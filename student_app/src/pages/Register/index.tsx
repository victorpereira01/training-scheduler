import { useNavigation } from '@react-navigation/native';
import React, { useState } from 'react';
import { Image, StyleSheet, Text, View } from 'react-native';
import InputContainer from '../../components/InputContainer';
import MainButton from '../../components/MainButton';
import Background from '../../components/Background';
import api from '../../services/api';

export default function Register() {

    const navigation = useNavigation();

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleRegister = async () => {
        const user = {
            email,
            password
        }

        try {
            await api.post('/users', user);
            alert('Cadastro realizado!');

        } catch (error) {
            alert(error);
            console.log(error);
        }
    }

    return (
        <View style={styles.container}>
            <Background reverse={true}></Background>
            <View style={styles.content}>
                <Image source={require('../../assets/images/trainer.png')} />
                <Text style={styles.title}>Começe a treinar {"\n"} ainda hoje!</Text>
                <InputContainer name="Email" onChangeText={setEmail} />
                <InputContainer name="Senha" onChangeText={setPassword} />
                <MainButton name="Confirmar" handleOnPress={handleRegister} />
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        width: '100%',
        height: '100%',
        backgroundColor: 'transparent'
    },
    content: {
        alignItems: 'center',
        justifyContent: 'center',
        marginTop: '25%'
    },
    title: {
        textAlign: 'center',
        color: '#17B978',
        fontSize: 24,
        paddingTop: 15,
        paddingBottom: 15,
        fontFamily: 'OpenSans_400Regular'
    },
    label: {
        marginTop: 16,
        fontSize: 20,
        paddingBottom: 5,
        fontFamily: 'OpenSans_700Bold',
        color: '#17B978',
    },
})