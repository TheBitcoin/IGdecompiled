package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

class a0 {

    /* renamed from: a  reason: collision with root package name */
    final SharedPreferences f11332a;

    static class a {

        /* renamed from: d  reason: collision with root package name */
        private static final long f11333d = TimeUnit.DAYS.toMillis(7);

        /* renamed from: a  reason: collision with root package name */
        final String f11334a;

        /* renamed from: b  reason: collision with root package name */
        final String f11335b;

        /* renamed from: c  reason: collision with root package name */
        final long f11336c;

        private a(String str, String str2, long j4) {
            this.f11334a = str;
            this.f11335b = str2;
            this.f11336c = j4;
        }

        static String a(String str, String str2, long j4) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, j4);
                return jSONObject.toString();
            } catch (JSONException e5) {
                Log.w("FirebaseMessaging", "Failed to encode token: " + e5);
                return null;
            }
        }

        static a c(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new a(str, (String) null, 0);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new a(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong(CampaignEx.JSON_KEY_TIMESTAMP));
            } catch (JSONException e5) {
                Log.w("FirebaseMessaging", "Failed to parse token: " + e5);
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(String str) {
            if (System.currentTimeMillis() > this.f11336c + f11333d || !str.equals(this.f11335b)) {
                return true;
            }
            return false;
        }
    }

    public a0(Context context) {
        this.f11332a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        a(context, "com.google.android.gms.appid-no-backup");
    }

    private void a(Context context, String str) {
        File file = new File(ContextCompat.getNoBackupFilesDir(context), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !e()) {
                    Log.i("FirebaseMessaging", "App restored, clearing state");
                    c();
                }
            } catch (IOException e5) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + e5.getMessage());
                }
            }
        }
    }

    private String b(String str, String str2) {
        return str + "|T|" + str2 + "|" + "*";
    }

    public synchronized void c() {
        this.f11332a.edit().clear().commit();
    }

    public synchronized a d(String str, String str2) {
        return a.c(this.f11332a.getString(b(str, str2), (String) null));
    }

    public synchronized boolean e() {
        return this.f11332a.getAll().isEmpty();
    }

    public synchronized void f(String str, String str2, String str3, String str4) {
        String a5 = a.a(str3, str4, System.currentTimeMillis());
        if (a5 != null) {
            SharedPreferences.Editor edit = this.f11332a.edit();
            edit.putString(b(str, str2), a5);
            edit.commit();
        }
    }
}
