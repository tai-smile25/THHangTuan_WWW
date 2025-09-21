package iuh.fit.se.entities;


public class Product {
    private int id;
    private String name;
    private double price;
    private String image;

    public Product() {}

    public Product(String name, double price, String image) {
        this.setName(name);
        this.setPrice(price);
        this.setImage(image);
    }

    public Product(int id, String name, double price, String image) {
        this.setId(id);
        this.setName(name);
        this.setPrice(price);
        this.setImage(image);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
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
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
