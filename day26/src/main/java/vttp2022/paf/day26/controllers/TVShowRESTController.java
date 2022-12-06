package vttp2022.paf.day26.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import vttp2022.paf.day26.repositories.TVShowRepo;

@RestController
@RequestMapping(path = "/api", produces=MediaType.APPLICATION_JSON_VALUE)
public class TVShowRESTController {
    

    @Autowired
    private TVShowRepo tvShowRepo;

    @GetMapping("/genres")
    public ResponseEntity<String> getGenres(){
        
        List<String> genreList = tvShowRepo.findAllGenres();

        JsonArrayBuilder jb = Json.createArrayBuilder();
        for(String g : genreList ){
            jb.add(g);
        }
        JsonArray arr = jb.build();

        return ResponseEntity.status(HttpStatus.OK).body(arr.toString());
    }
}
