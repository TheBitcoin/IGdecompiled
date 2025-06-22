package E1;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final b f6312b = new b((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final a f6313c = new C0080a().e(1).c();

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f6314a;

    /* renamed from: E1.a$a  reason: collision with other inner class name */
    public static final class C0080a {

        /* renamed from: b  reason: collision with root package name */
        public static final C0081a f6315b = new C0081a((C2103g) null);

        /* renamed from: a  reason: collision with root package name */
        private final JSONObject f6316a = new JSONObject();

        /* renamed from: E1.a$a$a  reason: collision with other inner class name */
        public static final class C0081a {
            public /* synthetic */ C0081a(C2103g gVar) {
                this();
            }

            private C0081a() {
            }
        }

        public C0080a() {
            a("autoplay", 0);
            a(CampaignEx.JSON_NATIVE_VIDEO_MUTE, 0);
            a("controls", 0);
            a("enablejsapi", 1);
            a("fs", 0);
            b(TtmlNode.ATTR_TTS_ORIGIN, "https://www.youtube.com");
            a("rel", 0);
            a("iv_load_policy", 3);
            a("cc_load_policy", 0);
        }

        private final void a(String str, int i4) {
            try {
                this.f6316a.put(str, i4);
            } catch (JSONException unused) {
                throw new RuntimeException("Illegal JSON value " + str + ": " + i4);
            }
        }

        private final void b(String str, String str2) {
            try {
                this.f6316a.put(str, str2);
            } catch (JSONException unused) {
                throw new RuntimeException("Illegal JSON value " + str + ": " + str2);
            }
        }

        public final a c() {
            return new a(this.f6316a, (C2103g) null);
        }

        public final C0080a d(int i4) {
            a("cc_load_policy", i4);
            return this;
        }

        public final C0080a e(int i4) {
            a("controls", i4);
            return this;
        }

        public final C0080a f(int i4) {
            a("fs", i4);
            return this;
        }

        public final C0080a g(int i4) {
            a("iv_load_policy", i4);
            return this;
        }

        public final C0080a h(int i4) {
            a("rel", i4);
            return this;
        }
    }

    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        public final a a() {
            return a.f6313c;
        }

        private b() {
        }
    }

    public /* synthetic */ a(JSONObject jSONObject, C2103g gVar) {
        this(jSONObject);
    }

    public final String b() {
        String string = this.f6314a.getString(TtmlNode.ATTR_TTS_ORIGIN);
        m.d(string, "playerOptions.getString(Builder.ORIGIN)");
        return string;
    }

    public String toString() {
        String jSONObject = this.f6314a.toString();
        m.d(jSONObject, "playerOptions.toString()");
        return jSONObject;
    }

    private a(JSONObject jSONObject) {
        this.f6314a = jSONObject;
    }
}
