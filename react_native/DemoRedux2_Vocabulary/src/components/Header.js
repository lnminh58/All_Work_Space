import React, { Component } from 'react';
import { View, Text, TouchableOpacity } from 'react-native';
import { connect } from 'react-redux';

class Header extends Component {
   render() {
      return (
         <View style={styles.headerStyle}>
         <Text />
         <Text>MY WORDS</Text>
         <TouchableOpacity>
            <Text 
               onPress={() => this.props.dispatch({ type: 'TOGGLE_IS_ADDING' })}
               style={styles.addButtonStyle}
            >
            +
            </Text>
         </TouchableOpacity>
      </View>
      );
   }
}

const styles = {


   headerStyle: {
      flex: 1,
      backgroundColor: '#ccc',
      alignItems: 'center',
      justifyContent: 'space-around',
      flexDirection: 'row'
   },

   addButtonStyle: {
      padding: 5, 
      backgroundColor: 'crimson'
   }
};


export default connect()(Header)
