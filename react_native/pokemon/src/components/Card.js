import React from 'react';
import { View, Text } from 'react-native';

const Card = (props) => {
    const { cardStyle } = styles;
    return (
        <View style={cardStyle}>{props.children}</View>
    );
}

const styles = {
    cardStyle: {
        borderWidth: 1,
        // borderRadius: 3,
        borderColor: '#ddd',
        borderBottomWidth: 0,
        elevation: 5,
        marginLeft: 5,
        marginRight: 5,
        marginTop: 15,
        padding: 3,
        backgroundColor: '#fff',
    }
}

export default Card;