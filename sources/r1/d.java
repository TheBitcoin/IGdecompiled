package R1;

import R2.n;
import R2.s;
import S1.i;
import V2.g;
import W1.C1612h;
import W1.D;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.documentfile.provider.DocumentFile;
import d3.p;
import java.io.File;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;

public final class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final DocumentFile f8193a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final File f8194b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f8195c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final i f8196d;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8197a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f8198b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d dVar, V2.d dVar2) {
            super(2, dVar2);
            this.f8198b = dVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new a(this.f8198b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f8197a;
            if (i4 == 0) {
                n.b(obj);
                d dVar = this.f8198b;
                this.f8197a = 1;
                if (dVar.f(this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f8199a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f8200b;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8201a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ d f8202b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f8203c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, ArrayList arrayList, V2.d dVar2) {
                super(2, dVar2);
                this.f8202b = dVar;
                this.f8203c = arrayList;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new a(this.f8202b, this.f8203c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8201a == 0) {
                    n.b(obj);
                    this.f8202b.f8196d.a(this.f8203c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* renamed from: R1.d$b$b  reason: collision with other inner class name */
        static final class C0105b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8204a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ d f8205b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f8206c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0105b(d dVar, ArrayList arrayList, V2.d dVar2) {
                super(2, dVar2);
                this.f8205b = dVar;
                this.f8206c = arrayList;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new C0105b(this.f8205b, this.f8206c, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f8204a == 0) {
                    n.b(obj);
                    this.f8205b.f8196d.b(this.f8206c);
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((C0105b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar, V2.d dVar2) {
            super(2, dVar2);
            this.f8200b = dVar;
        }

        public final V2.d create(Object obj, V2.d dVar) {
            return new b(this.f8200b, dVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c9, code lost:
            if (o3.C0977g.g(r11, r4, r10) == r0) goto L_0x00cb;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = W2.b.c()
                int r1 = r10.f8199a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x0021
                if (r1 == r3) goto L_0x000e
                if (r1 != r2) goto L_0x0019
            L_0x000e:
                R2.n.b(r11)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                goto L_0x00d3
            L_0x0013:
                r11 = move-exception
                goto L_0x00cc
            L_0x0016:
                r11 = move-exception
                goto L_0x00d0
            L_0x0019:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x0021:
                R2.n.b(r11)
                R1.d r11 = r10.f8200b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                androidx.documentfile.provider.DocumentFile r11 = r11.f8193a     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r1 = 0
                r4 = 0
                if (r11 == 0) goto L_0x007d
                R1.d r11 = r10.f8200b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                androidx.documentfile.provider.DocumentFile r11 = r11.f8193a     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                androidx.documentfile.provider.DocumentFile[] r11 = r11.listFiles()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.String r2 = "currentDirectory.listFiles()"
                kotlin.jvm.internal.m.d(r11, r2)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r2.<init>()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                int r5 = r11.length     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
            L_0x0043:
                if (r4 >= r5) goto L_0x0069
                r6 = r11[r4]     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.String r7 = r6.getName()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                if (r7 == 0) goto L_0x0066
                r2.add(r6)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                android.net.Uri r7 = r6.getUri()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.String r7 = r7.getPath()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                if (r7 == 0) goto L_0x0066
                R1.d r8 = r10.f8200b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.String r6 = r6.getName()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                kotlin.jvm.internal.m.b(r6)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r8.g(r7, r6)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
            L_0x0066:
                int r4 = r4 + 1
                goto L_0x0043
            L_0x0069:
                o3.E0 r11 = o3.Y.c()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                R1.d$b$a r4 = new R1.d$b$a     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                R1.d r5 = r10.f8200b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r4.<init>(r5, r2, r1)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r10.f8199a = r3     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.Object r11 = o3.C0977g.g(r11, r4, r10)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                if (r11 != r0) goto L_0x00d3
                goto L_0x00cb
            L_0x007d:
                R1.d r11 = r10.f8200b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.io.File r11 = r11.f8194b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                if (r11 == 0) goto L_0x00d3
                R1.d r11 = r10.f8200b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.io.File r11 = r11.f8194b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.io.File[] r11 = r11.listFiles()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r3.<init>()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                if (r11 == 0) goto L_0x00b8
                int r5 = r11.length     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
            L_0x0097:
                if (r4 >= r5) goto L_0x00b8
                r6 = r11[r4]     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r3.add(r6)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                R1.d r7 = r10.f8200b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.String r8 = r6.getPath()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.String r9 = "file.path"
                kotlin.jvm.internal.m.d(r8, r9)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.String r6 = r6.getName()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.String r9 = "file.name"
                kotlin.jvm.internal.m.d(r6, r9)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r7.g(r8, r6)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                int r4 = r4 + 1
                goto L_0x0097
            L_0x00b8:
                o3.E0 r11 = o3.Y.c()     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                R1.d$b$b r4 = new R1.d$b$b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                R1.d r5 = r10.f8200b     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r4.<init>(r5, r3, r1)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                r10.f8199a = r2     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                java.lang.Object r11 = o3.C0977g.g(r11, r4, r10)     // Catch:{ Exception -> 0x0016, Error -> 0x0013 }
                if (r11 != r0) goto L_0x00d3
            L_0x00cb:
                return r0
            L_0x00cc:
                r11.printStackTrace()
                goto L_0x00d3
            L_0x00d0:
                r11.printStackTrace()
            L_0x00d3:
                R2.s r11 = R2.s.f8222a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: R1.d.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(J j4, V2.d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public d(DocumentFile documentFile, File file, Context context, i iVar) {
        m.e(context, "context");
        m.e(iVar, "listener");
        this.f8193a = documentFile;
        this.f8194b = file;
        this.f8195c = context;
        this.f8196d = iVar;
        C1001s0 unused = C0981i.d(K.a(Y.b()), (g) null, (L) null, new a(this, (V2.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object f(V2.d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, (V2.d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: private */
    public final void g(String str, String str2) {
        Drawable h4;
        if (m3.m.o(str2, ".apk", false, 2, (Object) null)) {
            D d5 = D.f8459a;
            if (!d5.a().containsKey(str2) && (h4 = new C1612h().h(this.f8195c, str)) != null) {
                d5.a().put(str2, h4);
            }
        }
    }
}
