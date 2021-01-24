import React from 'react';
import { Image, StyleSheet, Text, View } from 'react-native';
import { RectButton } from 'react-native-gesture-handler';

export default function Landing() {
    return (
        <View style={styles.container}>
            <Image style={styles.appImage} source={require('../../assets/app-logo.png')} />
            <Text style={styles.title}>GO4WOD</Text>
            <Text style={styles.text}>Você pode se sentir dolorido amanhã ou pode sentir pena amanhã. Você escolhe.</Text>
            <RectButton style={styles.enterButton}>
                <Text style={styles.enterButtonText}>Entrar</Text>
            </RectButton>
            <RectButton style={styles.registerButton}>
                <Text style={styles.registerButtonText}>Registrar-se</Text>
            </RectButton>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        width: '100%',
        height: '100%',
        backgroundColor: '#2e2e2e',
        alignItems: 'center',
        justifyContent: 'flex-end'
    },
    appImage: {
        marginBottom: 48
    },
    title: {
        color: '#17B978',
        fontSize: 32,
        fontWeight: '700',
        marginBottom: 18
    },
    text: {
        textAlign: 'center',
        color: '#fff',
        width: '50%'
    },
    enterButton: {
        width: '85%',
        height: 54,
        marginTop: 48,
        backgroundColor: '#17B978',
        borderRadius: 8,
        justifyContent: 'center',
    },
    enterButtonText: {
        textAlign: 'center',
        color: '#fff',
        fontSize: 20,
        fontWeight: '700'
    },
    registerButton: {
        width: '85%',
        height: 54,
        marginTop: 32,
        backgroundColor: '#fff',
        borderRadius: 8,
        justifyContent: 'center',
        marginBottom: '30%'
    },
    registerButtonText: {
        textAlign: 'center',
        color: '#17B978',
        fontSize: 20,
        fontWeight: '700',
    }
})