const express = require('express');

const app = express();

app.get('/', (req, res) => {
  // res.send('<h1>Hello Express!</h1>');
  res.send({
    name: 'lnminh',
    likes: ['Bike', 'Phone']
  });
});

app.get('/about', (req,res) => {
  res.send('About page');
})

app.listen(3000);
