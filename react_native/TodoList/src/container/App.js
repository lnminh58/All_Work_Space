import React, { Component } from 'react';
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import { Container } from 'native-base';
import reducer from '../reducer/reducer';
import AppHeader from './Header';
import Content from './Content';

 export default class App extends Component {

   render() {
      return (
         <Provider store={createStore(reducer)}>
            <Container>
               <AppHeader />
               <Content />
              
            </Container>
         </Provider>
      );
   }
}


