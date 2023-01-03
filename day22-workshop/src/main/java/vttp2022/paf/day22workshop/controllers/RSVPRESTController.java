package vttp2022.paf.day22workshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import vttp2022.paf.day22workshop.models.RSVP;
import vttp2022.paf.day22workshop.repositories.RSVPRepo;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class RSVPRESTController {

    @Autowired
    private RSVPRepo rsRepo;

    // get all rsvps
    @GetMapping(path = "/rsvps")
    public ResponseEntity<String> getAllRSVP(){

        List<RSVP> rsvp = rsRepo.getAllRsvp();

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for(RSVP r : rsvp)
            arrBuilder.add(r.toJSON());
        JsonArray result = arrBuilder.build();
        System.out.println("" + result.toString());

        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(result.toString());
    }

    // search by name
    @GetMapping(path = "/rsvp", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<String> searchRSVPByName(@RequestParam( value = "q", required=true) String name){

        List<RSVP> rsvps = rsRepo.queryRSVPByName(name);

        if (rsvps.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("%s is not found in the database".formatted(name));
        }

        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        for(RSVP r : rsvps){
            arrBuilder.add(r.toJSON());
        }
        JsonArray result = arrBuilder.build();
        System.out.println("" + result.toString());

        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(result.toString());

    }

    //create rsvp
    @PostMapping(path = "/rsvp", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postRsvp(@RequestBody String json){

        RSVP r = new RSVP();

        try {
            r = RSVP.create(json);

            rsRepo.insertRSVP(r);

            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("RSVP created for %s".formatted(r.getName()));


        } catch (Exception e) {
                JsonObject jObj = Json.createObjectBuilder()
                                .add("error", e.getMessage())
                                .build();
                return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(jObj.toString());
        }
    }
    
}
