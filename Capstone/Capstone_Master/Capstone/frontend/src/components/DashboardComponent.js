import React from 'react'
import HomeSection from './HomeSectionComponent';
import { SavingsAccountCard, CheckingAccountsCard, CDAccountsCard, PersonalCheckingAccountCard, DBACheckingAccountsCard, UserCard,
          RegularIraCard, RolloverIraCard, RothIraCard } from './AccountCardsComponent';
import { Button } from './ButtonComponent';
import {Link} from 'react-router-dom';
import'../css/Dashboard.css';


function Dashboard(props) {
  if(props.user.userName.length != 0)
    return (
        <>
        
        <div class = "Dashboard-Wrapper">
          <h7 id= "welcome-title"> Welcome to your User Dashboard! </h7>
         

        <div className="col-12 col-md-6 m-1">
          <UserCard user={props.user} />
        </div>
        <div className="col-12 col-md-6 m-1">
          <SavingsAccountCard account={props.user.savingsAccount} />
        </div>
        <div className="col-12 col-md-6 m-1">
          <CheckingAccountsCard accounts={props.user.checkingAccounts} />
        </div>
        <div className="col-12 col-md-6 m-1">
          <CDAccountsCard accounts={props.user.cdAccounts} />
        </div>
        <div className="col-12 col-md-6 m-1">
          <PersonalCheckingAccountCard account={props.user.personalCheckingAccount} />
        </div>
        <div className="col-12 col-md-6 m-1">
          <DBACheckingAccountsCard accounts={props.user.dbaAccounts} />
        </div>
        <div className="col-12 col-md-6 m-1">
          <RegularIraCard account={props.user.regularIra} />
        </div>
        <div className="col-12 col-md-6 m-1">
          <RolloverIraCard account={props.user.rolloverIra} />
        </div>
        <div className="col-12 col-md-6 m-1">
          <RothIraCard account={props.user.rothIra} />
        </div>
        </div>
        </>
    );
    else{
      return(
        <div class="Empty-Dashboard">
          <div class="Dashboard-container">
            <Link to="/register">
              <Button>Sign Up</Button>
            </Link>
            <Link to="/signin">
              <Button>Sign In</Button>
            </Link>
          </div>
        </div>
      )
    }
}
export default Dashboard; 