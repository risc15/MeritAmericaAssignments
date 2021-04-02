import React from 'react';
import {Card, CardTitle, CardBody } from 'reactstrap';
import { Link } from 'react-router-dom';

function AccountSummaryCard(props) {
        return(
        <>
        <Link to={`/transactions/${props.accountType}/${props.account.id}`}>
            <Card>
                <CardTitle>Summary</CardTitle>
                <CardBody>
                    <p>ID: {props.account.id}</p>
                    <p>Balance: {props.account.balance}</p>
                    <p>Interest Rate: {props.account.interestRate}</p>
                </CardBody>
            </Card>
        </Link>
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
            <p>{props.accountType}</p>
            <Link to={`/transactions/${props.accountType}`}>
                <p>{summary}</p>
            </Link>
        </>
        );
    } else {
        return(
            <>
                <p>{props.accountType}</p>
                <p><AccountSummaryCard account={props.accounts} accountType={props.accountType} /></p>
            </>
        );
    }
}

export default AccountSummary