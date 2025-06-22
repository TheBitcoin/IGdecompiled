package androidx.privacysandbox.ads.adservices.topics;

import androidx.privacysandbox.ads.adservices.adid.a;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class GetTopicsRequest {
    private final String adsSdkName;
    private final boolean shouldRecordObservation;

    public static final class Builder {
        private String adsSdkName = "";
        private boolean shouldRecordObservation = true;

        public final GetTopicsRequest build() {
            if (this.adsSdkName.length() > 0) {
                return new GetTopicsRequest(this.adsSdkName, this.shouldRecordObservation);
            }
            throw new IllegalStateException("adsSdkName must be set");
        }

        public final Builder setAdsSdkName(String str) {
            m.e(str, "adsSdkName");
            this.adsSdkName = str;
            return this;
        }

        public final Builder setShouldRecordObservation(boolean z4) {
            this.shouldRecordObservation = z4;
            return this;
        }
    }

    public GetTopicsRequest() {
        this((String) null, false, 3, (C2103g) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsRequest)) {
            return false;
        }
        GetTopicsRequest getTopicsRequest = (GetTopicsRequest) obj;
        if (!m.a(this.adsSdkName, getTopicsRequest.adsSdkName) || this.shouldRecordObservation != getTopicsRequest.shouldRecordObservation) {
            return false;
        }
        return true;
    }

    public final String getAdsSdkName() {
        return this.adsSdkName;
    }

    public int hashCode() {
        return (this.adsSdkName.hashCode() * 31) + a.a(this.shouldRecordObservation);
    }

    public final boolean shouldRecordObservation() {
        return this.shouldRecordObservation;
    }

    public String toString() {
        return "GetTopicsRequest: adsSdkName=" + this.adsSdkName + ", shouldRecordObservation=" + this.shouldRecordObservation;
    }

    public GetTopicsRequest(String str, boolean z4) {
        m.e(str, "adsSdkName");
        this.adsSdkName = str;
        this.shouldRecordObservation = z4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetTopicsRequest(String str, boolean z4, int i4, C2103g gVar) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? false : z4);
    }
}
