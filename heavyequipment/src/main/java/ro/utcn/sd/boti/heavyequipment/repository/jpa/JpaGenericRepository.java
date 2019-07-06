package ro.utcn.sd.boti.heavyequipment.repository.jpa;

import lombok.RequiredArgsConstructor;
import ro.utcn.sd.boti.heavyequipment.repository.GenericRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JpaGenericRepository<T> implements GenericRepository<T> {
    protected final EntityManager entityManager;
    private final Class<T> type;

    public T save(T entity) {
        Object id = null;
        try {
            id = type.getDeclaredMethod("getId").invoke(entity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (id == null) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }

    public void remove(T entity) {
        entityManager.remove(entity);
    }

    public Optional<T> findById(int id) {
        return Optional.ofNullable(entityManager.find(type, id));
    }

    public List<T> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        query.select(query.from(type));
        return entityManager.createQuery(query).getResultList();
    }
}