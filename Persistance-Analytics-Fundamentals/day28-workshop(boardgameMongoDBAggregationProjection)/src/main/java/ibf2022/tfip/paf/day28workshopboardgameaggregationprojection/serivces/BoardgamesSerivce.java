package ibf2022.tfip.paf.day28workshopboardgameaggregationprojection.serivces;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.tfip.paf.day28workshopboardgameaggregationprojection.repositories.BoardgamesRepository;

@Service
public class BoardgamesSerivce {
    @Autowired
    private BoardgamesRepository boardgamesRepository;

        public Document getReviewByBoardGameId(int gid) {
            return boardgamesRepository.getReviewByBoardGameId(gid);
        }
}
