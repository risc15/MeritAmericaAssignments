import axios from 'axios';
import React from 'react';
import'../css/LoginPage.css';
import { addUser } from '../redux/ActionCreators';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import { baseUrlLocal } from '../shared/baseUrl';
import UserServices from '../services/UserServices';




const mapDispatchToProps = (dispatch) => ({
    addUser: () => dispatch(addUser()),
});

class LoginPage extends React.Component {


     constructor(props) {
         super(props);
         this.state = {
             err: '',
             userName: '',
             password: ''
         };

    }

     handleSubmit = (event) =>{
        event.preventDefault();
        const user = this.state.userName
        UserServices.getUserById(user)
            .then((response) => this.props.dispatch(addUser(response.data)));
     }

     handleInputChange = (event) => {
        event.preventDefault()
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    render() {

        let format = {
        color: "red"
        };
        return (
        
            <div>
                
                <h3> Login</h3>
                <span style={format}>{this.state.err != '' ? this.state.err : ''}</span>
                <form onSubmit={this.handleSubmit}>
                    Username <input type= "text" name="userName" onChange={this.handleInputChange}/>
                    <br/>
                    Password <input type= "password" name= "password" onChange={this.handleInputChange}/>
                    <br/>
                    <input type ="submit" value= "Login"/>

                </form>
            </div>
        )
    }

}

export default withRouter(connect(mapDispatchToProps)(LoginPage));