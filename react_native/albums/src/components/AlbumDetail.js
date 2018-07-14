import React from 'react';
import { Text, View, Image } from 'react-native';
import Card from './Card';
import CardSection from './CardSection';

const AlbumDetail = ({ album }) => {
    const { title, artist, thumbnail_image, image } = album;
    const { thumbnailStyle, thumbnailContianerStyle, headerContentStyle, imageStyle } = styles;
    return (   
        <Card>
            <CardSection >
                <View style={thumbnailContianerStyle}>
                    <Image 
                        style={thumbnailStyle}
                        source={{ uri: thumbnail_image }}
                    />
                </View>
                <View style={headerContentStyle}>
                    <Text style={styles.textStyle}>{title}</Text>
                    <Text>{artist}</Text>
                </View>
            </CardSection>
            <CardSection>
                <Image
                    style={imageStyle} 
                    source={{ uri: image }} 
                />
            </CardSection>
        </Card>
    );
};

const styles = {
    
    headerContentStyle: {
        flexDirection: 'column',
        justifyContent: 'space-around',

    },

    thumbnailStyle: {
        height: 50,
        width: 50,
    },

    thumbnailContianerStyle: {
        justifyContent: 'center',
        alignItems: 'center',
        marginLeft: 10,
        marginRight: 10,
    },
    
    imageStyle: {
        height: 300,
        flex: 1,
        width: null,
    },

    textStyle: {
        fontSize: 18,
        // color: '#fff',
    },

};


export default AlbumDetail;
