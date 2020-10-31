# React Native Component for ijkplayer


Install

```sh
npm install @newbanker/react-native-ijkplayer --save
```

### iOS

iOS build need IJKMediaFramework.framework first,
which can be build following instructions on https://github.com/Bilibili/ijkplayer,
and generate IJKMediaFramework.framework

```
cd /Users/cong/Library/Developer/Xcode/DerivedData/IJKMediaDemo-ffgcszbckhcejffronccjzcppdbz/Build/Products/
lipo -create Release-iphoneos/IJKMediaFramework.framework/IJKMediaFramework Release-iphonesimulator/IJKMediaFramework.framework/IJKMediaFramework -output IJKMediaFramework
cp IJKMediaFramework Release-iphoneos/IJKMediaFramework.framework/
cp -R Release-iphoneos/IJKMediaFramework.framework react-native-ijkplayer/ios/
```

After IJKMediaFramework.framework placed under react-native-ijkplayer/ios/ , Example is ready to build.
```
cd react-native-ijkplayer/Example/ios
open Example.xcodeproj
```

### Android

ijk dependencies is satisfied using gradle for Android

```
cd react-native-ijkplayer/Example/android
./gradlew installDebug
```
