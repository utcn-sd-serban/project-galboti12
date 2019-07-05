package ro.utcn.sd.boti.heavyequipment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.boti.heavyequipment.dto.TypeDTO;
import ro.utcn.sd.boti.heavyequipment.entity.Type;
import ro.utcn.sd.boti.heavyequipment.exception.TypeNotFoundException;
import ro.utcn.sd.boti.heavyequipment.repository.RepositoryFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TypeService {
    private final RepositoryFactory repositoryFactory;

    @Transactional
    public List<TypeDTO> getAllTypes() {
        List<Type> types = repositoryFactory.getTypeRepository().findAll();
        return types.stream()
                .map(TypeDTO::ofEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public TypeDTO addType(TypeDTO typeDTO) {
        Type type = new Type(typeDTO.getName());
        type.setId(typeDTO.getId());
        return TypeDTO.ofEntity(repositoryFactory.getTypeRepository().save(type));
    }

    @Transactional
    public void deleteType(Integer id) {
        Type type = repositoryFactory.getTypeRepository().findById(id).orElseThrow(TypeNotFoundException::new);
        repositoryFactory.getTypeRepository().remove(type);
    }
}
