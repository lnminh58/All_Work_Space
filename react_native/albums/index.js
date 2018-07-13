// import a library to help create a component
import React from 'react';
import { View, AppRegistry } from 'react-native'; 
// import ReactNative from 'react-native'; 
import Header from './src/components/Header';
import AlbumList from './src/components/AlbumList';
// Create a component
const App = () => (
    <View>
        <Header headerText={'Albums'} />
        <AlbumList />   
    </View>
);
// render it to device
AppRegistry.registerComponent('albums', () => App);
