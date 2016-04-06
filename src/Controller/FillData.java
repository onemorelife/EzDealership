package Controller;

import Model.DealershipDB;
import View.EditFrame;
import View.MainFrame;
import View.SearchFrame;
import java.util.ArrayList;
import java.text.NumberFormat;

//exists to update the data on the tables of the GUI

public class FillData 
{
    public static void updateEditFrame(MainFrame mf, EditFrame ef)
    {
        DealershipDB db = new DealershipDB();
        String selected = mf.getSelected();
        switch (selected) {
            case "Employees":
                ef.updateTitle("Employees");
                String[] columns1 = {"Name","Phone #","Email","Department","Salary"};
                ef.updateColumnNames(columns1);
                ArrayList<Employees> emp = db.getEmployees();
                for(Employees x : emp)
                {
                    String[] info = {x.getEmployeeName(),
                                     x.getPhone(),
                                     x.getEmail(),
                                     x.getDepartment(),
                                     NumberFormat.getCurrencyInstance().format(x.getSalary())};
                    ef.addRow(info);
                }
                break;
            case "Inventory":
                ef.updateTitle("Inventory");
                String[] columns2 = {"Model","Make","Stock","Price","Code"};
                ef.updateColumnNames(columns2);
                
                ArrayList<Inventory> inv = db.getInventory();
                for(Inventory x : inv)
                {
                    String[] info = {x.getModel(),
                                     x.getMake(),
                                     Integer.toString(x.getStock()),
                                     NumberFormat.getCurrencyInstance().format(x.getPrice()),
                                     x.getCode()};
                    ef.addRow(info);
                }
                break;
            case "Sales":
                ef.updateTitle("Sales");
                String[] columns3 = {"Code","Transaction #","Employee Name","Sale Date","Lease"};
                ef.updateColumnNames(columns3);
                
                ArrayList<Sales> sls = db.getSales();
                for(Sales x : sls)
                {
                    String[] info = {x.getCode(),
                                     x.getTransactionNum(),
                                     x.getEmployeeName(),
                                     x.getSaleDate(),
                                     (x.isLease() ? "True" : "False")}; //possibly change to yes/no?
                    ef.addRow(info);
                }
                break;
        }
    }
    
    public static void updateSearchFrame(MainFrame mf, SearchFrame sf)
    {
        DealershipDB db = new DealershipDB();
        String selected = mf.getSelected();
        switch (selected) {
            case "Employees":
                sf.updateTitle("Employees");
                sf.updateCondition("Employee Name");
                String[] columns1 = {"Phone #","Email","Department","Salary"};
                sf.updateColumnNames(columns1);
                break;
            case "Inventory":
                sf.updateTitle("Inventory");
                sf.updateCondition("Code");
                String[] columns2 = {"Model","Make","Stock","Price"};
                sf.updateColumnNames(columns2);
                break;
            case "Sales":
                sf.updateTitle("Sales");
                sf.updateCondition("Transaction Number");
                String[] columns3 = {"Code","Employee Name","Sale Date","Lease"};
                sf.updateColumnNames(columns3);
                break;
        }
    }
    
    public static void searchDB(SearchFrame sf)
    {
        sf.clearSearch();
        DealershipDB db = new DealershipDB();
        String condition = sf.getCondition();
        String title = sf.getLabel();
        switch (title)
        {
            case "Employees":
                Employees emp = db.getEmployees(condition);
                String[] info = {emp.getPhone(),
                                 emp.getEmail(),
                                 emp.getDepartment(),
                                 NumberFormat.getCurrencyInstance().format(emp.getSalary())};
                sf.addRow(info);
                break;
            case "Inventory":
                Inventory inv = db.getInventory(condition);
                String[] info2 = {inv.getModel(),
                                 inv.getMake(),
                                 Double.toString(inv.getStock()),
                                 NumberFormat.getCurrencyInstance().format(inv.getPrice())};
                sf.addRow(info2);
                break;
            case "Sales":
                Sales sls = db.getSales(condition);
                String[] info3 = {sls.getCode(),
                                 sls.getEmployeeName(),
                                 sls.getSaleDate(),
                                 (sls.isLease() ? "True" : "False")};
                sf.addRow(info3);
                break;
        }
    }
}
