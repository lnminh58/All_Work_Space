// import library for making a component

import React from 'react';
import ReactNative, { Text, View } from 'react-native';
// make a component

const Header = (props) => {
    const { textStyle, viewStyle } = styles;
    return (
    <View style={viewStyle}>
        <Text style={textStyle}>{props.headerText}</Text>
    </View>
);
};


const styles = {
    viewStyle: {
        backgroundColor: '#1adb8a',
        justifyContent: 'center',
        alignItems: 'center',
        height: 50,
        // paddingTop:15,
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 3 },
        shadowOpacity: 0.8,
        elevation: 10,
        position: 'relative',
        
    },
    textStyle: {
        fontSize: 25,
        color: '#f7f7f7',
        fontWeight: 'bold',
    }
};


// make the component available to other parts of the app

export default Header;
