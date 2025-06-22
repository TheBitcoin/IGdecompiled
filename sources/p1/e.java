package p1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import w1.C2340g;

abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f21462a = Pattern.compile("<(head)( [^>]*)?>", 2);

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f21463b = Pattern.compile("<(head)( [^>]*)?/>", 2);

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f21464c = Pattern.compile("<(body)( [^>]*?)?>", 2);

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f21465d = Pattern.compile("<(body)( [^>]*?)?/>", 2);

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f21466e = Pattern.compile("<(html)( [^>]*?)?>", 2);

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f21467f = Pattern.compile("<(html)( [^>]*?)?/>", 2);

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f21468g = Pattern.compile("<!DOCTYPE [^>]*>", 2);

    static String a(String str, String str2) {
        C2340g.d(str, "HTML is null or empty");
        int[][] d5 = d(str);
        StringBuilder sb = new StringBuilder(str.length() + str2.length() + 16);
        if (f(str, sb, f21463b, str2, d5)) {
            return sb.toString();
        }
        if (c(str, sb, f21462a, str2, d5)) {
            return sb.toString();
        }
        if (f(str, sb, f21465d, str2, d5)) {
            return sb.toString();
        }
        if (c(str, sb, f21464c, str2, d5)) {
            return sb.toString();
        }
        if (f(str, sb, f21467f, str2, d5)) {
            return sb.toString();
        }
        if (c(str, sb, f21466e, str2, d5)) {
            return sb.toString();
        }
        if (c(str, sb, f21468g, str2, d5)) {
            return sb.toString();
        }
        return str2 + str;
    }

    private static boolean b(int i4, int[][] iArr) {
        if (iArr != null) {
            for (int[] iArr2 : iArr) {
                if (i4 >= iArr2[0] && i4 <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean c(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i4 = 0;
        while (matcher.find(i4)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!b(start, iArr)) {
                sb.append(str.substring(0, matcher.end()));
                sb.append(str2);
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i4 = end;
        }
        return false;
    }

    private static int[][] d(String str) {
        ArrayList arrayList = new ArrayList();
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            int indexOf = str.indexOf("<!--", i4);
            if (indexOf >= 0) {
                int indexOf2 = str.indexOf("-->", indexOf);
                if (indexOf2 >= 0) {
                    arrayList.add(new int[]{indexOf, indexOf2});
                    i4 = indexOf2 + 3;
                } else {
                    arrayList.add(new int[]{indexOf, length});
                }
            }
            i4 = length;
        }
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = 0;
        return (int[][]) arrayList.toArray((int[][]) Array.newInstance(Integer.TYPE, iArr));
    }

    static String e(String str, String str2) {
        return a(str2, "<script type=\"text/javascript\">" + str + "</script>");
    }

    private static boolean f(String str, StringBuilder sb, Pattern pattern, String str2, int[][] iArr) {
        Matcher matcher = pattern.matcher(str);
        int i4 = 0;
        while (matcher.find(i4)) {
            int start = matcher.start();
            int end = matcher.end();
            if (!b(start, iArr)) {
                sb.append(str.substring(0, matcher.end() - 2));
                sb.append(">");
                sb.append(str2);
                sb.append("</");
                sb.append(matcher.group(1));
                sb.append(">");
                sb.append(str.substring(matcher.end()));
                return true;
            }
            i4 = end;
        }
        return false;
    }
}
