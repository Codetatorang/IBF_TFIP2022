package ibf2022.tfip.ssf.day16workshopRedisBoardgame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.tfip.ssf.day16workshopRedisBoardgame.model.Payload;
import ibf2022.tfip.ssf.day16workshopRedisBoardgame.repository.PayloadRepo;

@Service
public class PayloadService {
    @Autowired
    private PayloadRepo payloadRepo;

    public Payload save(Payload payload) {
        return payloadRepo.save(payload);
    }

    public List<Payload> findAll(){
        return payloadRepo.findAll();
    }

    public Payload findPayloadById(Integer id){
        return payloadRepo.findPayloadById(id);
    }

    public String deletePayloadById(Integer id){
        return payloadRepo.deletePayloadById(id);
    }
}
