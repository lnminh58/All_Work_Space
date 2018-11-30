/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 */

import React, { Component } from 'react';
import {
  Platform,
  StyleSheet,
  Text,
  View,
  TouchableOpacity,
  Dimensions,
  AsyncStorage,
  StatusBar
} from 'react-native';
import { GoogleSignin, statusCodes } from 'react-native-google-signin';
import Icon from 'react-native-vector-icons/AntDesign';

const { width, height } = Dimensions.get('window');

export default class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      buttonText: 'Sign In With Google',
      userName: ''
    };
    this.isLoginScreenPresented = false;
    GoogleSignin.configure({
      // scopes: ['https://www.googleapis.com/auth/drive.readonly'], // what API you want to access on behalf of the user, default is email and profile
      webClientId:
        '80634822106-lta0ij80erhap26poq2i4v25pb3de1h4.apps.googleusercontent.com', // client ID of type WEB for your server (needed to verify user ID and offline access)
      offlineAccess: true // if you want to access Google API on behalf of the user FROM YOUR SERVER
    });
  }

  componentDidMount() {
    (async () => {
      this.isLoginScreenPresented = await GoogleSignin.isSignedIn();
      if (this.isLoginScreenPresented) {
        this.setState({ buttonText: 'Sign Out' });
      }
      console.log(this.isLoginScreenPresented);
    })();
  }

  signIn = async () => {
    try {
      await GoogleSignin.hasPlayServices();
      const userInfo = await GoogleSignin.signIn();
      console.log(userInfo);
      this.setState({ userName: userInfo.user.name, buttonText: 'Sign Out' });
      this.isLoginScreenPresented = true;
    } catch (error) {
      console.log('err:::', error);
      if (error.code === statusCodes.SIGN_IN_CANCELLED) {
        // user cancelled the login flow
      } else if (error.code === statusCodes.IN_PROGRESS) {
        // operation (f.e. sign in) is in progress already
      } else if (error.code === statusCodes.PLAY_SERVICES_NOT_AVAILABLE) {
        // play services not available or outdated
      } else {
        // some other error happened
      }
    }
  };

  signOut = async () => {
    try {
      await GoogleSignin.revokeAccess();
      await GoogleSignin.signOut();
      this.setState({ userName: '', buttonText: 'Sign In With Google' });
      this.isLoginScreenPresented = false;
    } catch (error) {
      console.error(error);
    }
  };

  render() {
    return (
      <View style={styles.container}>
        <StatusBar
          // hidden
          backgroundColor="#223670"
          barStyle="light-content"
        />
        <Text style={styles.mainText}>{`Hello ${this.state.userName}`} </Text>
        <TouchableOpacity
          onPress={() => {
            this.isLoginScreenPresented ? this.signOut() : this.signIn();
          }}
          style={styles.button}
        >
          <Text style={styles.buttonText}>{this.state.buttonText}</Text>
          <Icon name="google" color="white" size={30} />
        </TouchableOpacity>
        <TouchableOpacity
          onPress={() => StatusBar.setHidden(true)}
          style={styles.button}
        >
          <Text style={styles.buttonText}>hidden status</Text>
        </TouchableOpacity>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'space-around',
    alignItems: 'center',
    backgroundColor: '#273c75'
  },
  button: {
    height: 50,
    width: width - 40,
    backgroundColor: '#e84118',
    alignItems: 'center',
    justifyContent: 'space-around',
    borderRadius: 25,
    flexDirection: 'row'
  },
  buttonText: {
    color: 'white',
    fontWeight: 'bold',
    fontSize: 20
  },
  mainText: {
    fontSize: 30,
    color: '#f5f6fa',
    fontWeight: 'bold'
  }
});
