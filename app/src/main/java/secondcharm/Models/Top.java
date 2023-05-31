package secondcharm.Models;

public class Top extends Clothing {
    private String size;

    public Top(byte[] image, String name, double price, String size, String describe) {
        super(image, name, price, describe);
        this.size = size;
    }

    public Top() {}

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
