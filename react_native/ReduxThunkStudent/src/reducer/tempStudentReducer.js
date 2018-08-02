// import batchs from '../resource/Batchs.json';

const tempStudentReducer = (
   state = {
      name: '',
      selectedBatch: null,
      birthday: null,
      gender: false,
      batchs: []
   },
   action
) => {
   console.log('inside tempStudentReducer', state);
   switch (action.type) {
      case 'LOAD_BATCHS':
         return {...state, batchs: action.batchs}
      case 'FILLUP':
         //    console.log(action);
         return { title: action.title, detail: action.detail, id: action.id };
      default:
         return state;
   }
};

export default tempStudentReducer;
