import React, { Component } from 'react';
import { View, Text, FlatList, TouchableOpacity } from 'react-native';
import { connect } from 'react-redux';
import Word from './Word';
import Filter from './Filter';
class Main extends Component {
   getWordList() {
      const { filterStatus, arrWords } = this.props;
      if (filterStatus === 'SHOW_ALL') {
         return arrWords;
      } else if (filterStatus === 'MEMORIZED') {
         return arrWords.filter(item => item.memorized);
      } 
      return arrWords.filter( item => !item.memorized );
   }

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
               data={this.getWordList()}
               renderItem={({ item }) => <Word word={item} />}
               keyExtractor={item => item.id}
            />
            <Filter />
         </View>
      );
   }
}

function mapStateToProps(state) {
   return ({ filterStatus, arrWords } = state);
}

export default connect(mapStateToProps)(Main);
