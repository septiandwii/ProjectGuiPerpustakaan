/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudTransaksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ACER
 */
public class UpdateDbTransaksi {
    String url = "jdbc:mysql://localhost:3306/database_perpustakaan";
    String username = "root";
    String password = "";
    
     public void updateData(int kode_buku, String nim, String nama, String peminjaman_buku, int pengembalian_buku, String pengembalian_buku_anggota, int id_transaksi, int denda){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection(url,username,  password);
            String query = String.format("update transaksi set kode_buku = \"%s\", nim = \"%s\", nama = \"%s\", peminjaman_buku = \"%s\", pengembalian_buku = \"%s\", pengembalian_buku_anggota = \"%s\", id_transaksi = \"%s\", denda = \"%s\" where id_transaksi = \"%s\";" ,kode_buku, nim, nama, pengembalian_buku, pengembalian_buku_anggota, id_transaksi, denda);
            Statement st = koneksi.createStatement();
            st.executeUpdate(query);
            st.close();
            System.out.println("Koneksi ditutup...");

         }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
       }
    }
}
