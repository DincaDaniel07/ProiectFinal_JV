package com.ITFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        // OLD - Console
//        ProductDao productDao = new ProductDao();
//        StoreService storeService = new StoreService(productDao);
//        ProductConstructor productConstructor = new ProductConstructor(productDao);
//        StoreOptionsMenu storeOptionsMenu = new StoreOptionsMenu(storeService, productConstructor);

//        storeOptionsMenu.Menu();
    }
}