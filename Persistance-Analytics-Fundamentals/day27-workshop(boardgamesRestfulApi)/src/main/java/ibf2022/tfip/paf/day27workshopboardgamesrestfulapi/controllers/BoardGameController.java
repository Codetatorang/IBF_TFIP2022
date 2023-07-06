package ibf2022.tfip.paf.day27workshopboardgamesrestfulapi.controllers;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.tfip.paf.day27workshopboardgamesrestfulapi.serivces.BoardGameService;

@RestController
@RequestMapping(path = "/review")
public class BoardGameController {
    @Autowired
    private BoardGameService boardGameService;

    @PostMapping()
    public ResponseEntity<String> insertComments(@RequestBody MultiValueMap<String, String> comment) {

        // proceed with insertion
        Document result = boardGameService.insertReview(comment.getFirst("user"), comment.getFirst("comment"),
                Integer.parseInt(comment.getFirst("rating")), Integer.parseInt(comment.getFirst("gid")));

        // return bad request if gid does not exist
        if (null == result)
            return ResponseEntity.badRequest().body("gid of: " + comment.getFirst("gid") + " does not exist");

        // return response
        return ResponseEntity.ok(result.toString());

    }

    @Validated
    @PutMapping("{review_id}")
    public ResponseEntity<String> updateComments(@RequestBody MultiValueMap<String, String> comment,
            @PathVariable int id) {
        // todo implement method
        int rating = Integer.parseInt(comment.getFirst("rating"));

        // rating constraint
        if (rating > 10)
            rating = 10;
        else if (rating < 0)
            rating = 0;

        return ResponseEntity.ok("Update successful");

    }

}
