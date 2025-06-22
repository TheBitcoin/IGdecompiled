package m3;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.charset.Charset;
import kotlin.jvm.internal.m;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f21159a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f21160b;

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f21161c;

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f21162d;

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f21163e;

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f21164f;

    /* renamed from: g  reason: collision with root package name */
    public static final Charset f21165g;

    static {
        Charset forName = Charset.forName(C.UTF8_NAME);
        m.d(forName, "forName(...)");
        f21160b = forName;
        Charset forName2 = Charset.forName(C.UTF16_NAME);
        m.d(forName2, "forName(...)");
        f21161c = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        m.d(forName3, "forName(...)");
        f21162d = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        m.d(forName4, "forName(...)");
        f21163e = forName4;
        Charset forName5 = Charset.forName(C.ASCII_NAME);
        m.d(forName5, "forName(...)");
        f21164f = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        m.d(forName6, "forName(...)");
        f21165g = forName6;
    }

    private d() {
    }
}
