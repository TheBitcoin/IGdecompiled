package X3;

import E2.d;
import E2.l;
import E2.s;
import E2.v;
import G2.b;
import G2.f;
import S2.C1601o;
import U3.C2589b;
import android.os.Build;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.CmpStatus;
import com.inmobi.cmp.core.model.ACData;
import com.inmobi.cmp.core.model.GDPRData;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import com.inmobi.cmp.data.storage.SharedStorage;
import com.inmobi.cmp.model.NonIABData;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: X3.f  reason: case insensitive filesystem */
public final class C2610f implements C2609e {

    /* renamed from: a  reason: collision with root package name */
    public final SharedStorage f24253a;

    /* renamed from: b  reason: collision with root package name */
    public final s f24254b;

    /* renamed from: c  reason: collision with root package name */
    public final ChoiceCmpCallback f24255c;

    /* renamed from: d  reason: collision with root package name */
    public final f f24256d = new f(Boolean.TRUE, 2, C1601o.l(l.CORE));

    /* renamed from: X3.f$a */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f24257a;

        static {
            int[] iArr = new int[PrivacyEncodingMode.values().length];
            iArr[PrivacyEncodingMode.GPP.ordinal()] = 1;
            iArr[PrivacyEncodingMode.TCF.ordinal()] = 2;
            f24257a = iArr;
        }
    }

    public C2610f(SharedStorage sharedStorage, s sVar, ChoiceCmpCallback choiceCmpCallback) {
        m.e(sharedStorage, "sharedStorage");
        m.e(sVar, "tcModel");
        this.f24253a = sharedStorage;
        this.f24254b = sVar;
        this.f24255c = choiceCmpCallback;
    }

    public void a(PrivacyEncodingMode privacyEncodingMode, boolean z4) {
        ChoiceCmpCallback choiceCmpCallback;
        Object obj;
        boolean z5;
        PrivacyEncodingMode privacyEncodingMode2 = privacyEncodingMode;
        m.e(privacyEncodingMode2, "encodingMode");
        s sVar = this.f24254b;
        int i4 = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            ZonedDateTime now = ZonedDateTime.now(ZoneId.of("UTC"));
            ZonedDateTime of = ZonedDateTime.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth(), 0, 0, 0, 0, ZoneOffset.UTC);
            sVar.f6394d = of;
            long epochMilli = of.toInstant().toEpochMilli();
            sVar.f6392b = epochMilli;
            sVar.f6393c = epochMilli;
        } else {
            Calendar instance = Calendar.getInstance();
            instance.setTime(new Date());
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            long timeInMillis = instance.getTimeInMillis();
            sVar.f6392b = timeInMillis;
            sVar.f6393c = timeInMillis;
        }
        int i5 = a.f24257a[privacyEncodingMode2.ordinal()];
        if (i5 == 1) {
            b();
        } else if (i5 != 2) {
            b();
            c();
        } else {
            c();
        }
        SharedStorage sharedStorage = this.f24253a;
        a4.a aVar = a4.a.NON_IAB_CONSENT_ENCODED;
        s sVar2 = this.f24254b;
        long j4 = sVar2.f6392b;
        long j5 = sVar2.f6393c;
        int i6 = sVar2.f6403m;
        int i7 = sVar2.f6404n;
        int maxId = sVar2.f6384A.getMaxId();
        Set<Integer> acceptedItems = sVar2.f6384A.getAcceptedItems();
        m.e(acceptedItems, "vendorConsents");
        StringBuilder sb = new StringBuilder();
        String l4 = Long.toString(j4, m3.a.a(2));
        m.d(l4, "toString(this, checkRadix(radix))");
        sb.append(l4);
        String l5 = Long.toString(j5, m3.a.a(2));
        m.d(l5, "toString(this, checkRadix(radix))");
        sb.append(l5);
        String num = Integer.toString(i6, m3.a.a(2));
        m.d(num, "toString(this, checkRadix(radix))");
        sb.append(num);
        String num2 = Integer.toString(i7, m3.a.a(2));
        m.d(num2, "toString(this, checkRadix(radix))");
        sb.append(num2);
        String num3 = Integer.toString(maxId, m3.a.a(2));
        m.d(num3, "toString(this, checkRadix(radix))");
        sb.append(num3);
        String str = "";
        if (!acceptedItems.isEmpty()) {
            for (Number intValue : acceptedItems) {
                String num4 = Integer.toString(intValue.intValue(), m3.a.a(2));
                m.d(num4, "toString(this, checkRadix(radix))");
                while (true) {
                    int length = num4.length();
                    String num5 = Integer.toString(maxId, m3.a.a(2));
                    m.d(num5, "toString(this, checkRadix(radix))");
                    if (length >= num5.length()) {
                        break;
                    }
                    num4 = m.m("0", num4);
                }
                str = m.m(str, num4);
            }
        }
        sb.append(str);
        sharedStorage.e(aVar, G2.a.f6588a.b(sb.toString()));
        if (z4) {
            ChoiceCmpCallback choiceCmpCallback2 = this.f24255c;
            if (choiceCmpCallback2 != null) {
                GDPRData gDPRData = new GDPRData((Set) null, 1, (C2103g) null);
                gDPRData.setCmpStatus(CmpStatus.LOADED);
                choiceCmpCallback2.onIABVendorConsentGiven(gDPRData);
            }
            ChoiceCmpCallback choiceCmpCallback3 = this.f24255c;
            if (choiceCmpCallback3 != null) {
                if (this.f24253a.i(a4.a.TCF_GDPR_APPLIES) == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                choiceCmpCallback3.onNonIABVendorConsentGiven(new NonIABData(z5, false, false, this.f24253a.j(a4.a.NON_IAB_CONSENT_ENCODED), this.f24254b.f6384A.getMap()));
            }
            if (this.f24253a.h(a4.a.GOOGLE_ENABLED) && (choiceCmpCallback = this.f24255c) != null) {
                Set<Integer> acceptedItems2 = this.f24254b.f6385B.getAcceptedItems();
                m.e(acceptedItems2, "vendorsID");
                String str2 = "1~";
                for (T next : acceptedItems2) {
                    int i8 = i4 + 1;
                    if (i4 < 0) {
                        C1601o.o();
                    }
                    int intValue2 = ((Number) next).intValue();
                    if (i4 != 0) {
                        obj = m.m(".", Integer.valueOf(intValue2));
                    } else {
                        obj = Integer.valueOf(intValue2);
                    }
                    str2 = m.m(str2, obj);
                    i4 = i8;
                }
                choiceCmpCallback.onGoogleVendorConsentGiven(new ACData(str2));
            }
        }
    }

    public final void b() {
        Object obj;
        s sVar = this.f24254b;
        SharedStorage sharedStorage = this.f24253a;
        String a5 = d.f6347a.a(sVar);
        b bVar = b.f6590a;
        String a6 = bVar.a(sVar.f6384A);
        String b5 = C2589b.b(sVar.f6384A.toString());
        String a7 = bVar.a(sVar.f6387D);
        Set<Integer> acceptedItems = sVar.f6385B.getAcceptedItems();
        m.e(acceptedItems, "vendorsID");
        String str = "1~";
        int i4 = 0;
        for (T next : acceptedItems) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                C1601o.o();
            }
            int intValue = ((Number) next).intValue();
            if (i4 != 0) {
                obj = m.m(".", Integer.valueOf(intValue));
            } else {
                obj = Integer.valueOf(intValue);
            }
            str = m.m(str, obj);
            i4 = i5;
        }
        String a8 = bVar.a(sVar.f6416z);
        String a9 = bVar.a(sVar.f6386C);
        String a10 = bVar.a(sVar.f6408r);
        String a11 = bVar.a(sVar.f6409s);
        String a12 = bVar.a(sVar.f6407q);
        String obj2 = sVar.f6390G.f6363c.toString();
        String a13 = bVar.a(sVar.f6412v);
        String a14 = bVar.a(sVar.f6413w);
        SharedStorage sharedStorage2 = sharedStorage;
        String a15 = bVar.a(sVar.f6414x);
        String a16 = bVar.a(sVar.f6415y);
        sharedStorage2.getClass();
        m.e(a5, "gppString");
        m.e(a6, "nonIabVendorConsents");
        m.e(b5, "nonIabVendorConsentsEncoded");
        m.e(a7, "nonIabVendorLegitimateInterests");
        m.e(str, "googleVendorConsents");
        m.e(a8, "iabVendorConsents");
        m.e(a9, "vendorLegitimateInterests");
        m.e(a10, "purposeConsents");
        m.e(a11, "purposeLegitimateInterests");
        m.e(a12, "specialFeatureOptions");
        m.e(obj2, "publisherRestrictions");
        m.e(a13, "publisherConsents");
        m.e(a14, "publisherLegitimateInterests");
        m.e(a15, "publisherCustomConsents");
        m.e(a16, "publisherCustomLegitimateInterests");
        String str2 = b5;
        SharedStorage sharedStorage3 = sharedStorage2;
        sharedStorage3.e(a4.a.NON_IAB_VENDOR_CONSENTS, a6);
        a4.a aVar = a4.a.NON_IAB_VENDOR_CONSENT_HASH;
        sharedStorage3.e(aVar, C2589b.b(str2));
        sharedStorage3.e(a4.a.NON_IAB_VENDOR_LEG_INTERESTS, a7);
        sharedStorage3.e(a4.a.OPTION_HASH, m.m(sharedStorage3.j(aVar), sharedStorage3.j(a4.a.PORTAL_CONFIG_HASH)));
        sharedStorage3.e(a4.a.ADDTL_CONSENT, str);
        sharedStorage3.e(a4.a.GPP_STRING, a5);
        sharedStorage3.e(a4.a.GPP_VENDOR_CONSENTS, a8);
        sharedStorage3.e(a4.a.GPP_VENDOR_LEGITIMATE_INTERESTS, a9);
        sharedStorage3.e(a4.a.GPP_PURPOSE_CONSENTS, a10);
        sharedStorage3.e(a4.a.GPP_PURPOSE_LEGITIMATE_INTERESTS, a11);
        sharedStorage3.e(a4.a.GPP_SPECIAL_FEATURES_OPT_INS, a12);
        sharedStorage3.e(a4.a.GPP_PUBLISHER_RESTRICTIONS, obj2);
        sharedStorage3.e(a4.a.GPP_PUBLISHER_CONSENT, a13);
        sharedStorage3.e(a4.a.GPP_PUBLISHER_LEGITIMATE_INTERESTS, a14);
        sharedStorage3.e(a4.a.GPP_PUBLISHER_CUSTOM_PURPOSES_CONSENTS, a15);
        sharedStorage3.e(a4.a.GPP_PUBLISHER_CUSTOM_PURPOSES_LEGITIMATE_INTERESTS, a16);
    }

    public final void c() {
        Object obj;
        s sVar = this.f24254b;
        SharedStorage sharedStorage = this.f24253a;
        String a5 = v.f6420a.a(sVar, this.f24256d);
        b bVar = b.f6590a;
        String a6 = bVar.a(sVar.f6384A);
        String b5 = C2589b.b(sVar.f6384A.toString());
        String a7 = bVar.a(sVar.f6387D);
        Set<Integer> acceptedItems = sVar.f6385B.getAcceptedItems();
        m.e(acceptedItems, "vendorsID");
        String str = "1~";
        int i4 = 0;
        for (T next : acceptedItems) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                C1601o.o();
            }
            int intValue = ((Number) next).intValue();
            if (i4 != 0) {
                obj = m.m(".", Integer.valueOf(intValue));
            } else {
                obj = Integer.valueOf(intValue);
            }
            str = m.m(str, obj);
            i4 = i5;
        }
        String a8 = bVar.a(sVar.f6416z);
        String a9 = bVar.a(sVar.f6386C);
        String a10 = bVar.a(sVar.f6408r);
        String a11 = bVar.a(sVar.f6409s);
        String a12 = bVar.a(sVar.f6407q);
        String obj2 = sVar.f6390G.f6363c.toString();
        String a13 = bVar.a(sVar.f6412v);
        String a14 = bVar.a(sVar.f6413w);
        SharedStorage sharedStorage2 = sharedStorage;
        String a15 = bVar.a(sVar.f6414x);
        String a16 = bVar.a(sVar.f6415y);
        sharedStorage2.getClass();
        m.e(a5, "tcString");
        m.e(a6, "nonIabVendorConsents");
        m.e(b5, "nonIabVendorConsentsEncoded");
        m.e(a7, "nonIabVendorLegitimateInterests");
        m.e(str, "googleVendorConsents");
        m.e(a8, "iabVendorConsents");
        m.e(a9, "vendorLegitimateInterests");
        m.e(a10, "purposeConsents");
        m.e(a11, "purposeLegitimateInterests");
        m.e(a12, "specialFeatureOptions");
        m.e(obj2, "publisherRestrictions");
        m.e(a13, "publisherConsents");
        m.e(a14, "publisherLegitimateInterests");
        m.e(a15, "publisherCustomConsents");
        m.e(a16, "publisherCustomLegitimateInterests");
        String str2 = b5;
        SharedStorage sharedStorage3 = sharedStorage2;
        sharedStorage3.e(a4.a.TC_STRING, a5);
        sharedStorage3.e(a4.a.NON_IAB_VENDOR_CONSENTS, a6);
        a4.a aVar = a4.a.NON_IAB_VENDOR_CONSENT_HASH;
        sharedStorage3.e(aVar, C2589b.b(str2));
        sharedStorage3.e(a4.a.NON_IAB_VENDOR_LEG_INTERESTS, a7);
        sharedStorage3.e(a4.a.OPTION_HASH, m.m(sharedStorage3.j(aVar), sharedStorage3.j(a4.a.PORTAL_CONFIG_HASH)));
        sharedStorage3.e(a4.a.ADDTL_CONSENT, str);
        sharedStorage3.e(a4.a.TCF_VENDOR_CONSENTS, a8);
        sharedStorage3.e(a4.a.TCF_VENDOR_LEGITIMATE_INTERESTS, a9);
        sharedStorage3.e(a4.a.TCF_PURPOSE_CONSENTS, a10);
        sharedStorage3.e(a4.a.TCF_PURPOSE_LEGITIMATE_INTERESTS, a11);
        sharedStorage3.e(a4.a.TCF_SPECIAL_FEATURES_OPT_INS, a12);
        sharedStorage3.e(a4.a.TCF_PUBLISHER_RESTRICTIONS, obj2);
        sharedStorage3.e(a4.a.TCF_PUBLISHER_CONSENT, a13);
        sharedStorage3.e(a4.a.TCF_PUBLISHER_LEGITIMATE_INTERESTS, a14);
        sharedStorage3.e(a4.a.TCF_PUBLISHER_CUSTOM_PURPOSES_CONSENTS, a15);
        sharedStorage3.e(a4.a.TCF_PUBLISHER_CUSTOM_PURPOSES_LEGITIMATE_INTERESTS, a16);
    }
}
