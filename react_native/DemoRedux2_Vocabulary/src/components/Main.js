import React, { Component } from 'react';
import { View, Text, FlatList, TouchableOpacity } from 'react-native';
import { connect } from 'react-redux';
import Word from './Word';
import Filter from "./Filter";
class Main extends Component {
   render() {
      return (
         <View
            style={{
               flex: 1,
               backgroundColor: '#666',
               alignSelf: 'stretch',
               justifyContent: 'center'
            }}
         >
            <FlatList
               data={this.props.arrWords}
               renderItem={({ item }) => <Word word={item} />}
               keyExtractor={item => item.id}
            />
           <Filter/>
         </View>
      );
   }
}

function mapStateToProps(state) {
   return ({ filterStatus, arrWords } = state);
}

export default connect(mapStateToProps)(Main);
