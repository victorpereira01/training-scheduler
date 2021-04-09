import React, { useEffect, useState } from 'react';
import { Modal, Pressable, StyleSheet, Text, View } from 'react-native';
import { RectButton } from 'react-native-gesture-handler';
import AltBackground from '../../components/AltBackground';
import Header from '../../components/Header';
import HourItem from '../../components/HourItem';
import MainButton from '../../components/MainButton';

export default function Training() {

    const [date, setDate] = useState('');
    const [formattedDate, setFormattedDate] = useState('');
    const [modalVisible, setModalVisible] = useState(false);

    const monthNames = ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
        "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"
    ];

    useEffect(() => {
        const date = new Date().toLocaleDateString();
        const formattedDate = new Date(date);
        setFormattedDate(formattedDate.getDate().toString() + " de " + monthNames[formattedDate.getMonth()]);
        setDate(new Date().toISOString().split("T")[0]);
    }, [])

    return (
        <View style={styles.container}>
            <Header />
            <AltBackground></AltBackground>
            <View style={styles.content}>
                <View>
                    <Text style={styles.date}>{formattedDate}</Text>
                    <Text style={styles.phrase}>E bora pra mais um treino...</Text>
                </View>
                <View style={styles.wodContainer}>
                    <Text style={styles.wodText}>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a nibh eu ipsum congue vehicula eu eu sem. Sed cursus odio eu lorem dapibus, eget ultricies tortor rutrum. Aenean eget ultricies arcu. </Text>
                </View>
                <MainButton name="Confirmar presença" handleOnPress={() => {}}/>
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
    phrase: {
        paddingTop: 5,
        marginBottom: '5%',
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
        backgroundColor: 'white'
    },
    wodText: {
        padding: 10,
        color: '#17B978',
        fontSize: 16
    }
})