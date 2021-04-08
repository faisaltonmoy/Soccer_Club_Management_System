package Tournaments;

import Home.window;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author faisa
 */
public class tournament extends javax.swing.JFrame {

    /**
     * Creates new form tournament
     */
    String m_area;

    public void visibility_true() {
        Opponent.setVisible(true);
        WinRatio.setVisible(true);
        MatchFee.setVisible(true);

        m_oppo_tf.setVisible(true);
        w_r_tf.setVisible(true);
        m_f_tf.setVisible(true);

    }

    public void visibility_false() {
       Opponent.setVisible(false);
        WinRatio.setVisible(false);
       MatchFee.setVisible(false);
        

        m_oppo_tf.setVisible(false);
        w_r_tf.setVisible(false);
        m_f_tf.setVisible(false);
       
    }

    public tournament() {
        initComponents();
        show_tournament();
        visibility_false();

        Toolkit tk = getToolkit();
        Dimension size = tk.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    public ArrayList<tournament_User> userList() {
        ArrayList<tournament_User> userslist = new ArrayList();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query1 = "SELECT * FROM Tournament";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);

            while (rs.next()) {
                tournament_User user = new tournament_User(rs.getString("Match_Date"), rs.getString("Match_Type"), rs.getString("Match_Area"), rs.getString("Stadium"), rs.getString("Result"));
                userslist.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return userslist;
    }
//For showing in the columns of jtable

    public void show_tournament() {
        ArrayList<tournament_User> list = userList();
        DefaultTableModel model = (DefaultTableModel) show_jTable.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getmDate();
            row[1] = list.get(i).getmType();
            row[2] = list.get(i).getmArea();
            row[3] = list.get(i).getSta();
            row[4] = list.get(i).getRes();
            model.addRow(row);
        }
    }

