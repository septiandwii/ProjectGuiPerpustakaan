/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectperpustakaan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author ACER
 */
public class Koneksi {
    public static Connection koneksiDb(){
            try{
//                String url = "jdbc:mysql://localhost:3306/database_perpustakaan";
//                String username = "root";
//                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_perpustakaan", "root", "");
                return koneksi;
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null,e);
                return null;
            }
        }
    }
//    String url = "jdbc:mysql://localhost:3306/data_perpus";
//    String username = "root";
//    String password = "";
//    public Connection conn = null;
//    public Koneksi() {
//        try {
//            conn =  conn = DriverManager.getConnection(url, username, password);
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void disconnect() {
//        try {
//            if (conn != null) {
//                conn.close();
//            }
//      
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
