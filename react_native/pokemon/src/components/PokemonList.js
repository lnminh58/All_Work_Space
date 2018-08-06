import React, { Component } from 'react';
import { ScrollView, Text, View } from 'react-native';
import Axios from 'axios';
import PokemonDetail from './PokemonDetail';

class PokemonList extends Component {
    state = {
        pokemons: [],
    }
    componentWillMount() {
        console.log('componet will mount in PokemonList');
        Axios.get('https://pokeapi.co/api/v2/pokemon-form/').then(response => this.setState({ pokemons: response.data.results }));
    }

    renderPokemon() {
        if (this.state.pokemons.length === 0) {
            return (
                <Text>Loading...</Text>
            );
        }
        return this.state.pokemons.map(pokemon =>
            <PokemonDetail key={pokemon.name} pokemon={pokemon} />
        );
    }

    render() {
        console.log(this.state.pokemons);

        return (

            <ScrollView>
                {this.renderPokemon()}
            </ScrollView>

        );
    }
}

export default PokemonList;
