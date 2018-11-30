import React, { PureComponent } from 'react'
import PropTypes from 'prop-types'
import {
  SafeAreaView,
  Button,
  View
} from 'react-native'

import styles from './styles';

export default class Profile extends PureComponent {
  static navigationOptions = {
    title: 'Profile'
  }

  static propTypes = {
    navigation: PropTypes.object.isRequired
  }

  render() {
    const { navigation } = this.props

    return (
      <SafeAreaView style={styles.container}>
        <View>
          <Button title="Go to Home" onPress={() => navigation.navigate('Home')} />
        </View>
      </SafeAreaView>
    )
  }
}
