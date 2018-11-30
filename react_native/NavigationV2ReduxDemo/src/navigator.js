import { createStackNavigator } from 'react-navigation';

import MainDrawerNav from './routes/MainDrawer';

const AppNavigator = createStackNavigator(
  {
    MainDrawerNav: {
      screen: MainDrawerNav
    }
  },
  {
    headerMode: 'none'
  }
);

export default AppNavigator;
