const { mongoose } = require('./db/connect');
const { Student } = require('./models/student');
const { Clazz } = require('./models/clazz');
const { createClass } = require('./services/ClazzService');
const StudentService = require('./services/StudentService');
// create

const studentService = new StudentService();

// delete 


// (async () => {
//   const clazz = await Clazz.findOneAndRemove({ name: '1A' })
//   console.log(clazz);
// })();



// (async () => {
//   const student = await Student.findOneAndRemove({ name: 'Horrom' })
//   console.log(student);
// })();


// read



(async () => {
  const sameClazzStudents = await studentService.findByClazz('5bd01903ad2ffb631c78478c').populate('clazz')
  console.log('================');
  console.log(sameClazzStudents);
})();


/* (async () => {
  const student = await studentService.findByName('Job').populate('clazz');
  console.log('================');
  console.log(student);
})(); */

/* (async () => {
  const result = await Student.find().populate('clazz');
  console.log('================');
  console.log(result);
})(); */

/* (async () => {
  const result = await Student.find({ name: 'Job' }).populate('clazz');
  console.log('================');
  console.log(finalResult);
})(); */

/* (async () => {
  const student = await Student.findOne({ name: 'Job'}).populate('clazz').select('name');
  const sameClassStudents = await Student.find({ clazz : student.clazz });
  console.log('================');
  console.log(student);
  console.log('================');
  console.log(sameClassStudents);
})();
 */




// create
/* (async () => {
  try {
    var result = await createClass('2A');
  } catch (e) {
    console.log(e);
    return;
  }

  try {
    await createStudent('John', 23, true, result._id);
  } catch (e) {
    console.log(e);
    return;
  }
})();

// createStudent('Horrom', 23, true, '5bd01917e579516395f9954a');
 */





