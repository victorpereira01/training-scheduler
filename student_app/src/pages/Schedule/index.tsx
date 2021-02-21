import React, { useEffect, useState } from 'react';
import { Modal, Pressable, StyleSheet, Text, View } from 'react-native';
import { RectButton } from 'react-native-gesture-handler';
import Header from '../../components/Header';
import HourItem from '../../components/HourItem';

export default function Schedule() {

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
            <Modal
                transparent
                visible={modalVisible}
                onRequestClose={() => {
                    setModalVisible(!modalVisible)
                }}
            >
                <View style={styles.modalView}>
                    <View style={styles.modalContent}>
                        <View style={styles.modalWod}>
                            <Text style={styles.modalWodText}>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce iaculis nulla ut dolor pellentesque, eget euismod justo scelerisque.</Text>
                        </View>
                        <Pressable onPress={() => setModalVisible(!modalVisible)}>
                            <Text style={styles.modalButton}>OK</Text>
                        </Pressable>
                    </View>
                </View>
            </Modal>
            <View style={styles.content}>
                <View style={styles.details}>
                    <Text style={styles.date}>{formattedDate}</Text>
                    <RectButton style={styles.wodButton} onPress={() => setModalVisible(true)}>
                        <Text style={styles.buttonText}>Ver WOD</Text>
                    </RectButton>
                </View>
                <View style={styles.schedule}>
                    <HourItem hour={13} />
                    <HourItem hour={14} />
                    <HourItem hour={15} />
                    <HourItem hour={16} />
                    <HourItem hour={17} />
                    <HourItem hour={18} />
                    <HourItem hour={19} />
                    <HourItem hour={20} />
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
    content: {
        margin: 18,
        height: '100%'
    },
    details: {
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'space-between',
    },
    date: {
        fontSize: 24,
        fontFamily: 'OpenSans_700Bold',
        color: '#17B978',
    },
    wodButton: {
        height: '100%',
        backgroundColor: '#17B978',
        borderRadius: 5
    },
    buttonText: {
        padding: 8,
        color: 'white',
        fontFamily: 'OpenSans_400Regular'
    },
    schedule: {
        marginTop: 20,
        height: '100%'
    },
    modalView: {
        width: '100%',
        height: '100%',
        alignItems: 'center',
        justifyContent: 'center'
    },
    modalContent: {
        backgroundColor: '#17B978',
        borderRadius: 8,
        width: '75%',
        height: '60%',
        alignItems: 'center',
        justifyContent: 'space-between'
    },
    modalWod: {
        padding: 18
    },
    modalWodText: {
        color: 'white',
        fontFamily: 'OpenSans_400Regular',
        textAlign: 'justify'
    },
    modalButton: {
        fontSize: 18,
        padding: 18,
        color: 'white',
        fontFamily: 'OpenSans_700Bold'
    }
})