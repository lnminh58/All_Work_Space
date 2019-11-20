import React, { Component } from 'react';
import {
  Platform,
  StyleSheet,
  Text,
  View,
  Dimensions,
  SafeAreaView,
  TouchableOpacity
} from 'react-native';
import ListCalendar from './src/components/ListCalendar';

export default class App extends Component {
  

  componentDidMount() {
  }

  delayGreeting = () => {
    setTimeout(() => {
      alert('Helllloooooo!')
    }, 2000)
  }

  render() {

    return (
      <SafeAreaView style={styles.container}>
        <ListCalendar
          ref={ref => this.ListCalendar = ref}
        />
        <View style={{ flex: 1}}>
          <TouchableOpacity
            onPress={this.delayGreeting}
          >
            <Text style={{ color: '#888' }}>My name is carousel</Text>
          </TouchableOpacity>
        </View>
      </SafeAreaView>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF'
  },
});
