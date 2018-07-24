import React, { Component } from 'react';
import { AppRegistry } from 'react-native';
import { createStore } from "redux";
import { Provider } from 'react-redux';
import App from "./src/App";

const defaultState = { value : 0, highlight: false };

const reducer = (state = defaultState, action) => {
   if(action.type === "UP"){
      return { value: state.value + 1, highlight: state.highlight };
   }
   if(action.type === "DOWN"){
      return { value: state.value - 1, highlight: state.highlight };
   }
   if(action.type === "CHANGE_COLOR"){
      return { value: state.value, highlight: !state.highlight}
   }
   return state;
};

const store = createStore(reducer);

export default class DemoRedux extends Component {
   state = {  }
   render() {
      return (
         <Provider store={store}>
            <App />
         </Provider>
      );
   }
}

AppRegistry.registerComponent('DemoRedux', () => DemoRedux);
