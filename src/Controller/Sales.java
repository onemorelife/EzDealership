
package Controller;

/**
 *
 * @author Badruddoza Khan
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

    //Accessors 
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
