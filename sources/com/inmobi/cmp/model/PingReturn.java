package com.inmobi.cmp.model;

import E2.t;
import androidx.annotation.Keep;
import com.inmobi.cmp.core.cmpapi.status.CmpStatus;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.m;

@Keep
public final class PingReturn {
    public static final a Companion = new a();
    /* access modifiers changed from: private */
    public static final PingReturn LOADING_PING;
    /* access modifiers changed from: private */
    public static final PingReturn STUB_PING;
    private String apiVersion;
    private Integer cmpId;
    private boolean cmpLoaded;
    private CmpStatus cmpStatus;
    private String cmpVersion;
    private DisplayStatus displayStatus;
    private Boolean gdprApplies;
    private Integer gvlVersion;
    private Integer tcfPolicyVersion;

    public static final class a {
    }

    static {
        CmpStatus cmpStatus2 = CmpStatus.STUB;
        DisplayStatus displayStatus2 = DisplayStatus.HIDDEN;
        STUB_PING = new PingReturn((Boolean) null, false, cmpStatus2, displayStatus2, MBridgeConstans.NATIVE_VIDEO_VERSION, (String) null, (Integer) null, (Integer) null, (Integer) null);
        LOADING_PING = new PingReturn((Boolean) null, false, CmpStatus.LOADING, displayStatus2, MBridgeConstans.NATIVE_VIDEO_VERSION, "0.1", 10, (Integer) null, (Integer) null);
    }

    public PingReturn(Boolean bool, boolean z4, CmpStatus cmpStatus2, DisplayStatus displayStatus2, String str, String str2, Integer num, Integer num2, Integer num3) {
        m.e(cmpStatus2, "cmpStatus");
        m.e(displayStatus2, "displayStatus");
        m.e(str, "apiVersion");
        this.gdprApplies = bool;
        this.cmpLoaded = z4;
        this.cmpStatus = cmpStatus2;
        this.displayStatus = displayStatus2;
        this.apiVersion = str;
        this.cmpVersion = str2;
        this.cmpId = num;
        this.gvlVersion = num2;
        this.tcfPolicyVersion = num3;
    }

