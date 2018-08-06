import { createStore, applyMiddleware } from 'redux';
import { middleware } from '../container/Router';
import reducer from '../reducer/reducer';
import { load, save } from '../helper/DataFactory';
import ListToDo from '../resource/TodoList.json';

const store = createStore(reducer, applyMiddleware(middleware));

export { store };

const key = 'todos';
load(key).then(data => {
   console.log('before dispatch');
   // if (data === null) {
   //    save(key, ListToDo);
   //    console.log('init data');
   //    load(key).then(dataInit =>
   //       store.dispatch({
   //          type: 'LOAD_DATA',
   //          data: dataInit
   //       })
   //    );
   // } else {
   store.dispatch({
      type: 'LOAD_DATA',
      data
   });
   // }
});
