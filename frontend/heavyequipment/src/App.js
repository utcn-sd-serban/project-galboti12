import React from 'react';
import './App.css';
import { HashRouter, Switch, Route } from "react-router-dom";
import 'bulma/css/bulma.min.css';

import SmartEquipmentList from './view/SmartEquipmentList';
import SmartSidePanel from './view/SmartSidePanel';
import SmartCreateEquipment from './view/SmartCreateEquipment';
import Header from './view/Header';

const App = () => (
  <div className="App">
    <div className="container">
      <Header/>
      <div className="columns">
        <div className="column is-one-fifth">
          <SmartSidePanel/>
        </div>
        <HashRouter>
          <Switch>
            <Route exact={true} component={SmartEquipmentList} path={["/", "/equipment", "/equipment/:id", "equipment?name:name", "equipment?typeId:typeId"]} />
            <Route exact={true} component={SmartCreateEquipment} path="/create-equipment" />
          </Switch>
        </HashRouter>
      </div>
    </div>
  </div>
);

export default App;
