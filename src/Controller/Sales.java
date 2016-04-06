package Controller;

/**
 * This class handles everything for the Sales table.
 * This class takes five values and arranges them onto 
 *      the Sales table.
 * code: This takes the inventory code to find what vehicle
 *      the customer is trying to buy.
 * transactionNum: This is to keep a record of who bought what
 *      car when and who sold it to them, recorded as a string.
 * employeeName: The full name of the employee who completed
 *      this transaction taken as one string.
 * saleDate: This takes the date as a string.
 * lease: This is a boolean to see if the vehicle is going 
 *      to be on a lease.
 * 
 */

public class Sales 
{
    private String code; 
    private String transactionNum; 
    private String employeeName;
    private String saleDate; 
    private boolean lease; 
    
    public Sales()
    {
        this("", "", "", "", false);
    }
    
    public Sales(String code, String transactionNum, String employeeName, 
                 String saleDate, boolean lease)
    {
        this.code = code;
        this.transactionNum = transactionNum;
        this.employeeName = employeeName;
        this.saleDate = saleDate;
        this.lease = lease;
    }        

    //Accessors for the sales class
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(String transactionNum) {
        this.transactionNum = transactionNum;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public boolean isLease() {
        return lease;
    }

    public void setLease(boolean lease) {
        this.lease = lease;
    }
}
