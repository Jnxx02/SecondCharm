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

    //TODO
    //implement method abstract dari Clothing
}
