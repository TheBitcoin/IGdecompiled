package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import androidx.collection.ArrayMap;

/* renamed from: com.google.android.gms.internal.measurement.k3  reason: case insensitive filesystem */
public abstract class C0600k3 {

    /* renamed from: a  reason: collision with root package name */
    private static final ArrayMap f1970a = new ArrayMap();

    public static synchronized Uri a(String str) {
        Uri uri;
        synchronized (C0600k3.class) {
            ArrayMap arrayMap = f1970a;
            uri = (Uri) arrayMap.get(str);
            if (uri == null) {
                String encode = Uri.encode(str);
                uri = Uri.parse("content://com.google.android.gms.phenotype/" + encode);
                arrayMap.put(str, uri);
            }
        }
        return uri;
    }

    public static String b(Context context, String str) {
        if (!str.contains("#")) {
            String packageName = context.getPackageName();
            return str + "#" + "" + packageName;
        }
        throw new IllegalArgumentException("The passed in package cannot already have a subpackage: " + str);
    }

    public static boolean c(String str, String str2) {
        if (!str.equals("eng") && !str.equals("userdebug")) {
            return false;
        }
        if (str2.contains("dev-keys") || str2.contains("test-keys")) {
            return true;
        }
        return false;
    }
}
