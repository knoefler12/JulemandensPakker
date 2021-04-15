package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {
    Wishlist wishlist = new Wishlist();
    JBDC jbdc = new JBDC();
    private ArrayList<Wishlist> wishes=new ArrayList<>();
    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("wishlist",wishlist);
        return "index.html";
    }

    @PostMapping("/ønske_processing")
    public String ønskeProcessing(@ModelAttribute Wishlist wishlist, RedirectAttributes redirectAttrs) throws SQLException {
        String name = wishlist.getNameOfThePresent();
        float price = wishlist.getPrice();
        String link = wishlist.getLinkOfThePresent();
        byte reserved = wishlist.getReseveret();
        String user = wishlist.getUsername();
        jbdc.createNewWishlist(name, price, link, reserved, user);
        Wishlist wishlistForArray = new Wishlist(name,price,link,reserved,user);
        wishes.add(wishlistForArray);
            return "redirect:/ønskelist";
    }

    @GetMapping("/ønskelist")
    public String dashboard(Model model){
        System.out.println(wishlist.getUsername());
        model.addAttribute("wish",wishes);
        return "ønskeliste";
    }

}
