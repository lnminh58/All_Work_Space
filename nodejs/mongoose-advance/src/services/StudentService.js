const { Student, StudentSchema } = require('./../models/student');
// function createStudent(name, age, gender = true, clazz) {
//   const student = new Student({
//     name,
//     age,
//     gender,
//     clazz
//   });
//   return student.save();
// }

class StudentService {
  createStudent(name, age, gender = true, clazz) {
    const student = new Student({
      name,
      age,
      gender,
      clazz
    });
    return student.save();
  }

  findByName(name) {
    return Student.find({ name })
  }

  findByClazz(clazz) {
    return Student.find({ clazz })
  }
}

module.exports =  StudentService;
