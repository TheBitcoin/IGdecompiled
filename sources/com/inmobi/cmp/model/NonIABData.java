package com.inmobi.cmp.model;

import A2.a;
import E2.t;
import androidx.annotation.Keep;
import java.util.Map;
import kotlin.jvm.internal.m;

@Keep
public final class NonIABData {
    private boolean gdprApplies;
    private boolean hasGlobalConsent;
    private boolean hasGlobalScope;
    private String metadata;
    private Map<Integer, Boolean> nonIabVendorConsents;

    public NonIABData(boolean z4, boolean z5, boolean z6, String str, Map<Integer, Boolean> map) {
        m.e(str, TtmlNode.TAG_METADATA);
        m.e(map, "nonIabVendorConsents");
        this.gdprApplies = z4;
        this.hasGlobalConsent = z5;
        this.hasGlobalScope = z6;
        this.metadata = str;
        this.nonIabVendorConsents = map;
    }

    public static /* synthetic */ NonIABData copy$default(NonIABData nonIABData, boolean z4, boolean z5, boolean z6, String str, Map<Integer, Boolean> map, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = nonIABData.gdprApplies;
        }
        if ((i4 & 2) != 0) {
            z5 = nonIABData.hasGlobalConsent;
        }
        if ((i4 & 4) != 0) {
            z6 = nonIABData.hasGlobalScope;
        }
        if ((i4 & 8) != 0) {
            str = nonIABData.metadata;
        }
        if ((i4 & 16) != 0) {
            map = nonIABData.nonIabVendorConsents;
        }
        String str2 = str;
        Map<Integer, Boolean> map2 = map;
        return nonIABData.copy(z4, z5, z6, str2, map2);
    }

    public final boolean component1() {
        return this.gdprApplies;
    }

    public final boolean component2() {
        return this.hasGlobalConsent;
    }

    public final boolean component3() {
        return this.hasGlobalScope;
    }

    public final String component4() {
        return this.metadata;
    }

    public final Map<Integer, Boolean> component5() {
        return this.nonIabVendorConsents;
    }

    public final NonIABData copy(boolean z4, boolean z5, boolean z6, String str, Map<Integer, Boolean> map) {
        m.e(str, TtmlNode.TAG_METADATA);
        m.e(map, "nonIabVendorConsents");
        return new NonIABData(z4, z5, z6, str, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NonIABData)) {
            return false;
        }
        NonIABData nonIABData = (NonIABData) obj;
        return this.gdprApplies == nonIABData.gdprApplies && this.hasGlobalConsent == nonIABData.hasGlobalConsent && this.hasGlobalScope == nonIABData.hasGlobalScope && m.a(this.metadata, nonIABData.metadata) && m.a(this.nonIabVendorConsents, nonIABData.nonIabVendorConsents);
    }

    public final boolean getGdprApplies() {
        return this.gdprApplies;
    }

    public final boolean getHasGlobalConsent() {
        return this.hasGlobalConsent;
    }

    public final boolean getHasGlobalScope() {
        return this.hasGlobalScope;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final Map<Integer, Boolean> getNonIabVendorConsents() {
        return this.nonIabVendorConsents;
    }

    public int hashCode() {
        boolean z4 = this.gdprApplies;
        boolean z5 = true;
        if (z4) {
            z4 = true;
        }
        int i4 = (z4 ? 1 : 0) * true;
        boolean z6 = this.hasGlobalConsent;
        if (z6) {
            z6 = true;
        }
        int i5 = (i4 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.hasGlobalScope;
        if (!z7) {
            z5 = z7;
        }
        return this.nonIabVendorConsents.hashCode() + t.a(this.metadata, (i5 + (z5 ? 1 : 0)) * 31, 31);
    }

    public final void setGdprApplies(boolean z4) {
        this.gdprApplies = z4;
    }

    public final void setHasGlobalConsent(boolean z4) {
        this.hasGlobalConsent = z4;
    }

    public final void setHasGlobalScope(boolean z4) {
        this.hasGlobalScope = z4;
    }

    public final void setMetadata(String str) {
        m.e(str, "<set-?>");
        this.metadata = str;
    }

    public final void setNonIabVendorConsents(Map<Integer, Boolean> map) {
        m.e(map, "<set-?>");
        this.nonIabVendorConsents = map;
    }

    public String toString() {
        StringBuilder a5 = a.a("NonIABData(gdprApplies=");
        a5.append(this.gdprApplies);
        a5.append(", hasGlobalConsent=");
        a5.append(this.hasGlobalConsent);
        a5.append(", hasGlobalScope=");
        a5.append(this.hasGlobalScope);
        a5.append(", metadata=");
        a5.append(this.metadata);
        a5.append(", nonIabVendorConsents=");
        a5.append(this.nonIabVendorConsents);
        a5.append(')');
        return a5.toString();
    }
}
