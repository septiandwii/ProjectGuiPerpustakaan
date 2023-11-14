/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectperpustakaan;
import crudBuku.DeleteDbBuku;
import crudBuku.UpdateDbBuku;
import crudBuku.CreateDbBuku;
import crudBuku.CreateDbBuku;
import crudBuku.DeleteDbBuku;
import crudBuku.TampilDataBuku;
import crudBuku.UpdateDbBuku;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ACER
 */
public class DataBuku extends javax.swing.JFrame {

    /**
     * Creates new form DataBuku
     */
    TampilDataBuku tampilData = new TampilDataBuku();
    int selectedRow = -1;
    
    public DataBuku() {
        initComponents();
        String[] columns = {
          "kode_buku", 
          "judul_buku", 
          "nama_pengarang", 
          "penerbit", 
          "tahun_terbit", 
          "jenis_buku", 
          "status", 
          "jumlah_buku_tersedia"
        };
        
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        this.tabelDataBuku.setModel(model);
        ResultSet rs = tampilData.tampilkanDataSemuaBuku();
        
        try{
            int i = 0;
            while(rs.next()){
                model.addRow(new Object[]{rs.getString("kode_buku"), rs.getString("judul_buku"),rs.getString("nama_pengarang"), rs.getString("penerbit"), rs.getString("tahun_terbit"), rs.getString("jenis_buku"), rs.getString("status"), rs.getString("jumlah_buku_tersedia")});
                i++;
            }
        }catch(SQLException e){
            System.out.println("Pesan Error : " + e.getMessage());
        }
        
        this.tabelDataBuku.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                int row = tabelDataBuku.getSelectedRow();
                selectedRow = row;
                inpKodeBuku.setText(tabelDataBuku.getValueAt(row, 0).toString());
                inpJudulBuku.setText(tabelDataBuku.getValueAt(row, 1).toString());
                inpNamaPengarang.setText(tabelDataBuku.getValueAt(row, 2).toString());
                inpPenerbit.setText(tabelDataBuku.getValueAt(row, 3).toString());
                inpTahunTerbit.setText(tabelDataBuku.getValueAt(row, 4).toString());
                inpJenisBuku.setText(tabelDataBuku.getValueAt(row, 5).toString());
                inpStatus.setText(tabelDataBuku.getValueAt(row, 6).toString());
                inpJumlahBuku.setText(tabelDataBuku.getValueAt(row, 7).toString());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        inpKodeBuku = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inpJudulBuku = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inpNamaPengarang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inpPenerbit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        inpTahunTerbit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        inpJenisBuku = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        inpStatus = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        inpJumlahBuku = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDataBuku = new javax.swing.JTable();
        btnSimpanBuku = new javax.swing.JButton();
        buttonEditBuku = new javax.swing.JButton();
        buttonHapusBuku = new javax.swing.JButton();
        buttonCariBuku = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        buttonKeluarBuku = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setText("DATA BUKU");

        jLabel2.setText("Kode Buku : ");

        inpKodeBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpKodeBukuActionPerformed(evt);
            }
        });

        jLabel3.setText("Judul Buku : ");

        inpJudulBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpJudulBukuActionPerformed(evt);
            }
        });

        jLabel4.setText("Nama Pengarang :");

        inpNamaPengarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpNamaPengarangActionPerformed(evt);
            }
        });

        jLabel5.setText("Penerbit :");

        inpPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpPenerbitActionPerformed(evt);
            }
        });

        jLabel6.setText("Tahun Terbit : ");

        inpTahunTerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpTahunTerbitActionPerformed(evt);
            }
        });

        jLabel7.setText("Jenis Buku :");

        inpJenisBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpJenisBukuActionPerformed(evt);
            }
        });

        jLabel8.setText("Status :");

        inpStatus.setEditable(false);
        inpStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpStatusActionPerformed(evt);
            }
        });

        jLabel9.setText("Jumlah Buku :");

        inpJumlahBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpJumlahBukuActionPerformed(evt);
            }
        });

        tabelDataBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Buku", "Judul Buku", "Nama Pengarang", "Penerbit", "Tahun Terbit", "Jenis Buku", "Status", "Jumlah Buku"
            }
        ));
        tabelDataBuku.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tabelDataBukuAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(tabelDataBuku);

        btnSimpanBuku.setText("Simpan");
        btnSimpanBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanBukuActionPerformed(evt);
            }
        });

        buttonEditBuku.setText("Edit");
        buttonEditBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditBukuActionPerformed(evt);
            }
        });

        buttonHapusBuku.setText("Hapus");
        buttonHapusBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusBukuActionPerformed(evt);
            }
        });

        buttonCariBuku.setText("Cari");
        buttonCariBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariBukuActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        buttonKeluarBuku.setText("Keluar");
        buttonKeluarBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKeluarBukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inpPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel2))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inpJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inpKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(29, 29, 29)
                                .addComponent(inpNamaPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(jLabel8))
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(inpJumlahBuku, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(inpStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inpJenisBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inpTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpanBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonEditBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonHapusBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonKeluarBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonCariBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 25, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(389, 389, 389))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(inpKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inpJudulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(inpNamaPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(inpPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(inpTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCariBuku)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inpJenisBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inpStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inpJumlahBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(buttonKeluarBuku)
                    .addComponent(buttonHapusBuku)
                    .addComponent(buttonEditBuku)
                    .addComponent(btnSimpanBuku))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inpKodeBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpKodeBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpKodeBukuActionPerformed

    private void inpJudulBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpJudulBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpJudulBukuActionPerformed

    private void inpNamaPengarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpNamaPengarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpNamaPengarangActionPerformed

    private void inpPenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpPenerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpPenerbitActionPerformed

    private void inpTahunTerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpTahunTerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpTahunTerbitActionPerformed

    private void inpJenisBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpJenisBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpJenisBukuActionPerformed

    private void inpJumlahBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpJumlahBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpJumlahBukuActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void buttonKeluarBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKeluarBukuActionPerformed
        dispose();
        Home home = new Home();
        home.setVisible(true);
    }//GEN-LAST:event_buttonKeluarBukuActionPerformed

    private void btnSimpanBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanBukuActionPerformed
        CreateDbBuku inputData = new CreateDbBuku();
        DefaultTableModel tabelData2 = (DefaultTableModel) tabelDataBuku.getModel();   
   
        inputData.inputData(Integer.parseInt(inpKodeBuku.getText()),inpJudulBuku.getText(),inpNamaPengarang.getText(),inpPenerbit.getText(),Integer.parseInt(inpTahunTerbit.getText()),inpJenisBuku.getText(),Integer.parseInt(inpJumlahBuku.getText()));
        ResultSet rs = tampilData.tampilkanData(this.inpKodeBuku.getText());
        try{
            
            if(rs.next()){
                tabelData2.addRow(new Object[]{rs.getString("kode_buku"), rs.getString("judul_buku"),rs.getString("nama_pengarang"), rs.getString("penerbit"), rs.getString("tahun_terbit"), rs.getString("jenis_buku"), rs.getString("status"), rs.getString("jumlah_buku_tersedia")});
            } else{
                System.out.println("Data tidak bisa ditampilkan");
            }
        }catch(SQLException e){
            System.out.println("Pesan Error : " + e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanBukuActionPerformed

    private void tabelDataBukuAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabelDataBukuAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelDataBukuAncestorAdded

    private void inpStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpStatusActionPerformed

    private void buttonEditBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditBukuActionPerformed
        // TODO add your handling code here:
        UpdateDbBuku updateData = new UpdateDbBuku();
        updateData.updateData(Integer.parseInt(inpKodeBuku.getText()),inpJudulBuku.getText(),inpNamaPengarang.getText(),inpPenerbit.getText(),Integer.parseInt(inpTahunTerbit.getText()),inpJenisBuku.getText(),inpStatus.getText(),Integer.parseInt(inpJumlahBuku.getText()));
        DefaultTableModel tabel = (DefaultTableModel) tabelDataBuku.getModel();
        tabel.addRow(new Object[]{inpKodeBuku.getText(), inpJudulBuku.getText(), inpNamaPengarang.getText(),inpPenerbit.getText(), inpTahunTerbit.getText(), inpJenisBuku.getText(), inpStatus.getText(), inpJumlahBuku.getText()});
        tabel.removeRow(selectedRow);
    }//GEN-LAST:event_buttonEditBukuActionPerformed

    private void buttonHapusBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusBukuActionPerformed
        //TODO add your handling code here:
        DeleteDbBuku deleteData = new DeleteDbBuku();
        deleteData.deleteData(inpKodeBuku.getText());
        DefaultTableModel tabel = (DefaultTableModel) tabelDataBuku.getModel();
        tabel.removeRow(selectedRow);
        inpKodeBuku.setText("");
        inpJudulBuku.setText("");
        inpNamaPengarang.setText("");
        inpTahunTerbit.setText("");
        inpJenisBuku.setText("");
        inpStatus.setText("");
        inpJumlahBuku.setText("");
    }//GEN-LAST:event_buttonHapusBukuActionPerformed

    private void buttonCariBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariBukuActionPerformed
                ResultSet rs;
        if(!"".equals(buttonCariBuku.getText())) {
            rs = tampilData.tampilkanData(buttonCariBuku.getText());
        } else {
            rs = tampilData.tampilkanDataSemuaBuku();
        }
        
        DefaultTableModel tabel = (DefaultTableModel) tabelDataBuku.getModel();
        
        try{
            for(var i = tabel.getRowCount() - 1; i >= 0; i--) {
                tabel.removeRow(i);
            }
            while(rs.next()){
                tabel.addRow(new Object[]{inpKodeBuku.getText(), inpJudulBuku.getText(), inpNamaPengarang.getText(),inpPenerbit.getText(), inpTahunTerbit.getText(), inpJenisBuku.getText(), inpStatus.getText(), inpJumlahBuku.getText()});
            }
            
        }catch(SQLException e){
            System.out.println("Pesan Error : " + e.getMessage());
        }
    }//GEN-LAST:event_buttonCariBukuActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpanBuku;
    private javax.swing.JButton buttonCariBuku;
    private javax.swing.JButton buttonEditBuku;
    private javax.swing.JButton buttonHapusBuku;
    private javax.swing.JButton buttonKeluarBuku;
    private javax.swing.JTextField inpJenisBuku;
    private javax.swing.JTextField inpJudulBuku;
    private javax.swing.JTextField inpJumlahBuku;
    private javax.swing.JTextField inpKodeBuku;
    private javax.swing.JTextField inpNamaPengarang;
    private javax.swing.JTextField inpPenerbit;
    private javax.swing.JTextField inpStatus;
    private javax.swing.JTextField inpTahunTerbit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabelDataBuku;
    // End of variables declaration//GEN-END:variables
}
