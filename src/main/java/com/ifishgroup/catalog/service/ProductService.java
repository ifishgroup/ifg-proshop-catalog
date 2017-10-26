package com.ifishgroup.catalog.service;

import com.ifishgroup.catalog.model.Product;

import java.util.List;

public interface ProductService {
    Product findById(long id);

    Product findByName(String name);

    void saveProduct(Product product);

    void updateProduct(Product product);

    void deleteProductById(long id);

    List<Product> findAllProducts();

    void deleteAllProducts();

    boolean isProductExist(Product product);
}
