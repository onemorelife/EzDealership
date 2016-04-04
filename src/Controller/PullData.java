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
        ArrayList<ArrayList<String>> table = ef.getInfo();
        
        if(type.equalsIgnoreCase("Inventory"))
        {
            ArrayList<Inventory> invOld = db.getInventory();
            ArrayList<Inventory> invNew = new ArrayList<>();
            for(ArrayList<String> row : table)
            {
                Inventory object = new Inventory(row.get(0), row.get(1), Integer.parseInt(row.get(2)), Double.parseDouble(row.get(3)), row.get(4));
                invNew.add(object);
            }
            for(int index = 0; index < invNew.size(); ++index)
            {
                if(index < invOld.size()) //only compare already existing items
                {
                    if(invNew.get(index) != invOld.get(index)) //need to overwrite compareto for all table-classes
                    {
                        db.updateInventory(invNew.get(index));
                    }
                }
                else
                {
                    db.addInventory(invNew.get(index)); //add any new items
                }
            }
        }
        else if(type.equalsIgnoreCase("Sales"))
        {
            
        }
        else if(type.equalsIgnoreCase("Employees"))
        {
            
        }
    }
}
