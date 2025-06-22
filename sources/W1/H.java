package W1;

import R2.n;
import R2.s;
import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import d3.p;
import java.io.File;
import java.util.ArrayList;
import java.util.zip.ZipOutputStream;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.B;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.J;
import o3.Y;

public final class H {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f8516a = new byte[4096];
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f8517b;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f8518a;

        /* renamed from: b  reason: collision with root package name */
        int f8519b;

        /* renamed from: c  reason: collision with root package name */
        int f8520c;

        /* renamed from: d  reason: collision with root package name */
        int f8521d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ DocumentFile f8522e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ZipOutputStream f8523f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ Context f8524g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ H f8525h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(DocumentFile documentFile, ZipOutputStream zipOutputStream, Context context, H h4, V2.d dVar) {
            super(2, dVar);
            this.f8522e = documentFile;
            this.f8523f = zipOutputStream;
            this.f8524g = context;
            this.f8525h = h4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f8522e, this.f8523f, this.f8524g, this.f8525h, dVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:31:0x0095  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r8.f8521d
                r2 = 1
                if (r1 == 0) goto L_0x0020
                if (r1 != r2) goto L_0x0018
                int r1 = r8.f8520c
                int r3 = r8.f8519b
                java.lang.Object r4 = r8.f8518a
                androidx.documentfile.provider.DocumentFile[] r4 = (androidx.documentfile.provider.DocumentFile[]) r4
                R2.n.b(r9)
                goto L_0x00b1
            L_0x0018:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x0020:
                R2.n.b(r9)
                androidx.documentfile.provider.DocumentFile r9 = r8.f8522e
                boolean r9 = r9.isFile()
                r1 = 0
                if (r9 == 0) goto L_0x007c
                java.util.zip.ZipEntry r9 = new java.util.zip.ZipEntry
                androidx.documentfile.provider.DocumentFile r0 = r8.f8522e
                java.lang.String r0 = r0.getName()
                r9.<init>(r0)
                java.util.zip.ZipOutputStream r0 = r8.f8523f
                r0.putNextEntry(r9)
                android.content.Context r9 = r8.f8524g
                android.content.ContentResolver r9 = r9.getContentResolver()
                r0 = 0
                if (r9 == 0) goto L_0x0050
                androidx.documentfile.provider.DocumentFile r2 = r8.f8522e
                android.net.Uri r2 = r2.getUri()
                java.io.InputStream r9 = r9.openInputStream(r2)
                goto L_0x0051
            L_0x0050:
                r9 = r0
            L_0x0051:
                W1.H r2 = r8.f8525h
                java.util.zip.ZipOutputStream r3 = r8.f8523f
                if (r9 == 0) goto L_0x006b
            L_0x0057:
                byte[] r4 = r2.f8516a     // Catch:{ all -> 0x0069 }
                int r4 = r9.read(r4)     // Catch:{ all -> 0x0069 }
                if (r4 <= 0) goto L_0x006b
                byte[] r5 = r2.f8516a     // Catch:{ all -> 0x0069 }
                r3.write(r5, r1, r4)     // Catch:{ all -> 0x0069 }
                goto L_0x0057
            L_0x0069:
                r0 = move-exception
                goto L_0x0076
            L_0x006b:
                R2.s r1 = R2.s.f8222a     // Catch:{ all -> 0x0069 }
                b3.C1642b.a(r9, r0)
                java.util.zip.ZipOutputStream r9 = r8.f8523f
                r9.closeEntry()
                goto L_0x00b3
            L_0x0076:
                throw r0     // Catch:{ all -> 0x0077 }
            L_0x0077:
                r1 = move-exception
                b3.C1642b.a(r9, r0)
                throw r1
            L_0x007c:
                androidx.documentfile.provider.DocumentFile r9 = r8.f8522e
                boolean r9 = r9.isDirectory()
                if (r9 == 0) goto L_0x00b3
                androidx.documentfile.provider.DocumentFile r9 = r8.f8522e
                androidx.documentfile.provider.DocumentFile[] r9 = r9.listFiles()
                java.lang.String r3 = "sourceFile.listFiles()"
                kotlin.jvm.internal.m.d(r9, r3)
                int r3 = r9.length
                r4 = r9
                r1 = r3
                r3 = 0
            L_0x0093:
                if (r3 >= r1) goto L_0x00b3
                r9 = r4[r3]
                W1.H r5 = r8.f8525h
                java.lang.String r6 = "entry"
                kotlin.jvm.internal.m.d(r9, r6)
                java.util.zip.ZipOutputStream r6 = r8.f8523f
                android.content.Context r7 = r8.f8524g
                r8.f8518a = r4
                r8.f8519b = r3
                r8.f8520c = r1
                r8.f8521d = r2
                java.lang.Object r9 = r5.f(r9, r6, r7, r8)
                if (r9 != r0) goto L_0x00b1
                return r0
            L_0x00b1:
                int r3 = r3 + r2
                goto L_0x0093
            L_0x00b3:
                R2.s r9 = R2.s.f8222a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.H.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f8526a;

        /* renamed from: b  reason: collision with root package name */
        int f8527b;

        /* renamed from: c  reason: collision with root package name */
        int f8528c;

        /* renamed from: d  reason: collision with root package name */
        int f8529d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ File f8530e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f8531f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ZipOutputStream f8532g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ H f8533h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(File file, String str, ZipOutputStream zipOutputStream, H h4, V2.d dVar) {
            super(2, dVar);
            this.f8530e = file;
            this.f8531f = str;
            this.f8532g = zipOutputStream;
            this.f8533h = h4;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f8530e, this.f8531f, this.f8532g, this.f8533h, dVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x007f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r8.f8529d
                r2 = 1
                if (r1 == 0) goto L_0x0020
                if (r1 != r2) goto L_0x0018
                int r1 = r8.f8528c
                int r3 = r8.f8527b
                java.lang.Object r4 = r8.f8526a
                java.io.File[] r4 = (java.io.File[]) r4
                R2.n.b(r9)
                goto L_0x00b3
            L_0x0018:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x0020:
                R2.n.b(r9)
                java.io.File r9 = r8.f8530e
                boolean r9 = r9.isFile()
                r1 = 0
                if (r9 == 0) goto L_0x0069
                java.util.zip.ZipEntry r9 = new java.util.zip.ZipEntry
                java.lang.String r0 = r8.f8531f
                r9.<init>(r0)
                java.util.zip.ZipOutputStream r0 = r8.f8532g
                r0.putNextEntry(r9)
                java.io.FileInputStream r9 = new java.io.FileInputStream
                java.io.File r0 = r8.f8530e
                r9.<init>(r0)
                W1.H r0 = r8.f8533h
                java.util.zip.ZipOutputStream r2 = r8.f8532g
            L_0x0043:
                byte[] r3 = r0.f8516a     // Catch:{ all -> 0x0055 }
                int r3 = r9.read(r3)     // Catch:{ all -> 0x0055 }
                if (r3 <= 0) goto L_0x0057
                byte[] r4 = r0.f8516a     // Catch:{ all -> 0x0055 }
                r2.write(r4, r1, r3)     // Catch:{ all -> 0x0055 }
                goto L_0x0043
            L_0x0055:
                r0 = move-exception
                goto L_0x0063
            L_0x0057:
                R2.s r0 = R2.s.f8222a     // Catch:{ all -> 0x0055 }
                r0 = 0
                b3.C1642b.a(r9, r0)
                java.util.zip.ZipOutputStream r9 = r8.f8532g
                r9.closeEntry()
                goto L_0x00b5
            L_0x0063:
                throw r0     // Catch:{ all -> 0x0064 }
            L_0x0064:
                r1 = move-exception
                b3.C1642b.a(r9, r0)
                throw r1
            L_0x0069:
                java.io.File r9 = r8.f8530e
                boolean r9 = r9.isDirectory()
                if (r9 == 0) goto L_0x00b5
                java.io.File r9 = r8.f8530e
                java.io.File[] r9 = r9.listFiles()
                if (r9 == 0) goto L_0x00b5
                int r3 = r9.length
                r4 = r9
                r1 = r3
                r3 = 0
            L_0x007d:
                if (r3 >= r1) goto L_0x00b5
                r9 = r4[r3]
                W1.H r5 = r8.f8533h
                java.lang.String r6 = "entry"
                kotlin.jvm.internal.m.d(r9, r6)
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = r8.f8531f
                r6.append(r7)
                r7 = 47
                r6.append(r7)
                java.lang.String r7 = r9.getName()
                r6.append(r7)
                java.lang.String r6 = r6.toString()
                java.util.zip.ZipOutputStream r7 = r8.f8532g
                r8.f8526a = r4
                r8.f8527b = r3
                r8.f8528c = r1
                r8.f8529d = r2
                java.lang.Object r9 = r5.g(r9, r6, r7, r8)
                if (r9 != r0) goto L_0x00b3
                return r0
            L_0x00b3:
                int r3 = r3 + r2
                goto L_0x007d
            L_0x00b5:
                R2.s r9 = R2.s.f8222a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.H.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f8534a;

        /* renamed from: b  reason: collision with root package name */
        Object f8535b;

        /* renamed from: c  reason: collision with root package name */
        Object f8536c;

        /* renamed from: d  reason: collision with root package name */
        int f8537d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ File f8538e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ArrayList f8539f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ H f8540g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ S1.c f8541h;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8542a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.c f8543b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f8544c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(S1.c cVar, ArrayList arrayList, V2.d dVar) {
                super(2, dVar);
                this.f8543b = cVar;
                this.f8544c = arrayList;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f8543b, this.f8544c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8542a == 0) {
                    n.b(obj);
                    this.f8543b.b(String.valueOf(this.f8544c.size()));
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8545a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.c f8546b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ H f8547c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ ArrayList f8548d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ String f8549e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(S1.c cVar, H h4, ArrayList arrayList, String str, V2.d dVar) {
                super(2, dVar);
                this.f8546b = cVar;
                this.f8547c = h4;
                this.f8548d = arrayList;
                this.f8549e = str;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f8546b, this.f8547c, this.f8548d, this.f8549e, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8545a == 0) {
                    n.b(obj);
                    this.f8546b.c((this.f8547c.f8517b * 100) / this.f8548d.size(), this.f8549e);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: W1.H$c$c  reason: collision with other inner class name */
        static final class C0118c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8550a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.c f8551b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ File f8552c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0118c(S1.c cVar, File file, V2.d dVar) {
                super(2, dVar);
                this.f8551b = cVar;
                this.f8552c = file;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0118c(this.f8551b, this.f8552c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8550a == 0) {
                    n.b(obj);
                    S1.c cVar = this.f8551b;
                    String name = this.f8552c.getName();
                    m.d(name, "destinationZip.name");
                    cVar.a(name);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0118c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(File file, ArrayList arrayList, H h4, S1.c cVar, V2.d dVar) {
            super(2, dVar);
            this.f8538e = file;
            this.f8539f = arrayList;
            this.f8540g = h4;
            this.f8541h = cVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new c(this.f8538e, this.f8539f, this.f8540g, this.f8541h, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x007c, code lost:
            if (o3.C0977g.g(r9, r10, r0) == r1) goto L_0x0122;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00fe, code lost:
            if (o3.C0977g.g(r10, r12, r0) != r1) goto L_0x0033;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0120, code lost:
            if (o3.C0977g.g(r2, r4, r0) == r1) goto L_0x0122;
         */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x008c  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0101  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                r19 = this;
                r0 = r19
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f8537d
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                r7 = 0
                if (r2 == 0) goto L_0x0056
                if (r2 == r6) goto L_0x004a
                if (r2 == r5) goto L_0x003a
                if (r2 == r4) goto L_0x0024
                if (r2 != r3) goto L_0x001c
                R2.n.b(r20)
                goto L_0x0123
            L_0x001c:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0024:
                java.lang.Object r2 = r0.f8536c
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r8 = r0.f8535b
                java.util.zip.ZipOutputStream r8 = (java.util.zip.ZipOutputStream) r8
                java.lang.Object r9 = r0.f8534a
                java.io.FileOutputStream r9 = (java.io.FileOutputStream) r9
                R2.n.b(r20)
            L_0x0033:
                r18 = r9
                r9 = r2
                r2 = r8
                r8 = r18
                goto L_0x0086
            L_0x003a:
                java.lang.Object r2 = r0.f8536c
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r8 = r0.f8535b
                java.util.zip.ZipOutputStream r8 = (java.util.zip.ZipOutputStream) r8
                java.lang.Object r9 = r0.f8534a
                java.io.FileOutputStream r9 = (java.io.FileOutputStream) r9
                R2.n.b(r20)
                goto L_0x00b7
            L_0x004a:
                java.lang.Object r2 = r0.f8535b
                java.util.zip.ZipOutputStream r2 = (java.util.zip.ZipOutputStream) r2
                java.lang.Object r8 = r0.f8534a
                java.io.FileOutputStream r8 = (java.io.FileOutputStream) r8
                R2.n.b(r20)
                goto L_0x0080
            L_0x0056:
                R2.n.b(r20)
                java.io.FileOutputStream r8 = new java.io.FileOutputStream
                java.io.File r2 = r0.f8538e
                r8.<init>(r2)
                java.util.zip.ZipOutputStream r2 = new java.util.zip.ZipOutputStream
                r2.<init>(r8)
                o3.E0 r9 = o3.Y.c()
                W1.H$c$a r10 = new W1.H$c$a
                S1.c r11 = r0.f8541h
                java.util.ArrayList r12 = r0.f8539f
                r10.<init>(r11, r12, r7)
                r0.f8534a = r8
                r0.f8535b = r2
                r0.f8537d = r6
                java.lang.Object r9 = o3.C0977g.g(r9, r10, r0)
                if (r9 != r1) goto L_0x0080
                goto L_0x0122
            L_0x0080:
                java.util.ArrayList r9 = r0.f8539f
                java.util.Iterator r9 = r9.iterator()
            L_0x0086:
                boolean r10 = r9.hasNext()
                if (r10 == 0) goto L_0x0101
                java.lang.Object r10 = r9.next()
                java.io.File r10 = (java.io.File) r10
                W1.H r11 = r0.f8540g
                java.lang.String r12 = "file"
                kotlin.jvm.internal.m.d(r10, r12)
                java.lang.String r12 = r10.getName()
                java.lang.String r13 = "file.name"
                kotlin.jvm.internal.m.d(r12, r13)
                r0.f8534a = r8
                r0.f8535b = r2
                r0.f8536c = r9
                r0.f8537d = r5
                java.lang.Object r10 = r11.g(r10, r12, r2, r0)
                if (r10 != r1) goto L_0x00b1
                goto L_0x0122
            L_0x00b1:
                r18 = r8
                r8 = r2
                r2 = r9
                r9 = r18
            L_0x00b7:
                W1.H r10 = r0.f8540g
                int r11 = r10.f8517b
                int r11 = r11 + r6
                r10.f8517b = r11
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                W1.H r11 = r0.f8540g
                int r11 = r11.f8517b
                r10.append(r11)
                r11 = 47
                r10.append(r11)
                java.util.ArrayList r11 = r0.f8539f
                int r11 = r11.size()
                r10.append(r11)
                java.lang.String r16 = r10.toString()
                o3.E0 r10 = o3.Y.c()
                W1.H$c$b r12 = new W1.H$c$b
                S1.c r13 = r0.f8541h
                W1.H r14 = r0.f8540g
                java.util.ArrayList r15 = r0.f8539f
                r17 = 0
                r12.<init>(r13, r14, r15, r16, r17)
                r0.f8534a = r9
                r0.f8535b = r8
                r0.f8536c = r2
                r0.f8537d = r4
                java.lang.Object r10 = o3.C0977g.g(r10, r12, r0)
                if (r10 != r1) goto L_0x0033
                goto L_0x0122
            L_0x0101:
                r2.close()
                r8.close()
                o3.E0 r2 = o3.Y.c()
                W1.H$c$c r4 = new W1.H$c$c
                S1.c r5 = r0.f8541h
                java.io.File r6 = r0.f8538e
                r4.<init>(r5, r6, r7)
                r0.f8534a = r7
                r0.f8535b = r7
                r0.f8536c = r7
                r0.f8537d = r3
                java.lang.Object r2 = o3.C0977g.g(r2, r4, r0)
                if (r2 != r1) goto L_0x0123
            L_0x0122:
                return r1
            L_0x0123:
                R2.s r1 = R2.s.f8222a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.H.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f8553a;

        /* renamed from: b  reason: collision with root package name */
        Object f8554b;

        /* renamed from: c  reason: collision with root package name */
        Object f8555c;

        /* renamed from: d  reason: collision with root package name */
        int f8556d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f8557e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ DocumentFile f8558f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ ArrayList f8559g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ H f8560h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ S1.c f8561i;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8562a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.c f8563b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f8564c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(S1.c cVar, ArrayList arrayList, V2.d dVar) {
                super(2, dVar);
                this.f8563b = cVar;
                this.f8564c = arrayList;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f8563b, this.f8564c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8562a == 0) {
                    n.b(obj);
                    this.f8563b.b(String.valueOf(this.f8564c.size()));
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8565a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.c f8566b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(S1.c cVar, V2.d dVar) {
                super(2, dVar);
                this.f8566b = cVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f8566b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8565a == 0) {
                    n.b(obj);
                    this.f8566b.onError("FileNotFoundException");
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8567a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.c f8568b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ H f8569c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ ArrayList f8570d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ String f8571e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(S1.c cVar, H h4, ArrayList arrayList, String str, V2.d dVar) {
                super(2, dVar);
                this.f8568b = cVar;
                this.f8569c = h4;
                this.f8570d = arrayList;
                this.f8571e = str;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new c(this.f8568b, this.f8569c, this.f8570d, this.f8571e, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8567a == 0) {
                    n.b(obj);
                    this.f8568b.c((this.f8569c.f8517b * 100) / this.f8570d.size(), this.f8571e);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: W1.H$d$d  reason: collision with other inner class name */
        static final class C0119d extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8572a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.c f8573b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ DocumentFile f8574c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0119d(S1.c cVar, DocumentFile documentFile, V2.d dVar) {
                super(2, dVar);
                this.f8573b = cVar;
                this.f8574c = documentFile;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0119d(this.f8573b, this.f8574c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8572a == 0) {
                    n.b(obj);
                    S1.c cVar = this.f8573b;
                    String name = this.f8574c.getName();
                    m.b(name);
                    cVar.a(name);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0119d) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, DocumentFile documentFile, ArrayList arrayList, H h4, S1.c cVar, V2.d dVar) {
            super(2, dVar);
            this.f8557e = context;
            this.f8558f = documentFile;
            this.f8559g = arrayList;
            this.f8560h = h4;
            this.f8561i = cVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new d(this.f8557e, this.f8558f, this.f8559g, this.f8560h, this.f8561i, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x006b, code lost:
            if (o3.C0977g.g(r2, r9, r0) == r1) goto L_0x013a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0094, code lost:
            if (o3.C0977g.g(r2, r9, r0) != r1) goto L_0x0098;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0114, code lost:
            if (o3.C0977g.g(r10, r12, r0) != r1) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0138, code lost:
            if (o3.C0977g.g(r2, r4, r0) == r1) goto L_0x013a;
         */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00aa  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0117  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                r19 = this;
                r0 = r19
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f8556d
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r7 = 1
                r8 = 0
                if (r2 == 0) goto L_0x0055
                if (r2 == r7) goto L_0x0051
                if (r2 == r6) goto L_0x004d
                if (r2 == r5) goto L_0x003c
                if (r2 == r4) goto L_0x0027
                if (r2 != r3) goto L_0x001f
                R2.n.b(r20)
                goto L_0x013b
            L_0x001f:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0027:
                java.lang.Object r2 = r0.f8555c
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r6 = r0.f8554b
                java.util.zip.ZipOutputStream r6 = (java.util.zip.ZipOutputStream) r6
                java.lang.Object r9 = r0.f8553a
                java.io.OutputStream r9 = (java.io.OutputStream) r9
                R2.n.b(r20)
            L_0x0036:
                r18 = r9
                r9 = r2
                r2 = r18
                goto L_0x00a4
            L_0x003c:
                java.lang.Object r2 = r0.f8555c
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r6 = r0.f8554b
                java.util.zip.ZipOutputStream r6 = (java.util.zip.ZipOutputStream) r6
                java.lang.Object r9 = r0.f8553a
                java.io.OutputStream r9 = (java.io.OutputStream) r9
                R2.n.b(r20)
                goto L_0x00cd
            L_0x004d:
                R2.n.b(r20)
                goto L_0x0098
            L_0x0051:
                R2.n.b(r20)
                goto L_0x006f
            L_0x0055:
                R2.n.b(r20)
                o3.E0 r2 = o3.Y.c()
                W1.H$d$a r9 = new W1.H$d$a
                S1.c r10 = r0.f8561i
                java.util.ArrayList r11 = r0.f8559g
                r9.<init>(r10, r11, r8)
                r0.f8556d = r7
                java.lang.Object r2 = o3.C0977g.g(r2, r9, r0)
                if (r2 != r1) goto L_0x006f
                goto L_0x013a
            L_0x006f:
                android.content.Context r2 = r0.f8557e     // Catch:{ FileNotFoundException -> 0x0082 }
                android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0082 }
                if (r2 == 0) goto L_0x0098
                androidx.documentfile.provider.DocumentFile r9 = r0.f8558f     // Catch:{ FileNotFoundException -> 0x0082 }
                android.net.Uri r9 = r9.getUri()     // Catch:{ FileNotFoundException -> 0x0082 }
                java.io.OutputStream r2 = r2.openOutputStream(r9)     // Catch:{ FileNotFoundException -> 0x0082 }
                goto L_0x0099
            L_0x0082:
                o3.E0 r2 = o3.Y.c()
                W1.H$d$b r9 = new W1.H$d$b
                S1.c r10 = r0.f8561i
                r9.<init>(r10, r8)
                r0.f8556d = r6
                java.lang.Object r2 = o3.C0977g.g(r2, r9, r0)
                if (r2 != r1) goto L_0x0098
                goto L_0x013a
            L_0x0098:
                r2 = r8
            L_0x0099:
                java.util.zip.ZipOutputStream r6 = new java.util.zip.ZipOutputStream
                r6.<init>(r2)
                java.util.ArrayList r9 = r0.f8559g
                java.util.Iterator r9 = r9.iterator()
            L_0x00a4:
                boolean r10 = r9.hasNext()
                if (r10 == 0) goto L_0x0117
                java.lang.Object r10 = r9.next()
                androidx.documentfile.provider.DocumentFile r10 = (androidx.documentfile.provider.DocumentFile) r10
                W1.H r11 = r0.f8560h
                java.lang.String r12 = "documentFile"
                kotlin.jvm.internal.m.d(r10, r12)
                android.content.Context r12 = r0.f8557e
                r0.f8553a = r2
                r0.f8554b = r6
                r0.f8555c = r9
                r0.f8556d = r5
                java.lang.Object r10 = r11.f(r10, r6, r12, r0)
                if (r10 != r1) goto L_0x00c8
                goto L_0x013a
            L_0x00c8:
                r18 = r9
                r9 = r2
                r2 = r18
            L_0x00cd:
                W1.H r10 = r0.f8560h
                int r11 = r10.f8517b
                int r11 = r11 + r7
                r10.f8517b = r11
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>()
                W1.H r11 = r0.f8560h
                int r11 = r11.f8517b
                r10.append(r11)
                r11 = 47
                r10.append(r11)
                java.util.ArrayList r11 = r0.f8559g
                int r11 = r11.size()
                r10.append(r11)
                java.lang.String r16 = r10.toString()
                o3.E0 r10 = o3.Y.c()
                W1.H$d$c r12 = new W1.H$d$c
                S1.c r13 = r0.f8561i
                W1.H r14 = r0.f8560h
                java.util.ArrayList r15 = r0.f8559g
                r17 = 0
                r12.<init>(r13, r14, r15, r16, r17)
                r0.f8553a = r9
                r0.f8554b = r6
                r0.f8555c = r2
                r0.f8556d = r4
                java.lang.Object r10 = o3.C0977g.g(r10, r12, r0)
                if (r10 != r1) goto L_0x0036
                goto L_0x013a
            L_0x0117:
                r6.close()
                if (r2 == 0) goto L_0x011f
                r2.close()
            L_0x011f:
                o3.E0 r2 = o3.Y.c()
                W1.H$d$d r4 = new W1.H$d$d
                S1.c r5 = r0.f8561i
                androidx.documentfile.provider.DocumentFile r6 = r0.f8558f
                r4.<init>(r5, r6, r8)
                r0.f8553a = r8
                r0.f8554b = r8
                r0.f8555c = r8
                r0.f8556d = r3
                java.lang.Object r2 = o3.C0977g.g(r2, r4, r0)
                if (r2 != r1) goto L_0x013b
            L_0x013a:
                return r1
            L_0x013b:
                R2.s r1 = R2.s.f8222a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.H.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f8575a;

        /* renamed from: b  reason: collision with root package name */
        Object f8576b;

        /* renamed from: c  reason: collision with root package name */
        Object f8577c;

        /* renamed from: d  reason: collision with root package name */
        Object f8578d;

        /* renamed from: e  reason: collision with root package name */
        Object f8579e;

        /* renamed from: f  reason: collision with root package name */
        Object f8580f;

        /* renamed from: g  reason: collision with root package name */
        long f8581g;

        /* renamed from: h  reason: collision with root package name */
        int f8582h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f8583i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ File f8584j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ H f8585k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ S1.e f8586l;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8587a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.e f8588b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(S1.e eVar, V2.d dVar) {
                super(2, dVar);
                this.f8588b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f8588b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8587a == 0) {
                    n.b(obj);
                    this.f8588b.c();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8589a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.e f8590b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ B f8591c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(S1.e eVar, B b5, V2.d dVar) {
                super(2, dVar);
                this.f8590b = eVar;
                this.f8591c = b5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f8590b, this.f8591c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8589a == 0) {
                    n.b(obj);
                    this.f8590b.d(this.f8591c.f20967a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8592a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.e f8593b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ A f8594c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(S1.e eVar, A a5, V2.d dVar) {
                super(2, dVar);
                this.f8593b = eVar;
                this.f8594c = a5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new c(this.f8593b, this.f8594c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8592a == 0) {
                    n.b(obj);
                    this.f8593b.b(this.f8594c.f20966a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str, File file, H h4, S1.e eVar, V2.d dVar) {
            super(2, dVar);
            this.f8583i = str;
            this.f8584j = file;
            this.f8585k = h4;
            this.f8586l = eVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new e(this.f8583i, this.f8584j, this.f8585k, this.f8586l, dVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: java.util.zip.ZipInputStream} */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x018f, code lost:
            if (o3.C0977g.g(r3, r4, r1) != r0) goto L_0x0192;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x0196 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x00b9 A[Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0101 A[Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x0113 A[Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }] */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x013b A[Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }] */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x015e A[Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }] */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x0170 A[Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                r19 = this;
                r1 = r19
                java.lang.Object r0 = W2.b.c()
                int r2 = r1.f8582h
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L_0x0076
                if (r2 == r5) goto L_0x0053
                if (r2 == r4) goto L_0x0029
                if (r2 != r3) goto L_0x0021
                java.lang.Object r0 = r1.f8575a
                r2 = r0
                java.util.zip.ZipInputStream r2 = (java.util.zip.ZipInputStream) r2
                R2.n.b(r20)     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                goto L_0x0192
            L_0x001e:
                r0 = move-exception
                goto L_0x01a5
            L_0x0021:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0029:
                long r7 = r1.f8581g
                java.lang.Object r2 = r1.f8580f
                kotlin.jvm.internal.A r2 = (kotlin.jvm.internal.A) r2
                java.lang.Object r9 = r1.f8579e
                java.io.FileOutputStream r9 = (java.io.FileOutputStream) r9
                java.lang.Object r10 = r1.f8578d
                kotlin.jvm.internal.B r10 = (kotlin.jvm.internal.B) r10
                java.lang.Object r11 = r1.f8577c
                kotlin.jvm.internal.A r11 = (kotlin.jvm.internal.A) r11
                java.lang.Object r12 = r1.f8576b
                java.util.zip.ZipInputStream r12 = (java.util.zip.ZipInputStream) r12
                java.lang.Object r13 = r1.f8575a
                java.io.File r13 = (java.io.File) r13
                R2.n.b(r20)     // Catch:{ EOFException -> 0x0050, IOException -> 0x004d, all -> 0x0049 }
                r14 = 2
                goto L_0x0140
            L_0x0049:
                r0 = move-exception
                r2 = r12
                goto L_0x01a5
            L_0x004d:
                r2 = r12
                goto L_0x0196
            L_0x0050:
                r2 = r12
                goto L_0x019c
            L_0x0053:
                java.lang.Object r2 = r1.f8578d
                java.util.zip.ZipEntry r2 = (java.util.zip.ZipEntry) r2
                java.lang.Object r7 = r1.f8577c
                kotlin.jvm.internal.A r7 = (kotlin.jvm.internal.A) r7
                java.lang.Object r8 = r1.f8576b
                java.util.zip.ZipInputStream r8 = (java.util.zip.ZipInputStream) r8
                java.lang.Object r9 = r1.f8575a
                java.io.File r9 = (java.io.File) r9
                R2.n.b(r20)     // Catch:{ EOFException -> 0x0073, IOException -> 0x0070, all -> 0x006c }
                r16 = r8
                r8 = r2
                r2 = r16
                goto L_0x00b2
            L_0x006c:
                r0 = move-exception
                r2 = r8
                goto L_0x01a5
            L_0x0070:
                r2 = r8
                goto L_0x0196
            L_0x0073:
                r2 = r8
                goto L_0x019c
            L_0x0076:
                R2.n.b(r20)
                java.io.File r9 = new java.io.File
                java.lang.String r2 = r1.f8583i
                r9.<init>(r2)
                java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream
                java.io.FileInputStream r7 = new java.io.FileInputStream
                java.io.File r8 = r1.f8584j
                r7.<init>(r8)
                r2.<init>(r7)
                kotlin.jvm.internal.A r7 = new kotlin.jvm.internal.A
                r7.<init>()
                java.util.zip.ZipEntry r8 = r2.getNextEntry()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                o3.E0 r10 = o3.Y.c()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                W1.H$e$a r11 = new W1.H$e$a     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                S1.e r12 = r1.f8586l     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r11.<init>(r12, r6)     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8575a = r9     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8576b = r2     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8577c = r7     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8578d = r8     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8582h = r5     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                java.lang.Object r10 = o3.C0977g.g(r10, r11, r1)     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                if (r10 != r0) goto L_0x00b2
                goto L_0x0191
            L_0x00b2:
                kotlin.jvm.internal.B r10 = new kotlin.jvm.internal.B     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r10.<init>()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
            L_0x00b7:
                if (r8 == 0) goto L_0x0170
                int r11 = r7.f20966a     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                int r11 = r11 + r5
                r7.f20966a = r11     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                java.io.File r11 = new java.io.File     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                java.lang.String r12 = r8.getName()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r11.<init>(r9, r12)     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                boolean r8 = r8.isDirectory()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                if (r8 == 0) goto L_0x00d3
                r11.mkdirs()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r14 = 2
                goto L_0x0163
            L_0x00d3:
                java.io.File r8 = r11.getParentFile()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                if (r8 == 0) goto L_0x00e2
                boolean r12 = r8.exists()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                if (r12 != 0) goto L_0x00e2
                r8.mkdirs()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
            L_0x00e2:
                java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r8.<init>(r11)     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                kotlin.jvm.internal.A r11 = new kotlin.jvm.internal.A     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r11.<init>()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r12 = 0
                r16 = r9
                r9 = r8
                r8 = r16
            L_0x00f3:
                W1.H r14 = r1.f8585k     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                byte[] r14 = r14.f8516a     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                int r14 = r2.read(r14)     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r11.f20966a = r14     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                if (r14 <= 0) goto L_0x015e
                long r3 = r10.f20967a     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                long r5 = (long) r14     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                long r3 = r3 + r5
                r10.f20967a = r3     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r5 = 1000(0x3e8, float:1.401E-42)
                long r5 = (long) r5     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                long r5 = r5 + r12
                int r14 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r14 <= 0) goto L_0x014c
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                o3.E0 r5 = o3.Y.c()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                W1.H$e$b r6 = new W1.H$e$b     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                S1.e r12 = r1.f8586l     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r13 = 0
                r6.<init>(r12, r10, r13)     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8575a = r8     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8576b = r2     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8577c = r7     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8578d = r10     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8579e = r9     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8580f = r11     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8581g = r3     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r14 = 2
                r1.f8582h = r14     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                java.lang.Object r5 = o3.C0977g.g(r5, r6, r1)     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                if (r5 != r0) goto L_0x013b
                goto L_0x0191
            L_0x013b:
                r12 = r2
                r13 = r8
                r2 = r11
                r11 = r7
                r7 = r3
            L_0x0140:
                r16 = r11
                r11 = r2
                r2 = r12
                r17 = r7
                r7 = r16
                r8 = r13
                r12 = r17
                goto L_0x014d
            L_0x014c:
                r14 = 2
            L_0x014d:
                W1.H r3 = r1.f8585k     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                byte[] r3 = r3.f8516a     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                int r4 = r11.f20966a     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r5 = 0
                r9.write(r3, r5, r4)     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                goto L_0x00f3
            L_0x015e:
                r14 = 2
                r9.close()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r9 = r8
            L_0x0163:
                r2.closeEntry()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                java.util.zip.ZipEntry r8 = r2.getNextEntry()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                goto L_0x00b7
            L_0x0170:
                o3.E0 r3 = o3.Y.c()     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                W1.H$e$c r4 = new W1.H$e$c     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                S1.e r5 = r1.f8586l     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r13 = 0
                r4.<init>(r5, r7, r13)     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8575a = r2     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8576b = r13     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8577c = r13     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8578d = r13     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8579e = r13     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r1.f8580f = r13     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                r15 = 3
                r1.f8582h = r15     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                java.lang.Object r3 = o3.C0977g.g(r3, r4, r1)     // Catch:{ EOFException -> 0x019c, IOException -> 0x0196 }
                if (r3 != r0) goto L_0x0192
            L_0x0191:
                return r0
            L_0x0192:
                r2.close()
                goto L_0x01a2
            L_0x0196:
                S1.e r0 = r1.f8586l     // Catch:{ all -> 0x001e }
                r0.a()     // Catch:{ all -> 0x001e }
                goto L_0x0192
            L_0x019c:
                S1.e r0 = r1.f8586l     // Catch:{ all -> 0x001e }
                r0.a()     // Catch:{ all -> 0x001e }
                goto L_0x0192
            L_0x01a2:
                R2.s r0 = R2.s.f8222a
                return r0
            L_0x01a5:
                r2.close()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.H.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f8595a;

        /* renamed from: b  reason: collision with root package name */
        Object f8596b;

        /* renamed from: c  reason: collision with root package name */
        Object f8597c;

        /* renamed from: d  reason: collision with root package name */
        Object f8598d;

        /* renamed from: e  reason: collision with root package name */
        Object f8599e;

        /* renamed from: f  reason: collision with root package name */
        Object f8600f;

        /* renamed from: g  reason: collision with root package name */
        Object f8601g;

        /* renamed from: h  reason: collision with root package name */
        int f8602h;

        /* renamed from: i  reason: collision with root package name */
        long f8603i;

        /* renamed from: j  reason: collision with root package name */
        int f8604j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ File f8605k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ Uri f8606l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ Context f8607m;

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ S1.e f8608n;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8609a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.e f8610b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(S1.e eVar, V2.d dVar) {
                super(2, dVar);
                this.f8610b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f8610b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8609a == 0) {
                    n.b(obj);
                    this.f8610b.c();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8611a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.e f8612b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(S1.e eVar, V2.d dVar) {
                super(2, dVar);
                this.f8612b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f8612b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8611a == 0) {
                    n.b(obj);
                    this.f8612b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8613a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.e f8614b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(S1.e eVar, V2.d dVar) {
                super(2, dVar);
                this.f8614b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new c(this.f8614b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8613a == 0) {
                    n.b(obj);
                    this.f8614b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class d extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8615a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.e f8616b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ B f8617c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(S1.e eVar, B b5, V2.d dVar) {
                super(2, dVar);
                this.f8616b = eVar;
                this.f8617c = b5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new d(this.f8616b, this.f8617c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8615a == 0) {
                    n.b(obj);
                    this.f8616b.d(this.f8617c.f20967a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class e extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8618a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.e f8619b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ A f8620c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(S1.e eVar, A a5, V2.d dVar) {
                super(2, dVar);
                this.f8619b = eVar;
                this.f8620c = a5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new e(this.f8619b, this.f8620c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8618a == 0) {
                    n.b(obj);
                    this.f8619b.b(this.f8620c.f20966a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(File file, Uri uri, Context context, S1.e eVar, V2.d dVar) {
            super(2, dVar);
            this.f8605k = file;
            this.f8606l = uri;
            this.f8607m = context;
            this.f8608n = eVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new f(this.f8605k, this.f8606l, this.f8607m, this.f8608n, dVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: androidx.documentfile.provider.DocumentFile} */
        /* JADX WARNING: type inference failed for: r5v9 */
        /* JADX WARNING: type inference failed for: r3v16, types: [androidx.documentfile.provider.DocumentFile] */
        /* JADX WARNING: type inference failed for: r3v22 */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0091, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x02ab;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x02a9, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x02ab;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0145  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x01c8  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x01ec  */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0213  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0227  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x0255  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x025f  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x026f  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x0285  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                r25 = this;
                r0 = r25
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f8604j
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r8 = 1
                r9 = 0
                if (r2 == 0) goto L_0x007d
                if (r2 == r8) goto L_0x0079
                if (r2 == r6) goto L_0x0064
                if (r2 == r5) goto L_0x004e
                if (r2 == r4) goto L_0x0027
                if (r2 != r3) goto L_0x001f
                R2.n.b(r26)
                goto L_0x02ac
            L_0x001f:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0027:
                long r10 = r0.f8603i
                int r2 = r0.f8602h
                java.lang.Object r12 = r0.f8601g
                kotlin.jvm.internal.A r12 = (kotlin.jvm.internal.A) r12
                java.lang.Object r13 = r0.f8600f
                byte[] r13 = (byte[]) r13
                java.lang.Object r14 = r0.f8599e
                java.io.OutputStream r14 = (java.io.OutputStream) r14
                java.lang.Object r15 = r0.f8598d
                kotlin.jvm.internal.B r15 = (kotlin.jvm.internal.B) r15
                java.lang.Object r3 = r0.f8597c
                kotlin.jvm.internal.A r3 = (kotlin.jvm.internal.A) r3
                java.lang.Object r7 = r0.f8596b
                kotlin.jvm.internal.C r7 = (kotlin.jvm.internal.C) r7
                java.lang.Object r4 = r0.f8595a
                java.util.zip.ZipInputStream r4 = (java.util.zip.ZipInputStream) r4
                R2.n.b(r26)
                r5 = r14
                r14 = 4
                goto L_0x0257
            L_0x004e:
                java.lang.Object r2 = r0.f8598d
                kotlin.jvm.internal.B r2 = (kotlin.jvm.internal.B) r2
                java.lang.Object r3 = r0.f8597c
                kotlin.jvm.internal.A r3 = (kotlin.jvm.internal.A) r3
                java.lang.Object r4 = r0.f8596b
                kotlin.jvm.internal.C r4 = (kotlin.jvm.internal.C) r4
                java.lang.Object r7 = r0.f8595a
                java.util.zip.ZipInputStream r7 = (java.util.zip.ZipInputStream) r7
                R2.n.b(r26)
                r11 = 3
                goto L_0x01ef
            L_0x0064:
                java.lang.Object r2 = r0.f8598d
                kotlin.jvm.internal.B r2 = (kotlin.jvm.internal.B) r2
                java.lang.Object r3 = r0.f8597c
                kotlin.jvm.internal.A r3 = (kotlin.jvm.internal.A) r3
                java.lang.Object r4 = r0.f8596b
                kotlin.jvm.internal.C r4 = (kotlin.jvm.internal.C) r4
                java.lang.Object r7 = r0.f8595a
                java.util.zip.ZipInputStream r7 = (java.util.zip.ZipInputStream) r7
                R2.n.b(r26)
                goto L_0x01c2
            L_0x0079:
                R2.n.b(r26)
                goto L_0x0095
            L_0x007d:
                R2.n.b(r26)
                o3.E0 r2 = o3.Y.c()
                W1.H$f$a r3 = new W1.H$f$a
                S1.e r4 = r0.f8608n
                r3.<init>(r4, r9)
                r0.f8604j = r8
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0095
                goto L_0x02ab
            L_0x0095:
                java.util.zip.ZipInputStream r2 = new java.util.zip.ZipInputStream
                java.io.FileInputStream r3 = new java.io.FileInputStream
                java.io.File r4 = r0.f8605k
                r3.<init>(r4)
                r2.<init>(r3)
                java.util.zip.ZipEntry r3 = r2.getNextEntry()
                android.net.Uri r4 = r0.f8606l
                java.lang.String r10 = r4.getLastPathSegment()
                kotlin.jvm.internal.m.b(r10)
                r14 = 6
                r15 = 0
                java.lang.String r11 = ":"
                r12 = 0
                r13 = 0
                int r4 = m3.m.R(r10, r11, r12, r13, r14, r15)
                int r4 = r4 + r8
                java.lang.String r4 = r10.substring(r4)
                java.lang.String r7 = "this as java.lang.String).substring(startIndex)"
                kotlin.jvm.internal.m.d(r4, r7)
                kotlin.jvm.internal.C r7 = new kotlin.jvm.internal.C
                r7.<init>()
                android.content.Context r10 = r0.f8607m
                android.net.Uri r11 = r0.f8606l
                androidx.documentfile.provider.DocumentFile r10 = androidx.documentfile.provider.DocumentFile.fromTreeUri(r10, r11)
                r7.f20968a = r10
                java.lang.String r10 = "/"
                java.lang.String[] r18 = new java.lang.String[]{r10}
                r21 = 6
                r22 = 0
                r19 = 0
                r20 = 0
                r17 = r4
                java.util.List r4 = m3.m.j0(r17, r18, r19, r20, r21, r22)
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                java.util.Iterator r4 = r4.iterator()
            L_0x00eb:
                boolean r10 = r4.hasNext()
                if (r10 == 0) goto L_0x0134
                java.lang.Object r10 = r4.next()
                java.lang.String r10 = (java.lang.String) r10
                java.lang.Object r11 = r7.f20968a
                androidx.documentfile.provider.DocumentFile r11 = (androidx.documentfile.provider.DocumentFile) r11
                if (r11 == 0) goto L_0x011e
                androidx.documentfile.provider.DocumentFile[] r11 = r11.listFiles()
                if (r11 == 0) goto L_0x011e
                java.lang.String r12 = "listFiles()"
                kotlin.jvm.internal.m.d(r11, r12)
                int r12 = r11.length
                r14 = r9
                r13 = 0
            L_0x010b:
                if (r13 >= r12) goto L_0x011f
                r15 = r11[r13]
                java.lang.String r5 = r15.getName()
                boolean r5 = m3.m.p(r5, r10, r8)
                if (r5 == 0) goto L_0x011a
                r14 = r15
            L_0x011a:
                int r13 = r13 + 1
                r5 = 3
                goto L_0x010b
            L_0x011e:
                r14 = r9
            L_0x011f:
                if (r14 == 0) goto L_0x0124
                r7.f20968a = r14
                goto L_0x0132
            L_0x0124:
                java.lang.Object r5 = r7.f20968a
                androidx.documentfile.provider.DocumentFile r5 = (androidx.documentfile.provider.DocumentFile) r5
                if (r5 == 0) goto L_0x012f
                androidx.documentfile.provider.DocumentFile r5 = r5.createDirectory(r10)
                goto L_0x0130
            L_0x012f:
                r5 = r9
            L_0x0130:
                r7.f20968a = r5
            L_0x0132:
                r5 = 3
                goto L_0x00eb
            L_0x0134:
                kotlin.jvm.internal.A r4 = new kotlin.jvm.internal.A
                r4.<init>()
                kotlin.jvm.internal.B r5 = new kotlin.jvm.internal.B
                r5.<init>()
                r23 = r5
                r5 = r2
                r2 = r23
            L_0x0143:
                if (r3 == 0) goto L_0x0285
                int r10 = r4.f20966a
                int r10 = r10 + r8
                r4.f20966a = r10
                boolean r10 = r3.isDirectory()
                if (r10 == 0) goto L_0x0166
                android.content.Context r10 = r0.f8607m
                android.net.Uri r11 = r0.f8606l
                androidx.documentfile.provider.DocumentFile r10 = androidx.documentfile.provider.DocumentFile.fromTreeUri(r10, r11)
                if (r10 == 0) goto L_0x0161
                java.lang.String r3 = r3.getName()
                r10.createDirectory(r3)
            L_0x0161:
                r8 = 0
                r16 = 4
                goto L_0x0279
            L_0x0166:
                W1.h r10 = new W1.h
                r10.<init>()
                java.lang.String r11 = r3.getName()
                java.lang.String r12 = "entry.name"
                kotlin.jvm.internal.m.d(r11, r12)
                java.lang.String r10 = r10.i(r11)
                java.lang.Object r11 = r7.f20968a
                androidx.documentfile.provider.DocumentFile r11 = (androidx.documentfile.provider.DocumentFile) r11
                if (r11 == 0) goto L_0x0187
                java.lang.String r3 = r3.getName()
                androidx.documentfile.provider.DocumentFile r3 = r11.createFile(r10, r3)
                goto L_0x0188
            L_0x0187:
                r3 = r9
            L_0x0188:
                if (r3 == 0) goto L_0x0161
                android.content.Context r10 = r0.f8607m     // Catch:{ FileNotFoundException -> 0x019b }
                android.content.ContentResolver r10 = r10.getContentResolver()     // Catch:{ FileNotFoundException -> 0x019b }
                if (r10 == 0) goto L_0x01c5
                android.net.Uri r3 = r3.getUri()     // Catch:{ FileNotFoundException -> 0x019b }
                java.io.OutputStream r3 = r10.openOutputStream(r3)     // Catch:{ FileNotFoundException -> 0x019b }
                goto L_0x01c6
            L_0x019b:
                o3.E0 r3 = o3.Y.c()
                W1.H$f$b r10 = new W1.H$f$b
                S1.e r11 = r0.f8608n
                r10.<init>(r11, r9)
                r0.f8595a = r5
                r0.f8596b = r7
                r0.f8597c = r4
                r0.f8598d = r2
                r0.f8599e = r9
                r0.f8600f = r9
                r0.f8601g = r9
                r0.f8604j = r6
                java.lang.Object r3 = o3.C0977g.g(r3, r10, r0)
                if (r3 != r1) goto L_0x01bf
                goto L_0x02ab
            L_0x01bf:
                r3 = r4
                r4 = r7
                r7 = r5
            L_0x01c2:
                r5 = r7
                r7 = r4
                r4 = r3
            L_0x01c5:
                r3 = r9
            L_0x01c6:
                if (r3 != 0) goto L_0x01f7
                o3.E0 r3 = o3.Y.c()
                W1.H$f$c r10 = new W1.H$f$c
                S1.e r11 = r0.f8608n
                r10.<init>(r11, r9)
                r0.f8595a = r5
                r0.f8596b = r7
                r0.f8597c = r4
                r0.f8598d = r2
                r0.f8599e = r9
                r0.f8600f = r9
                r0.f8601g = r9
                r11 = 3
                r0.f8604j = r11
                java.lang.Object r3 = o3.C0977g.g(r3, r10, r0)
                if (r3 != r1) goto L_0x01ec
                goto L_0x02ab
            L_0x01ec:
                r3 = r4
                r4 = r7
                r7 = r5
            L_0x01ef:
                r5 = r7
                r8 = 0
                r16 = 4
                r7 = r4
            L_0x01f4:
                r4 = r3
                goto L_0x0279
            L_0x01f7:
                r11 = 3
                r10 = 1024(0x400, float:1.435E-42)
                byte[] r10 = new byte[r10]
                kotlin.jvm.internal.A r12 = new kotlin.jvm.internal.A
                r12.<init>()
                r13 = 0
                r15 = r5
                r5 = r3
                r3 = r4
                r4 = r15
                r14 = r13
                r13 = r10
                r10 = r2
                r2 = 0
            L_0x020b:
                int r6 = r4.read(r13)
                r12.f20966a = r6
                if (r6 <= 0) goto L_0x026f
                r19 = r12
                long r11 = r10.f20967a
                long r8 = (long) r6
                long r11 = r11 + r8
                r10.f20967a = r11
                long r8 = java.lang.System.currentTimeMillis()
                r6 = 1000(0x3e8, float:1.401E-42)
                long r11 = (long) r6
                long r11 = r11 + r14
                int r6 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
                if (r6 <= 0) goto L_0x025f
                long r8 = java.lang.System.currentTimeMillis()
                o3.E0 r6 = o3.Y.c()
                W1.H$f$d r11 = new W1.H$f$d
                S1.e r12 = r0.f8608n
                r14 = 0
                r11.<init>(r12, r10, r14)
                r0.f8595a = r4
                r0.f8596b = r7
                r0.f8597c = r3
                r0.f8598d = r10
                r0.f8599e = r5
                r0.f8600f = r13
                r12 = r19
                r0.f8601g = r12
                r0.f8602h = r2
                r0.f8603i = r8
                r14 = 4
                r0.f8604j = r14
                java.lang.Object r6 = o3.C0977g.g(r6, r11, r0)
                if (r6 != r1) goto L_0x0255
                goto L_0x02ab
            L_0x0255:
                r15 = r10
                r10 = r8
            L_0x0257:
                r23 = r10
                r10 = r15
                r14 = r23
            L_0x025c:
                r16 = 4
                goto L_0x0262
            L_0x025f:
                r12 = r19
                goto L_0x025c
            L_0x0262:
                int r6 = r12.f20966a
                r8 = 0
                r5.write(r13, r8, r6)
                int r6 = r12.f20966a
                int r2 = r2 + r6
                r8 = 1
                r9 = 0
                r11 = 3
                goto L_0x020b
            L_0x026f:
                r8 = 0
                r16 = 4
                r5.close()
                r5 = r4
                r2 = r10
                goto L_0x01f4
            L_0x0279:
                r5.closeEntry()
                java.util.zip.ZipEntry r3 = r5.getNextEntry()
                r6 = 2
                r8 = 1
                r9 = 0
                goto L_0x0143
            L_0x0285:
                r5.close()
                o3.E0 r2 = o3.Y.c()
                W1.H$f$e r3 = new W1.H$f$e
                S1.e r5 = r0.f8608n
                r14 = 0
                r3.<init>(r5, r4, r14)
                r0.f8595a = r14
                r0.f8596b = r14
                r0.f8597c = r14
                r0.f8598d = r14
                r0.f8599e = r14
                r0.f8600f = r14
                r0.f8601g = r14
                r4 = 5
                r0.f8604j = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x02ac
            L_0x02ab:
                return r1
            L_0x02ac:
                R2.s r1 = R2.s.f8222a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.H.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((f) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f8621a;

        /* renamed from: b  reason: collision with root package name */
        Object f8622b;

        /* renamed from: c  reason: collision with root package name */
        Object f8623c;

        /* renamed from: d  reason: collision with root package name */
        Object f8624d;

        /* renamed from: e  reason: collision with root package name */
        Object f8625e;

        /* renamed from: f  reason: collision with root package name */
        Object f8626f;

        /* renamed from: g  reason: collision with root package name */
        long f8627g;

        /* renamed from: h  reason: collision with root package name */
        int f8628h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ String f8629i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ Context f8630j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ DocumentFile f8631k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ H f8632l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ S1.e f8633m;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8634a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.e f8635b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(S1.e eVar, V2.d dVar) {
                super(2, dVar);
                this.f8635b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f8635b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8634a == 0) {
                    n.b(obj);
                    this.f8635b.c();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8636a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.e f8637b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ B f8638c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(S1.e eVar, B b5, V2.d dVar) {
                super(2, dVar);
                this.f8637b = eVar;
                this.f8638c = b5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f8637b, this.f8638c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8636a == 0) {
                    n.b(obj);
                    this.f8637b.d(this.f8638c.f20967a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8639a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.e f8640b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ A f8641c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(S1.e eVar, A a5, V2.d dVar) {
                super(2, dVar);
                this.f8640b = eVar;
                this.f8641c = a5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new c(this.f8640b, this.f8641c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8639a == 0) {
                    n.b(obj);
                    this.f8640b.b(this.f8641c.f20966a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(String str, Context context, DocumentFile documentFile, H h4, S1.e eVar, V2.d dVar) {
            super(2, dVar);
            this.f8629i = str;
            this.f8630j = context;
            this.f8631k = documentFile;
            this.f8632l = h4;
            this.f8633m = eVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new g(this.f8629i, this.f8630j, this.f8631k, this.f8632l, this.f8633m, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x008e, code lost:
            if (o3.C0977g.g(r9, r10, r0) == r1) goto L_0x0171;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0124, code lost:
            if (o3.C0977g.g(r3, r4, r0) == r1) goto L_0x0171;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x016f, code lost:
            if (o3.C0977g.g(r2, r3, r0) != r1) goto L_0x0172;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0171, code lost:
            return r1;
         */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x009e  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00ed  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00ff  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0139  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x014d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                r0 = r18
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f8628h
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L_0x0050
                if (r2 == r5) goto L_0x0040
                if (r2 == r4) goto L_0x0021
                if (r2 != r3) goto L_0x0019
                R2.n.b(r19)
                goto L_0x0172
            L_0x0019:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0021:
                long r7 = r0.f8627g
                java.lang.Object r2 = r0.f8626f
                kotlin.jvm.internal.A r2 = (kotlin.jvm.internal.A) r2
                java.lang.Object r9 = r0.f8625e
                java.io.FileOutputStream r9 = (java.io.FileOutputStream) r9
                java.lang.Object r10 = r0.f8624d
                kotlin.jvm.internal.B r10 = (kotlin.jvm.internal.B) r10
                java.lang.Object r11 = r0.f8623c
                kotlin.jvm.internal.A r11 = (kotlin.jvm.internal.A) r11
                java.lang.Object r12 = r0.f8622b
                java.util.zip.ZipInputStream r12 = (java.util.zip.ZipInputStream) r12
                java.lang.Object r13 = r0.f8621a
                java.io.File r13 = (java.io.File) r13
                R2.n.b(r19)
                goto L_0x0127
            L_0x0040:
                java.lang.Object r2 = r0.f8623c
                java.util.zip.ZipEntry r2 = (java.util.zip.ZipEntry) r2
                java.lang.Object r7 = r0.f8622b
                java.util.zip.ZipInputStream r7 = (java.util.zip.ZipInputStream) r7
                java.lang.Object r8 = r0.f8621a
                java.io.File r8 = (java.io.File) r8
                R2.n.b(r19)
                goto L_0x0092
            L_0x0050:
                R2.n.b(r19)
                java.io.File r8 = new java.io.File
                java.lang.String r2 = r0.f8629i
                r8.<init>(r2)
                android.content.Context r2 = r0.f8630j
                android.content.ContentResolver r2 = r2.getContentResolver()
                if (r2 == 0) goto L_0x006d
                androidx.documentfile.provider.DocumentFile r7 = r0.f8631k
                android.net.Uri r7 = r7.getUri()
                java.io.InputStream r2 = r2.openInputStream(r7)
                goto L_0x006e
            L_0x006d:
                r2 = r6
            L_0x006e:
                java.util.zip.ZipInputStream r7 = new java.util.zip.ZipInputStream
                r7.<init>(r2)
                java.util.zip.ZipEntry r2 = r7.getNextEntry()
                o3.E0 r9 = o3.Y.c()
                W1.H$g$a r10 = new W1.H$g$a
                S1.e r11 = r0.f8633m
                r10.<init>(r11, r6)
                r0.f8621a = r8
                r0.f8622b = r7
                r0.f8623c = r2
                r0.f8628h = r5
                java.lang.Object r9 = o3.C0977g.g(r9, r10, r0)
                if (r9 != r1) goto L_0x0092
                goto L_0x0171
            L_0x0092:
                kotlin.jvm.internal.A r9 = new kotlin.jvm.internal.A
                r9.<init>()
                kotlin.jvm.internal.B r10 = new kotlin.jvm.internal.B
                r10.<init>()
            L_0x009c:
                if (r2 == 0) goto L_0x014d
                int r11 = r9.f20966a
                int r11 = r11 + r5
                r9.f20966a = r11
                java.io.File r11 = new java.io.File
                java.lang.String r12 = r2.getName()
                r11.<init>(r8, r12)
                boolean r2 = r2.isDirectory()
                if (r2 == 0) goto L_0x00b8
                r11.mkdirs()
                r5 = 2
                goto L_0x0140
            L_0x00b8:
                java.io.File r2 = r11.getParentFile()
                if (r2 == 0) goto L_0x00c7
                boolean r12 = r2.exists()
                if (r12 != 0) goto L_0x00c7
                r2.mkdirs()
            L_0x00c7:
                java.io.FileOutputStream r2 = new java.io.FileOutputStream
                r2.<init>(r11)
                kotlin.jvm.internal.A r11 = new kotlin.jvm.internal.A
                r11.<init>()
                r12 = 0
                r16 = r9
                r9 = r2
                r2 = r11
                r11 = r16
                r16 = r12
                r12 = r7
                r13 = r8
                r7 = r16
            L_0x00df:
                W1.H r14 = r0.f8632l
                byte[] r14 = r14.f8516a
                int r14 = r12.read(r14)
                r2.f20966a = r14
                if (r14 <= 0) goto L_0x0139
                long r3 = r10.f20967a
                long r5 = (long) r14
                long r3 = r3 + r5
                r10.f20967a = r3
                long r3 = java.lang.System.currentTimeMillis()
                r5 = 1000(0x3e8, float:1.401E-42)
                long r5 = (long) r5
                long r5 = r5 + r7
                int r14 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r14 <= 0) goto L_0x0127
                long r7 = java.lang.System.currentTimeMillis()
                o3.E0 r3 = o3.Y.c()
                W1.H$g$b r4 = new W1.H$g$b
                S1.e r5 = r0.f8633m
                r6 = 0
                r4.<init>(r5, r10, r6)
                r0.f8621a = r13
                r0.f8622b = r12
                r0.f8623c = r11
                r0.f8624d = r10
                r0.f8625e = r9
                r0.f8626f = r2
                r0.f8627g = r7
                r5 = 2
                r0.f8628h = r5
                java.lang.Object r3 = o3.C0977g.g(r3, r4, r0)
                if (r3 != r1) goto L_0x0128
                goto L_0x0171
            L_0x0127:
                r5 = 2
            L_0x0128:
                W1.H r3 = r0.f8632l
                byte[] r3 = r3.f8516a
                int r4 = r2.f20966a
                r6 = 0
                r9.write(r3, r6, r4)
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                goto L_0x00df
            L_0x0139:
                r5 = 2
                r9.close()
                r9 = r11
                r7 = r12
                r8 = r13
            L_0x0140:
                r7.closeEntry()
                java.util.zip.ZipEntry r2 = r7.getNextEntry()
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                goto L_0x009c
            L_0x014d:
                r7.close()
                o3.E0 r2 = o3.Y.c()
                W1.H$g$c r3 = new W1.H$g$c
                S1.e r4 = r0.f8633m
                r6 = 0
                r3.<init>(r4, r9, r6)
                r0.f8621a = r6
                r0.f8622b = r6
                r0.f8623c = r6
                r0.f8624d = r6
                r0.f8625e = r6
                r0.f8626f = r6
                r15 = 3
                r0.f8628h = r15
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0172
            L_0x0171:
                return r1
            L_0x0172:
                R2.s r1 = R2.s.f8222a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.H.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((g) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        Object f8642a;

        /* renamed from: b  reason: collision with root package name */
        Object f8643b;

        /* renamed from: c  reason: collision with root package name */
        Object f8644c;

        /* renamed from: d  reason: collision with root package name */
        Object f8645d;

        /* renamed from: e  reason: collision with root package name */
        Object f8646e;

        /* renamed from: f  reason: collision with root package name */
        Object f8647f;

        /* renamed from: g  reason: collision with root package name */
        Object f8648g;

        /* renamed from: h  reason: collision with root package name */
        long f8649h;

        /* renamed from: i  reason: collision with root package name */
        int f8650i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ Context f8651j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ DocumentFile f8652k;

        /* renamed from: l  reason: collision with root package name */
        final /* synthetic */ Uri f8653l;

        /* renamed from: m  reason: collision with root package name */
        final /* synthetic */ S1.e f8654m;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8655a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.e f8656b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(S1.e eVar, V2.d dVar) {
                super(2, dVar);
                this.f8656b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f8656b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8655a == 0) {
                    n.b(obj);
                    this.f8656b.c();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8657a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.e f8658b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(S1.e eVar, V2.d dVar) {
                super(2, dVar);
                this.f8658b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f8658b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8657a == 0) {
                    n.b(obj);
                    this.f8658b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class c extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8659a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.e f8660b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(S1.e eVar, V2.d dVar) {
                super(2, dVar);
                this.f8660b = eVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new c(this.f8660b, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8659a == 0) {
                    n.b(obj);
                    this.f8660b.a();
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class d extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8661a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.e f8662b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ B f8663c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(S1.e eVar, B b5, V2.d dVar) {
                super(2, dVar);
                this.f8662b = eVar;
                this.f8663c = b5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new d(this.f8662b, this.f8663c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8661a == 0) {
                    n.b(obj);
                    this.f8662b.d(this.f8663c.f20967a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class e extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8664a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ S1.e f8665b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ A f8666c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(S1.e eVar, A a5, V2.d dVar) {
                super(2, dVar);
                this.f8665b = eVar;
                this.f8666c = a5;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new e(this.f8665b, this.f8666c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8664a == 0) {
                    n.b(obj);
                    this.f8665b.b(this.f8666c.f20966a);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(Context context, DocumentFile documentFile, Uri uri, S1.e eVar, V2.d dVar) {
            super(2, dVar);
            this.f8651j = context;
            this.f8652k = documentFile;
            this.f8653l = uri;
            this.f8654m = eVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new h(this.f8651j, this.f8652k, this.f8653l, this.f8654m, dVar);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: androidx.documentfile.provider.DocumentFile} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: androidx.documentfile.provider.DocumentFile} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: androidx.documentfile.provider.DocumentFile} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: androidx.documentfile.provider.DocumentFile} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v6, resolved type: androidx.documentfile.provider.DocumentFile} */
        /* JADX WARNING: type inference failed for: r10v0 */
        /* JADX WARNING: type inference failed for: r10v1 */
        /* JADX WARNING: type inference failed for: r11v11, types: [V2.d, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r10v7, types: [boolean, int] */
        /* JADX WARNING: type inference failed for: r11v21 */
        /* JADX WARNING: type inference failed for: r11v37 */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x0340, code lost:
            if (o3.C0977g.g(r2, r3, r0) == r1) goto L_0x0342;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x009b, code lost:
            if (o3.C0977g.g(r2, r5, r0) == r1) goto L_0x0342;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x0294, code lost:
            if (o3.C0977g.g(r3, r8, r0) != r1) goto L_0x0298;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:101:0x02b8  */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x02ca  */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x02f4  */
        /* JADX WARNING: Removed duplicated region for block: B:107:0x02f8  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x0303  */
        /* JADX WARNING: Removed duplicated region for block: B:111:0x031c  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0158  */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r26) {
            /*
                r25 = this;
                r0 = r25
                java.lang.Object r1 = W2.b.c()
                int r2 = r0.f8650i
                java.lang.String r3 = "listFiles()"
                java.lang.String r4 = "/"
                r5 = 5
                r6 = 4
                r7 = 3
                r8 = 2
                r9 = 0
                r10 = 1
                r11 = 0
                if (r2 == 0) goto L_0x0087
                if (r2 == r10) goto L_0x0083
                if (r2 == r8) goto L_0x006b
                if (r2 == r7) goto L_0x0052
                if (r2 == r6) goto L_0x002c
                if (r2 != r5) goto L_0x0024
                R2.n.b(r26)
                goto L_0x0343
            L_0x0024:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x002c:
                long r12 = r0.f8649h
                java.lang.Object r2 = r0.f8648g
                kotlin.jvm.internal.A r2 = (kotlin.jvm.internal.A) r2
                java.lang.Object r14 = r0.f8647f
                byte[] r14 = (byte[]) r14
                java.lang.Object r15 = r0.f8646e
                java.io.OutputStream r15 = (java.io.OutputStream) r15
                java.lang.Object r5 = r0.f8645d
                kotlin.jvm.internal.B r5 = (kotlin.jvm.internal.B) r5
                java.lang.Object r6 = r0.f8644c
                kotlin.jvm.internal.A r6 = (kotlin.jvm.internal.A) r6
                java.lang.Object r7 = r0.f8643b
                kotlin.jvm.internal.C r7 = (kotlin.jvm.internal.C) r7
                java.lang.Object r8 = r0.f8642a
                java.util.zip.ZipInputStream r8 = (java.util.zip.ZipInputStream) r8
                R2.n.b(r26)
                r20 = r3
                r11 = 4
                goto L_0x02f5
            L_0x0052:
                java.lang.Object r2 = r0.f8645d
                kotlin.jvm.internal.B r2 = (kotlin.jvm.internal.B) r2
                java.lang.Object r5 = r0.f8644c
                kotlin.jvm.internal.A r5 = (kotlin.jvm.internal.A) r5
                java.lang.Object r6 = r0.f8643b
                kotlin.jvm.internal.C r6 = (kotlin.jvm.internal.C) r6
                java.lang.Object r7 = r0.f8642a
                java.util.zip.ZipInputStream r7 = (java.util.zip.ZipInputStream) r7
                R2.n.b(r26)
                r20 = r3
                r9 = 2
                r11 = 3
                goto L_0x0298
            L_0x006b:
                java.lang.Object r2 = r0.f8645d
                kotlin.jvm.internal.B r2 = (kotlin.jvm.internal.B) r2
                java.lang.Object r5 = r0.f8644c
                kotlin.jvm.internal.A r5 = (kotlin.jvm.internal.A) r5
                java.lang.Object r6 = r0.f8643b
                kotlin.jvm.internal.C r6 = (kotlin.jvm.internal.C) r6
                java.lang.Object r7 = r0.f8642a
                java.util.zip.ZipInputStream r7 = (java.util.zip.ZipInputStream) r7
                R2.n.b(r26)
                r20 = r3
                r9 = 2
                goto L_0x0271
            L_0x0083:
                R2.n.b(r26)
                goto L_0x009f
            L_0x0087:
                R2.n.b(r26)
                o3.E0 r2 = o3.Y.c()
                W1.H$h$a r5 = new W1.H$h$a
                S1.e r6 = r0.f8654m
                r5.<init>(r6, r11)
                r0.f8650i = r10
                java.lang.Object r2 = o3.C0977g.g(r2, r5, r0)
                if (r2 != r1) goto L_0x009f
                goto L_0x0342
            L_0x009f:
                android.content.Context r2 = r0.f8651j
                android.content.ContentResolver r2 = r2.getContentResolver()
                if (r2 == 0) goto L_0x00b2
                androidx.documentfile.provider.DocumentFile r5 = r0.f8652k
                android.net.Uri r5 = r5.getUri()
                java.io.InputStream r2 = r2.openInputStream(r5)
                goto L_0x00b3
            L_0x00b2:
                r2 = r11
            L_0x00b3:
                java.util.zip.ZipInputStream r5 = new java.util.zip.ZipInputStream
                r5.<init>(r2)
                java.util.zip.ZipEntry r2 = r5.getNextEntry()
                android.net.Uri r6 = r0.f8653l
                java.lang.String r16 = r6.getLastPathSegment()
                kotlin.jvm.internal.m.b(r16)
                r20 = 6
                r21 = 0
                java.lang.String r17 = ":"
                r18 = 0
                r19 = 0
                int r6 = m3.m.R(r16, r17, r18, r19, r20, r21)
                r7 = r16
                int r6 = r6 + r10
                java.lang.String r6 = r7.substring(r6)
                java.lang.String r7 = "this as java.lang.String).substring(startIndex)"
                kotlin.jvm.internal.m.d(r6, r7)
                kotlin.jvm.internal.C r7 = new kotlin.jvm.internal.C
                r7.<init>()
                android.content.Context r8 = r0.f8651j
                android.net.Uri r12 = r0.f8653l
                androidx.documentfile.provider.DocumentFile r8 = androidx.documentfile.provider.DocumentFile.fromTreeUri(r8, r12)
                r7.f20968a = r8
                java.lang.String[] r17 = new java.lang.String[]{r4}
                r16 = r6
                java.util.List r6 = m3.m.j0(r16, r17, r18, r19, r20, r21)
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.Iterator r6 = r6.iterator()
            L_0x00fe:
                boolean r8 = r6.hasNext()
                if (r8 == 0) goto L_0x0146
                java.lang.Object r8 = r6.next()
                java.lang.String r8 = (java.lang.String) r8
                java.lang.Object r12 = r7.f20968a
                androidx.documentfile.provider.DocumentFile r12 = (androidx.documentfile.provider.DocumentFile) r12
                if (r12 == 0) goto L_0x0130
                androidx.documentfile.provider.DocumentFile[] r12 = r12.listFiles()
                if (r12 == 0) goto L_0x0130
                kotlin.jvm.internal.m.d(r12, r3)
                int r13 = r12.length
                r15 = r11
                r14 = 0
            L_0x011c:
                if (r14 >= r13) goto L_0x0131
                r16 = r12[r14]
                java.lang.String r11 = r16.getName()
                boolean r11 = m3.m.p(r11, r8, r10)
                if (r11 == 0) goto L_0x012c
                r15 = r16
            L_0x012c:
                int r14 = r14 + 1
                r11 = 0
                goto L_0x011c
            L_0x0130:
                r15 = 0
            L_0x0131:
                if (r15 == 0) goto L_0x0136
                r7.f20968a = r15
                goto L_0x0144
            L_0x0136:
                java.lang.Object r11 = r7.f20968a
                androidx.documentfile.provider.DocumentFile r11 = (androidx.documentfile.provider.DocumentFile) r11
                if (r11 == 0) goto L_0x0141
                androidx.documentfile.provider.DocumentFile r8 = r11.createDirectory(r8)
                goto L_0x0142
            L_0x0141:
                r8 = 0
            L_0x0142:
                r7.f20968a = r8
            L_0x0144:
                r11 = 0
                goto L_0x00fe
            L_0x0146:
                kotlin.jvm.internal.A r6 = new kotlin.jvm.internal.A
                r6.<init>()
                kotlin.jvm.internal.B r8 = new kotlin.jvm.internal.B
                r8.<init>()
                r24 = r7
                r7 = r5
                r5 = r6
                r6 = r24
            L_0x0156:
                if (r2 == 0) goto L_0x031c
                int r11 = r5.f20966a
                int r11 = r11 + r10
                r5.f20966a = r11
                boolean r11 = r2.isDirectory()
                if (r11 == 0) goto L_0x0174
                java.lang.Object r11 = r6.f20968a
                androidx.documentfile.provider.DocumentFile r11 = (androidx.documentfile.provider.DocumentFile) r11
                if (r11 == 0) goto L_0x0170
                java.lang.String r2 = r2.getName()
                r11.createDirectory(r2)
            L_0x0170:
                r20 = r3
                goto L_0x0299
            L_0x0174:
                java.lang.String r11 = r2.getName()
                java.lang.String r2 = r2.getName()
                java.lang.String r12 = "entry.name"
                kotlin.jvm.internal.m.d(r2, r12)
                java.lang.String[] r19 = new java.lang.String[]{r4}
                r22 = 6
                r23 = 0
                r20 = 0
                r21 = 0
                r18 = r2
                java.util.List r2 = m3.m.j0(r18, r19, r20, r21, r22, r23)
                kotlin.jvm.internal.C r12 = new kotlin.jvm.internal.C
                r12.<init>()
                java.lang.Object r13 = r6.f20968a
                r12.f20968a = r13
                int r13 = r2.size()
                if (r13 <= r10) goto L_0x0214
                int r11 = r2.size()
                int r11 = r11 - r10
                java.util.List r11 = r2.subList(r9, r11)
                java.lang.Iterable r11 = (java.lang.Iterable) r11
                java.util.Iterator r11 = r11.iterator()
            L_0x01b1:
                boolean r13 = r11.hasNext()
                if (r13 == 0) goto L_0x0205
                java.lang.Object r13 = r11.next()
                java.lang.String r13 = (java.lang.String) r13
                java.lang.Object r14 = r6.f20968a
                androidx.documentfile.provider.DocumentFile r14 = (androidx.documentfile.provider.DocumentFile) r14
                if (r14 == 0) goto L_0x01eb
                androidx.documentfile.provider.DocumentFile[] r14 = r14.listFiles()
                if (r14 == 0) goto L_0x01eb
                kotlin.jvm.internal.m.d(r14, r3)
                int r15 = r14.length
                r16 = 0
            L_0x01cf:
                if (r9 >= r15) goto L_0x01e6
                r19 = r14[r9]
                r20 = r3
                java.lang.String r3 = r19.getName()
                boolean r3 = m3.m.p(r3, r13, r10)
                if (r3 == 0) goto L_0x01e1
                r16 = r19
            L_0x01e1:
                int r9 = r9 + 1
                r3 = r20
                goto L_0x01cf
            L_0x01e6:
                r20 = r3
                r3 = r16
                goto L_0x01ee
            L_0x01eb:
                r20 = r3
                r3 = 0
            L_0x01ee:
                if (r3 == 0) goto L_0x01f3
                r12.f20968a = r3
                goto L_0x0201
            L_0x01f3:
                java.lang.Object r3 = r12.f20968a
                androidx.documentfile.provider.DocumentFile r3 = (androidx.documentfile.provider.DocumentFile) r3
                if (r3 == 0) goto L_0x01fe
                androidx.documentfile.provider.DocumentFile r3 = r3.createDirectory(r13)
                goto L_0x01ff
            L_0x01fe:
                r3 = 0
            L_0x01ff:
                r12.f20968a = r3
            L_0x0201:
                r3 = r20
                r9 = 0
                goto L_0x01b1
            L_0x0205:
                r20 = r3
                int r3 = r2.size()
                int r3 = r3 - r10
                java.lang.Object r2 = r2.get(r3)
                r11 = r2
                java.lang.String r11 = (java.lang.String) r11
                goto L_0x0216
            L_0x0214:
                r20 = r3
            L_0x0216:
                W1.h r2 = new W1.h
                r2.<init>()
                java.lang.String r3 = "fileName"
                kotlin.jvm.internal.m.d(r11, r3)
                java.lang.String r2 = r2.i(r11)
                java.lang.Object r3 = r12.f20968a
                androidx.documentfile.provider.DocumentFile r3 = (androidx.documentfile.provider.DocumentFile) r3
                if (r3 == 0) goto L_0x022f
                androidx.documentfile.provider.DocumentFile r2 = r3.createFile(r2, r11)
                goto L_0x0230
            L_0x022f:
                r2 = 0
            L_0x0230:
                if (r2 == 0) goto L_0x0299
                android.content.Context r3 = r0.f8651j     // Catch:{ FileNotFoundException -> 0x0243 }
                android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0243 }
                if (r3 == 0) goto L_0x0245
                android.net.Uri r2 = r2.getUri()     // Catch:{ FileNotFoundException -> 0x0243 }
                java.io.OutputStream r2 = r3.openOutputStream(r2)     // Catch:{ FileNotFoundException -> 0x0243 }
                goto L_0x0246
            L_0x0243:
                goto L_0x024b
            L_0x0245:
                r2 = 0
            L_0x0246:
                r3 = r2
                r2 = r8
                r9 = 2
                r11 = 0
                goto L_0x0272
            L_0x024b:
                o3.E0 r2 = o3.Y.c()
                W1.H$h$b r3 = new W1.H$h$b
                S1.e r9 = r0.f8654m
                r11 = 0
                r3.<init>(r9, r11)
                r0.f8642a = r7
                r0.f8643b = r6
                r0.f8644c = r5
                r0.f8645d = r8
                r0.f8646e = r11
                r0.f8647f = r11
                r0.f8648g = r11
                r9 = 2
                r0.f8650i = r9
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0270
                goto L_0x0342
            L_0x0270:
                r2 = r8
            L_0x0271:
                r3 = r11
            L_0x0272:
                if (r3 != 0) goto L_0x029d
                o3.E0 r3 = o3.Y.c()
                W1.H$h$c r8 = new W1.H$h$c
                S1.e r12 = r0.f8654m
                r8.<init>(r12, r11)
                r0.f8642a = r7
                r0.f8643b = r6
                r0.f8644c = r5
                r0.f8645d = r2
                r0.f8646e = r11
                r0.f8647f = r11
                r0.f8648g = r11
                r11 = 3
                r0.f8650i = r11
                java.lang.Object r3 = o3.C0977g.g(r3, r8, r0)
                if (r3 != r1) goto L_0x0298
                goto L_0x0342
            L_0x0298:
                r8 = r2
            L_0x0299:
                r10 = 0
                r11 = 4
                goto L_0x030f
            L_0x029d:
                r11 = 3
                r8 = 1024(0x400, float:1.435E-42)
                byte[] r8 = new byte[r8]
                kotlin.jvm.internal.A r12 = new kotlin.jvm.internal.A
                r12.<init>()
                r13 = 0
                r15 = r3
                r3 = r8
                r8 = r7
                r7 = r6
                r6 = r5
                r5 = r2
                r2 = r12
            L_0x02b0:
                int r12 = r8.read(r3)
                r2.f20966a = r12
                if (r12 <= 0) goto L_0x0303
                long r9 = r5.f20967a
                long r11 = (long) r12
                long r9 = r9 + r11
                r5.f20967a = r9
                long r9 = java.lang.System.currentTimeMillis()
                r11 = 1000(0x3e8, float:1.401E-42)
                long r11 = (long) r11
                long r11 = r11 + r13
                int r19 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r19 <= 0) goto L_0x02f8
                long r12 = java.lang.System.currentTimeMillis()
                o3.E0 r9 = o3.Y.c()
                W1.H$h$d r10 = new W1.H$h$d
                S1.e r11 = r0.f8654m
                r14 = 0
                r10.<init>(r11, r5, r14)
                r0.f8642a = r8
                r0.f8643b = r7
                r0.f8644c = r6
                r0.f8645d = r5
                r0.f8646e = r15
                r0.f8647f = r3
                r0.f8648g = r2
                r0.f8649h = r12
                r11 = 4
                r0.f8650i = r11
                java.lang.Object r9 = o3.C0977g.g(r9, r10, r0)
                if (r9 != r1) goto L_0x02f4
                goto L_0x0342
            L_0x02f4:
                r14 = r3
            L_0x02f5:
                r3 = r14
                r13 = r12
                goto L_0x02f9
            L_0x02f8:
                r11 = 4
            L_0x02f9:
                int r9 = r2.f20966a
                r10 = 0
                r15.write(r3, r10, r9)
                r9 = 2
                r10 = 1
                r11 = 3
                goto L_0x02b0
            L_0x0303:
                r10 = 0
                r11 = 4
                r15.close()
                r24 = r8
                r8 = r5
                r5 = r6
                r6 = r7
                r7 = r24
            L_0x030f:
                r7.closeEntry()
                java.util.zip.ZipEntry r2 = r7.getNextEntry()
                r3 = r20
                r9 = 0
                r10 = 1
                goto L_0x0156
            L_0x031c:
                r7.close()
                o3.E0 r2 = o3.Y.c()
                W1.H$h$e r3 = new W1.H$h$e
                S1.e r4 = r0.f8654m
                r14 = 0
                r3.<init>(r4, r5, r14)
                r0.f8642a = r14
                r0.f8643b = r14
                r0.f8644c = r14
                r0.f8645d = r14
                r0.f8646e = r14
                r0.f8647f = r14
                r0.f8648g = r14
                r4 = 5
                r0.f8650i = r4
                java.lang.Object r2 = o3.C0977g.g(r2, r3, r0)
                if (r2 != r1) goto L_0x0343
            L_0x0342:
                return r1
            L_0x0343:
                R2.s r1 = R2.s.f8222a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: W1.H.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((h) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public final Object f(DocumentFile documentFile, ZipOutputStream zipOutputStream, Context context, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new a(documentFile, zipOutputStream, context, this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final Object g(File file, String str, ZipOutputStream zipOutputStream, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(file, str, zipOutputStream, this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public final Object h(ArrayList arrayList, DocumentFile documentFile, S1.c cVar, Context context, V2.d dVar) {
        DocumentFile documentFile2 = documentFile;
        Context context2 = context;
        Object g4 = C0977g.g(Y.b(), new d(context2, documentFile2, arrayList, this, cVar, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public final Object i(ArrayList arrayList, File file, S1.c cVar, V2.d dVar) {
        File file2 = file;
        Object g4 = C0977g.g(Y.b(), new c(file2, arrayList, this, cVar, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public final Object j(DocumentFile documentFile, Uri uri, S1.e eVar, Context context, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new h(context, documentFile, uri, eVar, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public final Object k(DocumentFile documentFile, String str, S1.e eVar, Context context, V2.d dVar) {
        String str2 = str;
        Context context2 = context;
        Object g4 = C0977g.g(Y.b(), new g(str2, context2, documentFile, this, eVar, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public final Object l(File file, Uri uri, S1.e eVar, Context context, V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new f(file, uri, context, eVar, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    public final Object m(File file, String str, S1.e eVar, V2.d dVar) {
        String str2 = str;
        Object g4 = C0977g.g(Y.b(), new e(str2, file, this, eVar, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }
}
