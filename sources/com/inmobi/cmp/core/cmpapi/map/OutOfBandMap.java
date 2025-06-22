package com.inmobi.cmp.core.cmpapi.map;

import A2.a;
import androidx.annotation.Keep;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

@Keep
public final class OutOfBandMap {
    private Map<String, Boolean> allowedVendors;
    private Map<String, Boolean> disclosedVendors;

    public OutOfBandMap() {
        this((Map) null, (Map) null, 3, (C2103g) null);
    }

    public static /* synthetic */ OutOfBandMap copy$default(OutOfBandMap outOfBandMap, Map<String, Boolean> map, Map<String, Boolean> map2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            map = outOfBandMap.allowedVendors;
        }
        if ((i4 & 2) != 0) {
            map2 = outOfBandMap.disclosedVendors;
        }
        return outOfBandMap.copy(map, map2);
    }

    public final Map<String, Boolean> component1() {
        return this.allowedVendors;
    }

    public final Map<String, Boolean> component2() {
        return this.disclosedVendors;
    }

    public final OutOfBandMap copy(Map<String, Boolean> map, Map<String, Boolean> map2) {
        m.e(map, "allowedVendors");
        m.e(map2, "disclosedVendors");
        return new OutOfBandMap(map, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OutOfBandMap)) {
            return false;
        }
        OutOfBandMap outOfBandMap = (OutOfBandMap) obj;
        return m.a(this.allowedVendors, outOfBandMap.allowedVendors) && m.a(this.disclosedVendors, outOfBandMap.disclosedVendors);
    }

    public final Map<String, Boolean> getAllowedVendors() {
        return this.allowedVendors;
    }

    public final Map<String, Boolean> getDisclosedVendors() {
        return this.disclosedVendors;
    }

    public int hashCode() {
        return this.disclosedVendors.hashCode() + (this.allowedVendors.hashCode() * 31);
    }

    public final void setAllowedVendors(Map<String, Boolean> map) {
        m.e(map, "<set-?>");
        this.allowedVendors = map;
    }

    public final void setDisclosedVendors(Map<String, Boolean> map) {
        m.e(map, "<set-?>");
        this.disclosedVendors = map;
    }

    public String toString() {
        StringBuilder a5 = a.a("OutOfBandMap(allowedVendors=");
        a5.append(this.allowedVendors);
        a5.append(", disclosedVendors=");
        a5.append(this.disclosedVendors);
        a5.append(')');
        return a5.toString();
    }

    public OutOfBandMap(Map<String, Boolean> map, Map<String, Boolean> map2) {
        m.e(map, "allowedVendors");
        m.e(map2, "disclosedVendors");
        this.allowedVendors = map;
        this.disclosedVendors = map2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OutOfBandMap(Map map, Map map2, int i4, C2103g gVar) {
        this((i4 & 1) != 0 ? new LinkedHashMap() : map, (i4 & 2) != 0 ? new LinkedHashMap() : map2);
    }
}
