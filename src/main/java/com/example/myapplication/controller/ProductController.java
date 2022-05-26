package com.example.myapplication.controller;

import com.example.myapplication.model.Brand;
import com.example.myapplication.model.Product;
import com.example.myapplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

    @PatchMapping("/updateProduct")
    public void updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }

    @PutMapping("/editProduct")
    public void editProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProductById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAllProduct(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/product/{id}")
    public Optional<Product> getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @GetMapping("/category")
    public List<Product> getAllProductByBrand(@RequestParam(name="brand", required = false) Brand brand){
        return productService.getAllProductByBrand(brand);
    }

}

