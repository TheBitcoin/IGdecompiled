package u2;

import R2.n;
import V2.d;
import W1.C1610f;
import W1.s;
import W2.b;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import androidx.core.content.ContextCompat;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.uptodown.R;
import d3.p;
import h2.C2073e;
import h2.C2075g;
import j$.util.DesugarTimeZone;
import j$.util.concurrent.ConcurrentHashMap;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.J;
import o3.Y;

public final class F {

    /* renamed from: a  reason: collision with root package name */
    public static final F f21886a = new F();

    /* renamed from: b  reason: collision with root package name */
    private static C2075g f21887b = new C2075g((Handler) null);

    /* renamed from: c  reason: collision with root package name */
    private static C2073e f21888c = new C2073e((Handler) null);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static ConcurrentHashMap f21889d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private static ArrayList f21890e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private static ArrayList f21891f = new ArrayList();

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21892a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f21893b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f21894c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, Context context, d dVar) {
            super(2, dVar);
            this.f21893b = str;
            this.f21894c = context;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f21893b, this.f21894c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Drawable drawable;
            b.c();
            if (this.f21892a == 0) {
                n.b(obj);
                if (this.f21893b != null && ((Drawable) F.f21889d.get(this.f21893b)) == null) {
                    try {
                        PackageManager packageManager = this.f21894c.getPackageManager();
                        m.d(packageManager, "getPackageManager(...)");
                        drawable = s.d(packageManager, this.f21893b, 0).applicationInfo.loadIcon(this.f21894c.getPackageManager());
                    } catch (Exception unused) {
                        drawable = ContextCompat.getDrawable(this.f21894c, R.drawable.vector_uptodown_logo_disabled);
                    }
                    if (drawable != null) {
                        F.f21889d.put(this.f21893b, drawable);
                    }
                }
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    private F() {
    }

    public final void b(long j4) {
        f21891f.add(Long.valueOf(j4));
    }

    public final void c(long j4) {
        f21890e.add(Long.valueOf(j4));
    }

    public final Spanned d(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned a5 = Html.fromHtml(str, 0);
            m.d(a5, "fromHtml(...)");
            return a5;
        }
        Spanned fromHtml = Html.fromHtml(str);
        m.d(fromHtml, "fromHtml(...)");
        return fromHtml;
    }

    public final String e() {
        DateFormat timeInstance = DateFormat.getTimeInstance();
        timeInstance.setTimeZone(DesugarTimeZone.getTimeZone("gmt"));
        timeInstance.format(new Date(System.currentTimeMillis()));
        Calendar calendar = timeInstance.getCalendar();
        int i4 = (calendar.get(12) * MBridgeCommon.DEFAULT_LOAD_TIMEOUT) + (calendar.get(13) * 1000);
        long timeInMillis = (calendar.getTimeInMillis() - ((long) (i4 + calendar.get(14)))) / ((long) 1000);
        C1610f fVar = C1610f.f8672a;
        return fVar.c("$(=a%·!45J&S" + timeInMillis);
    }

    public final C2073e f() {
        return f21888c;
    }

    public final C2075g g() {
        return f21887b;
    }

    public final boolean h(long j4) {
        return f21891f.contains(Long.valueOf(j4));
    }

    public final boolean i(long j4) {
        return f21890e.contains(Long.valueOf(j4));
    }

    public final boolean j(char c5) {
        if (1424 > c5 || c5 >= 1792) {
            return false;
        }
        return true;
    }

    public final Drawable k(Context context, String str) {
        Drawable drawable;
        m.e(context, "context");
        if (str != null) {
            drawable = (Drawable) f21889d.get(str);
        } else {
            drawable = null;
        }
        if (drawable == null) {
            return ContextCompat.getDrawable(context, R.drawable.vector_uptodown_logo_disabled);
        }
        return drawable;
    }

    public final Object l(Context context, String str, d dVar) {
        Object g4 = C0977g.g(Y.b(), new a(str, context, (d) null), dVar);
        if (g4 == b.c()) {
            return g4;
        }
        return R2.s.f8222a;
    }

    public final void m(long j4) {
        f21890e.remove(Long.valueOf(j4));
    }
}
