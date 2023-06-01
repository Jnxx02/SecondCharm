package secondcharm.Models;

public class Top extends Clothing {
    private String size;

    public Top(byte[] image, String name, double price, String size, String describe, int id) {
        super(image, name, price, describe, id);
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
