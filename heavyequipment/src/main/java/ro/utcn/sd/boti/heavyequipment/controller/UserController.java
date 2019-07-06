package ro.utcn.sd.boti.heavyequipment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.utcn.sd.boti.heavyequipment.dto.UserDTO;
import ro.utcn.sd.boti.heavyequipment.service.UserManagementService;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserManagementService userManagementService;

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody UserDTO dto) {
        return userManagementService.addUser(dto);
    }

    @GetMapping("/users/{userId}")
    public UserDTO getUserById(@PathVariable Integer userId) {
        return userManagementService.getUserById(userId);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userManagementService.deleteUser(userId);
    }

    @PutMapping("/users/{userId}")
    public UserDTO updateUser(@PathVariable Integer userId, @RequestBody UserDTO dto) {
        return userManagementService.updateUser(userId, dto);
    }

    @GetMapping("/users")
    public UserDTO getUserByUsername( @RequestParam(value = "username", required = true) String username) {
        return userManagementService.getUserByUsername(username);
    }
}
