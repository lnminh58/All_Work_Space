import React, { Component } from 'react';
import Axios from 'axios';
import { View, Text, Image } from 'react-native';
import Card from './Card';
import CardSection from './CardSection';

class PokemonDetail extends Component {
    state = {
        pokemonData: {
            version_group: {},
            sprites: {},
        },
        
    };
    
    componentWillMount() {
        Axios.get(this.props.pokemon.url).then(response =>
            this.setState({ pokemonData: response.data }));
    }

    styles = {
        imageStyle: {
            height: 100,
            width: 100,
        },
        nameStyle: {
            fontSize: 20,
            fontWeight: 'bold',
        }
    }

    render() {
        // console.log(this.state.pokemonData.version_group);
        return (
            <Card>
                <CardSection>
                    <View>
                        <Text style={this.styles.nameStyle}>{this.state.pokemonData.name}</Text>
                    </View>
                </CardSection>
                <CardSection>
                    <Image 
                            style={this.styles.imageStyle} 
                            source={{ uri: this.state.pokemonData.sprites
                                .back_default }}
                    />
                    <Image 
                            style={this.styles.imageStyle} 
                            source={{ uri: this.state.pokemonData.sprites
                                .front_default }}
                    />
                </CardSection>
            </Card>
        );
    }
}


// const fetchPokemon = (pokemon) => {
//     Axios.get(pokemon.url).then(response => {
//         console.log(response.data);
//         return response.data;
//     });
// };

export default PokemonDetail;
