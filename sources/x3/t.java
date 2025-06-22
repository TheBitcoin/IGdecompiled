package X3;

import A3.g;
import E2.h;
import W3.C2604a;
import W3.b;
import Z3.C2621j;
import com.inmobi.cmp.data.storage.SharedStorage;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.Arrays;
import java.util.Locale;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.m;

public final class t implements s {

    /* renamed from: a  reason: collision with root package name */
    public final Locale f24324a;

    /* renamed from: b  reason: collision with root package name */
    public final C2604a f24325b;

    /* renamed from: c  reason: collision with root package name */
    public final b f24326c;

    /* renamed from: d  reason: collision with root package name */
    public final SharedStorage f24327d;

    /* renamed from: e  reason: collision with root package name */
    public final h f24328e;

    /* renamed from: f  reason: collision with root package name */
    public final g f24329f;

    /* renamed from: g  reason: collision with root package name */
    public final C2621j f24330g;

    /* renamed from: h  reason: collision with root package name */
    public final String f24331h = "us-mspa/v1/purposes-state-%s-";

    /* renamed from: i  reason: collision with root package name */
    public final String f24332i = "us-mspa/v1/purposes-national-";

    public static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        public Object f24333a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f24334b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ t f24335c;

        /* renamed from: d  reason: collision with root package name */
        public int f24336d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(t tVar, V2.d dVar) {
            super(dVar);
            this.f24335c = tVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24334b = obj;
            this.f24336d |= Integer.MIN_VALUE;
            return this.f24335c.a(this);
        }
    }

    public t(Locale locale, C2604a aVar, b bVar, SharedStorage sharedStorage, h hVar, g gVar, C2621j jVar) {
        m.e(locale, "appLocale");
        m.e(aVar, "networkUtil");
        m.e(bVar, "requestApi");
        m.e(sharedStorage, "sharedStorage");
        m.e(hVar, "jurisdiction");
        m.e(gVar, MRAIDCommunicatorUtil.KEY_STATE);
        m.e(jVar, "resolver");
        this.f24324a = locale;
        this.f24325b = aVar;
        this.f24326c = bVar;
        this.f24327d = sharedStorage;
        this.f24328e = hVar;
        this.f24329f = gVar;
        this.f24330g = jVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(V2.d r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof X3.t.a
            if (r0 == 0) goto L_0x0013
            r0 = r9
            X3.t$a r0 = (X3.t.a) r0
            int r1 = r0.f24336d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f24336d = r1
            goto L_0x0018
        L_0x0013:
            X3.t$a r0 = new X3.t$a
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f24334b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f24336d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f24333a
            X3.t r0 = (X3.t) r0
            R2.n.b(r9)     // Catch:{ a -> 0x006d }
            goto L_0x0052
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0035:
            R2.n.b(r9)
            W3.a r9 = r8.f24325b     // Catch:{ a -> 0x006c }
            boolean r9 = r9.a()     // Catch:{ a -> 0x006c }
            if (r9 == 0) goto L_0x0055
            W3.b r9 = r8.f24326c     // Catch:{ a -> 0x006c }
            java.lang.String r2 = r8.b()     // Catch:{ a -> 0x006c }
            r0.f24333a = r8     // Catch:{ a -> 0x006c }
            r0.f24336d = r3     // Catch:{ a -> 0x006c }
            java.lang.Object r9 = r9.a(r2, r0)     // Catch:{ a -> 0x006c }
            if (r9 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r0 = r8
        L_0x0052:
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ a -> 0x006d }
            goto L_0x0075
        L_0x0055:
            C2.b r1 = C2.b.f6277a     // Catch:{ a -> 0x006c }
            com.inmobi.cmp.model.ChoiceError r2 = com.inmobi.cmp.model.ChoiceError.NO_CONNECTION     // Catch:{ a -> 0x006c }
            r6 = 0
            r7 = 30
            r3 = 0
            r4 = 0
            r5 = 0
            C2.b.a(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ a -> 0x006c }
            com.inmobi.cmp.data.storage.SharedStorage r9 = r8.f24327d     // Catch:{ a -> 0x006c }
            a4.a r0 = a4.a.MSPA_PURPOSES     // Catch:{ a -> 0x006c }
            java.lang.String r9 = r9.j(r0)     // Catch:{ a -> 0x006c }
            r0 = r8
            goto L_0x0075
        L_0x006c:
            r0 = r8
        L_0x006d:
            com.inmobi.cmp.data.storage.SharedStorage r9 = r0.f24327d
            a4.a r1 = a4.a.MSPA_PURPOSES
            java.lang.String r9 = r9.j(r1)
        L_0x0075:
            com.inmobi.cmp.data.storage.SharedStorage r1 = r0.f24327d
            a4.a r2 = a4.a.MSPA_PURPOSES
            r1.e(r2, r9)
            Z3.j r0 = r0.f24330g
            java.lang.Object r9 = r0.a(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.t.a(V2.d):java.lang.Object");
    }

    public final String b() {
        String str;
        String str2;
        h hVar = this.f24328e;
        h hVar2 = h.STATE_AND_NATIONAL;
        if (hVar == hVar2) {
            g gVar = this.f24329f;
            m.e(gVar, MRAIDCommunicatorUtil.KEY_STATE);
            m.e(gVar, MRAIDCommunicatorUtil.KEY_STATE);
            int ordinal = gVar.ordinal();
            String str3 = DownloadCommon.DOWNLOAD_REPORT_CANCEL;
            if (ordinal == 0) {
                str2 = str3;
            } else if (ordinal == 1) {
                str2 = "co";
            } else if (ordinal == 2) {
                str2 = "ct";
            } else if (ordinal == 3) {
                str2 = "ut";
            } else if (ordinal != 4) {
                str2 = "";
            } else {
                str2 = "va";
            }
            if (str2.length() > 0) {
                A3.d dVar = A3.d.f51a;
                m.e(hVar2, "value");
                A3.d.f58h = hVar2;
                F f4 = F.f20971a;
                String str4 = this.f24331h;
                g gVar2 = this.f24329f;
                m.e(gVar2, MRAIDCommunicatorUtil.KEY_STATE);
                int ordinal2 = gVar2.ordinal();
                if (ordinal2 != 0) {
                    if (ordinal2 == 1) {
                        str3 = "co";
                    } else if (ordinal2 == 2) {
                        str3 = "ct";
                    } else if (ordinal2 == 3) {
                        str3 = "ut";
                    } else if (ordinal2 != 4) {
                        str3 = "";
                    } else {
                        str3 = "va";
                    }
                }
                str = String.format(str4, Arrays.copyOf(new Object[]{str3}, 1));
                m.d(str, "format(format, *args)");
                StringBuilder sb = new StringBuilder();
                sb.append("https://cmp.inmobi.com/");
                sb.append(str);
                String lowerCase = "EN".toLowerCase(this.f24324a);
                m.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                sb.append(lowerCase);
                sb.append(".json");
                return sb.toString();
            }
        }
        A3.d dVar2 = A3.d.f51a;
        h hVar3 = h.NATIONAL;
        m.e(hVar3, "value");
        A3.d.f58h = hVar3;
        str = this.f24332i;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("https://cmp.inmobi.com/");
        sb2.append(str);
        String lowerCase2 = "EN".toLowerCase(this.f24324a);
        m.d(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
        sb2.append(lowerCase2);
        sb2.append(".json");
        return sb2.toString();
    }
}
