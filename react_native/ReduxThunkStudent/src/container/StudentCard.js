import React, { Component } from 'react';
import { Text, Card, CardItem, Body, Button, Icon, View } from 'native-base';
import { Alert } from 'react-native';
import { StyleSheet } from 'react-native';
import { connect } from 'react-redux';
import { deleteStudentThunk } from '../action';

class StudentCard extends Component {
   renderRow(iconType, iconName, text) {
      return (
         <View style={{ flexDirection: 'row', marginTop: 3 }}>
            <Icon
               type={iconType}
               name={iconName}
               style={{ fontSize: 20, marginRight: 10 }}
            />
            <Text>{text}</Text>
         </View>
      );
   }

   onDeleteStudent(data) {
      Alert.alert('Confirm', 'Are you sure?', [
         {
            text: 'NO',
            onPress: () => {},
            style: 'cancel'
         },
         { text: 'YES', onPress: () => this.props.deleteStudentThunk(data) }
      ]);
   }
   render() {
      const {
         cardHeaderStyle,
         cardHeaderTextStyle,
         buttonContainerStyle,
         buttonStyle
      } = styles;

      const { fullName, gender, birthday, batch, id } = this.props.student;
      return (
         <Card>
            <CardItem style={cardHeaderStyle}>
               <Text style={cardHeaderTextStyle}>{fullName}</Text>
            </CardItem>
            <CardItem>
               <Body>
                  {this.renderRow('FontAwesome', 'birthday-cake', birthday)}
                  {gender
                     ? this.renderRow('FontAwesome', 'venus')
                     : this.renderRow('FontAwesome', 'mars')}
                  {this.renderRow('MaterialIcons', 'class', batch.batchName)}
               </Body>
            </CardItem>
            <CardItem style={buttonContainerStyle}>
               <Button warning small>
                  <Icon type="Entypo" name="edit" />
               </Button>
               <Button
                  onPress={() => {
                     const data = { id };
                     this.onDeleteStudent(data);
                  }}
                  style={buttonStyle}
                  danger
                  small
               >
                  <Icon name="remove" />
               </Button>
            </CardItem>
         </Card>
      );
   }
}

const styles = StyleSheet.create({
   cardHeaderStyle: {
      backgroundColor: '#e5af8d',
      borderBottomLeftRadius: 0,
      borderBottomRightRadius: 0
   },
   buttonContainerStyle: {
      flexDirection: 'row-reverse'
      // justifyContent: 'space-around'
   },
   cardHeaderTextStyle: {
      color: 'white',
      fontWeight: 'bold'
   },
   buttonStyle: {
      marginRight: 15
   }
});

export default connect(
   null,
   { deleteStudentThunk }
)(StudentCard);
