package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import C1.e;
import F1.h;
import G1.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class YouTubePlayerView extends G1.b implements LifecycleEventObserver {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final List f17179a;

    /* renamed from: b  reason: collision with root package name */
    private final b f17180b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final G1.a f17181c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17182d;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f17183a;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|17) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                androidx.lifecycle.Lifecycle$Event[] r0 = androidx.lifecycle.Lifecycle.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_STOP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_START     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_PAUSE     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_ANY     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                f17183a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView.a.<clinit>():void");
        }
    }

    public static final class b implements D1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YouTubePlayerView f17184a;

        b(YouTubePlayerView youTubePlayerView) {
            this.f17184a = youTubePlayerView;
        }

        public void a(View view, d3.a aVar) {
            m.e(view, "fullscreenView");
            m.e(aVar, "exitFullscreen");
            if (!this.f17184a.f17179a.isEmpty()) {
                for (D1.b a5 : this.f17184a.f17179a) {
                    a5.a(view, aVar);
                }
                return;
            }
            throw new IllegalStateException("To enter fullscreen you need to first register a FullscreenListener.");
        }

        public void onExitFullscreen() {
            if (!this.f17184a.f17179a.isEmpty()) {
                for (D1.b onExitFullscreen : this.f17184a.f17179a) {
                    onExitFullscreen.onExitFullscreen();
                }
                return;
            }
            throw new IllegalStateException("To enter fullscreen you need to first register a FullscreenListener.");
        }
    }

    public static final class c extends D1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f17185a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ YouTubePlayerView f17186b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f17187c;

        c(String str, YouTubePlayerView youTubePlayerView, boolean z4) {
            this.f17185a = str;
            this.f17186b = youTubePlayerView;
            this.f17187c = z4;
        }

        public void f(e eVar) {
            boolean z4;
            m.e(eVar, "youTubePlayer");
            String str = this.f17185a;
            if (str != null) {
                YouTubePlayerView youTubePlayerView = this.f17186b;
                boolean z5 = this.f17187c;
                if (!youTubePlayerView.f17181c.getCanPlay$core_release() || !z5) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                h.a(eVar, z4, str, 0.0f);
            }
            eVar.a(this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        m.e(context, "context");
        this.f17179a = new ArrayList();
        b bVar = new b(this);
        this.f17180b = bVar;
        Context context2 = context;
        G1.a aVar = new G1.a(context2, bVar, (AttributeSet) null, 0, 12, (C2103g) null);
        this.f17181c = aVar;
        addView(aVar, g.b());
        TypedArray obtainStyledAttributes = context2.getTheme().obtainStyledAttributes(attributeSet, B1.b.f6170a, 0, 0);
        m.d(obtainStyledAttributes, "context.theme.obtainStyl….YouTubePlayerView, 0, 0)");
        this.f17182d = obtainStyledAttributes.getBoolean(B1.b.f6172c, true);
        boolean z4 = obtainStyledAttributes.getBoolean(B1.b.f6171b, false);
        boolean z5 = obtainStyledAttributes.getBoolean(B1.b.f6173d, true);
        String string = obtainStyledAttributes.getString(B1.b.f6174e);
        obtainStyledAttributes.recycle();
        if (!z4 || string != null) {
            c cVar = new c(string, this, z4);
            if (this.f17182d) {
                aVar.f(cVar, z5, E1.a.f6312b.a(), string);
                return;
            }
            return;
        }
        throw new IllegalStateException("YouTubePlayerView: videoId is not set but autoPlay is set to true. This combination is not allowed.");
    }

    private final void f() {
        this.f17181c.i();
    }

    private final void g() {
        this.f17181c.j();
    }

    public final boolean c(D1.b bVar) {
        m.e(bVar, "fullscreenListener");
        return this.f17179a.add(bVar);
    }

    public final View d(int i4) {
        return this.f17181c.d(i4);
    }

    public final void e(D1.c cVar, E1.a aVar) {
        m.e(cVar, "youTubePlayerListener");
        m.e(aVar, "playerOptions");
        if (!this.f17182d) {
            this.f17181c.e(cVar, true, aVar);
            return;
        }
        throw new IllegalStateException("YouTubePlayerView: If you want to initialize this view manually, you need to set 'enableAutomaticInitialization' to false.");
    }

    public final boolean getEnableAutomaticInitialization() {
        return this.f17182d;
    }

    public final void h() {
        this.f17181c.k();
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        m.e(lifecycleOwner, "source");
        m.e(event, NotificationCompat.CATEGORY_EVENT);
        int i4 = a.f17183a[event.ordinal()];
        if (i4 == 1) {
            f();
        } else if (i4 == 2) {
            g();
        } else if (i4 == 3) {
            h();
        }
    }

    public final void setCustomPlayerUi(View view) {
        m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        this.f17181c.setCustomPlayerUi(view);
    }

    public final void setEnableAutomaticInitialization(boolean z4) {
        this.f17182d = z4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context) {
        this(context, (AttributeSet) null, 0);
        m.e(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m.e(context, "context");
    }
}
