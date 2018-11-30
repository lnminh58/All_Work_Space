import React, { PureComponent } from 'react';
import PropTypes from 'prop-types';
import {
  SafeAreaView,
  Button,
  View
} from 'react-native';

import styles from './styles';

export default class Detail extends PureComponent {
  static navigationOptions = {
    title: 'Detail'
  };

  static propTypes = {
    navigation: PropTypes.object.isRequired
  };

  render() {
    const { navigation } = this.props;

    return (
      <SafeAreaView style={styles.container}>
        <View>
          <Button
            title="Go to Profile"
            onPress={() => navigation.navigate('Profile')}
          />
        </View>
      </SafeAreaView>
    );
  }
}
