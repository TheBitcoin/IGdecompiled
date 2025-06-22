package d2;

import N1.k;
import R2.k;
import R2.n;
import R2.s;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import b2.o;
import c2.C1679n;
import c2.C1683p;
import c2.W0;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1826a;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.activities.PreregistrationActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.RollbackActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.U;
import com.uptodown.activities.Updates;
import com.uptodown.activities.UserAvatarActivity;
import com.uptodown.activities.UserCommentsActivity;
import com.uptodown.activities.UserDeviceDetailsActivity;
import com.uptodown.activities.UserDevicesActivity;
import com.uptodown.activities.UserEditProfileActivity;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.activities.preferences.a;
import com.uptodown.util.views.UsernameTextView;
import d3.p;
import f2.K;
import g2.U;
import g2.V;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;
import r3.C1036f;
import r3.I;
import u2.E;
import u2.q;
import u2.t;
import u2.x;

public final class C2 extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public W0 f19606a;

    /* renamed from: b  reason: collision with root package name */
    private final R2.g f19607b = FragmentViewModelLazyKt.createViewModelLazy(this, D.b(E2.class), new g(new f(this)), (d3.a) null);

    /* renamed from: c  reason: collision with root package name */
    private final R2.g f19608c = FragmentViewModelLazyKt.createViewModelLazy(this, D.b(U.class), new i(new h(this)), (d3.a) null);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f19609d;

    /* renamed from: e  reason: collision with root package name */
    private final ActivityResultLauncher f19610e;

    /* renamed from: f  reason: collision with root package name */
    private final ActivityResultLauncher f19611f;

    /* renamed from: g  reason: collision with root package name */
    private final ActivityResultLauncher f19612g;

    /* renamed from: h  reason: collision with root package name */
    private final ActivityResultLauncher f19613h;

    /* renamed from: i  reason: collision with root package name */
    private final ActivityResultLauncher f19614i;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19615a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2 f19616b;

        /* renamed from: d2.C2$a$a  reason: collision with other inner class name */
        static final class C0243a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2 f19617a;

            /* renamed from: d2.C2$a$a$a  reason: collision with other inner class name */
            static final class C0244a extends kotlin.coroutines.jvm.internal.d {

                /* renamed from: a  reason: collision with root package name */
                Object f19618a;

                /* renamed from: b  reason: collision with root package name */
                Object f19619b;

                /* renamed from: c  reason: collision with root package name */
                /* synthetic */ Object f19620c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ C0243a f19621d;

                /* renamed from: e  reason: collision with root package name */
                int f19622e;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0244a(C0243a aVar, V2.d dVar) {
                    super(dVar);
                    this.f19621d = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.f19620c = obj;
                    this.f19622e |= Integer.MIN_VALUE;
                    return this.f19621d.emit((E) null, this);
                }
            }

            C0243a(C2 c22) {
                this.f19617a = c22;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* renamed from: b */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(u2.E r5, V2.d r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof d2.C2.a.C0243a.C0244a
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    d2.C2$a$a$a r0 = (d2.C2.a.C0243a.C0244a) r0
                    int r1 = r0.f19622e
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f19622e = r1
                    goto L_0x0018
                L_0x0013:
                    d2.C2$a$a$a r0 = new d2.C2$a$a$a
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.f19620c
                    java.lang.Object r1 = W2.b.c()
                    int r2 = r0.f19622e
                    r3 = 1
                    if (r2 == 0) goto L_0x0039
                    if (r2 != r3) goto L_0x0031
                    java.lang.Object r5 = r0.f19619b
                    u2.E r5 = (u2.E) r5
                    java.lang.Object r0 = r0.f19618a
                    d2.C2$a$a r0 = (d2.C2.a.C0243a) r0
                    R2.n.b(r6)
                    goto L_0x0058
                L_0x0031:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0039:
                    R2.n.b(r6)
                    u2.E$a r6 = u2.E.a.f21883a
                    boolean r6 = kotlin.jvm.internal.m.a(r5, r6)
                    if (r6 != 0) goto L_0x0083
                    boolean r6 = r5 instanceof u2.E.c
                    if (r6 == 0) goto L_0x0074
                    r0.f19618a = r4
                    r0.f19619b = r5
                    r0.f19622e = r3
                    r2 = 1000(0x3e8, double:4.94E-321)
                    java.lang.Object r6 = o3.U.b(r2, r0)
                    if (r6 != r1) goto L_0x0057
                    return r1
                L_0x0057:
                    r0 = r4
                L_0x0058:
                    d2.C2 r6 = r0.f19617a
                    u2.E$c r5 = (u2.E.c) r5
                    java.lang.Object r0 = r5.a()
                    d2.E2$a r0 = (d2.E2.a) r0
                    int r0 = r0.b()
                    java.lang.Object r5 = r5.a()
                    d2.E2$a r5 = (d2.E2.a) r5
                    int r5 = r5.a()
                    r6.M0(r0, r5)
                    goto L_0x0083
                L_0x0074:
                    u2.E$b r6 = u2.E.b.f21884a
                    boolean r5 = kotlin.jvm.internal.m.a(r5, r6)
                    if (r5 == 0) goto L_0x007d
                    goto L_0x0083
                L_0x007d:
                    R2.k r5 = new R2.k
                    r5.<init>()
                    throw r5
                L_0x0083:
                    R2.s r5 = R2.s.f8222a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: d2.C2.a.C0243a.emit(u2.E, V2.d):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(C2 c22, V2.d dVar) {
            super(2, dVar);
            this.f19616b = c22;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f19616b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19615a;
            if (i4 == 0) {
                n.b(obj);
                I j4 = this.f19616b.e0().j();
                C0243a aVar = new C0243a(this.f19616b);
                this.f19615a = 1;
                if (j4.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19623a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2 f19624b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2 f19625a;

            a(C2 c22) {
                this.f19625a = c22;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (!m.a(e5, E.a.f21883a)) {
                    if (e5 instanceof E.c) {
                        if (this.f19625a.isAdded()) {
                            q qVar = new q();
                            FragmentActivity requireActivity = this.f19625a.requireActivity();
                            m.d(requireActivity, "requireActivity(...)");
                            qVar.q(requireActivity, (String) ((E.c) e5).a(), this.f19625a.getString(R.string.uptodown_turbo));
                        }
                    } else if (!m.a(e5, E.b.f21884a)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C2 c22, V2.d dVar) {
            super(2, dVar);
            this.f19624b = c22;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f19624b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19623a;
            if (i4 == 0) {
                n.b(obj);
                I h4 = this.f19624b.e0().h();
                a aVar = new a(this.f19624b);
                this.f19623a = 1;
                if (h4.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19626a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2 f19627b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2 f19628a;

            a(C2 c22) {
                this.f19628a = c22;
            }

            /* renamed from: b */
            public final Object emit(E e5, V2.d dVar) {
                if (!m.a(e5, E.a.f21883a)) {
                    if (e5 instanceof E.c) {
                        V a5 = ((U.a) ((E.c) e5).a()).a();
                        Intent intent = new Intent(this.f19628a.requireContext(), UserDeviceDetailsActivity.class);
                        intent.putExtra("user_device", a5);
                        C2 c22 = this.f19628a;
                        UptodownApp.a aVar = UptodownApp.f17422D;
                        FragmentActivity requireActivity = c22.requireActivity();
                        m.d(requireActivity, "requireActivity(...)");
                        c22.startActivity(intent, aVar.a(requireActivity));
                    } else if (!m.a(e5, E.b.f21884a)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2 c22, V2.d dVar) {
            super(2, dVar);
            this.f19627b = c22;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f19627b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19626a;
            if (i4 == 0) {
                n.b(obj);
                I c6 = this.f19627b.d0().c();
                a aVar = new a(this.f19627b);
                this.f19626a = 1;
                if (c6.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19629a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2 f19630b;

        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2 f19631a;

            a(C2 c22) {
                this.f19631a = c22;
            }

            /* access modifiers changed from: private */
            public static final void e(C2 c22, View view) {
                if (c22.f19609d != null) {
                    q qVar = new q();
                    FragmentActivity requireActivity = c22.requireActivity();
                    m.d(requireActivity, "requireActivity(...)");
                    String N4 = c22.f19609d;
                    m.b(N4);
                    q.r(qVar, requireActivity, N4, (String) null, 4, (Object) null);
                }
            }

            /* renamed from: c */
            public final Object emit(E e5, V2.d dVar) {
                if (!m.a(e5, E.a.f21883a)) {
                    if (e5 instanceof E.c) {
                        this.f19631a.f19609d = (String) ((E.c) e5).a();
                        this.f19631a.c0().f10113p.setVisibility(0);
                        this.f19631a.c0().f10113p.setOnClickListener(new D2(this.f19631a));
                    } else if (!m.a(e5, E.b.f21884a)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(C2 c22, V2.d dVar) {
            super(2, dVar);
            this.f19630b = c22;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f19630b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f19629a;
            if (i4 == 0) {
                n.b(obj);
                I f4 = this.f19630b.e0().f();
                a aVar = new a(this.f19630b);
                this.f19629a = 1;
                if (f4.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public static final class f extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f19633a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment) {
            super(0);
            this.f19633a = fragment;
        }

        public final Fragment invoke() {
            return this.f19633a;
        }
    }

    public static final class g extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f19634a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(d3.a aVar) {
            super(0);
            this.f19634a = aVar;
        }

        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.f19634a.invoke()).getViewModelStore();
            m.d(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    public static final class h extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f19635a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Fragment fragment) {
            super(0);
            this.f19635a = fragment;
        }

        public final Fragment invoke() {
            return this.f19635a;
        }
    }

    public static final class i extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f19636a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(d3.a aVar) {
            super(0);
            this.f19636a = aVar;
        }

        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.f19636a.invoke()).getViewModelStore();
            m.d(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    static final class j extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19637a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2 f19638b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(C2 c22, V2.d dVar) {
            super(2, dVar);
            this.f19638b = c22;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new j(this.f19638b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f19637a == 0) {
                n.b(obj);
                this.f19638b.g0();
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((j) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C2() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new j2(this));
        m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f19610e = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new k2(this));
        m.d(registerForActivityResult2, "registerForActivityResult(...)");
        this.f19611f = registerForActivityResult2;
        ActivityResultLauncher registerForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new l2(this));
        m.d(registerForActivityResult3, "registerForActivityResult(...)");
        this.f19612g = registerForActivityResult3;
        ActivityResultLauncher registerForActivityResult4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new m2(this));
        m.d(registerForActivityResult4, "registerForActivityResult(...)");
        this.f19613h = registerForActivityResult4;
        ActivityResultLauncher registerForActivityResult5 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new n2(this));
        m.d(registerForActivityResult5, "registerForActivityResult(...)");
        this.f19614i = registerForActivityResult5;
    }

    /* access modifiers changed from: private */
    public static final void A0(C2 c22, View view) {
        Intent intent = new Intent(c22.requireContext(), RollbackActivity.class);
        UptodownApp.a aVar = UptodownApp.f17422D;
        FragmentActivity requireActivity = c22.requireActivity();
        m.d(requireActivity, "requireActivity(...)");
        c22.startActivity(intent, aVar.a(requireActivity));
    }

    /* access modifiers changed from: private */
    public static final void B0(C2 c22, View view) {
        U.b bVar = g2.U.f20468m;
        Context requireContext = c22.requireContext();
        m.d(requireContext, "requireContext(...)");
        g2.U e5 = bVar.e(requireContext);
        if (e5 != null) {
            Intent intent = new Intent(c22.requireContext(), UserCommentsActivity.class);
            intent.putExtra("userID", e5.g());
            UptodownApp.a aVar = UptodownApp.f17422D;
            FragmentActivity requireActivity = c22.requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            c22.startActivity(intent, aVar.a(requireActivity));
            return;
        }
        c22.F0();
    }

    /* access modifiers changed from: private */
    public static final void C0(C2 c22, View view) {
        U.b bVar = g2.U.f20468m;
        Context requireContext = c22.requireContext();
        m.d(requireContext, "requireContext(...)");
        if (bVar.e(requireContext) != null) {
            Intent intent = new Intent(c22.requireContext(), WishlistActivity.class);
            FragmentActivity activity = c22.getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            intent.putExtra("downloadResultReceiver", ((MainActivity) activity).I5());
            ActivityResultLauncher activityResultLauncher = c22.f19612g;
            UptodownApp.a aVar = UptodownApp.f17422D;
            FragmentActivity requireActivity = c22.requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            activityResultLauncher.launch(intent, aVar.b(requireActivity));
            return;
        }
        c22.F0();
    }

    /* access modifiers changed from: private */
    public static final void D0(C2 c22, View view) {
        U.b bVar = g2.U.f20468m;
        Context requireContext = c22.requireContext();
        m.d(requireContext, "requireContext(...)");
        if (bVar.e(requireContext) != null) {
            Intent intent = new Intent(c22.requireContext(), RecommendedActivity.class);
            FragmentActivity activity = c22.getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            intent.putExtra("downloadResultReceiver", ((MainActivity) activity).I5());
            ActivityResultLauncher activityResultLauncher = c22.f19612g;
            UptodownApp.a aVar = UptodownApp.f17422D;
            FragmentActivity requireActivity = c22.requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            activityResultLauncher.launch(intent, aVar.b(requireActivity));
            return;
        }
        c22.F0();
    }

    private final void E0(g2.U u4) {
        Intent intent = new Intent(requireContext(), UserAvatarActivity.class);
        intent.putExtra("user", u4);
        UptodownApp.a aVar = UptodownApp.f17422D;
        FragmentActivity requireActivity = requireActivity();
        m.d(requireActivity, "requireActivity(...)");
        startActivity(intent, aVar.a(requireActivity));
    }

    private final void F0() {
        Intent intent = new Intent(requireContext(), LoginActivity.class);
        ActivityResultLauncher activityResultLauncher = this.f19610e;
        UptodownApp.a aVar = UptodownApp.f17422D;
        FragmentActivity requireActivity = requireActivity();
        m.d(requireActivity, "requireActivity(...)");
        activityResultLauncher.launch(intent, aVar.b(requireActivity));
    }

    private final void G0() {
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.a0()) {
            Intent intent = new Intent(requireContext(), SecurityActivity.class);
            FragmentActivity requireActivity = requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            startActivity(intent, aVar.a(requireActivity));
        }
    }

    private final void H0() {
        Intent intent = new Intent(requireContext(), PreferencesActivity.class);
        ActivityResultLauncher activityResultLauncher = this.f19611f;
        UptodownApp.a aVar = UptodownApp.f17422D;
        FragmentActivity requireActivity = requireActivity();
        m.d(requireActivity, "requireActivity(...)");
        activityResultLauncher.launch(intent, aVar.b(requireActivity));
    }

    private final void J0() {
        a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        aVar.y0(requireContext, "yes");
        AppCompatDelegate.setDefaultNightMode(2);
        UptodownApp.f17422D.t0(true);
    }

    private final void K0() {
        a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        aVar.y0(requireContext, "no");
        AppCompatDelegate.setDefaultNightMode(1);
        UptodownApp.f17422D.t0(true);
    }

    /* access modifiers changed from: private */
    public static final void L0(C2 c22, ActivityResult activityResult) {
        int resultCode = activityResult.getResultCode();
        if (resultCode == 1003) {
            t.a aVar = t.f21927u;
            Context requireContext = c22.requireContext();
            m.d(requireContext, "requireContext(...)");
            t a5 = aVar.a(requireContext);
            a5.a();
            a5.r();
            a5.i();
            if (c22.getActivity() != null) {
                c22.requireActivity().finish();
                c22.startActivity(c22.requireActivity().getIntent());
            }
        } else if (resultCode == 1004) {
            UptodownApp.a aVar2 = UptodownApp.f17422D;
            Context requireContext2 = c22.requireContext();
            m.d(requireContext2, "requireContext(...)");
            aVar2.e(requireContext2);
            if (c22.getActivity() != null) {
                c22.requireActivity().finish();
                c22.startActivity(c22.requireActivity().getIntent());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void M0(int i4, int i5) {
        if (i4 > 0) {
            c0().f10083H.setVisibility(0);
            if (i4 > 99) {
                c0().f10083H.setText(getString(R.string.more_than_99_value));
            } else {
                c0().f10083H.setText(String.valueOf(i4));
            }
        } else {
            c0().f10083H.setVisibility(4);
        }
        if (i5 > 0) {
            c0().f10082G.setVisibility(0);
            if (i5 > 99) {
                c0().f10082G.setText(getString(R.string.more_than_99_value));
            } else {
                c0().f10082G.setText(String.valueOf(i5));
            }
        } else {
            c0().f10082G.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public static final void P0(C2 c22, ActivityResult activityResult) {
        if (activityResult.getResultCode() == 2 && c22.getContext() != null) {
            Context requireContext = c22.requireContext();
            m.d(requireContext, "requireContext(...)");
            c22.S(requireContext);
            c22.F0();
        }
    }

    /* access modifiers changed from: private */
    public static final void Q0(C2 c22, ActivityResult activityResult) {
        if (activityResult.getResultCode() == 5 && c22.getContext() != null) {
            Context requireContext = c22.requireContext();
            m.d(requireContext, "requireContext(...)");
            c22.S(requireContext);
        }
    }

    private final void S(Context context) {
        e0().d(context);
        c0().f10104g.setImageResource(R.drawable.vector_user_login);
        ImageView imageView = c0().f10104g;
        m.d(imageView, "ivUserAvatarUserFragment");
        int dimension = (int) getResources().getDimension(R.dimen.margin_m);
        imageView.setPadding(dimension, dimension, dimension, dimension);
        c0().f10104g.setBackground((Drawable) null);
        c0().f10095T.setText(getString(R.string.sign_in_sign_up));
        UsernameTextView.a aVar = UsernameTextView.f19434k;
        UsernameTextView usernameTextView = c0().f10095T;
        m.d(usernameTextView, "tvUsernameUserFragment");
        aVar.b(usernameTextView);
        c0().f10095T.setTextColor(ContextCompat.getColor(requireContext(), R.color.text_terciary));
        c0().f10092Q.setText(getString(R.string.subscribe_to_uptodown_turbo));
        c0().f10087L.setVisibility(8);
        c0().f10078C.setVisibility(8);
        c0().f10113p.setVisibility(8);
        this.f19609d = null;
        c0().f10102e.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.vector_support));
        c0().f10103f.setVisibility(8);
        if (getActivity() != null && !requireActivity().isFinishing() && (getActivity() instanceof MainActivity)) {
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).b8();
        }
    }

    private final void T(Context context) {
        Object obj;
        C c5 = new C();
        C1679n c6 = C1679n.c(getLayoutInflater());
        m.d(c6, "inflate(...)");
        TextView textView = c6.f10666f;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.x());
        c6.f10663c.setTypeface(aVar.x());
        c6.f10662b.setTypeface(aVar.x());
        c6.f10664d.setTypeface(aVar.x());
        String j4 = com.uptodown.activities.preferences.a.f18818a.j(context);
        if (m3.m.p(j4, "yes", true)) {
            c6.f10663c.setChecked(true);
        } else if (m3.m.p(j4, "no", true)) {
            c6.f10662b.setChecked(true);
        } else {
            c6.f10664d.setChecked(true);
        }
        c6.f10663c.setOnCheckedChangeListener(new q2(c5, this));
        c6.f10662b.setOnCheckedChangeListener(new s2(c5, this));
        c6.f10664d.setOnCheckedChangeListener(new t2(c5, context));
        c6.f10665e.setTypeface(aVar.w());
        c6.f10665e.setOnClickListener(new u2(c5));
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(c6.getRoot());
        builder.setCancelable(true);
        c5.f20968a = builder.create();
        if (getActivity() != null && !requireActivity().isFinishing() && (obj = c5.f20968a) != null) {
            Window window = ((AlertDialog) obj).getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            ((AlertDialog) c5.f20968a).show();
        }
    }

    /* access modifiers changed from: private */
    public static final void U(C c5, C2 c22, CompoundButton compoundButton, boolean z4) {
        if (z4) {
            Object obj = c5.f20968a;
            m.b(obj);
            ((AlertDialog) obj).dismiss();
            c22.J0();
        }
    }

    /* access modifiers changed from: private */
    public static final void V(C c5, C2 c22, CompoundButton compoundButton, boolean z4) {
        if (z4) {
            Object obj = c5.f20968a;
            m.b(obj);
            ((AlertDialog) obj).dismiss();
            c22.K0();
        }
    }

    /* access modifiers changed from: private */
    public static final void W(C c5, Context context, CompoundButton compoundButton, boolean z4) {
        if (z4) {
            Object obj = c5.f20968a;
            m.b(obj);
            ((AlertDialog) obj).dismiss();
            com.uptodown.activities.preferences.a.f18818a.y0(context, "system");
            AppCompatDelegate.setDefaultNightMode(-1);
            UptodownApp.f17422D.t0(true);
        }
    }

    /* access modifiers changed from: private */
    public static final void X(C c5, View view) {
        Object obj = c5.f20968a;
        m.b(obj);
        ((AlertDialog) obj).dismiss();
    }

    private final void Y(Context context) {
        Object obj;
        C c5 = new C();
        C1683p c6 = C1683p.c(getLayoutInflater());
        m.d(c6, "inflate(...)");
        TextView textView = c6.f10696d;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.x());
        c6.f10696d.setText(getString(R.string.log_out_confirmation_msg));
        c6.f10697e.setTypeface(aVar.w());
        c6.f10697e.setOnClickListener(new o2(this, context, c5));
        c6.f10695c.setTypeface(aVar.w());
        c6.f10695c.setOnClickListener(new p2(c5));
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(c6.getRoot());
        builder.setCancelable(true);
        c5.f20968a = builder.create();
        if (getActivity() != null && !requireActivity().isFinishing() && (obj = c5.f20968a) != null) {
            Window window = ((AlertDialog) obj).getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
            }
            ((AlertDialog) c5.f20968a).show();
        }
    }

    /* access modifiers changed from: private */
    public static final void Z(C2 c22, Context context, C c5, View view) {
        c22.S(context);
        Object obj = c5.f20968a;
        m.b(obj);
        ((AlertDialog) obj).dismiss();
    }

    /* access modifiers changed from: private */
    public static final void a0(C c5, View view) {
        Object obj = c5.f20968a;
        m.b(obj);
        ((AlertDialog) obj).dismiss();
    }

    /* access modifiers changed from: private */
    public static final void b0(C2 c22, ActivityResult activityResult) {
        if (activityResult.getResultCode() == 1 && c22.isAdded()) {
            FragmentActivity activity = c22.getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).w5(0);
        }
    }

    /* access modifiers changed from: private */
    public final com.uptodown.activities.U d0() {
        return (com.uptodown.activities.U) this.f19608c.getValue();
    }

    private final void f0(g2.U u4) {
        if (u4.b() != null) {
            w l4 = com.squareup.picasso.s.h().l(g2.U.f20468m.c(u4.a()));
            UptodownApp.a aVar = UptodownApp.f17422D;
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            l4.n(aVar.i0(requireContext)).i(c0().f10104g);
            c0().f10104g.setBackground(ContextCompat.getDrawable(requireContext(), R.drawable.shadow_user_icon));
        } else {
            c0().f10104g.setImageResource(R.drawable.vector_user_profile);
        }
        ImageView imageView = c0().f10104g;
        m.d(imageView, "ivUserAvatarUserFragment");
        imageView.setPadding(0, 0, 0, 0);
        c0().f10095T.setText(u4.h());
        if (!u4.n() || m.a(u4.l(), "type0")) {
            UsernameTextView.a aVar2 = UsernameTextView.f19434k;
            UsernameTextView usernameTextView = c0().f10095T;
            m.d(usernameTextView, "tvUsernameUserFragment");
            aVar2.b(usernameTextView);
        } else {
            UsernameTextView.a aVar3 = UsernameTextView.f19434k;
            UsernameTextView usernameTextView2 = c0().f10095T;
            m.d(usernameTextView2, "tvUsernameUserFragment");
            aVar3.a(usernameTextView2, u4.n(), u4.l());
        }
        if (u4.n()) {
            c0().f10103f.setVisibility(0);
            q.a aVar4 = q.f21920a;
            ImageView imageView2 = c0().f10104g;
            m.d(imageView2, "ivUserAvatarUserFragment");
            aVar4.a(imageView2);
            c0().f10092Q.setText(getString(R.string.turbo_welcome_popup_manage_subscription));
            c0().f10102e.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.vector_support_turbo));
        } else {
            c0().f10092Q.setText(getString(R.string.subscribe_to_uptodown_turbo));
            c0().f10102e.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.vector_support));
        }
        c0().f10078C.setVisibility(0);
        if (!u4.n()) {
            c0().f10113p.setVisibility(8);
        } else if (this.f19609d == null) {
            E2 e02 = e0();
            Context requireContext2 = requireContext();
            m.d(requireContext2, "requireContext(...)");
            e02.g(requireContext2);
        } else {
            c0().f10113p.setVisibility(0);
        }
        if (getActivity() != null && !requireActivity().isFinishing() && (getActivity() instanceof MainActivity)) {
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).b8();
        }
        c0().f10087L.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void g0() {
        String str;
        if (getContext() != null) {
            U.b bVar = g2.U.f20468m;
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            g2.U e5 = bVar.e(requireContext);
            if (e5 != null) {
                str = e5.g();
            } else {
                str = null;
            }
            if (str != null) {
                Context requireContext2 = requireContext();
                m.d(requireContext2, "requireContext(...)");
                if (e5.m(requireContext2)) {
                    f0(e5);
                    UptodownApp.a aVar = UptodownApp.f17422D;
                    Context requireContext3 = requireContext();
                    m.d(requireContext3, "requireContext(...)");
                    aVar.m0(requireContext3);
                    Context requireContext4 = requireContext();
                    m.d(requireContext4, "requireContext(...)");
                    aVar.l0(requireContext4);
                    return;
                }
            }
            Context requireContext5 = requireContext();
            m.d(requireContext5, "requireContext(...)");
            S(requireContext5);
        }
    }

    /* access modifiers changed from: private */
    public static final void h0(C2 c22, ActivityResult activityResult) {
        int resultCode = activityResult.getResultCode();
        if (resultCode == -1) {
            Context requireContext = c22.requireContext();
            m.d(requireContext, "requireContext(...)");
            c22.S(requireContext);
        } else if (resultCode == 1002) {
            c22.H0();
        }
    }

    /* access modifiers changed from: private */
    public static final void i0(C2 c22, View view) {
        U.b bVar = g2.U.f20468m;
        Context requireContext = c22.requireContext();
        m.d(requireContext, "requireContext(...)");
        g2.U e5 = bVar.e(requireContext);
        if (e5 != null) {
            c22.E0(e5);
        } else {
            c22.F0();
        }
    }

    /* access modifiers changed from: private */
    public static final void j0(C2 c22, View view) {
        U.b bVar = g2.U.f20468m;
        Context requireContext = c22.requireContext();
        m.d(requireContext, "requireContext(...)");
        if (bVar.e(requireContext) == null) {
            c22.F0();
        }
    }

    /* access modifiers changed from: private */
    public static final void k0(C2 c22, View view) {
        U.b bVar = g2.U.f20468m;
        Context requireContext = c22.requireContext();
        m.d(requireContext, "requireContext(...)");
        if (bVar.e(requireContext) != null) {
            Intent intent = new Intent(c22.requireContext(), PreregistrationActivity.class);
            UptodownApp.a aVar = UptodownApp.f17422D;
            FragmentActivity requireActivity = c22.requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            c22.startActivity(intent, aVar.a(requireActivity));
            return;
        }
        c22.F0();
    }

    /* access modifiers changed from: private */
    public static final void l0(C2 c22, View view) {
        String g4;
        if (c22.getContext() != null) {
            U.b bVar = g2.U.f20468m;
            Context requireContext = c22.requireContext();
            m.d(requireContext, "requireContext(...)");
            g2.U e5 = bVar.e(requireContext);
            if (e5 == null || (g4 = e5.g()) == null || g4.length() == 0 || !e5.n()) {
                FragmentActivity activity = c22.getActivity();
                m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                ((C1826a) activity).Y2();
                return;
            }
            E2 e02 = c22.e0();
            Context requireContext2 = c22.requireContext();
            m.d(requireContext2, "requireContext(...)");
            e02.i(requireContext2);
        }
    }

    /* access modifiers changed from: private */
    public static final void m0(C2 c22, View view) {
        c22.G0();
    }

    /* access modifiers changed from: private */
    public static final void n0(C2 c22, View view) {
        U.b bVar = g2.U.f20468m;
        Context requireContext = c22.requireContext();
        m.d(requireContext, "requireContext(...)");
        if (bVar.e(requireContext) != null) {
            ActivityResultLauncher activityResultLauncher = c22.f19613h;
            Intent intent = new Intent(c22.requireContext(), UserDevicesActivity.class);
            UptodownApp.a aVar = UptodownApp.f17422D;
            FragmentActivity requireActivity = c22.requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            activityResultLauncher.launch(intent, aVar.b(requireActivity));
            return;
        }
        c22.F0();
    }

    /* access modifiers changed from: private */
    public static final void o0(C2 c22, View view) {
        Intent intent = new Intent(c22.requireContext(), NotificationsRegistryActivity.class);
        UptodownApp.a aVar = UptodownApp.f17422D;
        FragmentActivity requireActivity = c22.requireActivity();
        m.d(requireActivity, "requireActivity(...)");
        c22.startActivity(intent, aVar.a(requireActivity));
    }

    /* access modifiers changed from: private */
    public static final void p0(C2 c22, View view) {
        c22.H0();
    }

    /* access modifiers changed from: private */
    public static final void q0(C2 c22, View view) {
        if (c22.getActivity() != null) {
            String string = c22.getString(R.string.url_support);
            m.d(string, "getString(...)");
            U.b bVar = g2.U.f20468m;
            FragmentActivity requireActivity = c22.requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            g2.U e5 = bVar.e(requireActivity);
            if (e5 != null && e5.n()) {
                string = c22.getString(R.string.url_support_turbo);
            }
            q qVar = new q();
            FragmentActivity requireActivity2 = c22.requireActivity();
            m.d(requireActivity2, "requireActivity(...)");
            qVar.q(requireActivity2, string, c22.getString(R.string.support_title));
        }
    }

    /* access modifiers changed from: private */
    public static final void r0(C2 c22, View view) {
        if (c22.getActivity() != null && !c22.requireActivity().isFinishing()) {
            q qVar = new q();
            FragmentActivity requireActivity = c22.requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            q.r(qVar, requireActivity, c22.getString(R.string.url) + "/android", (String) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void s0(C2 c22, View view) {
        Context requireContext = c22.requireContext();
        m.d(requireContext, "requireContext(...)");
        c22.Y(requireContext);
    }

    /* access modifiers changed from: private */
    public static final void t0(C2 c22, View view) {
        if (c22.getContext() != null && UptodownApp.f17422D.a0()) {
            if (new q().o(c22.getContext())) {
                c22.J0();
            } else {
                c22.K0();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void u0(C2 c22, View view) {
        String g4;
        U.b bVar = g2.U.f20468m;
        Context requireContext = c22.requireContext();
        m.d(requireContext, "requireContext(...)");
        g2.U e5 = bVar.e(requireContext);
        if (e5 != null && (g4 = e5.g()) != null && g4.length() != 0) {
            Context requireContext2 = c22.requireContext();
            m.d(requireContext2, "requireContext(...)");
            o oVar = new o(requireContext2, LifecycleOwnerKt.getLifecycleScope(c22));
            String g5 = e5.g();
            m.b(g5);
            oVar.b(g5, new e(c22));
        }
    }

    /* access modifiers changed from: private */
    public static final boolean v0(C2 c22, View view) {
        if (c22.getContext() == null) {
            return true;
        }
        Context requireContext = c22.requireContext();
        m.d(requireContext, "requireContext(...)");
        c22.T(requireContext);
        return true;
    }

    /* access modifiers changed from: private */
    public static final void w0(C2 c22, View view) {
        U.b bVar = g2.U.f20468m;
        Context requireContext = c22.requireContext();
        m.d(requireContext, "requireContext(...)");
        g2.U e5 = bVar.e(requireContext);
        if (e5 != null) {
            Context requireContext2 = c22.requireContext();
            m.d(requireContext2, "requireContext(...)");
            if (e5.m(requireContext2)) {
                Intent intent = new Intent(c22.getContext(), UserEditProfileActivity.class);
                ActivityResultLauncher activityResultLauncher = c22.f19614i;
                UptodownApp.a aVar = UptodownApp.f17422D;
                FragmentActivity requireActivity = c22.requireActivity();
                m.d(requireActivity, "requireActivity(...)");
                activityResultLauncher.launch(intent, aVar.b(requireActivity));
                return;
            }
        }
        c22.F0();
    }

    /* access modifiers changed from: private */
    public static final void x0(C2 c22, View view) {
        Intent intent = new Intent(c22.requireContext(), Updates.class);
        UptodownApp.a aVar = UptodownApp.f17422D;
        FragmentActivity requireActivity = c22.requireActivity();
        m.d(requireActivity, "requireActivity(...)");
        c22.startActivity(intent, aVar.a(requireActivity));
    }

    /* access modifiers changed from: private */
    public static final void y0(C2 c22, View view) {
        Intent intent = new Intent(c22.requireContext(), MyApps.class);
        UptodownApp.a aVar = UptodownApp.f17422D;
        FragmentActivity requireActivity = c22.requireActivity();
        m.d(requireActivity, "requireActivity(...)");
        c22.startActivity(intent, aVar.a(requireActivity));
    }

    /* access modifiers changed from: private */
    public static final void z0(C2 c22, View view) {
        Intent intent = new Intent(c22.requireContext(), MyDownloads.class);
        FragmentActivity activity = c22.getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
        intent.putExtra("downloadResultReceiver", ((MainActivity) activity).I5());
        UptodownApp.a aVar = UptodownApp.f17422D;
        FragmentActivity requireActivity = c22.requireActivity();
        m.d(requireActivity, "requireActivity(...)");
        c22.startActivity(intent, aVar.a(requireActivity));
    }

    public final void I0(W0 w02) {
        m.e(w02, "<set-?>");
        this.f19606a = w02;
    }

    public final void N0() {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (L) null, new j(this, (V2.d) null), 3, (Object) null);
    }

    public final void O0() {
        if (isAdded() && getContext() != null) {
            E2 e02 = e0();
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            e02.e(requireContext);
        }
    }

    public final W0 c0() {
        W0 w02 = this.f19606a;
        if (w02 != null) {
            return w02;
        }
        m.u("binding");
        return null;
    }

    public final E2 e0() {
        return (E2) this.f19607b.getValue();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        I0(W0.c(layoutInflater, viewGroup, false));
        RelativeLayout b5 = c0().getRoot();
        m.d(b5, "getRoot(...)");
        return b5;
    }

    public void onResume() {
        super.onResume();
        new x(getContext()).e("UserFragment");
        O0();
        if (new q().o(getContext())) {
            c0().f10099b.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.vector_moon));
        } else {
            c0().f10099b.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.vector_sun));
        }
        g0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        TextView textView = c0().f10090O;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        c0().f10095T.setTypeface(aVar.w());
        c0().f10087L.setTypeface(aVar.w());
        c0().f10079D.setTypeface(aVar.w());
        c0().f10094S.setTypeface(aVar.w());
        c0().f10083H.setTypeface(aVar.w());
        c0().f10077B.setTypeface(aVar.w());
        c0().f10082G.setTypeface(aVar.w());
        c0().f10085J.setTypeface(aVar.w());
        c0().f10097V.setTypeface(aVar.w());
        c0().f10084I.setTypeface(aVar.w());
        c0().f10093R.setTypeface(aVar.w());
        c0().f10086K.setTypeface(aVar.w());
        c0().f10092Q.setTypeface(aVar.w());
        c0().f10113p.setVisibility(8);
        c0().f10091P.setTypeface(aVar.x());
        c0().f10080E.setTypeface(aVar.x());
        c0().f10088M.setTypeface(aVar.x());
        c0().f10081F.setTypeface(aVar.x());
        c0().f10089N.setTypeface(aVar.x());
        c0().f10096U.setTypeface(aVar.x());
        c0().f10078C.setTypeface(aVar.x());
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new a(this, (V2.d) null), 2, (Object) null);
        C1001s0 unused2 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new b(this, (V2.d) null), 2, (Object) null);
        C1001s0 unused3 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new d(this, (V2.d) null), 2, (Object) null);
        O0();
        c0().f10104g.setOnClickListener(new V1(this));
        c0().f10076A.setOnClickListener(new X1(this));
        c0().f10087L.setOnClickListener(new C1886a2(this));
        c0().f10122y.setOnClickListener(new C1890b2(this));
        c0().f10105h.setOnClickListener(new C1894c2(this));
        c0().f10118u.setOnClickListener(new C1898d2(this));
        c0().f10110m.setOnClickListener(new C1902e2(this));
        c0().f10109l.setOnClickListener(new C1906f2(this));
        c0().f10117t.setOnClickListener(new h2(this));
        c0().f10108k.setOnClickListener(new i2(this));
        c0().f10115r.setOnClickListener(new g2(this));
        c0().f10114q.setOnClickListener(new r2(this));
        c0().f10100c.setOnClickListener(new v2(this));
        c0().f10106i.setOnClickListener(new w2(this));
        c0().f10107j.setOnClickListener(new x2(this));
        c0().f10111n.setOnClickListener(new y2(this));
        c0().f10112o.setOnClickListener(new z2(this));
        c0().f10096U.setOnClickListener(new A2(this));
        c0().f10078C.setOnClickListener(new B2(this));
        c0().f10099b.setOnClickListener(new W1(this));
        c0().f10099b.setOnLongClickListener(new Y1(this));
        c0().f10101d.setOnClickListener(new Z1(this));
        C1001s0 unused4 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), Y.c(), (L) null, new c(this, (V2.d) null), 2, (Object) null);
    }

    public static final class e implements K {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2 f19632a;

        e(C2 c22) {
            this.f19632a = c22;
        }

        public void a(g2.U u4) {
            m.e(u4, "user");
            Intent intent = new Intent(this.f19632a.requireContext(), PublicProfileActivity.class);
            intent.putExtra("user", u4);
            C2 c22 = this.f19632a;
            UptodownApp.a aVar = UptodownApp.f17422D;
            FragmentActivity requireActivity = c22.requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            c22.startActivity(intent, aVar.a(requireActivity));
        }

        public void b() {
        }
    }
}
