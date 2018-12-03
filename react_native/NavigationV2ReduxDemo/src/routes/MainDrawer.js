import React from 'react';
import { Dimensions } from 'react-native';
import { createStackNavigator, createDrawerNavigator } from 'react-navigation';

import Home from '../screens/Home';
import Profile from '../screens/Profile';
import Detail from '../screens/Detail';
import Drawer from '../screens/Drawer';

const { width } = Dimensions.get('window');

const stackNavigatorConfig = {
  initialRouteName: 'Detail',
  headerMode: 'screen',
  navigationOptions: {}
};

const drawerNavigatorConfig = {
  drawerWidth: width - 100,
  contentComponent: props => <Drawer drawerProps={props} />
};

const MainStackNav = createStackNavigator(
  {
    Home: {
      screen: Home
    },
    Detail: {
      screen: Detail
    },
    Profile: {
      screen: Profile
    }
  },
  stackNavigatorConfig
);

const MainDrawerNav = createDrawerNavigator(
  {
    MainStackNav: {
      screen: MainStackNav
    }
  },
  drawerNavigatorConfig
);

export default MainDrawerNav;
