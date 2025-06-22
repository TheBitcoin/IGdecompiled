package com.uptodown.activities;

import J1.C1333d0;
import J1.C1340e0;
import J1.C1347f0;
import M1.C1535l;
import N1.k;
import R2.g;
import R2.h;
import R2.n;
import R2.s;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c2.N;
import com.uptodown.R;
import com.uptodown.activities.preferences.a;
import d3.p;
import f2.C2030v;
import g2.C2066y;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import u2.t;

public final class LanguageSettingsActivity extends C1826a {
    /* access modifiers changed from: private */

    /* renamed from: J  reason: collision with root package name */
    public C1535l f17735J;
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public a f17736K = new a(this);

    /* renamed from: L  reason: collision with root package name */
    private final g f17737L = h.a(new C1333d0(this));

    /* renamed from: M  reason: collision with root package name */
    private final LifecycleCoroutineScope f17738M = LifecycleOwnerKt.getLifecycleScope(this);

    public static final class a implements C2030v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LanguageSettingsActivity f17739a;

        a(LanguageSettingsActivity languageSettingsActivity) {
            this.f17739a = languageSettingsActivity;
        }

        public void a(C2066y yVar) {
            m.e(yVar, "lang");
            if (yVar.a() != null) {
                LanguageSettingsActivity languageSettingsActivity = this.f17739a;
                String a5 = yVar.a();
                m.b(a5);
                languageSettingsActivity.k3(a5);
            }
        }
    }

    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f17740a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f17741b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ LanguageSettingsActivity f17742c;

        /* renamed from: d  reason: collision with root package name */
        int f17743d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(LanguageSettingsActivity languageSettingsActivity, V2.d dVar) {
            super(dVar);
            this.f17742c = languageSettingsActivity;
        }

        public final Object invokeSuspend(Object obj) {
            this.f17741b = obj;
            this.f17743d |= Integer.MIN_VALUE;
            return this.f17742c.m3(this);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17744a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LanguageSettingsActivity f17745b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(LanguageSettingsActivity languageSettingsActivity, V2.d dVar) {
            super(2, dVar);
            this.f17745b = languageSettingsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f17745b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17744a == 0) {
                n.b(obj);
                this.f17745b.l3().f9852b.setVisibility(0);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17746a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LanguageSettingsActivity f17747b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(LanguageSettingsActivity languageSettingsActivity, V2.d dVar) {
            super(2, dVar);
            this.f17747b = languageSettingsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f17747b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17746a == 0) {
                n.b(obj);
                ArrayList arrayList = new ArrayList();
                String[] stringArray = this.f17747b.getResources().getStringArray(R.array.languages);
                m.d(stringArray, "getStringArray(...)");
                String[] stringArray2 = this.f17747b.getResources().getStringArray(R.array.languageCodes);
                m.d(stringArray2, "getStringArray(...)");
                String[] stringArray3 = this.f17747b.getResources().getStringArray(R.array.localizedLang);
                m.d(stringArray3, "getStringArray(...)");
                int length = stringArray.length;
                for (int i4 = 0; i4 < length; i4++) {
                    String str = stringArray[i4];
                    C2066y yVar = new C2066y();
                    yVar.f(str);
                    yVar.e(stringArray3[i4]);
                    yVar.d(stringArray2[i4]);
                    arrayList.add(yVar);
                }
                String p4 = com.uptodown.activities.preferences.a.f18818a.p(this.f17747b);
                if (p4 == null) {
                    p4 = "en";
                }
                LanguageSettingsActivity languageSettingsActivity = this.f17747b;
                languageSettingsActivity.f17735J = new C1535l(arrayList, languageSettingsActivity.f17736K, p4);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17748a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LanguageSettingsActivity f17749b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(LanguageSettingsActivity languageSettingsActivity, V2.d dVar) {
            super(2, dVar);
            this.f17749b = languageSettingsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f17749b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17748a == 0) {
                n.b(obj);
                RecyclerView recyclerView = this.f17749b.l3().f9853c;
                C1535l e32 = this.f17749b.f17735J;
                if (e32 == null) {
                    m.u("adapter");
                    e32 = null;
                }
                recyclerView.setAdapter(e32);
                this.f17749b.l3().f9852b.setVisibility(8);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17750a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LanguageSettingsActivity f17751b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(LanguageSettingsActivity languageSettingsActivity, V2.d dVar) {
            super(2, dVar);
            this.f17751b = languageSettingsActivity;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f17751b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f17750a;
            if (i4 == 0) {
                n.b(obj);
                LanguageSettingsActivity languageSettingsActivity = this.f17751b;
                this.f17750a = 1;
                if (languageSettingsActivity.m3(this) == c5) {
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

    /* access modifiers changed from: private */
    public static final N j3(LanguageSettingsActivity languageSettingsActivity) {
        return N.c(languageSettingsActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void k3(String str) {
        t a5 = t.f21927u.a(this);
        a5.a();
        a5.m1();
        a5.i();
        a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
        Context applicationContext = getApplicationContext();
        m.d(applicationContext, "getApplicationContext(...)");
        aVar.M0(applicationContext, str);
        setResult(PointerIconCompat.TYPE_HELP);
        finish();
    }

    /* access modifiers changed from: private */
    public final N l3() {
        return (N) this.f17737L.getValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0071, code lost:
        if (o3.C0977g.g(r8, r5, r0) != r1) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0085, code lost:
        if (o3.C0977g.g(r8, r4, r0) == r1) goto L_0x0087;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m3(V2.d r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.uptodown.activities.LanguageSettingsActivity.b
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.uptodown.activities.LanguageSettingsActivity$b r0 = (com.uptodown.activities.LanguageSettingsActivity.b) r0
            int r1 = r0.f17743d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f17743d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.activities.LanguageSettingsActivity$b r0 = new com.uptodown.activities.LanguageSettingsActivity$b
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f17741b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f17743d
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0048
            if (r2 == r5) goto L_0x0040
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            R2.n.b(r8)
            goto L_0x0088
        L_0x0030:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0038:
            java.lang.Object r2 = r0.f17740a
            com.uptodown.activities.LanguageSettingsActivity r2 = (com.uptodown.activities.LanguageSettingsActivity) r2
            R2.n.b(r8)
            goto L_0x0074
        L_0x0040:
            java.lang.Object r2 = r0.f17740a
            com.uptodown.activities.LanguageSettingsActivity r2 = (com.uptodown.activities.LanguageSettingsActivity) r2
            R2.n.b(r8)
            goto L_0x0060
        L_0x0048:
            R2.n.b(r8)
            o3.E0 r8 = o3.Y.c()
            com.uptodown.activities.LanguageSettingsActivity$c r2 = new com.uptodown.activities.LanguageSettingsActivity$c
            r2.<init>(r7, r6)
            r0.f17740a = r7
            r0.f17743d = r5
            java.lang.Object r8 = o3.C0977g.g(r8, r2, r0)
            if (r8 != r1) goto L_0x005f
            goto L_0x0087
        L_0x005f:
            r2 = r7
        L_0x0060:
            o3.G r8 = o3.Y.b()
            com.uptodown.activities.LanguageSettingsActivity$d r5 = new com.uptodown.activities.LanguageSettingsActivity$d
            r5.<init>(r2, r6)
            r0.f17740a = r2
            r0.f17743d = r4
            java.lang.Object r8 = o3.C0977g.g(r8, r5, r0)
            if (r8 != r1) goto L_0x0074
            goto L_0x0087
        L_0x0074:
            o3.E0 r8 = o3.Y.c()
            com.uptodown.activities.LanguageSettingsActivity$e r4 = new com.uptodown.activities.LanguageSettingsActivity$e
            r4.<init>(r2, r6)
            r0.f17740a = r6
            r0.f17743d = r3
            java.lang.Object r8 = o3.C0977g.g(r8, r4, r0)
            if (r8 != r1) goto L_0x0088
        L_0x0087:
            return r1
        L_0x0088:
            R2.s r8 = R2.s.f8222a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.LanguageSettingsActivity.m3(V2.d):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final void n3(LanguageSettingsActivity languageSettingsActivity, View view) {
        languageSettingsActivity.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void o3(View view) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView((View) l3().getRoot());
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
            if (drawable != null) {
                l3().f9854d.setNavigationIcon(drawable);
                l3().f9854d.setNavigationContentDescription((CharSequence) getString(R.string.back));
            }
            l3().f9855e.setTypeface(k.f7778g.w());
            l3().f9854d.setNavigationOnClickListener(new C1340e0(this));
            l3().f9852b.setOnClickListener(new C1347f0());
            l3().f9853c.setLayoutManager(new LinearLayoutManager(this, 1, false));
            l3().f9853c.setItemAnimator(new DefaultItemAnimator());
            C1001s0 unused = C0981i.d(this.f17738M, (V2.g) null, (L) null, new f(this, (V2.d) null), 3, (Object) null);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
