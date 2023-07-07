package ibf2022.tfip.paf.day27workshopboardgamesrestfulapi.controllers;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.tfip.paf.day27workshopboardgamesrestfulapi.models.EditedComments;
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

    @PutMapping("/{review_id}")
    public ResponseEntity<String> updateComments(@RequestBody EditedComments comment,
            @PathVariable("review_id") String id) {
        int rating = comment.getRating();
        String commentString = comment.getComment();
        // rating constraint
        if (rating > 10)
            rating = 10;
        else if (rating < 0)
            rating = 0;

        //handle empty comment
        if(null == commentString)
            commentString = "";

        //proceed with update
        long result = boardGameService.updateReview(id, commentString, rating);

        // return bad request if cid does not exist
        if (0 == result)
            return ResponseEntity.badRequest().body("cid of: " + id + " does not exist");

        return ResponseEntity.ok("Update successful");

    }

    @GetMapping("{review_id}")
    public ResponseEntity<String> getLatestCommentRating(@PathVariable("review_id") String rid){
        Document result = boardGameService.getCommentandRating(rid);
        if(null == result)
            return ResponseEntity.badRequest().body("comment with id of: " + rid + " does not exist");
        return ResponseEntity.ok(result.toString());
    }

    @GetMapping(path = "{review_id}/history", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCommentHistory(@PathVariable("review_id") String rid){
        //todo implement this method
        return null;
    }

    
}
