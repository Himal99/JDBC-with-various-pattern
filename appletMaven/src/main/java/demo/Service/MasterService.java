package demo.Service;

import java.util.List;

public interface MasterService<T> {
    int insert(T model) throws Exception;
    List<T> findAll() throws Exception;
    void delete(int id) throws Exception;
    int update(T model) throws Exception;
    T findById(int id) throws Exception;
}