    public static /* synthetic */ PingReturn copy$default(PingReturn pingReturn, Boolean bool, boolean z4, CmpStatus cmpStatus2, DisplayStatus displayStatus2, String str, String str2, Integer num, Integer num2, Integer num3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            bool = pingReturn.gdprApplies;
        }
        if ((i4 & 2) != 0) {
            z4 = pingReturn.cmpLoaded;
        }
        if ((i4 & 4) != 0) {
            cmpStatus2 = pingReturn.cmpStatus;
        }
        if ((i4 & 8) != 0) {
            displayStatus2 = pingReturn.displayStatus;
        }
        if ((i4 & 16) != 0) {
            str = pingReturn.apiVersion;
        }
        if ((i4 & 32) != 0) {
            str2 = pingReturn.cmpVersion;
        }
        if ((i4 & 64) != 0) {
            num = pingReturn.cmpId;
        }
        if ((i4 & 128) != 0) {
            num2 = pingReturn.gvlVersion;
        }
        if ((i4 & 256) != 0) {
            num3 = pingReturn.tcfPolicyVersion;
        }
        Integer num4 = num2;
        Integer num5 = num3;
        String str3 = str2;
        Integer num6 = num;
        DisplayStatus displayStatus3 = displayStatus2;
        String str4 = str;
        return pingReturn.copy(bool, z4, cmpStatus2, displayStatus3, str4, str3, num6, num4, num5);
    }

    public final Boolean component1() {
        return this.gdprApplies;
    }

    public final boolean component2() {
        return this.cmpLoaded;
    }

    public final CmpStatus component3() {
        return this.cmpStatus;
    }

    public final DisplayStatus component4() {
        return this.displayStatus;
    }

    public final String component5() {
        return this.apiVersion;
    }

    public final String component6() {
        return this.cmpVersion;
    }

    public final Integer component7() {
        return this.cmpId;
    }

    public final Integer component8() {
        return this.gvlVersion;
    }

    public final Integer component9() {
        return this.tcfPolicyVersion;
    }

    public final PingReturn copy(Boolean bool, boolean z4, CmpStatus cmpStatus2, DisplayStatus displayStatus2, String str, String str2, Integer num, Integer num2, Integer num3) {
        m.e(cmpStatus2, "cmpStatus");
        m.e(displayStatus2, "displayStatus");
        String str3 = str;
        m.e(str3, "apiVersion");
        return new PingReturn(bool, z4, cmpStatus2, displayStatus2, str3, str2, num, num2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PingReturn)) {
            return false;
        }
        PingReturn pingReturn = (PingReturn) obj;
        return m.a(this.gdprApplies, pingReturn.gdprApplies) && this.cmpLoaded == pingReturn.cmpLoaded && this.cmpStatus == pingReturn.cmpStatus && this.displayStatus == pingReturn.displayStatus && m.a(this.apiVersion, pingReturn.apiVersion) && m.a(this.cmpVersion, pingReturn.cmpVersion) && m.a(this.cmpId, pingReturn.cmpId) && m.a(this.gvlVersion, pingReturn.gvlVersion) && m.a(this.tcfPolicyVersion, pingReturn.tcfPolicyVersion);
    }

    public final String getApiVersion() {
        return this.apiVersion;
    }

    public final Integer getCmpId() {
        return this.cmpId;
    }

    public final boolean getCmpLoaded() {
        return this.cmpLoaded;
    }

    public final CmpStatus getCmpStatus() {
        return this.cmpStatus;
    }

    public final String getCmpVersion() {
        return this.cmpVersion;
    }

    public final DisplayStatus getDisplayStatus() {
        return this.displayStatus;
    }

    public final Boolean getGdprApplies() {
        return this.gdprApplies;
    }

    public final Integer getGvlVersion() {
        return this.gvlVersion;
    }

    public final Integer getTcfPolicyVersion() {
        return this.tcfPolicyVersion;
    }

    public int hashCode() {
        Boolean bool = this.gdprApplies;
        int i4 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        boolean z4 = this.cmpLoaded;
        if (z4) {
            z4 = true;
        }
        int a5 = t.a(this.apiVersion, (this.displayStatus.hashCode() + ((this.cmpStatus.hashCode() + ((hashCode + (z4 ? 1 : 0)) * 31)) * 31)) * 31, 31);
        String str = this.cmpVersion;
        int hashCode2 = (a5 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.cmpId;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.gvlVersion;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.tcfPolicyVersion;
        if (num3 != null) {
            i4 = num3.hashCode();
        }
        return hashCode4 + i4;
    }

    public final void setApiVersion(String str) {
        m.e(str, "<set-?>");
        this.apiVersion = str;
    }

    public final void setCmpId(Integer num) {
        this.cmpId = num;
    }

    public final void setCmpLoaded(boolean z4) {
        this.cmpLoaded = z4;
    }

    public final void setCmpStatus(CmpStatus cmpStatus2) {
        m.e(cmpStatus2, "<set-?>");
        this.cmpStatus = cmpStatus2;
    }

    public final void setCmpVersion(String str) {
        this.cmpVersion = str;
    }

    public final void setDisplayStatus(DisplayStatus displayStatus2) {
        m.e(displayStatus2, "<set-?>");
        this.displayStatus = displayStatus2;
    }

    public final void setGdprApplies(Boolean bool) {
        this.gdprApplies = bool;
    }

    public final void setGvlVersion(Integer num) {
        this.gvlVersion = num;
    }

    public final void setTcfPolicyVersion(Integer num) {
        this.tcfPolicyVersion = num;
    }

    public String toString() {
        StringBuilder a5 = A2.a.a("PingReturn(gdprApplies=");
        a5.append(this.gdprApplies);
        a5.append(", cmpLoaded=");
        a5.append(this.cmpLoaded);
        a5.append(", cmpStatus=");
        a5.append(this.cmpStatus);
        a5.append(", displayStatus=");
        a5.append(this.displayStatus);
        a5.append(", apiVersion=");
        a5.append(this.apiVersion);
        a5.append(", cmpVersion=");
        a5.append(this.cmpVersion);
        a5.append(", cmpId=");
        a5.append(this.cmpId);
        a5.append(", gvlVersion=");
        a5.append(this.gvlVersion);
        a5.append(", tcfPolicyVersion=");
        a5.append(this.tcfPolicyVersion);
        a5.append(')');
        return a5.toString();
    }
}
