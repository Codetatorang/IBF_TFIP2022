package ibf2022.tfip.paf.day27workshopboardgamesrestfulapi.repositories;

import java.time.LocalDate;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.UpdateResult;

import ibf2022.tfip.paf.day27workshopboardgamesrestfulapi.models.Comments;
import jakarta.json.Json;
import jakarta.json.JsonObject;

@Repository
public class BoardGameRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    private final String COLLECTION_NAME_COMMENTS = "comments";
    private final String COLLECTION_NAME_GAMES = "games";

    public Document insertReview(String user, String comment, int rating, int gid) {

        // ! using projections
        ProjectionOperation filter = Aggregation.project("gid", "name").andExclude("_id");
        MatchOperation match = Aggregation.match(Criteria.where("gid").is(gid));

        // ! build pipepine
        Aggregation pipeline = Aggregation.newAggregation(match, filter);

        //! execute pipeline
        AggregationResults<Comments> results = mongoTemplate.aggregate(pipeline, COLLECTION_NAME_GAMES, Comments.class);

        if (results.getMappedResults().isEmpty())
            return null;

        JsonObject obj = Json.createObjectBuilder()
                .add("user", user)
                .add("comment", comment)
                .add("rating", rating)
                .add("gid", gid)
                .add("posted", LocalDate.now().toString())
                .add("name", results.getMappedResults().get(0).getName())
                .build();

        // convert json to bson
        Document bsonDoc = Document.parse(obj.toString());

        Document result = mongoTemplate.insert(bsonDoc, COLLECTION_NAME_COMMENTS);
        return result;
    }

    public long updateReview(String cid, String comment, int rating) {
        // !todo implement method
        // ObjectId commend_id = new ObjectId(cid);

        // Document commentResult = mongoTemplate.findById(commend_id, Document.class, COLLECTION_NAME_COMMENTS);

        // if(null == commentResult)
        //     return null;

        
        JsonObject obj = Json.createObjectBuilder()
                .add("comment", comment)
                .add("rating", rating)
                .add("posted", LocalDate.now().toString())
                .build();

        //create query
        Query query = Query.query(Criteria.where("_id").is(cid));

        // updateOperation
        Update updateOps = new Update()
                .push("edited", obj.toString());

        UpdateResult result = mongoTemplate.updateFirst(query, updateOps, getClass(), COLLECTION_NAME_COMMENTS);

        return result.getMatchedCount();
    }
}
