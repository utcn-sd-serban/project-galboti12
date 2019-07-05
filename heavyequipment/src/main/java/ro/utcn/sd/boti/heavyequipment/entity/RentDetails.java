package ro.utcn.sd.boti.heavyequipment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "rent_details")
@NoArgsConstructor
@AllArgsConstructor
public class RentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rent_id")
    private Rent rent;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @JoinColumn(name = "date_start")
    private String dateStart;
    @JoinColumn(name = "date_end")
    private String dateEnd;

    public RentDetails(Rent rent, Equipment equipment, String dateStart, String dateEnd) {
        this.rent = rent;
        this.equipment = equipment;
        this.dateEnd = dateEnd;
        this.dateStart = dateStart;
    }
}
