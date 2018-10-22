const express = require('express');
const hbs = require('hbs');
const fs = require('fs');

const port = process.env.PORT || 3000;
const app = express();

hbs.registerPartials(__dirname + '/views/partials');
app.set('view engine', 'hbs');
app.use(express.static(__dirname + '/public'));

app.use((req, res, next) => {
  var now = new Date().toString();
  var log = `${now}: ${req.method} ${req.url} \n`;
  console.log(log);
  fs.appendFile(
    'server.log',
    log,
    err => err && console.log('unable to append to server.log.')
  );
  next();
});

// app.use((req,res,next) => {
//   res.render('maintenance')
// });

hbs.registerHelper('getCurrentYear', () => {
  return new Date().getFullYear();
});
hbs.registerHelper('screamIt', text => {
  return text.toUpperCase();
});

app.get('/', (req, res) => {
  res.render('home.hbs', {
    pageTitle: 'Home Page',
    welcomeMessage: 'Welcome to my website'
  });
});

app.get('/about', (req, res) => {
  res.render('about.hbs', {
    pageTitle: 'About Page'
  });
});

app.get('/projects',(req,res) => {
  res.render('projects.hbs',{
    pageTitle: 'Projects'
  });
});

app.get('/bad', (req, res) => {
  res.send('unable to handle request');
});

app.listen(port, () => {
  console.log(`Server is up on port ${port}`);
});
