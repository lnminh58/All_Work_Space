import React, { Component } from 'react';
import { View, Dimensions } from 'react-native';
import RNSimpleCompass from 'react-native-simple-compass';

import AnalogClock from '../../components/AnalogClock';

const clockFace = require('../../../assets/img/clockBack.png');

const { width } = Dimensions.get('window');
const clockSize = width - 40;
const hourHandLength = clockSize / 4;
const minuteHandLength = clockSize / 3;
const secondHandLength = clockSize / 2.2;
const hourHandOffsetRatio = 9.85;
const minuteHandOffsetRatio = 11.7;
const secondHandOffsetRatio = 20;

const hourHandOffset = hourHandLength / hourHandOffsetRatio;
const minuteHandOffset = minuteHandLength / minuteHandOffsetRatio;
const secondHandOffset = secondHandLength / secondHandOffsetRatio;

import styles from './styles';
const clockBackground = require('./../../../assets/img/clock.png');

class Compass extends Component {
  constructor(props) {
    super(props);
    this.state = {};

  }
  componentDidUpdate() {

  }

  render() {
    return (
      <View
        style={{
          flex: 1,
          justifyContent: 'center',
          alignItems: 'center',
          backgroundColor: 'white'
        }}
      >
        <AnalogClock
          // clockFace={clockFace}
          hourHandLength={hourHandLength}
          minuteHandLength={minuteHandLength}
          secondHandLength={secondHandLength}
          minuteHandWidth={40}
          hourHandWidth={40}
          withBackground
          clockBorderWidth={0}
          clockSize={clockSize}
          hourHandOffset={-hourHandOffset}
          secondHandOffset={-secondHandOffset}
          minuteHandOffset={-minuteHandOffset}
          secondHandWidth={40}
          clockCentreSize={4}
          clockCentreColor="#27ae60"
          clockFaceColor="#3498db"
          secondHandColor="#27ae60"
          minuteHandColor="#27ae60"
          hourHandColor="#27ae60"
          updateTime={50}
          smoothRotate
          // showRealTime={false}
          // initialDate={new Date()}
        />
      </View>
    );
  }
}

export default Compass;
