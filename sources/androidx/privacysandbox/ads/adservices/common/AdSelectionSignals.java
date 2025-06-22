package androidx.privacysandbox.ads.adservices.common;

import kotlin.jvm.internal.m;

public final class AdSelectionSignals {
    private final String signals;

    public AdSelectionSignals(String str) {
        m.e(str, "signals");
        this.signals = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionSignals)) {
            return false;
        }
        return m.a(this.signals, ((AdSelectionSignals) obj).signals);
    }

    public final String getSignals() {
        return this.signals;
    }

    public int hashCode() {
        return this.signals.hashCode();
    }

    public String toString() {
        return "AdSelectionSignals: " + this.signals;
    }
}
