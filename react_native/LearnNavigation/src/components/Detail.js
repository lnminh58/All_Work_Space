import React, { Component } from 'react';
import { View, Text, TouchableOpacity } from 'react-native';

export default class Detail extends Component {
   render() {
      return (
         <View
            style={{
               flex: 1,
               justifyContent: 'center',
               alignItems: 'center'
            }}
         >
            <Text>Detail</Text>
            <TouchableOpacity
               onPress={() => {
                  this.props.navigation.navigate('homeScreen');
               }}
               style={{ backgroundColor: 'green' }}
            >
               <Text style={{ color: '#fff', fontSize: 20, padding: 10 }}>
                  Go to Home
               </Text>
            </TouchableOpacity>
            <Text>{this.props.navigation.state.params.thamso}</Text>
         </View>
      );
   }
}
