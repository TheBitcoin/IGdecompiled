package J1;

import N1.k;
import R2.n;
import R2.s;
import V2.d;
import V2.g;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.LifecycleOwnerKt;
import c2.O;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.uptodown.R;
import com.uptodown.activities.C1826a;
import d3.p;
import g2.U;
import k0.C0937l;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import u2.C2311A;
import u2.x;

/* renamed from: J1.x0  reason: case insensitive filesystem */
public abstract class C1472x0 extends C1826a {

    /* renamed from: J  reason: collision with root package name */
    private TextView f7192J;

    /* renamed from: K  reason: collision with root package name */
    private com.google.android.gms.auth.api.signin.b f7193K;

    /* renamed from: L  reason: collision with root package name */
    private final ActivityResultLauncher f7194L;

    /* renamed from: M  reason: collision with root package name */
    private final ActivityResultLauncher f7195M;

    /* renamed from: J1.x0$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f7196a;

        /* renamed from: b  reason: collision with root package name */
        int f7197b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ GoogleSignInAccount f7198c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C1472x0 f7199d;

        /* renamed from: J1.x0$a$a  reason: collision with other inner class name */
        static final class C0090a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f7200a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C1472x0 f7201b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0090a(C1472x0 x0Var, d dVar) {
                super(2, dVar);
                this.f7201b = x0Var;
            }

