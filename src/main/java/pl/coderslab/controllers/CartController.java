package pl.coderslab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.shop.Cart;
import pl.coderslab.shop.CartItem;
import pl.coderslab.shop.Product;

import java.util.List;
import java.util.Random;

@Controller
//@RequestMapping("/cart")
public class CartController {

    private Cart cart;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    @GetMapping("/addtocart")
    @ResponseBody
    public String addtocart() {
        Random rand = new Random();
        Product product = new Product("prod" + rand.nextInt(10), rand.nextDouble());
        cart.addToCart(new CartItem(product, 1));
        return "addtocart";
    }

    @GetMapping("/show")
    public String showCart(Model model) {
        List<CartItem> cartItems = cart.getCartItems();
        model.addAttribute("cartItems", cartItems);
        return "cart";
    }

}
