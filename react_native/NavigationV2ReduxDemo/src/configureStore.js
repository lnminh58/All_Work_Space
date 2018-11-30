/* eslint-disable */
import { Platform } from 'react-native'
import { createStore, applyMiddleware, compose } from 'redux'
import { persistStore } from 'redux-persist'
import thunk from 'redux-thunk'

import * as actionCreators from './actions'
import rootReducer from './reducers'

import { reactNavigationReduxMiddleware } from './middlewares/nav'

let composeEnhancers = compose

if (__DEV__) {
  // Use it if Remote debugging with RNDebugger, otherwise use remote-redux-devtools

  composeEnhancers = (window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__
    || require('remote-redux-devtools').composeWithDevTools)({
      name: Platform.OS,
      ...require('../package.json').remotedev,
      actionCreators
    })
}

const middlewares = [
  thunk,
  reactNavigationReduxMiddleware
]

const enhancer = composeEnhancers(applyMiddleware(...middlewares))

export default function configureStore(initialState) {
  const store = createStore(rootReducer, initialState, enhancer)
  const persistor = persistStore(store)

  if (module.hot) {
    module.hot.accept(() => {
      store.replaceReducer(require('./reducers').default)
    })
  }

  return { store, persistor }
}
