package X3;

import W3.C2604a;
import W3.b;
import Z3.C2621j;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import com.inmobi.cmp.data.storage.SharedStorage;
import java.util.Locale;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.m;

public final class l implements k {

    /* renamed from: a  reason: collision with root package name */
    public final Locale f24270a;

    /* renamed from: b  reason: collision with root package name */
    public final C2604a f24271b;

    /* renamed from: c  reason: collision with root package name */
    public final SharedStorage f24272c;

    /* renamed from: d  reason: collision with root package name */
    public final b f24273d;

    /* renamed from: e  reason: collision with root package name */
    public final C2621j f24274e;

    /* renamed from: f  reason: collision with root package name */
    public final String f24275f = "google-basic-consent/v1/purposes-";

    public static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        public Object f24276a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f24277b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f24278c;

        /* renamed from: d  reason: collision with root package name */
        public int f24279d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(l lVar, V2.d dVar) {
            super(dVar);
            this.f24278c = lVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24277b = obj;
            this.f24279d |= Integer.MIN_VALUE;
            return this.f24278c.a(this);
        }
    }

    public l(Locale locale, C2604a aVar, SharedStorage sharedStorage, b bVar, C2621j jVar) {
        m.e(locale, "appLocale");
        m.e(aVar, "networkUtil");
        m.e(sharedStorage, "sharedStorage");
        m.e(bVar, "requestApi");
        m.e(jVar, "resolver");
        this.f24270a = locale;
        this.f24271b = aVar;
        this.f24272c = sharedStorage;
        this.f24273d = bVar;
        this.f24274e = jVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(V2.d r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof X3.l.a
            if (r0 == 0) goto L_0x0013
            r0 = r9
            X3.l$a r0 = (X3.l.a) r0
            int r1 = r0.f24279d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f24279d = r1
            goto L_0x0018
        L_0x0013:
            X3.l$a r0 = new X3.l$a
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f24277b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f24279d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f24276a
            X3.l r0 = (X3.l) r0
            R2.n.b(r9)     // Catch:{ a -> 0x006d }
            goto L_0x0052
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0035:
            R2.n.b(r9)
            W3.a r9 = r8.f24271b     // Catch:{ a -> 0x006c }
            boolean r9 = r9.a()     // Catch:{ a -> 0x006c }
            if (r9 == 0) goto L_0x0055
            W3.b r9 = r8.f24273d     // Catch:{ a -> 0x006c }
            java.lang.String r2 = r8.b()     // Catch:{ a -> 0x006c }
            r0.f24276a = r8     // Catch:{ a -> 0x006c }
            r0.f24279d = r3     // Catch:{ a -> 0x006c }
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
            com.inmobi.cmp.data.storage.SharedStorage r9 = r8.f24272c     // Catch:{ a -> 0x006c }
            a4.a r0 = a4.a.GOOGLE_BASIC_CONSENT     // Catch:{ a -> 0x006c }
            java.lang.String r9 = r9.j(r0)     // Catch:{ a -> 0x006c }
            r0 = r8
            goto L_0x0075
        L_0x006c:
            r0 = r8
        L_0x006d:
            com.inmobi.cmp.data.storage.SharedStorage r9 = r0.f24272c
            a4.a r1 = a4.a.GOOGLE_BASIC_CONSENT
            java.lang.String r9 = r9.j(r1)
        L_0x0075:
            com.inmobi.cmp.data.storage.SharedStorage r1 = r0.f24272c
            a4.a r2 = a4.a.GOOGLE_BASIC_CONSENT
            r1.e(r2, r9)
            Z3.j r0 = r0.f24274e
            java.lang.Object r9 = r0.a(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: X3.l.a(V2.d):java.lang.Object");
    }

    public final String b() {
        String j4 = this.f24272c.j(a4.a.PORTAL_CHOICE_LANG);
        m.e(j4, LeanbackPreferenceDialogFragment.ARG_KEY);
        int[] a5 = E2.b.a(26);
        int length = a5.length;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                j4 = this.f24270a.getLanguage();
                break;
            }
            int i5 = a5[i4];
            i4++;
            if (m3.m.p(z3.a.b(i5), j4, true) && !m3.m.p(j4, "autoDetectedLanguage", true)) {
                break;
            }
        }
        StringBuilder a6 = A2.a.a("https://cmp.inmobi.com/");
        a6.append(this.f24275f);
        m.d(j4, "language");
        String lowerCase = j4.toLowerCase(this.f24270a);
        m.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        a6.append(lowerCase);
        a6.append(".json");
        return a6.toString();
    }
}
