import React, { Component } from 'react';
import { Header, Title, Left, Right, Body, Button, Icon } from 'native-base';
import { StyleSheet } from 'react-native';
export default class AppHeader extends Component {
   render() {
      const { headerStyle, headerTitleStyle, addButtonColor } = styles;
      return (
         <Header  style={headerStyle} androidStatusBarColor="#189735">
            <Left>
               <Icon style={headerTitleStyle} name="list" />
            </Left>
            <Body>
               <Title>TODO LIST</Title>
            </Body>
            <Right>
               <Button transparent>
                  <Icon style={addButtonColor} name="add" />
               </Button>
            </Right>
       
         </Header>

      );
   }
}

const styles = StyleSheet.create({
   headerStyle: {
      backgroundColor: '#28a745',
   },
   headerTitleStyle: {
      color: 'white'
   },
   addButtonColor: {
      color: '#ffc107',
      fontSize: 25,
   }
});
