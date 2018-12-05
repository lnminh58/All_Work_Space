import React, { Component } from 'react';
import './Hello.css';

const Hello = (props) => (
  <div className="f1 tc">
    <h1>Hello world</h1>
    <p>{props.greeting}</p>
  </div>
);

export default Hello;
