import React, { Component } from 'react';
import { View } from 'react-native';
import { Provider } from "react-redux";
import store from './redux/store';
import Main from "./component/Main";
export default class App extends Component {

   render() {
      return (
         <Provider store={store}>
            <Main/>
         </Provider>
      );
   }
}
