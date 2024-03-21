import java.io.*;
public class Grocery_Items implements Serializable{
    String item_code;
    int price;
    int size;
    String manufacture_date;
    String expiry_date;
    String manufacture_name;

    // Constructor
    public Grocery_Items(String item_code, int price, int size, String manufacture_date, String expiry_date, String manufacture_name) {
        this.item_code = item_code;
        this.price = price;
        this.size = size;
        this.manufacture_date = manufacture_date;
        this.expiry_date = expiry_date;
        this.manufacture_name = manufacture_name;
    }


}

