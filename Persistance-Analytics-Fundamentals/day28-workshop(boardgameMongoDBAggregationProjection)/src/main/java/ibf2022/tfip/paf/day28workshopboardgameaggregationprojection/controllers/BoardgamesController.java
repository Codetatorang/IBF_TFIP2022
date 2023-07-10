package ibf2022.tfip.paf.day28workshopboardgameaggregationprojection.controllers;

import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.tfip.paf.day28workshopboardgameaggregationprojection.serivces.BoardgamesSerivce;

@RestController
@RequestMapping("/game")
public class BoardgamesController {
    @Autowired
    private BoardgamesSerivce boardgamesSerivce;

    @GetMapping("{game_id}/reviews")
    public ResponseEntity<Document> showAllReviews(@PathVariable int game_id) {
        // get doc result
        Document result = boardgamesSerivce.getReviewByBoardGameId(game_id);

        if (null == result) {
            Document notFound = new Document("message", "cannot find a game with gid of " + game_id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFound);
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("{rating}")
    public ResponseEntity<String> getGamesByRanking(@PathVariable("rating") String rating) {
        Optional<String> docContainer = boardgamesSerivce.getGamesByRating(rating);

        if(docContainer.isEmpty()){
            Document doc = new Document("message", "an error has occured");
            // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(doc);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(doc.toString());
        }
        

        return ResponseEntity.ok(docContainer.get());
    }
}
