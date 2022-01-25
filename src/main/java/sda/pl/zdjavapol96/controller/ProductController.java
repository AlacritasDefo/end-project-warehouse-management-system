package sda.pl.zdjavapol96.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sda.pl.zdjavapol96.dto.ProductDto;
import sda.pl.zdjavapol96.service.ProductService;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/product/add")
    public String productAddForm() {
        return "/product/add-product-form";
    }
    @PostMapping("/product/add")
    public String productAdd(@ModelAttribute ProductDto productDto, Model model){
        model.addAttribute("product", productService.add(productDto));
        return "/product/confirm-add-product";
    }
    @GetMapping("/product/list")
    public String productList(Model model){
        model.addAttribute("products", productService.findAllProducts());
        return "/product/list";
    }
}
