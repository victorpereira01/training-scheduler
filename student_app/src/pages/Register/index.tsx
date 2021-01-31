import { useNavigation } from '@react-navigation/native';
import React, { useState } from 'react';
import DatePucker from 'react-native-datepicker';
import { Image, StyleSheet, Text, View } from 'react-native';
import InputContainer from '../../components/InputContainer';
import MainButton from '../../components/MainButton';
import DatePicker from 'react-native-datepicker';

export default function Register() {

    const navigation = useNavigation();

    const [date, setDate] = useState('');

    const handleRegister = () => {
        navigation.navigate('Landing');
    }

    return (
        <View style={styles.container}>
            <View style={styles.content}>
                <Image style={styles.appImage} source={require('../../../assets/app-logo.png')} />
                <InputContainer name="Nome" />
                <InputContainer name="E-mail" />
                <InputContainer name="Senha" />
                <View style={styles.datePickerContainer}> 
                    <Text style={styles.label}>Data de Nascimento</Text>
                    <DatePicker
                        style={styles.datePicker}
                        date={date}
                        format="DD-MM-YYYY"
                        showIcon={false}
                        onDateChange={setDate}
                        customStyles={{
                            dateInput: {
                                marginLeft: 8,
                                alignItems: 'flex-start',
                                borderWidth: 0
                            },
                            dateText: {
                                color: 'white'
                            }
                        }}
                    />
                </View>
                <MainButton name="Confirmar" handleOnPress={handleRegister} />
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        width: '100%',
        height: '100%',
        backgroundColor: '#2e2e2e'
    },
    content: {
        alignItems: 'center',
        marginTop: '40%'
    },
    appImage: {
        marginBottom: 24
    },
    datePickerContainer: {
        width: '85%'
    },
    label: {
        marginTop: 16,
        fontSize: 20,
        paddingBottom: 5,
        fontFamily: 'OpenSans_700Bold',
        color: '#17B978',
    },
    datePicker: {
        borderWidth: 1,
        borderColor: '#17B978',
        borderRadius: 5,
        width: '100%',
    }
})