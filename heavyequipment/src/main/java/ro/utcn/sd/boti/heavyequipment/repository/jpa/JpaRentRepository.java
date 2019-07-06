package ro.utcn.sd.boti.heavyequipment.repository.jpa;

import ro.utcn.sd.boti.heavyequipment.entity.Rent;
import ro.utcn.sd.boti.heavyequipment.repository.RentRepository;

import javax.persistence.EntityManager;

public class JpaRentRepository extends JpaGenericRepository<Rent> implements RentRepository {

    public JpaRentRepository(EntityManager entityManager) {
        super(entityManager, Rent.class);
    }
}
