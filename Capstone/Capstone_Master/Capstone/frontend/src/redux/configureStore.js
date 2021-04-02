import { User } from './user';
import { Token } from './token';
import { createStore, combineReducers, applyMiddleware } from 'redux';
import thunk from 'redux-thunk';
import logger from 'redux-logger';

export const ConfigureStore = () => {
    const store = createStore(
        combineReducers({
            user: User,
            token: Token
        }),
        applyMiddleware(thunk, logger)
    );
    return store;
}