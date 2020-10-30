/**
 * Created by wangcong (king6cong@gmail.com) on 7/13/16.
 */

package me.yiii.RCTIJKPlayer;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.SurfaceView;
import android.widget.FrameLayout;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import java.util.Timer;
import java.util.TimerTask;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class RCTIJKPlayerView extends FrameLayout {
    private static final String TAG = "RCTIJKPlayerView";
    private final Context _context;
    private SurfaceView mPreviewView;
    private Activity activity = null;
    private FrameLayout framelayout;
    private IjkVideoView mIJKPlayerView;
    private int _eventID;
    private RCTEventEmitter mEventEmitter;
    private Timer _timer;
    private TimerTask _task;

    //private RCTEventEmitter mEventEmitter;
    public IjkVideoView getPlayer() {
        return this.mIJKPlayerView;
    }

    public RCTIJKPlayerView(ThemedReactContext context) {
        super(context);
        this._context = context;
        _eventID = getId();
        _timer = new Timer();
        _task = getTask();
        mEventEmitter = context.getJSModule(RCTEventEmitter.class);
        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        if (mIJKPlayerView != null) {
            return;
        }

        mIJKPlayerView = new IjkVideoView(this._context);
        mIJKPlayerView.setProgressListener(new VideoProgressListener() {
            @Override
            public void onStatusChanged(int status) {
                WritableMap event = Arguments.createMap();
                event.putString("state", Integer.toString(status));
                mEventEmitter.receiveEvent(_eventID, "onPlaybackStatu", event);
            }
        });
        addView(mIJKPlayerView);
    }

    public void refresh() {
        Log.e(TAG, "view refresh");
        this.postInvalidate();
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                requestLayout();
            }
        });

    }

    private void sendEvent(int state) {
        Log.e(TAG, "sendEvent");
        ReactContext reactContext = (ReactContext) getContext();
        WritableMap params = Arguments.createMap();
        params.putString("state", Integer.toString(state));
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("PlayBackState", params);

    }

    // 延深添加
    public void begin(final String URL, final int duration,final int eventID) {
        start(URL, duration, eventID);
    }

    public void start(final String URL, final int duration,final int eventID) {
        Log.e(TAG, String.format("start URL %s", URL));
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                _eventID = eventID;
                mIJKPlayerView.setVideoPath(URL,duration);
                mIJKPlayerView.start();
                // RCTIJKPlayerView.this.invalidate();
                // requestLayout()
                 _task = getTask();
                if(_timer == null){
                    _timer = new Timer();
                }
                _timer.schedule(_task,0,1000);
            }
        });
    }

   private TimerTask getTask() {
       TimerTask  task =  new TimerTask() {
            @Override
            public void run() {
                int currentPlaybackTime = mIJKPlayerView.getCurrentPosition() / 1000;
                int duration = mIJKPlayerView.getDuration() / 1000;
                int bufferingProgress = mIJKPlayerView.getBufferPercentage();
                int playbackState = mIJKPlayerView.CurrentState();

                //ReactContext reactContext = (ReactContext) getContext();
                WritableMap event = Arguments.createMap();
                event.putString("currentPlaybackTime", Integer.toString(currentPlaybackTime));
                event.putString("duration", Integer.toString(duration));
                event.putString("playableDuration", "");
                event.putString("bufferingProgress", Integer.toString(bufferingProgress));
                event.putString("playbackState", Integer.toString(playbackState));
                event.putString("loadState", "");
                event.putString("isPreparedToPlay", "");

                mEventEmitter.receiveEvent(_eventID, "onPlaybackInfo", event);
            }
        };
       return task;
    }

    public void stop() {
        Log.e(TAG, String.format("stop"));
        mIJKPlayerView.stopPlayback();
    }

    public void pause() {
        Log.e(TAG, String.format("pause"));
        mIJKPlayerView.pause();
    }

    public void resume() {
        Log.e(TAG, String.format("resume"));
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                mIJKPlayerView.resume();
            }
        });

    }

    public void shutdown() {
        Log.e(TAG, String.format("shutdown"));
        mIJKPlayerView.release(true);

        if(_timer != null && _task != null){
            _task.cancel();
        }
    }

    public void seekTo(double currentPlaybackTime) {
        int position = (int)(currentPlaybackTime * 1000);
        Log.e(TAG, "seekTo "+ currentPlaybackTime + ", " + position);
        mIJKPlayerView.seekTo(position);
    }
}
