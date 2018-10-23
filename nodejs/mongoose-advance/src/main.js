const { mongoose } = require('./db/connect');
const { Student } = require('./model/student');

const student = new Student({
  name: 'Mike',
  age: 24,
  gender: true
});
// student
//   .save()
//   .then(res => console.log(res))
//   .catch(err => console.log(err));

student.findAllStudentSameName().then(res => {
  console.log('-------------------')
  console.log(res);
});


Student.findAllStudentByGender(true).then(res =>{
  console.log('-------------------')
  console.log(res);
});
