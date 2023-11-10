/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudAnggota;

import java.sql.Statement;
import com.mycompany.projectperpustakaan.Koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author ACER
 */
public class CreatDbAnggota {
   String url = "jdbc:mysql://localhost:3306/database_perpustakaan";
    String username = "root";
    String password = "";
    
     public void inputData(String nama, String nim, String programStudi, String nomorTlp, String jenisKelamin){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection(url,username,  password);
            String query = String.format("insert into data_anggota(nama, nim, program_studi, nomor_telp, jenis_kelamin)values(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");",nama, nim, programStudi, nomorTlp, jenisKelamin);
            Statement st = koneksi.createStatement();
            st.executeUpdate(query);
            st.close();
            System.out.println("Koneksi ditutup...");

         }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
       }
    }
}
