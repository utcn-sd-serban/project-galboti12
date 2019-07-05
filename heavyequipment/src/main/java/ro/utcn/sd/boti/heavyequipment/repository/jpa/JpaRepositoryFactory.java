package ro.utcn.sd.boti.heavyequipment.repository.jpa;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import ro.utcn.sd.boti.heavyequipment.repository.*;

import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "stackoverflow.repository-type", havingValue = "JPA")
public class JpaRepositoryFactory implements RepositoryFactory {
    private final EntityManager entityManager;

    @Override
    public EquipmentRepository getEquipmentRepository() {
        return new JpaEquipmentRepository(entityManager);
    }

    @Override
    public RentRepository getRentRepository() {
        return new JpaRentRepository(entityManager);
    }

    @Override
    public RentDetailsRepository getRentDetailsRepository() {
        return new JpaRentDetailsRepository(entityManager);
    }

    @Override
    public TypeRepository getTypeRepository() {
        return new JpaTypeRepository(entityManager);
    }

    @Override
    public UserRepository getUserRepository() {
        return new JpaUserRepository(entityManager);
    }
}
