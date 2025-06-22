package com.inmobi.cmp.core.model;

import A2.a;
import androidx.annotation.Keep;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

@Keep
public final class ACData {
    private final String acString;

    public ACData() {
        this((String) null, 1, (C2103g) null);
    }

    public static /* synthetic */ ACData copy$default(ACData aCData, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = aCData.acString;
        }
        return aCData.copy(str);
    }

    public final String component1() {
        return this.acString;
    }

    public final ACData copy(String str) {
        return new ACData(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ACData) && m.a(this.acString, ((ACData) obj).acString);
    }

    public final String getAcString() {
        return this.acString;
    }

    public int hashCode() {
        String str = this.acString;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        StringBuilder a5 = a.a("ACData(acString=");
        a5.append(this.acString);
        a5.append(')');
        return a5.toString();
    }

    public ACData(String str) {
        this.acString = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ACData(String str, int i4, C2103g gVar) {
        this((i4 & 1) != 0 ? null : str);
    }
}
