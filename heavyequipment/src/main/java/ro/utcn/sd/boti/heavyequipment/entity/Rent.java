package ro.utcn.sd.boti.heavyequipment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    private String date;
    private String text;

    @OneToMany(mappedBy = "rent")
    private List<RentDetails> rentDetailsList = new ArrayList<>();

    public Rent(User user, String date, String text) {
        this.user = user;
        this.date = date;
        this.text = text;
    }
}
