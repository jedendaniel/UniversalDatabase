package hello.repository;

import java.util.List;

import hello.UniversalObject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UniversalRepository extends MongoRepository<UniversalObject, String>, UniversalRepositoryExtension {

    List<UniversalObject> findByName(String name);
//    List<UniversalObject> findWithQuery(String queryString);
//    public Map<String, Object> findByObjects(Map<String, Object> object);

}