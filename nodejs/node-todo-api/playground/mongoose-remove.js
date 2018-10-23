const { ObjectID } = require('mongodb');

const { mongoose } = require('../server/db/mongoose');
const { Todo } = require('../server/models/todo');
const { User } = require('../server/models/user');

const id = '5bcd7ade67e781b7217dd8d4';

// Todo.remove({}).then(result => {
//   console.log(result);
// });

Todo.findByIdAndRemove('5bce8865d73b1bbf3dfd73e').then(todo => {
  console.log(todo);
}).catch( e => console.log(e.message));
