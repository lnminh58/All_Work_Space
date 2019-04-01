import React, { Component } from 'react';
import {
  Text,
  View,
  StyleSheet,
  Image,
  Animated,
  Easing,
  Dimensions
} from 'react-native';
import RNSimpleCompass from 'react-native-simple-compass';

const meccaRatio = 6.7;

export default class Compass extends Component {
  constructor() {
    super();
    this.state = {
      rot: 0,
    };
  }

  componentDidMount() {
    const degree_update_rate = 1; // Number of degrees changed before the callback is triggered
    RNSimpleCompass.start(degree_update_rate, degree => {
      // console.log('You are facing', degree);
      this.setState({ rot: degree });
    });
  }

  componentWillUnmount() {
    RNSimpleCompass.stop();
  }

  render() {

    return (
      <View style={styles.container}>
        <Text style={styles.text}>{this.state.rot + '°'}</Text>
        <View style={styles.imageContainer}>
          <Image
            resizeMode="contain"
            source={require('../assets/base.png')}
            style={{
              width: deviceWidth ,
              height: deviceHeight / 2 ,
              left: deviceWidth / 2 - (deviceWidth) / 2,
              top: deviceHeight / 2 - (deviceHeight / 2 ) / 2,
              transform: [{ rotate: `${-this.state.rot}deg` }]
            }}
          />
        </View>
        <View style={styles.arrowContainer}>
          <Image
            resizeMode="contain"
            source={require('../assets/meccaDirection.png')}
            style={styles.arrow}
          />
        </View>
      </View>
    );
  }
}

// Device dimensions so we can properly center the images set to 'position: absolute'
const deviceWidth = Dimensions.get('window').width;
const deviceHeight = Dimensions.get('window').height;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: 'rgb(3,2,32)'
  },
  text: {
    color: '#263544',
    fontSize: 80,
    transform: [
      { translateY: -(deviceHeight / 2 - (deviceHeight / 2 ) / 2) - 50 }
    ]
  },
  imageContainer: {
    ...StyleSheet.absoluteFillObject
  },
  arrowContainer: {
    ...StyleSheet.absoluteFillObject
  },
  arrow: {
    width: 46,
    height: 156,
    left: deviceWidth / 2 - 46 / 2, 
    top: deviceHeight / 2 - 156 + 25,
    opacity: 0.9
  }
});
