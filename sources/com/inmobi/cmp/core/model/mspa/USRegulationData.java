package com.inmobi.cmp.core.model.mspa;

import A3.k;
import A3.l;
import E2.t;
import androidx.annotation.Keep;
import java.util.List;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

@Keep
public final class USRegulationData {
    private String gppString;
    private List<Integer> knownChildSensitiveDataConsents;
    private int mspaCoveredTransaction;
    private int mspaOptOutOptionMode;
    private int mspaServiceProviderMode;
    private int personalDataConsents;
    private int saleOptOut;
    private int saleOptOutNotice;
    private int sensitiveDataLimitUseNotice;
    private List<Integer> sensitiveDataProcessing;
    private int sensitiveDataProcessingOptOutNotice;
    private int sharingNotice;
    private int sharingOptOut;
    private int sharingOptOutNotice;
    private int targetedAdvertisingOptOut;
    private int targetedAdvertisingOptOutNotice;
    private int version;

    public USRegulationData() {
        this(0, (String) null, 0, 0, 0, 0, 0, 0, 0, 0, 0, (List) null, (List) null, 0, 0, 0, 0, 131071, (C2103g) null);
    }

    public static /* synthetic */ USRegulationData copy$default(USRegulationData uSRegulationData, int i4, String str, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, List list, List list2, int i14, int i15, int i16, int i17, int i18, Object obj) {
        int i19;
        int i20;
        int i21;
        int i22;
        List list3;
        List list4;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        String str2;
        int i32;
        USRegulationData uSRegulationData2;
        USRegulationData uSRegulationData3 = uSRegulationData;
        int i33 = i18;
        int i34 = (i33 & 1) != 0 ? uSRegulationData3.version : i4;
        String str3 = (i33 & 2) != 0 ? uSRegulationData3.gppString : str;
        int i35 = (i33 & 4) != 0 ? uSRegulationData3.sharingNotice : i5;
        int i36 = (i33 & 8) != 0 ? uSRegulationData3.saleOptOutNotice : i6;
        int i37 = (i33 & 16) != 0 ? uSRegulationData3.sharingOptOutNotice : i7;
        int i38 = (i33 & 32) != 0 ? uSRegulationData3.targetedAdvertisingOptOutNotice : i8;
        int i39 = (i33 & 64) != 0 ? uSRegulationData3.sensitiveDataProcessingOptOutNotice : i9;
        int i40 = (i33 & 128) != 0 ? uSRegulationData3.sensitiveDataLimitUseNotice : i10;
        int i41 = (i33 & 256) != 0 ? uSRegulationData3.saleOptOut : i11;
        int i42 = (i33 & 512) != 0 ? uSRegulationData3.sharingOptOut : i12;
        int i43 = (i33 & 1024) != 0 ? uSRegulationData3.targetedAdvertisingOptOut : i13;
        List list5 = (i33 & 2048) != 0 ? uSRegulationData3.sensitiveDataProcessing : list;
        List list6 = (i33 & 4096) != 0 ? uSRegulationData3.knownChildSensitiveDataConsents : list2;
        int i44 = (i33 & 8192) != 0 ? uSRegulationData3.personalDataConsents : i14;
        int i45 = i34;
        int i46 = (i33 & 16384) != 0 ? uSRegulationData3.mspaCoveredTransaction : i15;
        int i47 = (i33 & 32768) != 0 ? uSRegulationData3.mspaOptOutOptionMode : i16;
        if ((i18 & 65536) != 0) {
            i20 = i47;
            i19 = uSRegulationData3.mspaServiceProviderMode;
            i21 = i46;
            str2 = str3;
            i31 = i35;
            i30 = i36;
            i29 = i37;
            i28 = i38;
            i27 = i39;
            i26 = i40;
            i25 = i41;
            i24 = i42;
            i23 = i43;
            list4 = list5;
            list3 = list6;
            i22 = i44;
            i32 = i45;
            uSRegulationData2 = uSRegulationData3;
        } else {
            i19 = i17;
            i20 = i47;
            i32 = i45;
            uSRegulationData2 = uSRegulationData3;
            i21 = i46;
            str2 = str3;
            i31 = i35;
            i30 = i36;
            i29 = i37;
            i28 = i38;
            i27 = i39;
            i26 = i40;
            i25 = i41;
            i24 = i42;
            i23 = i43;
            list4 = list5;
            list3 = list6;
            i22 = i44;
        }
        return uSRegulationData2.copy(i32, str2, i31, i30, i29, i28, i27, i26, i25, i24, i23, list4, list3, i22, i21, i20, i19);
    }

