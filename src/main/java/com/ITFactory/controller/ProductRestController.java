package com.ITFactory.controller;

import com.ITFactory.model.Product;
import com.ITFactory.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service/product")
public class ProductRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);
    private final StoreService storeService;

    @Autowired
    public ProductRestController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/all")
    public List<Product> showAllProducts() {
        return storeService.showAllProducts();
    }

    @PostMapping("/create")
    public void addNewProduct(@RequestBody Product product) {
        storeService.addNewProduct(product);
    }

    @DeleteMapping("/remove")
    public void removeProduct(@RequestBody Product product) {
        storeService.removeProduct(product);
    }

    @PutMapping("/update-price")
    public void updateProductPrice(@RequestBody Product product) {
        storeService.updateProductPrice(product);
    }

    @PutMapping("/update-quantity")
    public void updateProductQuantity(@RequestBody Product product) {
        storeService.updateProductQuantity(product);
    }
}
