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
import PropTypes from 'prop-types';
import moment from 'moment';

import { scrollInterpolator, animatedStyles } from '../utils/animations';

const { width } = Dimensions.get('window');

const dayName = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF'
  },
  calendarContainer: {
    flex: 1,
    marginTop: 20,
    marginBottom: 30,
    marginHorizontal: 10,
    backgroundColor: 'white',
    shadowColor: 'black',
    shadowOffset: { width: 0, height: 5 },
    shadowOpacity: 0.2,
    shadowRadius: 10,
    elevation: 10,
    borderRadius: 5
  },
  calendarBodyContainer: {
    paddingHorizontal: 10,
    width: '100%'
  },
  week: {
    width: '100%',
    flexDirection: 'row',
    justifyContent: 'space-around'
  },
  calendarHeader: {
    flexDirection: 'row',
    paddingRight: 10,
    marginTop: 5,
    alignItems: 'center'
  },
  dayContainer: {
    paddingVertical: 3,
    alignItems: 'center'
  },
  dayNameContainer: {
    flexDirection: 'row',
    justifyContent: 'space-around',
    width: width - 60,
    paddingHorizontal: 15,
    marginTop: 20
  },
  lblDayName: {
    flex: 1,
    textAlign: 'center',
    color: '#888'
  }
});

export default class ListCalendar extends Component {
  static propTypes = {
    itemWidth: PropTypes.number,
    renderItem: PropTypes.func,
    minMonthNumber: PropTypes.number.isRequired,
    maxMonthNumber: PropTypes.number
  };

  static defaultProps = {
    itemWidth: width - 60,
    minMonthNumber: 5,
    maxMonthNumber: 12,
    renderItem: null
  };

  constructor(props) {
    super(props);
    const { minMonthNumber } = this.props;
    const { renderItem } = this.props;

    this.state = {
      renderedMonths: minMonthNumber
    };

    this.renderItem = renderItem || this.renderCalendarItem;
  }

  renderCalendarItem = ({ item }) => {
    return (
      <View style={styles.calendarContainer}>
        <Calendar
          hideDayNames
          hideArrows
          current={moment()
            .add(item, 'month')
            .toDate()}
          theme={{
            textDayFontSize: 15,
            textMonthFontSize: 15,
            textDayHeaderFontSize: 15,
            'stylesheet.calendar.main': {
              container: styles.calendarBodyContainer,
              week: styles.week
            },
            'stylesheet.calendar.header': {
              header: styles.calendarHeader
            },
            'stylesheet.day.basic': {
              base: styles.dayContainer
            }
          }}
        />
      </View>
    );
  };

  onSnapToItem = index => {
    const { renderedMonths } = this.state
    const { maxMonthNumber } = this.props

    if (index >= renderedMonths - 2 && renderedMonths < maxMonthNumber) {
      this.setState({ renderedMonths: renderedMonths + 1 });
    }
  };

  render() {
    const { renderedMonths } = this.state
    const { itemWidth, extraData } = this.props;

    const data = Array
      .apply(null, {length: renderedMonths})
      .map(Number.call, Number)

    return (
      <View style={styles.container}>
        <View style={styles.dayNameContainer}>
          {dayName.map(item => (
            <Text key={item} style={styles.lblDayName}>
              {item}
            </Text>
          ))}
        </View>

        <View style={{ height: 320 }}>
          <Carousel
            onSnapToItem={this.onSnapToItem}
            data={data}
            renderItem={this.renderItem}
            sliderWidth={width}
            scrollInterpolator={scrollInterpolator}
            slideInterpolatedStyle={animatedStyles}
            itemWidth={itemWidth}
            enableSnap
            removeClippedSubviews={false}
            extraData={extraData}
          />
        </View>
      </View>
    );
  }
}
