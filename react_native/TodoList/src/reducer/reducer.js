import { combineReducers } from 'redux';
import listTodosReducer from './listTodosReducer';
import navigateReducer from './navigateReducer';
import tempTodoReducer from './tempTodoReducer';

const reducer = combineReducers({
   listTodos: listTodosReducer,
   navigation: navigateReducer,
   currentFormData: tempTodoReducer,
});


export default reducer;
