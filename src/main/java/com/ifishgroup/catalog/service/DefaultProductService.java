package com.ifishgroup.catalog.service;

import com.google.common.collect.Lists;
import com.ifishgroup.catalog.model.Product;
import com.ifishgroup.catalog.persist.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service("productService")
public class DefaultProductService implements ProductService {

    @Autowired
    private ProductRepository repository;

    private static final AtomicLong counter = new AtomicLong();

    @Override
    public Product findById(long id) {
        return repository.findOne(id);
    }

    @Override
    public Product findByName(String name) {
        List<Product> products = Lists.newArrayList(repository.findAll());
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void saveProduct(Product product) {
        repository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        repository.save(product);
    }

    @Override
    public void deleteProductById(long id) {
        repository.delete(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return Lists.newArrayList(repository.findAll());
    }

    @Override
    public void deleteAllProducts() {
        repository.deleteAll();
    }

    @Override
    public boolean isProductExist(Product product) {
        return repository.exists(product.getId());
    }

}
