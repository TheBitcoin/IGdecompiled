package g2;

import android.content.Context;
import android.os.Bundle;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import u2.x;

/* renamed from: g2.c  reason: case insensitive filesystem */
public abstract class C2045c {

    /* renamed from: j  reason: collision with root package name */
    public static final a f20544j = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final long f20545a;

    /* renamed from: b  reason: collision with root package name */
    private final String f20546b;

    /* renamed from: c  reason: collision with root package name */
    private String f20547c;

    /* renamed from: d  reason: collision with root package name */
    private String f20548d;

    /* renamed from: e  reason: collision with root package name */
    private long f20549e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f20550f = -1;

    /* renamed from: g  reason: collision with root package name */
    private long f20551g = -1;

    /* renamed from: h  reason: collision with root package name */
    private int f20552h;

    /* renamed from: i  reason: collision with root package name */
    private long f20553i = -1;

    /* renamed from: g2.c$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final boolean a(C2045c cVar, long j4) {
            if (cVar == null || cVar.o() <= -1 || cVar.k() != j4 || System.currentTimeMillis() - cVar.o() >= ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS) {
                return false;
            }
            return true;
        }

        private a() {
        }
    }

    public C2045c(long j4, String str, String str2, String str3) {
        m.e(str, "packageName");
        m.e(str2, "imageUrl");
        m.e(str3, "type");
        this.f20545a = j4;
        this.f20546b = str;
        this.f20547c = str2;
        this.f20548d = str3;
    }

    private final boolean b(Context context) {
        if (new u2.m().A(context, r()) == null) {
            return true;
        }
        return false;
    }

    private final boolean c(Context context) {
        boolean z4;
        boolean z5;
        long currentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        long j4 = this.f20549e;
        if (currentTimeMillis - j4 <= 3600 || this.f20552h >= 3) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (currentTimeMillis - j4 > 86400) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (z5) {
            this.f20552h = 0;
            t(context);
        }
        if (z4 || z5) {
            return true;
        }
        return false;
    }

    public final boolean a(Context context) {
        m.e(context, "context");
        if (c(context)) {
            return b(context);
        }
        return false;
    }

    public final boolean d() {
        if ((System.currentTimeMillis() / ((long) 1000)) - this.f20553i > 86400) {
            return true;
        }
        return false;
    }

    public final void e(Context context) {
        m.e(context, "context");
        this.f20551g = System.currentTimeMillis();
        t(context);
        Bundle bundle = new Bundle();
        bundle.putString("appId", String.valueOf(k()));
        bundle.putString("type", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        bundle.putString("adView", this.f20548d);
        new x(context).d("ad", bundle);
    }

    public final void f(Context context) {
        m.e(context, "context");
        Bundle bundle = new Bundle();
        bundle.putString("appId", String.valueOf(k()));
        bundle.putString("type", CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        bundle.putString("adView", this.f20548d);
        new x(context).d("ad", bundle);
    }

    public final void g(Context context) {
        m.e(context, "context");
        Bundle bundle = new Bundle();
        bundle.putString("appId", String.valueOf(k()));
        bundle.putString("type", "imageFailed");
        bundle.putString("adView", this.f20548d);
        new x(context).d("ad", bundle);
    }

    public final void h(Context context) {
        m.e(context, "context");
        Bundle bundle = new Bundle();
        bundle.putString("appId", String.valueOf(k()));
        bundle.putString("type", "imageLoaded");
        bundle.putString("adView", this.f20548d);
        new x(context).d("ad", bundle);
    }

    public final void i(Context context) {
        m.e(context, "context");
        this.f20550f = -1;
        t(context);
    }

    public final void j(Context context) {
        m.e(context, "context");
        this.f20549e = System.currentTimeMillis() / ((long) 1000);
        this.f20552h++;
        t(context);
        Bundle bundle = new Bundle();
        bundle.putString("appId", String.valueOf(k()));
        bundle.putString("type", CampaignEx.JSON_NATIVE_VIDOE_IMPRESSION);
        bundle.putString("adView", this.f20548d);
        new x(context).d("ad", bundle);
    }

    public abstract long k();

    public final int l() {
        return this.f20552h;
    }

    public final int m() {
        return this.f20550f;
    }

    public abstract String n();

    public final long o() {
        return this.f20551g;
    }

    public final long p() {
        return this.f20553i;
    }

    public final long q() {
        return this.f20549e;
    }

    public abstract String r();

    public final String s() {
        return this.f20548d;
    }

    public abstract void t(Context context);

    public String toString() {
        return "AdInfo(appId=" + k() + ", packageName=" + r() + ", imageUrl=" + n() + ", lastTimeShown=" + this.f20549e + ", downloadId=" + this.f20550f + ", lastTimeClicked=" + this.f20551g + ", type=" + this.f20548d + ", counterImpressions=" + this.f20552h + ", lastTimeRequested=" + this.f20553i + ')';
    }

    public final void u(int i4) {
        this.f20552h = i4;
    }

    public final void v(int i4) {
        this.f20550f = i4;
    }

    public final void w(Context context, int i4) {
        m.e(context, "context");
        this.f20550f = i4;
        t(context);
    }

    public final void x(long j4) {
        this.f20551g = j4;
    }

    public final void y(long j4) {
        this.f20553i = j4;
    }

    public final void z(long j4) {
        this.f20549e = j4;
    }
}
