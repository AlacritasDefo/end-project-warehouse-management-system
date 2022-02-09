package sda.pl.zdjavapol96;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sda.pl.zdjavapol96.dto.CustomerDto;
import sda.pl.zdjavapol96.model.UserApp;
import sda.pl.zdjavapol96.repository.UserAppRepository;
import sda.pl.zdjavapol96.service.CustomerService;
import sda.pl.zdjavapol96.service.ProductPriceService;
import sda.pl.zdjavapol96.service.ProductService;


@SpringBootApplication
public class endProjectWarehouseManagementSystemApplication implements CommandLineRunner {
    private UserAppRepository userAppRepository;
    private CustomerService customerService;
    private ProductService productService;
    private ProductPriceService productPriceService;


    public endProjectWarehouseManagementSystemApplication(UserAppRepository userAppRepository,
                                                          CustomerService customerService,
                                                          ProductService productService,
                                                          ProductPriceService productPriceService){
        this.userAppRepository = userAppRepository;
        this.customerService = customerService;
        this.productService = productService;
        this.productPriceService = productPriceService;
    }

    public static void main(String[] args) {
        SpringApplication.run(endProjectWarehouseManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userAppRepository.save(
                UserApp.builder()
                        .username("Arek")
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
                        .taxId("PL1875285")
                .build());


    }
}
