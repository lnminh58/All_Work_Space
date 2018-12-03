import { createStackNavigator } from 'react-navigation';

import MainDrawerNav from './routes/MainDrawer';
// import MainStackNav from './routes';

// const AppNavigator = createStackNavigator(MainStackNav, {
//   headerMode: 'screen'
// });
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
