package G1;

import F1.b;
import F1.f;
import R2.s;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import d3.l;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private final c f6560a;

    /* renamed from: b  reason: collision with root package name */
    private final F1.b f6561b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final f f6562c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6563d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public d3.a f6564e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final Set f6565f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6566g;

    /* renamed from: G1.a$a  reason: collision with other inner class name */
    public static final class C0084a extends D1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f6567a;

        C0084a(a aVar) {
            this.f6567a = aVar;
        }

        public void b(C1.e eVar, C1.d dVar) {
            m.e(eVar, "youTubePlayer");
            m.e(dVar, MRAIDCommunicatorUtil.KEY_STATE);
            if (dVar == C1.d.PLAYING && !this.f6567a.g()) {
                eVar.pause();
            }
        }
    }

    public static final class b extends D1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f6568a;

        b(a aVar) {
            this.f6568a = aVar;
        }

        public void f(C1.e eVar) {
            m.e(eVar, "youTubePlayer");
            this.f6568a.setYouTubePlayerReady$core_release(true);
            Iterator it = this.f6568a.f6565f.iterator();
            if (!it.hasNext()) {
                this.f6568a.f6565f.clear();
                eVar.a(this);
                return;
            }
            android.support.v4.media.a.a(it.next());
            throw null;
        }
    }

    static final class d extends n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        public static final d f6570a = new d();

        d() {
            super(0);
        }

        public final void invoke() {
        }
    }

    static final class e extends n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f6571a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ E1.a f6572b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f6573c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ D1.c f6574d;

        /* renamed from: G1.a$e$a  reason: collision with other inner class name */
        static final class C0085a extends n implements l {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ D1.c f6575a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0085a(D1.c cVar) {
                super(1);
                this.f6575a = cVar;
            }

            public final void a(C1.e eVar) {
                m.e(eVar, "it");
                eVar.d(this.f6575a);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((C1.e) obj);
                return s.f8222a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar, E1.a aVar2, String str, D1.c cVar) {
            super(0);
            this.f6571a = aVar;
            this.f6572b = aVar2;
            this.f6573c = str;
            this.f6574d = cVar;
        }

        public final void invoke() {
            this.f6571a.getWebViewYouTubePlayer$core_release().e(new C0085a(this.f6574d), this.f6572b, this.f6573c);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Context context, D1.b bVar, AttributeSet attributeSet, int i4, int i5, C2103g gVar) {
        this(context, bVar, (i5 & 4) != 0 ? null : attributeSet, (i5 & 8) != 0 ? 0 : i4);
    }

    public final View d(int i4) {
        removeViews(1, getChildCount() - 1);
        View inflate = View.inflate(getContext(), i4, this);
        m.d(inflate, "inflate(context, layoutId, this)");
        return inflate;
    }

    public final void e(D1.c cVar, boolean z4, E1.a aVar) {
        m.e(cVar, "youTubePlayerListener");
        m.e(aVar, "playerOptions");
        f(cVar, z4, aVar, (String) null);
    }

    public final void f(D1.c cVar, boolean z4, E1.a aVar, String str) {
        m.e(cVar, "youTubePlayerListener");
        m.e(aVar, "playerOptions");
        if (!this.f6563d) {
            if (z4) {
                this.f6561b.e();
            }
            e eVar = new e(this, aVar, str, cVar);
            this.f6564e = eVar;
            if (!z4) {
                eVar.invoke();
                return;
            }
            return;
        }
        throw new IllegalStateException("This YouTubePlayerView has already been initialized.");
    }

    public final boolean g() {
        if (this.f6566g || this.f6560a.f()) {
            return true;
        }
        return false;
    }

    public final boolean getCanPlay$core_release() {
        return this.f6566g;
    }

    public final c getWebViewYouTubePlayer$core_release() {
        return this.f6560a;
    }

    public final boolean h() {
        return this.f6563d;
    }

    public final void i() {
        this.f6562c.k();
        this.f6566g = true;
    }

    public final void j() {
        this.f6560a.getYoutubePlayer$core_release().pause();
        this.f6562c.l();
        this.f6566g = false;
    }

    public final void k() {
        this.f6561b.a();
        removeView(this.f6560a);
        this.f6560a.removeAllViews();
        this.f6560a.destroy();
    }

    public final void setCustomPlayerUi(View view) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        removeViews(1, getChildCount() - 1);
        addView(view);
    }

    public final void setYouTubePlayerReady$core_release(boolean z4) {
        this.f6563d = z4;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, D1.b bVar, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        m.e(context, "context");
        m.e(bVar, "listener");
        Context context2 = context;
        c cVar = new c(context2, bVar, (AttributeSet) null, 0, 12, (C2103g) null);
        this.f6560a = cVar;
        Context applicationContext = context2.getApplicationContext();
        m.d(applicationContext, "context.applicationContext");
        F1.b bVar2 = new F1.b(applicationContext);
        this.f6561b = bVar2;
        f fVar = new f();
        this.f6562c = fVar;
        this.f6564e = d.f6570a;
        this.f6565f = new LinkedHashSet();
        this.f6566g = true;
        addView(cVar, new FrameLayout.LayoutParams(-1, -1));
        cVar.c(fVar);
        cVar.c(new C0084a(this));
        cVar.c(new b(this));
        bVar2.d().add(new c(this));
    }

    public static final class c implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f6569a;

        c(a aVar) {
            this.f6569a = aVar;
        }

        public void a() {
            if (!this.f6569a.h()) {
                this.f6569a.f6564e.invoke();
            } else {
                this.f6569a.f6562c.m(this.f6569a.getWebViewYouTubePlayer$core_release().getYoutubePlayer$core_release());
            }
        }

        public void b() {
        }
    }
}
