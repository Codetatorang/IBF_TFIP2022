package ibf2022.tfip.ssf.day16workshopRedisBoardgame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2022.tfip.ssf.day16workshopRedisBoardgame.model.Boardgame;
import ibf2022.tfip.ssf.day16workshopRedisBoardgame.service.BoardgameService;

@RestController
@RequestMapping("/api/boardgame")
public class BoardgameController {
    @Autowired
    BoardgameService boardgameSvc;

    @PostMapping
    public ResponseEntity<Boardgame> save(@RequestBody Boardgame boardgame) {
        Boardgame bg = boardgameSvc.save(boardgame);
        return new ResponseEntity<Boardgame>(bg, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boardgame> findBoardgameById(@PathVariable Integer id) {
        Boardgame bg = boardgameSvc.findBoardgameById(id);

        if (null == bg)
            return new ResponseEntity<Boardgame>(bg, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<Boardgame>(bg, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Boardgame> update(@RequestBody Boardgame boardgame) {
        Boardgame bg = boardgameSvc.update(boardgame);
        return new ResponseEntity<Boardgame>(bg, HttpStatus.OK);
    }
}