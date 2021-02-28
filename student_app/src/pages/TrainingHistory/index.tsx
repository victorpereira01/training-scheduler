import React, { useEffect, useState } from 'react';
import { SafeAreaView, StyleSheet, Text, View } from 'react-native';
import { ScrollView } from 'react-native-gesture-handler';
import Header from '../../components/Header';
import ScheduledItem from '../../components/ScheduledItem';

export default function TrainingHistory() {
    return (
        <View style={styles.container}>
            <Header />
            <SafeAreaView style={styles.nav}>
                <ScrollView>
                    <ScheduledItem />
                    <ScheduledItem />
                    <ScheduledItem />
                    <ScheduledItem />
                    <ScheduledItem />
                    <ScheduledItem />
                    <ScheduledItem />
                    <ScheduledItem />
                    <ScheduledItem />
                    <ScheduledItem />
                </ScrollView>
            </SafeAreaView>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        height: '100%',
        width: '100%'
    },
    nav: {
        height: '80%'
,        marginTop: 24,
        margin: 18
    }
})