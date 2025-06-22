package com.inmobi.cmp.core.model;

import E2.i;
import E2.j;
import E2.k;
import E2.l;
import E2.s;
import E2.v;
import G2.f;
import S2.C1601o;
import androidx.annotation.Keep;
import b4.d;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.core.cmpapi.map.ConsentMap;
import com.inmobi.cmp.core.cmpapi.map.OutOfBandMap;
import com.inmobi.cmp.core.cmpapi.map.PublisherMap;
import com.inmobi.cmp.core.cmpapi.status.CmpStatus;
import com.inmobi.cmp.core.cmpapi.status.EventStatus;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import m.C0956a;

@Keep
public final class GDPRData {
    private Integer cmpId;
    private CmpStatus cmpStatus;
    private Integer cmpVersion;
    private EventStatus eventStatus;
    private Boolean gdprApplies;
    private String gppString;
    private boolean isServiceSpecific;
    private final OutOfBandMap outOfBand;
    private PrivacyEncodingMode privacyEncodingMode;
    private final PublisherMap publisher;
    private String publisherCC;
    private final ConsentMap purpose;
    private boolean purposeOneTreatment;
    private Map<String, Boolean> specialFeaturesOptions;
    private String tcString;
    private final int tcfPolicyVersion;
    private boolean useNonStandardStacks;
    private final ConsentMap vendor;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11779a;

