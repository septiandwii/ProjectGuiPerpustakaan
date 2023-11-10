/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudAnggota;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ACER
 */
public class UpdateDbAnggota {
    String url = "jdbc:mysql://localhost:3306/database_perpustakaan";
    String username = "root";
    String password = "";
    
     public void updateData(String nama, String nim, String programStudi, String nomorTlp, String jenisKelamin){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection(url,username,  password);
            String query = String.format("update data_anggota set nama = \"%s\", nim = \"%s\", program_studi = \"%s\", nomor_telp = \"%s\", jenis_kelamin = \"%s\" where nim = \"%s\";",nama, nim, programStudi, nomorTlp, jenisKelamin, nim);
            Statement st = koneksi.createStatement();
            st.executeUpdate(query);
            st.close();
            System.out.println("Koneksi ditutup...");

         }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
       }
    }
}

