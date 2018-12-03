import { StyleSheet, Dimensions } from 'react-native';

const { height } = Dimensions.get('window');

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  linearGradient: {
    flex: 1,
    // height: height / 3,
    alignItems: 'center',
    justifyContent: 'center'
  },
  drawerHeaderText: {
    color: '#fff',
    fontSize: 17,
    fontWeight: 'bold'
  },
  drawerHeaderImage: {
    height: height / 6,
    width: height / 6,
    borderRadius: height / 12
  },
  rowItem: {
    flexDirection: 'row',
    justifyContent: 'flex-start',
    alignItems: 'flex-start',
    padding: 10,
  },
  rowText: {
    marginLeft: 10,
    color: '#6c6c6c',
    fontSize: 18,
    fontWeight: '400'
  }
});

export default styles;
