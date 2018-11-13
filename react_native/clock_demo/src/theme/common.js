/* eslint-disable import/prefer-default-export, quote-props, prefer-const */

import { Platform } from 'react-native';

// we define available font weight and styles for each font here
const font = {
  Montserrat: {
    weights: {
      '200': 'ExtraLight',
      '300': 'Light',
      '400': 'Regular',
      '500': 'Medium',
      '600': 'SemiBold',
      '700': 'Bold'
    },
    styles: {
      Italic: 'italic'
    }
  }
};

// generate styles for a font with given weight and style
export const fontMaker = (options = {}) => {
  let { weight, style, family } = Object.assign({
    weight: null,
    style: null,
    family: 'Montserrat'
  }, options);

  const { weights, styles } = font[family];

  if (Platform.OS === 'android') {
    weight = weights[weight] ? weights[weight] : '';
    style = styles[style] ? style : '';

    const suffix = weight + style;

    return {
      fontFamily: family + (suffix.length ? `-${suffix}` : ''),
      fontWeight: 'normal'
    };
  }
  style = styles[style] || 'normal';

  return {
    fontFamily: family,
    fontWeight: weight || '400',
    fontStyle: style
  };
};
