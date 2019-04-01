import React, { Component } from 'react';
import {
  StyleSheet,
  Text,
  TouchableOpacity,
  SafeAreaView,
  Dimensions,
  View,
  ScrollView
} from 'react-native';
import Popover from './component/react-native-popover-view';

const { width, height } = Dimensions.get('window');

export default class App extends Component {
  state = {
    isVisible: false
  };

  showPopover() {
    this.setState({ isVisible: true });
  }

  closePopover() {
    this.setState({ isVisible: false });
  }

  render() {
    
    return (
      <SafeAreaView style={styles.container}>
        <ScrollView>
          <View style={{height: height * 2 / 3, width}}/>
          <TouchableOpacity
            ref={ref => (this.touchable = ref)}
            style={styles.button}
            onPress={() => this.showPopover()}
          >
            <Text style={{color: 'green', alignSelf: 'flex-end'}}>Press me</Text>
          </TouchableOpacity>

          {
          
          this.state.isVisible && (<Popover
            isVisible={this.state.isVisible}
            fromView={this.touchable}
            onClose={() => this.closePopover()}
            showBackground={false}
            arrowStyle={{ height: 20, width: 10 }}
            popoverStyle={{
              borderRadius: 10,
            }}
            containerStyle={{
              shadowColor: '#000',
                shadowOffset: { width: 0, height: 5 },
                shadowOpacity: 0.3,
                shadowRadius: 10,
                elevation: 5,
                paddingHorizontal: 30
            }}
          >
            <View
              style={{
                justifyContent: 'center',
                width: width - 60,
                height: 250,
                alignItems: 'center',
              }}
            >
              <Text style={{ fontSize: 30, fontWeight: '600', color: '#369' }}>content here</Text>
            </View>
          </Popover>)}
          <View style={{height: height * 2 / 3, width}}/>
        </ScrollView>
      </SafeAreaView>
    );
  }
}

var styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'flex-end',
    justifyContent: 'flex-end',
    backgroundColor: 'white'
  },
  button: {
    alignSelf: 'flex-end',
  }
});
