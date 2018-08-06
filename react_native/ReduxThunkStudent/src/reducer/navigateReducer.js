import { RootNavigator } from '../container/Router';
import { NavigationActions } from 'react-navigation';

const firstAction = RootNavigator.router.getActionForPathAndParams('Home');
const initialState = RootNavigator.router.getStateForAction(firstAction);

const navigateReducer = (state = initialState, action) => {
      console.log("inside navigateReducer");
   let nextState;
   switch (action.type) {
      case 'GO_FORM':
         nextState = RootNavigator.router.getStateForAction(
            NavigationActions.navigate({ routeName: 'Form' }),
            state
         );
         break;
      case 'GO_HOME':
         nextState = RootNavigator.router.getStateForAction(
            NavigationActions.navigate({ routeName: 'Home' }),
            state
         );
         break;
      default:
         nextState = RootNavigator.router.getStateForAction(action, state);
         break;
   }

   return nextState || state;
};

export default navigateReducer;
