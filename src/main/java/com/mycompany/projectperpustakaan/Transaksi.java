/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projectperpustakaan;
import crudTransaksi.CreateDbTransaksi;
import crudAnggota.TampilDataAnggota;
import crudBuku.TampilDataBuku;
import crudTransaksi.TampilDbTransaksi;
import crudTransaksi.UpdateDbTransaksi;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.*;
/**
 *
 * @author ACER
 */
public class Transaksi extends javax.swing.JFrame {

    /**
     * Creates new form Transaksi
     */
    TampilDataBuku tampilData = new TampilDataBuku();
    TampilDbTransaksi tampilData2 = new TampilDbTransaksi();
    int selectedRow = -1;
    public Transaksi() {
        initComponents();
        // ini logic untuk combobox -> read semua data anggota
        TampilDataAnggota dataAnggota = new TampilDataAnggota();
        ResultSet rsA = dataAnggota.tampilkanDataSemuaAnggota();
        try{
            int i = 0;
            while(rsA.next()){
                pilihanNim.addItem(rsA.getString("nim"));
                i++;
            }
        }catch(SQLException e){
            System.out.println("Pesan Error : " + e.getMessage());
        }
        
                
        // ini logic tabel transaksi
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
                inpNamaBuku.setText(tabelDataBuku.getValueAt(row, 1).toString());
                inpNamaPengarang.setText(tabelDataBuku.getValueAt(row, 2).toString());
                inpTahunTerbit.setText(tabelDataBuku.getValueAt(row, 3).toString());
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
        // penutup logic tabel transaksi
        
        
        
        String[] columns2 = {
          "kode_buku",
          "nim",
          "nama", 
          "peminjaman_buku", 
          "pengembalian_buku",
          "pengembalian_buku_anggota",
          "id_transaksi",
        };
        DefaultTableModel model2 = new DefaultTableModel(columns2, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tabelTransaksi.setModel(model2);
        ResultSet rsB = tampilData2.tampilkanDataSemuaTransaksi();
        
        try{
            int i = 0;
            while(rsB.next()){
                model2.addRow(new Object[]{rsB.getString("kode_buku"), rsB.getString("nim"),rsB.getString("nama"), rsB.getString("peminjaman_buku"), rsB.getString("pengembalian_buku"), rsB.getString("pengembalian_buku_anggota"), rsB.getString("id_transaksi")});
                i++;
            }
        }catch(SQLException e){
            System.out.println("Pesan Error : " + e.getMessage());
        }
        
        this.tabelTransaksi.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//                int row = tabelTransaksi.getSelectedRow();
//                selectedRow = row;
//                inptKodePeminjaman.setText(tabelTransaksi.getValueAt(row, 0).toString());
//                inpNama.setText(tabelTransaksi.getValueAt(row, 1).toString());
//                pilihanNim.setSelectedItem(tabelTransaksi.getValueAt(row, 2).toString());
//                inpTahunTerbit.setText(tabelTransaksi.getValueAt(row, 3).toString());
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
    
    public void idTransaksi(){
        
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
        tabelDataBuku = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inptKodePeminjaman = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        inpKodeBuku = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        inpNamaBuku = new javax.swing.JTextField();
        inpNamaPengarang = new javax.swing.JTextField();
        inpTahunTerbit = new javax.swing.JTextField();
        inpTanggalPeminjaman = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnEditDatabase = new javax.swing.JButton();
        btnHapusDatabase = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        pilihanNim = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        inpNama = new javax.swing.JTextField();
        btnPengembalianBuku = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelDataBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelDataBuku);
        if (tabelDataBuku.getColumnModel().getColumnCount() > 0) {
            tabelDataBuku.getColumnModel().getColumn(0).setResizable(false);
            tabelDataBuku.getColumnModel().getColumn(1).setResizable(false);
            tabelDataBuku.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("DATA PEMINJAMAN BUKU PERPUSTAKAAN");

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelTransaksi);

        jLabel2.setText("TABEL DATA TRANSAKSI");

        jLabel3.setText("TABEL DATA BUKU");

        jLabel4.setText("Data Peminjam ");

        jLabel5.setText("ID Transaksi");

        jLabel7.setText("NIM ");

        jLabel8.setText("Data Buku ");

        inpKodeBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpKodeBukuActionPerformed(evt);
            }
        });

        jLabel9.setText("Kode Buku");

        jLabel10.setText("Nama Buku");

        jLabel11.setText("Nama Pengarang");

        jLabel12.setText("Tahun Terbit");

        jLabel13.setText("Tanggal Peminjaman");

        inpNamaBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpNamaBukuActionPerformed(evt);
            }
        });

        inpTanggalPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpTanggalPeminjamanActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnEditDatabase.setText("Edit");
        btnEditDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDatabaseActionPerformed(evt);
            }
        });

        btnHapusDatabase.setText("Hapus");

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        pilihanNim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihanNimActionPerformed(evt);
            }
        });

        jLabel6.setText("Nama");

        inpNama.setEditable(false);
        inpNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpNamaActionPerformed(evt);
            }
        });

        btnPengembalianBuku.setText("Pengembalian");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inpKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inpNamaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inpNamaPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(inpTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                    .addComponent(inpTanggalPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pilihanNim, 0, 93, Short.MAX_VALUE)
                                        .addComponent(inpNama)
                                        .addComponent(inptKodePeminjaman))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 210, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEditDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnHapusDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 24, Short.MAX_VALUE)
                                        .addComponent(btnPengembalianBuku)
                                        .addGap(78, 78, 78)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(175, 175, 175))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(645, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGap(189, 189, 189)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(inptKodePeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inpNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pilihanNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(inpKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(inpNamaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(inpNamaPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(inpTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(inpTanggalPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnKeluar)
                            .addComponent(btnPengembalianBuku)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btnEditDatabase)
                            .addComponent(btnHapusDatabase))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addComponent(jLabel3)
                    .addContainerGap(539, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        CreateDbTransaksi inputData = new CreateDbTransaksi();
        DefaultTableModel tabelData3 = (DefaultTableModel) tabelTransaksi.getModel();     
        inputData.inputData(Integer.parseInt(inpKodeBuku.getText()), pilihanNim.getSelectedItem().toString(), inpNama.getText(), inptKodePeminjaman.getText());
        ResultSet rsB = tampilData2.tampilkanDataTransaksi(this.inptKodePeminjaman.getText());
        try{
            
            if(rsB.next()){
                tabelData3.addRow(new Object[]{rsB.getString("kode_buku"),rsB.getString("nim"),rsB.getString("nama"), rsB.getString("peminjaman_buku"), rsB.getString("pengembalian_buku"),rsB.getString("pengembalian_buku_anggota"), rsB.getString("id_transaksi")});
            } else{
                System.out.println("Data tidak bisa ditampilkan");
            }
        }catch(SQLException e){
//            System.out.println("Pesan Error : " + e.getMessage());
            e.printStackTrace();
        }
    
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void inpKodeBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpKodeBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpKodeBukuActionPerformed

    private void inpNamaBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpNamaBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpNamaBukuActionPerformed

    private void inpTanggalPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpTanggalPeminjamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpTanggalPeminjamanActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        dispose();
        Home home = new Home();
        home.setVisible(true);
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void pilihanNimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihanNimActionPerformed

        String nim = pilihanNim.getSelectedItem().toString();
        TampilDataAnggota dataAnggota = new TampilDataAnggota();
        ResultSet rsA = dataAnggota.tampilkanData(nim);
        try {
            while(rsA.next()) {
                inpNama.setText(rsA.getString("nama"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pilihanNimActionPerformed

    private void inpNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpNamaActionPerformed

    private void btnEditDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDatabaseActionPerformed
        UpdateDbTransaksi updateData = new UpdateDbTransaksi();
        updateData.updateData(inpNama .getText(), inpNim.getText(), inpProgramStudi.getText(),inpNo.getText(), pilihanJenisKelamin.getSelectedItem().toString());
        DefaultTableModel tabel = (DefaultTableModel) tabelDataAnggota.getModel();
        tabel.addRow(new Object[]{inpNama.getText(), inpNim.getText(), inpProgramStudi.getText(),inpNo.getText(), pilihanJenisKelamin.getSelectedItem().toString()});
        tabel.removeRow(selectedRow);
    }//GEN-LAST:event_btnEditDatabaseActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditDatabase;
    private javax.swing.JButton btnHapusDatabase;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnPengembalianBuku;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JTextField inpKodeBuku;
    private javax.swing.JTextField inpNama;
    private javax.swing.JTextField inpNamaBuku;
    private javax.swing.JTextField inpNamaPengarang;
    private javax.swing.JTextField inpTahunTerbit;
    private javax.swing.JTextField inpTanggalPeminjaman;
    private javax.swing.JTextField inptKodePeminjaman;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JComboBox<String> pilihanNim;
    private javax.swing.JTable tabelDataBuku;
    private javax.swing.JTable tabelTransaksi;
    // End of variables declaration//GEN-END:variables
}
