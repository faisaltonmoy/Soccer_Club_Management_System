/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medical;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Mahin Opu
 */
public class coach_medical extends javax.swing.JFrame {

    /**
     * Creates new form coach_medical
     */
    public coach_medical() {
        initComponents();
        Toolkit tk = getToolkit();
        Dimension size = tk.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        m_description_tf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        s_id_tf = new javax.swing.JTextField();
        s_name_tf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        leave_tf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        insert_btn = new javax.swing.JButton();
        clear_btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(320, 380));
        setMinimumSize(new java.awt.Dimension(320, 380));
        setPreferredSize(new java.awt.Dimension(320, 420));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(m_description_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 249, 180, 25));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Coach Medical Status");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 20, 240, -1));

        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Coach Id");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 50, -1));
        getContentPane().add(s_id_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 84, 100, 25));
        getContentPane().add(s_name_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 139, 180, 25));

        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Coach Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 70, -1));

        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Leave");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 40, -1));
        getContentPane().add(leave_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 194, 100, 25));

        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Description");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 254, 60, -1));

        insert_btn.setText("Insert");
        insert_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_btnActionPerformed(evt);
            }
        });
        getContentPane().add(insert_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 292, -1, -1));

        clear_btn.setText("Clear");
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });
        getContentPane().add(clear_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 292, -1, -1));

        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Home/image/eleven.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(320, 420));
        jLabel1.setMinimumSize(new java.awt.Dimension(320, 420));
        jLabel1.setPreferredSize(new java.awt.Dimension(320, 420));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insert_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_btnActionPerformed
        // TODO add your handling code here:

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query = "insert into [Coach Medical Status](C_ID,C_Name,Leave,M_Description)values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, s_id_tf.getText());
            pst.setString(2, s_name_tf.getText());
            pst.setString(3, leave_tf.getText());
            pst.setString(4, m_description_tf.getText());

            pst.executeUpdate();

            c_revenue();

            JOptionPane.showMessageDialog(null, "Inserted Sucessfully!");

            setVisible(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_insert_btnActionPerformed

    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        // TODO add your handling code here:
        s_id_tf.setText("");
        s_name_tf.setText("");
        leave_tf.setText("");
        m_description_tf.setText("");
    }//GEN-LAST:event_clear_btnActionPerformed
    public void c_revenue() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);

            String value = s_id_tf.getText().toString();
            String query_sl = "insert into [Coach Revenue] ([C_PAY_ID]) select [C_PAY_ID] from [Coach Salary] where C_ID = " + value;

            PreparedStatement pst = con.prepareStatement(query_sl);
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

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
            java.util.logging.Logger.getLogger(coach_medical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(coach_medical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(coach_medical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(coach_medical.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new coach_medical().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clear_btn;
    private javax.swing.JButton insert_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField leave_tf;
    private javax.swing.JTextField m_description_tf;
    private javax.swing.JTextField s_id_tf;
    private javax.swing.JTextField s_name_tf;
    // End of variables declaration//GEN-END:variables
}
