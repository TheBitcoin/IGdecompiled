package com.mbridge.msdk.tracker.network;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.d;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.util.HashMap;
import java.util.Map;

public abstract class i<T> extends u<T> {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f15538a = "i";

    /* renamed from: b  reason: collision with root package name */
    private final long f15539b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f15540c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, String> f15541d;

    /* renamed from: e  reason: collision with root package name */
    private z f15542e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15543f = false;

    public i(int i4, String str, int i5, String str2, long j4) {
        super(i4, str, i5, str2);
        if (j4 > 0) {
            this.f15539b = j4;
        } else {
            this.f15539b = ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS;
        }
    }

    public final void a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            if (this.f15540c == null) {
                this.f15540c = new HashMap();
            }
            try {
                this.f15540c.putAll(map);
            } catch (Exception e5) {
                String str = f15538a;
                af.b(str, "addParams error: " + e5.getMessage());
            }
        }
    }

    public final z b() {
        if (this.f15542e == null) {
            this.f15542e = new e(30000, this.f15539b, 3);
        }
        return this.f15542e;
    }

    public final Map<String, String> c() {
        if (this.f15541d == null) {
            this.f15541d = new HashMap();
        }
        this.f15541d.put("Charset", C.UTF8_NAME);
        return this.f15541d;
    }

    public final boolean d() {
        if (!this.f15543f || !d.a(f(), k())) {
            return false;
        }
        return true;
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f15541d == null) {
                this.f15541d = new HashMap();
            }
            try {
                this.f15541d.put(str, str2);
            } catch (Exception e5) {
                String str3 = f15538a;
                af.b(str3, "addHeader error: " + e5.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final Map<String, String> a() {
        if (this.f15540c == null) {
            this.f15540c = new HashMap();
        }
        return this.f15540c;
    }

    public final void a(boolean z4) {
        this.f15543f = z4;
    }
}
