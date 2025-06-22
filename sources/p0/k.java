package P0;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import j$.util.DateRetargetClass;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

class k {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f7986a;

    public k(Context context, String str) {
        this.f7986a = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    private synchronized void a() {
        try {
            long j4 = this.f7986a.getLong("fire-count", 0);
            String str = "";
            String str2 = null;
            for (Map.Entry next : this.f7986a.getAll().entrySet()) {
                if (next.getValue() instanceof Set) {
                    for (String str3 : (Set) next.getValue()) {
                        if (str2 != null) {
                            if (str2.compareTo(str3) > 0) {
                            }
                        }
                        str = (String) next.getKey();
                        str2 = str3;
                    }
                }
            }
            HashSet hashSet = new HashSet(this.f7986a.getStringSet(str, new HashSet()));
            hashSet.remove(str2);
            this.f7986a.edit().putStringSet(str, hashSet).putLong("fire-count", j4 - 1).commit();
        } finally {
            while (true) {
            }
        }
    }

    private synchronized String d(long j4) {
        if (Build.VERSION.SDK_INT >= 26) {
            return DateRetargetClass.toInstant(new Date(j4)).atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j4));
    }

    private synchronized String e(String str) {
        for (Map.Entry next : this.f7986a.getAll().entrySet()) {
            if (next.getValue() instanceof Set) {
                for (String equals : (Set) next.getValue()) {
                    if (str.equals(equals)) {
                        return (String) next.getKey();
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void h(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = r4.e(r5)     // Catch:{ all -> 0x0030 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            java.util.HashSet r1 = new java.util.HashSet     // Catch:{ all -> 0x0030 }
            android.content.SharedPreferences r2 = r4.f7986a     // Catch:{ all -> 0x0030 }
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ all -> 0x0030 }
            r3.<init>()     // Catch:{ all -> 0x0030 }
            java.util.Set r2 = r2.getStringSet(r0, r3)     // Catch:{ all -> 0x0030 }
            r1.<init>(r2)     // Catch:{ all -> 0x0030 }
            r1.remove(r5)     // Catch:{ all -> 0x0030 }
            boolean r5 = r1.isEmpty()     // Catch:{ all -> 0x0030 }
            if (r5 == 0) goto L_0x0032
            android.content.SharedPreferences r5 = r4.f7986a     // Catch:{ all -> 0x0030 }
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ all -> 0x0030 }
            android.content.SharedPreferences$Editor r5 = r5.remove(r0)     // Catch:{ all -> 0x0030 }
            r5.commit()     // Catch:{ all -> 0x0030 }
            goto L_0x003f
        L_0x0030:
            r5 = move-exception
            goto L_0x0041
        L_0x0032:
            android.content.SharedPreferences r5 = r4.f7986a     // Catch:{ all -> 0x0030 }
            android.content.SharedPreferences$Editor r5 = r5.edit()     // Catch:{ all -> 0x0030 }
            android.content.SharedPreferences$Editor r5 = r5.putStringSet(r0, r1)     // Catch:{ all -> 0x0030 }
            r5.commit()     // Catch:{ all -> 0x0030 }
        L_0x003f:
            monitor-exit(r4)
            return
        L_0x0041:
            monitor-exit(r4)     // Catch:{ all -> 0x0030 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: P0.k.h(java.lang.String):void");
    }

    private synchronized void m(String str, String str2) {
        h(str2);
        HashSet hashSet = new HashSet(this.f7986a.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.f7986a.edit().putStringSet(str, hashSet).commit();
    }

    /* access modifiers changed from: package-private */
    public synchronized void b() {
        try {
            SharedPreferences.Editor edit = this.f7986a.edit();
            int i4 = 0;
            for (Map.Entry next : this.f7986a.getAll().entrySet()) {
                if (next.getValue() instanceof Set) {
                    String d5 = d(System.currentTimeMillis());
                    String str = (String) next.getKey();
                    if (((Set) next.getValue()).contains(d5)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(d5);
                        i4++;
                        edit.putStringSet(str, hashSet);
                    } else {
                        edit.remove(str);
                    }
                }
            }
            if (i4 == 0) {
                edit.remove("fire-count");
            } else {
                edit.putLong("fire-count", (long) i4);
            }
            edit.commit();
        } finally {
            while (true) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized List c() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Map.Entry next : this.f7986a.getAll().entrySet()) {
                if (next.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) next.getValue());
                    hashSet.remove(d(System.currentTimeMillis()));
                    if (!hashSet.isEmpty()) {
                        arrayList.add(l.a((String) next.getKey(), new ArrayList(hashSet)));
                    }
                }
            }
            l(System.currentTimeMillis());
        } finally {
            while (true) {
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean f(long j4, long j5) {
        return d(j4).equals(d(j5));
    }

    /* access modifiers changed from: package-private */
    public synchronized void g() {
        String d5 = d(System.currentTimeMillis());
        this.f7986a.edit().putString("last-used-date", d5).commit();
        h(d5);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean i(long j4) {
        return j("fire-global", j4);
    }

    /* access modifiers changed from: package-private */
    public synchronized boolean j(String str, long j4) {
        if (!this.f7986a.contains(str)) {
            this.f7986a.edit().putLong(str, j4).commit();
            return true;
        } else if (f(this.f7986a.getLong(str, -1), j4)) {
            return false;
        } else {
            this.f7986a.edit().putLong(str, j4).commit();
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void k(long j4, String str) {
        String d5 = d(j4);
        if (this.f7986a.getString("last-used-date", "").equals(d5)) {
            String e5 = e(d5);
            if (e5 != null) {
                if (!e5.equals(str)) {
                    m(str, d5);
                    return;
                }
                return;
            }
            return;
        }
        long j5 = this.f7986a.getLong("fire-count", 0);
        if (j5 + 1 == 30) {
            a();
            j5 = this.f7986a.getLong("fire-count", 0);
        }
        HashSet hashSet = new HashSet(this.f7986a.getStringSet(str, new HashSet()));
        hashSet.add(d5);
        this.f7986a.edit().putStringSet(str, hashSet).putLong("fire-count", j5 + 1).putString("last-used-date", d5).commit();
    }

    /* access modifiers changed from: package-private */
    public synchronized void l(long j4) {
        this.f7986a.edit().putLong("fire-global", j4).commit();
    }
}
