/**
 * Created by wangcong (king6cong@gmail.com) on 7/13/16.
 */

package me.yiii.RCTIJKPlayer;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class RCTIJKPlayerModule extends ReactContextBaseJavaModule  {
    private static final String TAG = "RCTIJKPlayerModule";

    public static int videoWidth = 0;
    public static int videoHeight = 0;

    private final ReactApplicationContext _reactContext;
    public RCTIJKPlayerModule(ReactApplicationContext reactContext) {
        super(reactContext);
        _reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RCTIJKPlayerModule";
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(new HashMap<String, Object>() {
            {
            }
        });
    }

    @ReactMethod
    public void resetVideoSize(int w, int h, Promise promise) {
        videoWidth = w;
        videoHeight = h;
        promise.resolve(true);
    }

//    @ReactMethod
//    public void start(final ReadableMap options, final Promise promise) {
//        final String URL = options.getString("url");
//        final int  duration = options.getInt("seek");
//        UiThreadUtil.runOnUiThread(new Runnable() {
//            public void run() {
//                Log.e(TAG, "****start URL: " + URL);
//                RCTIJKPlayerView view = RCTIJKPlayer.getViewInstance();
//                view.setProgressListener(RCTIJKPlayerModule.this);
//                view.start(URL,duration);
//            }
//        });
//    }
//
//    @ReactProp(name = "start")
//    public void setStart(final RCTIJKPlayerView videoView, final ReadableMap options) {
//        final String URL = options.getString("url");
//        final int  duration = options.getInt("seek");
//        UiThreadUtil.runOnUiThread(new Runnable() {
//            public void run() {
//                Log.e(TAG, "****start URL: " + URL);
//                RCTIJKPlayerView view = RCTIJKPlayer.getViewInstance();
//                videoView.setProgressListener(RCTIJKPlayerModule.this);
//                videoView.start(URL,duration);
//            }
//        });
//
//    }
//
//
//    @ReactProp(name = "stop", defaultBoolean = false)
//    public void setStop(final RCTIJKPlayerView videoView, final boolean stop) {
//        videoView.stop();
//    }
//
//    @ReactProp(name = "pause", defaultBoolean = false)
//    public void setPause(final RCTIJKPlayerView videoView, final boolean pause) {
//        videoView.pause();
//    }
//
//    @ReactProp(name = "resume", defaultBoolean = false)
//    public void setResume(final RCTIJKPlayerView videoView, final boolean resume) {
//        videoView.resume();
//    }
//
//    @ReactProp(name = "shutdown", defaultBoolean = false)
//    public void setShutdown(final RCTIJKPlayerView videoView, final boolean shutdown) {
//        videoView.shutdown();
//    }
//
//    @ReactProp(name = "seekTo", defaultDouble = 0.0)
//    public void setShutdown(final RCTIJKPlayerView videoView, final double currentPlaybackTime) {
//        videoView.seekTo(currentPlaybackTime);
//    }

//    @ReactMethod
//    public void stop() {
//        Log.e(TAG, "stop");
//        RCTIJKPlayer.getViewInstance().stop();
//    }

//    @ReactMethod
//    public void pause() {
//        Log.e(TAG, "pause");
//        RCTIJKPlayer.getViewInstance().pause();
//    }

//    @ReactMethod
//    public void resume() {
//        Log.e(TAG, "resume");
//        RCTIJKPlayer.getViewInstance().resume();
//    }

//    @ReactMethod
//    public void shutdown() {
//        Log.e(TAG, "shutdown");
//        RCTIJKPlayer.getViewInstance().shutdown();
//    }

//    @ReactMethod
//    public void seekTo(double currentPlaybackTime) {
//        Log.e(TAG, "seekTo "+ currentPlaybackTime);
//        RCTIJKPlayer.getViewInstance().seekTo(currentPlaybackTime);
//    }

//    @ReactMethod
//    public void playbackInfo(final Promise promise) {
//        IjkVideoView player = RCTIJKPlayer.getViewInstance().getPlayer();
//        WritableMap data = new WritableNativeMap();
//        int currentPlaybackTime = player.getCurrentPosition() / 1000;
//        int duration = player.getDuration() / 1000;
//        int bufferingProgress = player.getBufferPercentage();
//        int playbackState = player.CurrentState();
//
//        data.putString("currentPlaybackTime", Integer.toString(currentPlaybackTime));
//        data.putString("duration", Integer.toString(duration));
//        data.putString("playableDuration", "");
//        data.putString("bufferingProgress", Integer.toString(bufferingProgress));
//        data.putString("playbackState", Integer.toString(playbackState));
//        data.putString("loadState", "");
//        data.putString("isPreparedToPlay", "");
//        promise.resolve(data);
//    }


//    @Override
//    public void onStatusChanged(int status) {
//        getReactApplicationContext()
//                            .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
//                            .emit("PlayBackState",status);
//    }
}
