package com.ITFactory.service;

import com.ITFactory.dao.ProductDao;
import com.ITFactory.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    private ProductDao productDao;

    public StoreService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void addNewProduct(Product product) {
        if (product != null && !productDao.retrieveAllProducts().contains(product)) {
            productDao.addNewProduct(product);
        } else {
            System.out.println("The product already exists!");
            System.out.println(" ");
        }
    }


    public List<Product> showAllProducts() {
        if (!productDao.retrieveAllProducts().isEmpty()) {
            System.out.println("The following products are in stock:");
            System.out.println(productDao.retrieveAllProducts());
            System.out.println(" ");
        } else {
            System.out.println("No products in stock!");
            System.out.println(" ");
        }
        return productDao.retrieveAllProducts();
    }


    public void updateProductPrice(Product product) {
        if (product != null) {
            productDao.updateProductPrice(product, product.getProductPrice());
        } else {
            System.out.println("The product you wish to update the price for does not exist in stock!");
        }
    }


    public void updateProductQuantity(Product product) {
        if (product != null) {
            productDao.updateProductQuantity(product, product.getProductQuantity());
        } else {
            System.out.println("The product you wish to update the quantity for does not exist in stock!");
        }
    }


    public void removeProduct(Product product) {
        if (product != null) {
            productDao.removeProduct(product);
        } else {
            System.out.println("The product you wish to remove does not exist in stock!");
        }
    }
}



