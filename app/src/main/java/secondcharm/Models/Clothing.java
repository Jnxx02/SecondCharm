package secondcharm.Models;

public abstract class Clothing {
    private String id;
    private String name;
    private double price;

    public Clothing(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    //TODO
    //tambahkan method abstractnya seperti contoh dibawah (tidak harus sama kyk di bwah)
    //public abstract void displayInfo();
}
