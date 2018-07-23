import React from 'react';
import { View, AppRegistry } from 'react-native';

import Header from './src/components/Header';
import PokemonList from './src/components/PokemonList';

const App = () => (
   <View>
      <Header headerText={'Pokemons'} />
      <PokemonList />
   </View>
);

AppRegistry.registerComponent('pokemon', () => App);
