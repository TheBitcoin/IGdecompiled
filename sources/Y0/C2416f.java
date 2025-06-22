package y0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.app.NotificationCompat;
import v0.g;

/* renamed from: y0.f  reason: case insensitive filesystem */
class C2416f {

    /* renamed from: a  reason: collision with root package name */
    private final Float f22634a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22635b;

    private C2416f(Float f4, boolean z4) {
        this.f22635b = z4;
        this.f22634a = f4;
    }

    public static C2416f a(Context context) {
        boolean z4 = false;
        Float f4 = null;
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                z4 = e(registerReceiver);
                f4 = d(registerReceiver);
            }
        } catch (IllegalStateException e5) {
            g.f().e("An error occurred getting battery state.", e5);
        }
        return new C2416f(f4, z4);
    }

    private static Float d(Intent intent) {
        int intExtra = intent.getIntExtra("level", -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return null;
        }
        return Float.valueOf(((float) intExtra) / ((float) intExtra2));
    }

    private static boolean e(Intent intent) {
        int intExtra = intent.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
        if (intExtra == -1) {
            return false;
        }
        if (intExtra == 2 || intExtra == 5) {
            return true;
        }
        return false;
    }

    public Float b() {
        return this.f22634a;
    }

    public int c() {
        Float f4;
        if (!this.f22635b || (f4 = this.f22634a) == null) {
            return 1;
        }
        if (((double) f4.floatValue()) < 0.99d) {
            return 2;
        }
        return 3;
    }
}
