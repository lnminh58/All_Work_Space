import React, { Component } from 'react';
import { Container, Content, Card, Button, Text, Textarea } from 'native-base';
import { StyleSheet } from 'react-native';
import { connect } from 'react-redux';
import { changeToTab, addWork, fillUpForm } from '../action';

class TodoForm extends Component {
   constructor(props) {
      super(props);
      this.state = {
         title: '',
         detail: ''
      };
   }
   // componentWillMount() {
   //    console.log('inside componentWillMount');

   //    this.setState({
   //       title: this.props.currentFormData.title,
   //       detail: this.props.currentFormData.detail
   //    });
   // }

   componentWillReceiveProps(nextProps) {
      this.setState({
         title: nextProps.currentFormData.title,
         detail: nextProps.currentFormData.detail
      });
   }
   render() {
      const { containerStyle, cardStyle, buttonStyle } = styles;

      return (
         <Container style={containerStyle}>
            <Content>
               <Card style={cardStyle}>
                  <Textarea
                     onChangeText={title => this.setState({ title })}
                     value={this.state.title}
                     rowSpan={2}
                     bordered
                     placeholder="Title"
                  />

                  <Textarea
                     onChangeText={detail => this.setState({ detail })}
                     value={this.state.detail}
                     rowSpan={7}
                     bordered
                     placeholder="Detail"
                  />

                  <Button
                     onPress={() => {
                        this.props.changeToTab(0);
                        this.props.changeToTab(0);
                        this.props.addWork(this.state.title, this.state.detail);
                        this.props.fillUpForm('', '');
                     }}
                     block
                     success
                     style={buttonStyle}
                  >
                     <Text>Accept</Text>
                  </Button>
               </Card>
            </Content>
         </Container>
      );
   }
}

const styles = StyleSheet.create({
   containerStyle: {
      marginTop: 20,
      paddingHorizontal: 5
   },
   cardStyle: {
      padding: 5
   },
   buttonStyle: {
      marginTop: 5,
      marginBottom: 5
   }
});

function mapStateToProps(state) {
   console.log('inside map', state.currentFormData);

   return ({ currentFormData } = state);
}

export default connect(
   mapStateToProps,
   { changeToTab, addWork, fillUpForm }
)(TodoForm);
