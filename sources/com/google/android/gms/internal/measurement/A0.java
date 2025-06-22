package com.google.android.gms.internal.measurement;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import l0.h;

public final class A0 {

    /* renamed from: b  reason: collision with root package name */
    private static final Method f1394b = e();

    /* renamed from: c  reason: collision with root package name */
    private static final Method f1395c = d();

    /* renamed from: a  reason: collision with root package name */
    private final JobScheduler f1396a;

    private A0(JobScheduler jobScheduler) {
        this.f1396a = jobScheduler;
    }

    private static int a() {
        Method method = f1395c;
        if (method != null) {
            try {
                Integer num = (Integer) method.invoke(UserHandle.class, (Object[]) null);
                if (num != null) {
                    return num.intValue();
                }
                return 0;
            } catch (IllegalAccessException | InvocationTargetException e5) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "myUserId invocation illegal", e5);
                }
            }
        }
        return 0;
    }

    private final int b(JobInfo jobInfo, String str, int i4, String str2) {
        Method method = f1394b;
        if (method != null) {
            try {
                Integer num = (Integer) method.invoke(this.f1396a, new Object[]{jobInfo, str, Integer.valueOf(i4), str2});
                if (num != null) {
                    return num.intValue();
                }
                return 0;
            } catch (IllegalAccessException | InvocationTargetException e5) {
                Log.e(str2, "error calling scheduleAsPackage", e5);
            }
        }
        return this.f1396a.schedule(jobInfo);
    }

    public static int c(Context context, JobInfo jobInfo, String str, String str2) {
        JobScheduler jobScheduler = (JobScheduler) h.i((JobScheduler) context.getSystemService("jobscheduler"));
        if (f1394b == null || context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") != 0) {
            return jobScheduler.schedule(jobInfo);
        }
        return new A0(jobScheduler).b(jobInfo, str, a(), str2);
    }

    private static Method d() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return UserHandle.class.getDeclaredMethod("myUserId", (Class[]) null);
            } catch (NoSuchMethodException unused) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No myUserId method available");
                }
            }
        }
        return null;
    }

    private static Method e() {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        try {
            Class<String> cls = String.class;
            return JobScheduler.class.getDeclaredMethod("scheduleAsPackage", new Class[]{JobInfo.class, cls, Integer.TYPE, cls});
        } catch (NoSuchMethodException unused) {
            if (!Log.isLoggable("JobSchedulerCompat", 6)) {
                return null;
            }
            Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
            return null;
        }
    }
}
