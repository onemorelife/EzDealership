package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB 
{
    public static void checkAndCreate()
    {
        Connection connection = null;
        String DBURL = "jdbc:derby:database/DealershipDB;";
        try
        {
            connection = DriverManager.getConnection(DBURL);
        }
        catch(SQLException e)
        {
            makeDB();
        }
    }
    
    private static void makeDB()
    {
        Connection connection = null;
        String sql = "";
		int[] result;
        String DBURL = "jdbc:derby:database/DealershipDB;create=true;";
        try
        {
            connection = DriverManager.getConnection(DBURL);
            Statement st = connection.createStatement();
                /*to drop tables
			try
			{
				st.execute("DROP TABLE Inventory");
			} catch (SQLSyntaxErrorException e)
			{}
			try
			{
				st.execute("DROP TABLE Sales");
			} catch (SQLSyntaxErrorException e)
			{}
			try
			{
				st.execute("DROP TABLE Employees");
			} catch (SQLSyntaxErrorException e)
			{}
                   */     
            //create inventory table 
            sql = "CREATE TABLE Inventory (make VARCHAR(20), model VARCHAR(20), "
                    + " stock INT, price DOUBLE, code VARCHAR(4))";
			st.addBatch(sql);
			
            //add rows to inventory tables
            sql = "INSERT INTO Inventory VALUES ('Toyota', 'RAV4', 7, 26320, 'TRAV'), "
                    + "('Tesla', 'Model X', 5, 108462, 'TSLX'), "
                    + "('Nissan', 'Sentra', 8, 19800, 'NISS')";
			st.addBatch(sql);
			
            //create employees table 
            sql = "CREATE TABLE Employees (employeeName VARCHAR(24), "
                    + "phone VARCHAR(10), email VARCHAR(20), "
                    + "department VARCHAR(20), salary DOUBLE)";
			st.addBatch(sql);
			
            //add rows to employees table 
            sql = "INSERT INTO Employees VALUES ('John Doe', '4332125678', 'jdoe@example.com', 'Sales', 32000), "
                    + "('Jane Doe', '3224785678', 'janedoe@example.com', 'Accounting', 32000), "
                    + "('Bob Smith', '6167894342', 'bsmith@example.com', 'Sales', 38000)";
			st.addBatch(sql);
			
            //create sales table
            sql = "CREATE TABLE Sales (code VARCHAR(4), transactionNum INT, "
                    + "employeeName VARCHAR(24), saleDate VARCHAR(8), lease BOOLEAN)";
			st.addBatch(sql);
			
            //add rows to sales table
            sql = "INSERT INTO Sales VALUES ('TSLX', 1, 'Bob Smith', '12182015', FALSE), "
                    + "('NISS', 2, 'John Doe', '03152016', FALSE)";
			st.addBatch(sql);
 
			result = st.executeBatch();
 
			connection.commit();
			connection.close();
        }
        catch (SQLException e)
        {
            System.out.print(e);
        }
            
    }
}
