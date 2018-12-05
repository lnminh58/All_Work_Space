import React from 'react';

const Card = ({ robot, onClick }) => {
  return (
    <div
      onClick={onClick}
      className="bg-light-green dib br3 pa3 ma2 grow bw2 shadow-5"
    >
      <img src={`https://robohash.org/${robot.username}?100x100`} alt="robot" />
      <div>
        <h2>{robot.name}</h2>
        <p>{robot.email}</p>
      </div>
    </div>
  );
};

export default Card;
