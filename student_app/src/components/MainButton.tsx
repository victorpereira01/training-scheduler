import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { RectButton } from 'react-native-gesture-handler';

type Props = {
    name: string,
    handleOnPress(): void,
}

export default function MainButton({ name, handleOnPress }: Props) {
    return (
        <View style={styles.container}>
            <RectButton style={styles.enterButton} onPress={handleOnPress}>
                <Text style={styles.enterButtonText}>{name}</Text>
            </RectButton>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        width: '100%',
        alignItems: 'center',
        justifyContent: 'center',
    },
    enterButton: {
        width: '85%',
        height: 48,
        backgroundColor: '#17B978',
        borderRadius: 8,
        justifyContent: 'center',
        marginTop: 24
    },
    enterButtonText: {
        textAlign: 'center',
        color: '#fff',
        fontSize: 20,
        fontFamily: 'OpenSans_700Bold'
    },
})