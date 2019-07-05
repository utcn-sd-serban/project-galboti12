package ro.utcn.sd.boti.heavyequipment.repository;

public interface RepositoryFactory {

    EquipmentRepository getEquipmentRepository();

    RentRepository getRentRepository();

    RentDetailsRepository getRentDetailsRepository();

    TypeRepository getTypeRepository();

    UserRepository getUserRepository();
}
