import React, { Component } from 'react';
import { Navbar, NavbarBrand, Card, NavbarToggler, Nav, NavItem, Jumbotron } from 'reactstrap';
import { NavLink, Router } from 'react-router-dom';

class Header extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isNavOpen: false,
            isMmodalOpen: false
        }
        this.toggleNav = this.toggleNav.bind(this);
        this.toggleModal = this.toggleModal.bind(this);
    }

    toggleNav() {
        this.setState({
            isNavOpen: !this.state.isNavOpen
        });
    }

    toggleModal() {
        this.setState({
            isModalOpen: !this.state.isModalOpen
        })
    }

    render() {
        return(
            <>
            <Navbar dark expand="md"> 
                <div className="container"> 
                <div className="nav-content">Dashboard</div>
                <NavbarToggler onClick={this.toggleNav}/>
                    <NavbarBrand className="mr-auto" href="/home">
                        <img src="/logo192.png" height="70" width="70" />
                    </NavbarBrand>
                        <Nav navbar>
                            <NavItem>
                                <NavLink className="nav-content" to="/home">
                                    <span className="fa fa-home fa-lg"></span> Home
                                </NavLink>
                            </NavItem>
                            <NavItem>
                                <NavLink className="nav-content" to="/aboutus">
                                    <span color="white" className="fa fa-info fa-lg"></span> About Us
                                </NavLink>
                            </NavItem>
                            <NavItem>
                                <NavLink className="nav-content" to="/createaccount">
                                    <span className="fa fa-list fa-lg"></span> Create Account
                                </NavLink>
                            </NavItem>
                            <NavItem>
                                <NavLink className="nav-content" to="/contactus">
                                    <span className="fa fa-address-card fa-lg"></span> Contact Us
                                </NavLink>
                            </NavItem>
                        </Nav>
                    </div>
            </Navbar>
            </>
        );
    }

}

export default Header