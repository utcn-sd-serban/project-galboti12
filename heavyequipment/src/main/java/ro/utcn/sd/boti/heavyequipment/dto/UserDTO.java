package ro.utcn.sd.boti.heavyequipment.dto;

import lombok.Data;
import ro.utcn.sd.boti.heavyequipment.entity.User;

@Data
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private Integer isAdmin;
    private String address;

    public static UserDTO ofEntity(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.id = user.getId();
        userDTO.username = user.getUsername();
        userDTO.password = user.getPassword();
        userDTO.isAdmin = user.getIsAdmin();
        userDTO.address = user.getAddress();
        return userDTO;
    }
}
