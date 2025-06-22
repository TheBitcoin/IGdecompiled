package F1;

import C1.d;
import C1.e;
import D1.a;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import kotlin.jvm.internal.m;

public final class g extends a {

    /* renamed from: a  reason: collision with root package name */
    private d f6465a = d.UNKNOWN;

    /* renamed from: b  reason: collision with root package name */
    private float f6466b;

    /* renamed from: c  reason: collision with root package name */
    private float f6467c;

    /* renamed from: d  reason: collision with root package name */
    private String f6468d;

    public void a(e eVar, String str) {
        m.e(eVar, "youTubePlayer");
        m.e(str, "videoId");
        this.f6468d = str;
    }

    public void b(e eVar, d dVar) {
        m.e(eVar, "youTubePlayer");
        m.e(dVar, MRAIDCommunicatorUtil.KEY_STATE);
        this.f6465a = dVar;
    }

    public void d(e eVar, float f4) {
        m.e(eVar, "youTubePlayer");
        this.f6467c = f4;
    }

    public void j(e eVar, float f4) {
        m.e(eVar, "youTubePlayer");
        this.f6466b = f4;
    }
}
