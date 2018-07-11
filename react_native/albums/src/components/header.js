// import library for making a component

import React from 'react';
import { Text, View } from 'react-native';

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
        backgroundColor: '#fad1ff',
        justifyContent: 'center',
        alignItems: 'center',
        height: 60,
        // paddingTop:15,
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 3 },
        shadowOpacity: 0.3,
        elevation: 5,
        position: 'relative',


    },
    textStyle: {
        fontSize: 30,

    }
};


// make the component available to other parts of the app

export default Header;
