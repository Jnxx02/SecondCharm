package secondcharm.Models;

public class Bottom extends Clothing {
    
    private int size;
    
    public Bottom(byte[] image, String name, double price, int size, String describe) {
        super(image, name, price, describe);
        this.size = size;
    }

    public Bottom() {}

    public int getSize() {
        return size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
}
