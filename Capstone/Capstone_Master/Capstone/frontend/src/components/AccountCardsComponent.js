import React from 'react';
import { Card, CardTitle, CardBody } from 'reactstrap';
import { Link } from 'react-router-dom';
import'../css/AccountsCard.css';

function getCummulativeBalance(accounts){

    var cummulativeBalance;
    cummulativeBalance = accounts.reduce(function(tot, arr) {  
        return tot + arr.balance;
    }, 0);
    return cummulativeBalance;
}

export const UserCard = ({ user }) => {
    return(

        
        <Card>
            <Link to="/myprofile" style={{ textDecoration: 'none' }}>
            <CardTitle>{user.firstName} {user.lastName}'s Profile Info</CardTitle>
            </Link>
        </Card>
    )
}

export const SavingsAccountCard = ({ account }) => {
    if(account != null)
    return(
        <Card>
            < Link to="/accountsummary/savings"  style={{ textDecoration: 'none' }}>
            <CardTitle>Savings Account</CardTitle>
            <CardBody>Balance: {account.balance}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card>
                <Link to="/createaccount"  style={{ textDecoration: 'none' }}>
                <CardTitle>Create Savings Account</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const CheckingAccountsCard = (accounts) => {
    if(accounts.accounts.length != 0)
    return(
        <Card>
            <Link to="/accountsummary/checking"  style={{ textDecoration: 'none' }}>
            <CardTitle>Checking Accounts</CardTitle>
            <CardBody>Cummulative Balance: {getCummulativeBalance(accounts.accounts)}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card>
                <Link to="/createaccount" style={{ textDecoration: 'none' }}>
                <CardTitle>Create Checking Account</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const CDAccountsCard = (accounts) => {
    if(accounts.accounts.length != 0)
    return(
        <Card>
            <Link to="/accountsummary/cd"  style={{ textDecoration: 'none' }}>
            <CardTitle>Certificate of Deposit Accounts</CardTitle>
            <CardBody>Cummulative Balance: {getCummulativeBalance(accounts.accounts)}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card>
                <Link to="/createaccount"  style={{ textDecoration: 'none' }} >
                <CardTitle>Create Certificate of Deposit Account</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const PersonalCheckingAccountCard = ({ account }) => {
    if(account != null)
    return(
        <Card>
            <Link to="/accountsummary/personal"  style={{ textDecoration: 'none' }}>
            <CardTitle>Personal Checking Account</CardTitle>
            <CardBody>Balance: {account.balance}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card>
                <Link to="/createaccount"style={{ textDecoration: 'none' }}>
                <CardTitle>Create Personal Checking Account</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const DBACheckingAccountsCard = (accounts) => {
    if(accounts.accounts.length != 0)
    return(
        <Card>
            <Link to="/accountsummary/dba" style={{ textDecoration: 'none' }}>
            <CardTitle>DBA Checking Accounts</CardTitle>
            <CardBody>Cummulative Balance: {getCummulativeBalance(accounts.accounts)}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card>
                <Link to="/createaccount"  style={{ textDecoration: 'none' }}>
                <CardTitle>Create DBA Checking Account?</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const RegularIraCard = ({ account }) => {
    if(account != null)
    return(
        <Card>
            <Link to="/accountsummary/regular"  style={{ textDecoration: 'none' }} >
            <CardTitle>Regular IRA</CardTitle>
            <CardBody>Balance: {account.balance}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card>
                <Link to="/createaccount"  style={{ textDecoration: 'none' }}>
                <CardTitle>Create Regular IRA?</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const RolloverIraCard = ({ account }) => {
    if(account != null)
    return(
        <Card>
            <Link to="/accountsummary/rollover"  style={{ textDecoration: 'none' }}>
            <CardTitle>Rollover IRA</CardTitle>
            <CardBody>Balance: {account.balance}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card>
                <Link to="/createaccount"  style={{ textDecoration: 'none' }}>
                <CardTitle>Create Rollover IRA?</CardTitle>
                </Link>
            </Card>
        )
    }
}

export const RothIraCard = ({ account }) => {
    if(account != null)
    return(
        <Card>
            <Link to="/accountsummary/roth" style={{ textDecoration: 'none' }}>
            <CardTitle>Roth IRA</CardTitle>
            <CardBody>Balance: {account.balance}</CardBody>
            </Link>
        </Card>
    )
    else{
        return(
            <Card>
                <Link to="/createaccount"  style={{ textDecoration: 'none' }}>
                <CardTitle>Create Roth IRA?</CardTitle>
                </Link>
            </Card>
            
        )
    }
}