            public final d create(Object obj, d dVar) {
                return new C0090a(this.f7201b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f7200a == 0) {
                    n.b(obj);
                    this.f7201b.s3();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((C0090a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: J1.x0$a$b */
        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f7202a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2311A f7203b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C1472x0 f7204c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(C2311A a5, C1472x0 x0Var, d dVar) {
                super(2, dVar);
                this.f7203b = a5;
                this.f7204c = x0Var;
            }

            public final d create(Object obj, d dVar) {
                return new b(this.f7203b, this.f7204c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f7202a == 0) {
                    n.b(obj);
                    if (this.f7203b.e()) {
                        this.f7204c.r3(this.f7203b.c(), this.f7203b.b());
                        this.f7204c.setResult(-1);
                    } else {
                        this.f7204c.p3(this.f7203b.c());
                        this.f7204c.t3();
                        this.f7204c.setResult(1);
                        Bundle bundle = new Bundle();
                        bundle.putString("type", "success");
                        bundle.putString("loginSource", "google");
                        x m22 = this.f7204c.m2();
                        if (m22 != null) {
                            m22.d("login", bundle);
                        }
                    }
                    this.f7204c.h3();
                    U e5 = U.f20468m.e(this.f7204c);
                    if (e5 == null || !e5.m(this.f7204c)) {
                        this.f7204c.getOnBackPressedDispatcher().onBackPressed();
                    } else {
                        this.f7204c.finish();
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(GoogleSignInAccount googleSignInAccount, C1472x0 x0Var, d dVar) {
            super(2, dVar);
            this.f7198c = googleSignInAccount;
            this.f7199d = x0Var;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f7198c, this.f7199d, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0072, code lost:
            if (r1.g(r9, "google", r4, r8) == r0) goto L_0x008a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0088, code lost:
            if (o3.C0977g.g(r9, r3, r8) != r0) goto L_0x008b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r8.f7197b
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L_0x002f
                if (r1 == r4) goto L_0x0027
                if (r1 == r3) goto L_0x001f
                if (r1 != r2) goto L_0x0017
                R2.n.b(r9)
                goto L_0x008b
            L_0x0017:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x001f:
                java.lang.Object r1 = r8.f7196a
                u2.A r1 = (u2.C2311A) r1
                R2.n.b(r9)
                goto L_0x0075
            L_0x0027:
                java.lang.Object r1 = r8.f7196a
                u2.A r1 = (u2.C2311A) r1
                R2.n.b(r9)
                goto L_0x004e
            L_0x002f:
                R2.n.b(r9)
                u2.A r9 = new u2.A
                r9.<init>()
                o3.E0 r1 = o3.Y.c()
                J1.x0$a$a r6 = new J1.x0$a$a
                J1.x0 r7 = r8.f7199d
                r6.<init>(r7, r5)
                r8.f7196a = r9
                r8.f7197b = r4
                java.lang.Object r1 = o3.C0977g.g(r1, r6, r8)
                if (r1 != r0) goto L_0x004d
                goto L_0x008a
            L_0x004d:
                r1 = r9
            L_0x004e:
                com.google.android.gms.auth.api.signin.GoogleSignInAccount r9 = r8.f7198c
                java.lang.String r9 = r9.l()
                if (r9 == 0) goto L_0x0075
                int r9 = r9.length()
                if (r9 != 0) goto L_0x005d
                goto L_0x0075
            L_0x005d:
                com.google.android.gms.auth.api.signin.GoogleSignInAccount r9 = r8.f7198c
                java.lang.String r9 = r9.l()
                kotlin.jvm.internal.m.b(r9)
                J1.x0 r4 = r8.f7199d
                r8.f7196a = r1
                r8.f7197b = r3
                java.lang.String r3 = "google"
                java.lang.Object r9 = r1.g(r9, r3, r4, r8)
                if (r9 != r0) goto L_0x0075
                goto L_0x008a
            L_0x0075:
                o3.E0 r9 = o3.Y.c()
                J1.x0$a$b r3 = new J1.x0$a$b
                J1.x0 r4 = r8.f7199d
                r3.<init>(r1, r4, r5)
                r8.f7196a = r5
                r8.f7197b = r2
                java.lang.Object r9 = o3.C0977g.g(r9, r3, r8)
                if (r9 != r0) goto L_0x008b
            L_0x008a:
                return r0
            L_0x008b:
                R2.s r9 = R2.s.f8222a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: J1.C1472x0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: J1.x0$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f7205a;

        /* renamed from: b  reason: collision with root package name */
        int f7206b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ GoogleSignInAccount f7207c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C1472x0 f7208d;

        /* renamed from: J1.x0$b$a */
        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f7209a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2311A f7210b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C1472x0 f7211c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(C2311A a5, C1472x0 x0Var, d dVar) {
                super(2, dVar);
                this.f7210b = a5;
                this.f7211c = x0Var;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f7210b, this.f7211c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f7209a == 0) {
                    n.b(obj);
                    if (this.f7210b.e()) {
                        this.f7211c.setResult(-1);
                    } else {
                        this.f7211c.q3(this.f7210b.c());
                        this.f7211c.t3();
                        this.f7211c.setResult(1);
                        Bundle bundle = new Bundle();
                        bundle.putString("type", "success");
                        bundle.putString("loginSource", "google");
                        x m22 = this.f7211c.m2();
                        if (m22 != null) {
                            m22.d("login", bundle);
                        }
                    }
                    U e5 = U.f20468m.e(this.f7211c);
                    if (e5 != null && e5.m(this.f7211c)) {
                        this.f7211c.j3();
                        this.f7211c.o3();
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(GoogleSignInAccount googleSignInAccount, C1472x0 x0Var, d dVar) {
            super(2, dVar);
            this.f7207c = googleSignInAccount;
            this.f7208d = x0Var;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f7207c, this.f7208d, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
            if (r1.g(r7, "google", r4, r6) == r0) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0065, code lost:
            if (o3.C0977g.g(r7, r3, r6) == r0) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0067, code lost:
            return r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r6.f7206b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0022
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                R2.n.b(r7)
                goto L_0x0068
            L_0x0012:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x001a:
                java.lang.Object r1 = r6.f7205a
                u2.A r1 = (u2.C2311A) r1
                R2.n.b(r7)
                goto L_0x0051
            L_0x0022:
                R2.n.b(r7)
                u2.A r1 = new u2.A
                r1.<init>()
                com.google.android.gms.auth.api.signin.GoogleSignInAccount r7 = r6.f7207c
                java.lang.String r7 = r7.l()
                if (r7 == 0) goto L_0x0051
                int r7 = r7.length()
                if (r7 != 0) goto L_0x0039
                goto L_0x0051
            L_0x0039:
                com.google.android.gms.auth.api.signin.GoogleSignInAccount r7 = r6.f7207c
                java.lang.String r7 = r7.l()
                kotlin.jvm.internal.m.b(r7)
                J1.x0 r4 = r6.f7208d
                r6.f7205a = r1
                r6.f7206b = r3
                java.lang.String r3 = "google"
                java.lang.Object r7 = r1.g(r7, r3, r4, r6)
                if (r7 != r0) goto L_0x0051
                goto L_0x0067
            L_0x0051:
                o3.E0 r7 = o3.Y.c()
                J1.x0$b$a r3 = new J1.x0$b$a
                J1.x0 r4 = r6.f7208d
                r5 = 0
                r3.<init>(r1, r4, r5)
                r6.f7205a = r5
                r6.f7206b = r2
                java.lang.Object r7 = o3.C0977g.g(r7, r3, r6)
                if (r7 != r0) goto L_0x0068
            L_0x0067:
                return r0
            L_0x0068:
                R2.s r7 = R2.s.f8222a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: J1.C1472x0.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1472x0() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1458v0(this));
        m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f7194L = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1465w0(this));
        m.d(registerForActivityResult2, "registerForActivityResult(...)");
        this.f7195M = registerForActivityResult2;
    }

    private final void f3(RelativeLayout relativeLayout) {
        relativeLayout.setOnClickListener(new C1451u0(this));
    }

    /* access modifiers changed from: private */
    public static final void g3(C1472x0 x0Var, View view) {
        x0Var.s3();
        x0Var.m3();
    }

    /* access modifiers changed from: private */
    public static final void k3(C1472x0 x0Var, ActivityResult activityResult) {
        GoogleSignInAccount googleSignInAccount;
        if (activityResult.getData() != null) {
            C0937l b5 = com.google.android.gms.auth.api.signin.a.b(activityResult.getData());
            m.d(b5, "getSignedInAccountFromIntent(...)");
            if (b5.n() && (googleSignInAccount = (GoogleSignInAccount) b5.j()) != null) {
                C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(x0Var), (g) null, (L) null, new a(googleSignInAccount, x0Var, (d) null), 3, (Object) null);
            }
        }
        x0Var.h3();
    }

    /* access modifiers changed from: private */
    public static final void l3(C1472x0 x0Var, ActivityResult activityResult) {
        GoogleSignInAccount googleSignInAccount;
        if (activityResult.getData() != null) {
            C0937l b5 = com.google.android.gms.auth.api.signin.a.b(activityResult.getData());
            m.d(b5, "getSignedInAccountFromIntent(...)");
            if (b5.n() && (googleSignInAccount = (GoogleSignInAccount) b5.j()) != null) {
                C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(x0Var), (g) null, (L) null, new b(googleSignInAccount, x0Var, (d) null), 3, (Object) null);
            }
        }
    }

    private final void m3() {
        com.google.android.gms.auth.api.signin.b bVar = this.f7193K;
        m.b(bVar);
        Intent q4 = bVar.q();
        m.d(q4, "getSignInIntent(...)");
        this.f7194L.launch(q4);
    }

    /* access modifiers changed from: private */
    public final void q3(U u4) {
        String str;
        if (u4 != null) {
            u4.p(this);
        }
        try {
            if (u4 != null) {
                str = u4.h();
            } else {
                str = null;
            }
            AccountManager.get(getBaseContext()).addAccountExplicitly(new Account(str, getString(R.string.account)), (String) null, (Bundle) null);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final TextView e3() {
        return this.f7192J;
    }

    /* access modifiers changed from: protected */
    public abstract void h3();

    public final void i3(O o4) {
        m.e(o4, "binding");
        TextView textView = o4.f9870c.f9886i;
        k.a aVar = k.f7778g;
        textView.setTypeface(aVar.w());
        RelativeLayout relativeLayout = o4.f9870c.f9883f;
        m.d(relativeLayout, "rlGoogleLogin");
        f3(relativeLayout);
        o4.f9871d.f9749k.setTypeface(aVar.w());
        RelativeLayout relativeLayout2 = o4.f9871d.f9746h;
        m.d(relativeLayout2, "rlGoogleLogin");
        f3(relativeLayout2);
    }

    public U j3() {
        return null;
    }

    public final void n3() {
        Intent q4 = new C2311A().d(this).q();
        m.d(q4, "getSignInIntent(...)");
        this.f7195M.launch(q4);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7193K = new C2311A().d(this);
    }

    /* access modifiers changed from: protected */
    public abstract void p3(U u4);

    /* access modifiers changed from: protected */
    public abstract void r3(U u4, String str);

    /* access modifiers changed from: protected */
    public abstract void s3();

    /* access modifiers changed from: protected */
    public abstract void t3();

    public void o3() {
    }
}
