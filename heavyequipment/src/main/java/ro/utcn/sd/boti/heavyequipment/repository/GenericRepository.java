package ro.utcn.sd.boti.heavyequipment.repository;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T> {
    T save(T entity);

    void remove(T entity);

    Optional<T> findById(int id);

    List<T> findAll();
}
