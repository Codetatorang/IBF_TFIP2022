package ibf2022.tfip.ssf.day16workshopRedisBoardgame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.tfip.ssf.day16workshopRedisBoardgame.model.Payload;
import ibf2022.tfip.ssf.day16workshopRedisBoardgame.service.PayloadService;

@RestController
@RequestMapping(path = "/api/payload")
public class PayloadController {
    @Autowired
    PayloadService payloadSvc;

    @PostMapping
    public ResponseEntity<Payload> save(@RequestBody Payload payload) {
        Payload pload = payloadSvc.save(payload);
        return new ResponseEntity<Payload>(pload, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Payload>> findAll(){
        List<Payload> payloadList = payloadSvc.findAll();
        return new ResponseEntity<List<Payload>>(payloadList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payload> findPayloadById(@PathVariable Integer id){
        Payload pload = payloadSvc.findPayloadById(id);
        return new ResponseEntity<Payload>(pload, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayloadById(@PathVariable Integer id){
        String result = payloadSvc.deletePayloadById(id);
        return new ResponseEntity<String>(result, HttpStatus.OK);
    }
}
