package vttp2022.day21.day21.controllers;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vttp2022.day21.day21.models.Book;
import vttp2022.day21.day21.repositories.BookRepository;



@Controller
@RequestMapping(path = "/search")
public class SearchController {
    private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private BookRepository bookRepo;

    @GetMapping 
    public String search(@RequestParam String bookName, @RequestParam Integer resultCount
                , Model model){

        List<Book> books = bookRepo.getBooksByTitle(bookName, resultCount);

        logger.info("books >>>>> " + books);

        // populate the model with the bindings
        model.addAttribute("bookName", bookName);
        model.addAttribute("resultCount", books.size());
        model.addAttribute("books", books);
        model.addAttribute("hasResult", books.size() > 0);
        
        return "search-results";
    }


    // @GetMapping({"/"})
    // public String showIndexPage(Model model) {
    //     List<Book> results = new LinkedList<>();
        
    //     model.addAttribute("bookResults", results);
        
    //     return "result";
    // }
    

//     @GetMapping("/search")
//     public String searchBooks(@RequestParam("title") String title, @RequestParam("numResult") String numResult, Model model) {

//         logger.info("title >>> " + title);
//         logger.info("limit >>> " + numResult);
        
//         // query the database 
//         List<Book> results = bookRepo.getBooksByTitleAndLimit(title, Integer.parseInt(numResult));
        
      
//         model.addAttribute("bookResults", results);

//         logger.info("results >> " + results.toString());
       

//         return "result";

//     }
}
