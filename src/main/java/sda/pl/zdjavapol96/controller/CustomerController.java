package sda.pl.zdjavapol96.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sda.pl.zdjavapol96.dto.CustomerDto;
import sda.pl.zdjavapol96.model.Customer;
import sda.pl.zdjavapol96.service.CustomerService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/customer")
public class  CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }


    @PostMapping("")
    public ResponseEntity<Customer> add(@Valid @RequestBody CustomerDto customerDto) {
        final Customer customer = customerService.add(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(customer);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable long id) {
        return ResponseEntity.of(customerService.findById(id));
    }


}
