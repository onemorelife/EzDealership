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
        String type = ef.getTableTitle();
        ArrayList<ArrayList<String>> table = ef.getInfo();
        
        if(type.equalsIgnoreCase("Inventory"))
        {
            ArrayList<Inventory> invOld = db.getInventory();
            ArrayList<Inventory> invNew = new ArrayList<>();
            for(ArrayList<String> row : table)
            {
                if(row != null) //row is null if it was empty
                {
                    Inventory object = new Inventory(row.get(0), row.get(1), Integer.parseInt(row.get(2)), Double.parseDouble(row.get(3)), row.get(4));
                    invNew.add(object);
                }
            }
            
            //check if an object was deleted from the new inventory
            for(Inventory oldI : invOld)
            {
                boolean existInNew = false;
                for(Inventory newI : invNew)
                {
                    if(oldI == newI)
                    {
                        existInNew = true;
                    }
                }
                if(!existInNew)
                {
                    db.deleteInventory(oldI);
                }
            }
            
            //check if the new object exists in the db already
            // if it doesnt, then add it
            for(Inventory newI : invNew)
            {
                boolean existInOld = false;
                for(Inventory oldI : invOld)
                {
                    if(oldI == newI)
                    {
                        existInOld = true;
                    }
                }
                if(!existInOld)
                {
                    db.addInventory(newI);
                }
            }
        }
        else if(type.equalsIgnoreCase("Sales"))
        {
            ArrayList<Sales> slsOld = db.getSales();
            ArrayList<Sales> slsNew = new ArrayList<>();
            for(ArrayList<String> row : table)
            {
                if(row != null) //row is null if it was empty
                {
                Sales object = new Sales(row.get(0), row.get(1), row.get(2), row.get(3), row.get(4).equalsIgnoreCase("true"));
                slsNew.add(object);
                }
            }
            
            //check if an object was deleted from the new inventory
            for(Sales oldS : slsOld)
            {
                boolean existInNew = false;
                for(Sales newS : slsNew)
                {
                    if(oldS == newS)
                    {
                        existInNew = true;
                    }
                }
                if(!existInNew)
                {
                    db.deleteSales(oldS);
                }
            }
            
            //check if the new object exists in the db already
            // if it doesnt, then add it
            for(Sales newS : slsNew)
            {
                boolean existInOld = false;
                for(Sales oldS : slsOld)
                {
                    if(oldS == newS)
                    {
                        existInOld = true;
                    }
                }
                if(!existInOld)
                {
                    db.addSales(newS);
                }
            }
        }
        else if(type.equalsIgnoreCase("Employees"))
        {
            ArrayList<Employees> empOld = db.getEmployees();
            ArrayList<Employees> empNew = new ArrayList<>();
            for(ArrayList<String> row : table)
            {
                if(row != null) //row is null if it was empty
                {
                Employees object = new Employees(row.get(0), row.get(1), row.get(2), row.get(3), Double.parseDouble(row.get(4)));
                empNew.add(object);
                }
            }
            
            //check if an object was deleted from the new inventory
            for(Employees oldE : empOld)
            {
                boolean existInNew = false;
                for(Employees newE : empNew)
                {
                    if(oldE == newE)
                    {
                        existInNew = true;
                    }
                }
                if(!existInNew)
                {
                    db.deleteEmployee(oldE);
                }
            }
            
            //check if the new object exists in the db already
            // if it doesnt, then add it
            for(Employees newE : empNew)
            {
                boolean existInOld = false;
                for(Employees oldE : empOld)
                {
                    if(oldE == newE)
                    {
                        existInOld = true;
                    }
                }
                if(!existInOld)
                {
                    db.addEmployee(newE);
                }
            }
        }
    }
}
