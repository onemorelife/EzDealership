/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Controller.Sales;
import Controller.Inventory;
import Controller.Employees;
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
        String sql = "SELECT *"
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
    
    public ArrayList<Sales> getSales()
    {
        String sql = "SELECT *"
                + "FROM Sales ORDER BY Code ASC";        
        ArrayList<Sales> sales = new ArrayList<>();
        
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery())
        {
            while(rs.next())
            {
                String code = rs.getString("code");
                String transactionNum = rs.getString("transactionNum");
                String employeeName = rs.getString("employeeName");
                String saleDate = rs.getString("saleDate");
                boolean lease = rs.getBoolean("lease");

                Sales s = new Sales(code, transactionNum, employeeName, saleDate, lease);
                sales.add(s);
            }
            return sales;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return null;
        }
    }
    
    public ArrayList<Employees> getEmployees()
    {
        String sql = "SELECT *"
                + "FROM Sales ORDER BY employeeName ASC";        
        ArrayList<Employees> employees = new ArrayList<>();
        
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery())
        {
            while(rs.next())
            {
                String employeeName = rs.getString("employeeName");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String department = rs.getString("derpartment");
                double salary = rs.getDouble("salary");

                Employees e = new Employees(employeeName, phone, email, department, salary);
                employees.add(e);
            }
            return employees;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return null;
        }
    }
}
