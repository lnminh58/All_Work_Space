const changeTabReducer = (state = 0, action) => {
   switch (action.type) {
      case 'CHANGE_TAB':
      //    console.log('inside reducer tabId: ', action.tabId);
      //    console.log('inside reducer state: ', state);
         if (action.tabId === 0) {
            if (action.tabId === state) return 1;
            return 0;
         } else {
            if (action.tabId === state) return 0;
            return 1;
         }

      default:
      //    console.log('inside default: ', state);
         return state;
   }
};

export default changeTabReducer;
