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
        //TODO
        //implement method abstract dari Clothing

    }   
}
