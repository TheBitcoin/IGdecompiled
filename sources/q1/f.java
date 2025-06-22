package q1;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

public enum f {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO(MimeTypes.BASE_TYPE_VIDEO),
    AUDIO(MimeTypes.BASE_TYPE_AUDIO);
    

    /* renamed from: a  reason: collision with root package name */
    private final String f21530a;

    private f(String str) {
        this.f21530a = str;
    }

    public String toString() {
        return this.f21530a;
    }
}
