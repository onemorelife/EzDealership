
package Controller;

/**
 *
 * @author Badruddoza Khan
 */
public class Inventory 
{
    private String model; 
    private String make; 
    private int stock;
    private double price; 
    private String code; 
    
    public Inventory()
    {
        this("", "", 0, 0.0, "");
    }
    
    public Inventory(String model, String make, int stock, double price, String code)
    {
        this.model = model;
        this.make = make;
        this.stock = stock;
        this.price = price;
        this.code = code;
    }
    
    //Accessors 
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }    
}
