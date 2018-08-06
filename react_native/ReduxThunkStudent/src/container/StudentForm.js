import React, { Component } from 'react';
import {
   Container,
   Content,
   Card,
   Button,
   Text,
   Picker,
   DatePicker,
   Item,
   Input,
   CheckBox,
   ListItem,
   Body
} from 'native-base';
import { StyleSheet } from 'react-native';
import { connect } from 'react-redux';
import { goToHome, fetchBatchsThunk, addStudentThunk } from '../action';
import AppHeader from './Header';

class StudentForm extends Component {
   constructor(props) {
      super(props);
      this.state = {
         name: '',
         selectedBatch: null,
         birthday: new Date(),
         gender: false,
         batchs: []
      };

      this.props.fetchBatchsThunk();
   }
   componentWillReceiveProps(nextProps) {
      this.setState({
         name: nextProps.currentFormData.name,
         selectedBatch: nextProps.currentFormData.selectedBatch,
         birthday: nextProps.currentFormData.birthday,
         gender: nextProps.currentFormData.gender,
         batchs: nextProps.currentFormData.batchs
      });
   }
   render() {
      //  console.log('rednder');
      const { cardStyle, buttonStyle } = styles;
      const { batchs } = this.state;
      return (
         <Container>
            <AppHeader headerText="Form Student" headerIconName="edit" />
            <Content>
               <Card style={cardStyle}>
                  <Item>
                     <Input
                        placeholder="name"
                        value={this.state.name}
                        onChangeText={name => this.setState({ name })}
                     />
                  </Item>
                  <ListItem>
                     <CheckBox
                        checked={this.state.gender}
                        color="#333"
                        onPress={() =>
                           this.setState({ gender: !this.state.gender })
                        }
                     />
                     <Body>
                        <Text>Male</Text>
                     </Body>
                  </ListItem>
                  <DatePicker
                     defaultDate={new Date(1994, 4, 4)}
                     minimumDate={new Date(1950, 1, 1)}
                     maximumDate={new Date(2020, 12, 31)}
                     locale={'en'}
                     timeZoneOffsetInMinutes={undefined}
                     modalTransparent={false}
                     animationType={'fade'}
                     androidMode={'default'}
                     placeHolderText="Select birthday"
                     textStyle={{ color: 'green' }}
                     placeHolderTextStyle={{ color: '#d3d3d3' }}
                     onDateChange={birthday => this.setState({ birthday })}
                  />

                  <Picker
                     mode="dropdown"
                     placeholder="Select Batch"
                     placeholderStyle={{ color: '#bfc6ea' }}
                     placeholderIconColor="#007aff"
                     style={{ width: null }}
                     selectedValue={this.state.selectedBatch}
                     onValueChange={selectedBatch => {
                        console.log(selectedBatch);
                        this.setState({ selectedBatch });
                     }}
                  >
                     <Picker.Item label="choose Batch..." value={null} />
                     {batchs.map(batch => (
                        <Picker.Item
                           label={batch.batchName}
                           value={batch.id}
                           key={batch.id}
                        />
                     ))}
                  </Picker>
                  <Button
                     onPress={() => {
                        console.log(this.state);
                        const data = {
                           fullName: this.state.name,
                           gender: this.state.gender,
                           birthday: this.state.birthday,
                           batchId: this.state.selectedBatch
                        };
                        this.props.addStudentThunk(data);
                        this.props.goToHome();
                     }}
                     block
                     warning
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
   { goToHome, fetchBatchsThunk, addStudentThunk }
)(StudentForm);
