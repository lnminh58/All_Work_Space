/**
 * @format
 * @flow
 */

import React, { Component } from 'react'
import PropTypes from 'prop-types'
import { BackHandler } from 'react-native'
import { connect } from 'react-redux'
import { NavigationActions } from 'react-navigation'
import { reduxifyNavigator } from 'react-navigation-redux-helpers'
import { bindActionCreators } from 'redux'


import AppNavigator from './navigator'

const ReduxNavigator = reduxifyNavigator(AppNavigator, 'root')

class AppWithNavigationState extends Component {
  static propTypes = {
    dispatch: PropTypes.func.isRequired,
    nav: PropTypes.object.isRequired
  }

  componentDidMount() {
    BackHandler.addEventListener('hardwareBackPress', this.onBackPress)
  }

  componentWillUnmount() {
    BackHandler.removeEventListener('hardwareBackPress', this.onBackPress)
  }

  onBackPress = () => {
    const { dispatch, nav } = this.props

    if (nav.index === 0) {
      return false
    }

    dispatch(NavigationActions.back())

    return true
  }


  render() {
    const { dispatch, nav, ...props } = this.props

    return (
      <ReduxNavigator
        {...props}
        state={nav}
        dispatch={dispatch}
      />
    )
  }
}

export default connect(
  state => ({
    nav: state.nav
  }),
  dispatch => ({
    dispatch,
    ...bindActionCreators({
    }, dispatch)
  })
)(AppWithNavigationState)
