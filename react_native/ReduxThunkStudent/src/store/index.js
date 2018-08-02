import { createStore, applyMiddleware } from 'redux';
import { middleware } from '../container/Router';
import reducer from '../reducer/reducer';
import thunk from 'redux-thunk';

const store = createStore(reducer, applyMiddleware(middleware,thunk));

export { store };
