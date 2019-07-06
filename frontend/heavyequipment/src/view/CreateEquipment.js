import React from "react";
import 'bulma/css/bulma.min.css';

const CreateEquipment = ({ typeName, name, cost, year, onCreate, onChange }) => (
    <div className="box" style={{ backgroundColor: '#eeeeee' }}>
        <div className="field is-horizontal">
            <div className="field-label is-normal">
                <label className="label">Type</label>
            </div>
            <div className="field-body">
                <div className="field">
                    <div className="control">
                        <input className="input" type="text" placeholder="Minimum 5 charachers"
                            value={typeName} onChange={e => onChange("typeName", e.target.value)} />
                    </div>
                </div>
            </div>
        </div>
        <div className="field is-horizontal">
            <div className="field-label is-normal">
                <label className="label">Name</label>
            </div>
            <div className="field-body">
                <div className="field">
                    <input className="input" placeholder="Minimum 5 charachers"
                        value={name} onChange={e => onChange("name", e.target.value)}/>
                </div>
            </div>
        </div>

        <div className="field is-horizontal">
            <div className="field-label is-normal">
                <label className="label">Cost</label>
            </div>
            <div className="field-body">
                <div className="field">
                    <input className="input" type="text" value={cost} onChange={e => onChange("cost", e.target.value)} />
                </div>
            </div>
        </div>

        <div className="field is-horizontal">
            <div className="field-label is-normal">
                <label className="label">Year</label>
            </div>
            <div className="field-body">
                <div className="field">
                    <input className="input" type="text" value={year} onChange={e => onChange("year", e.target.value)} />
                </div>
            </div>
        </div>

        <div className="field is-grouped is-grouped-right">
            <button className="button is-info" disabled={typeName.length < 5 || name.length < 5} onClick={onCreate}>Create</button>
        </div>
    </div>
);

export default CreateEquipment;