import React from 'react';
import { Image, StyleSheet, Text, View } from 'react-native';

export default function Header() {
    return (
        <View style={styles.container}>
            <View style={styles.content}>
                <Image style={styles.appImage} source={require('../../assets/app-logo.png')} />
                <Text style={styles.title}>GO4WOD</Text>
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        width: '100%',
        height: '12%',
        backgroundColor: '#2e2e2e',
        alignItems: 'center',
        justifyContent: 'flex-end'
    },
    content: {
        flexDirection: 'row',
        alignItems: 'center',
        marginBottom: 16
    },
    appImage: {
        resizeMode: 'contain',
        width: '12%',
        height: '110%',
    },
    title: {
        color: '#17B978',
        fontFamily: 'OpenSans_700Bold',
        fontSize: 21,
        height: '100%'
    }
})