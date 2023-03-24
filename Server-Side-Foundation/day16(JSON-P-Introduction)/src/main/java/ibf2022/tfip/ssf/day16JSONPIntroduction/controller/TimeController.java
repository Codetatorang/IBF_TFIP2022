package ibf2022.tfip.ssf.day16JSONPIntroduction.controller;

import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@RestController
@RequestMapping(path = "/time")
public class TimeController {
    /* 
     Request 
     >GET /time
     >Accept: application/type
     Response
     < 200 OK
     <Content-Type: application/json
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTimeAsJson(){
        String time = (new Date()).toString();
        JsonObject payload = Json.createObjectBuilder()
            .add("time", time)
            .build();
        return ResponseEntity.ok(payload.toString());
    }

    //text/plain
    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getTimeAsText(){
        String time = (new Date()).toString();
        return ResponseEntity.ok("The current time is : %s".formatted(time));
    }

    //text/html
    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> getTimeAsHTML(){
        String time = (new Date()).toString();
        return ResponseEntity.status(200)
            .header("X-Generated-by",  "Spring-Boot")
            .body(
                "<h1>The current time/date is : %s</h1>".formatted(time)
            );
            
    }
}
