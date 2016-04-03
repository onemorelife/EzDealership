package Controller;

import Model.DealershipDB;
import View.EditFrame;
import java.util.ArrayList;

//exists to pull data from the edit frame and us it to update the db
public class PullData 
{
    static public void updateDB(EditFrame ef)
    {
        DealershipDB db = new DealershipDB();
        String type = ef.getTitle();
        
        if(type.equalsIgnoreCase("Inventory"))
        {
            ArrayList<Inventory> invOld = db.getInventory();
            ArrayList<Inventory> invNew = new ArrayList<>();
        }
        else if(type.equalsIgnoreCase("Sales"))
        {
            
        }
        else if(type.equalsIgnoreCase("Employees"))
        {
            
        }
    }
}
