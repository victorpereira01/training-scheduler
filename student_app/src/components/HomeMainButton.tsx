import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

type Props = {
    title: string
}

export default function HomeMainButton({ title }: Props) {
    return (
        <View style={styles.container}>
            <Text style={styles.title}>{title}</Text>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        width: '75%',
        height: 75,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#17B978',
        borderRadius: 8
    },
    title: {
        fontSize: 18,
        color: 'white'
    }
})