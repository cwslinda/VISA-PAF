package paf.day23.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import paf.day23.models.Style;
import paf.day23.services.BeerService;

@Controller
@RequestMapping(path={"/", "/index.html"})
public class IndexController {

    @Autowired
    private BeerService beerSvc;

  
    @GetMapping
    public String getIndex(Model model){

        List<Style> styleList = beerSvc.getStyles();

        model.addAttribute("styleList",  styleList);
        
        return "index";
    }
    
}
