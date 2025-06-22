package com.google.android.gms.auth.api.signin;

import F.c;
import M.C0335p;
import N.a;
import R.d;
import R.g;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class GoogleSignInAccount extends a implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new c();

    /* renamed from: n  reason: collision with root package name */
    public static final d f1188n = g.b();

    /* renamed from: a  reason: collision with root package name */
    final int f1189a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1190b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1191c;

    /* renamed from: d  reason: collision with root package name */
    private final String f1192d;

    /* renamed from: e  reason: collision with root package name */
    private final String f1193e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f1194f;

    /* renamed from: g  reason: collision with root package name */
    private String f1195g;

    /* renamed from: h  reason: collision with root package name */
    private final long f1196h;

    /* renamed from: i  reason: collision with root package name */
    private final String f1197i;

    /* renamed from: j  reason: collision with root package name */
    final List f1198j;

    /* renamed from: k  reason: collision with root package name */
    private final String f1199k;

    /* renamed from: l  reason: collision with root package name */
    private final String f1200l;

    /* renamed from: m  reason: collision with root package name */
    private final Set f1201m = new HashSet();

    GoogleSignInAccount(int i4, String str, String str2, String str3, String str4, Uri uri, String str5, long j4, String str6, List list, String str7, String str8) {
        this.f1189a = i4;
        this.f1190b = str;
        this.f1191c = str2;
        this.f1192d = str3;
        this.f1193e = str4;
        this.f1194f = uri;
        this.f1195g = str5;
        this.f1196h = j4;
        this.f1197i = str6;
        this.f1198j = list;
        this.f1199k = str7;
        this.f1200l = str8;
    }

    public static GoogleSignInAccount p(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l4, String str7, Set set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, (String) null, l4.longValue(), C0335p.f(str7), new ArrayList((Collection) C0335p.l(set)), str5, str6);
    }

    public static GoogleSignInAccount q(String str) {
        Uri uri;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        if (!TextUtils.isEmpty(optString)) {
            uri = Uri.parse(optString);
        } else {
            uri = null;
        }
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            hashSet.add(new Scope(jSONArray.getString(i4)));
        }
        String optString2 = jSONObject.optString("id");
        if (jSONObject.has("tokenId")) {
            str2 = jSONObject.optString("tokenId");
        } else {
            str2 = null;
        }
        if (jSONObject.has(NotificationCompat.CATEGORY_EMAIL)) {
            str3 = jSONObject.optString(NotificationCompat.CATEGORY_EMAIL);
        } else {
            str3 = null;
        }
        if (jSONObject.has("displayName")) {
            str4 = jSONObject.optString("displayName");
        } else {
            str4 = null;
        }
        if (jSONObject.has("givenName")) {
            str5 = jSONObject.optString("givenName");
        } else {
            str5 = null;
        }
        if (jSONObject.has("familyName")) {
            str6 = jSONObject.optString("familyName");
        } else {
            str6 = null;
        }
        GoogleSignInAccount p4 = p(optString2, str2, str3, str4, str5, str6, uri, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        if (jSONObject.has("serverAuthCode")) {
            str7 = jSONObject.optString("serverAuthCode");
        }
        p4.f1195g = str7;
        return p4;
    }

    public String c() {
        return this.f1193e;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.f1197i.equals(this.f1197i) || !googleSignInAccount.n().equals(n())) {
            return false;
        }
        return true;
    }

    public String g() {
        return this.f1192d;
    }

    public String h() {
        return this.f1200l;
    }

    public int hashCode() {
        return ((this.f1197i.hashCode() + 527) * 31) + n().hashCode();
    }

    public String j() {
        return this.f1199k;
    }

    public String k() {
        return this.f1190b;
    }

    public String l() {
        return this.f1191c;
    }

    public Uri m() {
        return this.f1194f;
    }

    public Set n() {
        HashSet hashSet = new HashSet(this.f1198j);
        hashSet.addAll(this.f1201m);
        return hashSet;
    }

    public String o() {
        return this.f1195g;
    }

    public final String r() {
        return this.f1197i;
    }

    public final String s() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (k() != null) {
                jSONObject.put("id", k());
            }
            if (l() != null) {
                jSONObject.put("tokenId", l());
            }
            if (g() != null) {
                jSONObject.put(NotificationCompat.CATEGORY_EMAIL, g());
            }
            if (c() != null) {
                jSONObject.put("displayName", c());
            }
            if (j() != null) {
                jSONObject.put("givenName", j());
            }
            if (h() != null) {
                jSONObject.put("familyName", h());
            }
            Uri m4 = m();
            if (m4 != null) {
                jSONObject.put("photoUrl", m4.toString());
            }
            if (o() != null) {
                jSONObject.put("serverAuthCode", o());
            }
            jSONObject.put("expirationTime", this.f1196h);
            jSONObject.put("obfuscatedIdentifier", this.f1197i);
            JSONArray jSONArray = new JSONArray();
            List list = this.f1198j;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, c.f202a);
            for (Scope c5 : scopeArr) {
                jSONArray.put(c5.c());
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            return jSONObject.toString();
        } catch (JSONException e5) {
            throw new RuntimeException(e5);
        }
    }

    public void writeToParcel(Parcel parcel, int i4) {
        int a5 = N.c.a(parcel);
        N.c.i(parcel, 1, this.f1189a);
        N.c.n(parcel, 2, k(), false);
        N.c.n(parcel, 3, l(), false);
        N.c.n(parcel, 4, g(), false);
        N.c.n(parcel, 5, c(), false);
        N.c.m(parcel, 6, m(), i4, false);
        N.c.n(parcel, 7, o(), false);
        N.c.k(parcel, 8, this.f1196h);
        N.c.n(parcel, 9, this.f1197i, false);
        N.c.q(parcel, 10, this.f1198j, false);
        N.c.n(parcel, 11, j(), false);
        N.c.n(parcel, 12, h(), false);
        N.c.b(parcel, a5);
    }
}
