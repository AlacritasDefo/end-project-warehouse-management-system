package sda.pl.zdjavapol96.service;

import org.springframework.stereotype.Service;
import sda.pl.zdjavapol96.dto.ProductPriceDto;
import sda.pl.zdjavapol96.model.Product;
import sda.pl.zdjavapol96.model.ProductPrice;
import sda.pl.zdjavapol96.repository.ProductPriceRepository;

@Service
public class JpaProductPriceService implements ProductPriceService{

    private final ProductPriceRepository productPriceRepository;

    public JpaProductPriceService(ProductPriceRepository productPriceRepository) {
        this.productPriceRepository = productPriceRepository;

    }


    @Override
    public ProductPrice add(ProductPriceDto newProductPrice) {
        ProductPrice productPrice = ProductPrice.builder()
                .product(Product.builder()
                        .id(newProductPrice.getProductId())
                        .build())
                .purchasePrice(newProductPrice.getPurchasePrice())
                .sellingPrice(newProductPrice.getSellingPrice())
                .introductionDate(newProductPrice.getIntroductionDate())
                .build();
        return productPriceRepository.save(productPrice);
    }

}
