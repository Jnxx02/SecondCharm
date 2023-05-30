package secondcharm.Models;

public class Bottom extends Clothing {
    
    private String size;
    
    public Bottom(byte[] image, String name, double price, String size) {
        super(image, name, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
    
}
