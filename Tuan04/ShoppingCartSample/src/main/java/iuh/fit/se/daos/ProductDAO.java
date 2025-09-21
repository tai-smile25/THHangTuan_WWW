package iuh.fit.se.daos;

import iuh.fit.se.entities.Product;

import java.util.List;

public interface ProductDAO {
    public List<Product> findAll();
    public Product getById(int id);
    public void addProduct(Product p);
}
