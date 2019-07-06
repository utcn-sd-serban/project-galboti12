import React, { Component } from "react";
import equipmentModel from "../model/EquipmentModel";
import EquipmentList from "./EquipmentList";
import equipmentPresenter from "../presenter/EquipmentPresenter";

const mapModelStateToComponentState = modelState => ({
    equipmentList: modelState.equipmentList
});

export default class SmartEquipmentList extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState(equipmentModel.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        equipmentModel.addListener("change", this.listener);
        console.log("SmartEquipmentList constructor");
    }

    componentWillUnmount() {
        equipmentModel.removeListener("change", this.listener);
        console.log("SmartEquipmentList will unmount");
    }

    componentDidUpdate() {
        console.log(this.props);
    }

    componentWillMount() {
        if (this.props.location.search === "") {
            equipmentPresenter.onInit();
        }
    }

    render() {
        return (
            <EquipmentList
                onClickEquipment={equipmentPresenter.onClickEquipment}
                equipmentList={this.state.equipmentList}
                searchByType={equipmentPresenter.onSearchByType}
            />
        );
    }
}