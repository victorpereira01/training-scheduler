import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { TouchableNativeFeedback } from 'react-native-gesture-handler';

type Props = {
    title: string,
    handleOnPress(): void
}

export default function HomeAltButton({ title, handleOnPress }: Props) {
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
        backgroundColor: '#D4FBEB',
        borderWidth: 1,
        borderRadius: 8,
        borderColor: '#17B978',

    },
    button: {
        height: '100%',
        width: '100%',
        justifyContent: 'center',
    },
    title: {
        textAlign: 'center',
        width: '100%',
        fontSize: 18,
        color: '#17B978',
    }
})