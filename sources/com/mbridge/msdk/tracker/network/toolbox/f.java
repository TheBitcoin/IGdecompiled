package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.tracker.network.ae;
import com.mbridge.msdk.tracker.network.b;
import com.mbridge.msdk.tracker.network.h;
import com.mbridge.msdk.tracker.network.r;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;

public final class f {
    public static b.a a(r rVar) {
        long j4;
        long j5;
        long j6;
        boolean z4;
        long j7;
        long j8;
        r rVar2 = rVar;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = rVar2.f15602c;
        if (map == null) {
            return null;
        }
        String str = map.get("Date");
        long a5 = str != null ? a(str) : 0;
        String str2 = map.get("Cache-Control");
        int i4 = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z4 = false;
            j6 = 0;
            j5 = 0;
            while (i4 < split.length) {
                String trim = split[i4].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j6 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j5 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z4 = true;
                }
                i4++;
            }
            j4 = 0;
            i4 = 1;
        } else {
            j4 = 0;
            j6 = 0;
            j5 = 0;
            z4 = false;
        }
        String str3 = map.get("Expires");
        long a6 = str3 != null ? a(str3) : j4;
        String str4 = map.get("Last-Modified");
        long a7 = str4 != null ? a(str4) : j4;
        long j9 = currentTimeMillis;
        String str5 = map.get(Command.HTTP_HEADER_ETAG);
        if (i4 != 0) {
            long j10 = j9 + (j6 * 1000);
            if (z4) {
                j7 = j10;
            } else {
                Long.signum(j5);
                j7 = (j5 * 1000) + j10;
            }
            j8 = j10;
        } else {
            j8 = (a5 <= j4 || a6 < a5) ? j4 : j9 + (a6 - a5);
            j7 = j8;
        }
        b.a aVar = new b.a();
        aVar.f15518a = rVar2.f15601b;
        aVar.f15519b = str5;
        aVar.f15523f = j8;
        aVar.f15522e = j7;
        aVar.f15520c = a5;
        aVar.f15521d = a7;
        aVar.f15524g = map;
        aVar.f15525h = rVar2.f15603d;
        return aVar;
    }

    private static SimpleDateFormat b(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    private static long a(String str) {
        try {
            Date parse = b("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str);
            if (parse != null) {
                return parse.getTime();
            }
            return 0;
        } catch (ParseException e5) {
            if ("0".equals(str) || "-1".equals(str)) {
                ae.a("Unable to parse dateStr: %s, falling back to 0", str);
            } else {
                ae.a(e5, "Unable to parse dateStr: %s, falling back to 0", str);
            }
            return 0;
        }
    }

    static String a(long j4) {
        return b("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j4));
    }

    static List<h> a(List<h> list, b.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (h a5 : list) {
                treeSet.add(a5.a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<h> list2 = aVar.f15525h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (h next : aVar.f15525h) {
                    if (!treeSet.contains(next.a())) {
                        arrayList.add(next);
                    }
                }
            }
        } else if (!aVar.f15524g.isEmpty()) {
            for (Map.Entry next2 : aVar.f15524g.entrySet()) {
                if (!treeSet.contains(next2.getKey())) {
                    arrayList.add(new h((String) next2.getKey(), (String) next2.getValue()));
                }
            }
        }
        return arrayList;
    }

    public static String a(Map<String, String> map) {
        String str;
        if (map == null || (str = map.get("Content-Type")) == null) {
            return "ISO-8859-1";
        }
        String[] split = str.split(";", 0);
        for (int i4 = 1; i4 < split.length; i4++) {
            String[] split2 = split[i4].trim().split("=", 0);
            if (split2.length == 2 && split2[0].equals("charset")) {
                return split2[1];
            }
        }
        return "ISO-8859-1";
    }
}
