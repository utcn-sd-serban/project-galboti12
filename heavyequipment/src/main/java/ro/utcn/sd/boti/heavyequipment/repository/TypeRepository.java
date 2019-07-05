package ro.utcn.sd.boti.heavyequipment.repository;

import ro.utcn.sd.boti.heavyequipment.entity.Type;

import java.util.Optional;

public interface TypeRepository extends GenericRepository<Type> {
    Optional<Type> findByName(String name);
}
