import { handleActions } from 'redux-actions';

const initialState = {
  counter: 0
};

export default handleActions({
  INCREMENT: (state) => {
    return {
      ...state,
      counter: state.counter + 1
    };
  },
  
  DECREMENT: (state) => {
    return {
      ...state,
      counter: state.counter - 1
    };
  }
}, initialState);
