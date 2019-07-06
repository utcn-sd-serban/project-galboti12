package ro.utcn.sd.boti.heavyequipment.repository;

import ro.utcn.sd.boti.heavyequipment.entity.User;

import java.util.Optional;

public interface UserRepository extends GenericRepository<User> {
    Optional<User> findByUsername(String username);
}
