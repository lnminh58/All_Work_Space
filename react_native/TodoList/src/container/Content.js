import React, { Component } from 'react';
import { Tab, Tabs, TabHeading, Text, Icon } from 'native-base';
import { connect } from 'react-redux';
import ListTodos from './ListTodos';
import TodoForm from './TodoForm';

class Content extends Component {
   // componentDidMount(){
   //    this.props.dispatch({
   //       typ
   //    });
   // }
   render() {
      // console.log('inside render method: ', this.props.destinationTab);
      return (
         <Tabs
            page={this.props.destinationTab}
            tabContainerStyle={{ height: 30 }}
            tabBarUnderlineStyle={{ height: 2 }}
         >
            <Tab
               heading={
                  <TabHeading style={{ backgroundColor: '#28a745' }}>
                     <Text>List</Text>
                  </TabHeading>
               }
            >
               <ListTodos />
            </Tab>
            <Tab
               heading={
                  <TabHeading style={{ backgroundColor: '#28a745' }}>
                     <Icon name="add-circle" />
                  </TabHeading>
               }
            >
               <TodoForm />
            </Tab>
         </Tabs>
      );
   }
}

function mapStateToProps(state) {
//    console.log('inside map function', state.destinationTab);
   return ({ destinationTab } = state);
}

export default connect(mapStateToProps)(Content);
