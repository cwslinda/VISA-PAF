package paf.day23.repositories;

public class Queries {
    
    // public static final String SQL_SELECT_STYLE = 
        // "select distinct s.style_name from styles as s join beers as b on s.id = b.style_id join breweries as brew on b.brewery_id = brew.id";
       
    public static final String SQL_SELECT_STYLE = 
        "select id, style_name from styles order by style_name asc";

    // public static final String SQL_SELECT_BREWERIES_BY_STYLE = 
    //     "select s.style_name, brew.name from styles as s join beers as b on s.id = b.style_id join breweries as brew on b.brewery_id = brew.id where style_name = ?";

    public static final String SQL_SELECT_BREWERIES_BY_STYLE = 
        "SELECT name FROM breweries_styles where id = ?";
    

}
