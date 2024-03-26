package com.ITFactory.interfaces;

import com.ITFactory.model.Product;

import java.util.Scanner;

public interface ConstructorMethods {
    Product tryAddNewProduct(Scanner scanner);

    Product tryUpdateProductPrice(Scanner scanner);

    Product tryUpdateProductQuantity(Scanner scanner);

    Product tryRemoveProduct(Scanner scanner);
}
