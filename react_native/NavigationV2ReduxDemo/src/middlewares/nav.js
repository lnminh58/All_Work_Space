import { createReactNavigationReduxMiddleware } from 'react-navigation-redux-helpers'

export const reactNavigationReduxMiddleware = createReactNavigationReduxMiddleware(
  'root',
  state => state.nav,
)
