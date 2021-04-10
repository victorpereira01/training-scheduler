import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { Image, StyleSheet, Text, TextInput, View } from "react-native";
import Background from '../../components/Background';
import InputContainer from '../../components/InputContainer';
import MainButton from '../../components/MainButton';

export default function Login() {

    const navigation = useNavigation();

    const handleLogin = () => {
        navigation.navigate('FirstLogin');
    }

    return (
        <View style={styles.container}>
            <Background reverse={false}></Background>
            <View style={styles.content}>
                <Image source={require('../../assets/images/student.png')} />
                <Text style={styles.title}>GO4WOD</Text>
                <InputContainer name="E-mail" />
                <View style={styles.inputContainer}>
                    <Text style={styles.inputText}>Password</Text>
                    <TextInput secureTextEntry style={styles.input}></TextInput>
                </View>
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