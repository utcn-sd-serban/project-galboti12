package ro.utcn.sd.boti.heavyequipment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.utcn.sd.boti.heavyequipment.dto.TypeDTO;
import ro.utcn.sd.boti.heavyequipment.service.TypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TypeController {
    private final TypeService typeService;

    @GetMapping("/types")
    public List<TypeDTO> getAllTypes() {
        return typeService.getAllTypes();
    }

    @DeleteMapping("/types/{id}")
    public void deleteType(@PathVariable Integer id) {
        typeService.deleteType(id);
    }

    @PostMapping("/types")
    public TypeDTO createType(@RequestBody TypeDTO typeDTO) {
        return typeService.addType(typeDTO);
    }
}
