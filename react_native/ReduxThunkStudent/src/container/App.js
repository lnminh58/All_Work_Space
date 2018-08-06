import React, { Component } from 'react';
import { Provider } from 'react-redux';
import { AppNavigator } from './Router';
import { store } from '../store';


 export default class App extends Component {

   render() {
      return (
         <Provider store={store}>
            <AppNavigator />
         </Provider>
      );
   }
}
