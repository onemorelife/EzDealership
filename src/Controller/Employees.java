package Controller;
/**
 * This class handles everything to do with the employee table
 * employeeName: is the name of the employee, It is all one string,
 *      but you enter the name in First name, Last name format.
 * phone: The employees phone number, entered as a sting
 *      all one number, no spaces/slashes between them.
 * email: Enter the email of the employee, entered in regular
 *      format all as one string.
 * department: This is the employees department, 
 *      all entered as one string.
 * salary: This is how much the employee makes in a year.
 *      It is entered as double.
 * 
 * Employees(): takes all of these in order, and sets them to
 *      the right values and then returns to the employees table.
 *  
 */
public class Employees implements Comparable
{
    private String employeeName; 
    private String phone; 
    private String email;
    private String department; 
    private double salary; 
    
    public Employees()
    {
        this("", "", "", "", 0.0);
    }
    
    public Employees(String employeeName, String phone, String email, 
                     String derpartment, double salary)
    {
        this.employeeName = employeeName;
        this.phone = phone;
        this.email = email;
        this.department = derpartment;
        this.salary = salary;
    }    

    //Accessors
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Object t) 
    {
        try
        {
            Employees emp = (Employees) t;
            if(emp.getEmployeeName().equalsIgnoreCase(this.getEmployeeName()))
                return 0;
            else
                return -1;
        }
        catch(Exception e)
        {
            return -1;
        }
    }
}
