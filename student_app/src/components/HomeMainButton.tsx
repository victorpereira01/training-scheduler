import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { RectButton, TouchableNativeFeedback, TouchableOpacity } from 'react-native-gesture-handler';

type Props = {
    title: string,
    handleOnPress(): void
}

export default function HomeMainButton({ title, handleOnPress }: Props) {
    return (
        <View style={styles.container}>
            <TouchableNativeFeedback style={styles.button} onPress={handleOnPress}>
                <Text style={styles.title}>{title}</Text>
            </TouchableNativeFeedback>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        width: '75%',
        height: 75,
        justifyContent: 'center',
        backgroundColor: '#17B978',
        borderRadius: 8
    },
    button: {
        height: '100%',
        width: '100%',  
        justifyContent: 'center',
    },
    title: {
        fontFamily: 'OpenSans_400Regular',
        textAlign: 'center',
        fontSize: 18,
        color: 'white'
    }
})