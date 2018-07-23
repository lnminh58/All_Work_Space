import React, { Component } from 'react';
import { View, Text, TouchableOpacity } from 'react-native';
import firebase from 'firebase';
import {
   Header,
   Card,
   Button,
   Spinner,
   CardSection
} from './components/common';
import LoginForm from './components/LoginForm';

class App extends Component {
   state = { loggedIn: false };

   componentWillMount() {
      this.initializeFirebase();
   }

   initializeFirebase() {
      // const firebase = require('firebase');

      // Initialize Firebase
      const config = {
         apiKey: 'AIzaSyDVppUJIk2_yq3m66gLu8iRrhPMwMfsKD0',
         authDomain: 'authentication-c1fd6.firebaseapp.com',
         databaseURL: 'https://authentication-c1fd6.firebaseio.com',
         projectId: 'authentication-c1fd6',
         storageBucket: 'authentication-c1fd6.appspot.com',
         messagingSenderId: '25008331852'
      };
      firebase.initializeApp(config);

      firebase.auth().onAuthStateChanged(user => {
         if (user) {
            this.setState({ loggedIn: true });
         } else {
            this.setState({ loggedIn: false });
         }
      });
      // //inicializando o firestore
      // const firestore = require('firebase/firestore');

      // const db = firebase.firestore();
      // db.settings({ timestampsInSnapshots: true });
   }

   renderContent() {
      switch (this.state.loggedIn) {
         case true:
            return (
               <TouchableOpacity onPress={() => firebase.auth().signOut()}>
                  <Text>Log Out</Text>
               </TouchableOpacity>
            );
         case false:
            return <LoginForm />;
         default:
            return <Spinner size="large" />;
      }
   }

   render() {
      return (
         <View>
            <Header headerText="Authentication" />
            {this.renderContent()}
         </View>
      );
   }
}

export default App;
