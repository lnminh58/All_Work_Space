import { getStudents, addStudent, deleteStudent } from '../api/studentAPI';
import { getBatchs } from '../api/getBatchs';

export function goToForm() {
   return {
      type: 'GO_FORM'
   };
}

export function goToHome() {
   return {
      type: 'GO_HOME'
   };
}
function loadBatchs(batchs) {
   return {
      type: 'LOAD_BATCHS',
      batchs
   };
}

function showStudents(pageStudents) {
   return {
      type: 'SHOW_STUDENT',
      pageStudents,
      error: false
   };
}

function loadStudentsError() {
   return {
      type: 'LOAD_ERROR',
      pageStudents: [],
      error: true
   };
}

function addStudentAction(newStudent) {
   return {
      type: 'ADD_STUDENT',
      newStudent
   };
}

function deleteStudentAction(id) {
   return {
      type: 'DELETE_STUDENT',
      id
   };
}

export function addStudentThunk(data) {
   return dispatch => {
      addStudent(data)
         .then(res => dispatch(addStudentAction(res)))
         .catch(error => console.log(error));
   };
}

export function deleteStudentThunk(data) {
   return dispatch => {
      deleteStudent(data)
         .then(() => dispatch(deleteStudentAction(data.id)))
         .catch(error => console.log(error));
   };
}

export function fetchStudensThunk(page, quantity) {
   return dispatch => {
      getStudents(page, quantity)
         .then(data => dispatch(showStudents(data)))
         .catch(() => dispatch(loadStudentsError()));
   };
}
export function fetchBatchsThunk() {
   return dispatch => {
      getBatchs().then(data => dispatch(loadBatchs(data)));
   };
}
