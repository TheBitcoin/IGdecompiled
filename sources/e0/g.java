package E0;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import v0.j;
import y0.C2420j;

public class g {

    /* renamed from: a  reason: collision with root package name */
    final String f6305a;

    /* renamed from: b  reason: collision with root package name */
    private final File f6306b;

    /* renamed from: c  reason: collision with root package name */
    private final File f6307c;

    /* renamed from: d  reason: collision with root package name */
    private final File f6308d;

    /* renamed from: e  reason: collision with root package name */
    private final File f6309e;

    /* renamed from: f  reason: collision with root package name */
    private final File f6310f;

    /* renamed from: g  reason: collision with root package name */
    private final File f6311g;

    public g(Context context) {
        String str;
        String d5 = j.f21978a.e(context).d();
        this.f6305a = d5;
        File filesDir = context.getFilesDir();
        this.f6306b = filesDir;
        if (x()) {
            str = ".crashlytics.v3" + File.separator + w(d5);
        } else {
            str = ".com.google.firebase.crashlytics.files.v1";
        }
        File s4 = s(new File(filesDir, str));
        this.f6307c = s4;
        this.f6308d = s(new File(s4, "open-sessions"));
        this.f6309e = s(new File(s4, "reports"));
        this.f6310f = s(new File(s4, "priority-reports"));
        this.f6311g = s(new File(s4, "native-reports"));
    }

    private void b(String str) {
        File file = new File(this.f6306b, str);
        if (file.exists() && u(file)) {
            v0.g f4 = v0.g.f();
            f4.b("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    private void c(String str) {
        String[] list;
        if (this.f6306b.exists() && (list = this.f6306b.list(new f(str))) != null) {
            for (String b5 : list) {
                b(b5);
            }
        }
    }

    private File p(String str) {
        return t(new File(this.f6308d, str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.io.File s(java.io.File r4) {
        /*
            java.lang.Class<E0.g> r0 = E0.g.class
            monitor-enter(r0)
            boolean r1 = r4.exists()     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0034
            boolean r1 = r4.isDirectory()     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0011
            monitor-exit(r0)
            return r4
        L_0x0011:
            v0.g r1 = v0.g.f()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r2.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = "Unexpected non-directory file: "
            r2.append(r3)     // Catch:{ all -> 0x0032 }
            r2.append(r4)     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = "; deleting file and creating new directory."
            r2.append(r3)     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0032 }
            r1.b(r2)     // Catch:{ all -> 0x0032 }
            r4.delete()     // Catch:{ all -> 0x0032 }
            goto L_0x0034
        L_0x0032:
            r4 = move-exception
            goto L_0x0054
        L_0x0034:
            boolean r1 = r4.mkdirs()     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0052
            v0.g r1 = v0.g.f()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r2.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = "Could not create Crashlytics-specific directory: "
            r2.append(r3)     // Catch:{ all -> 0x0032 }
            r2.append(r4)     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0032 }
            r1.d(r2)     // Catch:{ all -> 0x0032 }
        L_0x0052:
            monitor-exit(r0)
            return r4
        L_0x0054:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: E0.g.s(java.io.File):java.io.File");
    }

    private static File t(File file) {
        file.mkdirs();
        return file;
    }

    static boolean u(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File u4 : listFiles) {
                u(u4);
            }
        }
        return file.delete();
    }

    private static List v(Object[] objArr) {
        if (objArr == null) {
            return Collections.EMPTY_LIST;
        }
        return Arrays.asList(objArr);
    }

    static String w(String str) {
        if (str.length() > 40) {
            return C2420j.z(str);
        }
        return str.replaceAll("[^a-zA-Z0-9.]", "_");
    }

    private boolean x() {
        return !this.f6305a.isEmpty();
    }

    public void d() {
        b(".com.google.firebase.crashlytics");
        b(".com.google.firebase.crashlytics-ndk");
        if (x()) {
            b(".com.google.firebase.crashlytics.files.v1");
            c(".com.google.firebase.crashlytics.files.v2" + File.pathSeparator);
        }
    }

    public boolean e(String str) {
        return u(new File(this.f6308d, str));
    }

    public List f() {
        return v(this.f6308d.list());
    }

    public File g(String str) {
        return new File(this.f6307c, str);
    }

    public List h(FilenameFilter filenameFilter) {
        return v(this.f6307c.listFiles(filenameFilter));
    }

    public File i(String str) {
        return new File(this.f6311g, str);
    }

    public List j() {
        return v(this.f6311g.listFiles());
    }

    public File k(String str) {
        return t(new File(p(str), "native"));
    }

    public File l(String str) {
        return new File(this.f6310f, str);
    }

    public List m() {
        return v(this.f6310f.listFiles());
    }

    public File n(String str) {
        return new File(this.f6309e, str);
    }

    public List o() {
        return v(this.f6309e.listFiles());
    }

    public File q(String str, String str2) {
        return new File(p(str), str2);
    }

    public List r(String str, FilenameFilter filenameFilter) {
        return v(p(str).listFiles(filenameFilter));
    }
}
