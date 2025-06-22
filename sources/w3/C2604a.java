package W3;

import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

/* renamed from: W3.a  reason: case insensitive filesystem */
public final class C2604a {

    /* renamed from: a  reason: collision with root package name */
    public final ConnectivityManager f24233a;

    public C2604a(ConnectivityManager connectivityManager) {
        this.f24233a = connectivityManager;
    }

    public final boolean a() {
        ConnectivityManager connectivityManager = this.f24233a;
        if (connectivityManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16)) {
                return true;
            }
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        return activeNetworkInfo.isConnected();
    }
}
