import typeModel from "../model/TypeModel";
import equipmentModel from "../model/EquipmentModel";

class SidePanelPresenter {
    onClick(typeId) {
        console.log("searchType " + typeId);
        equipmentModel.filterByType(typeId);
        window.location.assign('#/equipment?typeId=' + typeId);
    }
    onChange(property, value) {
        typeModel.changeNewTypeProperty(property, value);
    }
    onSearchName(name) {
        if (name.trim() != "") {
            console.log("searchByName " + name);
            equipmentModel.filterByName(name);
            window.location.assign('#/equipment?name=' + name);
        }
    }

    onInit() {
        typeModel.loadTypes();
    }
}

const sidePanelPresenter = new SidePanelPresenter();

export default sidePanelPresenter;