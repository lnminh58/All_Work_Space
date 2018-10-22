const { MongoClient, ObjectID } = require('mongodb');

const obj = new ObjectID();
console.log(obj, obj.getTimestamp(), obj.toHexString());

MongoClient.connect(
  'mongodb://localhost:27017/TodoApp',
  (err, db) => {
    if (err) {
      return console.log('Unable to connect to MongoDB server');
    }
    console.log('Connected to MongoDB server');

    // db
    //   .collection('Todos')
    //   .find({ _id: new ObjectID('5bcd39320eca3e48e11cc7b9') })
    //   .toArray()
    //   .then(docs => {
    //     console.log('todos');
    //     console.log(docs);
    //     console.log('=================');
    //     console.log(JSON.stringify(docs, undefined, 2));
    //   }),
    //   err => {
    //     console.log('unable to fetch todos', err);
    //   };
    // db.collection('Todos')
    //   .find()
    //   .count()
    //   .then(count => {
    //     console.log(`todos count: ${count}`);
    //   })
    //   .catch(err => {
    //     console.log('unable to fetch todos', err);
    //   });

    db.collection('Users')
      .find({ name: 'Andrew' })
      .toArray()
      .then(docs => console.log(docs))
      .catch(err => console.log('err', err));

    db.close();
  }
);
