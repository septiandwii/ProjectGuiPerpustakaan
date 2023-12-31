/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudBuku;
import com.mycompany.projectperpustakaan.Koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
/**
 *
 * @author hafid punyaa
 */
public class CreateDbBuku {
   String url = "jdbc:mysql://localhost:3306/database_perpustakaan";
    String username = "root";
    String password = "";
    
     public void inputData(int kode_buku, String judul_buku, String nama_pengarang, String penerbit, int tahun_terbit, String jenis_buku, int jumlah_buku_tersedia, JRootPane rootPane){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection(url,username,  password);
            String query = String.format("insert into data_buku(kode_buku, judul_buku, nama_pengarang, penerbit, tahun_terbit, jenis_buku, status, jumlah_buku_tersedia)values(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\", \"Tersedia\",\"%s\");",kode_buku, judul_buku, nama_pengarang, penerbit, tahun_terbit, jenis_buku, jumlah_buku_tersedia);
            Statement st = koneksi.createStatement();
            st.executeUpdate(query);
            st.close();
            System.out.println("Koneksi ditutup...");
            JOptionPane.showMessageDialog(rootPane, "SIMPAN DATA BERHASIL");

         }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
           JOptionPane.showMessageDialog(rootPane, "SIMPAN DATA GAGAL");
       }
    }
}
