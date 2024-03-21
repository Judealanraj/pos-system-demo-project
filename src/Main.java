import java.util.*;
import java.io.*;
public class Main implements Serializable {     //implements use to serialize this class
    public static void billing(){               // function to do continuous billing with a new customer
        Scanner input = new Scanner(System.in);
        String customer_name;
        String cashier_name;
        System.out.println("****************************************");
        System.out.println("*          Enter Customer Name         *");
        System.out.println("****************************************");
        System.out.print("Enter name: ");                                          // Get user input for customer name
        customer_name = input.nextLine();
        System.out.println("****************************************");
        System.out.println("*          Enter Cashier Name         *");
        System.out.println("****************************************");
        cashier_name = input.nextLine();                                         // Get user input for cashier name
        Poss customer = new Poss(customer_name,cashier_name);                    //create a pos object to a customer
        int checker = 1;                                                         //variable checker is used to selection of below menu
        while (checker == 1){
            int item_code;
            System.out.println("-------------------------------------");
            System.out.println("          Enter Item Code           ");
            System.out.println("-------------------------------------");
            System.out.print("Item Code: ");
            item_code = input.nextInt();                                       // Get user input for item code
            input.nextLine();
            customer.add_item(item_code);
            System.out.println("----------------------------------------");
            System.out.println("              Options Menu                ");
            System.out.println("----------------------------------------");
            System.out.println("Please select one of the following options:");
            System.out.println("  1. Add items");
            System.out.println("  2. Print bill");
            System.out.println("  3. Store customer data");
            System.out.println("------------------------------------------");
            checker = input.nextInt();
            input.nextLine();
        }
        if(checker == 2){
            customer.print_bill();                                                  //print the bill
        }
        else if(checker == 3){
            String fileName = customer.customer_name+".ser";                         //store a customer bill

            try {
                // Create a FileOutputStream to write the serialized data to a file
                FileOutputStream fileOut = new FileOutputStream(fileName);
                // Create an ObjectOutputStream to serialize the object
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                // Write the object to the ObjectOutputStream
                out.writeObject(customer);
                // Close the streams
                out.close();
                fileOut.close();
                System.out.println("Serialized data is saved in " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void billing(Poss customer){
        Scanner input = new Scanner(System.in);
        int checker = 1;                                                   //variable checker is used to selection of below menu
        while (checker == 1){
            int item_code;
            System.out.println("-------------------------------------");
            System.out.println("          Enter Item Code           ");
            System.out.println("-------------------------------------");
            System.out.print("Item Code: ");
            item_code = input.nextInt();
            input.nextLine();
            customer.add_item(item_code);
            System.out.println("----------------------------------------");
            System.out.println("              Options Menu                ");
            System.out.println("----------------------------------------");
            System.out.println("Please select one of the following options:");
            System.out.println("  1. Add items");
            System.out.println("  2. Print bill");
            System.out.println("  3. Store customer data");
            System.out.println("------------------------------------------");
            checker = input.nextInt();
            input.nextLine();
        }
        if(checker == 2){
            customer.print_bill();
        }
        else if(checker == 3){
            String fileName = customer.customer_name+".ser";

            try {
                // Create a FileOutputStream to write the serialized data to a file
                FileOutputStream fileOut = new FileOutputStream(fileName);
                // Create an ObjectOutputStream to serialize the object
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                // Write the object to the ObjectOutputStream
                out.writeObject(customer);
                // Close the streams
                out.close();
                fileOut.close();
                System.out.println("Serialized data is saved in " + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("enter a valid number");
        }
    }
    public static Object deserializeObjectFromFile(String filename) {                       //function for deserialize object from file
        Object object = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            object = objectIn.readObject();
            System.out.println("Object deserialized successfully from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int options;
        System.out.println("----------------------------------------");
        System.out.println("          Options Menu for Customers       ");
        System.out.println("-----------------------------------------");
        System.out.println("Please select one of the following options:");
        System.out.println("  0. Start with a new customer");
        System.out.println("  1. Handle the last pending bill");
        System.out.println("------------------------------------------");
        options = input.nextInt();
        input.nextLine();
        if(options == 0){
            billing();
        }
        else if(options == 1){
            int check =0;
            System.out.println("enter the name of the customer you want to continue: ");
            while(check == 0){
            try{String file_name = input.nextLine()+".ser";
            Poss customer = (Poss) deserializeObjectFromFile(file_name);
            billing(customer);
            check = 1;}
            catch (Exception e){
                System.out.println("enter correct name");
            }
            }
        }
    }
}
