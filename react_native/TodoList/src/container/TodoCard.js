import React, { Component } from 'react';
import { Text, Card, CardItem, Body, Button, Icon, View } from 'native-base';
import { StyleSheet } from 'react-native';
import { connect } from 'react-redux';
import {
   changeWorkStatus,
   removeWork,
   changeToTab,
   fillUpForm
} from '../action';

class TodoCard extends Component {
   render() {
      const {
         cardHeaderStyle,
         cardHeaderTextStyle,
         buttonContainerStyle,
         buttonStyle
      } = styles;

      const { title, detail, isDone, id } = this.props.todo;
      const cusCardHeaderStyle = isDone
         ? {
              backgroundColor: '#868e96',
              borderBottomLeftRadius: 0,
              borderBottomRightRadius: 0
           }
         : cardHeaderStyle;
      return (
         <Card>
            <CardItem style={cusCardHeaderStyle}>
               <Text style={cardHeaderTextStyle}>{title}</Text>
            </CardItem>
            <CardItem>
               <Body>
                  <Text>{detail}</Text>
               </Body>
            </CardItem>
            <CardItem style={buttonContainerStyle}>
               <Button
                  onPress={() => this.props.changeWorkStatus(id)}
                  warning
                  small
               >
                  {isDone ? (
                     <Icon type="Entypo" name="cw" />
                  ) : (
                     <Icon type="Entypo" name="check" />
                  )}
               </Button>
               <Button
                  onPress={() => {
                     this.props.changeToTab(1);
                     this.props.changeToTab(1);
                     this.props.fillUpForm(title, detail);
                  }}
                  warning
                  small
               >
                  <Icon type="Entypo" name="edit" />
               </Button>
               <Button onPress={() => this.props.removeWork(id)} danger small>
                  <Icon name="remove" />
               </Button>
            </CardItem>
         </Card>
      );
   }
}

const styles = StyleSheet.create({
   cardHeaderStyle: {
      backgroundColor: '#17a2b8',
      borderBottomLeftRadius: 0,
      borderBottomRightRadius: 0
   },
   buttonContainerStyle: {
      flexDirection: 'row-reverse',
      justifyContent: 'space-around'
   },
   cardHeaderTextStyle: {
      color: 'white',
      fontWeight: 'bold'
   },
   buttonStyle: {
      marginRight: 10
   }
});

export default connect(
   null,
   { changeWorkStatus, removeWork, changeToTab, fillUpForm }
)(TodoCard);
