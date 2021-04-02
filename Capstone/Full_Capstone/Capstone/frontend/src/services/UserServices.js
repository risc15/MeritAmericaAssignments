import axios from 'axios';
import { baseUrlLocal } from '../shared/baseUrl';

class UserServices {

    

    getUser(){
        return axios.get(baseUrlLocal + '/api/users');
    }

    getUserById(userName){
        return axios.get(baseUrlLocal + '/api/users/' + userName); 
    }

    postUser(user){
        return axios.post(baseUrlLocal + '/api/users', user);
    }

    postAccount(accountType, userName, data){
        return axios.post(baseUrlLocal + '/api/users/' + userName + '/' + accountType, data);
    }

    deleteUser(userName){
        axios.delete(baseUrlLocal + '/api/users/' + userName);
    }

    deleteAccount(userName, accoutType, id){
        return axios.patch(baseUrlLocal + '/api/users/' + userName + '/' + accoutType + '/' + id);
    }
}

export default  new UserServices();