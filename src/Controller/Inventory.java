package Controller;

/**
 * This class handles everything for the Inventory table.
 * This class takes five input values and arrange them nicely
 *      on to the table.
 * model: is the name of the model of the vehicle as one string.
 * make: this is the make of the model, also taken as a string.
 * stock: is how much of that vehicle we have at the moment, and
 *      are able to sell at that moment.
 * price: This is the price for one vehicle.
 * code: This code is a short way to get all of the information
 *      at once from this four letter string.
 * Inventory(): takes all of these in order and returns them
 *      to the Inventory table.
 * 
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
    
    //Accessors for inventory class
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
