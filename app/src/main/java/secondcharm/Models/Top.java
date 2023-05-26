package secondcharm.Models;

public class Top extends Clothing {
    private String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Top(String id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }

    //TODO
    //implement method abstract dari Clothing
    
}
