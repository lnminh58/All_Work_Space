const tempTodoReducer = (state = { title: 'aa', detail: 'aa' }, action) => {
   switch (action.type) {
      case 'FILLUP':
         console.log('====================================');
         console.log(action);
         console.log('====================================');
         return { title: action.title, detail: action.detail };
      default:
         return state;
   }
};

export default tempTodoReducer;
