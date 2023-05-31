package secondcharm.Models;

public class Bottom extends Clothing {
    
    private int size;
    
    public Bottom(byte[] image, String name, double price, int size) {
        super(image, name, price);
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
}
