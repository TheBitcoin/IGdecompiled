package com.uptodown;

import N1.j;
import N1.k;
import R2.n;
import R2.s;
import W1.C1612h;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.UiModeManager;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.NotificationCompat;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.model.ACData;
import com.inmobi.cmp.core.model.GDPRData;
import com.inmobi.cmp.core.model.gbc.GoogleBasicConsents;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.data.model.ChoiceStyle;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.NonIABData;
import com.inmobi.cmp.model.PingReturn;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.activities.C1826a;
import com.uptodown.activities.preferences.a;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.GetUserDataWorker;
import com.uptodown.workers.PreRegisterWorker;
import com.uptodown.workers.SearchApksWorker;
import com.uptodown.workers.TrackingWorker;
import d3.p;
import e2.C1996b;
import f2.M;
import g2.C2048f;
import g2.C2050h;
import g2.C2054l;
import g2.C2060s;
import g2.S;
import g2.U;
import h2.C2069a;
import h2.C2070b;
import h2.C2071c;
import h2.C2076h;
import h2.C2077i;
import h2.C2078j;
import i2.C2083a;
import j2.C2092a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o0.C2172d;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;
import u2.C2312B;
import u2.C2313C;
import u2.F;
import u2.t;
import u2.x;
import u2.y;
import u2.z;
import w2.i;
import y2.h;

public final class UptodownApp extends k implements ChoiceCmpCallback {

    /* renamed from: D  reason: collision with root package name */
    public static final a f17422D = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: E  reason: collision with root package name */
    public static float f17423E = 1.0f;
    /* access modifiers changed from: private */

    /* renamed from: F  reason: collision with root package name */
    public static String f17424F;
    /* access modifiers changed from: private */

    /* renamed from: G  reason: collision with root package name */
    public static String f17425G;
    /* access modifiers changed from: private */

    /* renamed from: H  reason: collision with root package name */
    public static String f17426H;
    /* access modifiers changed from: private */

    /* renamed from: I  reason: collision with root package name */
    public static String f17427I;
    /* access modifiers changed from: private */

    /* renamed from: J  reason: collision with root package name */
    public static String f17428J;
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public static String f17429K;
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public static String f17430L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public static String f17431M;
    /* access modifiers changed from: private */

    /* renamed from: N  reason: collision with root package name */
    public static String f17432N;
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public static int f17433O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public static int f17434P;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public static int f17435Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public static int f17436R;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public static int f17437S;
    /* access modifiers changed from: private */

    /* renamed from: T  reason: collision with root package name */
    public static C1.e f17438T;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public static C1.e f17439U;
    /* access modifiers changed from: private */

    /* renamed from: V  reason: collision with root package name */
    public static final HashMap f17440V = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public static C2078j f17441W = new C2078j((Handler) null);
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public static boolean f17442X;
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public static boolean f17443Y;
    /* access modifiers changed from: private */

    /* renamed from: Z  reason: collision with root package name */
    public static C2054l f17444Z;
    /* access modifiers changed from: private */

    /* renamed from: m0  reason: collision with root package name */
    public static boolean f17445m0;
    /* access modifiers changed from: private */

    /* renamed from: n0  reason: collision with root package name */
    public static final Object f17446n0 = new Object();
    /* access modifiers changed from: private */

    /* renamed from: o0  reason: collision with root package name */
    public static ArrayList f17447o0;
    /* access modifiers changed from: private */

    /* renamed from: p0  reason: collision with root package name */
    public static C2048f f17448p0;
    /* access modifiers changed from: private */

    /* renamed from: q0  reason: collision with root package name */
    public static long f17449q0;
    /* access modifiers changed from: private */

    /* renamed from: r0  reason: collision with root package name */
    public static ArrayList f17450r0;
    /* access modifiers changed from: private */

    /* renamed from: s0  reason: collision with root package name */
    public static final Object f17451s0 = new Object();
    /* access modifiers changed from: private */

    /* renamed from: t0  reason: collision with root package name */
    public static final Object f17452t0 = new Object();
    /* access modifiers changed from: private */

    /* renamed from: u0  reason: collision with root package name */
    public static ArrayList f17453u0 = new ArrayList();

    /* renamed from: A  reason: collision with root package name */
    private C2069a f17454A;

    /* renamed from: B  reason: collision with root package name */
    private C2071c f17455B;

    /* renamed from: C  reason: collision with root package name */
    private C2070b f17456C;

    public static final class a {

        /* renamed from: com.uptodown.UptodownApp$a$a  reason: collision with other inner class name */
        public static final class C0213a implements C2092a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f17457a;

            C0213a(Context context) {
                this.f17457a = context;
            }

            public void a(String str) {
                Bundle bundle = new Bundle();
                bundle.putString("type", "failed");
                new x(this.f17457a).d("uptodown_services_init", bundle);
            }

            public void b() {
                Bundle bundle = new Bundle();
                bundle.putString("type", "success");
                new x(this.f17457a).d("uptodown_services_init", bundle);
            }

