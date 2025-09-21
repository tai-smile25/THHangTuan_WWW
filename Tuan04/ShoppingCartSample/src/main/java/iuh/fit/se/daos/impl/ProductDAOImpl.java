package iuh.fit.se.daos.impl;


import iuh.fit.se.daos.ProductDAO;
import iuh.fit.se.entities.Product;
import java.sql.Connection;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private final DataSource datasource;

    public ProductDAOImpl(DataSource datasource) {
        this.datasource = datasource;
    }

    @Override
    public List<Product> findAll() {

        String sql = "SELECT id, name, price, image FROM product";
        List<Product> list = new ArrayList<>();
        try (
                Connection con = (Connection) this.datasource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                String image = rs.getString("image");
                list.add(new Product(id, name, price,image));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product getById(int id) {

        String sql = "SELECT id, name, price, image FROM product WHERE id=?";
        Product p = null;
        try (
                Connection con = (Connection) this.datasource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    Double price = rs.getDouble("price");
                    String image = rs.getString("image");
                    p = new Product(id, name, price,image);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void addProduct(Product p) {
        String sql = "INSERT INTO product (name, price, image) VALUES (?,?,?)";
        try (
                Connection con = (Connection) this.datasource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ){
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setString(3, p.getImage());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
