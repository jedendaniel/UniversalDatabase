package hello.repository;

import java.util.List;

import hello.UniversalObject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UniversalRepository extends MongoRepository<UniversalObject, String>, UniversalRepositoryCustom {

    List<UniversalObject> findByName(String name);
}