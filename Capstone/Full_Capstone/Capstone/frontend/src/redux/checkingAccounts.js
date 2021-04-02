import * as ActionTypes from './ActionTypes';

export const CheckingAccounts = (state = {
    isLoading: true,
    errMess: null,
    accounts: []
}, action) => {
    switch (action.type) {
        case ActionTypes.ADD_CHECKING_ACCOUNTS:
            return { ...state, isLoading: false, errMess: null, accounts: action.payload }

        case ActionTypes.CHECKING_ACCOUNTS_LOADING:
            return { ...state, isLoading: true, errMess: null, accounts: [] } 
        
        case ActionTypes.CHECKING_ACCOUNTS_FAILED:
            return { ...state, isLoading: false, errMess: null, accounts: [] }

        default: 
            return state;
    }
}