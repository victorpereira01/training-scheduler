import React from 'react';
import { StyleSheet, View } from 'react-native';

export default function Background() {
    return (
        <>
            <View style={styles.backgroundTop}>

            </View>
            <View style={styles.backgroundBottom}></View>
        </>
    )
}

const styles = StyleSheet.create({
    backgroundTop: {
        backgroundColor: 'rgba(23, 185, 120,0.25)',
        height: '38%',
        width: '100%',
        position: 'absolute',
        borderBottomLeftRadius: 175,
    },
    backgroundBottom: {
        backgroundColor: 'rgba(23, 185, 120,0.25)',
        position: 'absolute',
        width: '100%',
        height: '100%',
        top: '90%',
        borderTopEndRadius: 175
    }
})