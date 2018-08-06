import { connect } from 'react-redux';
import CounterComponent from '../components/CounterComponent';
import { increaseAction, decreaseAction } from '../actions';

const mapStateToProps = state => {
   return ({ times } = state);
}; 

const mapDispatchToProps = dispatch => {
   return {
      onDecrement: step => {
         dispatch(decreaseAction(step));
      },
      onIncrement: step => {
         dispatch(increaseAction(step));
      }
   };
};

const CounterContainer = connect(
   mapStateToProps,
   mapDispatchToProps
)(CounterComponent);
export default CounterContainer;
