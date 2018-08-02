import axios from 'axios';

const url = 'http://10.13.5.174:8080/student/get-batchs' ;

export const getBatchs = () => axios.get(url).then(res =>res.data);

getBatchs().then(data => console.log(data));
