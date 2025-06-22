package com.inmobi.cmp;

import R2.n;
import R2.s;
import S2.C1601o;
import S2.N;
import U3.C2589b;
import V3.C2591b;
import X3.C2607c;
import X3.C2608d;
import X3.o;
import X3.q;
import X3.r;
import X3.u;
import X3.w;
import Z3.C2613b;
import Z3.C2617f;
import Z3.C2618g;
import Z3.C2619h;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import b.m;
import com.inmobi.cmp.core.cmpapi.status.CmpStatus;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.inmobi.cmp.core.model.GDPRData;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import com.inmobi.cmp.data.model.ChoiceStyle;
import com.inmobi.cmp.data.storage.SharedStorage;
import com.inmobi.cmp.model.ChoiceError;
import com.inmobi.cmp.model.NonIABData;
import com.inmobi.cmp.model.PingReturn;
import com.inmobi.cmp.presentation.components.CmpActivity;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import d3.p;
import j1.C2091a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import o3.C0977g;
import o3.C1001s0;
import o3.H;
import o3.J;
import o3.K;
import o3.L;
import o3.P0;
import o3.Y;

public final class ChoiceCmp {
    public static final ChoiceCmp INSTANCE = new ChoiceCmp();

    /* renamed from: a  reason: collision with root package name */
    public static ChoiceCmpCallback f11750a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f11751b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f11752c = "";

    /* renamed from: d  reason: collision with root package name */
    public static m f11753d;

    /* renamed from: e  reason: collision with root package name */
    public static J f11754e;

    /* renamed from: f  reason: collision with root package name */
    public static final H f11755f = new i(H.f3655j0);

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f11756g = Pattern.compile("^(p-)?([a-zA-Z0-9_-]{13})$");

    public static final class a extends l implements p {
        public a(V2.d dVar) {
            super(2, dVar);
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(dVar);
        }

        public Object invoke(Object obj, Object obj2) {
            J j4 = (J) obj;
            return new a((V2.d) obj2).invokeSuspend(s.f8222a);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            n.b(obj);
            ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
            ChoiceCmpCallback callback = choiceCmp.getCallback();
            if (callback != null) {
                callback.onCmpLoaded(choiceCmp.ping$app_release(true, CmpStatus.LOADED, DisplayStatus.HIDDEN));
            }
            b4.d dVar = b4.d.f24465a;
            if (b4.d.f24466b != null) {
                ChoiceCmp.access$showCmpDialog(choiceCmp, dVar.b());
            }
            return s.f8222a;
        }
    }

    public static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f11757a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChoiceCmp f11758b;

