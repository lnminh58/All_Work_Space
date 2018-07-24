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

   toggleShowWord() {
      this.props.dispatch({
         type: 'TOGGLE_SHOW',
         id: this.props.word.id,
      });
   }
   render() {
      const { en, vn, memorized, isShow } = this.props.word;
      const textDecorationLine = memorized ? 'line-through' : 'none';
      const memorizedButtonText = memorized ? 'forget' : 'memorized';
      const meaning = isShow ? vn : '';
      return (
         <View style={styles.container}>
            <Text style={{ textDecorationLine }}>{en}</Text>
            <Text>{meaning}</Text>
            <View style={styles.controller}>
               <TouchableOpacity
                  style={styles.button}
                  onPress={this.memorizeWord.bind(this)}
               >
                  <Text>{memorizedButtonText}</Text>
               </TouchableOpacity>
               <TouchableOpacity style={styles.button} onPress={this.toggleShowWord.bind(this)}>
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
