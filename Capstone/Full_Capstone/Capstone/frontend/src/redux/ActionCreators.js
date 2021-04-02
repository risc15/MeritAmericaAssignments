import * as ActionTypes from './ActionTypes';
import UserServices from '../services/UserServices';


export const fetchUser = () => (dispatch) => {
    dispatch(userLoading(true));

    UserServices.getUser()
            .then((response) => dispatch(addUser(response.data)))
            .catch(error => dispatch(userFailed(error.message)));

}

export const userFailed = (errmess) => ({
    type: ActionTypes.USER_FAILED,
    payload: errmess
})

export const addUser = (user) => ({
    type: ActionTypes.ADD_USER,
    payload: user
})

export const userLoading = () => ({
    type: ActionTypes.USER_LOADING
})
