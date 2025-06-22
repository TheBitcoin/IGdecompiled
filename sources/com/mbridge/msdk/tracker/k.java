package com.mbridge.msdk.tracker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.mbridge.msdk.tracker.w;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

class k {

    /* renamed from: a  reason: collision with root package name */
    private static x f15473a = null;

    /* renamed from: o  reason: collision with root package name */
    private static volatile String f15474o = "";

    /* renamed from: b  reason: collision with root package name */
    private final String f15475b;

    /* renamed from: c  reason: collision with root package name */
    private final m f15476c;

    /* renamed from: d  reason: collision with root package name */
    private Context f15477d;

    /* renamed from: e  reason: collision with root package name */
    private w f15478e;

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f15479f;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f15480g;

    /* renamed from: h  reason: collision with root package name */
    private List<String> f15481h;

    /* renamed from: i  reason: collision with root package name */
    private volatile c f15482i;

    /* renamed from: j  reason: collision with root package name */
    private volatile l f15483j;

    /* renamed from: k  reason: collision with root package name */
    private volatile d f15484k;

    /* renamed from: l  reason: collision with root package name */
    private volatile j f15485l;

    /* renamed from: m  reason: collision with root package name */
    private volatile r f15486m;

    /* renamed from: n  reason: collision with root package name */
    private volatile boolean f15487n = true;

    /* renamed from: p  reason: collision with root package name */
    private volatile n f15488p;

    /* renamed from: q  reason: collision with root package name */
    private volatile boolean f15489q;

    k(String str, m mVar) {
        this.f15475b = str;
        this.f15476c = mVar;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        if (!y.a((Object) this.f15477d) && !y.a((Object) this.f15478e)) {
            try {
                o().a();
                this.f15487n = false;
                this.f15489q = false;
                if (TextUtils.isEmpty(f15474o)) {
                    f15474o = UUID.randomUUID().toString();
                }
                if (!y.a((Object) f15473a)) {
                    try {
                        f15473a.a(b(), this.f15475b, this.f15476c);
                        t.a().b();
                    } catch (Exception e5) {
                        if (a.f15435a) {
                            Log.e("TrackManager", "track manager start exception", e5);
                        }
                    }
                }
                return f15474o;
            } catch (Exception e6) {
                if (a.f15435a) {
                    Log.e("TrackManager", "start error", e6);
                }
                this.f15487n = true;
            }
        }
        return "";
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        if (!TextUtils.isEmpty(f15474o)) {
            return f15474o;
        }
        String uuid = UUID.randomUUID().toString();
        f15474o = uuid;
        return uuid;
    }

    /* access modifiers changed from: package-private */
    public final String c() {
        return this.f15475b;
    }

    /* access modifiers changed from: package-private */
    public final w d() {
        w wVar = this.f15478e;
        if (wVar != null) {
            return wVar;
        }
        w a5 = new w.a().a();
        this.f15478e = a5;
        return a5;
    }

    /* access modifiers changed from: package-private */
    public final Context e() {
        return this.f15477d;
    }

    /* access modifiers changed from: package-private */
    public final JSONObject f() {
        JSONObject jSONObject = this.f15479f;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        this.f15479f = jSONObject2;
        return jSONObject2;
    }

