import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class dkasus extends javax.swing.JFrame {

    public dkasus() {
        initComponents();
        load_table();
        updateButtonText();
    }
    
     private void updateButtonText() {
    String idKasusValue = idkasus.getText();
    System.out.println("Current id_kasus: " + idKasusValue); // Debug print statement

    String selectSql = "SELECT status FROM kasus WHERE id_kasus = ?";
    
    try (Connection conn = koneksi.configDB();
         PreparedStatement selectPst = conn.prepareStatement(selectSql)) {
        
        selectPst.setString(1, idKasusValue);
        ResultSet rs = selectPst.executeQuery();
        
        if (rs.next()) {
            String currentStatus = rs.getString("status");
            
            switch (currentStatus) {
                case "Pending":
                    status.setText("Proses");
                    break;
                case "Proses":
                    status.setText("Selesai");
                    break;
                case "Selesai":
                    status.setText("Batal");
                    break;
                default:
                    status.setText("Unknown Status");
                    break;
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error fetching status: " + e.getMessage());
        e.printStackTrace();
    }
}

        private void kosong(){
        kronologi.setText(null);
    }
    
    private void load_table(){
    // membuat tampilan model tabel
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id User");
    model.addColumn("Kasus");
    model.addColumn("Status");
    model.addColumn("Id Kasus");
    
    
    try{

        String sql = "select id_user, kasus, status, id_kasus FROM kasus";
        java.sql.Connection conn=(Connection)koneksi.configDB();
        java.sql.Statement stm=conn.createStatement();
        java.sql.ResultSet res=stm.executeQuery(sql);
        while(res.next()){
            model.addRow(new Object[]{res.getString(1),res.getString(2),
            res.getString(3), res.getString(4)});
        }
        table.setModel(model);
    }catch (Exception e){
}
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        kronologi = new java.awt.TextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        idkasus = new javax.swing.JTextField();
        status = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Hapus");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        status.setText("No Status");
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        jMenu1.setText("Menu");

        jMenuItem1.setText("Tambah");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                    .addComponent(kronologi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(idkasus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 453, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(status)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(kronologi, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(status))
                .addGap(5, 5, 5)
                .addComponent(idkasus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         try {

    String sql = "UPDATE kasus SET kasus ='" + kronologi.getText()
        + "' WHERE id_kasus='" + idkasus.getText() + "'";
    
    java.sql.Connection conn = (Connection)koneksi.configDB();
    java.sql.PreparedStatement pst = conn.prepareStatement(sql);
    pst.execute();
    JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Perubahan Data Gagal: " + e.getMessage());
}

load_table();
kosong();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
       int row = table.rowAtPoint(evt.getPoint()); // Get the selected row index
    if (row >= 0) {
        String idb = table.getValueAt(row, 3).toString(); // Get the case ID from the selected row
        idkasus.setText(idb); // Set the ID to the idkasus field
        String namabarang = table.getValueAt(row, 1).toString(); // Get the case name from the selected row
        kronologi.setText(namabarang); // Set the name to the kronologi field
        updateButtonText(); // Update the button text based on the selected row's status
    }
    }//GEN-LAST:event_tableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            String sql = "delete from kasus WHERE id_kasus='"+idkasus.getText()+"'";
            java.sql.Connection conn=(Connection)koneksi.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "Data Berhasil di Hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table();
        kosong();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
        new kasus().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
          String selectSql = "SELECT status FROM kasus WHERE id_kasus = ?";
    String updateSql;

    try (Connection conn = koneksi.configDB();
         PreparedStatement selectPst = conn.prepareStatement(selectSql)) {

        selectPst.setString(1, idkasus.getText());
        ResultSet rs = selectPst.executeQuery();

        if (rs.next()) {
            String currentStatus = rs.getString("status");

            if ("Pending".equals(currentStatus)) {
                updateSql = "UPDATE kasus SET status = 'Proses' WHERE id_kasus = ?";
            } else if ("Proses".equals(currentStatus)) {
                updateSql = "UPDATE kasus SET status = 'Selesai' WHERE id_kasus = ?";
            } else if ("Selesai".equals(currentStatus)) {
                updateSql = "UPDATE kasus SET status = 'Pending' WHERE id_kasus = ?";
            } else {
                JOptionPane.showMessageDialog(null, "Status tidak dapat diubah dari: " + currentStatus);
                return;
            }

            try (PreparedStatement updatePst = conn.prepareStatement(updateSql)) {
                updatePst.setString(1, idkasus.getText());
                int rowsAffected = updatePst.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
                }
            } catch (SQLException updateEx) {
                JOptionPane.showMessageDialog(null, "Update Error: " + updateEx.getMessage());
                updateEx.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
        }

    } catch (SQLException selectEx) {
        JOptionPane.showMessageDialog(null, "Select Error: " + selectEx.getMessage());
        selectEx.printStackTrace();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Perubahan Data Gagal: " + e.getMessage());
        e.printStackTrace();
    }

    load_table();
    kosong();

    }//GEN-LAST:event_statusActionPerformed

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
            java.util.logging.Logger.getLogger(dkasus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dkasus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dkasus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dkasus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dkasus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idkasus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextArea kronologi;
    private javax.swing.JButton status;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
