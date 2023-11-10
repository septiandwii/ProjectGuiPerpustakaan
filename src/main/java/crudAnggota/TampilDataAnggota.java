/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudAnggota;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ACER
 */
public class TampilDataAnggota {
    String url = "jdbc:mysql://localhost:3306/database_perpustakaan";
    String username = "root";
    String password = "";
    ResultSet rs;
    
//    String nama, nim, programStudi, nomorTlp, jenisKelamin;
    
     public ResultSet tampilkanData(String nim){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection(url,username,  password);
            String query = String.format("select * from data_anggota where nim = \"%s\";", nim);
            Statement st = koneksi.createStatement();
            this.rs = st.executeQuery(query);
            return this.rs;
         }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
       }
        return this.rs;
     }
     
     public ResultSet tampilkanDataSemuaAnggota(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection koneksi = DriverManager.getConnection(url,username,  password);
            String query = String.format("select * from data_anggota");
            Statement st = koneksi.createStatement();
            this.rs = st.executeQuery(query);
            return this.rs;
         }catch (ClassNotFoundException | SQLException ex){
           System.out.println("Terdapat Error : "+ex.getMessage());  
       }
        return this.rs;
     }
     
}
