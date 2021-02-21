import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { StyleSheet, View } from 'react-native';
import Header from '../../components/Header';
import HomeAltButton from '../../components/HomeAltButton';
import HomeMainButton from '../../components/HomeMainButton';

export default function Home() {

    const navigation = useNavigation();

    const handleNavigateToSchedule = () => {
        navigation.navigate('Schedule');
    }

    return (
        <View style={styles.container}>
            <Header />
            <View style={styles.buttonContainer}> 
                <View style={styles.button}>
                    <HomeMainButton title="Agende um Treino" handleOnPress={handleNavigateToSchedule} />
                </View>
                <View style={styles.button}>
                    <HomeMainButton title="Treinos Agendados" handleOnPress={() => {}}/>
                </View>
                <View style={styles.button}>
                    <HomeMainButton title="Perfil" handleOnPress={() => {}} />
                </View>
                <View style={styles.button}>
                    <HomeAltButton title="Sair"/>
                </View>
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        height: '100%',
        width: '100%'
    },
    buttonContainer: {
        marginTop: 36
    },
    button: {
        width: '100%',
        alignItems: 'center',
        marginTop: 56
    }
})