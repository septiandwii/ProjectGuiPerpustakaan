/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectperpustakaan;

import crudAnggota.CreatDbAnggota;
import crudAnggota.DeleteDbAnggota;
import crudAnggota.TampilDataAnggota;
import crudAnggota.UpdateDbAnggota;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class DataAnggota extends javax.swing.JFrame {

    /**
     * Creates new form DataAnggota
     */
    
    TampilDataAnggota tampilData = new TampilDataAnggota();
    int selectedRow = -1;
    
    public DataAnggota() {
        initComponents();
//        DefaultTableModel tabelData = (DefaultTableModel) tabelDataAnggota.getModel();
        String[] columns = {
          "Nama",
          "NIM",
          "Program Studi",
          "Nomor Telepon",
          "Jenis Kelamin"
        };
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tabelDataAnggota.setModel(model);
        ResultSet rs = tampilData.tampilkanDataSemuaAnggota();
        
        try{
            int i = 0;
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("nama"), rs.getString("nim"),rs.getString("program_studi"), rs.getString("nomor_telp"), rs.getString("jenis_kelamin")});
                i++;
            }
            
        }catch(SQLException e){
            System.out.println("Pesan Error : " + e.getMessage());
        }
        
        this.tabelDataAnggota.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                int row = tabelDataAnggota.getSelectedRow();
                selectedRow = row;
                inpNama.setText(tabelDataAnggota.getValueAt(row, 0).toString());
                inpNim.setText(tabelDataAnggota.getValueAt(row, 1).toString());
                inpProgramStudi.setText(tabelDataAnggota.getValueAt(row, 2).toString());
                inpNo.setText(tabelDataAnggota.getValueAt(row, 3).toString());
                pilihanJenisKelamin.setSelectedItem(tabelDataAnggota.getValueAt(row, 4).toString());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        } );
        
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonSimpanAnggota = new javax.swing.JButton();
        inpNo = new javax.swing.JTextField();
        buttonEditAnggota = new javax.swing.JButton();
        buttonDeleteAnggota = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        buttonKeluarAnggota = new javax.swing.JButton();
        inpNim = new javax.swing.JTextField();
        inpCari = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buttonCariAnggota = new javax.swing.JButton();
        inpNama = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inpProgramStudi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDataAnggota = new javax.swing.JTable();
        pilihanJenisKelamin = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(90, 99, 106));

        jPanel1.setBackground(new java.awt.Color(124, 133, 148));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(19, 46, 53), 12, true));

        buttonSimpanAnggota.setBackground(new java.awt.Color(74, 88, 89));
        buttonSimpanAnggota.setFont(new java.awt.Font("Schadow BT", 0, 12)); // NOI18N
        buttonSimpanAnggota.setForeground(new java.awt.Color(239, 239, 239));
        buttonSimpanAnggota.setText("Simpan");
        buttonSimpanAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanAnggotaActionPerformed(evt);
            }
        });

        inpNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpNoActionPerformed(evt);
            }
        });

        buttonEditAnggota.setBackground(new java.awt.Color(74, 88, 89));
        buttonEditAnggota.setFont(new java.awt.Font("Schadow BT", 0, 12)); // NOI18N
        buttonEditAnggota.setForeground(new java.awt.Color(237, 236, 236));
        buttonEditAnggota.setText("Edit");
        buttonEditAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditAnggotaActionPerformed(evt);
            }
        });

        buttonDeleteAnggota.setBackground(new java.awt.Color(74, 88, 89));
        buttonDeleteAnggota.setFont(new java.awt.Font("Schadow BT", 0, 12)); // NOI18N
        buttonDeleteAnggota.setForeground(new java.awt.Color(237, 237, 237));
        buttonDeleteAnggota.setText("Hapus");
        buttonDeleteAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteAnggotaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Schadow BT", 1, 14)); // NOI18N
        jLabel1.setText("NIM : ");

        buttonKeluarAnggota.setBackground(new java.awt.Color(93, 107, 107));
        buttonKeluarAnggota.setFont(new java.awt.Font("Schadow BT", 0, 12)); // NOI18N
        buttonKeluarAnggota.setForeground(new java.awt.Color(237, 237, 237));
        buttonKeluarAnggota.setText("Keluar");
        buttonKeluarAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKeluarAnggotaActionPerformed(evt);
            }
        });

        inpNim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpNimActionPerformed(evt);
            }
        });

        inpCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpCariActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Schadow BT", 1, 14)); // NOI18N
        jLabel2.setText("NAMA :");

        buttonCariAnggota.setBackground(new java.awt.Color(105, 129, 141));
        buttonCariAnggota.setFont(new java.awt.Font("Schadow BT", 0, 12)); // NOI18N
        buttonCariAnggota.setForeground(new java.awt.Color(255, 255, 255));
        buttonCariAnggota.setText("Cari");
        buttonCariAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariAnggotaActionPerformed(evt);
            }
        });

        inpNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpNamaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Mongolian Baiti", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(25, 29, 35));
        jLabel6.setText("DATA ANGGOTA");

        jLabel3.setFont(new java.awt.Font("Schadow BT", 1, 14)); // NOI18N
        jLabel3.setText("Program Studi :");

        inpProgramStudi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpProgramStudiActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Schadow BT", 1, 14)); // NOI18N
        jLabel4.setText("Jenis Kelamin :");

        tabelDataAnggota.setFont(new java.awt.Font("Schadow BT", 0, 12)); // NOI18N
        tabelDataAnggota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama", "Nim", "Program Studi", "No_Telepon", "Jenis Kelamin"
            }
        ));
        tabelDataAnggota.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(tabelDataAnggota);

        pilihanJenisKelamin.setBackground(new java.awt.Color(74, 88, 89));
        pilihanJenisKelamin.setFont(new java.awt.Font("Schadow BT", 0, 12)); // NOI18N
        pilihanJenisKelamin.setForeground(new java.awt.Color(255, 255, 255));
        pilihanJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));

        jLabel5.setFont(new java.awt.Font("Schadow BT", 1, 14)); // NOI18N
        jLabel5.setText("No Telepon :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(245, 245, 245))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(678, 688, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inpNama)
                            .addComponent(inpNim)
                            .addComponent(inpProgramStudi)
                            .addComponent(inpNo)
                            .addComponent(pilihanJenisKelamin, javax.swing.GroupLayout.Alignment.TRAILING, 0, 146, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(buttonSimpanAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonEditAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonDeleteAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonKeluarAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(inpCari, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonCariAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel6)
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inpNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inpCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCariAnggota))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inpNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inpProgramStudi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inpNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pilihanJenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSimpanAnggota)
                    .addComponent(buttonEditAnggota)
                    .addComponent(buttonDeleteAnggota)
                    .addComponent(buttonKeluarAnggota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inpNimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpNimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpNimActionPerformed

    private void inpNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpNamaActionPerformed

    private void inpProgramStudiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpProgramStudiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpProgramStudiActionPerformed

    private void inpNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpNoActionPerformed

    private void buttonSimpanAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanAnggotaActionPerformed
        CreatDbAnggota inputData = new CreatDbAnggota();
        DefaultTableModel tabelData2 = (DefaultTableModel) tabelDataAnggota.getModel();  
        try{ 
            inputData.inputData(inpNama.getText(), inpNim.getText(), inpProgramStudi.getText(),inpNo.getText(), pilihanJenisKelamin.getSelectedItem().toString(), rootPane);
            ResultSet rs = tampilData.tampilkanData(this.inpNim.getText());
            if(rs.next()){
                tabelData2.addRow(new Object[]{rs.getString("nama"), rs.getString("nim"),rs.getString("program_studi"), rs.getString("nomor_telp"), rs.getString("jenis_kelamin")});
            }
        }catch(SQLException e){
            System.out.println("Pesan Error : " + e.getMessage());
        }
        
    }//GEN-LAST:event_buttonSimpanAnggotaActionPerformed

    private void buttonEditAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditAnggotaActionPerformed
        UpdateDbAnggota updateData = new UpdateDbAnggota();
        updateData.updateData(inpNama.getText(), inpNim.getText(), inpProgramStudi.getText(),inpNo.getText(), pilihanJenisKelamin.getSelectedItem().toString(), rootPane);
        DefaultTableModel tabel = (DefaultTableModel) tabelDataAnggota.getModel();
        tabel.addRow(new Object[]{inpNama.getText(), inpNim.getText(), inpProgramStudi.getText(),inpNo.getText(), pilihanJenisKelamin.getSelectedItem().toString()});
        tabel.removeRow(selectedRow);
    }//GEN-LAST:event_buttonEditAnggotaActionPerformed

    private void buttonDeleteAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteAnggotaActionPerformed
        DeleteDbAnggota deleteData = new DeleteDbAnggota();
        deleteData.deleteData(inpNim.getText(), rootPane);
        DefaultTableModel tabel = (DefaultTableModel) tabelDataAnggota.getModel();
        tabel.removeRow(selectedRow);
        inpNama.setText("");
        inpNim.setText("");
        inpProgramStudi.setText("");
        inpNo.setText("");
        pilihanJenisKelamin.setSelectedItem("Laki-laki");
        
    }//GEN-LAST:event_buttonDeleteAnggotaActionPerformed

    private void buttonKeluarAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKeluarAnggotaActionPerformed
        dispose();
        Home home = new Home();
        home.setVisible(true);
    }//GEN-LAST:event_buttonKeluarAnggotaActionPerformed

    private void buttonCariAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariAnggotaActionPerformed
        // todo : cari berdasarkan NIM
        ResultSet rs;
        if(!"".equals(inpCari.getText())) {
            rs = tampilData.tampilkanData(inpCari.getText());
        } else {
            rs = tampilData.tampilkanDataSemuaAnggota();
        }
        
        DefaultTableModel tabel = (DefaultTableModel) tabelDataAnggota.getModel();
        
        try{
            for(var i = tabel.getRowCount() - 1; i >= 0; i--) {
                tabel.removeRow(i);
            }
            while(rs.next()){
                tabel.addRow(new Object[]{rs.getString("nama"), rs.getString("nim"),rs.getString("program_studi"), rs.getString("nomor_telp"), rs.getString("jenis_kelamin")});
            }
            
        }catch(SQLException e){
            System.out.println("Pesan Error : " + e.getMessage());
        }
    }//GEN-LAST:event_buttonCariAnggotaActionPerformed

    private void inpCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpCariActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCariAnggota;
    private javax.swing.JButton buttonDeleteAnggota;
    private javax.swing.JButton buttonEditAnggota;
    private javax.swing.JButton buttonKeluarAnggota;
    private javax.swing.JButton buttonSimpanAnggota;
    private javax.swing.JTextField inpCari;
    private javax.swing.JTextField inpNama;
    private javax.swing.JTextField inpNim;
    private javax.swing.JTextField inpNo;
    private javax.swing.JTextField inpProgramStudi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> pilihanJenisKelamin;
    private javax.swing.JTable tabelDataAnggota;
    // End of variables declaration//GEN-END:variables
}
