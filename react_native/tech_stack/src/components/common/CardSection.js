import React from 'react';
import { View } from 'react-native';

const CardSection = props => {
   return <View style={styles.containerStyle}>{props.children}</View>;
};

const styles = {
   containerStyle: {
      borderWidth: 0,
      borderBottomWidth: 1,
      //   borderRadius: 2,
      // margin: 5,
      padding: 5,
      backgroundColor: '#fff',
      justifyContent: 'flex-start',
      flexDirection: 'row',
      borderColor: '#ddd',
      position: 'relative'
   }
};

export { CardSection };
