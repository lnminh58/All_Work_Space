import React, { Component } from 'react';
import { View, Text, TouchableOpacity, StyleSheet } from 'react-native';

export default class Filter extends Component {
   render() {
      return (
         <View
            style={styles.tabbarStyle}
         >
            <TouchableOpacity>
               <Text>SHOW ALL</Text>
            </TouchableOpacity>
            <TouchableOpacity>
               <Text>MEMORIZED</Text>
            </TouchableOpacity>
            <TouchableOpacity>
               <Text>SHOW ALL</Text>
            </TouchableOpacity>
         </View>
      );
   }
}

const styles = StyleSheet.create({
   tabbarStyle: {
      backgroundColor: '#ccc',
      flexDirection: 'row',
      justifyContent: 'space-around',
      padding: 10
   }
})
