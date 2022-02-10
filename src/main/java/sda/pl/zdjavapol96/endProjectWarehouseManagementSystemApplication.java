package sda.pl.zdjavapol96;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sda.pl.zdjavapol96.dto.*;
import sda.pl.zdjavapol96.model.DocumentType;
import sda.pl.zdjavapol96.model.UserApp;
import sda.pl.zdjavapol96.repository.UserAppRepository;
import sda.pl.zdjavapol96.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;


@SpringBootApplication
public class endProjectWarehouseManagementSystemApplication implements CommandLineRunner {
    private UserAppRepository userAppRepository;
    private CustomerService customerService;
    private ProductService productService;
    private ProductPriceService productPriceService;
    private DocumentElementService documentElementService;
    private DocumentService documentService;


    public endProjectWarehouseManagementSystemApplication(UserAppRepository userAppRepository,
                                                          CustomerService customerService,
                                                          ProductService productService,
                                                          ProductPriceService productPriceService,
                                                          DocumentService documentService,
                                                          DocumentElementService documentElementService){
        this.userAppRepository = userAppRepository;
        this.customerService = customerService;
        this.productService = productService;
        this.productPriceService = productPriceService;
        this.documentElementService = documentElementService;
        this.documentService = documentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(endProjectWarehouseManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userAppRepository.save(
                UserApp.builder()
                        .username("Arek1234")
                        .password("1234")
                        .firstName("Arkadiusz")
                        .lastName("Przychocki")
                        .roles("ROLE_ADMIN")
                        .build()
        );
        customerService.add(CustomerDto.builder()
                        .name("Miłosz Transport S.C.")
                        .address("Mazowiecka 12, 00-155 Warszawa")
                        .country("Poland")
                        .eMail("mil-trans@gmail.com")
                        .phoneNumber(888111222)
                        .taxId("")
                .build());
        productService.add(ProductDto.builder()
                        .productName("Gwóźdź")
                        .unit("Sztuka")
                        .quantity(BigDecimal.valueOf(100))
                        .isSaleable(true)
                        .vat(BigDecimal.valueOf(23))
                .build());
        productPriceService.add(ProductPriceDto.builder()
                        .productId(1)
                        .introductionDate(LocalDate.now())
                        .sellingPrice(BigDecimal.valueOf(0.99))
                        .purchasePrice(BigDecimal.valueOf(0.49))
                .build());
        documentService.add(DocumentDto.builder()
                        .user(userAppRepository.getById(1L))
                        .issueDate(LocalDate.now())
                        .customerId(1)
                        .documentType(DocumentType.SALES_INVOICE)
                        .documentElements(Set.of())
                .build());
        documentElementService.add(DocumentElementDto.builder()
                        .productId(01L)
                        .productPriceId(01L)
                        .documentId(01L)
                        .quantity(BigDecimal.valueOf(1))
                .build());
    }
}
