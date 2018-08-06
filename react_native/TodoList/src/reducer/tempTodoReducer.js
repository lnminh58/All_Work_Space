const tempTodoReducer = (state = { title: '', detail: '' }, action) => {
        console.log('inside tempTodoReducer');
   switch (action.type) {
      case 'FILLUP':
      //    console.log(action);
         return { title: action.title, detail: action.detail, id: action.id };
      default:
         return state;
 }
};

export default tempTodoReducer;
