package shop;

public class Item {

    private String name;
    private int price;

    public Item(String name,Integer price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(o == this) {
            return true;
        }
        Item i = (Item) o;
        if(i== null) {
            return false;
        }
        if(i.name.equals(this.name)) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name;
    }
}
