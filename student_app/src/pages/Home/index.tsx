import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { Image, StyleSheet, Text, View } from 'react-native';
import AltBackground from '../../components/AltBackground';
import AltButton from '../../components/AltButton';
import Background from '../../components/Background';
import Header from '../../components/Header';
import MainButton from '../../components/MainButton';

export default function Home() {

    const navigation = useNavigation();

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

    return (
        <View style={styles.container}>
            <Header />
            <AltBackground />
            <View style={styles.content}>
                <Text style={styles.title}>Bem-vindo, X!</Text>
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