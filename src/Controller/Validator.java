package Controller;

import View.EditFrame;
import javax.swing.JOptionPane;

public class Validator {
    public static boolean validate(EditFrame ef)
    {
        return validateDataTypes(ef) && validateDataTypes(ef);
    }
    
    private static boolean validateFieldLength(EditFrame ef)
    {
        boolean valid = true;
        String valType = ef.getTableTitle(); 
        
        switch (valType)
        {
            case "Employees":
                int[] empColumnsToValidate = {0,1,2,3};
                for(int index = 0; index < ef.getRowCount(); ++index)
                {
                    for(int column : empColumnsToValidate)
                    {
                        String test = ((String)ef.getValueAt(index, column));
                        if(test != null)
                        {
                            if(column == 0 && test.length() > 24)
                            {
                                String message = "The value located in the ";
                                message += Integer.toString(index + 1);
                                switch ((index % 10) + 1)
                                {
                                    case 1:
                                        message += "st";
                                        break;
                                    case 2:
                                        message += "nd";
                                        break;
                                    case 3:
                                        message += "rd";
                                        break;
                                    default:
                                        message += "th";
                                        break;
                                }
                                message += " row, under the " + ef.getColumnName(column) 
                                        + " column must be shorter than 24 characters.";
                                valid = false;
                                JOptionPane.showMessageDialog(ef, message);
                            }
                            
                            else if(column == 1 && test.length() != 10)
                            {
                                String message = "The value located in the ";
                                message += Integer.toString(index + 1);
                                switch ((index % 10) + 1)
                                {
                                    case 1:
                                        message += "st";
                                        break;
                                    case 2:
                                        message += "nd";
                                        break;
                                    case 3:
                                        message += "rd";
                                        break;
                                    default:
                                        message += "th";
                                        break;
                                }
                                message += " row, under the " + ef.getColumnName(column) 
                                        + " column must be a 10 digit number.";
                                valid = false;
                                JOptionPane.showMessageDialog(ef, message);
                            }
                            
                            else if((column == 2 || column == 3) && test.length() > 20)
                            {
                                String message = "The value located in the ";
                                message += Integer.toString(index + 1);
                                switch ((index % 10) + 1)
                                {
                                    case 1:
                                        message += "st";
                                        break;
                                    case 2:
                                        message += "nd";
                                        break;
                                    case 3:
                                        message += "rd";
                                        break;
                                    default:
                                        message += "th";
                                        break;
                                }
                                message += " row, under the " + ef.getColumnName(column) 
                                        + " column must be shorter than 20 characters.";
                                valid = false;
                                JOptionPane.showMessageDialog(ef, message);
                            }
                        }
                    }
                }
                break;
            case "Inventory":
                int[] invColumnsToValidate = {0,1,4};
                for(int index = 0; index < ef.getRowCount(); ++index)
                {
                    for(int column : invColumnsToValidate)
                    {
                        String test = ((String)ef.getValueAt(index, column));
                        if(test != null)
                        {
                            if((column == 0 || column == 1) && test.length() > 20)
                            {
                                String message = "The value located in the ";
                                message += Integer.toString(index + 1);
                                switch ((index % 10) + 1)
                                {
                                    case 1:
                                        message += "st";
                                        break;
                                    case 2:
                                        message += "nd";
                                        break;
                                    case 3:
                                        message += "rd";
                                        break;
                                    default:
                                        message += "th";
                                        break;
                                }
                                message += " row, under the " + ef.getColumnName(column) 
                                        + " column must be shorter than 20 characters.";
                                valid = false;
                                JOptionPane.showMessageDialog(ef, message);
                            }
                            if( column == 4 && test.length() != 4)
                            {
                                String message = "The value located in the ";
                                message += Integer.toString(index + 1);
                                switch ((index % 10) + 1)
                                {
                                    case 1:
                                        message += "st";
                                        break;
                                    case 2:
                                        message += "nd";
                                        break;
                                    case 3:
                                        message += "rd";
                                        break;
                                    default:
                                        message += "th";
                                        break;
                                }
                                message += " row, under the " + ef.getColumnName(column) 
                                        + " column must contain exactly 4 characters.";
                                valid = false;
                                JOptionPane.showMessageDialog(ef, message);
                            }
                        }
                    }
                }
                break;
            case "Sales":
                int[] slsColumnsToValidate = {0,2,3};
                for(int index = 0; index < ef.getRowCount(); ++index)
                {
                    for(int column : slsColumnsToValidate)
                    {
                        String test = ((String)ef.getValueAt(index, column));
                        if(test != null)
                        {
                            if(column == 0 && test.length() != 4)
                            {
                                String message = "The value located in the ";
                                message += Integer.toString(index + 1);
                                switch ((index % 10) + 1)
                                {
                                    case 1:
                                        message += "st";
                                        break;
                                    case 2:
                                        message += "nd";
                                        break;
                                    case 3:
                                        message += "rd";
                                        break;
                                    default:
                                        message += "th";
                                        break;
                                }
                                message += " row, under the " + ef.getColumnName(column) 
                                        + " column must contain exactly 4 characters.";
                                valid = false;
                                JOptionPane.showMessageDialog(ef, message);
                            }
                            
                            if(column == 2 && test.length() > 24)
                            {
                                String message = "The value located in the ";
                                message += Integer.toString(index + 1);
                                switch ((index % 10) + 1)
                                {
                                    case 1:
                                        message += "st";
                                        break;
                                    case 2:
                                        message += "nd";
                                        break;
                                    case 3:
                                        message += "rd";
                                        break;
                                    default:
                                        message += "th";
                                        break;
                                }
                                message += " row, under the " + ef.getColumnName(column) 
                                        + " column must be shorter than 24 characters.";
                                valid = false;
                                JOptionPane.showMessageDialog(ef, message);
                            }
                            
                            if(column == 3 && test.length() != 8)
                            {
                                String message = "The value located in the ";
                                message += Integer.toString(index + 1);
                                switch ((index % 10) + 1)
                                {
                                    case 1:
                                        message += "st";
                                        break;
                                    case 2:
                                        message += "nd";
                                        break;
                                    case 3:
                                        message += "rd";
                                        break;
                                    default:
                                        message += "th";
                                        break;
                                }
                                message += " row, under the " + ef.getColumnName(column) 
                                        + " column must contain only 8 digits, (MM/DD/YY).";
                                valid = false;
                                JOptionPane.showMessageDialog(ef, message);
                            }
                        }
                    }
                }
                break;
        }
        return valid;
    }
    
