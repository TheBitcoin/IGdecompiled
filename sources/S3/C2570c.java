package S3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: S3.c  reason: case insensitive filesystem */
public class C2570c {

    /* renamed from: a  reason: collision with root package name */
    private final ConnectivityManager f23942a;

    /* renamed from: S3.c$a */
    public enum a {
        NONE,
        MOBILE,
        WIFI
    }

    public C2570c(Context context) {
        this.f23942a = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public a a() {
        NetworkInfo activeNetworkInfo = this.f23942a.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return a.NONE;
        }
        if (activeNetworkInfo.getType() == 1) {
            return a.WIFI;
        }
        return a.MOBILE;
    }

    public boolean b() {
        NetworkInfo activeNetworkInfo = this.f23942a.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }
}
