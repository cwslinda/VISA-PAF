package paf.day23.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import paf.day23.models.Style;

import static paf.day23.repositories.Queries.*;

@Repository
public class StyleRepositories {
    
    @Autowired 
    private JdbcTemplate jdbcTemplate;

    public List<Style> getStyles(){

        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_SELECT_STYLE);
        
        List<Style> styles = new LinkedList<>();
        while(rs.next())
            styles.add(Style.create(rs));

        return styles;
    }
}
