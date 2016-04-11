/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
package Controller;
 
 
 
import View.EditFrame;
import View.MainFrame;
import View.SearchFrame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;
 
 
/**
 * This is the main class for this project.
 * This tells the other classes when to be active
 * It also sets up how you can change between 
 *      said classes and how everything 
 *      interacts with everything else.
 * componentHidden: This sets the main window invisible
 *      while the none main windows are in use, once the "Exit"
 *      button is it, the program reopens the main window 
 *      without closing the program.
 * 
 */
public class EzDealership {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {   
        makeDB();
        ArrayList<String> tableNames = new ArrayList<>();
        tableNames.add("Employees");
        tableNames.add("Inventory");
        tableNames.add("Sales");
        /* Set the Nimbus look and feel
         *<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 
        
        EditFrame ef = new EditFrame();
        SearchFrame sf = new SearchFrame();
        MainFrame mf = new MainFrame(ef, sf);
        mf.updateCbxTableList(tableNames);
        
        //Allows you to swap windows without closing the program.
        sf.addComponentListener(new ComponentAdapter() 
        {
            public void componentHidden(ComponentEvent e) 
            {
                mf.setVisible(true);
            }
            
        });
        
        ef.addComponentListener(new ComponentAdapter() 
        {
            public void componentHidden(ComponentEvent e) 
            {
                mf.setVisible(true);
            }
        });
    }  
    
    public static void makeDB()
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