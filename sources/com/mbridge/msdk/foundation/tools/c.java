package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.SharedPreferences;
import com.mbridge.msdk.foundation.controller.d;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    static FastKV f13624a;

    public static Object a(Context context, String str, Object obj) {
        String str2;
        if (context != null) {
            if (obj != null) {
                str2 = obj.getClass().getSimpleName();
            } else {
                str2 = "";
            }
            d.a();
            if (f13624a == null) {
                try {
                    f13624a = new FastKV.Builder(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "share_kv_date").asyncBlocking().build();
                } catch (Exception unused) {
                    f13624a = null;
                }
            }
            if (f13624a != null) {
                try {
                    if ("String".equals(str2)) {
                        return f13624a.getString(str, (String) obj);
                    }
                    if ("Integer".equals(str2)) {
                        return Integer.valueOf(f13624a.getInt(str, ((Integer) obj).intValue()));
                    }
                    if ("Boolean".equals(str2)) {
                        return Boolean.valueOf(f13624a.getBoolean(str, ((Boolean) obj).booleanValue()));
                    }
                    if ("Float".equals(str2)) {
                        return Float.valueOf(f13624a.getFloat(str, ((Float) obj).floatValue()));
                    }
                    if ("Long".equals(str2)) {
                        return Long.valueOf(f13624a.getLong(str, ((Long) obj).longValue()));
                    }
                } catch (Exception unused2) {
                }
            } else {
                SharedPreferences sharedPreferences = context.getSharedPreferences("share_kv_date", 0);
                if ("String".equals(str2)) {
                    return sharedPreferences.getString(str, (String) obj);
                }
                if ("Integer".equals(str2)) {
                    return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
                }
                if ("Boolean".equals(str2)) {
                    return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
                }
                if ("Float".equals(str2)) {
                    return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
                }
                if ("Long".equals(str2)) {
                    return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
                }
            }
        }
        return obj;
    }

    public static void b(Context context, String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        if (context != null) {
            d.a();
            if (f13624a == null) {
                try {
                    f13624a = new FastKV.Builder(e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "share_kv_date").asyncBlocking().build();
                } catch (Exception unused) {
                    f13624a = null;
                }
            }
            if (f13624a != null) {
                try {
                    if ("String".equals(simpleName)) {
                        f13624a.putString(str, (String) obj);
                    } else if ("Integer".equals(simpleName)) {
                        f13624a.putInt(str, ((Integer) obj).intValue());
                    } else if ("Boolean".equals(simpleName)) {
                        f13624a.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if ("Float".equals(simpleName)) {
                        f13624a.putFloat(str, ((Float) obj).floatValue());
                    } else if ("Long".equals(simpleName)) {
                        f13624a.putLong(str, ((Long) obj).longValue());
                    }
                } catch (Exception unused2) {
                }
            } else {
                SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("share_kv_date", 0).edit();
                if ("String".equals(simpleName)) {
                    edit.putString(str, (String) obj);
                } else if ("Integer".equals(simpleName)) {
                    edit.putInt(str, ((Integer) obj).intValue());
                } else if ("Boolean".equals(simpleName)) {
                    edit.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if ("Float".equals(simpleName)) {
                    edit.putFloat(str, ((Float) obj).floatValue());
                } else if ("Long".equals(simpleName)) {
                    edit.putLong(str, ((Long) obj).longValue());
                }
                edit.apply();
            }
        }
    }
}
