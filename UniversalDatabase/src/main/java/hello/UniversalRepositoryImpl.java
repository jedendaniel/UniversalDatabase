package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UniversalRepositoryImpl implements IUniversalRepositoryImpl {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<UniversalObject> findWithQuery(String queryString) {
        Query basicQuery = new BasicQuery(queryString);
        return mongoTemplate.find(basicQuery,UniversalObject.class);
    }
}
