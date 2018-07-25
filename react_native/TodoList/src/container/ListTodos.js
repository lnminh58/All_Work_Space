import React, { Component } from 'react';
import { FlatList, StyleSheet } from 'react-native';
import { Content, Container } from 'native-base';
import { connect } from 'react-redux';
import TodoCard from './TodoCard';

class ListTodos extends Component {
   render() {
      const { containerStyle } = styles;
      const { listTodos } = this.props;
      return (
         <Container>
            <FlatList
               style={containerStyle}
               data={listTodos}
               renderItem={({ item }) => <TodoCard todo={item} />}
               keyExtractor={item => item.id.toString()}
            />
         </Container>
      );
   }
}

const styles = StyleSheet.create({
   containerStyle: {
      paddingLeft: 10,
      paddingRight: 10
   }
});

function mapStateToProps(state) {
   return ({ listTodos } = state);
}

export default connect(mapStateToProps)(ListTodos);
