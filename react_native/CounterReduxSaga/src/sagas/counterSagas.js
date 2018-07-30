import { DECREMENT, INCREMENT } from '../actions/actionTypes';

import { delay } from "redux-saga";
import { put, takeEvery} from 'redux-saga/effects';
export function* sayHello(){
   console.log('hello world')
}

function* increment(){
   console.log('this is increment saga')
}
export function* watchIncrement(){
   yield takeEvery(INCREMENT, increment);
}

function* decrement(){
   console.log('this is increment saga')
}
export function* watchDecrement(){
   yield takeEvery(DECREMENT, decrement);
}

