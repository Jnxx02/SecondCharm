package secondcharm.Models;

public class Top extends Clothing {
    private String size;
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
    public Top(String name, double price, int stock, String size) {
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
