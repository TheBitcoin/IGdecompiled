package b2;

import R2.n;
import R2.s;
import V2.d;
import V2.g;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import d3.p;
import f2.C2007F;
import g2.C2048f;
import g2.C2050h;
import g2.L;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.J;
import o3.Y;
import org.json.JSONObject;
import u2.t;
import u2.x;

public final class w {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f9587a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2050h f9588b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C2048f f9589c;

    /* renamed from: d  reason: collision with root package name */
    private C2007F f9590d;

    /* renamed from: e  reason: collision with root package name */
    private J f9591e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f9592f;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9593a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w f9594b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(w wVar, d dVar) {
            super(2, dVar);
            this.f9594b = wVar;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f9594b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f9593a;
            if (i4 == 0) {
                n.b(obj);
                w wVar = this.f9594b;
                this.f9593a = 1;
                if (wVar.m(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f9595a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w f9596b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(w wVar, d dVar) {
            super(2, dVar);
            this.f9596b = wVar;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f9596b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f9595a == 0) {
                n.b(obj);
                if (this.f9596b.f9589c != null) {
                    C2048f b5 = this.f9596b.f9589c;
                    m.b(b5);
                    if (b5.z() == null) {
                        w wVar = this.f9596b;
                        Context e5 = wVar.f9587a;
                        C2048f b6 = this.f9596b.f9589c;
                        m.b(b6);
                        String o4 = b6.o();
                        m.b(o4);
                        C2048f b7 = this.f9596b.f9589c;
                        m.b(b7);
                        String k4 = b7.k();
                        m.b(k4);
                        wVar.f9592f = wVar.i(e5, o4, k4);
                        C2048f b8 = this.f9596b.f9589c;
                        m.b(b8);
                        b8.g0(this.f9596b.f9592f);
                        t a5 = t.f21927u.a(this.f9596b.f9587a);
                        a5.a();
                        C2048f b9 = this.f9596b.f9589c;
                        m.b(b9);
                        a5.r1(b9);
                        a5.i();
                    } else {
                        w wVar2 = this.f9596b;
                        C2048f b10 = wVar2.f9589c;
                        m.b(b10);
                        wVar2.f9592f = b10.z();
                    }
                } else if (this.f9596b.f9588b != null) {
                    C2050h c5 = this.f9596b.f9588b;
                    m.b(c5);
                    if (c5.t0() == null) {
                        w wVar3 = this.f9596b;
                        Context e6 = wVar3.f9587a;
                        C2050h c6 = this.f9596b.f9588b;
                        m.b(c6);
                        String Q4 = c6.Q();
                        m.b(Q4);
                        C2050h c7 = this.f9596b.f9588b;
                        m.b(c7);
                        String J4 = c7.J();
                        m.b(J4);
                        wVar3.f9592f = wVar3.i(e6, Q4, J4);
                    } else {
                        w wVar4 = this.f9596b;
                        C2050h c8 = wVar4.f9588b;
                        m.b(c8);
                        wVar4.f9592f = c8.t0();
                    }
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public w(Context context, C2050h hVar, C2048f fVar, C2007F f4, J j4) {
        m.e(context, "context");
        m.e(j4, "scope");
        this.f9587a = context;
        this.f9588b = hVar;
        this.f9589c = fVar;
        this.f9590d = f4;
        this.f9591e = j4;
        k();
    }

    /* access modifiers changed from: private */
    public final String i(Context context, String str, String str2) {
        int i4;
        L r02 = new u2.L(context).r0(str, str2);
        if (r02.e() == null) {
            return null;
        }
        JSONObject e5 = r02.e();
        m.b(e5);
        if (!e5.isNull("success")) {
            i4 = e5.optInt("success");
        } else {
            i4 = 0;
        }
        JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
        if (i4 != 1 || optJSONObject == null || optJSONObject.isNull("app_url")) {
            return null;
        }
        return optJSONObject.optString("app_url");
    }

    private final void j(String str, String str2, String str3) {
        if (str3 != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.addFlags(524288);
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", this.f9587a.getString(R.string.share_app_details_msg, new Object[]{str}));
            intent.putExtra("android.intent.extra.TEXT", str3);
            Context context = this.f9587a;
            context.startActivity(Intent.createChooser(intent, context.getString(R.string.option_button_share)));
            Bundle bundle = new Bundle();
            bundle.putString("packagename", str2);
            new x(this.f9587a).d("share_app", bundle);
            return;
        }
        C2007F f4 = this.f9590d;
        if (f4 != null) {
            f4.a(str);
        }
    }

    private final void k() {
        C0981i.d(this.f9591e, (g) null, (o3.L) null, new a(this, (d) null), 3, (Object) null).i(new v(this));
    }

    /* access modifiers changed from: private */
    public static final s l(w wVar, Throwable th) {
        C2048f fVar = wVar.f9589c;
        if (fVar != null) {
            m.b(fVar);
            String m4 = fVar.m();
            m.b(m4);
            C2048f fVar2 = wVar.f9589c;
            m.b(fVar2);
            String o4 = fVar2.o();
            m.b(o4);
            wVar.j(m4, o4, wVar.f9592f);
        } else {
            C2050h hVar = wVar.f9588b;
            if (hVar != null) {
                m.b(hVar);
                String L4 = hVar.L();
                m.b(L4);
                C2050h hVar2 = wVar.f9588b;
                m.b(hVar2);
                String Q4 = hVar2.Q();
                m.b(Q4);
                wVar.j(L4, Q4, wVar.f9592f);
            }
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object m(d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }
}
