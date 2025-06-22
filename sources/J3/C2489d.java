package J3;

import N3.C2514e;
import N3.C2516g;
import N3.C2517h;
import N3.L;
import N3.Z;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: J3.d  reason: case insensitive filesystem */
abstract class C2489d {

    /* renamed from: a  reason: collision with root package name */
    static final C2488c[] f23448a;

    /* renamed from: b  reason: collision with root package name */
    static final Map f23449b = b();

    /* renamed from: J3.d$a */
    static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final List f23450a;

        /* renamed from: b  reason: collision with root package name */
        private final C2516g f23451b;

        /* renamed from: c  reason: collision with root package name */
        private final int f23452c;

        /* renamed from: d  reason: collision with root package name */
        private int f23453d;

        /* renamed from: e  reason: collision with root package name */
        C2488c[] f23454e;

        /* renamed from: f  reason: collision with root package name */
        int f23455f;

        /* renamed from: g  reason: collision with root package name */
        int f23456g;

        /* renamed from: h  reason: collision with root package name */
        int f23457h;

        a(int i4, Z z4) {
            this(i4, i4, z4);
        }

        private void a() {
            int i4 = this.f23453d;
            int i5 = this.f23457h;
            if (i4 >= i5) {
                return;
            }
            if (i4 == 0) {
                b();
            } else {
                d(i5 - i4);
            }
        }

        private void b() {
            Arrays.fill(this.f23454e, (Object) null);
            this.f23455f = this.f23454e.length - 1;
            this.f23456g = 0;
            this.f23457h = 0;
        }

        private int c(int i4) {
            return this.f23455f + 1 + i4;
        }

        private int d(int i4) {
            int i5;
            int i6 = 0;
            if (i4 > 0) {
                int length = this.f23454e.length;
                while (true) {
                    length--;
                    i5 = this.f23455f;
                    if (length < i5 || i4 <= 0) {
                        C2488c[] cVarArr = this.f23454e;
                        System.arraycopy(cVarArr, i5 + 1, cVarArr, i5 + 1 + i6, this.f23456g);
                        this.f23455f += i6;
                    } else {
                        int i7 = this.f23454e[length].f23447c;
                        i4 -= i7;
                        this.f23457h -= i7;
                        this.f23456g--;
                        i6++;
                    }
                }
                C2488c[] cVarArr2 = this.f23454e;
                System.arraycopy(cVarArr2, i5 + 1, cVarArr2, i5 + 1 + i6, this.f23456g);
                this.f23455f += i6;
            }
            return i6;
        }

        private C2517h f(int i4) {
            if (h(i4)) {
                return C2489d.f23448a[i4].f23445a;
            }
            int c5 = c(i4 - C2489d.f23448a.length);
            if (c5 >= 0) {
                C2488c[] cVarArr = this.f23454e;
                if (c5 < cVarArr.length) {
                    return cVarArr[c5].f23445a;
                }
            }
            throw new IOException("Header index too large " + (i4 + 1));
        }

        private void g(int i4, C2488c cVar) {
            this.f23450a.add(cVar);
            int i5 = cVar.f23447c;
            if (i4 != -1) {
                i5 -= this.f23454e[c(i4)].f23447c;
            }
            int i6 = this.f23453d;
            if (i5 > i6) {
                b();
                return;
            }
            int d5 = d((this.f23457h + i5) - i6);
            if (i4 == -1) {
                int i7 = this.f23456g + 1;
                C2488c[] cVarArr = this.f23454e;
                if (i7 > cVarArr.length) {
                    C2488c[] cVarArr2 = new C2488c[(cVarArr.length * 2)];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f23455f = this.f23454e.length - 1;
                    this.f23454e = cVarArr2;
                }
                int i8 = this.f23455f;
                this.f23455f = i8 - 1;
                this.f23454e[i8] = cVar;
                this.f23456g++;
            } else {
                this.f23454e[i4 + c(i4) + d5] = cVar;
            }
            this.f23457h += i5;
        }

        private boolean h(int i4) {
            if (i4 < 0 || i4 > C2489d.f23448a.length - 1) {
                return false;
            }
            return true;
        }

