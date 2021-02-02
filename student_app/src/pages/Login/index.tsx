import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { Image, StyleSheet, Text, View } from "react-native";
import InputContainer from '../../components/InputContainer';
import MainButton from '../../components/MainButton';

export default function Login() {

    const navigation = useNavigation();

    const handleLogin = () => {
        navigation.navigate('Home');
    }

    return (
        <View style={styles.container}>
            <View style={styles.content}>
                <Image style={styles.appImage} source={require('../../../assets/app-logo.png')} />
                <Text style={styles.title}>GO4WOD</Text>
                <Text style={styles.text}>Você pode se sentir dolorido amanhã ou pode sentir pena amanhã. Você escolhe.</Text>
                <InputContainer name="E-mail" />
                <InputContainer name="Password" />
                <MainButton name="Confirmar" handleOnPress={handleLogin} />
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
        marginBottom: 24,
        fontFamily: 'OpenSans_400Regular'
    },
    padding: {
        marginTop: 16
    }
})