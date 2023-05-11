package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.shop.Cart;
import pl.coderslab.shop.CartItem;
import pl.coderslab.shop.Product;

import java.util.List;
import java.util.Random;

@Controller
//@RequestMapping("/cart")   <--------  O TEN MAPPING MI SIĘ ROZCHODZI
public class CartController {

    private Cart cart;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    @RequestMapping("/addtocart")

    public String addtocart() {
//        Random rand = new Random();
//        Product product = new Product("prod" + rand.nextInt(10), rand.nextDouble());
//        cart.addToCart(new CartItem(product, 1));
//        return "addtocart";
        return "cart";
    }
@PostMapping("/addform")
    public String addtocartForm(Model model, @RequestParam String name,@RequestParam Double price, @RequestParam int quantity) {
    System.out.println(price);
    //Double priceDbl = Double.parseDouble(price);

        Product product = new Product(name,price);
        cart.addToCart(new CartItem(product, quantity));
        List<CartItem> cartItems = cart.getCartItems();
        model.addAttribute("cartItems", cartItems);


        return "cart";
    }

    @GetMapping("/show")
    public String showCart(Model model) {
        List<CartItem> cartItems = cart.getCartItems();
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

}
