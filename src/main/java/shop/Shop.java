package shop;

import Exceptions.InvalidItemException;
import Exceptions.InvalidLoginException;

import java.util.*;

public class Shop {

    private Map<Item, Integer> items;
    private List<Customer> customers = new ArrayList<>(
       Arrays.asList( new Customer("John", "password123", 200), new Customer("Don", "321", 100))
    );
    private Customer loggedInCustomer = null;



    public Shop() {
        Item item1 = new Item("Shirt", 10);
        Item item2 = new Item("Jeans", 30);
        items = new HashMap<>();
        items.put(item1, 10);
        items.put(item2, 30);
    }

    public void printCurrentItems() {
        System.out.println("Items:");
        // Map.Entry<Item, Integer> Als Alternative zu var in diesem Beispiel
        for (var item:items.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }

    }

    public void buyItems(String itemName, Integer quantity) throws InvalidItemException {
        for (var item:items.entrySet()) {
            if(item.getKey().getName().equals(itemName)) {
                if(quantity>item.getValue()) {
                    throw new InvalidItemException();
                }
                if(loggedInCustomer.getBalance() >= item.getKey().getPrice() * quantity) {
                    loggedInCustomer.setBalance(loggedInCustomer.getBalance() - item.getKey().getPrice() * quantity);
                    item.setValue(item.getValue() - quantity);
                }
                else {
                    throw new InvalidItemException();
                }

            }
        }
    }

    public Customer login(String name, String password) throws InvalidLoginException{
        for (int i = 0; i < customers.size() ; i++) {
            Customer c = customers.get(i);
            if (c.getName().equals(name)) {
                if (c.getPassword().equals(password)) {
                    loggedInCustomer = c;
                    return c;
                }
            }
        }
        throw new InvalidLoginException();
    }

}
