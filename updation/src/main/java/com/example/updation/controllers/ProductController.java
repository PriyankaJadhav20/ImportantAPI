package com.example.updation.controllers;

import com.example.updation.entities.Product;
import com.example.updation.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "save",
            method = RequestMethod.PUT,
            produces = { MimeTypeUtils.APPLICATION_JSON_VALUE },
            headers = "Accept=application/json")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        try {
            return new ResponseEntity<Product>(productService.save(product), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
    }


}
