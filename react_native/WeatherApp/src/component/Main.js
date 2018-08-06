import React, { Component } from 'react';
import {
   View,
   Text,
   TextInput,
   TouchableOpacity,
   StyleSheet
} from 'react-native';
import { connect } from 'react-redux';
import Header from './header';
import { getTemp } from '../api/getTemp';
import * as actions from '../redux/actionCreator';
class Main extends Component {
   state = {
      city: 'hanoi'
   };

   getWeatherMessage() {
      const { city, temp, isLoading, error } = this.props;
      if (isLoading) return '...Loading';
      if (error) return 'Vui lòng thử lại';
      if (!city) return 'Nhập tên địa điểm hiện tại';
      return `Thời tiết tại ${city} là ${temp} *C`;
   }
   getTempByCity() {
      const { city } = this.state;
      console.log(this, city);
      this.props.fetchDataThunk(city);
   }

   render() {
      const {
         containerStyle,
         messageStyle,
         buttonStyle,
         buttonTextStyle,
         TextInputStyle
      } = styles;
      return (
         <View style={{ flex: 1 }}>
            <Header headerText="Weather" />
            <View style={containerStyle}>
               <Text style={messageStyle}>{this.getWeatherMessage()}</Text>
               <TextInput
                  underlineColorAndroid="#e99790"
                  style={TextInputStyle}
                  value={this.state.Main}
                  onChangeText={city => this.setState({ city })}
               />
               <TouchableOpacity
                  onPress={() => this.getTempByCity()}
                  style={buttonStyle}
               >
                  <Text style={buttonTextStyle}>Lấy nhiệt độ</Text>
               </TouchableOpacity>
            </View>
         </View>
      );
   }
}

const mapStateToProps = state => {
   return ({ city, temp, isLoading, error } = state);
};

export default connect(
   mapStateToProps,
   actions
)(Main);

const styles = StyleSheet.create({
   containerStyle: {
      backgroundColor: '#f2e2cd',
      flex: 1,
      alignSelf: 'stretch',
      justifyContent: 'center',
      alignItems: 'center'
   },
   messageStyle: {
      color: '#48697f',
      fontSize: 25,
      fontWeight: 'bold'
   },
   buttonStyle: {
      backgroundColor: '#e99790',
      margin: 50,
      padding: 7,
      borderRadius: 3,
      elevation: 5
   },
   buttonTextStyle: {
      color: '#ecf0f2',
      fontWeight: 'bold'
   },
   TextInputStyle: {
      margin: 10,
      width: 300,
      textAlign: 'center',
      color: '#6c6d79'
      // borderColor: 'white'
   }
});
