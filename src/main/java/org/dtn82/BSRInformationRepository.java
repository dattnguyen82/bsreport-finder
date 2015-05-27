package org.dtn82;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by 212391398 on 5/13/15.
 */

public interface BSRInformationRepository extends MongoRepository<BSRInformation, String> {

//    public BSRInformation findByDate(Date date);
////
    @Query("{ 'tokens' : { $in : ?0 } }")
    public List<BSRInformation> findByTokens(String[] tokens);
////
////    @Query("{ 'date' : { '$gte' : ?0 }, 'date' : { '$lte' : ?1 } }")
////    public List<BSRInformation> findByDateRange(Date start, Date End);

//    {"tokens": {"$in":["bill"]},"date": {"$gte": "2015-01-01","$lte": "2015-05-01"}}


    @Query("{ 'info' : { $regex : ?0 } }")
    public List<BSRInformation> findByInfo(String pattern);

    @Query("{ 'info' : { $regex : ?0 }, 'date' : { '$gte' : ?1, '$lte' : ?2 } }")
    public List<BSRInformation> get(String pattern, Date start, Date End);
}
