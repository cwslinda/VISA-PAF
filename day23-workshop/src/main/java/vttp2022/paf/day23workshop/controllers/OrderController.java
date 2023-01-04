package vttp2022.paf.day23workshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.paf.day23workshop.models.Order;
import vttp2022.paf.day23workshop.repositories.OrderRepo;

@Controller
@RequestMapping("/order/total")
public class OrderController {
    
    @Autowired
    private OrderRepo ordRepo;

    @GetMapping
    public String getOrderId(@RequestParam("orderId") String orderId, Model model){
        System.out.println("order id >>> " + orderId);

        Order order = ordRepo.queryOrder(orderId);

        model.addAttribute("order", order);

        return "order";
    }
}
