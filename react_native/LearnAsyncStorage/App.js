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
    async storeData  () {
       user = {
           name: 'John',
           age: 24
       }
      try {
         console.log('before set item');
         await AsyncStorage.setItem('user', JSON.stringify(user) );
         console.log('after set item');
      } catch (error) {
         console.log('inside catch block of store m ethod');
         // Error saving data
      }
   };

   async retrieveData  () {
      try {
         console.log('before get item');
         const value = await AsyncStorage.getItem('user');
         console.log('after get item');
        if(value!==null){
            console.log(value);
            return value;
        }
      } catch (error) {
         console.log('inside catch block of retrieve method');
      }
   };

   render() {
       this.retrieveData();
      return (
         <View style={styles.container}>
            <TouchableOpacity onPress={()=> {
                this.retrieveData().then(value => console.log(value));
            }}>
               <Text style={styles.welcome}>GET DATA</Text>
            </TouchableOpacity>
            <TouchableOpacity onPress={this.storeData } >
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
    },
   welcome: {
      fontSize: 20,
      textAlign: 'center',
      margin: 10
   }
});
