const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const ClazzSchema = new Schema({
  name: String,
});

const Clazz = mongoose.model('Clazz', ClazzSchema);

module.exports = { Clazz, ClazzSchema };
