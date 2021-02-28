import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';
import Header from '../../components/Header';
import MainButton from '../../components/MainButton';

export default function Profile() {
    return (
        <View style={styles.container}>
            <Header />
            <View style={styles.content}>
                <View style={styles.profileCard}>
                    <View style={styles.profileImage}>
                        <Icon name="camera" size={24} />
                    </View>
                    <Text style={styles.profileText}>Lorem ipsym</Text>
                    <Text style={styles.profileText}>loremipsym@gmail.com</Text>
                    <Text style={styles.profileText}>21/21/21</Text>
                </View>
                <MainButton name="Deletar conta" handleOnPress={() => { }} />
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        width: '100%',
        height: '100%'
    },
    content: {
        width: '100%',
        height: '100%',
        justifyContent: 'flex-start',
        alignItems: 'center'
    },
    profileCard: {
        width: '80%',
        height: '60%',
        marginTop: '10%',
        justifyContent: 'flex-start',
        alignItems: 'center',
        borderRadius: 8,
        borderTopWidth: 2,
        borderTopColor: '#e0e0e0',
        borderLeftWidth: 2,
        borderLeftColor: '#e0e0e0',
        borderBottomWidth: 5,
        borderBottomColor: '#e0e0e0',
        borderRightWidth: 5,
        borderRightColor: '#e0e0e0',
    },
    profileImage: {
        width: 120,
        height: 120,
        marginTop: 45,
        marginBottom: 45,
        borderRadius: 60,
        backgroundColor: 'grey',
        justifyContent: 'center',
        alignItems: 'center'
    },
    profileText: {
        margin: 24,
        fontSize: 18,
        color: '#17B978',
    }
})