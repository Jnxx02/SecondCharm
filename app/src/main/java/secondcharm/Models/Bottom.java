package secondcharm.Models;

public class Bottom extends Clothing {
    private int size;
    
    public int getSize() {
        return size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    public Bottom(String name, double price, int stock, int size) {
        super(name, price, stock);
        this.size = size;
    }

    @Override
    void displayInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Stock: " + getStock());
        System.out.println("Size: " + getSize());
    }    

}
