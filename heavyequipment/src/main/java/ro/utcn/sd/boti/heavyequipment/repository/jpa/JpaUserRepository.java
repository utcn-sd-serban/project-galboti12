package ro.utcn.sd.boti.heavyequipment.repository.jpa;

import ro.utcn.sd.boti.heavyequipment.entity.User;
import ro.utcn.sd.boti.heavyequipment.repository.UserRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaUserRepository extends JpaGenericRepository<User> implements UserRepository {

    public JpaUserRepository(EntityManager entityManager) {
        super(entityManager, User.class);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        List<User> result = entityManager.createQuery("select user from User user where user.username like ?1").
                setParameter(1, username).getResultList();
        return result.isEmpty() ? Optional.empty() : Optional.ofNullable(result.get(0));
    }
}
