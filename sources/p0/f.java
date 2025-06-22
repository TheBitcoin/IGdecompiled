package P0;

import P0.j;
import R0.b;
import Z0.i;
import android.content.Context;
import android.util.Base64OutputStream;
import androidx.core.os.UserManagerCompat;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import k0.C0937l;
import k0.C0940o;
import org.json.JSONArray;
import org.json.JSONObject;
import p0.C2194f;
import r0.C2213a;
import s0.C2264F;
import s0.C2268c;
import s0.C2270e;
import s0.r;

public class f implements i, j {

    /* renamed from: a  reason: collision with root package name */
    private final b f7975a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f7976b;

    /* renamed from: c  reason: collision with root package name */
    private final b f7977c;

    /* renamed from: d  reason: collision with root package name */
    private final Set f7978d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f7979e;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private f(android.content.Context r7, java.lang.String r8, java.util.Set r9, R0.b r10, java.util.concurrent.Executor r11) {
        /*
            r6 = this;
            P0.c r1 = new P0.c
            r1.<init>(r7, r8)
            r0 = r6
            r5 = r7
            r2 = r9
            r4 = r10
            r3 = r11
            r0.<init>((R0.b) r1, (java.util.Set) r2, (java.util.concurrent.Executor) r3, (R0.b) r4, (android.content.Context) r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: P0.f.<init>(android.content.Context, java.lang.String, java.util.Set, R0.b, java.util.concurrent.Executor):void");
    }

    public static /* synthetic */ String c(f fVar) {
        Base64OutputStream base64OutputStream;
        GZIPOutputStream gZIPOutputStream;
        String byteArrayOutputStream;
        synchronized (fVar) {
            try {
                k kVar = (k) fVar.f7975a.get();
                List c5 = kVar.c();
                kVar.b();
                JSONArray jSONArray = new JSONArray();
                for (int i4 = 0; i4 < c5.size(); i4++) {
                    l lVar = (l) c5.get(i4);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", lVar.c());
                    jSONObject.put("dates", new JSONArray(lVar.b()));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put("version", "2");
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                base64OutputStream = new Base64OutputStream(byteArrayOutputStream2, 11);
                gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                gZIPOutputStream.write(jSONObject2.toString().getBytes(C.UTF8_NAME));
                gZIPOutputStream.close();
                base64OutputStream.close();
                byteArrayOutputStream = byteArrayOutputStream2.toString(C.UTF8_NAME);
            } catch (Throwable th) {
                throw th;
            }
        }
        return byteArrayOutputStream;
        throw th;
        throw th;
    }

    public static /* synthetic */ k d(Context context, String str) {
        return new k(context, str);
    }

    public static /* synthetic */ f e(C2264F f4, C2270e eVar) {
        return new f((Context) eVar.a(Context.class), ((C2194f) eVar.a(C2194f.class)).o(), eVar.e(g.class), eVar.d(i.class), (Executor) eVar.h(f4));
    }

    public static /* synthetic */ Void f(f fVar) {
        synchronized (fVar) {
            ((k) fVar.f7975a.get()).k(System.currentTimeMillis(), ((i) fVar.f7977c.get()).a());
        }
        return null;
    }

    public static C2268c g() {
        C2264F a5 = C2264F.a(C2213a.class, Executor.class);
        return C2268c.d(f.class, i.class, j.class).b(r.k(Context.class)).b(r.k(C2194f.class)).b(r.o(g.class)).b(r.m(i.class)).b(r.l(a5)).f(new b(a5)).d();
    }

    public C0937l a() {
        if (!UserManagerCompat.isUserUnlocked(this.f7976b)) {
            return C0940o.e("");
        }
        return C0940o.c(this.f7979e, new d(this));
    }

    public synchronized j.a b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        k kVar = (k) this.f7975a.get();
        if (kVar.i(currentTimeMillis)) {
            kVar.g();
            return j.a.GLOBAL;
        }
        return j.a.NONE;
    }

    public C0937l h() {
        if (this.f7978d.size() <= 0) {
            return C0940o.e((Object) null);
        }
        if (!UserManagerCompat.isUserUnlocked(this.f7976b)) {
            return C0940o.e((Object) null);
        }
        return C0940o.c(this.f7979e, new e(this));
    }

    f(b bVar, Set set, Executor executor, b bVar2, Context context) {
        this.f7975a = bVar;
        this.f7978d = set;
        this.f7979e = executor;
        this.f7977c = bVar2;
        this.f7976b = context;
    }
}
