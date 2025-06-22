package J2;

import C3.f;
import E2.e;
import E2.s;
import M2.c;
import V3.C2596g;
import X3.C2609e;
import X3.i;
import X3.u;
import androidx.lifecycle.ViewModel;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import kotlin.jvm.internal.m;

public final class l extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final s f7267a;

    /* renamed from: b  reason: collision with root package name */
    public final f f7268b;

    /* renamed from: c  reason: collision with root package name */
    public final e f7269c;

    /* renamed from: d  reason: collision with root package name */
    public final z3.l f7270d;

    /* renamed from: e  reason: collision with root package name */
    public final u f7271e;

    /* renamed from: f  reason: collision with root package name */
    public final C2609e f7272f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f7273g;

    /* renamed from: h  reason: collision with root package name */
    public final C2596g f7274h;

    /* renamed from: i  reason: collision with root package name */
    public final c f7275i;

    /* renamed from: j  reason: collision with root package name */
    public final i f7276j;

    public l(s sVar, f fVar, e eVar, z3.l lVar, u uVar, C2609e eVar2, boolean z4, C2596g gVar, c cVar, i iVar) {
        m.e(sVar, "tcModel");
        m.e(fVar, "portalConfig");
        m.e(eVar, "googleVendorList");
        m.e(uVar, "portalConfigRepository");
        m.e(eVar2, "consentRepository");
        m.e(gVar, "initScreen");
        m.e(cVar, "gbcPurposeResponse");
        m.e(iVar, "gbcConsentRepository");
        this.f7267a = sVar;
        this.f7268b = fVar;
        this.f7269c = eVar;
        this.f7270d = lVar;
        this.f7271e = uVar;
        this.f7272f = eVar2;
        this.f7273g = z4;
        this.f7274h = gVar;
        this.f7275i = cVar;
        this.f7276j = iVar;
    }

    public final void a() {
        String str = this.f7268b.f170b.f117I;
        if (str != null) {
            PrivacyEncodingMode privacyEncodingMode = PrivacyEncodingMode.GPP;
            if (str.equals(privacyEncodingMode.getValue())) {
                this.f7272f.a(privacyEncodingMode, true);
                return;
            }
        }
        String str2 = this.f7268b.f170b.f117I;
        if (str2 != null) {
            PrivacyEncodingMode privacyEncodingMode2 = PrivacyEncodingMode.TCF;
            if (str2.equals(privacyEncodingMode2.getValue())) {
                this.f7272f.a(privacyEncodingMode2, true);
                return;
            }
        }
        this.f7272f.a(PrivacyEncodingMode.TCF_AND_GPP, true);
    }
}
