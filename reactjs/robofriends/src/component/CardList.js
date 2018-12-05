import React from 'react';
import Card from './Card';

const CardList = ({ robots }) => {
  const cardComponents = robots.map(e => (
    <Card
      onClick={() => alert(`${e.name} was added into cart`)}
      key={e.id}
      id={e.id}
      robot={e}
    />
  ));
  return <div>{cardComponents}</div>;
};

export default CardList;
