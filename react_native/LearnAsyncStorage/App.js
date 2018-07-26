/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import { StyleSheet, Text, View,TouchableOpacity } from 'react-native';

export default class App extends Component {
   render() {
      return (
         <View style={styles.container}>
         <TouchableOpacity>
            <Text style={styles.welcome}>GET DATA</Text>
         </TouchableOpacity>
         <TouchableOpacity>
            <Text style={styles.welcome}>SAVE DATA</Text>
         </TouchableOpacity>
          </View>
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
   welcome: {
      fontSize: 20,
      textAlign: 'center',
      margin: 10
   }
});
