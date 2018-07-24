export default (state = null, action) => {
   // console.log(action);
   // console.log(state);
   switch (action.type) {
      case 'SELECT_LIBRARY':
         return action.payload;
      default:
         return state;
   }
};
