package org.dtn82;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by 212391398 on 5/13/15.
 */

public interface BSRInformationRepository extends MongoRepository<BSRInformation, String> {

    @Query("{ 'tokens' : { $in : ?0 } }")
    public List<BSRInformation> findByTokens(String[] tokens);

    @Query("{ 'info' : { $regex : ?0 } }")
    public List<BSRInformation> findByInfo(String pattern);

    //@Query("{ 'info' : { $regex : ?0 } }")
    @Query("{ 'info' : { $regex : ?0 }, 'date' : {'$gte' : ?1, '$lte' : ?2} }")
    public List<BSRInformation> get(String pattern, String start, String End);
}
