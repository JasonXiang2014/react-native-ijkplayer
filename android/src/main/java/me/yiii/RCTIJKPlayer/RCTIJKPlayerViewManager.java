package me.yiii.RCTIJKPlayer;

import android.util.Log;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

import javax.annotation.Nullable;

public class RCTIJKPlayerViewManager extends SimpleViewManager<RCTIJKPlayerView> {
    private static final String REACT_CLASS = "RCTIJKPlayer";

    public RCTIJKPlayerViewManager(){
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public RCTIJKPlayerView createViewInstance(ThemedReactContext context) {
        return new RCTIJKPlayerView(context);
    }

    @Override
    public void onDropViewInstance(RCTIJKPlayerView view) {
        super.onDropViewInstance(view);
    }

    @Override
    @Nullable
    public Map getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        builder.put("onPlaybackInfo", MapBuilder.of("registrationName", "onPlaybackInfo"));
        builder.put("onPlaybackStatu", MapBuilder.of("registrationName", "onPlaybackStatu"));
        return builder.build();
    }

    @ReactProp(name = "start")
    public void setStart(final RCTIJKPlayerView videoView, final ReadableMap options) {
        final String URL = options.getString("url");
        final int  duration = options.getInt("seek");
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                videoView.start(URL,duration,videoView.getId());
            }
        });
    }

    // 延深添加
    @ReactProp(name = "begin")
    public void setBegin(final RCTIJKPlayerView videoView, final ReadableMap options) {
        setStart(videoView, options);
    }

    @ReactProp(name = "stop", defaultBoolean = false)
    public void setStop(final RCTIJKPlayerView videoView, final boolean stop) {
        videoView.stop();
    }

    @ReactProp(name = "pause", defaultBoolean = false)
    public void setPause(final RCTIJKPlayerView videoView, final boolean pause) {
        videoView.pause();
    }

    @ReactProp(name = "resume", defaultBoolean = false)
    public void setResume(final RCTIJKPlayerView videoView, final boolean resume) {
        videoView.resume();
    }

    @ReactProp(name = "shutdown", defaultBoolean = false)
    public void setShutdown(final RCTIJKPlayerView videoView, final boolean shutdown) {
        videoView.shutdown();
    }

    @ReactProp(name = "seekTo", defaultDouble = 0.0)
    public void setShutdown(final RCTIJKPlayerView videoView, final double currentPlaybackTime) {
        videoView.seekTo(currentPlaybackTime);
    }



}
