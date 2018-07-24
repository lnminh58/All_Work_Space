import React, { Component } from 'react';
import { View, Text, TouchableOpacity, StyleSheet } from 'react-native';
import { connect } from 'react-redux';
class Word extends Component {
   memorizeWord() {
      this.props.dispatch({
         type: 'TOGGLE_MEMORIZED',
         id: this.props.word.id
      });
   }
   render() {
      const { en, vn, memorized } = this.props.word;
      const textDecorationLine = memorized ? 'line-through' : 'none';
      const memorizedButtonText = memorized ? 'forget' : 'memorized';
      return (
         <View style={styles.container}>
            <Text style={{ textDecorationLine }}>{en}</Text>
            <Text>{vn}</Text>
            <View style={styles.controller}>
               <TouchableOpacity
                  style={styles.button}
                  onPress={this.memorizeWord.bind(this)}
               >
                  <Text>{memorizedButtonText}</Text>
               </TouchableOpacity>
               <TouchableOpacity style={styles.button}>
                  <Text>Show</Text>
               </TouchableOpacity>
            </View>
         </View>
      );
   }
}

const styles = StyleSheet.create({
   container: {
      backgroundColor: '#cfcfcf',
      padding: 10,
      margin: 10
   },
   controller: {
      flexDirection: 'row',
      justifyContent: 'space-around'
   },
   button: {
      backgroundColor: 'crimson',
      padding: 5,
      margin: 10
   }
});

export default connect()(Word);
