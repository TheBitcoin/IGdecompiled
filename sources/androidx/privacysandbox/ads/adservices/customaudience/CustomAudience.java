package androidx.privacysandbox.ads.adservices.customaudience;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.AdData;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.entity.b;
import j$.time.Instant;
import java.util.List;
import kotlin.jvm.internal.m;

public final class CustomAudience {
    private final Instant activationTime;
    private final List<AdData> ads;
    private final Uri biddingLogicUri;
    private final AdTechIdentifier buyer;
    private final Uri dailyUpdateUri;
    private final Instant expirationTime;
    private final String name;
    private final TrustedBiddingData trustedBiddingSignals;
    private final AdSelectionSignals userBiddingSignals;

    public static final class Builder {
        private Instant activationTime;
        private List<AdData> ads;
        private Uri biddingLogicUri;
        private AdTechIdentifier buyer;
        private Uri dailyUpdateUri;
        private Instant expirationTime;
        private String name;
        private TrustedBiddingData trustedBiddingData;
        private AdSelectionSignals userBiddingSignals;

        public Builder(AdTechIdentifier adTechIdentifier, String str, Uri uri, Uri uri2, List<AdData> list) {
            m.e(adTechIdentifier, "buyer");
            m.e(str, RewardPlus.NAME);
            m.e(uri, "dailyUpdateUri");
            m.e(uri2, "biddingLogicUri");
            m.e(list, b.JSON_KEY_ADS);
            this.buyer = adTechIdentifier;
            this.name = str;
            this.dailyUpdateUri = uri;
            this.biddingLogicUri = uri2;
            this.ads = list;
        }

        public final CustomAudience build() {
            return new CustomAudience(this.buyer, this.name, this.dailyUpdateUri, this.biddingLogicUri, this.ads, this.activationTime, this.expirationTime, this.userBiddingSignals, this.trustedBiddingData);
        }

        public final Builder setActivationTime(Instant instant) {
            m.e(instant, "activationTime");
            this.activationTime = instant;
            return this;
        }

        public final Builder setAds(List<AdData> list) {
            m.e(list, b.JSON_KEY_ADS);
            this.ads = list;
            return this;
        }

        public final Builder setBiddingLogicUri(Uri uri) {
            m.e(uri, "biddingLogicUri");
            this.biddingLogicUri = uri;
            return this;
        }

        public final Builder setBuyer(AdTechIdentifier adTechIdentifier) {
            m.e(adTechIdentifier, "buyer");
            this.buyer = adTechIdentifier;
            return this;
        }

        public final Builder setDailyUpdateUri(Uri uri) {
            m.e(uri, "dailyUpdateUri");
            this.dailyUpdateUri = uri;
            return this;
        }

        public final Builder setExpirationTime(Instant instant) {
            m.e(instant, "expirationTime");
            this.expirationTime = instant;
            return this;
        }

        public final Builder setName(String str) {
            m.e(str, RewardPlus.NAME);
            this.name = str;
            return this;
        }

        public final Builder setTrustedBiddingData(TrustedBiddingData trustedBiddingData2) {
            m.e(trustedBiddingData2, "trustedBiddingSignals");
            this.trustedBiddingData = trustedBiddingData2;
            return this;
        }

        public final Builder setUserBiddingSignals(AdSelectionSignals adSelectionSignals) {
            m.e(adSelectionSignals, "userBiddingSignals");
            this.userBiddingSignals = adSelectionSignals;
            return this;
        }
    }

