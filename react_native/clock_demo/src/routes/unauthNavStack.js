import { StackNavigator } from 'react-navigation';

import Signin from '../screens/Signin';
import Compass from '../screens/Compass';

const stackNavigatorConfig = {
  initialRouteName: 'Compass',
  navigationOptions: {
    header: null
  }

};

const UnauthNavStack = new StackNavigator({
  Signin: { screen: Signin },
  Compass: { screen: Compass }
}, stackNavigatorConfig);

export default UnauthNavStack;
