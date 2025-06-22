package R;

import T.e;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.lang.reflect.Method;

public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    private static final int f622a = Process.myUid();

    /* renamed from: b  reason: collision with root package name */
    private static final Method f623b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f624c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f625d;

    /* renamed from: e  reason: collision with root package name */
    private static final Method f626e;

    /* renamed from: f  reason: collision with root package name */
    private static final Method f627f;

    /* renamed from: g  reason: collision with root package name */
    private static final Method f628g;

    /* renamed from: h  reason: collision with root package name */
    private static final Method f629h;

    /* renamed from: i  reason: collision with root package name */
    private static final Method f630i;

    /* renamed from: j  reason: collision with root package name */
    private static Boolean f631j = null;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a1  */
    static {
        /*
            r0 = 2
            r1 = 0
            r2 = 1
            java.lang.String r3 = "add"
            java.lang.Class r4 = java.lang.Integer.TYPE
            java.lang.Class<android.os.WorkSource> r5 = android.os.WorkSource.class
            int r6 = android.os.Process.myUid()
            f622a = r6
            r6 = 0
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0019 }
            r7[r1] = r4     // Catch:{ Exception -> 0x0019 }
            java.lang.reflect.Method r7 = r5.getMethod(r3, r7)     // Catch:{ Exception -> 0x0019 }
            goto L_0x001b
        L_0x0019:
            r7 = r6
        L_0x001b:
            f623b = r7
            boolean r7 = R.k.c()
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            if (r7 == 0) goto L_0x0030
            java.lang.Class[] r7 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0030 }
            r7[r1] = r4     // Catch:{ Exception -> 0x0030 }
            r7[r2] = r8     // Catch:{ Exception -> 0x0030 }
            java.lang.reflect.Method r3 = r5.getMethod(r3, r7)     // Catch:{ Exception -> 0x0030 }
            goto L_0x0031
        L_0x0030:
            r3 = r6
        L_0x0031:
            f624c = r3
            java.lang.String r3 = "size"
            java.lang.reflect.Method r3 = r5.getMethod(r3, r6)     // Catch:{ Exception -> 0x003a }
            goto L_0x003b
        L_0x003a:
            r3 = r6
        L_0x003b:
            f625d = r3
            java.lang.String r3 = "get"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0048 }
            r7[r1] = r4     // Catch:{ Exception -> 0x0048 }
            java.lang.reflect.Method r3 = r5.getMethod(r3, r7)     // Catch:{ Exception -> 0x0048 }
            goto L_0x004a
        L_0x0048:
            r3 = r6
        L_0x004a:
            f626e = r3
            boolean r3 = R.k.c()
            if (r3 == 0) goto L_0x005e
            java.lang.String r3 = "getName"
            java.lang.Class[] r7 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x005d }
            r7[r1] = r4     // Catch:{ Exception -> 0x005d }
            java.lang.reflect.Method r3 = r5.getMethod(r3, r7)     // Catch:{ Exception -> 0x005d }
            goto L_0x005f
        L_0x005d:
        L_0x005e:
            r3 = r6
        L_0x005f:
            f627f = r3
            boolean r3 = R.k.i()
            java.lang.String r7 = "WorkSourceUtil"
            if (r3 == 0) goto L_0x0076
            java.lang.String r3 = "createWorkChain"
            java.lang.reflect.Method r3 = r5.getMethod(r3, r6)     // Catch:{ Exception -> 0x0070 }
            goto L_0x0077
        L_0x0070:
            r3 = move-exception
            java.lang.String r9 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r7, r9, r3)
        L_0x0076:
            r3 = r6
        L_0x0077:
            f628g = r3
            boolean r3 = R.k.i()
            if (r3 == 0) goto L_0x0098
            java.lang.String r3 = "android.os.WorkSource$WorkChain"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ Exception -> 0x0092 }
            java.lang.String r9 = "addNode"
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0092 }
            r0[r1] = r4     // Catch:{ Exception -> 0x0092 }
            r0[r2] = r8     // Catch:{ Exception -> 0x0092 }
            java.lang.reflect.Method r0 = r3.getMethod(r9, r0)     // Catch:{ Exception -> 0x0092 }
            goto L_0x0099
        L_0x0092:
            r0 = move-exception
            java.lang.String r1 = "Missing WorkChain class"
            android.util.Log.w(r7, r1, r0)
        L_0x0098:
            r0 = r6
        L_0x0099:
            f629h = r0
            boolean r0 = R.k.i()
            if (r0 == 0) goto L_0x00ab
            java.lang.String r0 = "isEmpty"
            java.lang.reflect.Method r0 = r5.getMethod(r0, r6)     // Catch:{ Exception -> 0x00ab }
            r0.setAccessible(r2)     // Catch:{ Exception -> 0x00ac }
            goto L_0x00ac
        L_0x00ab:
            r0 = r6
        L_0x00ac:
            f630i = r0
            f631j = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: R.p.<clinit>():void");
    }

    public static void a(WorkSource workSource, int i4, String str) {
        Method method = f624c;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(i4), str});
            } catch (Exception e5) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e5);
            }
        } else {
            Method method2 = f623b;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(i4)});
                } catch (Exception e6) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e6);
                }
            }
        }
    }

    public static WorkSource b(Context context, String str) {
        if (!(context == null || context.getPackageManager() == null || str == null)) {
            try {
                ApplicationInfo c5 = e.a(context).c(str, 0);
                if (c5 == null) {
                    Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
                    return null;
                }
                int i4 = c5.uid;
                WorkSource workSource = new WorkSource();
                a(workSource, i4, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
            }
        }
        return null;
    }

    public static synchronized boolean c(Context context) {
        synchronized (p.class) {
            Boolean bool = f631j;
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                return booleanValue;
            }
            boolean z4 = false;
            if (context == null) {
                return false;
            }
            if (ContextCompat.checkSelfPermission(context, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                z4 = true;
            }
            f631j = Boolean.valueOf(z4);
            return z4;
        }
    }
}
