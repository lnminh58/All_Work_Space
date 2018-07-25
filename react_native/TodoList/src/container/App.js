import React, { Component } from 'react';
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import { Container, Content, Text } from 'native-base';
import AppHeader from './Header';
import ListToDo from './ListTodo';
export default class App extends Component {
   render() {
      return (
         <Provider store={ createStore(reducer)}>
            <Container>
               <AppHeader />
               <ListToDo />
            </Container>
         </Provider>
      );
   }
}

const reducer = ()=> [];
