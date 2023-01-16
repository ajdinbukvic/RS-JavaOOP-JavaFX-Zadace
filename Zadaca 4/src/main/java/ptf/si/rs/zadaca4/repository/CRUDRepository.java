package ptf.si.rs.zadaca4.repository;

import java.util.List;

public interface CRUDRepository<T> {
    void save(T value);
    void update(T value);
    List<T> readAll();
    void delete(Long id);
}
