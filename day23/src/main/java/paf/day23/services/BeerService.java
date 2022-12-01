package paf.day23.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paf.day23.models.Style;
import paf.day23.repositories.StyleRepositories;

@Service
public class BeerService {
    
    @Autowired
    private StyleRepositories styleRepo;

    public List<Style> getStyles (){
        return styleRepo.getStyles();
    }

    
}
