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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Milos
 */
public class Customers {
    
    private int id;
    private String first_name;
    private String last_name;
    private String password;
    private String email_address;
    
    public String PASS;
    public String EML;
    
    public Customers() {
        this.id = 0;
        this.first_name = "";
        this.last_name = "";
        this.password = "";
        this.email_address = "";
    }
    
    public Customers(int id, String first_name, String last_name, String password, String email_address) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email_address = email_address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    @Override
    public String toString() {
        return "Customers{" + "id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", password=" + password + ", email_address=" + email_address + '}';
    }
    
    
    public void addAll(Customers ctm){
        DatabaseConn db = new DatabaseConn();
        Connection con = db.Connect();
        try {
            String query = "insert into customers(first_name,last_name,password,email_address)values(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, ctm.getFirst_name());
                ps.setString(2, ctm.getLast_name());
                ps.setString(3, ctm.getPassword());
                ps.setString(4, ctm.getEmail_address());
                
                ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public String getAll(){
        
        String table = "";
                table += "<table border = 1>";
        
                table += "<tr>";
                        table += "<td>";
                            table += " id ";
                        table += "</td>";
                    
                        table += "<td>";
                            table += " First name ";
                        table += "</td>";
                        
                        table += "<td>";
                            table += " Last name ";
                        table += "</td>";
                        
                        table += "<td>";
                            table += " Password ";
                        table += "</td>";
                        
                        table += "<td>";
                            table += " Email address ";
                        table += "</td>";
                    table += "</tr>";
                
        DatabaseConn db = new DatabaseConn();
                Connection con = db.Connect();
                Statement stmt; 
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from customers");

                while(rs.next()){
                    Customers c = new Customers();
                    c.setId(rs.getInt("id"));
                    c.setFirst_name(rs.getString("first_name"));
                    c.setLast_name(rs.getString("last_name"));
                    c.setPassword(rs.getString("password"));
                    c.setEmail_address(rs.getString("email_address"));
                    
                    table += "<tr>";
                        table += "<td>";
                            table += c.getId();
                        table += "</td>";
                    
                        table += "<td>";
                            table += c.getFirst_name();
                        table += "</td>";
                        
                        table += "<td>";
                            table += c.getLast_name();
                        table += "</td>";
                        
                        table += "<td>";
                            table += c.getPassword();
                        table += "</td>";
                        
                        table += "<td>";
                            table += c.getEmail_address();
                        table += "</td>"; 
                        
                        table += "<td>";
                            table += "<a href=update?id=" + c.getId() + "> Update </a>" + "<a href=delete?id=" + c.getId() + "> Delete </a>";
                        table += "</td>";
                    table += "</tr>";
                }
                
                table += "</table>";
                   
        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        return table;  
    }
    
    public void deleteCustomer(int id){
        DatabaseConn db = new DatabaseConn();
        Connection con = db.Connect();

        try {        
            String query = "delete from customers where id = ?";
            PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, id);
                ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static boolean validateEmail(String emailStr){
        Matcher matcher = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(emailStr);
        return matcher.find();
         
    }
    
    public boolean register(String password, String email){
        
        DatabaseConn db = new DatabaseConn();
        Connection con = db.Connect();
        
        try {
            String query = "SELECT * FROM customers where password like ? and email_address like ?";
            PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, password);
                ps.setString(2, email);
                    ResultSet rs = ps.executeQuery();
                        if(rs.next()){
                            return true;
                        }
                        else{
                            return false;
                        }  
        } 
        catch (SQLException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
            return true;
    } 
}
