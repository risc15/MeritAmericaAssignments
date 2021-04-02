import React, { Component } from 'react';
import { Button } from './ButtonComponent';
import { addUser } from '../redux/ActionCreators';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import UserServices from '../services/UserServices';

const mapDispatchToProps = (dispatch) => ({
    addUser: () => dispatch(addUser())
});

class Transactions extends Component {
    
    constructor(props){
        super(props)
    }

    deleteAccount = async (event) => {

        await UserServices.deleteAccount(this.props.user.userName, this.props.match.params.accountType, this.props.match.params.id);
        UserServices.getUserById(this.props.user.userName)
            .then((response) => this.props.dispatch(addUser(response.data)));
        
        event.preventDefault();
    }

    render(){

        return(
            <>
            <h1>{this.props.match.params.accountType} ID: {this.props.match.params.id}</h1>
            <Button onClick={this.deleteAccount}>Delete Account</Button>
            </>
        );
    }
}

export default withRouter(connect(mapDispatchToProps)(Transactions));