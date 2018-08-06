import {
   ADD_MOVIE,
   FETCH_MOVIES,
   FETCH_SUCCEEDED,
   FETCH_FAILED
} from './actionTypes';

export const fetchMovieAction = sort => ({
   type: FETCH_MOVIES,
   sort
});

export const addMovieAction = newMovie => ({
   type: ADD_MOVIE,
   newMovie
});

export const fetchSuccessAction = receivedMovies => ({
   type: FETCH_SUCCEEDED,
   receivedMovies
});

export const fetchFailedAction = error => ({
   type: FETCH_FAILED,
   error
});
