package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UniversalRepository extends MongoRepository<UniversalObject, String>, IUniversalRepositoryImpl {

    public List<UniversalObject> findByName(String name);
//    public Map<String, Object> findByObjects(Map<String, Object> object);

}