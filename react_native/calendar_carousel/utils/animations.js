import { Platform } from 'react-native';
import { getInputRangeFromIndexes } from 'react-native-snap-carousel'

export function scrollInterpolator(index, carouselProps) {
  const range = [2, 1, 0, -1, -2]
  const inputRange = getInputRangeFromIndexes(range, index, carouselProps)
  const outputRange = range

  return { inputRange, outputRange }
}

export function animatedStyles(index, animatedValue, carouselProps) {
  const outputRange = Platform.select({
    ios: [1, 1.05, 1],
    android: [0.95, 1, 0.95]
  });
  return {
    zIndex: carouselProps.data.length - index,
    transform: [{
      perspective: 1000,
      scale: animatedValue.interpolate({
        inputRange: [-1, 0, 1],
        outputRange,
        extrapolate: 'clamp'
      }),
    }]
  }
}
