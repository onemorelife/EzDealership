package Controller;

import Model.DealershipDB;
import View.EditFrame;
import View.MainFrame;
import java.util.ArrayList;
import Controller.Inventory;

//exists to update the data on the tables of the GUI
// will be run on the event listenter for when a window is set to visible

public class Updater 
{
    public static void updateEditFrame(MainFrame mf, EditFrame ef)
    {
        DealershipDB db = new DealershipDB();
        String selected = mf.getSelected();
        switch (selected) {
            case "Employees":
                ef.updateTitle("Employee");
                String[] columns1 = {"Name","Phone #","Email","Department","Salary"};
                ef.updateColumnNames(columns1);
                //cant test if this works without database setup and existing
                /*
                ArrayList<Employees> emp = db.getEmployees();
                for(Employees x : emp)
                {
                    String[] info = {x.getEmployeeName(),
                                     x.getPhone(),
                                     x.getEmail(),
                                     x.getDepartment(),
                                     Double.toString(x.getSalary())};//change salary to use currancy format later
                    ef.addRow(info);
                }*/
                break;
            case "Inventory":
                ef.updateTitle("Inventory");
                String[] columns2 = {"Model","Make","Stock","Price","Code"};
                ef.updateColumnNames(columns2);
                /*
                ArrayList<Inventory> inv = db.getInventory();
                for(Inventory x : inv)
                {
                    String[] info = {x.getModel(),
                                     x.getMake(),
                                     Double.toString(x.getStock()),
                                     Double.toString(x.getPrice()),
                                     x.getCode()};
                    ef.addRow(info);
                }*/
                break;
            case "Sales":
                break;
        }
    }
}
