package androidx.work.impl.constraints;

public final class NetworkState {
    private final boolean isConnected;
    private final boolean isMetered;
    private final boolean isNotRoaming;
    private final boolean isValidated;

    public NetworkState(boolean z4, boolean z5, boolean z6, boolean z7) {
        this.isConnected = z4;
        this.isValidated = z5;
        this.isMetered = z6;
        this.isNotRoaming = z7;
    }

    public static /* synthetic */ NetworkState copy$default(NetworkState networkState, boolean z4, boolean z5, boolean z6, boolean z7, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = networkState.isConnected;
        }
        if ((i4 & 2) != 0) {
            z5 = networkState.isValidated;
        }
        if ((i4 & 4) != 0) {
            z6 = networkState.isMetered;
        }
        if ((i4 & 8) != 0) {
            z7 = networkState.isNotRoaming;
        }
        return networkState.copy(z4, z5, z6, z7);
    }

    public final boolean component1() {
        return this.isConnected;
    }

    public final boolean component2() {
        return this.isValidated;
    }

    public final boolean component3() {
        return this.isMetered;
    }

    public final boolean component4() {
        return this.isNotRoaming;
    }

    public final NetworkState copy(boolean z4, boolean z5, boolean z6, boolean z7) {
        return new NetworkState(z4, z5, z6, z7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        return this.isConnected == networkState.isConnected && this.isValidated == networkState.isValidated && this.isMetered == networkState.isMetered && this.isNotRoaming == networkState.isNotRoaming;
    }

    public int hashCode() {
        boolean z4 = this.isConnected;
        boolean z5 = true;
        if (z4) {
            z4 = true;
        }
        int i4 = (z4 ? 1 : 0) * true;
        boolean z6 = this.isValidated;
        if (z6) {
            z6 = true;
        }
        int i5 = (i4 + (z6 ? 1 : 0)) * 31;
        boolean z7 = this.isMetered;
        if (z7) {
            z7 = true;
        }
        int i6 = (i5 + (z7 ? 1 : 0)) * 31;
        boolean z8 = this.isNotRoaming;
        if (!z8) {
            z5 = z8;
        }
        return i6 + (z5 ? 1 : 0);
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isMetered() {
        return this.isMetered;
    }

    public final boolean isNotRoaming() {
        return this.isNotRoaming;
    }

    public final boolean isValidated() {
        return this.isValidated;
    }

    public String toString() {
        return "NetworkState(isConnected=" + this.isConnected + ", isValidated=" + this.isValidated + ", isMetered=" + this.isMetered + ", isNotRoaming=" + this.isNotRoaming + ')';
    }
}
