import equipmentModel from "../model/EquipmentModel";

class CreateEquipmentPresenter {
    onCreate() {
        console.log("CreateEquipmentPresenter onCreate");
        equipmentModel.addEquipment(equipmentModel.state.newEquipment.typeName,
            equipmentModel.state.newEquipment.name, equipmentModel.state.newEquipment.cost, equipmentModel.state.newEquipment.year);
        equipmentModel.changeNewEquipmentProperty("typeName", "");
        equipmentModel.changeNewEquipmentProperty("name", "");
        equipmentModel.changeNewEquipmentProperty("cost", 0);
        equipmentModel.changeNewEquipmentProperty("year", 0);
        window.location.assign("#/");
    }
    onChange(property, value) {
        equipmentModel.changeNewEquipmentProperty(property, value);
    }
}

const createEquipmentPresenter = new CreateEquipmentPresenter();

export default createEquipmentPresenter;