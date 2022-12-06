package vttp2022.paf.day26.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class TVShowRepo {
    
    public static final String C_TV_SHOWS = "tvshows";


    @Autowired
    private MongoTemplate template;


    //look for english language shows
    //db.tvshows.find({language:"English"})
    public List<Document> findTVShowByLang(String language){

        // create criteria/predicate
        Criteria c = Criteria.where("language").is(language);

        // create query
        Query q = Query.query(c);

        List<Document> results = template.find(q, Document.class, C_TV_SHOWS);
        System.out.println("size of results : " + results.size()); // empty

        return results;
    }

    public List<String> findAllGenres(){

        List<String> genres = template.findDistinct(new Query(), "genres", C_TV_SHOWS, String.class);

        return genres;
    }
}
