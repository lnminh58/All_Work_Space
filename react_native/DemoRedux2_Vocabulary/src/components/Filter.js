import React, { Component } from 'react';
import { View, Text, TouchableOpacity, StyleSheet } from 'react-native';
import { connect } from 'react-redux';
import {
   showAll,
   showMemorized,
   showNeedPractice
} from '../redux/actionCreators';

class Filter extends Component {
   getTextStyle(statusName) {
      if (statusName === this.props.filterStatus) {
         return { color: 'green', fontWeight: 'bold' };
      }
      return styles.buttonTextStyle;
   }

   render() {
      return (
         <View style={styles.tabbarStyle}>
            <TouchableOpacity onPress={() => this.props.showAll()}>
               <Text style={this.getTextStyle('SHOW_ALL')}>SHOW ALL</Text>
            </TouchableOpacity>
            <TouchableOpacity onPress={() => this.props.showMemorized()}>
               <Text style={this.getTextStyle('MEMORIZED')}>MEMORIZED</Text>
            </TouchableOpacity>
            <TouchableOpacity onPress={() => this.props.showNeedPractice()}>
               <Text style={this.getTextStyle('NEED_PRACTICE')}>
                  NEED PRACTICE
               </Text>
            </TouchableOpacity>
         </View>
      );
   }
}

const styles = StyleSheet.create({
   tabbarStyle: {
      backgroundColor: '#ccc',
      flexDirection: 'row',
      justifyContent: 'space-around',
      padding: 10
   },
   buttonTextStyle: {
      color: 'black',
      fontWeight: 'normal'
   }
});

function mapStateToProps(state) {
   return ({ filterStatus } = state);
}

export default connect(
   mapStateToProps,
   { showAll, showMemorized, showNeedPractice }
)(Filter);
