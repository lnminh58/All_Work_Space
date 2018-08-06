import React from 'react';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import { createStackNavigator } from 'react-navigation';
import {
   reduxifyNavigator,
   createReactNavigationReduxMiddleware
} from 'react-navigation-redux-helpers';

import ListStudents from './ListStudents';
import StudentForm from './StudentForm';

const RootNavigator = createStackNavigator({
   Home: {
      screen: ListStudents,
      navigationOptions: {
         header: null
      }
   },
   Form: {
      screen: StudentForm,
      navigationOptions: {
         header: null
      }
   }
   //   Profile: { screen: ProfileScreen },
});

const middleware = createReactNavigationReduxMiddleware(
   'root',
   state => state.navigation
);
const AppWithNavigationState = reduxifyNavigator(RootNavigator, 'root');

const mapStateToProps = state => ({
   state: state.navigation
});

const AppNavigator = connect(mapStateToProps)(AppWithNavigationState);

export { RootNavigator, AppNavigator, middleware };
