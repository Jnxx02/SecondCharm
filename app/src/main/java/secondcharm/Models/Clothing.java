package secondcharm.Models;

public abstract class Clothing {
    private String name;
    private double price;
    private int stock;
    
    public Clothing(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //TODO
    //tambahkan method abstractnya seperti contoh dibawah (tidak harus sama kyk di bwah)
    //public abstract void displayInfo();
}
