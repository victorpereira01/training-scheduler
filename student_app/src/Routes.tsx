import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';
import Landing from './pages/Landing';
import Login from './pages/Login';
import Register from './pages/Register';

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
            </Stack.Navigator>
        </NavigationContainer>
    )
}

export default Routes;