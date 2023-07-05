package ibf2022.tfip.paf.day26workshopboardgamesMongoDB.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SkipOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import ibf2022.tfip.paf.day26workshopboardgamesMongoDB.models.Game;
import ibf2022.tfip.paf.day26workshopboardgamesMongoDB.models.GameDetails;

@Repository
public class BoardgamesRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    private final String COLLECTION_NAME = "games";

    public List<Game> getBoardGames(int offset, int limit) {

        // ! using projections
        ProjectionOperation filter = Aggregation.project("gid", "name").andExclude("_id");
        SkipOperation skip = Aggregation.skip(offset);
        LimitOperation limitOp = Aggregation.limit(limit);

        // ! build pipepine
        Aggregation pipeline = Aggregation.newAggregation(filter, skip, limitOp);

        // ! execute pipeline
        List<Game> results = mongoTemplate.aggregate(pipeline, COLLECTION_NAME, Game.class).getMappedResults();
        return results;
    }

    public long getBoardGamesCount() {
        return mongoTemplate.count(new Query(), COLLECTION_NAME);
    }

    public List<Game> getBoardGamesByRank(int offset, int limit) {
        // !using projections
        ProjectionOperation filter = Aggregation.project("gid", "name").andExclude("_id");
        SkipOperation skip = Aggregation.skip(offset);
        LimitOperation limitOp = Aggregation.limit(limit);
        SortOperation sort = Aggregation.sort(Direction.ASC, "ranking");

        // ! build pipepine
        Aggregation pipeline = Aggregation.newAggregation(sort, skip, limitOp, filter);

        // ! execute pipeline
        List<Game> results = mongoTemplate.aggregate(pipeline, COLLECTION_NAME, Game.class).getMappedResults();

        return results;
    }

    public Optional<GameDetails> getBoardGameById(int gid) {
        // ! using query to match for id
        Query query = Query.query(Criteria.where("gid").is(gid));
        GameDetails game = mongoTemplate.findOne(query, GameDetails.class, COLLECTION_NAME);

        // ! using projections to get average ranking
        ProjectionOperation filter = Aggregation.project(GameDetails.class).andExclude("_id");
        GroupOperation group = Aggregation.group().avg("ranking").as("average");

        // !building pipeline
        Aggregation pipeline = Aggregation.newAggregation(group, filter);

        // ! execute pipeline
        AggregationResults<GameDetails> results = mongoTemplate.aggregate(pipeline, COLLECTION_NAME, GameDetails.class);

        // ! set average result into game
        if (null != game)
            game.setAverage(results.getMappedResults().get(0).getAverage());
            
        return Optional.ofNullable(game);
    }
}
