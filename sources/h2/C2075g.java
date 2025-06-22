package h2;

import R2.n;
import R2.s;
import V2.d;
import android.app.Activity;
import android.os.Handler;
import android.os.ResultReceiver;
import com.uptodown.activities.AppInstalledDetailsActivity;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import o3.J;

/* renamed from: h2.g  reason: case insensitive filesystem */
public final class C2075g extends ResultReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final a f20847a = new a((C2103g) null);

    /* renamed from: h2.g$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: h2.g$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20848a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f20849b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f20850c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f20851d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Activity activity, int i4, String str, d dVar) {
            super(2, dVar);
            this.f20849b = activity;
            this.f20850c = i4;
            this.f20851d = str;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f20849b, this.f20850c, this.f20851d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f20848a;
            if (i4 == 0) {
                n.b(obj);
                int i5 = this.f20850c;
                String str = this.f20851d;
                this.f20848a = 1;
                if (((AppInstalledDetailsActivity) this.f20849b).z5(i5, str, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C2075g(Handler handler) {
        super(handler);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v12 */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* JADX WARNING: type inference failed for: r5v16 */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r5v18 */
    /* JADX WARNING: type inference failed for: r5v19 */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceiveResult(int r13, android.os.Bundle r14) {
        /*
            r12 = this;
            N1.k$a r0 = N1.k.f7778g
            android.app.Activity r1 = r0.g()
            if (r1 == 0) goto L_0x0101
            android.app.Activity r0 = r0.g()
            boolean r1 = r0 instanceof com.uptodown.activities.Updates
            if (r1 == 0) goto L_0x0016
            com.uptodown.activities.Updates r0 = (com.uptodown.activities.Updates) r0
            r0.Q5(r13, r14)
            return
        L_0x0016:
            boolean r1 = r0 instanceof com.uptodown.activities.MyApps
            r2 = 110(0x6e, float:1.54E-43)
            r3 = 105(0x69, float:1.47E-43)
            java.lang.String r4 = "packagename"
            r5 = 0
            if (r1 == 0) goto L_0x0068
            if (r13 == r3) goto L_0x0049
            if (r13 == r2) goto L_0x003b
            com.uptodown.activities.MyApps r0 = (com.uptodown.activities.MyApps) r0
            boolean r1 = r0.s4()
            if (r1 == 0) goto L_0x0031
            r0.F4(r13)
            return
        L_0x0031:
            if (r14 == 0) goto L_0x0037
            java.lang.String r5 = r14.getString(r4)
        L_0x0037:
            r0.x5(r13, r5)
            return
        L_0x003b:
            r13 = r0
            com.uptodown.activities.MyApps r13 = (com.uptodown.activities.MyApps) r13
            com.uptodown.activities.a$b r14 = new com.uptodown.activities.a$b
            com.uptodown.activities.a r0 = (com.uptodown.activities.C1826a) r0
            r14.<init>()
            r13.runOnUiThread(r14)
            return
        L_0x0049:
            if (r14 == 0) goto L_0x0060
            int r13 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            java.lang.String r2 = "apps_parcelable"
            if (r13 < r1) goto L_0x005b
            java.lang.Class<g2.f> r13 = g2.C2048f.class
            java.util.ArrayList r13 = r14.getParcelableArrayList(r2, r13)
        L_0x0059:
            r5 = r13
            goto L_0x0060
        L_0x005b:
            java.util.ArrayList r13 = r14.getParcelableArrayList(r2)
            goto L_0x0059
        L_0x0060:
            if (r5 == 0) goto L_0x0101
            com.uptodown.activities.MyApps r0 = (com.uptodown.activities.MyApps) r0
            r0.r5(r5)
            return
        L_0x0068:
            boolean r1 = r0 instanceof com.uptodown.activities.AppInstalledDetailsActivity
            if (r1 == 0) goto L_0x009b
            if (r13 == r3) goto L_0x008d
            if (r13 == r2) goto L_0x008d
            if (r14 == 0) goto L_0x0077
            java.lang.String r14 = r14.getString(r4)
            goto L_0x0078
        L_0x0077:
            r14 = r5
        L_0x0078:
            o3.E0 r1 = o3.Y.c()
            o3.J r6 = o3.K.a(r1)
            h2.g$b r9 = new h2.g$b
            r9.<init>(r0, r13, r14, r5)
            r10 = 3
            r11 = 0
            r7 = 0
            r8 = 0
            o3.C1001s0 unused = o3.C0981i.d(r6, r7, r8, r9, r10, r11)
            return
        L_0x008d:
            r13 = r0
            com.uptodown.activities.AppInstalledDetailsActivity r13 = (com.uptodown.activities.AppInstalledDetailsActivity) r13
            com.uptodown.activities.a$b r14 = new com.uptodown.activities.a$b
            com.uptodown.activities.a r0 = (com.uptodown.activities.C1826a) r0
            r14.<init>()
            r13.runOnUiThread(r14)
            return
        L_0x009b:
            boolean r1 = r0 instanceof com.uptodown.activities.MainActivity
            if (r1 == 0) goto L_0x00bd
            r1 = 103(0x67, float:1.44E-43)
            if (r13 != r1) goto L_0x00a9
            r1 = r0
            com.uptodown.activities.MainActivity r1 = (com.uptodown.activities.MainActivity) r1
            r1.Z7()
        L_0x00a9:
            if (r14 == 0) goto L_0x00af
            java.lang.String r5 = r14.getString(r4)
        L_0x00af:
            com.uptodown.activities.MainActivity r0 = (com.uptodown.activities.MainActivity) r0
            com.uptodown.activities.MainActivity$e r14 = new com.uptodown.activities.MainActivity$e
            r14.<init>(r13, r5)
            r0.runOnUiThread(r14)
            r0.c8(r5)
            return
        L_0x00bd:
            boolean r1 = r0 instanceof com.uptodown.activities.AppDetailActivity
            if (r1 == 0) goto L_0x00d2
            if (r14 == 0) goto L_0x00c7
            java.lang.String r5 = r14.getString(r4)
        L_0x00c7:
            com.uptodown.activities.AppDetailActivity r0 = (com.uptodown.activities.AppDetailActivity) r0
            com.uptodown.activities.AppDetailActivity$b r14 = new com.uptodown.activities.AppDetailActivity$b
            r14.<init>(r13, r5)
            r0.runOnUiThread(r14)
            return
        L_0x00d2:
            boolean r13 = r0 instanceof com.uptodown.activities.WishlistActivity
            if (r13 == 0) goto L_0x00e2
            if (r14 == 0) goto L_0x00dc
            java.lang.String r5 = r14.getString(r4)
        L_0x00dc:
            com.uptodown.activities.WishlistActivity r0 = (com.uptodown.activities.WishlistActivity) r0
            r0.r5(r5)
            return
        L_0x00e2:
            boolean r13 = r0 instanceof com.uptodown.activities.RecommendedActivity
            if (r13 == 0) goto L_0x00f2
            if (r14 == 0) goto L_0x00ec
            java.lang.String r5 = r14.getString(r4)
        L_0x00ec:
            com.uptodown.activities.RecommendedActivity r0 = (com.uptodown.activities.RecommendedActivity) r0
            r0.t5(r5)
            return
        L_0x00f2:
            boolean r13 = r0 instanceof com.uptodown.activities.PublicListActivity
            if (r13 == 0) goto L_0x0101
            if (r14 == 0) goto L_0x00fc
            java.lang.String r5 = r14.getString(r4)
        L_0x00fc:
            com.uptodown.activities.PublicListActivity r0 = (com.uptodown.activities.PublicListActivity) r0
            r0.X4(r5)
        L_0x0101:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h2.C2075g.onReceiveResult(int, android.os.Bundle):void");
    }
}
