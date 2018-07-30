import {
   ADD_MOVIE,
   FETCH_MOVIES,
   FETCH_SUCCEEDED,
   FETCH_FAILED
} from '../actions/actionTypes';
import { put, takeLatest } from 'redux-saga/effects';
import { Api } from './Api';

function* fetchMovies() {
   console.log('inside fetchMovies');
   try {
      const receivedMovies = yield Api.getMoviesFromApi();
      console.log('inside fetchMovies', receivedMovies);
      yield put({
         type: FETCH_SUCCEEDED,
         receivedMovies
      });
   } catch (error) {
      yield put({
         type: FETCH_FAILED,
         error
      });
   }
}

export function* watchFetchMovies() {
   yield takeLatest(FETCH_MOVIES, fetchMovies);
}
