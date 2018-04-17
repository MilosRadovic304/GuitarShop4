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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milos
 */
public class UpdateCustomers {
    
    private Connection con;
    private ResultSet results;
    
    private Customers customer = new Customers();
    private int id;
    
    
    public void doRead(int customerId){
        this.id = customerId;
        DatabaseConn db = new DatabaseConn();
        con = db.Connect();
        String query = "SELECT * FROM customers where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            this.results = ps.executeQuery();
                this.results.next();
                
                customer.setId(this.results.getInt("id"));
                customer.setFirst_name(this.results.getString("first_name"));
                customer.setLast_name(this.results.getString("last_name"));
                customer.setPassword(this.results.getString("password"));
                customer.setEmail_address(this.results.getString("email_address"));
            
        } catch (SQLException ex) {
            Logger.getLogger(UpdateCustomers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Customers getCustomer(){
        return this.customer;
    }
    
    public void doUpdate(Customers customer){
        DatabaseConn db = new DatabaseConn();
        con = db.Connect();
        String query = "Update customers SET first_name = ?, last_name = ?, password = ?, email_address = ? WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, customer.getFirst_name());
            ps.setString(2, customer.getLast_name());
            ps.setString(3, customer.getPassword());
            ps.setString(4, customer.getEmail_address());
            ps.setInt(5, customer.getId());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UpdateCustomers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
