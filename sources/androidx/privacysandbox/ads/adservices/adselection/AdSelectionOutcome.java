package androidx.privacysandbox.ads.adservices.adselection;

import android.net.Uri;
import kotlin.jvm.internal.m;

public final class AdSelectionOutcome {
    private final long adSelectionId;
    private final Uri renderUri;

    public AdSelectionOutcome(long j4, Uri uri) {
        m.e(uri, "renderUri");
        this.adSelectionId = j4;
        this.renderUri = uri;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionOutcome)) {
            return false;
        }
        AdSelectionOutcome adSelectionOutcome = (AdSelectionOutcome) obj;
        if (this.adSelectionId != adSelectionOutcome.adSelectionId || !m.a(this.renderUri, adSelectionOutcome.renderUri)) {
            return false;
        }
        return true;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public final Uri getRenderUri() {
        return this.renderUri;
    }

    public int hashCode() {
        return (u.a(this.adSelectionId) * 31) + this.renderUri.hashCode();
    }

    public String toString() {
        return "AdSelectionOutcome: adSelectionId=" + this.adSelectionId + ", renderUri=" + this.renderUri;
    }
}
