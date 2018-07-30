import { combineReducers } from 'redux';
import movies from './movieReducer';

const reducer = combineReducers({
   movies
});

export default reducer;
