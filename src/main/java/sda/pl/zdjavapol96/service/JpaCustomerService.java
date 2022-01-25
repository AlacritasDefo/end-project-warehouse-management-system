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
        final Customer customer = Customer.builder()
                .build();
        return customerRepository.save(customer);
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
