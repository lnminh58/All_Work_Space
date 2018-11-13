import http from '../services/http';

export default class User {
  /**
   * @function signup
   * @description Register a new email account
   * @param body {community, username, email, password, firstName, lastName}
   *  community: (string) - specify user community
   *  username: (string) - username, used for login
   *  email: (string) - email, used for login
   *  password: (string) - password, user for login
   *  firstName: (string) - first name
   *  lastName: (string) - last name
   * @return Promise { data } : data - user info with token
   */
  static signUp(body) {
    return http.post('/auth/signup', body);
  }


  /**
   * @function login
   * @description Login in app with specific community
   * @param body {community, username, password}
   *    community: (string) - specify user community
   *    username: (string) - username or email
   *    password: (string) - password
   * @return Promise { data } : data - user info with token
   */
  static login(body) {
    return http.post('/auth/login', body);
  }

  /**
   * @function updateProfile
   * @description To update my profile
   * @param body {firstName, lastName, profileImageURL, description, coordinates, address}
   * @return Promise { data } : data - user info
   */
  static updateProfile(data) {
    return http.put('/users/my-profile', data);
  }

  /**
   * @function getProfile
   * @description To get my profile
   * @return Promise { data } : data - user info
   */
  static getProfile() {
    return http.get('/users/my-profile');
  }
}
