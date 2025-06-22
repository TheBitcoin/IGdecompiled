package C1;

import D1.c;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.Collection;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class q {

    /* renamed from: c  reason: collision with root package name */
    public static final a f6273c = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final b f6274a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f6275b = new Handler(Looper.getMainLooper());

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    public interface b {
        void a();

        e getInstance();

        Collection getListeners();
    }

    public q(b bVar) {
        m.e(bVar, "youTubePlayerOwner");
        this.f6274a = bVar;
    }

    private final a l(String str) {
        if (m3.m.p(str, "small", true)) {
            return a.SMALL;
        }
        if (m3.m.p(str, "medium", true)) {
            return a.MEDIUM;
        }
        if (m3.m.p(str, "large", true)) {
            return a.LARGE;
        }
        if (m3.m.p(str, "hd720", true)) {
            return a.HD720;
        }
        if (m3.m.p(str, "hd1080", true)) {
            return a.HD1080;
        }
        if (m3.m.p(str, "highres", true)) {
            return a.HIGH_RES;
        }
        if (m3.m.p(str, MRAIDCommunicatorUtil.STATES_DEFAULT, true)) {
            return a.DEFAULT;
        }
        return a.UNKNOWN;
    }

    private final b m(String str) {
        if (m3.m.p(str, "0.25", true)) {
            return b.RATE_0_25;
        }
        if (m3.m.p(str, "0.5", true)) {
            return b.RATE_0_5;
        }
        if (m3.m.p(str, "0.75", true)) {
            return b.RATE_0_75;
        }
        if (m3.m.p(str, "1", true)) {
            return b.RATE_1;
        }
        if (m3.m.p(str, "1.25", true)) {
            return b.RATE_1_25;
        }
        if (m3.m.p(str, "1.5", true)) {
            return b.RATE_1_5;
        }
        if (m3.m.p(str, "1.75", true)) {
            return b.RATE_1_75;
        }
        if (m3.m.p(str, "2", true)) {
            return b.RATE_2;
        }
        return b.UNKNOWN;
    }

    private final c n(String str) {
        if (m3.m.p(str, "2", true)) {
            return c.INVALID_PARAMETER_IN_REQUEST;
        }
        if (m3.m.p(str, CampaignEx.CLICKMODE_ON, true)) {
            return c.HTML_5_PLAYER;
        }
        if (m3.m.p(str, "100", true)) {
            return c.VIDEO_NOT_FOUND;
        }
        if (m3.m.p(str, "101", true)) {
            return c.VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER;
        }
        if (m3.m.p(str, "150", true)) {
            return c.VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER;
        }
        return c.UNKNOWN;
    }

    private final d o(String str) {
        if (m3.m.p(str, "UNSTARTED", true)) {
            return d.UNSTARTED;
        }
        if (m3.m.p(str, "ENDED", true)) {
            return d.ENDED;
        }
        if (m3.m.p(str, "PLAYING", true)) {
            return d.PLAYING;
        }
        if (m3.m.p(str, "PAUSED", true)) {
            return d.PAUSED;
        }
        if (m3.m.p(str, "BUFFERING", true)) {
            return d.BUFFERING;
        }
        if (m3.m.p(str, "CUED", true)) {
            return d.VIDEO_CUED;
        }
        return d.UNKNOWN;
    }

    /* access modifiers changed from: private */
    public static final void p(q qVar) {
        m.e(qVar, "this$0");
        for (c e5 : qVar.f6274a.getListeners()) {
            e5.e(qVar.f6274a.getInstance());
        }
    }

    /* access modifiers changed from: private */
    public static final void q(q qVar, c cVar) {
        m.e(qVar, "this$0");
        m.e(cVar, "$playerError");
        for (c i4 : qVar.f6274a.getListeners()) {
            i4.i(qVar.f6274a.getInstance(), cVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void r(q qVar, a aVar) {
        m.e(qVar, "this$0");
        m.e(aVar, "$playbackQuality");
        for (c h4 : qVar.f6274a.getListeners()) {
            h4.h(qVar.f6274a.getInstance(), aVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void s(q qVar, b bVar) {
        m.e(qVar, "this$0");
        m.e(bVar, "$playbackRate");
        for (c c5 : qVar.f6274a.getListeners()) {
            c5.c(qVar.f6274a.getInstance(), bVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void t(q qVar) {
        m.e(qVar, "this$0");
        for (c f4 : qVar.f6274a.getListeners()) {
            f4.f(qVar.f6274a.getInstance());
        }
    }

    /* access modifiers changed from: private */
    public static final void u(q qVar, d dVar) {
        m.e(qVar, "this$0");
        m.e(dVar, "$playerState");
        for (c b5 : qVar.f6274a.getListeners()) {
            b5.b(qVar.f6274a.getInstance(), dVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void v(q qVar, float f4) {
        m.e(qVar, "this$0");
        for (c j4 : qVar.f6274a.getListeners()) {
            j4.j(qVar.f6274a.getInstance(), f4);
        }
    }

    /* access modifiers changed from: private */
    public static final void w(q qVar, float f4) {
        m.e(qVar, "this$0");
        for (c d5 : qVar.f6274a.getListeners()) {
            d5.d(qVar.f6274a.getInstance(), f4);
        }
    }

    /* access modifiers changed from: private */
    public static final void x(q qVar, String str) {
        m.e(qVar, "this$0");
        m.e(str, "$videoId");
        for (c a5 : qVar.f6274a.getListeners()) {
            a5.a(qVar.f6274a.getInstance(), str);
        }
    }

    /* access modifiers changed from: private */
    public static final void y(q qVar, float f4) {
        m.e(qVar, "this$0");
        for (c g4 : qVar.f6274a.getListeners()) {
            g4.g(qVar.f6274a.getInstance(), f4);
        }
    }

    /* access modifiers changed from: private */
    public static final void z(q qVar) {
        m.e(qVar, "this$0");
        qVar.f6274a.a();
    }

    @JavascriptInterface
    public final boolean sendApiChange() {
        return this.f6275b.post(new l(this));
    }

    @JavascriptInterface
    public final void sendError(String str) {
        m.e(str, CampaignEx.JSON_NATIVE_VIDEO_ERROR);
        this.f6275b.post(new o(this, n(str)));
    }

    @JavascriptInterface
    public final void sendPlaybackQualityChange(String str) {
        m.e(str, "quality");
        this.f6275b.post(new h(this, l(str)));
    }

    @JavascriptInterface
    public final void sendPlaybackRateChange(String str) {
        m.e(str, "rate");
        this.f6275b.post(new j(this, m(str)));
    }

    @JavascriptInterface
    public final boolean sendReady() {
        return this.f6275b.post(new m(this));
    }

    @JavascriptInterface
    public final void sendStateChange(String str) {
        m.e(str, MRAIDCommunicatorUtil.KEY_STATE);
        this.f6275b.post(new p(this, o(str)));
    }

    @JavascriptInterface
    public final void sendVideoCurrentTime(String str) {
        m.e(str, "seconds");
        try {
            this.f6275b.post(new f(this, Float.parseFloat(str)));
        } catch (NumberFormatException e5) {
            e5.printStackTrace();
        }
    }

    @JavascriptInterface
    public final void sendVideoDuration(String str) {
        m.e(str, "seconds");
        try {
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            this.f6275b.post(new i(this, Float.parseFloat(str)));
        } catch (NumberFormatException e5) {
            e5.printStackTrace();
        }
    }

    @JavascriptInterface
    public final boolean sendVideoId(String str) {
        m.e(str, "videoId");
        return this.f6275b.post(new k(this, str));
    }

    @JavascriptInterface
    public final void sendVideoLoadedFraction(String str) {
        m.e(str, "fraction");
        try {
            this.f6275b.post(new n(this, Float.parseFloat(str)));
        } catch (NumberFormatException e5) {
            e5.printStackTrace();
        }
    }

    @JavascriptInterface
    public final boolean sendYouTubeIFrameAPIReady() {
        return this.f6275b.post(new g(this));
    }
}
