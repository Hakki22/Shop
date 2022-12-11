package shop;

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
                break;
            } catch (InvalidLoginException e) {
                System.out.println("Invalid Login Attempt");
            }
        }
        mainMenu(shop1,currentCustomer);
    }

    public static String scanStringInput() {
        Scanner input1 = new Scanner(System.in);
        return input1.nextLine();
    }
    public static void mainMenu(Shop shop, Customer customer) {
        System.out.println("Login Successfull, Welcome on our Shop!");
        System.out.println();
        System.out.println("1 - Show Items");
        System.out.println("2 - Buy Items");
        System.out.println("3 - Exit");
        System.out.print("Choice: ");
        String menuInput = scanStringInput();
        if(menuInput.equals("1")) {
            shop.printCurrentItems();
        } else if (menuInput.equals("2")) {
            System.out.println("Your Balance is currently: " + customer.getBalance());
            System.out.println("Which Item do you want to buy?");
            System.out.println("Choice: ");
            menuInput = scanStringInput();


        }
    }

}