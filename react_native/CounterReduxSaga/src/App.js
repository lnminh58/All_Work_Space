import React, { Component } from 'react';
import { createStore, applyMiddleware } from 'redux';
import { Provider } from 'react-redux';
import reducer from './reducers/reducers';
import CounterContainer from './containers/CounterContainer';
import createSagaMiddleware from 'redux-saga';
import rootSaga from './sagas/rootSaga';
const sagaMiddleware = createSagaMiddleware();

const store = createStore(reducer,applyMiddleware(sagaMiddleware));


export default class App extends Component {
   render() {
      return (
         <Provider store={store}>
            <CounterContainer />
         </Provider>
      );
   }
}

sagaMiddleware.run(rootSaga);
