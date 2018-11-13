import React, { Component } from 'react';
import PropTypes from 'prop-types';
import { BackHandler } from 'react-native';
import { NavigationActions } from 'react-navigation/src/react-navigation';
import { connect } from 'react-redux';
import AppNavigator from './navigator';
import { addListener } from './middlewares/navigation';

export class AppWithNavigationState extends Component {
  static propTypes = {
    dispatch: PropTypes.func.isRequired,
    nav: PropTypes.object.isRequired,
  };

  componentDidMount() {
    this.backHandler = BackHandler.addEventListener('hardwareBackPress', () => {
      this.props.dispatch(NavigationActions.back());
      return true;
    });
  }

  componentWillUnmount() {
    this.backHandler.remove();
  }

  render() {
    const { dispatch, nav } = this.props;
    return <AppNavigator navigation={{ dispatch, state: nav, addListener }} />;
  }
}

export default connect(
  state => ({
    nav: state.nav,
  }),
  dispatch => ({ dispatch }),
)(AppWithNavigationState);
