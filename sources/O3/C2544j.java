package O3;

import N3.C2516g;
import N3.C2519j;
import N3.Q;
import R2.s;
import S2.C1601o;
import S2.H;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import d3.p;
import java.io.IOException;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.B;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.z;

/* renamed from: O3.j  reason: case insensitive filesystem */
public abstract class C2544j {

    /* renamed from: O3.j$a */
    public static final class a implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return U2.a.a(((C2543i) obj).a(), ((C2543i) obj2).a());
        }
    }

    /* renamed from: O3.j$b */
    static final class b extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ z f23774a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f23775b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ B f23776c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2516g f23777d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ B f23778e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ B f23779f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(z zVar, long j4, B b5, C2516g gVar, B b6, B b7) {
            super(2);
            this.f23774a = zVar;
            this.f23775b = j4;
            this.f23776c = b5;
            this.f23777d = gVar;
            this.f23778e = b6;
            this.f23779f = b7;
        }

        public final void a(int i4, long j4) {
            long j5;
            if (i4 == 1) {
                z zVar = this.f23774a;
                if (!zVar.f20985a) {
                    zVar.f20985a = true;
                    if (j4 >= this.f23775b) {
                        B b5 = this.f23776c;
                        long j6 = b5.f20967a;
                        if (j6 == 4294967295L) {
                            j6 = this.f23777d.readLongLe();
                        }
                        b5.f20967a = j6;
                        B b6 = this.f23778e;
                        long j7 = 0;
                        if (b6.f20967a == 4294967295L) {
                            j5 = this.f23777d.readLongLe();
                        } else {
                            j5 = 0;
                        }
                        b6.f20967a = j5;
                        B b7 = this.f23779f;
                        if (b7.f20967a == 4294967295L) {
                            j7 = this.f23777d.readLongLe();
                        }
                        b7.f20967a = j7;
                        return;
                    }
                    throw new IOException("bad zip: zip64 extra too short");
                }
                throw new IOException("bad zip: zip64 extra repeated");
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Number) obj).intValue(), ((Number) obj2).longValue());
            return s.f8222a;
        }
    }

    /* renamed from: O3.j$c */
    static final class c extends n implements p {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2516g f23780a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C f23781b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C f23782c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C f23783d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(C2516g gVar, C c5, C c6, C c7) {
            super(2);
            this.f23780a = gVar;
            this.f23781b = c5;
            this.f23782c = c6;
            this.f23783d = c7;
        }

        public final void a(int i4, long j4) {
            boolean z4;
            boolean z5;
            if (i4 == 21589) {
                long j5 = 1;
                if (j4 >= 1) {
                    byte readByte = this.f23780a.readByte();
                    boolean z6 = false;
                    if ((readByte & 1) == 1) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if ((readByte & 2) == 2) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if ((readByte & 4) == 4) {
                        z6 = true;
                    }
                    C2516g gVar = this.f23780a;
                    if (z4) {
                        j5 = 5;
                    }
                    if (z5) {
                        j5 += 4;
                    }
                    if (z6) {
                        j5 += 4;
                    }
                    if (j4 >= j5) {
                        if (z4) {
                            this.f23781b.f20968a = Long.valueOf(((long) gVar.readIntLe()) * 1000);
                        }
                        if (z5) {
                            this.f23782c.f20968a = Long.valueOf(((long) this.f23780a.readIntLe()) * 1000);
                        }
                        if (z6) {
                            this.f23783d.f20968a = Long.valueOf(((long) this.f23780a.readIntLe()) * 1000);
                            return;
                        }
                        return;
                    }
                    throw new IOException("bad zip: extended timestamp extra too short");
                }
                throw new IOException("bad zip: extended timestamp extra too short");
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a(((Number) obj).intValue(), ((Number) obj2).longValue());
            return s.f8222a;
        }
    }

    private static final Map a(List list) {
        Q e5 = Q.a.e(Q.f23639b, "/", false, 1, (Object) null);
        Map k4 = H.k(R2.p.a(e5, new C2543i(e5, true, (String) null, 0, 0, 0, 0, (Long) null, 0, TypedValues.PositionType.TYPE_CURVE_FIT, (C2103g) null)));
        for (C2543i iVar : C1601o.W(list, new a())) {
            if (((C2543i) k4.put(iVar.a(), iVar)) == null) {
                while (true) {
                    Q i4 = iVar.a().i();
                    if (i4 == null) {
                        break;
                    }
                    C2543i iVar2 = (C2543i) k4.get(i4);
                    if (iVar2 != null) {
                        iVar2.b().add(iVar.a());
                        break;
                    }
                    C2543i iVar3 = new C2543i(i4, true, (String) null, 0, 0, 0, 0, (Long) null, 0, TypedValues.PositionType.TYPE_CURVE_FIT, (C2103g) null);
                    k4.put(i4, iVar3);
                    iVar3.b().add(iVar.a());
                    iVar = iVar3;
                }
            }
        }
        return k4;
    }

    private static final Long b(int i4, int i5) {
        if (i5 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(((i4 >> 9) & ModuleDescriptor.MODULE_VERSION) + 1980, ((i4 >> 5) & 15) - 1, i4 & 31, (i5 >> 11) & 31, (i5 >> 5) & 63, (i5 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String c(int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append("0x");
        String num = Integer.toString(i4, m3.a.a(16));
        m.d(num, "toString(this, checkRadix(radix))");
        sb.append(num);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r10.close();
        r4 = r4 - ((long) 20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0058, code lost:
        if (r4 <= 0) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005a, code lost:
        r4 = N3.L.d(r3.A(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0069, code lost:
        if (r4.readIntLe() != 117853008) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006b, code lost:
        r5 = r4.readIntLe();
        r11 = r4.readLongLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0078, code lost:
        if (r4.readIntLe() != 1) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
        if (r5 != 0) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007c, code lost:
        r5 = N3.L.d(r3.A(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r11 = r5.readIntLe();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008b, code lost:
        if (r11 != 101075792) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008d, code lost:
        r8 = j(r5, r8);
        r11 = R2.s.f8222a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        b3.C1642b.a(r5, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0097, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0098, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c3, code lost:
        throw new java.io.IOException("bad zip: expected " + c(101075792) + " but was " + c(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        b3.C1642b.a(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c9, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d1, code lost:
        throw new java.io.IOException("unsupported zip: spanned");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d2, code lost:
        r5 = R2.s.f8222a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        b3.C1642b.a(r4, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00dd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        b3.C1642b.a(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e1, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e2, code lost:
        r4 = new java.util.ArrayList();
        r5 = N3.L.d(r3.A(r8.a()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r11 = r8.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00f9, code lost:
        if (r6 >= r11) goto L_0x012a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00fb, code lost:
        r13 = e(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0109, code lost:
        if (r13.f() >= r8.a()) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0115, code lost:
        if (((java.lang.Boolean) r2.invoke(r13)).booleanValue() == false) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0117, code lost:
        r4.add(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x011b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x011c, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x011e, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0129, code lost:
        throw new java.io.IOException("bad zip: local file header offset >= central directory offset");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012a, code lost:
        r2 = R2.s.f8222a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        b3.C1642b.a(r5, (java.lang.Throwable) null);
        r4 = new N3.b0(r0, r1, a(r4), r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0138, code lost:
        b3.C1642b.a(r3, (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x013b, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x013d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        b3.C1642b.a(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0141, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
        r8 = f(r10);
        r9 = r10.readUtf8((long) r8.b());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final N3.b0 d(N3.Q r19, N3.C2520k r20, d3.l r21) {
        /*
            r0 = r19
            r1 = r20
            r2 = r21
            java.lang.String r3 = "zipPath"
            kotlin.jvm.internal.m.e(r0, r3)
            java.lang.String r3 = "fileSystem"
            kotlin.jvm.internal.m.e(r1, r3)
            java.lang.String r3 = "predicate"
            kotlin.jvm.internal.m.e(r2, r3)
            N3.i r3 = r1.i(r0)
            long r4 = r3.z()     // Catch:{ all -> 0x00d8 }
            r6 = 22
            long r6 = (long) r6     // Catch:{ all -> 0x00d8 }
            long r4 = r4 - r6
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x015c
            r8 = 65536(0x10000, double:3.2379E-319)
            long r8 = r4 - r8
            long r8 = java.lang.Math.max(r8, r6)     // Catch:{ all -> 0x00d8 }
        L_0x0030:
            N3.Z r10 = r3.A(r4)     // Catch:{ all -> 0x00d8 }
            N3.g r10 = N3.L.d(r10)     // Catch:{ all -> 0x00d8 }
            int r11 = r10.readIntLe()     // Catch:{ all -> 0x0142 }
            r12 = 101010256(0x6054b50, float:2.506985E-35)
            if (r11 != r12) goto L_0x0144
            O3.f r8 = f(r10)     // Catch:{ all -> 0x0142 }
            int r9 = r8.b()     // Catch:{ all -> 0x0142 }
            long r11 = (long) r9     // Catch:{ all -> 0x0142 }
            java.lang.String r9 = r10.readUtf8(r11)     // Catch:{ all -> 0x0142 }
            r10.close()     // Catch:{ all -> 0x00d8 }
            r10 = 20
            long r10 = (long) r10     // Catch:{ all -> 0x00d8 }
            long r4 = r4 - r10
            r10 = 0
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 <= 0) goto L_0x00e2
            N3.Z r4 = r3.A(r4)     // Catch:{ all -> 0x00d8 }
            N3.g r4 = N3.L.d(r4)     // Catch:{ all -> 0x00d8 }
            int r5 = r4.readIntLe()     // Catch:{ all -> 0x0097 }
            r11 = 117853008(0x7064b50, float:1.0103172E-34)
            if (r5 != r11) goto L_0x00d2
            int r5 = r4.readIntLe()     // Catch:{ all -> 0x0097 }
            long r11 = r4.readLongLe()     // Catch:{ all -> 0x0097 }
            int r13 = r4.readIntLe()     // Catch:{ all -> 0x0097 }
            r14 = 1
            if (r13 != r14) goto L_0x00ca
            if (r5 != 0) goto L_0x00ca
            N3.Z r5 = r3.A(r11)     // Catch:{ all -> 0x0097 }
            N3.g r5 = N3.L.d(r5)     // Catch:{ all -> 0x0097 }
            int r11 = r5.readIntLe()     // Catch:{ all -> 0x009a }
            r12 = 101075792(0x6064b50, float:2.525793E-35)
            if (r11 != r12) goto L_0x009d
            O3.f r8 = j(r5, r8)     // Catch:{ all -> 0x009a }
            R2.s r11 = R2.s.f8222a     // Catch:{ all -> 0x009a }
            b3.C1642b.a(r5, r10)     // Catch:{ all -> 0x0097 }
            goto L_0x00d2
        L_0x0097:
            r0 = move-exception
            r1 = r0
            goto L_0x00dc
        L_0x009a:
            r0 = move-exception
            r1 = r0
            goto L_0x00c4
        L_0x009d:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x009a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r1.<init>()     // Catch:{ all -> 0x009a }
            java.lang.String r2 = "bad zip: expected "
            r1.append(r2)     // Catch:{ all -> 0x009a }
            java.lang.String r2 = c(r12)     // Catch:{ all -> 0x009a }
            r1.append(r2)     // Catch:{ all -> 0x009a }
            java.lang.String r2 = " but was "
            r1.append(r2)     // Catch:{ all -> 0x009a }
            java.lang.String r2 = c(r11)     // Catch:{ all -> 0x009a }
            r1.append(r2)     // Catch:{ all -> 0x009a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x009a }
            r0.<init>(r1)     // Catch:{ all -> 0x009a }
            throw r0     // Catch:{ all -> 0x009a }
        L_0x00c4:
            throw r1     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r0 = move-exception
            b3.C1642b.a(r5, r1)     // Catch:{ all -> 0x0097 }
            throw r0     // Catch:{ all -> 0x0097 }
        L_0x00ca:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0097 }
            java.lang.String r1 = "unsupported zip: spanned"
            r0.<init>(r1)     // Catch:{ all -> 0x0097 }
            throw r0     // Catch:{ all -> 0x0097 }
        L_0x00d2:
            R2.s r5 = R2.s.f8222a     // Catch:{ all -> 0x0097 }
            b3.C1642b.a(r4, r10)     // Catch:{ all -> 0x00d8 }
            goto L_0x00e2
        L_0x00d8:
            r0 = move-exception
            r1 = r0
            goto L_0x0177
        L_0x00dc:
            throw r1     // Catch:{ all -> 0x00dd }
        L_0x00dd:
            r0 = move-exception
            b3.C1642b.a(r4, r1)     // Catch:{ all -> 0x00d8 }
            throw r0     // Catch:{ all -> 0x00d8 }
        L_0x00e2:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00d8 }
            r4.<init>()     // Catch:{ all -> 0x00d8 }
            long r11 = r8.a()     // Catch:{ all -> 0x00d8 }
            N3.Z r5 = r3.A(r11)     // Catch:{ all -> 0x00d8 }
            N3.g r5 = N3.L.d(r5)     // Catch:{ all -> 0x00d8 }
            long r11 = r8.c()     // Catch:{ all -> 0x011b }
        L_0x00f7:
            int r13 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x012a
            O3.i r13 = e(r5)     // Catch:{ all -> 0x011b }
            long r14 = r13.f()     // Catch:{ all -> 0x011b }
            long r16 = r8.a()     // Catch:{ all -> 0x011b }
            int r18 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r18 >= 0) goto L_0x0122
            java.lang.Object r14 = r2.invoke(r13)     // Catch:{ all -> 0x011b }
            java.lang.Boolean r14 = (java.lang.Boolean) r14     // Catch:{ all -> 0x011b }
            boolean r14 = r14.booleanValue()     // Catch:{ all -> 0x011b }
            if (r14 == 0) goto L_0x011e
            r4.add(r13)     // Catch:{ all -> 0x011b }
            goto L_0x011e
        L_0x011b:
            r0 = move-exception
            r1 = r0
            goto L_0x013c
        L_0x011e:
            r13 = 1
            long r6 = r6 + r13
            goto L_0x00f7
        L_0x0122:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x011b }
            java.lang.String r1 = "bad zip: local file header offset >= central directory offset"
            r0.<init>(r1)     // Catch:{ all -> 0x011b }
            throw r0     // Catch:{ all -> 0x011b }
        L_0x012a:
            R2.s r2 = R2.s.f8222a     // Catch:{ all -> 0x011b }
            b3.C1642b.a(r5, r10)     // Catch:{ all -> 0x00d8 }
            java.util.Map r2 = a(r4)     // Catch:{ all -> 0x00d8 }
            N3.b0 r4 = new N3.b0     // Catch:{ all -> 0x00d8 }
            r4.<init>(r0, r1, r2, r9)     // Catch:{ all -> 0x00d8 }
            b3.C1642b.a(r3, r10)
            return r4
        L_0x013c:
            throw r1     // Catch:{ all -> 0x013d }
        L_0x013d:
            r0 = move-exception
            b3.C1642b.a(r5, r1)     // Catch:{ all -> 0x00d8 }
            throw r0     // Catch:{ all -> 0x00d8 }
        L_0x0142:
            r0 = move-exception
            goto L_0x0158
        L_0x0144:
            r10.close()     // Catch:{ all -> 0x00d8 }
            r10 = -1
            long r4 = r4 + r10
            int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0150
            goto L_0x0030
        L_0x0150:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00d8 }
            java.lang.String r1 = "not a zip: end of central directory signature not found"
            r0.<init>(r1)     // Catch:{ all -> 0x00d8 }
            throw r0     // Catch:{ all -> 0x00d8 }
        L_0x0158:
            r10.close()     // Catch:{ all -> 0x00d8 }
            throw r0     // Catch:{ all -> 0x00d8 }
        L_0x015c:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r1.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = "not a zip: size="
            r1.append(r2)     // Catch:{ all -> 0x00d8 }
            long r4 = r3.z()     // Catch:{ all -> 0x00d8 }
            r1.append(r4)     // Catch:{ all -> 0x00d8 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00d8 }
            r0.<init>(r1)     // Catch:{ all -> 0x00d8 }
            throw r0     // Catch:{ all -> 0x00d8 }
        L_0x0177:
            throw r1     // Catch:{ all -> 0x0178 }
        L_0x0178:
            r0 = move-exception
            b3.C1642b.a(r3, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: O3.C2544j.d(N3.Q, N3.k, d3.l):N3.b0");
    }

    public static final C2543i e(C2516g gVar) {
        C2516g gVar2 = gVar;
        m.e(gVar2, "<this>");
        int readIntLe = gVar2.readIntLe();
        if (readIntLe == 33639248) {
            gVar2.skip(4);
            short readShortLe = gVar2.readShortLe();
            short s4 = readShortLe & 65535;
            if ((readShortLe & 1) == 0) {
                short readShortLe2 = gVar2.readShortLe() & 65535;
                Long b5 = b(gVar2.readShortLe() & 65535, gVar2.readShortLe() & 65535);
                long readIntLe2 = ((long) gVar2.readIntLe()) & 4294967295L;
                B b6 = new B();
                b6.f20967a = ((long) gVar2.readIntLe()) & 4294967295L;
                B b7 = new B();
                b7.f20967a = ((long) gVar2.readIntLe()) & 4294967295L;
                short readShortLe3 = gVar2.readShortLe() & 65535;
                short readShortLe4 = gVar2.readShortLe() & 65535;
                gVar2.skip(8);
                B b8 = new B();
                b8.f20967a = ((long) gVar2.readIntLe()) & 4294967295L;
                String readUtf8 = gVar2.readUtf8((long) (gVar2.readShortLe() & 65535));
                if (!m3.m.C(readUtf8, 0, false, 2, (Object) null)) {
                    long j4 = b7.f20967a == 4294967295L ? (long) 8 : 0;
                    long j5 = readIntLe2;
                    if (b6.f20967a == 4294967295L) {
                        j4 += (long) 8;
                    }
                    if (b8.f20967a == 4294967295L) {
                        j4 += (long) 8;
                    }
                    long j6 = j4;
                    z zVar = new z();
                    g(gVar2, readShortLe3, new b(zVar, j6, b7, gVar2, b6, b8));
                    if (j6 <= 0 || zVar.f20985a) {
                        return new C2543i(Q.a.e(Q.f23639b, "/", false, 1, (Object) null).l(readUtf8), m3.m.o(readUtf8, "/", false, 2, (Object) null), gVar2.readUtf8((long) readShortLe4), j5, b6.f20967a, b7.f20967a, readShortLe2, b5, b8.f20967a);
                    }
                    throw new IOException("bad zip: zip64 extra required but absent");
                }
                throw new IOException("bad zip: filename contains 0x00");
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + c(s4));
        }
        throw new IOException("bad zip: expected " + c(33639248) + " but was " + c(readIntLe));
    }

    private static final C2540f f(C2516g gVar) {
        short readShortLe = gVar.readShortLe() & 65535;
        short readShortLe2 = gVar.readShortLe() & 65535;
        long readShortLe3 = (long) (gVar.readShortLe() & 65535);
        if (readShortLe3 == ((long) (gVar.readShortLe() & 65535)) && readShortLe == 0 && readShortLe2 == 0) {
            gVar.skip(4);
            return new C2540f(readShortLe3, 4294967295L & ((long) gVar.readIntLe()), gVar.readShortLe() & 65535);
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final void g(C2516g gVar, int i4, p pVar) {
        long j4 = (long) i4;
        while (j4 != 0) {
            if (j4 >= 4) {
                short readShortLe = gVar.readShortLe() & 65535;
                long readShortLe2 = ((long) gVar.readShortLe()) & 65535;
                long j5 = j4 - ((long) 4);
                if (j5 >= readShortLe2) {
                    gVar.require(readShortLe2);
                    long A4 = gVar.h().A();
                    pVar.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
                    long A5 = (gVar.h().A() + readShortLe2) - A4;
                    int i5 = (A5 > 0 ? 1 : (A5 == 0 ? 0 : -1));
                    if (i5 >= 0) {
                        if (i5 > 0) {
                            gVar.h().skip(A5);
                        }
                        j4 = j5 - readShortLe2;
                    } else {
                        throw new IOException("unsupported zip: too many bytes processed for " + readShortLe);
                    }
                } else {
                    throw new IOException("bad zip: truncated value in extra field");
                }
            } else {
                throw new IOException("bad zip: truncated header in extra field");
            }
        }
    }

    public static final C2519j h(C2516g gVar, C2519j jVar) {
        m.e(gVar, "<this>");
        m.e(jVar, "basicMetadata");
        C2519j i4 = i(gVar, jVar);
        m.b(i4);
        return i4;
    }

    private static final C2519j i(C2516g gVar, C2519j jVar) {
        Long l4;
        C2516g gVar2 = gVar;
        C c5 = new C();
        if (jVar != null) {
            l4 = jVar.a();
        } else {
            l4 = null;
        }
        c5.f20968a = l4;
        C c6 = new C();
        C c7 = new C();
        int readIntLe = gVar2.readIntLe();
        if (readIntLe == 67324752) {
            gVar2.skip(2);
            short readShortLe = gVar2.readShortLe();
            short s4 = readShortLe & 65535;
            if ((readShortLe & 1) == 0) {
                gVar2.skip(18);
                short readShortLe2 = gVar2.readShortLe() & 65535;
                gVar2.skip(((long) gVar2.readShortLe()) & 65535);
                if (jVar == null) {
                    gVar2.skip((long) readShortLe2);
                    return null;
                }
                g(gVar2, readShortLe2, new c(gVar2, c5, c6, c7));
                return new C2519j(jVar.d(), jVar.c(), (Q) null, jVar.b(), (Long) c7.f20968a, (Long) c5.f20968a, (Long) c6.f20968a, (Map) null, 128, (C2103g) null);
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + c(s4));
        }
        throw new IOException("bad zip: expected " + c(67324752) + " but was " + c(readIntLe));
    }

    private static final C2540f j(C2516g gVar, C2540f fVar) {
        gVar.skip(12);
        int readIntLe = gVar.readIntLe();
        int readIntLe2 = gVar.readIntLe();
        long readLongLe = gVar.readLongLe();
        if (readLongLe == gVar.readLongLe() && readIntLe == 0 && readIntLe2 == 0) {
            gVar.skip(8);
            return new C2540f(readLongLe, gVar.readLongLe(), fVar.b());
        }
        throw new IOException("unsupported zip: spanned");
    }

    public static final void k(C2516g gVar) {
        m.e(gVar, "<this>");
        i(gVar, (C2519j) null);
    }
}
