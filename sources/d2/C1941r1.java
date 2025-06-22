package d2;

import N1.j;
import N1.k;
import R1.c;
import R2.g;
import R2.k;
import R2.n;
import R2.s;
import S1.h;
import S2.C1601o;
import V2.d;
import W1.G;
import W1.i;
import W2.b;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import b2.C1640l;
import b2.o;
import c2.C1650A;
import c2.C1653a;
import c2.C1659d;
import c2.C1661e;
import c2.C1671j;
import c2.C1675l;
import c2.C1677m;
import c2.C1683p;
import c2.C1690t;
import c2.C1691t0;
import c2.C1694v;
import c2.C1695v0;
import c2.C1699x0;
import c2.C1700y;
import c2.I0;
import c2.f1;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newinterstitial.out.MBNewInterstitialHandler;
import com.mbridge.msdk.newinterstitial.out.NewInterstitialListener;
import com.mbridge.msdk.out.BannerAdListener;
import com.mbridge.msdk.out.BannerSize;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.C1826a;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.Gallery;
import com.uptodown.activities.InformationActivity;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.ReviewsActivity;
import com.uptodown.activities.SearchActivity;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.activities.YouTubeActivity;
import com.uptodown.activities.preferences.a;
import com.uptodown.util.views.UsernameTextView;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.DownloadWorker;
import com.uptodown.workers.GenerateQueueWorker;
import com.uptodown.workers.GetUserDataWorker;
import d2.C1988y1;
import d3.a;
import d3.p;
import f2.C2006E;
import f2.C2007F;
import f2.C2010a;
import f2.C2013d;
import f2.C2019j;
import f2.C2027s;
import g2.C2033A;
import g2.C2039G;
import g2.C2046d;
import g2.C2047e;
import g2.C2048f;
import g2.C2050h;
import g2.C2052j;
import g2.C2053k;
import g2.C2054l;
import g2.C2059q;
import g2.C2060s;
import g2.C2062u;
import g2.C2065x;
import g2.U;
import g2.r;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.z;
import o3.C0977g;
import o3.C1001s0;
import r3.C1036f;
import r3.t;
import u2.C2313C;
import u2.C2315a;
import u2.E;
import u2.L;
import u2.q;
import u2.t;
import u2.w;
import u2.x;
import w2.C2345c;
import w2.C2346d;
import w2.k;
import w2.v;

/* renamed from: d2.r1  reason: case insensitive filesystem */
public final class C1941r1 extends Fragment {

    /* renamed from: n  reason: collision with root package name */
    public static final C1942a f19976n = new C1942a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    public C2050h f19977a;

    /* renamed from: b  reason: collision with root package name */
    private C1659d f19978b;

