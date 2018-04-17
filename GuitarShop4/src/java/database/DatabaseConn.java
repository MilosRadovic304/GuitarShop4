/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Milos
 */
public class DatabaseConn {
    public Connection conn;
    
    public Connection Connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/guitar_shop", "root", "");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return conn;
    }
    
    public void close(){
        try{
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
