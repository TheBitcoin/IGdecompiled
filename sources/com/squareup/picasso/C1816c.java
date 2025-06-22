package com.squareup.picasso;

import N3.C2516g;
import N3.L;
import N3.Z;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.NetworkInfo;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.squareup.picasso.q;
import com.squareup.picasso.s;
import com.squareup.picasso.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.squareup.picasso.c  reason: case insensitive filesystem */
class C1816c implements Runnable {

    /* renamed from: t  reason: collision with root package name */
    private static final Object f17209t = new Object();

    /* renamed from: u  reason: collision with root package name */
    private static final ThreadLocal f17210u = new a();

    /* renamed from: v  reason: collision with root package name */
    private static final AtomicInteger f17211v = new AtomicInteger();

    /* renamed from: w  reason: collision with root package name */
    private static final x f17212w = new b();

    /* renamed from: a  reason: collision with root package name */
    final int f17213a = f17211v.incrementAndGet();

    /* renamed from: b  reason: collision with root package name */
    final s f17214b;

    /* renamed from: c  reason: collision with root package name */
    final g f17215c;

    /* renamed from: d  reason: collision with root package name */
    final H1.a f17216d;

    /* renamed from: e  reason: collision with root package name */
    final z f17217e;

    /* renamed from: f  reason: collision with root package name */
    final String f17218f;

    /* renamed from: g  reason: collision with root package name */
    final v f17219g;

    /* renamed from: h  reason: collision with root package name */
    final int f17220h;

    /* renamed from: i  reason: collision with root package name */
    int f17221i;

    /* renamed from: j  reason: collision with root package name */
    final x f17222j;

    /* renamed from: k  reason: collision with root package name */
    C1814a f17223k;

    /* renamed from: l  reason: collision with root package name */
    List f17224l;

    /* renamed from: m  reason: collision with root package name */
    Bitmap f17225m;

    /* renamed from: n  reason: collision with root package name */
    Future f17226n;

    /* renamed from: o  reason: collision with root package name */
    s.e f17227o;

    /* renamed from: p  reason: collision with root package name */
    Exception f17228p;

    /* renamed from: q  reason: collision with root package name */
    int f17229q;

    /* renamed from: r  reason: collision with root package name */
    int f17230r;

    /* renamed from: s  reason: collision with root package name */
    s.f f17231s;

    /* renamed from: com.squareup.picasso.c$a */
    static class a extends ThreadLocal {
        a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    }

    /* renamed from: com.squareup.picasso.c$b */
    static class b extends x {
        b() {
        }

        public boolean c(v vVar) {
            return true;
        }

        public x.a f(v vVar, int i4) {
            throw new IllegalStateException("Unrecognized type of request: " + vVar);
        }
    }

    /* renamed from: com.squareup.picasso.c$c  reason: collision with other inner class name */
    static class C0210c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ H1.e f17232a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RuntimeException f17233b;

        C0210c(H1.e eVar, RuntimeException runtimeException) {
            this.f17232a = eVar;
            this.f17233b = runtimeException;
        }

