import { NavigationActions } from 'react-navigation'
import AppNavigator from '../navigator'

const initialState = AppNavigator.router.getStateForAction(NavigationActions.navigate({ routeName: 'MainDrawerNav' }))

const navReducer = (state = initialState, action) => {
  const nextState = AppNavigator.router.getStateForAction(action, state);

  // Simply return the original `state` if `nextState` is null or undefined.
  return nextState || state;
}

export default navReducer
