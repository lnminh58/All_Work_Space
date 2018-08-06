import React, { Component } from 'react';
import { Header, Title, Left, Right, Body, Button, Icon } from 'native-base';
import { StyleSheet } from 'react-native';
import { connect } from 'react-redux';
import { goToForm, goToHome } from '../action';

class AppHeader extends Component {
   renderNavButton(headerNavButtonText) {
      switch (headerNavButtonText) {
         case 'ADD':
            return (
               <Button onPress={() => this.props.goToForm()} transparent>
                  <Icon name="add-to-list" type="Entypo" />
               </Button>
            );
         default :
            return (
               <Button onPress={() => this.props.goToHome()} transparent>
                  <Icon name="home" />
               </Button>
            );
      }
   }
   render() {
      const { headerText, headerIconName, headerNavButtonText } = this.props;
      const { headerStyle, headerTitleStyle  } = styles;
      return (
         <Header style={headerStyle} androidStatusBarColor="#a188bd">
            <Left>
               <Icon
                  style={headerTitleStyle}
                  type="Entypo"
                  name={headerIconName}
               />
            </Left>
            <Body>
               <Title>{headerText}</Title>
            </Body>
            <Right>
               {this.renderNavButton(headerNavButtonText)}
            </Right>
         </Header>
      );
   }
}

const styles = StyleSheet.create({
   headerStyle: {
      height: 50,
      backgroundColor: '#9178ad'
   },
   headerTitleStyle: {
      color: 'white'
   }
});

export default connect(
   null,
   { goToForm, goToHome }
)(AppHeader);