    public CustomAudience(AdTechIdentifier adTechIdentifier, String str, Uri uri, Uri uri2, List<AdData> list, Instant instant, Instant instant2, AdSelectionSignals adSelectionSignals, TrustedBiddingData trustedBiddingData) {
        m.e(adTechIdentifier, "buyer");
        m.e(str, RewardPlus.NAME);
        m.e(uri, "dailyUpdateUri");
        m.e(uri2, "biddingLogicUri");
        m.e(list, b.JSON_KEY_ADS);
        this.buyer = adTechIdentifier;
        this.name = str;
        this.dailyUpdateUri = uri;
        this.biddingLogicUri = uri2;
        this.ads = list;
        this.activationTime = instant;
        this.expirationTime = instant2;
        this.userBiddingSignals = adSelectionSignals;
        this.trustedBiddingSignals = trustedBiddingData;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomAudience)) {
            return false;
        }
        CustomAudience customAudience = (CustomAudience) obj;
        if (!m.a(this.buyer, customAudience.buyer) || !m.a(this.name, customAudience.name) || !m.a(this.activationTime, customAudience.activationTime) || !m.a(this.expirationTime, customAudience.expirationTime) || !m.a(this.dailyUpdateUri, customAudience.dailyUpdateUri) || !m.a(this.userBiddingSignals, customAudience.userBiddingSignals) || !m.a(this.trustedBiddingSignals, customAudience.trustedBiddingSignals) || !m.a(this.ads, customAudience.ads)) {
            return false;
        }
        return true;
    }

    public final Instant getActivationTime() {
        return this.activationTime;
    }

    public final List<AdData> getAds() {
        return this.ads;
    }

    public final Uri getBiddingLogicUri() {
        return this.biddingLogicUri;
    }

    public final AdTechIdentifier getBuyer() {
        return this.buyer;
    }

    public final Uri getDailyUpdateUri() {
        return this.dailyUpdateUri;
    }

    public final Instant getExpirationTime() {
        return this.expirationTime;
    }

    public final String getName() {
        return this.name;
    }

    public final TrustedBiddingData getTrustedBiddingSignals() {
        return this.trustedBiddingSignals;
    }

    public final AdSelectionSignals getUserBiddingSignals() {
        return this.userBiddingSignals;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i6;
        int hashCode = ((this.buyer.hashCode() * 31) + this.name.hashCode()) * 31;
        Instant instant = this.activationTime;
        int i7 = 0;
        if (instant != null) {
            i4 = instant.hashCode();
        } else {
            i4 = 0;
        }
        int i8 = (hashCode + i4) * 31;
        Instant instant2 = this.expirationTime;
        if (instant2 != null) {
            i5 = instant2.hashCode();
        } else {
            i5 = 0;
        }
        int hashCode2 = (((i8 + i5) * 31) + this.dailyUpdateUri.hashCode()) * 31;
        AdSelectionSignals adSelectionSignals = this.userBiddingSignals;
        if (adSelectionSignals != null) {
            i6 = adSelectionSignals.hashCode();
        } else {
            i6 = 0;
        }
        int i9 = (hashCode2 + i6) * 31;
        TrustedBiddingData trustedBiddingData = this.trustedBiddingSignals;
        if (trustedBiddingData != null) {
            i7 = trustedBiddingData.hashCode();
        }
        return ((((i9 + i7) * 31) + this.biddingLogicUri.hashCode()) * 31) + this.ads.hashCode();
    }

    public String toString() {
        return "CustomAudience: buyer=" + this.biddingLogicUri + ", activationTime=" + this.activationTime + ", expirationTime=" + this.expirationTime + ", dailyUpdateUri=" + this.dailyUpdateUri + ", userBiddingSignals=" + this.userBiddingSignals + ", trustedBiddingSignals=" + this.trustedBiddingSignals + ", biddingLogicUri=" + this.biddingLogicUri + ", ads=" + this.ads;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CustomAudience(androidx.privacysandbox.ads.adservices.common.AdTechIdentifier r2, java.lang.String r3, android.net.Uri r4, android.net.Uri r5, java.util.List r6, j$.time.Instant r7, j$.time.Instant r8, androidx.privacysandbox.ads.adservices.common.AdSelectionSignals r9, androidx.privacysandbox.ads.adservices.customaudience.TrustedBiddingData r10, int r11, kotlin.jvm.internal.C2103g r12) {
        /*
            r1 = this;
            r12 = r11 & 32
            r0 = 0
            if (r12 == 0) goto L_0x0006
            r7 = r0
        L_0x0006:
            r12 = r11 & 64
            if (r12 == 0) goto L_0x000b
            r8 = r0
        L_0x000b:
            r12 = r11 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x0010
            r9 = r0
        L_0x0010:
            r11 = r11 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x001f
            r11 = r0
        L_0x0015:
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            goto L_0x0021
        L_0x001f:
            r11 = r10
            goto L_0x0015
        L_0x0021:
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.customaudience.CustomAudience.<init>(androidx.privacysandbox.ads.adservices.common.AdTechIdentifier, java.lang.String, android.net.Uri, android.net.Uri, java.util.List, j$.time.Instant, j$.time.Instant, androidx.privacysandbox.ads.adservices.common.AdSelectionSignals, androidx.privacysandbox.ads.adservices.customaudience.TrustedBiddingData, int, kotlin.jvm.internal.g):void");
    }
}
