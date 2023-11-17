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
import java.sql.Date;
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
    int selectedBuku = -1;
    int kode_buku;
    String nim;
    String nama;
    Date peminjaman_buku;    
    Date pengembalian_buku;
    Date pengembalian_buku_anggota = new Date(System.currentTimeMillis());
    int id_transaksi;
    double denda;
    
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
                Boolean tersedia = rs.getInt("jumlah_buku_tersedia") > 0;
                if(tersedia) {
                    model.addRow(new Object[]{rs.getString("kode_buku"), rs.getString("judul_buku"),rs.getString("nama_pengarang"), rs.getString("penerbit"), rs.getString("tahun_terbit"), rs.getString("jenis_buku"), rs.getString("status"), rs.getString("jumlah_buku_tersedia")});   
                }
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
                selectedBuku = row;
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
                int row = tabelTransaksi.getSelectedRow();
                kode_buku = Integer.parseInt(tabelTransaksi.getValueAt(row, 0).toString());
                nim = tabelTransaksi.getValueAt(row, 1).toString();
                nama = tabelTransaksi.getValueAt(row, 2).toString();
                peminjaman_buku = Date.valueOf(tabelTransaksi.getValueAt(row, 3).toString());
                pengembalian_buku = Date.valueOf(tabelTransaksi.getValueAt(row, 4).toString());
                pengembalian_buku_anggota = new Date(System.currentTimeMillis());
                id_transaksi =  Integer.parseInt(tabelTransaksi.getValueAt(row, 6).toString());
                Boolean melebihi = pengembalian_buku_anggota.after(pengembalian_buku);
                if(melebihi) {
                    double selisih = pengembalian_buku_anggota.toLocalDate().toEpochDay() - pengembalian_buku.toLocalDate().toEpochDay();
                    denda = 1000 * selisih;
                }
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDataBuku = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        btnKeluar = new javax.swing.JButton();
        pilihanNim = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        inpNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnPengembalianBuku = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inptKodePeminjaman = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        inpKodeBuku = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        inpNamaBuku = new javax.swing.JTextField();
        inpNamaPengarang = new javax.swing.JTextField();
        inpTahunTerbit = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(124, 133, 148));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(19, 46, 53), 12, true));

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

        btnSimpan.setBackground(new java.awt.Color(74, 88, 89));
        btnSimpan.setFont(new java.awt.Font("Schadow BT", 0, 12)); // NOI18N
        btnSimpan.setForeground(new java.awt.Color(237, 237, 237));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Mongolian Baiti", 1, 36)); // NOI18N
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

        btnKeluar.setBackground(new java.awt.Color(93, 107, 107));
        btnKeluar.setFont(new java.awt.Font("Schadow BT", 0, 12)); // NOI18N
        btnKeluar.setForeground(new java.awt.Color(237, 237, 237));
        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        pilihanNim.setBackground(new java.awt.Color(74, 88, 89));
        pilihanNim.setFont(new java.awt.Font("Schadow BT", 0, 12)); // NOI18N
        pilihanNim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihanNimActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Mongolian Baiti", 3, 18)); // NOI18N
        jLabel2.setText("DATA TRANSAKSI");

        jLabel3.setFont(new java.awt.Font("Mongolian Baiti", 3, 18)); // NOI18N
        jLabel3.setText("DATA BUKU");

        jLabel6.setFont(new java.awt.Font("Schadow BT", 1, 14)); // NOI18N
        jLabel6.setText("Nama");

        inpNama.setEditable(false);
        inpNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpNamaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Mongolian Baiti", 3, 18)); // NOI18N
        jLabel4.setText("Data Peminjam ");

        btnPengembalianBuku.setBackground(new java.awt.Color(105, 129, 141));
        btnPengembalianBuku.setFont(new java.awt.Font("Schadow BT", 0, 12)); // NOI18N
        btnPengembalianBuku.setForeground(new java.awt.Color(237, 237, 237));
        btnPengembalianBuku.setText("Pengembalian");
        btnPengembalianBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengembalianBukuActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Schadow BT", 1, 14)); // NOI18N
        jLabel5.setText("ID Transaksi");

        jLabel7.setFont(new java.awt.Font("Schadow BT", 1, 14)); // NOI18N
        jLabel7.setText("NIM ");

        jLabel8.setFont(new java.awt.Font("Mongolian Baiti", 3, 18)); // NOI18N
        jLabel8.setText("Data Buku ");

        inpKodeBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpKodeBukuActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Schadow BT", 1, 14)); // NOI18N
        jLabel9.setText("Kode Buku");

        jLabel10.setFont(new java.awt.Font("Schadow BT", 1, 14)); // NOI18N
        jLabel10.setText("Nama Buku");

        jLabel11.setFont(new java.awt.Font("Schadow BT", 1, 14)); // NOI18N
        jLabel11.setText("Nama Pengarang");

        jLabel12.setFont(new java.awt.Font("Schadow BT", 1, 14)); // NOI18N
        jLabel12.setText("Tahun Terbit");

        inpNamaBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpNamaBukuActionPerformed(evt);
            }
        });

        inpTahunTerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpTahunTerbitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inptKodePeminjaman, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(87, 87, 87)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pilihanNim, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inpNama, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(btnPengembalianBuku))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel11))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(inpKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inpNamaBuku, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(inpNamaPengarang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel12)
                                .addGap(64, 64, 64)
                                .addComponent(inpTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKeluar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inptKodePeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inpNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pilihanNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSimpan))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(inpKodeBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(inpNamaBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(inpNamaPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(inpTahunTerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addComponent(btnPengembalianBuku)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKeluar)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        CreateDbTransaksi inputData = new CreateDbTransaksi();
        DefaultTableModel tabelData3 = (DefaultTableModel) tabelTransaksi.getModel();     
        inputData.inputData(Integer.parseInt(inpKodeBuku.getText()), pilihanNim.getSelectedItem().toString(), inpNama.getText(), inptKodePeminjaman.getText(), rootPane);
        ResultSet rsT = tampilData2.tampilkanDataTransaksi(this.inptKodePeminjaman.getText());
        try{
            if(rsT.next()){
                tabelData3.addRow(new Object[]{rsT.getString("kode_buku"),rsT.getString("nim"),rsT.getString("nama"), rsT.getString("peminjaman_buku"), rsT.getString("pengembalian_buku"),rsT.getString("pengembalian_buku_anggota"), rsT.getString("id_transaksi")});
            } else{
                System.out.println("Data tidak bisa ditampilkan");
            }
        }catch(SQLException e){
//            System.out.println("Pesan Error : " + e.getMessage());
            e.printStackTrace();
        }
        
        ResultSet rsB = tampilData.tampilkanData(tabelDataBuku.getValueAt(selectedBuku, 0).toString());
        DefaultTableModel tabel = (DefaultTableModel) tabelDataBuku.getModel();
        try {
            if(rsB.next()) {
                Boolean tersedia = rsB.getInt("jumlah_buku_tersedia") > 0;
                if(tersedia){
                    tabel.addRow(new Object[]{rsB.getString("kode_buku"), rsB.getString("judul_buku"),rsB.getString("nama_pengarang"), rsB.getString("penerbit"), rsB.getString("tahun_terbit"), rsB.getString("jenis_buku"), rsB.getString("status"), rsB.getString("jumlah_buku_tersedia")});
                }
                tabel.removeRow(selectedBuku);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void inpKodeBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpKodeBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpKodeBukuActionPerformed

    private void inpNamaBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpNamaBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpNamaBukuActionPerformed

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

    private void btnPengembalianBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengembalianBukuActionPerformed
          dispose();
          PengembalianBuku pengembalianBuku = new PengembalianBuku(kode_buku, nim, nama, peminjaman_buku, pengembalian_buku, pengembalian_buku_anggota, id_transaksi, denda);
          pengembalianBuku.setVisible(true);
    }//GEN-LAST:event_btnPengembalianBukuActionPerformed

    private void inpTahunTerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpTahunTerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpTahunTerbitActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnPengembalianBuku;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JTextField inpKodeBuku;
    private javax.swing.JTextField inpNama;
    private javax.swing.JTextField inpNamaBuku;
    private javax.swing.JTextField inpNamaPengarang;
    private javax.swing.JTextField inpTahunTerbit;
    private javax.swing.JTextField inptKodePeminjaman;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> pilihanNim;
    private javax.swing.JTable tabelDataBuku;
    private javax.swing.JTable tabelTransaksi;
    // End of variables declaration//GEN-END:variables
}
