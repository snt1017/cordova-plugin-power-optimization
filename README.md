# cordova-plugin-power-save

This plugins give you android PowerManager methods in cordova.


Example
Getting if the battery optimization is ignoring:

```javascript
var success = function (result) {
  alert(result);
}
var failure = function (result) {
  console.error(result);
}
cordova.plugins.PowerOptimization.IsIgnoringBatteryOptimizations({}, success, failure);
```
