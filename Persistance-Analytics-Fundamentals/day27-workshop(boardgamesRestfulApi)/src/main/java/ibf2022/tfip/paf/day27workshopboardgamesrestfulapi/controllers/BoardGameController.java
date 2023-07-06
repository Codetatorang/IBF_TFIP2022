package ibf2022.tfip.paf.day27workshopboardgamesrestfulapi.controllers;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.tfip.paf.day27workshopboardgamesrestfulapi.serivces.BoardGameService;

@RestController
@RequestMapping(path = "/reviews")
public class BoardGameController {
    @Autowired
    private BoardGameService boardGameService;

    @PostMapping()
    public ResponseEntity<String> getComments(@RequestBody MultiValueMap<String, String> comment) {
        // todo: implement method
        System.out.println(comment.getFirst("user"));
        Document result = boardGameService.insertReview(comment.getFirst("user"), comment.getFirst("comment"),
                Integer.parseInt(comment.getFirst("rating")), Integer.parseInt(comment.getFirst("gid")));

        if (result != null) {
            return ResponseEntity.ok(result.toString());
        }
        return ResponseEntity.badRequest().body("Insertion failed");
    }
}
