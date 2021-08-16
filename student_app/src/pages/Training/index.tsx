import React, { useEffect, useState } from 'react';
import { Image, StyleSheet, Text, View } from 'react-native';
import AltBackground from '../../components/AltBackground';
import Header from '../../components/Header';
import MainButton from '../../components/MainButton';
import api from '../../services/api';

export default function Training() {

    const [formattedDate, setFormattedDate] = useState('');
    const [training, setTraining] = useState('');

    const monthNames = ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    ];

    useEffect(() => {
        const date = new Date().toISOString();
        const formattedDate = new Date(date);
        setFormattedDate(formattedDate.getDate().toString() + ' de ' + monthNames[formattedDate.getMonth()]);

        async function fetchUser() {
            try {
                const response = await api.get(`/trainings/${date.split('T')[0]}`);
                setTraining(response.data.wod);
            } catch (error) {
                console.log('Training not found: ' + error);
            }
        }

        fetchUser();
    }, [])

    const handleNoTraining = (training: string) => {
        if (training == '') {
            return (
                <View >
                    <Image style={styles.image} source={require('../../assets/images/relaxation.png')} />
                    <Text style={styles.freeDayPhrase}>Nada pra hoje, hora de descansar!</Text>
                </View>
            )
        } else {
            return (
                <>
                    <View style={styles.wodContainer}>
                        <Text style={styles.wodText}>{training}</Text>
                    </View>
                    <MainButton name="Confirmar presença" handleOnPress={() => { }} />
                </>
            )
        }
    }

    return (
        <View style={styles.container}>
            <Header />
            <AltBackground />
            <View style={styles.content}>
                <View>
                    <Text style={styles.date}>{formattedDate}</Text>
                    <Text style={styles.phrase}>E bora pra mais um treino...</Text>
                </View>
                {handleNoTraining(training)}
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        height: '100%',
        width: '100%'
    },
    content: {
        margin: 18,
        height: '100%'
    },
    date: {
        fontSize: 22,
        fontFamily: 'OpenSans_400Regular',
        color: '#17B978',
    },
    image: {
        alignSelf: 'center',
        marginTop: '5%'
    },
    phrase: {
        paddingTop: 5,
        marginBottom: '5%',
        fontSize: 24,
        fontFamily: 'OpenSans_400Regular',
        color: '#17B978'
    },
    freeDayPhrase: {
        textAlign: 'center',
        paddingTop: 5,
        fontSize: 24,
        fontFamily: 'OpenSans_400Regular',
        color: '#17B978'
    },
    wodContainer: {
        height: '55%',
        borderRadius: 10,
        borderWidth: 2,
        borderColor: '#17B978',
        margin: 12,
        paddingTop: 15,
        backgroundColor: 'white',
        shadowColor: "#000",
        shadowOffset: {
            width: 0,
            height: 2,
        },
        shadowOpacity: 0.25,
        shadowRadius: 3.84,
        elevation: 5,
    },
    wodText: {
        padding: 10,
        color: '#17B978',
        fontSize: 16,
        letterSpacing: 1.1,
        lineHeight: 25
    }
})