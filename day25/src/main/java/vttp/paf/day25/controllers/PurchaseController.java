package vttp.paf.day25.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/purchase")
public class PurchaseController {
    

    @PostMapping
    public String postPurchase(@RequestBody MultiValueMap<String, String> form, Model model){
        // retriveve the date from the form

        return "";

    }
}
