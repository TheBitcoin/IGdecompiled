package androidx.privacysandbox.ads.adservices.adselection;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.m;

public final class AdSelectionConfig {
    private final AdSelectionSignals adSelectionSignals;
    private final List<AdTechIdentifier> customAudienceBuyers;
    private final Uri decisionLogicUri;
    private final Map<AdTechIdentifier, AdSelectionSignals> perBuyerSignals;
    private final AdTechIdentifier seller;
    private final AdSelectionSignals sellerSignals;
    private final Uri trustedScoringSignalsUri;

    public AdSelectionConfig(AdTechIdentifier adTechIdentifier, Uri uri, List<AdTechIdentifier> list, AdSelectionSignals adSelectionSignals2, AdSelectionSignals adSelectionSignals3, Map<AdTechIdentifier, AdSelectionSignals> map, Uri uri2) {
        m.e(adTechIdentifier, "seller");
        m.e(uri, "decisionLogicUri");
        m.e(list, "customAudienceBuyers");
        m.e(adSelectionSignals2, "adSelectionSignals");
        m.e(adSelectionSignals3, "sellerSignals");
        m.e(map, "perBuyerSignals");
        m.e(uri2, "trustedScoringSignalsUri");
        this.seller = adTechIdentifier;
        this.decisionLogicUri = uri;
        this.customAudienceBuyers = list;
        this.adSelectionSignals = adSelectionSignals2;
        this.sellerSignals = adSelectionSignals3;
        this.perBuyerSignals = map;
        this.trustedScoringSignalsUri = uri2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionConfig)) {
            return false;
        }
        AdSelectionConfig adSelectionConfig = (AdSelectionConfig) obj;
        if (!m.a(this.seller, adSelectionConfig.seller) || !m.a(this.decisionLogicUri, adSelectionConfig.decisionLogicUri) || !m.a(this.customAudienceBuyers, adSelectionConfig.customAudienceBuyers) || !m.a(this.adSelectionSignals, adSelectionConfig.adSelectionSignals) || !m.a(this.sellerSignals, adSelectionConfig.sellerSignals) || !m.a(this.perBuyerSignals, adSelectionConfig.perBuyerSignals) || !m.a(this.trustedScoringSignalsUri, adSelectionConfig.trustedScoringSignalsUri)) {
            return false;
        }
        return true;
    }

    public final AdSelectionSignals getAdSelectionSignals() {
        return this.adSelectionSignals;
    }

    public final List<AdTechIdentifier> getCustomAudienceBuyers() {
        return this.customAudienceBuyers;
    }

    public final Uri getDecisionLogicUri() {
        return this.decisionLogicUri;
    }

    public final Map<AdTechIdentifier, AdSelectionSignals> getPerBuyerSignals() {
        return this.perBuyerSignals;
    }

    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public final AdSelectionSignals getSellerSignals() {
        return this.sellerSignals;
    }

    public final Uri getTrustedScoringSignalsUri() {
        return this.trustedScoringSignalsUri;
    }

    public int hashCode() {
        return (((((((((((this.seller.hashCode() * 31) + this.decisionLogicUri.hashCode()) * 31) + this.customAudienceBuyers.hashCode()) * 31) + this.adSelectionSignals.hashCode()) * 31) + this.sellerSignals.hashCode()) * 31) + this.perBuyerSignals.hashCode()) * 31) + this.trustedScoringSignalsUri.hashCode();
    }

    public String toString() {
        return "AdSelectionConfig: seller=" + this.seller + ", decisionLogicUri='" + this.decisionLogicUri + "', customAudienceBuyers=" + this.customAudienceBuyers + ", adSelectionSignals=" + this.adSelectionSignals + ", sellerSignals=" + this.sellerSignals + ", perBuyerSignals=" + this.perBuyerSignals + ", trustedScoringSignalsUri=" + this.trustedScoringSignalsUri;
    }
}
