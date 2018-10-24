const mongoose = require('mongoose');
// const { model, Schema } = require('mongoose');
const { isBoolean } = require('lodash');
const Schema = mongoose.Schema;

const StudentSchema = new Schema({
  name: String,
  age: Number,
  gender: Boolean,
  clazz: { type: Schema.Types.ObjectId, ref: 'Clazz' }
});


StudentSchema.methods.findAllStudentSameName = function() {
  return this.model('Student').find({ name: this.name });
};

StudentSchema.methods.findAllStudentSameClass = function() {
  return this.model('Student').find({ clazz: this.clazz });
};

StudentSchema.statics.findAllStudentByGender = function(gender) {
  if (!isBoolean(gender)) return false;
  return this.find({ gender });
};

const Student = mongoose.model('Student', StudentSchema);

module.exports = { Student, StudentSchema };
