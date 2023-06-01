package secondcharm.Models;

public class Clothing {
    private byte[] image;
    private String name;
    private double price;
    private String describe;
    private int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Clothing() {}

    public Clothing(byte[] image, String name, double price, String describe, int id) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.describe = describe;
        this.id = id;
    }
    
    public byte[] getImage() {
        return image;
    }
    
    public void setImage(byte[] image) {
        this.image = image;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getDescribe() {
        return describe;
    }
    
    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
