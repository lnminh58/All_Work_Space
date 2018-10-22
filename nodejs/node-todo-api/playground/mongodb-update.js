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

    //delete many

    // db.collection('Todos')
    //   .deleteMany({ text: 'Eat lunch' })
    //   .then(result => console.log(result))
    //   .catch(err => console.log(err));

    //delete one

    // db.collection('Todos')
    //   .deleteOne({ text: 'Eat lunch' })
    //   .then(result => console.log(result))
    //   .catch(err => console.log(err));

    //find One and delete
    db.collection('Users')
      .findOneAndUpdate(
        {
          _id: new ObjectID('5bcd446d085d435a9ab81f2d')
        },
        {
          $set: {
            name: 'Minh'
          },
          $unset: {
            age : ''
          }
        },
        {
          returnOriginal: false
        }
      )
      .then(result => console.log(result))
      .catch(err => console.log(err));
    db.close();
  }
);
