#import <UIKit/UIKit.h>
#import <AVFoundation/AVFoundation.h>
#import <IJKMediaFramework/IJKMediaFramework.h>
#import <React/RCTView.h>
/* @class IJKMediaControl; */

@class RCTIJKPlayerManager;

@interface RCTIJKPlayer : UIView

@property(atomic,strong) NSURL *url;
@property(atomic, retain) id<IJKMediaPlayback> player;
@property (nonatomic, copy) RCTBubblingEventBlock onPlaybackInfo;
@property (nonatomic, copy) RCTBubblingEventBlock onPlaybackStatu;

- (id)initWithManager:(RCTIJKPlayerManager*)manager bridge:(RCTBridge *)bridge;
- (void)startWithOptions:(NSDictionary *)options;
- (void)stop;
- (void)resume;
- (void)pause;
- (void)shutdown;
- (void)seekTo:(NSTimeInterval)currentPlaybackTime;
@end
