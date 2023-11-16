/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudTransaksi;

import crudBuku.UpdateDbBuku;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ACER
 */
public class CreateDbTransaksi {
    String url = "jdbc:mysql://localhost:3306/database_perpustakaan";
    String username = "root";
    String password = ""; 
    
     public void inputData(int kodeBuku, String nim, String nama, String idTransaksi){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection(url,username,  password);
            String queryBuku = String.format("update data_buku set jumlah_buku_tersedia = jumlah_buku_tersedia - 1 where kode_buku = \"%s\"", kodeBuku);
            String queryEmptyBuku = "update data_buku set status = \"Tidak Tersedia\" where jumlah_buku_tersedia = 0";
            String query = String.format("insert into transaksi(kode_buku, nim, nama, pengembalian_buku, pengembalian_buku_anggota, denda, id_transaksi)values(\"%s\",\"%s\",\"%s\",now() + interval 5 day,\"%s\",\"%s\",\"%s\");", kodeBuku, nim, nama, "-", "0", idTransaksi);
            Statement st = koneksi.createStatement();
            st.executeUpdate(query);
            st.executeUpdate(queryBuku);
            st.executeUpdate(queryEmptyBuku);
            st.close();
            System.out.println("Koneksi ditutup...");

         }catch (ClassNotFoundException | SQLException ex){
           ex.printStackTrace();
       }
    }
}
