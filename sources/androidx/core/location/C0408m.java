package androidx.core.location;

import android.location.Location;
import android.os.Bundle;
import java.util.List;

/* renamed from: androidx.core.location.m  reason: case insensitive filesystem */
public abstract /* synthetic */ class C0408m {
    public static void b(LocationListenerCompat locationListenerCompat, List list) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            locationListenerCompat.onLocationChanged((Location) list.get(i4));
        }
    }

    public static void a(LocationListenerCompat locationListenerCompat, int i4) {
    }

    public static void c(LocationListenerCompat locationListenerCompat, String str) {
    }

    public static void d(LocationListenerCompat locationListenerCompat, String str) {
    }

    public static void e(LocationListenerCompat locationListenerCompat, String str, int i4, Bundle bundle) {
    }
}
