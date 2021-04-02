import axios from 'axios';
import { baseUrlLocal } from '../shared/baseUrl';

class UserServices {

    getUser(){
        return axios.get('http://localhost:8080/Users');
    }

    getUserById(userName){
        return axios.get(baseUrlLocal + '/Users/' + userName); 
    }

    postUser(user){
        return axios.post(baseUrlLocal + '/Users', user);
    }

    postAccount(accountType, userName, data, token){
        return axios.post(baseUrlLocal + '/Users/' + userName + '/' + accountType, { headers: {"Authorization" : `Bearer ${token}`}}, data);
    }

    deleteUser(userName){
        axios.delete(baseUrlLocal + '/Users/' + userName);
    }

    deleteAccount(userName, accoutType, id, closingTo){
        return axios.patch(baseUrlLocal + '/Users/' + userName + '/' + accoutType + '/' + id + '/' + closingTo);
    }
}

export default  new UserServices();