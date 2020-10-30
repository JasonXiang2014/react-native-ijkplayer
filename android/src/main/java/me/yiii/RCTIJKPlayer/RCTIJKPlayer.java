/**
 * Created by wangcong (king6cong@gmail.com) on 7/13/16.
 */

package me.yiii.RCTIJKPlayer;

public class RCTIJKPlayer {

    private static  RCTIJKPlayer ourInstance = new RCTIJKPlayer();
    private RCTIJKPlayerView mIJKPlayerView;


    public static RCTIJKPlayer getInstance() {
        if(ourInstance != null){
            return ourInstance ;
        }
        ourInstance = new RCTIJKPlayer();
        return  ourInstance ;
    }

    public static RCTIJKPlayerView getViewInstance() {

        if(ourInstance != null){
            return  ourInstance.mIJKPlayerView;
        }
        ourInstance = new RCTIJKPlayer();
        return  ourInstance.mIJKPlayerView;
    }

    public void setIJKPlayerView(RCTIJKPlayerView mIJKPlayerView) {
        this.mIJKPlayerView = mIJKPlayerView;
    }

    private RCTIJKPlayer() {
    }

}
