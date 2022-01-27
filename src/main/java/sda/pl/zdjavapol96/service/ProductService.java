package sda.pl.zdjavapol96.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sda.pl.zdjavapol96.dto.ProductDto;
import sda.pl.zdjavapol96.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product add(ProductDto newProduct);
    List<Product> findAll();
    List<Product> findById(long id);
    Optional<Product> findByName(String name);

}
