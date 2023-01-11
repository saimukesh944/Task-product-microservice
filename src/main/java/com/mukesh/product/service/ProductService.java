package com.mukesh.product.service;

import com.mukesh.product.model.Product;
import com.mukesh.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public String saveProduct(Product product) {

                repository.save(product);
                return "Product Added Successfully";
    }

    public String saveProducts(List<Product> products) {
         repository.saveAll(products);
         return "Products Added Successfully";
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }


    public String updateProduct(Product product) {
        // TODO Auto-generated method stub
       repository.save(product);
        return "Product Updated Successfully";
    }


}
