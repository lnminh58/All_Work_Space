import React, { Component } from 'react';
import {
   Text,
   TouchableWithoutFeedback,
   View,
   LayoutAnimation,
   UIManager,
   Platform
} from 'react-native';
import { connect } from 'react-redux';
import { CardSection } from './common';
import * as actions from '../actions';

class ListItem extends Component {

   constructor() {
      super();
      if (Platform.OS === 'android') {
         UIManager.setLayoutAnimationEnabledExperimental(true);
      }
    }

   componentWillUpdate() {
      LayoutAnimation.spring();
   }

   renderDescription() {
      const { library, expanded } = this.props;
      if (expanded) {
         return (
            <CardSection>
               <Text style={{ flex: 1 }}>{library.description} </Text>
            </CardSection>
         );
      }
   }

   render() {
      const { titleStyle } = styles;
      const { id, title } = this.props.library;
      // console.log(this.props);
      return (
         <TouchableWithoutFeedback onPress={() => this.props.selectLibrary(id)}>
            <View>
               <CardSection>
                  <Text style={titleStyle}>{title}</Text>
               </CardSection>
               {this.renderDescription()}
            </View>
         </TouchableWithoutFeedback>
      );
   }
}

const styles = {
   titleStyle: {
      fontSize: 18,
      paddingLeft: 30,
      paddingTop: 10,
      paddingBottom: 10
   }
};

const mapStateToProps = (state, ownProps) => {
   const expanded = state.selectedLibraryId === ownProps.library.id;
   return { expanded };
};

export default connect(
   mapStateToProps,
   actions
)(ListItem);
