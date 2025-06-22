package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;

public final class e implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private String f12825a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f12826b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f12827c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f12828d = "";

    /* renamed from: e  reason: collision with root package name */
    private int f12829e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12830f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12831g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12832h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f12833i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f12834j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f12835k;

    /* renamed from: l  reason: collision with root package name */
    private a f12836l;

    /* renamed from: m  reason: collision with root package name */
    private final SharedPreferences f12837m;

    public interface a {
        void a();
    }

    public e(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        this.f12837m = defaultSharedPreferences;
        if (defaultSharedPreferences != null) {
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
        if (defaultSharedPreferences != null) {
            this.f12825a = defaultSharedPreferences.getString("IABTCF_TCString", "");
            this.f12829e = defaultSharedPreferences.getInt("IABTCF_gdprApplies", 0);
            a(defaultSharedPreferences.getString("IABTCF_PurposeConsents", ""));
            b(defaultSharedPreferences.getString("IABTCF_VendorConsents", ""));
            c(defaultSharedPreferences.getString("IABTCF_AddtlConsent", ""));
        }
    }

    private void b(String str) {
        this.f12833i = a(str, 867);
        this.f12827c = str;
    }

    private void c(String str) {
        this.f12828d = str;
        if (TextUtils.isEmpty(str)) {
            this.f12834j = true;
        } else if (MBridgeConstans.GOOGLE_ATP_ID == -1) {
            this.f12835k = false;
        } else {
            this.f12835k = true;
            try {
                String[] split = str.split("~");
                if (split.length <= 1) {
                    return;
                }
                if (TextUtils.isEmpty(split[1])) {
                    this.f12834j = false;
                } else {
                    this.f12834j = str.contains(String.valueOf(MBridgeConstans.GOOGLE_ATP_ID));
                }
            } catch (Throwable th) {
                af.b("TCStringManager", th.getMessage());
            }
        }
    }

    private boolean d(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.matches("[01]+");
        }
        return false;
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.f12836l = aVar;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSharedPreferenceChanged(android.content.SharedPreferences r12, java.lang.String r13) {
        /*
            r11 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x008b
            int r0 = r13.hashCode()     // Catch:{ all -> 0x0025 }
            r1 = 2
            java.lang.String r2 = "IABTCF_PurposeConsents"
            r3 = 1
            java.lang.String r4 = "IABTCF_gdprApplies"
            r5 = 0
            java.lang.String r6 = "IABTCF_TCString"
            r7 = 4
            java.lang.String r8 = "IABTCF_AddtlConsent"
            r9 = 3
            java.lang.String r10 = "IABTCF_VendorConsents"
            switch(r0) {
                case -2004976699: goto L_0x003f;
                case 83641339: goto L_0x0037;
                case 1218895378: goto L_0x002f;
                case 1342914771: goto L_0x0027;
                case 1450203731: goto L_0x001d;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0047
        L_0x001d:
            boolean r13 = r13.equals(r10)     // Catch:{ all -> 0x0025 }
            if (r13 == 0) goto L_0x0047
            r13 = 3
            goto L_0x0048
        L_0x0025:
            r12 = move-exception
            goto L_0x0082
        L_0x0027:
            boolean r13 = r13.equals(r8)     // Catch:{ all -> 0x0025 }
            if (r13 == 0) goto L_0x0047
            r13 = 4
            goto L_0x0048
        L_0x002f:
            boolean r13 = r13.equals(r6)     // Catch:{ all -> 0x0025 }
            if (r13 == 0) goto L_0x0047
            r13 = 0
            goto L_0x0048
        L_0x0037:
            boolean r13 = r13.equals(r4)     // Catch:{ all -> 0x0025 }
            if (r13 == 0) goto L_0x0047
            r13 = 1
            goto L_0x0048
        L_0x003f:
            boolean r13 = r13.equals(r2)     // Catch:{ all -> 0x0025 }
            if (r13 == 0) goto L_0x0047
            r13 = 2
            goto L_0x0048
        L_0x0047:
            r13 = -1
        L_0x0048:
            java.lang.String r0 = ""
            if (r13 == 0) goto L_0x0074
            if (r13 == r3) goto L_0x006d
            if (r13 == r1) goto L_0x0065
            if (r13 == r9) goto L_0x005d
            if (r13 == r7) goto L_0x0055
            goto L_0x007a
        L_0x0055:
            java.lang.String r12 = r12.getString(r8, r0)     // Catch:{ all -> 0x0025 }
            r11.c(r12)     // Catch:{ all -> 0x0025 }
            goto L_0x007a
        L_0x005d:
            java.lang.String r12 = r12.getString(r10, r0)     // Catch:{ all -> 0x0025 }
            r11.b(r12)     // Catch:{ all -> 0x0025 }
            goto L_0x007a
        L_0x0065:
            java.lang.String r12 = r12.getString(r2, r0)     // Catch:{ all -> 0x0025 }
            r11.a((java.lang.String) r12)     // Catch:{ all -> 0x0025 }
            goto L_0x007a
        L_0x006d:
            int r12 = r12.getInt(r4, r5)     // Catch:{ all -> 0x0025 }
            r11.f12829e = r12     // Catch:{ all -> 0x0025 }
            goto L_0x007a
        L_0x0074:
            java.lang.String r12 = r12.getString(r6, r0)     // Catch:{ all -> 0x0025 }
            r11.f12825a = r12     // Catch:{ all -> 0x0025 }
        L_0x007a:
            com.mbridge.msdk.foundation.controller.e$a r12 = r11.f12836l     // Catch:{ all -> 0x0025 }
            if (r12 == 0) goto L_0x008b
            r12.a()     // Catch:{ all -> 0x0025 }
            return
        L_0x0082:
            java.lang.String r13 = "TCStringManager"
            java.lang.String r12 = r12.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r13, r12)
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.controller.e.onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String):void");
    }

    public final String a() {
        return this.f12825a;
    }

    private void a(String str) {
        this.f12831g = a(str, 1);
        this.f12832h = a(str, 2);
        this.f12826b = str;
    }

    public final boolean b() {
        boolean z4 = true;
        if (this.f12829e == 0) {
            this.f12830f = true;
            return true;
        }
        if (d(this.f12826b) && d(this.f12827c)) {
            if (MBridgeConstans.VERIFY_ATP_CONSENT) {
                boolean z5 = this.f12835k && this.f12834j;
                if ((!this.f12833i && !z5) || !this.f12831g || !this.f12832h) {
                    z4 = false;
                }
                this.f12830f = z4;
                return this.f12830f;
            } else if (!this.f12833i || !this.f12831g || !this.f12832h) {
                z4 = false;
            }
        }
        this.f12830f = z4;
        return this.f12830f;
    }

    private boolean a(String str, int i4) {
        if (!d(str) || i4 > str.length() || i4 < 1 || '1' != str.charAt(i4 - 1)) {
            return false;
        }
        return true;
    }
}