    public final int component1() {
        return this.version;
    }

    public final int component10() {
        return this.sharingOptOut;
    }

    public final int component11() {
        return this.targetedAdvertisingOptOut;
    }

    public final List<Integer> component12() {
        return this.sensitiveDataProcessing;
    }

    public final List<Integer> component13() {
        return this.knownChildSensitiveDataConsents;
    }

    public final int component14() {
        return this.personalDataConsents;
    }

    public final int component15() {
        return this.mspaCoveredTransaction;
    }

    public final int component16() {
        return this.mspaOptOutOptionMode;
    }

    public final int component17() {
        return this.mspaServiceProviderMode;
    }

    public final String component2() {
        return this.gppString;
    }

    public final int component3() {
        return this.sharingNotice;
    }

    public final int component4() {
        return this.saleOptOutNotice;
    }

    public final int component5() {
        return this.sharingOptOutNotice;
    }

    public final int component6() {
        return this.targetedAdvertisingOptOutNotice;
    }

    public final int component7() {
        return this.sensitiveDataProcessingOptOutNotice;
    }

    public final int component8() {
        return this.sensitiveDataLimitUseNotice;
    }

    public final int component9() {
        return this.saleOptOut;
    }

    public final USRegulationData copy(int i4, String str, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, List<Integer> list, List<Integer> list2, int i14, int i15, int i16, int i17) {
        String str2 = str;
        m.e(str2, "gppString");
        List<Integer> list3 = list;
        m.e(list3, "sensitiveDataProcessing");
        List<Integer> list4 = list2;
        m.e(list4, "knownChildSensitiveDataConsents");
        return new USRegulationData(i4, str2, i5, i6, i7, i8, i9, i10, i11, i12, i13, list3, list4, i14, i15, i16, i17);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof USRegulationData)) {
            return false;
        }
        USRegulationData uSRegulationData = (USRegulationData) obj;
        return this.version == uSRegulationData.version && m.a(this.gppString, uSRegulationData.gppString) && this.sharingNotice == uSRegulationData.sharingNotice && this.saleOptOutNotice == uSRegulationData.saleOptOutNotice && this.sharingOptOutNotice == uSRegulationData.sharingOptOutNotice && this.targetedAdvertisingOptOutNotice == uSRegulationData.targetedAdvertisingOptOutNotice && this.sensitiveDataProcessingOptOutNotice == uSRegulationData.sensitiveDataProcessingOptOutNotice && this.sensitiveDataLimitUseNotice == uSRegulationData.sensitiveDataLimitUseNotice && this.saleOptOut == uSRegulationData.saleOptOut && this.sharingOptOut == uSRegulationData.sharingOptOut && this.targetedAdvertisingOptOut == uSRegulationData.targetedAdvertisingOptOut && m.a(this.sensitiveDataProcessing, uSRegulationData.sensitiveDataProcessing) && m.a(this.knownChildSensitiveDataConsents, uSRegulationData.knownChildSensitiveDataConsents) && this.personalDataConsents == uSRegulationData.personalDataConsents && this.mspaCoveredTransaction == uSRegulationData.mspaCoveredTransaction && this.mspaOptOutOptionMode == uSRegulationData.mspaOptOutOptionMode && this.mspaServiceProviderMode == uSRegulationData.mspaServiceProviderMode;
    }

    public final String getGppString() {
        return this.gppString;
    }

    public final List<Integer> getKnownChildSensitiveDataConsents() {
        return this.knownChildSensitiveDataConsents;
    }

    public final int getMspaCoveredTransaction() {
        return this.mspaCoveredTransaction;
    }

    public final int getMspaOptOutOptionMode() {
        return this.mspaOptOutOptionMode;
    }

    public final int getMspaServiceProviderMode() {
        return this.mspaServiceProviderMode;
    }

    public final int getPersonalDataConsents() {
        return this.personalDataConsents;
    }

    public final int getSaleOptOut() {
        return this.saleOptOut;
    }

    public final int getSaleOptOutNotice() {
        return this.saleOptOutNotice;
    }

    public final int getSensitiveDataLimitUseNotice() {
        return this.sensitiveDataLimitUseNotice;
    }

    public final List<Integer> getSensitiveDataProcessing() {
        return this.sensitiveDataProcessing;
    }

    public final int getSensitiveDataProcessingOptOutNotice() {
        return this.sensitiveDataProcessingOptOutNotice;
    }

    public final int getSharingNotice() {
        return this.sharingNotice;
    }

    public final int getSharingOptOut() {
        return this.sharingOptOut;
    }

    public final int getSharingOptOutNotice() {
        return this.sharingOptOutNotice;
    }

    public final int getTargetedAdvertisingOptOut() {
        return this.targetedAdvertisingOptOut;
    }

    public final int getTargetedAdvertisingOptOutNotice() {
        return this.targetedAdvertisingOptOutNotice;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.mspaServiceProviderMode + k.a(this.mspaOptOutOptionMode, k.a(this.mspaCoveredTransaction, k.a(this.personalDataConsents, l.a(this.knownChildSensitiveDataConsents, l.a(this.sensitiveDataProcessing, k.a(this.targetedAdvertisingOptOut, k.a(this.sharingOptOut, k.a(this.saleOptOut, k.a(this.sensitiveDataLimitUseNotice, k.a(this.sensitiveDataProcessingOptOutNotice, k.a(this.targetedAdvertisingOptOutNotice, k.a(this.sharingOptOutNotice, k.a(this.saleOptOutNotice, k.a(this.sharingNotice, t.a(this.gppString, this.version * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final void setGppString(String str) {
        m.e(str, "<set-?>");
        this.gppString = str;
    }

    public final void setKnownChildSensitiveDataConsents(List<Integer> list) {
        m.e(list, "<set-?>");
        this.knownChildSensitiveDataConsents = list;
    }

    public final void setMspaCoveredTransaction(int i4) {
        this.mspaCoveredTransaction = i4;
    }

    public final void setMspaOptOutOptionMode(int i4) {
        this.mspaOptOutOptionMode = i4;
    }

    public final void setMspaServiceProviderMode(int i4) {
        this.mspaServiceProviderMode = i4;
    }

    public final void setPersonalDataConsents(int i4) {
        this.personalDataConsents = i4;
    }

    public final void setSaleOptOut(int i4) {
        this.saleOptOut = i4;
    }

    public final void setSaleOptOutNotice(int i4) {
        this.saleOptOutNotice = i4;
    }

    public final void setSensitiveDataLimitUseNotice(int i4) {
        this.sensitiveDataLimitUseNotice = i4;
    }

    public final void setSensitiveDataProcessing(List<Integer> list) {
        m.e(list, "<set-?>");
        this.sensitiveDataProcessing = list;
    }

    public final void setSensitiveDataProcessingOptOutNotice(int i4) {
        this.sensitiveDataProcessingOptOutNotice = i4;
    }

    public final void setSharingNotice(int i4) {
        this.sharingNotice = i4;
    }

    public final void setSharingOptOut(int i4) {
        this.sharingOptOut = i4;
    }

    public final void setSharingOptOutNotice(int i4) {
        this.sharingOptOutNotice = i4;
    }

    public final void setTargetedAdvertisingOptOut(int i4) {
        this.targetedAdvertisingOptOut = i4;
    }

    public final void setTargetedAdvertisingOptOutNotice(int i4) {
        this.targetedAdvertisingOptOutNotice = i4;
    }

    public final void setVersion(int i4) {
        this.version = i4;
    }

    public String toString() {
        return "USRegulationData(version=" + this.version + ", gppString=" + this.gppString + ", sharingNotice=" + this.sharingNotice + ", saleOptOutNotice=" + this.saleOptOutNotice + ", sharingOptOutNotice=" + this.sharingOptOutNotice + ", targetedAdvertisingOptOutNotice=" + this.targetedAdvertisingOptOutNotice + ", sensitiveDataProcessingOptOutNotice=" + this.sensitiveDataProcessingOptOutNotice + ", sensitiveDataLimitUseNotice=" + this.sensitiveDataLimitUseNotice + ", saleOptOut=" + this.saleOptOut + ", sharingOptOut=" + this.sharingOptOut + ", targetedAdvertisingOptOut=" + this.targetedAdvertisingOptOut + ", sensitiveDataProcessing=" + this.sensitiveDataProcessing + ", knownChildSensitiveDataConsents=" + this.knownChildSensitiveDataConsents + ", personalDataConsents=" + this.personalDataConsents + ", mspaCoveredTransaction=" + this.mspaCoveredTransaction + ", mspaOptOutOptionMode=" + this.mspaOptOutOptionMode + ", mspaServiceProviderMode=" + this.mspaServiceProviderMode + ')';
    }

    public USRegulationData(int i4, String str, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, List<Integer> list, List<Integer> list2, int i14, int i15, int i16, int i17) {
        m.e(str, "gppString");
        m.e(list, "sensitiveDataProcessing");
        m.e(list2, "knownChildSensitiveDataConsents");
        this.version = i4;
        this.gppString = str;
        this.sharingNotice = i5;
        this.saleOptOutNotice = i6;
        this.sharingOptOutNotice = i7;
        this.targetedAdvertisingOptOutNotice = i8;
        this.sensitiveDataProcessingOptOutNotice = i9;
        this.sensitiveDataLimitUseNotice = i10;
        this.saleOptOut = i11;
        this.sharingOptOut = i12;
        this.targetedAdvertisingOptOut = i13;
        this.sensitiveDataProcessing = list;
        this.knownChildSensitiveDataConsents = list2;
        this.personalDataConsents = i14;
        this.mspaCoveredTransaction = i15;
        this.mspaOptOutOptionMode = i16;
        this.mspaServiceProviderMode = i17;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ USRegulationData(int r19, java.lang.String r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, java.util.List r30, java.util.List r31, int r32, int r33, int r34, int r35, int r36, kotlin.jvm.internal.C2103g r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r19
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            java.lang.String r3 = ""
            goto L_0x0013
        L_0x0011:
            r3 = r20
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0019
            r4 = 0
            goto L_0x001b
        L_0x0019:
            r4 = r21
        L_0x001b:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0021
            r5 = 0
            goto L_0x0023
        L_0x0021:
            r5 = r22
        L_0x0023:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0029
            r6 = 0
            goto L_0x002b
        L_0x0029:
            r6 = r23
        L_0x002b:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0031
            r7 = 0
            goto L_0x0033
        L_0x0031:
            r7 = r24
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0039
            r8 = 0
            goto L_0x003b
        L_0x0039:
            r8 = r25
        L_0x003b:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0041
            r9 = 0
            goto L_0x0043
        L_0x0041:
            r9 = r26
        L_0x0043:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0049
            r10 = 0
            goto L_0x004b
        L_0x0049:
            r10 = r27
        L_0x004b:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0051
            r11 = 0
            goto L_0x0053
        L_0x0051:
            r11 = r28
        L_0x0053:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0059
            r12 = 0
            goto L_0x005b
        L_0x0059:
            r12 = r29
        L_0x005b:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0064
            java.util.List r13 = S2.C1601o.h()
            goto L_0x0066
        L_0x0064:
            r13 = r30
        L_0x0066:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006f
            java.util.List r14 = S2.C1601o.h()
            goto L_0x0071
        L_0x006f:
            r14 = r31
        L_0x0071:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0077
            r15 = 0
            goto L_0x0079
        L_0x0077:
            r15 = r32
        L_0x0079:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x007f
            r2 = 0
            goto L_0x0081
        L_0x007f:
            r2 = r33
        L_0x0081:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x008b
            r16 = 0
            goto L_0x008d
        L_0x008b:
            r16 = r34
        L_0x008d:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x00b8
            r36 = 0
        L_0x0095:
            r19 = r18
            r20 = r1
            r34 = r2
            r21 = r3
            r22 = r4
            r23 = r5
            r24 = r6
            r25 = r7
            r26 = r8
            r27 = r9
            r28 = r10
            r29 = r11
            r30 = r12
            r31 = r13
            r32 = r14
            r33 = r15
            r35 = r16
            goto L_0x00bb
        L_0x00b8:
            r36 = r35
            goto L_0x0095
        L_0x00bb:
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.cmp.core.model.mspa.USRegulationData.<init>(int, java.lang.String, int, int, int, int, int, int, int, int, int, java.util.List, java.util.List, int, int, int, int, int, kotlin.jvm.internal.g):void");
    }
}
