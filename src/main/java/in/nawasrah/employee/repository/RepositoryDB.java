package in.nawasrah.employee.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryDB<T> {
    List<T> findAll();
    T findById(long id);
    boolean updateById(long id);
    boolean remove(long id);
    boolean insert(T data);
}
