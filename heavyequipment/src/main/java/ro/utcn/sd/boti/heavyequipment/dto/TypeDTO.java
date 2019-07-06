package ro.utcn.sd.boti.heavyequipment.dto;

import lombok.Data;
import ro.utcn.sd.boti.heavyequipment.entity.Type;

@Data
public class TypeDTO {
    private Integer id;
    private String name;

    public static TypeDTO ofEntity(Type type) {
        TypeDTO typeDTO = new TypeDTO();
        typeDTO.id = type.getId();
        typeDTO.name = type.getName();
        return typeDTO;
    }
}
