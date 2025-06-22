package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import androidx.annotation.RequiresApi;
import androidx.privacysandbox.ads.adservices.adid.a;
import kotlin.jvm.internal.m;

@RequiresApi(33)
public final class WebSourceParams {
    private final boolean debugKeyAllowed;
    private final Uri registrationUri;

    public WebSourceParams(Uri uri, boolean z4) {
        m.e(uri, "registrationUri");
        this.registrationUri = uri;
        this.debugKeyAllowed = z4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSourceParams)) {
            return false;
        }
        WebSourceParams webSourceParams = (WebSourceParams) obj;
        if (!m.a(this.registrationUri, webSourceParams.registrationUri) || this.debugKeyAllowed != webSourceParams.debugKeyAllowed) {
            return false;
        }
        return true;
    }

    public final boolean getDebugKeyAllowed() {
        return this.debugKeyAllowed;
    }

    public final Uri getRegistrationUri() {
        return this.registrationUri;
    }

    public int hashCode() {
        return (this.registrationUri.hashCode() * 31) + a.a(this.debugKeyAllowed);
    }

    public String toString() {
        return "WebSourceParams { RegistrationUri=" + this.registrationUri + ", DebugKeyAllowed=" + this.debugKeyAllowed + " }";
    }
}