    /* renamed from: c  reason: collision with root package name */
    private final g f19979c = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.D.b(C1988y1.class), new V(new U(this)), (a) null);

    /* renamed from: d  reason: collision with root package name */
    private x f19980d;

    /* renamed from: e  reason: collision with root package name */
    private AlertDialog f19981e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList f19982f;

    /* renamed from: g  reason: collision with root package name */
    private Menu f19983g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public M1.I f19984h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public M1.I f19985i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public ArrayList f19986j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private final C1954m f19987k = new C1954m(this);

    /* renamed from: l  reason: collision with root package name */
    private final ActivityResultLauncher f19988l;

    /* renamed from: m  reason: collision with root package name */
    private final ActivityResultLauncher f19989m;

    /* renamed from: d2.r1$A */
    static final class A extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19990a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f19991b;

        /* renamed from: d2.r1$A$a */
        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1941r1 f19992a;

            a(C1941r1 r1Var) {
                this.f19992a = r1Var;
            }

            /* renamed from: b */
            public final Object emit(u2.E e5, d dVar) {
                if (!(e5 instanceof E.a)) {
                    if (e5 instanceof E.c) {
                        E.c cVar = (E.c) e5;
                        if (((C1988y1.e) cVar.a()).a()) {
                            if (((C1988y1.e) cVar.a()).b()) {
                                this.f19992a.w3();
                            }
                            this.f19992a.F6();
                        }
                    } else if (!(e5 instanceof E.b)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        A(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f19991b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new A(this.f19991b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f19990a;
            if (i4 == 0) {
                n.b(obj);
                r3.I U4 = this.f19991b.d4().U();
                a aVar = new a(this.f19991b);
                this.f19990a = 1;
                if (U4.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((A) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$B */
    static final class B extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f19993a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f19994b;

        /* renamed from: d2.r1$B$a */
        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1941r1 f19995a;

            a(C1941r1 r1Var) {
                this.f19995a = r1Var;
            }

            /* access modifiers changed from: private */
            public static final void e(C1941r1 r1Var, u2.E e5, View view) {
                if (UptodownApp.f17422D.a0()) {
                    r1Var.b7((ArrayList) ((E.c) e5).a());
                }
            }

            /* renamed from: c */
            public final Object emit(u2.E e5, d dVar) {
                if (!(e5 instanceof E.a)) {
                    if (e5 instanceof E.c) {
                        if (!((Collection) ((E.c) e5).a()).isEmpty()) {
                            if (((Number) this.f19995a.d4().R().getValue()).intValue() == -1) {
                                this.f19995a.Z3().f10277L.f10579b.setVisibility(0);
                            }
                            this.f19995a.a7(com.uptodown.R.id.action_remote_install);
                            this.f19995a.Z3().f10277L.f10579b.setOnClickListener(new C1982w1(this.f19995a, e5));
                        } else {
                            this.f19995a.Z3().f10277L.f10579b.setVisibility(8);
                            this.f19995a.f4(com.uptodown.R.id.action_remote_install);
                        }
                    } else if (!(e5 instanceof E.b)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        B(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f19994b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new B(this.f19994b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f19993a;
            if (i4 == 0) {
                n.b(obj);
                r3.I l02 = this.f19994b.d4().l0();
                a aVar = new a(this.f19994b);
                this.f19993a = 1;
                if (l02.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((B) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$D */
    public static final class D implements f2.W {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f19997a;

        D(C1941r1 r1Var) {
            this.f19997a = r1Var;
        }

        public void a(g2.K k4) {
            m.e(k4, "reportVT");
            if (this.f19997a.getActivity() != null && !this.f19997a.requireActivity().isFinishing()) {
                Intent intent = new Intent(this.f19997a.requireActivity(), VirusTotalReport.class);
                intent.putExtra("appInfo", this.f19997a.Y3());
                intent.putExtra("appReportVT", k4);
                C1941r1 r1Var = this.f19997a;
                UptodownApp.a aVar = UptodownApp.f17422D;
                FragmentActivity requireActivity = r1Var.requireActivity();
                m.d(requireActivity, "requireActivity(...)");
                r1Var.startActivity(intent, aVar.a(requireActivity));
                this.f19997a.d4().m0().setValue(Boolean.FALSE);
            }
        }

        public void b() {
            if (this.f19997a.getActivity() != null && !this.f19997a.requireActivity().isFinishing()) {
                String l02 = this.f19997a.Y3().l0();
                if (!(l02 == null || l02.length() == 0)) {
                    String l03 = this.f19997a.Y3().l0();
                    m.b(l03);
                    if (Long.parseLong(l03) > 650000000) {
                        Intent intent = new Intent(this.f19997a.requireActivity(), VirusTotalReport.class);
                        intent.putExtra("appInfo", this.f19997a.Y3());
                        intent.putExtra("isVirusTotalReportAvaialable", false);
                        C1941r1 r1Var = this.f19997a;
                        UptodownApp.a aVar = UptodownApp.f17422D;
                        FragmentActivity requireActivity = r1Var.requireActivity();
                        m.d(requireActivity, "requireActivity(...)");
                        r1Var.startActivity(intent, aVar.a(requireActivity));
                        this.f19997a.d4().m0().setValue(Boolean.FALSE);
                        return;
                    }
                }
                FragmentActivity activity = this.f19997a.getActivity();
                m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                ((C1826a) activity).F2(this.f19997a.Y3().i0());
            }
        }
    }

    /* renamed from: d2.r1$E */
    public static final class E implements H1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f19998a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f19999b;

        E(C1941r1 r1Var, Context context) {
            this.f19998a = r1Var;
            this.f19999b = context;
        }

        public void a(Exception exc) {
            m.e(exc, "e");
            exc.printStackTrace();
            C1941r1 r1Var = this.f19998a;
            r1Var.h6(r1Var.Z3().f10280O.f10417b, this.f19999b);
        }

        public void b() {
            C1941r1 r1Var = this.f19998a;
            r1Var.h6(r1Var.Z3().f10280O.f10417b, this.f19999b);
        }
    }

    /* renamed from: d2.r1$F */
    public static final class F implements C2013d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20000a;

        F(C1941r1 r1Var) {
            this.f20000a = r1Var;
        }

        public void a(C2050h hVar) {
            m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (UptodownApp.f17422D.a0() && this.f20000a.getActivity() != null && !this.f20000a.requireActivity().isFinishing()) {
                this.f20000a.r5(hVar);
            }
        }
    }

    /* renamed from: d2.r1$G */
    public static final class G implements C2010a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20001a;

        G(C1941r1 r1Var) {
            this.f20001a = r1Var;
        }

        public void a(C2050h hVar, int i4) {
            m.e(hVar, "appInfo");
            this.f20001a.S6(hVar);
        }
    }

    /* renamed from: d2.r1$H */
    public static final class H implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1695v0 f20002a;

        H(C1695v0 v0Var) {
            this.f20002a = v0Var;
        }

        public boolean onPreDraw() {
            this.f20002a.f10820n.getViewTreeObserver().removeOnPreDrawListener(this);
            TextView textView = this.f20002a.f10820n;
            m.d(textView, "tvBodyReview");
            if (!w2.s.a(textView)) {
                return true;
            }
            this.f20002a.f10825s.setVisibility(0);
            this.f20002a.f10825s.setTypeface(N1.k.f7778g.w());
            return true;
        }
    }

    /* renamed from: d2.r1$I */
    public static final class I implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1699x0 f20003a;

        I(C1699x0 x0Var) {
            this.f20003a = x0Var;
        }

        public boolean onPreDraw() {
            this.f20003a.f10868n.getViewTreeObserver().removeOnPreDrawListener(this);
            TextView textView = this.f20003a.f10868n;
            m.d(textView, "tvBodyReview");
            if (!w2.s.a(textView)) {
                return true;
            }
            this.f20003a.f10873s.setVisibility(0);
            this.f20003a.f10873s.setTypeface(N1.k.f7778g.w());
            return true;
        }
    }

    /* renamed from: d2.r1$J */
    public static final class J implements C2006E {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20004a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f20005b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.C f20006c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f20007d;

        J(C1941r1 r1Var, ArrayList arrayList, kotlin.jvm.internal.C c5, ArrayList arrayList2) {
            this.f20004a = r1Var;
            this.f20005b = arrayList;
            this.f20006c = c5;
            this.f20007d = arrayList2;
        }

        public void a(g2.O o4) {
            m.e(o4, "screenshot");
            UptodownApp.a aVar = UptodownApp.f17422D;
            if (aVar.a0() && this.f20004a.getActivity() != null && !this.f20004a.requireActivity().isFinishing()) {
                Intent intent = new Intent(this.f20004a.requireActivity(), Gallery.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("images", this.f20005b);
                bundle.putInt("index", this.f20005b.indexOf(o4));
                intent.putExtra("bundle", bundle);
                C1941r1 r1Var = this.f20004a;
                FragmentActivity requireActivity = r1Var.requireActivity();
                m.d(requireActivity, "requireActivity(...)");
                r1Var.startActivity(intent, aVar.a(requireActivity));
            }
        }

        public void b(g2.O o4) {
            m.e(o4, "screenshot");
            this.f20005b.remove(o4);
            M1.B b5 = (M1.B) this.f20006c.f20968a;
            if (b5 != null) {
                b5.c(o4);
            }
        }

        public void c(g2.Z z4) {
            m.e(z4, MimeTypes.BASE_TYPE_VIDEO);
            this.f20007d.remove(z4);
            M1.B b5 = (M1.B) this.f20006c.f20968a;
            if (b5 != null) {
                b5.c(z4);
            }
        }

        public void d(g2.Z z4) {
            m.e(z4, MimeTypes.BASE_TYPE_VIDEO);
            if (UptodownApp.f17422D.a0() && this.f20004a.getActivity() != null && !this.f20004a.requireActivity().isFinishing()) {
                Intent intent = new Intent(this.f20004a.getActivity(), YouTubeActivity.class);
                intent.putExtra("id_youtube", z4.a());
                this.f20004a.startActivity(intent);
            }
        }
    }

    /* renamed from: d2.r1$K */
    public static final class K implements C2013d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20008a;

        K(C1941r1 r1Var) {
            this.f20008a = r1Var;
        }

        public void a(C2050h hVar) {
            m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (UptodownApp.f17422D.a0() && this.f20008a.getActivity() != null && !this.f20008a.requireActivity().isFinishing()) {
                this.f20008a.r5(hVar);
            }
        }
    }

    /* renamed from: d2.r1$L */
    public static final class L implements C2010a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20009a;

        L(C1941r1 r1Var) {
            this.f20009a = r1Var;
        }

        public void a(C2050h hVar, int i4) {
            m.e(hVar, "appInfo");
            this.f20009a.S6(hVar);
        }
    }

    /* renamed from: d2.r1$M */
    public static final class M implements C2013d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20010a;

        M(C1941r1 r1Var) {
            this.f20010a = r1Var;
        }

        public void a(C2050h hVar) {
            m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (UptodownApp.f17422D.a0() && this.f20010a.getActivity() != null && !this.f20010a.requireActivity().isFinishing()) {
                this.f20010a.r5(hVar);
            }
        }
    }

    /* renamed from: d2.r1$N */
    public static final class N implements C2010a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20011a;

        N(C1941r1 r1Var) {
            this.f20011a = r1Var;
        }

        public void a(C2050h hVar, int i4) {
            m.e(hVar, "appInfo");
            this.f20011a.S6(hVar);
        }
    }

    /* renamed from: d2.r1$O */
    static final class O extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20012a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20013b;

        /* renamed from: d2.r1$O$a */
        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1941r1 f20014a;

            /* renamed from: d2.r1$O$a$a  reason: collision with other inner class name */
            static final class C0245a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f20015a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ C1941r1 f20016b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0245a(C1941r1 r1Var, d dVar) {
                    super(2, dVar);
                    this.f20016b = r1Var;
                }

                public final d create(Object obj, d dVar) {
                    return new C0245a(this.f20016b, dVar);
                }

                public final Object invokeSuspend(Object obj) {
                    b.c();
                    if (this.f20015a == 0) {
                        n.b(obj);
                        if (this.f20016b.Y3().d0() == 1) {
                            C1941r1 r1Var = this.f20016b;
                            String string = r1Var.getString(com.uptodown.R.string.remove_recommended);
                            m.d(string, "getString(...)");
                            r1Var.o6(com.uptodown.R.id.action_recommended, string);
                            this.f20016b.Z3().f10281P.setBackground(ContextCompat.getDrawable(this.f20016b.requireContext(), com.uptodown.R.drawable.ripple_blue_primary_button));
                            this.f20016b.Z3().f10314l.setImageDrawable(ContextCompat.getDrawable(this.f20016b.requireContext(), com.uptodown.R.drawable.vector_bookmark_white));
                            this.f20016b.Z3().f10333u0.setTextColor(ContextCompat.getColor(this.f20016b.requireContext(), com.uptodown.R.color.white));
                            this.f20016b.Z3().f10333u0.setText(this.f20016b.getString(com.uptodown.R.string.remove_recommended));
                        } else {
                            C1941r1 r1Var2 = this.f20016b;
                            String string2 = r1Var2.getString(com.uptodown.R.string.add_recommended);
                            m.d(string2, "getString(...)");
                            r1Var2.o6(com.uptodown.R.id.action_recommended, string2);
                            this.f20016b.Z3().f10281P.setBackground(ContextCompat.getDrawable(this.f20016b.requireContext(), com.uptodown.R.drawable.ripple_stroke_blue_primary));
                            this.f20016b.Z3().f10314l.setImageDrawable(ContextCompat.getDrawable(this.f20016b.requireContext(), com.uptodown.R.drawable.vector_bookmark_stroke));
                            this.f20016b.Z3().f10333u0.setTextColor(ContextCompat.getColor(this.f20016b.requireContext(), com.uptodown.R.color.text_terciary));
                            this.f20016b.Z3().f10333u0.setText(this.f20016b.getString(com.uptodown.R.string.add_recommended));
                        }
                        return s.f8222a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(o3.J j4, d dVar) {
                    return ((C0245a) create(j4, dVar)).invokeSuspend(s.f8222a);
                }
            }

            a(C1941r1 r1Var) {
                this.f20014a = r1Var;
            }

            public final Object b(int i4, d dVar) {
                this.f20014a.Y3().Q0(i4);
                Object g4 = C0977g.g(o3.Y.c(), new C0245a(this.f20014a, (d) null), dVar);
                if (g4 == b.c()) {
                    return g4;
                }
                return s.f8222a;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, d dVar) {
                return b(((Number) obj).intValue(), dVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20013b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new O(this.f20013b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20012a;
            if (i4 == 0) {
                n.b(obj);
                t Y4 = this.f20013b.d4().Y();
                a aVar = new a(this.f20013b);
                this.f20012a = 1;
                if (Y4.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((O) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$P */
    public static final class P implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f20017a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20018b;

        P(View view, C1941r1 r1Var) {
            this.f20017a = view;
            this.f20018b = r1Var;
        }

        public boolean onPreDraw() {
            this.f20017a.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f20018b.startPostponedEnterTransition();
            return true;
        }
    }

    /* renamed from: d2.r1$Q */
    static final class Q extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20019a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20020b;

        /* renamed from: d2.r1$Q$a */
        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1941r1 f20021a;

            a(C1941r1 r1Var) {
                this.f20021a = r1Var;
            }

            /* renamed from: b */
            public final Object emit(u2.E e5, d dVar) {
                if (!(e5 instanceof E.a)) {
                    if (e5 instanceof E.c) {
                        E.c cVar = (E.c) e5;
                        if (((C1988y1.g) cVar.a()).b()) {
                            FragmentActivity activity = this.f20021a.getActivity();
                            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                            String string = this.f20021a.requireContext().getString(com.uptodown.R.string.review_sended);
                            m.d(string, "getString(...)");
                            ((C1826a) activity).q0(string);
                        } else if (!((C1988y1.g) cVar.a()).b() && ((C1988y1.g) cVar.a()).a() == 0) {
                            FragmentActivity activity2 = this.f20021a.getActivity();
                            m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                            String string2 = this.f20021a.getString(com.uptodown.R.string.error_review_already_submitted);
                            m.d(string2, "getString(...)");
                            ((C1826a) activity2).q0(string2);
                        } else if (((C1988y1.g) cVar.a()).a() == 401) {
                            this.f20021a.Z4();
                        } else if (((C1988y1.g) cVar.a()).a() == 403) {
                            FragmentActivity activity3 = this.f20021a.getActivity();
                            m.c(activity3, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                            String string3 = this.f20021a.getString(com.uptodown.R.string.email_validation_msg);
                            m.d(string3, "getString(...)");
                            ((C1826a) activity3).q0(string3);
                        } else {
                            FragmentActivity activity4 = this.f20021a.getActivity();
                            m.c(activity4, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                            String string4 = this.f20021a.getString(com.uptodown.R.string.error_generico);
                            m.d(string4, "getString(...)");
                            ((C1826a) activity4).q0(string4);
                        }
                    } else if (!(e5 instanceof E.b)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        Q(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20020b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new Q(this.f20020b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20019a;
            if (i4 == 0) {
                n.b(obj);
                r3.I e02 = this.f20020b.d4().e0();
                a aVar = new a(this.f20020b);
                this.f20019a = 1;
                if (e02.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((Q) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$R */
    public static final class R implements H1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20022a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1653a f20023b;

        R(C1941r1 r1Var, C1653a aVar) {
            this.f20022a = r1Var;
            this.f20023b = aVar;
        }

        /* access modifiers changed from: private */
        public static final void d(C1653a aVar, C1941r1 r1Var) {
            if (new q().p(aVar.getRoot())) {
                C2065x.a aVar2 = C2065x.f20781n;
                Context requireContext = r1Var.requireContext();
                m.d(requireContext, "requireContext(...)");
                C2065x d5 = aVar2.d(requireContext);
                if (d5 != null) {
                    Context requireContext2 = r1Var.requireContext();
                    m.d(requireContext2, "requireContext(...)");
                    d5.j(requireContext2);
                }
            }
        }

        public void a(Exception exc) {
            this.f20022a.Z3().f10302f.removeAllViews();
            this.f20022a.Z3().f10302f.setVisibility(8);
            this.f20022a.Z6();
        }

        public void b() {
            this.f20022a.Z3().f10302f.addView(this.f20023b.getRoot());
            this.f20022a.Z3().f10302f.setVisibility(0);
            new Handler(Looper.getMainLooper()).postDelayed(new C1985x1(this.f20023b, this.f20022a), 500);
        }
    }

    /* renamed from: d2.r1$S */
    public static final class S implements NewInterstitialListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20024a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MBNewInterstitialHandler f20025b;

        S(C1941r1 r1Var, MBNewInterstitialHandler mBNewInterstitialHandler) {
            this.f20024a = r1Var;
            this.f20025b = mBNewInterstitialHandler;
        }

        public void onAdClicked(MBridgeIds mBridgeIds) {
            m.e(mBridgeIds, "ids");
            Bundle bundle = new Bundle();
            bundle.putString("type", "clicked");
            new x(this.f20024a.getContext()).d("mintegral_interstitial", bundle);
        }

        public void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
            m.e(mBridgeIds, "ids");
            m.e(rewardInfo, "info");
            Bundle bundle = new Bundle();
            bundle.putString("type", "closed");
            new x(this.f20024a.getContext()).d("mintegral_interstitial", bundle);
        }

        public void onAdCloseWithNIReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
            m.e(mBridgeIds, "ids");
            m.e(rewardInfo, "info");
        }

        public void onAdShow(MBridgeIds mBridgeIds) {
            m.e(mBridgeIds, "ids");
            if (this.f20024a.getContext() != null) {
                Bundle bundle = new Bundle();
                bundle.putString("type", "show");
                new x(this.f20024a.getContext()).d("mintegral_interstitial", bundle);
                a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
                Context requireContext = this.f20024a.requireContext();
                m.d(requireContext, "requireContext(...)");
                aVar.S0(requireContext, System.currentTimeMillis());
            }
        }

        public void onEndcardShow(MBridgeIds mBridgeIds) {
            m.e(mBridgeIds, "ids");
        }

        public void onLoadCampaignSuccess(MBridgeIds mBridgeIds) {
            m.e(mBridgeIds, "ids");
        }

        public void onResourceLoadFail(MBridgeIds mBridgeIds, String str) {
            String str2;
            m.e(mBridgeIds, "ids");
            m.e(str, "errorMsg");
            Bundle bundle = new Bundle();
            bundle.putString("type", "load_failed");
            if (str.length() > 10) {
                str2 = str.substring(0, 10);
                m.d(str2, "substring(...)");
            } else if (str.length() > 0) {
                str2 = str;
            } else {
                str2 = null;
            }
            if (str2 != null) {
                bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
            }
            new x(this.f20024a.getContext()).d("mintegral_interstitial", bundle);
        }

        public void onResourceLoadSuccess(MBridgeIds mBridgeIds) {
            m.e(mBridgeIds, "ids");
            Bundle bundle = new Bundle();
            bundle.putString("type", "loaded");
            new x(this.f20024a.getContext()).d("mintegral_interstitial", bundle);
            if (this.f20025b.isReady()) {
                this.f20025b.show();
            }
        }

        public void onShowFail(MBridgeIds mBridgeIds, String str) {
            String str2;
            m.e(mBridgeIds, "ids");
            m.e(str, "errorMsg");
            Bundle bundle = new Bundle();
            bundle.putString("type", "show_failed");
            if (str.length() > 10) {
                str2 = str.substring(0, 10);
                m.d(str2, "substring(...)");
            } else if (str.length() > 0) {
                str2 = str;
            } else {
                str2 = null;
            }
            if (str2 != null) {
                bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
            }
            new x(this.f20024a.getContext()).d("mintegral_interstitial", bundle);
        }

        public void onVideoComplete(MBridgeIds mBridgeIds) {
            m.e(mBridgeIds, "ids");
            Bundle bundle = new Bundle();
            bundle.putString("type", "video_completed");
            new x(this.f20024a.getContext()).d("mintegral_interstitial", bundle);
        }
    }

    /* renamed from: d2.r1$T */
    public static final class T implements f2.L {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f20026a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f20027b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ z f20028c;

        T(ArrayList arrayList, ArrayList arrayList2, z zVar) {
            this.f20026a = arrayList;
            this.f20027b = arrayList2;
            this.f20028c = zVar;
        }

        public void a(int i4) {
            if (((g2.X) this.f20026a.get(i4)).d() != 0) {
                z zVar = this.f20028c;
                zVar.f20985a = !zVar.f20985a;
            } else if (this.f20027b.contains(this.f20026a.get(i4))) {
                this.f20027b.remove(this.f20026a.get(i4));
            } else {
                this.f20027b.add(this.f20026a.get(i4));
            }
        }
    }

    /* renamed from: d2.r1$U */
    public static final class U extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f20029a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public U(Fragment fragment) {
            super(0);
            this.f20029a = fragment;
        }

        public final Fragment invoke() {
            return this.f20029a;
        }
    }

    /* renamed from: d2.r1$V */
    public static final class V extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f20030a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public V(d3.a aVar) {
            super(0);
            this.f20030a = aVar;
        }

        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.f20030a.invoke()).getViewModelStore();
            m.d(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    /* renamed from: d2.r1$W */
    static final class W extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20031a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20032b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f20033c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        W(C1941r1 r1Var, Context context, d dVar) {
            super(2, dVar);
            this.f20032b = r1Var;
            this.f20033c = context;
        }

        public final d create(Object obj, d dVar) {
            return new W(this.f20032b, this.f20033c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20031a;
            if (i4 == 0) {
                n.b(obj);
                C1941r1 r1Var = this.f20032b;
                Context context = this.f20033c;
                this.f20031a = 1;
                if (r1Var.b3(context, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((W) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$X */
    static final class X extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20034a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f20035b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20036c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        X(String str, C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20035b = str;
            this.f20036c = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new X(this.f20035b, this.f20036c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object obj3;
            Object obj4;
            b.c();
            if (this.f20034a == 0) {
                n.b(obj);
                String str = this.f20035b;
                if (!(str == null || str.length() == 0)) {
                    if (this.f20036c.f19984h != null) {
                        M1.I B12 = this.f20036c.f19984h;
                        m.b(B12);
                        ArrayList c5 = B12.c();
                        String str2 = this.f20035b;
                        int size = c5.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size) {
                                obj4 = null;
                                break;
                            }
                            obj4 = c5.get(i4);
                            i4++;
                            if (m.a(((C2050h) obj4).Q(), str2)) {
                                break;
                            }
                        }
                        M1.I B13 = this.f20036c.f19984h;
                        m.b(B13);
                        int K4 = C1601o.K(B13.c(), (C2050h) obj4);
                        M1.I B14 = this.f20036c.f19984h;
                        m.b(B14);
                        B14.notifyItemChanged(K4);
                    }
                    if (this.f20036c.f19985i != null) {
                        M1.I A12 = this.f20036c.f19985i;
                        m.b(A12);
                        ArrayList c6 = A12.c();
                        String str3 = this.f20035b;
                        int size2 = c6.size();
                        int i5 = 0;
                        while (true) {
                            if (i5 >= size2) {
                                obj3 = null;
                                break;
                            }
                            obj3 = c6.get(i5);
                            i5++;
                            if (m.a(((C2050h) obj3).Q(), str3)) {
                                break;
                            }
                        }
                        M1.I A13 = this.f20036c.f19985i;
                        m.b(A13);
                        int K5 = C1601o.K(A13.c(), (C2050h) obj3);
                        M1.I A14 = this.f20036c.f19985i;
                        m.b(A14);
                        A14.notifyItemChanged(K5);
                    }
                    if (!this.f20036c.f19986j.isEmpty()) {
                        Iterator it = this.f20036c.f19986j.iterator();
                        m.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            m.d(next, "next(...)");
                            M1.I i6 = (M1.I) next;
                            ArrayList c7 = i6.c();
                            String str4 = this.f20035b;
                            int size3 = c7.size();
                            int i7 = 0;
                            while (true) {
                                if (i7 >= size3) {
                                    obj2 = null;
                                    break;
                                }
                                obj2 = c7.get(i7);
                                i7++;
                                if (m.a(((C2050h) obj2).Q(), str4)) {
                                    break;
                                }
                            }
                            i6.notifyItemChanged(C1601o.K(i6.c(), (C2050h) obj2));
                        }
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((X) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$Y */
    static final class Y extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20037a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f20038b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20039c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        Y(String str, C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20038b = str;
            this.f20039c = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new Y(this.f20038b, this.f20039c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            FragmentActivity activity;
            b.c();
            if (this.f20037a == 0) {
                n.b(obj);
                if (m3.m.p(this.f20038b, this.f20039c.Y3().Q(), true) && (activity = this.f20039c.getActivity()) != null) {
                    this.f20039c.h7(activity);
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((Y) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$Z */
    static final class Z extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20040a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20041b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a0 f20042c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        Z(C1941r1 r1Var, a0 a0Var, d dVar) {
            super(2, dVar);
            this.f20041b = r1Var;
            this.f20042c = a0Var;
        }

        public final d create(Object obj, d dVar) {
            return new Z(this.f20041b, this.f20042c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20040a;
            if (i4 == 0) {
                n.b(obj);
                GetUserDataWorker.a aVar = GetUserDataWorker.f19472b;
                Context requireContext = this.f20041b.requireContext();
                m.d(requireContext, "requireContext(...)");
                a0 a0Var = this.f20042c;
                this.f20040a = 1;
                if (aVar.a(requireContext, a0Var, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((Z) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$a  reason: case insensitive filesystem */
    public static final class C1942a {
        public /* synthetic */ C1942a(C2103g gVar) {
            this();
        }

        public final C1941r1 a(C2050h hVar) {
            C1941r1 r1Var = new C1941r1();
            Bundle bundle = new Bundle();
            if (hVar != null) {
                bundle.putParcelable("appInfo", hVar);
            }
            r1Var.setArguments(bundle);
            return r1Var;
        }

        private C1942a() {
        }
    }

    /* renamed from: d2.r1$a0 */
    public static final class a0 implements f2.M {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20043a;

        a0(C1941r1 r1Var) {
            this.f20043a = r1Var;
        }

        public void a() {
            U.b bVar = g2.U.f20468m;
            Context requireContext = this.f20043a.requireContext();
            m.d(requireContext, "requireContext(...)");
            g2.U e5 = bVar.e(requireContext);
            if (e5 != null && e5.n()) {
                this.f20043a.Z3().f10302f.setVisibility(8);
                this.f20043a.Z3().f10263C.setVisibility(8);
            }
        }
    }

    /* renamed from: d2.r1$b  reason: case insensitive filesystem */
    public final class C1943b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f20044a;

        /* renamed from: b  reason: collision with root package name */
        private final g2.S f20045b;

        public C1943b(int i4, g2.S s4) {
            this.f20044a = i4;
            this.f20045b = s4;
        }

        public void run() {
            File file;
            g2.S s4 = this.f20045b;
            if (s4 != null && m3.m.p(s4.h(), C1941r1.this.Y3().Q(), true)) {
                int i4 = this.f20044a;
                if (i4 != 108) {
                    if (i4 == 109) {
                        C1941r1.this.b4();
                        C1941r1.this.K6(this.f20045b);
                    } else if (i4 != 201) {
                        FragmentActivity activity = C1941r1.this.getActivity();
                        if (activity != null) {
                            C1941r1.this.h7(activity);
                        }
                    } else {
                        C1941r1.this.K6(this.f20045b);
                    }
                } else if (C1941r1.this.getContext() != null) {
                    C1941r1 r1Var = C1941r1.this;
                    Context requireContext = r1Var.requireContext();
                    m.d(requireContext, "requireContext(...)");
                    r1Var.h7(requireContext);
                    g2.S s5 = this.f20045b;
                    Context requireContext2 = C1941r1.this.requireContext();
                    m.d(requireContext2, "requireContext(...)");
                    C2060s b5 = s5.b(requireContext2);
                    if (b5 != null) {
                        if (b5.o().size() == 1 && ((C2060s.c) b5.o().get(0)).a() != null) {
                            String a5 = ((C2060s.c) b5.o().get(0)).a();
                            m.b(a5);
                            file = new File(a5);
                        } else if (b5.o().size() > 1) {
                            String a6 = ((C2060s.c) b5.o().get(0)).a();
                            m.b(a6);
                            file = new File(a6).getParentFile();
                        } else {
                            file = null;
                        }
                        if (file != null && file.exists()) {
                            C1941r1.this.S4(file);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: d2.r1$b0 */
    static final class b0 extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20047a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20048b;

        /* renamed from: d2.r1$b0$a */
        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1941r1 f20049a;

            /* renamed from: d2.r1$b0$a$a  reason: collision with other inner class name */
            static final class C0246a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f20050a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ C1941r1 f20051b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0246a(C1941r1 r1Var, d dVar) {
                    super(2, dVar);
                    this.f20051b = r1Var;
                }

                public final d create(Object obj, d dVar) {
                    return new C0246a(this.f20051b, dVar);
                }

                public final Object invokeSuspend(Object obj) {
                    b.c();
                    if (this.f20050a == 0) {
                        n.b(obj);
                        if (this.f20051b.Y3().A0() == 1) {
                            C1941r1 r1Var = this.f20051b;
                            String string = r1Var.getString(com.uptodown.R.string.app_detail_remove_wishlist_title);
                            m.d(string, "getString(...)");
                            r1Var.o6(com.uptodown.R.id.action_wishlist, string);
                            this.f20051b.Z3().f10286U.setBackground(ContextCompat.getDrawable(this.f20051b.requireContext(), com.uptodown.R.drawable.ripple_blue_primary_button));
                            this.f20051b.Z3().f10318n.setImageDrawable(ContextCompat.getDrawable(this.f20051b.requireContext(), com.uptodown.R.drawable.vector_heart_white));
                            this.f20051b.Z3().f10268E0.setTextColor(ContextCompat.getColor(this.f20051b.requireContext(), com.uptodown.R.color.white));
                            this.f20051b.Z3().f10268E0.setText(this.f20051b.getString(com.uptodown.R.string.app_detail_remove_wishlist_title));
                        } else {
                            C1941r1 r1Var2 = this.f20051b;
                            String string2 = r1Var2.getString(com.uptodown.R.string.app_detail_add_wishlist_title);
                            m.d(string2, "getString(...)");
                            r1Var2.o6(com.uptodown.R.id.action_wishlist, string2);
                            this.f20051b.Z3().f10286U.setBackground(ContextCompat.getDrawable(this.f20051b.requireContext(), com.uptodown.R.drawable.ripple_stroke_blue_primary));
                            this.f20051b.Z3().f10318n.setImageDrawable(ContextCompat.getDrawable(this.f20051b.requireContext(), com.uptodown.R.drawable.vector_heart_stroke));
                            this.f20051b.Z3().f10268E0.setTextColor(ContextCompat.getColor(this.f20051b.requireContext(), com.uptodown.R.color.text_terciary));
                            this.f20051b.Z3().f10268E0.setText(this.f20051b.getString(com.uptodown.R.string.app_detail_add_wishlist_title));
                        }
                        return s.f8222a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(o3.J j4, d dVar) {
                    return ((C0246a) create(j4, dVar)).invokeSuspend(s.f8222a);
                }
            }

            a(C1941r1 r1Var) {
                this.f20049a = r1Var;
            }

            public final Object b(int i4, d dVar) {
                this.f20049a.Y3().W0(i4);
                Object g4 = C0977g.g(o3.Y.c(), new C0246a(this.f20049a, (d) null), dVar);
                if (g4 == b.c()) {
                    return g4;
                }
                return s.f8222a;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, d dVar) {
                return b(((Number) obj).intValue(), dVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b0(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20048b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new b0(this.f20048b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20047a;
            if (i4 == 0) {
                n.b(obj);
                t p02 = this.f20048b.d4().p0();
                a aVar = new a(this.f20048b);
                this.f20047a = 1;
                if (p02.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((b0) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$c  reason: case insensitive filesystem */
    public final class C1944c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final String f20052a;

        /* renamed from: b  reason: collision with root package name */
        private final int f20053b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20054c;

        public C1944c(C1941r1 r1Var, String str, int i4) {
            m.e(str, "packagename");
            this.f20054c = r1Var;
            this.f20052a = str;
            this.f20053b = i4;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
            r1 = r5.f20054c;
            r0 = r1.getString(com.uptodown.R.string.install_compatibility_error, r1.Y3().L());
            kotlin.jvm.internal.m.d(r0, "getString(...)");
            d2.C1941r1.t1(r1, r0);
            d2.C1941r1.i2(r5.f20054c);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ad, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ae, code lost:
            r0 = r5.f20054c.getActivity();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b4, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b6, code lost:
            d2.C1941r1.k2(r5.f20054c, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00bb, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00bc, code lost:
            r0 = r5.f20054c;
            r1 = r0.getString(com.uptodown.R.string.installing);
            kotlin.jvm.internal.m.d(r1, "getString(...)");
            d2.C1941r1.h2(r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                r0 = 1
                d2.r1 r1 = r5.f20054c
                g2.h r1 = r1.Y3()
                java.lang.String r1 = r1.Q()
                if (r1 == 0) goto L_0x00cb
                int r1 = r1.length()
                if (r1 != 0) goto L_0x0015
                goto L_0x00cb
            L_0x0015:
                d2.r1 r1 = r5.f20054c
                g2.h r1 = r1.Y3()
                java.lang.String r1 = r1.Q()
                java.lang.String r2 = r5.f20052a
                boolean r1 = m3.m.p(r1, r2, r0)
                if (r1 == 0) goto L_0x00cb
                int r1 = r5.f20053b
                java.lang.String r2 = "getString(...)"
                switch(r1) {
                    case 301: goto L_0x00bc;
                    case 302: goto L_0x00ae;
                    case 303: goto L_0x008c;
                    case 304: goto L_0x0077;
                    case 305: goto L_0x0067;
                    case 306: goto L_0x0059;
                    case 307: goto L_0x0033;
                    default: goto L_0x002e;
                }
            L_0x002e:
                switch(r1) {
                    case 351: goto L_0x00bc;
                    case 352: goto L_0x00ae;
                    case 353: goto L_0x008c;
                    default: goto L_0x0031;
                }
            L_0x0031:
                goto L_0x00cb
            L_0x0033:
                d2.r1 r0 = r5.f20054c
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                if (r0 == 0) goto L_0x00cb
                d2.r1 r1 = r5.f20054c
                androidx.fragment.app.FragmentActivity r3 = r1.getActivity()
                java.lang.String r4 = "null cannot be cast to non-null type com.uptodown.activities.BaseActivity"
                kotlin.jvm.internal.m.c(r3, r4)
                com.uptodown.activities.a r3 = (com.uptodown.activities.C1826a) r3
                r4 = 2131952002(0x7f130182, float:1.9540434E38)
                java.lang.String r4 = r1.getString(r4)
                kotlin.jvm.internal.m.d(r4, r2)
                r3.q0(r4)
                r1.h7(r0)
                return
            L_0x0059:
                d2.r1 r0 = r5.f20054c
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                if (r0 == 0) goto L_0x00cb
                d2.r1 r1 = r5.f20054c
                r1.t6(r0)
                return
            L_0x0067:
                d2.r1 r0 = r5.f20054c
                r1 = 2131952734(0x7f13045e, float:1.954192E38)
                java.lang.String r1 = r0.getString(r1)
                kotlin.jvm.internal.m.d(r1, r2)
                r0.y6(r1)
                return
            L_0x0077:
                d2.r1 r0 = r5.f20054c
                r1 = 2131952305(0x7f1302b1, float:1.954105E38)
                java.lang.String r1 = r0.getString(r1)
                kotlin.jvm.internal.m.d(r1, r2)
                r0.s3(r1)
                d2.r1 r0 = r5.f20054c
                r0.z6()
                return
            L_0x008c:
                d2.r1 r1 = r5.f20054c
                g2.h r3 = r1.Y3()
                java.lang.String r3 = r3.L()
                java.lang.Object[] r0 = new java.lang.Object[r0]
                r4 = 0
                r0[r4] = r3
                r3 = 2131952077(0x7f1301cd, float:1.9540587E38)
                java.lang.String r0 = r1.getString(r3, r0)
                kotlin.jvm.internal.m.d(r0, r2)
                r1.s3(r0)
                d2.r1 r0 = r5.f20054c
                r0.z6()
                return
            L_0x00ae:
                d2.r1 r0 = r5.f20054c
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                if (r0 == 0) goto L_0x00cb
                d2.r1 r1 = r5.f20054c
                r1.D6(r0)
                return
            L_0x00bc:
                d2.r1 r0 = r5.f20054c
                r1 = 2131952090(0x7f1301da, float:1.9540613E38)
                java.lang.String r1 = r0.getString(r1)
                kotlin.jvm.internal.m.d(r1, r2)
                r0.y6(r1)
            L_0x00cb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d2.C1941r1.C1944c.run():void");
        }
    }

    /* renamed from: d2.r1$d  reason: case insensitive filesystem */
    public final class C1945d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f20055a;

        /* renamed from: b  reason: collision with root package name */
        private final C2060s f20056b;

        public C1945d(int i4, C2060s sVar) {
            this.f20055a = i4;
            this.f20056b = sVar;
        }

        public void run() {
            String str;
            String str2;
            C2060s sVar = this.f20056b;
            String str3 = null;
            if (sVar != null) {
                str = sVar.w();
            } else {
                str = null;
            }
            if (!(str == null || str.length() == 0)) {
                C2060s sVar2 = this.f20056b;
                if (sVar2 != null) {
                    str2 = sVar2.w();
                } else {
                    str2 = null;
                }
                if (m3.m.p(str2, C1941r1.this.Y3().Q(), true)) {
                    switch (this.f20055a) {
                        case 199:
                            C1941r1.this.v6((C2060s) null);
                            return;
                        case 200:
                            C1941r1.this.b4();
                            if (C1941r1.P4(C1941r1.this, (g2.S) null, 1, (Object) null)) {
                                C1941r1.this.v6(this.f20056b);
                                C2060s sVar3 = this.f20056b;
                                if ((sVar3 == null || C1941r1.this.Y3().H() != sVar3.E()) && C1941r1.this.getActivity() != null && (C1941r1.this.getActivity() instanceof C1826a)) {
                                    FragmentActivity activity = C1941r1.this.getActivity();
                                    m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                                    C1941r1 r1Var = C1941r1.this;
                                    String string = r1Var.getString(com.uptodown.R.string.recent_version_available, r1Var.Y3().L());
                                    m.d(string, "getString(...)");
                                    ((C1826a) activity).q0(string);
                                    return;
                                }
                                return;
                            }
                            return;
                        case 201:
                            if (C1941r1.P4(C1941r1.this, (g2.S) null, 1, (Object) null)) {
                                C1941r1.this.v6(this.f20056b);
                                return;
                            }
                            return;
                        case 202:
                            if (C1941r1.this.getContext() != null) {
                                C1941r1 r1Var2 = C1941r1.this;
                                Context requireContext = r1Var2.requireContext();
                                m.d(requireContext, "requireContext(...)");
                                r1Var2.h7(requireContext);
                                C2060s sVar4 = this.f20056b;
                                m.b(sVar4);
                                Context requireContext2 = C1941r1.this.requireContext();
                                m.d(requireContext2, "requireContext(...)");
                                File m4 = sVar4.m(requireContext2);
                                if (m4 != null) {
                                    C1941r1.this.S4(m4);
                                    return;
                                }
                                return;
                            }
                            FragmentActivity activity2 = C1941r1.this.getActivity();
                            if (activity2 != null) {
                                C1941r1.this.h7(activity2);
                                return;
                            }
                            return;
                        case 203:
                            FragmentActivity activity3 = C1941r1.this.getActivity();
                            if (activity3 != null) {
                                C1941r1 r1Var3 = C1941r1.this;
                                String string2 = r1Var3.getString(com.uptodown.R.string.download_error_message);
                                m.d(string2, "getString(...)");
                                r1Var3.s3(string2);
                                r1Var3.t6(activity3);
                                return;
                            }
                            return;
                        case 205:
                            C1941r1 r1Var4 = C1941r1.this;
                            C2060s sVar5 = this.f20056b;
                            m.b(sVar5);
                            r1Var4.s6(sVar5);
                            return;
                        case 206:
                            FragmentActivity activity4 = C1941r1.this.getActivity();
                            if (activity4 != null) {
                                C1941r1.this.h7(activity4);
                                return;
                            }
                            return;
                        case 207:
                            FragmentActivity activity5 = C1941r1.this.getActivity();
                            if (activity5 != null) {
                                C1941r1.this.t6(activity5);
                                return;
                            }
                            return;
                        case 208:
                            FragmentActivity activity6 = C1941r1.this.getActivity();
                            if (activity6 != null) {
                                C1941r1 r1Var5 = C1941r1.this;
                                String string3 = r1Var5.getString(com.uptodown.R.string.no_free_space);
                                m.d(string3, "getString(...)");
                                r1Var5.s3(string3);
                                r1Var5.h7(activity6);
                                return;
                            }
                            return;
                        case 209:
                            FragmentActivity activity7 = C1941r1.this.getActivity();
                            if (activity7 != null) {
                                C1941r1 r1Var6 = C1941r1.this;
                                String string4 = r1Var6.getString(com.uptodown.R.string.error_no_connection);
                                m.d(string4, "getString(...)");
                                r1Var6.s3(string4);
                                r1Var6.h7(activity7);
                                return;
                            }
                            return;
                        case 210:
                            FragmentActivity activity8 = C1941r1.this.getActivity();
                            if (activity8 != null) {
                                C1941r1.this.h7(activity8);
                                return;
                            }
                            return;
                        case 211:
                            C1941r1.this.E6(this.f20056b);
                            return;
                        default:
                            return;
                    }
                }
            }
            C1941r1 r1Var7 = C1941r1.this;
            C2060s sVar6 = this.f20056b;
            if (sVar6 != null) {
                str3 = sVar6.w();
            }
            r1Var7.o7(str3);
        }
    }

    /* renamed from: d2.r1$e  reason: case insensitive filesystem */
    static final class C1946e extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f20058a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f20059b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20060c;

        /* renamed from: d  reason: collision with root package name */
        int f20061d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1946e(C1941r1 r1Var, d dVar) {
            super(dVar);
            this.f20060c = r1Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.f20059b = obj;
            this.f20061d |= Integer.MIN_VALUE;
            return this.f20060c.W2(this);
        }
    }

    /* renamed from: d2.r1$f  reason: case insensitive filesystem */
    static final class C1947f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20062a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20063b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1947f(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20063b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new C1947f(this.f20063b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String Q4;
            b.c();
            if (this.f20062a == 0) {
                n.b(obj);
                if (!(this.f20063b.getContext() == null || (Q4 = this.f20063b.Y3().Q()) == null || Q4.length() == 0)) {
                    t.a aVar = u2.t.f21927u;
                    Context requireContext = this.f20063b.requireContext();
                    m.d(requireContext, "requireContext(...)");
                    u2.t a5 = aVar.a(requireContext);
                    a5.a();
                    String Q5 = this.f20063b.Y3().Q();
                    m.b(Q5);
                    C2048f Y4 = a5.Y(Q5);
                    if (Y4 != null) {
                        this.f20063b.d4().S().setValue(Y4);
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1947f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$g  reason: case insensitive filesystem */
    static final class C1948g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20064a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20065b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1948g(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20065b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new C1948g(this.f20065b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20064a == 0) {
                n.b(obj);
                if (this.f20065b.d4().S().getValue() != null) {
                    Object value = this.f20065b.d4().S().getValue();
                    m.b(value);
                    if (((C2048f) value).e() == 0) {
                        C1941r1 r1Var = this.f20065b;
                        String string = r1Var.getString(com.uptodown.R.string.not_offer_updates);
                        m.d(string, "getString(...)");
                        r1Var.o6(com.uptodown.R.id.action_exclude, string);
                        return s.f8222a;
                    }
                }
                C1941r1 r1Var2 = this.f20065b;
                String string2 = r1Var2.getString(com.uptodown.R.string.offer_updates_again);
                m.d(string2, "getString(...)");
                r1Var2.o6(com.uptodown.R.id.action_exclude, string2);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1948g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$h  reason: case insensitive filesystem */
    static final class C1949h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20066a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20067b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f20068c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.C f20069d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ z f20070e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ z f20071f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1949h(C1941r1 r1Var, Context context, kotlin.jvm.internal.C c5, z zVar, z zVar2, d dVar) {
            super(2, dVar);
            this.f20067b = r1Var;
            this.f20068c = context;
            this.f20069d = c5;
            this.f20070e = zVar;
            this.f20071f = zVar2;
        }

        public final d create(Object obj, d dVar) {
            return new C1949h(this.f20067b, this.f20068c, this.f20069d, this.f20070e, this.f20071f, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            String t4;
            String str;
            b.c();
            if (this.f20066a == 0) {
                n.b(obj);
                this.f20067b.Z3().f10277L.f10584g.setVisibility(8);
                this.f20067b.Z3().f10273H.f9679g.setVisibility(8);
                if (this.f20067b.Y3().c()) {
                    this.f20067b.Z3().f10327r0.setVisibility(0);
                } else {
                    this.f20067b.Z3().f10327r0.setVisibility(8);
                }
                if (this.f20067b.d4().S().getValue() != null) {
                    this.f20067b.Z3().f10277L.f10580c.setVisibility(0);
                } else {
                    this.f20067b.Z3().f10277L.f10580c.setVisibility(8);
                }
                if (this.f20067b.Y3().J0()) {
                    this.f20067b.G6(this.f20068c);
                } else if (this.f20067b.Y3().G0()) {
                    this.f20067b.q6();
                } else if (this.f20067b.Y3().F0()) {
                    this.f20067b.t6(this.f20068c);
                } else if (this.f20067b.Y3().H0()) {
                    this.f20067b.F6();
                } else if (!com.uptodown.activities.preferences.a.f18818a.Q(this.f20068c)) {
                    this.f20067b.n6();
                } else if (!this.f20067b.Y3().B0()) {
                    if (this.f20067b.d4().S().getValue() != null) {
                        this.f20067b.D6(this.f20068c);
                        this.f20067b.W4(1);
                    } else {
                        C1941r1 r1Var = this.f20067b;
                        String string = r1Var.getString(com.uptodown.R.string.app_detail_not_compatible);
                        m.d(string, "getString(...)");
                        r1Var.r6(string);
                        this.f20067b.W4(0);
                    }
                } else if (!this.f20067b.e4()) {
                    this.f20067b.B6(this.f20068c, (C2060s) this.f20069d.f20968a);
                } else if (((Boolean) this.f20067b.d4().P().getValue()).booleanValue() || this.f20067b.Y3().D0()) {
                    C1941r1 r1Var2 = this.f20067b;
                    String string2 = r1Var2.getString(com.uptodown.R.string.app_detail_not_available);
                    m.d(string2, "getString(...)");
                    r1Var2.r6(string2);
                } else if (this.f20067b.d4().S().getValue() != null) {
                    if (this.f20067b.d4().j0().getValue() != null) {
                        Object value = this.f20067b.d4().j0().getValue();
                        m.b(value);
                        if (!((g2.S) value).m()) {
                            Object value2 = this.f20067b.d4().S().getValue();
                            m.b(value2);
                            if (((C2048f) value2).e() != 1) {
                                Object obj2 = this.f20069d.f20968a;
                                if (obj2 == null) {
                                    this.f20067b.t6(this.f20068c);
                                } else if (((C2060s) obj2).f()) {
                                    this.f20067b.M6(this.f20068c);
                                } else {
                                    if (!this.f20070e.f20985a) {
                                        C1941r1 r1Var3 = this.f20067b;
                                        if (!r1Var3.O4((g2.S) r1Var3.d4().j0().getValue())) {
                                            if (((C2060s) this.f20069d.f20968a).y() > 0) {
                                                this.f20067b.O6();
                                            } else {
                                                this.f20067b.t6(this.f20068c);
                                            }
                                        }
                                    }
                                    this.f20067b.v6((C2060s) this.f20069d.f20968a);
                                }
                            }
                        }
                    }
                    Object value3 = this.f20067b.d4().S().getValue();
                    m.b(value3);
                    if (!((C2048f) value3).H()) {
                        this.f20067b.D6(this.f20068c);
                    } else {
                        this.f20067b.Z3().f10277L.getRoot().setVisibility(4);
                        this.f20067b.Z3().f10273H.getRoot().setVisibility(8);
                    }
                } else {
                    T1.a i4 = N1.k.f7778g.i();
                    if (i4 != null) {
                        str = i4.b();
                    } else {
                        str = null;
                    }
                    if (m3.m.p(str, this.f20067b.Y3().Q(), true)) {
                        C1941r1 r1Var4 = this.f20067b;
                        String string3 = r1Var4.getString(com.uptodown.R.string.installing);
                        m.d(string3, "getString(...)");
                        r1Var4.y6(string3);
                    } else {
                        Object obj3 = this.f20069d.f20968a;
                        if (obj3 == null) {
                            this.f20067b.t6(this.f20068c);
                        } else if (((C2060s) obj3).f()) {
                            this.f20067b.z6();
                        } else if ((C1941r1.P4(this.f20067b, (g2.S) null, 1, (Object) null) || this.f20070e.f20985a) && this.f20071f.f20985a) {
                            this.f20067b.v6((C2060s) this.f20069d.f20968a);
                        } else {
                            this.f20067b.t6(this.f20068c);
                        }
                    }
                }
                this.f20067b.d4().N().setValue(kotlin.coroutines.jvm.internal.b.a(true));
                if (this.f20067b.d4().S().getValue() != null) {
                    this.f20067b.a7(com.uptodown.R.id.action_app_details_settings);
                    this.f20067b.a7(com.uptodown.R.id.action_exclude);
                } else {
                    this.f20067b.f4(com.uptodown.R.id.action_app_details_settings);
                    this.f20067b.f4(com.uptodown.R.id.action_exclude);
                }
                if (!this.f20067b.Y3().F0() || (t4 = this.f20067b.Y3().t()) == null || t4.length() == 0) {
                    this.f20067b.Z3().f10322p.getRoot().setVisibility(8);
                    this.f20067b.Z3().f10322p.f9819c.setVisibility(8);
                } else {
                    TextView textView = this.f20067b.Z3().f10322p.f9819c;
                    C1941r1 r1Var5 = this.f20067b;
                    textView.setTypeface(N1.k.f7778g.x());
                    textView.setText(r1Var5.Y3().t());
                    this.f20067b.Z3().f10322p.getRoot().setVisibility(0);
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1949h) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$i  reason: case insensitive filesystem */
    static final class C1950i extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20072a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20073b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1950i(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20073b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new C1950i(this.f20073b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20072a == 0) {
                n.b(obj);
                if (this.f20073b.Y3().H0()) {
                    this.f20073b.F6();
                } else {
                    C1941r1 r1Var = this.f20073b;
                    String string = r1Var.getString(com.uptodown.R.string.app_detail_not_available);
                    m.d(string, "getString(...)");
                    r1Var.r6(string);
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1950i) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$j  reason: case insensitive filesystem */
    static final class C1951j extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20074a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20075b;

        /* renamed from: d2.r1$j$a */
        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1941r1 f20076a;

            a(C1941r1 r1Var) {
                this.f20076a = r1Var;
            }

            /* renamed from: b */
            public final Object emit(u2.E e5, d dVar) {
                String a5;
                if (!(e5 instanceof E.a)) {
                    if (e5 instanceof E.c) {
                        E.c cVar = (E.c) e5;
                        boolean z4 = false;
                        if (((C1988y1.f) cVar.a()).b()) {
                            C1941r1 r1Var = this.f20076a;
                            TextView textView = r1Var.Z3().f10277L.f10585h;
                            m.d(textView, "tvDownloadCancelBad");
                            r1Var.R2(textView);
                            C1941r1 r1Var2 = this.f20076a;
                            RelativeLayout relativeLayout = r1Var2.Z3().f10273H.f9680h;
                            m.d(relativeLayout, "rlStatusPreRegister");
                            r1Var2.R2(relativeLayout);
                            this.f20076a.Z3().f10273H.f9676d.setVisibility(8);
                            if (!(this.f20076a.getContext() == null || (a5 = ((C1988y1.f) cVar.a()).a()) == null || a5.length() == 0)) {
                                C1941r1 r1Var3 = this.f20076a;
                                TextView textView2 = r1Var3.Z3().f10277L.f10585h;
                                m.d(textView2, "tvDownloadCancelBad");
                                r1Var3.m6(textView2, ((C1988y1.f) cVar.a()).a());
                                this.f20076a.Z3().f10273H.f9680h.setBackground(ContextCompat.getDrawable(this.f20076a.requireContext(), com.uptodown.R.drawable.ripple_open_button));
                                this.f20076a.Z3().f10273H.f9687o.setTextColor(ContextCompat.getColorStateList(this.f20076a.requireContext(), com.uptodown.R.color.selector_wizard_accept_button_text));
                                this.f20076a.Z3().f10273H.f9687o.setText(((C1988y1.f) cVar.a()).a());
                            }
                            t.a aVar = u2.t.f21927u;
                            Context requireContext = this.f20076a.requireContext();
                            m.d(requireContext, "requireContext(...)");
                            u2.t a6 = aVar.a(requireContext);
                            a6.a();
                            C2039G v02 = a6.v0(this.f20076a.Y3().e());
                            a6.i();
                            if (v02 != null) {
                                this.f20076a.Z3().f10267E.setVisibility(0);
                                SwitchCompat switchCompat = this.f20076a.Z3().f10290Y;
                                if (v02.d() == 1) {
                                    z4 = true;
                                }
                                switchCompat.setChecked(z4);
                            } else {
                                this.f20076a.Z3().f10290Y.setChecked(true);
                            }
                        } else {
                            C1941r1 r1Var4 = this.f20076a;
                            TextView textView3 = r1Var4.Z3().f10277L.f10585h;
                            m.d(textView3, "tvDownloadCancelBad");
                            r1Var4.D2(textView3);
                            C1941r1 r1Var5 = this.f20076a;
                            RelativeLayout relativeLayout2 = r1Var5.Z3().f10273H.f9680h;
                            m.d(relativeLayout2, "rlStatusPreRegister");
                            r1Var5.D2(relativeLayout2);
                            this.f20076a.Z3().f10273H.f9676d.setVisibility(0);
                            if (this.f20076a.getContext() != null) {
                                C1941r1 r1Var6 = this.f20076a;
                                TextView textView4 = r1Var6.Z3().f10277L.f10585h;
                                m.d(textView4, "tvDownloadCancelBad");
                                String string = this.f20076a.getString(com.uptodown.R.string.pre_registration_title);
                                m.d(string, "getString(...)");
                                r1Var6.l6(textView4, string);
                                this.f20076a.Z3().f10273H.f9680h.setBackground(ContextCompat.getDrawable(this.f20076a.requireContext(), com.uptodown.R.drawable.ripple_blue_primary_button));
                                this.f20076a.Z3().f10273H.f9687o.setText(this.f20076a.getString(com.uptodown.R.string.pre_registration_title));
                                this.f20076a.Z3().f10273H.f9687o.setTextColor(ContextCompat.getColor(this.f20076a.requireContext(), com.uptodown.R.color.white));
                            }
                        }
                    } else if (!(e5 instanceof E.b)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1951j(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20075b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new C1951j(this.f20075b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20074a;
            if (i4 == 0) {
                n.b(obj);
                r3.I V4 = this.f20075b.d4().V();
                a aVar = new a(this.f20075b);
                this.f20074a = 1;
                if (V4.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1951j) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$k  reason: case insensitive filesystem */
    public static final class C1952k implements f2.W {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20077a;

        C1952k(C1941r1 r1Var) {
            this.f20077a = r1Var;
        }

        /* access modifiers changed from: private */
        public static final s e(C1941r1 r1Var) {
            r1Var.Q3();
            return s.f8222a;
        }

        /* access modifiers changed from: private */
        public static final s f(C1941r1 r1Var) {
            FragmentActivity requireActivity = r1Var.requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            r1Var.Q2(requireActivity);
            return s.f8222a;
        }

        public void a(g2.K k4) {
            m.e(k4, "reportVT");
            if (this.f20077a.getActivity() != null && (this.f20077a.getActivity() instanceof C1826a) && !this.f20077a.requireActivity().isFinishing()) {
                this.f20077a.Y3().R0(k4);
                if (k4.d() > 0) {
                    FragmentActivity activity = this.f20077a.getActivity();
                    m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    ((C1826a) activity).d2(this.f20077a.Y3(), new C1970s1(this.f20077a), new C1973t1(this.f20077a));
                    return;
                }
                this.f20077a.Q3();
            }
        }

        public void b() {
            this.f20077a.Q3();
        }
    }

    /* renamed from: d2.r1$m  reason: case insensitive filesystem */
    public static final class C1954m implements C2019j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20079a;

        C1954m(C1941r1 r1Var) {
            this.f20079a = r1Var;
        }

        public void a(long j4) {
            this.f20079a.q5(j4);
        }

        public void b(C2053k kVar) {
            m.e(kVar, "category");
            this.f20079a.e5(kVar);
        }
    }

    /* renamed from: d2.r1$n  reason: case insensitive filesystem */
    static final class C1955n extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20080a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20081b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1955n(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20081b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new C1955n(this.f20081b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20080a;
            if (i4 == 0) {
                n.b(obj);
                C1941r1 r1Var = this.f20081b;
                this.f20080a = 1;
                if (r1Var.W2(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1955n) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$o  reason: case insensitive filesystem */
    public static final class C1956o implements C2027s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20082a;

        C1956o(C1941r1 r1Var) {
            this.f20082a = r1Var;
        }

        public void b(int i4) {
            if (i4 == 404) {
                this.f20082a.d4().P().setValue(Boolean.TRUE);
            }
        }

        public void c(C2050h hVar) {
            m.e(hVar, "appInfo");
            this.f20082a.k6(hVar);
            this.f20082a.I5();
            this.f20082a.G2();
            this.f20082a.F2();
        }
    }

    /* renamed from: d2.r1$p  reason: case insensitive filesystem */
    static final class C1957p extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20083a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20084b;

        /* renamed from: d2.r1$p$a */
        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1941r1 f20085a;

            a(C1941r1 r1Var) {
                this.f20085a = r1Var;
            }

            /* renamed from: b */
            public final Object emit(ArrayList arrayList, d dVar) {
                this.f20085a.K5(arrayList);
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1957p(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20084b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new C1957p(this.f20084b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20083a;
            if (i4 == 0) {
                n.b(obj);
                r3.I X4 = this.f20084b.d4().X();
                a aVar = new a(this.f20084b);
                this.f20083a = 1;
                if (X4.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1957p) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$r  reason: case insensitive filesystem */
    static final class C1959r extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20088a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20089b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g2.N f20090c;

        /* renamed from: d2.r1$r$a */
        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1941r1 f20091a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ g2.N f20092b;

            a(C1941r1 r1Var, g2.N n4) {
                this.f20091a = r1Var;
                this.f20092b = n4;
            }

            public final Object b(int i4, d dVar) {
                if (i4 == 0) {
                    FragmentActivity activity = this.f20091a.getActivity();
                    m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    String string = this.f20091a.getString(com.uptodown.R.string.error_generico);
                    m.d(string, "getString(...)");
                    ((C1826a) activity).q0(string);
                } else if (i4 == 1) {
                    Iterator it = ((Iterable) this.f20091a.d4().b0().getValue()).iterator();
                    int i5 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i5 = -1;
                            break;
                        }
                        int i6 = i5 + 1;
                        if (((g2.N) it.next()).f() == this.f20092b.f()) {
                            break;
                        }
                        i5 = i6;
                    }
                    if (i5 > 0 && i5 < ((ArrayList) this.f20091a.d4().b0().getValue()).size()) {
                        this.f20091a.p7(this.f20092b, i5);
                    }
                }
                return s.f8222a;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, d dVar) {
                return b(((Number) obj).intValue(), dVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1959r(C1941r1 r1Var, g2.N n4, d dVar) {
            super(2, dVar);
            this.f20089b = r1Var;
            this.f20090c = n4;
        }

        public final d create(Object obj, d dVar) {
            return new C1959r(this.f20089b, this.f20090c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20088a;
            if (i4 == 0) {
                n.b(obj);
                r3.I Z4 = this.f20089b.d4().Z();
                a aVar = new a(this.f20089b, this.f20090c);
                this.f20088a = 1;
                if (Z4.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1959r) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$s  reason: case insensitive filesystem */
    public static final class C1960s implements BannerAdListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20093a;

        C1960s(C1941r1 r1Var) {
            this.f20093a = r1Var;
        }

        /* access modifiers changed from: private */
        public static final void b(C1941r1 r1Var, View view) {
            r1Var.f7();
        }

        public void closeFullScreen(MBridgeIds mBridgeIds) {
            m.e(mBridgeIds, "ids");
        }

        public void onClick(MBridgeIds mBridgeIds) {
            m.e(mBridgeIds, "ids");
            Bundle bundle = new Bundle();
            bundle.putString("type", "clicked");
            new x(this.f20093a.getContext()).d("mintegral_banner", bundle);
        }

        public void onCloseBanner(MBridgeIds mBridgeIds) {
            m.e(mBridgeIds, "ids");
            Bundle bundle = new Bundle();
            bundle.putString("type", "closed");
            new x(this.f20093a.getContext()).d("mintegral_banner", bundle);
        }

        public void onLeaveApp(MBridgeIds mBridgeIds) {
            m.e(mBridgeIds, "ids");
        }

        public void onLoadFailed(MBridgeIds mBridgeIds, String str) {
            m.e(mBridgeIds, "ids");
            m.e(str, "errorMsg");
            this.f20093a.Z3().f10263C.setVisibility(8);
            this.f20093a.Z3().f10335v0.setVisibility(8);
            this.f20093a.Z3().f10263C.release();
            Bundle bundle = new Bundle();
            bundle.putString("type", "failed");
            new x(this.f20093a.getContext()).d("mintegral_banner", bundle);
        }

        public void onLoadSuccessed(MBridgeIds mBridgeIds) {
            m.e(mBridgeIds, "ids");
            this.f20093a.Z3().f10335v0.setTypeface(N1.k.f7778g.x());
            this.f20093a.Z3().f10335v0.setVisibility(0);
            this.f20093a.Z3().f10335v0.setOnClickListener(new C1976u1(this.f20093a));
            Bundle bundle = new Bundle();
            bundle.putString("type", "loaded");
            new x(this.f20093a.getContext()).d("mintegral_banner", bundle);
        }

        public void onLogImpression(MBridgeIds mBridgeIds) {
            m.e(mBridgeIds, "ids");
        }

        public void showFullScreen(MBridgeIds mBridgeIds) {
            m.e(mBridgeIds, "ids");
        }
    }

    /* renamed from: d2.r1$t  reason: case insensitive filesystem */
    public static final class C1961t implements H1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20094a;

        C1961t(C1941r1 r1Var) {
            this.f20094a = r1Var;
        }

        public void a(Exception exc) {
            m.e(exc, "e");
        }

        public void b() {
            this.f20094a.Z3().f10279N.f10406b.setVisibility(0);
            if (!((Boolean) this.f20094a.d4().I().getValue()).booleanValue()) {
                this.f20094a.Z3().f10298d.setTitle(this.f20094a.Y3().L());
                this.f20094a.Z3().f10294b.setExpanded(false, false);
            }
            String y4 = this.f20094a.Y3().y();
            if (y4 != null && y4.length() != 0) {
                this.f20094a.X3();
                FragmentActivity activity = this.f20094a.getActivity();
                if (activity != null) {
                    this.f20094a.n7(activity);
                }
            }
        }
    }

    /* renamed from: d2.r1$u  reason: case insensitive filesystem */
    static final class C1962u extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20095a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20096b;

        /* renamed from: d2.r1$u$a */
        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1941r1 f20097a;

            a(C1941r1 r1Var) {
                this.f20097a = r1Var;
            }

            /* renamed from: b */
            public final Object emit(u2.E e5, d dVar) {
                if (!(e5 instanceof E.a)) {
                    if (e5 instanceof E.c) {
                        E.c cVar = (E.c) e5;
                        this.f20097a.E5(((C1988y1.C1989a) cVar.a()).b());
                        this.f20097a.w5(((C1988y1.C1989a) cVar.a()).a());
                    } else if (!(e5 instanceof E.b)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1962u(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20096b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new C1962u(this.f20096b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20095a;
            if (i4 == 0) {
                n.b(obj);
                r3.I O4 = this.f20096b.d4().O();
                a aVar = new a(this.f20096b);
                this.f20095a = 1;
                if (O4.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1962u) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$v  reason: case insensitive filesystem */
    static final class C1963v extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20098a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20099b;

        /* renamed from: d2.r1$v$a */
        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1941r1 f20100a;

            a(C1941r1 r1Var) {
                this.f20100a = r1Var;
            }

            /* renamed from: b */
            public final Object emit(u2.E e5, d dVar) {
                if (!(e5 instanceof E.a)) {
                    if (e5 instanceof E.c) {
                        E.c cVar = (E.c) e5;
                        this.f20100a.a6(((C1988y1.C1990b) cVar.a()).a(), ((C1988y1.C1990b) cVar.a()).b());
                    } else if (!(e5 instanceof E.b)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1963v(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20099b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new C1963v(this.f20099b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20098a;
            if (i4 == 0) {
                n.b(obj);
                r3.I H4 = this.f20099b.d4().H();
                a aVar = new a(this.f20099b);
                this.f20098a = 1;
                if (H4.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1963v) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$w  reason: case insensitive filesystem */
    static final class C1964w extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20101a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20102b;

        /* renamed from: d2.r1$w$a */
        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1941r1 f20103a;

            a(C1941r1 r1Var) {
                this.f20103a = r1Var;
            }

            /* renamed from: b */
            public final Object emit(ArrayList arrayList, d dVar) {
                this.f20103a.b6(arrayList, false);
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1964w(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20102b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new C1964w(this.f20102b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20101a;
            if (i4 == 0) {
                n.b(obj);
                r3.I h02 = this.f20102b.d4().h0();
                a aVar = new a(this.f20102b);
                this.f20101a = 1;
                if (h02.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1964w) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$x  reason: case insensitive filesystem */
    static final class C1965x extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20104a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20105b;

        /* renamed from: d2.r1$x$a */
        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1941r1 f20106a;

            a(C1941r1 r1Var) {
                this.f20106a = r1Var;
            }

            /* access modifiers changed from: private */
            public static final void e(C1941r1 r1Var, C2047e eVar, View view) {
                r1Var.b5(eVar);
            }

            /* renamed from: c */
            public final Object emit(C2047e eVar, d dVar) {
                ArrayList a5 = eVar.a();
                if (a5 != null && !a5.isEmpty()) {
                    this.f20106a.Z3().f10312k.setVisibility(0);
                    this.f20106a.Z3().f10343z0.setText(this.f20106a.getString(com.uptodown.R.string.best_alternatives));
                    this.f20106a.Z3().f10342z.setOnClickListener(new C1979v1(this.f20106a, eVar));
                    ArrayList a6 = eVar.a();
                    m.b(a6);
                    if (a6.size() > 20) {
                        ArrayList a7 = eVar.a();
                        m.b(a7);
                        this.f20106a.b6(new ArrayList(a7.subList(0, 20)), true);
                    } else {
                        this.f20106a.b6(eVar.a(), true);
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1965x(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20105b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new C1965x(this.f20105b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20104a;
            if (i4 == 0) {
                n.b(obj);
                r3.I A4 = this.f20105b.d4().A();
                a aVar = new a(this.f20105b);
                this.f20104a = 1;
                if (A4.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1965x) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$y  reason: case insensitive filesystem */
    static final class C1966y extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20107a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20108b;

        /* renamed from: d2.r1$y$a */
        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1941r1 f20109a;

            a(C1941r1 r1Var) {
                this.f20109a = r1Var;
            }

            /* renamed from: b */
            public final Object emit(u2.E e5, d dVar) {
                if (!(e5 instanceof E.a)) {
                    if (e5 instanceof E.c) {
                        E.c cVar = (E.c) e5;
                        ArrayList b5 = ((C1988y1.c) cVar.a()).b();
                        if (b5 == null || b5.isEmpty()) {
                            ArrayList a5 = ((C1988y1.c) cVar.a()).a();
                            if (a5 != null && !a5.isEmpty()) {
                                this.f20109a.F5(((C1988y1.c) cVar.a()).a());
                            }
                        } else {
                            this.f20109a.c6(((C1988y1.c) cVar.a()).b());
                        }
                    } else if (!(e5 instanceof E.b)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1966y(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20108b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new C1966y(this.f20108b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20107a;
            if (i4 == 0) {
                n.b(obj);
                r3.I J4 = this.f20108b.d4().J();
                a aVar = new a(this.f20108b);
                this.f20107a = 1;
                if (J4.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1966y) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: d2.r1$z  reason: case insensitive filesystem */
    static final class C1967z extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20110a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20111b;

        /* renamed from: d2.r1$z$a */
        static final class a implements C1036f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1941r1 f20112a;

            a(C1941r1 r1Var) {
                this.f20112a = r1Var;
            }

            /* renamed from: b */
            public final Object emit(u2.E e5, d dVar) {
                if (!(e5 instanceof E.a)) {
                    if (e5 instanceof E.c) {
                        E.c cVar = (E.c) e5;
                        this.f20112a.Z5(((C1988y1.d) cVar.a()).b());
                        this.f20112a.J5(((C1988y1.d) cVar.a()).a());
                    } else if (!(e5 instanceof E.b)) {
                        throw new k();
                    }
                }
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1967z(C1941r1 r1Var, d dVar) {
            super(2, dVar);
            this.f20111b = r1Var;
        }

        public final d create(Object obj, d dVar) {
            return new C1967z(this.f20111b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = b.c();
            int i4 = this.f20110a;
            if (i4 == 0) {
                n.b(obj);
                r3.I L4 = this.f20111b.d4().L();
                a aVar = new a(this.f20111b);
                this.f20110a = 1;
                if (L4.collect(aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                n.b(obj);
            }
            throw new R2.d();
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((C1967z) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C1941r1() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1939q1(this));
        m.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f19988l = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C1977v(this));
        m.d(registerForActivityResult2, "registerForActivityResult(...)");
        this.f19989m = registerForActivityResult2;
    }

    private final void A2() {
        String Q4 = Y3().Q();
        if (Q4 != null && Q4.length() != 0 && getContext() != null) {
            t.a aVar = u2.t.f21927u;
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            u2.t a5 = aVar.a(requireContext);
            a5.a();
            String Q5 = Y3().Q();
            m.b(Q5);
            C2048f Y4 = a5.Y(Q5);
            if (Y4 != null) {
                if (Y4.e() == 0) {
                    Y4.N(1);
                    C2048f.c w4 = Y4.w();
                    C2048f.c cVar = C2048f.c.UPDATED;
                    if (w4 != cVar) {
                        Y4.c0(cVar);
                        String o4 = Y4.o();
                        m.b(o4);
                        a5.R(o4);
                        w wVar = new w();
                        Context requireContext2 = requireContext();
                        m.d(requireContext2, "requireContext(...)");
                        wVar.b(requireContext2);
                    }
                } else {
                    Y4.N(0);
                }
                a5.r1(Y4);
                d4().S().setValue(Y4);
                u2.m mVar = new u2.m();
                Context requireContext3 = requireContext();
                m.d(requireContext3, "requireContext(...)");
                mVar.B(requireContext3);
            }
            a5.i();
            U3();
        }
    }

    /* access modifiers changed from: private */
    public static final void A3(C1941r1 r1Var, View view) {
        FragmentActivity activity = r1Var.getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog j22 = ((C1826a) activity).j2();
        if (j22 != null) {
            j22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void A4(C1941r1 r1Var, View view) {
        if (UptodownApp.f17422D.a0() && !((Boolean) r1Var.d4().m0().getValue()).booleanValue()) {
            r1Var.v5();
        }
    }

    /* access modifiers changed from: private */
    public static final void A5(C1941r1 r1Var, View view) {
        r1Var.s5();
    }

    /* access modifiers changed from: private */
    public static final void A6(C1941r1 r1Var, View view) {
        Context requireContext = r1Var.requireContext();
        m.d(requireContext, "requireContext(...)");
        r1Var.N3(requireContext);
    }

    private final void B2() {
        if (getContext() != null) {
            U.b bVar = g2.U.f20468m;
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            if (bVar.e(requireContext) == null) {
                i5();
            } else if (Y3().d0() == 1) {
                C1988y1 d42 = d4();
                Context requireContext2 = requireContext();
                m.d(requireContext2, "requireContext(...)");
                d42.v0(requireContext2, Y3().e());
            } else {
                C1988y1 d43 = d4();
                Context requireContext3 = requireContext();
                m.d(requireContext3, "requireContext(...)");
                d43.u0(requireContext3, Y3().e());
            }
        }
    }

    private final void B3(Context context) {
        FragmentActivity activity = getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog j22 = ((C1826a) activity).j2();
        if (j22 != null) {
            j22.dismiss();
        }
        Drawable drawable = ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on);
        Drawable drawable2 = ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        C1694v c5 = C1694v.c(getLayoutInflater());
        m.d(c5, "inflate(...)");
        String F4 = Y3().F();
        if (F4 == null || F4.length() == 0) {
            c5.f10798d.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_app_icon_placeholder));
        } else {
            com.squareup.picasso.s.h().l(Y3().F()).n(UptodownApp.f17422D.i0(context)).i(c5.f10798d);
        }
        TextView textView = c5.f10804j;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        c5.f10804j.setText(Y3().L());
        c5.f10797c.setText((CharSequence) d4().c0().getValue());
        int intValue = ((Number) d4().a0().getValue()).intValue();
        if (intValue == 1) {
            c5.f10799e.setImageDrawable(drawable);
            c5.f10800f.setImageDrawable(drawable2);
            c5.f10801g.setImageDrawable(drawable2);
            c5.f10802h.setImageDrawable(drawable2);
            c5.f10803i.setImageDrawable(drawable2);
        } else if (intValue == 2) {
            c5.f10799e.setImageDrawable(drawable);
            c5.f10800f.setImageDrawable(drawable);
            c5.f10801g.setImageDrawable(drawable2);
            c5.f10802h.setImageDrawable(drawable2);
            c5.f10803i.setImageDrawable(drawable2);
        } else if (intValue == 3) {
            c5.f10799e.setImageDrawable(drawable);
            c5.f10800f.setImageDrawable(drawable);
            c5.f10801g.setImageDrawable(drawable);
            c5.f10802h.setImageDrawable(drawable2);
            c5.f10803i.setImageDrawable(drawable2);
        } else if (intValue == 4) {
            c5.f10799e.setImageDrawable(drawable);
            c5.f10800f.setImageDrawable(drawable);
            c5.f10801g.setImageDrawable(drawable);
            c5.f10802h.setImageDrawable(drawable);
            c5.f10803i.setImageDrawable(drawable2);
        } else if (intValue != 5) {
            c5.f10799e.setImageDrawable(drawable2);
            c5.f10800f.setImageDrawable(drawable2);
            c5.f10801g.setImageDrawable(drawable2);
            c5.f10802h.setImageDrawable(drawable2);
            c5.f10803i.setImageDrawable(drawable2);
        } else {
            c5.f10799e.setImageDrawable(drawable);
            c5.f10800f.setImageDrawable(drawable);
            c5.f10801g.setImageDrawable(drawable);
            c5.f10802h.setImageDrawable(drawable);
            c5.f10803i.setImageDrawable(drawable);
        }
        c5.f10799e.setOnClickListener(new T0(this, c5, drawable, drawable2));
        c5.f10800f.setOnClickListener(new V0(this, c5, drawable, drawable2));
        c5.f10801g.setOnClickListener(new W0(this, c5, drawable, drawable2));
        c5.f10802h.setOnClickListener(new X0(this, c5, drawable, drawable2));
        c5.f10803i.setOnClickListener(new Y0(this, c5, drawable));
        c5.f10797c.setTypeface(aVar.x());
        if (d4().T().getValue() != null) {
            Object value = d4().T().getValue();
            m.b(value);
            String i4 = ((g2.N) value).i();
            if (!(i4 == null || i4.length() == 0)) {
                EditText editText = c5.f10797c;
                Object value2 = d4().T().getValue();
                m.b(value2);
                editText.setText(String.valueOf(((g2.N) value2).i()));
            }
            Object value3 = d4().T().getValue();
            m.b(value3);
            if (((g2.N) value3).h() >= 1) {
                c5.f10799e.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            Object value4 = d4().T().getValue();
            m.b(value4);
            if (((g2.N) value4).h() >= 2) {
                c5.f10800f.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            Object value5 = d4().T().getValue();
            m.b(value5);
            if (((g2.N) value5).h() >= 3) {
                c5.f10801g.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            Object value6 = d4().T().getValue();
            m.b(value6);
            if (((g2.N) value6).h() >= 4) {
                c5.f10802h.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            Object value7 = d4().T().getValue();
            m.b(value7);
            if (((g2.N) value7).h() == 5) {
                c5.f10803i.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
        }
        c5.f10806l.setTypeface(aVar.w());
        c5.f10806l.setOnClickListener(new Z0(context, this, c5));
        c5.f10805k.setTypeface(aVar.w());
        c5.f10805k.setOnClickListener(new C1885a1(this, c5));
        builder.setView(c5.getRoot());
        FragmentActivity activity2 = getActivity();
        m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog j23 = ((C1826a) activity2).j2();
        if (j23 != null) {
            j23.setOnDismissListener(new C1889b1(this, context));
        }
        V6(builder);
    }

    /* access modifiers changed from: private */
    public static final void B4(C1941r1 r1Var, View view) {
        r1Var.B2();
    }

    /* access modifiers changed from: private */
    public static final void B5(C1941r1 r1Var) {
        TextView textView = r1Var.Z3().f10285T.f10446d;
        m.d(textView, "tvWhatsNewContent");
        if (!w2.s.a(textView) && r1Var.Z3().f10285T.f10446d.getMaxLines() <= 6) {
            r1Var.Z3().f10285T.f10444b.setVisibility(8);
            r1Var.Z3().f10285T.f10447e.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void B6(Context context, C2060s sVar) {
        long j4;
        w wVar = new w();
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        File f4 = wVar.f(requireContext);
        w wVar2 = new w();
        Context requireContext2 = requireContext();
        m.d(requireContext2, "requireContext(...)");
        long k4 = wVar2.k(requireContext2, f4);
        try {
            j4 = f4.getTotalSpace();
        } catch (SecurityException unused) {
            j4 = 0;
        }
        if (j4 > 0) {
            Context requireContext3 = requireContext();
            m.d(requireContext3, "requireContext(...)");
            String d5 = new i().d(((long) (((double) c4()) * 2.25d)) - k4, requireContext3);
            long j5 = ((j4 - k4) * ((long) 100)) / j4;
            TextView textView = Z3().f10272G0.f10403g;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.x());
            Z3().f10272G0.f10400d.setProgress((int) j5);
            Z3().f10272G0.f10404h.setTypeface(aVar.x());
            Z3().f10272G0.f10404h.setText(context.getString(com.uptodown.R.string.no_storage_text, new Object[]{d5}));
            Z3().f10272G0.f10402f.setTypeface(aVar.w());
            Z3().f10272G0.f10402f.setOnClickListener(new U0(this));
            Z3().f10272G0.getRoot().setVisibility(0);
        }
        if (sVar == null || !sVar.f()) {
            t6(context);
        } else {
            z6();
        }
    }

    private final void C2() {
        if (getContext() != null) {
            U.b bVar = g2.U.f20468m;
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            if (bVar.e(requireContext) == null) {
                i5();
            } else if (Y3().A0() == 1) {
                C1988y1 d42 = d4();
                Context requireContext2 = requireContext();
                m.d(requireContext2, "requireContext(...)");
                d42.C0(requireContext2, Y3().e());
            } else {
                C1988y1 d43 = d4();
                Context requireContext3 = requireContext();
                m.d(requireContext3, "requireContext(...)");
                d43.B0(requireContext3, Y3().e());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void C3(C1941r1 r1Var, C1694v vVar, Drawable drawable, Drawable drawable2, View view) {
        if (UptodownApp.f17422D.a0()) {
            r1Var.d4().a0().setValue(1);
            vVar.f10799e.setImageDrawable(drawable);
            vVar.f10800f.setImageDrawable(drawable2);
            vVar.f10801g.setImageDrawable(drawable2);
            vVar.f10802h.setImageDrawable(drawable2);
            vVar.f10803i.setImageDrawable(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public static final void C4(C1941r1 r1Var, View view) {
        r1Var.C2();
    }

    private final View C5(C2062u uVar, LinearLayout.LayoutParams layoutParams) {
        c2.D c5 = c2.D.c(getLayoutInflater());
        m.d(c5, "inflate(...)");
        c5.getRoot().setLayoutParams(layoutParams);
        TextView textView = c5.f9717c;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        c5.f9716b.setTypeface(aVar.x());
        c5.f9717c.setText(uVar.b());
        c5.f9716b.setText(uVar.a());
        c5.getRoot().setOnClickListener(new C1905f1());
        LinearLayout b5 = c5.getRoot();
        m.d(b5, "getRoot(...)");
        return b5;
    }

    /* access modifiers changed from: private */
    public static final void C6(C1941r1 r1Var, View view) {
        Intent intent = new Intent(r1Var.requireActivity(), FreeUpSpaceActivity.class);
        intent.putExtra("appInfo", r1Var.Y3());
        UptodownApp.a aVar = UptodownApp.f17422D;
        FragmentActivity requireActivity = r1Var.requireActivity();
        m.d(requireActivity, "requireActivity(...)");
        r1Var.startActivity(intent, aVar.a(requireActivity));
    }

    /* access modifiers changed from: private */
    public final void D2(View view) {
        view.setOnClickListener(new C1980w(this));
    }

    /* access modifiers changed from: private */
    public static final void D3(C1941r1 r1Var, C1694v vVar, Drawable drawable, Drawable drawable2, View view) {
        if (UptodownApp.f17422D.a0()) {
            r1Var.d4().a0().setValue(2);
            vVar.f10799e.setImageDrawable(drawable);
            vVar.f10800f.setImageDrawable(drawable);
            vVar.f10801g.setImageDrawable(drawable2);
            vVar.f10802h.setImageDrawable(drawable2);
            vVar.f10803i.setImageDrawable(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public final void D6(Context context) {
        String str;
        C2060s sVar;
        k7();
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = Z3().f10280O.f10423h;
        m.d(progressBar, "pbProgressAppDetail");
        ImageView imageView = Z3().f10280O.f10417b;
        m.d(imageView, "ivLogoAppDetail");
        cVar.c(progressBar, imageView);
        d4().R().setValue(0);
        C2053k h4 = Y3().h();
        if (h4 == null || h4.i() != 1) {
            str = context.getString(com.uptodown.R.string.open);
        } else {
            str = context.getString(com.uptodown.R.string.app_detail_play_button);
        }
        Z3().f10273H.f9682j.setText(str);
        TextView textView = Z3().f10277L.f10586i;
        m.d(textView, "tvOpenBad");
        l6(textView, str);
        a7(com.uptodown.R.id.action_uninstall);
        a7(com.uptodown.R.id.action_app_installed_details);
        String Q4 = Y3().Q();
        if (Q4 != null && Q4.length() != 0 && m3.m.p(requireActivity().getPackageName(), Y3().Q(), true)) {
            Z3().f10277L.f10586i.setVisibility(8);
            Z3().f10277L.f10581d.setVisibility(8);
            Z3().f10277L.f10582e.setVisibility(8);
            Z3().f10273H.f9682j.setVisibility(8);
            if (671 < Y3().H()) {
                g2.S s4 = (g2.S) d4().j0().getValue();
                if (s4 != null) {
                    sVar = s4.b(context);
                } else {
                    sVar = null;
                }
                if (sVar == null && Y3().z() > 0) {
                    u2.t a5 = u2.t.f21927u.a(context);
                    a5.a();
                    C2060s f02 = a5.f0(String.valueOf(Y3().z()));
                    a5.i();
                    sVar = f02;
                }
                if (sVar == null || !sVar.f()) {
                    r3.t j02 = d4().j0();
                    String packageName = requireActivity().getPackageName();
                    m.d(packageName, "getPackageName(...)");
                    j02.setValue(new g2.S(packageName));
                    t6(context);
                    return;
                }
                M6(context);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void E2(C1941r1 r1Var, View view) {
        if (UptodownApp.f17422D.a0()) {
            C1988y1 d42 = r1Var.d4();
            Context requireContext = r1Var.requireContext();
            m.d(requireContext, "requireContext(...)");
            long e5 = r1Var.Y3().e();
            String L4 = r1Var.Y3().L();
            m.b(L4);
            d42.u(requireContext, e5, L4, r1Var.Y3().F(), System.currentTimeMillis(), r1Var.Z3().f10290Y.isChecked());
        }
    }

    /* access modifiers changed from: private */
    public static final void E3(C1941r1 r1Var, C1694v vVar, Drawable drawable, Drawable drawable2, View view) {
        if (UptodownApp.f17422D.a0()) {
            r1Var.d4().a0().setValue(3);
            vVar.f10799e.setImageDrawable(drawable);
            vVar.f10800f.setImageDrawable(drawable);
            vVar.f10801g.setImageDrawable(drawable);
            vVar.f10802h.setImageDrawable(drawable2);
            vVar.f10803i.setImageDrawable(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public static final void E4(C1941r1 r1Var, Context context, AppBarLayout appBarLayout, int i4) {
        m.e(appBarLayout, "appBarLayout");
        if (Math.abs(i4) == appBarLayout.getTotalScrollRange()) {
            r1Var.d4().i0().setValue(Boolean.TRUE);
        } else if (i4 == 0) {
            r1Var.d4().i0().setValue(Boolean.FALSE);
            r1Var.n7(context);
        } else {
            r1Var.d4().i0().setValue(Boolean.FALSE);
            r1Var.m7(context);
        }
    }

    /* access modifiers changed from: private */
    public final void E5(ArrayList arrayList) {
        if (!arrayList.isEmpty()) {
            int dimension = (int) getResources().getDimension(com.uptodown.R.dimen.margin_m);
            int dimension2 = (int) getResources().getDimension(com.uptodown.R.dimen.margin_l);
            Z3().f10311j0.setVisibility(0);
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                if (i4 == C1601o.j(arrayList)) {
                    layoutParams.setMargins(0, dimension, 0, dimension2);
                } else {
                    layoutParams.setMargins(0, dimension, 0, dimension);
                }
                LinearLayout linearLayout = Z3().f10326r;
                Object obj = arrayList.get(i4);
                m.d(obj, "get(...)");
                linearLayout.addView(C5((C2062u) obj, layoutParams));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void E6(C2060s sVar) {
        v6(sVar);
        TextView textView = Z3().f10277L.f10585h;
        m.d(textView, "tvDownloadCancelBad");
        String string = getString(com.uptodown.R.string.option_button_cancel);
        m.d(string, "getString(...)");
        m6(textView, string);
        TextView textView2 = Z3().f10277L.f10587j;
        m.d(textView2, "tvPauseBad");
        String string2 = getString(com.uptodown.R.string.updates_button_resume);
        m.d(string2, "getString(...)");
        l6(textView2, string2);
        Z3().f10273H.f9674b.setVisibility(8);
        Z3().f10273H.f9675c.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void F2() {
        if (getContext() != null) {
            C1988y1 d42 = d4();
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            if (d42.r0(requireContext)) {
                d4().N().setValue(Boolean.TRUE);
                Context requireContext2 = requireContext();
                m.d(requireContext2, "requireContext(...)");
                N3(requireContext2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void F3(C1941r1 r1Var, C1694v vVar, Drawable drawable, Drawable drawable2, View view) {
        if (UptodownApp.f17422D.a0()) {
            r1Var.d4().a0().setValue(4);
            vVar.f10799e.setImageDrawable(drawable);
            vVar.f10800f.setImageDrawable(drawable);
            vVar.f10801g.setImageDrawable(drawable);
            vVar.f10802h.setImageDrawable(drawable);
            vVar.f10803i.setImageDrawable(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public static final void F4(C1941r1 r1Var, CompoundButton compoundButton, boolean z4) {
        C1988y1 d42 = r1Var.d4();
        Context requireContext = r1Var.requireContext();
        m.d(requireContext, "requireContext(...)");
        d42.A0(requireContext, r1Var.Y3().e(), z4);
    }

    /* access modifiers changed from: private */
    public final void F5(ArrayList arrayList) {
        LinearLayout linearLayout = Z3().f10328s;
        m.d(linearLayout, "llFloatingCategoriesAppDetail");
        if (linearLayout.getChildCount() == 0) {
            Z3().f10313k0.setTypeface(N1.k.f7778g.w());
            if (getActivity() != null) {
                HorizontalScrollView horizontalScrollView = new HorizontalScrollView(requireContext());
                horizontalScrollView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                horizontalScrollView.setHorizontalScrollBarEnabled(false);
                LinearLayout linearLayout2 = new LinearLayout(requireContext());
                linearLayout2.setOrientation(0);
                linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                horizontalScrollView.addView(linearLayout2);
                Z3().f10328s.addView(horizontalScrollView);
                Iterator it = arrayList.iterator();
                m.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    C2053k kVar = (C2053k) next;
                    int dimension = (int) getResources().getDimension(com.uptodown.R.dimen.margin_m);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (m.a(kVar, C1601o.P(arrayList))) {
                        layoutParams.setMargins(dimension, 0, dimension, 0);
                    } else {
                        layoutParams.setMargins(dimension, 0, 0, 0);
                    }
                    linearLayout2.addView(G5(kVar, layoutParams));
                }
            }
            Z3().f10330t.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void F6() {
        l7();
        U.b bVar = g2.U.f20468m;
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        if (bVar.e(requireContext) == null) {
            TextView textView = Z3().f10277L.f10585h;
            m.d(textView, "tvDownloadCancelBad");
            String string = getString(com.uptodown.R.string.pre_registration_title);
            m.d(string, "getString(...)");
            l6(textView, string);
            Z3().f10273H.f9687o.setText(getString(com.uptodown.R.string.pre_registration_title));
            Z3().f10273H.f9676d.setVisibility(0);
            TextView textView2 = Z3().f10277L.f10585h;
            m.d(textView2, "tvDownloadCancelBad");
            j5(textView2);
            RelativeLayout relativeLayout = Z3().f10273H.f9680h;
            m.d(relativeLayout, "rlStatusPreRegister");
            j5(relativeLayout);
        } else {
            d3();
        }
        Z3().f10280O.f10420e.setVisibility(0);
        Z3().f10280O.f10418c.setVisibility(8);
        Z3().f10280O.f10430o.setVisibility(8);
        Z3().f10277L.f10581d.setVisibility(8);
        f4(com.uptodown.R.id.action_antivirus_report);
        f4(com.uptodown.R.id.action_uninstall);
    }

    /* access modifiers changed from: private */
    public final void G2() {
        if (N4()) {
            C2054l m4 = UptodownApp.f17422D.m();
            m.b(m4);
            if (m4.b() == -1 && getContext() != null) {
                a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
                Context requireContext = requireContext();
                m.d(requireContext, "requireContext(...)");
                if (aVar.Q(requireContext)) {
                    Context requireContext2 = requireContext();
                    m.d(requireContext2, "requireContext(...)");
                    if (!aVar.c0(requireContext2)) {
                        Context requireContext3 = requireContext();
                        m.d(requireContext3, "requireContext(...)");
                        aVar.b1(requireContext3, false);
                    }
                    Context requireContext4 = requireContext();
                    m.d(requireContext4, "requireContext(...)");
                    N3(requireContext4);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void G3(C1941r1 r1Var, C1694v vVar, Drawable drawable, View view) {
        if (UptodownApp.f17422D.a0()) {
            r1Var.d4().a0().setValue(5);
            vVar.f10799e.setImageDrawable(drawable);
            vVar.f10800f.setImageDrawable(drawable);
            vVar.f10801g.setImageDrawable(drawable);
            vVar.f10802h.setImageDrawable(drawable);
            vVar.f10803i.setImageDrawable(drawable);
        }
    }

    /* access modifiers changed from: private */
    public static final void G4(C1941r1 r1Var, NestedScrollView nestedScrollView, int i4, int i5, int i6, int i7) {
        C2046d dVar;
        C2046d dVar2;
        boolean z4;
        Rect rect = new Rect();
        r1Var.Z3().f10293a0.getHitRect(rect);
        r1Var.U6(rect);
        if (r1Var.Z3().f10280O.f10433r.getLocalVisibleRect(rect)) {
            r1Var.Z3().f10298d.setTitle("");
            r1Var.d4().I().setValue(Boolean.TRUE);
        } else {
            boolean booleanValue = ((Boolean) r1Var.d4().I().getValue()).booleanValue();
            r1Var.d4().I().setValue(Boolean.FALSE);
            String L4 = r1Var.Y3().L();
            if (!(L4 == null || L4.length() == 0)) {
                ArrayList y02 = r1Var.Y3().y0();
                if (y02 == null || y02.isEmpty()) {
                    String y4 = r1Var.Y3().y();
                    if (y4 == null || y4.length() == 0) {
                        r1Var.Z3().f10298d.setTitleEnabled(false);
                        z4 = true;
                    } else {
                        z4 = ((Boolean) r1Var.d4().i0().getValue()).booleanValue();
                    }
                } else {
                    z4 = ((Boolean) r1Var.d4().i0().getValue()).booleanValue();
                }
                if (booleanValue && z4) {
                    if (r1Var.getResources().getConfiguration().getLayoutDirection() == 1) {
                        String L5 = r1Var.Y3().L();
                        m.b(L5);
                        int length = L5.length() - 1;
                        int i8 = 0;
                        for (int i9 = 0; i9 < length; i9++) {
                            String L6 = r1Var.Y3().L();
                            m.b(L6);
                            char charAt = L6.charAt(i9);
                            if (charAt != ' ' && !u2.F.f21886a.j(charAt)) {
                                i8++;
                            }
                        }
                        if (i8 > 0) {
                            r1Var.Z3().f10298d.setRtlTextDirectionHeuristicsEnabled(false);
                            r1Var.Z3().f10298d.setLayoutDirection(0);
                        }
                    }
                    CollapsingToolbarLayout collapsingToolbarLayout = r1Var.Z3().f10298d;
                    String L7 = r1Var.Y3().L();
                    m.b(L7);
                    collapsingToolbarLayout.setTitle(L7);
                }
            }
        }
        if (r1Var.d4().y().getValue() != null) {
            Object value = r1Var.d4().y().getValue();
            m.b(value);
            if (!((C2046d) value).h() && r1Var.Z3().f10265D.getRoot().getLocalVisibleRect(rect) && (dVar2 = (C2046d) r1Var.d4().y().getValue()) != null) {
                Context requireContext = r1Var.requireContext();
                m.d(requireContext, "requireContext(...)");
                dVar2.b(requireContext, Long.valueOf(r1Var.Y3().e()));
            }
        }
        if (r1Var.d4().y().getValue() != null) {
            Object value2 = r1Var.d4().y().getValue();
            m.b(value2);
            if (!((C2046d) value2).h() && r1Var.Z3().f10265D.getRoot().getLocalVisibleRect(rect) && (dVar = (C2046d) r1Var.d4().y().getValue()) != null) {
                Context requireContext2 = r1Var.requireContext();
                m.d(requireContext2, "requireContext(...)");
                dVar.b(requireContext2, Long.valueOf(r1Var.Y3().e()));
            }
        }
    }

    private final View G5(C2053k kVar, LinearLayout.LayoutParams layoutParams) {
        C1661e c5 = C1661e.c(getLayoutInflater());
        m.d(c5, "inflate(...)");
        c5.getRoot().setLayoutParams(layoutParams);
        c5.getRoot().setTypeface(N1.k.f7778g.w());
        c5.getRoot().setText(String.valueOf(kVar.d()));
        c5.getRoot().setOnClickListener(new C1983x(this, kVar));
        TextView b5 = c5.getRoot();
        m.d(b5, "getRoot(...)");
        return b5;
    }

    /* access modifiers changed from: private */
    public final void G6(Context context) {
        Z3().f10280O.f10439x.setVisibility(8);
        Z3().f10280O.f10419d.setVisibility(8);
        if (d4().S().getValue() != null) {
            D6(context);
        } else {
            String c02 = Y3().c0();
            if (c02 == null || c02.length() == 0) {
                String string = getString(com.uptodown.R.string.app_detail_not_available);
                m.d(string, "getString(...)");
                r6(string);
            } else {
                String c03 = Y3().c0();
                m.b(c03);
                r6(c03);
            }
        }
        Z3().f10277L.f10581d.setVisibility(8);
        f4(com.uptodown.R.id.action_antivirus_report);
    }

    private final void H2(C1671j jVar) {
        jVar.f10585h.setTypeface(N1.k.f7778g.w());
        jVar.f10586i.setOnClickListener(new L0(this));
        jVar.f10585h.setOnClickListener(new M0(this));
        jVar.f10586i.setFocusable(true);
        jVar.f10587j.setOnClickListener(new N0(this));
    }

    /* access modifiers changed from: private */
    public static final void H3(Context context, C1941r1 r1Var, C1694v vVar, View view) {
        String str;
        if (UptodownApp.f17422D.a0()) {
            g2.U e5 = g2.U.f20468m.e(context);
            r3.t c02 = r1Var.d4().c0();
            Editable text = vVar.f10797c.getText();
            m.d(text, "getText(...)");
            c02.setValue(m3.m.u0(text).toString());
            if (e5 != null) {
                str = e5.g();
            } else {
                str = null;
            }
            if (str != null) {
                String g4 = e5.g();
                m.b(g4);
                if (g4.length() > 0) {
                    r1Var.i6((String) r1Var.d4().c0().getValue());
                    FragmentActivity activity = r1Var.getActivity();
                    m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    AlertDialog j22 = ((C1826a) activity).j2();
                    if (j22 != null) {
                        j22.dismiss();
                        return;
                    }
                    return;
                }
            }
            r1Var.i5();
        }
    }

    /* access modifiers changed from: private */
    public static final void H5(C1941r1 r1Var, C2053k kVar, View view) {
        if (UptodownApp.f17422D.a0()) {
            r1Var.e5(kVar);
        }
    }

    private final void H6() {
        i7();
        d4().R().setValue(4);
        Z3().f10277L.f10585h.setOnClickListener(new O0(this));
        TextView textView = Z3().f10277L.f10585h;
        m.d(textView, "tvDownloadCancelBad");
        String string = getString(com.uptodown.R.string.option_button_cancel);
        m.d(string, "getString(...)");
        m6(textView, string);
        TextView textView2 = Z3().f10277L.f10587j;
        m.d(textView2, "tvPauseBad");
        String string2 = getString(com.uptodown.R.string.updates_button_resume);
        m.d(string2, "getString(...)");
        l6(textView2, string2);
        TextView textView3 = Z3().f10273H.f9686n;
        m.d(textView3, "tvStatusDownload");
        String string3 = getString(com.uptodown.R.string.updates_button_resume);
        m.d(string3, "getString(...)");
        l6(textView3, string3);
    }

    /* access modifiers changed from: private */
    public static final void I2(C1941r1 r1Var, View view) {
        r1Var.c5();
    }

    /* access modifiers changed from: private */
    public static final void I3(C1941r1 r1Var, C1694v vVar, View view) {
        if (UptodownApp.f17422D.a0()) {
            r3.t c02 = r1Var.d4().c0();
            Editable text = vVar.f10797c.getText();
            m.d(text, "getText(...)");
            c02.setValue(m3.m.u0(text).toString());
            vVar.f10797c.setText((CharSequence) r1Var.d4().c0().getValue());
            FragmentActivity activity = r1Var.getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog j22 = ((C1826a) activity).j2();
            if (j22 != null) {
                j22.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void I4(C1941r1 r1Var, View view) {
        r1Var.p5();
    }

    /* access modifiers changed from: private */
    public final void I5() {
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        z5(requireContext);
        Context requireContext2 = requireContext();
        m.d(requireContext2, "requireContext(...)");
        h7(requireContext2);
        w7();
        f6();
        d4().z().setValue(Boolean.TRUE);
        if (((Number) d4().n0().getValue()).intValue() > 0) {
            u7();
        }
        U3();
    }

    /* access modifiers changed from: private */
    public static final void I6(C1941r1 r1Var, View view) {
        r1Var.i3();
    }

    /* access modifiers changed from: private */
    public static final void J2(C1941r1 r1Var, View view) {
        Context requireContext = r1Var.requireContext();
        m.d(requireContext, "requireContext(...)");
        r1Var.N3(requireContext);
    }

    /* access modifiers changed from: private */
    public static final void J3(C1941r1 r1Var, Context context, DialogInterface dialogInterface) {
        r1Var.s7(((Number) r1Var.d4().a0().getValue()).intValue(), context);
    }

    /* access modifiers changed from: private */
    public static final void J4(C1941r1 r1Var, View view) {
        r1Var.V3();
    }

    /* access modifiers changed from: private */
    public final void J5(g2.N n4) {
        if (getActivity() != null && !requireActivity().isFinishing() && n4 != null) {
            if (n4.h() >= 1) {
                Z3().f10261B.f10234b.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            if (n4.h() >= 2) {
                Z3().f10261B.f10235c.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            if (n4.h() >= 3) {
                Z3().f10261B.f10236d.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            if (n4.h() >= 4) {
                Z3().f10261B.f10237e.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            if (n4.h() == 5) {
                Z3().f10261B.f10238f.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            Z3().f10261B.f10241i.setText(getString(com.uptodown.R.string.edit_your_review));
        }
    }

    /* access modifiers changed from: private */
    public final void J6(int i4) {
        g4();
        Z3().f10280O.f10435t.setText(getString(com.uptodown.R.string.unzipping_status, Integer.valueOf(i4)));
        Z3().f10273H.f9684l.setText(getString(com.uptodown.R.string.unzipping_status, Integer.valueOf(i4)));
    }

    /* access modifiers changed from: private */
    public static final void K2(C1941r1 r1Var, View view) {
        DownloadWorker.a aVar = DownloadWorker.f19459d;
        if (!aVar.j(r1Var.Y3().e())) {
            String Q4 = r1Var.Y3().Q();
            m.b(Q4);
            if (!aVar.m(Q4)) {
                return;
            }
        }
        if (aVar.h()) {
            aVar.o();
            return;
        }
        t.a aVar2 = u2.t.f21927u;
        Context requireContext = r1Var.requireContext();
        m.d(requireContext, "requireContext(...)");
        u2.t a5 = aVar2.a(requireContext);
        a5.a();
        C2060s f02 = a5.f0(String.valueOf(r1Var.Y3().z()));
        a5.i();
        if (f02 != null && aVar.l(f02)) {
            x xVar = r1Var.f19980d;
            if (xVar != null) {
                Bundle bundle = new Bundle();
                bundle.putString("type", "paused");
                s sVar = s.f8222a;
                xVar.d("download", bundle);
            }
            aVar.n();
            r1Var.E6((C2060s) null);
        }
    }

    private final void K3() {
        FragmentActivity activity = getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog j22 = ((C1826a) activity).j2();
        if (j22 != null) {
            j22.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        C1700y c5 = C1700y.c(getLayoutInflater());
        m.d(c5, "inflate(...)");
        if (getActivity() != null && !requireActivity().isFinishing()) {
            TextView textView = c5.f10881g;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.w());
            c5.f10882h.setTypeface(aVar.w());
            c5.f10880f.setTypeface(aVar.w());
            if (((Number) d4().p0().getValue()).intValue() == 1) {
                c5.f10879e.setBackground(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.ripple_blue_primary_button));
                c5.f10882h.setTextColor(ContextCompat.getColor(requireContext(), com.uptodown.R.color.white));
                c5.f10877c.setVisibility(0);
            }
            if (((Number) d4().Y().getValue()).intValue() == 1) {
                c5.f10878d.setBackground(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.ripple_blue_primary_button));
                c5.f10880f.setTextColor(ContextCompat.getColor(requireContext(), com.uptodown.R.color.white));
                c5.f10876b.setVisibility(0);
            }
            c5.f10878d.setOnClickListener(new P0(this));
            c5.f10879e.setOnClickListener(new Q0(this));
            builder.setView(c5.getRoot());
            builder.setCancelable(true);
            V6(builder);
        }
    }

    /* access modifiers changed from: private */
    public static final void K4(C1941r1 r1Var, View view) {
        r1Var.W3();
    }

    /* access modifiers changed from: private */
    public final void K5(ArrayList arrayList) {
        if (Z3().f10324q.getVisibility() == 8 && !arrayList.isEmpty()) {
            M1.I i4 = new M1.I(new F(this), new G(this), 8);
            this.f19985i = i4;
            m.b(i4);
            i4.d(arrayList);
            Z3().f10287V.setAdapter(this.f19985i);
            Z3().f10287V.setNestedScrollingEnabled(false);
            Z3().f10287V.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
            defaultItemAnimator.setSupportsChangeAnimations(false);
            Z3().f10287V.setItemAnimator(defaultItemAnimator);
            Z3().f10324q.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void K6(g2.S s4) {
        C2060s sVar;
        j7();
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = Z3().f10280O.f10423h;
        m.d(progressBar, "pbProgressAppDetail");
        ImageView imageView = Z3().f10280O.f10417b;
        m.d(imageView, "ivLogoAppDetail");
        cVar.e(progressBar, imageView);
        d4().R().setValue(5);
        if (s4 != null) {
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            sVar = s4.b(requireContext);
        } else {
            sVar = null;
        }
        if (sVar != null) {
            Z3().f10280O.f10420e.setVisibility(8);
            Z3().f10280O.f10418c.setVisibility(0);
            Z3().f10277L.f10586i.setVisibility(8);
            TextView textView = Z3().f10277L.f10585h;
            m.d(textView, "tvDownloadCancelBad");
            String string = getString(com.uptodown.R.string.option_button_cancel);
            m.d(string, "getString(...)");
            m6(textView, string);
            Z3().f10277L.f10585h.setOnClickListener(new I0(this));
            if (DownloadWorker.f19459d.h()) {
                TextView textView2 = Z3().f10277L.f10587j;
                m.d(textView2, "tvPauseBad");
                String string2 = getString(com.uptodown.R.string.updates_button_resume);
                m.d(string2, "getString(...)");
                l6(textView2, string2);
            } else {
                TextView textView3 = Z3().f10277L.f10587j;
                m.d(textView3, "tvPauseBad");
                String string3 = getString(com.uptodown.R.string.action_pause);
                m.d(string3, "getString(...)");
                m6(textView3, string3);
            }
            if (sVar.x() > 0) {
                Z3().f10280O.f10423h.setIndeterminate(false);
                Z3().f10280O.f10423h.setProgress(sVar.x());
                Z3().f10273H.f9677e.setIndeterminate(false);
            } else {
                Z3().f10280O.f10423h.setIndeterminate(true);
                Z3().f10273H.f9677e.setIndeterminate(true);
            }
            TextView textView4 = Z3().f10280O.f10435t;
            Integer valueOf = Integer.valueOf(sVar.x());
            i iVar = new i();
            long z4 = sVar.z();
            Context requireContext2 = requireContext();
            m.d(requireContext2, "requireContext(...)");
            textView4.setText(getString(com.uptodown.R.string.percent_of_total_size, valueOf, iVar.d(z4, requireContext2)));
            Z3().f10273H.f9674b.setVisibility(0);
            TextView textView5 = Z3().f10273H.f9684l;
            i iVar2 = new i();
            long z5 = (sVar.z() * ((long) sVar.x())) / ((long) 100);
            Context requireContext3 = requireContext();
            m.d(requireContext3, "requireContext(...)");
            textView5.setText(iVar2.d(z5, requireContext3));
            Z3().f10273H.f9677e.setProgress(sVar.x());
            Z3().f10273H.f9681i.setVisibility(8);
            Z3().f10273H.f9683k.setVisibility(0);
            TextView textView6 = Z3().f10273H.f9683k;
            textView6.setText(sVar.x() + getString(com.uptodown.R.string.percent));
            TextView textView7 = Z3().f10273H.f9685m;
            kotlin.jvm.internal.F f4 = kotlin.jvm.internal.F.f20971a;
            i iVar3 = new i();
            long z6 = sVar.z();
            Context requireContext4 = requireContext();
            m.d(requireContext4, "requireContext(...)");
            String format = String.format("/%s", Arrays.copyOf(new Object[]{iVar3.d(z6, requireContext4)}, 1));
            m.d(format, "format(...)");
            textView7.setText(format);
            return;
        }
        Z3().f10280O.f10423h.setIndeterminate(true);
        Z3().f10273H.f9677e.setIndeterminate(true);
    }

    private final void L2(C1650A a5) {
        TextView textView = a5.f9686n;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        a5.f9684l.setTypeface(aVar.x());
        a5.f9685m.setTypeface(aVar.x());
        a5.f9683k.setTypeface(aVar.x());
        a5.f9681i.setTypeface(aVar.x());
        a5.f9682j.setTypeface(aVar.w());
        a5.f9687o.setTypeface(aVar.w());
        a5.f9686n.setOnClickListener(new E0(this));
        a5.f9686n.setFocusable(true);
        a5.f9674b.setOnClickListener(new F0(a5, this));
        a5.f9675c.setOnClickListener(new G0(a5));
        a5.f9682j.setOnClickListener(new H0(this));
        a5.f9682j.setFocusable(true);
    }

    /* access modifiers changed from: private */
    public static final void L3(C1941r1 r1Var, View view) {
        r1Var.B2();
        FragmentActivity activity = r1Var.getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        ((C1826a) activity).i2();
    }

    /* access modifiers changed from: private */
    public static final void L4(C1941r1 r1Var, View view) {
        r1Var.s5();
    }

    private final View L5(LinearLayout.LayoutParams layoutParams, g2.N n4, Context context) {
        CharSequence charSequence;
        C1695v0 c5 = C1695v0.c(getLayoutInflater());
        m.d(c5, "inflate(...)");
        c5.getRoot().setLayoutParams(layoutParams);
        c5.f10811e.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
        c5.f10812f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
        c5.f10813g.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
        c5.f10814h.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
        c5.f10815i.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
        if (n4.h() >= 2) {
            c5.f10812f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
        }
        if (n4.h() >= 3) {
            c5.f10813g.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
        }
        if (n4.h() >= 4) {
            c5.f10814h.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
        }
        if (n4.h() == 5) {
            c5.f10815i.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
        }
        UsernameTextView usernameTextView = c5.f10826t;
        k.a aVar = N1.k.f7778g;
        usernameTextView.setTypeface(aVar.w());
        c5.f10821o.setTypeface(aVar.x());
        c5.f10820n.setTypeface(aVar.x());
        c5.f10823q.setTypeface(aVar.x());
        c5.f10824r.setTypeface(aVar.x());
        U.b bVar = g2.U.f20468m;
        String c6 = bVar.c(n4.e());
        if (!(c6 == null || c6.length() == 0)) {
            com.squareup.picasso.s.h().l(bVar.c(n4.e())).n(UptodownApp.f17422D.i0(context)).i(c5.f10809c);
        }
        String l4 = n4.l();
        if (!(l4 == null || l4.length() == 0)) {
            c5.f10809c.setOnClickListener(new C1992z0(this, n4));
            c5.f10826t.setOnClickListener(new A0(this, n4));
        }
        String m4 = n4.m();
        if (!(m4 == null || m4.length() == 0)) {
            c5.f10826t.setText(n4.m());
            UsernameTextView.a aVar2 = UsernameTextView.f19434k;
            UsernameTextView usernameTextView2 = c5.f10826t;
            m.d(usernameTextView2, "tvUsernameReview");
            aVar2.a(usernameTextView2, n4.o(), n4.n());
        }
        String k4 = n4.k();
        if (!(k4 == null || k4.length() == 0)) {
            c5.f10821o.setText(n4.k());
        }
        if (n4.a() > 0) {
            c5.f10824r.setText(String.valueOf(n4.a()));
        }
        String i4 = n4.i();
        if (i4 == null || i4.length() == 0) {
            c5.f10820n.setVisibility(8);
            c5.f10818l.setVisibility(8);
            c5.f10817k.setVisibility(8);
        } else {
            c5.f10823q.setFocusable(true);
            TextView textView = c5.f10820n;
            Spanned j4 = n4.j();
            if (j4 != null) {
                charSequence = m3.m.u0(j4);
            } else {
                charSequence = null;
            }
            textView.setText(charSequence);
            c5.f10820n.getViewTreeObserver().addOnPreDrawListener(new H(c5));
            c5.f10825s.setOnClickListener(new B0(c5, this));
            c5.f10818l.setOnClickListener(new C0(this, n4));
            c5.f10818l.setFocusable(true);
            c5.f10822p.setTypeface(aVar.x());
            c5.f10822p.setText(String.valueOf(n4.g()));
            if (u2.F.f21886a.i(n4.f())) {
                c5.f10810d.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_heart_red));
            }
            c5.f10817k.setOnClickListener(new D0(this, c5, n4));
        }
        c5.f10823q.setFocusable(true);
        RelativeLayout b5 = c5.getRoot();
        m.d(b5, "getRoot(...)");
        return b5;
    }

    /* access modifiers changed from: private */
    public static final void L6(C1941r1 r1Var, View view) {
        r1Var.i3();
    }

    /* access modifiers changed from: private */
    public static final void M2(C1941r1 r1Var, View view) {
        Context requireContext = r1Var.requireContext();
        m.d(requireContext, "requireContext(...)");
        r1Var.N3(requireContext);
    }

    /* access modifiers changed from: private */
    public static final void M3(C1941r1 r1Var, View view) {
        r1Var.C2();
        FragmentActivity activity = r1Var.getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        ((C1826a) activity).i2();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void M4(java.io.File r10, android.content.Context r11) {
        /*
            r9 = this;
            java.lang.String r0 = r10.getName()
            java.lang.String r1 = "getName(...)"
            kotlin.jvm.internal.m.d(r0, r1)
            java.lang.String r2 = ".apk"
            r3 = 0
            r4 = 2
            r5 = 0
            boolean r0 = m3.m.o(r0, r2, r3, r4, r5)
            java.lang.String r2 = "null cannot be cast to non-null type com.uptodown.activities.BaseActivity"
            if (r0 == 0) goto L_0x00b9
            r0 = 1
            r6 = -1
            android.content.pm.PackageManager r1 = r11.getPackageManager()     // Catch:{ Exception -> 0x005d }
            java.lang.String r4 = "getPackageManager(...)"
            kotlin.jvm.internal.m.d(r1, r4)     // Catch:{ Exception -> 0x005d }
            java.lang.String r4 = r10.getAbsolutePath()     // Catch:{ Exception -> 0x005d }
            java.lang.String r8 = "getAbsolutePath(...)"
            kotlin.jvm.internal.m.d(r4, r8)     // Catch:{ Exception -> 0x005d }
            android.content.pm.PackageInfo r1 = W1.s.c(r1, r4, r0)     // Catch:{ Exception -> 0x005d }
            if (r1 == 0) goto L_0x0060
            java.lang.String r4 = r1.versionName     // Catch:{ Exception -> 0x005d }
            if (r4 == 0) goto L_0x0036
            r3 = 1
        L_0x0036:
            W1.h r4 = new W1.h     // Catch:{ Exception -> 0x005d }
            r4.<init>()     // Catch:{ Exception -> 0x005d }
            long r6 = r4.m(r1)     // Catch:{ Exception -> 0x005d }
            u2.t$a r1 = u2.t.f21927u     // Catch:{ Exception -> 0x005d }
            u2.t r1 = r1.a(r11)     // Catch:{ Exception -> 0x005d }
            r1.a()     // Catch:{ Exception -> 0x005d }
            g2.h r4 = r9.Y3()     // Catch:{ Exception -> 0x005d }
            java.lang.String r4 = r4.Q()     // Catch:{ Exception -> 0x005d }
            kotlin.jvm.internal.m.b(r4)     // Catch:{ Exception -> 0x005d }
            g2.f r4 = r1.Y(r4)     // Catch:{ Exception -> 0x005d }
            r1.i()     // Catch:{ Exception -> 0x005b }
            goto L_0x0065
        L_0x005b:
            r1 = move-exception
            goto L_0x0062
        L_0x005d:
            r1 = move-exception
            r4 = r5
            goto L_0x0062
        L_0x0060:
            r4 = r5
            goto L_0x0065
        L_0x0062:
            r1.printStackTrace()
        L_0x0065:
            if (r3 == 0) goto L_0x0129
            if (r4 == 0) goto L_0x0082
            long r3 = r4.A()
            int r1 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x0082
            r10 = 2131952305(0x7f1302b1, float:1.954105E38)
            java.lang.String r10 = r9.getString(r10)
            java.lang.String r11 = "getString(...)"
            kotlin.jvm.internal.m.d(r10, r11)
            r9.s3(r10)
            goto L_0x0129
        L_0x0082:
            androidx.fragment.app.FragmentActivity r1 = r9.getActivity()
            if (r1 == 0) goto L_0x0129
            d2.y1 r1 = r9.d4()
            r3.t r1 = r1.j0()
            java.lang.Object r1 = r1.getValue()
            g2.S r1 = (g2.S) r1
            if (r1 == 0) goto L_0x009c
            java.lang.String r5 = r1.h()
        L_0x009c:
            java.lang.String r11 = r11.getPackageName()
            boolean r11 = m3.m.p(r5, r11, r0)
            if (r11 == 0) goto L_0x00b4
            androidx.fragment.app.FragmentActivity r11 = r9.getActivity()
            kotlin.jvm.internal.m.c(r11, r2)
            com.uptodown.activities.a r11 = (com.uptodown.activities.C1826a) r11
            r11.S1(r10)
            goto L_0x0129
        L_0x00b4:
            r9.S4(r10)
            goto L_0x0129
        L_0x00b9:
            W1.G$a r11 = W1.G.f8470b
            java.lang.String r0 = r10.getName()
            kotlin.jvm.internal.m.d(r0, r1)
            boolean r11 = r11.a(r0)
            if (r11 == 0) goto L_0x0129
            W1.G r11 = new W1.G
            r11.<init>()
            boolean r0 = r11.f(r10)
            boolean r11 = r11.c(r10)
            if (r11 == 0) goto L_0x011d
            W1.h r11 = new W1.h
            r11.<init>()
            java.io.File r11 = r11.e()
            boolean r11 = r11.canWrite()
            if (r11 != 0) goto L_0x011d
            androidx.fragment.app.FragmentActivity r11 = r9.getActivity()
            if (r11 == 0) goto L_0x011e
            androidx.fragment.app.FragmentActivity r11 = r9.getActivity()
            kotlin.jvm.internal.m.c(r11, r2)
            com.uptodown.activities.a r11 = (com.uptodown.activities.C1826a) r11
            boolean r11 = r11.T()
            if (r11 == 0) goto L_0x0110
            androidx.fragment.app.FragmentActivity r11 = r9.getActivity()
            kotlin.jvm.internal.m.c(r11, r2)
            com.uptodown.activities.a r11 = (com.uptodown.activities.C1826a) r11
            g2.h r0 = r9.Y3()
            long r0 = r0.e()
            r11.X2(r0)
            goto L_0x011e
        L_0x0110:
            androidx.fragment.app.FragmentActivity r11 = r9.getActivity()
            kotlin.jvm.internal.m.c(r11, r2)
            com.uptodown.activities.a r11 = (com.uptodown.activities.C1826a) r11
            r11.k0()
            goto L_0x011e
        L_0x011d:
            r3 = r0
        L_0x011e:
            if (r3 == 0) goto L_0x0129
            androidx.fragment.app.FragmentActivity r11 = r9.getActivity()
            if (r11 == 0) goto L_0x0129
            r9.S4(r10)
        L_0x0129:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.C1941r1.M4(java.io.File, android.content.Context):void");
    }

    /* access modifiers changed from: private */
    public static final void M5(C1941r1 r1Var, g2.N n4, View view) {
        r1Var.u5(n4);
    }

    /* access modifiers changed from: private */
    public final void M6(Context context) {
        i7();
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = Z3().f10280O.f10423h;
        m.d(progressBar, "pbProgressAppDetail");
        ImageView imageView = Z3().f10280O.f10417b;
        m.d(imageView, "ivLogoAppDetail");
        cVar.c(progressBar, imageView);
        d4().R().setValue(2);
        TextView textView = Z3().f10277L.f10585h;
        m.d(textView, "tvDownloadCancelBad");
        String string = getString(com.uptodown.R.string.updates_button_update_app);
        m.d(string, "getString(...)");
        l6(textView, string);
        Z3().f10277L.f10585h.setOnClickListener(new C1919k(this, context));
        Z3().f10273H.f9686n.setText(getString(com.uptodown.R.string.updates_button_update_app));
        TextView textView2 = Z3().f10273H.f9686n;
        m.d(textView2, "tvStatusDownload");
        String string2 = getString(com.uptodown.R.string.updates_button_update_app);
        m.d(string2, "getString(...)");
        l6(textView2, string2);
        a7(com.uptodown.R.id.action_app_installed_details);
    }

    /* access modifiers changed from: private */
    public static final void N2(C1650A a5, C1941r1 r1Var, View view) {
        if (a5.f9674b.getVisibility() == 0) {
            r1Var.i3();
        }
    }

    private final void N3(Context context) {
        String u4;
        File file;
        String Q4 = Y3().Q();
        File file2 = null;
        if (Q4 != null && Q4.length() != 0 && !com.uptodown.activities.preferences.a.f18818a.Q(context)) {
            u2.t a5 = u2.t.f21927u.a(context);
            a5.a();
            String Q5 = Y3().Q();
            m.b(Q5);
            C2060s h02 = a5.h0(Q5);
            a5.i();
            if (h02 != null) {
                file2 = h02.m(context);
            }
            if (file2 != null) {
                M4(file2, context);
                return;
            }
            String o4 = Y3().o();
            if (o4 == null || o4.length() == 0) {
                String string = getString(com.uptodown.R.string.download_error_message);
                m.d(string, "getString(...)");
                s3(string);
                return;
            }
            C2060s sVar = new C2060s();
            sVar.d(Y3());
            int Q6 = sVar.Q(context);
            v6(sVar);
            DownloadApkWorker.a aVar = DownloadApkWorker.f19447i;
            String o5 = Y3().o();
            m.b(o5);
            aVar.b(context, o5, Q6);
        } else if (((Boolean) d4().N().getValue()).booleanValue() && Y3().B0() && Y3().E0()) {
            u2.t a6 = u2.t.f21927u.a(context);
            a6.a();
            C2060s f02 = a6.f0(String.valueOf(Y3().z()));
            if (f02 != null) {
                file = f02.m(context);
            } else {
                file = null;
            }
            a6.i();
            if (file == null || !file.exists()) {
                v6((C2060s) null);
                c3();
                return;
            }
            M4(file, context);
        } else if (!Y3().F0() || (u4 = Y3().u()) == null || u4.length() == 0) {
            String string2 = getString(com.uptodown.R.string.download_error_message);
            m.d(string2, "getString(...)");
            s3(string2);
        } else {
            U.b bVar = g2.U.f20468m;
            FragmentActivity requireActivity = requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            g2.U e5 = bVar.e(requireActivity);
            if (e5 == null || !e5.n()) {
                String u5 = Y3().u();
                m.b(u5);
                g5(u5, context);
                return;
            }
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            ((C1826a) activity).d2(Y3(), new F(this, context), new Q());
        }
    }

    private final boolean N4() {
        return UptodownApp.f17422D.L(Y3().Q());
    }

    /* access modifiers changed from: private */
    public static final void N5(C1941r1 r1Var, g2.N n4, View view) {
        r1Var.u5(n4);
    }

    /* access modifiers changed from: private */
    public static final void N6(C1941r1 r1Var, Context context, View view) {
        r1Var.N3(context);
    }

    /* access modifiers changed from: private */
    public static final void O2(C1650A a5, View view) {
        if (a5.f9675c.getVisibility() == 0) {
            DownloadWorker.f19459d.o();
        }
    }

    /* access modifiers changed from: private */
    public static final s O3(C1941r1 r1Var, Context context) {
        String u4 = r1Var.Y3().u();
        m.b(u4);
        r1Var.g5(u4, context);
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final boolean O4(g2.S s4) {
        if (DownloadWorker.f19459d.j(Y3().e())) {
            return true;
        }
        if (s4 == null || !UptodownApp.f17422D.O(s4)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static final void O5(C1695v0 v0Var, C1941r1 r1Var, View view) {
        if (v0Var.f10820n.getMaxLines() == Integer.MAX_VALUE) {
            v0Var.f10820n.setMaxLines(4);
            v0Var.f10825s.setText(r1Var.getString(com.uptodown.R.string.read_more_desc_app_detail));
            return;
        }
        v0Var.f10820n.setMaxLines(Integer.MAX_VALUE);
        v0Var.f10825s.setText(r1Var.getString(com.uptodown.R.string.read_less_desc_app_detail));
    }

    /* access modifiers changed from: private */
    public final void O6() {
        i7();
        d4().R().setValue(4);
        TextView textView = Z3().f10277L.f10585h;
        m.d(textView, "tvDownloadCancelBad");
        String string = getString(com.uptodown.R.string.option_button_cancel);
        m.d(string, "getString(...)");
        m6(textView, string);
        Z3().f10277L.f10585h.setOnClickListener(new C1940r0(this));
        TextView textView2 = Z3().f10277L.f10587j;
        m.d(textView2, "tvPauseBad");
        String string2 = getString(com.uptodown.R.string.updates_button_resume);
        m.d(string2, "getString(...)");
        l6(textView2, string2);
        Z3().f10273H.f9686n.setOnClickListener(new C1969s0(this));
        TextView textView3 = Z3().f10273H.f9686n;
        m.d(textView3, "tvStatusDownload");
        String string3 = getString(com.uptodown.R.string.updates_button_resume);
        m.d(string3, "getString(...)");
        l6(textView3, string3);
        a7(com.uptodown.R.id.action_app_installed_details);
    }

    /* access modifiers changed from: private */
    public static final void P2(C1941r1 r1Var, View view) {
        r1Var.c5();
    }

    /* access modifiers changed from: private */
    public static final s P3() {
        return s.f8222a;
    }

    static /* synthetic */ boolean P4(C1941r1 r1Var, g2.S s4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            s4 = null;
        }
        return r1Var.O4(s4);
    }

    /* access modifiers changed from: private */
    public static final void P5(C1941r1 r1Var, g2.N n4, View view) {
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.a0()) {
            Intent intent = new Intent(r1Var.requireActivity(), RepliesActivity.class);
            intent.putExtra("review", n4);
            intent.putExtra("appName", r1Var.Y3().L());
            FragmentActivity requireActivity = r1Var.requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            r1Var.startActivity(intent, aVar.a(requireActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final void P6(C1941r1 r1Var, View view) {
        r1Var.i3();
    }

    /* access modifiers changed from: private */
    public final void Q2(Context context) {
        DownloadWorker.a aVar = DownloadWorker.f19459d;
        if (aVar.j(Y3().e())) {
            String Q4 = Y3().Q();
            m.b(Q4);
            aVar.c(Q4);
            C2313C.f21882a.e(context);
        } else {
            String Q5 = Y3().Q();
            m.b(Q5);
            if (aVar.m(Q5)) {
                String Q6 = Y3().Q();
                m.b(Q6);
                aVar.c(Q6);
            } else {
                u2.t a5 = u2.t.f21927u.a(context);
                a5.a();
                C2060s f02 = a5.f0(String.valueOf(Y3().z()));
                if (f02 != null) {
                    if (f02.N()) {
                        a5.z(f02);
                    } else {
                        Iterator it = f02.o().iterator();
                        m.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            m.d(next, "next(...)");
                            C2060s.c cVar = (C2060s.c) next;
                            cVar.p(0);
                            cVar.l(0);
                            a5.x1(cVar);
                        }
                    }
                }
                a5.i();
            }
        }
        h7(context);
    }

    /* access modifiers changed from: private */
    public final void Q3() {
        if (getContext() == null) {
            return;
        }
        if (d4().S().getValue() != null && d4().j0().getValue() != null) {
            UptodownApp.a aVar = UptodownApp.f17422D;
            Object value = d4().S().getValue();
            m.b(value);
            if (aVar.c((C2048f) value).size() < 2 && aVar.D().size() < 2) {
                Object value2 = d4().j0().getValue();
                m.b(value2);
                g7(((g2.S) value2).h());
            }
            if (DownloadWorker.f19459d.h()) {
                y3(new C1931o());
            }
        } else if (getActivity() != null && (getActivity() instanceof C1826a)) {
            UptodownApp.a aVar2 = UptodownApp.f17422D;
            C2050h Y32 = Y3();
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            int c02 = aVar2.c0(Y32, (C1826a) activity);
            if (c02 >= 0) {
                C1988y1 d42 = d4();
                Context requireContext = requireContext();
                m.d(requireContext, "requireContext(...)");
                if (d42.r0(requireContext)) {
                    C2052j.a aVar3 = C2052j.f20686n;
                    Context requireContext2 = requireContext();
                    m.d(requireContext2, "requireContext(...)");
                    C2052j d5 = aVar3.d(requireContext2);
                    if (d5 != null && d5.k() == ((Number) d4().F().getValue()).longValue()) {
                        Context requireContext3 = requireContext();
                        m.d(requireContext3, "requireContext(...)");
                        d5.w(requireContext3, c02);
                    }
                } else {
                    C1988y1 d43 = d4();
                    Context requireContext4 = requireContext();
                    m.d(requireContext4, "requireContext(...)");
                    if (d43.s0(requireContext4)) {
                        C2065x.a aVar4 = C2065x.f20781n;
                        Context requireContext5 = requireContext();
                        m.d(requireContext5, "requireContext(...)");
                        C2065x d6 = aVar4.d(requireContext5);
                        if (d6 != null && d6.k() == ((Number) d4().F().getValue()).longValue()) {
                            Context requireContext6 = requireContext();
                            m.d(requireContext6, "requireContext(...)");
                            d6.w(requireContext6, c02);
                        }
                    }
                }
                W6();
                if (N4()) {
                    C2054l m4 = aVar2.m();
                    m.b(m4);
                    m4.g(c02);
                }
                String Q4 = Y3().Q();
                m.b(Q4);
                a3(c02, Q4, Y3().e());
                DownloadApkWorker.a aVar5 = DownloadApkWorker.f19447i;
                Context requireContext7 = requireContext();
                m.d(requireContext7, "requireContext(...)");
                if (!aVar5.c(requireContext7, c02)) {
                    TextView textView = Z3().f10277L.f10585h;
                    m.d(textView, "tvDownloadCancelBad");
                    String string = getString(com.uptodown.R.string.option_button_cancel);
                    m.d(string, "getString(...)");
                    m6(textView, string);
                    Z3().f10277L.f10585h.setOnClickListener(new C1934p(this));
                    Z3().f10273H.f9674b.setVisibility(0);
                    a.C0236a aVar6 = com.uptodown.activities.preferences.a.f18818a;
                    Context requireContext8 = requireContext();
                    m.d(requireContext8, "requireContext(...)");
                    if (!aVar6.S(requireContext8)) {
                        FragmentActivity activity2 = getActivity();
                        m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                        kotlin.jvm.internal.F f4 = kotlin.jvm.internal.F.f20971a;
                        String string2 = getString(com.uptodown.R.string.msg_added_to_downlads_queue);
                        m.d(string2, "getString(...)");
                        String format = String.format(string2, Arrays.copyOf(new Object[]{Y3().L()}, 1));
                        m.d(format, "format(...)");
                        ((C1826a) activity2).q0(format);
                    }
                }
                if (DownloadWorker.f19459d.h()) {
                    y3(new C1937q());
                    return;
                }
                return;
            }
            Context requireContext9 = requireContext();
            m.d(requireContext9, "requireContext(...)");
            t6(requireContext9);
        }
    }

    private final void Q4(File file) {
        boolean z4;
        C1958q qVar = new C1958q(this);
        if (getActivity() instanceof MainActivity) {
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            z4 = ((MainActivity) activity).T();
        } else if (getActivity() instanceof AppDetailActivity) {
            FragmentActivity activity2 = getActivity();
            m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity");
            z4 = ((AppDetailActivity) activity2).T();
        } else {
            z4 = true;
        }
        G.a aVar = W1.G.f8470b;
        String name = file.getName();
        m.d(name, "getName(...)");
        if (aVar.a(name)) {
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            String absolutePath = file.getAbsolutePath();
            m.d(absolutePath, "getAbsolutePath(...)");
            new c(requireContext, absolutePath, qVar, z4);
            return;
        }
        UptodownApp.a aVar2 = UptodownApp.f17422D;
        FragmentActivity requireActivity = requireActivity();
        m.d(requireActivity, "requireActivity(...)");
        aVar2.V(file, requireActivity, Y3().M());
        s sVar = s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void Q5(C1941r1 r1Var, C1695v0 v0Var, g2.N n4, View view) {
        if (UptodownApp.f17422D.a0()) {
            Context requireContext = r1Var.requireContext();
            m.d(requireContext, "requireContext(...)");
            y2.n nVar = new y2.n(requireContext);
            ImageView imageView = v0Var.f10810d;
            m.d(imageView, "ivLikesCounterReview");
            nVar.n(imageView);
            if (!u2.F.f21886a.i(n4.f())) {
                r1Var.T4(n4);
                v0Var.f10822p.setText(String.valueOf(n4.g() + 1));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void Q6(C1941r1 r1Var, View view) {
        r1Var.i3();
    }

    /* access modifiers changed from: private */
    public final void R2(View view) {
        view.setOnClickListener(new H(this, view));
    }

    /* access modifiers changed from: private */
    public static final s R3() {
        DownloadWorker.a aVar = DownloadWorker.f19459d;
        if (aVar.h()) {
            aVar.o();
        }
        return s.f8222a;
    }

    private final void R4(File file) {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            C1826a.w2((C1826a) activity, file, (String) null, 2, (Object) null);
        }
    }

    private final View R5(LinearLayout.LayoutParams layoutParams) {
        C1695v0 c5 = C1695v0.c(getLayoutInflater());
        m.d(c5, "inflate(...)");
        c5.getRoot().setLayoutParams(layoutParams);
        c5.getRoot().setVisibility(4);
        RelativeLayout b5 = c5.getRoot();
        m.d(b5, "getRoot(...)");
        return b5;
    }

    private final void R6() {
        if (getContext() != null) {
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            new b2.w(requireContext, Y3(), (C2048f) null, (C2007F) null, LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void S2(C1941r1 r1Var, View view, View view2) {
        if (UptodownApp.f17422D.a0()) {
            FragmentActivity activity = r1Var.getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog j22 = ((C1826a) activity).j2();
            if (j22 != null) {
                j22.dismiss();
            }
            if (view.getContext() != null) {
                C1690t c5 = C1690t.c(r1Var.getLayoutInflater());
                m.d(c5, "inflate(...)");
                TextView textView = c5.f10767f;
                k.a aVar = N1.k.f7778g;
                textView.setTypeface(aVar.w());
                c5.f10767f.setText(r1Var.getString(com.uptodown.R.string.cancel_registration));
                c5.f10765d.setTypeface(aVar.x());
                TextView textView2 = c5.f10765d;
                q qVar = new q();
                String string = r1Var.getString(com.uptodown.R.string.confirm_cancel_preregister, r1Var.Y3().L());
                m.d(string, "getString(...)");
                String L4 = r1Var.Y3().L();
                m.b(L4);
                Context context = view.getContext();
                m.d(context, "getContext(...)");
                textView2.setText(qVar.d(string, L4, context));
                c5.f10764c.setTypeface(aVar.w());
                c5.f10766e.setTypeface(aVar.w());
                c5.f10766e.setText(r1Var.getString(com.uptodown.R.string.dialog_confirmation_verify_afirmative));
                c5.f10764c.setVisibility(0);
                c5.f10764c.setOnClickListener(new C1918j1(r1Var));
                c5.f10766e.setOnClickListener(new C1921k1(r1Var));
                c5.f10763b.setOnClickListener(new C1924l1(r1Var));
                AlertDialog.Builder builder = new AlertDialog.Builder(r1Var.requireContext());
                builder.setView(c5.getRoot());
                builder.setCancelable(true);
                r1Var.V6(builder);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void S3(C1941r1 r1Var, View view) {
        r1Var.i3();
    }

    /* access modifiers changed from: private */
    public final void S4(File file) {
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        if (new P1.a(requireContext).r()) {
            R4(file);
        } else {
            Q4(file);
        }
    }

    private final View S5(LinearLayout.LayoutParams layoutParams, g2.N n4, Context context) {
        CharSequence charSequence;
        C1699x0 c5 = C1699x0.c(getLayoutInflater());
        m.d(c5, "inflate(...)");
        c5.getRoot().setLayoutParams(layoutParams);
        c5.f10859e.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on_turbo));
        c5.f10860f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off_turbo));
        c5.f10861g.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off_turbo));
        c5.f10862h.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off_turbo));
        c5.f10863i.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off_turbo));
        if (n4.h() >= 2) {
            c5.f10860f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on_turbo));
        }
        if (n4.h() >= 3) {
            c5.f10861g.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on_turbo));
        }
        if (n4.h() >= 4) {
            c5.f10862h.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on_turbo));
        }
        if (n4.h() == 5) {
            c5.f10863i.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on_turbo));
        }
        UsernameTextView usernameTextView = c5.f10874t;
        k.a aVar = N1.k.f7778g;
        usernameTextView.setTypeface(aVar.w());
        c5.f10869o.setTypeface(aVar.x());
        c5.f10868n.setTypeface(aVar.x());
        c5.f10871q.setTypeface(aVar.x());
        c5.f10872r.setTypeface(aVar.x());
        U.b bVar = g2.U.f20468m;
        if (bVar.c(n4.e()) != null) {
            com.squareup.picasso.s.h().l(bVar.c(n4.e())).n(UptodownApp.f17422D.i0(context)).i(c5.f10857c);
        }
        String l4 = n4.l();
        if (!(l4 == null || l4.length() == 0)) {
            c5.f10857c.setOnClickListener(new C1878A(this, n4));
            c5.f10874t.setOnClickListener(new C1879B(this, n4));
        }
        if (n4.m() != null) {
            c5.f10874t.setText(n4.m());
            UsernameTextView.a aVar2 = UsernameTextView.f19434k;
            UsernameTextView usernameTextView2 = c5.f10874t;
            m.d(usernameTextView2, "tvUsernameReview");
            aVar2.a(usernameTextView2, n4.o(), n4.n());
        }
        if (n4.k() != null) {
            c5.f10869o.setText(n4.k());
        }
        if (n4.a() > 0) {
            c5.f10872r.setText(String.valueOf(n4.a()));
        }
        if (n4.i() != null) {
            c5.f10871q.setFocusable(true);
            TextView textView = c5.f10868n;
            Spanned j4 = n4.j();
            if (j4 != null) {
                charSequence = m3.m.u0(j4);
            } else {
                charSequence = null;
            }
            textView.setText(charSequence);
            c5.f10868n.getViewTreeObserver().addOnPreDrawListener(new I(c5));
            c5.f10873s.setOnClickListener(new C1880C(c5, this));
            c5.f10866l.setOnClickListener(new C1881D(this, n4));
            c5.f10866l.setFocusable(true);
            c5.f10870p.setTypeface(aVar.x());
            c5.f10870p.setText(String.valueOf(n4.g()));
            if (u2.F.f21886a.i(n4.f())) {
                c5.f10858d.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_heart_red));
            }
            c5.f10865k.setOnClickListener(new C1882E(this, c5, n4));
        } else {
            c5.f10868n.setVisibility(8);
            c5.f10866l.setVisibility(8);
            c5.f10865k.setVisibility(8);
        }
        c5.f10864j.setOnClickListener(new G(this));
        c5.f10864j.setVisibility(0);
        q.a aVar3 = q.f21920a;
        ImageView imageView = c5.f10857c;
        m.d(imageView, "ivAvatarReview");
        aVar3.a(imageView);
        c5.f10871q.setFocusable(true);
        RelativeLayout b5 = c5.getRoot();
        m.d(b5, "getRoot(...)");
        return b5;
    }

    /* access modifiers changed from: private */
    public final void S6(C2050h hVar) {
        if ((getActivity() instanceof MainActivity) || (getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            ((C1826a) activity).V2(hVar, new C1928n(hVar, this));
        }
    }

    /* access modifiers changed from: private */
    public static final void T2(C1941r1 r1Var, View view) {
        FragmentActivity activity = r1Var.getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog j22 = ((C1826a) activity).j2();
        if (j22 != null) {
            j22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final s T3() {
        DownloadWorker.a aVar = DownloadWorker.f19459d;
        if (aVar.h()) {
            aVar.o();
        }
        return s.f8222a;
    }

    private final void T4(g2.N n4) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (o3.L) null, new C1959r(this, n4, (d) null), 2, (Object) null);
        C1988y1 d42 = d4();
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        d42.t0(requireContext, n4);
    }

    /* access modifiers changed from: private */
    public static final void T5(C1941r1 r1Var, g2.N n4, View view) {
        r1Var.u5(n4);
    }

    /* access modifiers changed from: private */
    public static final s T6(C2050h hVar, C1941r1 r1Var) {
        if (hVar.Q() != null) {
            String Q4 = hVar.Q();
            m.b(Q4);
            r1Var.o7(Q4);
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public static final void U2(C1941r1 r1Var, View view) {
        C1988y1 d42 = r1Var.d4();
        Context requireContext = r1Var.requireContext();
        m.d(requireContext, "requireContext(...)");
        d42.v(requireContext, r1Var.Y3().e());
        FragmentActivity activity = r1Var.getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog j22 = ((C1826a) activity).j2();
        if (j22 != null) {
            j22.dismiss();
        }
    }

    private final void U3() {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (o3.L) null, new C1955n(this, (d) null), 3, (Object) null);
    }

    private final void U4() {
        boolean z4;
        U.b bVar = g2.U.f20468m;
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        g2.U e5 = bVar.e(requireContext);
        if (e5 == null || !e5.n()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (Y3().d() != 1 || z4) {
            Z3().f10263C.setVisibility(8);
            Z3().f10263C.release();
            return;
        }
        try {
            Z3().f10263C.init(new BannerSize(5, getResources().getDisplayMetrics().widthPixels, (int) getResources().getDimension(com.uptodown.R.dimen.mintegral_banner_height)), "1517644", "3351941");
            Z3().f10263C.setAllowShowCloseBtn(true);
            Z3().f10263C.setRefreshTime(15);
            Z3().f10263C.setBannerAdListener(new C1960s(this));
            Z3().f10263C.load();
        } catch (Exception e6) {
            e6.printStackTrace();
            Bundle bundle = new Bundle();
            bundle.putString("type", "exception");
            new x(getContext()).d("mintegral_banner", bundle);
            Z3().f10263C.setVisibility(8);
            Z3().f10263C.release();
        }
    }

    /* access modifiers changed from: private */
    public static final void U5(C1941r1 r1Var, g2.N n4, View view) {
        r1Var.u5(n4);
    }

    private final void U6(Rect rect) {
        if (getContext() != null && !m.a(Y3().Q(), requireContext().getPackageName())) {
            if (Z3().f10277L.getRoot().getLocalVisibleRect(rect) && !((Boolean) d4().M().getValue()).booleanValue()) {
                Context requireContext = requireContext();
                m.d(requireContext, "requireContext(...)");
                y2.n nVar = new y2.n(requireContext);
                RelativeLayout relativeLayout = Z3().f10271G;
                m.d(relativeLayout, "rlBottomBoxDownloadButtonAppDetail");
                nVar.i(relativeLayout, com.uptodown.R.anim.slide_out_bottom);
                d4().M().setValue(Boolean.valueOf(!((Boolean) d4().M().getValue()).booleanValue()));
            } else if (!Z3().f10277L.getRoot().getLocalVisibleRect(rect) && ((Boolean) d4().M().getValue()).booleanValue()) {
                Context requireContext2 = requireContext();
                m.d(requireContext2, "requireContext(...)");
                y2.n nVar2 = new y2.n(requireContext2);
                RelativeLayout relativeLayout2 = Z3().f10271G;
                m.d(relativeLayout2, "rlBottomBoxDownloadButtonAppDetail");
                nVar2.h(relativeLayout2, com.uptodown.R.anim.slide_in_bottom);
                d4().M().setValue(Boolean.valueOf(!((Boolean) d4().M().getValue()).booleanValue()));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void V2(C1941r1 r1Var, View view) {
        FragmentActivity activity = r1Var.getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog j22 = ((C1826a) activity).j2();
        if (j22 != null) {
            j22.dismiss();
        }
    }

    private final void V3() {
        String q02;
        String j4 = Y3().j();
        if (j4 != null && j4.length() != 0) {
            if (Z3().f10291Z.getVisibility() == 0) {
                Z3().f10331t0.setText(com.uptodown.R.string.read_less_desc_app_detail);
                Z3().f10291Z.setVisibility(8);
                LinearLayout linearLayout = Z3().f10326r;
                m.d(linearLayout, "llFaqsContainerAppDetails");
                if (linearLayout.getChildCount() != 0) {
                    Z3().f10326r.setVisibility(0);
                }
                String x02 = Y3().x0();
                if (!((x02 == null || x02.length() == 0) && ((q02 = Y3().q0()) == null || q02.length() == 0))) {
                    Z3().f10284S.setVisibility(0);
                }
                Z3().f10301e0.setMaxLines(Integer.MAX_VALUE);
                Z3().f10301e0.setEllipsize((TextUtils.TruncateAt) null);
                String s4 = Y3().s();
                if (s4 != null && s4.length() != 0) {
                    Z3().f10278M.setVisibility(0);
                    return;
                }
                return;
            }
            Z3().f10331t0.setText(com.uptodown.R.string.read_more_desc_app_detail);
            Z3().f10291Z.setVisibility(0);
            Z3().f10326r.setVisibility(8);
            Z3().f10284S.setVisibility(8);
            Z3().f10301e0.setMaxLines(6);
            Z3().f10301e0.setEllipsize(TextUtils.TruncateAt.END);
            Z3().f10278M.setVisibility(8);
            Z3().f10293a0.smoothScrollTo(0, Z3().f10280O.f10433r.getBottom(), 1000);
        }
    }

    private final void V4() {
        if (Y3().y() != null) {
            com.squareup.picasso.w l4 = com.squareup.picasso.s.h().l(Y3().y());
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            l4.n(new C2346d(requireContext)).j(Z3().f10279N.f10406b, new C1961t(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void V5(C1699x0 x0Var, C1941r1 r1Var, View view) {
        if (x0Var.f10868n.getMaxLines() == Integer.MAX_VALUE) {
            x0Var.f10868n.setMaxLines(4);
            x0Var.f10873s.setText(r1Var.getString(com.uptodown.R.string.read_more_desc_app_detail));
            return;
        }
        x0Var.f10868n.setMaxLines(Integer.MAX_VALUE);
        x0Var.f10873s.setText(r1Var.getString(com.uptodown.R.string.read_less_desc_app_detail));
    }

    private final void V6(AlertDialog.Builder builder) {
        if (!UptodownApp.f17422D.M()) {
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            ((C1826a) activity).J2(builder.create());
            if (getActivity() != null && !requireActivity().isFinishing()) {
                FragmentActivity activity2 = getActivity();
                m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                if (((C1826a) activity2).j2() != null) {
                    FragmentActivity activity3 = getActivity();
                    m.c(activity3, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    AlertDialog j22 = ((C1826a) activity3).j2();
                    m.b(j22);
                    Window window = j22.getWindow();
                    if (window != null) {
                        window.setBackgroundDrawable(new ColorDrawable(0));
                    }
                    FragmentActivity activity4 = getActivity();
                    m.c(activity4, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    AlertDialog j23 = ((C1826a) activity4).j2();
                    m.b(j23);
                    j23.show();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (o3.C0977g.g(r7, r4, r0) != r1) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object W2(V2.d r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof d2.C1941r1.C1946e
            if (r0 == 0) goto L_0x0013
            r0 = r7
            d2.r1$e r0 = (d2.C1941r1.C1946e) r0
            int r1 = r0.f20061d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f20061d = r1
            goto L_0x0018
        L_0x0013:
            d2.r1$e r0 = new d2.r1$e
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f20059b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f20061d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            R2.n.b(r7)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.f20058a
            d2.r1 r2 = (d2.C1941r1) r2
            R2.n.b(r7)
            goto L_0x0055
        L_0x003d:
            R2.n.b(r7)
            o3.G r7 = o3.Y.b()
            d2.r1$f r2 = new d2.r1$f
            r2.<init>(r6, r5)
            r0.f20058a = r6
            r0.f20061d = r4
            java.lang.Object r7 = o3.C0977g.g(r7, r2, r0)
            if (r7 != r1) goto L_0x0054
            goto L_0x0068
        L_0x0054:
            r2 = r6
        L_0x0055:
            o3.E0 r7 = o3.Y.c()
            d2.r1$g r4 = new d2.r1$g
            r4.<init>(r2, r5)
            r0.f20058a = r5
            r0.f20061d = r3
            java.lang.Object r7 = o3.C0977g.g(r7, r4, r0)
            if (r7 != r1) goto L_0x0069
        L_0x0068:
            return r1
        L_0x0069:
            R2.s r7 = R2.s.f8222a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.C1941r1.W2(V2.d):java.lang.Object");
    }

    private final void W3() {
        String M4 = Y3().M();
        if (M4 != null && M4.length() != 0) {
            if (Z3().f10285T.f10447e.getVisibility() == 0) {
                Z3().f10285T.f10444b.setText(com.uptodown.R.string.read_less_desc_app_detail);
                Z3().f10285T.f10447e.setVisibility(8);
                Z3().f10285T.f10446d.setMaxLines(Integer.MAX_VALUE);
                Z3().f10285T.f10446d.setEllipsize((TextUtils.TruncateAt) null);
                return;
            }
            Z3().f10285T.f10444b.setText(com.uptodown.R.string.read_more_desc_app_detail);
            Z3().f10285T.f10447e.setVisibility(0);
            Z3().f10285T.f10446d.setMaxLines(6);
            Z3().f10285T.f10446d.setEllipsize(TextUtils.TruncateAt.END);
            Z3().f10293a0.smoothScrollTo(0, Z3().f10285T.f10445c.getTop(), 1000);
        }
    }

    /* access modifiers changed from: private */
    public final void W4(int i4) {
        if (!Y3().N()) {
            Y3().O0(true);
            Bundle bundle = new Bundle();
            bundle.putString("appId", String.valueOf(Y3().e()));
            bundle.putString("type", "noCompatibleFile");
            bundle.putInt("installed", i4);
            x xVar = this.f19980d;
            if (xVar != null) {
                xVar.d("app_details", bundle);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void W5(C1941r1 r1Var, g2.N n4, View view) {
        UptodownApp.a aVar = UptodownApp.f17422D;
        if (aVar.a0()) {
            Intent intent = new Intent(r1Var.requireActivity(), RepliesActivity.class);
            intent.putExtra("review", n4);
            intent.putExtra("appName", r1Var.Y3().L());
            FragmentActivity requireActivity = r1Var.requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            r1Var.startActivity(intent, aVar.a(requireActivity));
        }
    }

    private final void W6() {
        U.b bVar = g2.U.f20468m;
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        g2.U e5 = bVar.e(requireContext);
        if (e5 == null || !e5.n()) {
            C2065x.a aVar = C2065x.f20781n;
            Context requireContext2 = requireContext();
            m.d(requireContext2, "requireContext(...)");
            C2065x d5 = aVar.d(requireContext2);
            if (d5 != null) {
                Context requireContext3 = requireContext();
                m.d(requireContext3, "requireContext(...)");
                if (d5.a(requireContext3) && !m3.m.p(d5.r(), Y3().Q(), true)) {
                    C1653a c5 = C1653a.c(getLayoutInflater());
                    m.d(c5, "inflate(...)");
                    c5.f10189d.setTypeface(N1.k.f7778g.w());
                    com.squareup.picasso.s.h().l(d5.n()).j(c5.f10187b, new R(this, c5));
                    c5.f10188c.setOnClickListener(new C1971t(this, d5));
                    c5.f10187b.setOnClickListener(new C1974u(this, d5));
                    return;
                }
            }
            Z6();
        }
    }

    /* access modifiers changed from: private */
    public final void X3() {
        if (getContext() != null) {
            UptodownApp.a aVar = UptodownApp.f17422D;
            if (aVar.v() > 0) {
                Z3().f10279N.f10406b.setLayoutParams(new RelativeLayout.LayoutParams(-1, aVar.v()));
                Z3().f10298d.setScrimVisibleHeightTrigger((int) (((double) aVar.v()) * 0.4d));
            }
        }
    }

    private final void X4(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("type", str);
        bundle.putString("packagename", Y3().Q());
        if (Y3().e() >= 0) {
            bundle.putString("appId", String.valueOf(Y3().e()));
        }
        if (Y3().z() >= 0) {
            bundle.putString("fileId", String.valueOf(Y3().z()));
        }
        if (N4()) {
            bundle.putInt("deeplink", 1);
        } else {
            bundle.putInt("deeplink", 0);
        }
        x xVar = this.f19980d;
        if (xVar != null) {
            xVar.d("warning", bundle);
        }
    }

    /* access modifiers changed from: private */
    public static final void X5(C1941r1 r1Var, C1699x0 x0Var, g2.N n4, View view) {
        if (UptodownApp.f17422D.a0()) {
            Context requireContext = r1Var.requireContext();
            m.d(requireContext, "requireContext(...)");
            y2.n nVar = new y2.n(requireContext);
            ImageView imageView = x0Var.f10858d;
            m.d(imageView, "ivLikesCounterReview");
            nVar.n(imageView);
            if (!u2.F.f21886a.i(n4.f())) {
                r1Var.T4(n4);
                x0Var.f10870p.setText(String.valueOf(n4.g() + 1));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void X6(C1941r1 r1Var, C2065x xVar, View view) {
        r1Var.Z3().f10302f.removeAllViews();
        r1Var.Z3().f10302f.setVisibility(8);
        Context requireContext = r1Var.requireContext();
        m.d(requireContext, "requireContext(...)");
        xVar.f(requireContext);
    }

    private final void Y2() {
        new Handler(Looper.getMainLooper()).postDelayed(new I(this), 5000);
    }

    /* access modifiers changed from: private */
    public static final void Y4(C1941r1 r1Var, ActivityResult activityResult) {
        String str;
        if (activityResult.getResultCode() == 1) {
            U.b bVar = g2.U.f20468m;
            Context requireContext = r1Var.requireContext();
            m.d(requireContext, "requireContext(...)");
            g2.U e5 = bVar.e(requireContext);
            if (e5 != null) {
                str = e5.g();
            } else {
                str = null;
            }
            if (str != null) {
                Context requireContext2 = r1Var.requireContext();
                m.d(requireContext2, "requireContext(...)");
                if (e5.m(requireContext2)) {
                    UptodownApp.a aVar = UptodownApp.f17422D;
                    Context requireContext3 = r1Var.requireContext();
                    m.d(requireContext3, "requireContext(...)");
                    aVar.m0(requireContext3);
                    Context requireContext4 = r1Var.requireContext();
                    m.d(requireContext4, "requireContext(...)");
                    aVar.l0(requireContext4);
                    r1Var.j6();
                    r1Var.d3();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void Y5(C1941r1 r1Var, View view) {
        r1Var.f7();
    }

    /* access modifiers changed from: private */
    public static final void Y6(C1941r1 r1Var, C2065x xVar, View view) {
        if (UptodownApp.f17422D.a0() && r1Var.getActivity() != null && (r1Var.getActivity() instanceof MainActivity)) {
            Context requireContext = r1Var.requireContext();
            m.d(requireContext, "requireContext(...)");
            xVar.e(requireContext);
            r1Var.Z3().f10302f.removeAllViews();
            r1Var.Z3().f10302f.setVisibility(8);
            FragmentActivity activity = r1Var.getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).C2(xVar.k());
        }
    }

    /* access modifiers changed from: private */
    public static final void Z2(C1941r1 r1Var) {
        if (r1Var.getContext() != null) {
            a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
            Context requireContext = r1Var.requireContext();
            m.d(requireContext, "requireContext(...)");
            if (!aVar.Q(requireContext)) {
                r1Var.n6();
            } else if (r1Var.Z3().f10300e.getChildCount() > 0) {
                r1Var.Z3().f10300e.removeAllViews();
            }
        }
    }

    /* access modifiers changed from: private */
    public final C1659d Z3() {
        C1659d dVar = this.f19978b;
        m.b(dVar);
        return dVar;
    }

    /* access modifiers changed from: private */
    public final void Z4() {
        U.b bVar = g2.U.f20468m;
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        bVar.a(requireContext);
        i5();
    }

    /* access modifiers changed from: private */
    public final void Z5(ArrayList arrayList) {
        LinearLayout linearLayout = Z3().f10338x;
        m.d(linearLayout, "llReviewListContainer");
        if (linearLayout.getChildCount() == 0 && getContext() != null) {
            if (arrayList == null || arrayList.isEmpty()) {
                Z3().f10338x.setVisibility(8);
                Z3().f10276K.setVisibility(8);
                return;
            }
            int dimension = (int) getResources().getDimension(com.uptodown.R.dimen.margin_m);
            if (m3.m.p(getString(com.uptodown.R.string.screen_type), "phone", true)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(dimension, dimension, dimension, dimension);
                Iterator it = arrayList.iterator();
                m.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    g2.N n4 = (g2.N) next;
                    if (n4.o()) {
                        LinearLayout linearLayout2 = Z3().f10338x;
                        Context requireContext = requireContext();
                        m.d(requireContext, "requireContext(...)");
                        linearLayout2.addView(S5(layoutParams, n4, requireContext));
                    } else {
                        LinearLayout linearLayout3 = Z3().f10338x;
                        Context requireContext2 = requireContext();
                        m.d(requireContext2, "requireContext(...)");
                        linearLayout3.addView(L5(layoutParams, n4, requireContext2));
                    }
                }
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(dimension, dimension, dimension, dimension);
            for (int i4 = 0; i4 < arrayList.size(); i4 += 2) {
                LinearLayout linearLayout4 = new LinearLayout(getContext());
                linearLayout4.setOrientation(0);
                linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.setMargins(0, dimension, dimension, dimension);
                layoutParams3.weight = 1.0f;
                if (((g2.N) arrayList.get(i4)).o()) {
                    Object obj = arrayList.get(i4);
                    m.d(obj, "get(...)");
                    Context requireContext3 = requireContext();
                    m.d(requireContext3, "requireContext(...)");
                    linearLayout4.addView(S5(layoutParams2, (g2.N) obj, requireContext3));
                } else {
                    Object obj2 = arrayList.get(i4);
                    m.d(obj2, "get(...)");
                    Context requireContext4 = requireContext();
                    m.d(requireContext4, "requireContext(...)");
                    linearLayout4.addView(L5(layoutParams3, (g2.N) obj2, requireContext4));
                }
                int i5 = i4 + 1;
                if (i5 < arrayList.size()) {
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams4.setMargins(dimension, dimension, 0, dimension);
                    layoutParams4.weight = 1.0f;
                    if (((g2.N) arrayList.get(i5)).o()) {
                        Object obj3 = arrayList.get(i5);
                        m.d(obj3, "get(...)");
                        Context requireContext5 = requireContext();
                        m.d(requireContext5, "requireContext(...)");
                        linearLayout4.addView(S5(layoutParams2, (g2.N) obj3, requireContext5));
                    } else {
                        Object obj4 = arrayList.get(i5);
                        m.d(obj4, "get(...)");
                        Context requireContext6 = requireContext();
                        m.d(requireContext6, "requireContext(...)");
                        linearLayout4.addView(L5(layoutParams4, (g2.N) obj4, requireContext6));
                    }
                } else {
                    linearLayout4.addView(R5(layoutParams3));
                }
                Z3().f10338x.addView(linearLayout4);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void Z6() {
        boolean z4;
        U.b bVar = g2.U.f20468m;
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        g2.U e5 = bVar.e(requireContext);
        if (e5 == null || !e5.n()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (getContext() != null && Y3().d() == 1 && !z4) {
            a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
            Context requireContext2 = requireContext();
            m.d(requireContext2, "requireContext(...)");
            long v4 = aVar.v(requireContext2);
            if (v4 == 0 || System.currentTimeMillis() - v4 >= ((long) 86400000)) {
                try {
                    MBNewInterstitialHandler mBNewInterstitialHandler = new MBNewInterstitialHandler(requireContext(), "1525209", "3361225");
                    mBNewInterstitialHandler.setInterstitialVideoListener(new S(this, mBNewInterstitialHandler));
                    mBNewInterstitialHandler.playVideoMute(1);
                    mBNewInterstitialHandler.load();
                } catch (Exception e6) {
                    e6.printStackTrace();
                    Bundle bundle = new Bundle();
                    bundle.putString("type", "exception");
                    new x(getContext()).d("mintegral_interstitial", bundle);
                }
            }
        }
    }

    private final void a3(int i4, String str, long j4) {
        if (getContext() != null && i4 >= 0) {
            C2033A.a aVar = C2033A.f20327f;
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            C2033A b5 = aVar.b(requireContext);
            if (b5 != null && b5.c() == -1 && m.a(b5.d(), str) && b5.b() == j4) {
                Context requireContext2 = requireContext();
                m.d(requireContext2, "requireContext(...)");
                b5.l(requireContext2, i4);
            }
        }
    }

    private final void a4() {
        if (Y3().e() > 0) {
            I5();
            G2();
            F2();
            s sVar = s.f8222a;
            return;
        }
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        new C1640l(requireContext, ((Number) d4().F().getValue()).longValue(), new C1956o(this), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073 A[Catch:{ Exception -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ac A[Catch:{ Exception -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d5 A[Catch:{ Exception -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dc A[Catch:{ Exception -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e7 A[Catch:{ Exception -> 0x0026 }, LOOP:0: B:40:0x00e5->B:41:0x00e7, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a5() {
        /*
            r4 = this;
            d2.y1 r0 = r4.d4()     // Catch:{ Exception -> 0x0026 }
            r3.t r0 = r0.Q()     // Catch:{ Exception -> 0x0026 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ Exception -> 0x0026 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x0026 }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x0026 }
            if (r0 != 0) goto L_0x0029
            android.graphics.Rect r0 = new android.graphics.Rect     // Catch:{ Exception -> 0x0026 }
            r0.<init>()     // Catch:{ Exception -> 0x0026 }
            c2.d r1 = r4.Z3()     // Catch:{ Exception -> 0x0026 }
            androidx.core.widget.NestedScrollView r1 = r1.f10293a0     // Catch:{ Exception -> 0x0026 }
            r1.getHitRect(r0)     // Catch:{ Exception -> 0x0026 }
            r4.U6(r0)     // Catch:{ Exception -> 0x0026 }
            goto L_0x0029
        L_0x0026:
            r0 = move-exception
            goto L_0x00f3
        L_0x0029:
            d2.y1 r0 = r4.d4()     // Catch:{ Exception -> 0x0026 }
            r3.t r0 = r0.Q()     // Catch:{ Exception -> 0x0026 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ Exception -> 0x0026 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x0026 }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x0026 }
            java.lang.String r1 = "requireContext(...)"
            if (r0 != 0) goto L_0x005b
            g2.h r0 = r4.Y3()     // Catch:{ Exception -> 0x0026 }
            java.lang.String r0 = r0.n()     // Catch:{ Exception -> 0x0026 }
            if (r0 == 0) goto L_0x005b
            int r0 = r0.length()     // Catch:{ Exception -> 0x0026 }
            if (r0 != 0) goto L_0x0050
            goto L_0x005b
        L_0x0050:
            android.content.Context r0 = r4.requireContext()     // Catch:{ Exception -> 0x0026 }
            kotlin.jvm.internal.m.d(r0, r1)     // Catch:{ Exception -> 0x0026 }
            r4.h7(r0)     // Catch:{ Exception -> 0x0026 }
            goto L_0x0068
        L_0x005b:
            d2.y1 r0 = r4.d4()     // Catch:{ Exception -> 0x0026 }
            r3.t r0 = r0.Q()     // Catch:{ Exception -> 0x0026 }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0026 }
            r0.setValue(r2)     // Catch:{ Exception -> 0x0026 }
        L_0x0068:
            g2.h r0 = r4.Y3()     // Catch:{ Exception -> 0x0026 }
            java.lang.String r0 = r0.l0()     // Catch:{ Exception -> 0x0026 }
            r2 = 0
            if (r0 == 0) goto L_0x008e
            int r0 = r0.length()     // Catch:{ Exception -> 0x0026 }
            if (r0 != 0) goto L_0x007a
            goto L_0x008e
        L_0x007a:
            boolean r0 = r4.e4()     // Catch:{ Exception -> 0x0026 }
            if (r0 != 0) goto L_0x008e
            c2.d r0 = r4.Z3()     // Catch:{ Exception -> 0x0026 }
            c2.e1 r0 = r0.f10272G0     // Catch:{ Exception -> 0x0026 }
            android.widget.RelativeLayout r0 = r0.getRoot()     // Catch:{ Exception -> 0x0026 }
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x0026 }
            goto L_0x009d
        L_0x008e:
            c2.d r0 = r4.Z3()     // Catch:{ Exception -> 0x0026 }
            c2.e1 r0 = r0.f10272G0     // Catch:{ Exception -> 0x0026 }
            android.widget.RelativeLayout r0 = r0.getRoot()     // Catch:{ Exception -> 0x0026 }
            r3 = 8
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x0026 }
        L_0x009d:
            r4.U3()     // Catch:{ Exception -> 0x0026 }
            c2.d r0 = r4.Z3()     // Catch:{ Exception -> 0x0026 }
            androidx.core.widget.NestedScrollView r0 = r0.f10293a0     // Catch:{ Exception -> 0x0026 }
            int r0 = r0.getScrollY()     // Catch:{ Exception -> 0x0026 }
            if (r0 <= 0) goto L_0x00d1
            android.content.Context r0 = r4.requireContext()     // Catch:{ Exception -> 0x0026 }
            kotlin.jvm.internal.m.d(r0, r1)     // Catch:{ Exception -> 0x0026 }
            r4.m7(r0)     // Catch:{ Exception -> 0x0026 }
            g2.h r0 = r4.Y3()     // Catch:{ Exception -> 0x0026 }
            java.lang.String r0 = r0.y()     // Catch:{ Exception -> 0x0026 }
            if (r0 == 0) goto L_0x00c6
            int r0 = r0.length()     // Catch:{ Exception -> 0x0026 }
            if (r0 != 0) goto L_0x00d1
        L_0x00c6:
            c2.d r0 = r4.Z3()     // Catch:{ Exception -> 0x0026 }
            com.google.android.material.appbar.CollapsingToolbarLayout r0 = r0.f10298d     // Catch:{ Exception -> 0x0026 }
            java.lang.String r1 = ""
            r0.setTitle(r1)     // Catch:{ Exception -> 0x0026 }
        L_0x00d1:
            M1.I r0 = r4.f19984h     // Catch:{ Exception -> 0x0026 }
            if (r0 == 0) goto L_0x00d8
            r0.notifyDataSetChanged()     // Catch:{ Exception -> 0x0026 }
        L_0x00d8:
            M1.I r0 = r4.f19985i     // Catch:{ Exception -> 0x0026 }
            if (r0 == 0) goto L_0x00df
            r0.notifyDataSetChanged()     // Catch:{ Exception -> 0x0026 }
        L_0x00df:
            java.util.ArrayList r0 = r4.f19986j     // Catch:{ Exception -> 0x0026 }
            int r1 = r0.size()     // Catch:{ Exception -> 0x0026 }
        L_0x00e5:
            if (r2 >= r1) goto L_0x00f6
            java.lang.Object r3 = r0.get(r2)     // Catch:{ Exception -> 0x0026 }
            int r2 = r2 + 1
            M1.I r3 = (M1.I) r3     // Catch:{ Exception -> 0x0026 }
            r3.notifyDataSetChanged()     // Catch:{ Exception -> 0x0026 }
            goto L_0x00e5
        L_0x00f3:
            r0.printStackTrace()
        L_0x00f6:
            c2.d r0 = r4.Z3()
            com.mbridge.msdk.out.MBBannerView r0 = r0.f10263C
            java.lang.String r1 = "mbBannerView"
            kotlin.jvm.internal.m.d(r0, r1)
            r0.onResume()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.C1941r1.a5():void");
    }

    /* access modifiers changed from: private */
    public final void a6(ArrayList arrayList, ArrayList arrayList2) {
        if (!arrayList.isEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            if (!arrayList2.isEmpty()) {
                int size = arrayList2.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList2.get(i4);
                    i4++;
                    g2.Z z4 = (g2.Z) obj;
                    String b5 = z4.b();
                    if (!(b5 == null || b5.length() == 0)) {
                        arrayList3.add(z4);
                    }
                }
            }
            ArrayList arrayList4 = new ArrayList();
            int size2 = arrayList.size();
            for (int i5 = 0; i5 < size2; i5++) {
                Object obj2 = arrayList.get(i5);
                m.d(obj2, "get(...)");
                g2.O o4 = (g2.O) obj2;
                if (o4.a() == 0) {
                    arrayList4.add(o4);
                }
            }
            kotlin.jvm.internal.C c5 = new kotlin.jvm.internal.C();
            J j4 = new J(this, arrayList4, c5, arrayList3);
            ArrayList arrayList5 = new ArrayList();
            arrayList5.addAll(arrayList3);
            arrayList5.addAll(arrayList4);
            c5.f20968a = new M1.B(arrayList5, j4);
            Z3().f10288W.setAdapter((RecyclerView.Adapter) c5.f20968a);
            Z3().f10288W.setVisibility(0);
            return;
        }
        Z3().f10288W.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void a7(int i4) {
        Menu menu = this.f19983g;
        if (menu != null) {
            m.b(menu);
            menu.findItem(i4).setVisible(true);
        }
    }

    /* access modifiers changed from: private */
    public final Object b3(Context context, d dVar) {
        boolean z4;
        kotlin.jvm.internal.C c5 = new kotlin.jvm.internal.C();
        z zVar = new z();
        z zVar2 = new z();
        String Q4 = Y3().Q();
        C2060s sVar = null;
        if (Q4 == null || Q4.length() == 0) {
            Object g4 = C0977g.g(o3.Y.c(), new C1950i(this, (d) null), dVar);
            if (g4 == b.c()) {
                return g4;
            }
            return s.f8222a;
        }
        d4().S().setValue(new u2.m().A(context, Y3().Q()));
        u2.t a5 = u2.t.f21927u.a(context);
        a5.a();
        if (d4().S().getValue() != null) {
            r3.t j02 = d4().j0();
            String Q5 = Y3().Q();
            m.b(Q5);
            j02.setValue(a5.D0(Q5));
            g2.S s4 = (g2.S) d4().j0().getValue();
            if (s4 != null) {
                sVar = s4.b(context);
            }
            c5.f20968a = sVar;
        } else {
            c5.f20968a = a5.f0(String.valueOf(Y3().z()));
        }
        C2060s sVar2 = (C2060s) c5.f20968a;
        boolean z5 = true;
        if (sVar2 == null || !sVar2.K()) {
            z4 = false;
        } else {
            z4 = true;
        }
        zVar.f20985a = z4;
        a5.i();
        C2060s sVar3 = (C2060s) c5.f20968a;
        if (sVar3 == null || sVar3.E() != Y3().H()) {
            z5 = false;
        }
        zVar2.f20985a = z5;
        Object g5 = C0977g.g(o3.Y.c(), new C1949h(this, context, c5, zVar, zVar2, (d) null), dVar);
        if (g5 == b.c()) {
            return g5;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void b4() {
        if (getContext() != null) {
            C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (o3.L) null, new C1957p(this, (d) null), 2, (Object) null);
            C1988y1 d42 = d4();
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            d42.W(requireContext, Y3().e());
        }
    }

    /* access modifiers changed from: private */
    public final void b5(C2047e eVar) {
        if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).g8(eVar);
        } else if (getActivity() != null && (getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity2 = getActivity();
            m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity");
            ((AppDetailActivity) activity2).s3(eVar);
        }
    }

    /* access modifiers changed from: private */
    public final void b6(ArrayList arrayList, boolean z4) {
        int i4;
        if (getContext() == null || arrayList == null || arrayList.isEmpty()) {
            Z3().f10283R.setVisibility(8);
            return;
        }
        K k4 = new K(this);
        L l4 = new L(this);
        if (z4) {
            i4 = 25;
        } else {
            i4 = 20;
        }
        M1.I i5 = new M1.I(k4, l4, i4);
        this.f19984h = i5;
        m.b(i5);
        i5.d(arrayList);
        Z3().f10289X.setAdapter(this.f19984h);
        Z3().f10289X.setNestedScrollingEnabled(false);
        Z3().f10289X.setItemAnimator((RecyclerView.ItemAnimator) null);
        Z3().f10289X.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        Z3().f10283R.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void b7(ArrayList arrayList) {
        C1691t0 c5 = C1691t0.c(getLayoutInflater());
        m.d(c5, "inflate(...)");
        Z3().f10304g.addView(c5.getRoot());
        Z3().f10304g.setVisibility(0);
        TextView textView = c5.f10774g;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.w());
        c5.f10773f.setTypeface(aVar.w());
        z zVar = new z();
        ArrayList arrayList2 = new ArrayList();
        M1.S s4 = new M1.S(arrayList, new T(arrayList, arrayList2, zVar));
        c5.f10772e.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        c5.f10772e.setItemAnimator((RecyclerView.ItemAnimator) null);
        c5.f10772e.setAdapter(s4);
        c5.f10773f.setOnClickListener(new C1936p1(arrayList, this, arrayList2, zVar, c5));
        c5.f10769b.setOnClickListener(new C1922l(this, c5));
        c5.f10775h.setOnClickListener(new C1925m(this, c5));
        FragmentActivity requireActivity = requireActivity();
        m.d(requireActivity, "requireActivity(...)");
        y2.n nVar = new y2.n(requireActivity);
        View view = c5.f10775h;
        m.d(view, "vBackgroundRemoteInstallDevices");
        nVar.d(view, 1.0f);
        FragmentActivity requireActivity2 = requireActivity();
        m.d(requireActivity2, "requireActivity(...)");
        y2.n nVar2 = new y2.n(requireActivity2);
        RelativeLayout relativeLayout = c5.f10771d;
        m.d(relativeLayout, "rlpRemoteInstallDevices");
        nVar2.h(relativeLayout, com.uptodown.R.anim.slide_in_bottom);
    }

    private final void c3() {
        FragmentActivity activity = getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        if (((C1826a) activity).R()) {
            a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            if (!aVar.c0(requireContext)) {
                v7();
            } else {
                x6();
            }
        } else {
            FragmentActivity activity2 = getActivity();
            m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            ((C1826a) activity2).l0();
        }
    }

    private final long c4() {
        try {
            String l02 = Y3().l0();
            if (l02 == null) {
                return 0;
            }
            if (l02.length() == 0) {
                return 0;
            }
            String l03 = Y3().l0();
            m.b(l03);
            return Long.parseLong(l03);
        } catch (NumberFormatException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    private final void c5() {
        String Q4;
        if (getActivity() != null && !requireActivity().isFinishing() && (Q4 = Y3().Q()) != null && Q4.length() != 0 && !m3.m.p(Y3().Q(), requireActivity().getPackageName(), true)) {
            PackageManager packageManager = requireActivity().getPackageManager();
            String Q5 = Y3().Q();
            m.b(Q5);
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(Q5);
            if (launchIntentForPackage != null) {
                startActivity(launchIntentForPackage);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void c6(ArrayList arrayList) {
        LinearLayout linearLayout = Z3().f10328s;
        m.d(linearLayout, "llFloatingCategoriesAppDetail");
        if (linearLayout.getChildCount() == 0) {
            Z3().f10313k0.setVisibility(8);
            if (getActivity() != null) {
                Iterator it = arrayList.iterator();
                int i4 = 0;
                while (it.hasNext()) {
                    int i5 = i4 + 1;
                    g2.Q q4 = (g2.Q) it.next();
                    c2.K c5 = c2.K.c(getLayoutInflater());
                    m.d(c5, "inflate(...)");
                    if (i4 > 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(0, (int) getResources().getDimension(com.uptodown.R.dimen.margin_l), 0, 0);
                        c5.getRoot().setLayoutParams(layoutParams);
                    }
                    M1.I i6 = new M1.I(new M(this), new N(this), 20);
                    i6.d(q4.a());
                    c5.f9814e.setTypeface(N1.k.f7778g.w());
                    c5.f9814e.setText(q4.b().d());
                    c5.f9812c.setOnClickListener(new C1972t0(this, q4));
                    c5.f9813d.setAdapter(i6);
                    c5.f9813d.setNestedScrollingEnabled(false);
                    c5.f9813d.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
                    DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
                    defaultItemAnimator.setSupportsChangeAnimations(false);
                    c5.f9813d.setItemAnimator(defaultItemAnimator);
                    Z3().f10328s.addView(c5.getRoot());
                    this.f19986j.add(i6);
                    i4 = i5;
                }
            }
            Z3().f10330t.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public static final void c7(ArrayList arrayList, C1941r1 r1Var, ArrayList arrayList2, z zVar, C1691t0 t0Var, View view) {
        Object obj;
        int size = arrayList.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i4);
            i4++;
            if (((g2.X) obj).d() == 1) {
                break;
            }
        }
        g2.X x4 = (g2.X) obj;
        if (x4 != null) {
            C1988y1 d42 = r1Var.d4();
            Context requireContext = r1Var.requireContext();
            m.d(requireContext, "requireContext(...)");
            d42.w0(requireContext, r1Var.Y3().e(), x4, arrayList2);
        }
        if (zVar.f20985a && r1Var.Y3().E0() && r1Var.Y3().B0()) {
            Context requireContext2 = r1Var.requireContext();
            m.d(requireContext2, "requireContext(...)");
            r1Var.N3(requireContext2);
        }
        r1Var.h3(t0Var);
    }

    private final void d3() {
        if (Y3().H0()) {
            C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (o3.L) null, new C1951j(this, (d) null), 2, (Object) null);
            C1988y1 d42 = d4();
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            d42.w(requireContext, Y3().e());
        }
    }

    /* access modifiers changed from: private */
    public final C1988y1 d4() {
        return (C1988y1) this.f19979c.getValue();
    }

    private final void d5() {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", Y3().Q(), (String) null));
            intent.addFlags(268435456);
            intent.addFlags(8388608);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e5) {
                e5.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void d6(C1941r1 r1Var, g2.Q q4, View view) {
        if (UptodownApp.f17422D.a0()) {
            r1Var.e5(q4.b());
        }
    }

    /* access modifiers changed from: private */
    public static final void d7(C1941r1 r1Var, C1691t0 t0Var, View view) {
        r1Var.h3(t0Var);
    }

    private final void e3() {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            U.b bVar = g2.U.f20468m;
            FragmentActivity requireActivity = requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            g2.U e5 = bVar.e(requireActivity);
            if (e5 == null || !e5.n()) {
                Q3();
                s sVar = s.f8222a;
            } else if (Y3().e0() == null) {
                FragmentActivity requireActivity2 = requireActivity();
                m.d(requireActivity2, "requireActivity(...)");
                new b2.p(requireActivity2, String.valueOf(Y3().z()), Y3().i0(), new C1952k(this), LifecycleOwnerKt.getLifecycleScope(this));
            } else {
                g2.K e02 = Y3().e0();
                m.b(e02);
                if (e02.d() > 0) {
                    FragmentActivity activity = getActivity();
                    m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    ((C1826a) activity).d2(Y3(), new C1901e1(this), new C1909g1(this));
                } else {
                    Q3();
                }
                s sVar2 = s.f8222a;
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean e4() {
        FragmentActivity activity = getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        if (!((C1826a) activity).R() || getContext() == null) {
            return true;
        }
        w wVar = new w();
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        File f4 = wVar.f(requireContext);
        C2315a aVar = new C2315a();
        w wVar2 = new w();
        Context requireContext2 = requireContext();
        m.d(requireContext2, "requireContext(...)");
        return aVar.a(wVar2.k(requireContext2, f4), c4());
    }

    /* access modifiers changed from: private */
    public final void e5(C2053k kVar) {
        if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).i8(kVar);
        } else if (getActivity() != null && (getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity2 = getActivity();
            m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity");
            ((AppDetailActivity) activity2).t3(kVar);
        }
    }

    private final void e6() {
        boolean z4;
        boolean z5;
        boolean z6;
        if (Y3().B0()) {
            C2060s sVar = new C2060s();
            sVar.d(Y3());
            r rVar = new r();
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            rVar.k(requireContext);
            a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
            Context requireContext2 = requireContext();
            m.d(requireContext2, "requireContext(...)");
            boolean s12 = aVar.s1(requireContext2);
            boolean z7 = true;
            if (s12) {
                boolean i4 = rVar.i(sVar);
                z4 = rVar.g(sVar);
                z6 = rVar.h(sVar);
                if (Y3().f0() != null) {
                    ArrayList f02 = Y3().f0();
                    m.b(f02);
                    Context requireContext3 = requireContext();
                    m.d(requireContext3, "requireContext(...)");
                    z5 = rVar.f(f02, requireContext3);
                    z7 = i4;
                } else {
                    z7 = i4;
                    z5 = true;
                }
            } else {
                z6 = true;
                z5 = true;
                z4 = true;
            }
            if (z7 && z4 && z6 && z5) {
                e3();
            } else if (!z7) {
                X4("sdk");
                String string = getString(com.uptodown.R.string.msg_warning_incompatible_sdk);
                m.d(string, "getString(...)");
                l3(string);
            } else if (!z4) {
                X4("abi");
                String string2 = getString(com.uptodown.R.string.msg_warning_incompatible_abi);
                m.d(string2, "getString(...)");
                l3(string2);
            } else if (!z6) {
                X4("density");
                String string3 = getString(com.uptodown.R.string.msg_warning_incompatible_density);
                m.d(string3, "getString(...)");
                l3(string3);
            } else {
                X4("required_feature");
                String string4 = getString(com.uptodown.R.string.msg_warning_incompatible_required_features);
                m.d(string4, "getString(...)");
                l3(string4);
            }
        } else {
            X4("no_file_id");
            String string5 = getString(com.uptodown.R.string.msg_app_no_compatible_files);
            m.d(string5, "getString(...)");
            s3(string5);
        }
    }

    /* access modifiers changed from: private */
    public static final void e7(C1941r1 r1Var, C1691t0 t0Var, View view) {
        r1Var.h3(t0Var);
    }

    /* access modifiers changed from: private */
    public static final s f3(C1941r1 r1Var) {
        r1Var.Q3();
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void f4(int i4) {
        Menu menu = this.f19983g;
        if (menu != null) {
            m.b(menu);
            menu.findItem(i4).setVisible(false);
        }
    }

    private final void f5() {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            String string = getString(com.uptodown.R.string.dmca_title);
            m.d(string, "getString(...)");
            String string2 = getString(com.uptodown.R.string.url_dmca);
            m.d(string2, "getString(...)");
            q qVar = new q();
            FragmentActivity requireActivity = requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            qVar.q(requireActivity, string2, string);
        }
    }

    private final void f6() {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (o3.L) null, new O(this, (d) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void f7() {
        if (getContext() != null) {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            m.d(build, "build(...)");
            L.a aVar = u2.L.f21898b;
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            build.intent.setData(Uri.parse(new q().c(aVar.c(requireContext))));
            ActivityResultLauncher activityResultLauncher = this.f19989m;
            Intent intent = build.intent;
            UptodownApp.a aVar2 = UptodownApp.f17422D;
            FragmentActivity requireActivity = requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            activityResultLauncher.launch(intent, aVar2.b(requireActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final s g3(C1941r1 r1Var) {
        FragmentActivity requireActivity = r1Var.requireActivity();
        m.d(requireActivity, "requireActivity(...)");
        r1Var.Q2(requireActivity);
        return s.f8222a;
    }

    private final void g4() {
        j7();
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = Z3().f10280O.f10423h;
        m.d(progressBar, "pbProgressAppDetail");
        ImageView imageView = Z3().f10280O.f10417b;
        m.d(imageView, "ivLogoAppDetail");
        cVar.e(progressBar, imageView);
        d4().R().setValue(-1);
        Z3().f10277L.f10586i.setVisibility(8);
        Z3().f10277L.f10583f.setVisibility(8);
        Z3().f10277L.f10584g.setVisibility(0);
        Z3().f10280O.f10423h.setIndeterminate(true);
        Z3().f10280O.f10435t.setText(getString(com.uptodown.R.string.status_download_update_pending));
        Z3().f10273H.f9682j.setVisibility(8);
        Z3().f10273H.f9674b.setVisibility(4);
        Z3().f10273H.f9685m.setText("");
        Z3().f10273H.f9677e.setIndeterminate(true);
        Z3().f10273H.f9683k.setText("");
    }

    private final void g5(String str, Context context) {
        q qVar = new q();
        FragmentActivity activity = getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        q.r(qVar, (C1826a) activity, str, (String) null, 4, (Object) null);
        d4().q0(context, Y3().e());
    }

    private final void g7(String str) {
        if (getContext() != null && !UptodownApp.f17422D.U("GenerateQueueWorker", getContext())) {
            Data build = new Data.Builder().putInt("downloadAutostartedInBackground", 0).putBoolean("downloadAnyway", false).putString("packagename", str).build();
            m.d(build, "build(...)");
            WorkManager.getInstance(requireContext()).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(GenerateQueueWorker.class).addTag("GenerateQueueWorker")).setInputData(build)).build());
        }
    }

    private final void h3(C1691t0 t0Var) {
        if (d4().B().compareAndSet(false, true)) {
            FragmentActivity requireActivity = requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            y2.n nVar = new y2.n(requireActivity);
            View view = t0Var.f10775h;
            m.d(view, "vBackgroundRemoteInstallDevices");
            nVar.d(view, 0.0f);
            FragmentActivity requireActivity2 = requireActivity();
            m.d(requireActivity2, "requireActivity(...)");
            y2.n nVar2 = new y2.n(requireActivity2);
            RelativeLayout relativeLayout = t0Var.f10771d;
            m.d(relativeLayout, "rlpRemoteInstallDevices");
            nVar2.g(relativeLayout, com.uptodown.R.anim.slide_out_bottom, new C1953l(this));
        }
    }

    private final void h4(Context context) {
        if (new q().o(context)) {
            Z3().f10295b0.setTitleTextColor(ContextCompat.getColor(requireActivity(), com.uptodown.R.color.main_blue));
        }
        Z3().f10295b0.setNavigationIcon(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_arrow_left_white));
        Z3().f10295b0.setNavigationContentDescription((CharSequence) getString(com.uptodown.R.string.back));
        Z3().f10295b0.setNavigationOnClickListener(new J(this));
        Z3().f10295b0.inflateMenu(com.uptodown.R.menu.toolbar_menu_app_detail);
        this.f19983g = Z3().f10295b0.getMenu();
        Z3().f10295b0.setOnMenuItemClickListener(new W(this));
        CollapsingToolbarLayout collapsingToolbarLayout = Z3().f10298d;
        k.a aVar = N1.k.f7778g;
        collapsingToolbarLayout.setCollapsedTitleTypeface(aVar.w());
        Z3().f10294b.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new C1914i0(this, context));
        Z3().f10293a0.setOnScrollChangeListener(new C1917j0(this));
        Z3().f10302f.setOnClickListener(new C1920k0());
        if (((Number) d4().F().getValue()).longValue() != -1) {
            X3();
            a.C0236a aVar2 = com.uptodown.activities.preferences.a.f18818a;
            if (aVar2.N(context)) {
                ImageView imageView = Z3().f10280O.f10417b;
                kotlin.jvm.internal.F f4 = kotlin.jvm.internal.F.f20971a;
                String format = String.format("%s%s", Arrays.copyOf(new Object[]{getString(com.uptodown.R.string.transition_name_logo_card), d4().F().getValue()}, 2));
                m.d(format, "format(...)");
                imageView.setTransitionName(format);
            }
            Z3().f10280O.f10427l.setOnClickListener(new C1923l0(this));
            Z3().f10331t0.setOnClickListener(new C1926m0(this));
            Z3().f10280O.f10437v.setTypeface(aVar.w());
            Z3().f10280O.f10436u.setTypeface(aVar.x());
            Z3().f10280O.f10429n.setTypeface(aVar.x());
            Z3().f10280O.f10435t.setTypeface(aVar.x());
            Z3().f10280O.f10438w.setTypeface(aVar.x());
            Z3().f10277L.f10586i.setTypeface(aVar.w());
            Z3().f10277L.f10587j.setTypeface(aVar.w());
            Z3().f10280O.f10429n.setTypeface(aVar.w());
            Z3().f10280O.f10430o.setTypeface(aVar.x());
            Z3().f10280O.f10431p.setTypeface(aVar.w());
            Z3().f10280O.f10432q.setTypeface(aVar.x());
            Z3().f10299d0.setTypeface(aVar.x());
            Z3().f10285T.f10445c.setTypeface(aVar.w());
            Z3().f10285T.f10446d.setTypeface(aVar.x());
            Z3().f10285T.f10444b.setTypeface(aVar.w());
            Z3().f10285T.f10444b.setOnClickListener(new C1932o0(this));
            Z3().f10337w0.setTypeface(aVar.x());
            Z3().f10280O.f10426k.setOnClickListener(new C1935p0(this));
            Z3().f10280O.f10426k.setFocusable(true);
            if (!aVar2.Q(context)) {
                n6();
            }
            Z3().f10280O.f10422g.setFocusable(true);
            Z3().f10280O.f10422g.setOnClickListener(new C1938q0(this, context));
            Z3().f10261B.f10241i.setTypeface(aVar.w());
            Z3().f10261B.f10241i.setOnClickListener(new K(this, context));
            Z3().f10261B.f10240h.setOnClickListener(new L(this, context));
            Z3().f10261B.f10242j.setTypeface(aVar.w());
            Z3().f10288W.setLayoutManager(new LinearLayoutManager(context, 0, false));
            Z3().f10288W.addItemDecoration(new w2.p((int) getResources().getDimension(com.uptodown.R.dimen.margin_m)));
            Z3().f10264C0.setTypeface(aVar.w());
            Z3().f10266D0.setTypeface(aVar.x());
            Z3().f10262B0.setTypeface(aVar.x());
            Z3().f10311j0.setTypeface(aVar.w());
            Z3().f10329s0.setTypeface(aVar.w());
            Z3().f10272G0.getRoot().setVisibility(8);
            Z3().f10297c0.setTypeface(aVar.w());
            Z3().f10274I.setOnClickListener(new M(this));
            Z3().f10317m0.setTypeface(aVar.x());
            Z3().f10315l0.setTypeface(aVar.w());
            Z3().f10325q0.setTypeface(aVar.x());
            Z3().f10323p0.setTypeface(aVar.w());
            Z3().f10321o0.setTypeface(aVar.x());
            Z3().f10319n0.setTypeface(aVar.w());
            Z3().f10327r0.setTypeface(aVar.w());
            Z3().f10327r0.setOnClickListener(new N(this));
            Z3().f10327r0.setFocusable(true);
            Z3().f10303f0.setTypeface(aVar.w());
            Z3().f10303f0.setOnClickListener(new O(this));
            Z3().f10303f0.setFocusable(true);
            Z3().f10340y.f10600h.post(new P(this));
            Z3().f10343z0.setTypeface(aVar.w());
            Z3().f10261B.f10234b.setOnClickListener(new S(this, context));
            Z3().f10261B.f10234b.setFocusable(true);
            Z3().f10261B.f10235c.setOnClickListener(new T(this, context));
            Z3().f10261B.f10235c.setFocusable(true);
            Z3().f10261B.f10236d.setOnClickListener(new U(this, context));
            Z3().f10261B.f10236d.setFocusable(true);
            Z3().f10261B.f10237e.setOnClickListener(new V(this, context));
            Z3().f10261B.f10237e.setFocusable(true);
            Z3().f10261B.f10238f.setOnClickListener(new X(this, context));
            Z3().f10261B.f10238f.setFocusable(true);
            Z3().f10276K.setOnClickListener(new Y(this));
            Z3().f10339x0.setTypeface(aVar.w());
            Z3().f10280O.f10433r.setTypeface(aVar.w());
            Z3().f10280O.f10439x.setTypeface(aVar.x());
            Z3().f10280O.f10434s.setTypeface(aVar.x());
            Z3().f10280O.f10427l.setTypeface(aVar.x());
            Z3().f10280O.f10428m.setTypeface(aVar.x());
            Z3().f10280O.f10428m.setOnClickListener(new Z(this));
            Z3().f10341y0.setTypeface(aVar.w());
            Z3().f10331t0.setTypeface(aVar.w());
            Z3().f10301e0.setTypeface(aVar.x());
            Z3().f10309i0.setTypeface(aVar.x());
            Z3().f10307h0.setTypeface(aVar.w());
            Z3().f10305g0.setTypeface(aVar.x());
            Z3().f10340y.f10607o.setTypeface(aVar.w());
            Z3().f10340y.f10609q.setTypeface(aVar.w());
            Z3().f10340y.f10608p.setTypeface(aVar.x());
            Z3().f10333u0.setTypeface(aVar.w());
            Z3().f10268E0.setTypeface(aVar.w());
            C1671j jVar = Z3().f10277L;
            m.d(jVar, "rlDownloadButtonRootAppDetail");
            H2(jVar);
            C1650A a5 = Z3().f10273H;
            m.d(a5, "rlBottomDownloadButtonAppDetail");
            L2(a5);
            String Q4 = Y3().Q();
            if (Q4 == null || Q4.length() == 0 || !new u2.m().s(Y3().Q(), context)) {
                Z3().f10277L.f10586i.setVisibility(8);
            } else {
                TextView textView = Z3().f10277L.f10586i;
                m.d(textView, "tvOpenBad");
                String string = getString(com.uptodown.R.string.open);
                m.d(string, "getString(...)");
                m6(textView, string);
                Z3().f10277L.f10586i.setVisibility(0);
            }
            if (((Number) d4().R().getValue()).intValue() > -1) {
                int intValue = ((Number) d4().R().getValue()).intValue();
                if (intValue == 0) {
                    D6(context);
                } else if (intValue == 1) {
                    t6(context);
                } else if (intValue == 2) {
                    M6(context);
                } else if (intValue == 3) {
                    z6();
                } else if (intValue == 4) {
                    H6();
                } else if (intValue == 5) {
                    v6((C2060s) null);
                }
            }
            Z3().f10277L.f10580c.setOnClickListener(new C1884a0(this));
            Z3().f10277L.f10582e.setOnClickListener(new C1888b0(this));
            Z3().f10277L.f10581d.setOnClickListener(new C1896d0(this));
            Z3().f10281P.setOnClickListener(new C1900e0(this));
            Z3().f10286U.setOnClickListener(new C1904f0(this));
            Z3().f10269F.setOnClickListener(new C1908g0());
            V4();
            z5(context);
            d4().N().setValue(Boolean.FALSE);
            Z3().f10290Y.setOnCheckedChangeListener(new C1911h0(this));
            a4();
            U4();
        } else if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).getOnBackPressedDispatcher().onBackPressed();
        }
    }

    private final void h5() {
        if (!requireActivity().isFinishing()) {
            Intent intent = new Intent(requireActivity(), InformationActivity.class);
            UptodownApp.a aVar = UptodownApp.f17422D;
            FragmentActivity requireActivity = requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            startActivity(intent, aVar.a(requireActivity));
        }
    }

    /* access modifiers changed from: private */
    public final void h6(View view, Context context) {
        ViewTreeObserver viewTreeObserver;
        if (com.uptodown.activities.preferences.a.f18818a.N(context) && view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnPreDrawListener(new P(view, this));
        }
    }

    /* access modifiers changed from: private */
    public final void h7(Context context) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (o3.L) null, new W(this, context, (d) null), 3, (Object) null);
    }

    private final void i3() {
        FragmentActivity activity = getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog j22 = ((C1826a) activity).j2();
        if (j22 != null) {
            j22.dismiss();
        }
        z zVar = new z();
        if (P4(this, (g2.S) null, 1, (Object) null)) {
            DownloadWorker.a aVar = DownloadWorker.f19459d;
            zVar.f20985a = aVar.h();
            aVar.n();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        C1683p c5 = C1683p.c(getLayoutInflater());
        m.d(c5, "inflate(...)");
        if (getActivity() != null && !requireActivity().isFinishing()) {
            TextView textView = c5.f10696d;
            k.a aVar2 = N1.k.f7778g;
            textView.setTypeface(aVar2.x());
            c5.f10696d.setText(requireContext().getString(com.uptodown.R.string.download_cancel_confimation_title));
            c5.f10695c.setTypeface(aVar2.w());
            c5.f10695c.setText(requireContext().getString(com.uptodown.R.string.dialog_confirmation_verify_negative));
            c5.f10695c.setOnClickListener(new C1893c1(zVar, this));
            c5.f10697e.setTypeface(aVar2.w());
            c5.f10697e.setText(requireContext().getString(com.uptodown.R.string.dialog_confirmation_verify_afirmative));
            c5.f10697e.setOnClickListener(new C1897d1(this));
        }
        builder.setView(c5.getRoot());
        builder.setCancelable(false);
        V6(builder);
    }

    /* access modifiers changed from: private */
    public static final void i4(C1941r1 r1Var, View view) {
        if (r1Var.getActivity() == null) {
            return;
        }
        if (r1Var.getActivity() instanceof MainActivity) {
            FragmentActivity activity = r1Var.getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).Z6();
        } else if (r1Var.getActivity() instanceof AppDetailActivity) {
            FragmentActivity activity2 = r1Var.getActivity();
            m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity");
            ((AppDetailActivity) activity2).finish();
        }
    }

    private final void i5() {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            Intent intent = new Intent(requireActivity(), LoginActivity.class);
            ActivityResultLauncher activityResultLauncher = this.f19988l;
            UptodownApp.a aVar = UptodownApp.f17422D;
            FragmentActivity requireActivity = requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            activityResultLauncher.launch(intent, aVar.b(requireActivity));
        }
    }

    private final void i6(String str) {
        int intValue = ((Number) d4().a0().getValue()).intValue();
        if (1 > intValue || intValue >= 6) {
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            String string = getString(com.uptodown.R.string.error_review_no_valoration);
            m.d(string, "getString(...)");
            ((C1826a) activity).q0(string);
            return;
        }
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (o3.L) null, new Q(this, (d) null), 2, (Object) null);
        C1988y1 d42 = d4();
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        d42.x0(requireContext, str, ((Number) d4().a0().getValue()).intValue(), Y3().e());
    }

    private final void i7() {
        Z3().f10280O.f10420e.setVisibility(0);
        Z3().f10280O.f10418c.setVisibility(8);
        Z3().f10277L.f10583f.setVisibility(0);
        Z3().f10277L.f10585h.setVisibility(0);
        Z3().f10277L.f10586i.setVisibility(8);
        Z3().f10277L.f10587j.setVisibility(8);
        Z3().f10273H.f9686n.setVisibility(0);
        Z3().f10273H.f9678f.setVisibility(8);
        Z3().f10273H.f9682j.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void j3(z zVar, C1941r1 r1Var, View view) {
        if (!zVar.f20985a) {
            DownloadWorker.f19459d.o();
        }
        FragmentActivity activity = r1Var.getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog j22 = ((C1826a) activity).j2();
        if (j22 != null) {
            j22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void j4(C1941r1 r1Var, Context context, View view) {
        r1Var.B3(context);
    }

    private final void j5(View view) {
        view.setOnClickListener(new C1987y0(this, view));
    }

    private final void j6() {
        if (((CharSequence) d4().c0().getValue()).length() > 0) {
            i6((String) d4().c0().getValue());
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog j22 = ((C1826a) activity).j2();
            if (j22 != null) {
                j22.dismiss();
            }
        }
    }

    private final void j7() {
        Z3().f10280O.f10420e.setVisibility(8);
        Z3().f10280O.f10418c.setVisibility(0);
        Z3().f10277L.f10583f.setVisibility(0);
        Z3().f10277L.f10585h.setVisibility(0);
        Z3().f10277L.f10579b.setVisibility(8);
        Z3().f10277L.f10586i.setVisibility(8);
        Z3().f10273H.f9679g.setVisibility(8);
        Z3().f10273H.f9686n.setVisibility(8);
        Z3().f10273H.f9678f.setVisibility(0);
        Z3().f10273H.f9682j.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void k3(C1941r1 r1Var, View view) {
        Context requireContext = r1Var.requireContext();
        m.d(requireContext, "requireContext(...)");
        r1Var.Q2(requireContext);
        FragmentActivity activity = r1Var.getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog j22 = ((C1826a) activity).j2();
        if (j22 != null) {
            j22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void k4(C1941r1 r1Var, Context context, View view) {
        r1Var.B3(context);
    }

    /* access modifiers changed from: private */
    public static final void k5(C1941r1 r1Var, View view, View view2) {
        if (UptodownApp.f17422D.a0()) {
            FragmentActivity activity = r1Var.getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog j22 = ((C1826a) activity).j2();
            if (j22 != null) {
                j22.dismiss();
            }
            if (view.getContext() != null) {
                C1690t c5 = C1690t.c(r1Var.getLayoutInflater());
                m.d(c5, "inflate(...)");
                TextView textView = c5.f10767f;
                k.a aVar = N1.k.f7778g;
                textView.setTypeface(aVar.w());
                c5.f10765d.setTypeface(aVar.x());
                c5.f10766e.setTypeface(aVar.w());
                c5.f10766e.setOnClickListener(new C1912h1(r1Var));
                c5.f10763b.setOnClickListener(new C1915i1(r1Var));
                AlertDialog.Builder builder = new AlertDialog.Builder(r1Var.requireContext());
                builder.setView(c5.getRoot());
                builder.setCancelable(true);
                r1Var.V6(builder);
            }
        }
    }

    private final void k7() {
        Z3().f10280O.f10420e.setVisibility(0);
        Z3().f10280O.f10418c.setVisibility(8);
        Z3().f10277L.f10583f.setVisibility(8);
        Z3().f10277L.f10585h.setVisibility(8);
        Z3().f10277L.f10579b.setVisibility(8);
        Z3().f10277L.f10586i.setVisibility(0);
        Z3().f10277L.f10587j.setVisibility(8);
        Z3().f10273H.f9686n.setVisibility(8);
        Z3().f10273H.f9678f.setVisibility(8);
        Z3().f10273H.f9682j.setVisibility(0);
    }

    private final void l3(String str) {
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog j22 = ((C1826a) activity).j2();
            if (j22 != null) {
                j22.dismiss();
            }
        }
        if (getContext() != null) {
            C1683p c5 = C1683p.c(getLayoutInflater());
            m.d(c5, "inflate(...)");
            TextView textView = c5.f10696d;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.x());
            c5.f10696d.setText(str);
            c5.f10694b.setVisibility(0);
            c5.f10694b.setTypeface(aVar.x());
            c5.f10694b.setOnCheckedChangeListener(new C1927m1(this));
            c5.f10697e.setTypeface(aVar.w());
            c5.f10697e.setOnClickListener(new C1930n1(this));
            c5.f10695c.setTypeface(aVar.w());
            c5.f10695c.setOnClickListener(new C1933o1(c5, this));
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setView(c5.getRoot());
            builder.setCancelable(false);
            V6(builder);
        }
    }

    /* access modifiers changed from: private */
    public static final void l4(C1941r1 r1Var, Context context, View view) {
        r1Var.B3(context);
    }

    /* access modifiers changed from: private */
    public static final void l5(C1941r1 r1Var, View view) {
        r1Var.i5();
        FragmentActivity activity = r1Var.getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog j22 = ((C1826a) activity).j2();
        if (j22 != null) {
            j22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void l6(TextView textView, String str) {
        textView.setText(str);
        v.a(textView);
    }

    private final void l7() {
        Z3().f10280O.f10420e.setVisibility(0);
        Z3().f10280O.f10418c.setVisibility(8);
        Z3().f10277L.f10583f.setVisibility(0);
        Z3().f10277L.f10585h.setVisibility(0);
        Z3().f10277L.f10579b.setVisibility(8);
        Z3().f10277L.f10586i.setVisibility(8);
        Z3().f10277L.f10587j.setVisibility(8);
        Z3().f10273H.f9680h.setVisibility(0);
        Z3().f10273H.f9686n.setVisibility(8);
        Z3().f10273H.f9679g.setVisibility(8);
        Z3().f10273H.f9678f.setVisibility(8);
        Z3().f10273H.f9682j.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void m3(C1941r1 r1Var, CompoundButton compoundButton, boolean z4) {
        a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
        Context requireContext = r1Var.requireContext();
        m.d(requireContext, "requireContext(...)");
        aVar.f1(requireContext, !z4);
    }

    /* access modifiers changed from: private */
    public static final void m4(C1941r1 r1Var, View view) {
        r1Var.n5();
    }

    /* access modifiers changed from: private */
    public static final void m5(C1941r1 r1Var, View view) {
        FragmentActivity activity = r1Var.getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog j22 = ((C1826a) activity).j2();
        if (j22 != null) {
            j22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void m6(TextView textView, String str) {
        textView.setText(str);
        v.b(textView);
    }

    private final void m7(Context context) {
        Z3().f10270F0.setVisibility(8);
        Z3().f10295b0.setBackgroundColor(ContextCompat.getColor(context, com.uptodown.R.color.transparent));
        if (new q().o(context)) {
            p6(ContextCompat.getColor(context, com.uptodown.R.color.main_blue));
            Drawable drawable = ContextCompat.getDrawable(context, com.uptodown.R.drawable.core_vector_back);
            if (drawable != null) {
                Z3().f10295b0.setNavigationIcon(drawable);
            }
            Drawable drawable2 = ContextCompat.getDrawable(context, com.uptodown.R.drawable.core_vector_menu_dots_blue);
            if (drawable2 != null) {
                Z3().f10295b0.setOverflowIcon(drawable2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void n3(C1941r1 r1Var, View view) {
        r1Var.Q3();
        if (r1Var.getActivity() != null) {
            FragmentActivity activity = r1Var.getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog j22 = ((C1826a) activity).j2();
            if (j22 != null) {
                j22.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void n4(C1941r1 r1Var, View view) {
        r1Var.o5();
    }

    private final void n5() {
        if (!requireActivity().isFinishing()) {
            Intent intent = new Intent(requireActivity(), MoreInfo.class);
            intent.putExtra("appInfo", Y3());
            UptodownApp.a aVar = UptodownApp.f17422D;
            FragmentActivity requireActivity = requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            startActivity(intent, aVar.a(requireActivity));
        }
    }

    /* access modifiers changed from: private */
    public final void n6() {
        if (Z3().f10300e.getChildCount() == 0) {
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            t6(requireContext);
            C1675l c5 = C1675l.c(getLayoutInflater());
            m.d(c5, "inflate(...)");
            c5.f10616b.setTypeface(N1.k.f7778g.x());
            Z3().f10300e.addView(c5.getRoot());
        }
        Y2();
    }

    /* access modifiers changed from: private */
    public final void n7(Context context) {
        Z3().f10270F0.setVisibility(0);
        Z3().f10295b0.setBackgroundColor(ContextCompat.getColor(context, com.uptodown.R.color.transparent));
        p6(ContextCompat.getColor(context, com.uptodown.R.color.white));
        Drawable drawable = ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_arrow_left_white);
        if (drawable != null) {
            Z3().f10295b0.setNavigationIcon(drawable);
        }
        Drawable drawable2 = ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_menu_dots);
        if (drawable2 != null) {
            Z3().f10295b0.setOverflowIcon(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public static final void o3(C1683p pVar, C1941r1 r1Var, View view) {
        if (pVar.f10694b.isChecked()) {
            a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
            Context requireContext = r1Var.requireContext();
            m.d(requireContext, "requireContext(...)");
            aVar.f1(requireContext, true);
        }
        Context requireContext2 = r1Var.requireContext();
        m.d(requireContext2, "requireContext(...)");
        r1Var.t6(requireContext2);
        if (r1Var.getActivity() != null) {
            FragmentActivity activity = r1Var.getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog j22 = ((C1826a) activity).j2();
            if (j22 != null) {
                j22.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void o4(C1941r1 r1Var, View view) {
        r1Var.f5();
    }

    private final void o5() {
        if (!requireActivity().isFinishing() && Y3().E0()) {
            Intent intent = new Intent(requireActivity(), OldVersionsActivity.class);
            intent.putExtra("appInfo", Y3());
            UptodownApp.a aVar = UptodownApp.f17422D;
            FragmentActivity requireActivity = requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            startActivity(intent, aVar.a(requireActivity));
        }
    }

    /* access modifiers changed from: private */
    public final void o6(int i4, String str) {
        Menu menu = this.f19983g;
        if (menu != null) {
            m.b(menu);
            menu.findItem(i4).setTitle(str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void p3() {
        /*
            r11 = this;
            r0 = 1
            r1 = 0
            androidx.fragment.app.FragmentActivity r2 = r11.getActivity()
            java.lang.String r3 = "null cannot be cast to non-null type com.uptodown.activities.BaseActivity"
            kotlin.jvm.internal.m.c(r2, r3)
            com.uptodown.activities.a r2 = (com.uptodown.activities.C1826a) r2
            android.app.AlertDialog r2 = r2.j2()
            if (r2 == 0) goto L_0x0016
            r2.dismiss()
        L_0x0016:
            androidx.fragment.app.FragmentActivity r2 = r11.getActivity()
            if (r2 == 0) goto L_0x0185
            java.util.ArrayList r2 = r11.f19982f
            if (r2 == 0) goto L_0x0185
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0028
            goto L_0x0185
        L_0x0028:
            com.uptodown.activities.preferences.a$a r2 = com.uptodown.activities.preferences.a.f18818a
            androidx.fragment.app.FragmentActivity r3 = r11.requireActivity()
            java.lang.String r4 = "requireActivity(...)"
            kotlin.jvm.internal.m.d(r3, r4)
            boolean r3 = r2.c0(r3)
            if (r3 != 0) goto L_0x003b
        L_0x0039:
            r2 = 0
            goto L_0x0049
        L_0x003b:
            androidx.fragment.app.FragmentActivity r3 = r11.requireActivity()
            kotlin.jvm.internal.m.d(r3, r4)
            boolean r2 = r2.b0(r3)
            if (r2 == 0) goto L_0x0039
            r2 = 1
        L_0x0049:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            kotlin.jvm.internal.F r6 = kotlin.jvm.internal.F.f20971a
            r6 = 2131952093(0x7f1301dd, float:1.954062E38)
            java.lang.String r6 = r11.getString(r6)
            java.lang.String r7 = "getString(...)"
            kotlin.jvm.internal.m.d(r6, r7)
            W1.i r8 = new W1.i
            r8.<init>()
            u2.w r9 = new u2.w
            r9.<init>()
            androidx.fragment.app.FragmentActivity r10 = r11.requireActivity()
            kotlin.jvm.internal.m.d(r10, r4)
            java.io.File r4 = r9.f(r10)
            long r9 = r4.getFreeSpace()
            java.lang.String r4 = r8.c(r9)
            java.lang.Object[] r8 = new java.lang.Object[r0]
            r8[r1] = r4
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r8, r0)
            java.lang.String r4 = java.lang.String.format(r6, r4)
            java.lang.String r6 = "format(...)"
            kotlin.jvm.internal.m.d(r4, r6)
            r3.put(r5, r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            r5 = 2131952585(0x7f1303c9, float:1.9541617E38)
            java.lang.String r5 = r11.getString(r5)
            kotlin.jvm.internal.m.d(r5, r7)
            W1.i r7 = new W1.i
            r7.<init>()
            java.util.ArrayList r8 = r11.f19982f
            kotlin.jvm.internal.m.b(r8)
            java.lang.Object r8 = S2.C1601o.H(r8)
            T1.h r8 = (T1.h) r8
            long r8 = r8.a()
            java.lang.String r7 = r7.c(r8)
            java.lang.Object[] r8 = new java.lang.Object[r0]
            r8[r1] = r7
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r8, r0)
            java.lang.String r1 = java.lang.String.format(r5, r1)
            kotlin.jvm.internal.m.d(r1, r6)
            r3.put(r4, r1)
            android.view.LayoutInflater r1 = r11.getLayoutInflater()
            c2.w r1 = c2.C1696w.c(r1)
            java.lang.String r4 = "inflate(...)"
            kotlin.jvm.internal.m.d(r1, r4)
            android.widget.TextView r5 = r1.f10830d
            N1.k$a r6 = N1.k.f7778g
            android.graphics.Typeface r6 = r6.w()
            r5.setTypeface(r6)
            android.widget.TextView r5 = r1.f10830d
            r6 = 2131952597(0x7f1303d5, float:1.9541641E38)
            java.lang.String r6 = r11.getString(r6)
            r5.setText(r6)
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x00f5:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x015a
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            android.view.LayoutInflater r6 = r11.getLayoutInflater()
            c2.D0 r6 = c2.D0.c(r6)
            kotlin.jvm.internal.m.d(r6, r4)
            android.widget.RadioButton r7 = r6.getRoot()
            java.lang.Object r8 = r5.getKey()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r7.setId(r8)
            android.widget.RadioButton r7 = r6.f9719b
            N1.k$a r8 = N1.k.f7778g
            android.graphics.Typeface r8 = r8.x()
            r7.setTypeface(r8)
            android.widget.RadioButton r7 = r6.f9719b
            java.lang.Object r8 = r5.getValue()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
            android.widget.RadioButton r7 = r6.getRoot()
            d2.R0 r8 = new d2.R0
            r8.<init>(r11, r5)
            r7.setOnClickListener(r8)
            java.lang.Object r5 = r5.getKey()
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            if (r5 != r2) goto L_0x0150
            android.widget.RadioButton r5 = r6.f9719b
            r5.setChecked(r0)
        L_0x0150:
            android.widget.RadioGroup r5 = r1.f10828b
            android.widget.RadioButton r6 = r6.getRoot()
            r5.addView(r6)
            goto L_0x00f5
        L_0x015a:
            android.widget.TextView r2 = r1.f10829c
            N1.k$a r3 = N1.k.f7778g
            android.graphics.Typeface r3 = r3.w()
            r2.setTypeface(r3)
            android.widget.TextView r2 = r1.f10829c
            d2.S0 r3 = new d2.S0
            r3.<init>(r11)
            r2.setOnClickListener(r3)
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            android.content.Context r3 = r11.getContext()
            r2.<init>(r3)
            android.widget.LinearLayout r1 = r1.getRoot()
            r2.setView(r1)
            r2.setCancelable(r0)
            r11.V6(r2)
        L_0x0185:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.C1941r1.p3():void");
    }

    /* access modifiers changed from: private */
    public static final void p4(C1941r1 r1Var) {
        r1Var.d4().n0().setValue(Integer.valueOf(r1Var.Z3().f10340y.f10601i.getMeasuredWidth()));
        if (((Boolean) r1Var.d4().z().getValue()).booleanValue()) {
            r1Var.u7();
        }
    }

    private final void p5() {
        if (!requireActivity().isFinishing()) {
            Intent intent = new Intent(requireActivity(), OrganizationActivity.class);
            intent.putExtra("organizationID", Y3().P());
            intent.putExtra("organizationName", Y3().g());
            UptodownApp.a aVar = UptodownApp.f17422D;
            FragmentActivity requireActivity = requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            startActivity(intent, aVar.a(requireActivity));
        }
    }

    private final void p6(int i4) {
        Menu menu = this.f19983g;
        m.b(menu);
        Drawable icon = menu.findItem(com.uptodown.R.id.action_search).getIcon();
        if (icon != null) {
            DrawableCompat.setTint(icon, i4);
        }
    }

    /* access modifiers changed from: private */
    public final void p7(g2.N n4, int i4) {
        int dimension = (int) getResources().getDimension(com.uptodown.R.dimen.margin_m);
        LinearLayout linearLayout = Z3().f10338x;
        m.d(linearLayout, "llReviewListContainer");
        if (linearLayout.getChildCount() > i4) {
            Z3().f10338x.removeViewAt(i4);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(dimension, dimension, dimension, dimension);
        if (n4.o()) {
            LinearLayout linearLayout2 = Z3().f10338x;
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            linearLayout2.addView(S5(layoutParams, n4, requireContext), i4);
            return;
        }
        LinearLayout linearLayout3 = Z3().f10338x;
        Context requireContext2 = requireContext();
        m.d(requireContext2, "requireContext(...)");
        linearLayout3.addView(L5(layoutParams, n4, requireContext2), i4);
    }

    /* access modifiers changed from: private */
    public static final void q3(C1941r1 r1Var, Map.Entry entry, View view) {
        r1Var.d4().d0().setValue(entry.getKey());
    }

    /* access modifiers changed from: private */
    public static final void q4(C1941r1 r1Var, Context context, View view) {
        r1Var.d4().a0().setValue(1);
        r1Var.B3(context);
    }

    /* access modifiers changed from: private */
    public final void q5(long j4) {
        if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).C2(j4);
        } else if (getActivity() != null && (getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity2 = getActivity();
            m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity");
            ((AppDetailActivity) activity2).C2(j4);
        }
    }

    /* access modifiers changed from: private */
    public final void q6() {
        Z3().f10280O.f10439x.setVisibility(8);
        Z3().f10280O.f10419d.setVisibility(8);
        String string = getString(com.uptodown.R.string.download_not_available_in_this_country);
        m.d(string, "getString(...)");
        r6(string);
        Z3().f10277L.f10581d.setVisibility(8);
        f4(com.uptodown.R.id.action_antivirus_report);
    }

    /* access modifiers changed from: private */
    public static final void r3(C1941r1 r1Var, View view) {
        boolean z4;
        if (((Number) r1Var.d4().d0().getValue()).intValue() >= 0) {
            a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
            Context requireContext = r1Var.requireContext();
            m.d(requireContext, "requireContext(...)");
            if (((Number) r1Var.d4().d0().getValue()).intValue() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            aVar.b1(requireContext, z4);
            FragmentActivity activity = r1Var.getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog j22 = ((C1826a) activity).j2();
            if (j22 != null) {
                j22.dismiss();
            }
            r1Var.x6();
        }
    }

    /* access modifiers changed from: private */
    public static final void r4(C1941r1 r1Var, Context context, View view) {
        r1Var.d4().a0().setValue(2);
        r1Var.B3(context);
    }

    /* access modifiers changed from: private */
    public final void r5(C2050h hVar) {
        if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).C2(hVar.e());
        } else if (getActivity() != null && (getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity2 = getActivity();
            m.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity");
            ((AppDetailActivity) activity2).C2(hVar.e());
        }
    }

    /* access modifiers changed from: private */
    public final void r6(String str) {
        i7();
        d4().R().setValue(-1);
        Z3().f10280O.f10420e.setVisibility(0);
        Z3().f10280O.f10418c.setVisibility(8);
        Z3().f10277L.f10585h.setText(str);
        TextView textView = Z3().f10277L.f10585h;
        m.d(textView, "tvDownloadCancelBad");
        v.c(textView);
        Z3().f10277L.f10585h.setOnClickListener((View.OnClickListener) null);
        Z3().f10273H.f9686n.setText(str);
        TextView textView2 = Z3().f10273H.f9686n;
        m.d(textView2, "tvStatusDownload");
        v.c(textView2);
        Z3().f10273H.f9686n.setOnClickListener((View.OnClickListener) null);
    }

    /* access modifiers changed from: private */
    public final void s3(String str) {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            FragmentActivity activity = getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog j22 = ((C1826a) activity).j2();
            if (j22 != null) {
                j22.dismiss();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            C1683p c5 = C1683p.c(getLayoutInflater());
            m.d(c5, "inflate(...)");
            TextView textView = c5.f10696d;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.x());
            c5.f10696d.setText(str);
            c5.f10695c.setVisibility(8);
            c5.f10697e.setTypeface(aVar.x());
            c5.f10697e.setOnClickListener(new C1981w0(this));
            builder.setView(c5.getRoot());
            builder.setCancelable(false);
            V6(builder);
        }
    }

    /* access modifiers changed from: private */
    public static final void s4(C1941r1 r1Var, Context context, View view) {
        r1Var.d4().a0().setValue(3);
        r1Var.B3(context);
    }

    private final void s5() {
        if (!requireActivity().isFinishing()) {
            Intent intent = new Intent(requireActivity(), ReviewsActivity.class);
            intent.putExtra("appInfo", Y3());
            intent.putExtra("myReview", (Parcelable) d4().T().getValue());
            UptodownApp.a aVar = UptodownApp.f17422D;
            FragmentActivity requireActivity = requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            startActivity(intent, aVar.a(requireActivity));
        }
    }

    /* access modifiers changed from: private */
    public final void s6(C2060s sVar) {
        j7();
        d4().R().setValue(-1);
        Z3().f10280O.f10423h.setIndeterminate(true);
        Z3().f10280O.f10420e.setVisibility(8);
        Z3().f10280O.f10418c.setVisibility(0);
        Z3().f10280O.f10435t.setText(getString(com.uptodown.R.string.status_download_update_pending));
        Z3().f10273H.f9677e.setIndeterminate(true);
        TextView textView = Z3().f10273H.f9684l;
        i iVar = new i();
        long y4 = sVar.y();
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        textView.setText(iVar.d(y4, requireContext));
        TextView textView2 = Z3().f10273H.f9683k;
        textView2.setText(sVar.x() + getString(com.uptodown.R.string.percent));
        TextView textView3 = Z3().f10273H.f9685m;
        kotlin.jvm.internal.F f4 = kotlin.jvm.internal.F.f20971a;
        i iVar2 = new i();
        long z4 = sVar.z();
        Context requireContext2 = requireContext();
        m.d(requireContext2, "requireContext(...)");
        String format = String.format("/%s", Arrays.copyOf(new Object[]{iVar2.d(z4, requireContext2)}, 1));
        m.d(format, "format(...)");
        textView3.setText(format);
    }

    private final void s7(int i4, Context context) {
        String str;
        g2.U e5 = g2.U.f20468m.e(context);
        if (e5 != null) {
            str = e5.g();
        } else {
            str = null;
        }
        if (str != null) {
            String g4 = e5.g();
            m.b(g4);
            if (g4.length() > 0) {
                d4().a0().setValue(Integer.valueOf(i4));
                if (i4 == 1) {
                    Z3().f10261B.f10234b.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    Z3().f10261B.f10235c.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    Z3().f10261B.f10236d.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    Z3().f10261B.f10237e.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    Z3().f10261B.f10238f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                } else if (i4 == 2) {
                    Z3().f10261B.f10234b.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    Z3().f10261B.f10235c.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    Z3().f10261B.f10236d.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    Z3().f10261B.f10237e.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    Z3().f10261B.f10238f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                } else if (i4 == 3) {
                    Z3().f10261B.f10234b.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    Z3().f10261B.f10235c.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    Z3().f10261B.f10236d.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    Z3().f10261B.f10237e.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    Z3().f10261B.f10238f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                } else if (i4 == 4) {
                    Z3().f10261B.f10234b.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    Z3().f10261B.f10235c.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    Z3().f10261B.f10236d.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    Z3().f10261B.f10237e.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    Z3().f10261B.f10238f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                } else if (i4 != 5) {
                    Z3().f10261B.f10234b.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    Z3().f10261B.f10235c.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    Z3().f10261B.f10236d.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    Z3().f10261B.f10237e.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    Z3().f10261B.f10238f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                } else {
                    Z3().f10261B.f10234b.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    Z3().f10261B.f10235c.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    Z3().f10261B.f10236d.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    Z3().f10261B.f10237e.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    Z3().f10261B.f10238f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void t3(C1941r1 r1Var, View view) {
        if (r1Var.getActivity() != null && !r1Var.requireActivity().isFinishing()) {
            FragmentActivity activity = r1Var.getActivity();
            m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog j22 = ((C1826a) activity).j2();
            if (j22 != null) {
                j22.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final boolean t4(C1941r1 r1Var, MenuItem menuItem) {
        FragmentActivity activity;
        m.e(menuItem, "item");
        if (!UptodownApp.f17422D.a0()) {
            return true;
        }
        if (menuItem.getItemId() == com.uptodown.R.id.action_search) {
            r1Var.t5();
            return true;
        } else if (menuItem.getItemId() == com.uptodown.R.id.action_share) {
            r1Var.R6();
            return true;
        } else if (menuItem.getItemId() == com.uptodown.R.id.action_antivirus_report) {
            r1Var.v5();
            return true;
        } else if (menuItem.getItemId() == com.uptodown.R.id.action_uninstall) {
            String Q4 = r1Var.Y3().Q();
            if (Q4 == null || Q4.length() == 0 || (activity = r1Var.getActivity()) == null) {
                return true;
            }
            j jVar = new j(activity);
            String Q5 = r1Var.Y3().Q();
            m.b(Q5);
            jVar.h(Q5);
            return true;
        } else if (menuItem.getItemId() == com.uptodown.R.id.action_wishlist) {
            r1Var.C2();
            return true;
        } else if (menuItem.getItemId() == com.uptodown.R.id.action_recommended) {
            r1Var.B2();
            return true;
        } else if (menuItem.getItemId() == com.uptodown.R.id.action_exclude) {
            r1Var.A2();
            return true;
        } else if (menuItem.getItemId() == com.uptodown.R.id.action_app_details_settings) {
            r1Var.d5();
            return true;
        } else if (menuItem.getItemId() != com.uptodown.R.id.action_remote_install) {
            return false;
        } else {
            if (!(r1Var.d4().l0().getValue() instanceof E.c)) {
                return true;
            }
            Object value = r1Var.d4().l0().getValue();
            m.c(value, "null cannot be cast to non-null type com.uptodown.util.Result.Success<java.util.ArrayList<com.uptodown.models.UserRemoteDevice>>");
            r1Var.b7((ArrayList) ((E.c) value).a());
            return true;
        }
    }

    private final void t5() {
        Intent intent = new Intent(getContext(), SearchActivity.class);
        intent.setFlags(603979776);
        UptodownApp.a aVar = UptodownApp.f17422D;
        FragmentActivity requireActivity = requireActivity();
        m.d(requireActivity, "requireActivity(...)");
        startActivity(intent, aVar.a(requireActivity));
    }

    /* access modifiers changed from: private */
    public final void t6(Context context) {
        String str;
        i7();
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = Z3().f10280O.f10423h;
        m.d(progressBar, "pbProgressAppDetail");
        ImageView imageView = Z3().f10280O.f10417b;
        m.d(imageView, "ivLogoAppDetail");
        cVar.c(progressBar, imageView);
        d4().R().setValue(-1);
        if (new P1.a(context).m()) {
            str = context.getString(com.uptodown.R.string.option_button_install);
        } else {
            String T4 = Y3().T();
            if (T4 == null || T4.length() == 0) {
                str = context.getString(com.uptodown.R.string.option_button_install);
            } else {
                String s02 = Y3().s0("try");
                if (s02 == null || s02.length() == 0) {
                    str = context.getString(com.uptodown.R.string.option_button_install);
                } else {
                    str = s02;
                }
            }
        }
        if (!((Boolean) d4().f0().getValue()).booleanValue() || !Y3().E0()) {
            Z3().f10277L.f10579b.setVisibility(8);
        } else {
            Z3().f10277L.f10579b.setVisibility(0);
        }
        Z3().f10277L.f10586i.setVisibility(8);
        Z3().f10280O.f10420e.setVisibility(0);
        Z3().f10280O.f10418c.setVisibility(8);
        TextView textView = Z3().f10277L.f10585h;
        m.d(textView, "tvDownloadCancelBad");
        l6(textView, str);
        Z3().f10277L.f10585h.setOnClickListener(new C1978v0(this));
        Z3().f10273H.f9674b.setVisibility(4);
        TextView textView2 = Z3().f10273H.f9686n;
        m.d(textView2, "tvStatusDownload");
        l6(textView2, str);
        if (d4().S().getValue() == null) {
            f4(com.uptodown.R.id.action_uninstall);
            f4(com.uptodown.R.id.action_app_installed_details);
        }
    }

    /* access modifiers changed from: private */
    public static final void t7(C1941r1 r1Var, ActivityResult activityResult) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(r1Var), o3.Y.b(), (o3.L) null, new Z(r1Var, new a0(r1Var), (d) null), 2, (Object) null);
    }

    private final void u3() {
        w wVar = new w();
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        File f4 = wVar.f(requireContext);
        w wVar2 = new w();
        Context requireContext2 = requireContext();
        m.d(requireContext2, "requireContext(...)");
        long k4 = wVar2.k(requireContext2, f4);
        long totalSpace = f4.getTotalSpace();
        Context requireContext3 = requireContext();
        m.d(requireContext3, "requireContext(...)");
        String d5 = new i().d((long) (((double) c4()) * 2.25d), requireContext3);
        long j4 = ((totalSpace - k4) * ((long) 100)) / totalSpace;
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        f1 c5 = f1.c(getLayoutInflater());
        m.d(c5, "inflate(...)");
        TextView textView = c5.f10413e;
        k.a aVar = N1.k.f7778g;
        textView.setTypeface(aVar.x());
        c5.f10410b.setProgress((int) j4);
        c5.f10414f.setTypeface(aVar.x());
        c5.f10414f.setText(getString(com.uptodown.R.string.no_storage_text, d5));
        c5.f10412d.setTypeface(aVar.w());
        c5.f10412d.setOnClickListener(new K0(this));
        builder.setView(c5.getRoot());
        V6(builder);
    }

    /* access modifiers changed from: private */
    public static final void u4(C1941r1 r1Var, Context context, View view) {
        r1Var.d4().a0().setValue(4);
        r1Var.B3(context);
    }

    private final void u5(g2.N n4) {
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        o oVar = new o(requireContext, LifecycleOwnerKt.getLifecycleScope(this));
        String l4 = n4.l();
        m.b(l4);
        oVar.b(l4, new C(this));
    }

    /* access modifiers changed from: private */
    public static final void u6(C1941r1 r1Var, View view) {
        Context requireContext = r1Var.requireContext();
        m.d(requireContext, "requireContext(...)");
        r1Var.N3(requireContext);
    }

    private final void u7() {
        try {
            if (Y3().W() <= 0 || ((Number) d4().n0().getValue()).intValue() <= 0) {
                Z3().f10340y.getRoot().setVisibility(8);
                Z3().f10340y.f10609q.setVisibility(8);
                return;
            }
            int dimension = (int) getResources().getDimension(com.uptodown.R.dimen.margin_m);
            Z3().f10340y.f10600h.setLayoutParams(new RelativeLayout.LayoutParams((((Number) d4().n0().getValue()).intValue() * Y3().b0()) / Y3().W(), dimension));
            Z3().f10340y.f10599g.setLayoutParams(new RelativeLayout.LayoutParams((((Number) d4().n0().getValue()).intValue() * Y3().a0()) / Y3().W(), dimension));
            Z3().f10340y.f10598f.setLayoutParams(new RelativeLayout.LayoutParams((((Number) d4().n0().getValue()).intValue() * Y3().Z()) / Y3().W(), dimension));
            Z3().f10340y.f10597e.setLayoutParams(new RelativeLayout.LayoutParams((((Number) d4().n0().getValue()).intValue() * Y3().Y()) / Y3().W(), dimension));
            Z3().f10340y.f10596d.setLayoutParams(new RelativeLayout.LayoutParams((((Number) d4().n0().getValue()).intValue() * Y3().X()) / Y3().W(), dimension));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static final void v3(C1941r1 r1Var, View view) {
        Intent intent = new Intent(r1Var.requireActivity(), FreeUpSpaceActivity.class);
        intent.putExtra("appInfo", r1Var.Y3());
        UptodownApp.a aVar = UptodownApp.f17422D;
        FragmentActivity requireActivity = r1Var.requireActivity();
        m.d(requireActivity, "requireActivity(...)");
        r1Var.startActivity(intent, aVar.a(requireActivity));
    }

    /* access modifiers changed from: private */
    public static final void v4(C1941r1 r1Var, Context context, View view) {
        r1Var.d4().a0().setValue(5);
        r1Var.B3(context);
    }

    private final void v5() {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            d4().m0().setValue(Boolean.TRUE);
            FragmentActivity requireActivity = requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            new b2.p(requireActivity, String.valueOf(Y3().z()), Y3().i0(), new D(this), LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    /* access modifiers changed from: private */
    public final void v6(C2060s sVar) {
        j7();
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = Z3().f10280O.f10423h;
        m.d(progressBar, "pbProgressAppDetail");
        ImageView imageView = Z3().f10280O.f10417b;
        m.d(imageView, "ivLogoAppDetail");
        cVar.e(progressBar, imageView);
        TextView textView = Z3().f10277L.f10585h;
        m.d(textView, "tvDownloadCancelBad");
        String string = getString(com.uptodown.R.string.option_button_cancel);
        m.d(string, "getString(...)");
        m6(textView, string);
        Z3().f10277L.f10586i.setVisibility(8);
        Z3().f10273H.f9675c.setVisibility(8);
        d4().R().setValue(5);
        if (sVar == null && getContext() != null) {
            t.a aVar = u2.t.f21927u;
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            u2.t a5 = aVar.a(requireContext);
            a5.a();
            C2060s f02 = a5.f0(String.valueOf(Y3().z()));
            a5.i();
            sVar = f02;
        }
        if (sVar != null) {
            Z3().f10277L.f10585h.setOnClickListener(new C1984x0(this));
            Z3().f10273H.f9674b.setVisibility(0);
            if (!P4(this, (g2.S) null, 1, (Object) null)) {
                Z3().f10280O.f10435t.setText(getString(com.uptodown.R.string.status_download_update_pending));
                Z3().f10280O.f10423h.setIndeterminate(true);
                Z3().f10273H.f9677e.setIndeterminate(true);
                Z3().f10273H.f9681i.setVisibility(0);
                Z3().f10273H.f9683k.setVisibility(8);
            } else {
                TextView textView2 = Z3().f10277L.f10587j;
                m.d(textView2, "tvPauseBad");
                String string2 = getString(com.uptodown.R.string.action_pause);
                m.d(string2, "getString(...)");
                m6(textView2, string2);
                String valueOf = String.valueOf(sVar.x());
                if (isAdded() && getContext() != null) {
                    valueOf = valueOf + requireContext().getString(com.uptodown.R.string.percent);
                }
                Z3().f10280O.f10423h.setIndeterminate(false);
                Z3().f10280O.f10423h.setProgress(sVar.x());
                if (((C2060s.c) sVar.o().get(0)).i() > 0) {
                    TextView textView3 = Z3().f10280O.f10435t;
                    Integer valueOf2 = Integer.valueOf(sVar.x());
                    i iVar = new i();
                    long z4 = sVar.z();
                    Context requireContext2 = requireContext();
                    m.d(requireContext2, "requireContext(...)");
                    textView3.setText(getString(com.uptodown.R.string.percent_of_total_size, valueOf2, iVar.d(z4, requireContext2)));
                }
                Z3().f10273H.f9677e.setIndeterminate(false);
                Z3().f10273H.f9683k.setVisibility(0);
                Z3().f10273H.f9681i.setVisibility(8);
                Z3().f10273H.f9683k.setText(valueOf);
                TextView textView4 = Z3().f10273H.f9684l;
                i iVar2 = new i();
                long y4 = sVar.y();
                Context requireContext3 = requireContext();
                m.d(requireContext3, "requireContext(...)");
                textView4.setText(iVar2.d(y4, requireContext3));
                Z3().f10273H.f9677e.setProgress(sVar.x());
            }
            TextView textView5 = Z3().f10273H.f9685m;
            kotlin.jvm.internal.F f4 = kotlin.jvm.internal.F.f20971a;
            i iVar3 = new i();
            long z5 = sVar.z();
            Context requireContext4 = requireContext();
            m.d(requireContext4, "requireContext(...)");
            String format = String.format("/%s", Arrays.copyOf(new Object[]{iVar3.d(z5, requireContext4)}, 1));
            m.d(format, "format(...)");
            textView5.setText(format);
            return;
        }
        Z3().f10280O.f10423h.setIndeterminate(true);
        Z3().f10273H.f9677e.setIndeterminate(true);
    }

    private final void v7() {
        W1.E e5 = new W1.E();
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        ArrayList c5 = e5.c(requireContext);
        this.f19982f = c5;
        m.b(c5);
        if (c5.size() > 0) {
            d4().d0().setValue(0);
            p3();
            return;
        }
        a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
        Context requireContext2 = requireContext();
        m.d(requireContext2, "requireContext(...)");
        aVar.b1(requireContext2, false);
        x6();
    }

    /* access modifiers changed from: private */
    public final void w3() {
        FragmentActivity activity = getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog j22 = ((C1826a) activity).j2();
        if (j22 != null) {
            j22.dismiss();
        }
        if (getContext() != null) {
            C1677m c5 = C1677m.c(getLayoutInflater());
            m.d(c5, "inflate(...)");
            TextView textView = c5.f10653d;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.w());
            c5.f10652c.setTypeface(aVar.x());
            TextView textView2 = c5.f10652c;
            q qVar = new q();
            String string = getString(com.uptodown.R.string.pre_register_success, Y3().L());
            m.d(string, "getString(...)");
            String L4 = Y3().L();
            m.b(L4);
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            textView2.setText(qVar.d(string, L4, requireContext));
            c5.f10651b.setTypeface(aVar.w());
            c5.f10651b.setOnClickListener(new C1975u0(this));
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setView(c5.getRoot());
            builder.setCancelable(true);
            V6(builder);
        }
    }

    /* access modifiers changed from: private */
    public static final void w4(C1941r1 r1Var, View view) {
        r1Var.s5();
    }

    /* access modifiers changed from: private */
    public final void w5(C2046d dVar) {
        if (dVar != null) {
            Z3().f10265D.getRoot().setVisibility(0);
            float dimension = getResources().getDimension(com.uptodown.R.dimen.border_radius_m);
            int parseColor = Color.parseColor(dVar.f());
            int parseColor2 = Color.parseColor(dVar.g());
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{parseColor, parseColor2});
            gradientDrawable.setCornerRadius(dimension);
            Z3().f10265D.f10246d.setBackground(gradientDrawable);
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{dimension, dimension, dimension, dimension, dimension, dimension, dimension, dimension}, (RectF) null, (float[]) null));
            shapeDrawable.getPaint().setColor(parseColor2);
            Z3().f10265D.f10247e.setBackground(shapeDrawable);
            com.squareup.picasso.s.h().l(Y3().F()).i(Z3().f10265D.f10244b);
            TextView textView = Z3().f10265D.f10249g;
            k.a aVar = N1.k.f7778g;
            textView.setTypeface(aVar.w());
            Z3().f10265D.f10249g.setTextColor(parseColor);
            Z3().f10265D.f10249g.setText(dVar.i());
            Z3().f10265D.f10248f.setTypeface(aVar.x());
            Z3().f10265D.f10248f.setText(dVar.e());
            Z3().f10265D.f10247e.setTypeface(aVar.w());
            Z3().f10265D.f10247e.setText(dVar.d());
            Z3().f10265D.getRoot().setOnClickListener(new C1986y(this, dVar));
            ImageView imageView = Z3().f10265D.f10244b;
            new Handler(Looper.getMainLooper()).postDelayed(new C1991z(this, dVar), 500);
        }
    }

    /* access modifiers changed from: private */
    public static final void w6(C1941r1 r1Var, View view) {
        r1Var.i3();
    }

    private final void w7() {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (o3.L) null, new b0(this, (d) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void x3(C1941r1 r1Var, View view) {
        FragmentActivity activity = r1Var.getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog j22 = ((C1826a) activity).j2();
        if (j22 != null) {
            j22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void x4(C1941r1 r1Var, View view) {
        r1Var.h5();
    }

    /* access modifiers changed from: private */
    public static final void x5(C1941r1 r1Var, C2046d dVar, View view) {
        String c5;
        if (r1Var.getContext() != null && (c5 = dVar.c()) != null && c5.length() != 0) {
            Context requireContext = r1Var.requireContext();
            m.d(requireContext, "requireContext(...)");
            dVar.a(requireContext, Long.valueOf(r1Var.Y3().e()));
            if (r1Var.getActivity() != null) {
                String c6 = dVar.c();
                m.b(c6);
                q qVar = new q();
                FragmentActivity requireActivity = r1Var.requireActivity();
                m.d(requireActivity, "requireActivity(...)");
                q.r(qVar, requireActivity, c6, (String) null, 4, (Object) null);
            }
        }
    }

    private final void x6() {
        v6((C2060s) null);
        d4().R().setValue(5);
        long c42 = c4();
        w wVar = new w();
        Context requireContext = requireContext();
        m.d(requireContext, "requireContext(...)");
        File f4 = wVar.f(requireContext);
        if (!f4.exists() && !f4.mkdirs()) {
            String string = getString(com.uptodown.R.string.error_cant_create_dir);
            m.d(string, "getString(...)");
            s3(string);
        } else if (!e4()) {
            Context requireContext2 = requireContext();
            m.d(requireContext2, "requireContext(...)");
            B6(requireContext2, (C2060s) null);
            u3();
        } else {
            q qVar = new q();
            Z3().f10280O.f10435t.setVisibility(0);
            Z3().f10280O.f10435t.setText(getString(com.uptodown.R.string.status_download_update_pending));
            Z3().f10280O.f10423h.setProgress(0);
            Z3().f10273H.f9681i.setVisibility(0);
            Z3().f10273H.f9683k.setVisibility(8);
            Z3().f10273H.f9684l.setText(com.uptodown.R.string.zero_mb);
            TextView textView = Z3().f10273H.f9685m;
            kotlin.jvm.internal.F f5 = kotlin.jvm.internal.F.f20971a;
            i iVar = new i();
            Context requireContext3 = requireContext();
            m.d(requireContext3, "requireContext(...)");
            String format = String.format("/%s", Arrays.copyOf(new Object[]{iVar.d(c42, requireContext3), requireContext()}, 2));
            m.d(format, "format(...)");
            textView.setText(format);
            Z3().f10273H.f9677e.setProgress(0);
            AlertDialog alertDialog = this.f19981e;
            FragmentActivity requireActivity = requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            AlertDialog e5 = qVar.e(alertDialog, requireActivity);
            this.f19981e = e5;
            if (e5 == null) {
                e6();
                v6((C2060s) null);
            }
        }
    }

    private final void y3(d3.a aVar) {
        FragmentActivity activity = getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog j22 = ((C1826a) activity).j2();
        if (j22 != null) {
            j22.dismiss();
        }
        if (getContext() != null) {
            C1683p c5 = C1683p.c(getLayoutInflater());
            m.d(c5, "inflate(...)");
            TextView textView = c5.f10696d;
            k.a aVar2 = N1.k.f7778g;
            textView.setTypeface(aVar2.x());
            c5.f10696d.setText(getString(com.uptodown.R.string.resume_downloads_queue_dialog, Y3().L()));
            c5.f10697e.setTypeface(aVar2.w());
            c5.f10697e.setText(getString(com.uptodown.R.string.updates_button_resume));
            c5.f10697e.setOnClickListener(new r(aVar, this));
            c5.f10695c.setTypeface(aVar2.w());
            TextView textView2 = c5.f10695c;
            m.d(textView2, "tvCancel");
            v.b(textView2);
            c5.f10695c.setOnClickListener(new C1968s(this));
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setView(c5.getRoot());
            builder.setCancelable(false);
            V6(builder);
        }
    }

    /* access modifiers changed from: private */
    public static final void y4(C1941r1 r1Var, View view) {
        if (UptodownApp.f17422D.a0() && r1Var.d4().S().getValue() != null) {
            Context requireContext = r1Var.requireContext();
            m.d(requireContext, "requireContext(...)");
            j jVar = new j(requireContext);
            Object value = r1Var.d4().S().getValue();
            m.b(value);
            String o4 = ((C2048f) value).o();
            m.b(o4);
            jVar.h(o4);
        }
    }

    /* access modifiers changed from: private */
    public static final void y5(C1941r1 r1Var, C2046d dVar) {
        if (new q().p(r1Var.Z3().f10265D.getRoot())) {
            Context requireContext = r1Var.requireContext();
            m.d(requireContext, "requireContext(...)");
            dVar.b(requireContext, Long.valueOf(r1Var.Y3().e()));
        }
    }

    /* access modifiers changed from: private */
    public final void y6(String str) {
        g4();
        Z3().f10280O.f10435t.setText(str);
        Z3().f10273H.f9684l.setText(str);
    }

    /* access modifiers changed from: private */
    public static final void z3(d3.a aVar, C1941r1 r1Var, View view) {
        aVar.invoke();
        FragmentActivity activity = r1Var.getActivity();
        m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog j22 = ((C1826a) activity).j2();
        if (j22 != null) {
            j22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void z4(C1941r1 r1Var, View view) {
        if (UptodownApp.f17422D.a0()) {
            r1Var.K3();
        }
    }

    private final void z5(Context context) {
        String U4;
        String v4;
        if (new u2.m().s(Y3().Q(), context)) {
            Drawable k4 = u2.F.f21886a.k(context, Y3().Q());
            Z3().f10280O.f10417b.setImageDrawable(k4);
            Z3().f10261B.f10239g.setImageDrawable(k4);
        } else {
            String C4 = Y3().C();
            if (C4 == null || C4.length() == 0) {
                Z3().f10280O.f10417b.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_app_icon_placeholder));
                Z3().f10261B.f10239g.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_app_icon_placeholder));
            } else {
                com.squareup.picasso.w l4 = com.squareup.picasso.s.h().l(Y3().E()).l(com.uptodown.R.drawable.shape_bg_placeholder);
                UptodownApp.a aVar = UptodownApp.f17422D;
                l4.n(aVar.i0(context)).j(Z3().f10280O.f10417b, new E(this, context));
                com.squareup.picasso.s.h().l(Y3().F()).l(com.uptodown.R.drawable.shape_bg_placeholder).n(aVar.i0(context)).i(Z3().f10261B.f10239g);
            }
        }
        String C5 = Y3().C();
        if ((C5 == null || C5.length() == 0) && ((v4 = Y3().v()) == null || v4.length() == 0)) {
            m7(context);
        }
        String L4 = Y3().L();
        if (!(L4 == null || L4.length() == 0)) {
            Z3().f10280O.f10433r.setText(Y3().L());
            Z3().f10343z0.setText(context.getString(com.uptodown.R.string.similar_to_x, new Object[]{Y3().L()}));
        }
        String w02 = Y3().w0();
        if (!(w02 == null || w02.length() == 0)) {
            Z3().f10280O.f10439x.setText(Y3().w0());
            Z3().f10280O.f10439x.setVisibility(0);
        }
        String T4 = Y3().T();
        if (!(T4 == null || T4.length() == 0)) {
            Z3().f10280O.f10434s.setText(Y3().T());
            Z3().f10280O.f10434s.setVisibility(0);
        }
        String g4 = Y3().g();
        if (!(g4 == null || g4.length() == 0)) {
            Z3().f10280O.f10427l.setText(Y3().g());
        }
        if (Y3().k() == 1) {
            Z3().f10280O.f10428m.setVisibility(0);
        }
        String j02 = Y3().j0();
        if (j02 == null || j02.length() == 0) {
            Z3().f10341y0.setVisibility(8);
        } else {
            Z3().f10341y0.setVisibility(0);
            k.a aVar2 = w2.k.f22035a;
            TextView textView = Z3().f10341y0;
            m.d(textView, "tvShortDescAppDetail");
            aVar2.a(textView);
            TextView textView2 = Z3().f10341y0;
            C2059q.a aVar3 = C2059q.f20700f;
            String j03 = Y3().j0();
            m.b(j03);
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            textView2.setText(aVar3.m(j03, requireContext, this.f19987k));
        }
        String j4 = Y3().j();
        if (j4 == null || j4.length() == 0) {
            Z3().f10275J.setVisibility(8);
        } else {
            k.a aVar4 = w2.k.f22035a;
            TextView textView3 = Z3().f10301e0;
            m.d(textView3, "tvDescAppDetail");
            aVar4.a(textView3);
            if (getResources().getConfiguration().getLayoutDirection() == 1) {
                Z3().f10301e0.setTextDirection(2);
            }
            TextView textView4 = Z3().f10301e0;
            C2059q.a aVar5 = C2059q.f20700f;
            String j5 = Y3().j();
            m.b(j5);
            Context requireContext2 = requireContext();
            m.d(requireContext2, "requireContext(...)");
            textView4.setText(aVar5.m(j5, requireContext2, this.f19987k));
            Z3().f10275J.setVisibility(0);
            String m4 = Y3().m();
            if (m4 == null || m4.length() == 0) {
                String s4 = Y3().s();
                if (!(s4 == null || s4.length() == 0)) {
                    TextView textView5 = Z3().f10307h0;
                    String s5 = Y3().s();
                    m.b(s5);
                    Context requireContext3 = requireContext();
                    m.d(requireContext3, "requireContext(...)");
                    textView5.setText(aVar5.m(s5, requireContext3, this.f19987k));
                    String r4 = Y3().r();
                    if (r4 == null || r4.length() == 0) {
                        Z3().f10305g0.setVisibility(8);
                    } else {
                        Z3().f10305g0.setText(Y3().r());
                    }
                    String q4 = Y3().q();
                    if (q4 == null || q4.length() == 0) {
                        Z3().f10308i.setVisibility(8);
                    } else {
                        com.squareup.picasso.w l5 = com.squareup.picasso.s.h().l(Y3().q()).l(com.uptodown.R.drawable.shape_bg_placeholder);
                        UptodownApp.a aVar6 = UptodownApp.f17422D;
                        Context requireContext4 = requireContext();
                        m.d(requireContext4, "requireContext(...)");
                        l5.n(aVar6.i0(requireContext4)).i(Z3().f10308i);
                    }
                    if (Y3().k0() == 1) {
                        Z3().f10309i0.setVisibility(0);
                    } else {
                        Z3().f10309i0.setVisibility(8);
                    }
                }
            } else {
                Z3().f10307h0.setText(Y3().m());
                Z3().f10309i0.setVisibility(8);
                Z3().f10308i.setVisibility(8);
            }
        }
        String t02 = Y3().t0();
        if (t02 == null || t02.length() == 0) {
            f4(com.uptodown.R.id.action_share);
        } else {
            a7(com.uptodown.R.id.action_share);
        }
        String l02 = Y3().l0();
        if (l02 == null || l02.length() == 0) {
            f4(com.uptodown.R.id.action_antivirus_report);
            Z3().f10277L.f10581d.setVisibility(8);
        } else {
            a7(com.uptodown.R.id.action_antivirus_report);
            Z3().f10277L.f10581d.setVisibility(0);
        }
        String g02 = Y3().g0();
        if (g02 == null || g02.length() == 0) {
            Z3().f10282Q.setVisibility(8);
        } else {
            Z3().f10282Q.setVisibility(0);
            Z3().f10337w0.setText(Y3().g0());
        }
        if (Y3().V() == 0) {
            Z3().f10280O.f10426k.setVisibility(8);
            Z3().f10280O.f10440y.setVisibility(8);
        } else {
            Z3().f10280O.f10437v.setVisibility(0);
            Z3().f10280O.f10437v.setText(String.valueOf(((double) Y3().V()) / 10.0d));
            if (Y3().W() == 1) {
                Z3().f10280O.f10436u.setText(getString(com.uptodown.R.string.reviews_counter_single));
            } else {
                TextView textView6 = Z3().f10280O.f10436u;
                kotlin.jvm.internal.F f4 = kotlin.jvm.internal.F.f20971a;
                String string = getString(com.uptodown.R.string.reviews_counter_multiple);
                m.d(string, "getString(...)");
                String format = String.format(string, Arrays.copyOf(new Object[]{new i().b((long) Y3().W())}, 1));
                m.d(format, "format(...)");
                textView6.setText(format);
            }
        }
        if (!Y3().H0() || (U4 = Y3().U()) == null || U4.length() == 0) {
            Z3().f10280O.f10429n.setText(new i().b((long) Y3().p()));
            Z3().f10280O.f10430o.setText(getString(com.uptodown.R.string.more_info_downloads_label));
            String Q4 = Y3().Q();
            if (Q4 == null || Q4.length() == 0) {
                Z3().f10334v.setVisibility(8);
            } else {
                Z3().f10319n0.setText(Y3().Q());
            }
            ArrayList m02 = Y3().m0();
            if (m02 == null || m02.isEmpty()) {
                Z3().f10332u.setVisibility(8);
            } else {
                TextView textView7 = Z3().f10315l0;
                ArrayList m03 = Y3().m0();
                m.b(m03);
                textView7.setText((CharSequence) C1601o.H(m03));
            }
            String R4 = Y3().R();
            if (R4 == null || R4.length() == 0) {
                Z3().f10336w.setVisibility(8);
            } else {
                Z3().f10323p0.setText(getString(com.uptodown.R.string.pegi_plus, Y3().R()));
            }
        } else {
            Z3().f10280O.f10429n.setText(Y3().U());
            Z3().f10274I.setVisibility(8);
        }
        String G4 = Y3().G();
        if (G4 == null || G4.length() == 0 || Y3().H0()) {
            Z3().f10280O.f10421f.setVisibility(8);
        } else {
            Z3().f10280O.f10431p.setText(Y3().G());
        }
        Z3().f10340y.f10607o.setText(String.valueOf(((double) Y3().V()) / 10.0d));
        if (Y3().W() == 1) {
            Z3().f10340y.f10608p.setText(getString(com.uptodown.R.string.comment_counter_single));
        } else {
            TextView textView8 = Z3().f10340y.f10608p;
            kotlin.jvm.internal.F f5 = kotlin.jvm.internal.F.f20971a;
            String string2 = getString(com.uptodown.R.string.reviews_counter_multiple);
            m.d(string2, "getString(...)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{new i().b((long) Y3().W())}, 1));
            m.d(format2, "format(...)");
            textView8.setText(format2);
        }
        Z3().f10340y.f10608p.setOnClickListener(new C1892c0(this));
        String M4 = Y3().M();
        if (M4 == null || M4.length() == 0) {
            Z3().f10285T.getRoot().setVisibility(8);
        } else {
            Z3().f10285T.f10446d.setText(Y3().M());
            Z3().f10285T.f10446d.getViewTreeObserver().addOnGlobalLayoutListener(new C1929n0(this));
            Z3().f10285T.getRoot().setVisibility(0);
        }
        String q02 = Y3().q0();
        if (q02 == null || q02.length() == 0) {
            String x02 = Y3().x0();
            if (!(x02 == null || x02.length() == 0)) {
                Z3().f10262B0.setText(Y3().x0());
            }
        } else {
            Z3().f10262B0.setText(Y3().q0());
        }
        C2033A b5 = C2033A.f20327f.b(context);
        if (b5 != null && b5.b() == Y3().e() && !b5.g()) {
            b5.p(context);
        }
        if (m.a(Y3().Q(), requireContext().getPackageName()) || m.a(Y3().Q(), "com.uptodown.installer")) {
            Z3().f10303f0.setVisibility(8);
        }
        ArrayList u02 = Y3().u0();
        if (u02 != null && !u02.isEmpty() && Z3().f10259A.getVisibility() == 8) {
            Z3().f10259A.setVisibility(0);
            Z3().f10260A0.setTypeface(N1.k.f7778g.w());
            ArrayList u03 = Y3().u0();
            m.b(u03);
            Iterator it = u03.iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                String str = (String) next;
                if (str.length() > 0) {
                    I0 c5 = I0.c(getLayoutInflater());
                    m.d(c5, "inflate(...)");
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.setMargins(0, (int) getResources().getDimension(com.uptodown.R.dimen.margin_m), 0, 0);
                    c5.getRoot().setLayoutParams(layoutParams);
                    c5.f9788c.setTypeface(N1.k.f7778g.x());
                    c5.f9788c.setText(str);
                    Z3().f10259A.addView(c5.getRoot());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void z6() {
        i7();
        C2345c cVar = C2345c.f22021a;
        ProgressBar progressBar = Z3().f10280O.f10423h;
        m.d(progressBar, "pbProgressAppDetail");
        ImageView imageView = Z3().f10280O.f10417b;
        m.d(imageView, "ivLogoAppDetail");
        cVar.c(progressBar, imageView);
        Z3().f10280O.f10420e.setVisibility(0);
        Z3().f10280O.f10418c.setVisibility(8);
        Z3().f10277L.f10579b.setVisibility(8);
        Z3().f10277L.f10585h.setOnClickListener(new J0(this));
        d4().R().setValue(3);
        TextView textView = Z3().f10277L.f10585h;
        m.d(textView, "tvDownloadCancelBad");
        String string = getString(com.uptodown.R.string.option_button_install);
        m.d(string, "getString(...)");
        l6(textView, string);
        TextView textView2 = Z3().f10273H.f9686n;
        m.d(textView2, "tvStatusDownload");
        String string2 = getString(com.uptodown.R.string.option_button_install);
        m.d(string2, "getString(...)");
        l6(textView2, string2);
        f4(com.uptodown.R.id.action_app_installed_details);
        f4(com.uptodown.R.id.action_uninstall);
    }

    public final void X2(Context context) {
        m.e(context, "context");
        h7(context);
    }

    public final C2050h Y3() {
        C2050h hVar = this.f19977a;
        if (hVar != null) {
            return hVar;
        }
        m.u("appInfo");
        return null;
    }

    public final void g6() {
        a4();
    }

    public final void k6(C2050h hVar) {
        m.e(hVar, "<set-?>");
        this.f19977a = hVar;
    }

    public final void o7(String str) {
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (o3.L) null, new X(str, this, (d) null), 2, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r4) {
        /*
            r3 = this;
            super.onCreate(r4)
            d2.y1 r4 = r3.d4()
            r3.t r4 = r4.z()
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r4.setValue(r0)
            u2.x r4 = new u2.x
            androidx.fragment.app.FragmentActivity r0 = r3.requireActivity()
            r4.<init>(r0)
            r3.f19980d = r4
            com.uptodown.UptodownApp$a r4 = com.uptodown.UptodownApp.f17422D
            C1.e r0 = r4.k()
            if (r0 == 0) goto L_0x0026
            r0.pause()
        L_0x0026:
            C1.e r4 = r4.l()
            if (r4 == 0) goto L_0x002f
            r4.pause()
        L_0x002f:
            android.os.Bundle r4 = r3.getArguments()
            if (r4 == 0) goto L_0x0068
            d2.y1 r0 = r3.d4()
            r3.t r0 = r0.F()
            java.lang.String r1 = "appId"
            long r1 = r4.getLong(r1)
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r0.setValue(r1)
            java.lang.String r0 = "appInfo"
            boolean r1 = r4.containsKey(r0)
            if (r1 == 0) goto L_0x0068
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            if (r1 < r2) goto L_0x0061
            java.lang.Class<g2.h> r1 = g2.C2050h.class
            java.lang.Object r4 = r4.getParcelable(r0, r1)
            android.os.Parcelable r4 = (android.os.Parcelable) r4
            goto L_0x0065
        L_0x0061:
            android.os.Parcelable r4 = r4.getParcelable(r0)
        L_0x0065:
            g2.h r4 = (g2.C2050h) r4
            goto L_0x0069
        L_0x0068:
            r4 = 0
        L_0x0069:
            if (r4 == 0) goto L_0x0083
            r3.k6(r4)
            d2.y1 r4 = r3.d4()
            android.content.Context r0 = r3.requireContext()
            java.lang.String r1 = "requireContext(...)"
            kotlin.jvm.internal.m.d(r0, r1)
            g2.h r1 = r3.Y3()
            r4.x(r0, r1)
            return
        L_0x0083:
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            if (r4 == 0) goto L_0x00b6
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            boolean r4 = r4 instanceof com.uptodown.activities.MainActivity
            if (r4 == 0) goto L_0x00a0
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            java.lang.String r0 = "null cannot be cast to non-null type com.uptodown.activities.MainActivity"
            kotlin.jvm.internal.m.c(r4, r0)
            com.uptodown.activities.MainActivity r4 = (com.uptodown.activities.MainActivity) r4
            r4.Z6()
            return
        L_0x00a0:
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            boolean r4 = r4 instanceof com.uptodown.activities.AppDetailActivity
            if (r4 == 0) goto L_0x00b6
            androidx.fragment.app.FragmentActivity r4 = r3.getActivity()
            java.lang.String r0 = "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity"
            kotlin.jvm.internal.m.c(r4, r0)
            com.uptodown.activities.AppDetailActivity r4 = (com.uptodown.activities.AppDetailActivity) r4
            r4.finish()
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d2.C1941r1.onCreate(android.os.Bundle):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        m.e(layoutInflater, "inflater");
        if (getActivity() == null) {
            return super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        this.f19978b = C1659d.c(layoutInflater, viewGroup, false);
        FragmentActivity requireActivity = requireActivity();
        m.d(requireActivity, "requireActivity(...)");
        h4(requireActivity);
        return Z3().getRoot();
    }

    public void onDestroy() {
        try {
            MBBannerView mBBannerView = Z3().f10263C;
            m.d(mBBannerView, "mbBannerView");
            mBBannerView.release();
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        d4().M().setValue(Boolean.valueOf(!((Boolean) d4().M().getValue()).booleanValue()));
        MBBannerView mBBannerView = Z3().f10263C;
        m.d(mBBannerView, "mbBannerView");
        mBBannerView.onPause();
    }

    public void onResume() {
        String n4;
        super.onResume();
        x xVar = this.f19980d;
        if (xVar != null) {
            xVar.e("AppDetailsFragment");
        }
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (o3.L) null, new C1962u(this, (d) null), 2, (Object) null);
        C1001s0 unused2 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (o3.L) null, new C1963v(this, (d) null), 2, (Object) null);
        C1001s0 unused3 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (o3.L) null, new C1964w(this, (d) null), 2, (Object) null);
        C1001s0 unused4 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (o3.L) null, new C1965x(this, (d) null), 2, (Object) null);
        C1001s0 unused5 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (o3.L) null, new C1966y(this, (d) null), 2, (Object) null);
        C1001s0 unused6 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (o3.L) null, new C1967z(this, (d) null), 2, (Object) null);
        C1001s0 unused7 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (o3.L) null, new A(this, (d) null), 2, (Object) null);
        if (!((Boolean) d4().Q().getValue()).booleanValue()) {
            Rect rect = new Rect();
            Z3().f10293a0.getHitRect(rect);
            U6(rect);
        }
        if (((Boolean) d4().Q().getValue()).booleanValue() || (n4 = Y3().n()) == null || n4.length() == 0) {
            d4().Q().setValue(Boolean.FALSE);
        } else {
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            h7(requireContext);
        }
        String l02 = Y3().l0();
        int i4 = 0;
        if (l02 == null || l02.length() == 0 || e4()) {
            Z3().f10272G0.getRoot().setVisibility(8);
        } else {
            Z3().f10272G0.getRoot().setVisibility(0);
        }
        U3();
        if (Z3().f10293a0.getScrollY() > 0) {
            Context requireContext2 = requireContext();
            m.d(requireContext2, "requireContext(...)");
            m7(requireContext2);
            String y4 = Y3().y();
            if (y4 == null || y4.length() == 0) {
                Z3().f10298d.setTitle("");
            }
        }
        M1.I i5 = this.f19984h;
        if (i5 != null) {
            i5.notifyDataSetChanged();
        }
        M1.I i6 = this.f19985i;
        if (i6 != null) {
            i6.notifyDataSetChanged();
        }
        ArrayList arrayList = this.f19986j;
        int size = arrayList.size();
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            ((M1.I) obj).notifyDataSetChanged();
        }
        C1001s0 unused8 = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (o3.L) null, new B(this, (d) null), 2, (Object) null);
        a5();
        MBBannerView mBBannerView = Z3().f10263C;
        m.d(mBBannerView, "mbBannerView");
        mBBannerView.onResume();
    }

    public final void q7(String str) {
        m.e(str, "packagename");
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), o3.Y.c(), (o3.L) null, new Y(str, this, (d) null), 2, (Object) null);
    }

    public final void r7(String str) {
        m.e(str, "packagename");
        if (getContext() != null && Y3().Q() != null && !m3.m.p(Y3().Q(), str, true)) {
            Context requireContext = requireContext();
            m.d(requireContext, "requireContext(...)");
            h7(requireContext);
            if (getActivity() != null && !requireActivity().isFinishing() && (getActivity() instanceof C1826a)) {
                FragmentActivity activity = getActivity();
                m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                String string = getString(com.uptodown.R.string.install_compatibility_error, Y3().L());
                m.d(string, "getString(...)");
                ((C1826a) activity).q0(string);
            }
        }
    }

    /* renamed from: d2.r1$C */
    public static final class C implements f2.K {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f19996a;

        C(C1941r1 r1Var) {
            this.f19996a = r1Var;
        }

        public void a(g2.U u4) {
            m.e(u4, "user");
            Intent intent = new Intent(this.f19996a.requireContext(), PublicProfileActivity.class);
            intent.putExtra("user", u4);
            C1941r1 r1Var = this.f19996a;
            UptodownApp.a aVar = UptodownApp.f17422D;
            FragmentActivity requireActivity = r1Var.requireActivity();
            m.d(requireActivity, "requireActivity(...)");
            r1Var.startActivity(intent, aVar.a(requireActivity));
        }

        public void b() {
        }
    }

    /* renamed from: d2.r1$l  reason: case insensitive filesystem */
    public static final class C1953l implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20078a;

        C1953l(C1941r1 r1Var) {
            this.f20078a = r1Var;
        }

        public void onAnimationEnd(Animation animation) {
            this.f20078a.Z3().f10304g.removeAllViews();
            this.f20078a.d4().B().set(false);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: d2.r1$q  reason: case insensitive filesystem */
    public static final class C1958q implements S1.m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1941r1 f20086a;

        /* renamed from: d2.r1$q$a */
        public static final class a implements h {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C1941r1 f20087a;

            a(C1941r1 r1Var) {
                this.f20087a = r1Var;
            }

            public void a() {
                C1941r1 r1Var = this.f20087a;
                String string = r1Var.getString(com.uptodown.R.string.installing);
                m.d(string, "getString(...)");
                r1Var.y6(string);
            }

            public void b(String str) {
                if (str != null) {
                    this.f20087a.s3(str);
                    return;
                }
                C1941r1 r1Var = this.f20087a;
                String string = r1Var.getString(com.uptodown.R.string.error_generico);
                m.d(string, "getString(...)");
                r1Var.s3(string);
            }
        }

        C1958q(C1941r1 r1Var) {
            this.f20086a = r1Var;
        }

        public void a(File file, ArrayList arrayList) {
            m.e(file, "fileZipped");
            m.e(arrayList, "files");
            a aVar = new a(this.f20086a);
            if (this.f20086a.getActivity() != null) {
                FragmentActivity activity = this.f20086a.getActivity();
                m.b(activity);
                if (!activity.isFinishing()) {
                    FragmentActivity activity2 = this.f20086a.getActivity();
                    m.b(activity2);
                    W1.C c5 = new W1.C(activity2);
                    c5.x(arrayList);
                    ArrayList y4 = c5.y();
                    FragmentActivity requireActivity = this.f20086a.requireActivity();
                    m.d(requireActivity, "requireActivity(...)");
                    new W1.j(requireActivity, aVar).w(y4, false);
                    if (this.f20086a.getActivity() instanceof C1826a) {
                        FragmentActivity activity3 = this.f20086a.getActivity();
                        m.c(activity3, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                        ((C1826a) activity3).z2(file);
                    }
                }
            }
        }

        public void b(int i4) {
            this.f20086a.J6(i4);
        }

        public void e() {
            if (this.f20086a.getContext() != null) {
                C1941r1 r1Var = this.f20086a;
                String string = r1Var.getString(com.uptodown.R.string.msg_install_from_unknown_source, r1Var.getString(com.uptodown.R.string.app_name));
                m.d(string, "getString(...)");
                this.f20086a.s3(string);
            }
        }

        public void f() {
            if (this.f20086a.getContext() != null) {
                C1941r1 r1Var = this.f20086a;
                String string = r1Var.getString(com.uptodown.R.string.core_kill_this_app, r1Var.getString(com.uptodown.R.string.app_name));
                m.d(string, "getString(...)");
                this.f20086a.s3(string);
            }
        }

        public void g() {
            this.f20086a.J6(0);
        }

        public void h() {
            if (this.f20086a.getContext() != null) {
                String string = this.f20086a.getString(com.uptodown.R.string.error_unzipping);
                m.d(string, "getString(...)");
                this.f20086a.s3(string);
            }
        }

        public void i() {
            if (this.f20086a.getActivity() != null && (this.f20086a.getActivity() instanceof C1826a)) {
                FragmentActivity activity = this.f20086a.getActivity();
                m.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                ((C1826a) activity).J();
            }
        }

        public void c(File file) {
        }

        public void d(File file) {
        }
    }

    /* access modifiers changed from: private */
    public static final void D4(View view) {
    }

    /* access modifiers changed from: private */
    public static final void D5(View view) {
    }

    /* access modifiers changed from: private */
    public static final void H4(View view) {
    }
}
