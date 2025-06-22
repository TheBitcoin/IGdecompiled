package com.google.android.gms.auth.api.signin;

import F.d;
import G.b;
import K.a;
import M.C0335p;
import N.c;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class GoogleSignInOptions extends N.a implements a.d, ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new e();

    /* renamed from: l  reason: collision with root package name */
    public static final GoogleSignInOptions f1202l;

    /* renamed from: m  reason: collision with root package name */
    public static final GoogleSignInOptions f1203m;

    /* renamed from: n  reason: collision with root package name */
    public static final Scope f1204n = new Scope("profile");

    /* renamed from: o  reason: collision with root package name */
    public static final Scope f1205o = new Scope(NotificationCompat.CATEGORY_EMAIL);

    /* renamed from: p  reason: collision with root package name */
    public static final Scope f1206p = new Scope("openid");

    /* renamed from: q  reason: collision with root package name */
    public static final Scope f1207q;

    /* renamed from: r  reason: collision with root package name */
    public static final Scope f1208r = new Scope("https://www.googleapis.com/auth/games");

    /* renamed from: s  reason: collision with root package name */
    private static final Comparator f1209s = new d();

    /* renamed from: a  reason: collision with root package name */
    final int f1210a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList f1211b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Account f1212c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f1213d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final boolean f1214e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final boolean f1215f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f1216g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f1217h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ArrayList f1218i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f1219j;

    /* renamed from: k  reason: collision with root package name */
    private Map f1220k;

    static {
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        f1207q = scope;
        a aVar = new a();
        aVar.c();
        aVar.e();
        f1202l = aVar.a();
        a aVar2 = new a();
        aVar2.f(scope, new Scope[0]);
        f1203m = aVar2.a();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* synthetic */ GoogleSignInOptions(int r1, java.util.ArrayList r2, android.accounts.Account r3, boolean r4, boolean r5, boolean r6, java.lang.String r7, java.lang.String r8, java.util.Map r9, java.lang.String r10, F.d r11) {
        /*
            r0 = this;
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = 3
            r1 = r0
            r1.<init>((int) r2, (java.util.ArrayList) r3, (android.accounts.Account) r4, (boolean) r5, (boolean) r6, (boolean) r7, (java.lang.String) r8, (java.lang.String) r9, (java.util.Map) r10, (java.lang.String) r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.<init>(int, java.util.ArrayList, android.accounts.Account, boolean, boolean, boolean, java.lang.String, java.lang.String, java.util.Map, java.lang.String, F.d):void");
    }

    /* access modifiers changed from: private */
    public static Map C(List list) {
        HashMap hashMap = new HashMap();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                G.a aVar = (G.a) it.next();
                hashMap.put(Integer.valueOf(aVar.c()), aVar);
            }
        }
        return hashMap;
    }

    public static GoogleSignInOptions p(String str) {
        String str2;
        Account account;
        String str3;
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            hashSet.add(new Scope(jSONArray.getString(i4)));
        }
        if (jSONObject.has("accountName")) {
            str2 = jSONObject.optString("accountName");
        } else {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            account = new Account(str2, "com.google");
        } else {
            account = null;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        boolean z4 = jSONObject.getBoolean("idTokenRequested");
        boolean z5 = jSONObject.getBoolean("serverAuthRequested");
        boolean z6 = jSONObject.getBoolean("forceCodeForRefreshToken");
        if (jSONObject.has("serverClientId")) {
            str3 = jSONObject.optString("serverClientId");
        } else {
            str3 = null;
        }
        if (jSONObject.has("hostedDomain")) {
            str4 = jSONObject.optString("hostedDomain");
        }
        return new GoogleSignInOptions(3, arrayList, account, z4, z5, z6, str3, str4, (Map) new HashMap(), (String) null);
    }

    public Account c() {
        return this.f1212c;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r1.equals(r4.c()) != false) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList r1 = r3.f1218i     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.isEmpty()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x0090
            java.util.ArrayList r1 = r4.f1218i     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.isEmpty()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0018
            goto L_0x0090
        L_0x0018:
            java.util.ArrayList r1 = r3.f1211b     // Catch:{ ClassCastException -> 0x0090 }
            int r1 = r1.size()     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList r2 = r4.j()     // Catch:{ ClassCastException -> 0x0090 }
            int r2 = r2.size()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            java.util.ArrayList r1 = r3.f1211b     // Catch:{ ClassCastException -> 0x0090 }
            java.util.ArrayList r2 = r4.j()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.containsAll(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0035
            goto L_0x0090
        L_0x0035:
            android.accounts.Account r1 = r3.f1212c     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0040
            android.accounts.Account r1 = r4.c()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x0090
            goto L_0x004a
        L_0x0040:
            android.accounts.Account r2 = r4.c()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x0090
        L_0x004a:
            java.lang.String r1 = r3.f1216g     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x005d
            java.lang.String r1 = r4.k()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 == 0) goto L_0x0090
            goto L_0x006a
        L_0x005d:
            java.lang.String r1 = r3.f1216g     // Catch:{ ClassCastException -> 0x0090 }
            java.lang.String r2 = r4.k()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r1 = r1.equals(r2)     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != 0) goto L_0x006a
            goto L_0x0090
        L_0x006a:
            boolean r1 = r3.f1215f     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.l()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            boolean r1 = r3.f1213d     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.m()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            boolean r1 = r3.f1214e     // Catch:{ ClassCastException -> 0x0090 }
            boolean r2 = r4.n()     // Catch:{ ClassCastException -> 0x0090 }
            if (r1 != r2) goto L_0x0090
            java.lang.String r1 = r3.f1219j     // Catch:{ ClassCastException -> 0x0090 }
            java.lang.String r4 = r4.h()     // Catch:{ ClassCastException -> 0x0090 }
            boolean r4 = android.text.TextUtils.equals(r1, r4)     // Catch:{ ClassCastException -> 0x0090 }
            if (r4 == 0) goto L_0x0090
            r4 = 1
            return r4
        L_0x0090:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public ArrayList g() {
        return this.f1218i;
    }

    public String h() {
        return this.f1219j;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f1211b;
        int size = arrayList2.size();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(((Scope) arrayList2.get(i4)).c());
        }
        Collections.sort(arrayList);
        b bVar = new b();
        bVar.a(arrayList);
        bVar.a(this.f1212c);
        bVar.a(this.f1216g);
        bVar.c(this.f1215f);
        bVar.c(this.f1213d);
        bVar.c(this.f1214e);
        bVar.a(this.f1219j);
        return bVar.b();
    }

    public ArrayList j() {
        return new ArrayList(this.f1211b);
    }

    public String k() {
        return this.f1216g;
    }

    public boolean l() {
        return this.f1215f;
    }

    public boolean m() {
        return this.f1213d;
    }

    public boolean n() {
        return this.f1214e;
    }

    public final String t() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.f1211b, f1209s);
            ArrayList arrayList = this.f1211b;
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                jSONArray.put(((Scope) obj).c());
            }
            jSONObject.put("scopes", jSONArray);
            Account account = this.f1212c;
            if (account != null) {
                jSONObject.put("accountName", account.name);
            }
            jSONObject.put("idTokenRequested", this.f1213d);
            jSONObject.put("forceCodeForRefreshToken", this.f1215f);
            jSONObject.put("serverAuthRequested", this.f1214e);
            if (!TextUtils.isEmpty(this.f1216g)) {
                jSONObject.put("serverClientId", this.f1216g);
            }
            if (!TextUtils.isEmpty(this.f1217h)) {
                jSONObject.put("hostedDomain", this.f1217h);
            }
            return jSONObject.toString();
        } catch (JSONException e5) {
            throw new RuntimeException(e5);
        }
    }

    public void writeToParcel(Parcel parcel, int i4) {
        int i5 = this.f1210a;
        int a5 = c.a(parcel);
        c.i(parcel, 1, i5);
        c.q(parcel, 2, j(), false);
        c.m(parcel, 3, c(), i4, false);
        c.c(parcel, 4, m());
        c.c(parcel, 5, n());
        c.c(parcel, 6, l());
        c.n(parcel, 7, k(), false);
        c.n(parcel, 8, this.f1217h, false);
        c.q(parcel, 9, g(), false);
        c.n(parcel, 10, h(), false);
        c.b(parcel, a5);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Set f1221a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        private boolean f1222b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1223c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1224d;

        /* renamed from: e  reason: collision with root package name */
        private String f1225e;

        /* renamed from: f  reason: collision with root package name */
        private Account f1226f;

        /* renamed from: g  reason: collision with root package name */
        private String f1227g;

        /* renamed from: h  reason: collision with root package name */
        private Map f1228h = new HashMap();

        /* renamed from: i  reason: collision with root package name */
        private String f1229i;

        public a() {
        }

        private final String h(String str) {
            C0335p.f(str);
            String str2 = this.f1225e;
            boolean z4 = true;
            if (str2 != null && !str2.equals(str)) {
                z4 = false;
            }
            C0335p.b(z4, "two different server client ids provided");
            return str;
        }

        public GoogleSignInOptions a() {
            if (this.f1221a.contains(GoogleSignInOptions.f1208r)) {
                Set set = this.f1221a;
                Scope scope = GoogleSignInOptions.f1207q;
                if (set.contains(scope)) {
                    this.f1221a.remove(scope);
                }
            }
            if (this.f1224d && (this.f1226f == null || !this.f1221a.isEmpty())) {
                c();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f1221a), this.f1226f, this.f1224d, this.f1222b, this.f1223c, this.f1225e, this.f1227g, this.f1228h, this.f1229i, (d) null);
        }

        public a b() {
            this.f1221a.add(GoogleSignInOptions.f1205o);
            return this;
        }

        public a c() {
            this.f1221a.add(GoogleSignInOptions.f1206p);
            return this;
        }

        public a d(String str) {
            this.f1224d = true;
            h(str);
            this.f1225e = str;
            return this;
        }

        public a e() {
            this.f1221a.add(GoogleSignInOptions.f1204n);
            return this;
        }

        public a f(Scope scope, Scope... scopeArr) {
            this.f1221a.add(scope);
            this.f1221a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public a g(String str) {
            this.f1229i = str;
            return this;
        }

        public a(GoogleSignInOptions googleSignInOptions) {
            C0335p.l(googleSignInOptions);
            this.f1221a = new HashSet(googleSignInOptions.f1211b);
            this.f1222b = googleSignInOptions.f1214e;
            this.f1223c = googleSignInOptions.f1215f;
            this.f1224d = googleSignInOptions.f1213d;
            this.f1225e = googleSignInOptions.f1216g;
            this.f1226f = googleSignInOptions.f1212c;
            this.f1227g = googleSignInOptions.f1217h;
            this.f1228h = GoogleSignInOptions.C(googleSignInOptions.f1218i);
            this.f1229i = googleSignInOptions.f1219j;
        }
    }

    GoogleSignInOptions(int i4, ArrayList arrayList, Account account, boolean z4, boolean z5, boolean z6, String str, String str2, ArrayList arrayList2, String str3) {
        this(i4, arrayList, account, z4, z5, z6, str, str2, C(arrayList2), str3);
    }

    private GoogleSignInOptions(int i4, ArrayList arrayList, Account account, boolean z4, boolean z5, boolean z6, String str, String str2, Map map, String str3) {
        this.f1210a = i4;
        this.f1211b = arrayList;
        this.f1212c = account;
        this.f1213d = z4;
        this.f1214e = z5;
        this.f1215f = z6;
        this.f1216g = str;
        this.f1217h = str2;
        this.f1218i = new ArrayList(map.values());
        this.f1220k = map;
        this.f1219j = str3;
    }
}
