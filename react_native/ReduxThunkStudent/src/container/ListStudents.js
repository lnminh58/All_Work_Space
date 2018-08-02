import React, { Component } from 'react';
import { FlatList, StyleSheet } from 'react-native';
import { Content, Container, View, Button, Text, Icon } from 'native-base';
import { connect } from 'react-redux';
import StudentCard from './StudentCard';
import AppHeader from './Header';
import { fetchStudensThunk } from '../action';

class ListStudent extends Component {
   constructor(props) {
      super(props);

      this.props.fetchStudensThunk(this.page, this.quantity);
   }
   page = 0;
   quantity = 4;
   render() {
      const { containerStyle } = styles;
      const { pageStudents, error } = this.props.studentsPageState;
      const { content, firstPage, lastPage } = pageStudents;
      console.log(pageStudents);
      return (
         <Container>
            <AppHeader
               headerText="Student Manager"
               headerIconName="users"
               headerNavButtonText="ADD"
            />
            {error ? <Text>Error when load data</Text> : null}

            <FlatList
               style={containerStyle}
               data={content}
               renderItem={({ item }) => <StudentCard student={item} />}
               keyExtractor={item => item.id.toString()}
            />
            <View
               style={{
                  flexDirection: 'row',
                  justifyContent: 'space-around',
                  elevation: 20,
                  backgroundColor: '#9b59b6'
               }}
            >
               <Button
                  onPress={() => {
                     this.page--;
                     this.props.fetchStudensThunk(this.page, this.quantity);
                  }}
                  disabled={firstPage}
                  transparent
                  small
                  light
               >
                  <Icon type="Entypo" name="chevron-with-circle-left" />
               </Button>
               <Button
                  onPress={() => {
                     this.page++;
                     this.props.fetchStudensThunk(this.page, this.quantity);
                  }}
                  disabled={lastPage}
                  small
                  transparent
                  light
               >
                  <Icon type="Entypo" name="chevron-with-circle-right" />
               </Button>
            </View>
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
   return ({ studentsPageState } = state);
}

export default connect(
   mapStateToProps,
   { fetchStudensThunk }
)(ListStudent);
