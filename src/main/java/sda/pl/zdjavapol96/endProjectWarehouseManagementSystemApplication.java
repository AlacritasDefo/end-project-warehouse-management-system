package sda.pl.zdjavapol96;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sda.pl.zdjavapol96.repository.UserAppRepository;

@SpringBootApplication
public class endProjectWarehouseManagementSystemApplication implements CommandLineRunner {
    private UserAppRepository userAppRepository;

    public endProjectWarehouseManagementSystemApplication(){

    }

    public static void main(String[] args) {
        SpringApplication.run(endProjectWarehouseManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
