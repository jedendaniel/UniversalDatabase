package hello.repository;

import hello.UniversalObject;

import java.util.List;

public interface UniversalRepositoryCustom {
    List<UniversalObject> findWithQuery(String queryString);
}
