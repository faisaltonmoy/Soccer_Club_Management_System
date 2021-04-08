package Tournaments;

import Home.window;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import oracle.jrockit.jfr.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author faisa
 */
public class la_liga extends javax.swing.JFrame {

    public void visibility_true() {
        MatchPlayed.setVisible(true);
        Win.setVisible(true);
        Loss.setVisible(true);
        Draw.setVisible(true);

        mp_tf.setVisible(true);
        mw_tf.setVisible(true);
        ml_tf.setVisible(true);
        md_tf.setVisible(true);

    }

    public void visibility_false() {

        MatchPlayed.setVisible(false);
        Win.setVisible(false);
        Loss.setVisible(false);
        Draw.setVisible(false);

        mp_tf.setVisible(false);
        mw_tf.setVisible(false);
        ml_tf.setVisible(false);
        md_tf.setVisible(false);

    }

    public la_liga() {
        initComponents();
        show_laliga();
        show_mp();
        show_mw();
        show_md();
        show_ml();
        visibility_false();

        Toolkit tk = getToolkit();
        Dimension size = tk.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    public ArrayList<laliga_User> userList() {
        ArrayList<laliga_User> userslist = new ArrayList();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query1 = "SELECT * FROM [La Liga]";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);

            while (rs.next()) {
                laliga_User l_user = new laliga_User(rs.getInt("match_day"), rs.getString("match_date"), rs.getString("match_opponent"), rs.getInt("win"), rs.getInt("loss"), rs.getInt("draw"));
                userslist.add(l_user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return userslist;
    }

    public void show_laliga() {
        ArrayList<laliga_User> list = userList();
        DefaultTableModel model = (DefaultTableModel) l_show_jTable.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getmDay();
            row[1] = list.get(i).getmDate();
            row[2] = list.get(i).getOppo();
            row[3] = list.get(i).getWin();
            row[4] = list.get(i).getLoss();
            row[5] = list.get(i).getDraw();

            model.addRow(row);
        }
    }
    String v1 = "", v2 = "";

    public void show_mp() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);

            String query_mp = "select count(Result) as mp from [La Liga]\n"
                    + "inner join Tournament on Tournament.Match_Date=[La Liga].Match_Date \n"
                    + "where Tournament.Match_date between '" + v1 + "' and '" + v2 + "'";

            PreparedStatement pst = con.prepareStatement(query_mp);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                mp_tf.setText(rs.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void show_mw() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);

            String query_mp = "select count(Result) from [La Liga]\n"
                    + "inner join Tournament on Tournament.Match_Date=[La Liga].Match_Date \n"
                    + "where Result='win'\n"
                    + "and Tournament.Match_date between '" + v1 + "' and '" + v2 + "'";

            PreparedStatement pst = con.prepareStatement(query_mp);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                mw_tf.setText(rs.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void show_md() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);

            String query_mp = "select count(Result) from [La Liga]\n"
                    + "inner join Tournament on Tournament.Match_Date=[La Liga].Match_Date \n"
                    + "where Result='draw'\n"
                    + "and Tournament.Match_date between '" + v1 + "' and '" + v2 + "'";

