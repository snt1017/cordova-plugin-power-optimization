package cordova.plugin.PowerOptimization;

import android.content.ComponentName;
import android.content.Intent;
import java.util.Arrays;
import java.util.List;

public class Constants {

public static List<Intent> POWERMANAGER_INTENTS = Arrays.asList(
        // Xiaomi Battery usage monitoring and Power settings
        new Intent().setComponent(new ComponentName("com.miui.securitycenter", "com.miui.powercenter.PowerSettings")),
        // Samsung Unmonitored Apps (7.0+)
        new Intent().setComponent(new ComponentName("com.samsung.android.lool","com.samsung.android.sm.ui.battery.BatteryActivity")),
        // Huawei Protected Apps (EMUI < 5)
        new Intent().setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"))
        // TODO ASUS, OPPO, Elephone, Sony STAMINA, Huawei Phone manager (EMUI 5)
);
}