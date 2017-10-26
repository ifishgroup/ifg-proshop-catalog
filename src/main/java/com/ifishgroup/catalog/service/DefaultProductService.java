package com.ifishgroup.catalog.service;

import com.google.common.collect.Lists;
import com.ifishgroup.catalog.model.Product;
import com.ifishgroup.catalog.persist.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("productService")
public class DefaultProductService implements ProductService {

    @Autowired
    private ProductRepository repository;

    private static final AtomicLong counter = new AtomicLong();

    @Override
    public Product findById(long id) {
        return null;
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public void saveProduct(Product product) {
        repository.save(product);
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProductById(long id) {

    }

    @Override
    public List<Product> findAllProducts() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public void deleteAllProducts() {

    }

    @Override
    public boolean isProductExist(Product product) {
        return false;
    }

}
