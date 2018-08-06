import { combineReducers } from 'redux';
import { persistReducer } from 'redux-persist';
import storage from 'redux-persist/lib/storage';
import counter from './counter';
import nav from './nav';

const rootPersistConfig = {
  key: 'root',
  storage,
  whitelist: ['counter']
};

const rootReducer = combineReducers({
  counter,
  nav
});

export default persistReducer(rootPersistConfig, rootReducer);
