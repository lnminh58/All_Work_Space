const { ObjectID } = require('mongodb');

const { mongoose } = require('../server/db/mongoose');
const { Todo } = require('../server/models/todo');

const id = '5bcd7ade67e781b7217dd8d4';

if (ObjectID.isValid(id)) {
  // Todo.find({
  //   _id: id
  // }).then(todos => {
  //   console.log('========== FIND ==========');
  //   console.log('Todos', todos);
  // });
  // Todo.findOne({
  //   _id: id
  // }).then(todos => {
  //   console.log('========== FIND ONE ==========');
  //   console.log('Todos', todos);
  // });

  Todo.findById(id)
    .then(todos => {
      console.log('========== FIND BY ID ==========');
      console.log('Todos', todos);
    })
    .catch(e => console.log(e.message));
}
