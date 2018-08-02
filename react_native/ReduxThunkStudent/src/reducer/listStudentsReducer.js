import students from '../resource/Students.json';

const ListStudentsReducer = (
   state = { error: false, pageStudents: {} },
   action
) => {
   let nextState;
      console.log('inside ListStudentsReducer', action);
   switch (action.type) {
      case 'SHOW_STUDENT':
         nextState = { error, pageStudents } = action;
         break;

      case 'LOAD_ERROR':
         nextState = { error, pageStudents } = action;
         break;

      case 'ADD_STUDENT':
         nextState = {
            ...state,
            pageStudents: {
               ...pageStudents,
               content: [action.newStudent, ...state.pageStudents.content]
            }
         };
         break;
      case 'DELETE_STUDENT':
         nextState = {
            ...state,
            pageStudents: {
               ...pageStudents,
               content: state.pageStudents.content.filter(
                  item => item.id !== action.id
               )
            }
         };
         break;
      default:
         nextState = state;
   }
   return nextState;
};

export default ListStudentsReducer;
