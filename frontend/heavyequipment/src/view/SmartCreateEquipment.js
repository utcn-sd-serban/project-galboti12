import React, { Component } from "react";
import equipmentModel from "../model/EquipmentModel";
import CreateEquipment from "./CreateEquipment";
import createEquipmentPresenter from "../presenter/CreateEquipmentPresenter";

const mapModelStateToComponentState = modelState => ({
    equipment: modelState.newEquipment
});

export default class SmartCreateEquipment extends Component {
    constructor() {
        console.log("SmartCreateEquipment constructor");
        super();
        this.state = mapModelStateToComponentState(equipmentModel.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        equipmentModel.addListener("change", this.listener);
    }

    componentWillUnmount() {
        console.log("SmartCreateEquipment will unmont!");
        equipmentModel.removeListener("change", this.listener);
    }

    render() {
        return (
            <CreateEquipment 
                onCreate={createEquipmentPresenter.onCreate}
                onChange={createEquipmentPresenter.onChange}
                typeName={this.state.equipment.typeName}
                name={this.state.equipment.name}
                cost={this.state.equipment.cost}
                year={this.state.equipment.year} />
        );
    }
}