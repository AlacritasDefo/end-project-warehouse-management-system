package sda.pl.zdjavapol96.service;


import sda.pl.zdjavapol96.dto.ProductPriceDto;
import sda.pl.zdjavapol96.model.ProductPrice;

import java.util.Optional;


public interface ProductPriceService {
    ProductPrice add(ProductPriceDto newProductPrice);
    Optional<ProductPrice> findById(long id);


}
