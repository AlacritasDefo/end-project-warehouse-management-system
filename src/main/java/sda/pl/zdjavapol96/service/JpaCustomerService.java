package sda.pl.zdjavapol96.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sda.pl.zdjavapol96.dto.CustomerDto;
import sda.pl.zdjavapol96.model.Customer;
import sda.pl.zdjavapol96.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaCustomerService implements CustomerService{
    private final CustomerRepository customerRepository;

    public JpaCustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer add(CustomerDto newCustomer){
        //TODO Zaimplementowac Customer ADD
        final Customer customer = Customer.builder()
                .build();
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findCustomerByName(String name) {
       //TODO Zaimplementowac findCustomerByName
        return Optional.empty();
    }

    @Override
    public List<Customer> findCustomerById(long id) {
        //TODO Zaimplementowac findCustomerById
        return null;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAllCustomers();
    }

    @Override
    public Customer update(Customer customerUpdate) {
        return null;
    }

    @Override
    public Optional<Customer> findById(long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(long id) {

    }
}
