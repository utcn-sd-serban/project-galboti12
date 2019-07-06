import { EventEmitter } from "events";
import client from "../rest/RestClient";

class EquipmentModel extends EventEmitter {
    constructor() {
        super();
        this.state = {
            equipmentList: [],
            newEquipment: {
                id: 0,
                typeName: "",
                name: "",
                cost: 0,
                year: 0,
                picture: ""
            }
        };
    }

    loadEquipment() {
        return client.loadAllEquipment()
            .then(equipmentList => {
                this.state = {
                    ...this.state, equipmentList
                };
                this.emit("change", this.state);
            })
    }

    addEquipment = (typeName, name, cost, year) => {
        return client.createEquipment(typeName, name, cost, year)
            .then(equipment => {
                if (!this.state.equipmentList.includes(equipment)) {
                    this.appendEquipment(equipment)
                };
                this.emit("change", this.state);
            });
            
    }

    appendEquipment(equipment) {
        this.state = {
            ...this.state,
            equipmentList: [equipment].concat(this.state.equipmentList)
        };
        this.emit("change", this.state);
    }

    changeNewEquipmentProperty(property, value) {
        this.state = {
            ...this.state,
            newEquipment: {
                ...this.state.newEquipment,
                [property]: value
            }
        };
        this.emit("change", this.state);
    }

    filterByName(name) {
        return client.filterByName(name)
            .then(equipmentList => {
                this.state = {
                    ...this.state, equipmentList
                };
                this.emit("change", this.state);
            })
    }

    filterByType(typeId) {
        return client.filterByType(typeId)
            .then(equipmentList => {
                this.state = {
                    ...this.state, equipmentList
                };
                this.emit("change", this.state);
            })
    }
}

const equipmentModel = new EquipmentModel();

export default equipmentModel;