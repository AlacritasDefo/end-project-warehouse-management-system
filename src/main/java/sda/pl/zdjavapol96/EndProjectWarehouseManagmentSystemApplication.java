package sda.pl.zdjavapol96;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sda.pl.zdjavapol96.repository.UserAppRepository;
import sda.pl.zdjavapol96.service.UserAppService;

@SpringBootApplication
public class EndProjectWarehouseManagmentSystemApplication implements CommandLineRunner {
    private UserAppRepository userAppRepository;

    public EndProjectWarehouseManagmentSystemApplication(){

    }

    public static void main(String[] args) {
        SpringApplication.run(EndProjectWarehouseManagmentSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
