// import a library to help create a component
import React from 'react';
import { View, AppRegistry } from 'react-native';

// import ReactNative from 'react-native';
import Header from './src/components/Header';
import AlbumList from './src/components/AlbumList';
// Create a component
const App = () => (
    <View style={{ flex: 1 }}>
        <Header headerText={'Albums'} />
        <AlbumList />
    </View>
); 
// render it to device
console.log('hello');

AppRegistry.registerComponent('albums', () => App);
