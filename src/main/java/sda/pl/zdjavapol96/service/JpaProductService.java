package sda.pl.zdjavapol96.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sda.pl.zdjavapol96.dto.ProductDto;
import sda.pl.zdjavapol96.model.Product;
import sda.pl.zdjavapol96.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaProductService implements ProductService{
    private final ProductRepository productRepository;

    public JpaProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product add(ProductDto newProduct) {
       //TODO Zaimplementować ADD Product
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public List<Product> findById(long id) {
        return null;
    }

    @Override
    public Optional<Product> findByName(String name) {
        return Optional.empty();
    }




}
