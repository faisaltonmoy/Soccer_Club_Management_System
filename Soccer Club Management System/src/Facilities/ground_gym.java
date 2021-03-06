package Facilities;

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
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author faisa
 */
public class ground_gym extends javax.swing.JFrame {

    /**
     * Creates new form ground_gym
     */
    public ground_gym() {
        initComponents();
        show_GymGround();
        
        Toolkit tk = getToolkit();
        Dimension size = tk.getScreenSize();
        setLocation(size.width / 2 - getWidth() / 2, size.height / 2 - getHeight() / 2);
    }

    public ArrayList<G_User> userList() {
        ArrayList<G_User> userslist = new ArrayList();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query1 = "SELECT * FROM [Ground & Gym]";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);

            while (rs.next()) {
                G_User user;
                user = new G_User(rs.getInt("G_No"), rs.getString("G_Name"), rs.getString("G_Type"), rs.getInt("G_Capacity"), rs.getString("G_Description"));
                userslist.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return userslist;
    }

    public void show_GymGround() {
        ArrayList<G_User> list = userList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getg_no();
            row[1] = list.get(i).getgName();
            row[2] = list.get(i).getgTYPE();
            row[3] = list.get(i).getg_Capacity();
            row[4] = list.get(i).getgDescription();

            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        coach_jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        G_name_tf = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Type_combo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        capacity_tf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Description_tf = new javax.swing.JTextField();
        insert_btn = new javax.swing.JButton();
        clear_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        refresh_btn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        coach_jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Coach ID", "Coach Name", "Formation", "Type", "Age", "Sex", "Rating", "Medical Issue  "
            }
        ));
        coach_jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coach_jTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                coach_jTableMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(coach_jTable);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 505));
        setMinimumSize(new java.awt.Dimension(1000, 505));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ground & Gym");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        getContentPane().add(back_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText(" Name:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, 20));

        G_name_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G_name_tfActionPerformed(evt);
            }
        });
        getContentPane().add(G_name_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 161, -1));

        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setText("Type:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 46, 20));

        Type_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Home", "Traning", "Academic ", "Gym" }));
        Type_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Type_comboActionPerformed(evt);
            }
        });
        getContentPane().add(Type_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Capacity:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, 20));

        capacity_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capacity_tfActionPerformed(evt);
            }
        });
        getContentPane().add(capacity_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 88, -1));

        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Description :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 77, 22));

        Description_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Description_tfActionPerformed(evt);
            }
        });
        getContentPane().add(Description_tf, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 161, -1));

        insert_btn.setText("Insert");
        insert_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_btnActionPerformed(evt);
            }
        });
        getContentPane().add(insert_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, -1, -1));

        clear_btn.setText("Clear");
        clear_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btnActionPerformed(evt);
            }
        });
        getContentPane().add(clear_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, -1, -1));

        update_btn.setText("Update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });
        getContentPane().add(update_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, -1));

        delete_btn.setText("Delete");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        getContentPane().add(delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, -1, -1));

        refresh_btn.setText("Refresh");
        refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btnActionPerformed(evt);
            }
        });
        getContentPane().add(refresh_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ground/Gym No", "Name", "Type", "Capacity", "Description"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 660, 170));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Staffs/gg.png"))); // NOI18N
        jLabel3.setIconTextGap(0);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 505));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        // TODO add your handling code here:
        window field = new window();
        field.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_back_btnActionPerformed

    private void G_name_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G_name_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_G_name_tfActionPerformed

    private void Type_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Type_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Type_comboActionPerformed

    private void capacity_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capacity_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_capacity_tfActionPerformed

    private void Description_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Description_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Description_tfActionPerformed

    private void insert_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_btnActionPerformed
        // TODO add your handling code here:

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            String query = "insert into [Ground & Gym](G_Name, G_Type ,G_Capacity, G_Description)values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, G_name_tf.getText());
            String m_result;
            m_result = Type_combo.getSelectedItem().toString();
            pst.setString(2, m_result);

            pst.setString(3, capacity_tf.getText());
            pst.setString(4, Description_tf.getText());

            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            show_GymGround();

            JOptionPane.showMessageDialog(null, "Inserted Sucessfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_insert_btnActionPerformed

    public void clear() {

        G_name_tf.setText("");
        Type_combo.setSelectedIndex(-1);
        capacity_tf.setText("");
        Description_tf.setText("");

    }
    private void clear_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_btnActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_clear_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
            int row = jTable1.getSelectedRow();
            String value = (jTable1.getModel().getValueAt(row, 0).toString());
            String query = "Update [Ground & Gym] SET G_Name = ? ,G_Type = ? ,G_Capacity = ? ,G_Description = ? where G_No =" + value;
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, G_name_tf.getText());
            String m_result;
            m_result = Type_combo.getSelectedItem().toString();
            pst.setString(2, m_result);
            pst.setString(3, capacity_tf.getText());
            pst.setString(4, Description_tf.getText());

            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            show_GymGround();

            JOptionPane.showMessageDialog(null, "Updated Sucessfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_update_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to Delete?", "Delete", JOptionPane.YES_NO_CANCEL_OPTION);
        if (confirm == 0) {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url = "jdbc:sqlserver://localhost:1433;databaseName=Soccer_Club_Management_System;user=sa;password=123456";
                Connection con = DriverManager.getConnection(url);
                int row = jTable1.getSelectedRow();
                String value = (jTable1.getModel().getValueAt(row, 0).toString());

                String query = "Delete from [Ground & Gym] where G_No =" + value;
                PreparedStatement pst = con.prepareStatement(query);
                pst.executeUpdate();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                show_GymGround();

                JOptionPane.showMessageDialog(null, "Deleted Sucessfully!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        show_GymGround();

    }//GEN-LAST:event_refresh_btnActionPerformed

    private void coach_jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coach_jTableMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_coach_jTableMouseClicked

    private void coach_jTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_coach_jTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_coach_jTableMouseEntered

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
          int i = jTable1.getSelectedRow();
        //TableModel model = (TableModel)jTable1.getModel();
        TableModel model= (TableModel) jTable1.getModel();

        G_name_tf.setText(model.getValueAt(i, 1).toString());

        String type = model.getValueAt(i, 2).toString();
        switch (type) {
            case "Home":
                Type_combo.setSelectedIndex(0);
                break;
            case "Traning":
                Type_combo.setSelectedIndex(1);
                break;
            case "Academy":
                Type_combo.setSelectedIndex(2);
                break;
            case "Gym":
                Type_combo.setSelectedIndex(3);
                break;
        }

        capacity_tf.setText(model.getValueAt(i, 3).toString());

        Description_tf.setText(model.getValueAt(i, 4).toString());

        
        
        
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(ground_gym.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ground_gym.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ground_gym.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ground_gym.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ground_gym().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Description_tf;
    private javax.swing.JTextField G_name_tf;
    private javax.swing.JComboBox<String> Type_combo;
    private javax.swing.JButton back_btn;
    private javax.swing.JTextField capacity_tf;
    private javax.swing.JButton clear_btn;
    private javax.swing.JTable coach_jTable;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton insert_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton refresh_btn;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
