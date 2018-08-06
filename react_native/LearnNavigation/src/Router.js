import React from 'react';
import { StackNavigator, TabNavigator, DrawerNavigator } from 'react-navigation';

import Home from './components/Home';
import User from './components/User';
import Detail from './components/Detail';
import Menu from './components/Menu';


export const HomeStack = StackNavigator({
    homeScreen: {
        screen: Home,   
        navigationOptions: {
            // header: null,
            // title: 'Trang chu',

        }
    },
    detailScreen: {
        screen: Detail,
        navigationOptions: {
            title: 'Chi tiet',
            
        }
    },
});
export const UserStack = StackNavigator({
    userScreen: {
        screen: User,
        navigationOptions: {
            title: 'Tai Khoan',
        }
    }
});

export const Tabbar = TabNavigator({
        homeButton: {
            screen: HomeStack,
            navigationOptions: {
                tabBarLabel: 'Home',
            }
        },
        UserButton: {
            screen: UserStack,
            navigationOptions: {
                tabBarLabel: 'User',
            }
        }
        
    },
    {
        tabBarPosition: 'bottom',
        swipeEnabled: true,
        tabBarOptions: {
            style: {
                backgroundColor: 'green',
            },
            inactiveTintColor: 'white',
            activeTintColor: 'orange',
        }
    }
);

export const SideMenu = DrawerNavigator({
    tabbar: {
        screen: Tabbar,
    },
    {
        drawerWidth: 300,
        drawerPosition: 'right',
        contentComponent: props => <Menu {...props} />
    }
});
