import java.util.ArrayList;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Poss implements Serializable{
    String customer_name;
    String cashier_name;
    String branch = "colombo";
    ArrayList<String> item_list = new ArrayList<String>();
    int total_discount;
    ArrayList<String > items_names  = new ArrayList<String>();
    ArrayList<Integer> item_prices = new ArrayList<Integer>();
    ArrayList<Integer> item_sizes = new ArrayList<Integer>();
    int total_price = 0;



    // Constructor with parameters
    public Poss(String customer_name, String cashier_name) {
        this.customer_name = customer_name;
        this.cashier_name = cashier_name;
    }
    public void check_item_presence(int item_id) throws ItemCodeNotFound{
        if(item_id<0 || item_id>10){
            throw new ItemCodeNotFound("Item not found");
        }
    }
    public void print_bill() {
        System.out.println("=========================================");
        System.out.println("             INVOICE BILL               ");
        System.out.println("=========================================");
        System.out.printf("%-20s%-12s%-8s%-10s\n", "Item Name", "Unit Price", "Size", "Net Price");

        for (int i = 0; i < items_names.size(); i++) {
            String itemName = items_names.get(i);
            int itemPrice = item_prices.get(i);
            int itemSize = item_sizes.get(i);
            int net_price = item_sizes.get(i) * item_prices.get(i);
            total_price += net_price;

            // Print item details in the specified format
            System.out.printf("%-20s%-12d%-8d%-10d\n", itemName, itemPrice, itemSize, net_price);
        }

        System.out.println("=========================================");
        System.out.println("Total Price: " + total_price+"rs");
        System.out.println("Cashier Name: " + this.cashier_name);
        System.out.println("Branch: " + this.branch);
        System.out.println("Customer Name: " + this.customer_name);

        // Print current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println("Date and Time: " + formattedDateTime);
        System.out.println("=========================================");
    }
    public void add_item(int a){/***  Hard coded items list  ****/
        Grocery_Items item1 = new Grocery_Items("ITEM001", 10, 500, "2024-03-20", "2024-04-20", "Manufacturer A");
        Grocery_Items item2 = new Grocery_Items("ITEM002", 20, 750, "2024-03-21", "2024-04-21", "Manufacturer B");
        Grocery_Items item3 = new Grocery_Items("ITEM003", 15, 300, "2024-03-22", "2024-04-22", "Manufacturer C");
        Grocery_Items item4 = new Grocery_Items("ITEM004", 25, 600, "2024-03-23", "2024-04-23", "Manufacturer D");
        Grocery_Items item5 = new Grocery_Items("ITEM005", 30, 400, "2024-03-24", "2024-04-24", "Manufacturer E");
        Grocery_Items item6 = new Grocery_Items("ITEM006", 12, 550, "2024-03-25", "2024-04-25", "Manufacturer F");
        Grocery_Items item7 = new Grocery_Items("ITEM007", 18, 700, "2024-03-26", "2024-04-26", "Manufacturer G");
        Grocery_Items item8 = new Grocery_Items("ITEM008", 22, 450, "2024-03-27", "2024-04-27", "Manufacturer H");
        Grocery_Items item9 = new Grocery_Items("ITEM009", 28, 800, "2024-03-28", "2024-04-28", "Manufacturer I");
        Grocery_Items item10 = new Grocery_Items("ITEM010", 35, 350, "2024-03-29", "2024-04-29", "Manufacturer J");

        switch (a){
            case 1:
                item_list.add(item1.item_code);
                items_names.add(item1.item_code);
                item_prices.add(item1.price);
                item_sizes.add(item1.size);
                break;
            case 2:
                item_list.add(item2.item_code);
                items_names.add(item2.item_code);
                item_prices.add(item2.price);
                item_sizes.add(item2.size);
                break;
            case 3:
                item_list.add(item3.item_code);
                items_names.add(item3.item_code);
                item_prices.add(item3.price);
                item_sizes.add(item3.size);
                break;
            case 4:
                item_list.add(item4.item_code);
                items_names.add(item4.item_code);
                item_prices.add(item4.price);
                item_sizes.add(item4.size);
                break;
            case 5:
                item_list.add(item5.item_code);
                items_names.add(item5.item_code);
                item_prices.add(item5.price);
                item_sizes.add(item5.size);
                break;
            case 6:
                item_list.add(item6.item_code);
                items_names.add(item6.item_code);
                item_prices.add(item6.price);
                item_sizes.add(item6.size);
                break;
            case 7:
                item_list.add(item7.item_code);
                items_names.add(item7.item_code);
                item_prices.add(item7.price);
                item_sizes.add(item7.size);
                break;
            case 8:
                item_list.add(item8.item_code);
                items_names.add(item8.item_code);
                item_prices.add(item8.price);
                item_sizes.add(item8.size);
                break;
            case 9:
                item_list.add(item9.item_code);
                items_names.add(item9.item_code);
                item_prices.add(item9.price);
                item_sizes.add(item9.size);
                break;
            case 10:
                item_list.add(item10.item_code);
                items_names.add(item10.item_code);
                item_prices.add(item10.price);
                item_sizes.add(item10.size);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    public Grocery_Items getItemDetails() {
        int check = 0;
        while(check == 0){
        try {
            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);
            int item_code = br.read();
            check_item_presence(item_code);
            Grocery_Items item = null;
            // Fetch item details from the database
            br.close();
            r.close();
            check = 1;
            return item;
        }

        catch (ItemCodeNotFound e) {
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace();
            // Handle IO exception
        }



           }
        return  null;}
}