import React, { Component } from "react";
import typeModel from "../model/TypeModel";
import SidePanel from "./SidePanel";
import sidePanelPresenter from "../presenter/SidePanelPresenter";

const mapModelStateToComponentState = modelState => ({
    types: modelState.types,
    searchType: modelState.searchType,
    searchName: modelState.searchName
});

export default class SmartSidePanel extends Component {
    constructor() {
        console.log("SmartSidePanel consructor");
        super();
        this.state = mapModelStateToComponentState(typeModel.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        typeModel.addListener("change", this.listener);
    }

    componentWillUnmount() {
        console.log("SmartSidePanel will unmont!");
        typeModel.removeListener("change", this.listener);
    }

    componentWillMount() {
        sidePanelPresenter.onInit();
    }

    render() {
        return (
            <SidePanel
                types={this.state.types}
                onChange={sidePanelPresenter.onChange}
                onClick={sidePanelPresenter.onClick}
                onSearchName={sidePanelPresenter.onSearchName}
                searchName={this.state.searchName} />
        );
    }
}