package P3;

import Q3.C2551b;
import Q3.C2555f;
import R2.s;
import S3.C2568a;
import S3.C2569b;
import S3.C2571d;
import S3.C2572e;
import Y3.C2611a;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: P3.b  reason: case insensitive filesystem */
public final class C2546b {

    /* renamed from: e  reason: collision with root package name */
    public static final a f23786e = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static volatile C2546b f23787f;

    /* renamed from: a  reason: collision with root package name */
    private final Map f23788a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f23789b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences f23790c;

    /* renamed from: d  reason: collision with root package name */
    private C2555f f23791d;

    /* renamed from: P3.b$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final synchronized C2546b a(Context context) {
            try {
                m.e(context, "context");
                if (C2546b.f23787f == null) {
                    synchronized (C2546b.class) {
                        if (C2546b.f23787f == null) {
                            C2546b.f23787f = new C2546b(context, (C2103g) null);
                        }
                        s sVar = s.f8222a;
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            } finally {
            }
            return C2546b.f23787f;
        }

        public final String b(Class... clsArr) {
            m.e(clsArr, "classes");
            int length = clsArr.length;
            String[] strArr = new String[length];
            int length2 = clsArr.length;
            for (int i4 = 0; i4 < length2; i4++) {
                strArr[i4] = clsArr[i4].getSimpleName();
            }
            return c((String[]) Arrays.copyOf(strArr, length));
        }

        public final String c(String... strArr) {
            m.e(strArr, "tags");
            StringBuilder sb = new StringBuilder("MATOMO:");
            int length = strArr.length;
            for (int i4 = 0; i4 < length; i4++) {
                sb.append(strArr[i4]);
                if (i4 < strArr.length - 1) {
                    sb.append(":");
                }
            }
            String sb2 = sb.toString();
            m.d(sb2, "toString(...)");
            return sb2;
        }

        private a() {
        }
    }

    public /* synthetic */ C2546b(Context context, C2103g gVar) {
        this(context);
    }

    public static final synchronized C2546b f(Context context) {
        C2546b a5;
        synchronized (C2546b.class) {
            a5 = f23786e.a(context);
        }
        return a5;
    }

    public static final String i(Class... clsArr) {
        return f23786e.b(clsArr);
    }

    public final Context c() {
        return this.f23789b;
    }

    public final C2571d d() {
        return new C2571d(this.f23789b, new C2572e(), new C2568a());
    }

    public final C2555f e() {
        return this.f23791d;
    }

    public final SharedPreferences g() {
        return this.f23790c;
    }

    public final SharedPreferences h(C2549e eVar) {
        SharedPreferences sharedPreferences;
        String str;
        m.e(eVar, "tracker");
        synchronized (this.f23788a) {
            sharedPreferences = (SharedPreferences) this.f23788a.get(eVar);
            if (sharedPreferences == null) {
                try {
                    str = "org.matomo.sdk_" + C2569b.b(eVar.d());
                } catch (Exception e5) {
                    C2611a.f24368a.d(e5);
                    str = "org.matomo.sdk_" + eVar.d();
                }
                sharedPreferences = this.f23789b.getSharedPreferences(str, 0);
                this.f23788a.put(eVar, sharedPreferences);
            }
        }
        return sharedPreferences;
    }

    private C2546b(Context context) {
        this.f23788a = new HashMap();
        this.f23791d = new C2551b();
        this.f23789b = context.getApplicationContext();
        this.f23790c = context.getSharedPreferences("org.matomo.sdk", 0);
    }
}
