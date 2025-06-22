package androidx.privacysandbox.ads.adservices.common;

import android.net.Uri;
import kotlin.jvm.internal.m;

public final class AdData {
    private final String metadata;
    private final Uri renderUri;

    public AdData(Uri uri, String str) {
        m.e(uri, "renderUri");
        m.e(str, TtmlNode.TAG_METADATA);
        this.renderUri = uri;
        this.metadata = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdData)) {
            return false;
        }
        AdData adData = (AdData) obj;
        if (!m.a(this.renderUri, adData.renderUri) || !m.a(this.metadata, adData.metadata)) {
            return false;
        }
        return true;
    }

    public final String getMetadata() {
        return this.metadata;
    }

    public final Uri getRenderUri() {
        return this.renderUri;
    }

    public int hashCode() {
        return (this.renderUri.hashCode() * 31) + this.metadata.hashCode();
    }

    public String toString() {
        return "AdData: renderUri=" + this.renderUri + ", metadata='" + this.metadata + '\'';
    }
}
