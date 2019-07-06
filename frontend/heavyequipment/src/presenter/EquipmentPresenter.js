import equipmentModel from "../model/EquipmentModel";

class EquipmentPresenter {
    onCreateEquipment() {
        window.location.assign("#/equipment");
    }

    onClickEquipment(id) {
        console.log("clicked equipment with id " + id);
        window.location.assign('#/show-equipment/' + id);
    }

    onInit() {
        equipmentModel.loadEquipment();
    }
}

const equipmentPresenter = new EquipmentPresenter();

export default equipmentPresenter;