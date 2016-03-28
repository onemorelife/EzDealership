/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.*;
import java.sql.*;
/**
 *
 * @author azure
 */
public class DealershipDB 
{
    private Connection getConnection()
    {
        Connection connection = null;
        try
        {
            //Set the directory
            String dbDirectory = "c:/dealership/db";
            System.setProperty("derby.system.home", dbDirectory);

            //Set the db url, username, and password
            String url = "jdbc:derby:DealershipDB";
            String username = "";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);
			return connection;
        }
        catch(SQLException e)
        {
            System.err.println(e);
			return null;
        }
    }
    
    //test method of reading inventory table
    public ArrayList<Inventory> getInventory()
    {
        String sql = "SELECT Make, Model, Stock, Price, Code "
                   + "FROM Inventory ORDER BY Make ASC";        
        ArrayList<Inventory> inventory = new ArrayList<>();
        
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery())
        {
            while(rs.next())
            {
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                int stock = rs.getInt("Stock");
                double price = rs.getDouble("Price");
                String code = rs.getString("Code");

                Inventory i = new Inventory(make, model, stock, price, code);
                inventory.add(i);
            }
            return inventory;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return null;
        }
    }    
}
