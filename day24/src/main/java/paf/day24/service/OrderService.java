package paf.day24.service;

import org.springframework.beans.factory.annotation.Autowired;

import paf.day24.repositories.PurchaseOrderRepository;

public class OrderService {

    @Autowired
    private PurchaseOrderRepository poReop;

    @Autowired
    private ItemRepository itemRepo;

    

    
}