    private static boolean validateDataTypes(EditFrame ef)
    {
        boolean valid = true;
        String valType = ef.getTableTitle();
        switch (valType)
        {
            case "Employees":
                int[] empColumnsToValidate = {1,4};
                for(int index = 0; index < ef.getRowCount(); ++index)
                {
                    for(int column : empColumnsToValidate)
                    {
                        String test = ((String)ef.getValueAt(index, column));
                        if(test != null)
                        {
                            for(char x : test.toCharArray())
                            {
                                if(x != '$' && x != ',' && x != '.' && (x < '0' || x > '9')) //if x is not one of the format charracters, or a number, display an error
                                {
                                    String message = "The value located in the ";
                                    message += Integer.toString(index + 1);
                                    switch ((index % 10) + 1)
                                    {
                                        case 1:
                                            message += "st";
                                            break;
                                        case 2:
                                            message += "nd";
                                            break;
                                        case 3:
                                            message += "rd";
                                            break;
                                        default:
                                            message += "th";
                                            break;
                                    }
                                    message += " row, under the " + ef.getColumnName(column) 
                                            + " column can only contain a number.";
                                    valid = false;
                                    JOptionPane.showMessageDialog(ef, message);
                                }
                            }
                        }
                    }
                }
                break;
            case "Inventory":
                int[] invColumnsToValidate = {2,3};
                for(int index = 0; index < ef.getRowCount(); ++index)
                {
                    for(int column : invColumnsToValidate)
                    {
                        String test = ((String)ef.getValueAt(index, column));
                        if(test != null)
                        {
                            for(char x : test.toCharArray())
                            {
                                if(x != '$' && x != ',' && x != '.' && (x < '0' || x > '9'))
                                {
                                    String message = "The value located in the ";
                                    message += Integer.toString(index + 1);
                                    switch ((index % 10) + 1)
                                    {
                                        case 1:
                                            message += "st";
                                            break;
                                        case 2:
                                            message += "nd";
                                            break;
                                        case 3:
                                            message += "rd";
                                            break;
                                        default:
                                            message += "th";
                                            break;
                                    }
                                    message += " row, under the " + ef.getColumnName(column) 
                                            + " column can only contain a number.";
                                    valid = false;
                                    JOptionPane.showMessageDialog(ef, message);
                                }
                            }
                        }
                    }
                }
                break;
            case "Sales":
                int slsColumnsToValidate = 4;
                for(int index = 0; index < ef.getRowCount(); ++index)
                {
                    String test = (String)ef.getValueAt(index, slsColumnsToValidate);
                    if(!test.equalsIgnoreCase("True") && !test.equalsIgnoreCase("False"))
                    {
                        String message = "The value located in the ";
                        message += Integer.toString(index + 1);
                        switch ((index % 10) + 1)
                        {
                            case 1:
                                message += "st";
                                break;
                            case 2:
                                message += "nd";
                                break;
                            case 3:
                                message += "rd";
                                break;
                            default:
                                message += "th";
                                break;
                        }
                        message += " row, under the " + ef.getColumnName(slsColumnsToValidate) 
                                + " column can only contain True or False.";
                        valid = false;
                        JOptionPane.showMessageDialog(ef, message);
                    }
                }
                break;
        }
        return valid;
    }
}
