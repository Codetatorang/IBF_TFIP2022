package ibf2022.tfip.paf.day26workshopboardgamesMongoDB.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.tfip.paf.day26workshopboardgamesMongoDB.models.Game;
import ibf2022.tfip.paf.day26workshopboardgamesMongoDB.models.GameDetails;
import ibf2022.tfip.paf.day26workshopboardgamesMongoDB.repositories.BoardgamesRepository;

@Service
public class BoardgamesService {
    @Autowired
    private BoardgamesRepository boardgamesRepository;

    public List<Game> getBoardgames(int offset, int limit) {
        return boardgamesRepository.getBoardGames(offset, limit);
    }

    public long getBoardGamesCount() {
        return boardgamesRepository.getBoardGamesCount();
    }

    public List<Game> getBoardGamesByRank(int offset, int limit) {
        return boardgamesRepository.getBoardGamesByRank(offset, limit);
    }

    public Optional<GameDetails> getBoardGameById(int gid) {
        return boardgamesRepository.getBoardGameById(gid);
    }
}
