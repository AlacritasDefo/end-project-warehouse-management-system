package sda.pl.zdjavapol96.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sda.pl.zdjavapol96.model.ProductPrice;
import sda.pl.zdjavapol96.repository.ProductPriceRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaProductPriceService implements ProductPriceService {
    private final ProductPriceRepository productPriceRepository;

    public JpaProductPriceService(ProductPriceRepository productPriceRepository) {
        this.productPriceRepository = productPriceRepository;
    }
//    @Override
//    public Product add(ProductPriceDto productpriceDto) {
//        ProductPrice productPrice = ProductPrice.builder()
//                .
//                .build()
//    }

    @Override
    public List<ProductPrice> findAll() {
        return productPriceRepository.findAll();
    }

    @Override
    public Optional<ProductPrice> findById(long id) {
        return productPriceRepository.findById(id);
    }

    @Override
    public Optional<ProductPrice> findByName(String productName) {
        return productPriceRepository.findByName(productName);
    }

    @Override
    public void deleteById(long id) {

    }
}
