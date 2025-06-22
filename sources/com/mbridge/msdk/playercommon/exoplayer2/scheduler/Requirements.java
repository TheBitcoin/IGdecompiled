package com.mbridge.msdk.playercommon.exoplayer2.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Requirements {
    private static final int DEVICE_CHARGING = 16;
    private static final int DEVICE_IDLE = 8;
    public static final int NETWORK_TYPE_ANY = 1;
    private static final int NETWORK_TYPE_MASK = 7;
    public static final int NETWORK_TYPE_METERED = 4;
    public static final int NETWORK_TYPE_NONE = 0;
    public static final int NETWORK_TYPE_NOT_ROAMING = 3;
    private static final String[] NETWORK_TYPE_STRINGS = null;
    public static final int NETWORK_TYPE_UNMETERED = 2;
    private static final String TAG = "Requirements";
    private final int requirements;

    @Retention(RetentionPolicy.SOURCE)
    public @interface NetworkType {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Requirements(int i4, boolean z4, boolean z5) {
        this(i4 | (z4 ? 16 : 0) | (z5 ? 8 : 0));
    }

    private boolean checkChargingRequirement(Context context) {
        if (!isChargingRequired()) {
            return true;
        }
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        if (intExtra == 2 || intExtra == 5) {
            return true;
        }
        return false;
    }

    private boolean checkIdleRequirement(Context context) {
        if (!isIdleRequired()) {
            return true;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        int i4 = Util.SDK_INT;
        if (i4 >= 23) {
            if (!powerManager.isDeviceIdleMode()) {
                return true;
            }
            return false;
        } else if (i4 >= 20) {
            if (!powerManager.isInteractive()) {
                return true;
            }
            return false;
        } else if (!powerManager.isScreenOn()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean checkInternetConnectivity(ConnectivityManager connectivityManager) {
        if (Util.SDK_INT < 23) {
            return true;
        }
        Network a5 = connectivityManager.getActiveNetwork();
        boolean z4 = false;
        if (a5 == null) {
            logd("No active network.");
            return false;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(a5);
        if (networkCapabilities == null || !networkCapabilities.hasCapability(16)) {
            z4 = true;
        }
        logd("Network capability validated: " + z4);
        return !z4;
    }

    private boolean checkNetworkRequirements(Context context) {
        int requiredNetworkType = getRequiredNetworkType();
        if (requiredNetworkType == 0) {
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            logd("No network info or no connection.");
            return false;
        } else if (!checkInternetConnectivity(connectivityManager)) {
            return false;
        } else {
            if (requiredNetworkType == 1) {
                return true;
            }
            if (requiredNetworkType == 3) {
                boolean isRoaming = activeNetworkInfo.isRoaming();
                logd("Roaming: " + isRoaming);
                return !isRoaming;
            }
            boolean isActiveNetworkMetered = isActiveNetworkMetered(connectivityManager, activeNetworkInfo);
            logd("Metered network: " + isActiveNetworkMetered);
            if (requiredNetworkType == 2) {
                return !isActiveNetworkMetered;
            }
            if (requiredNetworkType == 4) {
                return isActiveNetworkMetered;
            }
            throw new IllegalStateException();
        }
    }

    private static boolean isActiveNetworkMetered(ConnectivityManager connectivityManager, NetworkInfo networkInfo) {
        if (Util.SDK_INT >= 16) {
            return connectivityManager.isActiveNetworkMetered();
        }
        int type = networkInfo.getType();
        if (type == 1 || type == 7 || type == 9) {
            return false;
        }
        return true;
    }

    private static void logd(String str) {
    }

    public final boolean checkRequirements(Context context) {
        if (!checkNetworkRequirements(context) || !checkChargingRequirement(context) || !checkIdleRequirement(context)) {
            return false;
        }
        return true;
    }

    public final int getRequiredNetworkType() {
        return this.requirements & 7;
    }

    public final int getRequirementsData() {
        return this.requirements;
    }

    public final boolean isChargingRequired() {
        if ((this.requirements & 16) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isIdleRequired() {
        if ((this.requirements & 8) != 0) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return super.toString();
    }

    public Requirements(int i4) {
        this.requirements = i4;
    }
}
