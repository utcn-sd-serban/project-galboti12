package ro.utcn.sd.boti.heavyequipment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.boti.heavyequipment.dto.UserDTO;
import ro.utcn.sd.boti.heavyequipment.entity.User;
import ro.utcn.sd.boti.heavyequipment.exception.UserNotFoundException;
import ro.utcn.sd.boti.heavyequipment.repository.RepositoryFactory;

@Service
@RequiredArgsConstructor
public class UserManagementService {
    private final RepositoryFactory repositoryFactory;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserDTO addUser(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword()), userDTO.getIsAdmin(), userDTO.getAddress());
        return UserDTO.ofEntity(repositoryFactory.getUserRepository().save(user));
    }

    @Transactional
    public void deleteUser(Integer userId) {
        User user = repositoryFactory.getUserRepository().findById(userId).orElseThrow(UserNotFoundException::new);
        repositoryFactory.getUserRepository().remove(user);
    }

    @Transactional
    public UserDTO updateUser(Integer userId, UserDTO userDTO) {
        User user = new User(userId, userDTO.getUsername(), passwordEncoder.encode(userDTO.getPassword()), userDTO.getIsAdmin(), userDTO.getAddress());
        return UserDTO.ofEntity(repositoryFactory.getUserRepository().save(user));
    }

    @Transactional
    public UserDTO getUserByUsername(String username) {
        return UserDTO.ofEntity(repositoryFactory.getUserRepository().findByUsername(username).orElseThrow(UserNotFoundException::new));
    }

    @Transactional
    public UserDTO getUserById(Integer id) {
        return UserDTO.ofEntity(repositoryFactory.getUserRepository().findById(id).orElseThrow(UserNotFoundException::new));
    }
}
