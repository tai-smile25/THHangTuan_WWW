package iuh.fit.se.entities;

public class ItemCart {
    private Product product;
    private int quantity;

    public ItemCart() {}

    public ItemCart(Product product, int quantity) {
        this.setProduct(product);
        this.setQuantity(quantity);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
