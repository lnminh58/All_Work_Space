const { Clazz, ClazzSchema } = require('./../models/clazz');


function createClass(name) {
  const clazz = new Clazz({
    name
  });
  return clazz.save();
}

module.exports = { createClass }
