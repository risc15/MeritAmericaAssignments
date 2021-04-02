import * as ActionTypes from './ActionTypes';

export const PersonalCheckingAccount = (state = {
    isLoading: true,
    errMess: null,
    account: []
}, action) => {
    switch (action.type) {
        case ActionTypes.ADD_PERSONAL_CHECKING_ACCOUNT:
            return { ...state, isLoading: false, errMess: null, account: action.payload }

        case ActionTypes.PERSONAL_CHECKING_ACCOUNT_LOADING:
            return { ...state, isLoading: true, errMess: null, account: [] } 
        
        case ActionTypes.PERSONAL_CHECKING_ACCOUNT_FAILED:
            return { ...state, isLoading: false, errMess: null, account: [] }

        default: 
            return state;
    }
}