package M1;

import C1.d;
import C1.e;
import E1.a;
import N1.k;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import d2.E1;
import f2.C2010a;
import f2.C2028t;
import g2.C2050h;
import g2.Z;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;
import w2.h;
import x2.C2375j;
import y2.h;

public final class d0 extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private C2028t f7567a;

    /* renamed from: b  reason: collision with root package name */
    private final C2010a f7568b;

    /* renamed from: c  reason: collision with root package name */
    private Context f7569c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f7570d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList f7571e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private boolean f7572f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public YouTubePlayerView f7573g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public e f7574h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f7575i = "";
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f7576j;

    /* renamed from: k  reason: collision with root package name */
    private int f7577k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7578l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f7579m = true;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public h f7580n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f7581o = 8;

    public final class a extends C2375j {

        /* renamed from: b  reason: collision with root package name */
        private C2028t f7582b;

        /* renamed from: c  reason: collision with root package name */
        private final C2010a f7583c;

        /* renamed from: d  reason: collision with root package name */
        private Context f7584d;

        /* renamed from: e  reason: collision with root package name */
        private String f7585e;

        /* renamed from: f  reason: collision with root package name */
        private final ImageView f7586f;

        /* renamed from: g  reason: collision with root package name */
        private final RelativeLayout f7587g;

        /* renamed from: h  reason: collision with root package name */
        private final ProgressBar f7588h;

        /* renamed from: i  reason: collision with root package name */
        private final ImageView f7589i;

        /* renamed from: j  reason: collision with root package name */
        private final TextView f7590j;

        /* renamed from: k  reason: collision with root package name */
        private final TextView f7591k;

        /* renamed from: l  reason: collision with root package name */
        private final TextView f7592l;

        /* renamed from: m  reason: collision with root package name */
        private final TextView f7593m;

        /* renamed from: n  reason: collision with root package name */
        private final TextView f7594n;

        /* renamed from: o  reason: collision with root package name */
        private final LinearLayout f7595o;

        /* renamed from: p  reason: collision with root package name */
        private final CardView f7596p;

        /* renamed from: q  reason: collision with root package name */
        private final View f7597q;

        /* renamed from: r  reason: collision with root package name */
        private final int f7598r = UptodownApp.f17422D.F();

        /* renamed from: s  reason: collision with root package name */
        final /* synthetic */ d0 f7599s;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d0 d0Var, View view, C2028t tVar, C2010a aVar, Context context, String str) {
            super(view, context);
            m.e(view, "itemView");
            m.e(tVar, "listener");
            m.e(aVar, "actionsClickListener");
            m.e(context, "context");
            m.e(str, "fragmentName");
            this.f7599s = d0Var;
            this.f7582b = tVar;
            this.f7583c = aVar;
            this.f7584d = context;
            this.f7585e = str;
            View findViewById = view.findViewById(R.id.iv_image_video_featured_item);
            m.d(findViewById, "findViewById(...)");
            this.f7586f = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.rl_video_card_info);
            m.d(findViewById2, "findViewById(...)");
            this.f7587g = (RelativeLayout) findViewById2;
            View findViewById3 = view.findViewById(R.id.pb_progress_video_featured_item);
            m.d(findViewById3, "findViewById(...)");
            this.f7588h = (ProgressBar) findViewById3;
            View findViewById4 = view.findViewById(R.id.iv_logo_video_featured_item);
            m.d(findViewById4, "findViewById(...)");
            this.f7589i = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(R.id.tv_name_video_featured_item);
            m.d(findViewById5, "findViewById(...)");
            TextView textView = (TextView) findViewById5;
            this.f7590j = textView;
            View findViewById6 = view.findViewById(R.id.tv_desc_video_featured_item);
            m.d(findViewById6, "findViewById(...)");
            TextView textView2 = (TextView) findViewById6;
            this.f7591k = textView2;
            View findViewById7 = view.findViewById(R.id.tv_status_video_featured_item);
            m.d(findViewById7, "findViewById(...)");
            this.f7592l = (TextView) findViewById7;
            View findViewById8 = view.findViewById(R.id.tv_progress_video_featured_item);
            m.d(findViewById8, "findViewById(...)");
            TextView textView3 = (TextView) findViewById8;
            this.f7593m = textView3;
            View findViewById9 = view.findViewById(R.id.tv_verified_video_featured_item);
            m.d(findViewById9, "findViewById(...)");
            TextView textView4 = (TextView) findViewById9;
            this.f7594n = textView4;
            View findViewById10 = view.findViewById(R.id.ll_progress_video_featured_item);
            m.d(findViewById10, "findViewById(...)");
            this.f7595o = (LinearLayout) findViewById10;
            View findViewById11 = view.findViewById(R.id.cv_youtube_player_view);
            m.d(findViewById11, "findViewById(...)");
            this.f7596p = (CardView) findViewById11;
            View findViewById12 = view.findViewById(R.id.v_player_controller);
            m.d(findViewById12, "findViewById(...)");
            this.f7597q = findViewById12;
            k.a aVar2 = k.f7778g;
            textView.setTypeface(aVar2.w());
            textView2.setTypeface(aVar2.x());
            textView3.setTypeface(aVar2.x());
            textView4.setTypeface(aVar2.x());
        }

        /* access modifiers changed from: private */
        public static final boolean p(a aVar, C2050h hVar, int i4, View view) {
            aVar.f7583c.a(hVar, i4);
            return true;
        }

        /* access modifiers changed from: private */
        public static final void r(d0 d0Var, View view) {
            if (d0Var.r()) {
                e f4 = d0Var.f7574h;
                if (f4 != null) {
                    f4.pause();
                    return;
                }
                return;
            }
            e f5 = d0Var.f7574h;
            if (f5 != null) {
                f5.play();
            }
        }

        /* access modifiers changed from: private */
        public static final boolean s(a aVar, C2050h hVar, int i4, View view) {
            aVar.f7583c.a(hVar, i4);
            return true;
        }

        private final void t(C2050h hVar) {
            i(hVar, this.f7590j, this.f7591k);
            c(this.f7587g, this.f7582b, hVar);
            u(this.f7586f, hVar);
            h(this.f7589i, hVar.F());
        }

        private final void u(ImageView imageView, C2050h hVar) {
            y2.h hVar2 = new y2.h((int) imageView.getContext().getResources().getDimension(R.dimen.border_radius_m), (h.a) null, 2, (C2103g) null);
            String y4 = hVar.y();
            if (y4 == null || y4.length() == 0) {
                imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), R.drawable.shape_bg_placeholder));
                return;
            }
            UptodownApp.a aVar = UptodownApp.f17422D;
            if (aVar.x() > 0) {
                imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, aVar.x()));
                s.h().l(hVar.w()).m(aVar.y(), aVar.x()).n(hVar2).i(imageView);
                return;
            }
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            s.h().l(hVar.w()).f().n(hVar2).i(imageView);
        }

        public final void o(C2050h hVar, int i4) {
            m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            this.f7596p.setVisibility(8);
            this.f7597q.setVisibility(8);
            this.f7586f.setVisibility(0);
            t(hVar);
            C2050h hVar2 = hVar;
            e(hVar2, this.f7588h, this.f7589i, this.f7591k, this.f7593m, this.f7592l, this.f7595o);
            this.f7587g.setOnLongClickListener(new c0(this, hVar2, i4));
            this.itemView.setLayoutParams(b(new RelativeLayout.LayoutParams(this.f7598r, -1), this.f7584d, i4, this.f7599s.f7581o));
            c(this.f7586f, this.f7582b, hVar2);
        }

        public final void q(C2050h hVar, int i4) {
            ArrayList y02;
            ImageView l4;
            m.e(hVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (this.f7599s.f7573g != null) {
                YouTubePlayerView g4 = this.f7599s.f7573g;
                m.b(g4);
                if (g4.getParent() != null) {
                    YouTubePlayerView g5 = this.f7599s.f7573g;
                    m.b(g5);
                    ViewParent parent = g5.getParent();
                    m.c(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    ((ViewGroup) parent).removeView(this.f7599s.f7573g);
                }
                this.f7596p.addView(this.f7599s.f7573g);
                this.f7596p.setVisibility(0);
                this.f7597q.setVisibility(0);
                this.f7586f.setVisibility(8);
                w2.h b5 = this.f7599s.f7580n;
                if (!(b5 == null || (l4 = b5.l()) == null)) {
                    l4.setImageDrawable((Drawable) null);
                }
                t(hVar);
                C2050h hVar2 = hVar;
                e(hVar2, this.f7588h, this.f7589i, this.f7591k, this.f7593m, this.f7592l, this.f7595o);
                this.f7597q.setOnClickListener(new a0(this.f7599s));
                this.f7587g.setOnLongClickListener(new b0(this, hVar2, i4));
                this.itemView.setLayoutParams(b(new RelativeLayout.LayoutParams(this.f7598r, -1), this.f7584d, i4, this.f7599s.f7581o));
                if (this.f7599s.q() && this.f7599s.f7574h != null && (y02 = hVar2.y0()) != null && !y02.isEmpty()) {
                    ArrayList y03 = hVar2.y0();
                    m.b(y03);
                    if (((Z) y03.get(0)).a() != null) {
                        ArrayList y04 = hVar2.y0();
                        m.b(y04);
                        if (!m.a(((Z) y04.get(0)).a(), this.f7599s.f7576j)) {
                            d0 d0Var = this.f7599s;
                            ArrayList y05 = hVar2.y0();
                            m.b(y05);
                            d0Var.f7576j = ((Z) y05.get(0)).a();
                            d0 d0Var2 = this.f7599s;
                            StringBuilder sb = new StringBuilder();
                            String L4 = hVar2.L();
                            m.b(L4);
                            sb.append(L4);
                            sb.append(this.f7585e);
                            d0Var2.f7575i = sb.toString();
                            if (m.a(this.f7585e, D.b(E1.class).b())) {
                                UptodownApp.f17422D.r0(this.f7599s.f7574h);
                            } else {
                                UptodownApp.f17422D.s0(this.f7599s.f7574h);
                            }
                            UptodownApp.a aVar = UptodownApp.f17422D;
                            if (!aVar.f(this.f7584d) || com.uptodown.activities.preferences.a.f18818a.k(this.f7584d) <= 0) {
                                if (aVar.H().containsKey(this.f7599s.f7575i)) {
                                    e f4 = this.f7599s.f7574h;
                                    m.b(f4);
                                    ArrayList y06 = hVar2.y0();
                                    m.b(y06);
                                    String a5 = ((Z) y06.get(0)).a();
                                    m.b(a5);
                                    Object obj = aVar.H().get(this.f7599s.f7575i);
                                    m.b(obj);
                                    f4.c(a5, ((Number) obj).floatValue());
                                } else {
                                    e f5 = this.f7599s.f7574h;
                                    m.b(f5);
                                    ArrayList y07 = hVar2.y0();
                                    m.b(y07);
                                    String a6 = ((Z) y07.get(0)).a();
                                    m.b(a6);
                                    f5.c(a6, 0.0f);
                                    aVar.H().put(this.f7599s.f7575i, Float.valueOf(0.0f));
                                }
                                String y4 = hVar2.y();
                                if (y4 != null && y4.length() != 0) {
                                    w2.h b6 = this.f7599s.f7580n;
                                    m.b(b6);
                                    b6.l().setVisibility(0);
                                    w2.h b7 = this.f7599s.f7580n;
                                    m.b(b7);
                                    u(b7.l(), hVar2);
                                    return;
                                }
                                return;
                            }
                            if (aVar.H().containsKey(this.f7599s.f7575i)) {
                                e f6 = this.f7599s.f7574h;
                                m.b(f6);
                                ArrayList y08 = hVar2.y0();
                                m.b(y08);
                                String a7 = ((Z) y08.get(0)).a();
                                m.b(a7);
                                Object obj2 = aVar.H().get(this.f7599s.f7575i);
                                m.b(obj2);
                                f6.e(a7, ((Number) obj2).floatValue());
                            } else {
                                e f7 = this.f7599s.f7574h;
                                m.b(f7);
                                ArrayList y09 = hVar2.y0();
                                m.b(y09);
                                String a8 = ((Z) y09.get(0)).a();
                                m.b(a8);
                                f7.e(a8, 0.0f);
                                aVar.H().put(this.f7599s.f7575i, Float.valueOf(0.0f));
                            }
                            if (this.f7599s.o()) {
                                e f8 = this.f7599s.f7574h;
                                m.b(f8);
                                f8.play();
                                return;
                            }
                            e f9 = this.f7599s.f7574h;
                            m.b(f9);
                            f9.pause();
                            return;
                        }
                    }
                }
                ArrayList y010 = hVar2.y0();
                if (y010 == null || y010.isEmpty()) {
                    o(hVar2, i4);
                }
                if (this.f7599s.f7574h == null) {
                    this.f7599s.p();
                    return;
                }
                return;
            }
        }
    }

    public static final class b extends D1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d0 f7600a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f7601b;

        b(d0 d0Var, View view) {
            this.f7600a = d0Var;
            this.f7601b = view;
        }

        public void b(e eVar, d dVar) {
            m.e(eVar, "youTubePlayer");
            m.e(dVar, MRAIDCommunicatorUtil.KEY_STATE);
            super.b(eVar, dVar);
            d dVar2 = d.BUFFERING;
            if (dVar == dVar2 && this.f7600a.o()) {
                eVar.play();
            }
            if (dVar == dVar2 && m.a(this.f7600a.f7570d, D.b(E1.class).b())) {
                eVar.play();
            }
            if (dVar == d.PAUSED) {
                this.f7600a.y(false);
            }
            if (dVar == d.PLAYING) {
                this.f7600a.y(true);
            }
        }

        public void f(e eVar) {
            m.e(eVar, "youTubePlayer");
            super.f(eVar);
            UptodownApp.a aVar = UptodownApp.f17422D;
            if (aVar.x() == 0) {
                YouTubePlayerView g4 = this.f7600a.f7573g;
                m.b(g4);
                if (g4.getHeight() != 0) {
                    YouTubePlayerView g5 = this.f7600a.f7573g;
                    m.b(g5);
                    aVar.G0(g5.getHeight());
                    YouTubePlayerView g6 = this.f7600a.f7573g;
                    m.b(g6);
                    aVar.H0(g6.getWidth());
                }
            }
            this.f7600a.f7580n = new w2.h(this.f7601b, eVar);
            w2.h b5 = this.f7600a.f7580n;
            m.b(b5);
            eVar.d(b5);
            eVar.f();
            this.f7600a.f7574h = eVar;
            this.f7600a.w(true);
            this.f7600a.notifyItemChanged(0);
        }

        public void j(e eVar, float f4) {
            m.e(eVar, "youTubePlayer");
            super.j(eVar, f4);
            UptodownApp.f17422D.H().put(this.f7600a.f7575i, Float.valueOf(f4));
        }
    }

    public d0(C2028t tVar, C2010a aVar, Context context, String str) {
        m.e(tVar, "listener");
        m.e(aVar, "actionsClickListener");
        m.e(context, "context");
        m.e(str, "fragmentName");
        this.f7567a = tVar;
        this.f7568b = aVar;
        this.f7569c = context;
        this.f7570d = str;
        if (!com.uptodown.activities.preferences.a.f18818a.L(this.f7569c)) {
            try {
                YouTubePlayerView youTubePlayerView = new YouTubePlayerView(this.f7569c);
                youTubePlayerView.setEnableAutomaticInitialization(false);
                this.f7573g = youTubePlayerView;
                p();
            } catch (UnsatisfiedLinkError e5) {
                com.uptodown.activities.preferences.a.f18818a.F0(this.f7569c, true);
                this.f7573g = null;
                e5.printStackTrace();
            } catch (Exception e6) {
                com.uptodown.activities.preferences.a.f18818a.F0(this.f7569c, true);
                this.f7573g = null;
                e6.printStackTrace();
            }
        }
        if (m.a(this.f7570d, D.b(E1.class).b())) {
            this.f7581o = 8;
        } else {
            this.f7581o = 20;
        }
        this.f7579m = UptodownApp.f17422D.f(this.f7569c);
    }

    /* access modifiers changed from: private */
    public final void p() {
        YouTubePlayerView youTubePlayerView = this.f7573g;
        if (youTubePlayerView != null) {
            m.b(youTubePlayerView);
            View d5 = youTubePlayerView.d(R.layout.home_youtube_player_layout);
            E1.a c5 = new a.C0080a().e(0).h(0).g(3).d(1).c();
            YouTubePlayerView youTubePlayerView2 = this.f7573g;
            m.b(youTubePlayerView2);
            youTubePlayerView2.e(new b(this, d5), c5);
        }
    }

    public int getItemCount() {
        return this.f7571e.size();
    }

    public final ArrayList m() {
        return this.f7571e;
    }

    public final int n() {
        return this.f7577k;
    }

    public final boolean o() {
        return this.f7572f;
    }

    public final boolean q() {
        return this.f7578l;
    }

    public final boolean r() {
        return this.f7579m;
    }

    /* renamed from: s */
    public void onBindViewHolder(a aVar, int i4) {
        m.e(aVar, "holder");
        int i5 = i4 + 1;
        if (com.uptodown.activities.preferences.a.f18818a.L(this.f7569c) || i4 != this.f7577k) {
            Object obj = this.f7571e.get(i4);
            m.d(obj, "get(...)");
            aVar.o((C2050h) obj, i5);
            return;
        }
        Object obj2 = this.f7571e.get(i4);
        m.d(obj2, "get(...)");
        aVar.q((C2050h) obj2, i5);
    }

    /* renamed from: t */
    public a onCreateViewHolder(ViewGroup viewGroup, int i4) {
        m.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_video_featured_item, viewGroup, false);
        m.b(inflate);
        return new a(this, inflate, this.f7567a, this.f7568b, this.f7569c, this.f7570d);
    }

    public final void u(int i4) {
        this.f7577k = i4;
    }

    public final void v(ArrayList arrayList) {
        m.e(arrayList, "appList");
        ArrayList arrayList2 = this.f7571e;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
    }

    public final void w(boolean z4) {
        this.f7578l = z4;
    }

    public final void x(boolean z4) {
        this.f7572f = z4;
    }

    public final void y(boolean z4) {
        this.f7579m = z4;
    }
}
