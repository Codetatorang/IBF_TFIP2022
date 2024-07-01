package ibf2022.tfip.ssf.day16JSONPIntroduction.controller;

import java.io.StringReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@RestController
@RequestMapping(path = "/rsvp", produces = MediaType.APPLICATION_JSON_VALUE)
public class RSVPController {
    private static final Logger logger = LoggerFactory.getLogger(RSVPController.class);

    // application/json
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postAsJson(@RequestBody String payload) {
        logger.info("payload: %s".formatted(payload));

        JsonReader reader = Json.createReader(new StringReader(payload));
        JsonObject jsonObj = reader.readObject();

        String name = jsonObj.getString("name");
        Boolean attending = jsonObj.getBoolean("attending");

        logger.info("Json object name %s, attending %b".formatted(name, attending));

        jsonObj = Json.createObjectBuilder()
                .add("message", "Received %s RSVP".formatted(name))
                .add("attending", attending)
                .build();

        return ResponseEntity
                .status(200)
                .body(jsonObj.toString());
    }

    // application/x-www-form-urlencoded
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> postAsForm(@RequestBody MultiValueMap<String, String> form) {

        String name = form.getFirst("name");
        Boolean attending = Boolean.valueOf(form.getFirst("attending"));

        logger.info("attending: %b".formatted(attending));

        JsonObject payload = Json.createObjectBuilder()
                .add("message", "Received %s RSVP".formatted(name))
                .add("attending", attending)
                .build();

        return ResponseEntity
                .status(201)
                .body(payload.toString());
    }
}
