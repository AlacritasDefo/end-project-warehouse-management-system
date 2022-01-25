package sda.pl.zdjavapol96.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sda.pl.zdjavapol96.dto.CustomerDto;
import sda.pl.zdjavapol96.service.CustomerService;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/customer/add")
    public String customerAddForm(){
        return "/customer/add-customer-form";
    }

    @PostMapping("/customer/add")
    public String customerAdd(@ModelAttribute CustomerDto customerDto, Model model){
        model.addAttribute("customer", customerService.add(customerDto));
        return "/customer/confirm-customer-add";
    }

    @GetMapping("/customer/list")
    public String customerList(Model model){
        model.addAttribute("customers", customerService.findAllCustomers());
        return "/customer/list";
    }

}
