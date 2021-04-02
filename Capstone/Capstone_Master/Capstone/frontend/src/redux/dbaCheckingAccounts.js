import * as ActionTypes from './ActionTypes';

export const DBACheckingAccounts = (state = {
    isLoading: true,
    errMess: null,
    accounts: []
}, action) => {
    switch (action.type) {
        case ActionTypes.ADD_DBA_CHECKING_ACCOUNT:
            return { ...state, isLoading: false, errMess: null, accounts: action.payload }

        case ActionTypes.DBA_CHECKING_ACCOUNT_LOADING:
            return { ...state, isLoading: true, errMess: null, accounts: [] } 
        
        case ActionTypes.DBA_CHECKING_ACCOUNT_FAILED:
            return { ...state, isLoading: false, errMess: null, accounts: [] }

        default: 
            return state;
    }
}