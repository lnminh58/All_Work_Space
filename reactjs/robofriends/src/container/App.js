import React, { Component } from 'react';
import axios from 'axios';

import CardList from '../component/CardList';
import SearchBox from '../component/SearchBox';
import Scroll from '../component/Scroll';

import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      robots: [],
      searchField: ''
    };
    this.onSearchChange = this.onSearchChange.bind(this);
    this.robots = [];
  }

  componentDidMount() {
    console.log('did mount');
    axios
      .get('https://jsonplaceholder.typicode.com/users')
      .then(res => {
        this.robots = res.data;
        this.setState({ robots: res.data });
      })
      .catch(err => console.log('err::', err));
  }

  onSearchChange(event) {
    const searchField = event.target.value;

    const filteredRobots = this.robots.filter(e =>
      e.name.toLowerCase().includes(searchField.toLowerCase())
    );
    this.setState({
      searchField,
      robots: filteredRobots
    });
  }

  render() {
    return (
      <div className="tc">
        <h1>RoboFriends</h1>
        <SearchBox searchChange={this.onSearchChange} />
        <Scroll>
          <CardList robots={this.state.robots} />
        </Scroll>
      </div>
    );
  }
}

export default App;
