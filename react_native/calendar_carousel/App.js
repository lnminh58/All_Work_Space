import React, { Component } from 'react';
import {
  Platform,
  StyleSheet,
  Text,
  View,
  Dimensions,
  SafeAreaView
} from 'react-native';
import Carousel from 'react-native-snap-carousel';
import { Calendar } from 'react-native-calendars';
import { scrollInterpolator, animatedStyles } from './utils/animations';
import moment from 'moment';

const { width } = Dimensions.get('window');

const dayName = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']

export default class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      totalMonth: 5
    };
  }
  renderItem = ({ item, index }) => {
    return (
      <View
        style={{
          flex: 1,
          marginTop: 20,
          marginBottom: 30,
          marginHorizontal: 10,
          // justifyContent: 'center',
          backgroundColor: 'white',
          shadowColor: 'black',
          shadowOffset: { width: 0, height: 5 },
          shadowOpacity: 0.2,
          shadowRadius: 10,
          elevation: 10,
          borderRadius: 5
        }}
      >
        <Calendar
          hideDayNames
          hideArrows
          current={moment().add(item, "month").toDate()}
          theme={{
            textDayFontSize: 15,
            textMonthFontSize: 15,
            textDayHeaderFontSize: 15,
            'stylesheet.calendar.main': {
              container: {
                paddingHorizontal: 10,
                width: '100%'
              },
              week: {
                width: '100%',
                flexDirection: 'row',
                justifyContent: 'space-around'
              }
            },
            'stylesheet.calendar.header': {
              header: {
                flexDirection: 'row',
                paddingRight: 10,
                marginTop: 5,
                alignItems: 'center'
              }
            },
            'stylesheet.day.basic': {
              base: {
                paddingVertical: 3,
                alignItems: 'center'
              }
            }
          }}
        />
      </View>
    );
  };

  render() {
    const { totalMonth } = this.state;
    const data = [];
    for (let index = 0; index < totalMonth; index++) {
      data.push(index);
    }
    return (
      <SafeAreaView style={styles.container}>
        <View style={{
          flexDirection: 'row',
          justifyContent: 'space-around',
          width: width - 60,
          paddingHorizontal: 15,
          marginTop: 20
        }}>
          {dayName.map(item => (
            <Text 
              key={item}
              style={{ flex: 1, textAlign: 'center', color: '#888'}}
            >
              {item}
            </Text>
          ))}

        </View>
        <View style={{ height: 320 }}>
          <Carousel
            onSnapToItem={index => {
              if (index > totalMonth - 2 && totalMonth < 30 )
                this.setState({ totalMonth: totalMonth + 1 });
            }}
            ref={c => {
              this._carousel = c;
            }}
            data={data}
            renderItem={this.renderItem}
            sliderWidth={width}
            scrollInterpolator={scrollInterpolator}
            slideInterpolatedStyle={animatedStyles}
            itemWidth={width - 60}
            enableSnap
            removeClippedSubviews={false}
            extraData={this.state}
          />
        </View>
        <View style={{ flex: 1}}>
          <Text style={{ color: '#888' }}>My name is carousel</Text>
        </View>
      </SafeAreaView>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF'
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5
  }
});
