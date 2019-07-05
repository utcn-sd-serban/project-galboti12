package ro.utcn.sd.boti.heavyequipment.repository.jpa;

import ro.utcn.sd.boti.heavyequipment.entity.Equipment;
import ro.utcn.sd.boti.heavyequipment.repository.EquipmentRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class JpaEquipmentRepository extends JpaGenericRepository<Equipment> implements EquipmentRepository {
    public JpaEquipmentRepository(EntityManager entityManager) {
        super(entityManager, Equipment.class);
    }

    @Override
    public List<Equipment> searchByName(String s) {
        List<Equipment> result =  entityManager.createQuery("select q from Equipment q where q.name like ?1").
                setParameter(1, "%"+s+"%").getResultList();
        return result;
    }
}
