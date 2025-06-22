package I2;

import E2.c;
import R2.l;
import R2.p;
import S2.H;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f6692a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final Map f6693b;

    static {
        l a5 = p.a(c.VERSION, "IntEncoder");
        l a6 = p.a(c.CREATED, "DateEncoder");
        l a7 = p.a(c.LASTUPDATED, "DateEncoder");
        l a8 = p.a(c.CMPID, "IntEncoder");
        l a9 = p.a(c.CMPVERSION, "IntEncoder");
        l lVar = a6;
        l lVar2 = a9;
        H.j(a5, lVar, a7, a8, lVar2, p.a(c.CONSENTSCREEN, "IntEncoder"), p.a(c.CONSENTLANGUAGE, "LangEncoder"), p.a(c.VENDORLISTVERSION, "IntEncoder"), p.a(c.POLICYVERSION, "IntEncoder"), p.a(c.ISSERVICESPECIFIC, "BooleanEncoder"), p.a(c.USENONSTANDARDSTACKS, "BooleanEncoder"), p.a(c.SPECIALFEATUREOPTIONS, "FixedVectorEncoder"), p.a(c.PURPOSECONSENTS, "FixedVectorEncoder"), p.a(c.PURPOSELEGITIMATEINTERESTS, "FixedVectorEncoder"), p.a(c.PURPOSEONETREATMENT, "BooleanEncoder"), p.a(c.PUBLISHERCOUNTRYCODE, "LangEncoder"), p.a(c.VENDORCONSENTS, "VendorVectorEncoder"), p.a(c.VENDORLEGITIMATEINTERESTS, "VendorVectorEncoder"), p.a(c.PUBLISHERRESTRICTIONS, "PurposeRestrictionVectorEncoder"), p.a(c.VENDORSDISCLOSED, "VendorVectorEncoder"), p.a(c.VENDORSALLOWED, "VendorVectorEncoder"), p.a(c.PUBLISHERCONSENTS, "FixedVectorEncoder"), p.a(c.PUBLISHERLEGITIMATEINTERESTS, "FixedVectorEncoder"), p.a(c.NUMCUSTOMPURPOSES, "IntEncoder"), p.a(c.PUBLISHERCUSTOMCONSENTS, "FixedVectorEncoder"), p.a(c.PUBLISHERCUSTOMLEGITIMATEINTERESTS, "FixedVectorEncoder"));
        l a10 = p.a("version", "IntEncoder");
        l a11 = p.a("created", "DateEncoder");
        l a12 = p.a("lastUpdated", "DateEncoder");
        l a13 = p.a("cmpId", "IntEncoder");
        l a14 = p.a("cmpVersion", "IntEncoder");
        l a15 = p.a("consentScreen", "IntEncoder");
        l a16 = p.a("consentLanguage", "LangEncoder");
        l a17 = p.a("vendorListVersion", "IntEncoder");
        l a18 = p.a("policyVersion", "IntEncoder");
        l a19 = p.a("isServiceSpecific", "BooleanEncoder");
        l lVar3 = a11;
        l a20 = p.a("useNonStandardStacks", "BooleanEncoder");
        l a21 = p.a("specialFeatureOptions", "FixedVectorEncoder");
        l a22 = p.a("purposeConsents", "FixedVectorEncoder");
        l a23 = p.a("purposeLegitimateInterests", "FixedVectorEncoder");
        l a24 = p.a("purposeOneTreatment", "BooleanEncoder");
        l a25 = p.a("publisherCountryCode", "LangEncoder");
        l a26 = p.a("vendorConsents", "VendorVectorEncoder");
        l lVar4 = a24;
        l a27 = p.a("vendorLegitimateInterests", "VendorVectorEncoder");
        l a28 = p.a("publisherRestrictions", "PurposeRestrictionVectorEncoder");
        l a29 = p.a("segmentType", "IntEncoder");
        l lVar5 = a28;
        l a30 = p.a("vendorsDisclosed", "VendorVectorEncoder");
        l a31 = p.a("vendorsAllowed", "VendorVectorEncoder");
        l a32 = p.a("publisherConsents", "FixedVectorEncoder");
        l a33 = p.a("publisherLegitimateInterests", "FixedVectorEncoder");
        l a34 = p.a("numCustomPurposes", "IntEncoder");
        l lVar6 = a34;
        f6693b = H.j(a10, lVar3, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, lVar4, a25, a26, a27, lVar5, a29, a30, a31, a32, a33, lVar6, p.a("publisherCustomConsents", "FixedVectorEncoder"), p.a("publisherCustomLegitimateInterests", "FixedVectorEncoder"));
    }
}
