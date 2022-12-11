package shop;

import Exceptions.InvalidItemException;
import Exceptions.InvalidLoginException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Shop shop1 = new Shop();
        Customer currentCustomer = null;
        while (true) {
            System.out.print("Login name: ");
            String loginName = scanStringInput();
            System.out.print("password: ");
            String passwordInput = scanStringInput();
            try {
                currentCustomer = shop1.login(loginName, passwordInput);
                System.out.println("Login Successfull, Welcome on our Shop!");
                break;
            } catch (InvalidLoginException e) {
                System.out.println("Invalid Login Attempt");
            }
        }
        for (;true;) {
           boolean result = mainMenu(shop1,currentCustomer);
           if(result==true) {
               break;
           }
        }
    }

    //Test Kommentar für GIT
    public static String scanStringInput() {
        Scanner input1 = new Scanner(System.in);
        return input1.nextLine();
    }

    public static Integer scanIntegerInput() {
        Scanner input1 = new Scanner(System.in);
        return input1.nextInt();
    }


    public static boolean mainMenu(Shop shop, Customer customer) {
        System.out.println();
        System.out.println("1 - Show Items");
        System.out.println("2 - Buy Items");
        System.out.println("3 - Exit");
        System.out.print("Choice: ");
        String menuStringInput = scanStringInput();
        if(menuStringInput.equals("1")) {
            shop.printCurrentItems();
        } else if (menuStringInput.equals("2")) {
            System.out.println("Your Balance is currently: " + customer.getBalance());
            while(true) {
                System.out.println("Which Item do you want to buy?");
                System.out.print("Choice: ");
                menuStringInput = scanStringInput();
                System.out.print("Quantity: ");
                Integer menuIntegerInput = scanIntegerInput();
                try {
                    shop.buyItems(menuStringInput, menuIntegerInput);
                    shop.printCurrentItems();
                    break;
                }
                catch (InvalidItemException i) {
                    System.out.println("Invalid Input, try again!");
                }
            }
        } else if (menuStringInput.equals("3")) {
            return true;
        }
        return false;
    }

}