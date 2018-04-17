/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import database.DatabaseConn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milos
 */
public class Products {
    private int id;
    private String model_name;
    private String code;
    private int stock;
    private int price;
    
    public String MODEL;

    public Products() {
        this.id = 0;
        this.model_name = "";
        this.code = "";
        this.stock = 0;
        this.price = 0;
    }
    
    public Products(int id, String model_name, String code, int stock, int price) {
        this.id = id;
        this.model_name = model_name;
        this.code = code;
        this.stock = stock;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


       
    @Override
    public String toString() {
        return "Products{" + "id=" + id + ", model_name=" + model_name + ", code=" + code + ", stock=" + stock + ", price=" + price + '}';
    }
    
    
    public String findGuitars(String guitarName){
           
        String table = "";
        table += "<table border = 1>";
        
        table += "<tr>";
            table += "<td>";
                table += " id ";
            table += "</td>";
                    
            table += "<td>";
                table += " Model Name ";
            table += "</td>";
                        
            table += "<td>";
                table += " Code ";
            table += "</td>";
                        
            table += "<td>";
                table += " Stock ";
            table += "</td>";
                        
            table += "<td>";
                table += " Price ";
            table += "</td>";   
        table += "</tr>";
                    
        DatabaseConn db = new DatabaseConn();
        Connection con = db.Connect();
            try {
                String query = "select * from products where model_name like ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1,"%" + guitarName + "%");
                
                ResultSet rs = ps.executeQuery();
                
                    while(rs.next()){
                        Products pro = new Products();
                        pro.setId(rs.getInt("id"));
                        pro.setModel_name(rs.getString("model_name"));
                        pro.setCode(rs.getString("code"));
                        pro.setStock(rs.getInt("stock"));
                        pro.setPrice(rs.getInt("price"));

                        MODEL = pro.getModel_name();   
                        
                        table += "<tr>";
                            table += "<td>";
                                table += pro.getId();
                            table += "</td>";

                            table += "<td>";
                                table += pro.getModel_name();
                            table += "</td>";

                            table += "<td>";
                                table += pro.getCode();
                            table += "</td>";

                            table += "<td>";
                                table += pro.getStock();
                            table += "</td>";

                            table += "<td>";
                                table += pro.getPrice();
                            table += "</td>";   
                        table += "</tr>";
                        
                    }
                    table += "</table>";
            
            } catch (SQLException ex) {
                Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
                }
            return table;    
    }
    
    
    
    public String getAllProducts(){
    
        String table = "";
        table += "<table border = 1>";
        
        table += "<tr>";
                        table += "<td>";
                            table += " id ";
                        table += "</td>";
                    
                        table += "<td>";
                            table += " Model Name ";
                        table += "</td>";
                        
                        table += "<td>";
                            table += " Code ";
                        table += "</td>";
                        
                        table += "<td>";
                            table += " Stock ";
                        table += "</td>";
                        
                        table += "<td>";
                            table += " Price ";
                        table += "</td>";   
                    table += "</tr>";
        
        DatabaseConn db = new DatabaseConn();
                Connection con = db.Connect();
                Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from products");
            while(rs.next()){
                    Products p = new Products();
                    p.setId(rs.getInt("id"));
                    p.setModel_name(rs.getString("model_name"));
                    p.setCode(rs.getString("code"));
                    p.setStock(rs.getInt("stock"));
                    p.setPrice(rs.getInt("price"));
                    
                    table += "<tr>";
                        table += "<td>";
                            table += p.getId();
                        table += "</td>";
                    
                        table += "<td>";
                            table += p.getModel_name();
                        table += "</td>";
                        
                        table += "<td>";
                            table += p.getCode();
                        table += "</td>";
                        
                        table += "<td>";
                            table += p.getStock();
                        table += "</td>";
                        
                        table += "<td>";
                            table += p.getPrice();
                        table += "</td>";   
                    table += "</tr>";
                }
                
                table += "</table>";
 
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
        return table;
    }
}
