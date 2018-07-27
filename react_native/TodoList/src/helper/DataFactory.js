import { AsyncStorage } from 'react-native';

const storeData = async (key, value) => {
   try {
         // console.log('before set item');
      console.log('====================================');
      await AsyncStorage.setItem(key, value);
   
      console.log('after set item');
      console.log('====================================');
   } catch (error) {
      console.log('inside catch block of store method');
   }
};

const retrieveData = async (key) => {
   try {
      // console.log('before get item');
      const value = await AsyncStorage.getItem(key);
      console.log('after get item');
      return value;
   } catch (error) {
      console.log('inside catch block of retrieve method');
   }
};
// storeData();
// retrieveData();
export { storeData, retrieveData };
