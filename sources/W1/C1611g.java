package W1;

import O1.r;
import R2.n;
import R2.s;
import T1.h;
import W1.G;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.text.format.DateFormat;
import androidx.documentfile.provider.DocumentFile;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import d3.p;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2098b;
import m3.j;
import m3.m;
import o3.C0977g;
import o3.J;
import o3.Y;

/* renamed from: W1.g  reason: case insensitive filesystem */
public final class C1611g {

    /* renamed from: W1.g$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8673a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f8674b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f8675c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, String str, V2.d dVar) {
            super(2, dVar);
            this.f8674b = context;
            this.f8675c = str;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f8674b, this.f8675c, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8673a == 0) {
                n.b(obj);
                Context context = this.f8674b;
                if (context instanceof r) {
                    ((r) context).q0(this.f8675c);
                }
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* renamed from: W1.g$b */
    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        int f8676a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f8677b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C1611g f8678c;

        /* renamed from: d  reason: collision with root package name */
        int f8679d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(C1611g gVar, V2.d dVar) {
            super(dVar);
            this.f8678c = gVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f8677b = obj;
            this.f8679d |= Integer.MIN_VALUE;
            return this.f8678c.d((Object) null, (String) null, (Context) null, (d3.a) null, this);
        }
    }

    /* renamed from: W1.g$c */
    static final class c extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f8680a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(d3.a aVar) {
            super(0);
            this.f8680a = aVar;
        }

        public final void invoke() {
            this.f8680a.invoke();
        }
    }

    /* renamed from: W1.g$d */
    static final class d extends kotlin.jvm.internal.n implements d3.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d3.a f8681a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(d3.a aVar) {
            super(0);
            this.f8681a = aVar;
        }

        public final void invoke() {
            this.f8681a.invoke();
        }
    }

    /* renamed from: W1.g$e */
    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8682a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f8683b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f8684c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ d3.a f8685d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Context context, String str, d3.a aVar, V2.d dVar) {
            super(2, dVar);
            this.f8683b = context;
            this.f8684c = str;
            this.f8685d = aVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f8683b, this.f8684c, this.f8685d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f8682a == 0) {
                n.b(obj);
                Context context = this.f8683b;
                if (context instanceof r) {
                    ((r) context).q0(this.f8684c);
                }
                this.f8685d.invoke();
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    private final boolean a(String str) {
        return !m.B(str, "Backups", true);
    }

    private final Object c(Context context, String str, V2.d dVar) {
        Object g4 = C0977g.g(Y.c(), new a(context, str, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    private final Object e(Context context, String str, d3.a aVar, V2.d dVar) {
        Object g4 = C0977g.g(Y.c(), new e(context, str, aVar, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    private final ArrayList j(Context context) {
        ArrayList arrayList = new ArrayList();
        ArrayList b5 = new E().b(context);
        if (b5.size() > 0) {
            int size = b5.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = b5.get(i4);
                i4++;
                File file = new File(((h) obj).b());
                if (file.exists() && file.isDirectory()) {
                    arrayList.addAll(i(file, context));
                }
            }
            return arrayList;
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        kotlin.jvm.internal.m.d(externalStorageDirectory, "rootDir");
        arrayList.addAll(i(externalStorageDirectory, context));
        return arrayList;
    }

    private final ArrayList n(ArrayList arrayList, Context context) {
        ArrayList arrayList2 = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        kotlin.jvm.internal.m.d(packageManager, "context.packageManager");
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            File file = (File) obj;
            String name = file.getName();
            kotlin.jvm.internal.m.d(name, "file.name");
            if (!m.y(name, ".", false, 2, (Object) null)) {
                String name2 = file.getName();
                kotlin.jvm.internal.m.d(name2, "file.name");
                if (m.o(name2, ".apk", false, 2, (Object) null)) {
                    String absolutePath = file.getAbsolutePath();
                    kotlin.jvm.internal.m.d(absolutePath, "file.absolutePath");
                    PackageInfo c5 = s.c(packageManager, absolutePath, 128);
                    if (c5 == null) {
                        String name3 = file.getName();
                        kotlin.jvm.internal.m.d(name3, "file.name");
                        if (!m.y(name3, "split_config", false, 2, (Object) null)) {
                            arrayList2.add(file);
                        }
                    } else if (!k(c5)) {
                        arrayList2.add(file);
                    }
                } else {
                    G.a aVar = G.f8470b;
                    String name4 = file.getName();
                    kotlin.jvm.internal.m.d(name4, "file.name");
                    if (aVar.a(name4)) {
                        arrayList2.add(file);
                    }
                }
            }
        }
        return arrayList2;
    }

    public final String b(Object obj) {
        kotlin.jvm.internal.m.e(obj, "directory");
        int i4 = 0;
        if (obj instanceof File) {
            File[] listFiles = ((File) obj).listFiles();
            if (listFiles != null) {
                i4 = listFiles.length;
            }
        } else if (obj instanceof DocumentFile) {
            i4 = ((DocumentFile) obj).listFiles().length;
        }
        return String.valueOf(i4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0093, code lost:
        if (r11.e(r13, r12, r15, r0) == r1) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b0, code lost:
        if (r11.c(r13, r12, r0) == r1) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cb, code lost:
        if (r11.c(r13, r12, r0) == r1) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fb, code lost:
        if (r11.e(r13, r12, r15, r0) == r1) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0114, code lost:
        if (r11.c(r13, r12, r0) == r1) goto L_0x0116;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(java.lang.Object r11, java.lang.String r12, android.content.Context r13, d3.a r14, V2.d r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof W1.C1611g.b
            if (r0 == 0) goto L_0x0013
            r0 = r15
            W1.g$b r0 = (W1.C1611g.b) r0
            int r1 = r0.f8679d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f8679d = r1
            goto L_0x0018
        L_0x0013:
            W1.g$b r0 = new W1.g$b
            r0.<init>(r10, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f8677b
            java.lang.Object r1 = W2.b.c()
            int r2 = r0.f8679d
            r3 = 0
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 == r8) goto L_0x003b
            if (r2 == r7) goto L_0x003b
            if (r2 == r6) goto L_0x003b
            if (r2 == r5) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            goto L_0x003b
        L_0x0033:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003b:
            int r11 = r0.f8676a
            R2.n.b(r15)
            goto L_0x0118
        L_0x0042:
            R2.n.b(r15)
            boolean r15 = r11 instanceof java.io.File
            java.lang.String r2 = "context.getString(R.stri…eate_dialog_folder_error)"
            java.lang.String r9 = "context.getString(R.stri…te_dialog_folder_created)"
            if (r15 == 0) goto L_0x00ce
            java.io.File r15 = new java.io.File
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.io.File r11 = (java.io.File) r11
            java.lang.String r11 = r11.getAbsolutePath()
            r4.append(r11)
            r11 = 47
            r4.append(r11)
            r4.append(r12)
            java.lang.String r11 = r4.toString()
            r15.<init>(r11)
            boolean r11 = r15.exists()
            if (r11 != 0) goto L_0x00b3
            boolean r11 = r15.mkdir()
            if (r11 == 0) goto L_0x009a
            W1.g r11 = new W1.g
            r11.<init>()
            int r12 = N1.i.core_create_dialog_folder_created
            java.lang.String r12 = r13.getString(r12)
            kotlin.jvm.internal.m.d(r12, r9)
            W1.g$c r15 = new W1.g$c
            r15.<init>(r14)
            r0.f8676a = r8
            r0.f8679d = r8
            java.lang.Object r11 = r11.e(r13, r12, r15, r0)
            if (r11 != r1) goto L_0x0097
            goto L_0x0116
        L_0x0097:
            r11 = 1
            goto L_0x0118
        L_0x009a:
            W1.g r11 = new W1.g
            r11.<init>()
            int r12 = N1.i.core_create_dialog_folder_error
            java.lang.String r12 = r13.getString(r12)
            kotlin.jvm.internal.m.d(r12, r2)
            r0.f8676a = r3
            r0.f8679d = r7
            java.lang.Object r11 = r11.c(r13, r12, r0)
            if (r11 != r1) goto L_0x0117
            goto L_0x0116
        L_0x00b3:
            W1.g r11 = new W1.g
            r11.<init>()
            int r12 = N1.i.core_create_dialog_already_exists
            java.lang.String r12 = r13.getString(r12)
            java.lang.String r14 = "context.getString(R.stri…te_dialog_already_exists)"
            kotlin.jvm.internal.m.d(r12, r14)
            r0.f8676a = r3
            r0.f8679d = r6
            java.lang.Object r11 = r11.c(r13, r12, r0)
            if (r11 != r1) goto L_0x0117
            goto L_0x0116
        L_0x00ce:
            boolean r15 = r11 instanceof androidx.documentfile.provider.DocumentFile
            if (r15 == 0) goto L_0x0117
            androidx.documentfile.provider.DocumentFile r11 = (androidx.documentfile.provider.DocumentFile) r11
            androidx.documentfile.provider.DocumentFile r11 = r11.createDirectory(r12)
            if (r11 == 0) goto L_0x00fe
            boolean r11 = r11.exists()
            if (r11 == 0) goto L_0x00fe
            W1.g r11 = new W1.g
            r11.<init>()
            int r12 = N1.i.core_create_dialog_folder_created
            java.lang.String r12 = r13.getString(r12)
            kotlin.jvm.internal.m.d(r12, r9)
            W1.g$d r15 = new W1.g$d
            r15.<init>(r14)
            r0.f8676a = r8
            r0.f8679d = r5
            java.lang.Object r11 = r11.e(r13, r12, r15, r0)
            if (r11 != r1) goto L_0x0097
            goto L_0x0116
        L_0x00fe:
            W1.g r11 = new W1.g
            r11.<init>()
            int r12 = N1.i.core_create_dialog_folder_error
            java.lang.String r12 = r13.getString(r12)
            kotlin.jvm.internal.m.d(r12, r2)
            r0.f8676a = r3
            r0.f8679d = r4
            java.lang.Object r11 = r11.c(r13, r12, r0)
            if (r11 != r1) goto L_0x0117
        L_0x0116:
            return r1
        L_0x0117:
            r11 = 0
        L_0x0118:
            if (r11 == 0) goto L_0x011b
            r3 = 1
        L_0x011b:
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.b.a(r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.C1611g.d(java.lang.Object, java.lang.String, android.content.Context, d3.a, V2.d):java.lang.Object");
    }

    public final long f(String str) {
        kotlin.jvm.internal.m.e(str, "realPath");
        try {
            return new File(str).length();
        } catch (Exception unused) {
            return -1;
        }
    }

    public final String g(long j4) {
        Calendar instance = Calendar.getInstance(Locale.FRANCE);
        instance.setTimeInMillis(j4);
        return DateFormat.format("dd MMM yyyy hh:mm", instance).toString();
    }

    public final long h(File file) {
        File[] fileArr;
        kotlin.jvm.internal.m.e(file, "dir");
        if (!file.isDirectory()) {
            return file.length();
        }
        try {
            fileArr = file.listFiles();
        } catch (SecurityException e5) {
            e5.printStackTrace();
            fileArr = null;
        }
        long j4 = 0;
        if (fileArr != null) {
            Iterator a5 = C2098b.a(fileArr);
            while (a5.hasNext()) {
                j4 += h((File) a5.next());
            }
        }
        return j4;
    }

    public final ArrayList i(File file, Context context) {
        kotlin.jvm.internal.m.e(file, "directory");
        kotlin.jvm.internal.m.e(context, "context");
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            String packageName = context.getPackageName();
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    String absolutePath = file2.getAbsolutePath();
                    kotlin.jvm.internal.m.d(absolutePath, "childFile.absolutePath");
                    if (!m.o(absolutePath, "Android/data/" + packageName, false, 2, (Object) null)) {
                        String name = file2.getName();
                        kotlin.jvm.internal.m.d(name, "childFile.name");
                        if (a(name)) {
                            kotlin.jvm.internal.m.d(file2, "childFile");
                            arrayList.addAll(i(file2, context));
                        }
                    }
                } else {
                    String name2 = file2.getName();
                    kotlin.jvm.internal.m.d(name2, "childFile.name");
                    if (l(name2)) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return arrayList;
    }

    public final boolean k(PackageInfo packageInfo) {
        kotlin.jvm.internal.m.e(packageInfo, "pi");
        try {
            Bundle bundle = packageInfo.applicationInfo.metaData;
            if (bundle == null || !bundle.containsKey("com.android.vending.splits.required")) {
                return false;
            }
            return packageInfo.applicationInfo.metaData.getBoolean("com.android.vending.splits.required");
        } catch (Exception e5) {
            e5.printStackTrace();
            return false;
        }
    }

    public final boolean l(String str) {
        kotlin.jvm.internal.m.e(str, RewardPlus.NAME);
        if ((m.o(str, ".apk", false, 2, (Object) null) || G.f8470b.a(str)) && !m.y(str, ".", false, 2, (Object) null)) {
            return true;
        }
        return false;
    }

    public final String m(String str) {
        kotlin.jvm.internal.m.e(str, "fileName");
        return new j("[/\\\\:*?\"<>|]").g(str, "");
    }

    public final ArrayList o(Context context) {
        kotlin.jvm.internal.m.e(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(j(context));
        return n(arrayList, context);
    }
}
