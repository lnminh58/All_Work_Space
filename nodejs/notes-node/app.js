console.log('starting app.js');

const fs = require('fs');
const _ = require('lodash');

const { add } = require('./notes');

const command = process.argv[2];
// console.log('command: ', command);
// if(command === 'add'){
//   console.log('Adding new note');
// } else if (command === 'list') {
//   console.log('Listing all notes');
// } else {
//   console.log('Command not recognized')
// }

console.log( process.argv);
