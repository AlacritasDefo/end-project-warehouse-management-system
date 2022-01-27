package sda.pl.zdjavapol96.service;

import sda.pl.zdjavapol96.dto.ProductDto;
import sda.pl.zdjavapol96.model.ProductPriceDto;
import sda.pl.zdjavapol96.model.ProductPrice;

import java.util.List;
import java.util.Optional;

public interface ProductPriceService {
    ProductPrice add(ProductPriceDto productPriceDto);
    List<ProductPrice> findAll();
    Optional<ProductPrice> findById(long id);
    Optional<ProductPrice> findByName(String productName);
    void deleteById(long id);
}
