import React, { PureComponent } from 'react'
import PropTypes from 'prop-types'
import {
  SafeAreaView,
  Button,
  Text,
  View
} from 'react-native'


import styles from './styles'

export default class Home extends PureComponent {
  static navigationOptions = {
    title: 'Home'
  }

  static propTypes = {
    navigation: PropTypes.object.isRequired
  }

  render() {
    const { navigation } = this.props

    return (
      <SafeAreaView style={styles.container}>
        <View>
          <Text style={styles.hello}>Hello</Text>
          <Button title="Go to Detail" onPress={() => navigation.navigate('Detail')} />
        </View>
      </SafeAreaView>
    )
  }
}
