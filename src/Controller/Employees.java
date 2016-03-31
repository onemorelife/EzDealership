
package Controller;

/**
 *
 * @author azure
 */
public class Employees 
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
}
