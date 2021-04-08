/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Revenue;

import Home.window;
import Staffs.coach_user;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Atanu saha
 */
public class Revenue extends javax.swing.JFrame {

    /**
     * Creates new form Revenue
     */
    public Revenue() {
        initComponents();
        show_Player_user_revenue();
        show_Coachr_user_revenue();
        show_Staff_user_revenue();
        show_Media_user_revenue();
        show_Ground_user_revenue();
        ground_revenue();
        Media_revenue();
        Staff_revenue();
        Coach_revenue();
        Player_revenue();
        
        finantial_condition();

        Toolkit tk = getToolkit();
        Dimension size = tk.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);

    }

    public ArrayList<Player_user_revenue> userList() {
        ArrayList<Player_user_revenue> userslist = new ArrayList();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query1 = "select P_PAY_ID, P_SALARY,P_BONUS FROM [PLAYER SALARY]";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);

            while (rs.next()) {
                Player_user_revenue user = new Player_user_revenue(rs.getInt("P_PAY_ID"),rs.getInt("P_salary"), rs.getInt("P_bonus"));
                userslist.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return userslist;
    }

    public void show_Player_user_revenue() {
        ArrayList<Player_user_revenue> list = userList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getP_PAY_ID();
            row[1] = list.get(i).getCOST();
            row[2] = list.get(i).getBONUS();

            model.addRow(row);
        }
    }
    
       public void Player_revenue() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);

            String query_sl = "select  sum(P_SALARY+P_BONUS) FROM \"PLAYER SALARY\"";
            PreparedStatement pst = con.prepareStatement(query_sl);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

             PC_TF.setText(rs.getString(1));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


    public ArrayList<Coach_user_revenue> userList1() {
        ArrayList<Coach_user_revenue> userslist1 = new ArrayList();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query1 = "select C_PAY_ID, C_SALARY,C_BONUS FROM [COACH SALARY]";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);

            while (rs.next()) {
                Coach_user_revenue user = new Coach_user_revenue(rs.getInt("C_PAY_ID"), rs.getInt("C_salary"), rs.getInt("C_bonus"));
                userslist1.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return userslist1;
    }

    public void show_Coachr_user_revenue() {
        ArrayList<Coach_user_revenue> list = userList1();
        DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getC_PAY_Id();
            row[1] = list.get(i).getCOST();
            row[2] = list.get(i).getBONUS();

            model.addRow(row);
        }
    }
    
        public void Coach_revenue() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);

            String query_sl = "select  sum(C_SALARY+C_BONUS) FROM \"COACH SALARY\"";
            PreparedStatement pst = con.prepareStatement(query_sl);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

              CC_TF.setText(rs.getString(1));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Staf_user_revenue> userList2() {
        ArrayList<Staf_user_revenue> userslist2 = new ArrayList();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query1 = "select S_PAY_ID, S_salary,S_bonus FROM \"STAFF SALARY\"";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);

            while (rs.next()) {
                Staf_user_revenue user = new Staf_user_revenue(rs.getInt("S_PAY_ID"), rs.getInt("S_salary"), rs.getInt("S_bonus"));
                userslist2.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return userslist2;
    }

    public void show_Staff_user_revenue() {
        ArrayList<Staf_user_revenue> list = userList2();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getS_PAY_ID();
            row[1] = list.get(i).getCOST();
            row[2] = list.get(i).getBONUS();

            model.addRow(row);
        }
    }
    
      public void Staff_revenue() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);

            String query_sl = "select sum( S_SALARY+S_BONUS) FROM \"STAFF SALARY\"";
            PreparedStatement pst = con.prepareStatement(query_sl);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

               SC_TF.setText(rs.getString(1));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Media_user_revenue> userList3() {
        ArrayList<Media_user_revenue> userslist3 = new ArrayList();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query1 = "select Media_Id,Revenue,Media_Type FROM Media";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);

            while (rs.next()) {
                Media_user_revenue user;
                user = new Media_user_revenue(rs.getInt("Media_Id"), rs.getInt("Revenue"), rs.getString("Media_Type"));
                userslist3.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return userslist3;
    }

    public void show_Media_user_revenue() {
        ArrayList<Media_user_revenue> list = userList3();
        DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMedia_Id();
            row[1] = list.get(i).getREVENUE();
            row[2] = list.get(i).getMedia_type();

            model.addRow(row);
        }
    }

    public void Media_revenue() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);

            String query_sl = "select  sum(Revenue)FROM Media";
            PreparedStatement pst = con.prepareStatement(query_sl);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                MR_TF.setText(rs.getString(1));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ArrayList<Ground_user_revenue> userList4() {
        ArrayList<Ground_user_revenue> userslist4 = new ArrayList();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query1 = "select G_No, G_Type,G_Capacity FROM \"Ground & Gym\"";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);

            while (rs.next()) {
                Ground_user_revenue user;
                user = new Ground_user_revenue(rs.getInt("G_No"), rs.getString("G_Type"), rs.getInt("G_Capacity"));
                userslist4.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return userslist4;
    }

    public void show_Ground_user_revenue() {
        ArrayList<Ground_user_revenue> list = userList4();
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getG_No();
            row[1] = list.get(i).getGround_type();
            row[2] = list.get(i).getCapacity();

            model.addRow(row);
        }
    }

    public void ground_revenue() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);

            String query_sl = "select G_Capacity*.80*150*19 FROM \"Ground & Gym\" Where g_type = 'Home'";
             PreparedStatement pst = con.prepareStatement(query_sl);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                GR_TF.setText(rs.getString(1));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void finantial_condition(){
        double fin_con = 0 ;
        
        String pc = PC_TF.getText();
        double plr_cost = Double.parseDouble(pc);
        
        fin_con-=plr_cost;
        String cc = CC_TF.getText();
        double coach_cost = Double.parseDouble(cc);
        
        fin_con -= coach_cost;
        String sc = SC_TF.getText();
        double staff_cost = Double.parseDouble(sc);
        
        fin_con-=staff_cost;
        
        String m_rev = MR_TF.getText();
        double media_rev = Double.parseDouble(m_rev);
        
        fin_con+=media_rev;
        
        String g_rev = GR_TF.getText();
        double gg_rev = Double.parseDouble(g_rev);
        
        fin_con+=gg_rev;
        
        String fc = Double.toString(fin_con);
        FC_TF.setText(fc);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        PC_TF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CC_TF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        SC_TF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        MR_TF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        GR_TF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        FC_TF = new javax.swing.JTextField();
        back_btn1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 620));
        setMinimumSize(new java.awt.Dimension(1000, 620));
        setPreferredSize(new java.awt.Dimension(1000, 610));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Salary", "Bonus"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 101));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Player Cost");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, 20));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Salary", "Bonus"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, 101));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Coach Cost");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, 16));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Salary", "Bonus"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 444, 101));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Staff Cost");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, -1, 16));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Ground Type", "Capacity"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 450, 60));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ground Income");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, -1, 16));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Media Type", "Revenue"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 440, 101));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Media Income");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, -1, 16));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Player cost :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 100, -1));

        PC_TF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PC_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PC_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PC_TFActionPerformed(evt);
            }
        });
        getContentPane().add(PC_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 200, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Coach Cost:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 100, 30));

        CC_TF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CC_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CC_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CC_TFActionPerformed(evt);
            }
        });
        getContentPane().add(CC_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, 210, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Staff Cost :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

        SC_TF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SC_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SC_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SC_TFActionPerformed(evt);
            }
        });
        getContentPane().add(SC_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 190, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Media Revenue :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, -1, -1));

        MR_TF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MR_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(MR_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 350, 160, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ground Revenue :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, -1, 30));

        GR_TF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GR_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        GR_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GR_TFActionPerformed(evt);
            }
        });
        getContentPane().add(GR_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 170, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gross Profit/Loss: ");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 450, -1, 30));

        FC_TF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        FC_TF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        FC_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FC_TFActionPerformed(evt);
            }
        });
        getContentPane().add(FC_TF, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 450, 230, 30));

        back_btn1.setText("Back");
        back_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(back_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/image/money.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1000, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PC_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PC_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PC_TFActionPerformed

    private void CC_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CC_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CC_TFActionPerformed

    private void GR_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GR_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GR_TFActionPerformed

    private void FC_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FC_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FC_TFActionPerformed

    private void back_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btn1ActionPerformed
        // TODO add your handling code here:
        window field = new window();
        field.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_back_btn1ActionPerformed

    private void SC_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SC_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SC_TFActionPerformed

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
            java.util.logging.Logger.getLogger(Revenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Revenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Revenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Revenue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Revenue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CC_TF;
    private javax.swing.JTextField FC_TF;
    private javax.swing.JTextField GR_TF;
    private javax.swing.JTextField MR_TF;
    private javax.swing.JTextField PC_TF;
    private javax.swing.JTextField SC_TF;
    private javax.swing.JButton back_btn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    // End of variables declaration//GEN-END:variables
}
