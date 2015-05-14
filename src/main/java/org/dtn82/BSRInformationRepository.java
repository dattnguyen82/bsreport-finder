package org.dtn82;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * Created by 212391398 on 5/13/15.
 */

public interface BSRInformationRepository extends MongoRepository<BSRInformation, String> {

    public BSRInformation findByDate(Date date);

    @Query("{ 'tokens' : { $in : ?0 } }")
    public List<BSRInformation> findByTokens(String[] tokens);

}
