import React, { Component } from 'react';
import PropTypes from 'prop-types';
import {
    NativeAppEventEmitter,
    NativeModules,
    Platform,
    StyleSheet,
    requireNativeComponent,
    DeviceEventEmitter,
    View,
} from 'react-native';

const IJKPlayerManager = NativeModules.IJKPlayerManager || NativeModules.IJKPlayerModule;
const REF              = 'RCTIJKPlayer';
const ios              = Platform.OS === 'ios'

function convertNativeProps(props) {
    const newProps = {
        ...props
    };
    return newProps;
}

export default class RCTIJKPlayer extends Component {

    static PlayBackState = {
        IJKMPMoviePlaybackStateStopped        : 0,
        IJKMPMoviePlaybackStatePlaying        : 1,
        IJKMPMoviePlaybackStatePaused         : 2,
        IJKMPMoviePlaybackStateInterrupted    : 3,
        IJKMPMoviePlaybackStateSeekingForward : 4,
        IJKMPMoviePlaybackStateSeekingBackward: 5,
    }

    static constants = {
        PlayBackState: this.PlayBackState,
    };

    static propTypes = {
        ...View.propTypes,

    };

    static defaultProps = {
    };

    setNativeProps(props) {
        this.refs[REF].setNativeProps(props);
    }

    constructor() {
        super();
        this.state = {
            isAuthorized: false,
            isRecording : false
        };
    }

    componentWillUnmount() {
        this.stop();
        this.shutdown();
    }

    _playbackInfo(data) {
        for (var k in data) {
            if (data.hasOwnProperty(k)) {
                data[k] = +data[k];
            }

        }
        this.props.onPlayBackInfo && this.props.onPlayBackInfo(data)
    }
    
    _playbackStatu(data) {
        this.props.onPlayBackStatu && this.props.onPlayBackStatu(data)
    }
    
    render() {
        const style       = [styles.base, this.props.style];
        let   nativeProps = {
            ...this.props,
            onPlaybackInfo : (data) => { this._playbackInfo(data.nativeEvent) },
            onPlaybackStatu: (data) => { this._playbackStatu(data.nativeEvent) },
        }
        return <_RCTIJKPlayer ref={REF} {...nativeProps} />;
    }


    start(options) {
        this.setNativeProps({ start: options })
    }

    begin(options) {
        this.setNativeProps({ begin: options })
    }

    stop() {
        return this.setNativeProps({ stop: true })
    }
    
    unMount() {
        if (ios) {
            this.setNativeProps({ unMount: true })
        }
    }
    resume() {
        this.setNativeProps({ resume: true })
    }

    pause() {
        this.setNativeProps({ pause: true })
    }

    shutdown() {
        this.setNativeProps({ shutdown: true })
    }

    seekTo(currentPlaybackTime) {
        this.setNativeProps({ seekTo: currentPlaybackTime })
    }
}

export const constants = RCTIJKPlayer.constants;

RCTIJKPlayer.propTypes = {
    stop           : PropTypes.bool,
    resume         : PropTypes.bool,
    pause          : PropTypes.bool,
    unMount        : PropTypes.bool,
    shutdown       : PropTypes.bool,
    seekTo         : PropTypes.number,
    onPlaybackInfo : PropTypes.func,
    onPlaybackStatu: PropTypes.func,
    start          : PropTypes.object,
    begin          : PropTypes.object,
    ...View.propTypes,
};

const _RCTIJKPlayer = requireNativeComponent('RCTIJKPlayer', RCTIJKPlayer);

const styles = StyleSheet.create({
    base: {},
});
