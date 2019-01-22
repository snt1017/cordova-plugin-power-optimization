[![Apache 2.0 License](https://img.shields.io/badge/license-Apache%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0.html)

*Cordova plugin power save*
=========================================================
This plugins give you android PowerManager methods with cordova.

To use this plugin, be sure that your app is allowed to use this features in this link: https://developer.android.com/training/monitoring-device-state/doze-standby

Android Custom Roms made sometimes your apps unfunctional due to:
* Your App is killed when it's not in foreground
* Notification message do not appear
* Your services is killed by agressive power saving mode

### Please if you have a Samsung, Meizu, Letv test this plugin to help me, thanks!

## Current protected apps supported devices:

* Huawei (<span style="color:green">TESTED</span>)
* Xiaomi (<span style="color:green">TESTED</span>)
* Samsung (<span style="color:red">NOT TESTED</span>)
* Meizu (<span style="color:red"> NOT TESTED</span>)
* Letv (<span style="color:red">NOT TESTED</span>)

# Instalation

```bash
cordova plugin add https://github.com/snt1017/cordova-plugin-power-optimization.git
```


# Usage

Check if the battery optimization is ignoring:

```javascript
cordova.plugins.PowerOptimization.IsIgnoringBatteryOptimizations().then((result)=> {
  console.log(result);
}, (result) => {
  console.error(result);
});
```

Request permisson to ignore optimizations:

```javascript
cordova.plugins.PowerOptimization.RequestOptimizations().then((result) => {
  console.log('ok');
}, (result) => {
  console.error(result);
});
```

Go to battery optimizations configurations menu:

```javascript
cordova.plugins.PowerOptimization.RequestOptimizationsMenu().then((result) => {
  console.log('ok');
}, (result) => {
  console.error(result);
});
```

Check if have any data restrictions in background:

```javascript
cordova.plugins.PowerOptimization.IsIgnoringDataSaver().then((result) => {
  console.log(result);
}, (result) => {
  console.error(result);
});
```

Go to data restrictions in background configurations menu:

```javascript
cordova.plugins.PowerOptimization.RequestDataSaverMenu().then((result) => {
  console.log('ok');
}, (result) => {
  console.error(result);
});
```

Check if have another battery restriction is present into phone (like huawei, xiaomi, etc):

```javascript
cordova.plugins.PowerOptimization.HaveProtectedAppsCheck().then((result) => {
  console.log(result);
}, (result) => {
  console.error(result);
});
```

Go to configurations menu if another battery restriction is present into phone (like huawei, xiaomi, etc). You can send true into params if you want to force show the menu (is only show the fist time without params):

```javascript
cordova.plugins.PowerOptimization.ProtectedAppCheck().then((result) => {
  console.log('ok');
}, (result) => {
  console.error(result);
});
```
# Notes
Be sure that your AndroidManifest.xml contains this permission 
``` xml
<uses-permission android:name="android.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS" />
```

## Based in this repo:

[AppKillerManager](https://github.com/thelittlefireman/AppKillerManager)

## Help liks:
[backgroundable-android](https://github.com/dirkam/backgroundable-android)

[Network access in doze mode](https://stackoverflow.com/questions/32316491/network-access-in-doze-mode/32424117#32424117)

[REQUEST_IGNORE_BATTERY_OPTIMIZATIONS how to do it right](https://stackoverflow.com/questions/44862176/request-ignore-battery-optimizations-how-to-do-it-right)

[Android PowerManager](https://developer.android.com/reference/android/os/PowerManager)