const tempTodoReducer = (state = { title: '', detail: '' }, action) => {
   switch (action.type) {
      case 'FILLUP':
      //    console.log(action);
         return { title: action.title, detail: action.detail, id: action.id };
      default:
         return state;
 }
};

export default tempTodoReducer;
