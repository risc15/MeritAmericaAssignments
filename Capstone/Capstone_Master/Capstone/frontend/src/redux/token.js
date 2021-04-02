import * as ActionTypes from './ActionTypes';

export const Token = (state = {
    token: ''
}, action) => {
    switch(action.type){
        case ActionTypes.ADD_TOKEN:
            return { ...state, token: action.payload}
        case ActionTypes.DELETE_TOKEN:
            return { ...state, token: ''}
        default:
            return state;
    }
}