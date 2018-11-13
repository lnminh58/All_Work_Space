import PushNotification from 'react-native-push-notification';
import { Platform } from 'react-native';

const configure = () => {
    PushNotification.configure({
        onRegister: (token) => {
            console.log('TOKEN: ', token);
        },
    
        onNotification: (notification) => {
            console.log('NOTIFICATION: ', notification);
            notification.finish(PushNotificationIOS.FetchResult.NoData);
        },
    
        senderID: "834097703481",
    
        permissions: {
            alert: true,
            badge: true,
            sound: true
        },
    
        popInitialNotification: true,
        requestPermissions: true,
    });
}

const localNotificationSchedule = () => {
    const option = {
        autoCancel: true,
        largeIcon: 'ic_launcher',
        vibrate: true,
        vibration: 300,
        playSound: true,
        soundName: 'default',
        message: "My Notification Message",
        date: new Date( Date.now() + 5000),
        // repeatTime: 3000,
        // repeatType:'time'
    }

    console.log('option:::::', option);

    PushNotification.localNotificationSchedule(option);
}

const cancelLocalNotifications = () => {
    PushNotification.cancelLocalNotifications()
}

const LocalPushNotification = {
    configure,
    localNotificationSchedule,
    cancelLocalNotifications
};

export default LocalPushNotification;
