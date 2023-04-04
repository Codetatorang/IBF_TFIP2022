package ibf2022.tfip.paf.day22workshopSQLSearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.tfip.paf.day22workshopSQLSearch.model.RSVP;
import ibf2022.tfip.paf.day22workshopSQLSearch.repository.RSVPRepository;

@Service
public class RSVPService {
    @Autowired
    RSVPRepository rsvpRepo;

    public List<RSVP> getAllRSVP(){
        return rsvpRepo.getAllRSVP();
    }

    public List<RSVP> getRSVPByName(String name) {
        return rsvpRepo.getRSVPByName(name);
    }

    public Boolean saveRSVP(RSVP rsvp){
        return rsvpRepo.saveRSVP(rsvp);
    }

    public Boolean updateRSVP(RSVP rsvp){
        return rsvpRepo.updateRSVP(rsvp);
    }
}
