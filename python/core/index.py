# len(), print()

# a = [3, 4]
# b = len(a)
# print(a)
# print(b)

# input()

# print('what is your name');
# myName = input()
# greeting = 'It is good to meet you, {}'
# print(greeting.format(myName))

"""
is , is not
"""

# print(42 == 42.0, True == True)
# print(42 is 42.0)
# a = True
# if a is True:
#   print('hi')
#   print('something')
# else:
#   print('wrong')

"""
varibles
"""
# erorr
# print("Python is " + x)


# def myfunc():
#   # define globally
#   global x
#   x = 'fantastic'


# myfunc()

# print("Python is " + x)

# print(type(()))

"""
list
"""

thislist = ["apple", "banana", "cherry", "banana"]
for x in thislist:
  print(x)

# for idx in range(0, len(thislist)):
#   if(idx > 1 or idx < 1):
#     print(idx, thislist[idx])

# thislist.remove('banana')

removedItem = thislist.remove('banana')
print("return of list remove using remove()", removedItem)
removedItem = thislist.pop(0)
print("return of list remove using pop()", removedItem)

print('this after remove', thislist)


# list1 = ["a", "b" , "c"]
# list2 = [1, 2, 3]

# list3 = list1 + list2
# print(list3)

# list1 = ["a", "b" , "c"]
# list2 = [1, 2, 3]

# list1.extend(list2)
# print(list1)

def myFunc(e):
  return e['year']


cars = [
    {'car': 'Ford', 'year': 2005},
    {'car': 'Mitsubishi', 'year': 2000},
    {'car': 'BMW', 'year': 2019, 'manu': {'factory': 'vn'}},
    {'car': 'VW', 'year': 2011}
]
# cars.sort(key=myFunc)


cars1 = list(cars)

cars1[2]['year'] = 2020

print(cars1)
print(cars)

thisset = {"apple", "banana", "cherry"}

thisset.update(["orange", "mango", "grapes"])

print(thisset)


thisdict = {
    "brand": "Ford",
    "model": "Mustang",
    "year": 1964
}
print(thisdict)

print(thisdict.values())

for x in thisdict.values():
  print(x)


i = 1
while i < 6:
  print(i)
  i += 1
else:
  print("i is no longer less than 6")

print("end of loop")


"""
func
"""

def greeting():
  print('hello')
