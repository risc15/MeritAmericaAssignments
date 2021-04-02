import axios from 'axios';
import React, { Component } from 'react';
import { addToken, addUser } from '../redux/ActionCreators';
import { withRouter } from 'react-router-dom';
import { connect } from 'react-redux';
import { baseUrlLocal } from '../shared/baseUrl';
import '../css/MakeTransaction.css';

const mapDispatchToProps = (dispatch) => ({
    addUser: () => dispatch(addUser())
});

class MakeTransaction extends Component {

    constructor(props){
        super(props);
        this.state = {
            accountId: null,
            accountType: 'Checking Accounts',
            amount: null,
            type: 'Check'
        }
    }


    handleSubmit = async (event) => {
        event.preventDefault();
        console.log(this.state);
        await axios.post(baseUrlLocal + '/Users/' + this.props.user.userName + '/' + 'transactions', this.state,
                        { headers: {"Authorization" : `Bearer ${this.props.token.token}`}})
                        .catch((error) => alert(error.message));
                        
        axios.get(baseUrlLocal + '/Users/' + this.props.user.userName, { headers: {"Authorization" : `Bearer ${this.props.token.token}`}})
        .then((response) => {
            this.props.dispatch(addUser(response.data));
        });
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
                <div class="MakeTransaction-Wrapper">
                    <div class="MakeTransaction-container">
                    <form onSubmit={this.handleSubmit}>

                    <div class= "input-div">
                        
                        <h2> Account ID </h2> <input class= "Input-Box" type= "text" name="accountId" onChange={this.handleInputChange}/>
                        <br/>
                    
                        <h2> Account Type: </h2><select name="accountType" onChange={this.handleInputChange}>
                                                <option>Checking Accounts</option>
                                                <option>Savings Account</option> 
                                                <option>Personal Checking Account</option> 
                                                <option>DBA Checking Accounts</option> 
                                                <option>Certificate of Deposit Accounts</option> 
                                                <option>Regular IRA</option> 
                                                <option>Rollover IRA</option> 
                                                <option>Roth IRA</option> 
                                                </select>
                        
                        <h2> Transaction Type: </h2><select name="type" onChange={this.handleInputChange}>
                                                <option>Check</option>
                                                <option>Cash</option> 
                                                <option>ATM</option> 
                                                <option>Transfer</option> 
                                                </select>

                        <h2> Amount </h2> <input class= "Input-Box" type= "text" name="amount" onChange={this.handleInputChange}/>
                        
                                                        
                        <br/>
                        <button type ="submit" class="btn btn-success">GO!</button>

                        
                    </div>
                    </form>
                    </div>
                </div>
            </html>
        );
    }
}

export default withRouter(connect(mapDispatchToProps)(MakeTransaction));