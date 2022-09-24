package cordova.plugin.PowerOptimization;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

public class Constants {

    private Context context;

    // MIUI
    private static final String MIUI_ACTION_POWER_SAVE_EXTRA_NAME = "package_name";
    private static final String MIUI_ACTION_POWER_SAVE_EXTRA_LABEL = "package_label";
    private static final String[] MIUI_ACTION_POWERSAVE = {"com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity"};

    // SAMSUNG crash "com.samsung.android.lool","com.samsung.android.sm.ui.battery.AppSleepListActivity"
    private static final String SAMSUNG_SYSTEMMANAGER_POWERSAVING_ACTION = "com.samsung.android.sm.ACTION_BATTERY";
    private static final String SAMSUNG_SYSTEMMANAGER_NOTIFICATION_ACTION = "com.samsung.android.sm.ACTION_SM_NOTIFICATION_SETTING";
    // SAMSUNG ANDROID 7.0
    private static final String SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V3 = "com.samsung.android.lool";
    private static final String SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V3_ACTIVITY = "com.samsung.android.sm.ui.battery.BatteryActivity";

    // SAMSUNG ANDROID 6.0
    private static final String SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V2 = "com.samsung.android.sm_cn";
    private static final String SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V2_ACTIVITY = "com.samsung.android.sm.ui.battery.BatteryActivity";

    // SAMSUNG ANDROID 5.0/5.1
    private static final String SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V1 = "com.samsung.android.sm";
    private static final String SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V1_ACTIVITY = "com.samsung.android.sm.ui.battery.BatteryActivity";

    // HUAWEI
    private static final String HUAWEI_ACTION_POWERSAVING = "huawei.intent.action.HSM_PROTECTED_APPS";
    private static final String HUAWEI_COMPONENT_POWERSAVING_PKG = "com.huawei.systemmanager";
    private static final String HUAWEI_COMPONENT_POWERSAVING_CLS = "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity";

    // LETV
    private static final String LETV_ACTION_POWERSAVING_PKG = "com.letv.android.letvsafe";
    private static final String LETV_ACTION_POWERSAVING_CLS = "com.letv.android.letvsafe.BackgroundAppManageActivity";

    // MEIZU

    private static final String MEIZU_POWERSAVING_ACTION = "com.meizu.power.PowerAppKilledNotification";
    private static final String MEIZU_DEFAULT_PACKAGE = "com.meizu.safe";
    private static final String MEIZU_POWERSAVING_ACTIVITY_V2_2 = "com.meizu.safe.cleaner.RubbishCleanMainActivity";
    private static final String MEIZU_POWERSAVING_ACTIVITY_V3_4 = "com.meizu.safe.powerui.AppPowerManagerActivity";
    private static final String MEIZU_POWERSAVING_ACTIVITY_V3_7 = "com.meizu.safe.powerui.PowerAppPermissionActivity";

    public List<Intent> powerManagerIntents;

    public Constants(Context context){
        this.context = context;
        populateList();
    }


    private void populateList(){

        // Xiaomi intents
        Intent xiomi_1 = new Intent();
        xiomi_1.setComponent(new ComponentName(MIUI_ACTION_POWERSAVE[0], MIUI_ACTION_POWERSAVE[1]));
        xiomi_1.putExtra(MIUI_ACTION_POWER_SAVE_EXTRA_NAME, context.getPackageName());
        xiomi_1.putExtra(MIUI_ACTION_POWER_SAVE_EXTRA_LABEL, getApplicationName());

        // Samsung intents
        Intent samsung_1 = new Intent();
        samsung_1.setAction(SAMSUNG_SYSTEMMANAGER_POWERSAVING_ACTION);
        samsung_1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Intent samsung_2 = new Intent();
        samsung_2.setComponent(new ComponentName(SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V3, SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V3_ACTIVITY));
        samsung_2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Intent samsung_3 = new Intent();
        samsung_3.setComponent(new ComponentName(SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V2, SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V2_ACTIVITY));
        samsung_3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Intent samsung_4 = new Intent();
        samsung_4.setComponent(new ComponentName(SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V1, SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V1_ACTIVITY));
        samsung_4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Huawei
        Intent huawei_1 = new Intent();
        huawei_1.setAction(HUAWEI_ACTION_POWERSAVING);
        Intent huawei_2 = new Intent();
        huawei_2.setComponent(new ComponentName(HUAWEI_COMPONENT_POWERSAVING_PKG, HUAWEI_COMPONENT_POWERSAVING_CLS));

        // LeTV
        // TODO Test it
        Intent letv_1 = new Intent();
        huawei_1.setComponent(new ComponentName(LETV_ACTION_POWERSAVING_PKG, LETV_ACTION_POWERSAVING_CLS));

        // Meizu
        // TODO Test it
        Intent meizu_1 = new Intent();
        meizu_1.setAction(MEIZU_POWERSAVING_ACTION);
        Intent meizu_2 = new Intent();
        meizu_2.setClassName(MEIZU_DEFAULT_PACKAGE, MEIZU_POWERSAVING_ACTIVITY_V2_2);
        Intent meizu_3 = new Intent();
        meizu_3.setClassName(MEIZU_DEFAULT_PACKAGE, MEIZU_POWERSAVING_ACTIVITY_V3_4);
        Intent meizu_4 = new Intent();
        meizu_4.setClassName(MEIZU_DEFAULT_PACKAGE, MEIZU_POWERSAVING_ACTIVITY_V3_7);

        // TODO ASUS, OPPO, Elephone, Sony STAMINA, Huawei Phone manager (EMUI 5)

        powerManagerIntents = Arrays.asList(
                xiomi_1,
                samsung_1,
                samsung_2,
                samsung_3,
                samsung_4,
                huawei_1,
                huawei_2,
                letv_1,
                meizu_1,
                meizu_2,
                meizu_3,
                meizu_4
        );
    }

    public List<Intent> getPowermanagerIntents(){
        return powerManagerIntents;
    }


    public String getApplicationName() {
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
        } catch (final PackageManager.NameNotFoundException e) {
        }
        return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "Unknown");
    }

}