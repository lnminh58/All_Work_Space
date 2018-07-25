import arrWords from '../../resources/arrWords.json';

const arrWordsReducer = (state = arrWords, action) => {
   if (action.type === 'TOGGLE_MEMORIZED') {
      return state.map(item => {
         if (item.id !== action.id) {
            return item;
         }
         return { ...item, memorized: !item.memorized };
      });
   }
   if (action.type === 'TOGGLE_SHOW') {
      return state.map(item => {
         if (item.id !== action.id) {
            return item;
         }
         return { ...item, isShow: !item.isShow };
      });
   }
   if (action.type === 'ADD_WORD') {
      return [
         {
            id: state.length + 1,
            en: action.en,
            vn: action.vn,
            memorized: false,
            isShow: false
         },
         ...state
      ];
   }
   return state;
};

export default arrWordsReducer;
