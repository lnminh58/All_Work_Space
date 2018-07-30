import { connect } from 'react-redux';
import MovieComponent from '../components/MovieComponent';
import { addMovieAction, fetchMovieAction } from '../actions';

const mapStateToProps = state => {
   return ({ movies } = state);
};

const mapDispatchToProps = dispatch => {
   return {
      onFetchMovies: (sort) => {
         console.log('inside onFetchMovies');
         dispatch(fetchMovieAction(sort));
      },
      onAddMovies: () => {
         dispatch(addMovieAction);
      }
   };
};

const MovieContainer = connect(
   mapStateToProps,
   mapDispatchToProps
)(MovieComponent);

export default MovieContainer;
