package sda.pl.zdjavapol96.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.pl.zdjavapol96.model.Customer;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAll();
    Optional<Customer> findById(long id);
    Optional<Customer> findByName(String name);
    Optional<Customer> findByTaxId(String taxId);
    Optional<Customer> findByPhoneNumber(long phoneNumber);
}
