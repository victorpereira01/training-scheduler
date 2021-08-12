import { useNavigation, useRoute } from '@react-navigation/native';
import React from 'react';
import { useState } from 'react';
import { Alert, StyleSheet, Text, View } from 'react-native';
import AltBackground from '../../components/AltBackground';
import Header from '../../components/Header';
import InputContainer from '../../components/InputContainer';
import MainButton from '../../components/MainButton';
import api from '../../services/api';

const showAlert = (errors: string) =>
    Alert.alert(
        "Erro ao concluir cadastro",
        errors,
        [
            {
                text: "OK",
                style: "default",
            },
        ],
        {
            cancelable: false,
        }
    );

export default function FirstLogin() {

    const navigation = useNavigation();

    const [name, setName] = useState('');
    const [birthDate, setBirthDate] = useState('');

    const route = useRoute();
    const userId = route.params;

    const handleNavigateToTraining = async () => {
        const user = {
            name,
            birthDate
        }

        try {
            await api.put(`/users/${userId}`, user);
            navigation.navigate('Home', userId);
        } catch (error) {
            showAlert(error);
        }
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
                    <InputContainer name="Nome" onChangeText={setName} isPassword={false} />
                    <InputContainer name="Data de nascimento" onChangeText={setBirthDate} isPassword={false} />
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
    },
    datePickerContainer: {
        width: '85%'
    },
    datePickerText: {
        marginTop: 16,
        fontSize: 20,
        paddingBottom: 5,
        fontFamily: 'OpenSans_700Bold',
        color: '#17B978'
    },
    datePicker: {

        width: '100%',
        alignSelf: 'center',
        borderWidth: 1,
        borderRadius: 8,
        borderColor: '#17B978',
        borderBottomWidth: 5
    }
})