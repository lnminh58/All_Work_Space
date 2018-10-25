const path = require('path');
const express = require('express');
const http = require('http');
const socketIO = require('socket.io');

const publicPath = path.join(__dirname, '../public');
const app = express();
const server = http.createServer(app);
const io = socketIO(server);

app.use(express.static(publicPath));

io.on('connection', socket => {
  console.log(' new user connected');
  socket.on('disconnect', () => {
    console.log('User was disconnected');
  });
});

server.listen(3000, () => {
  console.log('Server is up on port 3000');
});
