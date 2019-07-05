package ro.utcn.sd.boti.heavyequipment.dto;

import lombok.Data;
import ro.utcn.sd.boti.heavyequipment.entity.Equipment;

@Data
public class EquipmentDTO {
    private Integer id;
    private String typeName;
    private String name;
    private Integer cost;
    private Integer year;

    public static EquipmentDTO ofEntity(Equipment equipment) {
        EquipmentDTO equipmentDTO = new EquipmentDTO();
        equipmentDTO.id = equipment.getId();
        equipmentDTO.typeName = equipment.getType().getName();
        equipmentDTO.name = equipment.getName();
        equipmentDTO.cost = equipment.getCost();
        equipmentDTO.year = equipment.getYear();
        return equipmentDTO;
    }
}
