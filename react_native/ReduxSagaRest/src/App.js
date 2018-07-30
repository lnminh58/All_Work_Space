import React, { Component } from 'react';
import { Provider } from 'react-redux';
import store from './store/store';
import MovieContainer from './containers/MovieContainer';

export default class App extends Component {
   render() {
      return (
         <Provider store={store}>
            <MovieContainer />
         </Provider>
      );
   }
}
