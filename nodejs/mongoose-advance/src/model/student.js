const mongoose = require('mongoose');
// const { model, Schema } = require('mongoose');
const { isBoolean } = require('lodash');



const StudentSchema = new mongoose.Schema({
  name: String,
  age: Number,
  gender: Boolean
});


StudentSchema.methods.findAllStudentSameName = function() {
  return this.model('Student').find({ name: this.name });
};

StudentSchema.statics.findAllStudentByGender = function(gender) {
  if (!isBoolean(gender)) return false;
  return this.find({ gender });
};

const Student = mongoose.model('Student', StudentSchema);

module.exports = { Student };
