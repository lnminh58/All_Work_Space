import { combineReducers } from 'redux';
import listStudentsReducer from './listStudentsReducer';
import navigateReducer from './navigateReducer';
import tempStudentReducer from './tempStudentReducer';

const reducer = combineReducers({
   studentsPageState: listStudentsReducer,
   navigation: navigateReducer,
   currentFormData: tempStudentReducer,
});


export default reducer;
