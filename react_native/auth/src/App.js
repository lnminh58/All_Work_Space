import React, { Component } from 'react';
import { View, Text } from 'react-native';
// import firebase from 'firebase';
import { Header } from './components/common';
import LoginForm from './components/LoginForm';

class App extends Component {
   
   
   componentWillMount() {
      this.initializeFirebase();
   }

   initializeFirebase() {
      const firebase = require('firebase');

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
      
      //inicializando o firestore
      const firestore = require('firebase/firestore');
      
      const db = firebase.firestore();
      db.settings({ timestampsInSnapshots: true });
   }

   render() {
      return (
         <View>
            <Header headerText="Authentication" />
            <LoginForm />
         </View>
      );
   }
}

export default App;
