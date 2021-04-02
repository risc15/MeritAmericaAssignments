import React from 'react';
import {Card, CardTitle, CardBody } from 'reactstrap';
import { Link } from 'react-router-dom';
import '../css/AccountSummary.css';

function AccountSummaryCard(props) {
        return(
        <>

        <div className= "Account-Summary-Wrapper">
        <Link to={`/transactions/${props.accountType}/${props.account.id}`} style={{ textDecoration: 'none' }}>
            <Card className="Account">
                <CardTitle>Summary</CardTitle>
                <CardBody>
                    <p>{props.accountType}</p>
                    <p>ID: {props.account.id}</p>
                    <p>Balance: {props.account.balance}</p>
                    <p>Interest Rate: {props.account.interestRate}</p>
                </CardBody>
            </Card>
        </Link>
        </div>
        </>
        );     
}

const AccountSummary = (props) => {
    if(Array.isArray(props.accounts)){
        const summary = props.accounts.map((account) => {
            return(
                <div key={account.id}>
                    <AccountSummaryCard account={account} accountType={props.accountType} />
                </div>
            )
        })
        return(
        <>
            <Link to={`/transactions/${props.accountType}`}>
                <p>{summary}</p>
            </Link>
        </>
        );
    } else {
        return(
            <>
                <p><AccountSummaryCard account={props.accounts} accountType={props.accountType} /></p>
            </>
        );
    }
}

export default AccountSummary