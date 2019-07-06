package ro.utcn.sd.boti.heavyequipment.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.boti.heavyequipment.entity.*;
import ro.utcn.sd.boti.heavyequipment.repository.*;

@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HeavyEquipmentSeed implements CommandLineRunner {
    private final RepositoryFactory factory;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        EquipmentRepository equipmentRepository = factory.getEquipmentRepository();
        TypeRepository typeRepository = factory.getTypeRepository();
        UserRepository userRepository = factory.getUserRepository();
        RentRepository rentRepository = factory.getRentRepository();
        RentDetailsRepository rentDetailsRepository = factory.getRentDetailsRepository();


        User u1 = new User("boti", passwordEncoder.encode("boti"), new Integer(1), "Address nr 5");

        if (userRepository.findAll().isEmpty()) {
            u1 = userRepository.save(u1);
        }

        Type t1 = new Type("Excavator");
        Type t2 = new Type("Loader");

        Equipment e1 = new Equipment(t1, "Case CX240", new Integer(31000), new Integer(2004));
        Equipment e2 = new Equipment(t2, "Volvo F5", new Integer(24000), new Integer(2005));

        t1.getEquipmentList().add(e1);
        t2.getEquipmentList().add(e2);

        if (typeRepository.findAll().isEmpty()) {
            t1 = typeRepository.save(t1);
            t2 = typeRepository.save(t2);
        }

        if (equipmentRepository.findAll().isEmpty()) {
            e1 = equipmentRepository.save(e1);
            e2 = equipmentRepository.save(e2);
        }

        Rent r1 = new Rent(u1, "2019-03-24 15:13:54", "first rent");

        RentDetails rentDetails1 = new RentDetails(r1, e1, "2019-05-11", "2019-06-22");
        RentDetails rentDetails2 = new RentDetails(r1, e2, "2019-05-12", "2019-06-22");

        r1.getRentDetailsList().add(rentDetails1);
        r1.getRentDetailsList().add(rentDetails2);

        if (rentRepository.findAll().isEmpty()) {
            rentRepository.save(r1);
        }

        if (rentDetailsRepository.findAll().isEmpty()) {
            rentDetailsRepository.save(rentDetails1);
            rentDetailsRepository.save(rentDetails2);
        }
    }
}
