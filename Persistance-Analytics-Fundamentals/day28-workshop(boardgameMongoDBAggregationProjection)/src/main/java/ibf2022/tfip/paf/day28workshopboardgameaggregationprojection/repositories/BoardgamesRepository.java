package ibf2022.tfip.paf.day28workshopboardgameaggregationprojection.repositories;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@Repository
public class BoardgamesRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    private final String COLLECTION_NAME_GAMES = "games";
    private final String COLLECTION_NAME_COMMENTS = "comments";

    public Document getReviewByBoardGameId(int gid) {
        // ! fetch games using operations
        ProjectionOperation filter = Aggregation.project().andInclude("gid", "name", "year", "users_rated", "url")
                .and("ranking").as("rank").and("image").as("thumbnail").andExclude("_id");
        GroupOperation group = Aggregation.group().avg("ranking").as("average");
        MatchOperation match = Aggregation.match(Criteria.where("gid").is(gid));

        // ! fetch comments based on gid
        // todo get the comments based on _id then save in an array
        MatchOperation matchcomments = Aggregation.match(Criteria.where("gid").is(gid));

        // ! build pipelines
        Aggregation pipeline = Aggregation.newAggregation(match, filter);
        Aggregation groupPipeline = Aggregation.newAggregation(group);

        Aggregation commentsPipeline = Aggregation.newAggregation(matchcomments);

        // ! execute pipelines
        Document results = mongoTemplate.aggregate(pipeline, COLLECTION_NAME_GAMES, Document.class).getMappedResults()
                .get(0);
        Document resultsAverage = mongoTemplate.aggregate(groupPipeline, COLLECTION_NAME_GAMES, Document.class)
                .getMappedResults().get(0);

        AggregationResults<Document> commentsResults = mongoTemplate.aggregate(commentsPipeline,
                COLLECTION_NAME_COMMENTS, Document.class);

        // !put timestamps and avg into results
        results.put("average", resultsAverage.get("average"));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        results.put("timestamp", LocalTime.now().format(formatter));

        List<String> commentArray = new ArrayList<String>();

        // !add comments _id reviews into bson array then add the array into the results
        // document.
        for (Document doc : commentsResults.getMappedResults()) {
            commentArray.add("/review/" + doc.get("_id"));
        }

        results.put("reviews", commentArray);
        return results;
    }

    /**
     * @param rating
     * @return
     */
    public Optional<String> getGamesByRating(String rating){
        //todo implement method
        LimitOperation limit = Aggregation.limit(5);
        ProjectionOperation filter  = Aggregation.project("user", "gid", "rating").and("c_text").as("comments").and("_id").as("review_id").andExclude("_id");
        
        AggregationResults<Document> result;
        
        if(rating.equalsIgnoreCase("highest")){
            SortOperation sort = Aggregation.sort(Direction.DESC, "rating");
            Aggregation pipline = Aggregation.newAggregation(sort, limit, filter);
            result  = mongoTemplate.aggregate(pipline, COLLECTION_NAME_COMMENTS, Document.class);
            
        }else if (rating.equalsIgnoreCase("lowest")){
            SortOperation sort = Aggregation.sort(Direction.ASC,"rating");
            Aggregation pipline = Aggregation.newAggregation(sort, limit, filter);
            result  = mongoTemplate.aggregate(pipline, COLLECTION_NAME_COMMENTS, Document.class);
            
        }else{
            //rating is some other wording
            return Optional.empty();
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

        JsonObject resultObj = Json.createObjectBuilder()
                .add("rating", rating)
                .add("games", result.getMappedResults().toString())
                .add("timestamp", LocalTime.now().format(formatter))
                .build();

        //print results for testing
        System.out.println("result:" + resultObj);


        return Optional.of(resultObj.toString());
        
    }
}
