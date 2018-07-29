import { getTemp } from '../api/getTemp';

export function startFetchData() {
   return {
      type: 'START_FETCH'
   };
}

export function fetchSuccess(city, temp) {
   console.log('inside fetch success');
   return {
      type: 'FETCH_SUCCESS',
      city,
      temp
   };
}

export function fetchError() {
   return {
      type: 'FETCH_ERROR'
   };
}

export function fetchDataThunk(city) {
   return dispatch => {
      dispatch(startFetchData());
      getTemp(city)
         .then(data => {
            const { city, temp } = data;
            console.log(city, temp);
            dispatch( fetchSuccess(city, temp));
         })
         .catch(error => {
            console.log(error);
            dispatch(fetchError());
         });
   };
}
