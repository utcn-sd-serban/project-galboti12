package ro.utcn.sd.boti.heavyequipment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private Type type;
    private String name;
    private Integer cost;
    private Integer year;

    @OneToMany(mappedBy = "equipment")
    private List<RentDetails> rentDetailsList = new ArrayList<>();

    public Equipment(Type type, String name, Integer cost, Integer year) {
        this.type = type;
        this.name = name;
        this.cost = cost;
        this.year = year;
    }
}