        public void run() {
            throw new RuntimeException("Transformation " + this.f17232a.key() + " crashed with exception.", this.f17233b);
        }
    }

    /* renamed from: com.squareup.picasso.c$d */
    static class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ StringBuilder f17234a;

        d(StringBuilder sb) {
            this.f17234a = sb;
        }

        public void run() {
            throw new NullPointerException(this.f17234a.toString());
        }
    }

    /* renamed from: com.squareup.picasso.c$e */
    static class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ H1.e f17235a;

        e(H1.e eVar) {
            this.f17235a = eVar;
        }

        public void run() {
            throw new IllegalStateException("Transformation " + this.f17235a.key() + " returned input Bitmap but recycled it.");
        }
    }

    /* renamed from: com.squareup.picasso.c$f */
    static class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ H1.e f17236a;

        f(H1.e eVar) {
            this.f17236a = eVar;
        }

        public void run() {
            throw new IllegalStateException("Transformation " + this.f17236a.key() + " mutated input Bitmap but failed to recycle the original.");
        }
    }

    C1816c(s sVar, g gVar, H1.a aVar, z zVar, C1814a aVar2, x xVar) {
        this.f17214b = sVar;
        this.f17215c = gVar;
        this.f17216d = aVar;
        this.f17217e = zVar;
        this.f17223k = aVar2;
        this.f17218f = aVar2.d();
        this.f17219g = aVar2.i();
        this.f17231s = aVar2.h();
        this.f17220h = aVar2.e();
        this.f17221i = aVar2.f();
        this.f17222j = xVar;
        this.f17230r = xVar.e();
    }

    static Bitmap a(List list, Bitmap bitmap) {
        int size = list.size();
        int i4 = 0;
        while (i4 < size) {
            H1.e eVar = (H1.e) list.get(i4);
            try {
                Bitmap a5 = eVar.a(bitmap);
                if (a5 == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Transformation ");
                    sb.append(eVar.key());
                    sb.append(" returned null after ");
                    sb.append(i4);
                    sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        sb.append(((H1.e) it.next()).key());
                        sb.append(10);
                    }
                    s.f17301o.post(new d(sb));
                    return null;
                } else if (a5 == bitmap && bitmap.isRecycled()) {
                    s.f17301o.post(new e(eVar));
                    return null;
                } else if (a5 == bitmap || bitmap.isRecycled()) {
                    i4++;
                    bitmap = a5;
                } else {
                    s.f17301o.post(new f(eVar));
                    return null;
                }
            } catch (RuntimeException e5) {
                s.f17301o.post(new C0210c(eVar, e5));
                return null;
            }
        }
        return bitmap;
    }

    private s.f d() {
        boolean z4;
        s.f fVar = s.f.LOW;
        List list = this.f17224l;
        if (list == null || list.isEmpty()) {
            z4 = false;
        } else {
            z4 = true;
        }
        C1814a aVar = this.f17223k;
        if (aVar == null && !z4) {
            return fVar;
        }
        if (aVar != null) {
            fVar = aVar.h();
        }
        if (z4) {
            int size = this.f17224l.size();
            for (int i4 = 0; i4 < size; i4++) {
                s.f h4 = ((C1814a) this.f17224l.get(i4)).h();
                if (h4.ordinal() > fVar.ordinal()) {
                    fVar = h4;
                }
            }
        }
        return fVar;
    }

    static Bitmap e(Z z4, v vVar) {
        C2516g d5 = L.d(z4);
        boolean s4 = C.s(d5);
        boolean z5 = vVar.f17367r;
        BitmapFactory.Options d6 = x.d(vVar);
        boolean g4 = x.g(d6);
        if (!s4) {
            InputStream inputStream = d5.inputStream();
            if (g4) {
                m mVar = new m(inputStream);
                mVar.a(false);
                long g5 = mVar.g(1024);
                BitmapFactory.decodeStream(mVar, (Rect) null, d6);
                x.b(vVar.f17357h, vVar.f17358i, d6, vVar);
                mVar.d(g5);
                mVar.a(true);
                inputStream = mVar;
            }
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, (Rect) null, d6);
            if (decodeStream != null) {
                return decodeStream;
            }
            throw new IOException("Failed to decode stream.");
        }
        byte[] readByteArray = d5.readByteArray();
        if (g4) {
            BitmapFactory.decodeByteArray(readByteArray, 0, readByteArray.length, d6);
            x.b(vVar.f17357h, vVar.f17358i, d6, vVar);
        }
        return BitmapFactory.decodeByteArray(readByteArray, 0, readByteArray.length, d6);
    }

    static C1816c g(s sVar, g gVar, H1.a aVar, z zVar, C1814a aVar2) {
        v i4 = aVar2.i();
        List i5 = sVar.i();
        int size = i5.size();
        for (int i6 = 0; i6 < size; i6++) {
            x xVar = (x) i5.get(i6);
            if (xVar.c(i4)) {
                return new C1816c(sVar, gVar, aVar, zVar, aVar2, xVar);
            }
        }
        return new C1816c(sVar, gVar, aVar, zVar, aVar2, f17212w);
    }

    static int l(int i4) {
        switch (i4) {
            case 3:
            case 4:
                return SubsamplingScaleImageView.ORIENTATION_180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return SubsamplingScaleImageView.ORIENTATION_270;
            default:
                return 0;
        }
    }

    static int m(int i4) {
        return (i4 == 2 || i4 == 7 || i4 == 4 || i4 == 5) ? -1 : 1;
    }

    private static boolean v(boolean z4, int i4, int i5, int i6, int i7) {
        if (!z4) {
            return true;
        }
        if (i6 == 0 || i4 <= i6) {
            return i7 != 0 && i5 > i7;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x0216  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0280 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Bitmap y(com.squareup.picasso.v r27, android.graphics.Bitmap r28, int r29) {
        /*
            r0 = r27
            int r1 = r28.getWidth()
            int r2 = r28.getHeight()
            boolean r3 = r0.f17362m
            android.graphics.Matrix r5 = new android.graphics.Matrix
            r5.<init>()
            boolean r4 = r0.e()
            if (r4 != 0) goto L_0x001e
            if (r29 == 0) goto L_0x001a
            goto L_0x001e
        L_0x001a:
            r3 = r1
            r6 = r2
            goto L_0x0270
        L_0x001e:
            int r4 = r0.f17357h
            int r7 = r0.f17358i
            float r8 = r0.f17363n
            r9 = 0
            int r9 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r9 == 0) goto L_0x014f
            double r9 = (double) r8
            double r11 = java.lang.Math.toRadians(r9)
            double r11 = java.lang.Math.cos(r11)
            double r9 = java.lang.Math.toRadians(r9)
            double r9 = java.lang.Math.sin(r9)
            boolean r4 = r0.f17366q
            if (r4 == 0) goto L_0x00de
            float r4 = r0.f17364o
            float r7 = r0.f17365p
            r5.setRotate(r8, r4, r7)
            float r4 = r0.f17364o
            double r7 = (double) r4
            r13 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r13 = r13 - r11
            double r7 = r7 * r13
            float r15 = r0.f17365p
            r17 = r7
            double r6 = (double) r15
            double r6 = r6 * r9
            double r7 = r17 + r6
            r17 = r9
            double r9 = (double) r15
            double r9 = r9 * r13
            double r13 = (double) r4
            double r13 = r13 * r17
            double r9 = r9 - r13
            int r4 = r0.f17357h
            double r13 = (double) r4
            double r13 = r13 * r11
            double r13 = r13 + r7
            r19 = r11
            double r11 = (double) r4
            double r11 = r11 * r17
            double r11 = r11 + r9
            r6 = r2
            r15 = r3
            double r2 = (double) r4
            double r2 = r2 * r19
            double r2 = r2 + r7
            r21 = r2
            int r2 = r0.f17358i
            r3 = r1
            double r0 = (double) r2
            double r0 = r0 * r17
            double r0 = r21 - r0
            r21 = r3
            double r3 = (double) r4
            double r3 = r3 * r17
            double r3 = r3 + r9
            r22 = r3
            double r3 = (double) r2
            double r3 = r3 * r19
            double r3 = r22 + r3
            r22 = r5
            r23 = r6
            double r5 = (double) r2
            double r5 = r5 * r17
            double r5 = r7 - r5
            r24 = r3
            double r2 = (double) r2
            double r2 = r2 * r19
            double r2 = r2 + r9
            r17 = r2
            double r2 = java.lang.Math.max(r7, r13)
            double r2 = java.lang.Math.max(r0, r2)
            double r2 = java.lang.Math.max(r5, r2)
            double r7 = java.lang.Math.min(r7, r13)
            double r0 = java.lang.Math.min(r0, r7)
            double r0 = java.lang.Math.min(r5, r0)
            double r4 = java.lang.Math.max(r9, r11)
            r6 = r24
            double r4 = java.lang.Math.max(r6, r4)
            r13 = r17
            double r4 = java.lang.Math.max(r13, r4)
            double r8 = java.lang.Math.min(r9, r11)
            double r6 = java.lang.Math.min(r6, r8)
            double r6 = java.lang.Math.min(r13, r6)
            double r2 = r2 - r0
            double r0 = java.lang.Math.floor(r2)
            int r0 = (int) r0
            double r4 = r4 - r6
            double r1 = java.lang.Math.floor(r4)
            int r7 = (int) r1
            r4 = r0
            r17 = r15
            goto L_0x0157
        L_0x00de:
            r21 = r1
            r23 = r2
            r15 = r3
            r17 = r9
            r19 = r11
            r5.setRotate(r8)
            r0 = r27
            int r1 = r0.f17357h
            double r2 = (double) r1
            double r2 = r2 * r19
            double r6 = (double) r1
            double r6 = r6 * r17
            double r8 = (double) r1
            double r8 = r8 * r19
            int r4 = r0.f17358i
            double r10 = (double) r4
            double r10 = r10 * r17
            double r8 = r8 - r10
            double r10 = (double) r1
            double r10 = r10 * r17
            double r12 = (double) r4
            double r12 = r12 * r19
            double r10 = r10 + r12
            double r12 = (double) r4
            double r12 = r12 * r17
            double r12 = -r12
            r1 = r15
            double r14 = (double) r4
            double r14 = r14 * r19
            r17 = r1
            r0 = 0
            r22 = r5
            double r4 = java.lang.Math.max(r0, r2)
            double r4 = java.lang.Math.max(r8, r4)
            double r4 = java.lang.Math.max(r12, r4)
            double r2 = java.lang.Math.min(r0, r2)
            double r2 = java.lang.Math.min(r8, r2)
            double r2 = java.lang.Math.min(r12, r2)
            double r8 = java.lang.Math.max(r0, r6)
            double r8 = java.lang.Math.max(r10, r8)
            double r8 = java.lang.Math.max(r14, r8)
            double r0 = java.lang.Math.min(r0, r6)
            double r0 = java.lang.Math.min(r10, r0)
            double r0 = java.lang.Math.min(r14, r0)
            double r4 = r4 - r2
            double r2 = java.lang.Math.floor(r4)
            int r4 = (int) r2
            double r8 = r8 - r0
            double r0 = java.lang.Math.floor(r8)
            int r7 = (int) r0
            goto L_0x0157
        L_0x014f:
            r21 = r1
            r23 = r2
            r17 = r3
            r22 = r5
        L_0x0157:
            if (r29 == 0) goto L_0x0185
            int r0 = l(r29)
            int r1 = m(r29)
            if (r0 == 0) goto L_0x0177
            float r2 = (float) r0
            r5 = r22
            r5.preRotate(r2)
            r2 = 90
            if (r0 == r2) goto L_0x0171
            r2 = 270(0x10e, float:3.78E-43)
            if (r0 != r2) goto L_0x0179
        L_0x0171:
            r26 = r7
            r7 = r4
            r4 = r26
            goto L_0x0179
        L_0x0177:
            r5 = r22
        L_0x0179:
            r0 = 1
            if (r1 == r0) goto L_0x0182
            float r0 = (float) r1
            r1 = 1065353216(0x3f800000, float:1.0)
            r5.postScale(r0, r1)
        L_0x0182:
            r0 = r27
            goto L_0x0188
        L_0x0185:
            r5 = r22
            goto L_0x0182
        L_0x0188:
            boolean r1 = r0.f17359j
            if (r1 == 0) goto L_0x0221
            if (r4 == 0) goto L_0x0196
            float r1 = (float) r4
            r3 = r21
            float r2 = (float) r3
            float r1 = r1 / r2
            r6 = r23
            goto L_0x019d
        L_0x0196:
            r3 = r21
            float r1 = (float) r7
            r6 = r23
            float r2 = (float) r6
            float r1 = r1 / r2
        L_0x019d:
            if (r7 == 0) goto L_0x01a3
            float r2 = (float) r7
            float r8 = (float) r6
        L_0x01a1:
            float r2 = r2 / r8
            goto L_0x01a6
        L_0x01a3:
            float r2 = (float) r4
            float r8 = (float) r3
            goto L_0x01a1
        L_0x01a6:
            int r8 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r8 <= 0) goto L_0x01d7
            float r8 = (float) r6
            float r2 = r2 / r1
            float r8 = r8 * r2
            double r8 = (double) r8
            double r8 = java.lang.Math.ceil(r8)
            int r2 = (int) r8
            int r0 = r0.f17360k
            r8 = r0 & 48
            r9 = 48
            if (r8 != r9) goto L_0x01be
            r0 = 0
            goto L_0x01ca
        L_0x01be:
            r8 = 80
            r0 = r0 & r8
            if (r0 != r8) goto L_0x01c6
            int r0 = r6 - r2
            goto L_0x01ca
        L_0x01c6:
            int r0 = r6 - r2
            int r0 = r0 / 2
        L_0x01ca:
            float r8 = (float) r7
            float r9 = (float) r2
            float r8 = r8 / r9
            r23 = r2
            r21 = r3
            r2 = r8
            r15 = r17
        L_0x01d4:
            r16 = 0
            goto L_0x0210
        L_0x01d7:
            int r8 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x0207
            float r8 = (float) r3
            float r1 = r1 / r2
            float r8 = r8 * r1
            double r8 = (double) r8
            double r8 = java.lang.Math.ceil(r8)
            int r1 = (int) r8
            int r0 = r0.f17360k
            r8 = r0 & 3
            r9 = 3
            if (r8 != r9) goto L_0x01ee
            r0 = 0
            goto L_0x01f9
        L_0x01ee:
            r8 = 5
            r0 = r0 & r8
            if (r0 != r8) goto L_0x01f5
            int r0 = r3 - r1
            goto L_0x01f9
        L_0x01f5:
            int r0 = r3 - r1
            int r0 = r0 / 2
        L_0x01f9:
            float r8 = (float) r4
            float r9 = (float) r1
            float r8 = r8 / r9
            r16 = r0
            r21 = r1
            r23 = r6
            r1 = r8
            r15 = r17
            r0 = 0
            goto L_0x0210
        L_0x0207:
            r1 = r2
            r21 = r3
            r23 = r6
            r15 = r17
            r0 = 0
            goto L_0x01d4
        L_0x0210:
            boolean r3 = v(r15, r3, r6, r4, r7)
            if (r3 == 0) goto L_0x0219
            r5.preScale(r1, r2)
        L_0x0219:
            r2 = r0
            r1 = r16
            r3 = r21
            r4 = r23
            goto L_0x0273
        L_0x0221:
            r15 = r17
            r3 = r21
            r6 = r23
            boolean r0 = r0.f17361l
            if (r0 == 0) goto L_0x024d
            if (r4 == 0) goto L_0x0231
            float r0 = (float) r4
            float r1 = (float) r3
        L_0x022f:
            float r0 = r0 / r1
            goto L_0x0234
        L_0x0231:
            float r0 = (float) r7
            float r1 = (float) r6
            goto L_0x022f
        L_0x0234:
            if (r7 == 0) goto L_0x023a
            float r1 = (float) r7
            float r2 = (float) r6
        L_0x0238:
            float r1 = r1 / r2
            goto L_0x023d
        L_0x023a:
            float r1 = (float) r4
            float r2 = (float) r3
            goto L_0x0238
        L_0x023d:
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 >= 0) goto L_0x0242
            goto L_0x0243
        L_0x0242:
            r0 = r1
        L_0x0243:
            boolean r1 = v(r15, r3, r6, r4, r7)
            if (r1 == 0) goto L_0x0270
            r5.preScale(r0, r0)
            goto L_0x0270
        L_0x024d:
            if (r4 != 0) goto L_0x0251
            if (r7 == 0) goto L_0x0270
        L_0x0251:
            if (r4 != r3) goto L_0x0255
            if (r7 == r6) goto L_0x0270
        L_0x0255:
            if (r4 == 0) goto L_0x025b
            float r0 = (float) r4
            float r1 = (float) r3
        L_0x0259:
            float r0 = r0 / r1
            goto L_0x025e
        L_0x025b:
            float r0 = (float) r7
            float r1 = (float) r6
            goto L_0x0259
        L_0x025e:
            if (r7 == 0) goto L_0x0264
            float r1 = (float) r7
            float r2 = (float) r6
        L_0x0262:
            float r1 = r1 / r2
            goto L_0x0267
        L_0x0264:
            float r1 = (float) r4
            float r2 = (float) r3
            goto L_0x0262
        L_0x0267:
            boolean r2 = v(r15, r3, r6, r4, r7)
            if (r2 == 0) goto L_0x0270
            r5.preScale(r0, r1)
        L_0x0270:
            r4 = r6
            r1 = 0
            r2 = 0
        L_0x0273:
            r6 = 1
            r0 = r28
            android.graphics.Bitmap r1 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)
            if (r1 == r0) goto L_0x0280
            r0.recycle()
            return r1
        L_0x0280:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.C1816c.y(com.squareup.picasso.v, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    static void z(v vVar) {
        String a5 = vVar.a();
        StringBuilder sb = (StringBuilder) f17210u.get();
        sb.ensureCapacity(a5.length() + 8);
        sb.replace(8, sb.length(), a5);
        Thread.currentThread().setName(sb.toString());
    }

    /* access modifiers changed from: package-private */
    public void b(C1814a aVar) {
        boolean z4 = this.f17214b.f17315m;
        v vVar = aVar.f17193b;
        if (this.f17223k == null) {
            this.f17223k = aVar;
            if (z4) {
                List list = this.f17224l;
                if (list == null || list.isEmpty()) {
                    C.u("Hunter", "joined", vVar.d(), "to empty hunter");
                } else {
                    C.u("Hunter", "joined", vVar.d(), C.l(this, "to "));
                }
            }
        } else {
            if (this.f17224l == null) {
                this.f17224l = new ArrayList(3);
            }
            this.f17224l.add(aVar);
            if (z4) {
                C.u("Hunter", "joined", vVar.d(), C.l(this, "to "));
            }
            s.f h4 = aVar.h();
            if (h4.ordinal() > this.f17231s.ordinal()) {
                this.f17231s = h4;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        List list;
        Future future;
        if (this.f17223k != null || (((list = this.f17224l) != null && !list.isEmpty()) || (future = this.f17226n) == null || !future.cancel(false))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void f(C1814a aVar) {
        boolean z4;
        if (this.f17223k == aVar) {
            this.f17223k = null;
            z4 = true;
        } else {
            List list = this.f17224l;
            if (list != null) {
                z4 = list.remove(aVar);
            } else {
                z4 = false;
            }
        }
        if (z4 && aVar.h() == this.f17231s) {
            this.f17231s = d();
        }
        if (this.f17214b.f17315m) {
            C.u("Hunter", "removed", aVar.f17193b.d(), C.l(this, "from "));
        }
    }

    /* access modifiers changed from: package-private */
    public C1814a h() {
        return this.f17223k;
    }

    /* access modifiers changed from: package-private */
    public List i() {
        return this.f17224l;
    }

    /* access modifiers changed from: package-private */
    public v j() {
        return this.f17219g;
    }

    /* access modifiers changed from: package-private */
    public Exception k() {
        return this.f17228p;
    }

    /* access modifiers changed from: package-private */
    public String n() {
        return this.f17218f;
    }

    /* access modifiers changed from: package-private */
    public s.e o() {
        return this.f17227o;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.f17220h;
    }

    /* access modifiers changed from: package-private */
    public s q() {
        return this.f17214b;
    }

    /* access modifiers changed from: package-private */
    public s.f r() {
        return this.f17231s;
    }

    public void run() {
        try {
            z(this.f17219g);
            if (this.f17214b.f17315m) {
                C.t("Hunter", "executing", C.k(this));
            }
            Bitmap t4 = t();
            this.f17225m = t4;
            if (t4 == null) {
                this.f17215c.e(this);
            } else {
                this.f17215c.d(this);
            }
            Thread.currentThread().setName("Picasso-Idle");
            return;
        } catch (q.b e5) {
            if (!p.a(e5.f17297b) || e5.f17296a != 504) {
                this.f17228p = e5;
            }
            this.f17215c.e(this);
        } catch (IOException e6) {
            this.f17228p = e6;
            this.f17215c.g(this);
        } catch (OutOfMemoryError e7) {
            StringWriter stringWriter = new StringWriter();
            this.f17217e.a().a(new PrintWriter(stringWriter));
            this.f17228p = new RuntimeException(stringWriter.toString(), e7);
            this.f17215c.e(this);
        } catch (Exception e8) {
            this.f17228p = e8;
            this.f17215c.e(this);
        } catch (Throwable th) {
            Thread.currentThread().setName("Picasso-Idle");
            throw th;
        }
        Thread.currentThread().setName("Picasso-Idle");
    }

    /* access modifiers changed from: package-private */
    public Bitmap s() {
        return this.f17225m;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cc A[Catch:{ all -> 0x00a7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap t() {
        /*
            r6 = this;
            int r0 = r6.f17220h
            boolean r0 = com.squareup.picasso.o.a(r0)
            if (r0 == 0) goto L_0x0031
            H1.a r0 = r6.f17216d
            java.lang.String r1 = r6.f17218f
            android.graphics.Bitmap r0 = r0.get(r1)
            if (r0 == 0) goto L_0x0032
            com.squareup.picasso.z r1 = r6.f17217e
            r1.d()
            com.squareup.picasso.s$e r1 = com.squareup.picasso.s.e.MEMORY
            r6.f17227o = r1
            com.squareup.picasso.s r1 = r6.f17214b
            boolean r1 = r1.f17315m
            if (r1 == 0) goto L_0x0030
            java.lang.String r1 = "Hunter"
            java.lang.String r2 = "decoded"
            com.squareup.picasso.v r3 = r6.f17219g
            java.lang.String r3 = r3.d()
            java.lang.String r4 = "from cache"
            com.squareup.picasso.C.u(r1, r2, r3, r4)
        L_0x0030:
            return r0
        L_0x0031:
            r0 = 0
        L_0x0032:
            int r1 = r6.f17230r
            if (r1 != 0) goto L_0x003b
            com.squareup.picasso.p r1 = com.squareup.picasso.p.OFFLINE
            int r1 = r1.f17293a
            goto L_0x003d
        L_0x003b:
            int r1 = r6.f17221i
        L_0x003d:
            r6.f17221i = r1
            com.squareup.picasso.x r2 = r6.f17222j
            com.squareup.picasso.v r3 = r6.f17219g
            com.squareup.picasso.x$a r1 = r2.f(r3, r1)
            if (r1 == 0) goto L_0x0071
            com.squareup.picasso.s$e r0 = r1.c()
            r6.f17227o = r0
            int r0 = r1.b()
            r6.f17229q = r0
            android.graphics.Bitmap r0 = r1.a()
            if (r0 != 0) goto L_0x0071
            N3.Z r0 = r1.d()
            com.squareup.picasso.v r1 = r6.f17219g     // Catch:{ all -> 0x006c }
            android.graphics.Bitmap r1 = e(r0, r1)     // Catch:{ all -> 0x006c }
            r0.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x006a
        L_0x0069:
        L_0x006a:
            r0 = r1
            goto L_0x0071
        L_0x006c:
            r1 = move-exception
            r0.close()     // Catch:{ IOException -> 0x0070 }
        L_0x0070:
            throw r1
        L_0x0071:
            if (r0 == 0) goto L_0x00f4
            com.squareup.picasso.s r1 = r6.f17214b
            boolean r1 = r1.f17315m
            if (r1 == 0) goto L_0x0086
            java.lang.String r1 = "Hunter"
            java.lang.String r2 = "decoded"
            com.squareup.picasso.v r3 = r6.f17219g
            java.lang.String r3 = r3.d()
            com.squareup.picasso.C.t(r1, r2, r3)
        L_0x0086:
            com.squareup.picasso.z r1 = r6.f17217e
            r1.b(r0)
            com.squareup.picasso.v r1 = r6.f17219g
            boolean r1 = r1.f()
            if (r1 != 0) goto L_0x0097
            int r1 = r6.f17229q
            if (r1 == 0) goto L_0x00f4
        L_0x0097:
            java.lang.Object r1 = f17209t
            monitor-enter(r1)
            com.squareup.picasso.v r2 = r6.f17219g     // Catch:{ all -> 0x00a7 }
            boolean r2 = r2.e()     // Catch:{ all -> 0x00a7 }
            if (r2 != 0) goto L_0x00a9
            int r2 = r6.f17229q     // Catch:{ all -> 0x00a7 }
            if (r2 == 0) goto L_0x00c4
            goto L_0x00a9
        L_0x00a7:
            r0 = move-exception
            goto L_0x00f2
        L_0x00a9:
            com.squareup.picasso.v r2 = r6.f17219g     // Catch:{ all -> 0x00a7 }
            int r3 = r6.f17229q     // Catch:{ all -> 0x00a7 }
            android.graphics.Bitmap r0 = y(r2, r0, r3)     // Catch:{ all -> 0x00a7 }
            com.squareup.picasso.s r2 = r6.f17214b     // Catch:{ all -> 0x00a7 }
            boolean r2 = r2.f17315m     // Catch:{ all -> 0x00a7 }
            if (r2 == 0) goto L_0x00c4
            java.lang.String r2 = "Hunter"
            java.lang.String r3 = "transformed"
            com.squareup.picasso.v r4 = r6.f17219g     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = r4.d()     // Catch:{ all -> 0x00a7 }
            com.squareup.picasso.C.t(r2, r3, r4)     // Catch:{ all -> 0x00a7 }
        L_0x00c4:
            com.squareup.picasso.v r2 = r6.f17219g     // Catch:{ all -> 0x00a7 }
            boolean r2 = r2.b()     // Catch:{ all -> 0x00a7 }
            if (r2 == 0) goto L_0x00e9
            com.squareup.picasso.v r2 = r6.f17219g     // Catch:{ all -> 0x00a7 }
            java.util.List r2 = r2.f17356g     // Catch:{ all -> 0x00a7 }
            android.graphics.Bitmap r0 = a(r2, r0)     // Catch:{ all -> 0x00a7 }
            com.squareup.picasso.s r2 = r6.f17214b     // Catch:{ all -> 0x00a7 }
            boolean r2 = r2.f17315m     // Catch:{ all -> 0x00a7 }
            if (r2 == 0) goto L_0x00e9
            java.lang.String r2 = "Hunter"
            java.lang.String r3 = "transformed"
            com.squareup.picasso.v r4 = r6.f17219g     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = r4.d()     // Catch:{ all -> 0x00a7 }
            java.lang.String r5 = "from custom transformations"
            com.squareup.picasso.C.u(r2, r3, r4, r5)     // Catch:{ all -> 0x00a7 }
        L_0x00e9:
            monitor-exit(r1)     // Catch:{ all -> 0x00a7 }
            if (r0 == 0) goto L_0x00f4
            com.squareup.picasso.z r1 = r6.f17217e
            r1.c(r0)
            goto L_0x00f4
        L_0x00f2:
            monitor-exit(r1)     // Catch:{ all -> 0x00a7 }
            throw r0
        L_0x00f4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.C1816c.t():android.graphics.Bitmap");
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        Future future = this.f17226n;
        if (future == null || !future.isCancelled()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean w(boolean z4, NetworkInfo networkInfo) {
        int i4 = this.f17230r;
        if (i4 <= 0) {
            return false;
        }
        this.f17230r = i4 - 1;
        return this.f17222j.h(z4, networkInfo);
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        return this.f17222j.i();
    }
}
