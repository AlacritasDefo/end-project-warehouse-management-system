package sda.pl.zdjavapol96.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import sda.pl.zdjavapol96.dto.ProductDto;
import sda.pl.zdjavapol96.model.Product;
import sda.pl.zdjavapol96.service.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public ResponseEntity<Product> add(@Valid @RequestBody ProductDto productDto) {
        final Product product = productService.add(productDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id) {
        return ResponseEntity.of(productService.findById(id));
    }
}