import React from 'react';
import { Text, View } from 'react-native';

const Header = (props) => {
    
    const { frameStyle, textStyle } = styles; 

    return (
        <View style={frameStyle}>
            <Text style={textStyle}>{props.headerText.toUpperCase()}</Text>
        </View>
    );
};

const styles = {
    frameStyle: {
        backgroundColor: '#555555',
        height: 50,
        justifyContent: 'center',
        alignItems: 'center',
        elevation: 15,
        position: 'relative',
    },
    textStyle: {
        color: '#fff',
        fontSize: 22,
        fontWeight: 'bold',
    },
};

export default Header;