/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudBuku;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hafid punyaa
 */
//updateeeeee
public class UpdateDbBuku {
    String url = "jdbc:mysql://localhost:3306/database_perpustakaan";
    String username = "root";
    String password = "";
    
     public void updateData(int kode_buku, String judul_buku, String nama_pengarang, String penerbit, int tahun_terbit, String jenis_buku, int jumlah_buku_tersedia){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection(url,username,  password);
            String query = String.format("update data_buku set kode_buku = \"%s\", judul_buku = \"%s\", nama_pengarang = \"%s\", penerbit = \"%s\", tahun_terbit = \"%s\", jenis_buku = \"%s\",jumlah_buku_tersedia = \"%s\" where kode_buku = \"%s\";" ,kode_buku, judul_buku, nama_pengarang, penerbit, tahun_terbit, jenis_buku, jumlah_buku_tersedia, kode_buku);
            Statement st = koneksi.createStatement();
            st.executeUpdate(query);
            st.close();
            System.out.println("Koneksi ditutup...");

         }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
       }
    }
    
     public void kembalikanBuku(int kode_buku){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection(url,username,  password);
            String query = String.format("update data_buku set jumlah_buku_tersedia = jumlah_buku_tersedia + 1, status = \"Tersedia\" where kode_buku = \"%s\";",kode_buku);
            Statement st = koneksi.createStatement();
            st.executeUpdate(query);
            st.close();
            System.out.println("Koneksi ditutup...");

         }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
       }
    }
}
