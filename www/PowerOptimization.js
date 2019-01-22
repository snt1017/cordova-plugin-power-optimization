var exec = require('cordova/exec');

var MODULE = "PowerOptimization";

var execute = function (function_name, arg0) {
    return new Promise((resolve, reject) => {
        exec(resolve, reject, MODULE, function_name, [arg0]);
    });
}

exports.IsIgnoringBatteryOptimizations = function (arg0) {
    return execute('IsIgnoringBatteryOptimizations', arg0);
};

exports.RequestOptimizations = function (arg0) {
    return execute('RequestOptimizations', arg0);
};

exports.RequestOptimizationsMenu = function (arg0) {
    return execute('RequestOptimizationsMenu', arg0);    
};

exports.IsIgnoringDataSaver = function (arg0) {
    return execute('IsIgnoringDataSaver', arg0);
};

exports.RequestDataSaverMenu = function (arg0) {
    return execute('RequestDataSaverMenu', arg0);
};

exports.ProtectedAppCheck = function (arg0) {
    return execute('ProtectedAppCheck', arg0);
};