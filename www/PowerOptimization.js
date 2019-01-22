var exec = require('cordova/exec');

var MODULE = "PowerOptimization";

exports.IsIgnoringBatteryOptimizations = function (arg0, success, error) {
    exec(success, error, MODULE, 'IsIgnoringBatteryOptimizations', [arg0]);
};

exports.RequestOptimizations = function (arg0, success, error) {
    exec(success, error, MODULE, 'RequestOptimizations', [arg0]);
};

exports.RequestOptimizationsMenu = function (arg0, success, error) {
    exec(success, error, MODULE, 'RequestOptimizationsMenu', [arg0]);
};

exports.IsIgnoringDataSaver = function (arg0, success, error) {
    exec(success, error, MODULE, 'IsIgnoringDataSaver', [arg0]);
};

exports.IsIgnoringDataSaver = function (arg0, success, error) {
    exec(success, error, MODULE, 'IsIgnoringDataSaver', [arg0]);
};

exports.RequestDataSaverMenu = function (arg0, success, error) {
    exec(success, error, MODULE, 'RequestDataSaverMenu', [arg0]);
};

exports.ProtectedAppCheck = function (arg0, success, error) {
    exec(success, error, MODULE, 'ProtectedAppCheck', [arg0]);
};