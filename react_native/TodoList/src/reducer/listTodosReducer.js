import ListToDo from '../resource/TodoList.json';
import { save } from '../helper/DataFactory';

const key = 'todos';

const listTodoReducer = (state = [], action) => {
   let nextState;
   console.log('inside listTodoReducer', action);
   switch (action.type) {
      case 'LOAD_DATA':
         //    console.log(action);
         nextState = action.data;
         save(key, nextState);
         break;
      case 'TOGGLE_IS_DONE':
         nextState = state.map(item => {
            return item.id !== action.id
               ? item
               : { ...item, isDone: !item.isDone };
         });
         save(key, nextState);
         break;
      case 'SAVE':
         if (action.id === null) {
            nextState = [
               {
                  id: Math.max(...state.map(item => item.id)) + 1,
                  title: action.title,
                  detail: action.detail,
                  isDone: false
               },
               ...state
            ];
         } else {
            nextState = state.map(item => {
               return item.id !== action.id
                  ? item
                  : { ...item, title: action.title, detail: action.detail };
            });
         }
         save(key, nextState);
         break;

      case 'REMOVE':
         nextState = state.filter(item => {
            return item.id !== action.id;
         });
         save(key, nextState);
         break;
      default:
         nextState = state;
   }
   return nextState;
};

export default listTodoReducer;
