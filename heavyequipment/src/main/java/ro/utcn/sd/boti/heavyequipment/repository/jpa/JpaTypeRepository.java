package ro.utcn.sd.boti.heavyequipment.repository.jpa;

import ro.utcn.sd.boti.heavyequipment.entity.Type;
import ro.utcn.sd.boti.heavyequipment.repository.TypeRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaTypeRepository extends JpaGenericRepository<Type> implements TypeRepository {
    public JpaTypeRepository(EntityManager entityManager) {
        super(entityManager, Type.class);
    }

    @Override
    public Optional<Type> findByName(String name) {
        List<Type> result = entityManager.createQuery("select t from Type t where t.name like ?1").
                setParameter(1, name).getResultList();
        return result.isEmpty() ? Optional.empty() : Optional.ofNullable(result.get(0));
    }
}
