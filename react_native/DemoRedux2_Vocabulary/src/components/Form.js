import React, { Component } from 'react';
import {
   View,
   TextInput,
   TouchableOpacity,
   Text,
   StyleSheet
} from 'react-native';
import { connect } from 'react-redux';
import { toggleIsAdding, addWord } from '../redux/actionCreators';

class Form extends Component {
   // state = {};
   constructor(props) {
      super(props);
      this.state = {
         en: '',
         vi: ''
      };
      this.onAdd = this.onAdd.bind(this);
   }

   onAdd() {
      const { en, vi } = this.state;
      this.props.addWord(en, vi);
      this.props.toggleIsAdding();
   }
   render() {
      return (
         <View style={styles.container}>
            <TextInput
               placeholder="English"
               style={styles.textInput}
               value={this.state.en}
               onChangeText={text => this.setState({ en: text })}
            />
            <TextInput
               placeholder="Việt Nam"
               style={styles.textInput}
               value={this.state.vi}
               onChangeText={text => this.setState({ vi: text })}
            />
            <TouchableOpacity onPress={() => this.onAdd()}>
               <Text>Add</Text>
            </TouchableOpacity>
         </View>
      );
   }
}

const styles = StyleSheet.create({
   container: {
      alignItems: 'center'
   },
   textInput: {
      height: 50,
      width: '80%'
   }
});

export default connect(
   null,
   {
      addWord,
      toggleIsAdding
   }
)(Form);
