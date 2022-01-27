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
    public Optional<Customer> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Customer> findById(long id) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer update(Customer customerUpdate) {
        //TODO ZAIMPLEMENTOWAĆ update
        return null;
    }

    @Override
    public void deleteById(long id) {
        //TODO ZAIMPLEMENTOWAĆ delete
    }
}
