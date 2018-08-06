import {
   ADD_MOVIE,
   FETCH_MOVIES,
   FETCH_SUCCEEDED,
   FETCH_FAILED
} from '../actions/actionTypes';

const movieReducers = (state = [], action) => {
   console.log('inside movieReducers', action);
   switch (action.type) {
      case FETCH_SUCCEEDED:
         return action.receivedMovies;
      case FETCH_FAILED:
         return [];
      case ADD_MOVIE:
         return [...state, action.newMovie];
      default:
         return state;
   }
};

export default movieReducers;
