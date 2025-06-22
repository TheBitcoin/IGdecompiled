package com.mbridge.msdk.tracker;

import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.tracker.network.e;
import com.mbridge.msdk.tracker.network.r;
import com.mbridge.msdk.tracker.network.u;
import com.mbridge.msdk.tracker.network.w;
import com.mbridge.msdk.tracker.network.z;
import java.util.HashMap;
import java.util.Map;

public final class u<T> extends com.mbridge.msdk.tracker.network.u<T> {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f15698a;

    /* renamed from: b  reason: collision with root package name */
    private u.b f15699b;

    /* renamed from: c  reason: collision with root package name */
    private w.b<T> f15700c;

    /* renamed from: d  reason: collision with root package name */
    private v f15701d;

    /* renamed from: e  reason: collision with root package name */
    private e f15702e;

    public u(String str, int i4) {
        super(i4, str);
    }

    public final void a(v vVar) {
        this.f15701d = vVar;
    }

    public final z b() {
        if (y.a((Object) this.f15702e)) {
            this.f15702e = new e(30000, 5);
        }
        return this.f15702e;
    }

    public final Map<String, String> c() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
        hashMap.put("Charset", C.UTF8_NAME);
        return hashMap;
    }

    public final boolean d() {
        return false;
    }

    public final u.b e() {
        return this.f15699b;
    }

    public u(String str, int i4, int i5) {
        super(i4, str, i5);
    }

    public final void a(u.b bVar) {
        this.f15699b = bVar;
    }

    public final void a(Map<String, String> map) {
        this.f15698a = map;
    }

    public final void a(w.b<T> bVar) {
        this.f15700c = bVar;
    }

    /* access modifiers changed from: protected */
    public final w<T> a(r rVar) {
        return this.f15701d.a(rVar);
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> a() {
        return this.f15698a;
    }

    /* access modifiers changed from: protected */
    public final void a(T t4) {
        w.b<T> bVar = this.f15700c;
        this.f15700c = bVar;
        if (bVar != null) {
            bVar.a(t4);
        }
    }
}
