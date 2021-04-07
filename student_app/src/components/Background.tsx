import React from 'react';
import { StyleSheet, View } from 'react-native';

type Props = {
    reverse: boolean
}

export default function Background({ reverse }: Props) {
    return (
        <>
            {reverse == true ?
                <>
                    <View style={styles.reverseBackgroundTop}></View>
                    <View style={styles.reverseBackgroundBottom}></View>
                </>
                :
                <>
                    <View style={styles.backgroundTop}></View>
                    <View style={styles.backgroundBottom}></View>
                </>
            }
        </>
    )
}

const styles = StyleSheet.create({
    reverseBackgroundTop: {
        backgroundColor: 'rgba(23, 185, 120,0.25)',
        height: '38%',
        width: '100%',
        position: 'absolute',
        borderBottomRightRadius: 175,
    },
    reverseBackgroundBottom: {
        backgroundColor: 'rgba(23, 185, 120,0.25)',
        position: 'absolute',
        width: '100%',
        height: '100%',
        top: '90%',
        borderTopStartRadius: 175
    },
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