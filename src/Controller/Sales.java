/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author azure
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

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the quantity
     */
    public String getTransactionNum() {
        return transactionNum;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setTransactionNum(String transactionNum) {
        this.transactionNum = transactionNum;
    }

    /**
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @param employeeName the employeeName to set
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @return the saleDate
     */
    public String getSaleDate() {
        return saleDate;
    }

    /**
     * @param saleDate the saleDate to set
     */
    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    /**
     * @return the lease
     */
    public boolean isLease() {
        return lease;
    }

    /**
     * @param lease the lease to set
     */
    public void setLease(boolean lease) {
        this.lease = lease;
    }
}
