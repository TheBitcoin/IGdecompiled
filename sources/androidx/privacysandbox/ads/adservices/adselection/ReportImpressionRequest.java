package androidx.privacysandbox.ads.adservices.adselection;

import kotlin.jvm.internal.m;

public final class ReportImpressionRequest {
    private final AdSelectionConfig adSelectionConfig;
    private final long adSelectionId;

    public ReportImpressionRequest(long j4, AdSelectionConfig adSelectionConfig2) {
        m.e(adSelectionConfig2, "adSelectionConfig");
        this.adSelectionId = j4;
        this.adSelectionConfig = adSelectionConfig2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportImpressionRequest)) {
            return false;
        }
        ReportImpressionRequest reportImpressionRequest = (ReportImpressionRequest) obj;
        if (this.adSelectionId != reportImpressionRequest.adSelectionId || !m.a(this.adSelectionConfig, reportImpressionRequest.adSelectionConfig)) {
            return false;
        }
        return true;
    }

    public final AdSelectionConfig getAdSelectionConfig() {
        return this.adSelectionConfig;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public int hashCode() {
        return (u.a(this.adSelectionId) * 31) + this.adSelectionConfig.hashCode();
    }

    public String toString() {
        return "ReportImpressionRequest: adSelectionId=" + this.adSelectionId + ", adSelectionConfig=" + this.adSelectionConfig;
    }
}
