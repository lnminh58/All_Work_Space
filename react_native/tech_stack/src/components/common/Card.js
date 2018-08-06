import React from 'react';
import { View } from 'react-native';

const Card = props => {
   return <View style={styles.containerStyle}>{props.children}</View>;
};

const styles = {
   containerStyle: {
      borderWidth: 1,
      borderRadius: 5,
      borderColor: '#ddd',
      borderBottomWidth: 0,
      // shadowColor: '#000',
      // shadowOffset: { width: 0, height: 3 },
      // shadowOpacity: 0.8,
      // shadowRadius: 2,
      elevation: 5,
      marginLeft: 5,
      marginRight: 5,
      marginTop: 15
      //   padding: 3
   }
};

export { Card };
