import React from 'react';
import { Text, TouchableOpacity } from 'react-native';

const Button = ({ onPress, children }) => {
   const { buttonStyle, textStyle } = styles;

   return (
      <TouchableOpacity onPress={onPress} style={buttonStyle}>
         <Text style={textStyle}>{children}</Text>
      </TouchableOpacity>
   );
};

const styles = {
   textStyle: {
      alignSelf: 'center',
      color: '#fff',
      fontSize: 16,
      fontWeight: '600'
   },
   buttonStyle: {
      flex: 1,
      alignSelf: 'stretch',
      backgroundColor: '#00C851',
      borderRadius: 2,
      padding: 5,
      // borderWidth: 1,
      // borderColor: '#007aff',
      marginLeft: 5,
      marginRight: 5
   }
};

export { Button };
