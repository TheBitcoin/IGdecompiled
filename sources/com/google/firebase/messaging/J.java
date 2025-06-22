package com.google.firebase.messaging;

import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

public class J {

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f11258a;

    public J(Bundle bundle) {
        if (bundle != null) {
            this.f11258a = new Bundle(bundle);
            return;
        }
        throw new NullPointerException(DataSchemeDataSource.SCHEME_DATA);
    }

    private static int d(String str) {
        int parseColor = Color.parseColor(str);
        if (parseColor != -16777216) {
            return parseColor;
        }
        throw new IllegalArgumentException("Transparent color is invalid");
    }

    private static boolean s(String str) {
        if (str.startsWith("google.c.a.") || str.equals(TypedValues.TransitionType.S_FROM)) {
            return true;
        }
        return false;
    }

    public static boolean t(Bundle bundle) {
        if ("1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString(v("gcm.n.e")))) {
            return true;
        }
        return false;
    }

    private static boolean u(String str) {
        if (str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
            return true;
        }
        return false;
    }

    private static String v(String str) {
        if (!str.startsWith("gcm.n.")) {
            return str;
        }
        return str.replace("gcm.n.", "gcm.notification.");
    }

    private String w(String str) {
        if (!this.f11258a.containsKey(str) && str.startsWith("gcm.n.")) {
            String v4 = v(str);
            if (this.f11258a.containsKey(v4)) {
                return v4;
            }
        }
        return str;
    }

    private static String z(String str) {
        if (str.startsWith("gcm.n.")) {
            return str.substring(6);
        }
        return str;
    }

    public boolean a(String str) {
        String p4 = p(str);
        if ("1".equals(p4) || Boolean.parseBoolean(p4)) {
            return true;
        }
        return false;
    }

    public Integer b(String str) {
        String p4 = p(str);
        if (TextUtils.isEmpty(p4)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(p4));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + z(str) + "(" + p4 + ") into an int");
            return null;
        }
    }

    public JSONArray c(String str) {
        String p4 = p(str);
        if (TextUtils.isEmpty(p4)) {
            return null;
        }
        try {
            return new JSONArray(p4);
        } catch (JSONException unused) {
            Log.w("NotificationParams", "Malformed JSON for key " + z(str) + ": " + p4 + ", falling back to default");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public int[] e() {
        JSONArray c5 = c("gcm.n.light_settings");
        if (c5 == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (c5.length() == 3) {
                iArr[0] = d(c5.optString(0));
                iArr[1] = c5.optInt(1);
                iArr[2] = c5.optInt(2);
                return iArr;
            }
            throw new JSONException("lightSettings don't have all three fields");
        } catch (JSONException unused) {
            Log.w("NotificationParams", "LightSettings is invalid: " + c5 + ". Skipping setting LightSettings");
            return null;
        } catch (IllegalArgumentException e5) {
            Log.w("NotificationParams", "LightSettings is invalid: " + c5 + ". " + e5.getMessage() + ". Skipping setting LightSettings");
            return null;
        }
    }

    public Uri f() {
        String p4 = p("gcm.n.link_android");
        if (TextUtils.isEmpty(p4)) {
            p4 = p("gcm.n.link");
        }
        if (!TextUtils.isEmpty(p4)) {
            return Uri.parse(p4);
        }
        return null;
    }

    public Object[] g(String str) {
        JSONArray c5 = c(str + "_loc_args");
        if (c5 == null) {
            return null;
        }
        int length = c5.length();
        String[] strArr = new String[length];
        for (int i4 = 0; i4 < length; i4++) {
            strArr[i4] = c5.optString(i4);
        }
        return strArr;
    }

    public String h(String str) {
        return p(str + "_loc_key");
    }

    public String i(Resources resources, String str, String str2) {
        String h4 = h(str2);
        if (TextUtils.isEmpty(h4)) {
            return null;
        }
        int identifier = resources.getIdentifier(h4, TypedValues.Custom.S_STRING, str);
        if (identifier == 0) {
            Log.w("NotificationParams", z(str2 + "_loc_key") + " resource not found: " + str2 + " Default value will be used.");
            return null;
        }
        Object[] g4 = g(str2);
        if (g4 == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, g4);
        } catch (MissingFormatArgumentException e5) {
            Log.w("NotificationParams", "Missing format argument for " + z(str2) + ": " + Arrays.toString(g4) + " Default value will be used.", e5);
            return null;
        }
    }

    public Long j(String str) {
        String p4 = p(str);
        if (TextUtils.isEmpty(p4)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(p4));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + z(str) + "(" + p4 + ") into a long");
            return null;
        }
    }

    public String k() {
        return p("gcm.n.android_channel_id");
    }

    /* access modifiers changed from: package-private */
    public Integer l() {
        Integer b5 = b("gcm.n.notification_count");
        if (b5 == null) {
            return null;
        }
        if (b5.intValue() >= 0) {
            return b5;
        }
        Log.w("FirebaseMessaging", "notificationCount is invalid: " + b5 + ". Skipping setting notificationCount.");
        return null;
    }

    /* access modifiers changed from: package-private */
    public Integer m() {
        Integer b5 = b("gcm.n.notification_priority");
        if (b5 == null) {
            return null;
        }
        if (b5.intValue() >= -2 && b5.intValue() <= 2) {
            return b5;
        }
        Log.w("FirebaseMessaging", "notificationPriority is invalid " + b5 + ". Skipping setting notificationPriority.");
        return null;
    }

    public String n(Resources resources, String str, String str2) {
        String p4 = p(str2);
        if (!TextUtils.isEmpty(p4)) {
            return p4;
        }
        return i(resources, str, str2);
    }

    public String o() {
        String p4 = p("gcm.n.sound2");
        if (TextUtils.isEmpty(p4)) {
            return p("gcm.n.sound");
        }
        return p4;
    }

    public String p(String str) {
        return this.f11258a.getString(w(str));
    }

    public long[] q() {
        JSONArray c5 = c("gcm.n.vibrate_timings");
        if (c5 == null) {
            return null;
        }
        try {
            if (c5.length() > 1) {
                int length = c5.length();
                long[] jArr = new long[length];
                for (int i4 = 0; i4 < length; i4++) {
                    jArr[i4] = c5.optLong(i4);
                }
                return jArr;
            }
            throw new JSONException("vibrateTimings have invalid length");
        } catch (NumberFormatException | JSONException unused) {
            Log.w("NotificationParams", "User defined vibrateTimings is invalid: " + c5 + ". Skipping setting vibrateTimings.");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Integer r() {
        Integer b5 = b("gcm.n.visibility");
        if (b5 == null) {
            return null;
        }
        if (b5.intValue() >= -1 && b5.intValue() <= 1) {
            return b5;
        }
        Log.w("NotificationParams", "visibility is invalid: " + b5 + ". Skipping setting visibility.");
        return null;
    }

    public Bundle x() {
        Bundle bundle = new Bundle(this.f11258a);
        for (String next : this.f11258a.keySet()) {
            if (!s(next)) {
                bundle.remove(next);
            }
        }
        return bundle;
    }

    public Bundle y() {
        Bundle bundle = new Bundle(this.f11258a);
        for (String next : this.f11258a.keySet()) {
            if (u(next)) {
                bundle.remove(next);
            }
        }
        return bundle;
    }
}
