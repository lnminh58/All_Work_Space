const expect = require('expect');
const request = require('supertest');

const { app } = require('./../server');
const { Todo } = require('./../models/todo');

describe('POST/todos',() => {
  it('Should create a new todo', (done) => {
    const text = 'Test todo text';
    request(app).post('/todos').send({text}).expect(200).expect( res => {
      expect(res.body.text).toBe(text);
    }).end((err,res) => {
      if(err) {
        done(err);
      }
      Todo.find().then(todos => {
        expect(todos.length).toBe(5);
        done();
      }).catch(e => done(e))
    })
  });
});
