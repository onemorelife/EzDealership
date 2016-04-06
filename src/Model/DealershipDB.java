
package Model;
import Controller.Sales;
import Controller.Inventory;
import Controller.Employees;
import java.util.*;
import java.sql.*;
/**
 *
 * @author Badruddoza Khan
 */
public class DealershipDB 
{
    private Connection getConnection()
    {
        Connection connection = null;
        try
        {
            //Set the directory
            String dbDirectory = "db";
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
    
    //Methods for getting the records in a specific table 
    public ArrayList<Inventory> getInventory()
    {
        String sql = "SELECT *"
                   + "FROM Inventory ORDER BY make ASC";        
        ArrayList<Inventory> inventory = new ArrayList<>();
        
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery())
        {
            while(rs.next())
            {
                String make = rs.getString("make");
                String model = rs.getString("model");
                int stock = rs.getInt("stock");
                double price = rs.getDouble("price");
                String code = rs.getString("code");

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
                + "FROM Sales ORDER BY code ASC";        
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
                + "FROM  ORDER BY employeeName ASC";        
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
                String department = rs.getString("department");
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
    
    //Methods for searching by criteria 
    //Methods are table specific 
    public Inventory getInventory(String code)
    {   //returns a single row based on code 
        //Pre-condition: Must be a valid code in table
        String sql =
            "SELECT model, make, stock, price " +
            "FROM Inventory " +
            "WHERE code = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {           
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                String make = rs.getString("make");
                String model = rs.getString("model");
                int stock = rs.getInt("stock");
                double price = rs.getDouble("Price");
                Inventory i = new Inventory(model, make, stock, price, code);
                rs.close();
                return i;
            }
            else
            {
                rs.close();
                return null;
            }
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return null;
        }
    }
    
    public Sales getSales(String transactionNum)
    {   //returns a single row based on transactionNum
        //Pre-condition: Must be a valid transactionNum in table
        //Will need helper method to convert transactionNum (input from view)
        //from an int or double to a string  
        // ^all data pulled from view is a string by default^
        String sql =
            "SELECT code, employeeName, saleDate, lease " +
            "FROM Sales " +
            "WHERE transactionNum = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {           
            ps.setString(1, transactionNum);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                String code = rs.getString("code");
                String employeeName = rs.getString("employeeName");
                String saleDate = rs.getString("saleDate");
                boolean lease = rs.getBoolean("lease");
                Sales s = new Sales(code, transactionNum, employeeName, 
                                    saleDate, lease);
                rs.close();
                return s;
            }
            else
            {
                rs.close();
                return null;
            }
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return null;
        }
    }
    
    public Employees getEmployees(String employeeName)
    {   //returns a single row based on employeeName 
        //Pre-condition: Must be a valid employeeName in table
        String sql =
            "SELECT phone, email, department, salary " +
            "FROM Employees " +
            "WHERE employeeName = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {           
            ps.setString(1, employeeName);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");
                Employees e = new Employees(employeeName, phone, email, 
                                            department, salary);
                rs.close();
                return e;
            }
            else
            {
                rs.close();
                return null;
            }
        }
        catch(SQLException whoops)
        {
            System.err.println(whoops);
            return null;
        }
    }
        
    //Methods for adding a record to a specific table 
    public boolean addInventory(Inventory i)
    { //Takes an Inventory object and adds it to the table record
      //TODO: Add another addInventory method to controller that takes user input
      //from view and makes use of this function.
        String sql =
            "INSERT INTO Inventory (make, model, stock, price, code) " +
            "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {           
            ps.setString(1, i.getMake());
            ps.setString(2, i.getModel());
            ps.setInt(3, i.getStock());
            ps.setDouble(4, i.getPrice());
            ps.setString(5, i.getCode());
            ps.executeUpdate();
            return true;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        }
    }
    
    public boolean addSales(Sales s)
    { //Takes a Sales object and adds it to the table record
        String sql =
            "INSERT INTO Sales (code, transactionNum, employeeName, saleDate, lease) " +
            "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {           
            ps.setString(1, s.getCode());
            ps.setString(2, s.getTransactionNum());
            ps.setString(3, s.getEmployeeName());
            ps.setString(4, s.getSaleDate());
            ps.setBoolean(5, s.isLease());
            ps.executeUpdate();
            return true;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        }
    }
    
    public boolean addEmployee(Employees e)
    { //Takes an Employee object and adds it to the table record      
        String sql =
            "INSERT INTO Employees (make, model, stock, price, code) " +
            "VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {           
            ps.setString(1, e.getEmployeeName());
            ps.setString(2, e.getPhone());
            ps.setString(3, e.getEmail());
            ps.setString(4, e.getDepartment());
            ps.setDouble(5, e.getSalary());
            ps.executeUpdate();
            return true;
        }
        catch(SQLException whoops)
        {
            System.err.println(whoops);
            return false;
        }
    }
    
    //Methods for deleting a record from a table. Will need
    //helper functions to wire ability to view
    public boolean deleteInventory(Inventory i)
    {
        String sql = "DELETE FROM Inventory " +
                     "WHERE code = ?";        
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {            
            ps.setString(1, i.getCode());
            ps.executeUpdate();
            return true;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        }
    }
    
    public boolean deleteSales(Sales s)
    {
        String sql = "DELETE FROM Sales " +
                     "WHERE transactionNum = ?";        
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {            
            ps.setString(1, s.getTransactionNum());
            ps.executeUpdate();
            return true;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        }
    }
    
    public boolean deleteEmployee(Employees e)
    {
        String sql = "DELETE FROM Employees " +
                     "WHERE employeeName = ?";        
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {            
            ps.setString(1, e.getEmployeeName());
            ps.executeUpdate();
            return true;
        }
        catch(SQLException whoops)
        {
            System.err.println(whoops);
            return false;
        }
    }
    
    //Methods for updating a record based on a criteria
    public boolean updateInventory(Inventory i)
    {
        String sql = "UPDATE Inventory SET " +
                         "make = ?, " +
                         "model = ?, " +
                         "stock = ?, " +
                         "price = ? " +
                     "WHERE code = ?";        
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {            
            ps.setString(1, i.getMake());
            ps.setString(2, i.getModel());
            ps.setInt(3, i.getStock());
            ps.setDouble(4, i.getPrice());
            ps.setString(5, i.getCode());
            ps.executeUpdate();
            return true;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        }
    }
    
    public boolean updateSales(Sales s)
    {
        String sql = "UPDATE Sales SET " +
                         "code = ?, " +
                         "employeeName = ?, " +
                         "saleDate = ?, " +
                         "lease = ? " +
                     "WHERE transactionNum = ?";        
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {            
            ps.setString(1, s.getCode());
            ps.setString(2, s.getEmployeeName());
            ps.setString(3, s.getSaleDate());
            ps.setBoolean(4, s.isLease());
            ps.setString(5, s.getTransactionNum());
            ps.executeUpdate();
            return true;
        }
        catch(SQLException e)
        {
            System.err.println(e);
            return false;
        }
    }
    
    public boolean updateEmployees(Employees e)
    {
        String sql = "UPDATE Employees SET " +
                         "phone = ?, " +
                         "email = ?, " +
                         "department = ?, " +
                         "salary = ? " +
                     "WHERE employeeName = ?";        
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql))
        {            
            ps.setString(1, e.getPhone());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getDepartment());
            ps.setDouble(4, e.getSalary());
            ps.setString(5, e.getEmployeeName());
            ps.executeUpdate();
            return true;
        }
        catch(SQLException whoops)
        {
            System.err.println(whoops);
            return false;
        }
    }
}