    /* access modifiers changed from: package-private */
    public final c g() {
        String str;
        if (y.a((Object) this.f15482i)) {
            synchronized (k.class) {
                try {
                    if (y.a((Object) this.f15482i)) {
                        Context context = this.f15477d;
                        if (TextUtils.isEmpty(this.f15475b)) {
                            str = String.format("track_manager_%s.db", new Object[]{MRAIDCommunicatorUtil.STATES_DEFAULT});
                        } else {
                            str = String.format("track_manager_%s.db", new Object[]{this.f15475b});
                        }
                        this.f15482i = new c(new b(context, str, "event_table"), "event_table");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f15482i;
    }

    /* access modifiers changed from: package-private */
    public final l h() {
        if (y.a((Object) this.f15483j)) {
            synchronized (k.class) {
                try {
                    if (y.a((Object) this.f15483j)) {
                        this.f15483j = new p(new g(g(), o(), i()));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f15483j;
    }

    /* access modifiers changed from: package-private */
    public final j i() {
        if (y.a((Object) this.f15485l)) {
            synchronized (k.class) {
                try {
                    if (y.a((Object) this.f15485l)) {
                        this.f15485l = new j();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f15485l;
    }

    /* access modifiers changed from: package-private */
    public final d j() {
        if (y.a((Object) this.f15484k)) {
            this.f15484k = d().f15710h;
        }
        return this.f15484k;
    }

    /* access modifiers changed from: package-private */
    public final m k() {
        return this.f15476c;
    }

    /* access modifiers changed from: package-private */
    public final int l() {
        if (d().f15703a < 0) {
            return 50;
        }
        return d().f15703a;
    }

    /* access modifiers changed from: package-private */
    public final int m() {
        return Math.max(d().f15704b, 0);
    }

    /* access modifiers changed from: package-private */
    public final int n() {
        return Math.max(d().f15707e, 0);
    }

    /* access modifiers changed from: package-private */
    public final r o() {
        if (y.a((Object) this.f15486m)) {
            synchronized (k.class) {
                try {
                    if (y.a((Object) this.f15486m)) {
                        this.f15486m = new r(this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f15486m;
    }

    /* access modifiers changed from: package-private */
    public final boolean p() throws IllegalStateException {
        if (y.a((Object) d())) {
            throw new IllegalStateException("config can not be null");
        } else if (y.a((Object) j())) {
            throw new IllegalStateException("decorate can not be null");
        } else if (y.a((Object) d().f15711i)) {
            throw new IllegalStateException("responseHandler can not be null");
        } else if (y.a((Object) d().f15709g) || y.a((Object) d().f15709g.c())) {
            throw new IllegalStateException("networkStackConfig or stack can not be null");
        } else if (!TextUtils.isEmpty(d().f15709g.b())) {
            return true;
        } else {
            throw new IllegalStateException("report url is null");
        }
    }

    /* access modifiers changed from: package-private */
    public final n q() {
        int i4;
        if (y.a((Object) this.f15488p)) {
            synchronized (k.class) {
                try {
                    if (y.a((Object) this.f15488p)) {
                        if (d().f15706d <= 0) {
                            i4 = 2;
                        } else {
                            i4 = d().f15706d;
                        }
                        this.f15488p = new n(i4, d().f15709g, d().f15711i, d().f15705c);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f15488p;
    }

    /* access modifiers changed from: package-private */
    public final boolean r() {
        return this.f15487n;
    }

    public final void s() {
        this.f15489q = true;
    }

    public final boolean t() {
        return !this.f15489q;
    }

    /* access modifiers changed from: package-private */
    public final void a(Context context) {
        this.f15477d = context;
    }

    /* access modifiers changed from: package-private */
    public final void a(w wVar) {
        this.f15478e = wVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject) {
        this.f15479f = jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(e eVar) {
        if (y.a((Object) eVar)) {
            return false;
        }
        f fVar = d().f15712j;
        if (y.b((Object) fVar)) {
            try {
                return fVar.a(eVar);
            } catch (Exception e5) {
                if (a.f15435a) {
                    Log.e("TrackManager", "event filter apply exception", e5);
                }
            }
        }
        String a5 = eVar.a();
        if (TextUtils.isEmpty(a5)) {
            return false;
        }
        List<String> list = this.f15481h;
        if (list != null) {
            try {
                return !list.contains(a5);
            } catch (Exception e6) {
                if (a.f15435a) {
                    Log.e("TrackManager", "disallowTrackEventNames contains exception", e6);
                }
            }
        }
        List<String> list2 = this.f15480g;
        if (list2 != null) {
            try {
                return list2.contains(a5);
            } catch (Exception e7) {
                if (a.f15435a) {
                    Log.e("TrackManager", "allowTrackEventNames contains exception", e7);
                }
            }
        }
        return true;
    }
}
