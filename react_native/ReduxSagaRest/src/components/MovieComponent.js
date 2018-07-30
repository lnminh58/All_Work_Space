import React, { Component } from 'react';
import Button from 'react-native-button';
import {
   Text,
   View,
   Platform,
   TextInput,
   FlatList
} from 'react-native';

export default class CounterComponent extends Component {
   constructor(props) {
      super(props);
      this.state = {
         movieName: '',
         releaseYear: ''
      };
   }

   render() {
      return (
         <View style={{ flex: 1, marginTop: Platform.OS === 'ios' ? 34 : 0 }}>
            <Text
               style={{
                  margin: 20,
                  fontWeight: 'bold',
                  color: 'forestgreen',
                  fontSize: 20
               }}
            >
               Redux saga tutorials - movies list
            </Text>
            <Text
               style={{
                  margin: 10,
                  color: 'black',
                  fontSize: 20
               }}
            >
               New movie information
            </Text>
            <View style={{ height: 100, margin: 10 }}>
               <TextInput
                  style={{
                     flex: 1,
                     margin: 5,
                     padding: 10,
                  }}
                  onChangeText={movieName => this.setState({ movieName })}
                  value={this.state.movieName}
                  placeholder="Enter new movie name"
               />
               <TextInput
                  style={{
                     flex: 1,
                     margin: 5,
                     padding: 10,
                     width: 120
                  }}
                  onChangeText={releaseYear => this.setState({ releaseYear })}
                  value={this.state.releaseYear}
                  placeholder="Release year"
               />
            </View>
            <View style={{ height: 70, flexDirection: 'row' }}>
               <Button
                  containerStyle={{
                     padding: 10,
                     margin: 10,
                     width: 150,
                     height: 45,
                     borderRadius: 10,
                     backgroundColor: 'darkviolet'
                  }}
                  style={{ fontSize: 18, color: 'white' }}
                  onPress={() => {
                        this.props.onFetchMovies('acs');
                  }}
               >
                  Fetch movies
               </Button>
               <Button
                  containerStyle={{
                     padding: 10,
                     margin: 10,
                     width: 150,
                     height: 45,
                     borderRadius: 10,
                     backgroundColor: 'darkviolet'
                  }}
                  style={{ fontSize: 18, color: 'white' }}
                  onPress={() => {
                  }}
               >
                  Add Movie
               </Button>
            </View>
            <FlatList
               data={this.props.movies}
               keyExtractor={item => item.name}
               renderItem={({ item, index }) => (
                  <Text
                     style={{
                        padding: 10,
                        fontWeight: 'bold',
                        fontSize: 17,
                        color: 'white',
                        backgroundColor:
                           index % 2 === 0 ? 'dodgerblue' : 'mediumseagreen'
                     }}
                  >
                     {`${item.name},releaseYear=${item.releaseYear}`}
                  </Text>
               )}
            />
         </View>
      );
   }
}
