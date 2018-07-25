import ListToDo from '../resource/TodoList.json';

const listTodoReducer = (state = ListToDo, action) => {
   switch (action.type) {
      case 'TOGGLE_IS_DONE':
         return state.map(item => {
            return item.id !== action.id
               ? item
               : { ...item, isDone: !item.isDone };
         });
      case 'ADD':
         return [
            {
               id: Math.max(...state.map(item => item.id)) + 1,
               title: action.title,
               detail: action.detail,
               isDone: false
            },
            ...state
         ];
      case 'REMOVE':
         return state.filter(item => {
            return item.id !== action.id;
         });
      default:
         return state;
   }
};

export default listTodoReducer;
