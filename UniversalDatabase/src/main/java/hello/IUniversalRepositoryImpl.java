package hello;

import java.util.List;

public interface IUniversalRepositoryImpl {
    public List<UniversalObject> findWithQuery(String queryString);
}
