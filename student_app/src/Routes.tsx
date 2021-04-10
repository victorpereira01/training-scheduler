import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';
import Landing from './pages/Landing';
import Login from './pages/Login';
import Register from './pages/Register';
import Home from './pages/Home';
import Training from './pages/Training';
import TrainingHistory from './pages/TrainingHistory';
import Profile from './pages/Profile';
import { StatusBar } from 'expo-status-bar';
import FirstLogin from './pages/FirstLogin';

const Stack = createStackNavigator();

function Routes() {
    return (
        <NavigationContainer>
            <StatusBar />
            <Stack.Navigator headerMode='none'>
                <Stack.Screen
                    name="Landing"
                    component={Landing}
                    options={{
                        animationEnabled: false,
                    }}
                ></Stack.Screen>
                <Stack.Screen
                    name="Login"
                    component={Login}
                    options={{
                        animationEnabled: false,
                    }}
                ></Stack.Screen>
                <Stack.Screen
                    name="Register"
                    component={Register}
                ></Stack.Screen>
                <Stack.Screen
                    name="Home"
                    component={Home}
                ></Stack.Screen>
                <Stack.Screen
                    name="FirstLogin"
                    component={FirstLogin}
                ></Stack.Screen>
                <Stack.Screen
                    name="Training"
                    component={Training}
                ></Stack.Screen>
                <Stack.Screen
                    name="TrainingHistory"
                    component={TrainingHistory}
                ></Stack.Screen>
                <Stack.Screen
                    name="Profile"
                    component={Profile}
                ></Stack.Screen>
            </Stack.Navigator>
        </NavigationContainer>
    )
}

export default Routes;