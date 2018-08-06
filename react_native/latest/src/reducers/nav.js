import AppNavigator from '../navigator';

export default (state, action) => AppNavigator.router.getStateForAction(action, state);
