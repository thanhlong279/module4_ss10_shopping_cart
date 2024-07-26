package com.example.pr3_shopping_cart.controllers;

import com.example.pr3_shopping_cart.models.Cart;
import com.example.pr3_shopping_cart.models.Product;
import com.example.pr3_shopping_cart.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
//    @GetMapping("/cart")
//    public String viewCart(Model model) {
//        model.addAttribute("cart", setupCart());
//        model.addAttribute("total", setupCart().getTotal());
//        return "cart";
//    }

    @PostMapping("/cart/remove/{id}")
    public String removeItem(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);

            setupCart().removeProduct(product);

        return "redirect:/cart";
    }

//    @PostMapping("/cart/update/{productId}")
//    public String updateItem(@PathVariable("productId") Long productId, @RequestParam("quantity") int quantity) {
//        Product product = productService.getProductById(productId);
//        if (product != null) {
//            setupCart().countTotalPayment(product, quantity);
//        }
//        return "redirect:/cart";
//    }
}
