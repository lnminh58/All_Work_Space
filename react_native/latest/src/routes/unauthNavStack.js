import { StackNavigator } from 'react-navigation';

import Signin from '../screens/Signin';

const stackNavigatorConfig = {
  initialRouteName: 'Signin',
  navigationOptions: {
    header: null
  }
};

const UnauthNavStack = new StackNavigator({
  Signin: { screen: Signin }
}, stackNavigatorConfig);

export default UnauthNavStack;
