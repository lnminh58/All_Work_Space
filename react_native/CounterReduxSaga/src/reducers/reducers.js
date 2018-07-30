import { combineReducers } from 'redux';
import counterReducer from './counterReducer';

const reducer = combineReducers({
   times: counterReducer
});

export default reducer;
