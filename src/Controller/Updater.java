package Controller;

import Model.DealershipDB;
import View.EditFrame;
import View.MainFrame;
import java.util.ArrayList;

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
                String[] columns = {"Name","Phone #","Email","Department","Salary"};
                ef.updateColumnNames(columns);
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
            case "Invetory":
                break;
            case "Sales":
                break;
        }
    }
}
