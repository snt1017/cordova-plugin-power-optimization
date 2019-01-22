package cordova.plugin.PowerOptimization;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import org.apache.cordova.CallbackContext;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class ProtectedApps {

    // This method checks if can fire the one of a list of intents and fire it
    public static void ProtectedAppCheck(Context context, CallbackContext callbackContext, boolean forceShow) throws JSONException {
        JSONObject result = new JSONObject();
        // Get preferences of the configuration
        SharedPreferences settings = context.getSharedPreferences("ProtectedApps", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = settings.edit();
        boolean skipMessage = settings.getBoolean("skipProtectedAppCheck", false);
        boolean foundCorrectIntent = false;
        if(!skipMessage || forceShow){
            Constants cons = new Constants(context);
            for (Intent intent : cons.getPowermanagerIntents()) {
                if (isCallable(context, intent)) {
                    foundCorrectIntent = true;
                    context.startActivity(intent);
                    break;
                }
            }
        }
        if (!foundCorrectIntent) {
            editor.putBoolean("skipProtectedAppCheck", true);
            editor.apply();
        }
        result.put("skip_message", skipMessage);
        result.put("found_intent", foundCorrectIntent);
        callbackContext.success(result);
    }

    // This method returns if can fire the one of a list of intents and fire it
    public static void HaveProtectedAppIntent(Context context, CallbackContext callbackContext) throws JSONException {
        String message = "false";
        Constants cons = new Constants(context);
        for (Intent intent : cons.getPowermanagerIntents()) {
            if (isCallable(context, intent)) {
                message = "true";
                break;
            }
        }
        callbackContext.success(message);
    }

    // Check if the intent is callable
    private static boolean isCallable(Context context, Intent intent) {
        List<ResolveInfo> list = context.getPackageManager().queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }
}