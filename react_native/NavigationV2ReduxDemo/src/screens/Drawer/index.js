import React, { PureComponent } from 'react';
import { View, Text, Image, TouchableOpacity } from 'react-native';
import LinearGradient from 'react-native-linear-gradient';
import { NavigationActions, StackActions} from 'react-navigation';
import { connect } from 'react-redux';
import PropTypes from 'prop-types';
import Icon from 'react-native-vector-icons/AntDesign';

import styles from './styles';

class Drawer extends PureComponent {
  static propTypes = {
    drawerProps: PropTypes.object.isRequired,
    nav: PropTypes.object
  };

  constructor(props) {
    super(props);
    this.state = {};
  }

  resetNavItemMenu = routeName => () => {
    const { drawerProps, nav } = this.props;
    // const currentRoute = getActiveRouteStateChildDrawer(nav);

    // if (currentRoute.routeName === routeName) {
    //   this.closeDawer();
    //   return;
    // }
    const navigationAction = StackActions.reset({
      index: 0,
      actions: [
        NavigationActions.navigate({ routeName, params: { isReset: true } })
      ]
    });
    drawerProps.navigation.dispatch(navigationAction);
  };

  render() {
    return (
      <View style={styles.container}>
        <View style={{ flex: 1 }}>
          <LinearGradient
            useAngle
            angle={140}
            // start={{ x: 0, y: 0 }}
            // end={{ x: 0.75, y: 1.0 }}
            colors={['#12c2e9', '#c471ed', '#f64f59']}
            style={styles.linearGradient}
          >
            <Image
              source={{ uri: 'https://picsum.photos/200/200/?136' }}
              style={styles.drawerHeaderImage}
            />
            <Text style={styles.drawerHeaderText}>Amanda Alan</Text>
          </LinearGradient>
        </View>

        <View style={{ flex: 2 }}>
          <TouchableOpacity
            onPress={this.resetNavItemMenu('Home')}
            style={styles.rowItem}
          >
            <Icon name="home" size={22} color="#f64f59" />
            <Text style={styles.rowText}>Home</Text>
          </TouchableOpacity>
          <TouchableOpacity
            onPress={this.resetNavItemMenu('Detail')}
            style={styles.rowItem}
          >
            <Icon name="profile" size={22} color="#f64f59" />
            <Text style={styles.rowText}>Detail</Text>
          </TouchableOpacity>
        </View>
        <TouchableOpacity
          onPress={this.resetNavItemMenu('Profile')}
          style={styles.rowItem}
        >
          <Icon name="solution1" size={22} color="#f64f59" />
          <Text style={styles.rowText}>Account Setting</Text>
        </TouchableOpacity>
      </View>
    );
  }
}

export default connect(
  state => ({
    nav: state.nav
  }),
  null
)(Drawer);
