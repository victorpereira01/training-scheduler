import React, { useEffect, useState } from 'react';
import { SafeAreaView, StyleSheet, View } from 'react-native';
import { ScrollView } from 'react-native-gesture-handler';
import AltBackground from '../../components/AltBackground';
import Header from '../../components/Header';
import TrainingItem from '../../components/TrainingItem';

export default function TrainingHistory() {
    return (
        <View style={styles.container}>
            <Header />
            <AltBackground />
            <SafeAreaView style={styles.nav}>
                <ScrollView>
                    <TrainingItem />
                    <TrainingItem />
                    <TrainingItem />
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
        height: '80%',
        marginTop: 24,
        margin: 18
    }
})