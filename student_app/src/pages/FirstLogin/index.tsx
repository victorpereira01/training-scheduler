import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { Image, StyleSheet, Text, View } from 'react-native';
import AltBackground from '../../components/AltBackground';
import Header from '../../components/Header';
import InputContainer from '../../components/InputContainer';
import MainButton from '../../components/MainButton';

export default function FirstLogin() {

    const navigation = useNavigation();

    const handleNavigateToTraining = () => {
        navigation.navigate('Home');
        // navigation.reset({
        //     index: 0,
        //     routes: [{name: 'Home'}],
        //   });
    }

    return (
        <View style={styles.container}>
            <Header />
            <AltBackground />
            <View style={styles.greetings}>
                <Text style={styles.welcome}>Bem-vindo ao GO4WOD!</Text>
                <Text style={styles.action}>Vamos terminar seu cadastro.</Text>
            </View>
            <View style={styles.wrapper}>
                <View style={styles.inputWrapper}>
                    <InputContainer name="Nome" />
                    <InputContainer name="Data de nascimento" />
                </View>
                <MainButton name="Confirmar" handleOnPress={handleNavigateToTraining} />
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        height: '100%',
        width: '100%',
        backgroundColor: 'transparent',
    },
    greetings: {
        padding: 15
    },
    welcome: {
        fontSize: 24,
        color: '#17B978'
    },
    action: {
        fontSize: 18,
        color: '#17B978',
        paddingTop: 5
    },
    wrapper: {
        width: '100%',
        padding: 0,
        alignItems: 'center'
    },
    inputWrapper: {
        width: '100%',
        alignItems: 'center',
        marginBottom: '10%'

    }
})