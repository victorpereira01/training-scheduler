import React from 'react';
import { StyleSheet, View } from 'react-native';

export default function AltBackground() {
    return (
        <>
            <View style={styles.background}></View>
        </>
    )
}

const styles = StyleSheet.create({
    background: {
        height: '65%',
        width: '140%',
        alignSelf: 'center',
        position: 'absolute',
        backgroundColor: 'rgba(23, 185, 120,0.25)',
        borderBottomRightRadius: 300,
        borderBottomLeftRadius: 300
    },
})