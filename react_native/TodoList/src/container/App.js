import React, { Component } from 'react';
import { Provider } from 'react-redux';
// import { AsyncStorage } from 'react-native';
// import reducer from '../reducer/reducer';
// import { createStore, applyMiddleware } from 'redux';
import { AppNavigator } from './Router';
import { store } from '../store';


// const store = createStore(reducer, applyMiddleware(middleware));

 export default class App extends Component {

   render() {
      return (
         <Provider store={store}>
            <AppNavigator />
         </Provider>
      );
   }
}
