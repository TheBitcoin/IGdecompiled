package Q3;

import P3.C2546b;
import P3.C2549e;
import Y3.C2611a;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: Q3.i  reason: case insensitive filesystem */
public class C2558i {

    /* renamed from: g  reason: collision with root package name */
    private static final String f23897g = C2546b.i(C2558i.class);

    /* renamed from: a  reason: collision with root package name */
    private final LinkedBlockingQueue f23898a = new LinkedBlockingQueue();

    /* renamed from: b  reason: collision with root package name */
    private final File f23899b;

    /* renamed from: c  reason: collision with root package name */
    private final long f23900c;

    /* renamed from: d  reason: collision with root package name */
    private final long f23901d;

    /* renamed from: e  reason: collision with root package name */
    private long f23902e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f23903f;

    public C2558i(C2549e eVar) {
        this.f23903f = false;
        this.f23900c = eVar.e();
        this.f23901d = eVar.f();
        try {
            File file = new File(new File(eVar.c().c().getCacheDir(), "piwik_cache"), new URL(eVar.a()).getHost());
            this.f23899b = file;
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                Arrays.sort(listFiles);
                for (File file2 : listFiles) {
                    this.f23902e += file2.length();
                    this.f23898a.add(file2);
                }
            }
        } catch (MalformedURLException e5) {
            throw new RuntimeException(e5);
        }
    }

    private void b() {
        long j4;
        char c5;
        long j5;
        long currentTimeMillis = System.currentTimeMillis();
        long j6 = this.f23900c;
        if (j6 < 0) {
            C2611a.b(f23897g).a("Caching is disabled.", new Object[0]);
            while (!this.f23898a.isEmpty()) {
                File file = (File) this.f23898a.poll();
                if (file.delete()) {
                    C2611a.b(f23897g).c("Deleted cache container %s", file.getPath());
                }
            }
        } else if (j6 > 0) {
            Iterator it = this.f23898a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                File file2 = (File) it.next();
                try {
                    j5 = Long.parseLong(file2.getName().split("_")[1]);
                } catch (Exception e5) {
                    C2611a.b(f23897g).d(e5);
                    j5 = 0;
                }
                j4 = currentTimeMillis;
                c5 = 0;
                if (j5 >= System.currentTimeMillis() - this.f23900c) {
                    break;
                }
                if (file2.delete()) {
                    C2611a.b(f23897g).c("Deleted cache container %s", file2.getPath());
                } else {
                    C2611a.b(f23897g).c("Failed to delete cache container %s", file2.getPath());
                }
                it.remove();
                currentTimeMillis = j4;
            }
        }
        j4 = currentTimeMillis;
        c5 = 0;
        if (this.f23901d != 0) {
            Iterator it2 = this.f23898a.iterator();
            while (it2.hasNext() && this.f23902e > this.f23901d) {
                File file3 = (File) it2.next();
                this.f23902e -= file3.length();
                it2.remove();
                if (file3.delete()) {
                    C2611a.b b5 = C2611a.b(f23897g);
                    Object[] objArr = new Object[1];
                    objArr[c5] = file3.getPath();
                    b5.c("Deleted cache container %s", objArr);
                } else {
                    C2611a.b b6 = C2611a.b(f23897g);
                    Object[] objArr2 = new Object[1];
                    objArr2[c5] = file3.getPath();
                    b6.c("Failed to delete cache container %s", objArr2);
                }
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        C2611a.b b7 = C2611a.b(f23897g);
        Object[] objArr3 = new Object[1];
        objArr3[c5] = Long.valueOf(currentTimeMillis2 - j4);
        b7.a("Cache check took %dms", objArr3);
    }

    private boolean c() {
        if (this.f23900c >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0077, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0078, code lost:
        r2 = r0;
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        Y3.C2611a.b(f23897g).d(r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0077 A[ExcHandler: all (r0v10 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:8:0x0018] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ab A[SYNTHETIC, Splitter:B:50:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00cf A[SYNTHETIC, Splitter:B:55:0x00cf] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List e(java.io.File r19) {
        /*
            r18 = this;
            r1 = r18
            r2 = 1
            r3 = 0
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r0 = r19.exists()
            if (r0 != 0) goto L_0x0010
            goto L_0x003c
        L_0x0010:
            r5 = 0
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x009d }
            r7 = r19
            r6.<init>(r7)     // Catch:{ IOException -> 0x009b }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            r0.<init>(r6)     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            r5.<init>(r0)     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            java.lang.String r0 = r5.readLine()     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            java.lang.String r8 = "1"
            boolean r0 = r8.equals(r0)     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            if (r0 != 0) goto L_0x003d
            r6.close()     // Catch:{ IOException -> 0x0032 }
            return r4
        L_0x0032:
            r0 = move-exception
            java.lang.String r2 = f23897g
            Y3.a$b r2 = Y3.C2611a.b(r2)
            r2.d(r0)
        L_0x003c:
            return r4
        L_0x003d:
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            long r10 = r1.f23900c     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            long r8 = r8 - r10
        L_0x0044:
            java.lang.String r0 = r5.readLine()     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            if (r0 == 0) goto L_0x0089
            java.lang.String r10 = " "
            int r10 = r0.indexOf(r10)     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            r11 = -1
            if (r10 != r11) goto L_0x0054
            goto L_0x0044
        L_0x0054:
            java.lang.String r11 = r0.substring(r3, r10)     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            long r11 = java.lang.Long.parseLong(r11)     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            long r13 = r1.f23900c     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            r15 = 0
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 <= 0) goto L_0x0069
            int r13 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r13 >= 0) goto L_0x0069
            goto L_0x0044
        L_0x0069:
            int r10 = r10 + r2
            java.lang.String r0 = r0.substring(r10)     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            Q3.g r10 = new Q3.g     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            r10.<init>(r11, r0)     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            r4.add(r10)     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            goto L_0x0044
        L_0x0077:
            r0 = move-exception
            r2 = r0
            r5 = r6
            goto L_0x00cd
        L_0x007b:
            r0 = move-exception
            java.lang.String r10 = f23897g     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            Y3.a$b r10 = Y3.C2611a.b(r10)     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            r10.d(r0)     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            goto L_0x0044
        L_0x0086:
            r0 = move-exception
            r5 = r6
            goto L_0x00a0
        L_0x0089:
            r6.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x00ae
        L_0x008d:
            r0 = move-exception
            java.lang.String r5 = f23897g
            Y3.a$b r5 = Y3.C2611a.b(r5)
            r5.d(r0)
            goto L_0x00ae
        L_0x0098:
            r0 = move-exception
            r2 = r0
            goto L_0x00cd
        L_0x009b:
            r0 = move-exception
            goto L_0x00a0
        L_0x009d:
            r0 = move-exception
            r7 = r19
        L_0x00a0:
            java.lang.String r6 = f23897g     // Catch:{ all -> 0x0098 }
            Y3.a$b r6 = Y3.C2611a.b(r6)     // Catch:{ all -> 0x0098 }
            r6.d(r0)     // Catch:{ all -> 0x0098 }
            if (r5 == 0) goto L_0x00ae
            r5.close()     // Catch:{ IOException -> 0x008d }
        L_0x00ae:
            java.lang.String r0 = f23897g
            Y3.a$b r0 = Y3.C2611a.b(r0)
            int r5 = r4.size()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = r7.getPath()
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r3] = r5
            r7[r2] = r6
            java.lang.String r2 = "Restored %d events from %s"
            r0.a(r2, r7)
            return r4
        L_0x00cd:
            if (r5 == 0) goto L_0x00dd
            r5.close()     // Catch:{ IOException -> 0x00d3 }
            goto L_0x00dd
        L_0x00d3:
            r0 = move-exception
            java.lang.String r3 = f23897g
            Y3.a$b r3 = Y3.C2611a.b(r3)
            r3.d(r0)
        L_0x00dd:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: Q3.C2558i.e(java.io.File):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fb A[SYNTHETIC, Splitter:B:43:0x00fb] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010c A[SYNTHETIC, Splitter:B:49:0x010c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File g(java.util.List r19) {
        /*
            r18 = this;
            r1 = r18
            r2 = 0
            r3 = 1
            java.lang.String r0 = "\n"
            boolean r4 = r19.isEmpty()
            r5 = 0
            if (r4 == 0) goto L_0x000e
            return r5
        L_0x000e:
            java.io.File r4 = r1.f23899b
            boolean r4 = r4.exists()
            if (r4 != 0) goto L_0x002f
            java.io.File r4 = r1.f23899b
            boolean r4 = r4.mkdirs()
            if (r4 != 0) goto L_0x002f
            java.lang.String r4 = f23897g
            Y3.a$b r4 = Y3.C2611a.b(r4)
            java.io.File r6 = r1.f23899b
            java.lang.Object[] r7 = new java.lang.Object[r3]
            r7[r2] = r6
            java.lang.String r6 = "Failed to make disk-cache dir '%s'"
            r4.c(r6, r7)
        L_0x002f:
            java.io.File r4 = new java.io.File
            java.io.File r6 = r1.f23899b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "events_"
            r7.append(r8)
            int r8 = r19.size()
            int r8 = r8 - r3
            r9 = r19
            java.lang.Object r8 = r9.get(r8)
            Q3.g r8 = (Q3.C2556g) r8
            long r10 = r8.b()
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            r4.<init>(r6, r7)
            java.io.FileWriter r6 = new java.io.FileWriter     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            r6.<init>(r4)     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            java.lang.String r7 = "1"
            java.io.Writer r7 = r6.append(r7)     // Catch:{ IOException -> 0x0094 }
            r7.append(r0)     // Catch:{ IOException -> 0x0094 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0094 }
            long r10 = r1.f23900c     // Catch:{ IOException -> 0x0094 }
            long r7 = r7 - r10
            java.util.Iterator r10 = r9.iterator()     // Catch:{ IOException -> 0x0094 }
            r11 = 0
        L_0x0072:
            boolean r12 = r10.hasNext()     // Catch:{ IOException -> 0x0094 }
            if (r12 == 0) goto L_0x00b5
            java.lang.Object r12 = r10.next()     // Catch:{ IOException -> 0x0094 }
            Q3.g r12 = (Q3.C2556g) r12     // Catch:{ IOException -> 0x0094 }
            long r13 = r1.f23900c     // Catch:{ IOException -> 0x0094 }
            r15 = 0
            int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r17 <= 0) goto L_0x0096
            long r13 = r12.b()     // Catch:{ IOException -> 0x0094 }
            int r15 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r15 >= 0) goto L_0x0096
            goto L_0x0072
        L_0x008f:
            r0 = move-exception
            r2 = r0
            r5 = r6
            goto L_0x010a
        L_0x0094:
            r0 = move-exception
            goto L_0x00ed
        L_0x0096:
            long r13 = r12.b()     // Catch:{ IOException -> 0x0094 }
            java.lang.String r11 = java.lang.String.valueOf(r13)     // Catch:{ IOException -> 0x0094 }
            java.io.Writer r11 = r6.append(r11)     // Catch:{ IOException -> 0x0094 }
            java.lang.String r13 = " "
            java.io.Writer r11 = r11.append(r13)     // Catch:{ IOException -> 0x0094 }
            java.lang.String r12 = r12.a()     // Catch:{ IOException -> 0x0094 }
            java.io.Writer r11 = r11.append(r12)     // Catch:{ IOException -> 0x0094 }
            r11.append(r0)     // Catch:{ IOException -> 0x0094 }
            r11 = 1
            goto L_0x0072
        L_0x00b5:
            r6.close()     // Catch:{ IOException -> 0x00b9 }
            goto L_0x00c3
        L_0x00b9:
            r0 = move-exception
            java.lang.String r6 = f23897g
            Y3.a$b r6 = Y3.C2611a.b(r6)
            r6.d(r0)
        L_0x00c3:
            java.lang.String r0 = f23897g
            Y3.a$b r0 = Y3.C2611a.b(r0)
            int r6 = r9.size()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r7 = r4.getPath()
            r8 = 2
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r2] = r6
            r8[r3] = r7
            java.lang.String r2 = "Saved %d events to %s"
            r0.a(r2, r8)
            if (r11 == 0) goto L_0x00e4
            return r4
        L_0x00e4:
            r4.delete()
            return r5
        L_0x00e8:
            r0 = move-exception
            r2 = r0
            goto L_0x010a
        L_0x00eb:
            r0 = move-exception
            r6 = r5
        L_0x00ed:
            java.lang.String r2 = f23897g     // Catch:{ all -> 0x008f }
            Y3.a$b r2 = Y3.C2611a.b(r2)     // Catch:{ all -> 0x008f }
            r2.d(r0)     // Catch:{ all -> 0x008f }
            r4.delete()     // Catch:{ all -> 0x008f }
            if (r6 == 0) goto L_0x0109
            r6.close()     // Catch:{ IOException -> 0x00ff }
            goto L_0x0109
        L_0x00ff:
            r0 = move-exception
            java.lang.String r2 = f23897g
            Y3.a$b r2 = Y3.C2611a.b(r2)
            r2.d(r0)
        L_0x0109:
            return r5
        L_0x010a:
            if (r5 == 0) goto L_0x011a
            r5.close()     // Catch:{ IOException -> 0x0110 }
            goto L_0x011a
        L_0x0110:
            r0 = move-exception
            java.lang.String r3 = f23897g
            Y3.a$b r3 = Y3.C2611a.b(r3)
            r3.d(r0)
        L_0x011a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: Q3.C2558i.g(java.util.List):java.io.File");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.util.List r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.c()     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x0056
            boolean r0 = r8.isEmpty()     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x000e
            goto L_0x0056
        L_0x000e:
            r7.b()     // Catch:{ all -> 0x002a }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x002a }
            java.io.File r2 = r7.g(r8)     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x002c
            java.util.concurrent.LinkedBlockingQueue r3 = r7.f23898a     // Catch:{ all -> 0x002a }
            r3.add(r2)     // Catch:{ all -> 0x002a }
            long r3 = r7.f23902e     // Catch:{ all -> 0x002a }
            long r5 = r2.length()     // Catch:{ all -> 0x002a }
            long r3 = r3 + r5
            r7.f23902e = r3     // Catch:{ all -> 0x002a }
            goto L_0x002c
        L_0x002a:
            r8 = move-exception
            goto L_0x0058
        L_0x002c:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x002a }
            java.lang.String r5 = f23897g     // Catch:{ all -> 0x002a }
            Y3.a$b r5 = Y3.C2611a.b(r5)     // Catch:{ all -> 0x002a }
            java.lang.String r6 = "Caching of %d events took %dms (%s)"
            int r8 = r8.size()     // Catch:{ all -> 0x002a }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x002a }
            long r3 = r3 - r0
            java.lang.Long r0 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x002a }
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x002a }
            r3 = 0
            r1[r3] = r8     // Catch:{ all -> 0x002a }
            r8 = 1
            r1[r8] = r0     // Catch:{ all -> 0x002a }
            r8 = 2
            r1[r8] = r2     // Catch:{ all -> 0x002a }
            r5.a(r6, r1)     // Catch:{ all -> 0x002a }
            monitor-exit(r7)
            return
        L_0x0056:
            monitor-exit(r7)
            return
        L_0x0058:
            monitor-exit(r7)     // Catch:{ all -> 0x002a }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: Q3.C2558i.a(java.util.List):void");
    }

    public synchronized boolean d() {
        try {
            if (!this.f23903f) {
                b();
                this.f23903f = true;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f23898a.isEmpty();
    }

    public synchronized List f() {
        try {
            ArrayList arrayList = new ArrayList();
            if (!c()) {
                return arrayList;
            }
            long currentTimeMillis = System.currentTimeMillis();
            while (!this.f23898a.isEmpty()) {
                File file = (File) this.f23898a.poll();
                if (file != null) {
                    arrayList.addAll(e(file));
                    if (!file.delete()) {
                        C2611a.b(f23897g).c("Failed to delete cache container %s", file.getPath());
                    }
                }
            }
            b();
            long currentTimeMillis2 = System.currentTimeMillis();
            C2611a.b(f23897g).a("Uncaching of %d events took %dms", Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
            return arrayList;
        } finally {
            while (true) {
            }
        }
    }
}
