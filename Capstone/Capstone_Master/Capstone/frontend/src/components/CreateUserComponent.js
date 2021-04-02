import React, { Component } from 'react';
import { Control, LocalForm, Form, Errors } from 'react-redux-form';
import { Row, Col, Label, Button, Input } from 'reactstrap';
import { postUser } from '../redux/ActionCreators';
import axios from 'axios';
import { baseUrlLocal } from '../shared/baseUrl';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import { addUser } from '../redux/ActionCreators';
import '../css/CreateUser.css';

const mapDispatchToProps = (dispatch) => ({
    addUser: () => dispatch(addUser())
});

class CreateUser extends Component {

    constructor(props){
        super(props);
        this.state = {
            firstName: '',
            middleName: '',
            lastName: '',
            userName: '',
            password: '',
            email: '',
            accountOpened: new Date(),
            dob: '',
            ssn: null
        }
    }

    handleSubmit = async (event) => {
        event.preventDefault()
        const data = this.state
        const exists = await axios.get(baseUrlLocal + '/Users' + '/' + data.userName + '/valid');
        if(exists.data === true){
            alert("Username taken!");
        } else {
            data.dob = new Date(data.dob);
            axios.post(baseUrlLocal + '/Users', data);
            alert(JSON.stringify(data));
        }
    }

    handleInputChange = (event) => {
        event.preventDefault()
        this.setState({
            [event.target.name]: event.target.value
        })
    }

    render(){
        return(
            
            <html>
               
            <body class= "Registration-Wrapper">

                <div class ="Registration-container">
                
                <h1> User Registration</h1>
                
                <form onSubmit={this.handleSubmit}>

                    <div class="input-div">
                    First Name: <input class = "input-Box"type= "text" name="firstName" onChange={this.handleInputChange}/>
                    <br/>
                  
                    Middle Name: (optional) <input class = "input-Box" type= "text" name= "middleName" onChange={this.handleInputChange}/>
                    <br/>
                    
                    Last Name: <input class = "input-Box" type= "text" name="lastName" onChange={this.handleInputChange}/>
                    <br/>
                   
                    Username: <input class = "input-Box" type= "text" name= "userName" onChange={this.handleInputChange}/>
                    <br/>
                    
                    Password: <input class = "input-Box" type= "text" name= "password" onChange={this.handleInputChange}/>
                    <br/>

                    Email: <input class = "input-Box" type= "text" name= "email" onChange={this.handleInputChange}/>
                    <br/>

                    Date of Birth: <input class = "input-Box" type= "text" name= "dob" onChange={this.handleInputChange}/>
                    <br/>
                   
                    SSN: <input class = "input-Box" type= "text" name= "ssn" onChange={this.handleInputChange}/>
                    <br/>
                    
                    <input type ="submit" class="btn btn-success" value= "Create Account" onChange={this.handleInputChange}/>
                </div>
            </form>
            </div>
            </body>
            </html>
           
          
           
        );
    }
}

export default withRouter(connect(mapDispatchToProps)(CreateUser));