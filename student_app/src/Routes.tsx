import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';
import Landing from './pages/Landing';
import Login from './pages/Login';
import Register from './pages/Register';
import Home from './pages/Home';
import Schedule from './pages/Schedule';

const Stack = createStackNavigator();

function Routes() {
    return (
        <NavigationContainer>
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
                    name="Schedule"
                    component={Schedule}
                ></Stack.Screen>
            </Stack.Navigator>
        </NavigationContainer>
    )
}

export default Routes;