package sda.pl.zdjavapol96.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.pl.zdjavapol96.model.Customer;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllCustomers();
    List<Customer> findCustomerById(long id);
    List<Customer> findCustomerByName(String name);
    Optional<Customer> findCustomerByTaxID(long taxId);
    Optional<Customer> findCustromerByPhoneNumber(long phoneNumber);
}
