package ro.utcn.sd.boti.heavyequipment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.utcn.sd.boti.heavyequipment.dto.EquipmentDTO;
import ro.utcn.sd.boti.heavyequipment.service.EquipmentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EquipmentController {
    private final EquipmentService equipmentService;

    @PostMapping("/equipment")
    public EquipmentDTO createEquipment(@RequestBody EquipmentDTO dto) {
        return equipmentService.addEquipment(dto);
    }

    @GetMapping("/equipment/{equipmentId}")
    public EquipmentDTO getEquipmentById(@PathVariable Integer equipmentId) {
        return equipmentService.getEquipmentById(equipmentId);
    }

    @DeleteMapping("/equipment/{equipmentId}")
    public void deleteEquipment(@PathVariable Integer equipmentId) {
        equipmentService.deleteEquipment(equipmentId);
    }

    @PutMapping("/equipment/{equipmentId}")
    public EquipmentDTO updateEquipment(@PathVariable Integer equipmentId, @RequestBody EquipmentDTO dto) {
        return equipmentService.updateEquipment(equipmentId, dto);
    }

    @GetMapping("/equipment")
    public List<EquipmentDTO> queryEquipment(@RequestParam(value = "name", required = false) String name,
                                             @RequestParam(value = "typeId", required = false) Integer typeId) {
        if (name == null && typeId == null) {
            return equipmentService.getAllEquipment();
        } else if (name == null) {
            return equipmentService.getEquipmentOfType(typeId);
        } else if (typeId == null) {
            return equipmentService.getEquipmentByName(name);
        } else {
            return equipmentService.getEquipmentByNameOfType(name, typeId);
        }
    }
}
