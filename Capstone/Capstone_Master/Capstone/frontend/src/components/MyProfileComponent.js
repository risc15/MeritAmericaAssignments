import React, { Component } from 'react';
import { addUser, deleteToken } from '../redux/ActionCreators';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import { Button } from './ButtonComponent';
import {Link} from 'react-router-dom'
import { Card, CardTitle, CardBody } from 'reactstrap';
import { InitialUserState } from '../shared/InitialUserState';
import UserServices from '../services/UserServices';
import axios from 'axios';
import { baseUrlLocal } from '../shared/baseUrl';
import'../css/MyProfile.css';
import { mockComponent } from 'react-dom/test-utils';
import moment from 'moment';

const mapDispatchToProps = (dispatch) => ({
    addUser: () => dispatch(addUser()),
    deleteToken: () => dispatch(deleteToken())
});

class MyProfile extends Component {

    
    constructor(props){
        super(props);

    }

    logout = (event) => {
        event.preventDefault();
        this.props.dispatch(addUser(InitialUserState));
        this.props.dispatch(deleteToken);
    }

    deleteAccount = (event) => {
        event.preventDefault();
        axios.delete(baseUrlLocal + '/Users/' + this.props.user.userName, { headers: {"Authorization" : `Bearer ${this.props.token.token}`}});
        this.props.dispatch(addUser(InitialUserState));
    }

    render(){
        if(this.props.user.userName.length != 0)
        return(
            <>
            <div class= "My-Profile-Wrapper">
                <Card>
                    <CardTitle>{this.props.user.userName}</CardTitle>
                    <CardBody>
                        <p>{moment(this.props.user.dob).format("YYYY/MM/DD")}</p>
                        <p>{this.props.user.ssn}</p>
                    </CardBody>
                </Card>
                <Link to="/" >
                    <Button onClick={this.logout}>Logout</Button>
                </Link>
                <Button onClick={this.deleteAccount}>Delete Profile</Button>
                </div>
            </>
            
        );
        else{
            return(
                <div>
                    <Link to="/register">
                        <Button>Sign Up</Button>
                    </Link>
                </div>
                
            );
        }
    }
}

export default withRouter(connect(mapDispatchToProps)(MyProfile));