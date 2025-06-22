package com.mbridge.msdk.foundation.controller.authoritycontroller;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.a.a.a;
import com.mbridge.msdk.foundation.controller.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.OnCompletionListener;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f12788c = true;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f12789d = true;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f12790a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    protected AuthorityInfoBean f12791b;

    /* renamed from: e  reason: collision with root package name */
    private int f12792e = 3;

    /* renamed from: f  reason: collision with root package name */
    private String f12793f = "";

    /* renamed from: g  reason: collision with root package name */
    private e f12794g;

    protected b() {
        c();
    }

    public static boolean b() {
        return f12789d;
    }

    /* access modifiers changed from: private */
    public void j() {
        int i4;
        boolean b5 = this.f12794g.b();
        c(this.f12794g.a());
        if (b5) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        c(i4);
        this.f12791b.authDeviceIdStatus(b5 ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    public abstract int b(String str);

    /* access modifiers changed from: protected */
    public final void c() {
        this.f12791b = new AuthorityInfoBean();
        try {
            if (a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA).equals("")) {
                this.f12791b.authGenDataStatus(1);
            }
            if (a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID).equals("")) {
                this.f12791b.authDeviceIdStatus(1);
            }
            if (a.a().a(MBridgeConstans.AUTHORITY_SERIAL_ID).equals("")) {
                this.f12791b.authSerialIdStatus(1);
            }
            if (a.a().a(MBridgeConstans.AUTHORITY_OTHER).equals("")) {
                this.f12791b.authOther(1);
            }
            this.f12790a.add(MBridgeConstans.AUTHORITY_GENERAL_DATA);
            this.f12790a.add(MBridgeConstans.AUTHORITY_DEVICE_ID);
            this.f12790a.add(MBridgeConstans.AUTHORITY_SERIAL_ID);
            this.f12790a.add(MBridgeConstans.AUTHORITY_OTHER);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final AuthorityInfoBean d() {
        AuthorityInfoBean authorityInfoBean = this.f12791b;
        if (authorityInfoBean != null) {
            return authorityInfoBean;
        }
        AuthorityInfoBean authorityInfoBean2 = new AuthorityInfoBean();
        authorityInfoBean2.a(1);
        return authorityInfoBean2;
    }

    public final boolean e() {
        int i4 = this.f12792e;
        if (i4 == 1 || i4 == 3) {
            return true;
        }
        return false;
    }

    public final int f() {
        return a.a().a(MBridgeConstans.AUTHORITY_COPPA, 0);
    }

    public final int g() {
        return this.f12792e;
    }

    public final String h() {
        JSONArray jSONArray = new JSONArray();
        for (int i4 = 0; i4 < this.f12790a.size(); i4++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("keyname", String.valueOf(this.f12790a.get(i4)));
                jSONObject.put("client_status", a(this.f12790a.get(i4)));
                jSONObject.put("server_status", b(this.f12790a.get(i4)));
                jSONArray.put(jSONObject);
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public final String i() {
        return this.f12793f;
    }

    public static void b(boolean z4) {
        f12789d = z4;
    }

    public static boolean a() {
        return f12788c;
    }

    public final void b(int i4) {
        a.a().b(MBridgeConstans.AUTHORITY_DNT, i4);
    }

    public static void a(boolean z4) {
        f12788c = z4;
    }

    public final void a(int i4) {
        if (this.f12791b != null) {
            c(i4);
        }
    }

    public final void a(final Context context, final OnCompletionListener onCompletionListener) {
        if (onCompletionListener != null) {
            com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() {
                public final void run() {
                    b.this.a(context);
                    onCompletionListener.onCompletion();
                }
            });
        } else {
            a(context);
        }
    }

    /* access modifiers changed from: protected */
    public final int a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String a5 = a.a().a(str);
                if (TextUtils.isEmpty(a5)) {
                    return 0;
                }
                return Integer.parseInt(a5);
            }
        } catch (Exception e5) {
            af.b("SDKAuthorityController", e5.getMessage());
        }
        return 0;
    }

    public final void a(String str, int i4) {
        if (this.f12791b == null) {
            return;
        }
        if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            this.f12791b.authGenDataStatus(i4);
        } else if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            this.f12791b.authDeviceIdStatus(i4);
        } else if (str.equals(MBridgeConstans.AUTHORITY_ALL_INFO)) {
            this.f12791b.a(i4);
        } else if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
            this.f12791b.authSerialIdStatus(i4);
        } else if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
            this.f12791b.authOther(i4);
        }
    }

    private void c(int i4) {
        int i5 = 1;
        if (i4 != 1) {
            i5 = 2;
        }
        this.f12792e = i5;
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f12793f = str;
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        try {
            if (this.f12794g == null) {
                e eVar = new e(context);
                this.f12794g = eVar;
                eVar.a((e.a) new e.a() {
                    public final void a() {
                        b.this.j();
                    }
                });
            }
            j();
        } catch (Throwable th) {
            af.b("SDKAuthorityController", th.getMessage());
        }
    }
}
