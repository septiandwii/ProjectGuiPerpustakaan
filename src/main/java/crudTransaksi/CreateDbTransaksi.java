/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudTransaksi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
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
    
     public void inputData(int kodeBuku, String nim, String nama){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection(url,username,  password);
            Date peminjamanBuku = new Date(System.currentTimeMillis());
            Date pengembalianBuku = new Date(peminjamanBuku.getTime() + 432000000);
            String query = String.format("insert into transaksi(kode_buku, nim, nama, peminjaman_buku, pengembalian_buku, pengembalian_buku_transaksi, denda)values(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");", kodeBuku, nim, nama, peminjamanBuku, pengembalianBuku);
            Statement st = koneksi.createStatement();
            st.executeUpdate(query);
            st.close();
            System.out.println("Koneksi ditutup...");

         }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
       }
    }
}
