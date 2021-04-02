import * as ActionTypes from './ActionTypes';

export const User = (state = {
    isLoading: true,
    errMess: null,
    firstName: '',
    middleName: '',
    lastName: '',
    userName: '',
    email: '',
    dob: '',
    ssn: null,
    checkingAccounts: [],
    savingsAccount: null,
    personalCheckingAccount: null,
    dbaAccounts: [],
    cdAccounts: [],
    regularIra: null,
    rolloverIra: null,
    rothIra: null,
    transactions: []
}, action) => {
    switch (action.type) {
        case ActionTypes.ADD_USER:
            return { ...state, isLoading: false, errMess: null, firstName: action.payload.firstName,
                middleName: action.payload.middleName, lastName: action.payload.lastName, userName: action.payload.userName, email: action.payload.email,
                dob: action.payload.dob, ssn: action.payload.ssn, checkingAccounts: action.payload.checkingAccounts, savingsAccount: action.payload.savingsAccount,
                personalCheckingAccount: action.payload.personalCheckingAccount, dbaAccounts: action.payload.dbaAccounts, cdAccounts: action.payload.cdAccounts,
                regularIra: action.payload.regularIra, rolloverIra: action.payload.rolloverIra, rothIra: action.payload.rothIra, transactions: action.payload.transactions}

        case ActionTypes.USER_LOADING:
            return { ...state, isLoading: true, errMess: null, accounts: [], firstName: '',
                middleName: '', lastName: '' } 
        
        case ActionTypes.USER_FAILED:
            return { ...state, isLoading: false, errMess: null, accounts: [], firstName: '',
                middleName: '', lastName: '' }

            
        default: 
            return state;
    }
}