package com.google.firebase.messaging;

import R.k;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.C1790d;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k0.C0940o;

/* renamed from: com.google.firebase.messaging.f  reason: case insensitive filesystem */
class C1792f {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f11362a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f11363b;

    /* renamed from: c  reason: collision with root package name */
    private final J f11364c;

    public C1792f(Context context, J j4, ExecutorService executorService) {
        this.f11362a = executorService;
        this.f11363b = context;
        this.f11364c = j4;
    }

    private boolean b() {
        if (((KeyguardManager) this.f11363b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!k.f()) {
            SystemClock.sleep(10);
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f11363b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    if (next.importance == 100) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void c(C1790d.a aVar) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f11363b.getSystemService("notification")).notify(aVar.f11350b, aVar.f11351c, aVar.f11349a.build());
    }

    private F d() {
        F i4 = F.i(this.f11364c.p("gcm.n.image"));
        if (i4 != null) {
            i4.l(this.f11362a);
        }
        return i4;
    }

    private void e(NotificationCompat.Builder builder, F f4) {
        if (f4 != null) {
            try {
                Bitmap bitmap = (Bitmap) C0940o.b(f4.k(), 5, TimeUnit.SECONDS);
                builder.setLargeIcon(bitmap);
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon((Bitmap) null));
            } catch (ExecutionException e5) {
                Log.w("FirebaseMessaging", "Failed to download image: " + e5.getCause());
            } catch (InterruptedException unused) {
                Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
                f4.close();
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
                f4.close();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        if (this.f11364c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        F d5 = d();
        C1790d.a e5 = C1790d.e(this.f11363b, this.f11364c);
        e(e5.f11349a, d5);
        c(e5);
        return true;
    }
}
