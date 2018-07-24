import React, { Component } from 'react';
import { View, Text, FlatList, TouchableOpacity } from 'react-native';
import { connect } from 'react-redux';
import Word from './Word';
import Filter from './Filter';
import Header from './Header';
import Form from './Form';

class Main extends Component {
   getWordList() {
      const { filterStatus, arrWords } = this.props;
      if (filterStatus === 'SHOW_ALL') {
         return arrWords;
      } else if (filterStatus === 'MEMORIZED') {
         return arrWords.filter(item => item.memorized);
      }
      return arrWords.filter(item => !item.memorized);
   }

   render() {
      return (
         <View style={styles.containerStyle}>
            <Header />
            <View style={{ flex: 12 }}>
               {this.props.isAdding ? <Form /> : null}
               <FlatList
                  data={this.getWordList()}
                  renderItem={({ item }) => <Word word={item} />}
                  keyExtractor={item => item.id}
               />
            </View>
            <View>
               <Filter />
            </View>
         </View>
      );
   }
}

const styles = {
   containerStyle: {
      flex: 1,
      backgroundColor: '#999',
      alignSelf: 'stretch',
      justifyContent: 'center'
   }
};

function mapStateToProps(state) {
   return ({ filterStatus, arrWords, isAdding } = state);
}

export default connect(mapStateToProps)(Main);
