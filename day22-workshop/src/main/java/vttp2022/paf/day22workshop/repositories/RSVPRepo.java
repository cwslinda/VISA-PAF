package vttp2022.paf.day22workshop.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2022.paf.day22workshop.models.RSVP;

import static vttp2022.paf.day22workshop.repositories.Queries.*;

import java.util.LinkedList;
import java.util.List;

@Repository
public class RSVPRepo {
    
    @Autowired
    private JdbcTemplate template;

    public List<RSVP> getAllRsvp(){

        final List<RSVP> rsvp = new LinkedList<>();

        final SqlRowSet rs = template.queryForRowSet(SQL_SELECT_RSVPS);

        while(rs.next()){
            rsvp.add(RSVP.create(rs));
        }

        return rsvp;


    }

    public List<RSVP> queryRSVPByName(String name){
        
        final List<RSVP> rsvps = new LinkedList<>();

        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_RSVP_BY_NAME, "%%%s%%".formatted(name));
        
        while(rs.next()){
            RSVP rsvp = RSVP.create(rs);
            rsvps.add(rsvp);
        }

        return rsvps;
    }

    // add new data into the database, check if there is an existing record already
    public boolean insertRSVP(RSVP rsvp){
        SqlRowSet rs = template.queryForRowSet(SQL_SELECT_RSVP_BY_EMAIL, rsvp.getEmail());

        if(rs.next()){
            return updateRSVP(rsvp);
        } else {
            return template.update(SQL_INSERT_NEW_RSVP, rsvp.getName(), rsvp.getEmail(), rsvp.getPhone(), rsvp.getConfirmationDate(), rsvp.getComments()) > 0;
        }
    }

    public boolean updateRSVP(RSVP rsvp){
        return template.update(SQL_UPDATE_RSVP, rsvp.getName(), rsvp.getPhone(), rsvp.getConfirmationDate(), rsvp.getComments(), rsvp.getEmail()) > 0;
    }
}
