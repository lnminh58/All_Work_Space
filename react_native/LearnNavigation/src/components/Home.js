import React, { Component } from 'react';
import { View, Text, TouchableOpacity } from 'react-native';

export default class Home extends Component {
   state = {};
   // static navigationOptions = {
   //     title: 'Home',
   // }

   render() {
      return (
         <View
            style={{
               flex: 1,
               justifyContent: 'center',
               alignItems: 'center'
            }}
         >
            <Text>HOME</Text>
            <TouchableOpacity
               onPress={() => {
                  this.props.navigation.navigate('detailScreen', {
                     thamso: 'Hello'
                  });
               }}
               style={{ backgroundColor: 'green' }}
            >
               <Text style={{ color: '#fff', fontSize: 20, padding: 10 }}>
                  Go to Detail
               </Text>
            </TouchableOpacity>
            <TouchableOpacity
               onPress={() => {
                  this.props.navigation.openDrawer();
               }}
               style={{ backgroundColor: 'red' }}
            >
               <Text style={{ color: '#fff', fontSize: 20, padding: 10 }}>
                  Go to Detail
               </Text>
            </TouchableOpacity>
         </View>
      );
   }
}
