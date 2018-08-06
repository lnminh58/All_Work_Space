// import library for making a component

import React from 'react';
import { Text, View } from 'react-native';
// make a component

const Header = (props) => {
    const { textStyle, viewStyle } = styles;
    return (
    <View style={viewStyle}>
        <Text style={textStyle}>{props.headerText.toUpperCase()}</Text>
    </View>
);
};


const styles = {
    viewStyle: {
        backgroundColor: '#f4a941',
        justifyContent: 'center',
        alignItems: 'center',
        height: 50,
        // paddingTop:15,  
        // shadowColor: 'red',
        // shadowOffset: { width: 0, height: 3 },
        // shadowOpacity: 0.8,
        elevation: 10,
        position: 'relative',

    },
    textStyle: {
        fontSize: 20,
        color: '#f7f7f7',
        fontWeight: 'bold',
    }
};


// make the component available to other parts of the app

export { Header };
