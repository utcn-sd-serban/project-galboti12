import React from "react";
import 'bulma/css/bulma.min.css';

const EquipmentList = ({ equipmentList, searchByType, typeSearch, onClickEquipment }) => (
    <div>
        <div style={{ justifyContent: 'space-around', alignContent: 'space-evenly' }}>
            {equipmentList.map((equipment, index) => (
                <div><br />
                    <div key={index} className="card">
                        <div className="card-image">
                            <figure className="image is-128x128px">
                                <img>{equipment.picture}</img>
                            </figure>
                        </div>
                        <div className="card-content">
                            <div className="media">
                                <div className="media-content">
                                    <div className="content">
                                        <p className="button is-white" style={{ backgroundColor: '#eeeeee' }} onClick={() => onClickEquipment(equipment.id)}> <strong><font size="4">{equipment.name}</font></strong>
                                        </p>
                                        <p styple={{ paddingLeft: '50px' }}>
                                            <i>Type:&nbsp;</i><b style={{ color: 'DarkSeaGreen' }}>{equipment.typeName}</b><br />
                                            <i>$</i><i style={{ color: 'coral' }}>{equipment.cost}</i> <br />
                                            <font size="2">year {equipment.year}</font>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            ))}
        </div>
    </div>
);

export default EquipmentList;