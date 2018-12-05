import React from 'react';

const SearchBox = ({ searchField, searchChange }) => {
  return (
    <div className="pa2 ">
      <input
        className="pa3 ba br3 b--green bg-lightest-blue"
        type="search"
        value={searchField}
        placeholder="search robots"
        onChange={searchChange}
      />
    </div>
  );
};

export default SearchBox;
