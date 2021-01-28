import React from 'react';
import { useNavigation } from '@react-navigation/native';
import { Image, StyleSheet, Text, View } from 'react-native';
import { RectButton } from 'react-native-gesture-handler';
import MainButton from '../../components/MainButton';

export default function Landing() {

    const navigation = useNavigation();

    const handleLogin = () => {
        navigation.navigate('Login');
    }

    return (
        <View style={styles.container}>
            <View style={styles.content}>
                <Image style={styles.appImage} source={require('../../../assets/app-logo.png')} />
                <Text style={styles.title}>GO4WOD</Text>
                <Text style={styles.text}>Você pode se sentir dolorido amanhã ou pode sentir pena amanhã. Você escolhe.</Text>
                <MainButton name="Entrar" handleOnPress={handleLogin} />
                <RectButton style={styles.registerButton}>
                    <Text style={styles.registerButtonText}>Registrar-se</Text>
                </RectButton>
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        width: '100%',
        height: '100%',
        backgroundColor: '#2e2e2e'
    },
    content: {
        alignItems: 'center',
        justifyContent: 'center',
        marginTop: '50%'
    },
    appImage: {
        marginBottom: 48
    },
    title: {
        color: '#17B978',
        fontSize: 32,
        marginBottom: 25,
        fontFamily: 'OpenSans_700Bold'
    },
    text: {
        textAlign: 'center',
        color: '#fff',
        width: '50%',
        marginBottom: 48,
        fontFamily: 'OpenSans_400Regular'
    },
    enterButton: {
        width: '85%',
        height: 48,
        backgroundColor: '#17B978',
        borderRadius: 8,
        justifyContent: 'center'
    },
    enterButtonText: {
        textAlign: 'center',
        color: '#fff',
        fontSize: 20,
        fontFamily: 'OpenSans_700Bold'
    },
    registerButton: {
        width: '85%',
        height: 48,
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
        fontFamily: 'OpenSans_700Bold'
    }
})