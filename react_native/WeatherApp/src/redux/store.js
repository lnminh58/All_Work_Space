import { createStore, applyMiddleware } from "../../node_modules/redux";
import thunk from 'redux-thunk';


const defaultState = {
   city: null,
   temp: null,
   isLoading: false,
   error: false
};

const reducer = (state = defaultState, action) => {
      console.log('inside reducer :',state,action);
   switch (action.type) {
      case 'START_FETCH':
         return {
            city: null,
            temp: null,
            isLoading: true,
            error: false
         };
      case 'FETCH_SUCCESS':
         console.log('success ', action.city, action.temp);
         return {
            city: action.city,
            temp: action.temp,
            isLoading: false,
            error: false
         };
      case 'FETCH_ERROR':
         return {
            city: null,
            temp: null,
            isLoading: false,
            error: true
         };
      default:
         return state;
   }
};

const store = createStore(reducer, applyMiddleware(thunk));
export default store;
