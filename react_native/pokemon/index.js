import React from 'react';
import { View, AppRegistry } from 'react-native';

import Header from './src/components/Header';

const App = () => (
    <View>
        <Header headerText={'Pokemons'} />
    </View>    
);

AppRegistry.registerComponent('pokemon', () => App);
