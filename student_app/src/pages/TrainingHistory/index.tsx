import React, { useEffect, useState } from 'react';
import { StyleSheet, Text, View } from 'react-native';
import Header from '../../components/Header';
import ScheduledItem from '../../components/ScheduledItem';

export default function TrainingHistory() {
    return (
        <View style={styles.container}>
            <Header />
            <View style={styles.nav}>
                <ScheduledItem/>
                <ScheduledItem/>
                <ScheduledItem/>
                <ScheduledItem/>
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        height: '100%',
        width: '100%'
    },
    nav: {
        marginTop: 24,
        margin: 18
    }
})