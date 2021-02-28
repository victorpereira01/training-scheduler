import React from 'react';
import { SafeAreaView, StyleSheet, Text, View } from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';

export default function ScheduledItem() {
    return (
        <SafeAreaView style={styles.container}>
            <View style={styles.content}>
                <Text style={styles.hour}>15/02</Text>
                <Text style={styles.hour}>13:00</Text>
            </View>
            <View style={styles.iconContainer}>
                <Icon style={styles.icon} name="trash" size={18} color="#17B978" />
            </View>
        </SafeAreaView>
    )
}

const styles = StyleSheet.create({
    container: {
        width: '100%',
        marginBottom: 8,
        height: 64,
        borderRadius: 5,
        borderWidth: 1,
        borderColor: '#17B978',
        backgroundColor: '#D4FBEB',
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center'

    },
    content: {
        flexDirection: 'row',
        alignContent: 'center'
    },
    hour: {
        fontFamily: 'OpenSans_400Regular',
        fontSize: 18,
        color: '#17B978',
        margin: 15
    },
    iconContainer: {
        margin: 15
    },
    icon: {
        justifyContent: 'flex-end'
    }
})