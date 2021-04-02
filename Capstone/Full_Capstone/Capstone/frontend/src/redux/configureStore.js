import { User } from './user';
import { SavingsAccount } from './savingsAccount';
import { CheckingAccounts } from './checkingAccounts';
import { CDAccounts } from './cdAccounts';
import { PersonalCheckingAccount } from './personalCheckingAccount';
import { DBACheckingAccounts } from './dbaCheckingAccounts';
import { createStore, combineReducers, applyMiddleware } from 'redux';
import { createForms } from 'react-redux-form';
import thunk from 'redux-thunk';
import logger from 'redux-logger';
import { InitialState } from './forms';

export const ConfigureStore = () => {
    const store = createStore(
        combineReducers({
            user: User
        }),
        applyMiddleware(thunk, logger)
    );
    return store;
}