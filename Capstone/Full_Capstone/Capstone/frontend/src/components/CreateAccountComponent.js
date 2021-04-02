import React, { Component } from 'react';
import { Control, LocalForm, Form, Errors } from 'react-redux-form';
import { Row, Col, Label, Button, Input } from 'reactstrap';
import { addUser } from '../redux/ActionCreators';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import { baseUrlLocal } from '../shared/baseUrl';
import UserServices from '../services/UserServices';


const mapDispatchToProps = (dispatch) => ({
    addUser: () => dispatch(addUser()),
});

class CreateAccount extends Component {

    constructor(props){
        super(props);
        this.state = {
            accountType: 'Checking Account',
            balance: null,
            interestRate: null
            
        }
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit = async (event) => {
        event.preventDefault();
        const data = this.state;
        if(this.props.user.dbaAccounts.length == 3 && this.state.accountType == 'DBA Checking Account'){
            alert("Cannot create any more DBA Checking Accounts! (3 Max)");
        } else if(this.props.user.savingsAccount != null && this.state.accountType == 'Savings Account'){
            alert("Cannot create any more than 1 Savings Account!");
        } else if(this.props.user.personalCheckingAccount != null && this.state.accountType == 'Personal Checking Account'){
            alert("Cannot create any more than 1 Personal Checking Account!");
        }else if(this.props.user.regularIra != null && this.state.accountType == 'Regular IRA'){
            alert("Cannot create any more than 1 Regular IRA!");
        } else if(this.props.user.rolloverIra != null && this.state.accountType == 'Rollover IRA'){
            alert("Cannot create any more than 1 Rollover IRA!");
        } else if(this.props.user.rothIra != null && this.state.accountType == 'Roth IRA'){
            alert("Cannot create any more than 1 Roth IRA!");
        }else{
            await UserServices.postAccount(this.state.accountType, this.props.user.userName, data);
            UserServices.getUserById(this.props.user.userName)
                .then((response) => {
                    console.log(response);
                    this.props.dispatch(addUser(response.data));
                });
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
            
            <div>
                
                <h3>Register</h3>
                <form onSubmit={this.handleSubmit}>
                    Account Type: <select name="accountType" onChange={this.handleInputChange}>
                                    <option onClick={this.setAccountType}>Checking Account</option>
                                    <option onClick={this.setAccountType}>Savings Account</option> 
                                    <option onClick={this.setAccountType}>Personal Checking Account</option> 
                                    <option onClick={this.setAccountType}>DBA Checking Account</option> 
                                    <option onClick={this.setAccountType}>Certificate of Deposit Account</option> 
                                    <option onClick={this.setAccountType}>Regular IRA</option> 
                                    <option onClick={this.setAccountType}>Rollover IRA</option> 
                                    <option onClick={this.setAccountType}>Roth IRA</option> 
                                    </select>
                    <br/>
                    Opening Balance: <input type= "text" name= "balance" onChange={this.handleInputChange}/>
                    <br/>
                    Interest Rate: <input type= "select" name="interestRate" onChange={this.handleInputChange}/>
                    <br/>
                    <input type ="submit" value= "Create Account" />

                </form>
            </div>
        );
    }
}

export default withRouter(connect(mapDispatchToProps)(CreateAccount));