import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';

export default function TrainingItem() {
    return (
        <View style={styles.container}>
            <View style={styles.content}>
                <View style={styles.topContent}>
                    <Text style={styles.hour}>15/02</Text>
                    <Text style={styles.hour}>13:00</Text>
                </View>
                <View style={styles.bottomContent}>
                    <Text
                        numberOfLines={1}
                        onPress={() => { }} // handle click and expand to see full text
                        style={styles.text}
                    >
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a nibh eu ipsum congue vehicula eu eu sem.
                    </Text>
                </View>
            </View>
            <View style={styles.iconContainer}>
                <Icon
                    // handle don't show icon for past date 
                    style={styles.icon}
                    name="trash"
                    size={18}
                    color="#17B978"
                    onPress={() => { }} />
            </View>
        </View>
    )
}

const styles = StyleSheet.create({
    container: {
        width: '100%',
        marginBottom: 16,
        height: 100,
        borderRadius: 5,
        borderWidth: 1,
        borderColor: '#17B978',
        backgroundColor: 'white',
        flexDirection: 'row',
        justifyContent: 'space-between'
    },
    content: {
        flexDirection: 'column'
    },
    topContent: {
        flexDirection: 'row'
    },
    bottomContent: {
        flex: 1,
        width: 250,
        marginLeft: 15
    },
    text: {
        color: '#17B978'
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