        private int i() {
            return this.f23451b.readByte() & 255;
        }

        private void l(int i4) {
            if (h(i4)) {
                this.f23450a.add(C2489d.f23448a[i4]);
                return;
            }
            int c5 = c(i4 - C2489d.f23448a.length);
            if (c5 >= 0) {
                C2488c[] cVarArr = this.f23454e;
                if (c5 < cVarArr.length) {
                    this.f23450a.add(cVarArr[c5]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i4 + 1));
        }

        private void n(int i4) {
            g(-1, new C2488c(f(i4), j()));
        }

        private void o() {
            g(-1, new C2488c(C2489d.a(j()), j()));
        }

        private void p(int i4) {
            this.f23450a.add(new C2488c(f(i4), j()));
        }

        private void q() {
            this.f23450a.add(new C2488c(C2489d.a(j()), j()));
        }

        public List e() {
            ArrayList arrayList = new ArrayList(this.f23450a);
            this.f23450a.clear();
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public C2517h j() {
            boolean z4;
            int i4 = i();
            if ((i4 & 128) == 128) {
                z4 = true;
            } else {
                z4 = false;
            }
            int m4 = m(i4, ModuleDescriptor.MODULE_VERSION);
            if (z4) {
                return C2517h.w(k.f().c(this.f23451b.readByteArray((long) m4)));
            }
            return this.f23451b.readByteString((long) m4);
        }

        /* access modifiers changed from: package-private */
        public void k() {
            while (!this.f23451b.exhausted()) {
                byte readByte = this.f23451b.readByte();
                byte b5 = readByte & 255;
                if (b5 == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    l(m(b5, ModuleDescriptor.MODULE_VERSION) - 1);
                } else if (b5 == 64) {
                    o();
                } else if ((readByte & 64) == 64) {
                    n(m(b5, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int m4 = m(b5, 31);
                    this.f23453d = m4;
                    if (m4 < 0 || m4 > this.f23452c) {
                        throw new IOException("Invalid dynamic table size update " + this.f23453d);
                    }
                    a();
                } else if (b5 == 16 || b5 == 0) {
                    q();
                } else {
                    p(m(b5, 15) - 1);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int m(int i4, int i5) {
            int i6 = i4 & i5;
            if (i6 < i5) {
                return i6;
            }
            int i7 = 0;
            while (true) {
                int i8 = i();
                if ((i8 & 128) == 0) {
                    return i5 + (i8 << i7);
                }
                i5 += (i8 & ModuleDescriptor.MODULE_VERSION) << i7;
                i7 += 7;
            }
        }

        a(int i4, int i5, Z z4) {
            this.f23450a = new ArrayList();
            C2488c[] cVarArr = new C2488c[8];
            this.f23454e = cVarArr;
            this.f23455f = cVarArr.length - 1;
            this.f23456g = 0;
            this.f23457h = 0;
            this.f23452c = i4;
            this.f23453d = i5;
            this.f23451b = L.d(z4);
        }
    }

    /* renamed from: J3.d$b */
    static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final C2514e f23458a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f23459b;

        /* renamed from: c  reason: collision with root package name */
        private int f23460c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f23461d;

        /* renamed from: e  reason: collision with root package name */
        int f23462e;

        /* renamed from: f  reason: collision with root package name */
        int f23463f;

        /* renamed from: g  reason: collision with root package name */
        C2488c[] f23464g;

        /* renamed from: h  reason: collision with root package name */
        int f23465h;

        /* renamed from: i  reason: collision with root package name */
        int f23466i;

        /* renamed from: j  reason: collision with root package name */
        int f23467j;

        b(C2514e eVar) {
            this(4096, true, eVar);
        }

        private void a() {
            int i4 = this.f23463f;
            int i5 = this.f23467j;
            if (i4 >= i5) {
                return;
            }
            if (i4 == 0) {
                b();
            } else {
                c(i5 - i4);
            }
        }

        private void b() {
            Arrays.fill(this.f23464g, (Object) null);
            this.f23465h = this.f23464g.length - 1;
            this.f23466i = 0;
            this.f23467j = 0;
        }

        private int c(int i4) {
            int i5;
            int i6 = 0;
            if (i4 > 0) {
                int length = this.f23464g.length;
                while (true) {
                    length--;
                    i5 = this.f23465h;
                    if (length < i5 || i4 <= 0) {
                        C2488c[] cVarArr = this.f23464g;
                        System.arraycopy(cVarArr, i5 + 1, cVarArr, i5 + 1 + i6, this.f23466i);
                        C2488c[] cVarArr2 = this.f23464g;
                        int i7 = this.f23465h;
                        Arrays.fill(cVarArr2, i7 + 1, i7 + 1 + i6, (Object) null);
                        this.f23465h += i6;
                    } else {
                        int i8 = this.f23464g[length].f23447c;
                        i4 -= i8;
                        this.f23467j -= i8;
                        this.f23466i--;
                        i6++;
                    }
                }
                C2488c[] cVarArr3 = this.f23464g;
                System.arraycopy(cVarArr3, i5 + 1, cVarArr3, i5 + 1 + i6, this.f23466i);
                C2488c[] cVarArr22 = this.f23464g;
                int i72 = this.f23465h;
                Arrays.fill(cVarArr22, i72 + 1, i72 + 1 + i6, (Object) null);
                this.f23465h += i6;
            }
            return i6;
        }

        private void d(C2488c cVar) {
            int i4 = cVar.f23447c;
            int i5 = this.f23463f;
            if (i4 > i5) {
                b();
                return;
            }
            c((this.f23467j + i4) - i5);
            int i6 = this.f23466i + 1;
            C2488c[] cVarArr = this.f23464g;
            if (i6 > cVarArr.length) {
                C2488c[] cVarArr2 = new C2488c[(cVarArr.length * 2)];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f23465h = this.f23464g.length - 1;
                this.f23464g = cVarArr2;
            }
            int i7 = this.f23465h;
            this.f23465h = i7 - 1;
            this.f23464g[i7] = cVar;
            this.f23466i++;
            this.f23467j += i4;
        }

        /* access modifiers changed from: package-private */
        public void e(int i4) {
            this.f23462e = i4;
            int min = Math.min(i4, 16384);
            int i5 = this.f23463f;
            if (i5 != min) {
                if (min < i5) {
                    this.f23460c = Math.min(this.f23460c, min);
                }
                this.f23461d = true;
                this.f23463f = min;
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void f(C2517h hVar) {
            if (!this.f23459b || k.f().e(hVar) >= hVar.G()) {
                h(hVar.G(), ModuleDescriptor.MODULE_VERSION, 0);
                this.f23458a.G(hVar);
                return;
            }
            C2514e eVar = new C2514e();
            k.f().d(hVar, eVar);
            C2517h x4 = eVar.x();
            h(x4.G(), ModuleDescriptor.MODULE_VERSION, 128);
            this.f23458a.G(x4);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00a8  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g(java.util.List r14) {
            /*
                r13 = this;
                boolean r0 = r13.f23461d
                r1 = 0
                if (r0 == 0) goto L_0x001e
                int r0 = r13.f23460c
                int r2 = r13.f23463f
                r3 = 32
                r4 = 31
                if (r0 >= r2) goto L_0x0012
                r13.h(r0, r4, r3)
            L_0x0012:
                r13.f23461d = r1
                r0 = 2147483647(0x7fffffff, float:NaN)
                r13.f23460c = r0
                int r0 = r13.f23463f
                r13.h(r0, r4, r3)
            L_0x001e:
                int r0 = r14.size()
                r2 = 0
            L_0x0023:
                if (r2 >= r0) goto L_0x00eb
                java.lang.Object r3 = r14.get(r2)
                J3.c r3 = (J3.C2488c) r3
                N3.h r4 = r3.f23445a
                N3.h r4 = r4.K()
                N3.h r5 = r3.f23446b
                java.util.Map r6 = J3.C2489d.f23449b
                java.lang.Object r6 = r6.get(r4)
                java.lang.Integer r6 = (java.lang.Integer) r6
                r7 = 1
                r8 = -1
                if (r6 == 0) goto L_0x006c
                int r6 = r6.intValue()
                int r9 = r6 + 1
                if (r9 <= r7) goto L_0x0069
                r10 = 8
                if (r9 >= r10) goto L_0x0069
                J3.c[] r10 = J3.C2489d.f23448a
                r11 = r10[r6]
                N3.h r11 = r11.f23446b
                boolean r11 = E3.c.n(r11, r5)
                if (r11 == 0) goto L_0x0059
                r6 = r9
                goto L_0x006e
            L_0x0059:
                r10 = r10[r9]
                N3.h r10 = r10.f23446b
                boolean r10 = E3.c.n(r10, r5)
                if (r10 == 0) goto L_0x0069
                int r6 = r6 + 2
                r12 = r9
                r9 = r6
                r6 = r12
                goto L_0x006e
            L_0x0069:
                r6 = r9
            L_0x006a:
                r9 = -1
                goto L_0x006e
            L_0x006c:
                r6 = -1
                goto L_0x006a
            L_0x006e:
                if (r9 != r8) goto L_0x00a6
                int r10 = r13.f23465h
                int r10 = r10 + r7
                J3.c[] r7 = r13.f23464g
                int r7 = r7.length
            L_0x0076:
                if (r10 >= r7) goto L_0x00a6
                J3.c[] r11 = r13.f23464g
                r11 = r11[r10]
                N3.h r11 = r11.f23445a
                boolean r11 = E3.c.n(r11, r4)
                if (r11 == 0) goto L_0x00a3
                J3.c[] r11 = r13.f23464g
                r11 = r11[r10]
                N3.h r11 = r11.f23446b
                boolean r11 = E3.c.n(r11, r5)
                if (r11 == 0) goto L_0x0099
                int r7 = r13.f23465h
                int r10 = r10 - r7
                J3.c[] r7 = J3.C2489d.f23448a
                int r7 = r7.length
                int r9 = r10 + r7
                goto L_0x00a6
            L_0x0099:
                if (r6 != r8) goto L_0x00a3
                int r6 = r13.f23465h
                int r6 = r10 - r6
                J3.c[] r11 = J3.C2489d.f23448a
                int r11 = r11.length
                int r6 = r6 + r11
            L_0x00a3:
                int r10 = r10 + 1
                goto L_0x0076
            L_0x00a6:
                if (r9 == r8) goto L_0x00b0
                r3 = 127(0x7f, float:1.78E-43)
                r4 = 128(0x80, float:1.794E-43)
                r13.h(r9, r3, r4)
                goto L_0x00e7
            L_0x00b0:
                r7 = 64
                if (r6 != r8) goto L_0x00c3
                N3.e r6 = r13.f23458a
                r6.writeByte(r7)
                r13.f(r4)
                r13.f(r5)
                r13.d(r3)
                goto L_0x00e7
            L_0x00c3:
                N3.h r8 = J3.C2488c.f23439d
                boolean r8 = r4.H(r8)
                if (r8 == 0) goto L_0x00dc
                N3.h r8 = J3.C2488c.f23444i
                boolean r4 = r8.equals(r4)
                if (r4 != 0) goto L_0x00dc
                r3 = 15
                r13.h(r6, r3, r1)
                r13.f(r5)
                goto L_0x00e7
            L_0x00dc:
                r4 = 63
                r13.h(r6, r4, r7)
                r13.f(r5)
                r13.d(r3)
            L_0x00e7:
                int r2 = r2 + 1
                goto L_0x0023
            L_0x00eb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: J3.C2489d.b.g(java.util.List):void");
        }

        /* access modifiers changed from: package-private */
        public void h(int i4, int i5, int i6) {
            if (i4 < i5) {
                this.f23458a.writeByte(i4 | i6);
                return;
            }
            this.f23458a.writeByte(i6 | i5);
            int i7 = i4 - i5;
            while (i7 >= 128) {
                this.f23458a.writeByte(128 | (i7 & ModuleDescriptor.MODULE_VERSION));
                i7 >>>= 7;
            }
            this.f23458a.writeByte(i7);
        }

        b(int i4, boolean z4, C2514e eVar) {
            this.f23460c = Integer.MAX_VALUE;
            C2488c[] cVarArr = new C2488c[8];
            this.f23464g = cVarArr;
            this.f23465h = cVarArr.length - 1;
            this.f23466i = 0;
            this.f23467j = 0;
            this.f23462e = i4;
            this.f23463f = i4;
            this.f23459b = z4;
            this.f23458a = eVar;
        }
    }

    static {
        C2488c cVar = new C2488c(C2488c.f23444i, "");
        C2517h hVar = C2488c.f23441f;
        C2488c cVar2 = new C2488c(hVar, ShareTarget.METHOD_GET);
        C2488c cVar3 = new C2488c(hVar, ShareTarget.METHOD_POST);
        C2517h hVar2 = C2488c.f23442g;
        C2488c cVar4 = new C2488c(hVar2, "/");
        C2488c cVar5 = new C2488c(hVar2, "/index.html");
        C2517h hVar3 = C2488c.f23443h;
        C2488c cVar6 = new C2488c(hVar3, "http");
        C2488c cVar7 = new C2488c(hVar3, "https");
        C2517h hVar4 = C2488c.f23440e;
        C2488c cVar8 = cVar;
        C2488c cVar9 = cVar2;
        f23448a = new C2488c[]{cVar8, cVar9, cVar3, cVar4, cVar5, cVar6, cVar7, new C2488c(hVar4, "200"), new C2488c(hVar4, "204"), new C2488c(hVar4, "206"), new C2488c(hVar4, "304"), new C2488c(hVar4, "400"), new C2488c(hVar4, "404"), new C2488c(hVar4, "500"), new C2488c("accept-charset", ""), new C2488c("accept-encoding", "gzip, deflate"), new C2488c("accept-language", ""), new C2488c("accept-ranges", ""), new C2488c("accept", ""), new C2488c("access-control-allow-origin", ""), new C2488c("age", ""), new C2488c("allow", ""), new C2488c("authorization", ""), new C2488c("cache-control", ""), new C2488c("content-disposition", ""), new C2488c("content-encoding", ""), new C2488c("content-language", ""), new C2488c("content-length", ""), new C2488c("content-location", ""), new C2488c("content-range", ""), new C2488c("content-type", ""), new C2488c("cookie", ""), new C2488c("date", ""), new C2488c(DownloadModel.ETAG, ""), new C2488c("expect", ""), new C2488c("expires", ""), new C2488c(TypedValues.TransitionType.S_FROM, ""), new C2488c("host", ""), new C2488c("if-match", ""), new C2488c("if-modified-since", ""), new C2488c("if-none-match", ""), new C2488c("if-range", ""), new C2488c("if-unmodified-since", ""), new C2488c("last-modified", ""), new C2488c("link", ""), new C2488c("location", ""), new C2488c("max-forwards", ""), new C2488c("proxy-authenticate", ""), new C2488c("proxy-authorization", ""), new C2488c("range", ""), new C2488c("referer", ""), new C2488c(ToolBar.REFRESH, ""), new C2488c("retry-after", ""), new C2488c("server", ""), new C2488c("set-cookie", ""), new C2488c("strict-transport-security", ""), new C2488c("transfer-encoding", ""), new C2488c("user-agent", ""), new C2488c("vary", ""), new C2488c("via", ""), new C2488c("www-authenticate", "")};
    }

    static C2517h a(C2517h hVar) {
        int G4 = hVar.G();
        int i4 = 0;
        while (i4 < G4) {
            byte h4 = hVar.h(i4);
            if (h4 < 65 || h4 > 90) {
                i4++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + hVar.M());
            }
        }
        return hVar;
    }

    private static Map b() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f23448a.length);
        int i4 = 0;
        while (true) {
            C2488c[] cVarArr = f23448a;
            if (i4 >= cVarArr.length) {
                return DesugarCollections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(cVarArr[i4].f23445a)) {
                linkedHashMap.put(cVarArr[i4].f23445a, Integer.valueOf(i4));
            }
            i4++;
        }
    }
}
