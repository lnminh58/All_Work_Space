import axios from 'axios';

const urlGetMovies = 'http://5b5ec2c68e9f160014b88d4a.mockapi.io/api/movie';

function* getMoviesFromApi() {
   console.log('inside getMoviesFromApi');
   const response = yield axios.get(urlGetMovies);
   console.log('inside API getMoviesFromApi', response);
   const movies = yield response.data.movies;
   console.log('inside API getMoviesFromApi', movies);
   return movies;
}

export const Api = {
   getMoviesFromApi
};
