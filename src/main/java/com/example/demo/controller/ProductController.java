package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @GetMapping("/getById/{id}")
    public Product getProductById(@PathVariable(value = "id")int id){
        return productService.listById(id);
    }
    @GetMapping("/getAllProduct")
    public List<Product> getAll(){
        return productService.listAll();
    }
    @PostMapping("/createProduct")
    public Product createProduct(@Valid @RequestBody Product product){
        return productService.create(product);
    }
    @PutMapping("/updateProduct/{id}")
    public String update(@RequestBody @PathVariable(value = "id")int id,Product product){
        Product product1=productService.listById(id);
        product1.setProductName(product.getProductName());
        Product product2=productService.create(product1);
        return "updated successfully";
    }
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable(value = "id")int id){
        Product product=productService.listById(id);
         productService.delete(product);
         return "deleted successfully";
    }

}
