package com.mbridge.msdk.tracker.network;

import android.util.Log;
import java.util.List;
import java.util.Locale;

public class ae {

    /* renamed from: a  reason: collision with root package name */
    public static String f15511a = "TrackManager_Volley";

    /* renamed from: b  reason: collision with root package name */
    private static final String f15512b = "com.mbridge.msdk.tracker.network.ae";

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final List<C0202a> f15513a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f15514b;

        /* renamed from: com.mbridge.msdk.tracker.network.ae$a$a  reason: collision with other inner class name */
        private static class C0202a {

            /* renamed from: a  reason: collision with root package name */
            public final String f15515a;

            /* renamed from: b  reason: collision with root package name */
            public final long f15516b;

            /* renamed from: c  reason: collision with root package name */
            public final long f15517c;
        }

        /* access modifiers changed from: protected */
        public final void finalize() throws Throwable {
            long j4;
            if (!this.f15514b) {
                this.f15514b = true;
                if (this.f15513a.size() == 0) {
                    j4 = 0;
                } else {
                    long j5 = this.f15513a.get(0).f15517c;
                    List<C0202a> list = this.f15513a;
                    j4 = list.get(list.size() - 1).f15517c - j5;
                }
                if (j4 > 0) {
                    long j6 = this.f15513a.get(0).f15517c;
                    ae.b("(%-4d ms) %s", Long.valueOf(j4), "Request on the loose");
                    for (C0202a next : this.f15513a) {
                        long j7 = next.f15517c;
                        ae.b("(+%-4d) [%2d] %s", Long.valueOf(j7 - j6), Long.valueOf(next.f15516b), next.f15515a);
                        j6 = j7;
                    }
                }
                ae.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    public static void a(String str, Object... objArr) {
    }

    public static void b(String str, Object... objArr) {
        Log.d(f15511a, d(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f15511a, d(str, objArr));
    }

    private static String d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i4 = 2;
        while (true) {
            if (i4 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i4].getClassName().equals(f15512b)) {
                String className = stackTrace[i4].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i4].getMethodName();
                break;
            } else {
                i4++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(f15511a, d(str, objArr), th);
    }
}
