package hello.repository;

import hello.UniversalObject;

import java.util.List;

public interface UniversalRepositoryExtension {
    List<UniversalObject> findWithQuery(String queryString);
}
