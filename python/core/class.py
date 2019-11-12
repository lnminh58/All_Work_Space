"""
class, object, inheritance
"""

class Person:
  def __init__(self, name, age):
    self.name = name
    self.age = age

  @staticmethod
  def greeting(name):
    print('hello {}!'.format(name))
  
  def introduce(self):
    print("I'm {1}, I'm {0} years old!".format(self.age, self.name))

minh = Person(age=18, name='Minh')

minh.greeting('Misa')

Person.greeting('Misa')

minh.introduce()


class Employee(Person):
  def __init__(self, name, age, salary):
    super().__init__(name, age)
    self.salary = salary

  def introduce(self):
    super().introduce()
    print("My company pay for me {0}$ per month".format(self.salary))

minhEmp = Employee('Minh', 24, '2k')

minhEmp.introduce()
