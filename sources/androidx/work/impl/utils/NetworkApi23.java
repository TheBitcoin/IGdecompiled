package androidx.work.impl.utils;

import android.net.ConnectivityManager;
import android.net.Network;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.m;

@RequiresApi(23)
public final class NetworkApi23 {
    @DoNotInline
    public static final Network getActiveNetworkCompat(ConnectivityManager connectivityManager) {
        m.e(connectivityManager, "<this>");
        return connectivityManager.getActiveNetwork();
    }
}
