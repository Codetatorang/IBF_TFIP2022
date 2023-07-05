package ibf2022.tfip.paf.day26workshopboardgamesMongoDB.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.tfip.paf.day26workshopboardgamesMongoDB.models.Game;
import ibf2022.tfip.paf.day26workshopboardgamesMongoDB.models.GameDetails;
import ibf2022.tfip.paf.day26workshopboardgamesMongoDB.services.BoardgamesService;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;

@RestController
@RequestMapping("/games")
public class BoardgamesController {
    // loggimg
    Logger logger = org.slf4j.LoggerFactory.getLogger(BoardgamesController.class);

    @Autowired
    private BoardgamesService boardgamesService;

    @GetMapping()
    public ResponseEntity<String> getGames(@RequestParam(name = "offset", defaultValue = "0") int offset,
            @RequestParam(name = "limit", defaultValue = "25") int limit) {
        List<Game> docs = boardgamesService.getBoardgames(offset, limit);

        //total games count
        int total = (int) boardgamesService.getBoardGamesCount();
        
        //create json array builder
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        
        //add each game to the array builder
        for (Game game : docs) {
            jsonArrayBuilder.add(Json.createObjectBuilder()
                    .add("game_id", game.getGid())
                    .add("name", game.getName()));
        }
        //build the json array
        JsonArray docsJson = jsonArrayBuilder.build();

        //create json object
        JsonObject docsJsonObj = Json.createObjectBuilder()
                .add("games", docsJson)
                .add("offset", offset)
                .add("limit", limit)
                .add("total", total)
                .add("timestamp",  LocalDateTime.now().toString().substring(0, 16)) //get current time up to the minute
                .build();

        return ResponseEntity.ok(docsJsonObj.toString());
    }

    @GetMapping("/rank")
    public ResponseEntity<String> getBoardGamesbyRank(@RequestParam(name="offset", defaultValue = "0") int offset, @RequestParam(name="limit", defaultValue = "25") int limit){
        List<Game> docs = boardgamesService.getBoardGamesByRank(offset, limit);

        //total games count
        int total = (int) boardgamesService.getBoardGamesCount();
        
        //create json array builder
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        
        //add each game to the array builder
        for (Game game : docs) {
            jsonArrayBuilder.add(Json.createObjectBuilder()
                    .add("game_id", game.getGid())
                    .add("name", game.getName()));
        }
        //build the json array
        JsonArray docsJson = jsonArrayBuilder.build();

        //create json object
        JsonObject docsJsonObj = Json.createObjectBuilder()
                .add("games", docsJson)
                .add("offset", offset)
                .add("limit", limit)
                .add("total", total)
                .add("timestamp",  LocalDateTime.now().toString().substring(0, 16)) //get current time up to the minute
                .build();

        return ResponseEntity.ok(docsJsonObj.toString());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getBoardGameById(@PathVariable("id") int gid){
        GameDetails game = boardgamesService.getBoardGameById(gid).get();

        if(game == null){
            return ResponseEntity.notFound().build();
        }

        //create json object
        JsonObject jsonObj = Json.createObjectBuilder()
                .add("game_id", game.getGid())
                .add("name", game.getName())
                .add("year", game.getYear())
                .add("ranking", game.getRanking())
                .add("average", game.getAverage())
                .add("user_rated", game.getUsers_rated())
                .add("url", game.getUrl())
                .add("timestamp",  LocalDateTime.now().toString().substring(0, 16)) //get current time up to the minute
                .build();
        return ResponseEntity.ok(jsonObj.toString());
    }
}
