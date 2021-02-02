import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

type Props = {
    title: string
}

export default function HomeAltButton({ title }: Props) {
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
        backgroundColor: '#D4FBEB',
        borderWidth: 1,
        borderRadius: 8,
        borderColor: '#17B978',
    
    },
    title: {
        fontSize: 18,
        color: '#17B978',
    }
})