        /* renamed from: c  reason: collision with root package name */
        public int f11759c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ChoiceCmp choiceCmp, V2.d dVar) {
            super(dVar);
            this.f11758b = choiceCmp;
        }

        public final Object invokeSuspend(Object obj) {
            this.f11757a = obj;
            this.f11759c |= Integer.MIN_VALUE;
            return this.f11758b.b(this);
        }
    }

    public static final class c extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f11760a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChoiceCmp f11761b;

        /* renamed from: c  reason: collision with root package name */
        public int f11762c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ChoiceCmp choiceCmp, V2.d dVar) {
            super(dVar);
            this.f11761b = choiceCmp;
        }

        public final Object invokeSuspend(Object obj) {
            this.f11760a = obj;
            this.f11762c |= Integer.MIN_VALUE;
            return this.f11761b.c(this);
        }
    }

    public static final class d extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f11763a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChoiceCmp f11764b;

        /* renamed from: c  reason: collision with root package name */
        public int f11765c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ChoiceCmp choiceCmp, V2.d dVar) {
            super(dVar);
            this.f11764b = choiceCmp;
        }

        public final Object invokeSuspend(Object obj) {
            this.f11763a = obj;
            this.f11765c |= Integer.MIN_VALUE;
            return this.f11764b.d(this);
        }
    }

    public static final class e extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f11766a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChoiceCmp f11767b;

        /* renamed from: c  reason: collision with root package name */
        public int f11768c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(ChoiceCmp choiceCmp, V2.d dVar) {
            super(dVar);
            this.f11767b = choiceCmp;
        }

        public final Object invokeSuspend(Object obj) {
            this.f11766a = obj;
            this.f11768c |= Integer.MIN_VALUE;
            return this.f11767b.e(this);
        }
    }

    public static final class f extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f11769a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChoiceCmp f11770b;

        /* renamed from: c  reason: collision with root package name */
        public int f11771c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(ChoiceCmp choiceCmp, V2.d dVar) {
            super(dVar);
            this.f11770b = choiceCmp;
        }

        public final Object invokeSuspend(Object obj) {
            this.f11769a = obj;
            this.f11771c |= Integer.MIN_VALUE;
            return this.f11770b.f(this);
        }
    }

    public static final class g extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f11772a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChoiceCmp f11773b;

        /* renamed from: c  reason: collision with root package name */
        public int f11774c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ChoiceCmp choiceCmp, V2.d dVar) {
            super(dVar);
            this.f11773b = choiceCmp;
        }

        public final Object invokeSuspend(Object obj) {
            this.f11772a = obj;
            this.f11774c |= Integer.MIN_VALUE;
            return this.f11773b.g(this);
        }
    }

    public static final class h extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f11775a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ChoiceCmp f11776b;

        /* renamed from: c  reason: collision with root package name */
        public int f11777c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ChoiceCmp choiceCmp, V2.d dVar) {
            super(dVar);
            this.f11776b = choiceCmp;
        }

        public final Object invokeSuspend(Object obj) {
            this.f11775a = obj;
            this.f11777c |= Integer.MIN_VALUE;
            return this.f11776b.h(this);
        }
    }

    public static final class j implements b4.a {
        public void a() {
            m access$getViewModel$p = ChoiceCmp.f11753d;
            if (access$getViewModel$p == null) {
                kotlin.jvm.internal.m.u("viewModel");
                access$getViewModel$p = null;
            }
            if (!access$getViewModel$p.f1125l) {
                ChoiceCmp.INSTANCE.a();
            }
        }

        public void b() {
            J access$getActiveScope$p = ChoiceCmp.f11754e;
            if (access$getActiveScope$p != null) {
                K.c(access$getActiveScope$p, (CancellationException) null, 1, (Object) null);
            }
            ChoiceCmp.f11754e = null;
        }
    }

    public static final class k extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        public int f11778a;

        public k(V2.d dVar) {
            super(2, dVar);
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new k(dVar);
        }

        public Object invoke(Object obj, Object obj2) {
            J j4 = (J) obj;
            return new k((V2.d) obj2).invokeSuspend(s.f8222a);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f11778a;
            if (i4 == 0) {
                n.b(obj);
                ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
                this.f11778a = 1;
                if (ChoiceCmp.access$loadCmpInfo(choiceCmp, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005b, code lost:
        if (r6 == r7) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007b, code lost:
        if (r6.c(r0) != r7) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007d, code lost:
        return r7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object access$loadCmpInfo(com.inmobi.cmp.ChoiceCmp r6, V2.d r7) {
        /*
            r6.getClass()
            boolean r0 = r7 instanceof b.C0497a
            if (r0 == 0) goto L_0x0016
            r0 = r7
            b.a r0 = (b.C0497a) r0
            int r1 = r0.f1096c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0016
            int r1 = r1 - r2
            r0.f1096c = r1
            goto L_0x001b
        L_0x0016:
            b.a r0 = new b.a
            r0.<init>(r6, r7)
        L_0x001b:
            java.lang.Object r6 = r0.f1094a
            java.lang.Object r7 = W2.b.c()
            int r1 = r0.f1096c
            java.lang.String r2 = "viewModel"
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x003e
            if (r1 == r4) goto L_0x003a
            if (r1 != r3) goto L_0x0032
            R2.n.b(r6)
            goto L_0x007e
        L_0x0032:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003a:
            R2.n.b(r6)
            goto L_0x005e
        L_0x003e:
            R2.n.b(r6)
            b.m r6 = f11753d
            if (r6 != 0) goto L_0x0049
            kotlin.jvm.internal.m.u(r2)
            r6 = r5
        L_0x0049:
            r0.f1096c = r4
            r6.getClass()
            o3.G r1 = o3.Y.b()
            b.d r4 = new b.d
            r4.<init>(r6, r5)
            java.lang.Object r6 = o3.C0977g.g(r1, r4, r0)
            if (r6 != r7) goto L_0x005e
            goto L_0x007d
        L_0x005e:
            E2.g r6 = (E2.g) r6
            b.m r1 = f11753d
            if (r1 != 0) goto L_0x0068
            kotlin.jvm.internal.m.u(r2)
            goto L_0x0069
        L_0x0068:
            r5 = r1
        L_0x0069:
            r5.getClass()
            java.lang.String r1 = "cmpIab"
            kotlin.jvm.internal.m.e(r6, r1)
            r5.f1129p = r6
            com.inmobi.cmp.ChoiceCmp r6 = INSTANCE
            r0.f1096c = r3
            java.lang.Object r6 = r6.c(r0)
            if (r6 != r7) goto L_0x007e
        L_0x007d:
            return r7
        L_0x007e:
            R2.s r6 = R2.s.f8222a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.access$loadCmpInfo(com.inmobi.cmp.ChoiceCmp, V2.d):java.lang.Object");
    }

    public static final void access$showCmpDialog(ChoiceCmp choiceCmp, Context context) {
        choiceCmp.getClass();
        m mVar = f11753d;
        m mVar2 = null;
        if (mVar == null) {
            kotlin.jvm.internal.m.u("viewModel");
            mVar = null;
        }
        if (mVar.l()) {
            if (choiceCmp.isViewModelAvailable$app_release()) {
                m mVar3 = f11753d;
                if (mVar3 == null) {
                    kotlin.jvm.internal.m.u("viewModel");
                    mVar3 = null;
                }
                if (mVar3.o()) {
                    m mVar4 = f11753d;
                    if (mVar4 == null) {
                        kotlin.jvm.internal.m.u("viewModel");
                        mVar4 = null;
                    }
                    C3.a aVar = mVar4.f1116c.f170b;
                    kotlin.jvm.internal.m.e(aVar, "coreConfig");
                    String b5 = C2589b.b(aVar.f118J + aVar.f122N + aVar.f123O);
                    SharedStorage sharedStorage = mVar4.f1114a;
                    a4.a aVar2 = a4.a.MSPA_PURPOSE_HASH;
                    if (!kotlin.jvm.internal.m.a(b5, sharedStorage.j(aVar2)) || mVar4.j()) {
                        if (mVar4.m()) {
                            mVar4.f1114a.e(a4.a.GBC_PURPOSE_HASH, mVar4.e());
                        }
                        SharedStorage sharedStorage2 = mVar4.f1114a;
                        C3.a aVar3 = mVar4.f1116c.f170b;
                        kotlin.jvm.internal.m.e(aVar3, "coreConfig");
                        sharedStorage2.e(aVar2, C2589b.b(aVar3.f118J + aVar3.f122N + aVar3.f123O));
                        mVar4.f1114a.b(a4.a.MSPA_PURPOSE_CONSENT);
                        mVar4.f1114a.b(a4.a.MSPA_SENSITIVE_PURPOSE_CONSENT);
                        m mVar5 = f11753d;
                        if (mVar5 == null) {
                            kotlin.jvm.internal.m.u("viewModel");
                            mVar5 = null;
                        }
                        if (!mVar5.k()) {
                            A3.i.f81a.b(b4.d.f24465a.h());
                        }
                        m mVar6 = f11753d;
                        if (mVar6 == null) {
                            kotlin.jvm.internal.m.u("viewModel");
                        } else {
                            mVar2 = mVar6;
                        }
                        if (mVar2.f1116c.f170b.f126R) {
                            context.startActivity(new Intent(context, CmpActivity.class).addFlags(268435456).addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL).putExtra("EXTRA_ACTION", "ACTION_SHOW_US_REGULATION_SCREEN").putExtra("EXTRA_FORCE", false));
                            return;
                        }
                        return;
                    }
                }
            }
            C2.b.a(C2.b.f6277a, ChoiceError.US_PRIVACY_NOT_APPLICABLE, (String) null, (String) null, C2.c.CONSOLE, (Throwable) null, 22);
            return;
        }
        choiceCmp.a(context, false);
    }

    public static final void forceDisplayUI(Activity activity) {
        kotlin.jvm.internal.m.e(activity, "activity");
        ChoiceCmp choiceCmp = INSTANCE;
        if (choiceCmp.isViewModelAvailable$app_release()) {
            choiceCmp.a(activity, true);
        } else {
            C2.b.a(C2.b.f6277a, ChoiceError.MISSING_INITIALIZATION, (String) null, (String) null, (C2.c) null, (Throwable) null, 30);
        }
    }

    public static final GDPRData getGDPRData(Set<Integer> set) {
        if (INSTANCE.isViewModelAvailable$app_release()) {
            return new GDPRData(set);
        }
        return null;
    }

    public static /* synthetic */ GDPRData getGDPRData$default(Set set, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            set = null;
        }
        return getGDPRData(set);
    }

    public static final NonIABData getNonIABData(Set<Integer> set) {
        boolean z4;
        LinkedHashMap linkedHashMap;
        m mVar = null;
        if (!INSTANCE.isViewModelAvailable$app_release()) {
            return null;
        }
        m mVar2 = f11753d;
        if (mVar2 == null) {
            kotlin.jvm.internal.m.u("viewModel");
        } else {
            mVar = mVar2;
        }
        if (mVar.f1114a.i(a4.a.TCF_GDPR_APPLIES) == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        String j4 = mVar.f1114a.j(a4.a.NON_IAB_CONSENT_ENCODED);
        Map<Integer, Boolean> map = mVar.f1115b.f6384A.getMap();
        if (set == null) {
            linkedHashMap = map;
        } else {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                if (set.contains(next.getKey())) {
                    linkedHashMap2.put(next.getKey(), next.getValue());
                }
            }
            linkedHashMap = linkedHashMap2;
        }
        return new NonIABData(z4, false, false, j4, linkedHashMap);
    }

    public static /* synthetic */ NonIABData getNonIABData$default(Set set, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            set = null;
        }
        return getNonIABData(set);
    }

    public static final void showCCPAScreen(Activity activity) {
        kotlin.jvm.internal.m.e(activity, "activity");
        if (INSTANCE.isViewModelAvailable$app_release()) {
            m mVar = f11753d;
            m mVar2 = null;
            if (mVar == null) {
                kotlin.jvm.internal.m.u("viewModel");
                mVar = null;
            }
            if (mVar.l()) {
                m mVar3 = f11753d;
                if (mVar3 == null) {
                    kotlin.jvm.internal.m.u("viewModel");
                    mVar3 = null;
                }
                if (mVar3.f1116c.f170b.f129b.contains("USP")) {
                    m mVar4 = f11753d;
                    if (mVar4 == null) {
                        kotlin.jvm.internal.m.u("viewModel");
                    } else {
                        mVar2 = mVar4;
                    }
                    if (mVar2.k()) {
                        activity.startActivity(new Intent(activity, CmpActivity.class).addFlags(268435456).addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL).putExtra("EXTRA_ACTION", "ACTION_SHOW_CCPA_SCREEN"));
                        return;
                    }
                }
                C2.b.a(C2.b.f6277a, ChoiceError.US_PRIVACY_NOT_APPLICABLE, (String) null, (String) null, C2.c.CONSOLE, (Throwable) null, 22);
                return;
            }
        }
        C2.b.a(C2.b.f6277a, ChoiceError.INVALID_LOCATION, (String) null, (String) null, C2.c.CONSOLE, (Throwable) null, 22);
    }

    public static final void showGBCScreen(Activity activity) {
        kotlin.jvm.internal.m.e(activity, "activity");
        if (!INSTANCE.isViewModelAvailable$app_release()) {
            C2.b.a(C2.b.f6277a, ChoiceError.MISSING_INITIALIZATION, (String) null, (String) null, (C2.c) null, (Throwable) null, 30);
        } else if (c.i.f1158b) {
            activity.startActivity(new Intent(activity, CmpActivity.class).addFlags(268435456).addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL).putExtra("EXTRA_ACTION", "ACTION_SHOW_GBC_SCREEN"));
        } else {
            C2.b.a(C2.b.f6277a, ChoiceError.GBC_NOT_APPLICABLE, (String) null, (String) null, (C2.c) null, (Throwable) null, 30);
        }
    }

    public static final void showUSRegulationScreen(Activity activity) {
        kotlin.jvm.internal.m.e(activity, "activity");
        if (INSTANCE.isViewModelAvailable$app_release()) {
            m mVar = f11753d;
            m mVar2 = null;
            if (mVar == null) {
                kotlin.jvm.internal.m.u("viewModel");
                mVar = null;
            }
            if (mVar.l()) {
                m mVar3 = f11753d;
                if (mVar3 == null) {
                    kotlin.jvm.internal.m.u("viewModel");
                    mVar3 = null;
                }
                if (mVar3.o()) {
                    m mVar4 = f11753d;
                    if (mVar4 == null) {
                        kotlin.jvm.internal.m.u("viewModel");
                    } else {
                        mVar2 = mVar4;
                    }
                    if (!mVar2.k()) {
                        A3.i.f81a.b(b4.d.f24465a.h());
                    }
                    activity.startActivity(new Intent(activity, CmpActivity.class).addFlags(268435456).addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL).putExtra("EXTRA_ACTION", "ACTION_SHOW_US_REGULATION_SCREEN").putExtra("EXTRA_FORCE", true));
                    return;
                }
                C2.b.a(C2.b.f6277a, ChoiceError.US_PRIVACY_NOT_APPLICABLE, (String) null, (String) null, C2.c.CONSOLE, (Throwable) null, 22);
                return;
            }
        }
        C2.b.a(C2.b.f6277a, ChoiceError.INVALID_LOCATION, (String) null, (String) null, C2.c.CONSOLE, (Throwable) null, 22);
    }

    public static final void startChoice(Application application, String str, String str2, ChoiceCmpCallback choiceCmpCallback, ChoiceStyle choiceStyle) {
        String str3;
        Typeface typeface;
        Typeface typeface2;
        q qVar;
        C2607c cVar;
        X3.m mVar;
        b4.d dVar;
        o oVar;
        X3.k kVar;
        Application application2 = application;
        String str4 = str;
        String str5 = str2;
        ChoiceCmpCallback choiceCmpCallback2 = choiceCmpCallback;
        ChoiceStyle choiceStyle2 = choiceStyle;
        kotlin.jvm.internal.m.e(application2, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        kotlin.jvm.internal.m.e(str4, "packageId");
        kotlin.jvm.internal.m.e(str5, "pCode");
        kotlin.jvm.internal.m.e(choiceCmpCallback2, "callback");
        kotlin.jvm.internal.m.e(choiceStyle2, "choiceStyle");
        ChoiceCmp choiceCmp = INSTANCE;
        f11750a = choiceCmpCallback2;
        f11751b = str4;
        choiceCmp.getClass();
        Matcher matcher = f11756g.matcher(str5);
        if (matcher.matches()) {
            str3 = matcher.group(2);
        } else {
            str3 = null;
        }
        if (str3 == null) {
            C2.b.a(C2.b.f6277a, ChoiceError.INVALID_PCODE, (String) null, (String) null, (C2.c) null, (Throwable) null, 30);
            str3 = null;
        }
        if (str3 == null) {
            str3 = null;
        }
        if (str3 != null) {
            f11752c = str3;
            b4.d dVar2 = b4.d.f24465a;
            kotlin.jvm.internal.m.e(application2, "<set-?>");
            b4.d.f24466b = application2;
            kotlin.jvm.internal.m.e(choiceStyle2, "resources");
            b4.d.f24468d = choiceStyle2;
            Integer boldFont = choiceStyle2.getBoldFont();
            if (boldFont == null) {
                typeface = null;
            } else {
                typeface = ResourcesCompat.getFont(dVar2.b(), boldFont.intValue());
            }
            Integer regularFont = choiceStyle2.getRegularFont();
            if (regularFont == null) {
                typeface2 = null;
            } else {
                typeface2 = ResourcesCompat.getFont(dVar2.b(), regularFont.intValue());
            }
            b4.d.f24469e = new C2591b(typeface, typeface2);
            if (f11753d == null) {
                SharedStorage m4 = dVar2.m();
                E2.s n4 = dVar2.n();
                C3.f j4 = dVar2.j();
                if (b4.d.f24481q == null) {
                    b4.d.f24481q = new r(dVar2.b(), dVar2.i(), dVar2.a(), dVar2.m(), dVar2.l(), new Z3.n(dVar2.a()));
                }
                q qVar2 = b4.d.f24481q;
                if (qVar2 == null) {
                    kotlin.jvm.internal.m.u("gvlRepository_");
                    qVar = null;
                } else {
                    qVar = qVar2;
                }
                if (b4.d.f24482r == null) {
                    b4.d.f24482r = new C2608d(dVar2.i(), dVar2.m(), dVar2.l(), new C2613b(dVar2.b(), dVar2.a()));
                }
                C2607c cVar2 = b4.d.f24482r;
                if (cVar2 == null) {
                    kotlin.jvm.internal.m.u("cmpRepository_");
                    cVar = null;
                } else {
                    cVar = cVar2;
                }
                u k4 = dVar2.k();
                w p4 = dVar2.p();
                if (b4.d.f24487w == null) {
                    b4.d.f24487w = new X3.n(dVar2.i(), dVar2.l(), new C2618g());
                }
                X3.m mVar2 = b4.d.f24487w;
                if (mVar2 == null) {
                    kotlin.jvm.internal.m.u("geoIPRepository_");
                    mVar = null;
                } else {
                    mVar = mVar2;
                }
                if (b4.d.f24488x == null) {
                    dVar = dVar2;
                    b4.d.f24488x = new X3.p(dVar2.i(), dVar2.m(), dVar2.l(), new C2619h());
                } else {
                    dVar = dVar2;
                }
                o oVar2 = b4.d.f24488x;
                if (oVar2 == null) {
                    kotlin.jvm.internal.m.u("googleVendorsRepository_");
                    oVar = null;
                } else {
                    oVar = oVar2;
                }
                if (b4.d.f24463A == null) {
                    b4.d.f24463A = new X3.l(dVar.a(), dVar.i(), dVar.m(), dVar.l(), new C2617f());
                }
                X3.k kVar2 = b4.d.f24463A;
                if (kVar2 == null) {
                    kotlin.jvm.internal.m.u("gbcRepository");
                    kVar = null;
                } else {
                    kVar = kVar2;
                }
                f11753d = new m(m4, n4, j4, qVar, cVar, k4, p4, mVar, oVar, kVar, dVar.c());
                choiceCmp.a();
            }
            j jVar = new j();
            kotlin.jvm.internal.m.e(application2, MimeTypes.BASE_TYPE_APPLICATION);
            kotlin.jvm.internal.m.e(jVar, "applicationLifecycleCallback");
            application2.registerActivityLifecycleCallbacks(new b4.b(jVar));
        }
    }

    public static /* synthetic */ void startChoice$default(Application application, String str, String str2, ChoiceCmpCallback choiceCmpCallback, ChoiceStyle choiceStyle, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            choiceStyle = new ChoiceStyle();
        }
        startChoice(application, str, str2, choiceCmpCallback, choiceStyle);
    }

    public final void a(Context context, boolean z4) {
        m mVar = f11753d;
        m mVar2 = null;
        if (mVar == null) {
            kotlin.jvm.internal.m.u("viewModel");
            mVar = null;
        }
        if (!mVar.l()) {
            m mVar3 = f11753d;
            if (mVar3 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                mVar3 = null;
            }
            if (mVar3.f1116c.f170b.f129b.contains("GDPR") && mVar3.b()) {
                m mVar4 = f11753d;
                if (mVar4 == null) {
                    kotlin.jvm.internal.m.u("viewModel");
                } else {
                    mVar2 = mVar4;
                }
                if (mVar2.s() || z4) {
                    context.startActivity(new Intent(context, CmpActivity.class).addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL).addFlags(268435456).putExtra("EXTRA_ACTION", "ACTION_SHOW_CMP_DIALOG").putExtra("EXTRA_FORCE", z4));
                    return;
                }
                return;
            }
        }
        C2.b.a(C2.b.f6277a, ChoiceError.GDPR_NA, (String) null, (String) null, C2.c.CONSOLE, (Throwable) null, 22);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        if (r8 == r1) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0082, code lost:
        if (r8.h(r0) != r1) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0084, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(V2.d r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.inmobi.cmp.ChoiceCmp.b
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.inmobi.cmp.ChoiceCmp$b r0 = (com.inmobi.cmp.ChoiceCmp.b) r0
            int r1 = r0.f11759c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11759c = r1
            goto L_0x0018
        L_0x0013:
            com.inmobi.cmp.ChoiceCmp$b r0 = new com.inmobi.cmp.ChoiceCmp$b
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f11757a
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f11759c
            java.lang.String r3 = "viewModel"
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x003b
            if (r2 == r5) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            R2.n.b(r8)
            goto L_0x0085
        L_0x002f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0037:
            R2.n.b(r8)
            goto L_0x005b
        L_0x003b:
            R2.n.b(r8)
            b.m r8 = f11753d
            if (r8 != 0) goto L_0x0046
            kotlin.jvm.internal.m.u(r3)
            r8 = r6
        L_0x0046:
            r0.f11759c = r5
            r8.getClass()
            o3.G r2 = o3.Y.b()
            b.g r5 = new b.g
            r5.<init>(r8, r6)
            java.lang.Object r8 = o3.C0977g.g(r2, r5, r0)
            if (r8 != r1) goto L_0x005b
            goto L_0x0084
        L_0x005b:
            M2.c r8 = (M2.c) r8
            b4.d r2 = b4.d.f24465a
            java.lang.String r2 = "gbcPurpose"
            kotlin.jvm.internal.m.e(r8, r2)
            b4.d.f24476l = r8
            b.m r8 = f11753d
            if (r8 != 0) goto L_0x006e
            kotlin.jvm.internal.m.u(r3)
            goto L_0x006f
        L_0x006e:
            r6 = r8
        L_0x006f:
            r6.getClass()
            c.i r8 = c.i.f1157a
            boolean r8 = r6.m()
            c.i.f1158b = r8
            com.inmobi.cmp.ChoiceCmp r8 = INSTANCE
            r0.f11759c = r4
            java.lang.Object r8 = r8.h(r0)
            if (r8 != r1) goto L_0x0085
        L_0x0084:
            return r1
        L_0x0085:
            R2.s r8 = R2.s.f8222a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.b(V2.d):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        if (r8 == r1) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0081, code lost:
        if (r8.g(r0) != r1) goto L_0x0084;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(V2.d r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.inmobi.cmp.ChoiceCmp.c
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.inmobi.cmp.ChoiceCmp$c r0 = (com.inmobi.cmp.ChoiceCmp.c) r0
            int r1 = r0.f11762c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11762c = r1
            goto L_0x0018
        L_0x0013:
            com.inmobi.cmp.ChoiceCmp$c r0 = new com.inmobi.cmp.ChoiceCmp$c
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f11760a
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f11762c
            java.lang.String r3 = "viewModel"
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x003b
            if (r2 == r5) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            R2.n.b(r8)
            goto L_0x0084
        L_0x002f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0037:
            R2.n.b(r8)
            goto L_0x005b
        L_0x003b:
            R2.n.b(r8)
            b.m r8 = f11753d
            if (r8 != 0) goto L_0x0046
            kotlin.jvm.internal.m.u(r3)
            r8 = r6
        L_0x0046:
            r0.f11762c = r5
            r8.getClass()
            o3.G r2 = o3.Y.b()
            b.h r5 = new b.h
            r5.<init>(r8, r6)
            java.lang.Object r8 = o3.C0977g.g(r2, r5, r0)
            if (r8 != r1) goto L_0x005b
            goto L_0x0083
        L_0x005b:
            P2.b r8 = (P2.b) r8
            b.m r2 = f11753d
            if (r2 != 0) goto L_0x0065
            kotlin.jvm.internal.m.u(r3)
            r2 = r6
        L_0x0065:
            r2.f1127n = r8
            b4.d r2 = b4.d.f24465a
            if (r8 != 0) goto L_0x006c
            goto L_0x006e
        L_0x006c:
            java.lang.String r6 = r8.f7990b
        L_0x006e:
            if (r6 != 0) goto L_0x0072
            java.lang.String r6 = ""
        L_0x0072:
            java.lang.String r8 = "region"
            kotlin.jvm.internal.m.e(r6, r8)
            b4.d.f24478n = r6
            com.inmobi.cmp.ChoiceCmp r8 = INSTANCE
            r0.f11762c = r4
            java.lang.Object r8 = r8.g(r0)
            if (r8 != r1) goto L_0x0084
        L_0x0083:
            return r1
        L_0x0084:
            R2.s r8 = R2.s.f8222a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.c(V2.d):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0064, code lost:
        if (r13 == r1) goto L_0x02e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02de, code lost:
        if (r13.f(r0) == r1) goto L_0x02e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02e0, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(V2.d r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.inmobi.cmp.ChoiceCmp.d
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.inmobi.cmp.ChoiceCmp$d r0 = (com.inmobi.cmp.ChoiceCmp.d) r0
            int r1 = r0.f11765c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11765c = r1
            goto L_0x0018
        L_0x0013:
            com.inmobi.cmp.ChoiceCmp$d r0 = new com.inmobi.cmp.ChoiceCmp$d
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f11763a
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f11765c
            java.lang.String r3 = "viewModel"
            r4 = 0
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r6) goto L_0x0038
            if (r2 != r5) goto L_0x0030
            R2.n.b(r13)
            goto L_0x02e1
        L_0x0030:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0038:
            R2.n.b(r13)
            goto L_0x0068
        L_0x003c:
            R2.n.b(r13)
            b.m r13 = f11753d
            if (r13 != 0) goto L_0x0047
            kotlin.jvm.internal.m.u(r3)
            r13 = r4
        L_0x0047:
            r0.f11765c = r6
            C3.f r2 = r13.f1116c
            C3.a r2 = r2.f170b
            boolean r2 = r2.f140m
            if (r2 == 0) goto L_0x005f
            o3.G r2 = o3.Y.b()
            b.i r7 = new b.i
            r7.<init>(r13, r4)
            java.lang.Object r13 = o3.C0977g.g(r2, r7, r0)
            goto L_0x0064
        L_0x005f:
            E2.e r13 = new E2.e
            r13.<init>(r4, r6)
        L_0x0064:
            if (r13 != r1) goto L_0x0068
            goto L_0x02e0
        L_0x0068:
            E2.e r13 = (E2.e) r13
            b.m r2 = f11753d
            if (r2 != 0) goto L_0x0072
            kotlin.jvm.internal.m.u(r3)
            goto L_0x0073
        L_0x0072:
            r4 = r2
        L_0x0073:
            r4.getClass()
            java.lang.String r2 = "googleVendorList"
            kotlin.jvm.internal.m.e(r13, r2)
            r4.f1126m = r13
            C3.f r13 = r4.f1116c
            C3.g r13 = r13.f169a
            java.util.List r13 = r13.f177c
            boolean r2 = r13.isEmpty()
            if (r2 != 0) goto L_0x00f7
            java.lang.Object r2 = S2.C1601o.H(r13)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            if (r2 != r6) goto L_0x0096
            goto L_0x00f7
        L_0x0096:
            boolean r2 = r13.isEmpty()
            if (r2 != 0) goto L_0x00b1
            java.lang.Object r2 = S2.C1601o.H(r13)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            r3 = -1
            if (r2 != r3) goto L_0x00b1
            E2.e r13 = r4.f1126m
            java.util.Map r13 = r13.f6348a
            r13.clear()
            goto L_0x00f7
        L_0x00b1:
            E2.e r2 = r4.f1126m
            java.util.Map r3 = r2.f6348a
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            r6.<init>()
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x00c2:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x00ec
            java.lang.Object r7 = r3.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getValue()
            E2.f r8 = (E2.f) r8
            int r8 = r8.f6349a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r8 = r13.contains(r8)
            if (r8 == 0) goto L_0x00c2
            java.lang.Object r8 = r7.getKey()
            java.lang.Object r7 = r7.getValue()
            r6.put(r8, r7)
            goto L_0x00c2
        L_0x00ec:
            java.util.Map r13 = S2.H.t(r6)
            java.lang.String r3 = "<set-?>"
            kotlin.jvm.internal.m.e(r13, r3)
            r2.f6348a = r13
        L_0x00f7:
            E2.e r13 = r4.f1126m
            java.util.Map r13 = r13.f6348a
            java.util.Collection r13 = r13.values()
            java.util.Iterator r13 = r13.iterator()
        L_0x0103:
            boolean r2 = r13.hasNext()
            if (r2 == 0) goto L_0x0197
            java.lang.Object r2 = r13.next()
            E2.f r2 = (E2.f) r2
            com.inmobi.cmp.data.storage.SharedStorage r3 = r4.f1114a
            a4.a r6 = a4.a.ADDTL_CONSENT
            java.lang.String r3 = r3.j(r6)
            java.lang.String r6 = "acString"
            kotlin.jvm.internal.m.e(r3, r6)
            int r6 = r3.length()
            if (r6 > r5) goto L_0x0127
            java.util.Set r3 = S2.N.d()
            goto L_0x0169
        L_0x0127:
            java.lang.String r6 = r3.substring(r5)
            java.lang.String r3 = "this as java.lang.String).substring(startIndex)"
            kotlin.jvm.internal.m.d(r6, r3)
            java.lang.String r3 = "."
            java.lang.String[] r7 = new java.lang.String[]{r3}
            r10 = 6
            r11 = 0
            r8 = 0
            r9 = 0
            java.util.List r3 = m3.m.j0(r6, r7, r8, r9, r10, r11)
            java.util.ArrayList r6 = new java.util.ArrayList
            r7 = 10
            int r7 = S2.C1601o.p(r3, r7)
            r6.<init>(r7)
            java.util.Iterator r3 = r3.iterator()
        L_0x014d:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x0165
            java.lang.Object r7 = r3.next()
            java.lang.String r7 = (java.lang.String) r7
            int r7 = java.lang.Integer.parseInt(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6.add(r7)
            goto L_0x014d
        L_0x0165:
            java.util.Set r3 = S2.C1601o.d0(r6)
        L_0x0169:
            int r6 = r2.f6349a
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r3 = r3.contains(r6)
            if (r3 == 0) goto L_0x018c
            z3.l r3 = r2.a()
            java.util.Set r3 = r3.f4819d
            boolean r3 = r4.c(r3)
            if (r3 == 0) goto L_0x018c
            E2.s r3 = r4.f1115b
            com.inmobi.cmp.core.model.Vector r3 = r3.f6385B
            int r2 = r2.f6349a
            r3.set((int) r2)
            goto L_0x0103
        L_0x018c:
            E2.s r3 = r4.f1115b
            com.inmobi.cmp.core.model.Vector r3 = r3.f6385B
            int r2 = r2.f6349a
            r3.unset((int) r2)
            goto L_0x0103
        L_0x0197:
            C3.f r13 = r4.f1116c
            C3.g r13 = r13.f169a
            java.util.List r13 = r13.f175a
            boolean r2 = r13.isEmpty()
            if (r2 != 0) goto L_0x01ec
            E2.s r2 = r4.f1115b
            z3.e r2 = r2.f6391a
            if (r2 != 0) goto L_0x01ab
            goto L_0x023f
        L_0x01ab:
            java.util.Map r3 = r2.f4808i
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            r6.<init>()
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x01ba:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x01e4
            java.lang.Object r7 = r3.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getValue()
            z3.l r8 = (z3.l) r8
            int r8 = r8.f4812a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r8 = r13.contains(r8)
            if (r8 != 0) goto L_0x01ba
            java.lang.Object r8 = r7.getKey()
            java.lang.Object r7 = r7.getValue()
            r6.put(r8, r7)
            goto L_0x01ba
        L_0x01e4:
            java.util.Map r13 = S2.H.t(r6)
            r2.a(r13)
            goto L_0x023f
        L_0x01ec:
            C3.f r13 = r4.f1116c
            C3.g r13 = r13.f169a
            java.util.List r13 = r13.f176b
            boolean r2 = r13.isEmpty()
            if (r2 != 0) goto L_0x023f
            E2.s r2 = r4.f1115b
            z3.e r2 = r2.f6391a
            if (r2 != 0) goto L_0x01ff
            goto L_0x023f
        L_0x01ff:
            java.util.Map r3 = r2.f4808i
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            r6.<init>()
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x020e:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x0238
            java.lang.Object r7 = r3.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getValue()
            z3.l r8 = (z3.l) r8
            int r8 = r8.f4812a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r8 = r13.contains(r8)
            if (r8 == 0) goto L_0x020e
            java.lang.Object r8 = r7.getKey()
            java.lang.Object r7 = r7.getValue()
            r6.put(r8, r7)
            goto L_0x020e
        L_0x0238:
            java.util.Map r13 = S2.H.t(r6)
            r2.a(r13)
        L_0x023f:
            E2.s r13 = r4.f1115b
            z3.e r13 = r13.f6391a
            if (r13 != 0) goto L_0x0247
            goto L_0x02d6
        L_0x0247:
            java.util.Map r13 = r13.f4808i
            java.util.Set r13 = r13.entrySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x0251:
            boolean r2 = r13.hasNext()
            if (r2 == 0) goto L_0x02d6
            java.lang.Object r2 = r13.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            z3.l r3 = (z3.l) r3
            java.util.Set r3 = r3.f4821f
            java.util.Iterator r3 = r3.iterator()
        L_0x0269:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0251
            java.lang.Object r6 = r3.next()
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            C3.f r7 = r4.f1116c
            C3.a r7 = r7.f170b
            java.util.List r7 = r7.f151x
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto L_0x02a7
            java.lang.Object r7 = r2.getValue()
            z3.l r7 = (z3.l) r7
            java.util.Set r7 = r7.f4819d
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            r7.add(r8)
            java.lang.Object r7 = r2.getValue()
            z3.l r7 = (z3.l) r7
            java.util.Set r7 = r7.f4820e
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            r7.remove(r8)
        L_0x02a7:
            C3.f r7 = r4.f1116c
            C3.a r7 = r7.f170b
            java.util.List r7 = r7.f152y
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            boolean r7 = r7.contains(r8)
            if (r7 == 0) goto L_0x0269
            java.lang.Object r7 = r2.getValue()
            z3.l r7 = (z3.l) r7
            java.util.Set r7 = r7.f4820e
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            r7.add(r8)
            java.lang.Object r7 = r2.getValue()
            z3.l r7 = (z3.l) r7
            java.util.Set r7 = r7.f4819d
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r7.remove(r6)
            goto L_0x0269
        L_0x02d6:
            com.inmobi.cmp.ChoiceCmp r13 = INSTANCE
            r0.f11765c = r5
            java.lang.Object r13 = r13.f(r0)
            if (r13 != r1) goto L_0x02e1
        L_0x02e0:
            return r1
        L_0x02e1:
            R2.s r13 = R2.s.f8222a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.d(V2.d):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        if (r11 == r1) goto L_0x016b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0169, code lost:
        if (r11.d(r0) != r1) goto L_0x016c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x016b, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(V2.d r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.inmobi.cmp.ChoiceCmp.e
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.inmobi.cmp.ChoiceCmp$e r0 = (com.inmobi.cmp.ChoiceCmp.e) r0
            int r1 = r0.f11768c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11768c = r1
            goto L_0x0018
        L_0x0013:
            com.inmobi.cmp.ChoiceCmp$e r0 = new com.inmobi.cmp.ChoiceCmp$e
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f11766a
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f11768c
            java.lang.String r3 = "viewModel"
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x003c
            if (r2 == r5) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            R2.n.b(r11)
            goto L_0x016c
        L_0x0030:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0038:
            R2.n.b(r11)
            goto L_0x005d
        L_0x003c:
            R2.n.b(r11)
            b.m r11 = f11753d
            if (r11 != 0) goto L_0x0047
            kotlin.jvm.internal.m.u(r3)
            r11 = r6
        L_0x0047:
            r0.f11768c = r5
            r11.getClass()
            o3.G r2 = o3.Y.b()
            b.e r5 = new b.e
            r5.<init>(r11, r6)
            java.lang.Object r11 = o3.C0977g.g(r2, r5, r0)
            if (r11 != r1) goto L_0x005d
            goto L_0x016b
        L_0x005d:
            z3.e r11 = (z3.e) r11
            b.m r2 = f11753d
            if (r2 != 0) goto L_0x0067
            kotlin.jvm.internal.m.u(r3)
            goto L_0x0068
        L_0x0067:
            r6 = r2
        L_0x0068:
            r6.getClass()
            java.lang.String r2 = "gvl"
            kotlin.jvm.internal.m.e(r11, r2)
            E2.s r2 = r6.f1115b
            r2.f6391a = r11
            E2.j r2 = r2.f6390G
            r2.f6364d = r11
            if (r11 != 0) goto L_0x007c
            goto L_0x0156
        L_0x007c:
            java.util.Map r11 = r11.f4808i
            if (r11 != 0) goto L_0x0082
            goto L_0x0156
        L_0x0082:
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x008a:
            boolean r3 = r11.hasNext()
            if (r3 == 0) goto L_0x0156
            java.lang.Object r3 = r11.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r5 = r3.getValue()
            z3.l r5 = (z3.l) r5
            java.util.Set r5 = r5.f4819d
            java.util.Iterator r5 = r5.iterator()
        L_0x00a2:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00f6
            java.lang.Object r7 = r5.next()
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            java.util.List r8 = r2.f6361a
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
            boolean r8 = r8.contains(r9)
            if (r8 == 0) goto L_0x00a2
            E2.i r8 = new E2.i
            E2.k r9 = E2.k.REQUIRE_CONSENT
            r8.<init>(r7, r9)
            java.lang.String r7 = r8.a()
            java.util.Map r8 = r2.f6363c
            java.lang.Object r8 = r8.get(r7)
            if (r8 != 0) goto L_0x00db
            java.util.Map r8 = r2.f6363c
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.put(r7, r9)
        L_0x00db:
            java.util.Map r8 = r2.f6363c
            java.lang.Object r7 = r8.get(r7)
            java.util.Set r7 = (java.util.Set) r7
            if (r7 != 0) goto L_0x00e6
            goto L_0x00a2
        L_0x00e6:
            java.lang.Object r8 = r3.getValue()
            z3.l r8 = (z3.l) r8
            int r8 = r8.f4812a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7.add(r8)
            goto L_0x00a2
        L_0x00f6:
            java.lang.Object r5 = r3.getValue()
            z3.l r5 = (z3.l) r5
            java.util.Set r5 = r5.f4820e
            java.util.Iterator r5 = r5.iterator()
        L_0x0102:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x008a
            java.lang.Object r7 = r5.next()
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            java.util.List r8 = r2.f6362b
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
            boolean r8 = r8.contains(r9)
            if (r8 == 0) goto L_0x0102
            E2.i r8 = new E2.i
            E2.k r9 = E2.k.REQUIRE_LI
            r8.<init>(r7, r9)
            java.lang.String r7 = r8.a()
            java.util.Map r8 = r2.f6363c
            java.lang.Object r8 = r8.get(r7)
            if (r8 != 0) goto L_0x013b
            java.util.Map r8 = r2.f6363c
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.put(r7, r9)
        L_0x013b:
            java.util.Map r8 = r2.f6363c
            java.lang.Object r7 = r8.get(r7)
            java.util.Set r7 = (java.util.Set) r7
            if (r7 != 0) goto L_0x0146
            goto L_0x0102
        L_0x0146:
            java.lang.Object r8 = r3.getValue()
            z3.l r8 = (z3.l) r8
            int r8 = r8.f4812a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r7.add(r8)
            goto L_0x0102
        L_0x0156:
            E2.s r11 = r6.f1115b
            C3.f r2 = r6.f1116c
            C3.a r2 = r2.f170b
            java.lang.String r2 = r2.f133f
            r11.b(r2)
            com.inmobi.cmp.ChoiceCmp r11 = INSTANCE
            r0.f11768c = r4
            java.lang.Object r11 = r11.d(r0)
            if (r11 != r1) goto L_0x016c
        L_0x016b:
            return r1
        L_0x016c:
            R2.s r11 = R2.s.f8222a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.e(V2.d):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        if (r7 == r1) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006e, code lost:
        if (r7.a(r0) != r1) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0070, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(V2.d r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.inmobi.cmp.ChoiceCmp.f
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.inmobi.cmp.ChoiceCmp$f r0 = (com.inmobi.cmp.ChoiceCmp.f) r0
            int r1 = r0.f11771c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11771c = r1
            goto L_0x0018
        L_0x0013:
            com.inmobi.cmp.ChoiceCmp$f r0 = new com.inmobi.cmp.ChoiceCmp$f
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f11769a
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f11771c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            R2.n.b(r7)
            goto L_0x0071
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0034:
            R2.n.b(r7)
            goto L_0x005b
        L_0x0038:
            R2.n.b(r7)
            b.m r7 = f11753d
            r2 = 0
            if (r7 != 0) goto L_0x0046
            java.lang.String r7 = "viewModel"
            kotlin.jvm.internal.m.u(r7)
            r7 = r2
        L_0x0046:
            r0.f11771c = r4
            r7.getClass()
            o3.G r4 = o3.Y.b()
            b.j r5 = new b.j
            r5.<init>(r7, r2)
            java.lang.Object r7 = o3.C0977g.g(r4, r5, r0)
            if (r7 != r1) goto L_0x005b
            goto L_0x0070
        L_0x005b:
            A3.a r7 = (A3.a) r7
            b4.d r2 = b4.d.f24465a
            java.lang.String r2 = "mspaConfig"
            kotlin.jvm.internal.m.e(r7, r2)
            b4.d.f24477m = r7
            com.inmobi.cmp.ChoiceCmp r7 = INSTANCE
            r0.f11771c = r3
            java.lang.Object r7 = r7.a(r0)
            if (r7 != r1) goto L_0x0071
        L_0x0070:
            return r1
        L_0x0071:
            R2.s r7 = R2.s.f8222a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.f(V2.d):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        if (r9 == r1) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x011e, code lost:
        if (r9.b(r0) == r1) goto L_0x0120;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0120, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(V2.d r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.inmobi.cmp.ChoiceCmp.g
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.inmobi.cmp.ChoiceCmp$g r0 = (com.inmobi.cmp.ChoiceCmp.g) r0
            int r1 = r0.f11774c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11774c = r1
            goto L_0x0018
        L_0x0013:
            com.inmobi.cmp.ChoiceCmp$g r0 = new com.inmobi.cmp.ChoiceCmp$g
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f11772a
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f11774c
            java.lang.String r3 = "viewModel"
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x003c
            if (r2 == r5) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            R2.n.b(r9)
            goto L_0x0121
        L_0x0030:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0038:
            R2.n.b(r9)
            goto L_0x005d
        L_0x003c:
            R2.n.b(r9)
            b.m r9 = f11753d
            if (r9 != 0) goto L_0x0047
            kotlin.jvm.internal.m.u(r3)
            r9 = r6
        L_0x0047:
            r0.f11774c = r5
            r9.getClass()
            o3.G r2 = o3.Y.b()
            b.f r5 = new b.f
            r5.<init>(r9, r6)
            java.lang.Object r9 = o3.C0977g.g(r2, r5, r0)
            if (r9 != r1) goto L_0x005d
            goto L_0x0120
        L_0x005d:
            C3.f r9 = (C3.f) r9
            C3.a r2 = r9.f170b
            java.lang.String r2 = r2.f132e
            boolean r2 = m3.m.N(r2)
            if (r2 != 0) goto L_0x0121
            b.m r2 = f11753d
            if (r2 != 0) goto L_0x0071
            kotlin.jvm.internal.m.u(r3)
            goto L_0x0072
        L_0x0071:
            r6 = r2
        L_0x0072:
            r6.getClass()
            java.lang.String r2 = "config"
            kotlin.jvm.internal.m.e(r9, r2)
            C3.f r2 = r6.f1116c
            C3.g r3 = r9.f169a
            r2.getClass()
            java.lang.String r5 = "<set-?>"
            kotlin.jvm.internal.m.e(r3, r5)
            r2.f169a = r3
            C3.f r2 = r6.f1116c
            C3.a r3 = r9.f170b
            r2.getClass()
            kotlin.jvm.internal.m.e(r3, r5)
            r2.f170b = r3
            C3.f r2 = r6.f1116c
            C3.e r3 = r9.f171c
            r2.getClass()
            kotlin.jvm.internal.m.e(r3, r5)
            r2.f171c = r3
            C3.f r2 = r6.f1116c
            V3.e r3 = r9.f172d
            r2.getClass()
            kotlin.jvm.internal.m.e(r3, r5)
            r2.f172d = r3
            C3.f r2 = r6.f1116c
            V3.n r3 = r9.f174f
            r2.getClass()
            kotlin.jvm.internal.m.e(r3, r5)
            r2.f174f = r3
            E2.s r2 = r6.f1115b
            E2.j r2 = r2.f6390G
            C3.a r3 = r9.f170b
            java.util.List r3 = r3.f151x
            r2.getClass()
            kotlin.jvm.internal.m.e(r3, r5)
            r2.f6361a = r3
            C3.a r3 = r9.f170b
            java.util.List r3 = r3.f152y
            kotlin.jvm.internal.m.e(r3, r5)
            r2.f6362b = r3
            X3.w r2 = r6.f1120g
            r2.b(r9)
            com.inmobi.cmp.data.storage.SharedStorage r2 = r6.f1114a
            a4.a r3 = a4.a.GOOGLE_ENABLED
            C3.a r5 = r9.f170b
            boolean r5 = r5.f140m
            r2.getClass()
            java.lang.String r7 = "preferenceKey"
            kotlin.jvm.internal.m.e(r3, r7)
            android.content.SharedPreferences r2 = r2.f11786a
            android.content.SharedPreferences$Editor r2 = r2.edit()
            java.lang.String r3 = "editor"
            kotlin.jvm.internal.m.d(r2, r3)
            java.lang.String r3 = "google_enabled"
            r2.putBoolean(r3, r5)
            r2.apply()
            com.inmobi.cmp.data.storage.SharedStorage r2 = r6.f1114a
            a4.a r3 = a4.a.PORTAL_CHOICE_LANG
            boolean r5 = r6.l()
            if (r5 == 0) goto L_0x0106
            java.lang.String r5 = "EN"
            goto L_0x010a
        L_0x0106:
            C3.a r5 = r9.f170b
            java.lang.String r5 = r5.f142o
        L_0x010a:
            r2.e(r3, r5)
            b4.d r2 = b4.d.f24465a
            java.lang.String r2 = "portalConfig"
            kotlin.jvm.internal.m.e(r9, r2)
            b4.d.f24472h = r9
            com.inmobi.cmp.ChoiceCmp r9 = INSTANCE
            r0.f11774c = r4
            java.lang.Object r9 = r9.b(r0)
            if (r9 != r1) goto L_0x0121
        L_0x0120:
            return r1
        L_0x0121:
            R2.s r9 = R2.s.f8222a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.g(V2.d):java.lang.Object");
    }

    public final String getAppPackageId() {
        return f11751b;
    }

    public final ChoiceCmpCallback getCallback() {
        return f11750a;
    }

    public final E2.e getGoogleVendorList$app_release() {
        m mVar = f11753d;
        if (mVar == null) {
            kotlin.jvm.internal.m.u("viewModel");
            mVar = null;
        }
        return mVar.f1126m;
    }

    public final String getPCode() {
        return f11752c;
    }

    public final C3.f getPortalConfig$app_release() {
        m mVar = null;
        if (!isViewModelAvailable$app_release()) {
            return null;
        }
        m mVar2 = f11753d;
        if (mVar2 == null) {
            kotlin.jvm.internal.m.u("viewModel");
        } else {
            mVar = mVar2;
        }
        return mVar.f1116c;
    }

    public final E2.s getTcModel$app_release() {
        m mVar = null;
        if (!isViewModelAvailable$app_release()) {
            return null;
        }
        m mVar2 = f11753d;
        if (mVar2 == null) {
            kotlin.jvm.internal.m.u("viewModel");
        } else {
            mVar = mVar2;
        }
        return mVar.f1115b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        if (r7 == r1) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
        if (r7.e(r0) != r1) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(V2.d r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.inmobi.cmp.ChoiceCmp.h
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.inmobi.cmp.ChoiceCmp$h r0 = (com.inmobi.cmp.ChoiceCmp.h) r0
            int r1 = r0.f11777c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11777c = r1
            goto L_0x0018
        L_0x0013:
            com.inmobi.cmp.ChoiceCmp$h r0 = new com.inmobi.cmp.ChoiceCmp$h
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f11775a
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f11777c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            R2.n.b(r7)
            goto L_0x0068
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0034:
            R2.n.b(r7)
            goto L_0x005b
        L_0x0038:
            R2.n.b(r7)
            b.m r7 = f11753d
            r2 = 0
            if (r7 != 0) goto L_0x0046
            java.lang.String r7 = "viewModel"
            kotlin.jvm.internal.m.u(r7)
            r7 = r2
        L_0x0046:
            r0.f11777c = r4
            r7.getClass()
            o3.G r4 = o3.Y.b()
            b.k r5 = new b.k
            r5.<init>(r7, r2)
            java.lang.Object r7 = o3.C0977g.g(r4, r5, r0)
            if (r7 != r1) goto L_0x005b
            goto L_0x0067
        L_0x005b:
            V3.r r7 = (V3.r) r7
            com.inmobi.cmp.ChoiceCmp r7 = INSTANCE
            r0.f11777c = r3
            java.lang.Object r7 = r7.e(r0)
            if (r7 != r1) goto L_0x0068
        L_0x0067:
            return r1
        L_0x0068:
            R2.s r7 = R2.s.f8222a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.ChoiceCmp.h(V2.d):java.lang.Object");
    }

    public final boolean isViewModelAvailable$app_release() {
        m mVar = f11753d;
        if (mVar == null || !mVar.f1125l) {
            return false;
        }
        return true;
    }

    public final PingReturn ping$app_release(boolean z4, CmpStatus cmpStatus, DisplayStatus displayStatus) {
        Integer num;
        Integer num2;
        CmpStatus cmpStatus2 = cmpStatus;
        kotlin.jvm.internal.m.e(cmpStatus2, "cmpStatus");
        DisplayStatus displayStatus2 = displayStatus;
        kotlin.jvm.internal.m.e(displayStatus2, "displayStatus");
        if (f11753d != null) {
            m mVar = f11753d;
            m mVar2 = null;
            if (mVar == null) {
                kotlin.jvm.internal.m.u("viewModel");
                mVar = null;
            }
            Boolean valueOf = Boolean.valueOf(mVar.b());
            E2.s tcModel$app_release = getTcModel$app_release();
            if (tcModel$app_release == null) {
                num = null;
            } else {
                num = Integer.valueOf(tcModel$app_release.f6404n);
            }
            String valueOf2 = String.valueOf(num);
            E2.s tcModel$app_release2 = getTcModel$app_release();
            if (tcModel$app_release2 == null) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(tcModel$app_release2.f6403m);
            }
            m mVar3 = f11753d;
            if (mVar3 == null) {
                kotlin.jvm.internal.m.u("viewModel");
                mVar3 = null;
            }
            Integer valueOf3 = Integer.valueOf(mVar3.i());
            m mVar4 = f11753d;
            if (mVar4 == null) {
                kotlin.jvm.internal.m.u("viewModel");
            } else {
                mVar2 = mVar4;
            }
            return new PingReturn(valueOf, z4, cmpStatus2, displayStatus2, MBridgeConstans.NATIVE_VIDEO_VERSION, valueOf2, num2, valueOf3, Integer.valueOf(mVar2.h()));
        }
        C2.b.a(C2.b.f6277a, ChoiceError.MISSING_INITIALIZATION, (String) null, (String) null, (C2.c) null, (Throwable) null, 30);
        return new PingReturn((Boolean) null, false, CmpStatus.ERROR, DisplayStatus.HIDDEN, MBridgeConstans.NATIVE_VIDEO_VERSION, (String) null, (Integer) null, (Integer) null, (Integer) null);
    }

    public final void setAppPackageId(String str) {
        kotlin.jvm.internal.m.e(str, "<set-?>");
        f11751b = str;
    }

    public final void setCallback(ChoiceCmpCallback choiceCmpCallback) {
        f11750a = choiceCmpCallback;
    }

    public final void setPCode(String str) {
        kotlin.jvm.internal.m.e(str, "<set-?>");
        f11752c = str;
    }

    public final void a() {
        J j4 = f11754e;
        if (j4 == null) {
            j4 = K.a(P0.b((C1001s0) null, 1, (Object) null));
        }
        J j5 = j4;
        f11754e = j5;
        if (j5 != null) {
            C1001s0 unused = C0981i.d(j5, f11755f, (L) null, new k((V2.d) null), 2, (Object) null);
        }
    }

    public final Object a(V2.d dVar) {
        s sVar;
        C3.h hVar;
        C3.h hVar2;
        C3.h hVar3;
        Set<Number> set;
        Map map;
        int i4;
        Map map2;
        Map map3;
        int i5;
        Map map4;
        Map map5;
        Map map6;
        int i6;
        int i7;
        Map map7;
        int i8;
        Map map8;
        int i9;
        Map map9;
        int i10;
        Map map10;
        int i11;
        Map map11;
        Map map12;
        Map map13;
        m mVar = f11753d;
        if (mVar == null) {
            kotlin.jvm.internal.m.u("viewModel");
            mVar = null;
        }
        String j4 = mVar.f1114a.j(a4.a.GPP_STRING);
        if (j4.length() > 0) {
            b4.d dVar2 = b4.d.f24465a;
            kotlin.jvm.internal.m.e(j4, "gppString");
            b4.d.f24479o = new C2091a(j4);
        }
        m mVar2 = f11753d;
        if (mVar2 == null) {
            kotlin.jvm.internal.m.u("viewModel");
            mVar2 = null;
        }
        z3.e eVar = mVar2.f1115b.f6391a;
        if (!(eVar == null || (map13 = eVar.f4808i) == null)) {
            for (Map.Entry entry : map13.entrySet()) {
                if (((z3.l) entry.getValue()).f4820e.isEmpty()) {
                    z3.l lVar = (z3.l) entry.getValue();
                    if (lVar.f4819d.isEmpty()) {
                        if (lVar.f4820e.isEmpty()) {
                            if (lVar.f4822g.isEmpty()) {
                            }
                        }
                    }
                }
                if (!mVar2.f1115b.f6386C.contains(((z3.l) entry.getValue()).f4812a)) {
                    mVar2.f1115b.f6386C.set(((z3.l) entry.getValue()).f4812a);
                }
            }
        }
        z3.e eVar2 = mVar2.f1115b.f6391a;
        if (!(eVar2 == null || (map12 = eVar2.f4808i) == null)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry2 : map12.entrySet()) {
                if (((z3.l) entry2.getValue()).f4826k == null) {
                    linkedHashMap.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                if (!mVar2.f1115b.f6416z.contains(((z3.l) entry3.getValue()).f4812a)) {
                    mVar2.f1115b.f6416z.unset(((z3.l) entry3.getValue()).f4812a);
                }
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        z3.e eVar3 = mVar2.f1115b.f6391a;
        if (!(eVar3 == null || (map11 = eVar3.f4808i) == null)) {
            for (Map.Entry value : map11.entrySet()) {
                linkedHashSet.addAll(((z3.l) value.getValue()).f4819d);
            }
        }
        for (C3.d dVar3 : mVar2.f1116c.f171c.f166a) {
            linkedHashSet.addAll(dVar3.f164f);
        }
        z3.e eVar4 = mVar2.f1115b.f6391a;
        if (!(eVar4 == null || (map8 = eVar4.f4803d) == null)) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry4 : map8.entrySet()) {
                if (linkedHashSet.contains(Integer.valueOf(((z3.i) entry4.getValue()).f4812a))) {
                    linkedHashMap2.put(entry4.getKey(), entry4.getValue());
                }
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry5 : linkedHashMap2.entrySet()) {
                if (mVar2.f1116c.f170b.f135h.contains(Integer.valueOf(((z3.i) entry5.getValue()).f4812a)) || mVar2.f1116c.f170b.f146s.contains(Integer.valueOf(((z3.i) entry5.getValue()).f4812a))) {
                    linkedHashMap3.put(entry5.getKey(), entry5.getValue());
                }
            }
            for (Map.Entry entry6 : linkedHashMap3.entrySet()) {
                if (!mVar2.f1115b.f6408r.contains(((z3.i) entry6.getValue()).f4812a)) {
                    int i12 = ((z3.i) entry6.getValue()).f4812a;
                    z3.e eVar5 = mVar2.f1115b.f6391a;
                    if (eVar5 == null || (map9 = eVar5.f4803d) == null) {
                        i9 = 0;
                    } else {
                        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                        for (Map.Entry entry7 : map9.entrySet()) {
                            if (((z3.i) entry7.getValue()).f4812a == i12) {
                                linkedHashMap4.put(entry7.getKey(), entry7.getValue());
                            }
                        }
                        i9 = 0;
                        for (Map.Entry entry8 : linkedHashMap4.entrySet()) {
                            z3.e eVar6 = mVar2.f1115b.f6391a;
                            if (!(eVar6 == null || (map10 = eVar6.f4808i) == null)) {
                                LinkedHashMap linkedHashMap5 = new LinkedHashMap();
                                for (Map.Entry entry9 : map10.entrySet()) {
                                    if (((z3.l) entry9.getValue()).f4826k == null) {
                                        linkedHashMap5.put(entry9.getKey(), entry9.getValue());
                                    }
                                }
                                for (Map.Entry value2 : linkedHashMap5.entrySet()) {
                                    Set<Number> set2 = ((z3.l) value2.getValue()).f4819d;
                                    if (!b.l.a(set2) || !set2.isEmpty()) {
                                        i11 = 0;
                                        for (Number intValue : set2) {
                                            if (intValue.intValue() == i12 && (i11 = i11 + 1) < 0) {
                                                C1601o.n();
                                            }
                                        }
                                    } else {
                                        i11 = 0;
                                    }
                                    i9 += i11;
                                }
                            }
                            for (C3.d dVar4 : mVar2.f1116c.f171c.f166a) {
                                List<Number> list = dVar4.f164f;
                                if (!(list instanceof Collection) || !list.isEmpty()) {
                                    i10 = 0;
                                    for (Number intValue2 : list) {
                                        if (intValue2.intValue() == i12 && (i10 = i10 + 1) < 0) {
                                            C1601o.n();
                                        }
                                    }
                                } else {
                                    i10 = 0;
                                }
                                i9 += i10;
                            }
                            for (Number intValue3 : mVar2.f1116c.f170b.f146s) {
                                if (intValue3.intValue() == i12) {
                                    i9++;
                                }
                            }
                        }
                    }
                    if (i9 > 0) {
                        mVar2.f1115b.f6408r.unset(((z3.i) entry6.getValue()).f4812a);
                    }
                }
            }
        }
        z3.e eVar7 = mVar2.f1115b.f6391a;
        if (!(eVar7 == null || (map5 = eVar7.f4803d) == null)) {
            LinkedHashMap linkedHashMap6 = new LinkedHashMap();
            for (Map.Entry entry10 : map5.entrySet()) {
                if (mVar2.f1116c.f170b.f137j.contains(Integer.valueOf(((z3.i) entry10.getValue()).f4812a)) || mVar2.f1116c.f170b.f147t.contains(Integer.valueOf(((z3.i) entry10.getValue()).f4812a))) {
                    linkedHashMap6.put(entry10.getKey(), entry10.getValue());
                }
            }
            for (Map.Entry entry11 : linkedHashMap6.entrySet()) {
                if (!mVar2.f1115b.f6409s.contains(((z3.i) entry11.getValue()).f4812a)) {
                    int i13 = ((z3.i) entry11.getValue()).f4812a;
                    E2.s sVar2 = mVar2.f1115b;
                    z3.e eVar8 = sVar2.f6391a;
                    if (eVar8 == null || (map6 = eVar8.f4803d) == null) {
                        map6 = null;
                    } else if (!kotlin.jvm.internal.m.a(sVar2.f6398h, "DE")) {
                        LinkedHashMap linkedHashMap7 = new LinkedHashMap();
                        for (Map.Entry entry12 : map6.entrySet()) {
                            if (((z3.i) entry12.getValue()).f4812a != 1) {
                                linkedHashMap7.put(entry12.getKey(), entry12.getValue());
                            }
                        }
                        map6 = linkedHashMap7;
                    }
                    if (map6 == null) {
                        i6 = 0;
                    } else {
                        LinkedHashMap linkedHashMap8 = new LinkedHashMap();
                        for (Map.Entry entry13 : map6.entrySet()) {
                            if (((z3.i) entry13.getValue()).f4812a == i13) {
                                linkedHashMap8.put(entry13.getKey(), entry13.getValue());
                            }
                        }
                        i6 = 0;
                        for (Map.Entry entry14 : linkedHashMap8.entrySet()) {
                            z3.e eVar9 = mVar2.f1115b.f6391a;
                            if (!(eVar9 == null || (map7 = eVar9.f4808i) == null)) {
                                LinkedHashMap linkedHashMap9 = new LinkedHashMap();
                                for (Map.Entry entry15 : map7.entrySet()) {
                                    if (((z3.l) entry15.getValue()).f4826k == null) {
                                        linkedHashMap9.put(entry15.getKey(), entry15.getValue());
                                    }
                                }
                                for (Map.Entry value3 : linkedHashMap9.entrySet()) {
                                    Set<Number> set3 = ((z3.l) value3.getValue()).f4820e;
                                    if (!b.l.a(set3) || !set3.isEmpty()) {
                                        i8 = 0;
                                        for (Number intValue4 : set3) {
                                            if ((intValue4.intValue() == i13) && (i8 = i8 + 1) < 0) {
                                                C1601o.n();
                                            }
                                        }
                                    } else {
                                        i8 = 0;
                                    }
                                    i6 += i8;
                                }
                            }
                            for (C3.d dVar5 : mVar2.f1116c.f171c.f166a) {
                                List<Number> list2 = dVar5.f165g;
                                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                                    i7 = 0;
                                    for (Number intValue5 : list2) {
                                        if ((intValue5.intValue() == i13) && (i7 = i7 + 1) < 0) {
                                            C1601o.n();
                                        }
                                    }
                                } else {
                                    i7 = 0;
                                }
                                i6 += i7;
                            }
                            for (Number intValue6 : mVar2.f1116c.f170b.f147t) {
                                if (intValue6.intValue() == i13) {
                                    i6++;
                                }
                            }
                        }
                    }
                    if (i6 > 0) {
                        mVar2.f1115b.f6409s.set(((z3.i) entry11.getValue()).f4812a);
                    }
                }
            }
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        z3.e eVar10 = mVar2.f1115b.f6391a;
        if (!(eVar10 == null || (map4 = eVar10.f4808i) == null)) {
            for (Map.Entry value4 : map4.entrySet()) {
                linkedHashSet2.addAll(((z3.l) value4.getValue()).f4824i);
            }
        }
        z3.e eVar11 = mVar2.f1115b.f6391a;
        if (!(eVar11 == null || (map = eVar11.f4806g) == null)) {
            LinkedHashMap linkedHashMap10 = new LinkedHashMap();
            for (Map.Entry entry16 : map.entrySet()) {
                if (linkedHashSet2.contains(Integer.valueOf(((z3.d) entry16.getValue()).f4812a))) {
                    linkedHashMap10.put(entry16.getKey(), entry16.getValue());
                }
            }
            LinkedHashMap linkedHashMap11 = new LinkedHashMap();
            for (Map.Entry entry17 : linkedHashMap10.entrySet()) {
                if (mVar2.f1116c.f170b.f138k.contains(Integer.valueOf(((z3.d) entry17.getValue()).f4812a)) || mVar2.f1116c.f170b.f150w.contains(Integer.valueOf(((z3.d) entry17.getValue()).f4812a))) {
                    linkedHashMap11.put(entry17.getKey(), entry17.getValue());
                }
            }
            for (Map.Entry entry18 : linkedHashMap11.entrySet()) {
                if (!mVar2.f1115b.f6407q.contains(((z3.d) entry18.getValue()).f4812a)) {
                    int i14 = ((z3.d) entry18.getValue()).f4812a;
                    z3.e eVar12 = mVar2.f1115b.f6391a;
                    if (eVar12 == null || (map2 = eVar12.f4806g) == null) {
                        i4 = 0;
                    } else {
                        LinkedHashMap linkedHashMap12 = new LinkedHashMap();
                        for (Map.Entry entry19 : map2.entrySet()) {
                            if (((z3.d) entry19.getValue()).f4812a == i14) {
                                linkedHashMap12.put(entry19.getKey(), entry19.getValue());
                            }
                        }
                        i4 = 0;
                        for (Map.Entry entry20 : linkedHashMap12.entrySet()) {
                            z3.e eVar13 = mVar2.f1115b.f6391a;
                            if (!(eVar13 == null || (map3 = eVar13.f4808i) == null)) {
                                LinkedHashMap linkedHashMap13 = new LinkedHashMap();
                                for (Map.Entry entry21 : map3.entrySet()) {
                                    if (((z3.l) entry21.getValue()).f4826k == null) {
                                        linkedHashMap13.put(entry21.getKey(), entry21.getValue());
                                    }
                                }
                                for (Map.Entry value5 : linkedHashMap13.entrySet()) {
                                    Set<Number> set4 = ((z3.l) value5.getValue()).f4824i;
                                    if (!b.l.a(set4) || !set4.isEmpty()) {
                                        i5 = 0;
                                        for (Number intValue7 : set4) {
                                            if ((intValue7.intValue() == i14) && (i5 = i5 + 1) < 0) {
                                                C1601o.n();
                                            }
                                        }
                                    } else {
                                        i5 = 0;
                                    }
                                    i4 += i5;
                                }
                            }
                            for (Number intValue8 : mVar2.f1116c.f170b.f150w) {
                                if (intValue8.intValue() == i14) {
                                    i4++;
                                }
                            }
                        }
                    }
                    if (i4 > 0) {
                        mVar2.f1115b.f6407q.unset(((z3.d) entry18.getValue()).f4812a);
                    }
                }
            }
        }
        for (C3.d dVar6 : mVar2.f1116c.f171c.f166a) {
            if (mVar2.c(C1601o.d0(dVar6.f164f))) {
                mVar2.f1115b.f6384A.unset(dVar6.f159a);
            }
            if (!dVar6.f165g.isEmpty()) {
                mVar2.f1115b.f6387D.set(dVar6.f159a);
            }
        }
        mVar2.p();
        String j5 = mVar2.f1114a.j(a4.a.ADDTL_CONSENT);
        if (!(j5.length() > 0)) {
            j5 = null;
        }
        if (j5 != null) {
            kotlin.jvm.internal.m.e(j5, "acString");
            if (j5.length() <= 2) {
                set = N.d();
            } else {
                String substring = j5.substring(2);
                kotlin.jvm.internal.m.d(substring, "this as java.lang.String).substring(startIndex)");
                List<String> j02 = m3.m.j0(substring, new String[]{"."}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList(C1601o.p(j02, 10));
                for (String parseInt : j02) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(parseInt)));
                }
                set = C1601o.d0(arrayList);
            }
            for (Number intValue9 : set) {
                mVar2.f1115b.f6385B.set(intValue9.intValue());
            }
        }
        SharedStorage sharedStorage = mVar2.f1114a;
        a4.a aVar = a4.a.NON_IAB_VENDOR_CONSENTS;
        if (sharedStorage.j(aVar).length() > 0) {
            Vector vector = mVar2.f1115b.f6384A;
            String j6 = mVar2.f1114a.j(aVar);
            Vector vector2 = new Vector((Map) null, 1, (C2103g) null);
            int i15 = 0;
            int i16 = 0;
            while (i15 < j6.length()) {
                char charAt = j6.charAt(i15);
                i15++;
                i16++;
                if (charAt == '1') {
                    vector2.set(i16);
                }
            }
            vector.setOwnedItems(vector2);
            Vector vector3 = mVar2.f1115b.f6387D;
            String j7 = mVar2.f1114a.j(a4.a.NON_IAB_VENDOR_LEG_INTERESTS);
            Vector vector4 = new Vector((Map) null, 1, (C2103g) null);
            int i17 = 0;
            int i18 = 0;
            while (i17 < j7.length()) {
                char charAt2 = j7.charAt(i17);
                i17++;
                i18++;
                if (charAt2 == '1') {
                    vector4.set(i18);
                }
            }
            vector3.unset(vector4);
        }
        m mVar3 = f11753d;
        if (mVar3 == null) {
            kotlin.jvm.internal.m.u("viewModel");
            mVar3 = null;
        }
        if (!mVar3.n()) {
            mVar3.f1114a.c(a4.a.VENDOR_LIST_VERSION, mVar3.i());
            SharedStorage sharedStorage2 = mVar3.f1114a;
            a4.a aVar2 = a4.a.VENDOR_LIST_LAST_UPDATED;
            long currentTimeMillis = System.currentTimeMillis();
            sharedStorage2.getClass();
            kotlin.jvm.internal.m.e(aVar2, "preferenceKey");
            SharedPreferences.Editor edit = sharedStorage2.f11786a.edit();
            kotlin.jvm.internal.m.d(edit, "editor");
            edit.putLong("gvl_last_updated", currentTimeMillis);
            edit.apply();
        }
        SharedStorage sharedStorage3 = mVar3.f1114a;
        a4.a aVar3 = a4.a.NON_IAB_VENDOR_CONSENT_HASH;
        String m4 = kotlin.jvm.internal.m.m(sharedStorage3.j(aVar3), mVar3.f());
        SharedStorage sharedStorage4 = mVar3.f1114a;
        a4.a aVar4 = a4.a.OPTION_HASH;
        if (!kotlin.jvm.internal.m.a(m4, sharedStorage4.j(aVar4))) {
            if (kotlin.jvm.internal.m.a(mVar3.f1114a.j(aVar3), "")) {
                mVar3.f1114a.e(aVar3, C2589b.b(mVar3.f1115b.f6384A.toString()));
            }
            mVar3.f1114a.e(a4.a.PORTAL_CONFIG_HASH, mVar3.f());
            SharedStorage sharedStorage5 = mVar3.f1114a;
            sharedStorage5.e(aVar4, kotlin.jvm.internal.m.m(sharedStorage5.j(aVar3), mVar3.f()));
            mVar3.f1114a.e(a4.a.PORTAL_NON_HASH, mVar3.f1116c.f170b.f149v.toString());
        }
        if (!mVar3.m()) {
            mVar3.f1114a.e(a4.a.GBC_PURPOSE_HASH, "");
        }
        String str = mVar3.f1116c.f170b.f117I;
        if (kotlin.jvm.internal.m.a(str, PrivacyEncodingMode.GPP.getValue())) {
            mVar3.q();
        } else if (kotlin.jvm.internal.m.a(str, PrivacyEncodingMode.TCF.getValue())) {
            mVar3.r();
        } else {
            mVar3.q();
            mVar3.r();
        }
        m mVar4 = f11753d;
        if (mVar4 == null) {
            kotlin.jvm.internal.m.u("viewModel");
            mVar4 = null;
        }
        C3.a aVar5 = mVar4.f1116c.f170b;
        if (!mVar4.l()) {
            mVar4.f1114a.e(a4.a.PRIVACY_STRING, "1---");
        } else {
            String j8 = mVar4.f1114a.j(a4.a.SAVED_PRIVACY_STRING);
            if (j8.length() > 0) {
                mVar4.f1114a.e(a4.a.PRIVACY_STRING, j8);
            } else {
                try {
                    P2.b bVar = mVar4.f1127n;
                    if (bVar == null) {
                        sVar = null;
                    } else {
                        List list3 = aVar5.f130c;
                        String substring2 = bVar.f7989a.substring(0, 2);
                        kotlin.jvm.internal.m.d(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        Locale locale = Locale.ROOT;
                        kotlin.jvm.internal.m.d(locale, "ROOT");
                        String upperCase = substring2.toUpperCase(locale);
                        kotlin.jvm.internal.m.d(upperCase, "this as java.lang.String).toUpperCase(locale)");
                        if (!list3.contains(upperCase)) {
                            List list4 = aVar5.f130c;
                            String substring3 = bVar.f7990b.substring(0, 2);
                            kotlin.jvm.internal.m.d(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                            kotlin.jvm.internal.m.d(locale, "ROOT");
                            String upperCase2 = substring3.toUpperCase(locale);
                            kotlin.jvm.internal.m.d(upperCase2, "this as java.lang.String).toUpperCase(locale)");
                            if (!list4.contains(upperCase2)) {
                                mVar4.f1114a.e(a4.a.PRIVACY_STRING, "1---");
                            }
                        }
                        sVar = s.f8222a;
                    }
                    if (sVar != null) {
                        SharedStorage sharedStorage6 = mVar4.f1114a;
                        if (kotlin.jvm.internal.m.a(sharedStorage6.a(1, 2), "Y")) {
                            hVar = C3.h.YES;
                        } else {
                            hVar = C3.h.NO;
                        }
                        C3.h hVar4 = hVar;
                        if (kotlin.jvm.internal.m.a(mVar4.f1114a.a(2, 3), "Y")) {
                            hVar2 = C3.h.YES;
                        } else {
                            hVar2 = C3.h.NO;
                        }
                        C3.h hVar5 = hVar2;
                        if (kotlin.jvm.internal.m.a(aVar5.f131d, "Y")) {
                            hVar3 = C3.h.YES;
                        } else {
                            hVar3 = C3.h.NO;
                        }
                        SharedStorage.f(sharedStorage6, 0, hVar4, hVar5, hVar3, 1, (Object) null);
                    }
                } catch (StringIndexOutOfBoundsException unused) {
                    C2.b.a(C2.b.f6277a, ChoiceError.GEO_IP_UNEXPECTED_ERROR, (String) null, (String) null, (C2.c) null, (Throwable) null, 30);
                }
            }
        }
        m mVar5 = f11753d;
        if (mVar5 == null) {
            kotlin.jvm.internal.m.u("viewModel");
            mVar5 = null;
        }
        for (C3.b bVar2 : mVar5.f1116c.f170b.f127S.f158c) {
            c.i.f1157a.d(bVar2.f154a, bVar2.f155b);
        }
        m mVar6 = f11753d;
        if (mVar6 == null) {
            kotlin.jvm.internal.m.u("viewModel");
            mVar6 = null;
        }
        SharedStorage sharedStorage7 = mVar6.f1114a;
        a4.a aVar6 = a4.a.MSPA_SHOWN;
        boolean h4 = sharedStorage7.h(aVar6);
        A3.i.f85e = h4;
        SharedStorage m5 = b4.d.f24465a.m();
        m5.getClass();
        kotlin.jvm.internal.m.e(aVar6, "preferenceKey");
        SharedPreferences.Editor edit2 = m5.f11786a.edit();
        kotlin.jvm.internal.m.d(edit2, "editor");
        edit2.putBoolean("MSPAShown", h4);
        edit2.apply();
        m mVar7 = f11753d;
        if (mVar7 == null) {
            kotlin.jvm.internal.m.u("viewModel");
            mVar7 = null;
        }
        mVar7.f1125l = true;
        if (!b4.c.f24462a) {
            return s.f8222a;
        }
        Object g4 = C0977g.g(Y.c().D(), new a((V2.d) null), dVar);
        return g4 == W2.b.c() ? g4 : s.f8222a;
    }

    public static final class i extends V2.a implements H {
        public i(H.a aVar) {
            super(aVar);
        }

        public void r(V2.g gVar, Throwable th) {
        }
    }
}
