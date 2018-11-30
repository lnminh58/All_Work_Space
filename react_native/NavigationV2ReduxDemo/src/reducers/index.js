import { persistCombineReducers } from 'redux-persist'
import storage from 'redux-persist/lib/storage'

import nav from './nav'

const rootPersistConfig = {
  key: 'root',
  storage,
  whitelist: []
}

const rootReducer = {
  nav
}

export default persistCombineReducers(rootPersistConfig, rootReducer)
