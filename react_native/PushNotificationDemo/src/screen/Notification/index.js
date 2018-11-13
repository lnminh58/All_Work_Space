import React, { Component } from 'react';
import { View, Text, TouchableOpacity } from 'react-native';
import LocalPushNotification from './PushNotification';
import OneSignal from 'react-native-onesignal';
import styles from './styles';

class Notifications extends Component {
  constructor(props) {
    super(props);
    this.state = {};
    this.lastId = 0;
  }
  componentDidMount() {
    LocalPushNotification.configure();
    OneSignal.init('546f1a8d-45cd-43cb-835c-547493a01203');
    OneSignal.configure();
    OneSignal.addEventListener('received', this.onReceived.bind(this));
    OneSignal.addEventListener('opened', this.onOpened.bind(this));
    OneSignal.addEventListener('ids', this.onIds.bind(this));
    OneSignal.inFocusDisplaying(0)
  }
  componentWillUnmount() {
    OneSignal.removeEventListener('received', this.onReceived);
    OneSignal.removeEventListener('opened', this.onOpened);
    OneSignal.removeEventListener('ids', this.onIds);
  }

  onReceived(notification) {
    const { title, body } = notification.payload;
    // this.pushLocalNotification(title, body)
    console.log('Notification received: ', notification);
  }

  onOpened(openResult) {
    console.log('Message: ', openResult.notification.payload.body);
    console.log('Data: ', openResult.notification.payload.additionalData);
    console.log('isActive: ', openResult.notification.isAppInFocus);
    console.log('openResult: ', openResult);
  }

  onIds(device) {
    console.log('Device info: ', device);
  }

  

  render() {
    return (
      <View style={styles.container}>
        <TouchableOpacity
          onPress={() => LocalPushNotification.localNotificationSchedule()}
          style={[styles.button, { backgroundColor: '#05c46b' }]}
        >
          <Text style={styles.centertext}>PUSH NOW</Text>
        </TouchableOpacity>
        <TouchableOpacity
          onPress={() => this.pushScheduleNotification()}
          style={[styles.button, { backgroundColor: '#18dcff' }]}
        >
          <Text style={styles.centertext}>PUSH SCHEDULE NOW</Text>
        </TouchableOpacity>
      </View>
    );
  }
}

export default Notifications;
