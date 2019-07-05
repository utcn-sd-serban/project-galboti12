package ro.utcn.sd.boti.heavyequipment.repository;

import ro.utcn.sd.boti.heavyequipment.entity.Equipment;

import java.util.List;

public interface EquipmentRepository extends GenericRepository<Equipment>{
    List<Equipment> searchByName(String s);
}
