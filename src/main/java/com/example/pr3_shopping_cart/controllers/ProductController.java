package com.example.pr3_shopping_cart.controllers;

import com.example.pr3_shopping_cart.models.Cart;
import com.example.pr3_shopping_cart.models.Product;
import com.example.pr3_shopping_cart.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(){
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action")String action){
        Optional<Product> productOptional = productService.findById(id);
        if(!productOptional.isPresent()){
            return "/error_404";
        }
        if(action.equals("show")){
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") Long id, Model model) {
        // Giả sử bạn có một dịch vụ để lấy thông tin sản phẩm theo ID
        Product product = productService.findProduct(id);
        model.addAttribute("product", product);
        return "/detail";
    }

}
