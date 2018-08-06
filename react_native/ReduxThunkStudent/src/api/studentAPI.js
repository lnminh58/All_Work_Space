import axios from 'axios';

const getURL = (page, quantity) =>
   `http://10.13.5.174:8080/student/get-students?page=${page}&quantity=${quantity}`;

export const getStudents = (page, quantity) =>
   axios.get(getURL(page, quantity)).then(res => res.data);

const addURL = 'http://10.13.5.174:8080/student/save';

export const addStudent = data =>
   axios.post(addURL, data).then(res => res.data);

const deleteURL = 'http://10.13.5.174:8080/student/delete';
export const deleteStudent = id => axios.delete(deleteURL, { data: id });
