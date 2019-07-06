import React from "react";
import 'bulma/css/bulma.min.css';

const SidePanel = ({ types, onChange, onClick, onSearchName, searchName }) => (
    <nav className="panel">
        <p className="panel-heading">Types</p>
        <div className="panel-block">
            <p className="control">
                <input className="input is-small" type="text" placeholder="search name"
                    value={searchName} onChange={e => onChange("searchName", e.target.value)} />
            </p>
            <p className="button is-small" onClick={() => onSearchName(searchName)}> Search </p>
        </div>
        {types.map((type, index) => (
            <a key={index} className="panel-block is-active" onClick={() => onClick(type.id)}>
                {type.name}
            </a>
        ))}
    </nav>
);

export default SidePanel;
