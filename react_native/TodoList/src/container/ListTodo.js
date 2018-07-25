import React, { Component } from 'react';
import { Content, Text, Card, CardItem, Body, Button, Icon } from 'native-base';
import { StyleSheet } from 'react-native';
export default class ListToDo extends Component {
   render() {
      const { containerStyle, cardHeaderStyle, cardHeaderTextStyle } = styles;
      return (
         <Content style={containerStyle}>
            <Card>
               <CardItem style={cardHeaderStyle}>
                  <Text style={cardHeaderTextStyle}>NativeBase</Text>
                  <Button warning small>
                     {/* <Text style={cardHeaderTextStyle}>Done</Text>
                   */} 
                     <Icon name="check" />
                  </Button>
                  <Button danger small>
                     {/* <Text style={cardHeaderTextStyle}>Remove</Text> */}
                     <Icon name="remove" />
                  </Button>
               </CardItem>
               <CardItem>
                  <Body>
                     <Text>
                        NativeBase is a free and open source framework that
                        enable developers to build high-quality mobile apps
                        using React Native iOS and Android apps with a fusion of
                        ES6.
                     </Text>
                  </Body>
               </CardItem>
            </Card>
         </Content>
      );
   }
}

const styles = StyleSheet.create({
   containerStyle: {
      padding: 10
   },
   cardHeaderStyle: {
      backgroundColor: '#17a2b8',
      borderBottomLeftRadius: 0,
      borderBottomRightRadius: 0,
      justifyContent: 'space-between'
   },
   cardHeaderTextStyle: {
      color: 'white',
      fontWeight: 'bold'
   }
});
