import React, { Component } from 'react';
import { View, TextInput } from 'react-native';
import { Button, Card, CardSection, Input } from './common';

class LoginForm extends Component {
   state = { email: '' };
   render() {
      return (
         <Card>
            <CardSection>
               <Input
                  placeholder='Your email here'
                  label='Email'
                  value={this.state.text}
                  onChangeText={email => this.setState({ email })}
               />
            </CardSection>
            <CardSection />

            <CardSection>
               <Button>Login</Button>
            </CardSection>
         </Card>
      );
   }
}

export default LoginForm;
