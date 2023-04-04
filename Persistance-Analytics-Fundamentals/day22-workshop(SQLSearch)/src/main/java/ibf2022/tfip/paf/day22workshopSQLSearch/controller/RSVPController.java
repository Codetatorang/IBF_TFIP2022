package ibf2022.tfip.paf.day22workshopSQLSearch.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.tfip.paf.day22workshopSQLSearch.model.RSVP;
import ibf2022.tfip.paf.day22workshopSQLSearch.service.RSVPService;

@RestController
@RequestMapping(path = "/api")
public class RSVPController {
    Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    RSVPService rsvpSvc;

    // @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    // public ResponseEntity<List<RSVP>> getAllRSVP(){
    //     List<RSVP> rsvp = rsvpSvc.getAllRSVP();
    //     return ResponseEntity.ok(rsvp);
    // }

    @GetMapping(path="/rsvps", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RSVP>> getAllCustomers() {
        List<RSVP> rsvpList = rsvpSvc.getAllRSVP();
        if(rsvpList.isEmpty())
            return ResponseEntity.notFound().build();
        return  ResponseEntity.ok().body(rsvpList);

    }

    @GetMapping(path="/rsvp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RSVP>> getRSVPByName(@RequestParam("q") String name) {
        List<RSVP> rsvpList = rsvpSvc.getRSVPByName(name);
        if (rsvpList.isEmpty())
            return ResponseEntity.notFound().header("message", "no RSVP by the name %s".formatted(name)).build();
        return new ResponseEntity<List<RSVP>>(rsvpList, HttpStatus.OK);
    }

    @PostMapping(path = "/rsvp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> saveRSVP(@RequestBody RSVP rsvp) {
        Boolean bSaved = rsvpSvc.saveRSVP(rsvp);
        return new ResponseEntity<Boolean>(bSaved, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{email}", produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Boolean> updateRSVP(@RequestBody RSVP rsvp) {
        boolean bUpdated = rsvpSvc.updateRSVP(rsvp);
        if(!bUpdated)
            return new ResponseEntity<Boolean>(bUpdated, HttpStatus.NOT_FOUND);
        return new ResponseEntity<Boolean>(bUpdated, HttpStatus.OK);
    }
}
