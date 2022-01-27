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
                .name(newCustomer.getName())
                .address(newCustomer.getAddress())
                .country(newCustomer.getCountry())
                .eMail(newCustomer.getEMail())
                .phoneNumber(newCustomer.getPhoneNumber())
                .taxId(newCustomer.getTaxId())
                .build();
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public Optional<Customer> findById(long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> findByTaxId(long taxId) {
        return customerRepository.findByTaxID(taxId);
    }

    @Override
    public Optional<Customer> findByPhoneNumber(long phoneNumber) {
        return customerRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Customer customerUpdate) {
        return customerRepository.save(customerUpdate);
    }

    @Override
    public void deleteById(long id) {
        customerRepository.deleteById(id);
    }
}
