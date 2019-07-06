const BASE_URL = "http://localhost:8080";

class RestClient {
    constructor(username, password) {
        this.authorization = "Basic " + btoa(username + ":" + password);
    }

    loadAllEquipment() {
        return fetch(BASE_URL + "/equipment", {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    createEquipment(typeName, name, cost, year) {
        return fetch(BASE_URL + "/equipment", {
            method: "POST",
            body: JSON.stringify({ id: 1, typeName, name, cost, year }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type": "application/json"
            }
        }).then(response => response.json());
    }

    filterByName(name) {
        return fetch(BASE_URL + "/equipment?name=" + name, {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    filterByType(typeId) {
        return fetch(BASE_URL + "/equipment?typeId=" + typeId, {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    login(username, password) {
        this.authorization = "Basic " + btoa(username + ":" + password);

        return true;
    }

    loadAllTypes() {
        return fetch(BASE_URL + "/types", {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }
}

const client = new RestClient("boti", "boti");

export default client;