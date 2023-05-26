package secondcharm.Models;

public class Bottom extends Clothing {
    private String size;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Bottom(String id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }

    //TODO
    //implement method abstract dari Clothing
}
