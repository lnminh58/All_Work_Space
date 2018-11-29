import React, { Component } from 'react';
import {
  Text,
  View,
  TouchableOpacity,
  Animated,
  StyleSheet,
  Image,
  Dimensions,
  FlatList
} from 'react-native';
import Interactable from 'react-native-interactable';
import SplashScreen from 'react-native-splash-screen'

const { width, height } = Dimensions.get('window');

class CollapsibleExample extends Component {
  constructor(props) {
    super(props);
     SplashScreen.show();
    this.state = {
      refreshing: false,
    };
    this.snapPoints = [
      { y: 0, tension: 100, damping: 0.8 },
      { tension: 100, damping: 0.8 , y: -((height / 20) * 2 + 20) }
    ];
    this.deltaY = new Animated.Value(this.snapPoints[1].y);
    this.index = 1;
    this.data = this.repareData();
    this.currentContentOffset = 0;
  }

  componentDidMount () {
    setTimeout(() => {
      SplashScreen.hide();
    }, 1000);
  }

  repareData() {
    let arr = [];
    for (let i = 0; i <= 50; i++) {
      arr.push(i + '');
    }
    return arr;
  }

  handleRefresh = () => {
    this.setState({ refreshing: true });
    setTimeout(() => {
      this.setState({ refreshing: false });
    }, 1500);
  }

  render() {
    return (
      <View style={styles.container}>
        <View style={[styles.filterContainer]}>
          <TouchableOpacity style={styles.filterRow}>
            <Text style={styles.filterRowText}>First Row, always show</Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.filterRow}>
            <Text style={styles.filterRowText}>second Row</Text>
          </TouchableOpacity>

          <TouchableOpacity style={styles.filterRow}>
            <Text style={styles.filterRowText}>Third Row</Text>
          </TouchableOpacity>
        </View>

        <Interactable.View
          ref="content"
          verticalOnly={true}
          boundaries={{ top: -150 }}
          snapPoints={this.snapPoints}
          animatedValueY={this.deltaY}
          initialPosition={this.snapPoints[1]}
          onSnap={event => {
            const { index } = event.nativeEvent;
            this.index = index;
          }}
        >
          <View style={styles.content}>
            <FlatList
              data={this.data}
              refreshing={this.state.refreshing}
              onRefresh={() => this.handleRefresh()}
              onScrollBeginDrag={event =>
                (this.currentContentOffset = event.nativeEvent.contentOffset.y)
              }
              onScrollEndDrag={event => {
                const { y } =event.nativeEvent.contentOffset;
                if(y>this.currentContentOffset) {
                  this.refs['content'].snapTo({ index: 1 })
                }
                //  else {
                //   this.refs['content'].snapTo({ index: 0 })
                // }
              }}
              contentContainerStyle={{ paddingBottom: 80 }}
              renderItem={({ item }) => (
                  <TouchableOpacity style={styles.listItemContainer}>
                    <Text style={{ color: 'white' }}>{item}</Text>
                  </TouchableOpacity>
              )}
              keyExtractor={item => item}
            />
          </View>
          <View style={styles.arrowContainer}>
            <TouchableOpacity
              onPress={() => {
                this.index === 0
                  ? this.refs['content'].snapTo({ index: 1 })
                  : this.refs['content'].snapTo({ index: 0 });
              }}
            >
              <Animated.Image
                style={[
                  styles.arrow,
                  {
                    transform: [
                      {
                        rotate: this.deltaY.interpolate({
                          inputRange: [
                            this.snapPoints[1].y,
                            this.snapPoints[0].y
                          ],
                          outputRange: ['180deg', '0deg']
                        })
                      }
                    ]
                  }
                ]}
                source={require('../../assets/icon-up.png')}
              />
            </TouchableOpacity>
          </View>
        </Interactable.View>
      </View>
    );
  }
}

export default CollapsibleExample;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white'
  },
  filterContainer: {
    backgroundColor: '#278485',
    paddingVertical: 5
  },

  filterRow: {
    height: height / 20,
    marginVertical: 5,
    marginHorizontal: 10,
    justifyContent: 'center',
    backgroundColor: ' rgba(255,255,255,0.2)',
    borderRadius: 5
  },
  filterRowText: {
    fontSize: height / 40,
    color: 'white',
    marginLeft: 20
  },

  content: {
    paddingTop: 30,
    backgroundColor: 'white',
    position: 'relative'
  },
  arrowContainer: {
    borderBottomLeftRadius: 4,
    borderBottomRightRadius: 4,
    position: 'absolute',
    backgroundColor: '#278485',
    top: 0,
    right: 20
  },
  arrow: {
    width: 26,
    height: 26
  },
  listItemContainer: {
    backgroundColor: '#278485',
    padding: 20,
    alignItems: 'center',
    marginHorizontal: 20,
    marginBottom: 10,
    borderRadius: 5
  }
});
