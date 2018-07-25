import { combineReducers } from 'redux';
import listTodosReducer from './listTodosReducer';
import changeTabReducer from './changeTabReducer';
import tempTodoReducer from './tempTodoReducer';

const reducer = combineReducers({
   listTodos: listTodosReducer,
   destinationTab: changeTabReducer,
   currentFormData: tempTodoReducer,
});


export default reducer;
