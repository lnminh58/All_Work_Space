import { StackNavigator } from 'react-navigation';

import UnauthNavStack from './routes/unauthNavStack';

const stackNavigatorConfig = {
  headerMode: 'screen',
  navigationOptions: {
    header: null
  }
};

const AppNavigator = new StackNavigator({
  UnauthNavStack: { screen: UnauthNavStack }
}, stackNavigatorConfig);

export default AppNavigator;
