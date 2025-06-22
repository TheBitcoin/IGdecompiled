package com.squareup.picasso;

import H1.e;
import N3.C2516g;
import N3.C2517h;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ThreadFactory;

abstract class C {

    /* renamed from: a  reason: collision with root package name */
    static final StringBuilder f17188a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private static final C2517h f17189b = C2517h.f("RIFF");

    /* renamed from: c  reason: collision with root package name */
    private static final C2517h f17190c = C2517h.f("WEBP");

    static class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            sendMessageDelayed(obtainMessage(), 1000);
        }
    }

    private static class b extends Thread {
        b(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    static class c implements ThreadFactory {
        c() {
        }

        public Thread newThread(Runnable runnable) {
            return new b(runnable);
        }
    }

    static long a(File file) {
        long j4;
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j4 = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 50;
        } catch (IllegalArgumentException unused) {
            j4 = 5242880;
        }
        return Math.max(Math.min(j4, 52428800), 5242880);
    }

    static int b(Context context) {
        int i4;
        ActivityManager activityManager = (ActivityManager) o(context, "activity");
        if ((context.getApplicationInfo().flags & 1048576) != 0) {
            i4 = activityManager.getLargeMemoryClass();
        } else {
            i4 = activityManager.getMemoryClass();
        }
        return (int) ((((long) i4) * 1048576) / 7);
    }

    static void c() {
        if (!r()) {
            throw new IllegalStateException("Method call should happen from the main thread.");
        }
    }

    static void d() {
        if (r()) {
            throw new IllegalStateException("Method call should not happen from the main thread.");
        }
    }

    static Object e(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    static File f(Context context) {
        File file = new File(context.getApplicationContext().getCacheDir(), "picasso-cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    static String g(v vVar) {
        StringBuilder sb = f17188a;
        String h4 = h(vVar, sb);
        sb.setLength(0);
        return h4;
    }

    static String h(v vVar, StringBuilder sb) {
        String str = vVar.f17355f;
        if (str != null) {
            sb.ensureCapacity(str.length() + 50);
            sb.append(vVar.f17355f);
        } else {
            Uri uri = vVar.f17353d;
            if (uri != null) {
                String uri2 = uri.toString();
                sb.ensureCapacity(uri2.length() + 50);
                sb.append(uri2);
            } else {
                sb.ensureCapacity(50);
                sb.append(vVar.f17354e);
            }
        }
        sb.append(10);
        if (vVar.f17363n != 0.0f) {
            sb.append("rotation:");
            sb.append(vVar.f17363n);
            if (vVar.f17366q) {
                sb.append('@');
                sb.append(vVar.f17364o);
                sb.append('x');
                sb.append(vVar.f17365p);
            }
            sb.append(10);
        }
        if (vVar.c()) {
            sb.append("resize:");
            sb.append(vVar.f17357h);
            sb.append('x');
            sb.append(vVar.f17358i);
            sb.append(10);
        }
        if (vVar.f17359j) {
            sb.append("centerCrop:");
            sb.append(vVar.f17360k);
            sb.append(10);
        } else if (vVar.f17361l) {
            sb.append("centerInside");
            sb.append(10);
        }
        List list = vVar.f17356g;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                sb.append(((e) vVar.f17356g.get(i4)).key());
                sb.append(10);
            }
        }
        return sb.toString();
    }

    static void i(Looper looper) {
        a aVar = new a(looper);
        aVar.sendMessageDelayed(aVar.obtainMessage(), 1000);
    }

    static int j(Bitmap bitmap) {
        int allocationByteCount = bitmap.getAllocationByteCount();
        if (allocationByteCount >= 0) {
            return allocationByteCount;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    static String k(C1816c cVar) {
        return l(cVar, "");
    }

    static String l(C1816c cVar, String str) {
        StringBuilder sb = new StringBuilder(str);
        C1814a h4 = cVar.h();
        if (h4 != null) {
            sb.append(h4.f17193b.d());
        }
        List i4 = cVar.i();
        if (i4 != null) {
            int size = i4.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (i5 > 0 || h4 != null) {
                    sb.append(", ");
                }
                sb.append(((C1814a) i4.get(i5)).f17193b.d());
            }
        }
        return sb.toString();
    }

    static int m(Resources resources, v vVar) {
        Uri uri;
        int i4 = vVar.f17354e;
        if (i4 != 0 || (uri = vVar.f17353d) == null) {
            return i4;
        }
        String authority = uri.getAuthority();
        if (authority != null) {
            List<String> pathSegments = vVar.f17353d.getPathSegments();
            if (pathSegments == null || pathSegments.isEmpty()) {
                throw new FileNotFoundException("No path segments: " + vVar.f17353d);
            } else if (pathSegments.size() == 1) {
                try {
                    return Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Last path segment is not a resource ID: " + vVar.f17353d);
                }
            } else if (pathSegments.size() == 2) {
                return resources.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + vVar.f17353d);
            }
        } else {
            throw new FileNotFoundException("No package provided: " + vVar.f17353d);
        }
    }

    static Resources n(Context context, v vVar) {
        Uri uri;
        if (vVar.f17354e != 0 || (uri = vVar.f17353d) == null) {
            return context.getResources();
        }
        String authority = uri.getAuthority();
        if (authority != null) {
            try {
                return context.getPackageManager().getResourcesForApplication(authority);
            } catch (PackageManager.NameNotFoundException unused) {
                throw new FileNotFoundException("Unable to obtain resources for package: " + vVar.f17353d);
            }
        } else {
            throw new FileNotFoundException("No package provided: " + vVar.f17353d);
        }
    }

    static Object o(Context context, String str) {
        return context.getSystemService(str);
    }

    static boolean p(Context context, String str) {
        if (context.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    static boolean q(Context context) {
        try {
            if (Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0) {
                return true;
            }
            return false;
        } catch (NullPointerException | SecurityException unused) {
        }
    }

    static boolean r() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    static boolean s(C2516g gVar) {
        if (!gVar.s(0, f17189b) || !gVar.s(8, f17190c)) {
            return false;
        }
        return true;
    }

    static void t(String str, String str2, String str3) {
        u(str, str2, str3, "");
    }

    static void u(String str, String str2, String str3, String str4) {
        Log.d("Picasso", String.format("%1$-11s %2$-12s %3$s %4$s", new Object[]{str, str2, str3, str4}));
    }
}
