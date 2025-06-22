package com.inmobi.cmp.core.cmpapi.map;

import A2.a;
import E2.k;
import androidx.annotation.Keep;
import java.util.Map;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

@Keep
public final class PublisherMap {
    private Map<String, Boolean> consents;
    private final ConsentMap customPurpose;
    private Map<String, Boolean> legitimateInterests;
    private Map<String, Map<String, k>> restrictions;
    private int vendorId;

    public PublisherMap() {
        this(0, (Map) null, (Map) null, (ConsentMap) null, (Map) null, 31, (C2103g) null);
    }

    public static /* synthetic */ PublisherMap copy$default(PublisherMap publisherMap, int i4, Map<String, Boolean> map, Map<String, Boolean> map2, ConsentMap consentMap, Map<String, Map<String, k>> map3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = publisherMap.vendorId;
        }
        if ((i5 & 2) != 0) {
            map = publisherMap.consents;
        }
        if ((i5 & 4) != 0) {
            map2 = publisherMap.legitimateInterests;
        }
        if ((i5 & 8) != 0) {
            consentMap = publisherMap.customPurpose;
        }
        if ((i5 & 16) != 0) {
            map3 = publisherMap.restrictions;
        }
        ConsentMap consentMap2 = consentMap;
        Map<String, Map<String, k>> map4 = map3;
        return publisherMap.copy(i4, map, map2, consentMap2, map4);
    }

    public final int component1() {
        return this.vendorId;
    }

    public final Map<String, Boolean> component2() {
        return this.consents;
    }

    public final Map<String, Boolean> component3() {
        return this.legitimateInterests;
    }

    public final ConsentMap component4() {
        return this.customPurpose;
    }

    public final Map<String, Map<String, k>> component5() {
        return this.restrictions;
    }

    public final PublisherMap copy(int i4, Map<String, Boolean> map, Map<String, Boolean> map2, ConsentMap consentMap, Map<String, Map<String, k>> map3) {
        m.e(map, "consents");
        m.e(map2, "legitimateInterests");
        m.e(consentMap, "customPurpose");
        m.e(map3, "restrictions");
        return new PublisherMap(i4, map, map2, consentMap, map3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublisherMap)) {
            return false;
        }
        PublisherMap publisherMap = (PublisherMap) obj;
        return this.vendorId == publisherMap.vendorId && m.a(this.consents, publisherMap.consents) && m.a(this.legitimateInterests, publisherMap.legitimateInterests) && m.a(this.customPurpose, publisherMap.customPurpose) && m.a(this.restrictions, publisherMap.restrictions);
    }

    public final Map<String, Boolean> getConsents() {
        return this.consents;
    }

    public final ConsentMap getCustomPurpose() {
        return this.customPurpose;
    }

    public final Map<String, Boolean> getLegitimateInterests() {
        return this.legitimateInterests;
    }

    public final Map<String, Map<String, k>> getRestrictions() {
        return this.restrictions;
    }

    public final int getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        int hashCode = this.consents.hashCode();
        int hashCode2 = this.legitimateInterests.hashCode();
        int hashCode3 = this.customPurpose.hashCode();
        return this.restrictions.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (this.vendorId * 31)) * 31)) * 31)) * 31);
    }

    public final void setConsents(Map<String, Boolean> map) {
        m.e(map, "<set-?>");
        this.consents = map;
    }

    public final void setLegitimateInterests(Map<String, Boolean> map) {
        m.e(map, "<set-?>");
        this.legitimateInterests = map;
    }

    public final void setRestrictions(Map<String, Map<String, k>> map) {
        m.e(map, "<set-?>");
        this.restrictions = map;
    }

    public final void setVendorId(int i4) {
        this.vendorId = i4;
    }

    public String toString() {
        StringBuilder a5 = a.a("PublisherMap(vendorId=");
        a5.append(this.vendorId);
        a5.append(", consents=");
        a5.append(this.consents);
        a5.append(", legitimateInterests=");
        a5.append(this.legitimateInterests);
        a5.append(", customPurpose=");
        a5.append(this.customPurpose);
        a5.append(", restrictions=");
        a5.append(this.restrictions);
        a5.append(')');
        return a5.toString();
    }

    public PublisherMap(int i4, Map<String, Boolean> map, Map<String, Boolean> map2, ConsentMap consentMap, Map<String, Map<String, k>> map3) {
        m.e(map, "consents");
        m.e(map2, "legitimateInterests");
        m.e(consentMap, "customPurpose");
        m.e(map3, "restrictions");
        this.vendorId = i4;
        this.consents = map;
        this.legitimateInterests = map2;
        this.customPurpose = consentMap;
        this.restrictions = map3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PublisherMap(int r2, java.util.Map r3, java.util.Map r4, com.inmobi.cmp.core.cmpapi.map.ConsentMap r5, java.util.Map r6, int r7, kotlin.jvm.internal.C2103g r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L_0x0005
            r2 = 0
        L_0x0005:
            r8 = r7 & 2
            if (r8 == 0) goto L_0x000e
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
        L_0x000e:
            r8 = r7 & 4
            if (r8 == 0) goto L_0x0017
            java.util.LinkedHashMap r4 = new java.util.LinkedHashMap
            r4.<init>()
        L_0x0017:
            r8 = r7 & 8
            if (r8 == 0) goto L_0x0022
            com.inmobi.cmp.core.cmpapi.map.ConsentMap r5 = new com.inmobi.cmp.core.cmpapi.map.ConsentMap
            r8 = 3
            r0 = 0
            r5.<init>(r0, r0, r8, r0)
        L_0x0022:
            r7 = r7 & 16
            if (r7 == 0) goto L_0x002b
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap
            r6.<init>()
        L_0x002b:
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.core.cmpapi.map.PublisherMap.<init>(int, java.util.Map, java.util.Map, com.inmobi.cmp.core.cmpapi.map.ConsentMap, java.util.Map, int, kotlin.jvm.internal.g):void");
    }
}
