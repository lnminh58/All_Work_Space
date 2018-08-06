import React, { Component } from 'react';
import { ScrollView, TextInput, Button } from 'react-native';
import styles from './styles';

class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      username: '',
      password: ''
    };
  }

  render() {
    return (
      <ScrollView style={styles.container}>
        <TextInput
          placeholder="Username"
          autoCapitalize="none"
          keyboardType="email-address"
          value={this.state.username}
          onChangeText={text => this.setState({ username: text })}
        />
        <TextInput
          placeholder="Password"
          autoCapitalize="none"
          secureTextEntry
          value={this.state.password}
          onChangeText={text => this.setState({ password: text })}
        />
        <Button title="Login" onPress={() => null} />
      </ScrollView>
    );
  }
}

export default Login;
