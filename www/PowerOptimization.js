var exec = require('cordova/exec');

var MODULE = "PowerOptimization";

var execute = function (function_name, arg0) {
    return new Promise(function (resolve, reject) {
        console.debug("PowerOptimization:execute", { MODULE: MODULE, function_name: function_name, arg: [arg0] })
        exec(resolve, reject, MODULE, function_name, [arg0]);
    });
}

var execute_boolean = function (function_name, arg0) {
    return new Promise(function (resolve, reject) {
        var success = function (data) {
            if (data == "true") resolve(true);
            else resolve(false);
        }
        exec(success, reject, MODULE, function_name, [arg0]);
    });
}

exports.IsIgnoringBatteryOptimizations = function (arg0) {
    return execute_boolean('IsIgnoringBatteryOptimizations', arg0);
};

exports.RequestOptimizations = function (arg0) {
    return execute('RequestOptimizations', arg0);
};

exports.RequestOptimizationsMenu = function (arg0) {
    return execute('RequestOptimizationsMenu', arg0);
};

exports.IsIgnoringDataSaver = function (arg0) {
    return execute_boolean('IsIgnoringDataSaver', arg0);
};

exports.RequestDataSaverMenu = function (arg0) {
    return execute('RequestDataSaverMenu', arg0);
};

exports.HaveProtectedAppsCheck = function (arg0) {
    return execute('HaveProtectedAppsCheck', arg0);
};

exports.ProtectedAppCheck = function (arg0) {
    return execute('ProtectedAppCheck', arg0);
};