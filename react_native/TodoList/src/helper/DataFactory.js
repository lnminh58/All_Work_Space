import { AsyncStorage } from 'react-native';

const save = async (key, data) => {
   try {
      console.log('save');
      await AsyncStorage.setItem(key, JSON.stringify(data));
      console.log('save ok');
   } catch (error) {
      console.log(error);
   }
};

const load = async key => {
   try {
      console.log('load');
      const strData = await AsyncStorage.getItem(key);
      const data = await JSON.parse(strData);
      console.log('load done');
      return data;
   } catch (error) {
      console.log(error);
   }
};

export { save, load };
