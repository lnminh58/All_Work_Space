import React, { Component } from 'react';
import { View, Text, StyleSheet } from 'react-native';
import {connect} from 'react-redux';
class Word extends Component {
   state = {  }
   render() {
      const { en, vn} = this.props.word;
      return (
         <View
            style={styles.container}
         >
            <Text>{en}</Text>
            <Text>{vn}</Text>
         </View>
      );
   }
}

const styles= StyleSheet.create({
   container: {
      backgroundColor: '#D2DEF6',
      padding: 10,
      margin: 10,
   }
})

export default connect()(Word);
