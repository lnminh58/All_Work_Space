import ListToDo from '../resource/TodoList.json';
import { retrieveData, storeData } from '../helper/DataFactory';

// retrieveData();
// storeData();

const listTodoReducer = (state = ListToDo, action) => {
   switch (action.type) {
      case 'TOGGLE_IS_DONE':
         return state.map(item => {
            return item.id !== action.id
               ? item
               : { ...item, isDone: !item.isDone };
         });
      case 'SAVE':
         if (action.id === null) {
            return [
               {
                  id: Math.max(...state.map(item => item.id)) + 1,
                  title: action.title,
                  detail: action.detail,
                  isDone: false
               },
               ...state
            ];
         } else {
            return state.map(item => {
               return item.id !== action.id
                  ? item
                  : { ...item, title: action.title, detail: action.detail };
            });
         }

      case 'REMOVE':
         return state.filter(item => {
            return item.id !== action.id;
         });
      default:
         return state;
   }
};

export default listTodoReducer;
