package ro.utcn.sd.boti.heavyequipment.repository.jpa;

import ro.utcn.sd.boti.heavyequipment.entity.RentDetails;
import ro.utcn.sd.boti.heavyequipment.repository.RentDetailsRepository;

import javax.persistence.EntityManager;

public class JpaRentDetailsRepository extends JpaGenericRepository<RentDetails> implements RentDetailsRepository {
    public JpaRentDetailsRepository(EntityManager entityManager) {
        super(entityManager, RentDetails.class);
    }
}
