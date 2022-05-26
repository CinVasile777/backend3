package com.example.myapplication.service;

import com.example.myapplication.model.Product;
import com.example.myapplication.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(Product product) {
        Optional<Product> productOptional = productRepository.findById(product.getId());
        if (productOptional.isPresent()) {
            throw new IllegalArgumentException("Product already exist");
        }

        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Product product) {
        this.getProductById(product.getId());
        return productRepository.save(product);
    }

    public void deleteProductById(Integer id) {
        this.getProductById(id);
        productRepository.deleteById(id);
    }

    public List<Product> getAllProductByBrand(final Enum brand) {
        return productRepository.findAll()
                .stream().filter(product -> product.getBrand().equals(brand))
                .toList();
    }
}
