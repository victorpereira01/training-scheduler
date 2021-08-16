import { useNavigation, useRoute } from '@react-navigation/native';
import React from 'react';
import { useState } from 'react';
import { useEffect } from 'react';
import { Image, StyleSheet, Text, View } from 'react-native';
import AltBackground from '../../components/AltBackground';
import AltButton from '../../components/AltButton';
import Header from '../../components/Header';
import MainButton from '../../components/MainButton';
import api from '../../services/api';

export default function Home() {

    const navigation = useNavigation();

    const route = useRoute();
    const userId = route.params;

    const [username, setUsername] = useState('');

    const handleNavigateToTraining = () => {
        navigation.navigate('Training');
    }

    const handleNavigateToHistory = () => {
        navigation.navigate('TrainingHistory');
    }

    const handleNavigateToProfile = () => {
        navigation.navigate('Profile');
    }

    const handleNavigateLogout = () => {
        navigation.navigate('Login');
    }

    useEffect(() => {
        async function fetchUser() {
            try {
                const response = await api.get(`/users/${userId}`);
                const usr: string = response.data.name;
                setUsername(usr.split(' ')[0]);
            } catch (error) {
                alert('Error finding user');
            }
        }

        fetchUser();
    }, [])

    return (
        <View style={styles.container}>
            <Header />
            <AltBackground />
            <View style={styles.content}>
                <Text style={styles.title}>Bem-vindo, {username}!</Text>
                <Text style={styles.subtitle}>O seu limite fica depois daquela vontade de parar.</Text>
                <Image style={styles.image} source={require('../../assets/images/training.png')} />
                <View style={styles.buttonContent}>
                    <MainButton name="Ver WOD" handleOnPress={handleNavigateToTraining}></MainButton>
                    <AltButton name="Seus treinos" handleOnPress={handleNavigateToHistory}></AltButton>
                </View>
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
    content: {
        padding: 15
    },
    title: {
        fontSize: 24,
        color: '#17B978'
    },
    subtitle: {
        paddingTop: 5,
        fontSize: 14,
        color: '#17B978'
    },
    image: {
        alignSelf: 'center',
        marginTop: '5%'
    },
    buttonContent: {
        marginTop: '10%'
    }
})