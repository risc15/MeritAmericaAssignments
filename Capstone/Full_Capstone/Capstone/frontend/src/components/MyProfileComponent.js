import React, { Component } from 'react';
import { addUser } from '../redux/ActionCreators';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import { Button } from './ButtonComponent';
import {Link} from 'react-router-dom'
import { Card, CardTitle, CardBody } from 'reactstrap';
import { InitialUserState } from '../shared/InitialUserState';
import UserServices from '../services/UserServices';

const mapDispatchToProps = (dispatch) => ({
    addUser: () => dispatch(addUser())
});

class MyProfile extends Component {

    constructor(props){
        super(props);

    }

    logout = (event) => {
        event.preventDefault();
        this.props.dispatch(addUser(InitialUserState));
    }

    deleteAccount = (event) => {
        event.preventDefault();
        UserServices.deleteUser(this.props.user.userName);
        this.props.dispatch(addUser(InitialUserState));
    }

    render(){
        if(this.props.user.userName.length != 0)
        return(
            <>
                <Card>
                    <CardTitle>{this.props.user.userName}</CardTitle>
                    <CardBody>
                        <p>{this.props.user.dob}</p>
                        <p>{this.props.user.ssn}</p>
                    </CardBody>
                </Card>
                <Link to="/">
                    <Button onClick={this.logout}>Logout</Button>
                </Link>
                <Button onClick={this.deleteAccount}>Delete Profile</Button>
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