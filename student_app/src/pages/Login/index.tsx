import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { useState } from 'react';
import { Alert, Image, StyleSheet, Text, View } from "react-native";
import Background from '../../components/Background';
import EmailInput from '../../components/EmailInput';
import InputContainer from '../../components/InputContainer';
import MainButton from '../../components/MainButton';
import api from '../../services/api';

const showAlert = (errors: string) =>
    Alert.alert(
        "Erro ao realizar login",
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

export default function Login() {
    const navigation = useNavigation();

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = async () => {
        try {
            const response = await api.get(`/users/email?value=${email}`);
            const userId = response.data.id;

            if (response.data.password == password) {
                if (response.data.name == null) {
                    navigation.navigate('FirstLogin', userId);
                } else {
                    navigation.navigate('Home', userId);
                }
            } else {
                showAlert('Email ou senha incorretos.');
            }
        } catch (error) {
            showAlert('Email ou senha incorretos.');
        }
    }

    return (
        <View style={styles.container}>
            <Background reverse={false}></Background>
            <View style={styles.content}>
                <Image source={require('../../assets/images/student.png')} />
                <Text style={styles.title}>GO4WOD</Text>
                <EmailInput name="E-mail" onChangeText={setEmail} />
                <InputContainer name="Password" onChangeText={setPassword} isPassword={true} />
                <MainButton name="Confirmar" handleOnPress={handleLogin} />
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
        paddingBottom: 25,
        fontFamily: 'OpenSans_400Regular'
    },
    text: {
        textAlign: 'center',
        color: '#fff',
        width: '50%',
        marginBottom: 24,
        fontFamily: 'OpenSans_400Regular'
    },
    inputContainer: {
        width: '85%'
    },
    inputText: {
        marginTop: 16,
        fontSize: 20,
        paddingBottom: 5,
        fontFamily: 'OpenSans_700Bold',
        color: '#17B978'
    },
    input: {
        color: '#3d3d3d',
        fontSize: 18,
        borderWidth: 1,
        borderRadius: 8,
        borderColor: '#17B978',
        height: 40,
        padding: 10,
        borderBottomWidth: 5
    }
})