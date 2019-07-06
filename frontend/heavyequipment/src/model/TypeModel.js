import { EventEmitter } from "events";
import client from "../rest/RestClient";

class TypeModel extends EventEmitter {
    constructor() {
        super();
        this.state = {
            types: [],
            newType: {
                id: 0,
                name: ""
            },
            searchName: "",
            searchType: ""
        };
    }

    loadTypes() {
        return client.loadAllTypes()
            .then(types => {
                this.state = {
                    ...this.state, types
                };
                this.emit("change", this.state);
            })
    }


    addType = name => {
        return client.createType(name)
        .then(type => {
            if(!this.state.types.includes(type)){
                this.appendType(type)
            };
            this.emit("change", this.state);
        })
    }

    appendType(type) {
        this.state = {
            ...this.state,
            types: this.state.types.concat(type)
        };
        this.emit("change", this.state);
    }

    changeNewTypeProperty(property, value) {
        this.state = {
            ...this.state,
            [property]: value
        };
        this.emit("change", this.state);
    }

    searchByName(name){
        return client.searchTypesByName(name)
        .then(types => {
            this.state = {
                ...this.state, types
            };
            this.emit("change", this.state);
        })
    }
}

const typeModel = new TypeModel();

export default typeModel;