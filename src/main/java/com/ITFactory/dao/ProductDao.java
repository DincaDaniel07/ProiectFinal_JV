package com.ITFactory.dao;

import com.ITFactory.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao {
    //Variables
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/proiectfinal";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Admin";

    //Methods
    public void addNewProduct(Product product) {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
//            System.out.println("Connected to MySQL database!");
//            System.out.println("Prepare statement");
//            System.out.println(" ");

            PreparedStatement statement = connection.prepareStatement("INSERT INTO PRODUCTS VALUES(?,?,?)");
            statement.setString(1, product.getProductName());
            statement.setDouble(2, product.getProductPrice());
            statement.setInt(3, product.getProductQuantity());

            statement.execute();
            System.out.println(STR."DB: The Product [\{product.getProductName()}] with the price of [\{product.getProductPrice()
                    }lei], in quantity of [\{product.getProductQuantity()}] was successfully added!");

        } catch (SQLException e) {
            System.out.println("Connection failure!");
        }
    }

    public List<Product> retrieveAllProducts() {

        List<Product> dbProducts = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
//            System.out.println("Connected to MySQL database!");
//            System.out.println("Prepare statement");
//            System.out.println(" ");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
            while (resultSet.next()) {
                String productName = resultSet.getString("product_name");
                double productPrice = resultSet.getDouble("product_price");
                int productQuantity = resultSet.getInt("product_quantity");
                Product product = new Product(productName, productPrice, productQuantity);
                dbProducts.add(product);
            }

        } catch (SQLException e) {
            System.out.println("Connection failure!");
        }
        return dbProducts;
    }

    public void updateProductPrice(Product product, double newPrice) {

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
//            System.out.println("Connected to MySQL database!");
//            System.out.println("Prepare statement");
//            System.out.println(" ");

            PreparedStatement statement = connection.prepareStatement("UPDATE PRODUCTS SET PRODUCT_PRICE=? WHERE PRODUCT_NAME=?");
            statement.setDouble(1, newPrice);
            statement.setString(2, product.getProductName());

            statement.execute();
            System.out.println(STR."DB: The Price of [\{product.getProductName()}] was updated to [\{newPrice}Lei]");

        } catch (SQLException e) {
            System.out.println("Connection failure!");
        }
    }

    public void updateProductQuantity(Product product, int newQuantity) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
//            System.out.println("Connected to MySQL database!");
//            System.out.println("Prepare statement");
//            System.out.println(" ");

            PreparedStatement statement = connection.prepareStatement("UPDATE PRODUCTS SET PRODUCT_QUANTITY=? WHERE PRODUCT_NAME=?");
            statement.setDouble(1, newQuantity);
            statement.setString(2, product.getProductName());

            statement.execute();
            System.out.println(STR."DB: The Quantity of [\{product.getProductName()}] was updated to [\{newQuantity}] products!");

        } catch (SQLException e) {
            System.out.println("Connection failure!");
        }
    }

    public void removeProduct(Product product) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
//            System.out.println("Connected to MySQL database!");
//            System.out.println("Prepare statement");
//            System.out.println(" ");

            PreparedStatement statement = connection.prepareStatement("DELETE FROM PRODUCTS WHERE PRODUCT_NAME=?");
            statement.setString(1, product.getProductName());

            statement.execute();
            System.out.println(STR."DB: The Product [\{product.getProductName()}] was removed successfully!");

        } catch (SQLException e) {
            System.out.println("Connection failure!");
        }
    }
}
