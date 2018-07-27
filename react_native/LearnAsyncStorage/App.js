/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
   StyleSheet,
   Text,
   View,
   TouchableOpacity,
   AsyncStorage
} from 'react-native';

export default class App extends Component {
   storeData = async () => {
      try {
         console.log('before set item');
         await AsyncStorage.setItem('user', `I 'm minh`);
         console.log('after set item');
      } catch (error) {
         console.log('inside catch block of store method');
         // Error saving data
      }
   };

   retrieveData = async () => {
      try {
         console.log('before get item');
         const value = await AsyncStorage.getItem('user');
         console.log('after get item');
         if (value !== null) {
            // We have data!!
            console.log(value);
         }
      } catch (error) {
         console.log('inside catch block of retrieve method');
      }
   };

   render() {
       this.retrieveData();
      return (
         <View style={styles.container}>
            <TouchableOpacity onPress={ this.retrieveData}>
               <Text style={styles.welcome}>GET DATA</Text>
            </TouchableOpacity>
            <TouchableOpacity onPress={this.storeData} >
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
