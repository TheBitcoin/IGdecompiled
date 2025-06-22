package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import l0.g;

/* renamed from: com.google.android.gms.internal.measurement.g3  reason: case insensitive filesystem */
public final class C0564g3 {

    /* renamed from: com.google.android.gms.internal.measurement.g3$a */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static volatile g f1904a;

        public static g a(Context context) {
            g gVar;
            g c5;
            g gVar2 = f1904a;
            if (gVar2 != null) {
                return gVar2;
            }
            synchronized (a.class) {
                try {
                    gVar = f1904a;
                    if (gVar == null) {
                        new C0564g3();
                        if (!C0600k3.c(Build.TYPE, Build.TAGS)) {
                            c5 = g.a();
                        } else {
                            if (S2.a()) {
                                if (!context.isDeviceProtectedStorage()) {
                                    context = context.createDeviceProtectedStorageContext();
                                }
                            }
                            c5 = C0564g3.c(context);
                        }
                        gVar = c5;
                        f1904a = gVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return gVar;
        }
    }

    private static C0573h3 a(Context context, File file) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
            HashMap hashMap = new HashMap();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String[] split = readLine.split(" ", 3);
                    if (split.length != 3) {
                        Log.e("HermeticFileOverrides", "Invalid: " + readLine);
                    } else {
                        String b5 = b(split[0]);
                        String decode = Uri.decode(b(split[1]));
                        String str = (String) hashMap.get(split[2]);
                        if (str == null) {
                            String b6 = b(split[2]);
                            str = Uri.decode(b6);
                            if (str.length() < 1024 || str == b6) {
                                hashMap.put(b6, str);
                            }
                        }
                        SimpleArrayMap simpleArrayMap2 = (SimpleArrayMap) simpleArrayMap.get(b5);
                        if (simpleArrayMap2 == null) {
                            simpleArrayMap2 = new SimpleArrayMap();
                            simpleArrayMap.put(b5, simpleArrayMap2);
                        }
                        simpleArrayMap2.put(decode, str);
                    }
                } else {
                    String valueOf = String.valueOf(file);
                    String packageName = context.getPackageName();
                    Log.w("HermeticFileOverrides", "Parsed " + valueOf + " for Android package " + packageName);
                    Y2 y22 = new Y2(simpleArrayMap);
                    bufferedReader.close();
                    return y22;
                }
            }
        } catch (IOException e5) {
            throw new RuntimeException(e5);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static final String b(String str) {
        return new String(str);
    }

    static g c(Context context) {
        g gVar;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            g d5 = d(context);
            if (d5.c()) {
                gVar = g.d(a(context, (File) d5.b()));
            } else {
                gVar = g.a();
            }
            return gVar;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static g d(Context context) {
        try {
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            if (file.exists()) {
                return g.d(file);
            }
            return g.a();
        } catch (RuntimeException e5) {
            Log.e("HermeticFileOverrides", "no data dir", e5);
            return g.a();
        }
    }
}
