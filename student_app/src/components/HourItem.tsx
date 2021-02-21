import React from 'react';
import { StyleSheet, Text, View } from 'react-native';

type Props = {
    hour: number;
}

export default function HourItem({ hour }: Props) {

    return (
        <View style={styles.container}>
            <Text style={styles.hour}>{hour}:00</Text>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        marginBottom: 8,
        width: '100%',
        height: 64,
        borderRadius: 5,
        borderWidth: 1,
        borderColor: '#17B978',
        backgroundColor: '#D4FBEB'
    },
    hour: {
        fontFamily: 'OpenSans_400Regular',
        fontSize: 18,
        color: '#17B978',
        margin: 8
    }
})