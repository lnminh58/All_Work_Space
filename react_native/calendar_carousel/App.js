import React, { Component } from 'react';
import {
  Platform,
  StyleSheet,
  Text,
  View,
  Dimensions,
  SafeAreaView
} from 'react-native';
import ListCalendar from './src/components/ListCalendar';

export default class App extends Component {
  
  render() {

    return (
      <SafeAreaView style={styles.container}>
        <ListCalendar
          
        />
        <View style={{ flex: 1}}>
          <Text style={{ color: '#888' }}>My name is carousel</Text>
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
