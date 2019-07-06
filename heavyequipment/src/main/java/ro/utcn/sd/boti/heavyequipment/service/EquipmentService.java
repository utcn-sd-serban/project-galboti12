package ro.utcn.sd.boti.heavyequipment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.boti.heavyequipment.dto.EquipmentDTO;
import ro.utcn.sd.boti.heavyequipment.entity.Equipment;
import ro.utcn.sd.boti.heavyequipment.entity.Type;
import ro.utcn.sd.boti.heavyequipment.exception.EquipmentNotFoundException;
import ro.utcn.sd.boti.heavyequipment.exception.TypeNotFoundException;
import ro.utcn.sd.boti.heavyequipment.repository.RepositoryFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EquipmentService {
    private final RepositoryFactory repositoryFactory;

    @Transactional
    public List<EquipmentDTO> searchEquipmentByName(String name) {
        List<Equipment> equipmentList = repositoryFactory.getEquipmentRepository().searchByName(name);
        return equipmentList.stream().
                map(EquipmentDTO::ofEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public EquipmentDTO getEquipmentById(Integer id) {
        return EquipmentDTO.ofEntity(repositoryFactory.getEquipmentRepository().findById(id).orElseThrow(EquipmentNotFoundException::new));
    }

    @Transactional
    public EquipmentDTO addEquipment(EquipmentDTO equipmentDTO) {
        Type type = findOrCreateType(equipmentDTO.getTypeName());
        Equipment equipment = new Equipment(type, equipmentDTO.getName(), equipmentDTO.getCost(), equipmentDTO.getYear());
        return EquipmentDTO.ofEntity(repositoryFactory.getEquipmentRepository().save(equipment));
    }

    @Transactional
    public void deleteEquipment(Integer equipmentId) {
        Equipment equipment = repositoryFactory.getEquipmentRepository().findById(equipmentId).orElseThrow(EquipmentNotFoundException::new);
        repositoryFactory.getEquipmentRepository().remove(equipment);
    }

    @Transactional
    public EquipmentDTO updateEquipment(Integer equipmentId, EquipmentDTO equipmentDTO) {
        Type type = findOrCreateType(equipmentDTO.getTypeName());
        Equipment equipment = new Equipment(type, equipmentDTO.getName(), equipmentDTO.getCost(), equipmentDTO.getYear());
        equipment.setId(equipmentId);
        return EquipmentDTO.ofEntity(repositoryFactory.getEquipmentRepository().save(equipment));
    }

    @Transactional
    public List<EquipmentDTO> getEquipmentOfType(Integer typeId) {
        Type type = repositoryFactory.getTypeRepository().findById(typeId).orElseThrow(TypeNotFoundException::new);
        if (type != null) {
            List<Equipment> equipmentList = type.getEquipmentList();
            return equipmentList.stream()
                    .map(EquipmentDTO::ofEntity)
                    .collect(Collectors.toList());
        } else return new ArrayList<EquipmentDTO>();
    }

    @Transactional
    public List<EquipmentDTO> getEquipmentByName(String name) {
        List<Equipment> equipmentList = repositoryFactory.getEquipmentRepository().searchByName(name);
        return equipmentList.stream()
                .map(EquipmentDTO::ofEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<EquipmentDTO> getAllEquipment() {
        List<Equipment> equipmentList = repositoryFactory.getEquipmentRepository().findAll();
        return equipmentList.stream()
                .map(EquipmentDTO::ofEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<EquipmentDTO> getEquipmentByNameOfType(String name, Integer typeId) {
        List<Equipment> equipmentList = repositoryFactory.getEquipmentRepository().searchByName(name);
        return equipmentList.stream()
                .filter(e -> e.getType().getId() == typeId)
                .map(EquipmentDTO::ofEntity)
                .collect(Collectors.toList());
    }

    public Type findOrCreateType(String name) {
        Type type = repositoryFactory.getTypeRepository().findByName(name).orElse(null);
        //create new type if not found
        if (type == null) {
            type.setName(name);
            type = repositoryFactory.getTypeRepository().save(type);
        }
        return type;
    }
}
