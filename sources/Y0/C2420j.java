package y0;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import v0.g;

/* renamed from: y0.j  reason: case insensitive filesystem */
public abstract class C2420j {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f22645a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: y0.j$a */
    enum a {
        X86_32,
        X86_64,
        ARM_UNKNOWN,
        PPC,
        PPC64,
        ARMV6,
        ARMV7,
        UNKNOWN,
        ARMV7S,
        ARM64;
        

        /* renamed from: k  reason: collision with root package name */
        private static final Map f22656k = null;

        static {
            a aVar;
            a aVar2;
            a aVar3;
            a aVar4;
            HashMap hashMap = new HashMap(4);
            f22656k = hashMap;
            hashMap.put("armeabi-v7a", aVar3);
            hashMap.put("armeabi", aVar2);
            hashMap.put("arm64-v8a", aVar4);
            hashMap.put("x86", aVar);
        }

        static a b() {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str)) {
                g.f().i("Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return UNKNOWN;
            }
            a aVar = (a) f22656k.get(str.toLowerCase(Locale.US));
            if (aVar == null) {
                return UNKNOWN;
            }
            return aVar;
        }
    }

    public static String A(InputStream inputStream) {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        if (useDelimiter.hasNext()) {
            return useDelimiter.next();
        }
        return "";
    }

    public static long a(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static synchronized long b(Context context) {
        long j4;
        synchronized (C2420j.class) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            j4 = memoryInfo.totalMem;
        }
        return j4;
    }

    public static long c(String str) {
        StatFs statFs = new StatFs(str);
        long blockSize = (long) statFs.getBlockSize();
        return (((long) statFs.getBlockCount()) * blockSize) - (blockSize * ((long) statFs.getAvailableBlocks()));
    }

    public static boolean d(Context context) {
        if (!e(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    public static boolean e(Context context, String str) {
        if (context.checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    public static void f(Closeable closeable, String str) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e5) {
                g.f().e(str, e5);
            }
        }
    }

    public static void g(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e5) {
                throw e5;
            } catch (Exception unused) {
            }
        }
    }

    public static String h(String... strArr) {
        if (!(strArr == null || strArr.length == 0)) {
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            for (String str : strArr) {
                if (str != null) {
                    arrayList.add(str.replace("-", "").toLowerCase(Locale.US));
                }
            }
            Collections.sort(arrayList);
            StringBuilder sb = new StringBuilder();
            int size = arrayList.size();
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                sb.append((String) obj);
            }
            String sb2 = sb.toString();
            if (sb2.length() > 0) {
                return z(sb2);
            }
        }
        return null;
    }

    public static boolean i(Context context, String str, boolean z4) {
        Resources resources;
        if (!(context == null || (resources = context.getResources()) == null)) {
            int p4 = p(context, str, "bool");
            if (p4 > 0) {
                return resources.getBoolean(p4);
            }
            int p5 = p(context, str, TypedValues.Custom.S_STRING);
            if (p5 > 0) {
                return Boolean.parseBoolean(context.getString(p5));
            }
        }
        return z4;
    }

    public static List j(Context context) {
        ArrayList arrayList = new ArrayList();
        int p4 = p(context, "com.google.firebase.crashlytics.build_ids_lib", "array");
        int p5 = p(context, "com.google.firebase.crashlytics.build_ids_arch", "array");
        int p6 = p(context, "com.google.firebase.crashlytics.build_ids_build_id", "array");
        if (p4 == 0 || p5 == 0 || p6 == 0) {
            g.f().b(String.format("Could not find resources: %d %d %d", new Object[]{Integer.valueOf(p4), Integer.valueOf(p5), Integer.valueOf(p6)}));
            return arrayList;
        }
        String[] stringArray = context.getResources().getStringArray(p4);
        String[] stringArray2 = context.getResources().getStringArray(p5);
        String[] stringArray3 = context.getResources().getStringArray(p6);
        if (stringArray.length == stringArray3.length && stringArray2.length == stringArray3.length) {
            for (int i4 = 0; i4 < stringArray3.length; i4++) {
                arrayList.add(new C2417g(stringArray[i4], stringArray2[i4], stringArray3[i4]));
            }
            return arrayList;
        }
        g.f().b(String.format("Lengths did not match: %d %d %d", new Object[]{Integer.valueOf(stringArray.length), Integer.valueOf(stringArray2.length), Integer.valueOf(stringArray3.length)}));
        return arrayList;
    }

    public static int k() {
        return a.b().ordinal();
    }

    public static int l() {
        boolean w4 = w();
        if (x()) {
            w4 |= true;
        }
        return v() ? w4 | true ? 1 : 0 : w4 ? 1 : 0;
    }

    public static String m(Context context) {
        int p4 = p(context, "com.google.firebase.crashlytics.mapping_file_id", TypedValues.Custom.S_STRING);
        if (p4 == 0) {
            p4 = p(context, "com.crashlytics.android.build_id", TypedValues.Custom.S_STRING);
        }
        if (p4 != 0) {
            return context.getResources().getString(p4);
        }
        return null;
    }

    public static boolean n(Context context) {
        if (!w() && ((SensorManager) context.getSystemService("sensor")).getDefaultSensor(8) != null) {
            return true;
        }
        return false;
    }

    public static String o(Context context) {
        int i4 = context.getApplicationContext().getApplicationInfo().icon;
        if (i4 <= 0) {
            return context.getPackageName();
        }
        try {
            String resourcePackageName = context.getResources().getResourcePackageName(i4);
            if ("android".equals(resourcePackageName)) {
                return context.getPackageName();
            }
            return resourcePackageName;
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    public static int p(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, o(context));
    }

    public static SharedPreferences q(Context context) {
        return context.getSharedPreferences("com.google.firebase.crashlytics", 0);
    }

    private static String r(String str, String str2) {
        return s(str.getBytes(), str2);
    }

    private static String s(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return t(instance.digest());
        } catch (NoSuchAlgorithmException e5) {
            g f4 = g.f();
            f4.e("Could not create hashing algorithm: " + str + ", returning empty string.", e5);
            return "";
        }
    }

    public static String t(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i4 = 0; i4 < bArr.length; i4++) {
            byte b5 = bArr[i4];
            int i5 = i4 * 2;
            char[] cArr2 = f22645a;
            cArr[i5] = cArr2[(b5 & 255) >>> 4];
            cArr[i5 + 1] = cArr2[b5 & 15];
        }
        return new String(cArr);
    }

    public static boolean u(Context context) {
        if ((context.getApplicationInfo().flags & 2) != 0) {
            return true;
        }
        return false;
    }

    public static boolean v() {
        if (Debug.isDebuggerConnected() || Debug.waitingForDebugger()) {
            return true;
        }
        return false;
    }

    public static boolean w() {
        if (Build.PRODUCT.contains("sdk")) {
            return true;
        }
        String str = Build.HARDWARE;
        if (str.contains("goldfish") || str.contains("ranchu")) {
            return true;
        }
        return false;
    }

    public static boolean x() {
        boolean w4 = w();
        String str = Build.TAGS;
        if ((!w4 && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (w4 || !file.exists()) {
            return false;
        }
        return true;
    }

    public static boolean y(String str, String str2) {
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public static String z(String str) {
        return r(str, "SHA-1");
    }
}