            PreparedStatement pst = con.prepareStatement(query_mp);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                md_tf.setText(rs.getString(1));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void show_ml() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);

            String query_mp = "select count(Result) from [La Liga]\n"
                    + "inner join Tournament on Tournament.Match_Date=[La Liga].Match_Date \n"
                    + "where Result='loss'\n"
                    + "and Tournament.Match_date between '" + v1 + "' and '" + v2 + "'";

            PreparedStatement pst = con.prepareStatement(query_mp);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                ml_tf.setText(rs.getString(1));

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

        jLabel1 = new javax.swing.JLabel();
        back_btn1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        l_date = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        l_opponent_tf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        l_loss_tf = new javax.swing.JTextField();
        l_win_tf = new javax.swing.JTextField();
        clear_btn = new javax.swing.JButton();
        insert_btn = new javax.swing.JButton();
        refresh_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        l_show_jTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        l_draw_tf = new javax.swing.JTextField();
        season = new javax.swing.JComboBox<>();
        mp_tf = new javax.swing.JTextField();
        ml_tf = new javax.swing.JTextField();
        mw_tf = new javax.swing.JTextField();
        md_tf = new javax.swing.JTextField();
        Draw = new javax.swing.JLabel();
        Loss = new javax.swing.JLabel();
        MatchPlayed = new javax.swing.JLabel();
        Win = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        srch_by_combo = new javax.swing.JComboBox<>();
        srch_p_name = new javax.swing.JTextField();
        srch_p_range_11 = new com.toedter.calendar.JDateChooser();
        srch_p_range_22 = new com.toedter.calendar.JDateChooser();
        ok = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 505));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("La Liga");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        back_btn1.setText("Back");
        back_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(back_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Match Date:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, 20));
        getContentPane().add(l_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 160, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Opponent:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));
        getContentPane().add(l_opponent_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 160, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Win:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Loss:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        l_loss_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_loss_tfActionPerformed(evt);
            }
        });
        getContentPane().add(l_loss_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 50, -1));

        l_win_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_win_tfActionPerformed(evt);
            }
        });
        getContentPane().add(l_win_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 50, -1));

        clear_btn.setText("Clear");
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });
        getContentPane().add(clear_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, -1, -1));

        insert_btn.setText("Insert");
        insert_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_btnActionPerformed(evt);
            }
        });
        getContentPane().add(insert_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, -1, -1));

        refresh_btn.setText("Refresh");
        refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btnActionPerformed(evt);
            }
        });
        getContentPane().add(refresh_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        update_btn.setText("Update");
        getContentPane().add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));

        delete_btn.setText("Delete");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        getContentPane().add(delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, -1));

        l_show_jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Match Day", "Match Date", "Opponent", "Win", "Loss", "Draw"
            }
        ));
        l_show_jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_show_jTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_show_jTableMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(l_show_jTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 107, 620, 170));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Draw:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, 20));

        l_draw_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                l_draw_tfActionPerformed(evt);
            }
        });
        getContentPane().add(l_draw_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 50, -1));

        season.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Season 19-20", "Season 20-21" }));
        season.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seasonActionPerformed(evt);
            }
        });
        getContentPane().add(season, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, -1, -1));

        mp_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mp_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mp_tfActionPerformed(evt);
            }
        });
        getContentPane().add(mp_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 110, -1));

        ml_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(ml_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 370, 110, -1));

        mw_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(mw_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 370, 110, -1));

        md_tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        md_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                md_tfActionPerformed(evt);
            }
        });
        getContentPane().add(md_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 370, 110, -1));

        Draw.setForeground(new java.awt.Color(255, 255, 255));
        Draw.setText("Draw");
        getContentPane().add(Draw, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 340, -1, -1));

        Loss.setForeground(new java.awt.Color(255, 255, 255));
        Loss.setText("Loss");
        getContentPane().add(Loss, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, -1, -1));

        MatchPlayed.setForeground(new java.awt.Color(255, 255, 255));
        MatchPlayed.setText("Match Played");
        getContentPane().add(MatchPlayed, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, -1));

        Win.setForeground(new java.awt.Color(255, 255, 255));
        Win.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Win.setText("Win");
        getContentPane().add(Win, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 110, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Search By");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, 40));

        srch_by_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Match Date", "Match Opponent" }));
        srch_by_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srch_by_comboActionPerformed(evt);
            }
        });
        getContentPane().add(srch_by_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 150, 25));

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
        getContentPane().add(srch_p_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 210, 25));

        srch_p_range_11.setMinimumSize(new java.awt.Dimension(140, 30));
        srch_p_range_11.setPreferredSize(new java.awt.Dimension(140, 30));
        getContentPane().add(srch_p_range_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 140, 30));

        srch_p_range_22.setMinimumSize(new java.awt.Dimension(140, 30));
        srch_p_range_22.setPreferredSize(new java.awt.Dimension(140, 30));
        getContentPane().add(srch_p_range_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 130, 30));

        ok.setText("Ok");
        ok.setAlignmentY(0.0F);
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, -1, 30));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Staffs/gg.png"))); // NOI18N
        jLabel11.setIconTextGap(0);
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 505));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btn1ActionPerformed
        // TODO add your handling code here:
        window field = new window();
        field.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_back_btn1ActionPerformed

    private void l_draw_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_draw_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_l_draw_tfActionPerformed

    private void l_win_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_win_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_l_win_tfActionPerformed

    public void clear() {

        srch_p_range_11.setCalendar(null);
        srch_p_range_22.setCalendar(null);
        l_date.setCalendar(null);
        l_opponent_tf.setText("");
        l_win_tf.setText("");
        l_loss_tf.setText("");
        l_draw_tf.setText("");
        visibility_false();

    }


    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clear_btnActionPerformed

    private void insert_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_btnActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query = "insert into [La Liga] (match_date, match_opponent, win, loss, draw)values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String m_date = sdf.format(l_date.getDate());
            pst.setString(1, m_date);
            pst.setString(2, l_opponent_tf.getText());
            pst.setString(3, l_win_tf.getText());
            pst.setString(4, l_loss_tf.getText());
            pst.setString(5, l_draw_tf.getText());

            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) l_show_jTable.getModel();
            model.setRowCount(0);
            show_laliga();

            JOptionPane.showMessageDialog(null, "Inserted Sucessfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_insert_btnActionPerformed

    private void refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) l_show_jTable.getModel();
        model.setRowCount(0);
        show_laliga();
    }//GEN-LAST:event_refresh_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to Delete?", "Delete", JOptionPane.YES_NO_CANCEL_OPTION);
        if (confirm == 0) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
                Connection con = DriverManager.getConnection(url);
                int row = l_show_jTable.getSelectedRow();
                String value = (l_show_jTable.getModel().getValueAt(row, 0).toString());
                String query = "Delete from [La Liga] where match_day =" + value;
                PreparedStatement pst = con.prepareStatement(query);
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel) l_show_jTable.getModel();
                model.setRowCount(0);
                show_laliga();

                JOptionPane.showMessageDialog(null, "Deleted Sucessfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void l_show_jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_show_jTableMouseClicked
        // TODO add your handling code here:
        int i = l_show_jTable.getSelectedRow();
        TableModel model = l_show_jTable.getModel();
        try {
            Date dtt = new SimpleDateFormat("yyyy-MM-dd").parse(((String) model.getValueAt(i, 1)));
            l_date.setDate(dtt);
        } catch (java.text.ParseException ex) {
            Logger.getLogger(la_liga.class.getName()).log(Level.SEVERE, null, ex);
        }

        l_opponent_tf.setText(model.getValueAt(i, 2).toString());
        l_win_tf.setText(model.getValueAt(i, 3).toString());
        l_loss_tf.setText(model.getValueAt(i, 4).toString());
        l_draw_tf.setText(model.getValueAt(i, 5).toString());

    }//GEN-LAST:event_l_show_jTableMouseClicked

    private void mp_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mp_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mp_tfActionPerformed

    private void md_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_md_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_md_tfActionPerformed

    private void seasonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seasonActionPerformed
        // TODO add your handling code here:
        visibility_true();
        try {
            if (season.getSelectedItem().equals("Season 19-20")) {
                v1 = "2019-07-01";
                v2 = "2020-06-30";
            } else if (season.getSelectedItem().equals("Season 20-21")) {
                v1 = "2020-07-01";
                v2 = "2021-06-30";
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        show_mp();
        show_mw();
        show_md();
        show_ml();
    }//GEN-LAST:event_seasonActionPerformed

    private void l_loss_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_l_loss_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_l_loss_tfActionPerformed
    public String srch_by_com;

    public void srch_combo_logic() {
        try {
            if (srch_by_combo.getSelectedItem().equals("Match Date")) {
                srch_by_com = "Match_Date";
            } else if (srch_by_combo.getSelectedItem().equals("Match Opponent")) {
                srch_by_com = "Match_opponent";
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

            TableModel model = l_show_jTable.getModel();

            String value = srch_p_name.getText();
            String srch_by = srch_by_com.toString();
            String query = "Select * from [La Liga] "
                    + " where " + srch_by + " LIKE '%" + value + "%'";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            l_show_jTable.setModel(DbUtils.resultSetToTableModel(rs));

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

            TableModel model = l_show_jTable.getModel();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            String value1 = sdf.format(srch_p_range_11.getDate());
            String value2 = sdf.format(srch_p_range_22.getDate());
            String srch_by = srch_by_com.toString();
            String query = "Select * from [La Liga] "
                    + " where " + srch_by + " BETWEEN '" + value1 + "' AND '" + value2 + "' order by " + srch_by;
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            l_show_jTable.setModel(DbUtils.resultSetToTableModel(rs));

            srch_p_range_11.setCalendar(null);
            srch_p_range_22.setCalendar(null);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_okActionPerformed

    private void l_show_jTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_show_jTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_l_show_jTableMouseEntered

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
            java.util.logging.Logger.getLogger(la_liga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(la_liga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(la_liga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(la_liga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new la_liga().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Draw;
    private javax.swing.JLabel Loss;
    private javax.swing.JLabel MatchPlayed;
    private javax.swing.JLabel Win;
    private javax.swing.JButton back_btn1;
    private javax.swing.JButton clear_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton insert_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser l_date;
    private javax.swing.JTextField l_draw_tf;
    private javax.swing.JTextField l_loss_tf;
    private javax.swing.JTextField l_opponent_tf;
    private javax.swing.JTable l_show_jTable;
    private javax.swing.JTextField l_win_tf;
    private javax.swing.JTextField md_tf;
    private javax.swing.JTextField ml_tf;
    private javax.swing.JTextField mp_tf;
    private javax.swing.JTextField mw_tf;
    private javax.swing.JButton ok;
    private javax.swing.JButton refresh_btn;
    private javax.swing.JComboBox<String> season;
    private javax.swing.JComboBox<String> srch_by_combo;
    private javax.swing.JTextField srch_p_name;
    private com.toedter.calendar.JDateChooser srch_p_range_11;
    private com.toedter.calendar.JDateChooser srch_p_range_22;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
