package ibf2022.tfip.ssf.day16workshopRedisBoardgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.tfip.ssf.day16workshopRedisBoardgame.model.Boardgame;
import ibf2022.tfip.ssf.day16workshopRedisBoardgame.repository.BoardgameRepo;

@Service
public class BoardgameService {
    @Autowired
    private BoardgameRepo boardgameRepo;

    public Boardgame save(Boardgame boardgame) {
        return boardgameRepo.save(boardgame);
    }

    public Boardgame findBoardgameById(Integer id) {
        return boardgameRepo.findBoardgameById(id);
    }

    public Boardgame update(Boardgame boardgame){
        return boardgameRepo.save(boardgame);
    }
}
