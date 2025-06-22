package G;

import K.g;
import K.h;
import L.l;
import M.C0335p;
import P.a;
import androidx.browser.trusted.sharing.ShareTarget;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class f implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private static final a f211c = new a("RevokeAccessOperation", new String[0]);

    /* renamed from: a  reason: collision with root package name */
    private final String f212a;

    /* renamed from: b  reason: collision with root package name */
    private final l f213b = new l((K.f) null);

    public f(String str) {
        this.f212a = C0335p.f(str);
    }

    public static g a(String str) {
        if (str == null) {
            return h.a(new Status(4), (K.f) null);
        }
        f fVar = new f(str);
        new Thread(fVar).start();
        return fVar.f213b;
    }

    public final void run() {
        Status status = Status.f1251h;
        try {
            String str = this.f212a;
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://accounts.google.com/o/oauth2/revoke?token=" + str).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.f1249f;
            } else {
                f211c.b("Unable to revoke access!", new Object[0]);
            }
            a aVar = f211c;
            aVar.a("Response Code: " + responseCode, new Object[0]);
        } catch (IOException e5) {
            f211c.b("IOException when revoking access: ".concat(String.valueOf(e5.toString())), new Object[0]);
        } catch (Exception e6) {
            f211c.b("Exception when revoking access: ".concat(String.valueOf(e6.toString())), new Object[0]);
        }
        this.f213b.f(status);
    }
}
