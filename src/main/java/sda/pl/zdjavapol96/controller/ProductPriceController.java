package sda.pl.zdjavapol96.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.pl.zdjavapol96.dto.ProductPriceDto;
import sda.pl.zdjavapol96.model.ProductPrice;
import sda.pl.zdjavapol96.service.ProductPriceService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/productprice")
public class ProductPriceController {
    private final ProductPriceService productPriceService;

    public ProductPriceController(ProductPriceService productPriceService) {
        this.productPriceService = productPriceService;
    }

    @PostMapping("")
    public ResponseEntity<ProductPrice> add(@Valid @RequestBody ProductPriceDto productPriceDto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productPriceService.add(productPriceDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductPrice> findById(@PathVariable long id){
        return ResponseEntity.of(productPriceService.findById(id));
    }
}
