package com.ITFactory.util;

import com.ITFactory.dao.ProductDao;
import com.ITFactory.interfaces.ConstructorMethods;
import com.ITFactory.model.Product;

import java.util.List;
import java.util.Scanner;


public class ProductConstructor implements ConstructorMethods {

    private ProductDao productDao;

    private List<Product> products;

    public ProductConstructor(ProductDao productDao) {
        this.productDao = productDao;
        this.products = productDao.retrieveAllProducts();
    }

    @Override
    public Product tryAddNewProduct(Scanner scanner) {
        System.out.print("Enter the name of the new product: ");
        String localProductName = scanner.nextLine();

        Product localProduct = null;

        if (checkInStock(localProductName.toLowerCase())) {
            System.out.println(" ");
        } else {
            double localProductPrice = 0;
            int localProductQuantity = 0;
            boolean localInvalidPrice = true;
            while (localInvalidPrice) {
                try {
                    System.out.print("Enter the price of the new product: ");
                    localProductPrice = Double.parseDouble(scanner.nextLine());
                    localInvalidPrice = false;
                } catch (NumberFormatException e) {
                    System.out.println("You can only input numbers!");
                    System.out.println(" ");
                }
            }
            boolean localInvalidQuantity = true;
            while (localInvalidQuantity) {
                try {
                    System.out.print("Enter the quantity of the new product: ");
                    localProductQuantity = Integer.parseInt(scanner.nextLine());
                    localInvalidQuantity = false;
                } catch (NumberFormatException e) {
                    System.out.println("You can only input numbers!");
                    System.out.println(" ");
                }
            }
            localProduct = new Product(localProductName, localProductPrice, localProductQuantity);
            products.add(localProduct);
        }
        return localProduct;
    }

    @Override
    public Product tryUpdateProductPrice(Scanner scanner) {
        System.out.print("Enter the name of the product you wish to update the price: ");
        String localProductName = scanner.nextLine();

        Product localProduct = null;

        double localProductPrice = 0;

        if (checkInStock(localProductName.toLowerCase())) {
            boolean localInvalidPrice = true;
            while (localInvalidPrice) {
                try {
                    System.out.print(STR."Enter the updated price for [\{localProductName}]: ");
                    localProductPrice = Double.parseDouble(scanner.nextLine());
                    localInvalidPrice = false;
                } catch (NumberFormatException e) {
                    System.out.println("You can only input numbers!");
                    System.out.println(" ");
                }
            }
            for (Product product : products) {
                if (product.getProductName().equals(localProductName)) {
                    localProduct = new Product(product.getProductName(), localProductPrice, product.getProductQuantity());
                }
            }
        } else {
            System.out.println(" ");
        }
        return localProduct;
    }

    @Override
    public Product tryUpdateProductQuantity(Scanner scanner) {
        System.out.print("Enter the name of the product you wish to update the quantity: ");
        String localProductName = scanner.nextLine();

        Product localProduct = null;

        if (checkInStock(localProductName.toLowerCase())) {
            int localProductQuantity = 0;
            boolean localInvalidQuantity = true;
            while (localInvalidQuantity) {
                try {
                    System.out.print(STR."Enter the updated quantity for [\{localProductName}]: ");
                    localProductQuantity = Integer.parseInt(scanner.nextLine());
                    localInvalidQuantity = false;
                } catch (NumberFormatException e) {
                    System.out.println("You can only input numbers!");
                    System.out.println(" ");
                }
            }
            for (Product product : products) {
                if (product.getProductName().equals(localProductName)) {
                    localProduct = new Product(product.getProductName(), product.getProductPrice(), localProductQuantity);
                }
            }
        } else {
            System.out.println(" ");
        }
        return localProduct;
    }

    @Override
    public Product tryRemoveProduct(Scanner scanner) {
        System.out.print("Enter the name of the product you want to remove: ");
        String localProductName = scanner.nextLine();

        Product localProduct = null;
        if (checkInStock(localProductName.toLowerCase())) {
            for (Product product : products) {
                if (product.getProductName().equals(localProductName)) {
                    localProduct = product;
                }
            }
        } else {
            System.out.println(" ");
        }
        return localProduct;
    }

    public boolean checkInStock(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) return true;
        }
        return false;
    }
}
