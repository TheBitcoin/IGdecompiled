package G2;

import R2.l;
import R2.p;
import S2.H;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import java.util.Map;
import kotlin.jvm.internal.m;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f6592a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final Map f6593b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map f6594c;

    /* renamed from: d  reason: collision with root package name */
    public static final Map f6595d;

    static {
        l a5 = p.a(E2.c.CMPID, 12);
        l a6 = p.a(E2.c.CMPVERSION, 12);
        l a7 = p.a(E2.c.CONSENTLANGUAGE, 12);
        l a8 = p.a(E2.c.CONSENTSCREEN, 6);
        l a9 = p.a(E2.c.CREATED, 36);
        l a10 = p.a(E2.c.ISSERVICESPECIFIC, 1);
        l a11 = p.a(E2.c.LASTUPDATED, 36);
        l a12 = p.a(E2.c.POLICYVERSION, 6);
        l a13 = p.a(E2.c.PUBLISHERCOUNTRYCODE, 12);
        l a14 = p.a(E2.c.PUBLISHERLEGITIMATEINTERESTS, 24);
        l lVar = a5;
        l lVar2 = a14;
        f6593b = H.j(lVar, a6, a7, a8, a9, a10, a11, a12, a13, lVar2, p.a(E2.c.PUBLISHERCONSENTS, 24), p.a(E2.c.PUBLISHERRESTRICTIONS, 36), p.a(E2.c.PURPOSECONSENTS, 24), p.a(E2.c.PURPOSELEGITIMATEINTERESTS, 24), p.a(E2.c.PURPOSEONETREATMENT, 1), p.a(E2.c.SPECIALFEATUREOPTIONS, 12), p.a(E2.c.USENONSTANDARDSTACKS, 1), p.a(E2.c.VENDORCONSENTS, 24), p.a(E2.c.VENDORLEGITIMATEINTERESTS, 24), p.a(E2.c.VENDORLISTVERSION, 12), p.a(E2.c.VERSION, 6));
        l a15 = p.a(d.ANY_BOOLEAN, 1);
        l a16 = p.a(d.ENCODING_TYPE, 1);
        l a17 = p.a(d.MAX_ID, 16);
        l lVar3 = a15;
        l lVar4 = a17;
        f6594c = H.j(lVar3, a16, lVar4, p.a(d.NUM_CUSTOM_PURPOSES, 6), p.a(d.NUM_ENTRIES, 12), p.a(d.NUM_RESTRICTIONS, 12), p.a(d.PURPOSE_ID, 6), p.a(d.RESTRICTION_TYPE, 2), p.a(d.SEGMENT_TYPE, 3), p.a(d.SINGLE_OR_RANGE, 1), p.a(d.VENDOR_ID, 16));
        l a18 = p.a("cmpId", 12);
        l a19 = p.a("cmpVersion", 12);
        l a20 = p.a("consentLanguage", 12);
        l a21 = p.a("consentScreen", 6);
        l a22 = p.a("created", 36);
        l a23 = p.a("isServiceSpecific", 1);
        l a24 = p.a("lastUpdated", 36);
        l a25 = p.a("policyVersion", 6);
        l lVar5 = a18;
        l a26 = p.a("publisherCountryCode", 12);
        l a27 = p.a("publisherLegitimateInterests", 24);
        l a28 = p.a("publisherConsents", 24);
        l a29 = p.a("publisherRestrictions", 36);
        l a30 = p.a("purposeConsents", 24);
        l lVar6 = a29;
        l a31 = p.a("purposeLegitimateInterests", 24);
        l a32 = p.a("purposeOneTreatment", 1);
        l a33 = p.a("specialFeatureOptions", 12);
        l a34 = p.a("useNonStandardStacks", 1);
        l a35 = p.a("vendorListVersion", 12);
        l a36 = p.a("vendorConsents", 24);
        l a37 = p.a("vendorLegitimateInterests", 24);
        l lVar7 = a37;
        f6595d = H.j(lVar5, a19, a20, a21, a22, a23, a24, a25, a26, a27, a28, lVar6, a30, a31, a32, a33, a34, a35, a36, lVar7, p.a("version", 6), p.a("anyBoolean", 1), p.a("encodingType", 1), p.a("maxId", 16), p.a("numCustomPurposes", 6), p.a("numEntries", 12), p.a("numRestrictions", 12), p.a("purposeId", 6), p.a("restrictionType", 2), p.a("segmentType", 3), p.a("singleOrRange", 1), p.a("vendorId", 16));
    }

    public final Integer a(d dVar) {
        m.e(dVar, LeanbackPreferenceDialogFragment.ARG_KEY);
        return (Integer) f6594c.get(dVar);
    }

    public final Integer b(String str) {
        m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
        return (Integer) f6595d.get(str);
    }
}
