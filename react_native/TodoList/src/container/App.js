import React, { Component } from 'react';
import { createStore, applyMiddleware } from 'redux';
import { Provider } from 'react-redux';
import { Container } from 'native-base';
import reducer from '../reducer/reducer';
import { AppNavigator, middleware } from './Router';


const store = createStore(reducer, applyMiddleware(middleware));
 export default class App extends Component {

   render() {
      return (
         <Provider store={store}>
            <AppNavigator />
         </Provider>
      );
   }
}
