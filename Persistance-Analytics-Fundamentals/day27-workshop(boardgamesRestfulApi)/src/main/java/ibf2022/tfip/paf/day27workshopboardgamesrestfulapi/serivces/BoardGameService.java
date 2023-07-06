package ibf2022.tfip.paf.day27workshopboardgamesrestfulapi.serivces;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ibf2022.tfip.paf.day27workshopboardgamesrestfulapi.repositories.BoardGameRepository;

@Service
public class BoardGameService {
    // !todo implement method
    @Autowired
    private BoardGameRepository boardGameRepository;

    public Document insertReview(String user, String comment, int rating, int gid) {
        return boardGameRepository.insertReview(user, comment, rating, gid);
    }

    public long updateReview(String cid, String comment, int rating) {
        return boardGameRepository.updateReview(cid, comment, rating);
    }
}