    public void leauge_info() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);

            int row = show_jTable.getSelectedRow();
            String value = (show_jTable.getModel().getValueAt(row, 0).toString());
            String m_type = match_type_combo.getSelectedItem().toString();

            if (m_type == "La Liga") {
                String sql = "select Match_Opponent,(select Cast(Cast((Win/(win+loss+draw))*100 as \n"
                        + "decimal(18,2)) as varchar(50)) + ' %' as Percentage)\n"
                        + "from Tournament \n"
                        + "inner join [La Liga] on [La Liga].Match_Date = Tournament.Match_Date where Tournament.Match_Date = " + "'" + value + "'";
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {

                    m_oppo_tf.setText(rs.getString(1));
                    w_r_tf.setText(rs.getString(2));

                }
            } else {
                String sql = "select Match_Opponent,(select Cast(Cast((Win/(win+loss+draw))*100 as \n"
                        + "decimal(18,2)) as varchar(50)) + ' %' as Percentage) \n"
                        + "from Tournament\n"
                        + "inner join [Champions league] on [Champions league].Match_Date = Tournament.Match_Date where Tournament.Match_Date = " + "'" + value + "'";
                PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {

                    m_oppo_tf.setText(rs.getString(1));
                    w_r_tf.setText(rs.getString(2));
                }
            }

            String fee = "select\n"
                    + "case\n"
                    + "	when result = 'win' then 50000*1.00\n"
                    + "	when result = 'draw' then 50000*.75\n"
                    + "	when result = 'loss' then 50000*.50\n"
                    + "end as cost\n"
                    + "from Tournament where Match_Date = " + "'" + value + "'";

            PreparedStatement pst_fee = con.prepareStatement(fee);
            ResultSet rs_fee = pst_fee.executeQuery();
            while (rs_fee.next()) {

                m_f_tf.setText(rs_fee.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        result_combo = new javax.swing.JComboBox<>();
        insert_btn = new javax.swing.JButton();
        clear_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        refresh_btn = new javax.swing.JButton();
        Opponent = new javax.swing.JLabel();
        m_oppo_tf = new javax.swing.JTextField();
        w_r_tf = new javax.swing.JTextField();
        WinRatio = new javax.swing.JLabel();
        m_f_tf = new javax.swing.JTextField();
        MatchFee = new javax.swing.JLabel();
        stadium_tf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        home_radio = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        away_radio = new javax.swing.JRadioButton();
        srch_p_range_22 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        match_type_combo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        show_jTable = new javax.swing.JTable();
        back_btn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        srch_by_combo = new javax.swing.JComboBox<>();
        srch_p_name = new javax.swing.JTextField();
        ok = new javax.swing.JButton();
        date1 = new com.toedter.calendar.JDateChooser();
        srch_p_range_11 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 505));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Result:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 40, -1));

        result_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Win", "Loss", "Draw", "Not Played" }));
        result_combo.setSelectedItem("Not Played");
        result_combo.setBorder(null);
        getContentPane().add(result_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 140, 30));

        insert_btn.setText("Insert");
        insert_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_btnActionPerformed(evt);
            }
        });
        getContentPane().add(insert_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, -1, -1));

        clear_btn.setText("Clear");
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });
        getContentPane().add(clear_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 60, -1));

        delete_btn.setText("Delete");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        getContentPane().add(delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, -1, -1));

        update_btn.setText("Update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });
        getContentPane().add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));

        refresh_btn.setText("Refresh");
        refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btnActionPerformed(evt);
            }
        });
        getContentPane().add(refresh_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        Opponent.setForeground(java.awt.Color.white);
        Opponent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Opponent.setText("Opponent");
        getContentPane().add(Opponent, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 100, -1));

        m_oppo_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        m_oppo_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_oppo_tfActionPerformed(evt);
            }
        });
        getContentPane().add(m_oppo_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 140, -1));

        w_r_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        w_r_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                w_r_tfActionPerformed(evt);
            }
        });
        getContentPane().add(w_r_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 110, -1));

        WinRatio.setForeground(java.awt.Color.white);
        WinRatio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        WinRatio.setText("Win Ratio");
        getContentPane().add(WinRatio, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 110, -1));

        m_f_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        m_f_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_f_tfActionPerformed(evt);
            }
        });
        getContentPane().add(m_f_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 380, 110, -1));

        MatchFee.setForeground(java.awt.Color.white);
        MatchFee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MatchFee.setText("Match Fee");
        getContentPane().add(MatchFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 350, 110, -1));
        getContentPane().add(stadium_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 140, 30));

        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Stadium:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, 30));

        home_radio.setForeground(java.awt.Color.white);
        home_radio.setText("Home");
        home_radio.setBorder(null);
        home_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_radioActionPerformed(evt);
            }
        });
        getContentPane().add(home_radio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Match Area:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        away_radio.setForeground(java.awt.Color.white);
        away_radio.setText("Away");
        away_radio.setBorder(null);
        away_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                away_radioActionPerformed(evt);
            }
        });
        getContentPane().add(away_radio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));

        srch_p_range_22.setMinimumSize(new java.awt.Dimension(140, 30));
        srch_p_range_22.setPreferredSize(new java.awt.Dimension(140, 30));
        getContentPane().add(srch_p_range_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 130, 30));

        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Match Date:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, 30));

        match_type_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "La Liga", "Champions League" }));
        match_type_combo.setBorder(null);
        match_type_combo.setPreferredSize(new java.awt.Dimension(113, 30));
        match_type_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                match_type_comboActionPerformed(evt);
            }
        });
        getContentPane().add(match_type_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 140, 30));

        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Match Type:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 194, -1, 20));

        show_jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Match Date", "Match Type", "Match Area", "Stadium", "Result"
            }
        ));
        show_jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                show_jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(show_jTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 650, 220));

        back_btn1.setText("Back");
        back_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(back_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 30)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tournament");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Search By");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, 40));

        srch_by_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Match Date", "Match Type", "Match Area", "Stadium", "Result" }));
        srch_by_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srch_by_comboActionPerformed(evt);
            }
        });
        getContentPane().add(srch_by_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 110, 25));

        srch_p_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srch_p_nameActionPerformed(evt);
            }
        });
        srch_p_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                srch_p_nameKeyReleased(evt);
            }
        });
        getContentPane().add(srch_p_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, 210, 25));

        ok.setText("Ok");
        ok.setAlignmentY(0.0F);
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, -1, 30));

        date1.setMinimumSize(new java.awt.Dimension(140, 30));
        date1.setPreferredSize(new java.awt.Dimension(140, 30));
        getContentPane().add(date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 140, 30));

        srch_p_range_11.setMinimumSize(new java.awt.Dimension(140, 30));
        srch_p_range_11.setPreferredSize(new java.awt.Dimension(140, 30));
        getContentPane().add(srch_p_range_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 140, 30));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/image/gg.png"))); // NOI18N
        jLabel10.setIconTextGap(0);
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 505));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btn1ActionPerformed
        // TODO add your handling code here:
        window field = new window();
        field.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_back_btn1ActionPerformed

    private void show_jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_show_jTableMouseClicked
        // TODO add your handling code here:
        int i = show_jTable.getSelectedRow();
        TableModel model = show_jTable.getModel();
        try {
            Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(((String) model.getValueAt(i, 0)));
            date1.setDate(dt);
        } catch (ParseException ex) {
            Logger.getLogger(tournament.class.getName()).log(Level.SEVERE, null, ex);
        }

        String league = model.getValueAt(i, 1).toString();
        switch (league) {
            case "La Liga":
                match_type_combo.setSelectedIndex(0);
                break;
            case "Champions League":
                match_type_combo.setSelectedIndex(1);
                break;
        }

        String area = model.getValueAt(i, 2).toString();
        if (area.equals("Home")) {
            home_radio.setSelected(true);
            away_radio.setSelected(false);
        }
        if (area.equals("Away")) {
            away_radio.setSelected(true);
            home_radio.setSelected(false);
        }

        stadium_tf.setText(model.getValueAt(i, 3).toString());

        String result = model.getValueAt(i, 4).toString();
        switch (result) {
            case "Win":
                result_combo.setSelectedIndex(0);
                break;
            case "Loss":
                result_combo.setSelectedIndex(1);
                break;
            case "Draw":
                result_combo.setSelectedIndex(2);
                break;
            case "Abandoned":
                result_combo.setSelectedIndex(3);
                break;
        }

        leauge_info();
        visibility_true();
    }//GEN-LAST:event_show_jTableMouseClicked

    private void match_type_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_match_type_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_match_type_comboActionPerformed

    private void home_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_radioActionPerformed
        // TODO add your handling code here:
        if (home_radio.isSelected()) {
            away_radio.setSelected(false);
        }
    }//GEN-LAST:event_home_radioActionPerformed

    private void away_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_away_radioActionPerformed
        // TODO add your handling code here:
        if (away_radio.isSelected()) {
            home_radio.setSelected(false);
        }
    }//GEN-LAST:event_away_radioActionPerformed

    private void m_oppo_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_oppo_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m_oppo_tfActionPerformed

    private void w_r_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_w_r_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_w_r_tfActionPerformed

    private void m_f_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_f_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m_f_tfActionPerformed

    private void insert_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_btnActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query = "insert into tournament(match_date, match_type, match_area, stadium, result)values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String m_date = sdf.format(date1.getDate());
            pst.setString(1, m_date);
            String m_type;
            m_type = match_type_combo.getSelectedItem().toString();
            pst.setString(2, m_type);
            if (home_radio.isSelected()) {
                m_area = "Home";
            }
            if (away_radio.isSelected()) {
                m_area = "Away";
            }
            pst.setString(3, m_area);
            pst.setString(4, stadium_tf.getText());
            String m_result;
            m_result = result_combo.getSelectedItem().toString();
            pst.setString(5, m_result);

            pst.executeUpdate();

            if (match_type_combo.getSelectedItem().equals("La Liga")) {
                la_liga ll = new la_liga();
                ll.setVisible(true);
                setVisible(false);
            } else if (match_type_combo.getSelectedItem().equals("Champions League")) {
                champions_league cl = new champions_league();
                cl.setVisible(true);
                setVisible(false);
            }
            DefaultTableModel model = (DefaultTableModel) show_jTable.getModel();
            model.setRowCount(0);
            show_tournament();

            JOptionPane.showMessageDialog(null, "Inserted Sucessfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_insert_btnActionPerformed

    
      public void clear() {

     srch_p_range_11.setCalendar(null);
        srch_p_range_22.setCalendar(null);
        date1.setCalendar(null);
        match_type_combo.setSelectedIndex(-1);
        home_radio.setSelected(false);
        away_radio.setSelected(false);
        stadium_tf.setText("");
        result_combo.setSelectedIndex(-1);
        visibility_false();
        
    }
    
    
    
    
    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clear_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to Delete?", "Delete", JOptionPane.YES_NO_CANCEL_OPTION);
        if (confirm == 0) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
                Connection con = DriverManager.getConnection(url);
                int row = show_jTable.getSelectedRow();
                String value = (show_jTable.getModel().getValueAt(row, 0).toString());

                if (match_type_combo.getSelectedItem().equals("La Liga")) {
                    String query = "Delete from [La Liga] where Match_Date IN (Select Match_Date from Tournament where Match_Date = '" + value + "')";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.executeUpdate();
                } else if (match_type_combo.getSelectedItem().equals("Champions League")) {
                    String query = "Delete from [Champions League] where Match_Date IN (Select Match_Date from Tournament where Match_Date = '" + value + "')";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.executeUpdate();
                }

                String query = "Delete from tournament where match_date= '" + value + "'";
                PreparedStatement pst = con.prepareStatement(query);
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel) show_jTable.getModel();
                model.setRowCount(0);
                show_tournament();

                JOptionPane.showMessageDialog(null, "Deleted Sucessfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) show_jTable.getModel();
        model.setRowCount(0);
        show_tournament();
    }//GEN-LAST:event_refresh_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            int row = show_jTable.getSelectedRow();
            String value = (show_jTable.getModel().getValueAt(row, 0).toString());
            String query = "Update Tournament SET [Match_Date] = ? ,[Match_Type] = ? ,[Match_Area] = ? ,[Stadium] = ? ,[Result] = ? where Match_Date = '" + value + "'";
            PreparedStatement pst = con.prepareStatement(query);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String m_date = sdf.format(date1.getDate());
            pst.setString(1, m_date);
            String m_type;
            m_type = match_type_combo.getSelectedItem().toString();
            pst.setString(2, m_type);
            if (home_radio.isSelected()) {
                m_area = "Home";
            }
            if (away_radio.isSelected()) {
                m_area = "Away";
            }
            pst.setString(3, m_area);
            pst.setString(4, stadium_tf.getText());
            String m_result;
            m_result = result_combo.getSelectedItem().toString();
            pst.setString(5, m_result);

            pst.executeUpdate();

            DefaultTableModel model = (DefaultTableModel) show_jTable.getModel();
            model.setRowCount(0);
            show_tournament();

            JOptionPane.showMessageDialog(null, "Updated Sucessfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_update_btnActionPerformed
    public String srch_by_com;

    public void srch_combo_logic() {
        try {
            if (srch_by_combo.getSelectedItem().equals("Match Date")) {
                srch_by_com = "Match_Date";
            } else if (srch_by_combo.getSelectedItem().equals("Match Type")) {
                srch_by_com = "Match_Type";
            } else if (srch_by_combo.getSelectedItem().equals("Match Area")) {
                srch_by_com = "Match_area";
            } else if (srch_by_combo.getSelectedItem().equals("Stadium")) {
                srch_by_com = "Stadium";
            } else if (srch_by_combo.getSelectedItem().equals("Result")) {
                srch_by_com = "Result";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void srch_by_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srch_by_comboActionPerformed
        // TODO add your handling code here:
        srch_combo_logic();
    }//GEN-LAST:event_srch_by_comboActionPerformed

    private void srch_p_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srch_p_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srch_p_nameActionPerformed

    private void srch_p_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srch_p_nameKeyReleased
        // TODO add your handling code here:
        srch_combo_logic();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);

            TableModel model = show_jTable.getModel();

            String value = srch_p_name.getText();
            String srch_by = srch_by_com.toString();
            String query = "Select * from Tournament "
                    + " where " + srch_by + " LIKE '%" + value + "%'";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            show_jTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_srch_p_nameKeyReleased

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);

            TableModel model = show_jTable.getModel();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String value1 = sdf.format(srch_p_range_11.getDate());
            String value2 = sdf.format(srch_p_range_22.getDate());
            String srch_by = srch_by_com.toString();
            String query = "Select * from Tournament "
                    + " where " + srch_by + " BETWEEN '" + value1 + "' AND '" + value2 + "' order by " + srch_by;
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            show_jTable.setModel(DbUtils.resultSetToTableModel(rs));

            srch_p_range_11.setCalendar(null);
            srch_p_range_22.setCalendar(null);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_okActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tournament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tournament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tournament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tournament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tournament().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MatchFee;
    private javax.swing.JLabel Opponent;
    private javax.swing.JLabel WinRatio;
    private javax.swing.JRadioButton away_radio;
    private javax.swing.JButton back_btn1;
    private javax.swing.JButton clear_btn;
    private com.toedter.calendar.JDateChooser date1;
    private javax.swing.JButton delete_btn;
    private javax.swing.JRadioButton home_radio;
    private javax.swing.JButton insert_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField m_f_tf;
    private javax.swing.JTextField m_oppo_tf;
    private javax.swing.JComboBox<String> match_type_combo;
    private javax.swing.JButton ok;
    private javax.swing.JButton refresh_btn;
    private javax.swing.JComboBox<String> result_combo;
    private javax.swing.JTable show_jTable;
    private javax.swing.JComboBox<String> srch_by_combo;
    private javax.swing.JTextField srch_p_name;
    private com.toedter.calendar.JDateChooser srch_p_range_11;
    private com.toedter.calendar.JDateChooser srch_p_range_22;
    private javax.swing.JTextField stadium_tf;
    private javax.swing.JButton update_btn;
    private javax.swing.JTextField w_r_tf;
    // End of variables declaration//GEN-END:variables
}
