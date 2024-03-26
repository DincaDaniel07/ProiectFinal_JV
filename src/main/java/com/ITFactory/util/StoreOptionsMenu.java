package com.ITFactory.util;

import com.ITFactory.service.StoreService;

import java.util.Scanner;


public class StoreOptionsMenu {

    private StoreService storeService;

    private ProductConstructor productConstructor;

    public StoreOptionsMenu(StoreService storeService, ProductConstructor productConstructor) {
        this.storeService = storeService;
        this.productConstructor = productConstructor;
    }

    public void Menu() {

        while (true) {

            System.out.println("Menu: ");
            System.out.println("1. Show a list with all the products. ");
            System.out.println("2. Add a new product. ");
            System.out.println("3. Remove an existing product. ");
            System.out.println("4. Update the price of an existing product. ");
            System.out.println("5. Update the quantity of an existing product. ");
            System.out.println("6. Exit the menu. ");
            System.out.println(" ");

            Scanner userInput = new Scanner(System.in);

            int option = 0;
            boolean IncorectOption = true;
            while (IncorectOption) {
                try {
                    System.out.print("Please, enter the your option: ");
                    option = Integer.parseInt(userInput.nextLine());
                    IncorectOption = false;
                } catch (NumberFormatException e) {
                    System.out.println("Sorry! You can only input numbers.");
                    System.out.println(" ");
                }
            }

            System.out.println(" ");
            switch (option) {
                case 1: {
                    storeService.showAllProducts();
                }
                break;

                case 2: {
                    try {
                        storeService.addNewProduct(productConstructor.tryAddNewProduct(userInput));
                    } catch (NumberFormatException e) {
                        System.out.println(" ");
                    }
                }
                break;

                case 3: {
                    try {
                        storeService.removeProduct(productConstructor.tryRemoveProduct(userInput));
                    } catch (NumberFormatException e) {
                        System.out.println(" ");
                    }
                }
                break;

                case 4: {
                    try {
                        storeService.updateProductPrice(productConstructor.tryUpdateProductPrice(userInput));
                    } catch (NumberFormatException e) {
                        System.out.println(" ");
                    }
                }
                break;

                case 5: {
                    try {
                        storeService.updateProductQuantity(productConstructor.tryUpdateProductQuantity(userInput));
                    } catch (NumberFormatException e) {
                        System.out.println(" ");
                    }
                }
                break;

                case 6:
                    System.exit(0);
            }
        }
    }
}
