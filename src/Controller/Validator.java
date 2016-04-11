package Controller;
 
import View.EditFrame;
import javax.swing.JOptionPane;
 
public class Validator {
    public static boolean validate(EditFrame ef)
    {
        return validateDataTypes(ef) && validateDataTypes(ef);
    }
	
	public static boolean isNumber(String str)  
	{  
	  try  
	  {  
		double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
		return false;  
	  }  
	  return true;  
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
				for(int row = 0; row < ef.getRowCount(); ++row)
				{
					// Column 0 must be 24 chars max
					String value = (String)ef.getValueAt(row, 0);
					if (value == null) continue;
					if (value.length() > 24)
					{
						JOptionPane.showMessageDialog(ef, "Column 1 of row " +
							(row + 1) + " can only contain a string with 24 characters!");
						valid = false;
						break;
					}
					
					// Column 1 must be 10 chars max
					value = (String)ef.getValueAt(row, 1);
					if (value == null) continue;
					if (value.length() > 10)
					{
						JOptionPane.showMessageDialog(ef, "Column 2 of row " +
							(row + 1) + " can only contain a string with 10 characters!");
						valid = false;
						break;
					}
					
					// Column 2 must be 20 chars max
					value = (String)ef.getValueAt(row, 2);
					if (value == null) continue;
					if (value.length() > 20)
					{
						JOptionPane.showMessageDialog(ef, "Column 3 of row " +
							(row + 1) + " can only contain a string with 20 characters!");
						valid = false;
						break;
					}
					
					// Column 3 must be 20 chars max
					value = (String)ef.getValueAt(row, 3);
					if (value == null) continue;
					if (value.length() > 20)
					{
						JOptionPane.showMessageDialog(ef, "Column 4 of row " +
							(row + 1) + " can only contain a string with 20 characters!");
						valid = false;
						break;
					}
					
					// Column 4 must be a number AND must disregard the $ symbol prefix
					value = (String)ef.getValueAt(row, 4);
					int i = 0;
					for (int index = 0; index < value.length(); index++)
					{
						char c = value.charAt(index);
						if (c == '$' && index != 0)
						{
							valid = false;
							break;
						}
						
						if (!Character.isDigit(c) && c != ',' && c != '.' && c != '$')
						{
							valid = false;
							break;
						}
					}
					if (!valid)
					{
						JOptionPane.showMessageDialog(ef, "Column 5 of row " +
							(row + 1) + " can only contain a number!");
						break;
					}
				}
				break;
/*
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
*/
            case "Inventory":
				for(int row = 0; row < ef.getRowCount(); ++row)
				{
					// Column 0 must be 20 chars max
					String value = (String)ef.getValueAt(row, 0);
					if (value == null) continue;
					if (value.length() > 20)
					{
						JOptionPane.showMessageDialog(ef, "Column 1 of row " +
							(row + 1) + " can only contain a string with 20 characters!");
						valid = false;
						break;
					}
					
					// Column 1 must be 20 chars max
					value = (String)ef.getValueAt(row, 1);
					if (value == null) continue;
					if (value.length() > 20)
					{
						JOptionPane.showMessageDialog(ef, "Column 2 of row " +
							(row + 1) + " can only contain a string with 20 characters!");
						valid = false;
						break;
					}
					
					// Column 2 must be a number
					value = (String)ef.getValueAt(row, 2);
					if (!isNumber(value))
					{
						JOptionPane.showMessageDialog(ef, "Column 3 of row " +
							(row + 1) + " can only contain a number!");
						valid = false;
						break;
					}
					
					// Column 3 must be a money value
					value = (String)ef.getValueAt(row, 3);
					int i = 0;
					for (int index = 0; index < value.length(); index++)
					{
						char c = value.charAt(index);
						if (c == '$' && index != 0)
						{
							valid = false;
							break;
						}
						
						if (!Character.isDigit(c) && c != ',' && c != '.' && c != '$')
						{
							valid = false;
							break;
						}
					}
					if (!valid)
					{
						JOptionPane.showMessageDialog(ef, "Column 4 of row " +
							(row + 1) + " can only contain a number!");
						break;
					}
										
					// Column 4 must be 4 chars max
					value = (String)ef.getValueAt(row, 4);
					if (value.length() > 4)
					{
						JOptionPane.showMessageDialog(ef, "Column 5 of row " +
							(row + 1) + " can only contain a string with 4 characters!");
						valid = false;
						break;
					}
				}
				break;
/*
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
*/
            case "Sales":
				for(int row = 0; row < ef.getRowCount(); ++row)
				{
					// Column 0 must be 4 chars max
					String value = (String)ef.getValueAt(row, 0);
					if (value == null) continue;
					if (value.length() > 4)
					{
						JOptionPane.showMessageDialog(ef, "Column 1 of row " +
							(row + 1) + " can only contain a string with 4 characters!");
						valid = false;
						break;
					}
					
					// Column 1 must be a number
					value = (String)ef.getValueAt(row, 1);
					if (!isNumber(value))
					{
						JOptionPane.showMessageDialog(ef, "Column 2 of row " +
							(row + 1) + " can only contain a number!");
						valid = false;
						break;
					}
					
					// Column 2 must be 24 chars max
					value = (String)ef.getValueAt(row, 2);
					if (value.length() > 24)
					{
						JOptionPane.showMessageDialog(ef, "Column 3 of row " +
							(row + 1) + " can only contain a string with 24 characters!");
						valid = false;
						break;
					}
					
					// Column 3 must be 8 chars max
					value = (String)ef.getValueAt(row, 3);
					if (value.length() > 8)
					{
						JOptionPane.showMessageDialog(ef, "Column 4 of row " +
							(row + 1) + " can only contain a string with 8 characters!");
						valid = false;
						break;
					}
					
					// Column 4 must be a boolean
					value = (String)ef.getValueAt(row, 4);
					if(!value.equalsIgnoreCase("true") && !value.equalsIgnoreCase("false"))
					{
						JOptionPane.showMessageDialog(ef, "Column 5 of row " +
							(row + 1) + " must be either True or False!");
						valid = false;
						break;
					}	
				}
				break;
/*
                int slsColumnsToValidate = 4;
                for(int index = 0; index < ef.getRowCount(); ++index)
                {
					String test = (String)ef.getValueAt(index, slsColumnsToValidate);
                    if(!test.equalsIgnoreCase("true") || !test.equalsIgnoreCase("false"))
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
			*/
        }
        return valid;
    }
}