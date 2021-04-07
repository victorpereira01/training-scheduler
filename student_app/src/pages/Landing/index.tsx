import React from 'react';
import { useNavigation } from '@react-navigation/native';
import { Image, StyleSheet, Text, View } from 'react-native';
import MainButton from '../../components/MainButton';
import AltButton from '../../components/AltButton';
import Background from '../../components/Background';

export default function Landing() {

    const navigation = useNavigation();

    const handleLogin = () => {
        navigation.navigate('Login');
    }

    const handleRegister = () => {
        navigation.navigate('Register');
    }

    return (
        <View style={styles.container}>
            <Background reverse={false}></Background>
            <View style={styles.content}>
                <Image source={require('../../assets/images/student.png')} />
                <Text style={styles.title}>GO4WOD</Text>
                <MainButton name="Entrar" handleOnPress={handleLogin} />
                <AltButton name="Registrar-se" handleOnPress={handleRegister} />
            </View>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        width: '100%',
        height: '100%',
        backgroundColor: 'transparent',
    },
    content: {
        alignItems: 'center',
        justifyContent: 'center',
        marginTop: '25%'
    },
    title: {
        color: '#17B978',
        fontSize: 35,
        paddingTop: 15,
        paddingBottom: 80,
        fontFamily: 'OpenSans_400Regular'
    }
})