package com.example.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JBDC {
    private String user;
    private String pwd;
    private String url;

    public void createNewWishlist(String nameOfPresent,float price,
                                  String linkOfThePresent, byte reserveret,
                                  String username) throws SQLException {
        try(InputStream input = new FileInputStream("src/main/resources/application.properties")) {
            Properties properties = new Properties();
            properties.load(input);
            user = properties.getProperty("user");
            pwd = properties.getProperty("pwd");
            url = properties.getProperty("url");
        }catch (IOException e){
            e.printStackTrace();
        }


        DriverManager.getConnection(url,user,pwd);
        Connection conn = DriverManager.getConnection(url, user, pwd);
        String sql = "INSERT INTO `ønskeskyen`.`ønskeliste`(`navn_på_gaven`,`pris`,`link_til_gaven`,`reseveret`,`username`) VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,nameOfPresent);
        pstmt.setFloat(2,price);
        pstmt.setString(3,linkOfThePresent);
        pstmt.setByte(4, reserveret);
        pstmt.setString(5,username);
        pstmt.executeUpdate();
        pstmt.close();
    }
}
