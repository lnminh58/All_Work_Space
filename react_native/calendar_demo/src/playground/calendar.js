import React, {Component} from 'react';
import {
  Text,
  StyleSheet,
  ScrollView,
  View
} from 'react-native';
import {Calendar} from 'react-native-calendars';
import moment from 'moment-hijri';

export default class CalendarsScreen extends Component {
  constructor(props) {
    super(props);
    this.state = {};
    this.onDayPress = this.onDayPress.bind(this);
    console.log(moment().format('iD/iM/iYYYY'));
  }

  render() {
    return (
      <ScrollView style={styles.container}>

        <Text style={styles.text}>Calendar with custom day component</Text>
        <Calendar
          style={[styles.calendar, {height: 300}]}
          firstDay={2}
          dayComponent={({date, state}) => {
            console.log(date)
            return (<View><Text style={{textAlign: 'center', color: state === 'disabled' ? 'gray' : 'black'}}>{date.day}</Text>
            <Text>{moment(date.timestamp).format('iD/iM')}</Text>
            </View>);
          }}
        />
 
      </ScrollView>
    );
  }

  onDayPress(day) {
    this.setState({
      selected: day.dateString
    });
  }
}

const styles = StyleSheet.create({
  calendar: {
    borderTopWidth: 1,
    paddingTop: 5,
    borderBottomWidth: 1,
    borderColor: '#eee',
    height: 350
  },
  text: {
    textAlign: 'center',
    borderColor: '#bbb',
    padding: 10,
    backgroundColor: '#eee'
  },
  container: {
    flex: 1,
    backgroundColor: 'gray'
  }
});