        static {
            int[] iArr = new int[PrivacyEncodingMode.values().length];
            iArr[PrivacyEncodingMode.TCF.ordinal()] = 1;
            iArr[PrivacyEncodingMode.GPP.ordinal()] = 2;
            f11779a = iArr;
        }
    }

    public GDPRData() {
        this((Set) null, 1, (C2103g) null);
    }

    private final Map<String, Map<String, k>> createRestrictions(j jVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (jVar.a() > 0) {
            int a5 = jVar.a();
            int i4 = 1;
            if (1 <= a5) {
                while (true) {
                    int i5 = i4 + 1;
                    for (i iVar : jVar.b(Integer.valueOf(i4))) {
                        if (!linkedHashMap.containsKey(String.valueOf(iVar.f6359a))) {
                            linkedHashMap.put(String.valueOf(iVar.f6359a), new LinkedHashMap());
                        }
                        Map map = (Map) linkedHashMap.get(String.valueOf(iVar.f6359a));
                        if (map != null) {
                            k kVar = (k) map.put(String.valueOf(i4), iVar.f6360b);
                        }
                    }
                    if (i4 == a5) {
                        break;
                    }
                    i4 = i5;
                }
            }
        }
        return linkedHashMap;
    }

    private final int getPublisherVendorId() {
        Vector vector;
        s sVar = C0956a.f3562c;
        if (sVar == null || (vector = sVar.f6410t) == null || vector.isEmpty()) {
            return -1;
        }
        return ((Number) C1601o.G(vector.getKeys())).intValue();
    }

    public final Integer getCmpId() {
        return this.cmpId;
    }

    public final CmpStatus getCmpStatus() {
        return this.cmpStatus;
    }

    public final Integer getCmpVersion() {
        return this.cmpVersion;
    }

    public final EventStatus getEventStatus() {
        return this.eventStatus;
    }

    public final Boolean getGdprApplies() {
        return this.gdprApplies;
    }

    public final String getGppString() {
        return this.gppString;
    }

    public final OutOfBandMap getOutOfBand() {
        return this.outOfBand;
    }

    public final PrivacyEncodingMode getPrivacyEncodingMode() {
        return this.privacyEncodingMode;
    }

    public final PublisherMap getPublisher() {
        return this.publisher;
    }

    public final String getPublisherCC() {
        return this.publisherCC;
    }

    public final ConsentMap getPurpose() {
        return this.purpose;
    }

    public final boolean getPurposeOneTreatment() {
        return this.purposeOneTreatment;
    }

    public final Map<String, Boolean> getSpecialFeaturesOptions() {
        return this.specialFeaturesOptions;
    }

    public final String getTcString() {
        return this.tcString;
    }

    public final int getTcfPolicyVersion() {
        return this.tcfPolicyVersion;
    }

    public final boolean getUseNonStandardStacks() {
        return this.useNonStandardStacks;
    }

    public final ConsentMap getVendor() {
        return this.vendor;
    }

    public final boolean isServiceSpecific() {
        return this.isServiceSpecific;
    }

    public final void setCmpId(Integer num) {
        this.cmpId = num;
    }

    public final void setCmpStatus(CmpStatus cmpStatus2) {
        m.e(cmpStatus2, "<set-?>");
        this.cmpStatus = cmpStatus2;
    }

    public final void setCmpVersion(Integer num) {
        this.cmpVersion = num;
    }

    public final void setEventStatus(EventStatus eventStatus2) {
        this.eventStatus = eventStatus2;
    }

    public final void setGdprApplies(Boolean bool) {
        this.gdprApplies = bool;
    }

    public final void setGppString(String str) {
        this.gppString = str;
    }

    public final void setPrivacyEncodingMode(PrivacyEncodingMode privacyEncodingMode2) {
        this.privacyEncodingMode = privacyEncodingMode2;
    }

    public final void setPublisherCC(String str) {
        this.publisherCC = str;
    }

    public final void setPurposeOneTreatment(boolean z4) {
        this.purposeOneTreatment = z4;
    }

    public final void setServiceSpecific(boolean z4) {
        this.isServiceSpecific = z4;
    }

    public final void setSpecialFeaturesOptions(Map<String, Boolean> map) {
        m.e(map, "<set-?>");
        this.specialFeaturesOptions = map;
    }

    public final void setTcString(String str) {
        this.tcString = str;
    }

    public final void setUseNonStandardStacks(boolean z4) {
        this.useNonStandardStacks = z4;
    }

    public GDPRData(Set<Integer> set) {
        Set<Integer> set2 = set;
        boolean z4 = false;
        this.tcfPolicyVersion = 2;
        C0956a aVar = C0956a.f3560a;
        this.eventStatus = null;
        this.cmpStatus = aVar.a();
        this.purpose = new ConsentMap((Map) null, (Map) null, 3, (C2103g) null);
        this.vendor = new ConsentMap((Map) null, (Map) null, 3, (C2103g) null);
        this.specialFeaturesOptions = new LinkedHashMap();
        this.publisher = new PublisherMap(0, (Map) null, (Map) null, (ConsentMap) null, (Map) null, 31, (C2103g) null);
        this.outOfBand = new OutOfBandMap((Map) null, (Map) null, 3, (C2103g) null);
        aVar.b(ChoiceCmp.INSTANCE.getTcModel$app_release());
        s f4 = aVar.f();
        if (f4 != null) {
            A3.j jVar = A3.j.f86a;
            d dVar = d.f24465a;
            setPrivacyEncodingMode(jVar.a(dVar.j().a().a()));
            PrivacyEncodingMode privacyEncodingMode2 = getPrivacyEncodingMode();
            int i4 = privacyEncodingMode2 == null ? -1 : a.f11779a[privacyEncodingMode2.ordinal()];
            if (i4 == 1) {
                aVar.e(v.f6420a.a(f4, new f(Boolean.TRUE, 2, C1601o.l(l.CORE))));
                setTcString(aVar.g());
            } else if (i4 != 2) {
                aVar.e(v.f6420a.a(f4, new f(Boolean.TRUE, 2, C1601o.l(l.CORE))));
                setTcString(aVar.g());
                aVar.c(E2.d.f6347a.a(f4));
                setGppString(aVar.d());
            } else {
                aVar.c(E2.d.f6347a.a(f4));
                setGppString(aVar.d());
            }
            setServiceSpecific(f4.w());
            setUseNonStandardStacks(f4.r());
            setPurposeOneTreatment(f4.p());
            setPublisherCC(f4.i());
            setCmpId(Integer.valueOf(f4.a()));
            setCmpVersion(Integer.valueOf(f4.d()));
            setGdprApplies(Boolean.valueOf(dVar.m().i(a4.a.TCF_GDPR_APPLIES) == 1 ? true : z4));
            OutOfBandMap outOfBand2 = getOutOfBand();
            outOfBand2.setAllowedVendors(jVar.c(f4.u(), set2));
            outOfBand2.setDisclosedVendors(jVar.c(f4.v(), set2));
            ConsentMap purpose2 = getPurpose();
            purpose2.setConsents(jVar.b(f4.n()));
            purpose2.setLegitimateInterests(jVar.b(f4.o()));
            ConsentMap vendor2 = getVendor();
            vendor2.setConsents(jVar.b(f4.s()));
            vendor2.setLegitimateInterests(jVar.b(f4.t()));
            setSpecialFeaturesOptions(jVar.b(f4.q()));
            PublisherMap publisher2 = getPublisher();
            publisher2.setVendorId(getPublisherVendorId());
            publisher2.setConsents(jVar.b(f4.h()));
            publisher2.setLegitimateInterests(jVar.b(f4.l()));
            ConsentMap customPurpose = publisher2.getCustomPurpose();
            customPurpose.setConsents(jVar.b(f4.j()));
            customPurpose.setLegitimateInterests(jVar.b(f4.k()));
            publisher2.setRestrictions(createRestrictions(f4.m()));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GDPRData(Set set, int i4, C2103g gVar) {
        this((i4 & 1) != 0 ? null : set);
    }
}
