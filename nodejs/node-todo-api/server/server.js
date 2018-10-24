const express = require('express');
const bodyParser = require('body-parser');
const { ObjectID } = require('mongodb');
const { pick, isBoolean } = require('lodash');

const { mongoose } = require('./db/mongoose');
const { Todo } = require('./models/todo');
const { User } = require('./models/user');

const app = express();

app.use(bodyParser.json());

app.post('/todos', (req, res) => {
  const { text } = req.body;
  const todo = new Todo({ text });

  todo
    .save()
    .then(doc => res.send(doc))
    .catch(err => res.status(400).send(err));
});

app.get('/todos', (req, res) => {
  Todo.find()
    .then(todos => {
      res.send(todos);
    })
    .catch(err => res.status(400).send(err));
});

app.get('/todos/:id', (req, res) => {
  const { id } = req.params;
  if (!ObjectID.isValid(id)) {
    return res.status(404).send();
  }

  Todo.findById(id)
    .then(todo => {
      todo ? res.send(todo) : res.status(404).send();
    })
    .catch(e => res.status(400).send(e));
});

// app.delete('/todos', (req, res) => {
//   const { text } = req.body;
//   Todo.findOneAndRemove({ text })
//     .then(todo => {
//       todo ? res.send(todo) : res.status(404).send();
//     })
//     .catch(e => res.status(400).send(e));
// });
app.delete('/todos/:id', (req, res) => {
  const { id } = req.params;
  if (!ObjectID.isValid(id)) {
    return res.status(404).send();
  }
  Todo.findOneAndDelete({ text: 'do something' })
    .then(todo => {
      todo ? res.send(todo) : res.status(404).send();
    })
    .catch(e => res.status(400).send(e));
});

app.patch('/todos/:id', (req, res) => {
  const { id } = req.params;
  const body = pick(req.body, ['text', 'completed']);

  if (!ObjectID.isValid(id)) {
    return res.status(404).send();
  }

  if (isBoolean(body.completed) && body.completed) {
    body.completedAt = new Date().getTime();
  } else {
    body.completed = false;
    body.completed = null;
  }

  Todo.findOneAndUpdate(id, { $set: body }, { new: true })
    .then(todo => (todo ? res.send({ todo }) : res.status(404).send()))
    .catch(err => res.status(400).send(e));
});

// POST /users

app.post('/users', (req, res) => {
  var body = pick(req.body, ['email', 'password']);
  var user = new User(body);
  user
    .save()
    .then(user => res.send(user))
    .catch(e => res.status(400).send(e));
});

app.listen(3000, () => {
  console.log('started on port 3000');
});

module.exports = { app };
