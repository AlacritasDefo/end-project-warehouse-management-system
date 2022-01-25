package sda.pl.zdjavapol96.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sda.pl.zdjavapol96.model.Customer;
import sda.pl.zdjavapol96.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer add(CustomerDto newCustomer);
    Optional<Customer> findCustomerByName(String name);
    List<Customer> findCustomerById(long id);
    List<Customer> findAllCustomers();
    Customer update(Customer customerUpdate);
    void deleteById(long id);

}
