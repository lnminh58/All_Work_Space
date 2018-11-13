import { createActions } from 'redux-actions';

export const { increment, decrement } = createActions({
  INCREMENT: () => {},
  DECREMENT: () => {}
});

export function incrementIfOdd() {
  return (dispatch, getState) => {
    const { counter } = getState();

    if (counter.counter % 2 === 0) {
      return;
    }

    dispatch(increment());
  };
}

export function incrementAsync(delay = 1000) {
  return (dispatch) => {
    setTimeout(() => {
      dispatch(increment());
    }, delay);
  };
}
