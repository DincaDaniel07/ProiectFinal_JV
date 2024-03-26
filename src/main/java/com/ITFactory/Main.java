package com.ITFactory;

import com.ITFactory.dao.ProductDao;
import com.ITFactory.service.StoreService;
import com.ITFactory.util.ProductConstructor;
import com.ITFactory.util.StoreOptionsMenu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        ProductDao productDao = new ProductDao();
        StoreService storeService = new StoreService(productDao);
        ProductConstructor productConstructor = new ProductConstructor(productDao);
        StoreOptionsMenu storeOptionsMenu = new StoreOptionsMenu(storeService, productConstructor);

        storeOptionsMenu.Menu();
    }
}