import { AsyncStorage } from 'react-native';

export const storeData = async () => {
   try {
         console.log('before saving');
         await AsyncStorage.setItem('TASKS', 'I like to save it.');
         console.log('after saving');
      } catch (error) {
            // Error saving data
            console.log('error when save');
      }
};

export const retrieveData = async () => {
      try {
            console.log('before loading');
            const value = await AsyncStorage.getItem('TASKS');
            console.log('after loading');
      if (value !== null) {
            // We have data!!
            console.log('value: ');
            console.log(value);
      }
   } catch (error) {
      // Error retrieving data
      console.log('error when load');
   }
};

// storeData();
// retrieveData();

