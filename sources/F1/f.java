package F1;

import C1.c;
import C1.d;
import C1.e;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import kotlin.jvm.internal.m;

public final class f extends D1.a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6459a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f6460b;

    /* renamed from: c  reason: collision with root package name */
    private c f6461c;

    /* renamed from: d  reason: collision with root package name */
    private String f6462d;

    /* renamed from: e  reason: collision with root package name */
    private float f6463e;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6464a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                C1.d[] r0 = C1.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                C1.d r1 = C1.d.ENDED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                C1.d r1 = C1.d.PAUSED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                C1.d r1 = C1.d.PLAYING     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f6464a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: F1.f.a.<clinit>():void");
        }
    }

    public void a(e eVar, String str) {
        m.e(eVar, "youTubePlayer");
        m.e(str, "videoId");
        this.f6462d = str;
    }

    public void b(e eVar, d dVar) {
        m.e(eVar, "youTubePlayer");
        m.e(dVar, MRAIDCommunicatorUtil.KEY_STATE);
        int i4 = a.f6464a[dVar.ordinal()];
        if (i4 == 1 || i4 == 2) {
            this.f6460b = false;
        } else if (i4 == 3) {
            this.f6460b = true;
        }
    }

    public void i(e eVar, c cVar) {
        m.e(eVar, "youTubePlayer");
        m.e(cVar, CampaignEx.JSON_NATIVE_VIDEO_ERROR);
        if (cVar == c.HTML_5_PLAYER) {
            this.f6461c = cVar;
        }
    }

    public void j(e eVar, float f4) {
        m.e(eVar, "youTubePlayer");
        this.f6463e = f4;
    }

    public final void k() {
        this.f6459a = true;
    }

    public final void l() {
        this.f6459a = false;
    }

    public final void m(e eVar) {
        m.e(eVar, "youTubePlayer");
        String str = this.f6462d;
        if (str != null) {
            boolean z4 = this.f6460b;
            if (z4 && this.f6461c == c.HTML_5_PLAYER) {
                h.a(eVar, this.f6459a, str, this.f6463e);
            } else if (!z4 && this.f6461c == c.HTML_5_PLAYER) {
                eVar.c(str, this.f6463e);
            }
            this.f6461c = null;
        }
    }
}
