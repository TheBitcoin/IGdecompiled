package com.mbridge.msdk.mbsignalcommon.windvane;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f14182a = {"wv_hybrid:", "mraid:", "ssp:", "mvb_hybrid:"};

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f14183b = Pattern.compile("hybrid://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f14184c = Pattern.compile("mraid://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f14185d = Pattern.compile("ssp://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f14186e = Pattern.compile("mv://(.+?):(.+?)/(.+?)(\\?(.*?))?");

    /* renamed from: f  reason: collision with root package name */
    private static Map<String, String> f14187f = new HashMap();

    static {
        for (e eVar : e.values()) {
            f14187f.put(eVar.a(), eVar.b());
        }
    }

    public static boolean a(String str) {
        for (String equals : f14182a) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static Pattern b(String str) {
        if ("wv_hybrid:".equals(str)) {
            return f14186e;
        }
        if ("mraid:".equals(str)) {
            return f14184c;
        }
        if ("ssp:".equals(str)) {
            return f14185d;
        }
        if ("mvb_hybrid:".equals(str)) {
            return f14186e;
        }
        return null;
    }

    public static String c(String str) {
        char[] cArr = {'\'', '\\'};
        StringBuffer stringBuffer = new StringBuffer(1000);
        stringBuffer.setLength(0);
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (charAt <= 255) {
                int i5 = 0;
                while (true) {
                    if (i5 >= 2) {
                        stringBuffer.append(charAt);
                        break;
                    } else if (cArr[i5] == charAt) {
                        stringBuffer.append("\\" + charAt);
                        break;
                    } else {
                        i5++;
                    }
                }
            } else {
                stringBuffer.append("\\u");
                String upperCase = Integer.toHexString(charAt >>> 8).toUpperCase();
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                String upperCase2 = Integer.toHexString(charAt & 255).toUpperCase();
                if (upperCase2.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase2);
            }
        }
        return new String(stringBuffer);
    }

    public static boolean d(String str) {
        return e(str).startsWith("image");
    }

    public static String e(String str) {
        String str2 = f14187f.get(f(str));
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    private static String f(String str) {
        String path;
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (path = Uri.parse(str).getPath()) == null || (lastIndexOf = path.lastIndexOf(".")) == -1) {
            return "";
        }
        return path.substring(lastIndexOf + 1);
    }
}
