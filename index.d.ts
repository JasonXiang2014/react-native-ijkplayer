import React from 'react'
import { ViewProps } from 'react-native';

export declare enum PlayBackState {
  IJKMPMoviePlaybackStateStopped = 0,
  IJKMPMoviePlaybackStatePlaying = 1,
  IJKMPMoviePlaybackStatePaused = 2,
  IJKMPMoviePlaybackStateInterrupted = 3,
  IJKMPMoviePlaybackStateSeekingForward = 4,
  IJKMPMoviePlaybackStateSeekingBackward = 5,
}

export declare enum AndroidPlayBackState {
  MEDIA_INFO_UNKNOWN = 1,
  MEDIA_INFO_STARTED_AS_NEXT = 2,
  MEDIA_INFO_VIDEO_RENDERING_START = 3,
  MEDIA_INFO_VIDEO_TRACK_LAGGING = 700,
  MEDIA_INFO_BUFFERING_START = 701,
  MEDIA_INFO_BUFFERING_END = 702,
  MEDIA_INFO_NETWORK_BANDWIDTH = 703,
  MEDIA_INFO_BAD_INTERLEAVING = 800,
  MEDIA_INFO_NOT_SEEKABLE = 801,
  MEDIA_INFO_METADATA_UPDATE = 802,
  MEDIA_INFO_TIMED_TEXT_ERROR = 900,
  MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901,
  MEDIA_INFO_SUBTITLE_TIMED_OUT = 902,
  MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001,
  MEDIA_INFO_AUDIO_RENDERING_START = 10002,
  MEDIA_INFO_AUDIO_DECODED_START = 10003,
  MEDIA_INFO_VIDEO_DECODED_START = 10004,
  MEDIA_INFO_OPEN_INPUT = 10005,
  MEDIA_INFO_FIND_STREAM_INFO = 10006,
  MEDIA_INFO_COMPONENT_OPEN = 10007,
  MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE = 10100,
  MEDIA_ERROR_UNKNOWN = 1,
  MEDIA_ERROR_SERVER_DIED = 100,
  MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200,
  MEDIA_ERROR_IO = -1004,
  MEDIA_ERROR_MALFORMED = -1007,
  MEDIA_ERROR_UNSUPPORTED = -1010,
  MEDIA_ERROR_TIMED_OUT = -110,
  MEDIA_PLAY_DONE = 200,
  MEDIA_ERROR = 404
}

export interface RCTIJKPlayerProperties extends ViewProps, React.ClassAttributes<RCTIJKPlayer> {
  
  onPlayBackInfo?(value: any): void

  onPlayBackStatu?(value: any): void  
}

export default class RCTIJKPlayer extends React.Component<RCTIJKPlayerProperties> {

  pause: () => void

  resume: () => void
  
  seekTo: (currentPlaybackTime: number) => void

  begin: (options: any) => void

  stop: () => void
  
  shutdown: () => void
}