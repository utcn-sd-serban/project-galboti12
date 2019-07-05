package ro.utcn.sd.boti.heavyequipment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    @JoinColumn(name = "is_admin")
    private Integer isAdmin;
    private String address;

    public User(String username, String password, Integer isAdmin, String address){
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.address = address;
    }
}
