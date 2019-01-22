*Cordova plugin power save*
=========================================================
This plugins give you android PowerManager methods with cordova.

To use this plugin, be sure that your app is allowed to use this features in this link: https://developer.android.com/training/monitoring-device-state/doze-standby

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