            public void c() {
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            Object f17458a;

            /* renamed from: b  reason: collision with root package name */
            int f17459b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f17460c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ boolean f17461d;

            /* renamed from: com.uptodown.UptodownApp$a$b$a  reason: collision with other inner class name */
            static final class C0214a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f17462a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ C f17463b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f17464c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ boolean f17465d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0214a(C c5, String str, boolean z4, V2.d dVar) {
                    super(2, dVar);
                    this.f17463b = c5;
                    this.f17464c = str;
                    this.f17465d = z4;
                }

                public final V2.d create(Object obj, V2.d dVar) {
                    return new C0214a(this.f17463b, this.f17464c, this.f17465d, dVar);
                }

                /* JADX WARNING: Can't fix incorrect switch cases order */
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
                    if (((com.uptodown.activities.AppDetailActivity) r5).q3(r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
                    if (((com.uptodown.activities.MainActivity) r5).T7(r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b2, code lost:
                    if (((com.uptodown.activities.MyApps) r5).a5("app_updated", r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:34:0x00cb, code lost:
                    if (((com.uptodown.activities.Updates) r5).q5("app_updated", r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d9, code lost:
                    if (((com.uptodown.activities.Updates) r5).q5("app_installed", r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ef, code lost:
                    if (((com.uptodown.activities.FreeUpSpaceActivity) r5).m3("app_updated", r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fe, code lost:
                    if (((com.uptodown.activities.FreeUpSpaceActivity) r5).m3("app_installed", r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:50:0x0113, code lost:
                    if (((com.uptodown.activities.AppInstalledDetailsActivity) r5).e5("app_updated", r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:54:0x0126, code lost:
                    if (((com.uptodown.tv.ui.activity.TvAppDetailActivity) r5).m(r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:9:0x0030, code lost:
                    if (((com.uptodown.activities.OldVersionsActivity) r5).V3(r1, r4) == r0) goto L_0x0128;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:20:0x005e  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object invokeSuspend(java.lang.Object r5) {
                    /*
                        r4 = this;
                        java.lang.Object r0 = W2.b.c()
                        int r1 = r4.f17462a
                        switch(r1) {
                            case 0: goto L_0x001a;
                            case 1: goto L_0x0015;
                            case 2: goto L_0x0015;
                            case 3: goto L_0x0011;
                            case 4: goto L_0x0015;
                            case 5: goto L_0x0015;
                            case 6: goto L_0x0015;
                            case 7: goto L_0x0015;
                            case 8: goto L_0x0015;
                            case 9: goto L_0x0015;
                            case 10: goto L_0x0015;
                            default: goto L_0x0009;
                        }
                    L_0x0009:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r0)
                        throw r5
                    L_0x0011:
                        R2.n.b(r5)
                        goto L_0x005a
                    L_0x0015:
                        R2.n.b(r5)
                        goto L_0x014c
                    L_0x001a:
                        R2.n.b(r5)
                        kotlin.jvm.internal.C r5 = r4.f17463b
                        java.lang.Object r5 = r5.f20968a
                        boolean r1 = r5 instanceof com.uptodown.activities.OldVersionsActivity
                        if (r1 == 0) goto L_0x0034
                        com.uptodown.activities.OldVersionsActivity r5 = (com.uptodown.activities.OldVersionsActivity) r5
                        java.lang.String r1 = r4.f17464c
                        r2 = 1
                        r4.f17462a = r2
                        java.lang.Object r5 = r5.V3(r1, r4)
                        if (r5 != r0) goto L_0x014c
                        goto L_0x0128
                    L_0x0034:
                        boolean r1 = r5 instanceof com.uptodown.activities.AppDetailActivity
                        if (r1 == 0) goto L_0x0047
                        com.uptodown.activities.AppDetailActivity r5 = (com.uptodown.activities.AppDetailActivity) r5
                        java.lang.String r1 = r4.f17464c
                        r2 = 2
                        r4.f17462a = r2
                        java.lang.Object r5 = r5.q3(r1, r4)
                        if (r5 != r0) goto L_0x014c
                        goto L_0x0128
                    L_0x0047:
                        boolean r1 = r5 instanceof com.uptodown.activities.MainActivity
                        if (r1 == 0) goto L_0x0095
                        com.uptodown.activities.MainActivity r5 = (com.uptodown.activities.MainActivity) r5
                        java.lang.String r1 = r4.f17464c
                        r2 = 3
                        r4.f17462a = r2
                        java.lang.Object r5 = r5.T7(r1, r4)
                        if (r5 != r0) goto L_0x005a
                        goto L_0x0128
                    L_0x005a:
                        boolean r5 = r4.f17465d
                        if (r5 == 0) goto L_0x0067
                        kotlin.jvm.internal.C r5 = r4.f17463b
                        java.lang.Object r5 = r5.f20968a
                        com.uptodown.activities.MainActivity r5 = (com.uptodown.activities.MainActivity) r5
                        r5.Z7()
                    L_0x0067:
                        kotlin.jvm.internal.C r5 = r4.f17463b
                        java.lang.Object r5 = r5.f20968a
                        com.uptodown.activities.MainActivity r5 = (com.uptodown.activities.MainActivity) r5
                        java.lang.String r0 = r4.f17464c
                        r5.c8(r0)
                        kotlin.jvm.internal.C r5 = r4.f17463b
                        java.lang.Object r5 = r5.f20968a
                        com.uptodown.activities.MainActivity r5 = (com.uptodown.activities.MainActivity) r5
                        java.lang.String r0 = r4.f17464c
                        r5.X7(r0)
                        kotlin.jvm.internal.C r5 = r4.f17463b
                        java.lang.Object r5 = r5.f20968a
                        com.uptodown.activities.MainActivity r5 = (com.uptodown.activities.MainActivity) r5
                        java.lang.String r0 = r4.f17464c
                        r5.a8(r0)
                        kotlin.jvm.internal.C r5 = r4.f17463b
                        java.lang.Object r5 = r5.f20968a
                        com.uptodown.activities.MainActivity r5 = (com.uptodown.activities.MainActivity) r5
                        java.lang.String r0 = r4.f17464c
                        r5.S7(r0)
                        goto L_0x014c
                    L_0x0095:
                        boolean r1 = r5 instanceof com.uptodown.activities.MyDownloads
                        if (r1 == 0) goto L_0x00a1
                        com.uptodown.activities.MyDownloads r5 = (com.uptodown.activities.MyDownloads) r5
                        r0 = 0
                        r5.y4(r0)
                        goto L_0x014c
                    L_0x00a1:
                        boolean r1 = r5 instanceof com.uptodown.activities.MyApps
                        java.lang.String r2 = "app_updated"
                        if (r1 == 0) goto L_0x00b6
                        com.uptodown.activities.MyApps r5 = (com.uptodown.activities.MyApps) r5
                        java.lang.String r1 = r4.f17464c
                        r3 = 4
                        r4.f17462a = r3
                        java.lang.Object r5 = r5.a5(r2, r1, r4)
                        if (r5 != r0) goto L_0x014c
                        goto L_0x0128
                    L_0x00b6:
                        boolean r1 = r5 instanceof com.uptodown.activities.Updates
                        java.lang.String r3 = "app_installed"
                        if (r1 == 0) goto L_0x00dc
                        boolean r1 = r4.f17465d
                        if (r1 == 0) goto L_0x00ce
                        com.uptodown.activities.Updates r5 = (com.uptodown.activities.Updates) r5
                        java.lang.String r1 = r4.f17464c
                        r3 = 5
                        r4.f17462a = r3
                        java.lang.Object r5 = r5.q5(r2, r1, r4)
                        if (r5 != r0) goto L_0x014c
                        goto L_0x0128
                    L_0x00ce:
                        com.uptodown.activities.Updates r5 = (com.uptodown.activities.Updates) r5
                        java.lang.String r1 = r4.f17464c
                        r2 = 6
                        r4.f17462a = r2
                        java.lang.Object r5 = r5.q5(r3, r1, r4)
                        if (r5 != r0) goto L_0x014c
                        goto L_0x0128
                    L_0x00dc:
                        boolean r1 = r5 instanceof com.uptodown.activities.FreeUpSpaceActivity
                        if (r1 == 0) goto L_0x0101
                        boolean r1 = r4.f17465d
                        if (r1 == 0) goto L_0x00f2
                        com.uptodown.activities.FreeUpSpaceActivity r5 = (com.uptodown.activities.FreeUpSpaceActivity) r5
                        java.lang.String r1 = r4.f17464c
                        r3 = 7
                        r4.f17462a = r3
                        java.lang.Object r5 = r5.m3(r2, r1, r4)
                        if (r5 != r0) goto L_0x014c
                        goto L_0x0128
                    L_0x00f2:
                        com.uptodown.activities.FreeUpSpaceActivity r5 = (com.uptodown.activities.FreeUpSpaceActivity) r5
                        java.lang.String r1 = r4.f17464c
                        r2 = 8
                        r4.f17462a = r2
                        java.lang.Object r5 = r5.m3(r3, r1, r4)
                        if (r5 != r0) goto L_0x014c
                        goto L_0x0128
                    L_0x0101:
                        boolean r1 = r5 instanceof com.uptodown.activities.AppInstalledDetailsActivity
                        if (r1 == 0) goto L_0x0116
                        boolean r1 = r4.f17465d
                        if (r1 == 0) goto L_0x014c
                        com.uptodown.activities.AppInstalledDetailsActivity r5 = (com.uptodown.activities.AppInstalledDetailsActivity) r5
                        r1 = 9
                        r4.f17462a = r1
                        java.lang.Object r5 = r5.e5(r2, r4)
                        if (r5 != r0) goto L_0x014c
                        goto L_0x0128
                    L_0x0116:
                        boolean r1 = r5 instanceof com.uptodown.tv.ui.activity.TvAppDetailActivity
                        if (r1 == 0) goto L_0x0129
                        com.uptodown.tv.ui.activity.TvAppDetailActivity r5 = (com.uptodown.tv.ui.activity.TvAppDetailActivity) r5
                        java.lang.String r1 = r4.f17464c
                        r2 = 10
                        r4.f17462a = r2
                        java.lang.Object r5 = r5.m(r1, r4)
                        if (r5 != r0) goto L_0x014c
                    L_0x0128:
                        return r0
                    L_0x0129:
                        boolean r0 = r5 instanceof com.uptodown.activities.WishlistActivity
                        if (r0 == 0) goto L_0x0135
                        com.uptodown.activities.WishlistActivity r5 = (com.uptodown.activities.WishlistActivity) r5
                        java.lang.String r0 = r4.f17464c
                        r5.r5(r0)
                        goto L_0x014c
                    L_0x0135:
                        boolean r0 = r5 instanceof com.uptodown.activities.RecommendedActivity
                        if (r0 == 0) goto L_0x0141
                        com.uptodown.activities.RecommendedActivity r5 = (com.uptodown.activities.RecommendedActivity) r5
                        java.lang.String r0 = r4.f17464c
                        r5.t5(r0)
                        goto L_0x014c
                    L_0x0141:
                        boolean r0 = r5 instanceof com.uptodown.activities.PublicListActivity
                        if (r0 == 0) goto L_0x014c
                        com.uptodown.activities.PublicListActivity r5 = (com.uptodown.activities.PublicListActivity) r5
                        java.lang.String r0 = r4.f17464c
                        r5.X4(r0)
                    L_0x014c:
                        R2.s r5 = R2.s.f8222a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.uptodown.UptodownApp.a.b.C0214a.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                public final Object invoke(J j4, V2.d dVar) {
                    return ((C0214a) create(j4, dVar)).invokeSuspend(s.f8222a);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(String str, boolean z4, V2.d dVar) {
                super(2, dVar);
                this.f17460c = str;
                this.f17461d = z4;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f17460c, this.f17461d, dVar);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:18:0x005c, code lost:
                if (o3.U.b(1000, r7) == r0) goto L_0x0086;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0084, code lost:
                if (o3.C0977g.g(r1, r3, r7) == r0) goto L_0x0086;
             */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x0068  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    java.lang.Object r0 = W2.b.c()
                    int r1 = r7.f17459b
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L_0x002e
                    if (r1 == r4) goto L_0x0026
                    if (r1 == r3) goto L_0x001e
                    if (r1 != r2) goto L_0x0016
                    R2.n.b(r8)
                    goto L_0x0087
                L_0x0016:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L_0x001e:
                    java.lang.Object r1 = r7.f17458a
                    kotlin.jvm.internal.C r1 = (kotlin.jvm.internal.C) r1
                    R2.n.b(r8)
                    goto L_0x005f
                L_0x0026:
                    java.lang.Object r1 = r7.f17458a
                    kotlin.jvm.internal.C r1 = (kotlin.jvm.internal.C) r1
                    R2.n.b(r8)
                    goto L_0x0052
                L_0x002e:
                    R2.n.b(r8)
                    kotlin.jvm.internal.C r8 = new kotlin.jvm.internal.C
                    r8.<init>()
                    N1.k$a r1 = N1.k.f7778g
                    android.app.Activity r1 = r1.g()
                    r8.f20968a = r1
                    if (r1 == 0) goto L_0x0060
                    boolean r5 = r1 instanceof com.uptodown.core.activities.InstallerActivity
                    if (r5 == 0) goto L_0x0060
                    com.uptodown.core.activities.InstallerActivity r1 = (com.uptodown.core.activities.InstallerActivity) r1
                    r7.f17458a = r8
                    r7.f17459b = r4
                    java.lang.Object r1 = r1.d2(r4, r7)
                    if (r1 != r0) goto L_0x0051
                    goto L_0x0086
                L_0x0051:
                    r1 = r8
                L_0x0052:
                    r7.f17458a = r1
                    r7.f17459b = r3
                    r3 = 1000(0x3e8, double:4.94E-321)
                    java.lang.Object r8 = o3.U.b(r3, r7)
                    if (r8 != r0) goto L_0x005f
                    goto L_0x0086
                L_0x005f:
                    r8 = r1
                L_0x0060:
                    N1.k$a r1 = N1.k.f7778g
                    android.app.Activity r3 = r1.g()
                    if (r3 == 0) goto L_0x0087
                    android.app.Activity r1 = r1.g()
                    r8.f20968a = r1
                    o3.E0 r1 = o3.Y.c()
                    com.uptodown.UptodownApp$a$b$a r3 = new com.uptodown.UptodownApp$a$b$a
                    java.lang.String r4 = r7.f17460c
                    boolean r5 = r7.f17461d
                    r6 = 0
                    r3.<init>(r8, r4, r5, r6)
                    r7.f17458a = r6
                    r7.f17459b = r2
                    java.lang.Object r8 = o3.C0977g.g(r1, r3, r7)
                    if (r8 != r0) goto L_0x0087
                L_0x0086:
                    return r0
                L_0x0087:
                    R2.s r8 = R2.s.f8222a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uptodown.UptodownApp.a.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private final void N0(Context context, boolean z4) {
            Data build = new Data.Builder().putBoolean("isCompressed", z4).build();
            m.d(build, "build(...)");
            Constraints build2 = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            WorkManager.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(TrackingWorker.class).addTag("TrackingWorkerSingle")).setBackoffCriteria(BackoffPolicy.LINEAR, 1, TimeUnit.MINUTES)).setInputData(build)).setConstraints(build2)).build());
        }

        public static /* synthetic */ boolean P0(a aVar, Context context, boolean z4, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                z4 = true;
            }
            return aVar.O0(context, z4);
        }

        public static /* synthetic */ void W(a aVar, File file, Context context, String str, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                str = null;
            }
            aVar.V(file, context, str);
        }

        public static /* synthetic */ void Y(a aVar, File file, Context context, String str, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                str = null;
            }
            aVar.X(file, context, str);
        }

        private final void Z(File file, Context context) {
            t a5 = t.f21927u.a(context);
            a5.a();
            String name = file.getName();
            m.d(name, "getName(...)");
            C2060s d02 = a5.d0(name);
            a5.i();
            Bundle bundle = new Bundle();
            if (d02 != null) {
                if (d02.w() != null) {
                    y yVar = y.f21955a;
                    String w4 = d02.w();
                    m.b(w4);
                    bundle = yVar.b(context, w4, bundle);
                    bundle.putString("packagename", d02.w());
                }
                if (((C2060s.c) d02.o().get(0)).d() > 0) {
                    bundle.putString("fileId", String.valueOf(((C2060s.c) d02.o().get(0)).d()));
                }
            }
            bundle.putString("type", "start");
            new x(context).d("install", bundle);
        }

        private final int d(float f4) {
            return (int) (f4 * UptodownApp.f17423E);
        }

        private final boolean g0(String str) {
            boolean z4;
            synchronized (UptodownApp.f17446n0) {
                z4 = false;
                if (UptodownApp.f17447o0 != null) {
                    ArrayList C02 = UptodownApp.f17447o0;
                    m.b(C02);
                    int size = C02.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size) {
                            break;
                        }
                        ArrayList C03 = UptodownApp.f17447o0;
                        m.b(C03);
                        if (m3.m.p(str, ((C2048f) C03.get(i4)).o(), true)) {
                            ArrayList C04 = UptodownApp.f17447o0;
                            m.b(C04);
                            C04.remove(i4);
                            z4 = true;
                            break;
                        }
                        i4++;
                    }
                }
            }
            return z4;
        }

        private final void n0(Context context) {
            Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            TimeUnit timeUnit = TimeUnit.MINUTES;
            WorkManager.getInstance(context).enqueue((WorkRequest) (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) TrackingWorker.class, 30, timeUnit).addTag("TrackingWorkerPeriodic")).setBackoffCriteria(BackoffPolicy.LINEAR, 1, timeUnit)).setConstraints(build)).build());
        }

        public final String A() {
            return UptodownApp.f17429K;
        }

        public final void A0(String str) {
            UptodownApp.f17425G = str;
        }

        public final C2078j B() {
            return UptodownApp.f17441W;
        }

        public final void B0(String str) {
            UptodownApp.f17424F = str;
        }

        public final C2048f C() {
            return UptodownApp.f17448p0;
        }

        public final void C0(ArrayList arrayList) {
            UptodownApp.f17450r0 = arrayList;
        }

        public final ArrayList D() {
            ArrayList A02;
            synchronized (UptodownApp.f17452t0) {
                A02 = UptodownApp.f17453u0;
            }
            return A02;
        }

        public final void D0(boolean z4) {
            UptodownApp.f17442X = z4;
        }

        public final ArrayList E() {
            ArrayList C02;
            synchronized (UptodownApp.f17446n0) {
                C02 = UptodownApp.f17447o0;
            }
            return C02;
        }

        public final void E0(int i4) {
            UptodownApp.f17434P = i4;
        }

        public final int F() {
            return UptodownApp.f17437S;
        }

        public final void F0(int i4) {
            UptodownApp.f17433O = i4;
        }

        /* JADX WARNING: Removed duplicated region for block: B:3:0x0023 A[LOOP:0: B:3:0x0023->B:8:0x0039, LOOP_START, PHI: r0 
          PHI: (r0v2 androidx.work.WorkInfo$State) = (r0v0 androidx.work.WorkInfo$State), (r0v3 androidx.work.WorkInfo$State) binds: [B:2:0x0004, B:8:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.work.WorkInfo.State G(java.lang.String r3, android.content.Context r4) {
            /*
                r2 = this;
                androidx.work.WorkInfo$State r0 = androidx.work.WorkInfo.State.SUCCEEDED
                if (r4 == 0) goto L_0x003b
                androidx.work.WorkManager r4 = androidx.work.WorkManager.getInstance(r4)
                java.lang.String r1 = "getInstance(...)"
                kotlin.jvm.internal.m.d(r4, r1)
                kotlin.jvm.internal.m.b(r3)
                o0.d r3 = r4.getWorkInfosByTag(r3)
                java.lang.String r4 = "getWorkInfosByTag(...)"
                kotlin.jvm.internal.m.d(r3, r4)
                java.lang.Object r3 = r3.get()
                java.util.List r3 = (java.util.List) r3
                java.util.Iterator r3 = r3.iterator()
            L_0x0023:
                boolean r4 = r3.hasNext()
                if (r4 == 0) goto L_0x003b
                java.lang.Object r4 = r3.next()
                androidx.work.WorkInfo r4 = (androidx.work.WorkInfo) r4
                androidx.work.WorkInfo$State r0 = r4.getState()
                androidx.work.WorkInfo$State r4 = androidx.work.WorkInfo.State.RUNNING
                if (r0 == r4) goto L_0x003b
                androidx.work.WorkInfo$State r4 = androidx.work.WorkInfo.State.ENQUEUED
                if (r0 != r4) goto L_0x0023
            L_0x003b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.UptodownApp.a.G(java.lang.String, android.content.Context):androidx.work.WorkInfo$State");
        }

        public final void G0(int i4) {
            UptodownApp.f17435Q = i4;
        }

        public final HashMap H() {
            return UptodownApp.f17440V;
        }

        public final void H0(int i4) {
            UptodownApp.f17436R = i4;
        }

        public final void I(Context context) {
            m.e(context, "context");
            if (com.uptodown.activities.preferences.a.f18818a.i0(context)) {
                new C2083a(context).c("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ2YWx1ZSI6IjRhOTRiN2I1MTk1NGVkNGMyMjZjZGM1MGMxZDE5Yjk2MTY4MzY5OTE1NCJ9.1j7HuORIuuZDp0wTf1f9A__sAHEnqaGDiuCNY5OQXYN", new C0213a(context));
            }
        }

        public final void I0(String str) {
            UptodownApp.f17430L = str;
        }

        public final boolean J() {
            return UptodownApp.f17443Y;
        }

        public final void J0(String str) {
            UptodownApp.f17429K = str;
        }

        public final boolean K() {
            return false;
        }

        public final void K0(C2048f fVar) {
            UptodownApp.f17448p0 = fVar;
        }

        public final boolean L(String str) {
            if (m() == null) {
                return false;
            }
            C2054l m4 = m();
            m.b(m4);
            if (m3.m.p(m4.d(), str, true)) {
                return true;
            }
            return false;
        }

        public final void L0(ArrayList arrayList) {
            synchronized (UptodownApp.f17446n0) {
                UptodownApp.f17447o0 = arrayList;
                s sVar = s.f8222a;
            }
        }

        public final boolean M() {
            return UptodownApp.f17445m0;
        }

        public final void M0(int i4) {
            UptodownApp.f17437S = i4;
        }

        public final boolean N(Context context) {
            m.e(context, "context");
            return U("DownloadUpdatesWorker", context);
        }

        public final boolean O(S s4) {
            boolean z4;
            m.e(s4, "update");
            synchronized (UptodownApp.f17452t0) {
                Iterator it = UptodownApp.f17453u0.iterator();
                m.d(it, "iterator(...)");
                while (true) {
                    if (!it.hasNext()) {
                        z4 = false;
                        break;
                    }
                    Object next = it.next();
                    m.d(next, "next(...)");
                    z4 = true;
                    if (m3.m.p(((S) next).h(), s4.h(), true)) {
                        break;
                    }
                }
            }
            return z4;
        }

        public final boolean O0(Context context, boolean z4) {
            m.e(context, "context");
            if (U("TrackingWorkerSingle", context) || T("TrackingWorkerPeriodic", context) || T("GenerateQueueWorker", context) || T("DownloadUpdatesWorker", context)) {
                return false;
            }
            N0(context, z4);
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean P(java.lang.String r7) {
            /*
                r6 = this;
                java.lang.String r0 = "packagename"
                kotlin.jvm.internal.m.e(r7, r0)
                java.lang.Object r0 = com.uptodown.UptodownApp.f17446n0
                monitor-enter(r0)
                java.util.ArrayList r1 = com.uptodown.UptodownApp.f17447o0     // Catch:{ all -> 0x003c }
                r2 = 0
                if (r1 == 0) goto L_0x003e
                java.util.ArrayList r1 = com.uptodown.UptodownApp.f17447o0     // Catch:{ all -> 0x003c }
                kotlin.jvm.internal.m.b(r1)     // Catch:{ all -> 0x003c }
                int r1 = r1.size()     // Catch:{ all -> 0x003c }
                r3 = 0
            L_0x001d:
                if (r3 >= r1) goto L_0x003e
                java.util.ArrayList r4 = com.uptodown.UptodownApp.f17447o0     // Catch:{ all -> 0x003c }
                kotlin.jvm.internal.m.b(r4)     // Catch:{ all -> 0x003c }
                java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x003c }
                g2.f r4 = (g2.C2048f) r4     // Catch:{ all -> 0x003c }
                java.lang.String r4 = r4.o()     // Catch:{ all -> 0x003c }
                r5 = 1
                boolean r4 = m3.m.p(r7, r4, r5)     // Catch:{ all -> 0x003c }
                if (r4 == 0) goto L_0x0039
                monitor-exit(r0)
                return r5
            L_0x0039:
                int r3 = r3 + 1
                goto L_0x001d
            L_0x003c:
                r7 = move-exception
                goto L_0x0040
            L_0x003e:
                monitor-exit(r0)
                return r2
            L_0x0040:
                monitor-exit(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.UptodownApp.a.P(java.lang.String):boolean");
        }

        public final boolean Q() {
            return false;
        }

        public final Object Q0(String str, boolean z4, V2.d dVar) {
            Object g4 = C0977g.g(Y.b(), new b(str, z4, (V2.d) null), dVar);
            if (g4 == W2.b.c()) {
                return g4;
            }
            return s.f8222a;
        }

        public final boolean R(Context context) {
            m.e(context, "context");
            try {
                PackageManager packageManager = context.getPackageManager();
                m.d(packageManager, "getPackageManager(...)");
                return new C1612h().r(W1.s.d(packageManager, "com.npg.smarttvnpg", 4096));
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        }

        public final boolean S(Context context) {
            m.e(context, "context");
            Object systemService = context.getSystemService("uimode");
            m.c(systemService, "null cannot be cast to non-null type android.app.UiModeManager");
            if (((UiModeManager) systemService).getCurrentModeType() == 4 || R(context)) {
                return true;
            }
            return false;
        }

        public final boolean T(String str, Context context) {
            m.e(context, "context");
            WorkManager instance = WorkManager.getInstance(context);
            m.d(instance, "getInstance(...)");
            m.b(str);
            C2172d workInfosByTag = instance.getWorkInfosByTag(str);
            m.d(workInfosByTag, "getWorkInfosByTag(...)");
            for (WorkInfo state : (List) workInfosByTag.get()) {
                if (state.getState() == WorkInfo.State.RUNNING) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:4:0x0027  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean U(java.lang.String r2, android.content.Context r3) {
            /*
                r1 = this;
                if (r3 == 0) goto L_0x003b
                androidx.work.WorkManager r3 = androidx.work.WorkManager.getInstance(r3)
                java.lang.String r0 = "getInstance(...)"
                kotlin.jvm.internal.m.d(r3, r0)
                kotlin.jvm.internal.m.b(r2)
                o0.d r2 = r3.getWorkInfosByTag(r2)
                java.lang.String r3 = "getWorkInfosByTag(...)"
                kotlin.jvm.internal.m.d(r2, r3)
                java.lang.Object r2 = r2.get()
                java.util.List r2 = (java.util.List) r2
                java.util.Iterator r2 = r2.iterator()
            L_0x0021:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L_0x003b
                java.lang.Object r3 = r2.next()
                androidx.work.WorkInfo r3 = (androidx.work.WorkInfo) r3
                androidx.work.WorkInfo$State r3 = r3.getState()
                androidx.work.WorkInfo$State r0 = androidx.work.WorkInfo.State.RUNNING
                if (r3 == r0) goto L_0x0039
                androidx.work.WorkInfo$State r0 = androidx.work.WorkInfo.State.ENQUEUED
                if (r3 != r0) goto L_0x0021
            L_0x0039:
                r2 = 1
                return r2
            L_0x003b:
                r2 = 0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.UptodownApp.a.U(java.lang.String, android.content.Context):boolean");
        }

        public final void V(File file, Context context, String str) {
            m.e(file, "item");
            m.e(context, "context");
            k.a aVar = k.f7778g;
            if (aVar.i() == null && aVar.j() == null) {
                new j(context).a(file, str, new u2.m().y(context));
                Z(file, context);
                return;
            }
            String string = context.getString(R.string.core_installation_in_progress_msg);
            m.d(string, "getString(...)");
            ((C1826a) context).q0(string);
        }

        public final void X(File file, Context context, String str) {
            m.e(file, "item");
            m.e(context, "context");
            new j(context).c(file, str, new u2.m().y(context));
            Z(file, context);
        }

        public final Bundle a(Activity activity) {
            m.e(activity, "<this>");
            if (!com.uptodown.activities.preferences.a.f18818a.N(activity) || UptodownApp.f17422D.Q()) {
                return null;
            }
            return ActivityOptions.makeCustomAnimation(activity, R.anim.left_to_right_in, R.anim.fade_out).toBundle();
        }

        public final boolean a0() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - UptodownApp.f17449q0 <= 600) {
                return false;
            }
            UptodownApp.f17449q0 = currentTimeMillis;
            return true;
        }

        public final ActivityOptionsCompat b(Activity activity) {
            m.e(activity, "<this>");
            if (!com.uptodown.activities.preferences.a.f18818a.N(activity) || UptodownApp.f17422D.Q()) {
                return null;
            }
            return ActivityOptionsCompat.makeCustomAnimation(activity, R.anim.left_to_right_in, R.anim.fade_out);
        }

        public final void b0(C2060s sVar, C2050h hVar, C1826a aVar, d3.l lVar, d3.a aVar2) {
            m.e(sVar, "download");
            m.e(hVar, "appInfo");
            m.e(aVar, "activity");
            m.e(lVar, "successBehavior");
            m.e(aVar2, "failedBehaviour");
            sVar.d(hVar);
            int Q4 = sVar.Q(aVar);
            if (Q4 >= 0) {
                String L4 = hVar.L();
                m.b(L4);
                aVar.I2(Q4, L4);
                lVar.invoke(Integer.valueOf(Q4));
                return;
            }
            aVar.q0(aVar.getString(R.string.error_cant_enqueue_download) + " (108)");
            aVar2.invoke();
        }

        public final ArrayList c(C2048f fVar) {
            ArrayList C02;
            m.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            synchronized (UptodownApp.f17446n0) {
                try {
                    if (UptodownApp.f17447o0 != null) {
                        ArrayList C03 = UptodownApp.f17447o0;
                        m.b(C03);
                        C03.add(fVar);
                    } else {
                        UptodownApp.f17447o0 = new ArrayList();
                        ArrayList C04 = UptodownApp.f17447o0;
                        m.b(C04);
                        C04.add(fVar);
                    }
                    C02 = UptodownApp.f17447o0;
                    m.b(C02);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return C02;
        }

        public final int c0(C2050h hVar, C1826a aVar) {
            m.e(hVar, "appInfo");
            m.e(aVar, "activity");
            C2060s sVar = new C2060s();
            sVar.d(hVar);
            int Q4 = sVar.Q(aVar);
            if (Q4 >= 0) {
                String L4 = hVar.L();
                m.b(L4);
                aVar.I2(Q4, L4);
                return Q4;
            }
            aVar.q0(aVar.getString(R.string.error_cant_enqueue_download) + " (108)");
            return Q4;
        }

        public final C2060s d0(C2050h hVar, Context context) {
            m.e(hVar, "appInfo");
            m.e(context, "context");
            C2060s sVar = new C2060s();
            sVar.d(hVar);
            int Q4 = sVar.Q(context);
            if (Q4 >= 0 && z.f21956a.d()) {
                DownloadApkWorker.f19447i.c(context, Q4);
            }
            return sVar;
        }

        public final void e(Context context) {
            m.e(context, "context");
            int i4 = context.getResources().getDisplayMetrics().widthPixels;
            if (!m3.m.p(context.getString(R.string.screen_type), "phone", true)) {
                i4 = 1024;
            }
            M0((int) (((float) i4) - (((float) 4) * context.getResources().getDimension(R.dimen.margin_m))));
            F0((int) (((double) F()) / 2.048d));
            E0((int) (((double) i4) / 2.048d));
            float f4 = context.getResources().getDisplayMetrics().density;
            int i5 = context.getResources().getDisplayMetrics().heightPixels;
            float dimension = context.getResources().getDimension(R.dimen.icon_size_xl);
            float dimension2 = context.getResources().getDimension(R.dimen.icon_size_l);
            float dimension3 = context.getResources().getDimension(R.dimen.gallery_height);
            float dimension4 = context.getResources().getDimension(R.dimen.user_avatar_profile_size);
            float dimension5 = context.getResources().getDimension(R.dimen.user_avatar_review_size);
            float dimension6 = context.getResources().getDimension(R.dimen.gallery_feature_horizontal_height);
            UptodownApp.f17423E = i.f22032a.c(context) / f4;
            StringBuilder sb = new StringBuilder();
            sb.append(':');
            sb.append(d(dimension));
            A0(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(':');
            sb2.append(d(dimension2));
            B0(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(':');
            sb3.append(d(dimension4));
            p0(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(':');
            sb4.append(d(dimension5));
            q0(sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append(':');
            sb5.append(d(dimension3));
            J0(sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(':');
            sb6.append(d((float) i5));
            I0(sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append(':');
            sb7.append(d((float) v()));
            y0(sb7.toString());
            StringBuilder sb8 = new StringBuilder();
            sb8.append(':');
            sb8.append(d((float) w()));
            x0(sb8.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append(':');
            sb9.append(d(dimension6));
            z0(sb9.toString());
        }

        public final void e0(S s4) {
            m.e(s4, "update");
            synchronized (UptodownApp.f17452t0) {
                try {
                    Iterator it = UptodownApp.f17453u0.iterator();
                    int i4 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i4 = -1;
                            break;
                        }
                        int i5 = i4 + 1;
                        if (m3.m.p(((S) it.next()).h(), s4.h(), true)) {
                            break;
                        }
                        i4 = i5;
                    }
                    if (i4 >= 0 && i4 < UptodownApp.f17453u0.size()) {
                        UptodownApp.f17453u0.remove(i4);
                    }
                    s sVar = s.f8222a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final boolean f(Context context) {
            m.e(context, "context");
            a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
            if ((aVar.f(context) != 0 || !z.f21956a.f()) && aVar.f(context) != 1) {
                return false;
            }
            return true;
        }

        public final void f0(String str) {
            m.e(str, "packagename");
            if (g0(str)) {
                Bundle bundle = new Bundle();
                bundle.putString("packagename", str);
                F.f21886a.g().send(106, bundle);
            }
        }

        public final void g() {
            synchronized (UptodownApp.f17446n0) {
                UptodownApp.f17447o0 = null;
                s sVar = s.f8222a;
            }
        }

        public final Object h() {
            return UptodownApp.f17451s0;
        }

        public final h h0(Context context) {
            m.e(context, "context");
            return new h((int) context.getResources().getDimension(R.dimen.border_radius_m), (h.a) null, 2, (C2103g) null);
        }

        public final String i() {
            return UptodownApp.f17431M;
        }

        public final h i0(Context context) {
            m.e(context, "context");
            if (com.uptodown.activities.preferences.a.f18818a.k(context) <= 0 || !z.f21956a.c()) {
                return new h((int) context.getResources().getDimension(R.dimen.border_radius_xs), (h.a) null, 2, (C2103g) null);
            }
            return new h((int) context.getResources().getDimension(R.dimen.border_radius_m), (h.a) null, 2, (C2103g) null);
        }

        public final String j() {
            return UptodownApp.f17432N;
        }

        public final h j0(Context context) {
            m.e(context, "context");
            if (com.uptodown.activities.preferences.a.f18818a.k(context) <= 0 || !z.f21956a.c()) {
                return new h((int) context.getResources().getDimension(R.dimen.border_radius_xs), (h.a) null, 2, (C2103g) null);
            }
            return new h((int) context.getResources().getDimension(R.dimen.border_radius_s), (h.a) null, 2, (C2103g) null);
        }

        public final C1.e k() {
            return UptodownApp.f17438T;
        }

        public final h k0(Context context) {
            m.e(context, "context");
            return new h((int) context.getResources().getDimension(R.dimen.border_radius_s), (h.a) null, 2, (C2103g) null);
        }

        public final C1.e l() {
            return UptodownApp.f17439U;
        }

        public final void l0(Context context) {
            m.e(context, "context");
            if (!U("GetUserDataWorker", context)) {
                WorkManager instance = WorkManager.getInstance(context);
                instance.enqueue((WorkRequest) (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) GetUserDataWorker.class, 24, TimeUnit.HOURS).addTag("GetUserDataWorker")).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())).build());
            }
        }

        public final C2054l m() {
            return UptodownApp.f17444Z;
        }

        public final void m0(Context context) {
            m.e(context, "context");
            if (!U("PreRegisterWorker", context)) {
                WorkManager instance = WorkManager.getInstance(context);
                instance.enqueue((WorkRequest) (PeriodicWorkRequest) ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) PreRegisterWorker.class, 4, TimeUnit.HOURS).addTag("PreRegisterWorker")).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())).build());
            }
        }

        public final String n() {
            return UptodownApp.f17427I;
        }

        public final String o() {
            return UptodownApp.f17426H;
        }

        public final void o0(Context context) {
            m.e(context, "context");
            if (!U("TrackingWorkerPeriodic", context)) {
                n0(context);
            }
        }

        public final String p() {
            return UptodownApp.f17428J;
        }

        public final void p0(String str) {
            UptodownApp.f17431M = str;
        }

        public final String q() {
            return UptodownApp.f17425G;
        }

        public final void q0(String str) {
            UptodownApp.f17432N = str;
        }

        public final String r() {
            return UptodownApp.f17424F;
        }

        public final void r0(C1.e eVar) {
            UptodownApp.f17438T = eVar;
        }

        public final C2048f s() {
            C2048f fVar;
            synchronized (UptodownApp.f17446n0) {
                if (UptodownApp.f17447o0 != null) {
                    ArrayList C02 = UptodownApp.f17447o0;
                    m.b(C02);
                    if (C02.size() > 0) {
                        ArrayList C03 = UptodownApp.f17447o0;
                        m.b(C03);
                        fVar = (C2048f) C03.remove(0);
                    }
                }
                fVar = null;
            }
            return fVar;
        }

        public final void s0(C1.e eVar) {
            UptodownApp.f17439U = eVar;
        }

        public final ArrayList t() {
            return UptodownApp.f17450r0;
        }

        public final void t0(boolean z4) {
            UptodownApp.f17443Y = z4;
        }

        public final boolean u() {
            return UptodownApp.f17442X;
        }

        public final void u0(C2054l lVar) {
            UptodownApp.f17444Z = lVar;
        }

        public final int v() {
            return UptodownApp.f17434P;
        }

        public final void v0(boolean z4) {
            UptodownApp.f17445m0 = z4;
        }

        public final int w() {
            return UptodownApp.f17433O;
        }

        public final void w0(S s4) {
            m.e(s4, "update");
            synchronized (UptodownApp.f17452t0) {
                try {
                    Iterator it = UptodownApp.f17453u0.iterator();
                    m.d(it, "iterator(...)");
                    while (true) {
                        if (!it.hasNext()) {
                            UptodownApp.f17453u0.add(s4);
                            break;
                        }
                        Object next = it.next();
                        m.d(next, "next(...)");
                        if (m3.m.p(((S) next).h(), s4.h(), true)) {
                            break;
                        }
                    }
                    s sVar = s.f8222a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final int x() {
            return UptodownApp.f17435Q;
        }

        public final void x0(String str) {
            UptodownApp.f17427I = str;
        }

        public final int y() {
            return UptodownApp.f17436R;
        }

        public final void y0(String str) {
            UptodownApp.f17426H = str;
        }

        public final String z() {
            return UptodownApp.f17430L;
        }

        public final void z0(String str) {
            UptodownApp.f17428J = str;
        }

        private a() {
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17466a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UptodownApp f17467b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(UptodownApp uptodownApp, V2.d dVar) {
            super(2, dVar);
            this.f17467b = uptodownApp;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f17467b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17466a == 0) {
                n.b(obj);
                t a5 = t.f21927u.a(this.f17467b);
                a5.a();
                Iterator it = a5.m0().iterator();
                m.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    C2060s sVar = (C2060s) next;
                    if (sVar.w() == null || sVar.E() == 0) {
                        a5.z(sVar);
                    } else if (!sVar.o().isEmpty()) {
                        Iterator it2 = sVar.o().iterator();
                        m.d(it2, "iterator(...)");
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            Object next2 = it2.next();
                            m.d(next2, "next(...)");
                            if (((C2060s.c) next2).d() <= 0) {
                                a5.z(sVar);
                                break;
                            }
                        }
                    }
                }
                a5.i();
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17468a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UptodownApp f17469b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f17470c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(UptodownApp uptodownApp, e eVar, V2.d dVar) {
            super(2, dVar);
            this.f17469b = uptodownApp;
            this.f17470c = eVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f17469b, this.f17470c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17468a;
            if (i4 == 0) {
                n.b(obj);
                GetUserDataWorker.a aVar = GetUserDataWorker.f19472b;
                Context applicationContext = this.f17469b.getApplicationContext();
                m.d(applicationContext, "getApplicationContext(...)");
                e eVar = this.f17470c;
                this.f17468a = 1;
                if (aVar.a(applicationContext, eVar, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17471a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UptodownApp f17472b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(UptodownApp uptodownApp, V2.d dVar) {
            super(2, dVar);
            this.f17472b = uptodownApp;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f17472b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17471a;
            if (i4 == 0) {
                n.b(obj);
                UptodownApp uptodownApp = this.f17472b;
                this.f17471a = 1;
                if (uptodownApp.h1(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class e implements M {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UptodownApp f17473a;

        e(UptodownApp uptodownApp) {
            this.f17473a = uptodownApp;
        }

        public void a() {
            U.b bVar = U.f20468m;
            Context applicationContext = this.f17473a.getApplicationContext();
            m.d(applicationContext, "getApplicationContext(...)");
            if (bVar.e(applicationContext) != null) {
                a aVar = UptodownApp.f17422D;
                Context applicationContext2 = this.f17473a.getApplicationContext();
                m.d(applicationContext2, "getApplicationContext(...)");
                aVar.l0(applicationContext2);
                Context applicationContext3 = this.f17473a.getApplicationContext();
                m.d(applicationContext3, "getApplicationContext(...)");
                aVar.m0(applicationContext3);
            }
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17474a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UptodownApp f17475b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(UptodownApp uptodownApp, V2.d dVar) {
            super(2, dVar);
            this.f17475b = uptodownApp;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f17475b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17474a;
            if (i4 == 0) {
                n.b(obj);
                UptodownApp uptodownApp = this.f17475b;
                this.f17474a = 1;
                if (uptodownApp.m1(uptodownApp, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17476a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f17477b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Context context, V2.d dVar) {
            super(2, dVar);
            this.f17477b = context;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f17477b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17476a;
            if (i4 == 0) {
                n.b(obj);
                ArrayList B4 = new u2.m().B(this.f17477b);
                u2.m mVar = new u2.m();
                Context context = this.f17477b;
                this.f17476a = 1;
                if (mVar.f(B4, context, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public final Object h1(V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    private final void i1() {
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = getSystemService("notification");
            m.c(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            String string = getString(R.string.app_name);
            m.d(string, "getString(...)");
            String string2 = getString(R.string.notification_channel_description);
            m.d(string2, "getString(...)");
            NotificationChannel a5 = androidx.browser.trusted.h.a("CHANNEL_ID_UPTODOWN", string, 3);
            a5.setSound((Uri) null, (AudioAttributes) null);
            a5.setDescription(string2);
            a5.enableLights(true);
            ((NotificationManager) systemService).createNotificationChannel(a5);
        }
    }

    private final void j1(boolean z4, String str) {
        Bundle bundle = new Bundle();
        if (z4) {
            bundle.putString("type", "accepted");
        } else {
            bundle.putString("type", "rejected");
        }
        bundle.putString("consent_version", str);
        new x(this).d("user_consent_mintegral", bundle);
    }

    private final void k1() {
        if (com.uptodown.activities.preferences.a.f18818a.l0(this)) {
            U e5 = U.f20468m.e(this);
            if (e5 == null || !e5.n()) {
                String packageName = getPackageName();
                m.d(packageName, "getPackageName(...)");
                ChoiceCmp.startChoice$default(this, packageName, "p-PLc5NudJ4X36X", this, (ChoiceStyle) null, 16, (Object) null);
            }
        }
    }

    private final void l1() {
        C1001s0 unused = C0981i.d(K.a(Y.b()), (V2.g) null, (L) null, new f(this, (V2.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object m1(Context context, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new g(context, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    private final void n1() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        C2069a aVar = new C2069a();
        this.f17454A = aVar;
        registerReceiver(aVar, intentFilter);
    }

    private final void o1() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        C2070b bVar = new C2070b();
        this.f17456C = bVar;
        registerReceiver(bVar, intentFilter);
    }

    private final void p1() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        C2071c cVar = new C2071c();
        this.f17455B = cVar;
        registerReceiver(cVar, intentFilter);
    }

    private final void q1(Context context) {
        if (!f17422D.U("SearchApksWorker", context)) {
            WorkManager.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(SearchApksWorker.class).addTag("SearchApksWorker")).build());
        }
    }

    private final void r1() {
        try {
            C2069a aVar = this.f17454A;
            if (aVar != null) {
                unregisterReceiver(aVar);
                this.f17454A = null;
            }
            C2071c cVar = this.f17455B;
            if (cVar != null) {
                unregisterReceiver(cVar);
                this.f17455B = null;
            }
            C2070b bVar = this.f17456C;
            if (bVar != null) {
                unregisterReceiver(bVar);
                this.f17456C = null;
            }
        } catch (IllegalArgumentException e5) {
            e5.printStackTrace();
        }
    }

    public void Q(String str) {
        m.e(str, NotificationCompat.CATEGORY_EVENT);
    }

    public void onCCPAConsentGiven(String str) {
        m.e(str, "consentString");
    }

    public void onCmpError(ChoiceError choiceError) {
        m.e(choiceError, CampaignEx.JSON_NATIVE_VIDEO_ERROR);
    }

    public void onCmpLoaded(PingReturn pingReturn) {
        m.e(pingReturn, "info");
    }

    public void onCmpUIShown(PingReturn pingReturn) {
        m.e(pingReturn, "info");
    }

    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        new x(this).b();
        a aVar = f17422D;
        aVar.I(this);
        new C1996b().b();
        new C2312B(this).c();
        n1();
        p1();
        o1();
        int i4 = getResources().getConfiguration().uiMode & 48;
        a.C0236a aVar2 = com.uptodown.activities.preferences.a.f18818a;
        String j4 = aVar2.j(this);
        if (m3.m.p(j4, "yes", true)) {
            if (i4 != 32) {
                AppCompatDelegate.setDefaultNightMode(2);
            }
        } else if (!m3.m.p(j4, "no", true)) {
            AppCompatDelegate.setDefaultNightMode(-1);
        } else if (i4 != 16) {
            AppCompatDelegate.setDefaultNightMode(1);
        }
        Context applicationContext = getApplicationContext();
        m.d(applicationContext, "getApplicationContext(...)");
        if (aVar2.p(applicationContext) == null) {
            String language = Locale.getDefault().getLanguage();
            Context applicationContext2 = getApplicationContext();
            m.d(applicationContext2, "getApplicationContext(...)");
            m.b(language);
            aVar2.M0(applicationContext2, language);
        }
        l1();
        Context applicationContext3 = getApplicationContext();
        m.d(applicationContext3, "getApplicationContext(...)");
        if (aVar2.h0(applicationContext3)) {
            Context applicationContext4 = getApplicationContext();
            m.d(applicationContext4, "getApplicationContext(...)");
            if (671 != aVar2.K(applicationContext4)) {
                Context applicationContext5 = getApplicationContext();
                m.d(applicationContext5, "getApplicationContext(...)");
                aVar2.h1(applicationContext5, false);
                Context applicationContext6 = getApplicationContext();
                m.d(applicationContext6, "getApplicationContext(...)");
                aVar2.m1(applicationContext6, (String) null);
            }
        }
        i1();
        aVar.o0(this);
        C1001s0 unused = C0981i.d(K.a(Y.b()), (V2.g) null, (L) null, new c(this, new e(this), (V2.d) null), 3, (Object) null);
        P1.a aVar3 = new P1.a(this);
        aVar3.a();
        if (aVar3.l() || aVar3.s()) {
            k.f7778g.P(new C2077i((Handler) null));
        }
        if (aVar3.p()) {
            q1(this);
        }
        X(new C2076h((Handler) null));
        ResultReceiver N4 = N();
        m.c(N4, "null cannot be cast to non-null type com.uptodown.receivers.InstallerActivityReceiver");
        ((C2076h) N4).d(getApplicationContext());
        C2313C c5 = C2313C.f21882a;
        Context applicationContext7 = getApplicationContext();
        m.d(applicationContext7, "getApplicationContext(...)");
        c5.i(applicationContext7);
        k.f7778g.b();
        C1001s0 unused2 = C0981i.d(K.a(Y.b()), (V2.g) null, (L) null, new d(this, (V2.d) null), 3, (Object) null);
        new u2.K().d(this);
        k1();
    }

    public void onGoogleBasicConsentChange(GoogleBasicConsents googleBasicConsents) {
        m.e(googleBasicConsents, "consents");
    }

    public void onGoogleVendorConsentGiven(ACData aCData) {
        m.e(aCData, "acData");
    }

    public void onIABVendorConsentGiven(GDPRData gDPRData) {
        boolean z4;
        m.e(gDPRData, "gdprData");
        Boolean bool = gDPRData.getVendor().getConsents().get("867");
        if (bool != null) {
            z4 = bool.booleanValue();
        } else {
            z4 = false;
        }
        u2.K k4 = new u2.K();
        Context applicationContext = getApplicationContext();
        m.d(applicationContext, "getApplicationContext(...)");
        k4.a(applicationContext, z4);
        j1(z4, "gdpr");
    }

    public void onNonIABVendorConsentGiven(NonIABData nonIABData) {
        m.e(nonIABData, "nonIABData");
    }

    public void onReceiveUSRegulationsConsent(USRegulationData uSRegulationData) {
        boolean z4;
        boolean z5;
        boolean z6;
        m.e(uSRegulationData, "usRegulationData");
        boolean z7 = false;
        if (uSRegulationData.getSaleOptOut() == 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (uSRegulationData.getSharingOptOut() == 2) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (uSRegulationData.getPersonalDataConsents() == 2) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z4 && z5 && z6) {
            z7 = true;
        }
        new u2.K().b(!z7);
        j1(z7, "mspa");
    }

    public void onTerminate() {
        super.onTerminate();
        new C2312B(this).d();
        r1();
    }

    public void onUserMovedToOtherState() {
    }
}
