import React from "react";
import 'bulma/css/bulma.min.css';

const Header = () => (
    <nav className="navbar" role="navigation" aria-label="main navigation">
        <div id="navbarBasicExample" className="navbar-menu">
            <div className="navbar-start">
                <a className="navbar-item" href={'#/equipment'}>Home</a>
                <a className="navbar-item" href={'#/create-equipment'}>Create Equipment</a>
            </div>
            <div className="navbar-end">
                <div className="navbar-item">
                    <div className="buttons">
                        <a className="button is-primary">
                            <strong>Sign up</strong>
                        </a>
                        <a className="button is-light">
                            Log in</a>
                    </div>
                </div>
            </div>
        </div>
    </nav>
);

export default Header;