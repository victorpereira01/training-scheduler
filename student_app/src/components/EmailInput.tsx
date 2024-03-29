import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { TextInput } from 'react-native-gesture-handler';

type Props = {
    name: string,
    onChangeText: (str: string) => void
}

export default function EmailInput({ name, onChangeText }: Props) {
    return (
        <View style={styles.container}>
            <Text style={styles.text}>{name}</Text>
            <TextInput 
                autoCapitalize='none' 
                keyboardType='email-address' 
                style={styles.input} 
                onChangeText={onChangeText}
            >
            </TextInput>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        width: '85%'
    },
    text: {
        marginTop: 16,
        fontSize: 20,
        paddingBottom: 5,
        fontFamily: 'OpenSans_700Bold',
        color: '#17B978'
    },
    input: {
        color: '#3d3d3d',
        fontSize: 18,
        borderWidth: 1,
        borderRadius: 8,
        borderColor: '#17B978',
        height: 40,
        padding: 10,
        borderBottomWidth: 5
    }
})