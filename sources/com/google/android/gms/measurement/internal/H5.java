package com.google.android.gms.measurement.internal;

import M.C0335p;
import R.d;
import R.e;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.collection.ArrayMap;
import androidx.work.WorkRequest;
import com.google.android.gms.internal.measurement.B4;
import com.google.android.gms.internal.measurement.C0526c1;
import com.google.android.gms.internal.measurement.C0554f2;
import com.google.android.gms.internal.measurement.C0576h6;
import com.google.android.gms.internal.measurement.C0597k0;
import com.google.android.gms.internal.measurement.C0599k2;
import com.google.android.gms.internal.measurement.C0604k7;
import com.google.android.gms.internal.measurement.C0617m2;
import com.google.android.gms.internal.measurement.C0635o2;
import com.google.android.gms.internal.measurement.C0643p2;
import com.google.android.gms.internal.measurement.C0668s4;
import com.google.android.gms.internal.measurement.C0674t2;
import com.google.android.gms.internal.measurement.T1;
import com.google.android.gms.internal.measurement.Y6;
import com.google.android.gms.measurement.internal.A3;
import com.mbridge.msdk.MBridgeConstans;
import f0.p;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class H5 implements C0898y3 {

    /* renamed from: H  reason: collision with root package name */
    private static volatile H5 f2529H;

    /* renamed from: A  reason: collision with root package name */
    private long f2530A;

    /* renamed from: B  reason: collision with root package name */
    private final Map f2531B;

    /* renamed from: C  reason: collision with root package name */
    private final Map f2532C;

    /* renamed from: D  reason: collision with root package name */
    private final Map f2533D;

    /* renamed from: E  reason: collision with root package name */
    private C0892x4 f2534E;

    /* renamed from: F  reason: collision with root package name */
    private String f2535F;

    /* renamed from: G  reason: collision with root package name */
    private final c6 f2536G;

    /* renamed from: a  reason: collision with root package name */
    private I2 f2537a;

    /* renamed from: b  reason: collision with root package name */
    private C0842q2 f2538b;

    /* renamed from: c  reason: collision with root package name */
    private C0797k f2539c;

    /* renamed from: d  reason: collision with root package name */
    private C0883w2 f2540d;

    /* renamed from: e  reason: collision with root package name */
    private D5 f2541e;

    /* renamed from: f  reason: collision with root package name */
    private h6 f2542f;

    /* renamed from: g  reason: collision with root package name */
    private final Z5 f2543g;

    /* renamed from: h  reason: collision with root package name */
    private C0878v4 f2544h;

    /* renamed from: i  reason: collision with root package name */
    private C0796j5 f2545i;

    /* renamed from: j  reason: collision with root package name */
    private final G5 f2546j;

    /* renamed from: k  reason: collision with root package name */
    private E2 f2547k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final S2 f2548l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f2549m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f2550n;

    /* renamed from: o  reason: collision with root package name */
    private long f2551o;

    /* renamed from: p  reason: collision with root package name */
    private List f2552p;

    /* renamed from: q  reason: collision with root package name */
    private final Set f2553q;

    /* renamed from: r  reason: collision with root package name */
    private int f2554r;

    /* renamed from: s  reason: collision with root package name */
    private int f2555s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f2556t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f2557u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f2558v;

    /* renamed from: w  reason: collision with root package name */
    private FileLock f2559w;

    /* renamed from: x  reason: collision with root package name */
    private FileChannel f2560x;

    /* renamed from: y  reason: collision with root package name */
    private List f2561y;

    /* renamed from: z  reason: collision with root package name */
    private List f2562z;

    private class a implements C0839q {

        /* renamed from: a  reason: collision with root package name */
        C0643p2 f2563a;

        /* renamed from: b  reason: collision with root package name */
        List f2564b;

        /* renamed from: c  reason: collision with root package name */
        List f2565c;

        /* renamed from: d  reason: collision with root package name */
        private long f2566d;

        private static long c(C0599k2 k2Var) {
            return ((k2Var.R() / 1000) / 60) / 60;
        }

        public final boolean a(long j4, C0599k2 k2Var) {
            C0335p.l(k2Var);
            if (this.f2565c == null) {
                this.f2565c = new ArrayList();
            }
            if (this.f2564b == null) {
                this.f2564b = new ArrayList();
            }
            if (!this.f2565c.isEmpty() && c((C0599k2) this.f2565c.get(0)) != c(k2Var)) {
                return false;
            }
            long d5 = this.f2566d + ((long) k2Var.d());
            H5.this.i0();
            if (d5 >= ((long) Math.max(0, ((Integer) G.f2483j.a((Object) null)).intValue()))) {
                return false;
            }
            this.f2566d = d5;
            this.f2565c.add(k2Var);
            this.f2564b.add(Long.valueOf(j4));
            int size = this.f2565c.size();
            H5.this.i0();
            if (size >= Math.max(1, ((Integer) G.f2486k.a((Object) null)).intValue())) {
                return false;
            }
            return true;
        }

        public final void b(C0643p2 p2Var) {
            C0335p.l(p2Var);
            this.f2563a = p2Var;
        }

        private a() {
        }
    }

    private H5(W5 w5) {
        this(w5, (S2) null);
    }

    private final void D(String str, C0617m2.a aVar, Bundle bundle, String str2) {
        int u4;
        List b5 = e.b("_o", "_sn", "_sc", "_si");
        if (d6.J0(aVar.E()) || d6.J0(str)) {
            u4 = i0().u(str2, true);
        } else {
            u4 = i0().o(str2, true);
        }
        long j4 = (long) u4;
        long codePointCount = (long) aVar.F().codePointCount(0, aVar.F().length());
        y0();
        String E4 = aVar.E();
        i0();
        String J4 = d6.J(E4, 40, true);
        if (codePointCount > j4 && !b5.contains(aVar.E())) {
            if ("_ev".equals(aVar.E())) {
                y0();
                bundle.putString("_ev", d6.J(aVar.F(), i0().u(str2, true), true));
                return;
            }
            a().M().c("Param value is too long; discarded. Name, value length", J4, Long.valueOf(codePointCount));
            if (bundle.getLong("_err") == 0) {
                bundle.putLong("_err", 4);
                if (bundle.getString("_ev") == null) {
                    bundle.putString("_ev", J4);
                    bundle.putLong("_el", codePointCount);
                }
            }
            bundle.remove(aVar.E());
        }
    }

    private final void F(String str, A3 a32) {
        f().k();
        A0();
        this.f2531B.put(str, a32);
        l0().E0(str, a32);
    }

    private final long F0() {
        long currentTimeMillis = B().currentTimeMillis();
        C0796j5 j5Var = this.f2545i;
        j5Var.r();
        j5Var.k();
        long a5 = j5Var.f3057j.a();
        if (a5 == 0) {
            a5 = ((long) j5Var.g().W0().nextInt(86400000)) + 1;
            j5Var.f3057j.b(a5);
        }
        return ((((currentTimeMillis + a5) / 1000) / 60) / 60) / 24;
    }

    private final C0883w2 G0() {
        C0883w2 w2Var = this.f2540d;
        if (w2Var != null) {
            return w2Var;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final D5 H0() {
        return (D5) i(this.f2541e);
    }

    private final void I(String str, boolean z4, Long l4, Long l5) {
        C0744c2 M02 = l0().M0(str);
        if (M02 != null) {
            M02.T(z4);
            M02.e(l4);
            M02.I(l5);
            if (M02.B()) {
                l0().V(M02, false, false);
            }
        }
    }

    private final void J(List list) {
        C0335p.a(!list.isEmpty());
        if (this.f2561y != null) {
            a().G().a("Set uploading progress before finishing the previous upload");
        } else {
            this.f2561y = new ArrayList(list);
        }
    }

    private final boolean M(int i4, FileChannel fileChannel) {
        f().k();
        if (fileChannel == null || !fileChannel.isOpen()) {
            a().G().a("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i4);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                a().G().b("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e5) {
            a().G().b("Failed to write to channel", e5);
            return false;
        }
    }

    private final boolean N(C0599k2.a aVar, C0599k2.a aVar2) {
        String str;
        C0335p.a("_e".equals(aVar.H()));
        x0();
        C0617m2 F4 = Z5.F((C0599k2) ((C0668s4) aVar.m()), "_sc");
        String str2 = null;
        if (F4 == null) {
            str = null;
        } else {
            str = F4.X();
        }
        x0();
        C0617m2 F5 = Z5.F((C0599k2) ((C0668s4) aVar2.m()), "_pc");
        if (F5 != null) {
            str2 = F5.X();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        C0335p.a("_e".equals(aVar.H()));
        x0();
        C0617m2 F6 = Z5.F((C0599k2) ((C0668s4) aVar.m()), "_et");
        if (F6 == null || !F6.b0() || F6.S() <= 0) {
            return true;
        }
        long S4 = F6.S();
        x0();
        C0617m2 F7 = Z5.F((C0599k2) ((C0668s4) aVar2.m()), "_et");
        if (F7 != null && F7.S() > 0) {
            S4 += F7.S();
        }
        x0();
        Z5.T(aVar2, "_et", Long.valueOf(S4));
        x0();
        Z5.T(aVar, "_fr", 1L);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0200, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0201, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0204, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00aa, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:592:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:11:0x0038, B:42:0x00a5] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0200 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0220 A[SYNTHETIC, Splitter:B:113:0x0220] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0227 A[Catch:{ IOException -> 0x01ea, all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045 A[Catch:{ SQLiteException -> 0x0048, all -> 0x0045 }, ExcHandler: all (th java.lang.Throwable), Splitter:B:11:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x03b5 A[SYNTHETIC, Splitter:B:169:0x03b5] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0452 A[Catch:{ IOException -> 0x01ea, all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x04b5 A[Catch:{ IOException -> 0x01ea, all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x04b9 A[Catch:{ IOException -> 0x01ea, all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x051f A[Catch:{ IOException -> 0x01ea, all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0552 A[Catch:{ IOException -> 0x01ea, all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0571 A[Catch:{ IOException -> 0x01ea, all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x065e A[Catch:{ IOException -> 0x01ea, all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x06a1 A[Catch:{ IOException -> 0x01ea, all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x06fa A[Catch:{ IOException -> 0x01ea, all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0811 A[Catch:{ IOException -> 0x01ea, all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:551:0x1047 A[Catch:{ IOException -> 0x01ea, all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:552:0x104b A[Catch:{ IOException -> 0x01ea, all -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:591:0x1164 A[SYNTHETIC, Splitter:B:591:0x1164] */
    /* JADX WARNING: Removed duplicated region for block: B:602:0x0419 A[EDGE_INSN: B:602:0x0419->B:178:0x0419 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean O(java.lang.String r44, long r45) {
        /*
            r43 = this;
            r1 = r43
            java.lang.String r2 = "_ai"
            java.lang.String r3 = "items"
            com.google.android.gms.measurement.internal.k r0 = r1.l0()
            r0.c1()
            com.google.android.gms.measurement.internal.H5$a r4 = new com.google.android.gms.measurement.internal.H5$a     // Catch:{ all -> 0x007e }
            r5 = 0
            r4.<init>()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.k r6 = r1.l0()     // Catch:{ all -> 0x007e }
            long r7 = r1.f2530A     // Catch:{ all -> 0x007e }
            M.C0335p.l(r4)     // Catch:{ all -> 0x007e }
            r6.k()     // Catch:{ all -> 0x007e }
            r6.r()     // Catch:{ all -> 0x007e }
            r10 = -1
            r12 = 1
            r13 = 0
            android.database.sqlite.SQLiteDatabase r14 = r6.y()     // Catch:{ SQLiteException -> 0x0207, all -> 0x0200 }
            boolean r0 = android.text.TextUtils.isEmpty(r44)     // Catch:{ SQLiteException -> 0x0207, all -> 0x0200 }
            java.lang.String r15 = ""
            if (r0 == 0) goto L_0x0099
            int r0 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x004e
            r23 = r10
            java.lang.String r10 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x0048, all -> 0x0045 }
            java.lang.String r11 = java.lang.String.valueOf(r45)     // Catch:{ SQLiteException -> 0x0048, all -> 0x0045 }
            java.lang.String[] r10 = new java.lang.String[]{r10, r11}     // Catch:{ SQLiteException -> 0x0048, all -> 0x0045 }
            goto L_0x0058
        L_0x0045:
            r0 = move-exception
            goto L_0x1162
        L_0x0048:
            r0 = move-exception
            r11 = r44
        L_0x004b:
            r10 = r5
            goto L_0x020d
        L_0x004e:
            r23 = r10
            java.lang.String r10 = java.lang.String.valueOf(r45)     // Catch:{ SQLiteException -> 0x0048, all -> 0x0045 }
            java.lang.String[] r10 = new java.lang.String[]{r10}     // Catch:{ SQLiteException -> 0x0048, all -> 0x0045 }
        L_0x0058:
            if (r0 == 0) goto L_0x005c
            java.lang.String r15 = "rowid <= ? and "
        L_0x005c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0048, all -> 0x0045 }
            java.lang.String r11 = "select app_id, metadata_fingerprint from raw_events where "
            r0.<init>(r11)     // Catch:{ SQLiteException -> 0x0048, all -> 0x0045 }
            r0.append(r15)     // Catch:{ SQLiteException -> 0x0048, all -> 0x0045 }
            java.lang.String r11 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r0.append(r11)     // Catch:{ SQLiteException -> 0x0048, all -> 0x0045 }
            java.lang.String r0 = r0.toString()     // Catch:{ SQLiteException -> 0x0048, all -> 0x0045 }
            android.database.Cursor r10 = r14.rawQuery(r0, r10)     // Catch:{ SQLiteException -> 0x0048, all -> 0x0045 }
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0094 }
            if (r0 != 0) goto L_0x0081
            r10.close()     // Catch:{ all -> 0x007e }
            goto L_0x0223
        L_0x007e:
            r0 = move-exception
            goto L_0x1168
        L_0x0081:
            java.lang.String r11 = r10.getString(r13)     // Catch:{ SQLiteException -> 0x0094 }
            java.lang.String r0 = r10.getString(r12)     // Catch:{ SQLiteException -> 0x0091 }
            r10.close()     // Catch:{ SQLiteException -> 0x0091 }
            goto L_0x00df
        L_0x008d:
            r0 = move-exception
            r5 = r10
            goto L_0x1162
        L_0x0091:
            r0 = move-exception
            goto L_0x020d
        L_0x0094:
            r0 = move-exception
            r11 = r44
            goto L_0x020d
        L_0x0099:
            r23 = r10
            int r0 = (r7 > r23 ? 1 : (r7 == r23 ? 0 : -1))
            if (r0 == 0) goto L_0x00ac
            java.lang.String r10 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x0048, all -> 0x0045 }
            r11 = r44
            java.lang.String[] r10 = new java.lang.String[]{r11, r10}     // Catch:{ SQLiteException -> 0x00aa, all -> 0x0045 }
            goto L_0x00b2
        L_0x00aa:
            r0 = move-exception
            goto L_0x004b
        L_0x00ac:
            r11 = r44
            java.lang.String[] r10 = new java.lang.String[]{r11}     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
        L_0x00b2:
            if (r0 == 0) goto L_0x00b6
            java.lang.String r15 = " and rowid <= ?"
        L_0x00b6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            java.lang.String r5 = "select metadata_fingerprint from raw_events where app_id = ?"
            r0.<init>(r5)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            r0.append(r15)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            java.lang.String r5 = " order by rowid limit 1;"
            r0.append(r5)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            java.lang.String r0 = r0.toString()     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            android.database.Cursor r10 = r14.rawQuery(r0, r10)     // Catch:{ SQLiteException -> 0x0204, all -> 0x0200 }
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0091 }
            if (r0 != 0) goto L_0x00d8
            r10.close()     // Catch:{ all -> 0x007e }
            goto L_0x0223
        L_0x00d8:
            java.lang.String r0 = r10.getString(r13)     // Catch:{ SQLiteException -> 0x0091 }
            r10.close()     // Catch:{ SQLiteException -> 0x0091 }
        L_0x00df:
            java.lang.String r15 = "raw_events_metadata"
            java.lang.String r5 = "metadata"
            java.lang.String[] r16 = new java.lang.String[]{r5}     // Catch:{ SQLiteException -> 0x0091 }
            java.lang.String r17 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r18 = new java.lang.String[]{r11, r0}     // Catch:{ SQLiteException -> 0x0091 }
            java.lang.String r21 = "rowid"
            java.lang.String r22 = "2"
            r19 = 0
            r20 = 0
            android.database.Cursor r10 = r14.query(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ SQLiteException -> 0x0091 }
            boolean r5 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0091 }
            if (r5 != 0) goto L_0x0115
            com.google.android.gms.measurement.internal.n2 r0 = r6.a()     // Catch:{ SQLiteException -> 0x0091 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()     // Catch:{ SQLiteException -> 0x0091 }
            java.lang.String r5 = "Raw event metadata record is missing. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C0821n2.s(r11)     // Catch:{ SQLiteException -> 0x0091 }
            r0.b(r5, r7)     // Catch:{ SQLiteException -> 0x0091 }
            r10.close()     // Catch:{ all -> 0x007e }
            goto L_0x0223
        L_0x0115:
            byte[] r5 = r10.getBlob(r13)     // Catch:{ SQLiteException -> 0x0091 }
            com.google.android.gms.internal.measurement.p2$a r15 = com.google.android.gms.internal.measurement.C0643p2.u2()     // Catch:{ IOException -> 0x01ea }
            com.google.android.gms.internal.measurement.Y4 r5 = com.google.android.gms.measurement.internal.Z5.G(r15, r5)     // Catch:{ IOException -> 0x01ea }
            com.google.android.gms.internal.measurement.p2$a r5 = (com.google.android.gms.internal.measurement.C0643p2.a) r5     // Catch:{ IOException -> 0x01ea }
            com.google.android.gms.internal.measurement.Z4 r5 = r5.m()     // Catch:{ IOException -> 0x01ea }
            com.google.android.gms.internal.measurement.s4 r5 = (com.google.android.gms.internal.measurement.C0668s4) r5     // Catch:{ IOException -> 0x01ea }
            com.google.android.gms.internal.measurement.p2 r5 = (com.google.android.gms.internal.measurement.C0643p2) r5     // Catch:{ IOException -> 0x01ea }
            boolean r15 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0091 }
            if (r15 == 0) goto L_0x0142
            com.google.android.gms.measurement.internal.n2 r15 = r6.a()     // Catch:{ SQLiteException -> 0x0091 }
            com.google.android.gms.measurement.internal.p2 r15 = r15.L()     // Catch:{ SQLiteException -> 0x0091 }
            java.lang.String r12 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.C0821n2.s(r11)     // Catch:{ SQLiteException -> 0x0091 }
            r15.b(r12, r9)     // Catch:{ SQLiteException -> 0x0091 }
        L_0x0142:
            r10.close()     // Catch:{ SQLiteException -> 0x0091 }
            r4.b(r5)     // Catch:{ SQLiteException -> 0x0091 }
            int r5 = (r7 > r23 ? 1 : (r7 == r23 ? 0 : -1))
            if (r5 == 0) goto L_0x015b
            java.lang.String r5 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ SQLiteException -> 0x0091 }
            java.lang.String[] r0 = new java.lang.String[]{r11, r0, r7}     // Catch:{ SQLiteException -> 0x0091 }
        L_0x0156:
            r18 = r0
            r17 = r5
            goto L_0x0162
        L_0x015b:
            java.lang.String r5 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r0 = new java.lang.String[]{r11, r0}     // Catch:{ SQLiteException -> 0x0091 }
            goto L_0x0156
        L_0x0162:
            java.lang.String r15 = "raw_events"
            java.lang.String r0 = "rowid"
            java.lang.String r5 = "name"
            java.lang.String r7 = "timestamp"
            java.lang.String r8 = "data"
            java.lang.String[] r16 = new java.lang.String[]{r0, r5, r7, r8}     // Catch:{ SQLiteException -> 0x0091 }
            java.lang.String r21 = "rowid"
            r22 = 0
            r19 = 0
            r20 = 0
            android.database.Cursor r10 = r14.query(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ SQLiteException -> 0x0091 }
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0091 }
            if (r0 != 0) goto L_0x0198
            com.google.android.gms.measurement.internal.n2 r0 = r6.a()     // Catch:{ SQLiteException -> 0x0091 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.L()     // Catch:{ SQLiteException -> 0x0091 }
            java.lang.String r5 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C0821n2.s(r11)     // Catch:{ SQLiteException -> 0x0091 }
            r0.b(r5, r7)     // Catch:{ SQLiteException -> 0x0091 }
            r10.close()     // Catch:{ all -> 0x007e }
            goto L_0x0223
        L_0x0198:
            long r7 = r10.getLong(r13)     // Catch:{ SQLiteException -> 0x0091 }
            r5 = 3
            byte[] r0 = r10.getBlob(r5)     // Catch:{ SQLiteException -> 0x0091 }
            com.google.android.gms.internal.measurement.k2$a r5 = com.google.android.gms.internal.measurement.C0599k2.S()     // Catch:{ IOException -> 0x01ce }
            com.google.android.gms.internal.measurement.Y4 r0 = com.google.android.gms.measurement.internal.Z5.G(r5, r0)     // Catch:{ IOException -> 0x01ce }
            com.google.android.gms.internal.measurement.k2$a r0 = (com.google.android.gms.internal.measurement.C0599k2.a) r0     // Catch:{ IOException -> 0x01ce }
            r5 = 1
            java.lang.String r9 = r10.getString(r5)     // Catch:{ SQLiteException -> 0x0091 }
            com.google.android.gms.internal.measurement.k2$a r5 = r0.B(r9)     // Catch:{ SQLiteException -> 0x0091 }
            r9 = 2
            long r14 = r10.getLong(r9)     // Catch:{ SQLiteException -> 0x0091 }
            r5.D(r14)     // Catch:{ SQLiteException -> 0x0091 }
            com.google.android.gms.internal.measurement.Z4 r0 = r0.m()     // Catch:{ SQLiteException -> 0x0091 }
            com.google.android.gms.internal.measurement.s4 r0 = (com.google.android.gms.internal.measurement.C0668s4) r0     // Catch:{ SQLiteException -> 0x0091 }
            com.google.android.gms.internal.measurement.k2 r0 = (com.google.android.gms.internal.measurement.C0599k2) r0     // Catch:{ SQLiteException -> 0x0091 }
            boolean r0 = r4.a(r7, r0)     // Catch:{ SQLiteException -> 0x0091 }
            if (r0 != 0) goto L_0x01e0
            r10.close()     // Catch:{ all -> 0x007e }
            goto L_0x0223
        L_0x01ce:
            r0 = move-exception
            com.google.android.gms.measurement.internal.n2 r5 = r6.a()     // Catch:{ SQLiteException -> 0x0091 }
            com.google.android.gms.measurement.internal.p2 r5 = r5.G()     // Catch:{ SQLiteException -> 0x0091 }
            java.lang.String r7 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.C0821n2.s(r11)     // Catch:{ SQLiteException -> 0x0091 }
            r5.c(r7, r8, r0)     // Catch:{ SQLiteException -> 0x0091 }
        L_0x01e0:
            boolean r0 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0091 }
            if (r0 != 0) goto L_0x0198
            r10.close()     // Catch:{ all -> 0x007e }
            goto L_0x0223
        L_0x01ea:
            r0 = move-exception
            com.google.android.gms.measurement.internal.n2 r5 = r6.a()     // Catch:{ SQLiteException -> 0x0091 }
            com.google.android.gms.measurement.internal.p2 r5 = r5.G()     // Catch:{ SQLiteException -> 0x0091 }
            java.lang.String r7 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.C0821n2.s(r11)     // Catch:{ SQLiteException -> 0x0091 }
            r5.c(r7, r8, r0)     // Catch:{ SQLiteException -> 0x0091 }
            r10.close()     // Catch:{ all -> 0x007e }
            goto L_0x0223
        L_0x0200:
            r0 = move-exception
            r5 = 0
            goto L_0x1162
        L_0x0204:
            r0 = move-exception
        L_0x0205:
            r10 = 0
            goto L_0x020d
        L_0x0207:
            r0 = move-exception
            r23 = r10
            r11 = r44
            goto L_0x0205
        L_0x020d:
            com.google.android.gms.measurement.internal.n2 r5 = r6.a()     // Catch:{ all -> 0x008d }
            com.google.android.gms.measurement.internal.p2 r5 = r5.G()     // Catch:{ all -> 0x008d }
            java.lang.String r6 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C0821n2.s(r11)     // Catch:{ all -> 0x008d }
            r5.c(r6, r7, r0)     // Catch:{ all -> 0x008d }
            if (r10 == 0) goto L_0x0223
            r10.close()     // Catch:{ all -> 0x007e }
        L_0x0223:
            java.util.List r0 = r4.f2565c     // Catch:{ all -> 0x007e }
            if (r0 == 0) goto L_0x1151
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x007e }
            if (r0 == 0) goto L_0x022f
            goto L_0x1151
        L_0x022f:
            com.google.android.gms.internal.measurement.p2 r0 = r4.f2563a     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4$b r0 = r0.y()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2$a r0 = (com.google.android.gms.internal.measurement.C0643p2.a) r0     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2$a r0 = r0.I0()     // Catch:{ all -> 0x007e }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
        L_0x0242:
            java.util.List r14 = r4.f2565c     // Catch:{ all -> 0x007e }
            int r14 = r14.size()     // Catch:{ all -> 0x007e }
            java.lang.String r15 = "_et"
            java.lang.String r13 = "_fr"
            java.lang.String r5 = "_e"
            r45 = r6
            java.lang.String r6 = "_c"
            r17 = r9
            r46 = r10
            if (r8 >= r14) goto L_0x0834
            java.util.List r14 = r4.f2565c     // Catch:{ all -> 0x007e }
            java.lang.Object r14 = r14.get(r8)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2 r14 = (com.google.android.gms.internal.measurement.C0599k2) r14     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4$b r14 = r14.y()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2$a r14 = (com.google.android.gms.internal.measurement.C0599k2.a) r14     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.I2 r9 = r1.r0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r10 = r4.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r10 = r10.x2()     // Catch:{ all -> 0x007e }
            r20 = r7
            java.lang.String r7 = r14.H()     // Catch:{ all -> 0x007e }
            boolean r7 = r9.P(r10, r7)     // Catch:{ all -> 0x007e }
            java.lang.String r9 = "_err"
            if (r7 == 0) goto L_0x02f6
            com.google.android.gms.measurement.internal.n2 r5 = r1.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r5 = r5.L()     // Catch:{ all -> 0x007e }
            java.lang.String r6 = "Dropping blocked raw event. appId"
            com.google.android.gms.internal.measurement.p2 r7 = r4.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r7 = r7.x2()     // Catch:{ all -> 0x007e }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C0821n2.s(r7)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.S2 r10 = r1.f2548l     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.h2 r10 = r10.D()     // Catch:{ all -> 0x007e }
            java.lang.String r13 = r14.H()     // Catch:{ all -> 0x007e }
            java.lang.String r10 = r10.c(r13)     // Catch:{ all -> 0x007e }
            r5.c(r6, r7, r10)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.I2 r5 = r1.r0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r6 = r4.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r6 = r6.x2()     // Catch:{ all -> 0x007e }
            boolean r5 = r5.X(r6)     // Catch:{ all -> 0x007e }
            if (r5 != 0) goto L_0x02e8
            com.google.android.gms.measurement.internal.I2 r5 = r1.r0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r6 = r4.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r6 = r6.x2()     // Catch:{ all -> 0x007e }
            boolean r5 = r5.Z(r6)     // Catch:{ all -> 0x007e }
            if (r5 == 0) goto L_0x02c4
            goto L_0x02e8
        L_0x02c4:
            java.lang.String r5 = r14.H()     // Catch:{ all -> 0x007e }
            boolean r5 = r9.equals(r5)     // Catch:{ all -> 0x007e }
            if (r5 != 0) goto L_0x02e8
            r1.y0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.c6 r5 = r1.f2536G     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r6 = r4.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r28 = r6.x2()     // Catch:{ all -> 0x007e }
            java.lang.String r30 = "_ev"
            java.lang.String r31 = r14.H()     // Catch:{ all -> 0x007e }
            r32 = 0
            r29 = 11
            r27 = r5
            com.google.android.gms.measurement.internal.d6.Z(r27, r28, r29, r30, r31, r32)     // Catch:{ all -> 0x007e }
        L_0x02e8:
            r10 = r46
            r22 = r2
            r13 = r8
            r8 = r4
        L_0x02ee:
            r6 = r45
            r9 = r17
            r7 = r20
            goto L_0x082b
        L_0x02f6:
            java.lang.String r7 = r14.H()     // Catch:{ all -> 0x007e }
            java.lang.String r10 = f0.q.a(r2)     // Catch:{ all -> 0x007e }
            boolean r7 = r7.equals(r10)     // Catch:{ all -> 0x007e }
            if (r7 == 0) goto L_0x0368
            r14.B(r2)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.n2 r7 = r1.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r7 = r7.K()     // Catch:{ all -> 0x007e }
            java.lang.String r10 = "Renaming ad_impression to _ai"
            r7.a(r10)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.n2 r7 = r1.a()     // Catch:{ all -> 0x007e }
            r10 = 5
            boolean r7 = r7.z(r10)     // Catch:{ all -> 0x007e }
            if (r7 == 0) goto L_0x0368
            r7 = 0
        L_0x0320:
            int r10 = r14.q()     // Catch:{ all -> 0x007e }
            if (r7 >= r10) goto L_0x0368
            java.lang.String r10 = "ad_platform"
            com.google.android.gms.internal.measurement.m2 r21 = r14.E(r7)     // Catch:{ all -> 0x007e }
            r22 = r2
            java.lang.String r2 = r21.W()     // Catch:{ all -> 0x007e }
            boolean r2 = r10.equals(r2)     // Catch:{ all -> 0x007e }
            if (r2 == 0) goto L_0x0363
            com.google.android.gms.internal.measurement.m2 r2 = r14.E(r7)     // Catch:{ all -> 0x007e }
            java.lang.String r2 = r2.X()     // Catch:{ all -> 0x007e }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x007e }
            if (r2 != 0) goto L_0x0363
            java.lang.String r2 = "admob"
            com.google.android.gms.internal.measurement.m2 r10 = r14.E(r7)     // Catch:{ all -> 0x007e }
            java.lang.String r10 = r10.X()     // Catch:{ all -> 0x007e }
            boolean r2 = r2.equalsIgnoreCase(r10)     // Catch:{ all -> 0x007e }
            if (r2 == 0) goto L_0x0363
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.M()     // Catch:{ all -> 0x007e }
            java.lang.String r10 = "AdMob ad impression logged from app. Potentially duplicative."
            r2.a(r10)     // Catch:{ all -> 0x007e }
        L_0x0363:
            int r7 = r7 + 1
            r2 = r22
            goto L_0x0320
        L_0x0368:
            r22 = r2
            com.google.android.gms.measurement.internal.I2 r2 = r1.r0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r7 = r4.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r7 = r7.x2()     // Catch:{ all -> 0x007e }
            java.lang.String r10 = r14.H()     // Catch:{ all -> 0x007e }
            boolean r2 = r2.N(r7, r10)     // Catch:{ all -> 0x007e }
            if (r2 != 0) goto L_0x03a5
            r1.x0()     // Catch:{ all -> 0x007e }
            java.lang.String r7 = r14.H()     // Catch:{ all -> 0x007e }
            M.C0335p.f(r7)     // Catch:{ all -> 0x007e }
            int r10 = r7.hashCode()     // Catch:{ all -> 0x007e }
            r21 = r2
            r2 = 95027(0x17333, float:1.33161E-40)
            if (r10 == r2) goto L_0x0394
            goto L_0x039d
        L_0x0394:
            java.lang.String r2 = "_ui"
            boolean r2 = r7.equals(r2)     // Catch:{ all -> 0x007e }
            if (r2 == 0) goto L_0x039d
            goto L_0x03a7
        L_0x039d:
            r27 = r8
            r29 = r11
        L_0x03a1:
            r9 = r17
            goto L_0x058a
        L_0x03a5:
            r21 = r2
        L_0x03a7:
            r2 = 0
            r10 = 0
            r27 = 0
        L_0x03ab:
            int r7 = r14.q()     // Catch:{ all -> 0x007e }
            r28 = r10
            java.lang.String r10 = "_r"
            if (r2 >= r7) goto L_0x0419
            com.google.android.gms.internal.measurement.m2 r7 = r14.E(r2)     // Catch:{ all -> 0x007e }
            java.lang.String r7 = r7.W()     // Catch:{ all -> 0x007e }
            boolean r7 = r6.equals(r7)     // Catch:{ all -> 0x007e }
            if (r7 == 0) goto L_0x03e5
            com.google.android.gms.internal.measurement.m2 r7 = r14.E(r2)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4$b r7 = r7.y()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2$a r7 = (com.google.android.gms.internal.measurement.C0617m2.a) r7     // Catch:{ all -> 0x007e }
            r29 = r11
            r10 = 1
            com.google.android.gms.internal.measurement.m2$a r7 = r7.s(r10)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r7 = r7.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r7 = (com.google.android.gms.internal.measurement.C0668s4) r7     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r7 = (com.google.android.gms.internal.measurement.C0617m2) r7     // Catch:{ all -> 0x007e }
            r14.t(r2, r7)     // Catch:{ all -> 0x007e }
            r10 = r28
            r27 = 1
            goto L_0x0414
        L_0x03e5:
            r29 = r11
            com.google.android.gms.internal.measurement.m2 r7 = r14.E(r2)     // Catch:{ all -> 0x007e }
            java.lang.String r7 = r7.W()     // Catch:{ all -> 0x007e }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x007e }
            if (r7 == 0) goto L_0x0412
            com.google.android.gms.internal.measurement.m2 r7 = r14.E(r2)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4$b r7 = r7.y()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2$a r7 = (com.google.android.gms.internal.measurement.C0617m2.a) r7     // Catch:{ all -> 0x007e }
            r10 = 1
            com.google.android.gms.internal.measurement.m2$a r7 = r7.s(r10)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r7 = r7.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r7 = (com.google.android.gms.internal.measurement.C0668s4) r7     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r7 = (com.google.android.gms.internal.measurement.C0617m2) r7     // Catch:{ all -> 0x007e }
            r14.t(r2, r7)     // Catch:{ all -> 0x007e }
            r10 = 1
            goto L_0x0414
        L_0x0412:
            r10 = r28
        L_0x0414:
            int r2 = r2 + 1
            r11 = r29
            goto L_0x03ab
        L_0x0419:
            r29 = r11
            if (r27 != 0) goto L_0x044e
            if (r21 == 0) goto L_0x044e
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.K()     // Catch:{ all -> 0x007e }
            java.lang.String r7 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.S2 r11 = r1.f2548l     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.h2 r11 = r11.D()     // Catch:{ all -> 0x007e }
            r27 = r8
            java.lang.String r8 = r14.H()     // Catch:{ all -> 0x007e }
            java.lang.String r8 = r11.c(r8)     // Catch:{ all -> 0x007e }
            r2.b(r7, r8)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2$a r2 = com.google.android.gms.internal.measurement.C0617m2.U()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2$a r2 = r2.y(r6)     // Catch:{ all -> 0x007e }
            r7 = 1
            com.google.android.gms.internal.measurement.m2$a r2 = r2.s(r7)     // Catch:{ all -> 0x007e }
            r14.y(r2)     // Catch:{ all -> 0x007e }
            goto L_0x0450
        L_0x044e:
            r27 = r8
        L_0x0450:
            if (r28 != 0) goto L_0x047e
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.K()     // Catch:{ all -> 0x007e }
            java.lang.String r7 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.S2 r8 = r1.f2548l     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.h2 r8 = r8.D()     // Catch:{ all -> 0x007e }
            java.lang.String r11 = r14.H()     // Catch:{ all -> 0x007e }
            java.lang.String r8 = r8.c(r11)     // Catch:{ all -> 0x007e }
            r2.b(r7, r8)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2$a r2 = com.google.android.gms.internal.measurement.C0617m2.U()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2$a r2 = r2.y(r10)     // Catch:{ all -> 0x007e }
            r7 = 1
            com.google.android.gms.internal.measurement.m2$a r2 = r2.s(r7)     // Catch:{ all -> 0x007e }
            r14.y(r2)     // Catch:{ all -> 0x007e }
        L_0x047e:
            com.google.android.gms.measurement.internal.k r30 = r1.l0()     // Catch:{ all -> 0x007e }
            long r31 = r1.F0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r2 = r4.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r33 = r2.x2()     // Catch:{ all -> 0x007e }
            r39 = 0
            r40 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 1
            com.google.android.gms.measurement.internal.o r2 = r30.J(r31, r33, r34, r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x007e }
            long r7 = r2.f3157e     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.g r2 = r1.i0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r11 = r4.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r11 = r11.x2()     // Catch:{ all -> 0x007e }
            int r2 = r2.w(r11)     // Catch:{ all -> 0x007e }
            r18 = r7
            long r7 = (long) r2     // Catch:{ all -> 0x007e }
            int r2 = (r18 > r7 ? 1 : (r18 == r7 ? 0 : -1))
            if (r2 <= 0) goto L_0x04b9
            o(r14, r10)     // Catch:{ all -> 0x007e }
            goto L_0x04bb
        L_0x04b9:
            r17 = 1
        L_0x04bb:
            java.lang.String r2 = r14.H()     // Catch:{ all -> 0x007e }
            boolean r2 = com.google.android.gms.measurement.internal.d6.K0(r2)     // Catch:{ all -> 0x007e }
            if (r2 == 0) goto L_0x03a1
            if (r21 == 0) goto L_0x03a1
            com.google.android.gms.measurement.internal.k r30 = r1.l0()     // Catch:{ all -> 0x007e }
            long r31 = r1.F0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r2 = r4.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r33 = r2.x2()     // Catch:{ all -> 0x007e }
            r39 = 0
            r40 = 0
            r34 = 0
            r35 = 0
            r36 = 1
            r37 = 0
            r38 = 0
            com.google.android.gms.measurement.internal.o r2 = r30.J(r31, r33, r34, r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x007e }
            long r7 = r2.f3155c     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.g r2 = r1.i0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r10 = r4.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r10 = r10.x2()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.b2 r11 = com.google.android.gms.measurement.internal.G.f2497o     // Catch:{ all -> 0x007e }
            int r2 = r2.t(r10, r11)     // Catch:{ all -> 0x007e }
            long r10 = (long) r2     // Catch:{ all -> 0x007e }
            int r2 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r2 <= 0) goto L_0x03a1
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.L()     // Catch:{ all -> 0x007e }
            java.lang.String r7 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.p2 r8 = r4.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r8 = r8.x2()     // Catch:{ all -> 0x007e }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.C0821n2.s(r8)     // Catch:{ all -> 0x007e }
            r2.b(r7, r8)     // Catch:{ all -> 0x007e }
            r2 = -1
            r7 = 0
            r8 = 0
            r10 = 0
        L_0x0519:
            int r11 = r14.q()     // Catch:{ all -> 0x007e }
            if (r7 >= r11) goto L_0x0547
            com.google.android.gms.internal.measurement.m2 r11 = r14.E(r7)     // Catch:{ all -> 0x007e }
            r18 = r7
            java.lang.String r7 = r11.W()     // Catch:{ all -> 0x007e }
            boolean r7 = r6.equals(r7)     // Catch:{ all -> 0x007e }
            if (r7 == 0) goto L_0x0539
            com.google.android.gms.internal.measurement.s4$b r2 = r11.y()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2$a r2 = (com.google.android.gms.internal.measurement.C0617m2.a) r2     // Catch:{ all -> 0x007e }
            r8 = r2
            r2 = r18
            goto L_0x0544
        L_0x0539:
            java.lang.String r7 = r11.W()     // Catch:{ all -> 0x007e }
            boolean r7 = r9.equals(r7)     // Catch:{ all -> 0x007e }
            if (r7 == 0) goto L_0x0544
            r10 = 1
        L_0x0544:
            int r7 = r18 + 1
            goto L_0x0519
        L_0x0547:
            if (r10 == 0) goto L_0x0550
            if (r8 == 0) goto L_0x0550
            r14.r(r2)     // Catch:{ all -> 0x007e }
            goto L_0x03a1
        L_0x0550:
            if (r8 == 0) goto L_0x0571
            java.lang.Object r7 = r8.clone()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4$b r7 = (com.google.android.gms.internal.measurement.C0668s4.b) r7     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2$a r7 = (com.google.android.gms.internal.measurement.C0617m2.a) r7     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2$a r7 = r7.y(r9)     // Catch:{ all -> 0x007e }
            r8 = 10
            com.google.android.gms.internal.measurement.m2$a r7 = r7.s(r8)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r7 = r7.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r7 = (com.google.android.gms.internal.measurement.C0668s4) r7     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r7 = (com.google.android.gms.internal.measurement.C0617m2) r7     // Catch:{ all -> 0x007e }
            r14.t(r2, r7)     // Catch:{ all -> 0x007e }
            goto L_0x03a1
        L_0x0571:
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.G()     // Catch:{ all -> 0x007e }
            java.lang.String r7 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.p2 r8 = r4.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r8 = r8.x2()     // Catch:{ all -> 0x007e }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.C0821n2.s(r8)     // Catch:{ all -> 0x007e }
            r2.b(r7, r8)     // Catch:{ all -> 0x007e }
            goto L_0x03a1
        L_0x058a:
            if (r21 == 0) goto L_0x064d
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x007e }
            java.util.List r7 = r14.I()     // Catch:{ all -> 0x007e }
            r2.<init>(r7)     // Catch:{ all -> 0x007e }
            r7 = 0
            r8 = -1
            r10 = -1
        L_0x0598:
            int r11 = r2.size()     // Catch:{ all -> 0x007e }
            r17 = r9
            java.lang.String r9 = "currency"
            r21 = r4
            java.lang.String r4 = "value"
            if (r7 >= r11) goto L_0x05d0
            java.lang.Object r11 = r2.get(r7)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r11 = (com.google.android.gms.internal.measurement.C0617m2) r11     // Catch:{ all -> 0x007e }
            java.lang.String r11 = r11.W()     // Catch:{ all -> 0x007e }
            boolean r4 = r4.equals(r11)     // Catch:{ all -> 0x007e }
            if (r4 == 0) goto L_0x05b8
            r8 = r7
            goto L_0x05c9
        L_0x05b8:
            java.lang.Object r4 = r2.get(r7)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r4 = (com.google.android.gms.internal.measurement.C0617m2) r4     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r4.W()     // Catch:{ all -> 0x007e }
            boolean r4 = r9.equals(r4)     // Catch:{ all -> 0x007e }
            if (r4 == 0) goto L_0x05c9
            r10 = r7
        L_0x05c9:
            int r7 = r7 + 1
            r9 = r17
            r4 = r21
            goto L_0x0598
        L_0x05d0:
            r7 = -1
            if (r8 == r7) goto L_0x0604
            java.lang.Object r7 = r2.get(r8)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r7 = (com.google.android.gms.internal.measurement.C0617m2) r7     // Catch:{ all -> 0x007e }
            boolean r7 = r7.b0()     // Catch:{ all -> 0x007e }
            if (r7 != 0) goto L_0x0606
            java.lang.Object r7 = r2.get(r8)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r7 = (com.google.android.gms.internal.measurement.C0617m2) r7     // Catch:{ all -> 0x007e }
            boolean r7 = r7.Z()     // Catch:{ all -> 0x007e }
            if (r7 != 0) goto L_0x0606
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.M()     // Catch:{ all -> 0x007e }
            java.lang.String r7 = "Value must be specified with a numeric type."
            r2.a(r7)     // Catch:{ all -> 0x007e }
            r14.r(r8)     // Catch:{ all -> 0x007e }
            o(r14, r6)     // Catch:{ all -> 0x007e }
            r2 = 18
            n(r14, r2, r4)     // Catch:{ all -> 0x007e }
        L_0x0603:
            r7 = -1
        L_0x0604:
            r10 = 3
            goto L_0x0652
        L_0x0606:
            r7 = -1
            if (r10 != r7) goto L_0x060b
            r10 = 3
            goto L_0x062e
        L_0x060b:
            java.lang.Object r2 = r2.get(r10)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r2 = (com.google.android.gms.internal.measurement.C0617m2) r2     // Catch:{ all -> 0x007e }
            java.lang.String r2 = r2.X()     // Catch:{ all -> 0x007e }
            int r4 = r2.length()     // Catch:{ all -> 0x007e }
            r10 = 3
            if (r4 == r10) goto L_0x061d
            goto L_0x062e
        L_0x061d:
            r4 = 0
        L_0x061e:
            int r11 = r2.length()     // Catch:{ all -> 0x007e }
            if (r4 >= r11) goto L_0x0652
            int r11 = r2.codePointAt(r4)     // Catch:{ all -> 0x007e }
            boolean r18 = java.lang.Character.isLetter(r11)     // Catch:{ all -> 0x007e }
            if (r18 != 0) goto L_0x0647
        L_0x062e:
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.M()     // Catch:{ all -> 0x007e }
            java.lang.String r4 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r2.a(r4)     // Catch:{ all -> 0x007e }
            r14.r(r8)     // Catch:{ all -> 0x007e }
            o(r14, r6)     // Catch:{ all -> 0x007e }
            r2 = 19
            n(r14, r2, r9)     // Catch:{ all -> 0x007e }
            goto L_0x0652
        L_0x0647:
            int r11 = java.lang.Character.charCount(r11)     // Catch:{ all -> 0x007e }
            int r4 = r4 + r11
            goto L_0x061e
        L_0x064d:
            r21 = r4
            r17 = r9
            goto L_0x0603
        L_0x0652:
            java.lang.String r2 = r14.H()     // Catch:{ all -> 0x007e }
            boolean r2 = r5.equals(r2)     // Catch:{ all -> 0x007e }
            r4 = 1000(0x3e8, double:4.94E-321)
            if (r2 == 0) goto L_0x06a1
            r1.x0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r2 = r14.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r2 = (com.google.android.gms.internal.measurement.C0668s4) r2     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2 r2 = (com.google.android.gms.internal.measurement.C0599k2) r2     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r2 = com.google.android.gms.measurement.internal.Z5.F(r2, r13)     // Catch:{ all -> 0x007e }
            if (r2 != 0) goto L_0x069e
            if (r20 == 0) goto L_0x069a
            long r8 = r20.F()     // Catch:{ all -> 0x007e }
            long r18 = r14.F()     // Catch:{ all -> 0x007e }
            long r8 = r8 - r18
            long r8 = java.lang.Math.abs(r8)     // Catch:{ all -> 0x007e }
            int r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x069a
            java.lang.Object r2 = r20.clone()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4$b r2 = (com.google.android.gms.internal.measurement.C0668s4.b) r2     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2$a r2 = (com.google.android.gms.internal.measurement.C0599k2.a) r2     // Catch:{ all -> 0x007e }
            boolean r4 = r1.N(r14, r2)     // Catch:{ all -> 0x007e }
            if (r4 == 0) goto L_0x069a
            r0.s(r12, r2)     // Catch:{ all -> 0x007e }
            r11 = r29
        L_0x0696:
            r2 = 0
            r20 = 0
            goto L_0x06f4
        L_0x069a:
            r11 = r46
            r2 = r14
            goto L_0x06f4
        L_0x069e:
            r5 = r29
            goto L_0x06f1
        L_0x06a1:
            java.lang.String r2 = "_vs"
            java.lang.String r6 = r14.H()     // Catch:{ all -> 0x007e }
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x007e }
            if (r2 == 0) goto L_0x069e
            r1.x0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r2 = r14.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r2 = (com.google.android.gms.internal.measurement.C0668s4) r2     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2 r2 = (com.google.android.gms.internal.measurement.C0599k2) r2     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r2 = com.google.android.gms.measurement.internal.Z5.F(r2, r15)     // Catch:{ all -> 0x007e }
            if (r2 != 0) goto L_0x069e
            if (r45 == 0) goto L_0x06e7
            long r8 = r45.F()     // Catch:{ all -> 0x007e }
            long r18 = r14.F()     // Catch:{ all -> 0x007e }
            long r8 = r8 - r18
            long r8 = java.lang.Math.abs(r8)     // Catch:{ all -> 0x007e }
            int r2 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x06e7
            java.lang.Object r2 = r45.clone()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4$b r2 = (com.google.android.gms.internal.measurement.C0668s4.b) r2     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2$a r2 = (com.google.android.gms.internal.measurement.C0599k2.a) r2     // Catch:{ all -> 0x007e }
            boolean r4 = r1.N(r2, r14)     // Catch:{ all -> 0x007e }
            if (r4 == 0) goto L_0x06e7
            r5 = r29
            r0.s(r5, r2)     // Catch:{ all -> 0x007e }
            r11 = r5
            goto L_0x0696
        L_0x06e7:
            r5 = r29
            r2 = r45
            r12 = r46
            r11 = r5
            r20 = r14
            goto L_0x06f4
        L_0x06f1:
            r2 = r45
            r11 = r5
        L_0x06f4:
            int r4 = r14.q()     // Catch:{ all -> 0x007e }
            if (r4 == 0) goto L_0x0811
            r1.x0()     // Catch:{ all -> 0x007e }
            java.util.List r4 = r14.I()     // Catch:{ all -> 0x007e }
            android.os.Bundle r4 = com.google.android.gms.measurement.internal.Z5.y(r4)     // Catch:{ all -> 0x007e }
            r5 = 0
        L_0x0706:
            int r6 = r14.q()     // Catch:{ all -> 0x007e }
            if (r5 >= r6) goto L_0x07bd
            com.google.android.gms.internal.measurement.m2 r6 = r14.E(r5)     // Catch:{ all -> 0x007e }
            java.lang.String r8 = r6.W()     // Catch:{ all -> 0x007e }
            boolean r8 = r8.equals(r3)     // Catch:{ all -> 0x007e }
            if (r8 == 0) goto L_0x0790
            java.util.List r8 = r6.Y()     // Catch:{ all -> 0x007e }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x007e }
            if (r8 != 0) goto L_0x0790
            r8 = r21
            com.google.android.gms.internal.measurement.p2 r9 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r9 = r9.x2()     // Catch:{ all -> 0x007e }
            java.util.List r6 = r6.Y()     // Catch:{ all -> 0x007e }
            int r13 = r6.size()     // Catch:{ all -> 0x007e }
            android.os.Bundle[] r13 = new android.os.Bundle[r13]     // Catch:{ all -> 0x007e }
            r15 = 0
        L_0x0737:
            int r7 = r6.size()     // Catch:{ all -> 0x007e }
            if (r15 >= r7) goto L_0x0788
            java.lang.Object r7 = r6.get(r15)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r7 = (com.google.android.gms.internal.measurement.C0617m2) r7     // Catch:{ all -> 0x007e }
            r1.x0()     // Catch:{ all -> 0x007e }
            java.util.List r18 = r7.Y()     // Catch:{ all -> 0x007e }
            android.os.Bundle r10 = com.google.android.gms.measurement.internal.Z5.y(r18)     // Catch:{ all -> 0x007e }
            java.util.List r7 = r7.Y()     // Catch:{ all -> 0x007e }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x007e }
        L_0x0756:
            boolean r18 = r7.hasNext()     // Catch:{ all -> 0x007e }
            if (r18 == 0) goto L_0x077a
            java.lang.Object r18 = r7.next()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r18 = (com.google.android.gms.internal.measurement.C0617m2) r18     // Catch:{ all -> 0x007e }
            r45 = r2
            java.lang.String r2 = r14.H()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4$b r18 = r18.y()     // Catch:{ all -> 0x007e }
            r19 = r5
            r5 = r18
            com.google.android.gms.internal.measurement.m2$a r5 = (com.google.android.gms.internal.measurement.C0617m2.a) r5     // Catch:{ all -> 0x007e }
            r1.D(r2, r5, r10, r9)     // Catch:{ all -> 0x007e }
            r2 = r45
            r5 = r19
            goto L_0x0756
        L_0x077a:
            r45 = r2
            r19 = r5
            r13[r15] = r10     // Catch:{ all -> 0x007e }
            int r15 = r15 + 1
            r2 = r45
            r5 = r19
            r10 = 3
            goto L_0x0737
        L_0x0788:
            r45 = r2
            r19 = r5
            r4.putParcelableArray(r3, r13)     // Catch:{ all -> 0x007e }
            goto L_0x07b3
        L_0x0790:
            r45 = r2
            r19 = r5
            r8 = r21
            java.lang.String r2 = r6.W()     // Catch:{ all -> 0x007e }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x007e }
            if (r2 != 0) goto L_0x07b3
            java.lang.String r2 = r14.H()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4$b r5 = r6.y()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2$a r5 = (com.google.android.gms.internal.measurement.C0617m2.a) r5     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r6 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r6 = r6.x2()     // Catch:{ all -> 0x007e }
            r1.D(r2, r5, r4, r6)     // Catch:{ all -> 0x007e }
        L_0x07b3:
            int r5 = r19 + 1
            r2 = r45
            r21 = r8
            r7 = -1
            r10 = 3
            goto L_0x0706
        L_0x07bd:
            r45 = r2
            r8 = r21
            r14.G()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.Z5 r2 = r1.x0()     // Catch:{ all -> 0x007e }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x007e }
            r5.<init>()     // Catch:{ all -> 0x007e }
            java.util.Set r6 = r4.keySet()     // Catch:{ all -> 0x007e }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x007e }
        L_0x07d5:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x007e }
            if (r7 == 0) goto L_0x07fe
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x007e }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2$a r9 = com.google.android.gms.internal.measurement.C0617m2.U()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2$a r9 = r9.y(r7)     // Catch:{ all -> 0x007e }
            java.lang.Object r7 = r4.get(r7)     // Catch:{ all -> 0x007e }
            if (r7 == 0) goto L_0x07d5
            r2.U(r9, r7)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r7 = r9.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r7 = (com.google.android.gms.internal.measurement.C0668s4) r7     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r7 = (com.google.android.gms.internal.measurement.C0617m2) r7     // Catch:{ all -> 0x007e }
            r5.add(r7)     // Catch:{ all -> 0x007e }
            goto L_0x07d5
        L_0x07fe:
            int r2 = r5.size()     // Catch:{ all -> 0x007e }
            r4 = 0
        L_0x0803:
            if (r4 >= r2) goto L_0x0815
            java.lang.Object r6 = r5.get(r4)     // Catch:{ all -> 0x007e }
            int r4 = r4 + 1
            com.google.android.gms.internal.measurement.m2 r6 = (com.google.android.gms.internal.measurement.C0617m2) r6     // Catch:{ all -> 0x007e }
            r14.z(r6)     // Catch:{ all -> 0x007e }
            goto L_0x0803
        L_0x0811:
            r45 = r2
            r8 = r21
        L_0x0815:
            java.util.List r2 = r8.f2565c     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r4 = r14.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r4 = (com.google.android.gms.internal.measurement.C0668s4) r4     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2 r4 = (com.google.android.gms.internal.measurement.C0599k2) r4     // Catch:{ all -> 0x007e }
            r13 = r27
            r2.set(r13, r4)     // Catch:{ all -> 0x007e }
            int r10 = r46 + 1
            r0.B(r14)     // Catch:{ all -> 0x007e }
            goto L_0x02ee
        L_0x082b:
            int r2 = r13 + 1
            r4 = r8
            r13 = 0
            r8 = r2
            r2 = r22
            goto L_0x0242
        L_0x0834:
            r8 = r4
            r2 = 0
            r10 = r46
            r11 = r2
            r4 = 0
        L_0x083b:
            if (r4 >= r10) goto L_0x088b
            com.google.android.gms.internal.measurement.k2 r7 = r0.r(r4)     // Catch:{ all -> 0x007e }
            java.lang.String r9 = r7.U()     // Catch:{ all -> 0x007e }
            boolean r9 = r5.equals(r9)     // Catch:{ all -> 0x007e }
            if (r9 == 0) goto L_0x085e
            r1.x0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r9 = com.google.android.gms.measurement.internal.Z5.F(r7, r13)     // Catch:{ all -> 0x007e }
            if (r9 == 0) goto L_0x085e
            r0.O(r4)     // Catch:{ all -> 0x007e }
            int r10 = r10 + -1
            int r4 = r4 + -1
        L_0x085b:
            r25 = 1
            goto L_0x0888
        L_0x085e:
            r1.x0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r7 = com.google.android.gms.measurement.internal.Z5.F(r7, r15)     // Catch:{ all -> 0x007e }
            if (r7 == 0) goto L_0x085b
            boolean r9 = r7.b0()     // Catch:{ all -> 0x007e }
            if (r9 == 0) goto L_0x0876
            long r20 = r7.S()     // Catch:{ all -> 0x007e }
            java.lang.Long r7 = java.lang.Long.valueOf(r20)     // Catch:{ all -> 0x007e }
            goto L_0x0877
        L_0x0876:
            r7 = 0
        L_0x0877:
            if (r7 == 0) goto L_0x085b
            long r20 = r7.longValue()     // Catch:{ all -> 0x007e }
            int r9 = (r20 > r2 ? 1 : (r20 == r2 ? 0 : -1))
            if (r9 <= 0) goto L_0x085b
            long r20 = r7.longValue()     // Catch:{ all -> 0x007e }
            long r11 = r11 + r20
            goto L_0x085b
        L_0x0888:
            int r4 = r4 + 1
            goto L_0x083b
        L_0x088b:
            r4 = 0
            r1.p(r0, r11, r4)     // Catch:{ all -> 0x007e }
            java.util.List r4 = r0.I()     // Catch:{ all -> 0x007e }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x007e }
        L_0x0897:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x007e }
            java.lang.String r7 = "_se"
            if (r5 == 0) goto L_0x08bc
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2 r5 = (com.google.android.gms.internal.measurement.C0599k2) r5     // Catch:{ all -> 0x007e }
            java.lang.String r9 = "_s"
            java.lang.String r5 = r5.U()     // Catch:{ all -> 0x007e }
            boolean r5 = r9.equals(r5)     // Catch:{ all -> 0x007e }
            if (r5 == 0) goto L_0x0897
            com.google.android.gms.measurement.internal.k r4 = r1.l0()     // Catch:{ all -> 0x007e }
            java.lang.String r5 = r0.Z0()     // Catch:{ all -> 0x007e }
            r4.T0(r5, r7)     // Catch:{ all -> 0x007e }
        L_0x08bc:
            java.lang.String r4 = "_sid"
            int r4 = com.google.android.gms.measurement.internal.Z5.v(r0, r4)     // Catch:{ all -> 0x007e }
            if (r4 < 0) goto L_0x08c9
            r5 = 1
            r1.p(r0, r11, r5)     // Catch:{ all -> 0x007e }
            goto L_0x08e9
        L_0x08c9:
            int r4 = com.google.android.gms.measurement.internal.Z5.v(r0, r7)     // Catch:{ all -> 0x007e }
            if (r4 < 0) goto L_0x08e9
            r0.U(r4)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.n2 r4 = r1.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r4 = r4.G()     // Catch:{ all -> 0x007e }
            java.lang.String r5 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.p2 r7 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r7 = r7.x2()     // Catch:{ all -> 0x007e }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.C0821n2.s(r7)     // Catch:{ all -> 0x007e }
            r4.b(r5, r7)     // Catch:{ all -> 0x007e }
        L_0x08e9:
            com.google.android.gms.internal.measurement.p2 r4 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r4.x2()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.P2 r5 = r1.f()     // Catch:{ all -> 0x007e }
            r5.k()     // Catch:{ all -> 0x007e }
            r1.A0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.k r5 = r1.l0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.c2 r5 = r5.M0(r4)     // Catch:{ all -> 0x007e }
            if (r5 != 0) goto L_0x0915
            com.google.android.gms.measurement.internal.n2 r5 = r1.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r5 = r5.G()     // Catch:{ all -> 0x007e }
            java.lang.String r7 = "Cannot fix consent fields without appInfo. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C0821n2.s(r4)     // Catch:{ all -> 0x007e }
            r5.b(r7, r4)     // Catch:{ all -> 0x007e }
            goto L_0x0918
        L_0x0915:
            r1.u(r5, r0)     // Catch:{ all -> 0x007e }
        L_0x0918:
            boolean r4 = com.google.android.gms.internal.measurement.R6.a()     // Catch:{ all -> 0x007e }
            if (r4 == 0) goto L_0x0959
            com.google.android.gms.measurement.internal.g r4 = r1.i0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.b2 r5 = com.google.android.gms.measurement.internal.G.f2447V0     // Catch:{ all -> 0x007e }
            boolean r4 = r4.q(r5)     // Catch:{ all -> 0x007e }
            if (r4 == 0) goto L_0x0959
            com.google.android.gms.internal.measurement.p2 r4 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r4.x2()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.P2 r5 = r1.f()     // Catch:{ all -> 0x007e }
            r5.k()     // Catch:{ all -> 0x007e }
            r1.A0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.k r5 = r1.l0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.c2 r5 = r5.M0(r4)     // Catch:{ all -> 0x007e }
            if (r5 != 0) goto L_0x0956
            com.google.android.gms.measurement.internal.n2 r5 = r1.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r5 = r5.L()     // Catch:{ all -> 0x007e }
            java.lang.String r7 = "Cannot populate ad_campaign_info without appInfo. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C0821n2.s(r4)     // Catch:{ all -> 0x007e }
            r5.b(r7, r4)     // Catch:{ all -> 0x007e }
            goto L_0x0959
        L_0x0956:
            r1.a0(r5, r0)     // Catch:{ all -> 0x007e }
        L_0x0959:
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            com.google.android.gms.internal.measurement.p2$a r4 = r0.y0(r4)     // Catch:{ all -> 0x007e }
            r9 = -9223372036854775808
            r4.h0(r9)     // Catch:{ all -> 0x007e }
            r4 = 0
        L_0x0968:
            int r5 = r0.T()     // Catch:{ all -> 0x007e }
            if (r4 >= r5) goto L_0x099b
            com.google.android.gms.internal.measurement.k2 r5 = r0.r(r4)     // Catch:{ all -> 0x007e }
            long r9 = r5.R()     // Catch:{ all -> 0x007e }
            long r11 = r0.k0()     // Catch:{ all -> 0x007e }
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 >= 0) goto L_0x0985
            long r9 = r5.R()     // Catch:{ all -> 0x007e }
            r0.y0(r9)     // Catch:{ all -> 0x007e }
        L_0x0985:
            long r9 = r5.R()     // Catch:{ all -> 0x007e }
            long r11 = r0.f0()     // Catch:{ all -> 0x007e }
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 <= 0) goto L_0x0998
            long r9 = r5.R()     // Catch:{ all -> 0x007e }
            r0.h0(r9)     // Catch:{ all -> 0x007e }
        L_0x0998:
            int r4 = r4 + 1
            goto L_0x0968
        L_0x099b:
            r0.X0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.A3 r4 = com.google.android.gms.measurement.internal.A3.f2299c     // Catch:{ all -> 0x007e }
            boolean r5 = com.google.android.gms.internal.measurement.C0576h6.a()     // Catch:{ all -> 0x007e }
            if (r5 == 0) goto L_0x0a33
            com.google.android.gms.measurement.internal.g r5 = r1.i0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.b2 r7 = com.google.android.gms.measurement.internal.G.f2455Z0     // Catch:{ all -> 0x007e }
            boolean r5 = r5.q(r7)     // Catch:{ all -> 0x007e }
            if (r5 == 0) goto L_0x0a33
            com.google.android.gms.internal.measurement.p2 r4 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r4.x2()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.A3 r4 = r1.U(r4)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r5 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r5 = r5.Y()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.A3 r5 = com.google.android.gms.measurement.internal.A3.q(r5)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.A3 r4 = r4.d(r5)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.k r5 = r1.l0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r7 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r7 = r7.x2()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.A3 r5 = r5.S0(r7)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.k r7 = r1.l0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r9 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r9 = r9.x2()     // Catch:{ all -> 0x007e }
            r7.a0(r9, r4)     // Catch:{ all -> 0x007e }
            boolean r7 = r4.z()     // Catch:{ all -> 0x007e }
            if (r7 != 0) goto L_0x09ff
            boolean r7 = r5.z()     // Catch:{ all -> 0x007e }
            if (r7 == 0) goto L_0x09ff
            com.google.android.gms.measurement.internal.k r5 = r1.l0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r7 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r7 = r7.x2()     // Catch:{ all -> 0x007e }
            r5.e1(r7)     // Catch:{ all -> 0x007e }
            goto L_0x0a18
        L_0x09ff:
            boolean r7 = r4.z()     // Catch:{ all -> 0x007e }
            if (r7 == 0) goto L_0x0a18
            boolean r5 = r5.z()     // Catch:{ all -> 0x007e }
            if (r5 != 0) goto L_0x0a18
            com.google.android.gms.measurement.internal.k r5 = r1.l0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r7 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r7 = r7.x2()     // Catch:{ all -> 0x007e }
            r5.f1(r7)     // Catch:{ all -> 0x007e }
        L_0x0a18:
            boolean r5 = r4.y()     // Catch:{ all -> 0x007e }
            if (r5 != 0) goto L_0x0a27
            r0.T0()     // Catch:{ all -> 0x007e }
            r0.N0()     // Catch:{ all -> 0x007e }
            r0.E0()     // Catch:{ all -> 0x007e }
        L_0x0a27:
            boolean r5 = r4.z()     // Catch:{ all -> 0x007e }
            if (r5 != 0) goto L_0x0a33
            r0.s0()     // Catch:{ all -> 0x007e }
            r0.V0()     // Catch:{ all -> 0x007e }
        L_0x0a33:
            boolean r5 = com.google.android.gms.internal.measurement.C0604k7.a()     // Catch:{ all -> 0x007e }
            if (r5 == 0) goto L_0x0c3a
            com.google.android.gms.measurement.internal.g r5 = r1.i0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r7 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r7 = r7.x2()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.b2 r9 = com.google.android.gms.measurement.internal.G.f2421I0     // Catch:{ all -> 0x007e }
            boolean r5 = r5.F(r7, r9)     // Catch:{ all -> 0x007e }
            if (r5 == 0) goto L_0x0c3a
            r1.y0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r5 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r5 = r5.x2()     // Catch:{ all -> 0x007e }
            boolean r5 = com.google.android.gms.measurement.internal.d6.D0(r5)     // Catch:{ all -> 0x007e }
            if (r5 == 0) goto L_0x0c3a
            com.google.android.gms.internal.measurement.p2 r5 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r5 = r5.x2()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.A3 r5 = r1.U(r5)     // Catch:{ all -> 0x007e }
            boolean r5 = r5.y()     // Catch:{ all -> 0x007e }
            if (r5 == 0) goto L_0x0c3a
            com.google.android.gms.internal.measurement.p2 r5 = r8.f2563a     // Catch:{ all -> 0x007e }
            boolean r5 = r5.n0()     // Catch:{ all -> 0x007e }
            if (r5 == 0) goto L_0x0c3a
            r5 = 0
        L_0x0a73:
            int r7 = r0.T()     // Catch:{ all -> 0x007e }
            if (r5 >= r7) goto L_0x0c3a
            com.google.android.gms.internal.measurement.k2 r7 = r0.r(r5)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4$b r7 = r7.y()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2$a r7 = (com.google.android.gms.internal.measurement.C0599k2.a) r7     // Catch:{ all -> 0x007e }
            java.util.List r9 = r7.I()     // Catch:{ all -> 0x007e }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x007e }
        L_0x0a8b:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x007e }
            if (r10 == 0) goto L_0x0c36
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r10 = (com.google.android.gms.internal.measurement.C0617m2) r10     // Catch:{ all -> 0x007e }
            java.lang.String r10 = r10.W()     // Catch:{ all -> 0x007e }
            boolean r10 = r6.equals(r10)     // Catch:{ all -> 0x007e }
            if (r10 == 0) goto L_0x0a8b
            com.google.android.gms.internal.measurement.p2 r9 = r8.f2563a     // Catch:{ all -> 0x007e }
            int r9 = r9.j()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.g r10 = r1.i0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r11 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r11 = r11.x2()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.b2 r12 = com.google.android.gms.measurement.internal.G.f2452Y     // Catch:{ all -> 0x007e }
            int r10 = r10.t(r11, r12)     // Catch:{ all -> 0x007e }
            if (r9 < r10) goto L_0x0c2b
            com.google.android.gms.measurement.internal.g r9 = r1.i0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r10 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r10 = r10.x2()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.b2 r11 = com.google.android.gms.measurement.internal.G.f2484j0     // Catch:{ all -> 0x007e }
            int r9 = r9.t(r10, r11)     // Catch:{ all -> 0x007e }
            if (r9 <= 0) goto L_0x0b9e
            com.google.android.gms.measurement.internal.k r26 = r1.l0()     // Catch:{ all -> 0x007e }
            long r27 = r1.F0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r10 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r29 = r10.x2()     // Catch:{ all -> 0x007e }
            r35 = 0
            r36 = 1
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            com.google.android.gms.measurement.internal.o r10 = r26.J(r27, r29, r30, r31, r32, r33, r34, r35, r36)     // Catch:{ all -> 0x007e }
            long r10 = r10.f3159g     // Catch:{ all -> 0x007e }
            long r12 = (long) r9     // Catch:{ all -> 0x007e }
            int r9 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r9 <= 0) goto L_0x0b0f
            com.google.android.gms.internal.measurement.m2$a r9 = com.google.android.gms.internal.measurement.C0617m2.U()     // Catch:{ all -> 0x007e }
            java.lang.String r10 = "_tnr"
            com.google.android.gms.internal.measurement.m2$a r9 = r9.y(r10)     // Catch:{ all -> 0x007e }
            r10 = 1
            com.google.android.gms.internal.measurement.m2$a r9 = r9.s(r10)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r9 = r9.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r9 = (com.google.android.gms.internal.measurement.C0668s4) r9     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r9 = (com.google.android.gms.internal.measurement.C0617m2) r9     // Catch:{ all -> 0x007e }
            r7.z(r9)     // Catch:{ all -> 0x007e }
            goto L_0x0c2b
        L_0x0b0f:
            com.google.android.gms.measurement.internal.g r9 = r1.i0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r10 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r10 = r10.x2()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.b2 r11 = com.google.android.gms.measurement.internal.G.f2425K0     // Catch:{ all -> 0x007e }
            boolean r9 = r9.F(r10, r11)     // Catch:{ all -> 0x007e }
            if (r9 == 0) goto L_0x0b43
            com.google.android.gms.measurement.internal.d6 r9 = r1.y0()     // Catch:{ all -> 0x007e }
            java.lang.String r9 = r9.U0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2$a r10 = com.google.android.gms.internal.measurement.C0617m2.U()     // Catch:{ all -> 0x007e }
            java.lang.String r11 = "_tu"
            com.google.android.gms.internal.measurement.m2$a r10 = r10.y(r11)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2$a r10 = r10.A(r9)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r10 = r10.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r10 = (com.google.android.gms.internal.measurement.C0668s4) r10     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r10 = (com.google.android.gms.internal.measurement.C0617m2) r10     // Catch:{ all -> 0x007e }
            r7.z(r10)     // Catch:{ all -> 0x007e }
            goto L_0x0b44
        L_0x0b43:
            r9 = 0
        L_0x0b44:
            com.google.android.gms.internal.measurement.m2$a r10 = com.google.android.gms.internal.measurement.C0617m2.U()     // Catch:{ all -> 0x007e }
            java.lang.String r11 = "_tr"
            com.google.android.gms.internal.measurement.m2$a r10 = r10.y(r11)     // Catch:{ all -> 0x007e }
            r11 = 1
            com.google.android.gms.internal.measurement.m2$a r10 = r10.s(r11)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r10 = r10.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r10 = (com.google.android.gms.internal.measurement.C0668s4) r10     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r10 = (com.google.android.gms.internal.measurement.C0617m2) r10     // Catch:{ all -> 0x007e }
            r7.z(r10)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.Z5 r10 = r1.x0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r11 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r11 = r11.x2()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.B5 r9 = r10.I(r11, r0, r7, r9)     // Catch:{ all -> 0x007e }
            if (r9 == 0) goto L_0x0c2b
            com.google.android.gms.measurement.internal.n2 r10 = r1.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r10 = r10.K()     // Catch:{ all -> 0x007e }
            java.lang.String r11 = "Generated trigger URI. appId, uri"
            com.google.android.gms.internal.measurement.p2 r12 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r12 = r12.x2()     // Catch:{ all -> 0x007e }
            java.lang.String r13 = r9.f2332a     // Catch:{ all -> 0x007e }
            r10.c(r11, r12, r13)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.k r10 = r1.l0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r11 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r11 = r11.x2()     // Catch:{ all -> 0x007e }
            r10.m0(r11, r9)     // Catch:{ all -> 0x007e }
            java.util.Set r9 = r1.f2553q     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r10 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r10 = r10.x2()     // Catch:{ all -> 0x007e }
            r9.add(r10)     // Catch:{ all -> 0x007e }
            goto L_0x0c2b
        L_0x0b9e:
            com.google.android.gms.measurement.internal.g r9 = r1.i0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r10 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r10 = r10.x2()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.b2 r11 = com.google.android.gms.measurement.internal.G.f2425K0     // Catch:{ all -> 0x007e }
            boolean r9 = r9.F(r10, r11)     // Catch:{ all -> 0x007e }
            if (r9 == 0) goto L_0x0bd2
            com.google.android.gms.measurement.internal.d6 r9 = r1.y0()     // Catch:{ all -> 0x007e }
            java.lang.String r9 = r9.U0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2$a r10 = com.google.android.gms.internal.measurement.C0617m2.U()     // Catch:{ all -> 0x007e }
            java.lang.String r11 = "_tu"
            com.google.android.gms.internal.measurement.m2$a r10 = r10.y(r11)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2$a r10 = r10.A(r9)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r10 = r10.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r10 = (com.google.android.gms.internal.measurement.C0668s4) r10     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r10 = (com.google.android.gms.internal.measurement.C0617m2) r10     // Catch:{ all -> 0x007e }
            r7.z(r10)     // Catch:{ all -> 0x007e }
            goto L_0x0bd3
        L_0x0bd2:
            r9 = 0
        L_0x0bd3:
            com.google.android.gms.internal.measurement.m2$a r10 = com.google.android.gms.internal.measurement.C0617m2.U()     // Catch:{ all -> 0x007e }
            java.lang.String r11 = "_tr"
            com.google.android.gms.internal.measurement.m2$a r10 = r10.y(r11)     // Catch:{ all -> 0x007e }
            r11 = 1
            com.google.android.gms.internal.measurement.m2$a r10 = r10.s(r11)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r10 = r10.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r10 = (com.google.android.gms.internal.measurement.C0668s4) r10     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r10 = (com.google.android.gms.internal.measurement.C0617m2) r10     // Catch:{ all -> 0x007e }
            r7.z(r10)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.Z5 r10 = r1.x0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r11 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r11 = r11.x2()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.B5 r9 = r10.I(r11, r0, r7, r9)     // Catch:{ all -> 0x007e }
            if (r9 == 0) goto L_0x0c2b
            com.google.android.gms.measurement.internal.n2 r10 = r1.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r10 = r10.K()     // Catch:{ all -> 0x007e }
            java.lang.String r11 = "Generated trigger URI. appId, uri"
            com.google.android.gms.internal.measurement.p2 r12 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r12 = r12.x2()     // Catch:{ all -> 0x007e }
            java.lang.String r13 = r9.f2332a     // Catch:{ all -> 0x007e }
            r10.c(r11, r12, r13)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.k r10 = r1.l0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r11 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r11 = r11.x2()     // Catch:{ all -> 0x007e }
            r10.m0(r11, r9)     // Catch:{ all -> 0x007e }
            java.util.Set r9 = r1.f2553q     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r10 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r10 = r10.x2()     // Catch:{ all -> 0x007e }
            r9.add(r10)     // Catch:{ all -> 0x007e }
        L_0x0c2b:
            com.google.android.gms.internal.measurement.Z4 r7 = r7.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r7 = (com.google.android.gms.internal.measurement.C0668s4) r7     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2 r7 = (com.google.android.gms.internal.measurement.C0599k2) r7     // Catch:{ all -> 0x007e }
            r0.t(r5, r7)     // Catch:{ all -> 0x007e }
        L_0x0c36:
            int r5 = r5 + 1
            goto L_0x0a73
        L_0x0c3a:
            boolean r5 = com.google.android.gms.internal.measurement.C0576h6.a()     // Catch:{ all -> 0x007e }
            if (r5 == 0) goto L_0x0c80
            com.google.android.gms.measurement.internal.g r5 = r1.i0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.b2 r6 = com.google.android.gms.measurement.internal.G.f2455Z0     // Catch:{ all -> 0x007e }
            boolean r5 = r5.q(r6)     // Catch:{ all -> 0x007e }
            if (r5 == 0) goto L_0x0c80
            com.google.android.gms.internal.measurement.p2$a r5 = r0.w0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.h6 r9 = r1.d0()     // Catch:{ all -> 0x007e }
            java.lang.String r10 = r0.Z0()     // Catch:{ all -> 0x007e }
            java.util.List r11 = r0.I()     // Catch:{ all -> 0x007e }
            java.util.List r12 = r0.J()     // Catch:{ all -> 0x007e }
            long r6 = r0.k0()     // Catch:{ all -> 0x007e }
            java.lang.Long r13 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x007e }
            long r6 = r0.f0()     // Catch:{ all -> 0x007e }
            java.lang.Long r14 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x007e }
            boolean r4 = r4.z()     // Catch:{ all -> 0x007e }
            r25 = 1
            r15 = r4 ^ 1
            java.util.List r4 = r9.x(r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x007e }
            r5.F(r4)     // Catch:{ all -> 0x007e }
            goto L_0x0cab
        L_0x0c80:
            com.google.android.gms.internal.measurement.p2$a r4 = r0.w0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.h6 r9 = r1.d0()     // Catch:{ all -> 0x007e }
            java.lang.String r10 = r0.Z0()     // Catch:{ all -> 0x007e }
            java.util.List r11 = r0.I()     // Catch:{ all -> 0x007e }
            java.util.List r12 = r0.J()     // Catch:{ all -> 0x007e }
            long r5 = r0.k0()     // Catch:{ all -> 0x007e }
            java.lang.Long r13 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x007e }
            long r5 = r0.f0()     // Catch:{ all -> 0x007e }
            java.lang.Long r14 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x007e }
            java.util.List r5 = r9.w(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x007e }
            r4.F(r5)     // Catch:{ all -> 0x007e }
        L_0x0cab:
            com.google.android.gms.measurement.internal.g r4 = r1.i0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r5 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r5 = r5.x2()     // Catch:{ all -> 0x007e }
            boolean r4 = r4.O(r5)     // Catch:{ all -> 0x007e }
            if (r4 == 0) goto L_0x0fa3
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ all -> 0x007e }
            r4.<init>()     // Catch:{ all -> 0x007e }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x007e }
            r5.<init>()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.d6 r6 = r1.y0()     // Catch:{ all -> 0x007e }
            java.security.SecureRandom r6 = r6.W0()     // Catch:{ all -> 0x007e }
            r7 = 0
        L_0x0cce:
            int r9 = r0.T()     // Catch:{ all -> 0x007e }
            if (r7 >= r9) goto L_0x0f6e
            com.google.android.gms.internal.measurement.k2 r9 = r0.r(r7)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4$b r9 = r9.y()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2$a r9 = (com.google.android.gms.internal.measurement.C0599k2.a) r9     // Catch:{ all -> 0x007e }
            java.lang.String r10 = r9.H()     // Catch:{ all -> 0x007e }
            java.lang.String r11 = "_ep"
            boolean r10 = r10.equals(r11)     // Catch:{ all -> 0x007e }
            java.lang.String r11 = "_sr"
            if (r10 == 0) goto L_0x0d6b
            r1.x0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r10 = r9.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r10 = (com.google.android.gms.internal.measurement.C0668s4) r10     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2 r10 = (com.google.android.gms.internal.measurement.C0599k2) r10     // Catch:{ all -> 0x007e }
            java.lang.String r12 = "_en"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.Z5.f0(r10, r12)     // Catch:{ all -> 0x007e }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x007e }
            java.lang.Object r12 = r4.get(r10)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.A r12 = (com.google.android.gms.measurement.internal.A) r12     // Catch:{ all -> 0x007e }
            if (r12 != 0) goto L_0x0d20
            com.google.android.gms.measurement.internal.k r12 = r1.l0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r13 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r13 = r13.x2()     // Catch:{ all -> 0x007e }
            java.lang.Object r14 = M.C0335p.l(r10)     // Catch:{ all -> 0x007e }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.A r12 = r12.L0(r13, r14)     // Catch:{ all -> 0x007e }
            if (r12 == 0) goto L_0x0d20
            r4.put(r10, r12)     // Catch:{ all -> 0x007e }
        L_0x0d20:
            if (r12 == 0) goto L_0x0d5f
            java.lang.Long r10 = r12.f2291i     // Catch:{ all -> 0x007e }
            if (r10 != 0) goto L_0x0d5f
            java.lang.Long r10 = r12.f2292j     // Catch:{ all -> 0x007e }
            if (r10 == 0) goto L_0x0d3c
            long r13 = r10.longValue()     // Catch:{ all -> 0x007e }
            r18 = 1
            int r10 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
            if (r10 <= 0) goto L_0x0d3c
            r1.x0()     // Catch:{ all -> 0x007e }
            java.lang.Long r10 = r12.f2292j     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.Z5.T(r9, r11, r10)     // Catch:{ all -> 0x007e }
        L_0x0d3c:
            java.lang.Boolean r10 = r12.f2293k     // Catch:{ all -> 0x007e }
            if (r10 == 0) goto L_0x0d54
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x007e }
            if (r10 == 0) goto L_0x0d54
            r1.x0()     // Catch:{ all -> 0x007e }
            java.lang.String r10 = "_efs"
            r18 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.Z5.T(r9, r10, r11)     // Catch:{ all -> 0x007e }
        L_0x0d54:
            com.google.android.gms.internal.measurement.Z4 r10 = r9.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r10 = (com.google.android.gms.internal.measurement.C0668s4) r10     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2 r10 = (com.google.android.gms.internal.measurement.C0599k2) r10     // Catch:{ all -> 0x007e }
            r5.add(r10)     // Catch:{ all -> 0x007e }
        L_0x0d5f:
            r0.s(r7, r9)     // Catch:{ all -> 0x007e }
            r44 = r2
        L_0x0d64:
            r46 = r6
            r1 = r7
            r18 = 1
            goto L_0x0f64
        L_0x0d6b:
            com.google.android.gms.measurement.internal.I2 r10 = r1.r0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r12 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r12 = r12.x2()     // Catch:{ all -> 0x007e }
            long r12 = r10.v(r12)     // Catch:{ all -> 0x007e }
            r1.y0()     // Catch:{ all -> 0x007e }
            long r14 = r9.F()     // Catch:{ all -> 0x007e }
            long r14 = com.google.android.gms.measurement.internal.d6.v(r14, r12)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r10 = r9.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r10 = (com.google.android.gms.internal.measurement.C0668s4) r10     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2 r10 = (com.google.android.gms.internal.measurement.C0599k2) r10     // Catch:{ all -> 0x007e }
            r44 = r2
            java.lang.String r2 = "_dbg"
            r18 = 1
            java.lang.Long r3 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x007e }
            boolean r20 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x007e }
            if (r20 != 0) goto L_0x0dce
            java.util.List r10 = r10.V()     // Catch:{ all -> 0x007e }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ all -> 0x007e }
        L_0x0da4:
            boolean r20 = r10.hasNext()     // Catch:{ all -> 0x007e }
            if (r20 == 0) goto L_0x0dce
            java.lang.Object r20 = r10.next()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.m2 r20 = (com.google.android.gms.internal.measurement.C0617m2) r20     // Catch:{ all -> 0x007e }
            java.lang.String r1 = r20.W()     // Catch:{ all -> 0x007e }
            boolean r1 = r2.equals(r1)     // Catch:{ all -> 0x007e }
            if (r1 == 0) goto L_0x0dcb
            long r1 = r20.S()     // Catch:{ all -> 0x007e }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x007e }
            boolean r1 = r3.equals(r1)     // Catch:{ all -> 0x007e }
            if (r1 != 0) goto L_0x0dc9
            goto L_0x0dce
        L_0x0dc9:
            r1 = 1
            goto L_0x0de0
        L_0x0dcb:
            r1 = r43
            goto L_0x0da4
        L_0x0dce:
            com.google.android.gms.measurement.internal.I2 r1 = r43.r0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r2 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r2 = r2.x2()     // Catch:{ all -> 0x007e }
            java.lang.String r3 = r9.H()     // Catch:{ all -> 0x007e }
            int r1 = r1.I(r2, r3)     // Catch:{ all -> 0x007e }
        L_0x0de0:
            if (r1 > 0) goto L_0x0e07
            com.google.android.gms.measurement.internal.n2 r2 = r43.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.L()     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "Sample rate must be positive. event, rate"
            java.lang.String r10 = r9.H()     // Catch:{ all -> 0x007e }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x007e }
            r2.c(r3, r10, r1)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r1 = r9.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r1 = (com.google.android.gms.internal.measurement.C0668s4) r1     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2 r1 = (com.google.android.gms.internal.measurement.C0599k2) r1     // Catch:{ all -> 0x007e }
            r5.add(r1)     // Catch:{ all -> 0x007e }
            r0.s(r7, r9)     // Catch:{ all -> 0x007e }
            goto L_0x0d64
        L_0x0e07:
            java.lang.String r2 = r9.H()     // Catch:{ all -> 0x007e }
            java.lang.Object r2 = r4.get(r2)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.A r2 = (com.google.android.gms.measurement.internal.A) r2     // Catch:{ all -> 0x007e }
            if (r2 != 0) goto L_0x0e66
            com.google.android.gms.measurement.internal.k r2 = r43.l0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r3 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r3 = r3.x2()     // Catch:{ all -> 0x007e }
            java.lang.String r10 = r9.H()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.A r2 = r2.L0(r3, r10)     // Catch:{ all -> 0x007e }
            if (r2 != 0) goto L_0x0e66
            com.google.android.gms.measurement.internal.n2 r2 = r43.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.L()     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.p2 r10 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r10 = r10.x2()     // Catch:{ all -> 0x007e }
            r20 = r12
            java.lang.String r12 = r9.H()     // Catch:{ all -> 0x007e }
            r2.c(r3, r10, r12)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.A r26 = new com.google.android.gms.measurement.internal.A     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r2 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r27 = r2.x2()     // Catch:{ all -> 0x007e }
            java.lang.String r28 = r9.H()     // Catch:{ all -> 0x007e }
            long r35 = r9.F()     // Catch:{ all -> 0x007e }
            r41 = 0
            r42 = 0
            r29 = 1
            r31 = 1
            r33 = 1
            r37 = 0
            r39 = 0
            r40 = 0
            r26.<init>(r27, r28, r29, r31, r33, r35, r37, r39, r40, r41, r42)     // Catch:{ all -> 0x007e }
            r2 = r26
            goto L_0x0e68
        L_0x0e66:
            r20 = r12
        L_0x0e68:
            r43.x0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r3 = r9.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r3 = (com.google.android.gms.internal.measurement.C0668s4) r3     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2 r3 = (com.google.android.gms.internal.measurement.C0599k2) r3     // Catch:{ all -> 0x007e }
            java.lang.String r10 = "_eid"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.Z5.f0(r3, r10)     // Catch:{ all -> 0x007e }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x007e }
            if (r3 == 0) goto L_0x0e80
            r10 = 1
        L_0x0e7e:
            r12 = 1
            goto L_0x0e82
        L_0x0e80:
            r10 = 0
            goto L_0x0e7e
        L_0x0e82:
            if (r1 != r12) goto L_0x0eae
            com.google.android.gms.internal.measurement.Z4 r1 = r9.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r1 = (com.google.android.gms.internal.measurement.C0668s4) r1     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2 r1 = (com.google.android.gms.internal.measurement.C0599k2) r1     // Catch:{ all -> 0x007e }
            r5.add(r1)     // Catch:{ all -> 0x007e }
            if (r10 == 0) goto L_0x0ea9
            java.lang.Long r1 = r2.f2291i     // Catch:{ all -> 0x007e }
            if (r1 != 0) goto L_0x0e9d
            java.lang.Long r1 = r2.f2292j     // Catch:{ all -> 0x007e }
            if (r1 != 0) goto L_0x0e9d
            java.lang.Boolean r1 = r2.f2293k     // Catch:{ all -> 0x007e }
            if (r1 == 0) goto L_0x0ea9
        L_0x0e9d:
            r1 = 0
            com.google.android.gms.measurement.internal.A r2 = r2.c(r1, r1, r1)     // Catch:{ all -> 0x007e }
            java.lang.String r1 = r9.H()     // Catch:{ all -> 0x007e }
            r4.put(r1, r2)     // Catch:{ all -> 0x007e }
        L_0x0ea9:
            r0.s(r7, r9)     // Catch:{ all -> 0x007e }
            goto L_0x0d64
        L_0x0eae:
            int r12 = r6.nextInt(r1)     // Catch:{ all -> 0x007e }
            if (r12 != 0) goto L_0x0eeb
            r43.x0()     // Catch:{ all -> 0x007e }
            long r12 = (long) r1     // Catch:{ all -> 0x007e }
            java.lang.Long r1 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.Z5.T(r9, r11, r1)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r1 = r9.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r1 = (com.google.android.gms.internal.measurement.C0668s4) r1     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2 r1 = (com.google.android.gms.internal.measurement.C0599k2) r1     // Catch:{ all -> 0x007e }
            r5.add(r1)     // Catch:{ all -> 0x007e }
            if (r10 == 0) goto L_0x0ed5
            java.lang.Long r1 = java.lang.Long.valueOf(r12)     // Catch:{ all -> 0x007e }
            r3 = 0
            com.google.android.gms.measurement.internal.A r2 = r2.c(r3, r1, r3)     // Catch:{ all -> 0x007e }
        L_0x0ed5:
            java.lang.String r1 = r9.H()     // Catch:{ all -> 0x007e }
            long r10 = r9.F()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.A r2 = r2.b(r10, r14)     // Catch:{ all -> 0x007e }
            r4.put(r1, r2)     // Catch:{ all -> 0x007e }
            r46 = r6
            r1 = r7
            r18 = 1
            goto L_0x0f61
        L_0x0eeb:
            java.lang.Long r12 = r2.f2290h     // Catch:{ all -> 0x007e }
            if (r12 == 0) goto L_0x0ef8
            long r12 = r12.longValue()     // Catch:{ all -> 0x007e }
            r46 = r6
            r22 = r7
            goto L_0x0f09
        L_0x0ef8:
            r43.y0()     // Catch:{ all -> 0x007e }
            long r12 = r9.C()     // Catch:{ all -> 0x007e }
            r46 = r6
            r22 = r7
            r6 = r20
            long r12 = com.google.android.gms.measurement.internal.d6.v(r12, r6)     // Catch:{ all -> 0x007e }
        L_0x0f09:
            int r6 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0f50
            r43.x0()     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "_efs"
            r18 = 1
            java.lang.Long r6 = java.lang.Long.valueOf(r18)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.Z5.T(r9, r3, r6)     // Catch:{ all -> 0x007e }
            r43.x0()     // Catch:{ all -> 0x007e }
            long r6 = (long) r1     // Catch:{ all -> 0x007e }
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.Z5.T(r9, r11, r1)     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r1 = r9.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r1 = (com.google.android.gms.internal.measurement.C0668s4) r1     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.k2 r1 = (com.google.android.gms.internal.measurement.C0599k2) r1     // Catch:{ all -> 0x007e }
            r5.add(r1)     // Catch:{ all -> 0x007e }
            if (r10 == 0) goto L_0x0f3e
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x007e }
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x007e }
            r6 = 0
            com.google.android.gms.measurement.internal.A r2 = r2.c(r6, r1, r3)     // Catch:{ all -> 0x007e }
        L_0x0f3e:
            java.lang.String r1 = r9.H()     // Catch:{ all -> 0x007e }
            long r6 = r9.F()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.A r2 = r2.b(r6, r14)     // Catch:{ all -> 0x007e }
            r4.put(r1, r2)     // Catch:{ all -> 0x007e }
        L_0x0f4d:
            r1 = r22
            goto L_0x0f61
        L_0x0f50:
            r18 = 1
            if (r10 == 0) goto L_0x0f4d
            java.lang.String r1 = r9.H()     // Catch:{ all -> 0x007e }
            r6 = 0
            com.google.android.gms.measurement.internal.A r2 = r2.c(r3, r6, r6)     // Catch:{ all -> 0x007e }
            r4.put(r1, r2)     // Catch:{ all -> 0x007e }
            goto L_0x0f4d
        L_0x0f61:
            r0.s(r1, r9)     // Catch:{ all -> 0x007e }
        L_0x0f64:
            int r7 = r1 + 1
            r1 = r43
            r2 = r44
            r6 = r46
            goto L_0x0cce
        L_0x0f6e:
            r44 = r2
            int r1 = r5.size()     // Catch:{ all -> 0x007e }
            int r2 = r0.T()     // Catch:{ all -> 0x007e }
            if (r1 >= r2) goto L_0x0f81
            com.google.android.gms.internal.measurement.p2$a r1 = r0.I0()     // Catch:{ all -> 0x007e }
            r1.Q(r5)     // Catch:{ all -> 0x007e }
        L_0x0f81:
            java.util.Set r1 = r4.entrySet()     // Catch:{ all -> 0x007e }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x007e }
        L_0x0f89:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x007e }
            if (r2 == 0) goto L_0x0fa5
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x007e }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.k r3 = r43.l0()     // Catch:{ all -> 0x007e }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.A r2 = (com.google.android.gms.measurement.internal.A) r2     // Catch:{ all -> 0x007e }
            r3.U(r2)     // Catch:{ all -> 0x007e }
            goto L_0x0f89
        L_0x0fa3:
            r44 = r2
        L_0x0fa5:
            com.google.android.gms.internal.measurement.p2 r1 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r1 = r1.x2()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.k r2 = r43.l0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.c2 r2 = r2.M0(r1)     // Catch:{ all -> 0x007e }
            if (r2 != 0) goto L_0x0fce
            com.google.android.gms.measurement.internal.n2 r2 = r43.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.G()     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.p2 r4 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r4.x2()     // Catch:{ all -> 0x007e }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C0821n2.s(r4)     // Catch:{ all -> 0x007e }
            r2.b(r3, r4)     // Catch:{ all -> 0x007e }
            goto L_0x1056
        L_0x0fce:
            int r3 = r0.T()     // Catch:{ all -> 0x007e }
            if (r3 <= 0) goto L_0x1056
            long r3 = r2.D0()     // Catch:{ all -> 0x007e }
            int r5 = (r3 > r44 ? 1 : (r3 == r44 ? 0 : -1))
            if (r5 == 0) goto L_0x0fe0
            r0.q0(r3)     // Catch:{ all -> 0x007e }
            goto L_0x0fe3
        L_0x0fe0:
            r0.P0()     // Catch:{ all -> 0x007e }
        L_0x0fe3:
            long r5 = r2.H0()     // Catch:{ all -> 0x007e }
            int r7 = (r5 > r44 ? 1 : (r5 == r44 ? 0 : -1))
            if (r7 != 0) goto L_0x0fec
            goto L_0x0fed
        L_0x0fec:
            r3 = r5
        L_0x0fed:
            int r5 = (r3 > r44 ? 1 : (r3 == r44 ? 0 : -1))
            if (r5 == 0) goto L_0x0ff5
            r0.u0(r3)     // Catch:{ all -> 0x007e }
            goto L_0x0ff8
        L_0x0ff5:
            r0.R0()     // Catch:{ all -> 0x007e }
        L_0x0ff8:
            boolean r3 = com.google.android.gms.internal.measurement.r7.a()     // Catch:{ all -> 0x007e }
            if (r3 == 0) goto L_0x1028
            com.google.android.gms.measurement.internal.g r3 = r43.i0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.b2 r4 = com.google.android.gms.measurement.internal.G.f2518y0     // Catch:{ all -> 0x007e }
            boolean r3 = r3.q(r4)     // Catch:{ all -> 0x007e }
            if (r3 == 0) goto L_0x1028
            r43.y0()     // Catch:{ all -> 0x007e }
            java.lang.String r3 = r2.l()     // Catch:{ all -> 0x007e }
            boolean r3 = com.google.android.gms.measurement.internal.d6.H0(r3)     // Catch:{ all -> 0x007e }
            if (r3 == 0) goto L_0x1028
            int r3 = r0.T()     // Catch:{ all -> 0x007e }
            long r3 = (long) r3     // Catch:{ all -> 0x007e }
            r2.c(r3)     // Catch:{ all -> 0x007e }
            long r3 = r2.B0()     // Catch:{ all -> 0x007e }
            int r4 = (int) r3     // Catch:{ all -> 0x007e }
            r0.p0(r4)     // Catch:{ all -> 0x007e }
            goto L_0x102b
        L_0x1028:
            r2.y()     // Catch:{ all -> 0x007e }
        L_0x102b:
            long r3 = r2.F0()     // Catch:{ all -> 0x007e }
            int r4 = (int) r3     // Catch:{ all -> 0x007e }
            r0.l0(r4)     // Catch:{ all -> 0x007e }
            long r3 = r0.k0()     // Catch:{ all -> 0x007e }
            r2.C0(r3)     // Catch:{ all -> 0x007e }
            long r3 = r0.f0()     // Catch:{ all -> 0x007e }
            r2.y0(r3)     // Catch:{ all -> 0x007e }
            java.lang.String r3 = r2.k()     // Catch:{ all -> 0x007e }
            if (r3 == 0) goto L_0x104b
            r0.O0(r3)     // Catch:{ all -> 0x007e }
            goto L_0x104e
        L_0x104b:
            r0.L0()     // Catch:{ all -> 0x007e }
        L_0x104e:
            com.google.android.gms.measurement.internal.k r3 = r43.l0()     // Catch:{ all -> 0x007e }
            r4 = 0
            r3.V(r2, r4, r4)     // Catch:{ all -> 0x007e }
        L_0x1056:
            int r2 = r0.T()     // Catch:{ all -> 0x007e }
            if (r2 <= 0) goto L_0x10b5
            com.google.android.gms.measurement.internal.I2 r2 = r43.r0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r3 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r3 = r3.x2()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.T1 r2 = r2.L(r3)     // Catch:{ all -> 0x007e }
            if (r2 == 0) goto L_0x107b
            boolean r3 = r2.Z()     // Catch:{ all -> 0x007e }
            if (r3 != 0) goto L_0x1073
            goto L_0x107b
        L_0x1073:
            long r2 = r2.K()     // Catch:{ all -> 0x007e }
            r0.P(r2)     // Catch:{ all -> 0x007e }
            goto L_0x10a4
        L_0x107b:
            com.google.android.gms.internal.measurement.p2 r2 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r2 = r2.d0()     // Catch:{ all -> 0x007e }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x007e }
            if (r2 == 0) goto L_0x108d
            r2 = r23
            r0.P(r2)     // Catch:{ all -> 0x007e }
            goto L_0x10a4
        L_0x108d:
            com.google.android.gms.measurement.internal.n2 r2 = r43.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.L()     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.p2 r4 = r8.f2563a     // Catch:{ all -> 0x007e }
            java.lang.String r4 = r4.x2()     // Catch:{ all -> 0x007e }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C0821n2.s(r4)     // Catch:{ all -> 0x007e }
            r2.b(r3, r4)     // Catch:{ all -> 0x007e }
        L_0x10a4:
            com.google.android.gms.measurement.internal.k r2 = r43.l0()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.Z4 r0 = r0.m()     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.s4 r0 = (com.google.android.gms.internal.measurement.C0668s4) r0     // Catch:{ all -> 0x007e }
            com.google.android.gms.internal.measurement.p2 r0 = (com.google.android.gms.internal.measurement.C0643p2) r0     // Catch:{ all -> 0x007e }
            r13 = r17
            r2.f0(r0, r13)     // Catch:{ all -> 0x007e }
        L_0x10b5:
            com.google.android.gms.measurement.internal.k r0 = r43.l0()     // Catch:{ all -> 0x007e }
            java.util.List r2 = r8.f2564b     // Catch:{ all -> 0x007e }
            M.C0335p.l(r2)     // Catch:{ all -> 0x007e }
            r0.k()     // Catch:{ all -> 0x007e }
            r0.r()     // Catch:{ all -> 0x007e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x007e }
            java.lang.String r4 = "rowid in ("
            r3.<init>(r4)     // Catch:{ all -> 0x007e }
            r13 = 0
        L_0x10cc:
            int r4 = r2.size()     // Catch:{ all -> 0x007e }
            if (r13 >= r4) goto L_0x10e9
            if (r13 == 0) goto L_0x10d9
            java.lang.String r4 = ","
            r3.append(r4)     // Catch:{ all -> 0x007e }
        L_0x10d9:
            java.lang.Object r4 = r2.get(r13)     // Catch:{ all -> 0x007e }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ all -> 0x007e }
            long r4 = r4.longValue()     // Catch:{ all -> 0x007e }
            r3.append(r4)     // Catch:{ all -> 0x007e }
            int r13 = r13 + 1
            goto L_0x10cc
        L_0x10e9:
            java.lang.String r4 = ")"
            r3.append(r4)     // Catch:{ all -> 0x007e }
            android.database.sqlite.SQLiteDatabase r4 = r0.y()     // Catch:{ all -> 0x007e }
            java.lang.String r5 = "raw_events"
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x007e }
            r6 = 0
            int r3 = r4.delete(r5, r3, r6)     // Catch:{ all -> 0x007e }
            int r4 = r2.size()     // Catch:{ all -> 0x007e }
            if (r3 == r4) goto L_0x111c
            com.google.android.gms.measurement.internal.n2 r0 = r0.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()     // Catch:{ all -> 0x007e }
            java.lang.String r4 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x007e }
            int r2 = r2.size()     // Catch:{ all -> 0x007e }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x007e }
            r0.c(r4, r3, r2)     // Catch:{ all -> 0x007e }
        L_0x111c:
            com.google.android.gms.measurement.internal.k r2 = r43.l0()     // Catch:{ all -> 0x007e }
            android.database.sqlite.SQLiteDatabase r0 = r2.y()     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            java.lang.String[] r4 = new java.lang.String[]{r1, r1}     // Catch:{ SQLiteException -> 0x112e }
            r0.execSQL(r3, r4)     // Catch:{ SQLiteException -> 0x112e }
            goto L_0x1140
        L_0x112e:
            r0 = move-exception
            com.google.android.gms.measurement.internal.n2 r2 = r2.a()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.G()     // Catch:{ all -> 0x007e }
            java.lang.String r3 = "Failed to remove unused event metadata. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.C0821n2.s(r1)     // Catch:{ all -> 0x007e }
            r2.c(r3, r1, r0)     // Catch:{ all -> 0x007e }
        L_0x1140:
            com.google.android.gms.measurement.internal.k r0 = r43.l0()     // Catch:{ all -> 0x007e }
            r0.k1()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.k r0 = r43.l0()
            r0.i1()
            r25 = 1
            return r25
        L_0x1151:
            com.google.android.gms.measurement.internal.k r0 = r43.l0()     // Catch:{ all -> 0x007e }
            r0.k1()     // Catch:{ all -> 0x007e }
            com.google.android.gms.measurement.internal.k r0 = r43.l0()
            r0.i1()
            r16 = 0
            return r16
        L_0x1162:
            if (r5 == 0) goto L_0x1167
            r5.close()     // Catch:{ all -> 0x007e }
        L_0x1167:
            throw r0     // Catch:{ all -> 0x007e }
        L_0x1168:
            com.google.android.gms.measurement.internal.k r1 = r43.l0()
            r1.i1()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.H5.O(java.lang.String, long):boolean");
    }

    private final void P() {
        f().k();
        if (this.f2556t || this.f2557u || this.f2558v) {
            a().K().d("Not stopping services. fetch, network, upload", Boolean.valueOf(this.f2556t), Boolean.valueOf(this.f2557u), Boolean.valueOf(this.f2558v));
            return;
        }
        a().K().a("Stopping uploading service(s)");
        List<Runnable> list = this.f2552p;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            ((List) C0335p.l(this.f2552p)).clear();
        }
    }

    private final void Q() {
        f().k();
        for (String str : this.f2553q) {
            if (C0604k7.a() && i0().F(str, G.f2421I0)) {
                a().F().b("Notifying app that trigger URIs are available. App ID", str);
                Intent intent = new Intent();
                intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                intent.setPackage(str);
                this.f2548l.A().sendBroadcast(intent);
            }
        }
        this.f2553q.clear();
    }

    private final void R() {
        boolean z4;
        long j4;
        long j5;
        f().k();
        A0();
        if (this.f2551o > 0) {
            long abs = 3600000 - Math.abs(B().elapsedRealtime() - this.f2551o);
            if (abs > 0) {
                a().K().b("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                G0().c();
                H0().w();
                return;
            }
            this.f2551o = 0;
        }
        if (!this.f2548l.p() || !S()) {
            a().K().a("Nothing to upload or uploading impossible");
            G0().c();
            H0().w();
            return;
        }
        long currentTimeMillis = B().currentTimeMillis();
        i0();
        long max = Math.max(0, ((Long) G.f2408C.a((Object) null)).longValue());
        if (l0().n1() || l0().m1()) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            String R4 = i0().R();
            if (TextUtils.isEmpty(R4) || ".none.".equals(R4)) {
                i0();
                j4 = Math.max(0, ((Long) G.f2513w.a((Object) null)).longValue());
            } else {
                i0();
                j4 = Math.max(0, ((Long) G.f2515x.a((Object) null)).longValue());
            }
        } else {
            i0();
            j4 = Math.max(0, ((Long) G.f2511v.a((Object) null)).longValue());
        }
        long a5 = this.f2545i.f3055h.a();
        long a6 = this.f2545i.f3056i.a();
        long j6 = 0;
        long j7 = max;
        long max2 = Math.max(l0().w(), l0().x());
        if (max2 == 0) {
            j5 = 0;
        } else {
            long abs2 = currentTimeMillis - Math.abs(max2 - currentTimeMillis);
            long abs3 = currentTimeMillis - Math.abs(a5 - currentTimeMillis);
            long abs4 = currentTimeMillis - Math.abs(a6 - currentTimeMillis);
            long max3 = Math.max(abs3, abs4);
            long j8 = abs2 + j7;
            if (z4 && max3 > 0) {
                j8 = Math.min(abs2, max3) + j4;
            }
            if (!x0().c0(max3, j4)) {
                j5 = max3 + j4;
            } else {
                j5 = j8;
            }
            if (abs4 != 0 && abs4 >= abs2) {
                int i4 = 0;
                while (true) {
                    i0();
                    if (i4 >= Math.min(20, Math.max(0, ((Integer) G.f2412E.a((Object) null)).intValue()))) {
                        j5 = 0;
                        break;
                    }
                    i0();
                    j5 += Math.max(j6, ((Long) G.f2410D.a((Object) null)).longValue()) * (1 << i4);
                    if (j5 > abs4) {
                        break;
                    }
                    i4++;
                    j6 = 0;
                }
            }
            j6 = 0;
        }
        if (j5 == j6) {
            a().K().a("Next upload time is 0");
            G0().c();
            H0().w();
        } else if (!p0().z()) {
            a().K().a("No network");
            G0().b();
            H0().w();
        } else {
            long a7 = this.f2545i.f3054g.a();
            i0();
            long max4 = Math.max(0, ((Long) G.f2507t.a((Object) null)).longValue());
            if (!x0().c0(a7, max4)) {
                j5 = Math.max(j5, a7 + max4);
            }
            G0().c();
            long currentTimeMillis2 = j5 - B().currentTimeMillis();
            if (currentTimeMillis2 <= 0) {
                i0();
                currentTimeMillis2 = Math.max(0, ((Long) G.f2517y.a((Object) null)).longValue());
                this.f2545i.f3055h.b(B().currentTimeMillis());
            }
            a().K().b("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
            H0().v(currentTimeMillis2);
        }
    }

    private final boolean S() {
        f().k();
        A0();
        if (l0().l1() || !TextUtils.isEmpty(l0().z())) {
            return true;
        }
        return false;
    }

    private final boolean T() {
        f().k();
        FileLock fileLock = this.f2559w;
        if (fileLock == null || !fileLock.isValid()) {
            try {
                FileChannel channel = new RandomAccessFile(new File(C0597k0.a().b(this.f2548l.A().getFilesDir(), "google_app_measurement.db")), "rw").getChannel();
                this.f2560x = channel;
                FileLock tryLock = channel.tryLock();
                this.f2559w = tryLock;
                if (tryLock != null) {
                    a().K().a("Storage concurrent access okay");
                    return true;
                }
                a().G().a("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e5) {
                a().G().b("Failed to acquire storage lock", e5);
                return false;
            } catch (IOException e6) {
                a().G().b("Failed to access storage lock file", e6);
                return false;
            } catch (OverlappingFileLockException e7) {
                a().L().b("Storage lock already acquired", e7);
                return false;
            }
        } else {
            a().K().a("Storage concurrent access okay");
            return true;
        }
    }

    private final void Y(E e5, M5 m5) {
        C0335p.f(m5.f2631a);
        C0848r2 b5 = C0848r2.b(e5);
        y0().N(b5.f3204d, l0().K0(m5.f2631a));
        y0().W(b5, i0().s(m5.f2631a));
        E a5 = b5.a();
        if ("_cmp".equals(a5.f2366a) && "referrer API v2".equals(a5.f2367b.m("_cis"))) {
            String m4 = a5.f2367b.m("gclid");
            if (!TextUtils.isEmpty(m4)) {
                w(new Y5("_lgclid", a5.f2369d, m4, "auto"), m5);
            }
        }
        s(a5, m5);
    }

    private final void Z(C0744c2 c2Var) {
        C0744c2 c2Var2 = c2Var;
        f().k();
        if (!TextUtils.isEmpty(c2Var2.q()) || !TextUtils.isEmpty(c2Var2.j())) {
            ArrayMap arrayMap = null;
            if (!Y6.a() || !i0().q(G.f2417G0)) {
                String s4 = this.f2546j.s(c2Var2);
                try {
                    String str = (String) C0335p.l(c2Var2.l());
                    URL url = new URL(s4);
                    a().K().b("Fetching remote configuration", str);
                    T1 L4 = r0().L(str);
                    String Q4 = r0().Q(str);
                    if (L4 != null) {
                        if (!TextUtils.isEmpty(Q4)) {
                            arrayMap = new ArrayMap();
                            arrayMap.put("If-Modified-Since", Q4);
                        }
                        String O4 = r0().O(str);
                        if (!TextUtils.isEmpty(O4)) {
                            if (arrayMap == null) {
                                arrayMap = new ArrayMap();
                            }
                            arrayMap.put("If-None-Match", O4);
                        }
                    }
                    this.f2556t = true;
                    C0842q2 p02 = p0();
                    Q5 q5 = new Q5(this);
                    p02.k();
                    p02.r();
                    C0335p.l(url);
                    C0335p.l(q5);
                    p02.f().w(new C0869u2(p02, str, url, (byte[]) null, arrayMap, q5));
                } catch (MalformedURLException unused) {
                    a().G().c("Failed to parse config URL. Not fetching. appId", C0821n2.s(c2Var2.l()), s4);
                }
            } else {
                String str2 = (String) C0335p.l(c2Var2.l());
                a().K().b("Fetching remote configuration", str2);
                T1 L5 = r0().L(str2);
                String Q5 = r0().Q(str2);
                if (L5 != null) {
                    if (!TextUtils.isEmpty(Q5)) {
                        arrayMap = new ArrayMap();
                        arrayMap.put("If-Modified-Since", Q5);
                    }
                    String O5 = r0().O(str2);
                    if (!TextUtils.isEmpty(O5)) {
                        if (arrayMap == null) {
                            arrayMap = new ArrayMap();
                        }
                        arrayMap.put("If-None-Match", O5);
                    }
                }
                ArrayMap arrayMap2 = arrayMap;
                this.f2556t = true;
                C0842q2 p03 = p0();
                K5 k5 = new K5(this);
                p03.k();
                p03.r();
                C0335p.l(c2Var2);
                C0335p.l(k5);
                String s5 = p03.q().s(c2Var2);
                try {
                    p03.f().w(new C0869u2(p03, c2Var2.l(), new URI(s5).toURL(), (byte[]) null, arrayMap2, k5));
                } catch (IllegalArgumentException | MalformedURLException | URISyntaxException unused2) {
                    p03.a().G().c("Failed to parse config URL. Not fetching. appId", C0821n2.s(c2Var2.l()), s5);
                }
            }
        } else {
            z((String) C0335p.l(c2Var2.l()), 204, (Throwable) null, (byte[]) null, (Map) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0 = r5.f2537a;
        r3 = com.google.android.gms.measurement.internal.A3.a.AD_PERSONALIZATION;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int b(java.lang.String r6, com.google.android.gms.measurement.internal.C0776h r7) {
        /*
            r5 = this;
            com.google.android.gms.measurement.internal.I2 r0 = r5.f2537a
            com.google.android.gms.internal.measurement.Q1 r0 = r0.J(r6)
            r1 = 1
            if (r0 != 0) goto L_0x0011
            com.google.android.gms.measurement.internal.A3$a r6 = com.google.android.gms.measurement.internal.A3.a.AD_PERSONALIZATION
            com.google.android.gms.measurement.internal.j r0 = com.google.android.gms.measurement.internal.C0790j.FAILSAFE
            r7.d(r6, r0)
            return r1
        L_0x0011:
            com.google.android.gms.measurement.internal.k r0 = r5.l0()
            com.google.android.gms.measurement.internal.c2 r0 = r0.M0(r6)
            r2 = 0
            if (r0 == 0) goto L_0x0043
            java.lang.String r0 = r0.t()
            com.google.android.gms.measurement.internal.B1 r0 = com.google.android.gms.measurement.internal.B1.a(r0)
            f0.p r0 = r0.b()
            f0.p r3 = f0.p.POLICY
            if (r0 != r3) goto L_0x0043
            com.google.android.gms.measurement.internal.I2 r0 = r5.f2537a
            com.google.android.gms.measurement.internal.A3$a r3 = com.google.android.gms.measurement.internal.A3.a.AD_PERSONALIZATION
            f0.p r0 = r0.z(r6, r3)
            f0.p r4 = f0.p.UNINITIALIZED
            if (r0 == r4) goto L_0x0043
            com.google.android.gms.measurement.internal.j r6 = com.google.android.gms.measurement.internal.C0790j.REMOTE_ENFORCED_DEFAULT
            r7.d(r3, r6)
            f0.p r6 = f0.p.GRANTED
            if (r0 != r6) goto L_0x0042
            return r2
        L_0x0042:
            return r1
        L_0x0043:
            com.google.android.gms.measurement.internal.A3$a r0 = com.google.android.gms.measurement.internal.A3.a.AD_PERSONALIZATION
            com.google.android.gms.measurement.internal.j r3 = com.google.android.gms.measurement.internal.C0790j.REMOTE_DEFAULT
            r7.d(r0, r3)
            com.google.android.gms.measurement.internal.I2 r7 = r5.f2537a
            boolean r6 = r7.M(r6, r0)
            if (r6 == 0) goto L_0x0053
            return r2
        L_0x0053:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.H5.b(java.lang.String, com.google.android.gms.measurement.internal.h):int");
    }

    private final int c(FileChannel fileChannel) {
        f().k();
        if (fileChannel == null || !fileChannel.isOpen()) {
            a().G().a("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    a().L().b("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e5) {
            a().G().b("Failed to read from channel", e5);
            return 0;
        }
    }

    private final M5 c0(String str) {
        String str2 = str;
        C0744c2 M02 = l0().M0(str2);
        if (M02 == null || TextUtils.isEmpty(M02.o())) {
            a().F().b("No app data available; dropping", str2);
            return null;
        }
        Boolean k4 = k(M02);
        if (k4 == null || k4.booleanValue()) {
            C0744c2 c2Var = M02;
            C0744c2 c2Var2 = c2Var;
            C0744c2 c2Var3 = c2Var2;
            C0744c2 c2Var4 = c2Var3;
            C0744c2 c2Var5 = c2Var4;
            return new M5(str2, c2Var.q(), c2Var.o(), c2Var2.U(), c2Var3.n(), c2Var4.z0(), c2Var5.t0(), (String) null, c2Var5.A(), false, c2Var5.p(), c2Var5.Q(), 0, 0, c2Var5.z(), false, c2Var5.j(), c2Var5.K0(), c2Var5.v0(), c2Var5.w(), (String) null, U(str).x(), "", (String) null, c2Var5.C(), c2Var5.J0(), U(str).b(), g0(str).j(), c2Var5.a(), c2Var5.X(), c2Var5.v(), c2Var5.t());
        }
        a().G().b("App version does not match; dropping. appId", C0821n2.s(str2));
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        r9 = r7.f2537a;
        r0 = com.google.android.gms.measurement.internal.A3.a.AD_USER_DATA;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.measurement.internal.C0873v e(java.lang.String r8, com.google.android.gms.measurement.internal.C0873v r9, com.google.android.gms.measurement.internal.A3 r10, com.google.android.gms.measurement.internal.C0776h r11) {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.I2 r0 = r7.r0()
            com.google.android.gms.internal.measurement.Q1 r0 = r0.J(r8)
            java.lang.String r1 = "-"
            r2 = 90
            if (r0 != 0) goto L_0x0031
            f0.p r8 = r9.g()
            f0.p r10 = f0.p.DENIED
            if (r8 != r10) goto L_0x0020
            int r2 = r9.a()
            com.google.android.gms.measurement.internal.A3$a r8 = com.google.android.gms.measurement.internal.A3.a.AD_USER_DATA
            r11.c(r8, r2)
            goto L_0x0027
        L_0x0020:
            com.google.android.gms.measurement.internal.A3$a r8 = com.google.android.gms.measurement.internal.A3.a.AD_USER_DATA
            com.google.android.gms.measurement.internal.j r9 = com.google.android.gms.measurement.internal.C0790j.FAILSAFE
            r11.d(r8, r9)
        L_0x0027:
            com.google.android.gms.measurement.internal.v r8 = new com.google.android.gms.measurement.internal.v
            java.lang.Boolean r9 = java.lang.Boolean.FALSE
            java.lang.Boolean r10 = java.lang.Boolean.TRUE
            r8.<init>((java.lang.Boolean) r9, (int) r2, (java.lang.Boolean) r10, (java.lang.String) r1)
            return r8
        L_0x0031:
            f0.p r0 = r9.g()
            f0.p r3 = f0.p.GRANTED
            if (r0 == r3) goto L_0x0087
            f0.p r4 = f0.p.DENIED
            if (r0 != r4) goto L_0x003e
            goto L_0x0087
        L_0x003e:
            f0.p r9 = f0.p.POLICY
            if (r0 != r9) goto L_0x0055
            com.google.android.gms.measurement.internal.I2 r9 = r7.f2537a
            com.google.android.gms.measurement.internal.A3$a r0 = com.google.android.gms.measurement.internal.A3.a.AD_USER_DATA
            f0.p r9 = r9.z(r8, r0)
            f0.p r5 = f0.p.UNINITIALIZED
            if (r9 == r5) goto L_0x0055
            com.google.android.gms.measurement.internal.j r10 = com.google.android.gms.measurement.internal.C0790j.REMOTE_ENFORCED_DEFAULT
            r11.d(r0, r10)
            r0 = r9
            goto L_0x0090
        L_0x0055:
            com.google.android.gms.measurement.internal.I2 r9 = r7.f2537a
            com.google.android.gms.measurement.internal.A3$a r0 = com.google.android.gms.measurement.internal.A3.a.AD_USER_DATA
            com.google.android.gms.measurement.internal.A3$a r9 = r9.K(r8, r0)
            f0.p r10 = r10.t()
            if (r10 == r3) goto L_0x0068
            if (r10 != r4) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r5 = 0
            goto L_0x0069
        L_0x0068:
            r5 = 1
        L_0x0069:
            com.google.android.gms.measurement.internal.A3$a r6 = com.google.android.gms.measurement.internal.A3.a.AD_STORAGE
            if (r9 != r6) goto L_0x0076
            if (r5 == 0) goto L_0x0076
            com.google.android.gms.measurement.internal.j r9 = com.google.android.gms.measurement.internal.C0790j.REMOTE_DELEGATION
            r11.d(r0, r9)
            r0 = r10
            goto L_0x0090
        L_0x0076:
            com.google.android.gms.measurement.internal.j r9 = com.google.android.gms.measurement.internal.C0790j.REMOTE_DEFAULT
            r11.d(r0, r9)
            com.google.android.gms.measurement.internal.I2 r9 = r7.f2537a
            boolean r9 = r9.M(r8, r0)
            if (r9 == 0) goto L_0x0085
            r0 = r3
            goto L_0x0090
        L_0x0085:
            r0 = r4
            goto L_0x0090
        L_0x0087:
            int r2 = r9.a()
            com.google.android.gms.measurement.internal.A3$a r9 = com.google.android.gms.measurement.internal.A3.a.AD_USER_DATA
            r11.c(r9, r2)
        L_0x0090:
            com.google.android.gms.measurement.internal.I2 r9 = r7.f2537a
            boolean r9 = r9.Y(r8)
            com.google.android.gms.measurement.internal.I2 r10 = r7.r0()
            java.util.SortedSet r8 = r10.T(r8)
            f0.p r10 = f0.p.DENIED
            if (r0 == r10) goto L_0x00bd
            boolean r10 = r8.isEmpty()
            if (r10 == 0) goto L_0x00a9
            goto L_0x00bd
        L_0x00a9:
            com.google.android.gms.measurement.internal.v r10 = new com.google.android.gms.measurement.internal.v
            java.lang.Boolean r11 = java.lang.Boolean.TRUE
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r9)
            java.lang.String r1 = ""
            if (r9 == 0) goto L_0x00b9
            java.lang.String r1 = android.text.TextUtils.join(r1, r8)
        L_0x00b9:
            r10.<init>((java.lang.Boolean) r11, (int) r2, (java.lang.Boolean) r0, (java.lang.String) r1)
            return r10
        L_0x00bd:
            com.google.android.gms.measurement.internal.v r8 = new com.google.android.gms.measurement.internal.v
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            r8.<init>((java.lang.Boolean) r10, (int) r2, (java.lang.Boolean) r9, (java.lang.String) r1)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.H5.e(java.lang.String, com.google.android.gms.measurement.internal.v, com.google.android.gms.measurement.internal.A3, com.google.android.gms.measurement.internal.h):com.google.android.gms.measurement.internal.v");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:159:0x04fa */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0309 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0392 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x03bd  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0506 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0541 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x05c0 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x060f A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x061c A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0629 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0636 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0644 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0655 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x06ad A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x073f A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0751 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0797 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x07e0 A[SYNTHETIC, Splitter:B:273:0x07e0] */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x0803 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x0874 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:292:0x088d A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x08ef A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0917 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0935 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x09ab A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x0a07 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01b5 A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x022e A[Catch:{ SQLiteException -> 0x02b7, all -> 0x018e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void e0(com.google.android.gms.measurement.internal.E r39, com.google.android.gms.measurement.internal.M5 r40) {
        /*
            r38 = this;
            r1 = r38
            r0 = r39
            r2 = r40
            java.lang.String r3 = "_fx"
            java.lang.String r4 = "_sno"
            M.C0335p.l(r2)
            java.lang.String r5 = r2.f2631a
            M.C0335p.f(r5)
            long r5 = java.lang.System.nanoTime()
            com.google.android.gms.measurement.internal.P2 r7 = r1.f()
            r7.k()
            r1.A0()
            java.lang.String r9 = r2.f2631a
            r1.x0()
            boolean r7 = com.google.android.gms.measurement.internal.Z5.d0(r39, r40)
            if (r7 != 0) goto L_0x002d
            goto L_0x00db
        L_0x002d:
            boolean r7 = r2.f2638h
            if (r7 != 0) goto L_0x0035
            r1.g(r2)
            return
        L_0x0035:
            com.google.android.gms.measurement.internal.I2 r7 = r1.r0()
            java.lang.String r8 = r0.f2366a
            boolean r7 = r7.P(r9, r8)
            java.lang.String r15 = "_err"
            r14 = 0
            r10 = 0
            if (r7 == 0) goto L_0x00dc
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()
            com.google.android.gms.measurement.internal.p2 r2 = r2.L()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C0821n2.s(r9)
            com.google.android.gms.measurement.internal.S2 r4 = r1.f2548l
            com.google.android.gms.measurement.internal.h2 r4 = r4.D()
            java.lang.String r5 = r0.f2366a
            java.lang.String r4 = r4.c(r5)
            java.lang.String r5 = "Dropping blocked event. appId"
            r2.c(r5, r3, r4)
            com.google.android.gms.measurement.internal.I2 r2 = r1.r0()
            boolean r2 = r2.X(r9)
            if (r2 != 0) goto L_0x0079
            com.google.android.gms.measurement.internal.I2 r2 = r1.r0()
            boolean r2 = r2.Z(r9)
            if (r2 == 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            r2 = 0
            goto L_0x007a
        L_0x0079:
            r2 = 1
        L_0x007a:
            if (r2 != 0) goto L_0x0093
            java.lang.String r3 = r0.f2366a
            boolean r3 = r15.equals(r3)
            if (r3 != 0) goto L_0x0093
            r1.y0()
            com.google.android.gms.measurement.internal.c6 r8 = r1.f2536G
            java.lang.String r12 = r0.f2366a
            r13 = 0
            r10 = 11
            java.lang.String r11 = "_ev"
            com.google.android.gms.measurement.internal.d6.Z(r8, r9, r10, r11, r12, r13)
        L_0x0093:
            if (r2 == 0) goto L_0x00db
            com.google.android.gms.measurement.internal.k r0 = r1.l0()
            com.google.android.gms.measurement.internal.c2 r0 = r0.M0(r9)
            if (r0 == 0) goto L_0x00db
            long r2 = r0.x0()
            long r4 = r0.a0()
            long r2 = java.lang.Math.max(r2, r4)
            R.d r4 = r1.B()
            long r4 = r4.currentTimeMillis()
            long r4 = r4 - r2
            long r2 = java.lang.Math.abs(r4)
            r1.i0()
            com.google.android.gms.measurement.internal.b2 r4 = com.google.android.gms.measurement.internal.G.f2406B
            java.lang.Object r4 = r4.a(r14)
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x00db
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()
            com.google.android.gms.measurement.internal.p2 r2 = r2.F()
            java.lang.String r3 = "Fetching config for blocked app"
            r2.a(r3)
            r1.Z(r0)
        L_0x00db:
            return
        L_0x00dc:
            com.google.android.gms.measurement.internal.r2 r0 = com.google.android.gms.measurement.internal.C0848r2.b(r0)
            com.google.android.gms.measurement.internal.d6 r7 = r1.y0()
            com.google.android.gms.measurement.internal.g r11 = r1.i0()
            int r11 = r11.s(r9)
            r7.W(r0, r11)
            com.google.android.gms.measurement.internal.g r7 = r1.i0()
            com.google.android.gms.measurement.internal.b2 r11 = com.google.android.gms.measurement.internal.G.f2442T
            r12 = 10
            r13 = 35
            int r7 = r7.n(r9, r11, r12, r13)
            java.util.TreeSet r11 = new java.util.TreeSet
            android.os.Bundle r12 = r0.f3204d
            java.util.Set r12 = r12.keySet()
            r11.<init>(r12)
            java.util.Iterator r11 = r11.iterator()
        L_0x010c:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x012e
            java.lang.Object r12 = r11.next()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.String r13 = "items"
            boolean r13 = r13.equals(r12)
            if (r13 == 0) goto L_0x010c
            com.google.android.gms.measurement.internal.d6 r13 = r1.y0()
            android.os.Bundle r8 = r0.f3204d
            android.os.Parcelable[] r8 = r8.getParcelableArray(r12)
            r13.b0(r8, r7)
            goto L_0x010c
        L_0x012e:
            com.google.android.gms.measurement.internal.E r7 = r0.a()
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()
            r8 = 2
            boolean r0 = r0.z(r8)
            if (r0 == 0) goto L_0x0154
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.K()
            com.google.android.gms.measurement.internal.S2 r8 = r1.f2548l
            com.google.android.gms.measurement.internal.h2 r8 = r8.D()
            java.lang.String r8 = r8.b(r7)
            java.lang.String r11 = "Logging event"
            r0.b(r11, r8)
        L_0x0154:
            boolean r0 = com.google.android.gms.internal.measurement.S6.a()
            if (r0 == 0) goto L_0x0163
            com.google.android.gms.measurement.internal.g r0 = r1.i0()
            com.google.android.gms.measurement.internal.b2 r8 = com.google.android.gms.measurement.internal.G.f2413E0
            r0.q(r8)
        L_0x0163:
            com.google.android.gms.measurement.internal.k r0 = r1.l0()
            r0.c1()
            r1.g(r2)     // Catch:{ all -> 0x018e }
            java.lang.String r0 = "ecommerce_purchase"
            java.lang.String r8 = r7.f2366a     // Catch:{ all -> 0x018e }
            boolean r0 = r0.equals(r8)     // Catch:{ all -> 0x018e }
            java.lang.String r8 = "refund"
            if (r0 != 0) goto L_0x0191
            java.lang.String r0 = "purchase"
            java.lang.String r11 = r7.f2366a     // Catch:{ all -> 0x018e }
            boolean r0 = r0.equals(r11)     // Catch:{ all -> 0x018e }
            if (r0 != 0) goto L_0x0191
            java.lang.String r0 = r7.f2366a     // Catch:{ all -> 0x018e }
            boolean r0 = r8.equals(r0)     // Catch:{ all -> 0x018e }
            if (r0 == 0) goto L_0x018c
            goto L_0x0191
        L_0x018c:
            r0 = 0
            goto L_0x0192
        L_0x018e:
            r0 = move-exception
            goto L_0x0a51
        L_0x0191:
            r0 = 1
        L_0x0192:
            java.lang.String r11 = "_iap"
            java.lang.String r12 = r7.f2366a     // Catch:{ all -> 0x018e }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x018e }
            java.lang.String r12 = "value"
            if (r11 != 0) goto L_0x01ab
            if (r0 == 0) goto L_0x01a1
            goto L_0x01ab
        L_0x01a1:
            r23 = r5
            r5 = r12
            r21 = r15
        L_0x01a6:
            r6 = 1
            r19 = 0
            goto L_0x033b
        L_0x01ab:
            com.google.android.gms.measurement.internal.D r11 = r7.f2367b     // Catch:{ all -> 0x018e }
            java.lang.String r13 = "currency"
            java.lang.String r11 = r11.m(r13)     // Catch:{ all -> 0x018e }
            if (r0 == 0) goto L_0x021c
            com.google.android.gms.measurement.internal.D r0 = r7.f2367b     // Catch:{ all -> 0x018e }
            java.lang.Double r0 = r0.h(r12)     // Catch:{ all -> 0x018e }
            double r17 = r0.doubleValue()     // Catch:{ all -> 0x018e }
            r19 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r17 = r17 * r19
            r21 = 0
            int r0 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
            if (r0 != 0) goto L_0x01dc
            com.google.android.gms.measurement.internal.D r0 = r7.f2367b     // Catch:{ all -> 0x018e }
            java.lang.Long r0 = r0.k(r12)     // Catch:{ all -> 0x018e }
            r21 = r15
            long r14 = r0.longValue()     // Catch:{ all -> 0x018e }
            double r14 = (double) r14     // Catch:{ all -> 0x018e }
            double r17 = r14 * r19
            goto L_0x01de
        L_0x01dc:
            r21 = r15
        L_0x01de:
            r14 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r0 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r0 > 0) goto L_0x01f8
            r14 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r0 = (r17 > r14 ? 1 : (r17 == r14 ? 0 : -1))
            if (r0 < 0) goto L_0x01f8
            long r14 = java.lang.Math.round(r17)     // Catch:{ all -> 0x018e }
            java.lang.String r0 = r7.f2366a     // Catch:{ all -> 0x018e }
            boolean r0 = r8.equals(r0)     // Catch:{ all -> 0x018e }
            if (r0 == 0) goto L_0x0228
            long r14 = -r14
            goto L_0x0228
        L_0x01f8:
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.p2 r0 = r0.L()     // Catch:{ all -> 0x018e }
            java.lang.String r2 = "Data lost. Currency value is too big. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C0821n2.s(r9)     // Catch:{ all -> 0x018e }
            java.lang.Double r4 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x018e }
            r0.c(r2, r3, r4)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.k r0 = r1.l0()     // Catch:{ all -> 0x018e }
            r0.k1()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.k r0 = r1.l0()
            r0.i1()
            return
        L_0x021c:
            r21 = r15
            com.google.android.gms.measurement.internal.D r0 = r7.f2367b     // Catch:{ all -> 0x018e }
            java.lang.Long r0 = r0.k(r12)     // Catch:{ all -> 0x018e }
            long r14 = r0.longValue()     // Catch:{ all -> 0x018e }
        L_0x0228:
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x018e }
            if (r0 != 0) goto L_0x0336
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ all -> 0x018e }
            java.lang.String r0 = r11.toUpperCase(r0)     // Catch:{ all -> 0x018e }
            java.lang.String r8 = "[A-Z]{3}"
            boolean r8 = r0.matches(r8)     // Catch:{ all -> 0x018e }
            if (r8 == 0) goto L_0x0336
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x018e }
            java.lang.String r11 = "_ltv_"
            r8.<init>(r11)     // Catch:{ all -> 0x018e }
            r8.append(r0)     // Catch:{ all -> 0x018e }
            java.lang.String r11 = r8.toString()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.k r0 = r1.l0()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.a6 r0 = r0.N0(r9, r11)     // Catch:{ all -> 0x018e }
            if (r0 == 0) goto L_0x025a
            java.lang.Object r0 = r0.f2858e     // Catch:{ all -> 0x018e }
            boolean r8 = r0 instanceof java.lang.Long     // Catch:{ all -> 0x018e }
            if (r8 != 0) goto L_0x0263
        L_0x025a:
            r23 = r5
            r5 = r12
            r6 = 0
            r16 = 1
            r19 = 0
            goto L_0x028b
        L_0x0263:
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ all -> 0x018e }
            long r17 = r0.longValue()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.a6 r8 = new com.google.android.gms.measurement.internal.a6     // Catch:{ all -> 0x018e }
            r19 = 0
            java.lang.String r10 = r7.f2368c     // Catch:{ all -> 0x018e }
            R.d r0 = r1.B()     // Catch:{ all -> 0x018e }
            long r22 = r0.currentTimeMillis()     // Catch:{ all -> 0x018e }
            long r17 = r17 + r14
            java.lang.Long r14 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x018e }
            r15 = r5
            r5 = r12
            r12 = r22
            r23 = r15
            r15 = 0
            r16 = 1
            r8.<init>(r9, r10, r11, r12, r14)     // Catch:{ all -> 0x018e }
            r6 = 1
            goto L_0x02ff
        L_0x028b:
            com.google.android.gms.measurement.internal.k r8 = r1.l0()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.g r0 = r1.i0()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.b2 r10 = com.google.android.gms.measurement.internal.G.f2418H     // Catch:{ all -> 0x018e }
            int r0 = r0.t(r9, r10)     // Catch:{ all -> 0x018e }
            int r0 = r0 + -1
            M.C0335p.f(r9)     // Catch:{ all -> 0x018e }
            r8.k()     // Catch:{ all -> 0x018e }
            r8.r()     // Catch:{ all -> 0x018e }
            android.database.sqlite.SQLiteDatabase r10 = r8.y()     // Catch:{ SQLiteException -> 0x02b7 }
            com.google.android.gms.measurement.internal.g r12 = r8.b()     // Catch:{ SQLiteException -> 0x02b7 }
            com.google.android.gms.measurement.internal.b2 r13 = com.google.android.gms.measurement.internal.G.f2494m1     // Catch:{ SQLiteException -> 0x02b7 }
            boolean r12 = r12.q(r13)     // Catch:{ SQLiteException -> 0x02b7 }
            if (r12 == 0) goto L_0x02b9
            java.lang.String r12 = "and name like '!_ltv!_%' escape '!'"
            goto L_0x02bb
        L_0x02b7:
            r0 = move-exception
            goto L_0x02da
        L_0x02b9:
            java.lang.String r12 = "and name like '_ltv_%' "
        L_0x02bb:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x02b7 }
            java.lang.String r6 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? "
            r13.<init>(r6)     // Catch:{ SQLiteException -> 0x02b7 }
            r13.append(r12)     // Catch:{ SQLiteException -> 0x02b7 }
            java.lang.String r6 = "order by set_timestamp desc limit ?,10);"
            r13.append(r6)     // Catch:{ SQLiteException -> 0x02b7 }
            java.lang.String r6 = r13.toString()     // Catch:{ SQLiteException -> 0x02b7 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ SQLiteException -> 0x02b7 }
            java.lang.String[] r0 = new java.lang.String[]{r9, r9, r0}     // Catch:{ SQLiteException -> 0x02b7 }
            r10.execSQL(r6, r0)     // Catch:{ SQLiteException -> 0x02b7 }
            goto L_0x02eb
        L_0x02da:
            com.google.android.gms.measurement.internal.n2 r6 = r8.a()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.p2 r6 = r6.G()     // Catch:{ all -> 0x018e }
            java.lang.String r8 = "Error pruning currencies. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.C0821n2.s(r9)     // Catch:{ all -> 0x018e }
            r6.c(r8, r10, r0)     // Catch:{ all -> 0x018e }
        L_0x02eb:
            com.google.android.gms.measurement.internal.a6 r8 = new com.google.android.gms.measurement.internal.a6     // Catch:{ all -> 0x018e }
            java.lang.String r10 = r7.f2368c     // Catch:{ all -> 0x018e }
            R.d r0 = r1.B()     // Catch:{ all -> 0x018e }
            long r12 = r0.currentTimeMillis()     // Catch:{ all -> 0x018e }
            java.lang.Long r14 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x018e }
            r6 = 1
            r8.<init>(r9, r10, r11, r12, r14)     // Catch:{ all -> 0x018e }
        L_0x02ff:
            com.google.android.gms.measurement.internal.k r0 = r1.l0()     // Catch:{ all -> 0x018e }
            boolean r0 = r0.i0(r8)     // Catch:{ all -> 0x018e }
            if (r0 != 0) goto L_0x033b
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()     // Catch:{ all -> 0x018e }
            java.lang.String r10 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.C0821n2.s(r9)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.S2 r12 = r1.f2548l     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.h2 r12 = r12.D()     // Catch:{ all -> 0x018e }
            java.lang.String r13 = r8.f2856c     // Catch:{ all -> 0x018e }
            java.lang.String r12 = r12.g(r13)     // Catch:{ all -> 0x018e }
            java.lang.Object r8 = r8.f2858e     // Catch:{ all -> 0x018e }
            r0.d(r10, r11, r12, r8)     // Catch:{ all -> 0x018e }
            r1.y0()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.c6 r8 = r1.f2536G     // Catch:{ all -> 0x018e }
            r12 = 0
            r13 = 0
            r10 = 9
            r11 = 0
            com.google.android.gms.measurement.internal.d6.Z(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x018e }
            goto L_0x033b
        L_0x0336:
            r23 = r5
            r5 = r12
            goto L_0x01a6
        L_0x033b:
            java.lang.String r0 = r7.f2366a     // Catch:{ all -> 0x018e }
            boolean r15 = com.google.android.gms.measurement.internal.d6.K0(r0)     // Catch:{ all -> 0x018e }
            java.lang.String r0 = r7.f2366a     // Catch:{ all -> 0x018e }
            r8 = r21
            boolean r17 = r8.equals(r0)     // Catch:{ all -> 0x018e }
            r1.y0()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.D r0 = r7.f2367b     // Catch:{ all -> 0x018e }
            long r10 = com.google.android.gms.measurement.internal.d6.x(r0)     // Catch:{ all -> 0x018e }
            r12 = 1
            long r10 = r10 + r12
            com.google.android.gms.measurement.internal.k r8 = r1.l0()     // Catch:{ all -> 0x018e }
            r20 = r12
            r12 = r10
            r11 = r9
            long r9 = r1.F0()     // Catch:{ all -> 0x018e }
            r14 = 0
            r19 = 0
            r21 = r20
            r20 = 0
            r16 = 0
            r14 = 1
            r18 = 0
            r16 = 0
            r25 = 0
            r18 = 0
            r36 = r21
            r21 = r7
            r6 = r36
            com.google.android.gms.measurement.internal.o r0 = r8.I(r9, r11, r12, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ all -> 0x018e }
            r9 = r11
            r18 = r15
            long r10 = r0.f3154b     // Catch:{ all -> 0x018e }
            r1.i0()     // Catch:{ all -> 0x018e }
            long r12 = com.google.android.gms.measurement.internal.C0769g.K()     // Catch:{ all -> 0x018e }
            long r10 = r10 - r12
            r12 = 1000(0x3e8, double:4.94E-321)
            r14 = 0
            int r8 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r8 <= 0) goto L_0x03bd
            long r10 = r10 % r12
            int r2 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x03ae
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.G()     // Catch:{ all -> 0x018e }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C0821n2.s(r9)     // Catch:{ all -> 0x018e }
            long r5 = r0.f3154b     // Catch:{ all -> 0x018e }
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x018e }
            r2.c(r3, r4, r0)     // Catch:{ all -> 0x018e }
        L_0x03ae:
            com.google.android.gms.measurement.internal.k r0 = r1.l0()     // Catch:{ all -> 0x018e }
            r0.k1()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.k r0 = r1.l0()
            r0.i1()
            return
        L_0x03bd:
            if (r18 == 0) goto L_0x0416
            long r10 = r0.f3153a     // Catch:{ all -> 0x018e }
            r1.i0()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.b2 r8 = com.google.android.gms.measurement.internal.G.f2495n     // Catch:{ all -> 0x018e }
            r19 = r12
            r12 = 0
            java.lang.Object r8 = r8.a(r12)     // Catch:{ all -> 0x018e }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ all -> 0x018e }
            int r8 = r8.intValue()     // Catch:{ all -> 0x018e }
            long r12 = (long) r8     // Catch:{ all -> 0x018e }
            long r10 = r10 - r12
            int r8 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r8 <= 0) goto L_0x0416
            long r10 = r10 % r19
            int r2 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x03f6
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.G()     // Catch:{ all -> 0x018e }
            java.lang.String r3 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C0821n2.s(r9)     // Catch:{ all -> 0x018e }
            long r5 = r0.f3153a     // Catch:{ all -> 0x018e }
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x018e }
            r2.c(r3, r4, r0)     // Catch:{ all -> 0x018e }
        L_0x03f6:
            r1.y0()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.c6 r8 = r1.f2536G     // Catch:{ all -> 0x018e }
            java.lang.String r11 = "_ev"
            r10 = r21
            java.lang.String r12 = r10.f2366a     // Catch:{ all -> 0x018e }
            r13 = 0
            r10 = 16
            com.google.android.gms.measurement.internal.d6.Z(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.k r0 = r1.l0()     // Catch:{ all -> 0x018e }
            r0.k1()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.k r0 = r1.l0()
            r0.i1()
            return
        L_0x0416:
            r10 = r21
            if (r17 == 0) goto L_0x0466
            long r11 = r0.f3156d     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.g r8 = r1.i0()     // Catch:{ all -> 0x018e }
            java.lang.String r13 = r2.f2631a     // Catch:{ all -> 0x018e }
            r16 = r14
            com.google.android.gms.measurement.internal.b2 r14 = com.google.android.gms.measurement.internal.G.f2492m     // Catch:{ all -> 0x018e }
            int r8 = r8.t(r13, r14)     // Catch:{ all -> 0x018e }
            r13 = 1000000(0xf4240, float:1.401298E-39)
            int r8 = java.lang.Math.min(r13, r8)     // Catch:{ all -> 0x018e }
            r14 = 0
            int r8 = java.lang.Math.max(r14, r8)     // Catch:{ all -> 0x018e }
            long r13 = (long) r8     // Catch:{ all -> 0x018e }
            long r11 = r11 - r13
            int r8 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x0468
            int r2 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x0457
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.G()     // Catch:{ all -> 0x018e }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C0821n2.s(r9)     // Catch:{ all -> 0x018e }
            long r5 = r0.f3156d     // Catch:{ all -> 0x018e }
            java.lang.Long r0 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x018e }
            r2.c(r3, r4, r0)     // Catch:{ all -> 0x018e }
        L_0x0457:
            com.google.android.gms.measurement.internal.k r0 = r1.l0()     // Catch:{ all -> 0x018e }
            r0.k1()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.k r0 = r1.l0()
            r0.i1()
            return
        L_0x0466:
            r16 = r14
        L_0x0468:
            com.google.android.gms.measurement.internal.D r0 = r10.f2367b     // Catch:{ all -> 0x018e }
            android.os.Bundle r0 = r0.j()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.d6 r8 = r1.y0()     // Catch:{ all -> 0x018e }
            java.lang.String r11 = "_o"
            java.lang.String r12 = r10.f2368c     // Catch:{ all -> 0x018e }
            r8.O(r0, r11, r12)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.d6 r8 = r1.y0()     // Catch:{ all -> 0x018e }
            java.lang.String r11 = r2.f2629E     // Catch:{ all -> 0x018e }
            boolean r8 = r8.E0(r9, r11)     // Catch:{ all -> 0x018e }
            java.lang.String r11 = "_r"
            if (r8 == 0) goto L_0x049f
            com.google.android.gms.measurement.internal.d6 r8 = r1.y0()     // Catch:{ all -> 0x018e }
            java.lang.String r12 = "_dbg"
            java.lang.Long r13 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x018e }
            r8.O(r0, r12, r13)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.d6 r8 = r1.y0()     // Catch:{ all -> 0x018e }
            java.lang.Long r12 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x018e }
            r8.O(r0, r11, r12)     // Catch:{ all -> 0x018e }
        L_0x049f:
            java.lang.String r8 = "_s"
            java.lang.String r12 = r10.f2366a     // Catch:{ all -> 0x018e }
            boolean r8 = r8.equals(r12)     // Catch:{ all -> 0x018e }
            if (r8 == 0) goto L_0x04c4
            com.google.android.gms.measurement.internal.k r8 = r1.l0()     // Catch:{ all -> 0x018e }
            java.lang.String r12 = r2.f2631a     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.a6 r8 = r8.N0(r12, r4)     // Catch:{ all -> 0x018e }
            if (r8 == 0) goto L_0x04c4
            java.lang.Object r12 = r8.f2858e     // Catch:{ all -> 0x018e }
            boolean r12 = r12 instanceof java.lang.Long     // Catch:{ all -> 0x018e }
            if (r12 == 0) goto L_0x04c4
            com.google.android.gms.measurement.internal.d6 r12 = r1.y0()     // Catch:{ all -> 0x018e }
            java.lang.Object r8 = r8.f2858e     // Catch:{ all -> 0x018e }
            r12.O(r0, r4, r8)     // Catch:{ all -> 0x018e }
        L_0x04c4:
            com.google.android.gms.measurement.internal.g r4 = r1.i0()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.b2 r8 = com.google.android.gms.measurement.internal.G.f2488k1     // Catch:{ all -> 0x018e }
            boolean r4 = r4.q(r8)     // Catch:{ all -> 0x018e }
            if (r4 == 0) goto L_0x04fa
            java.lang.String r4 = r10.f2368c     // Catch:{ all -> 0x018e }
            java.lang.String r8 = "am"
            boolean r4 = j$.util.Objects.equals(r4, r8)     // Catch:{ all -> 0x018e }
            if (r4 == 0) goto L_0x04fa
            java.lang.String r4 = r10.f2366a     // Catch:{ all -> 0x018e }
            java.lang.String r8 = "_ai"
            boolean r4 = j$.util.Objects.equals(r4, r8)     // Catch:{ all -> 0x018e }
            if (r4 == 0) goto L_0x04fa
            java.lang.Object r4 = r0.get(r5)     // Catch:{ all -> 0x018e }
            if (r4 == 0) goto L_0x04fa
            boolean r8 = r4 instanceof java.lang.String     // Catch:{ all -> 0x018e }
            if (r8 == 0) goto L_0x04fa
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ NumberFormatException -> 0x04fa }
            double r12 = java.lang.Double.parseDouble(r4)     // Catch:{ NumberFormatException -> 0x04fa }
            r0.remove(r5)     // Catch:{ NumberFormatException -> 0x04fa }
            r0.putDouble(r5, r12)     // Catch:{ NumberFormatException -> 0x04fa }
        L_0x04fa:
            com.google.android.gms.measurement.internal.k r4 = r1.l0()     // Catch:{ all -> 0x018e }
            long r4 = r4.F(r9)     // Catch:{ all -> 0x018e }
            int r8 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x051b
            com.google.android.gms.measurement.internal.n2 r8 = r1.a()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.p2 r8 = r8.L()     // Catch:{ all -> 0x018e }
            java.lang.String r12 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.C0821n2.s(r9)     // Catch:{ all -> 0x018e }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x018e }
            r8.c(r12, r13, r4)     // Catch:{ all -> 0x018e }
        L_0x051b:
            com.google.android.gms.measurement.internal.B r8 = new com.google.android.gms.measurement.internal.B     // Catch:{ all -> 0x018e }
            r4 = r11
            r11 = r9
            com.google.android.gms.measurement.internal.S2 r9 = r1.f2548l     // Catch:{ all -> 0x018e }
            java.lang.String r5 = r10.f2368c     // Catch:{ all -> 0x018e }
            java.lang.String r12 = r10.f2366a     // Catch:{ all -> 0x018e }
            long r13 = r10.f2369d     // Catch:{ all -> 0x018e }
            r19 = r16
            r15 = 0
            r17 = r0
            r0 = r4
            r10 = r5
            r4 = r19
            r8.<init>((com.google.android.gms.measurement.internal.S2) r9, (java.lang.String) r10, (java.lang.String) r11, (java.lang.String) r12, (long) r13, (long) r15, (android.os.Bundle) r17)     // Catch:{ all -> 0x018e }
            r9 = r11
            com.google.android.gms.measurement.internal.k r10 = r1.l0()     // Catch:{ all -> 0x018e }
            java.lang.String r11 = r8.f2317b     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.A r10 = r10.L0(r9, r11)     // Catch:{ all -> 0x018e }
            if (r10 != 0) goto L_0x05c0
            com.google.android.gms.measurement.internal.k r10 = r1.l0()     // Catch:{ all -> 0x018e }
            long r10 = r10.H0(r9)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.g r12 = r1.i0()     // Catch:{ all -> 0x018e }
            int r12 = r12.m(r9)     // Catch:{ all -> 0x018e }
            long r12 = (long) r12     // Catch:{ all -> 0x018e }
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x0596
            if (r18 == 0) goto L_0x0596
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()     // Catch:{ all -> 0x018e }
            java.lang.String r2 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C0821n2.s(r9)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.S2 r4 = r1.f2548l     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.h2 r4 = r4.D()     // Catch:{ all -> 0x018e }
            java.lang.String r5 = r8.f2317b     // Catch:{ all -> 0x018e }
            java.lang.String r4 = r4.c(r5)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.g r5 = r1.i0()     // Catch:{ all -> 0x018e }
            int r5 = r5.m(r9)     // Catch:{ all -> 0x018e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x018e }
            r0.d(r2, r3, r4, r5)     // Catch:{ all -> 0x018e }
            r1.y0()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.c6 r8 = r1.f2536G     // Catch:{ all -> 0x018e }
            r12 = 0
            r13 = 0
            r10 = 8
            r11 = 0
            com.google.android.gms.measurement.internal.d6.Z(r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.k r0 = r1.l0()
            r0.i1()
            return
        L_0x0596:
            com.google.android.gms.measurement.internal.A r10 = new com.google.android.gms.measurement.internal.A     // Catch:{ all -> 0x018e }
            r11 = r10
            java.lang.String r10 = r8.f2317b     // Catch:{ all -> 0x018e }
            long r12 = r8.f2319d     // Catch:{ all -> 0x018e }
            r21 = 0
            r22 = 0
            r15 = r12
            r13 = r8
            r8 = r11
            r11 = 0
            r17 = r13
            r13 = 0
            r19 = r17
            r17 = 0
            r20 = r19
            r19 = 0
            r27 = r20
            r20 = 0
            r28 = r6
            r6 = r27
            r8.<init>(r9, r10, r11, r13, r15, r17, r19, r20, r21, r22)     // Catch:{ all -> 0x018e }
            r10 = r8
            r8 = r6
            goto L_0x05d1
        L_0x05c0:
            r28 = r6
            r6 = r8
            com.google.android.gms.measurement.internal.S2 r7 = r1.f2548l     // Catch:{ all -> 0x018e }
            long r8 = r10.f2288f     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.B r8 = r6.a(r7, r8)     // Catch:{ all -> 0x018e }
            long r6 = r8.f2319d     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.A r10 = r10.a(r6)     // Catch:{ all -> 0x018e }
        L_0x05d1:
            com.google.android.gms.measurement.internal.k r6 = r1.l0()     // Catch:{ all -> 0x018e }
            r6.U(r10)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.P2 r6 = r1.f()     // Catch:{ all -> 0x018e }
            r6.k()     // Catch:{ all -> 0x018e }
            r1.A0()     // Catch:{ all -> 0x018e }
            M.C0335p.l(r8)     // Catch:{ all -> 0x018e }
            M.C0335p.l(r2)     // Catch:{ all -> 0x018e }
            java.lang.String r6 = r8.f2316a     // Catch:{ all -> 0x018e }
            M.C0335p.f(r6)     // Catch:{ all -> 0x018e }
            java.lang.String r6 = r8.f2316a     // Catch:{ all -> 0x018e }
            java.lang.String r7 = r2.f2631a     // Catch:{ all -> 0x018e }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x018e }
            M.C0335p.a(r6)     // Catch:{ all -> 0x018e }
            com.google.android.gms.internal.measurement.p2$a r6 = com.google.android.gms.internal.measurement.C0643p2.u2()     // Catch:{ all -> 0x018e }
            r7 = 1
            com.google.android.gms.internal.measurement.p2$a r6 = r6.t0(r7)     // Catch:{ all -> 0x018e }
            java.lang.String r9 = "android"
            com.google.android.gms.internal.measurement.p2$a r6 = r6.S0(r9)     // Catch:{ all -> 0x018e }
            java.lang.String r9 = r2.f2631a     // Catch:{ all -> 0x018e }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x018e }
            if (r9 != 0) goto L_0x0614
            java.lang.String r9 = r2.f2631a     // Catch:{ all -> 0x018e }
            r6.R(r9)     // Catch:{ all -> 0x018e }
        L_0x0614:
            java.lang.String r9 = r2.f2634d     // Catch:{ all -> 0x018e }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x018e }
            if (r9 != 0) goto L_0x0621
            java.lang.String r9 = r2.f2634d     // Catch:{ all -> 0x018e }
            r6.d0(r9)     // Catch:{ all -> 0x018e }
        L_0x0621:
            java.lang.String r9 = r2.f2633c     // Catch:{ all -> 0x018e }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x018e }
            if (r9 != 0) goto L_0x062e
            java.lang.String r9 = r2.f2633c     // Catch:{ all -> 0x018e }
            r6.j0(r9)     // Catch:{ all -> 0x018e }
        L_0x062e:
            java.lang.String r9 = r2.f2654x     // Catch:{ all -> 0x018e }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x018e }
            if (r9 != 0) goto L_0x063b
            java.lang.String r9 = r2.f2654x     // Catch:{ all -> 0x018e }
            r6.W0(r9)     // Catch:{ all -> 0x018e }
        L_0x063b:
            long r9 = r2.f2640j     // Catch:{ all -> 0x018e }
            r11 = -2147483648(0xffffffff80000000, double:NaN)
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x0648
            int r10 = (int) r9     // Catch:{ all -> 0x018e }
            r6.g0(r10)     // Catch:{ all -> 0x018e }
        L_0x0648:
            long r9 = r2.f2635e     // Catch:{ all -> 0x018e }
            r6.m0(r9)     // Catch:{ all -> 0x018e }
            java.lang.String r9 = r2.f2632b     // Catch:{ all -> 0x018e }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x018e }
            if (r9 != 0) goto L_0x065a
            java.lang.String r9 = r2.f2632b     // Catch:{ all -> 0x018e }
            r6.M0(r9)     // Catch:{ all -> 0x018e }
        L_0x065a:
            java.lang.String r9 = r2.f2631a     // Catch:{ all -> 0x018e }
            java.lang.Object r9 = M.C0335p.l(r9)     // Catch:{ all -> 0x018e }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.A3 r9 = r1.U(r9)     // Catch:{ all -> 0x018e }
            java.lang.String r10 = r2.f2652v     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.A3 r10 = com.google.android.gms.measurement.internal.A3.q(r10)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.A3 r9 = r9.d(r10)     // Catch:{ all -> 0x018e }
            java.lang.String r10 = r9.w()     // Catch:{ all -> 0x018e }
            r6.r0(r10)     // Catch:{ all -> 0x018e }
            java.lang.String r10 = r6.d1()     // Catch:{ all -> 0x018e }
            boolean r10 = r10.isEmpty()     // Catch:{ all -> 0x018e }
            if (r10 == 0) goto L_0x068e
            java.lang.String r10 = r2.f2647q     // Catch:{ all -> 0x018e }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x018e }
            if (r10 != 0) goto L_0x068e
            java.lang.String r10 = r2.f2647q     // Catch:{ all -> 0x018e }
            r6.G(r10)     // Catch:{ all -> 0x018e }
        L_0x068e:
            boolean r10 = com.google.android.gms.internal.measurement.C0604k7.a()     // Catch:{ all -> 0x018e }
            if (r10 == 0) goto L_0x0739
            com.google.android.gms.measurement.internal.g r10 = r1.i0()     // Catch:{ all -> 0x018e }
            java.lang.String r11 = r2.f2631a     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.b2 r12 = com.google.android.gms.measurement.internal.G.f2421I0     // Catch:{ all -> 0x018e }
            boolean r10 = r10.F(r11, r12)     // Catch:{ all -> 0x018e }
            if (r10 == 0) goto L_0x0739
            r1.y0()     // Catch:{ all -> 0x018e }
            java.lang.String r10 = r2.f2631a     // Catch:{ all -> 0x018e }
            boolean r10 = com.google.android.gms.measurement.internal.d6.D0(r10)     // Catch:{ all -> 0x018e }
            if (r10 == 0) goto L_0x0739
            int r10 = r2.f2627C     // Catch:{ all -> 0x018e }
            r6.a0(r10)     // Catch:{ all -> 0x018e }
            long r10 = r2.f2628D     // Catch:{ all -> 0x018e }
            boolean r9 = r9.y()     // Catch:{ all -> 0x018e }
            r12 = 32
            if (r9 != 0) goto L_0x06c4
            int r9 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x06c4
            r14 = -2
            long r10 = r10 & r14
            long r10 = r10 | r12
        L_0x06c4:
            int r9 = (r10 > r28 ? 1 : (r10 == r28 ? 0 : -1))
            if (r9 != 0) goto L_0x06ca
            r9 = 1
            goto L_0x06cb
        L_0x06ca:
            r9 = 0
        L_0x06cb:
            r6.H(r9)     // Catch:{ all -> 0x018e }
            int r9 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r9 == 0) goto L_0x0739
            com.google.android.gms.internal.measurement.h2$a r9 = com.google.android.gms.internal.measurement.C0572h2.G()     // Catch:{ all -> 0x018e }
            long r14 = r10 & r28
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x06de
            r14 = 1
            goto L_0x06df
        L_0x06de:
            r14 = 0
        L_0x06df:
            r9.s(r14)     // Catch:{ all -> 0x018e }
            r14 = 2
            long r14 = r14 & r10
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x06eb
            r14 = 1
            goto L_0x06ec
        L_0x06eb:
            r14 = 0
        L_0x06ec:
            r9.x(r14)     // Catch:{ all -> 0x018e }
            r14 = 4
            long r14 = r14 & r10
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x06f8
            r14 = 1
            goto L_0x06f9
        L_0x06f8:
            r14 = 0
        L_0x06f9:
            r9.y(r14)     // Catch:{ all -> 0x018e }
            r14 = 8
            long r14 = r14 & r10
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0705
            r14 = 1
            goto L_0x0706
        L_0x0705:
            r14 = 0
        L_0x0706:
            r9.z(r14)     // Catch:{ all -> 0x018e }
            r14 = 16
            long r14 = r14 & r10
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 == 0) goto L_0x0712
            r14 = 1
            goto L_0x0713
        L_0x0712:
            r14 = 0
        L_0x0713:
            r9.r(r14)     // Catch:{ all -> 0x018e }
            long r12 = r12 & r10
            int r14 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r14 == 0) goto L_0x071d
            r12 = 1
            goto L_0x071e
        L_0x071d:
            r12 = 0
        L_0x071e:
            r9.q(r12)     // Catch:{ all -> 0x018e }
            r12 = 64
            long r10 = r10 & r12
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 == 0) goto L_0x072a
            r10 = 1
            goto L_0x072b
        L_0x072a:
            r10 = 0
        L_0x072b:
            r9.t(r10)     // Catch:{ all -> 0x018e }
            com.google.android.gms.internal.measurement.Z4 r9 = r9.m()     // Catch:{ all -> 0x018e }
            com.google.android.gms.internal.measurement.s4 r9 = (com.google.android.gms.internal.measurement.C0668s4) r9     // Catch:{ all -> 0x018e }
            com.google.android.gms.internal.measurement.h2 r9 = (com.google.android.gms.internal.measurement.C0572h2) r9     // Catch:{ all -> 0x018e }
            r6.A(r9)     // Catch:{ all -> 0x018e }
        L_0x0739:
            long r9 = r2.f2636f     // Catch:{ all -> 0x018e }
            int r11 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r11 == 0) goto L_0x0742
            r6.V(r9)     // Catch:{ all -> 0x018e }
        L_0x0742:
            long r9 = r2.f2649s     // Catch:{ all -> 0x018e }
            r6.b0(r9)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.Z5 r9 = r1.x0()     // Catch:{ all -> 0x018e }
            java.util.List r9 = r9.k0()     // Catch:{ all -> 0x018e }
            if (r9 == 0) goto L_0x0754
            r6.W(r9)     // Catch:{ all -> 0x018e }
        L_0x0754:
            java.lang.String r9 = r2.f2631a     // Catch:{ all -> 0x018e }
            java.lang.Object r9 = M.C0335p.l(r9)     // Catch:{ all -> 0x018e }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.A3 r9 = r1.U(r9)     // Catch:{ all -> 0x018e }
            java.lang.String r10 = r2.f2652v     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.A3 r10 = com.google.android.gms.measurement.internal.A3.q(r10)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.A3 r9 = r9.d(r10)     // Catch:{ all -> 0x018e }
            boolean r10 = r9.y()     // Catch:{ all -> 0x018e }
            if (r10 == 0) goto L_0x082d
            boolean r10 = r2.f2645o     // Catch:{ all -> 0x018e }
            if (r10 == 0) goto L_0x082d
            com.google.android.gms.measurement.internal.j5 r10 = r1.f2545i     // Catch:{ all -> 0x018e }
            java.lang.String r11 = r2.f2631a     // Catch:{ all -> 0x018e }
            android.util.Pair r10 = r10.w(r11, r9)     // Catch:{ all -> 0x018e }
            if (r10 == 0) goto L_0x082d
            java.lang.Object r11 = r10.first     // Catch:{ all -> 0x018e }
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ all -> 0x018e }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x018e }
            if (r11 != 0) goto L_0x082d
            boolean r11 = r2.f2645o     // Catch:{ all -> 0x018e }
            if (r11 == 0) goto L_0x082d
            java.lang.Object r11 = r10.first     // Catch:{ all -> 0x018e }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x018e }
            r6.U0(r11)     // Catch:{ all -> 0x018e }
            java.lang.Object r11 = r10.second     // Catch:{ all -> 0x018e }
            if (r11 == 0) goto L_0x07a0
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x018e }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x018e }
            r6.Y(r11)     // Catch:{ all -> 0x018e }
        L_0x07a0:
            java.lang.String r11 = r8.f2317b     // Catch:{ all -> 0x018e }
            boolean r11 = r11.equals(r3)     // Catch:{ all -> 0x018e }
            if (r11 != 0) goto L_0x082d
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x018e }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x018e }
            java.lang.String r11 = "00000000-0000-0000-0000-000000000000"
            boolean r10 = r10.equals(r11)     // Catch:{ all -> 0x018e }
            if (r10 != 0) goto L_0x082d
            com.google.android.gms.measurement.internal.k r10 = r1.l0()     // Catch:{ all -> 0x018e }
            java.lang.String r11 = r2.f2631a     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.c2 r10 = r10.M0(r11)     // Catch:{ all -> 0x018e }
            if (r10 == 0) goto L_0x082d
            boolean r11 = r10.D()     // Catch:{ all -> 0x018e }
            if (r11 == 0) goto L_0x082d
            java.lang.String r11 = r2.f2631a     // Catch:{ all -> 0x018e }
            r13 = 0
            r14 = 0
            r1.I(r11, r14, r13, r13)     // Catch:{ all -> 0x018e }
            android.os.Bundle r11 = new android.os.Bundle     // Catch:{ all -> 0x018e }
            r11.<init>()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.g r12 = r1.i0()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.b2 r13 = com.google.android.gms.measurement.internal.G.f2451X0     // Catch:{ all -> 0x018e }
            boolean r12 = r12.q(r13)     // Catch:{ all -> 0x018e }
            java.lang.String r13 = "_pfo"
            if (r12 == 0) goto L_0x0803
            java.lang.Long r12 = r10.L0()     // Catch:{ all -> 0x018e }
            if (r12 == 0) goto L_0x07f1
            long r14 = r12.longValue()     // Catch:{ all -> 0x018e }
            long r14 = java.lang.Math.max(r4, r14)     // Catch:{ all -> 0x018e }
            r11.putLong(r13, r14)     // Catch:{ all -> 0x018e }
        L_0x07f1:
            java.lang.Long r10 = r10.M0()     // Catch:{ all -> 0x018e }
            if (r10 == 0) goto L_0x0800
            java.lang.String r12 = "_uwa"
            long r13 = r10.longValue()     // Catch:{ all -> 0x018e }
            r11.putLong(r12, r13)     // Catch:{ all -> 0x018e }
        L_0x0800:
            r12 = r28
            goto L_0x0823
        L_0x0803:
            com.google.android.gms.measurement.internal.g r10 = r1.i0()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.b2 r12 = com.google.android.gms.measurement.internal.G.f2449W0     // Catch:{ all -> 0x018e }
            boolean r10 = r10.q(r12)     // Catch:{ all -> 0x018e }
            if (r10 == 0) goto L_0x0800
            com.google.android.gms.measurement.internal.k r10 = r1.l0()     // Catch:{ all -> 0x018e }
            java.lang.String r12 = r2.f2631a     // Catch:{ all -> 0x018e }
            long r14 = r10.A0(r12)     // Catch:{ all -> 0x018e }
            long r14 = r14 - r28
            long r14 = java.lang.Math.max(r4, r14)     // Catch:{ all -> 0x018e }
            r11.putLong(r13, r14)     // Catch:{ all -> 0x018e }
            goto L_0x0800
        L_0x0823:
            r11.putLong(r0, r12)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.c6 r10 = r1.f2536G     // Catch:{ all -> 0x018e }
            java.lang.String r12 = r2.f2631a     // Catch:{ all -> 0x018e }
            r10.b(r12, r3, r11)     // Catch:{ all -> 0x018e }
        L_0x082d:
            com.google.android.gms.measurement.internal.S2 r3 = r1.f2548l     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.x r3 = r3.x()     // Catch:{ all -> 0x018e }
            r3.m()     // Catch:{ all -> 0x018e }
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ all -> 0x018e }
            com.google.android.gms.internal.measurement.p2$a r3 = r6.z0(r3)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.S2 r10 = r1.f2548l     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.x r10 = r10.x()     // Catch:{ all -> 0x018e }
            r10.m()     // Catch:{ all -> 0x018e }
            java.lang.String r10 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x018e }
            com.google.android.gms.internal.measurement.p2$a r3 = r3.Q0(r10)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.S2 r10 = r1.f2548l     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.x r10 = r10.x()     // Catch:{ all -> 0x018e }
            long r10 = r10.r()     // Catch:{ all -> 0x018e }
            int r11 = (int) r10     // Catch:{ all -> 0x018e }
            com.google.android.gms.internal.measurement.p2$a r3 = r3.B0(r11)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.S2 r10 = r1.f2548l     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.x r10 = r10.x()     // Catch:{ all -> 0x018e }
            java.lang.String r10 = r10.s()     // Catch:{ all -> 0x018e }
            r3.Y0(r10)     // Catch:{ all -> 0x018e }
            long r10 = r2.f2656z     // Catch:{ all -> 0x018e }
            r6.C0(r10)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.S2 r3 = r1.f2548l     // Catch:{ all -> 0x018e }
            boolean r3 = r3.m()     // Catch:{ all -> 0x018e }
            if (r3 == 0) goto L_0x0881
            r6.Z0()     // Catch:{ all -> 0x018e }
            r13 = 0
            boolean r3 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x018e }
            if (r3 != 0) goto L_0x0881
            r6.D0(r13)     // Catch:{ all -> 0x018e }
        L_0x0881:
            com.google.android.gms.measurement.internal.k r3 = r1.l0()     // Catch:{ all -> 0x018e }
            java.lang.String r10 = r2.f2631a     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.c2 r3 = r3.M0(r10)     // Catch:{ all -> 0x018e }
            if (r3 != 0) goto L_0x08ef
            com.google.android.gms.measurement.internal.c2 r3 = new com.google.android.gms.measurement.internal.c2     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.S2 r10 = r1.f2548l     // Catch:{ all -> 0x018e }
            java.lang.String r11 = r2.f2631a     // Catch:{ all -> 0x018e }
            r3.<init>(r10, r11)     // Catch:{ all -> 0x018e }
            java.lang.String r10 = r1.l(r9)     // Catch:{ all -> 0x018e }
            r3.J(r10)     // Catch:{ all -> 0x018e }
            java.lang.String r10 = r2.f2641k     // Catch:{ all -> 0x018e }
            r3.W(r10)     // Catch:{ all -> 0x018e }
            java.lang.String r10 = r2.f2632b     // Catch:{ all -> 0x018e }
            r3.Z(r10)     // Catch:{ all -> 0x018e }
            boolean r10 = r9.y()     // Catch:{ all -> 0x018e }
            if (r10 == 0) goto L_0x08ba
            com.google.android.gms.measurement.internal.j5 r10 = r1.f2545i     // Catch:{ all -> 0x018e }
            java.lang.String r11 = r2.f2631a     // Catch:{ all -> 0x018e }
            boolean r12 = r2.f2645o     // Catch:{ all -> 0x018e }
            java.lang.String r10 = r10.x(r11, r12)     // Catch:{ all -> 0x018e }
            r3.f0(r10)     // Catch:{ all -> 0x018e }
        L_0x08ba:
            r3.A0(r4)     // Catch:{ all -> 0x018e }
            r3.C0(r4)     // Catch:{ all -> 0x018e }
            r3.y0(r4)     // Catch:{ all -> 0x018e }
            java.lang.String r10 = r2.f2633c     // Catch:{ all -> 0x018e }
            r3.S(r10)     // Catch:{ all -> 0x018e }
            long r10 = r2.f2640j     // Catch:{ all -> 0x018e }
            r3.H(r10)     // Catch:{ all -> 0x018e }
            java.lang.String r10 = r2.f2634d     // Catch:{ all -> 0x018e }
            r3.O(r10)     // Catch:{ all -> 0x018e }
            long r10 = r2.f2635e     // Catch:{ all -> 0x018e }
            r3.u0(r10)     // Catch:{ all -> 0x018e }
            long r10 = r2.f2636f     // Catch:{ all -> 0x018e }
            r3.n0(r10)     // Catch:{ all -> 0x018e }
            boolean r10 = r2.f2638h     // Catch:{ all -> 0x018e }
            r3.K(r10)     // Catch:{ all -> 0x018e }
            long r10 = r2.f2649s     // Catch:{ all -> 0x018e }
            r3.q0(r10)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.k r10 = r1.l0()     // Catch:{ all -> 0x018e }
            r14 = 0
            r10.V(r3, r14, r14)     // Catch:{ all -> 0x018e }
            goto L_0x08f0
        L_0x08ef:
            r14 = 0
        L_0x08f0:
            boolean r9 = r9.z()     // Catch:{ all -> 0x018e }
            if (r9 == 0) goto L_0x090d
            java.lang.String r9 = r3.m()     // Catch:{ all -> 0x018e }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x018e }
            if (r9 != 0) goto L_0x090d
            java.lang.String r9 = r3.m()     // Catch:{ all -> 0x018e }
            java.lang.Object r9 = M.C0335p.l(r9)     // Catch:{ all -> 0x018e }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x018e }
            r6.X(r9)     // Catch:{ all -> 0x018e }
        L_0x090d:
            java.lang.String r9 = r3.p()     // Catch:{ all -> 0x018e }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x018e }
            if (r9 != 0) goto L_0x0924
            java.lang.String r9 = r3.p()     // Catch:{ all -> 0x018e }
            java.lang.Object r9 = M.C0335p.l(r9)     // Catch:{ all -> 0x018e }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x018e }
            r6.K0(r9)     // Catch:{ all -> 0x018e }
        L_0x0924:
            com.google.android.gms.measurement.internal.k r9 = r1.l0()     // Catch:{ all -> 0x018e }
            java.lang.String r10 = r2.f2631a     // Catch:{ all -> 0x018e }
            java.util.List r9 = r9.Y0(r10)     // Catch:{ all -> 0x018e }
            r10 = 0
        L_0x092f:
            int r11 = r9.size()     // Catch:{ all -> 0x018e }
            if (r10 >= r11) goto L_0x0993
            com.google.android.gms.internal.measurement.t2$a r11 = com.google.android.gms.internal.measurement.C0674t2.S()     // Catch:{ all -> 0x018e }
            java.lang.Object r12 = r9.get(r10)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.a6 r12 = (com.google.android.gms.measurement.internal.a6) r12     // Catch:{ all -> 0x018e }
            java.lang.String r12 = r12.f2856c     // Catch:{ all -> 0x018e }
            com.google.android.gms.internal.measurement.t2$a r11 = r11.t(r12)     // Catch:{ all -> 0x018e }
            java.lang.Object r12 = r9.get(r10)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.a6 r12 = (com.google.android.gms.measurement.internal.a6) r12     // Catch:{ all -> 0x018e }
            long r12 = r12.f2857d     // Catch:{ all -> 0x018e }
            com.google.android.gms.internal.measurement.t2$a r11 = r11.y(r12)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.Z5 r12 = r1.x0()     // Catch:{ all -> 0x018e }
            java.lang.Object r13 = r9.get(r10)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.a6 r13 = (com.google.android.gms.measurement.internal.a6) r13     // Catch:{ all -> 0x018e }
            java.lang.Object r13 = r13.f2858e     // Catch:{ all -> 0x018e }
            r12.V(r11, r13)     // Catch:{ all -> 0x018e }
            r6.D(r11)     // Catch:{ all -> 0x018e }
            java.lang.String r11 = "_sid"
            java.lang.Object r12 = r9.get(r10)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.a6 r12 = (com.google.android.gms.measurement.internal.a6) r12     // Catch:{ all -> 0x018e }
            java.lang.String r12 = r12.f2856c     // Catch:{ all -> 0x018e }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x018e }
            if (r11 == 0) goto L_0x0990
            long r11 = r3.I0()     // Catch:{ all -> 0x018e }
            int r13 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x0990
            com.google.android.gms.measurement.internal.Z5 r11 = r1.x0()     // Catch:{ all -> 0x018e }
            java.lang.String r12 = r2.f2654x     // Catch:{ all -> 0x018e }
            long r11 = r11.w(r12)     // Catch:{ all -> 0x018e }
            long r15 = r3.I0()     // Catch:{ all -> 0x018e }
            int r13 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r13 == 0) goto L_0x0990
            r6.V0()     // Catch:{ all -> 0x018e }
        L_0x0990:
            int r10 = r10 + 1
            goto L_0x092f
        L_0x0993:
            com.google.android.gms.measurement.internal.k r2 = r1.l0()     // Catch:{ IOException -> 0x0a0a }
            com.google.android.gms.internal.measurement.Z4 r3 = r6.m()     // Catch:{ IOException -> 0x0a0a }
            com.google.android.gms.internal.measurement.s4 r3 = (com.google.android.gms.internal.measurement.C0668s4) r3     // Catch:{ IOException -> 0x0a0a }
            com.google.android.gms.internal.measurement.p2 r3 = (com.google.android.gms.internal.measurement.C0643p2) r3     // Catch:{ IOException -> 0x0a0a }
            long r2 = r2.E(r3)     // Catch:{ IOException -> 0x0a0a }
            com.google.android.gms.measurement.internal.k r6 = r1.l0()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.D r9 = r8.f2321f     // Catch:{ all -> 0x018e }
            if (r9 == 0) goto L_0x0a00
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x018e }
        L_0x09af:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x018e }
            if (r10 == 0) goto L_0x09c2
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x018e }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x018e }
            boolean r10 = r0.equals(r10)     // Catch:{ all -> 0x018e }
            if (r10 == 0) goto L_0x09af
            goto L_0x0a01
        L_0x09c2:
            com.google.android.gms.measurement.internal.I2 r0 = r1.r0()     // Catch:{ all -> 0x018e }
            java.lang.String r9 = r8.f2316a     // Catch:{ all -> 0x018e }
            java.lang.String r10 = r8.f2317b     // Catch:{ all -> 0x018e }
            boolean r0 = r0.N(r9, r10)     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.k r25 = r1.l0()     // Catch:{ all -> 0x018e }
            long r26 = r1.F0()     // Catch:{ all -> 0x018e }
            java.lang.String r9 = r8.f2316a     // Catch:{ all -> 0x018e }
            r34 = 0
            r35 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r28 = r9
            com.google.android.gms.measurement.internal.o r9 = r25.J(r26, r28, r29, r30, r31, r32, r33, r34, r35)     // Catch:{ all -> 0x018e }
            if (r0 == 0) goto L_0x0a00
            long r9 = r9.f3157e     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.g r0 = r1.i0()     // Catch:{ all -> 0x018e }
            java.lang.String r11 = r8.f2316a     // Catch:{ all -> 0x018e }
            int r0 = r0.w(r11)     // Catch:{ all -> 0x018e }
            long r11 = (long) r0     // Catch:{ all -> 0x018e }
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 >= 0) goto L_0x0a00
            goto L_0x0a01
        L_0x0a00:
            r7 = 0
        L_0x0a01:
            boolean r0 = r6.h0(r8, r2, r7)     // Catch:{ all -> 0x018e }
            if (r0 == 0) goto L_0x0a20
            r1.f2551o = r4     // Catch:{ all -> 0x018e }
            goto L_0x0a20
        L_0x0a0a:
            r0 = move-exception
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.p2 r2 = r2.G()     // Catch:{ all -> 0x018e }
            java.lang.String r3 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r4 = r6.Z0()     // Catch:{ all -> 0x018e }
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C0821n2.s(r4)     // Catch:{ all -> 0x018e }
            r2.c(r3, r4, r0)     // Catch:{ all -> 0x018e }
        L_0x0a20:
            com.google.android.gms.measurement.internal.k r0 = r1.l0()     // Catch:{ all -> 0x018e }
            r0.k1()     // Catch:{ all -> 0x018e }
            com.google.android.gms.measurement.internal.k r0 = r1.l0()
            r0.i1()
            r1.R()
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.K()
            long r2 = java.lang.System.nanoTime()
            long r2 = r2 - r23
            r4 = 500000(0x7a120, double:2.47033E-318)
            long r2 = r2 + r4
            r4 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r2 / r4
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "Background event processing time, ms"
            r0.b(r3, r2)
            return
        L_0x0a51:
            com.google.android.gms.measurement.internal.k r2 = r1.l0()
            r2.i1()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.H5.e0(com.google.android.gms.measurement.internal.E, com.google.android.gms.measurement.internal.M5):void");
    }

    private final C0873v g0(String str) {
        f().k();
        A0();
        C0873v vVar = (C0873v) this.f2532C.get(str);
        if (vVar != null) {
            return vVar;
        }
        C0873v Q02 = l0().Q0(str);
        this.f2532C.put(str, Q02);
        return Q02;
    }

    private static E5 i(E5 e5) {
        if (e5 == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (e5.t()) {
            return e5;
        } else {
            String valueOf = String.valueOf(e5.getClass());
            throw new IllegalStateException("Component not initialized: " + valueOf);
        }
    }

    public static H5 j(Context context) {
        C0335p.l(context);
        C0335p.l(context.getApplicationContext());
        if (f2529H == null) {
            synchronized (H5.class) {
                try {
                    if (f2529H == null) {
                        f2529H = new H5((W5) C0335p.l(new W5(context)));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f2529H;
    }

    private final Boolean k(C0744c2 c2Var) {
        try {
            if (c2Var.U() != -2147483648L) {
                if (c2Var.U() == ((long) T.e.a(this.f2548l.A()).e(c2Var.l(), 0).versionCode)) {
                    return Boolean.TRUE;
                }
            } else {
                String str = T.e.a(this.f2548l.A()).e(c2Var.l(), 0).versionName;
                String o4 = c2Var.o();
                if (o4 != null && o4.equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:49|50|51|52|53|56|57) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x0115 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void k0(java.lang.String r12) {
        /*
            r11 = this;
            com.google.android.gms.measurement.internal.P2 r0 = r11.f()
            r0.k()
            r11.A0()
            r0 = 1
            r11.f2558v = r0
            r1 = 0
            com.google.android.gms.measurement.internal.S2 r2 = r11.f2548l     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.F4 r2 = r2.J()     // Catch:{ all -> 0x002d }
            java.lang.Boolean r2 = r2.W()     // Catch:{ all -> 0x002d }
            if (r2 != 0) goto L_0x0031
            com.google.android.gms.measurement.internal.n2 r12 = r11.a()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.p2 r12 = r12.L()     // Catch:{ all -> 0x002d }
            java.lang.String r0 = "Upload data called on the client side before use of service was decided"
            r12.a(r0)     // Catch:{ all -> 0x002d }
            r11.f2558v = r1
            r11.P()
            return
        L_0x002d:
            r0 = move-exception
            r12 = r0
            goto L_0x0130
        L_0x0031:
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x004a
            com.google.android.gms.measurement.internal.n2 r12 = r11.a()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.p2 r12 = r12.G()     // Catch:{ all -> 0x002d }
            java.lang.String r0 = "Upload called in the client side when service should be used"
            r12.a(r0)     // Catch:{ all -> 0x002d }
            r11.f2558v = r1
            r11.P()
            return
        L_0x004a:
            long r2 = r11.f2551o     // Catch:{ all -> 0x002d }
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x005b
            r11.R()     // Catch:{ all -> 0x002d }
            r11.f2558v = r1
            r11.P()
            return
        L_0x005b:
            com.google.android.gms.measurement.internal.q2 r2 = r11.p0()     // Catch:{ all -> 0x002d }
            boolean r2 = r2.z()     // Catch:{ all -> 0x002d }
            if (r2 != 0) goto L_0x007b
            com.google.android.gms.measurement.internal.n2 r12 = r11.a()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.p2 r12 = r12.K()     // Catch:{ all -> 0x002d }
            java.lang.String r0 = "Network not connected, ignoring upload request"
            r12.a(r0)     // Catch:{ all -> 0x002d }
            r11.R()     // Catch:{ all -> 0x002d }
            r11.f2558v = r1
            r11.P()
            return
        L_0x007b:
            com.google.android.gms.measurement.internal.k r2 = r11.l0()     // Catch:{ all -> 0x002d }
            boolean r2 = r2.g1(r12)     // Catch:{ all -> 0x002d }
            if (r2 != 0) goto L_0x0098
            com.google.android.gms.measurement.internal.n2 r0 = r11.a()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.p2 r0 = r0.K()     // Catch:{ all -> 0x002d }
            java.lang.String r2 = "Upload queue has no batches for appId"
            r0.b(r2, r12)     // Catch:{ all -> 0x002d }
            r11.f2558v = r1
            r11.P()
            return
        L_0x0098:
            com.google.android.gms.measurement.internal.k r2 = r11.l0()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.V5 r2 = r2.W0(r12)     // Catch:{ all -> 0x002d }
            if (r2 != 0) goto L_0x00a8
            r11.f2558v = r1
            r11.P()
            return
        L_0x00a8:
            com.google.android.gms.internal.measurement.o2 r3 = r2.c()     // Catch:{ all -> 0x002d }
            if (r3 != 0) goto L_0x00b4
            r11.f2558v = r1
            r11.P()
            return
        L_0x00b4:
            com.google.android.gms.measurement.internal.Z5 r4 = r11.x0()     // Catch:{ all -> 0x002d }
            java.lang.String r4 = r4.M(r3)     // Catch:{ all -> 0x002d }
            byte[] r8 = r3.i()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.n2 r5 = r11.a()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.p2 r5 = r5.K()     // Catch:{ all -> 0x002d }
            java.lang.String r6 = "Uploading data from upload queue. appId, uncompressed size, data"
            int r7 = r8.length     // Catch:{ all -> 0x002d }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x002d }
            r5.d(r6, r12, r7, r4)     // Catch:{ all -> 0x002d }
            boolean r4 = com.google.android.gms.internal.measurement.Y6.a()     // Catch:{ all -> 0x002d }
            if (r4 == 0) goto L_0x00f7
            com.google.android.gms.measurement.internal.g r4 = r11.i0()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.b2 r5 = com.google.android.gms.measurement.internal.G.f2417G0     // Catch:{ all -> 0x002d }
            boolean r4 = r4.q(r5)     // Catch:{ all -> 0x002d }
            if (r4 == 0) goto L_0x00f7
            r11.f2557u = r0     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.q2 r0 = r11.p0()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.I5 r4 = r2.b()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.O5 r5 = new com.google.android.gms.measurement.internal.O5     // Catch:{ all -> 0x002d }
            r5.<init>(r11, r12, r2)     // Catch:{ all -> 0x002d }
            r0.v(r12, r4, r3, r5)     // Catch:{ all -> 0x002d }
            goto L_0x012a
        L_0x00f7:
            r11.f2557u = r0     // Catch:{ MalformedURLException -> 0x0114 }
            com.google.android.gms.measurement.internal.q2 r5 = r11.p0()     // Catch:{ MalformedURLException -> 0x0114 }
            java.net.URL r7 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0114 }
            java.lang.String r0 = r2.d()     // Catch:{ MalformedURLException -> 0x0114 }
            r7.<init>(r0)     // Catch:{ MalformedURLException -> 0x0114 }
            java.util.Map r9 = r2.e()     // Catch:{ MalformedURLException -> 0x0114 }
            com.google.android.gms.measurement.internal.R5 r10 = new com.google.android.gms.measurement.internal.R5     // Catch:{ MalformedURLException -> 0x0114 }
            r10.<init>(r11, r12, r2)     // Catch:{ MalformedURLException -> 0x0114 }
            r6 = r12
            r5.w(r6, r7, r8, r9, r10)     // Catch:{ MalformedURLException -> 0x0115 }
            goto L_0x012a
        L_0x0114:
            r6 = r12
        L_0x0115:
            com.google.android.gms.measurement.internal.n2 r12 = r11.a()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.p2 r12 = r12.G()     // Catch:{ all -> 0x002d }
            java.lang.String r0 = "Failed to parse URL. Not uploading MeasurementBatch. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.C0821n2.s(r6)     // Catch:{ all -> 0x002d }
            java.lang.String r2 = r2.d()     // Catch:{ all -> 0x002d }
            r12.c(r0, r3, r2)     // Catch:{ all -> 0x002d }
        L_0x012a:
            r11.f2558v = r1
            r11.P()
            return
        L_0x0130:
            r11.f2558v = r1
            r11.P()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.H5.k0(java.lang.String):void");
    }

    private final String l(A3 a32) {
        if (!a32.z()) {
            return null;
        }
        byte[] bArr = new byte[16];
        y0().W0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    private static String m(Map map, String str) {
        if (map == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                if (((List) entry.getValue()).isEmpty()) {
                    return null;
                }
                return (String) ((List) entry.getValue()).get(0);
            }
        }
        return null;
    }

    private static void n(C0599k2.a aVar, int i4, String str) {
        List I4 = aVar.I();
        int i5 = 0;
        while (i5 < I4.size()) {
            if (!"_err".equals(((C0617m2) I4.get(i5)).W())) {
                i5++;
            } else {
                return;
            }
        }
        aVar.z((C0617m2) ((C0668s4) C0617m2.U().y("_err").s((long) i4).m())).z((C0617m2) ((C0668s4) C0617m2.U().y("_ev").A(str).m()));
    }

    private static void o(C0599k2.a aVar, String str) {
        List I4 = aVar.I();
        for (int i4 = 0; i4 < I4.size(); i4++) {
            if (str.equals(((C0617m2) I4.get(i4)).W())) {
                aVar.r(i4);
                return;
            }
        }
    }

    private final void p(C0643p2.a aVar, long j4, boolean z4) {
        String str;
        a6 a6Var;
        String str2;
        if (z4) {
            str = "_se";
        } else {
            str = "_lte";
        }
        String str3 = str;
        a6 N02 = l0().N0(aVar.Z0(), str3);
        if (N02 == null || N02.f2858e == null) {
            a6Var = new a6(aVar.Z0(), "auto", str3, B().currentTimeMillis(), Long.valueOf(j4));
        } else {
            a6Var = new a6(aVar.Z0(), "auto", str3, B().currentTimeMillis(), Long.valueOf(((Long) N02.f2858e).longValue() + j4));
        }
        C0674t2 t2Var = (C0674t2) ((C0668s4) C0674t2.S().t(str3).y(B().currentTimeMillis()).s(((Long) a6Var.f2858e).longValue()).m());
        int v4 = Z5.v(aVar, str3);
        if (v4 >= 0) {
            aVar.x(v4, t2Var);
        } else {
            aVar.E(t2Var);
        }
        if (j4 > 0) {
            l0().i0(a6Var);
            if (z4) {
                str2 = "session-scoped";
            } else {
                str2 = "lifetime";
            }
            a().K().c("Updated engagement user property. scope, value", str2, a6Var.f2858e);
        }
    }

    private static Boolean q0(M5 m5) {
        Boolean bool = m5.f2648r;
        if (!TextUtils.isEmpty(m5.f2630F)) {
            int i4 = N5.f2661a[B1.a(m5.f2630F).b().ordinal()];
            if (i4 == 1) {
                return null;
            }
            if (i4 == 2) {
                return Boolean.FALSE;
            }
            if (i4 == 3) {
                return Boolean.TRUE;
            }
            if (i4 != 4) {
                return bool;
            }
            return null;
        }
        return bool;
    }

    private static boolean s0(M5 m5) {
        if (!TextUtils.isEmpty(m5.f2632b) || !TextUtils.isEmpty(m5.f2647q)) {
            return true;
        }
        return false;
    }

    static /* synthetic */ void v(H5 h5, W5 w5) {
        h5.f().k();
        h5.f2547k = new E2(h5);
        C0797k kVar = new C0797k(h5);
        kVar.s();
        h5.f2539c = kVar;
        h5.i0().p((C0783i) C0335p.l(h5.f2537a));
        C0796j5 j5Var = new C0796j5(h5);
        j5Var.s();
        h5.f2545i = j5Var;
        h6 h6Var = new h6(h5);
        h6Var.s();
        h5.f2542f = h6Var;
        C0878v4 v4Var = new C0878v4(h5);
        v4Var.s();
        h5.f2544h = v4Var;
        D5 d5 = new D5(h5);
        d5.s();
        h5.f2541e = d5;
        h5.f2540d = new C0883w2(h5);
        if (h5.f2554r != h5.f2555s) {
            h5.a().G().c("Not all upload components initialized", Integer.valueOf(h5.f2554r), Integer.valueOf(h5.f2555s));
        }
        h5.f2549m = true;
    }

    public final Context A() {
        return this.f2548l.A();
    }

    /* access modifiers changed from: package-private */
    public final void A0() {
        if (!this.f2549m) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    public final d B() {
        return ((S2) C0335p.l(this.f2548l)).B();
    }

    /* access modifiers changed from: package-private */
    public final void B0() {
        this.f2555s++;
    }

    public final C0741c C() {
        return this.f2548l.C();
    }

    /* access modifiers changed from: package-private */
    public final void C0() {
        this.f2554r++;
    }

    /* access modifiers changed from: protected */
    public final void D0() {
        int delete;
        f().k();
        l0().j1();
        C0797k l02 = l0();
        l02.k();
        l02.r();
        if (l02.o0()) {
            C0737b2 b2Var = G.f2481i0;
            if (((Long) b2Var.a((Object) null)).longValue() != 0 && (delete = l02.y().delete("trigger_uris", "abs(timestamp_millis - ?) > cast(? as integer)", new String[]{String.valueOf(l02.B().currentTimeMillis()), String.valueOf(b2Var.a((Object) null))})) > 0) {
                l02.a().K().b("Deleted stale trigger uris. rowsDeleted", Integer.valueOf(delete));
            }
        }
        if (this.f2545i.f3055h.a() == 0) {
            this.f2545i.f3055h.b(B().currentTimeMillis());
        }
        R();
    }

    /* access modifiers changed from: package-private */
    public final void E(String str, C0643p2.a aVar) {
        int v4;
        int indexOf;
        Set S4 = r0().S(str);
        if (S4 != null) {
            aVar.c0(S4);
        }
        if (r0().b0(str)) {
            aVar.A0();
        }
        if (r0().e0(str)) {
            String e12 = aVar.e1();
            if (!TextUtils.isEmpty(e12) && (indexOf = e12.indexOf(".")) != -1) {
                aVar.Q0(e12.substring(0, indexOf));
            }
        }
        if (r0().f0(str) && (v4 = Z5.v(aVar, "_id")) != -1) {
            aVar.U(v4);
        }
        if (r0().d0(str)) {
            aVar.E0();
        }
        if (r0().a0(str)) {
            aVar.s0();
            if (!C0576h6.a() || !i0().q(G.f2455Z0) || U(str).z()) {
                b bVar = (b) this.f2533D.get(str);
                if (bVar == null || bVar.f2569b + i0().x(str, G.f2450X) < B().elapsedRealtime()) {
                    bVar = new b();
                    this.f2533D.put(str, bVar);
                }
                aVar.G0(bVar.f2568a);
            }
        }
        if (r0().c0(str)) {
            aVar.V0();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:220|221) */
    /* JADX WARNING: Code restructure failed: missing block: B:221:?, code lost:
        a().G().c("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.C0821n2.s(r6), r0.b());
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:220:0x05dd */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0315 A[Catch:{ all -> 0x002f }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0537 A[Catch:{ all -> 0x002f }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0540 A[Catch:{ all -> 0x002f }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0552 A[SYNTHETIC, Splitter:B:197:0x0552] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x05a1 A[Catch:{ MalformedURLException -> 0x05ab }] */
    /* JADX WARNING: Removed duplicated region for block: B:241:0x033b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E0() {
        /*
            r24 = this;
            r1 = r24
            com.google.android.gms.measurement.internal.P2 r0 = r1.f()
            r0.k()
            r1.A0()
            r0 = 1
            r1.f2558v = r0
            r8 = 0
            com.google.android.gms.measurement.internal.S2 r2 = r1.f2548l     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.F4 r2 = r2.J()     // Catch:{ all -> 0x002f }
            java.lang.Boolean r2 = r2.W()     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0033
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.p2 r0 = r0.L()     // Catch:{ all -> 0x002f }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r0.a(r2)     // Catch:{ all -> 0x002f }
            r1.f2558v = r8
            r1.P()
            return
        L_0x002f:
            r0 = move-exception
            r2 = 0
            goto L_0x0620
        L_0x0033:
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x004c
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()     // Catch:{ all -> 0x002f }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r0.a(r2)     // Catch:{ all -> 0x002f }
            r1.f2558v = r8
            r1.P()
            return
        L_0x004c:
            long r2 = r1.f2551o     // Catch:{ all -> 0x002f }
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x005d
            r1.R()     // Catch:{ all -> 0x002f }
            r1.f2558v = r8
            r1.P()
            return
        L_0x005d:
            com.google.android.gms.measurement.internal.P2 r2 = r1.f()     // Catch:{ all -> 0x002f }
            r2.k()     // Catch:{ all -> 0x002f }
            java.util.List r2 = r1.f2561y     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x007b
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.p2 r0 = r0.K()     // Catch:{ all -> 0x002f }
            java.lang.String r2 = "Uploading requested multiple times"
            r0.a(r2)     // Catch:{ all -> 0x002f }
            r1.f2558v = r8
            r1.P()
            return
        L_0x007b:
            com.google.android.gms.measurement.internal.q2 r2 = r1.p0()     // Catch:{ all -> 0x002f }
            boolean r2 = r2.z()     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x009b
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.p2 r0 = r0.K()     // Catch:{ all -> 0x002f }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.a(r2)     // Catch:{ all -> 0x002f }
            r1.R()     // Catch:{ all -> 0x002f }
            r1.f2558v = r8
            r1.P()
            return
        L_0x009b:
            R.d r2 = r1.B()     // Catch:{ all -> 0x002f }
            long r2 = r2.currentTimeMillis()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.g r6 = r1.i0()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.b2 r7 = com.google.android.gms.measurement.internal.G.f2446V     // Catch:{ all -> 0x002f }
            r9 = 0
            int r6 = r6.t(r9, r7)     // Catch:{ all -> 0x002f }
            r1.i0()     // Catch:{ all -> 0x002f }
            long r10 = com.google.android.gms.measurement.internal.C0769g.I()     // Catch:{ all -> 0x002f }
            long r10 = r2 - r10
            r7 = 0
        L_0x00b8:
            if (r7 >= r6) goto L_0x00c3
            boolean r12 = r1.O(r9, r10)     // Catch:{ all -> 0x002f }
            if (r12 == 0) goto L_0x00c3
            int r7 = r7 + 1
            goto L_0x00b8
        L_0x00c3:
            boolean r6 = com.google.android.gms.internal.measurement.C0604k7.a()     // Catch:{ all -> 0x002f }
            if (r6 == 0) goto L_0x00cc
            r1.Q()     // Catch:{ all -> 0x002f }
        L_0x00cc:
            com.google.android.gms.measurement.internal.j5 r6 = r1.f2545i     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.A2 r6 = r6.f3055h     // Catch:{ all -> 0x002f }
            long r6 = r6.a()     // Catch:{ all -> 0x002f }
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 == 0) goto L_0x00ef
            com.google.android.gms.measurement.internal.n2 r4 = r1.a()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.p2 r4 = r4.F()     // Catch:{ all -> 0x002f }
            java.lang.String r5 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r6 = r2 - r6
            long r6 = java.lang.Math.abs(r6)     // Catch:{ all -> 0x002f }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x002f }
            r4.b(r5, r6)     // Catch:{ all -> 0x002f }
        L_0x00ef:
            com.google.android.gms.measurement.internal.k r4 = r1.l0()     // Catch:{ all -> 0x002f }
            java.lang.String r6 = r4.z()     // Catch:{ all -> 0x002f }
            boolean r4 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x002f }
            r10 = -1
            if (r4 != 0) goto L_0x05f3
            long r4 = r1.f2530A     // Catch:{ all -> 0x002f }
            int r7 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r7 != 0) goto L_0x010f
            com.google.android.gms.measurement.internal.k r4 = r1.l0()     // Catch:{ all -> 0x002f }
            long r4 = r4.v()     // Catch:{ all -> 0x002f }
            r1.f2530A = r4     // Catch:{ all -> 0x002f }
        L_0x010f:
            com.google.android.gms.measurement.internal.g r4 = r1.i0()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.b2 r5 = com.google.android.gms.measurement.internal.G.f2477h     // Catch:{ all -> 0x002f }
            int r4 = r4.t(r6, r5)     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.g r5 = r1.i0()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.b2 r7 = com.google.android.gms.measurement.internal.G.f2480i     // Catch:{ all -> 0x002f }
            int r5 = r5.t(r6, r7)     // Catch:{ all -> 0x002f }
            int r5 = java.lang.Math.max(r8, r5)     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.k r7 = r1.l0()     // Catch:{ all -> 0x002f }
            java.util.List r4 = r7.Q(r6, r4, r5)     // Catch:{ all -> 0x002f }
            boolean r5 = r4.isEmpty()     // Catch:{ all -> 0x002f }
            if (r5 != 0) goto L_0x0592
            com.google.android.gms.measurement.internal.A3 r5 = r1.U(r6)     // Catch:{ all -> 0x002f }
            boolean r5 = r5.y()     // Catch:{ all -> 0x002f }
            if (r5 == 0) goto L_0x0192
            java.util.Iterator r5 = r4.iterator()     // Catch:{ all -> 0x002f }
        L_0x0143:
            boolean r7 = r5.hasNext()     // Catch:{ all -> 0x002f }
            if (r7 == 0) goto L_0x0162
            java.lang.Object r7 = r5.next()     // Catch:{ all -> 0x002f }
            android.util.Pair r7 = (android.util.Pair) r7     // Catch:{ all -> 0x002f }
            java.lang.Object r7 = r7.first     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.p2 r7 = (com.google.android.gms.internal.measurement.C0643p2) r7     // Catch:{ all -> 0x002f }
            java.lang.String r10 = r7.h0()     // Catch:{ all -> 0x002f }
            boolean r10 = r10.isEmpty()     // Catch:{ all -> 0x002f }
            if (r10 != 0) goto L_0x0143
            java.lang.String r5 = r7.h0()     // Catch:{ all -> 0x002f }
            goto L_0x0163
        L_0x0162:
            r5 = r9
        L_0x0163:
            if (r5 == 0) goto L_0x0192
            r7 = 0
        L_0x0166:
            int r10 = r4.size()     // Catch:{ all -> 0x002f }
            if (r7 >= r10) goto L_0x0192
            java.lang.Object r10 = r4.get(r7)     // Catch:{ all -> 0x002f }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x002f }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.p2 r10 = (com.google.android.gms.internal.measurement.C0643p2) r10     // Catch:{ all -> 0x002f }
            java.lang.String r11 = r10.h0()     // Catch:{ all -> 0x002f }
            boolean r11 = r11.isEmpty()     // Catch:{ all -> 0x002f }
            if (r11 != 0) goto L_0x018f
            java.lang.String r10 = r10.h0()     // Catch:{ all -> 0x002f }
            boolean r10 = r10.equals(r5)     // Catch:{ all -> 0x002f }
            if (r10 != 0) goto L_0x018f
            java.util.List r4 = r4.subList(r8, r7)     // Catch:{ all -> 0x002f }
            goto L_0x0192
        L_0x018f:
            int r7 = r7 + 1
            goto L_0x0166
        L_0x0192:
            com.google.android.gms.internal.measurement.o2$a r5 = com.google.android.gms.internal.measurement.C0635o2.L()     // Catch:{ all -> 0x002f }
            int r7 = r4.size()     // Catch:{ all -> 0x002f }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x002f }
            int r11 = r4.size()     // Catch:{ all -> 0x002f }
            r10.<init>(r11)     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.g r11 = r1.i0()     // Catch:{ all -> 0x002f }
            boolean r11 = r11.N(r6)     // Catch:{ all -> 0x002f }
            if (r11 == 0) goto L_0x01b9
            com.google.android.gms.measurement.internal.A3 r11 = r1.U(r6)     // Catch:{ all -> 0x002f }
            boolean r11 = r11.y()     // Catch:{ all -> 0x002f }
            if (r11 == 0) goto L_0x01b9
            r11 = 1
            goto L_0x01ba
        L_0x01b9:
            r11 = 0
        L_0x01ba:
            com.google.android.gms.measurement.internal.A3 r12 = r1.U(r6)     // Catch:{ all -> 0x002f }
            boolean r12 = r12.y()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.A3 r13 = r1.U(r6)     // Catch:{ all -> 0x002f }
            boolean r13 = r13.z()     // Catch:{ all -> 0x002f }
            boolean r14 = com.google.android.gms.internal.measurement.C0613l7.a()     // Catch:{ all -> 0x002f }
            if (r14 == 0) goto L_0x01de
            com.google.android.gms.measurement.internal.g r14 = r1.i0()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.b2 r15 = com.google.android.gms.measurement.internal.G.f2516x0     // Catch:{ all -> 0x002f }
            boolean r14 = r14.F(r6, r15)     // Catch:{ all -> 0x002f }
            if (r14 == 0) goto L_0x01de
            r14 = 1
            goto L_0x01df
        L_0x01de:
            r14 = 0
        L_0x01df:
            com.google.android.gms.measurement.internal.G5 r15 = r1.f2546j     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.I5 r15 = r15.r(r6)     // Catch:{ all -> 0x002f }
            r9 = 0
        L_0x01e6:
            if (r9 >= r7) goto L_0x0349
            java.lang.Object r16 = r4.get(r9)     // Catch:{ all -> 0x002f }
            r0 = r16
            android.util.Pair r0 = (android.util.Pair) r0     // Catch:{ all -> 0x002f }
            java.lang.Object r0 = r0.first     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.p2 r0 = (com.google.android.gms.internal.measurement.C0643p2) r0     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.s4$b r0 = r0.y()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.p2$a r0 = (com.google.android.gms.internal.measurement.C0643p2.a) r0     // Catch:{ all -> 0x002f }
            java.lang.Object r16 = r4.get(r9)     // Catch:{ all -> 0x002f }
            r8 = r16
            android.util.Pair r8 = (android.util.Pair) r8     // Catch:{ all -> 0x002f }
            java.lang.Object r8 = r8.second     // Catch:{ all -> 0x002f }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x002f }
            r10.add(r8)     // Catch:{ all -> 0x002f }
            r1.i0()     // Catch:{ all -> 0x002f }
            r16 = r7
            r7 = 106000(0x19e10, double:5.2371E-319)
            com.google.android.gms.internal.measurement.p2$a r7 = r0.J0(r7)     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.p2$a r7 = r7.F0(r2)     // Catch:{ all -> 0x002f }
            r8 = 0
            r7.e0(r8)     // Catch:{ all -> 0x002f }
            if (r11 != 0) goto L_0x0222
            r0.E0()     // Catch:{ all -> 0x002f }
        L_0x0222:
            if (r12 != 0) goto L_0x022a
            r0.T0()     // Catch:{ all -> 0x002f }
            r0.N0()     // Catch:{ all -> 0x002f }
        L_0x022a:
            if (r13 != 0) goto L_0x022f
            r0.s0()     // Catch:{ all -> 0x002f }
        L_0x022f:
            r1.E(r6, r0)     // Catch:{ all -> 0x002f }
            if (r14 != 0) goto L_0x0237
            r0.V0()     // Catch:{ all -> 0x002f }
        L_0x0237:
            boolean r7 = com.google.android.gms.internal.measurement.C0576h6.a()     // Catch:{ all -> 0x002f }
            if (r7 == 0) goto L_0x024e
            com.google.android.gms.measurement.internal.g r7 = r1.i0()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.b2 r8 = com.google.android.gms.measurement.internal.G.f2458a1     // Catch:{ all -> 0x002f }
            boolean r7 = r7.q(r8)     // Catch:{ all -> 0x002f }
            if (r7 == 0) goto L_0x024e
            if (r13 != 0) goto L_0x024e
            r0.w0()     // Catch:{ all -> 0x002f }
        L_0x024e:
            java.lang.String r7 = r0.f1()     // Catch:{ all -> 0x002f }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x002f }
            if (r8 != 0) goto L_0x026b
            java.lang.String r8 = "00000000-0000-0000-0000-000000000000"
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x002f }
            if (r7 == 0) goto L_0x0261
            goto L_0x026b
        L_0x0261:
            r17 = r4
            r22 = r9
            r21 = r11
            r23 = r12
            goto L_0x030f
        L_0x026b:
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x002f }
            java.util.List r8 = r0.I()     // Catch:{ all -> 0x002f }
            r7.<init>(r8)     // Catch:{ all -> 0x002f }
            java.util.Iterator r8 = r7.iterator()     // Catch:{ all -> 0x002f }
            r17 = r4
            r18 = r8
            r4 = 0
            r8 = 0
            r19 = 0
            r20 = 0
        L_0x0282:
            boolean r21 = r18.hasNext()     // Catch:{ all -> 0x002f }
            if (r21 == 0) goto L_0x02f7
            java.lang.Object r21 = r18.next()     // Catch:{ all -> 0x002f }
            r22 = r9
            r9 = r21
            com.google.android.gms.internal.measurement.k2 r9 = (com.google.android.gms.internal.measurement.C0599k2) r9     // Catch:{ all -> 0x002f }
            r21 = r11
            java.lang.String r11 = "_fx"
            r23 = r12
            java.lang.String r12 = r9.U()     // Catch:{ all -> 0x002f }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x002f }
            if (r11 == 0) goto L_0x02b0
            r18.remove()     // Catch:{ all -> 0x002f }
            r11 = r21
            r9 = r22
            r12 = r23
            r19 = 1
            r20 = 1
            goto L_0x0282
        L_0x02b0:
            java.lang.String r11 = "_f"
            java.lang.String r12 = r9.U()     // Catch:{ all -> 0x002f }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x002f }
            if (r11 == 0) goto L_0x02f0
            com.google.android.gms.measurement.internal.g r11 = r1.i0()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.b2 r12 = com.google.android.gms.measurement.internal.G.f2451X0     // Catch:{ all -> 0x002f }
            boolean r11 = r11.q(r12)     // Catch:{ all -> 0x002f }
            if (r11 == 0) goto L_0x02ee
            r1.x0()     // Catch:{ all -> 0x002f }
            java.lang.String r11 = "_pfo"
            com.google.android.gms.internal.measurement.m2 r11 = com.google.android.gms.measurement.internal.Z5.F(r9, r11)     // Catch:{ all -> 0x002f }
            if (r11 == 0) goto L_0x02db
            long r11 = r11.S()     // Catch:{ all -> 0x002f }
            java.lang.Long r4 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x002f }
        L_0x02db:
            r1.x0()     // Catch:{ all -> 0x002f }
            java.lang.String r11 = "_uwa"
            com.google.android.gms.internal.measurement.m2 r9 = com.google.android.gms.measurement.internal.Z5.F(r9, r11)     // Catch:{ all -> 0x002f }
            if (r9 == 0) goto L_0x02ee
            long r8 = r9.S()     // Catch:{ all -> 0x002f }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x002f }
        L_0x02ee:
            r20 = 1
        L_0x02f0:
            r11 = r21
            r9 = r22
            r12 = r23
            goto L_0x0282
        L_0x02f7:
            r22 = r9
            r21 = r11
            r23 = r12
            if (r19 == 0) goto L_0x0305
            r0.I0()     // Catch:{ all -> 0x002f }
            r0.Q(r7)     // Catch:{ all -> 0x002f }
        L_0x0305:
            if (r20 == 0) goto L_0x030f
            java.lang.String r7 = r0.Z0()     // Catch:{ all -> 0x002f }
            r9 = 1
            r1.I(r7, r9, r4, r8)     // Catch:{ all -> 0x002f }
        L_0x030f:
            int r4 = r0.T()     // Catch:{ all -> 0x002f }
            if (r4 == 0) goto L_0x033b
            com.google.android.gms.measurement.internal.g r4 = r1.i0()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.b2 r7 = com.google.android.gms.measurement.internal.G.f2496n0     // Catch:{ all -> 0x002f }
            boolean r4 = r4.F(r6, r7)     // Catch:{ all -> 0x002f }
            if (r4 == 0) goto L_0x0338
            com.google.android.gms.internal.measurement.Z4 r4 = r0.m()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.s4 r4 = (com.google.android.gms.internal.measurement.C0668s4) r4     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.p2 r4 = (com.google.android.gms.internal.measurement.C0643p2) r4     // Catch:{ all -> 0x002f }
            byte[] r4 = r4.i()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.Z5 r7 = r1.x0()     // Catch:{ all -> 0x002f }
            long r7 = r7.x(r4)     // Catch:{ all -> 0x002f }
            r0.y(r7)     // Catch:{ all -> 0x002f }
        L_0x0338:
            r5.r(r0)     // Catch:{ all -> 0x002f }
        L_0x033b:
            int r9 = r22 + 1
            r7 = r16
            r4 = r17
            r11 = r21
            r12 = r23
            r0 = 1
            r8 = 0
            goto L_0x01e6
        L_0x0349:
            r16 = r7
            int r0 = r5.q()     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x0365
            r1.J(r10)     // Catch:{ all -> 0x002f }
            java.util.List r7 = java.util.Collections.EMPTY_LIST     // Catch:{ all -> 0x002f }
            r2 = 0
            r3 = 204(0xcc, float:2.86E-43)
            r4 = 0
            r5 = 0
            r1.L(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x002f }
            r8 = 0
            r1.f2558v = r8
            r1.P()
            return
        L_0x0365:
            com.google.android.gms.internal.measurement.Z4 r0 = r5.m()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.s4 r0 = (com.google.android.gms.internal.measurement.C0668s4) r0     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.o2 r0 = (com.google.android.gms.internal.measurement.C0635o2) r0     // Catch:{ all -> 0x002f }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x002f }
            r4.<init>()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.g r7 = r1.i0()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.b2 r8 = com.google.android.gms.measurement.internal.G.f2518y0     // Catch:{ all -> 0x002f }
            boolean r7 = r7.q(r8)     // Catch:{ all -> 0x002f }
            if (r7 == 0) goto L_0x052b
            r1.y0()     // Catch:{ all -> 0x002f }
            boolean r7 = com.google.android.gms.measurement.internal.d6.H0(r6)     // Catch:{ all -> 0x002f }
            if (r7 == 0) goto L_0x052b
            f0.C r7 = r15.a()     // Catch:{ all -> 0x002f }
            f0.C r8 = f0.C.SGTM     // Catch:{ all -> 0x002f }
            if (r7 != r8) goto L_0x052b
            com.google.android.gms.internal.measurement.Z4 r0 = r5.m()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.s4 r0 = (com.google.android.gms.internal.measurement.C0668s4) r0     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.o2 r0 = (com.google.android.gms.internal.measurement.C0635o2) r0     // Catch:{ all -> 0x002f }
            java.util.List r0 = r0.R()     // Catch:{ all -> 0x002f }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x002f }
        L_0x039f:
            boolean r7 = r0.hasNext()     // Catch:{ all -> 0x002f }
            if (r7 == 0) goto L_0x03ba
            java.lang.Object r7 = r0.next()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.p2 r7 = (com.google.android.gms.internal.measurement.C0643p2) r7     // Catch:{ all -> 0x002f }
            boolean r7 = r7.J0()     // Catch:{ all -> 0x002f }
            if (r7 == 0) goto L_0x039f
            java.util.UUID r0 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x002f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x002f }
            goto L_0x03bb
        L_0x03ba:
            r0 = 0
        L_0x03bb:
            com.google.android.gms.internal.measurement.Z4 r7 = r5.m()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.s4 r7 = (com.google.android.gms.internal.measurement.C0668s4) r7     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.o2 r7 = (com.google.android.gms.internal.measurement.C0635o2) r7     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.P2 r8 = r1.f()     // Catch:{ all -> 0x002f }
            r8.k()     // Catch:{ all -> 0x002f }
            r1.A0()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.o2$a r8 = com.google.android.gms.internal.measurement.C0635o2.G(r7)     // Catch:{ all -> 0x002f }
            boolean r9 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x002f }
            if (r9 != 0) goto L_0x03da
            r8.t(r0)     // Catch:{ all -> 0x002f }
        L_0x03da:
            com.google.android.gms.measurement.internal.I2 r9 = r1.r0()     // Catch:{ all -> 0x002f }
            java.lang.String r9 = r9.R(r6)     // Catch:{ all -> 0x002f }
            boolean r11 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x002f }
            if (r11 != 0) goto L_0x03eb
            r8.z(r9)     // Catch:{ all -> 0x002f }
        L_0x03eb:
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x002f }
            r9.<init>()     // Catch:{ all -> 0x002f }
            java.util.List r7 = r7.R()     // Catch:{ all -> 0x002f }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x002f }
        L_0x03f8:
            boolean r11 = r7.hasNext()     // Catch:{ all -> 0x002f }
            if (r11 == 0) goto L_0x0417
            java.lang.Object r11 = r7.next()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.p2 r11 = (com.google.android.gms.internal.measurement.C0643p2) r11     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.p2$a r11 = com.google.android.gms.internal.measurement.C0643p2.H(r11)     // Catch:{ all -> 0x002f }
            r11.E0()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.Z4 r11 = r11.m()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.s4 r11 = (com.google.android.gms.internal.measurement.C0668s4) r11     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.p2 r11 = (com.google.android.gms.internal.measurement.C0643p2) r11     // Catch:{ all -> 0x002f }
            r9.add(r11)     // Catch:{ all -> 0x002f }
            goto L_0x03f8
        L_0x0417:
            r8.y()     // Catch:{ all -> 0x002f }
            r8.s(r9)     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.g r7 = r1.i0()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.b2 r9 = com.google.android.gms.measurement.internal.G.f2411D0     // Catch:{ all -> 0x002f }
            boolean r7 = r7.q(r9)     // Catch:{ all -> 0x002f }
            if (r7 == 0) goto L_0x0444
            com.google.android.gms.measurement.internal.n2 r7 = r1.a()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.p2 r7 = r7.K()     // Catch:{ all -> 0x002f }
            java.lang.String r11 = "Processed MeasurementBatch for sGTM with sgtmJoinId: "
            boolean r12 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x002f }
            if (r12 == 0) goto L_0x043c
            java.lang.String r12 = "null"
            goto L_0x0440
        L_0x043c:
            java.lang.String r12 = r8.A()     // Catch:{ all -> 0x002f }
        L_0x0440:
            r7.b(r11, r12)     // Catch:{ all -> 0x002f }
            goto L_0x0451
        L_0x0444:
            com.google.android.gms.measurement.internal.n2 r7 = r1.a()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.p2 r7 = r7.K()     // Catch:{ all -> 0x002f }
            java.lang.String r11 = "Processed MeasurementBatch for sGTM."
            r7.a(r11)     // Catch:{ all -> 0x002f }
        L_0x0451:
            com.google.android.gms.internal.measurement.Z4 r7 = r8.m()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.s4 r7 = (com.google.android.gms.internal.measurement.C0668s4) r7     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.o2 r7 = (com.google.android.gms.internal.measurement.C0635o2) r7     // Catch:{ all -> 0x002f }
            boolean r8 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x002f }
            if (r8 != 0) goto L_0x0528
            com.google.android.gms.measurement.internal.g r8 = r1.i0()     // Catch:{ all -> 0x002f }
            boolean r8 = r8.q(r9)     // Catch:{ all -> 0x002f }
            if (r8 == 0) goto L_0x0528
            com.google.android.gms.internal.measurement.Z4 r8 = r5.m()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.s4 r8 = (com.google.android.gms.internal.measurement.C0668s4) r8     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.o2 r8 = (com.google.android.gms.internal.measurement.C0635o2) r8     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.P2 r9 = r1.f()     // Catch:{ all -> 0x002f }
            r9.k()     // Catch:{ all -> 0x002f }
            r1.A0()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.o2$a r9 = com.google.android.gms.internal.measurement.C0635o2.L()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.n2 r11 = r1.a()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.p2 r11 = r11.K()     // Catch:{ all -> 0x002f }
            java.lang.String r12 = "Processing Google Signal, sgtmJoinId:"
            r11.b(r12, r0)     // Catch:{ all -> 0x002f }
            r9.t(r0)     // Catch:{ all -> 0x002f }
            java.util.List r0 = r8.R()     // Catch:{ all -> 0x002f }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x002f }
        L_0x0497:
            boolean r8 = r0.hasNext()     // Catch:{ all -> 0x002f }
            if (r8 == 0) goto L_0x04bb
            java.lang.Object r8 = r0.next()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.p2 r8 = (com.google.android.gms.internal.measurement.C0643p2) r8     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.p2$a r11 = com.google.android.gms.internal.measurement.C0643p2.u2()     // Catch:{ all -> 0x002f }
            java.lang.String r12 = r8.b0()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.p2$a r11 = r11.D0(r12)     // Catch:{ all -> 0x002f }
            int r8 = r8.j1()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.p2$a r8 = r11.p0(r8)     // Catch:{ all -> 0x002f }
            r9.r(r8)     // Catch:{ all -> 0x002f }
            goto L_0x0497
        L_0x04bb:
            com.google.android.gms.internal.measurement.Z4 r0 = r9.m()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.s4 r0 = (com.google.android.gms.internal.measurement.C0668s4) r0     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.measurement.o2 r0 = (com.google.android.gms.internal.measurement.C0635o2) r0     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.G5 r8 = r1.f2546j     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.I2 r8 = r8.o()     // Catch:{ all -> 0x002f }
            java.lang.String r8 = r8.R(r6)     // Catch:{ all -> 0x002f }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x002f }
            if (r9 != 0) goto L_0x0510
            com.google.android.gms.measurement.internal.b2 r9 = com.google.android.gms.measurement.internal.G.f2505s     // Catch:{ all -> 0x002f }
            r11 = 0
            java.lang.Object r9 = r9.a(r11)     // Catch:{ all -> 0x002f }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x002f }
            android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch:{ all -> 0x002f }
            android.net.Uri$Builder r11 = r9.buildUpon()     // Catch:{ all -> 0x002f }
            java.lang.String r9 = r9.getAuthority()     // Catch:{ all -> 0x002f }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x002f }
            r12.<init>()     // Catch:{ all -> 0x002f }
            r12.append(r8)     // Catch:{ all -> 0x002f }
            java.lang.String r8 = "."
            r12.append(r8)     // Catch:{ all -> 0x002f }
            r12.append(r9)     // Catch:{ all -> 0x002f }
            java.lang.String r8 = r12.toString()     // Catch:{ all -> 0x002f }
            r11.authority(r8)     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.I5 r8 = new com.google.android.gms.measurement.internal.I5     // Catch:{ all -> 0x002f }
            android.net.Uri r9 = r11.build()     // Catch:{ all -> 0x002f }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x002f }
            f0.C r11 = f0.C.GOOGLE_SIGNAL     // Catch:{ all -> 0x002f }
            r8.<init>(r9, r11)     // Catch:{ all -> 0x002f }
            r11 = 0
            goto L_0x0520
        L_0x0510:
            com.google.android.gms.measurement.internal.I5 r8 = new com.google.android.gms.measurement.internal.I5     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.b2 r9 = com.google.android.gms.measurement.internal.G.f2505s     // Catch:{ all -> 0x002f }
            r11 = 0
            java.lang.Object r9 = r9.a(r11)     // Catch:{ all -> 0x002f }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x002f }
            f0.C r12 = f0.C.GOOGLE_SIGNAL     // Catch:{ all -> 0x002f }
            r8.<init>(r9, r12)     // Catch:{ all -> 0x002f }
        L_0x0520:
            android.util.Pair r0 = android.util.Pair.create(r0, r8)     // Catch:{ all -> 0x002f }
            r4.add(r0)     // Catch:{ all -> 0x002f }
            goto L_0x0529
        L_0x0528:
            r11 = 0
        L_0x0529:
            r0 = r7
            goto L_0x052c
        L_0x052b:
            r11 = 0
        L_0x052c:
            com.google.android.gms.measurement.internal.n2 r7 = r1.a()     // Catch:{ all -> 0x002f }
            r8 = 2
            boolean r7 = r7.z(r8)     // Catch:{ all -> 0x002f }
            if (r7 == 0) goto L_0x0540
            com.google.android.gms.measurement.internal.Z5 r7 = r1.x0()     // Catch:{ all -> 0x002f }
            java.lang.String r9 = r7.M(r0)     // Catch:{ all -> 0x002f }
            goto L_0x0541
        L_0x0540:
            r9 = r11
        L_0x0541:
            r1.x0()     // Catch:{ all -> 0x002f }
            byte[] r13 = r0.i()     // Catch:{ all -> 0x002f }
            boolean r7 = com.google.android.gms.internal.measurement.Y6.a()     // Catch:{ all -> 0x002f }
            java.lang.String r8 = "Uploading data. app, uncompressed size, data"
            java.lang.String r11 = "?"
            if (r7 == 0) goto L_0x0595
            com.google.android.gms.measurement.internal.g r7 = r1.i0()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.b2 r12 = com.google.android.gms.measurement.internal.G.f2417G0     // Catch:{ all -> 0x002f }
            boolean r7 = r7.q(r12)     // Catch:{ all -> 0x002f }
            if (r7 == 0) goto L_0x0595
            r1.J(r10)     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.j5 r7 = r1.f2545i     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.A2 r7 = r7.f3056i     // Catch:{ all -> 0x002f }
            r7.b(r2)     // Catch:{ all -> 0x002f }
            if (r16 <= 0) goto L_0x0573
            r2 = 0
            com.google.android.gms.internal.measurement.p2 r3 = r5.x(r2)     // Catch:{ all -> 0x002f }
            java.lang.String r11 = r3.x2()     // Catch:{ all -> 0x002f }
        L_0x0573:
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.p2 r2 = r2.K()     // Catch:{ all -> 0x002f }
            int r3 = r13.length     // Catch:{ all -> 0x002f }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x002f }
            r2.d(r8, r11, r3, r9)     // Catch:{ all -> 0x002f }
            r9 = 1
            r1.f2557u = r9     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.q2 r2 = r1.p0()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.L5 r3 = new com.google.android.gms.measurement.internal.L5     // Catch:{ all -> 0x002f }
            r3.<init>(r1, r6, r4)     // Catch:{ all -> 0x002f }
            r2.v(r6, r15, r0, r3)     // Catch:{ all -> 0x002f }
        L_0x0592:
            r2 = 0
            goto L_0x061a
        L_0x0595:
            r1.J(r10)     // Catch:{ MalformedURLException -> 0x05ab }
            com.google.android.gms.measurement.internal.j5 r0 = r1.f2545i     // Catch:{ MalformedURLException -> 0x05ab }
            com.google.android.gms.measurement.internal.A2 r0 = r0.f3056i     // Catch:{ MalformedURLException -> 0x05ab }
            r0.b(r2)     // Catch:{ MalformedURLException -> 0x05ab }
            if (r16 <= 0) goto L_0x05ad
            r2 = 0
            com.google.android.gms.internal.measurement.p2 r0 = r5.x(r2)     // Catch:{ MalformedURLException -> 0x05ab }
            java.lang.String r11 = r0.x2()     // Catch:{ MalformedURLException -> 0x05ab }
            goto L_0x05ad
        L_0x05ab:
            r0 = r15
            goto L_0x05dd
        L_0x05ad:
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()     // Catch:{ MalformedURLException -> 0x05ab }
            com.google.android.gms.measurement.internal.p2 r0 = r0.K()     // Catch:{ MalformedURLException -> 0x05ab }
            int r2 = r13.length     // Catch:{ MalformedURLException -> 0x05ab }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ MalformedURLException -> 0x05ab }
            r0.d(r8, r11, r2, r9)     // Catch:{ MalformedURLException -> 0x05ab }
            r9 = 1
            r1.f2557u = r9     // Catch:{ MalformedURLException -> 0x05ab }
            com.google.android.gms.measurement.internal.q2 r10 = r1.p0()     // Catch:{ MalformedURLException -> 0x05ab }
            java.net.URL r12 = new java.net.URL     // Catch:{ MalformedURLException -> 0x05ab }
            java.lang.String r0 = r15.b()     // Catch:{ MalformedURLException -> 0x05ab }
            r12.<init>(r0)     // Catch:{ MalformedURLException -> 0x05ab }
            java.util.Map r14 = r15.c()     // Catch:{ MalformedURLException -> 0x05ab }
            r0 = r15
            com.google.android.gms.measurement.internal.P5 r15 = new com.google.android.gms.measurement.internal.P5     // Catch:{ MalformedURLException -> 0x05dd }
            r15.<init>(r1, r6, r4)     // Catch:{ MalformedURLException -> 0x05dd }
            r11 = r6
            r10.w(r11, r12, r13, r14, r15)     // Catch:{ MalformedURLException -> 0x05dc }
            goto L_0x0592
        L_0x05dc:
            r6 = r11
        L_0x05dd:
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.p2 r2 = r2.G()     // Catch:{ all -> 0x002f }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C0821n2.s(r6)     // Catch:{ all -> 0x002f }
            java.lang.String r0 = r0.b()     // Catch:{ all -> 0x002f }
            r2.c(r3, r4, r0)     // Catch:{ all -> 0x002f }
            goto L_0x0592
        L_0x05f3:
            r1.f2530A = r10     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.k r0 = r1.l0()     // Catch:{ all -> 0x002f }
            r1.i0()     // Catch:{ all -> 0x002f }
            long r4 = com.google.android.gms.measurement.internal.C0769g.I()     // Catch:{ all -> 0x002f }
            long r2 = r2 - r4
            java.lang.String r0 = r0.O(r2)     // Catch:{ all -> 0x002f }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x002f }
            if (r2 != 0) goto L_0x0592
            com.google.android.gms.measurement.internal.k r2 = r1.l0()     // Catch:{ all -> 0x002f }
            com.google.android.gms.measurement.internal.c2 r0 = r2.M0(r0)     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x0592
            r1.Z(r0)     // Catch:{ all -> 0x002f }
            goto L_0x0592
        L_0x061a:
            r1.f2558v = r2
            r1.P()
            return
        L_0x0620:
            r1.f2558v = r2
            r1.P()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.H5.E0():void");
    }

    public final void G(String str, C0892x4 x4Var) {
        f().k();
        String str2 = this.f2535F;
        if (str2 == null || str2.equals(str) || x4Var != null) {
            this.f2535F = str;
            this.f2534E = x4Var;
        }
    }

    /* access modifiers changed from: package-private */
    public final void H(String str, M5 m5) {
        long j4;
        f().k();
        A0();
        if (s0(m5)) {
            if (!m5.f2638h) {
                g(m5);
                return;
            }
            Boolean q02 = q0(m5);
            if (!"_npa".equals(str) || q02 == null) {
                a().F().b("Removing user property", this.f2548l.D().g(str));
                l0().c1();
                try {
                    g(m5);
                    if ("_id".equals(str)) {
                        l0().T0((String) C0335p.l(m5.f2631a), "_lair");
                    }
                    l0().T0((String) C0335p.l(m5.f2631a), str);
                    l0().k1();
                    a().F().b("User property removed", this.f2548l.D().g(str));
                    l0().i1();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    l0().i1();
                    throw th2;
                }
            } else {
                a().F().a("Falling back to manifest metadata value for ad personalization");
                long currentTimeMillis = B().currentTimeMillis();
                if (q02.booleanValue()) {
                    j4 = 1;
                } else {
                    j4 = 0;
                }
                w(new Y5("_npa", currentTimeMillis, Long.valueOf(j4), "auto"), m5);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void K(boolean z4) {
        R();
    }

    /* access modifiers changed from: package-private */
    public final void L(boolean z4, int i4, Throwable th, byte[] bArr, String str, List list) {
        byte[] bArr2;
        C0797k l02;
        f().k();
        A0();
        if (bArr == null) {
            try {
                bArr2 = new byte[0];
            } catch (SQLiteException e5) {
                a().G().b("Database error while trying to delete uploaded bundles", e5);
                this.f2551o = B().elapsedRealtime();
                a().K().b("Disable upload, time", Long.valueOf(this.f2551o));
            } catch (Throwable th2) {
                Throwable th3 = th2;
                this.f2557u = false;
                P();
                throw th3;
            }
        } else {
            bArr2 = bArr;
        }
        List<Long> list2 = (List) C0335p.l(this.f2561y);
        this.f2561y = null;
        if (z4) {
            if ((i4 != 200 && i4 != 204) || th != null) {
                if (Y6.a()) {
                    if (i0().q(G.f2417G0)) {
                        String str2 = new String(bArr2, StandardCharsets.UTF_8);
                        a().M().d("Network upload failed. Will retry later. code, error", Integer.valueOf(i4), th, str2.substring(0, Math.min(32, str2.length())));
                        this.f2545i.f3056i.b(B().currentTimeMillis());
                        if (i4 == 503 || i4 == 429) {
                            this.f2545i.f3054g.b(B().currentTimeMillis());
                        }
                        l0().d0(list2);
                        R();
                        this.f2557u = false;
                        P();
                    }
                }
                a().K().c("Network upload failed. Will retry later. code, error", Integer.valueOf(i4), th);
                this.f2545i.f3056i.b(B().currentTimeMillis());
                this.f2545i.f3054g.b(B().currentTimeMillis());
                l0().d0(list2);
                R();
                this.f2557u = false;
                P();
            }
        }
        a().K().b("Network upload successful with code", Integer.valueOf(i4));
        if (z4) {
            this.f2545i.f3055h.b(B().currentTimeMillis());
        }
        this.f2545i.f3056i.b(0);
        R();
        if (z4) {
            a().K().c("Successful upload. Got network response. code, size", Integer.valueOf(i4), Integer.valueOf(bArr2.length));
        } else {
            a().K().a("Purged empty bundles");
        }
        l0().c1();
        if (i0().q(G.f2409C0)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                I5 i5 = (I5) pair.second;
                l0().l0(str, (C0635o2) pair.first, i5.b(), i5.c(), i5.a());
            }
        }
        String str3 = str;
        for (Long l4 : list2) {
            try {
                l02 = l0();
                long longValue = l4.longValue();
                l02.k();
                l02.r();
                if (l02.y().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                    throw new SQLiteException("Deleted fewer rows from queue than expected");
                }
            } catch (SQLiteException e6) {
                l02.a().G().b("Failed to delete a bundle in a queue table", e6);
                throw e6;
            } catch (SQLiteException e7) {
                SQLiteException sQLiteException = e7;
                List list3 = this.f2562z;
                if (list3 == null || !list3.contains(l4)) {
                    throw sQLiteException;
                }
            }
        }
        l0().k1();
        l0().i1();
        this.f2562z = null;
        if (p0().z() && S()) {
            E0();
        } else if (!i0().q(G.f2409C0) || !p0().z() || !l0().g1(str3)) {
            this.f2530A = -1;
            R();
        } else {
            k0(str3);
        }
        this.f2551o = 0;
        this.f2557u = false;
        P();
    }

    /* access modifiers changed from: package-private */
    public final A3 U(String str) {
        f().k();
        A0();
        A3 a32 = (A3) this.f2531B.get(str);
        if (a32 == null) {
            a32 = l0().U0(str);
            if (a32 == null) {
                a32 = A3.f2299c;
            }
            F(str, a32);
        }
        return a32;
    }

    /* access modifiers changed from: package-private */
    public final String V(M5 m5) {
        try {
            return (String) f().t(new T5(this, m5)).get(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e5) {
            a().G().c("Failed to get app instance id. appId", C0821n2.s(m5.f2631a), e5);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void W(C0755e eVar) {
        M5 c02 = c0((String) C0335p.l(eVar.f2953a));
        if (c02 != null) {
            X(eVar, c02);
        }
    }

    /* access modifiers changed from: package-private */
    public final void X(C0755e eVar, M5 m5) {
        boolean z4;
        C0335p.l(eVar);
        C0335p.f(eVar.f2953a);
        C0335p.l(eVar.f2954b);
        C0335p.l(eVar.f2955c);
        C0335p.f(eVar.f2955c.f2824b);
        f().k();
        A0();
        if (s0(m5)) {
            if (!m5.f2638h) {
                g(m5);
                return;
            }
            C0755e eVar2 = new C0755e(eVar);
            boolean z5 = false;
            eVar2.f2957e = false;
            l0().c1();
            try {
                C0755e I02 = l0().I0((String) C0335p.l(eVar2.f2953a), eVar2.f2955c.f2824b);
                if (I02 != null && !I02.f2954b.equals(eVar2.f2954b)) {
                    a().L().d("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.f2548l.D().g(eVar2.f2955c.f2824b), eVar2.f2954b, I02.f2954b);
                }
                if (I02 != null && (z4 = I02.f2957e)) {
                    eVar2.f2954b = I02.f2954b;
                    eVar2.f2956d = I02.f2956d;
                    eVar2.f2960h = I02.f2960h;
                    eVar2.f2958f = I02.f2958f;
                    eVar2.f2961i = I02.f2961i;
                    eVar2.f2957e = z4;
                    Y5 y5 = eVar2.f2955c;
                    eVar2.f2955c = new Y5(y5.f2824b, I02.f2955c.f2825c, y5.c(), I02.f2955c.f2828f);
                } else if (TextUtils.isEmpty(eVar2.f2958f)) {
                    Y5 y52 = eVar2.f2955c;
                    eVar2.f2955c = new Y5(y52.f2824b, eVar2.f2956d, y52.c(), eVar2.f2955c.f2828f);
                    z5 = true;
                    eVar2.f2957e = true;
                }
                if (eVar2.f2957e) {
                    Y5 y53 = eVar2.f2955c;
                    a6 a6Var = new a6((String) C0335p.l(eVar2.f2953a), eVar2.f2954b, y53.f2824b, y53.f2825c, C0335p.l(y53.c()));
                    if (l0().i0(a6Var)) {
                        a().F().d("User property updated immediately", eVar2.f2953a, this.f2548l.D().g(a6Var.f2856c), a6Var.f2858e);
                    } else {
                        a().G().d("(2)Too many active user properties, ignoring", C0821n2.s(eVar2.f2953a), this.f2548l.D().g(a6Var.f2856c), a6Var.f2858e);
                    }
                    if (z5 && eVar2.f2961i != null) {
                        e0(new E(eVar2.f2961i, eVar2.f2956d), m5);
                    }
                }
                if (l0().g0(eVar2)) {
                    a().F().d("Conditional property added", eVar2.f2953a, this.f2548l.D().g(eVar2.f2955c.f2824b), eVar2.f2955c.c());
                } else {
                    a().G().d("Too many conditional properties, ignoring", C0821n2.s(eVar2.f2953a), this.f2548l.D().g(eVar2.f2955c.f2824b), eVar2.f2955c.c());
                }
                l0().k1();
                l0().i1();
            } catch (Throwable th) {
                Throwable th2 = th;
                l0().i1();
                throw th2;
            }
        }
    }

    public final C0821n2 a() {
        return ((S2) C0335p.l(this.f2548l)).a();
    }

    /* access modifiers changed from: package-private */
    public final void a0(C0744c2 c2Var, C0643p2.a aVar) {
        f().k();
        A0();
        C0554f2.a O4 = C0554f2.O();
        byte[] E4 = c2Var.E();
        if (E4 != null) {
            try {
                O4 = (C0554f2.a) Z5.G(O4, E4);
            } catch (B4 unused) {
                a().L().b("Failed to parse locally stored ad campaign info. appId", C0821n2.s(c2Var.l()));
            }
        }
        for (C0599k2 k2Var : aVar.I()) {
            if (k2Var.U().equals("_cmp")) {
                String str = (String) Z5.J(k2Var, "gclid", "");
                String str2 = (String) Z5.J(k2Var, "gbraid", "");
                String str3 = (String) Z5.J(k2Var, "gad_source", "");
                if (!str.isEmpty() || !str2.isEmpty()) {
                    long longValue = ((Long) Z5.J(k2Var, "click_timestamp", 0L)).longValue();
                    if (longValue <= 0) {
                        longValue = k2Var.R();
                    }
                    if ("referrer API v2".equals(Z5.f0(k2Var, "_cis"))) {
                        if (longValue > O4.t()) {
                            if (str.isEmpty()) {
                                O4.I();
                            } else {
                                O4.G(str);
                            }
                            if (str2.isEmpty()) {
                                O4.H();
                            } else {
                                O4.E(str2);
                            }
                            if (str3.isEmpty()) {
                                O4.F();
                            } else {
                                O4.C(str3);
                            }
                            O4.x(longValue);
                        }
                    } else if (longValue > O4.q()) {
                        if (str.isEmpty()) {
                            O4.D();
                        } else {
                            O4.A(str);
                        }
                        if (str2.isEmpty()) {
                            O4.B();
                        } else {
                            O4.y(str2);
                        }
                        if (str3.isEmpty()) {
                            O4.z();
                        } else {
                            O4.s(str3);
                        }
                        O4.r(longValue);
                    }
                }
            }
        }
        if (!((C0554f2) ((C0668s4) O4.m())).equals(C0554f2.U())) {
            aVar.z((C0554f2) ((C0668s4) O4.m()));
        }
        c2Var.i(((C0554f2) ((C0668s4) O4.m())).i());
        if (c2Var.B()) {
            l0().V(c2Var, false, false);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0112 A[Catch:{ all -> 0x005d, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0161 A[Catch:{ all -> 0x005d, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x016f A[Catch:{ all -> 0x005d, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0195 A[Catch:{ all -> 0x005d, all -> 0x0013 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0199 A[Catch:{ all -> 0x005d, all -> 0x0013 }] */
    /* renamed from: b0 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z(java.lang.String r9, int r10, java.lang.Throwable r11, byte[] r12, java.util.Map r13) {
        /*
            r8 = this;
            com.google.android.gms.measurement.internal.P2 r0 = r8.f()
            r0.k()
            r8.A0()
            M.C0335p.f(r9)
            r0 = 0
            if (r12 != 0) goto L_0x0016
            byte[] r12 = new byte[r0]     // Catch:{ all -> 0x0013 }
            goto L_0x0016
        L_0x0013:
            r9 = move-exception
            goto L_0x01e4
        L_0x0016:
            com.google.android.gms.measurement.internal.n2 r1 = r8.a()     // Catch:{ all -> 0x0013 }
            com.google.android.gms.measurement.internal.p2 r1 = r1.K()     // Catch:{ all -> 0x0013 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r12.length     // Catch:{ all -> 0x0013 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0013 }
            r1.b(r2, r3)     // Catch:{ all -> 0x0013 }
            com.google.android.gms.measurement.internal.k r1 = r8.l0()     // Catch:{ all -> 0x0013 }
            r1.c1()     // Catch:{ all -> 0x0013 }
            com.google.android.gms.measurement.internal.k r1 = r8.l0()     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.c2 r1 = r1.M0(r9)     // Catch:{ all -> 0x005d }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            if (r10 == r2) goto L_0x0043
            r2 = 204(0xcc, float:2.86E-43)
            if (r10 == r2) goto L_0x0043
            if (r10 != r3) goto L_0x0047
        L_0x0043:
            if (r11 != 0) goto L_0x0047
            r2 = 1
            goto L_0x0048
        L_0x0047:
            r2 = 0
        L_0x0048:
            if (r1 != 0) goto L_0x0060
            com.google.android.gms.measurement.internal.n2 r10 = r8.a()     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.p2 r10 = r10.L()     // Catch:{ all -> 0x005d }
            java.lang.String r11 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.C0821n2.s(r9)     // Catch:{ all -> 0x005d }
            r10.b(r11, r9)     // Catch:{ all -> 0x005d }
            goto L_0x01c8
        L_0x005d:
            r9 = move-exception
            goto L_0x01dc
        L_0x0060:
            r4 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00bc
            if (r10 != r4) goto L_0x0067
            goto L_0x00bc
        L_0x0067:
            R.d r12 = r8.B()     // Catch:{ all -> 0x005d }
            long r12 = r12.currentTimeMillis()     // Catch:{ all -> 0x005d }
            r1.s0(r12)     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.k r12 = r8.l0()     // Catch:{ all -> 0x005d }
            r12.V(r1, r0, r0)     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.n2 r12 = r8.a()     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.p2 r12 = r12.K()     // Catch:{ all -> 0x005d }
            java.lang.String r13 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x005d }
            r12.c(r13, r1, r11)     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.I2 r11 = r8.r0()     // Catch:{ all -> 0x005d }
            r11.U(r9)     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.j5 r9 = r8.f2545i     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.A2 r9 = r9.f3056i     // Catch:{ all -> 0x005d }
            R.d r11 = r8.B()     // Catch:{ all -> 0x005d }
            long r11 = r11.currentTimeMillis()     // Catch:{ all -> 0x005d }
            r9.b(r11)     // Catch:{ all -> 0x005d }
            r9 = 503(0x1f7, float:7.05E-43)
            if (r10 == r9) goto L_0x00a8
            r9 = 429(0x1ad, float:6.01E-43)
            if (r10 != r9) goto L_0x00b7
        L_0x00a8:
            com.google.android.gms.measurement.internal.j5 r9 = r8.f2545i     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.A2 r9 = r9.f3054g     // Catch:{ all -> 0x005d }
            R.d r10 = r8.B()     // Catch:{ all -> 0x005d }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x005d }
            r9.b(r10)     // Catch:{ all -> 0x005d }
        L_0x00b7:
            r8.R()     // Catch:{ all -> 0x005d }
            goto L_0x01c8
        L_0x00bc:
            boolean r11 = com.google.android.gms.internal.measurement.Y6.a()     // Catch:{ all -> 0x005d }
            java.lang.String r2 = "ETag"
            java.lang.String r5 = "Last-Modified"
            r6 = 0
            if (r11 == 0) goto L_0x00dc
            com.google.android.gms.measurement.internal.g r11 = r8.i0()     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.b2 r7 = com.google.android.gms.measurement.internal.G.f2417G0     // Catch:{ all -> 0x005d }
            boolean r11 = r11.q(r7)     // Catch:{ all -> 0x005d }
            if (r11 == 0) goto L_0x00dc
            java.lang.String r11 = m(r13, r5)     // Catch:{ all -> 0x005d }
            java.lang.String r13 = m(r13, r2)     // Catch:{ all -> 0x005d }
            goto L_0x0110
        L_0x00dc:
            if (r13 == 0) goto L_0x00e5
            java.lang.Object r11 = r13.get(r5)     // Catch:{ all -> 0x005d }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x005d }
            goto L_0x00e6
        L_0x00e5:
            r11 = r6
        L_0x00e6:
            if (r11 == 0) goto L_0x00f5
            boolean r5 = r11.isEmpty()     // Catch:{ all -> 0x005d }
            if (r5 != 0) goto L_0x00f5
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x005d }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x005d }
            goto L_0x00f6
        L_0x00f5:
            r11 = r6
        L_0x00f6:
            if (r13 == 0) goto L_0x00ff
            java.lang.Object r13 = r13.get(r2)     // Catch:{ all -> 0x005d }
            java.util.List r13 = (java.util.List) r13     // Catch:{ all -> 0x005d }
            goto L_0x0100
        L_0x00ff:
            r13 = r6
        L_0x0100:
            if (r13 == 0) goto L_0x010f
            boolean r2 = r13.isEmpty()     // Catch:{ all -> 0x005d }
            if (r2 != 0) goto L_0x010f
            java.lang.Object r13 = r13.get(r0)     // Catch:{ all -> 0x005d }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x005d }
            goto L_0x0110
        L_0x010f:
            r13 = r6
        L_0x0110:
            if (r10 == r4) goto L_0x012c
            if (r10 != r3) goto L_0x0115
            goto L_0x012c
        L_0x0115:
            com.google.android.gms.measurement.internal.I2 r2 = r8.r0()     // Catch:{ all -> 0x005d }
            boolean r11 = r2.H(r9, r12, r11, r13)     // Catch:{ all -> 0x005d }
            if (r11 != 0) goto L_0x014d
            com.google.android.gms.measurement.internal.k r9 = r8.l0()     // Catch:{ all -> 0x0013 }
            r9.i1()     // Catch:{ all -> 0x0013 }
            r8.f2556t = r0
            r8.P()
            return
        L_0x012c:
            com.google.android.gms.measurement.internal.I2 r11 = r8.r0()     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.measurement.T1 r11 = r11.L(r9)     // Catch:{ all -> 0x005d }
            if (r11 != 0) goto L_0x014d
            com.google.android.gms.measurement.internal.I2 r11 = r8.r0()     // Catch:{ all -> 0x005d }
            boolean r11 = r11.H(r9, r6, r6, r6)     // Catch:{ all -> 0x005d }
            if (r11 != 0) goto L_0x014d
            com.google.android.gms.measurement.internal.k r9 = r8.l0()     // Catch:{ all -> 0x0013 }
            r9.i1()     // Catch:{ all -> 0x0013 }
            r8.f2556t = r0
            r8.P()
            return
        L_0x014d:
            R.d r11 = r8.B()     // Catch:{ all -> 0x005d }
            long r2 = r11.currentTimeMillis()     // Catch:{ all -> 0x005d }
            r1.R(r2)     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.k r11 = r8.l0()     // Catch:{ all -> 0x005d }
            r11.V(r1, r0, r0)     // Catch:{ all -> 0x005d }
            if (r10 != r4) goto L_0x016f
            com.google.android.gms.measurement.internal.n2 r10 = r8.a()     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.p2 r10 = r10.M()     // Catch:{ all -> 0x005d }
            java.lang.String r11 = "Config not found. Using empty config. appId"
            r10.b(r11, r9)     // Catch:{ all -> 0x005d }
            goto L_0x0185
        L_0x016f:
            com.google.android.gms.measurement.internal.n2 r9 = r8.a()     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.p2 r9 = r9.K()     // Catch:{ all -> 0x005d }
            java.lang.String r11 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x005d }
            int r12 = r12.length     // Catch:{ all -> 0x005d }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x005d }
            r9.c(r11, r10, r12)     // Catch:{ all -> 0x005d }
        L_0x0185:
            com.google.android.gms.measurement.internal.q2 r9 = r8.p0()     // Catch:{ all -> 0x005d }
            boolean r9 = r9.z()     // Catch:{ all -> 0x005d }
            if (r9 == 0) goto L_0x0199
            boolean r9 = r8.S()     // Catch:{ all -> 0x005d }
            if (r9 == 0) goto L_0x0199
            r8.E0()     // Catch:{ all -> 0x005d }
            goto L_0x01c8
        L_0x0199:
            com.google.android.gms.measurement.internal.g r9 = r8.i0()     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.b2 r10 = com.google.android.gms.measurement.internal.G.f2409C0     // Catch:{ all -> 0x005d }
            boolean r9 = r9.q(r10)     // Catch:{ all -> 0x005d }
            if (r9 == 0) goto L_0x01c5
            com.google.android.gms.measurement.internal.q2 r9 = r8.p0()     // Catch:{ all -> 0x005d }
            boolean r9 = r9.z()     // Catch:{ all -> 0x005d }
            if (r9 == 0) goto L_0x01c5
            com.google.android.gms.measurement.internal.k r9 = r8.l0()     // Catch:{ all -> 0x005d }
            java.lang.String r10 = r1.l()     // Catch:{ all -> 0x005d }
            boolean r9 = r9.g1(r10)     // Catch:{ all -> 0x005d }
            if (r9 == 0) goto L_0x01c5
            java.lang.String r9 = r1.l()     // Catch:{ all -> 0x005d }
            r8.k0(r9)     // Catch:{ all -> 0x005d }
            goto L_0x01c8
        L_0x01c5:
            r8.R()     // Catch:{ all -> 0x005d }
        L_0x01c8:
            com.google.android.gms.measurement.internal.k r9 = r8.l0()     // Catch:{ all -> 0x005d }
            r9.k1()     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.k r9 = r8.l0()     // Catch:{ all -> 0x0013 }
            r9.i1()     // Catch:{ all -> 0x0013 }
            r8.f2556t = r0
            r8.P()
            return
        L_0x01dc:
            com.google.android.gms.measurement.internal.k r10 = r8.l0()     // Catch:{ all -> 0x0013 }
            r10.i1()     // Catch:{ all -> 0x0013 }
            throw r9     // Catch:{ all -> 0x0013 }
        L_0x01e4:
            r8.f2556t = r0
            r8.P()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.H5.z(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    public final Bundle d(String str) {
        int i4;
        String str2;
        f().k();
        A0();
        if (r0().J(str) == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        A3 U4 = U(str);
        bundle.putAll(U4.o());
        bundle.putAll(e(str, g0(str), U4, new C0776h()).f());
        a6 N02 = l0().N0(str, "_npa");
        if (N02 != null) {
            i4 = N02.f2858e.equals(1L);
        } else {
            i4 = b(str, new C0776h());
        }
        if (i4 == 1) {
            str2 = "denied";
        } else {
            str2 = "granted";
        }
        bundle.putString("ad_personalization", str2);
        return bundle;
    }

    public final h6 d0() {
        return (h6) i(this.f2542f);
    }

    public final P2 f() {
        return ((S2) C0335p.l(this.f2548l)).f();
    }

    /* access modifiers changed from: package-private */
    public final void f0(M5 m5) {
        f().k();
        A0();
        C0335p.l(m5);
        C0335p.f(m5.f2631a);
        if (i0().q(G.f2467d1)) {
            int i4 = 0;
            if (i0().q(G.f2487k0)) {
                long currentTimeMillis = B().currentTimeMillis();
                int t4 = i0().t((String) null, G.f2446V);
                i0();
                long I4 = currentTimeMillis - C0769g.I();
                while (i4 < t4 && O((String) null, I4)) {
                    i4++;
                }
            } else {
                i0();
                long K4 = C0769g.K();
                while (((long) i4) < K4 && O(m5.f2631a, 0)) {
                    i4++;
                }
            }
            if (i0().q(G.f2490l0)) {
                Q();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x024c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.C0744c2 g(com.google.android.gms.measurement.internal.M5 r13) {
        /*
            r12 = this;
            com.google.android.gms.measurement.internal.P2 r0 = r12.f()
            r0.k()
            r12.A0()
            M.C0335p.l(r13)
            java.lang.String r0 = r13.f2631a
            M.C0335p.f(r0)
            java.lang.String r0 = r13.f2653w
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0029
            java.util.Map r0 = r12.f2533D
            java.lang.String r2 = r13.f2631a
            com.google.android.gms.measurement.internal.H5$b r3 = new com.google.android.gms.measurement.internal.H5$b
            java.lang.String r4 = r13.f2653w
            r3.<init>(r4)
            r0.put(r2, r3)
        L_0x0029:
            com.google.android.gms.measurement.internal.k r0 = r12.l0()
            java.lang.String r2 = r13.f2631a
            com.google.android.gms.measurement.internal.c2 r0 = r0.M0(r2)
            java.lang.String r2 = r13.f2631a
            com.google.android.gms.measurement.internal.A3 r2 = r12.U(r2)
            java.lang.String r3 = r13.f2652v
            com.google.android.gms.measurement.internal.A3 r3 = com.google.android.gms.measurement.internal.A3.q(r3)
            com.google.android.gms.measurement.internal.A3 r2 = r2.d(r3)
            boolean r3 = r2.y()
            if (r3 == 0) goto L_0x0054
            com.google.android.gms.measurement.internal.j5 r3 = r12.f2545i
            java.lang.String r4 = r13.f2631a
            boolean r5 = r13.f2645o
            java.lang.String r3 = r3.x(r4, r5)
            goto L_0x0056
        L_0x0054:
            java.lang.String r3 = ""
        L_0x0056:
            r4 = 0
            if (r0 != 0) goto L_0x007b
            com.google.android.gms.measurement.internal.c2 r0 = new com.google.android.gms.measurement.internal.c2
            com.google.android.gms.measurement.internal.S2 r5 = r12.f2548l
            java.lang.String r6 = r13.f2631a
            r0.<init>(r5, r6)
            boolean r5 = r2.z()
            if (r5 == 0) goto L_0x006f
            java.lang.String r5 = r12.l(r2)
            r0.J(r5)
        L_0x006f:
            boolean r2 = r2.y()
            if (r2 == 0) goto L_0x0078
            r0.f0(r3)
        L_0x0078:
            r2 = 0
            goto L_0x0141
        L_0x007b:
            boolean r5 = r2.y()
            if (r5 == 0) goto L_0x0128
            if (r3 == 0) goto L_0x0128
            java.lang.String r5 = r0.s()
            boolean r5 = r3.equals(r5)
            if (r5 != 0) goto L_0x0128
            java.lang.String r5 = r0.s()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            r0.f0(r3)
            boolean r3 = r13.f2645o
            if (r3 == 0) goto L_0x010f
            com.google.android.gms.measurement.internal.j5 r3 = r12.f2545i
            java.lang.String r6 = r13.f2631a
            android.util.Pair r3 = r3.w(r6, r2)
            java.lang.Object r3 = r3.first
            java.lang.String r6 = "00000000-0000-0000-0000-000000000000"
            boolean r3 = r6.equals(r3)
            if (r3 != 0) goto L_0x010f
            if (r5 != 0) goto L_0x010f
            boolean r3 = com.google.android.gms.internal.measurement.C0576h6.a()
            if (r3 == 0) goto L_0x00ca
            com.google.android.gms.measurement.internal.g r3 = r12.i0()
            com.google.android.gms.measurement.internal.b2 r5 = com.google.android.gms.measurement.internal.G.f2455Z0
            boolean r3 = r3.q(r5)
            if (r3 == 0) goto L_0x00ca
            boolean r3 = r2.z()
            if (r3 != 0) goto L_0x00ca
            r2 = 1
            goto L_0x00d2
        L_0x00ca:
            java.lang.String r2 = r12.l(r2)
            r0.J(r2)
            r2 = 0
        L_0x00d2:
            com.google.android.gms.measurement.internal.k r3 = r12.l0()
            java.lang.String r5 = r13.f2631a
            java.lang.String r6 = "_id"
            com.google.android.gms.measurement.internal.a6 r3 = r3.N0(r5, r6)
            if (r3 == 0) goto L_0x0141
            com.google.android.gms.measurement.internal.k r3 = r12.l0()
            java.lang.String r5 = r13.f2631a
            java.lang.String r6 = "_lair"
            com.google.android.gms.measurement.internal.a6 r3 = r3.N0(r5, r6)
            if (r3 != 0) goto L_0x0141
            R.d r3 = r12.B()
            long r9 = r3.currentTimeMillis()
            com.google.android.gms.measurement.internal.a6 r5 = new com.google.android.gms.measurement.internal.a6
            java.lang.String r6 = r13.f2631a
            r7 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r7)
            java.lang.String r7 = "auto"
            java.lang.String r8 = "_lair"
            r5.<init>(r6, r7, r8, r9, r11)
            com.google.android.gms.measurement.internal.k r3 = r12.l0()
            r3.i0(r5)
            goto L_0x0141
        L_0x010f:
            java.lang.String r3 = r0.m()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0078
            boolean r3 = r2.z()
            if (r3 == 0) goto L_0x0078
            java.lang.String r2 = r12.l(r2)
            r0.J(r2)
            goto L_0x0078
        L_0x0128:
            java.lang.String r3 = r0.m()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0078
            boolean r3 = r2.z()
            if (r3 == 0) goto L_0x0078
            java.lang.String r2 = r12.l(r2)
            r0.J(r2)
            goto L_0x0078
        L_0x0141:
            java.lang.String r3 = r13.f2632b
            r0.Z(r3)
            java.lang.String r3 = r13.f2647q
            r0.f(r3)
            java.lang.String r3 = r13.f2641k
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0158
            java.lang.String r3 = r13.f2641k
            r0.W(r3)
        L_0x0158:
            long r5 = r13.f2635e
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x0163
            r0.u0(r5)
        L_0x0163:
            java.lang.String r3 = r13.f2633c
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0170
            java.lang.String r3 = r13.f2633c
            r0.S(r3)
        L_0x0170:
            long r5 = r13.f2640j
            r0.H(r5)
            java.lang.String r3 = r13.f2634d
            if (r3 == 0) goto L_0x017c
            r0.O(r3)
        L_0x017c:
            long r5 = r13.f2636f
            r0.n0(r5)
            boolean r3 = r13.f2638h
            r0.K(r3)
            java.lang.String r3 = r13.f2637g
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0193
            java.lang.String r3 = r13.f2637g
            r0.c0(r3)
        L_0x0193:
            boolean r3 = r13.f2645o
            r0.h(r3)
            java.lang.Boolean r3 = r13.f2648r
            r0.d(r3)
            long r5 = r13.f2649s
            r0.q0(r5)
            java.lang.String r3 = r13.f2654x
            r0.l0(r3)
            boolean r3 = com.google.android.gms.internal.measurement.C0678t6.a()
            if (r3 == 0) goto L_0x01bf
            com.google.android.gms.measurement.internal.g r3 = r12.i0()
            com.google.android.gms.measurement.internal.b2 r5 = com.google.android.gms.measurement.internal.G.f2514w0
            boolean r3 = r3.q(r5)
            if (r3 == 0) goto L_0x01bf
            java.util.List r1 = r13.f2650t
            r0.g(r1)
            goto L_0x01d4
        L_0x01bf:
            boolean r3 = com.google.android.gms.internal.measurement.C0678t6.a()
            if (r3 == 0) goto L_0x01d4
            com.google.android.gms.measurement.internal.g r3 = r12.i0()
            com.google.android.gms.measurement.internal.b2 r5 = com.google.android.gms.measurement.internal.G.f2512v0
            boolean r3 = r3.q(r5)
            if (r3 == 0) goto L_0x01d4
            r0.g(r1)
        L_0x01d4:
            boolean r1 = com.google.android.gms.internal.measurement.r7.a()
            if (r1 == 0) goto L_0x0209
            com.google.android.gms.measurement.internal.g r1 = r12.i0()
            com.google.android.gms.measurement.internal.b2 r3 = com.google.android.gms.measurement.internal.G.f2518y0
            boolean r1 = r1.q(r3)
            if (r1 == 0) goto L_0x0209
            r12.y0()
            java.lang.String r1 = r0.l()
            boolean r1 = com.google.android.gms.measurement.internal.d6.H0(r1)
            if (r1 == 0) goto L_0x0209
            boolean r1 = r13.f2655y
            r0.P(r1)
            com.google.android.gms.measurement.internal.g r1 = r12.i0()
            com.google.android.gms.measurement.internal.b2 r3 = com.google.android.gms.measurement.internal.G.f2520z0
            boolean r1 = r1.q(r3)
            if (r1 == 0) goto L_0x0209
            java.lang.String r1 = r13.f2629E
            r0.o0(r1)
        L_0x0209:
            boolean r1 = com.google.android.gms.internal.measurement.C0604k7.a()
            if (r1 == 0) goto L_0x0220
            com.google.android.gms.measurement.internal.g r1 = r12.i0()
            com.google.android.gms.measurement.internal.b2 r3 = com.google.android.gms.measurement.internal.G.f2421I0
            boolean r1 = r1.q(r3)
            if (r1 == 0) goto L_0x0220
            int r1 = r13.f2627C
            r0.b(r1)
        L_0x0220:
            long r5 = r13.f2656z
            r0.G0(r5)
            java.lang.String r13 = r13.f2630F
            r0.i0(r13)
            boolean r13 = com.google.android.gms.internal.measurement.C0576h6.a()
            if (r13 == 0) goto L_0x024c
            com.google.android.gms.measurement.internal.g r13 = r12.i0()
            com.google.android.gms.measurement.internal.b2 r1 = com.google.android.gms.measurement.internal.G.f2455Z0
            boolean r13 = r13.q(r1)
            if (r13 == 0) goto L_0x024c
            boolean r13 = r0.B()
            if (r13 != 0) goto L_0x0244
            if (r2 == 0) goto L_0x0259
        L_0x0244:
            com.google.android.gms.measurement.internal.k r13 = r12.l0()
            r13.V(r0, r2, r4)
            return r0
        L_0x024c:
            boolean r13 = r0.B()
            if (r13 == 0) goto L_0x0259
            com.google.android.gms.measurement.internal.k r13 = r12.l0()
            r13.V(r0, r4, r4)
        L_0x0259:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.H5.g(com.google.android.gms.measurement.internal.M5):com.google.android.gms.measurement.internal.c2");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x03aa A[Catch:{ SQLiteException -> 0x01b3, all -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x03d5 A[Catch:{ SQLiteException -> 0x01b3, all -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x03ea A[SYNTHETIC, Splitter:B:129:0x03ea] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0499 A[Catch:{ SQLiteException -> 0x01b3, all -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x04fe A[Catch:{ SQLiteException -> 0x01b3, all -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0109 A[Catch:{ SQLiteException -> 0x01b3, all -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01c8 A[Catch:{ SQLiteException -> 0x01b3, all -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0200 A[Catch:{ SQLiteException -> 0x01b3, all -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0226 A[Catch:{ SQLiteException -> 0x01b3, all -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0233 A[Catch:{ SQLiteException -> 0x01b3, all -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0245 A[Catch:{ SQLiteException -> 0x01b3, all -> 0x00c1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h0(com.google.android.gms.measurement.internal.M5 r27) {
        /*
            r26 = this;
            r1 = r26
            r2 = r27
            java.lang.String r3 = "_sysu"
            java.lang.String r4 = "_sys"
            java.lang.String r5 = "_pfo"
            java.lang.String r6 = "com.android.vending"
            java.lang.String r0 = "_npa"
            java.lang.String r7 = "_uwa"
            java.lang.String r8 = "app_id=?"
            com.google.android.gms.measurement.internal.P2 r9 = r1.f()
            r9.k()
            r1.A0()
            M.C0335p.l(r2)
            java.lang.String r9 = r2.f2631a
            M.C0335p.f(r9)
            boolean r9 = s0(r2)
            if (r9 != 0) goto L_0x002b
            return
        L_0x002b:
            com.google.android.gms.measurement.internal.k r9 = r1.l0()
            java.lang.String r10 = r2.f2631a
            com.google.android.gms.measurement.internal.c2 r9 = r9.M0(r10)
            r10 = 0
            r11 = 0
            if (r9 == 0) goto L_0x005f
            java.lang.String r13 = r9.q()
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 == 0) goto L_0x005f
            java.lang.String r13 = r2.f2632b
            boolean r13 = android.text.TextUtils.isEmpty(r13)
            if (r13 != 0) goto L_0x005f
            r9.R(r11)
            com.google.android.gms.measurement.internal.k r13 = r1.l0()
            r13.V(r9, r10, r10)
            com.google.android.gms.measurement.internal.I2 r9 = r1.r0()
            java.lang.String r13 = r2.f2631a
            r9.V(r13)
        L_0x005f:
            boolean r9 = r2.f2638h
            if (r9 != 0) goto L_0x0067
            r26.g(r27)
            return
        L_0x0067:
            long r13 = r2.f2643m
            int r9 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r9 != 0) goto L_0x0075
            R.d r9 = r1.B()
            long r13 = r9.currentTimeMillis()
        L_0x0075:
            r17 = r13
            com.google.android.gms.measurement.internal.S2 r9 = r1.f2548l
            com.google.android.gms.measurement.internal.x r9 = r9.x()
            r9.k()
            int r9 = r2.f2644n
            r13 = 1
            if (r9 == 0) goto L_0x009f
            if (r9 == r13) goto L_0x009f
            com.google.android.gms.measurement.internal.n2 r14 = r1.a()
            com.google.android.gms.measurement.internal.p2 r14 = r14.L()
            java.lang.String r15 = r2.f2631a
            java.lang.Object r15 = com.google.android.gms.measurement.internal.C0821n2.s(r15)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r11 = "Incorrect app type, assuming installed app. appId, appType"
            r14.c(r11, r15, r9)
            r9 = 0
        L_0x009f:
            com.google.android.gms.measurement.internal.k r11 = r1.l0()
            r11.c1()
            com.google.android.gms.measurement.internal.k r11 = r1.l0()     // Catch:{ all -> 0x00c1 }
            java.lang.String r12 = r2.f2631a     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.a6 r11 = r11.N0(r12, r0)     // Catch:{ all -> 0x00c1 }
            java.lang.Boolean r12 = q0(r2)     // Catch:{ all -> 0x00c1 }
            if (r11 == 0) goto L_0x00c4
            java.lang.String r14 = "auto"
            java.lang.String r15 = r11.f2855b     // Catch:{ all -> 0x00c1 }
            boolean r14 = r14.equals(r15)     // Catch:{ all -> 0x00c1 }
            if (r14 == 0) goto L_0x00f7
            goto L_0x00c4
        L_0x00c1:
            r0 = move-exception
            goto L_0x052b
        L_0x00c4:
            if (r12 == 0) goto L_0x00f2
            com.google.android.gms.measurement.internal.Y5 r15 = new com.google.android.gms.measurement.internal.Y5     // Catch:{ all -> 0x00c1 }
            java.lang.String r16 = "_npa"
            boolean r0 = r12.booleanValue()     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x00d3
            r23 = 1
            goto L_0x00d5
        L_0x00d3:
            r23 = 0
        L_0x00d5:
            java.lang.Long r0 = java.lang.Long.valueOf(r23)     // Catch:{ all -> 0x00c1 }
            r23 = 1
            java.lang.String r20 = "auto"
            r19 = r0
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x00c1 }
            if (r11 == 0) goto L_0x00ee
            java.lang.Object r0 = r11.f2858e     // Catch:{ all -> 0x00c1 }
            java.lang.Long r11 = r15.f2826d     // Catch:{ all -> 0x00c1 }
            boolean r0 = r0.equals(r11)     // Catch:{ all -> 0x00c1 }
            if (r0 != 0) goto L_0x00f7
        L_0x00ee:
            r1.w(r15, r2)     // Catch:{ all -> 0x00c1 }
            goto L_0x00f7
        L_0x00f2:
            if (r11 == 0) goto L_0x00f7
            r1.H(r0, r2)     // Catch:{ all -> 0x00c1 }
        L_0x00f7:
            com.google.android.gms.measurement.internal.k r0 = r1.l0()     // Catch:{ all -> 0x00c1 }
            java.lang.String r11 = r2.f2631a     // Catch:{ all -> 0x00c1 }
            java.lang.Object r11 = M.C0335p.l(r11)     // Catch:{ all -> 0x00c1 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.c2 r0 = r0.M0(r11)     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x01c6
            r1.y0()     // Catch:{ all -> 0x00c1 }
            java.lang.String r12 = r2.f2632b     // Catch:{ all -> 0x00c1 }
            java.lang.String r14 = r0.q()     // Catch:{ all -> 0x00c1 }
            java.lang.String r15 = r2.f2647q     // Catch:{ all -> 0x00c1 }
            java.lang.String r11 = r0.j()     // Catch:{ all -> 0x00c1 }
            boolean r11 = com.google.android.gms.measurement.internal.d6.m0(r12, r14, r15, r11)     // Catch:{ all -> 0x00c1 }
            if (r11 == 0) goto L_0x01c6
            com.google.android.gms.measurement.internal.n2 r11 = r1.a()     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.p2 r11 = r11.L()     // Catch:{ all -> 0x00c1 }
            java.lang.String r12 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r14 = r0.l()     // Catch:{ all -> 0x00c1 }
            java.lang.Object r14 = com.google.android.gms.measurement.internal.C0821n2.s(r14)     // Catch:{ all -> 0x00c1 }
            r11.b(r12, r14)     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.k r11 = r1.l0()     // Catch:{ all -> 0x00c1 }
            java.lang.String r12 = r0.l()     // Catch:{ all -> 0x00c1 }
            r11.r()     // Catch:{ all -> 0x00c1 }
            r11.k()     // Catch:{ all -> 0x00c1 }
            M.C0335p.f(r12)     // Catch:{ all -> 0x00c1 }
            android.database.sqlite.SQLiteDatabase r0 = r11.y()     // Catch:{ SQLiteException -> 0x01b3 }
            java.lang.String[] r14 = new java.lang.String[]{r12}     // Catch:{ SQLiteException -> 0x01b3 }
            java.lang.String r15 = "events"
            int r15 = r0.delete(r15, r8, r14)     // Catch:{ SQLiteException -> 0x01b3 }
            java.lang.String r10 = "user_attributes"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01b3 }
            int r15 = r15 + r10
            java.lang.String r10 = "conditional_properties"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01b3 }
            int r15 = r15 + r10
            java.lang.String r10 = "apps"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01b3 }
            int r15 = r15 + r10
            java.lang.String r10 = "raw_events"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01b3 }
            int r15 = r15 + r10
            java.lang.String r10 = "raw_events_metadata"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01b3 }
            int r15 = r15 + r10
            java.lang.String r10 = "event_filters"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01b3 }
            int r15 = r15 + r10
            java.lang.String r10 = "property_filters"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01b3 }
            int r15 = r15 + r10
            java.lang.String r10 = "audience_filter_values"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01b3 }
            int r15 = r15 + r10
            java.lang.String r10 = "consent_settings"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01b3 }
            int r15 = r15 + r10
            java.lang.String r10 = "default_event_params"
            int r10 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01b3 }
            int r15 = r15 + r10
            java.lang.String r10 = "trigger_uris"
            int r0 = r0.delete(r10, r8, r14)     // Catch:{ SQLiteException -> 0x01b3 }
            int r15 = r15 + r0
            if (r15 <= 0) goto L_0x01c5
            com.google.android.gms.measurement.internal.n2 r0 = r11.a()     // Catch:{ SQLiteException -> 0x01b3 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.K()     // Catch:{ SQLiteException -> 0x01b3 }
            java.lang.String r8 = "Deleted application data. app, records"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r15)     // Catch:{ SQLiteException -> 0x01b3 }
            r0.c(r8, r12, r10)     // Catch:{ SQLiteException -> 0x01b3 }
            goto L_0x01c5
        L_0x01b3:
            r0 = move-exception
            com.google.android.gms.measurement.internal.n2 r8 = r11.a()     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.p2 r8 = r8.G()     // Catch:{ all -> 0x00c1 }
            java.lang.String r10 = "Error deleting application data. appId, error"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.C0821n2.s(r12)     // Catch:{ all -> 0x00c1 }
            r8.c(r10, r11, r0)     // Catch:{ all -> 0x00c1 }
        L_0x01c5:
            r0 = 0
        L_0x01c6:
            if (r0 == 0) goto L_0x0221
            long r10 = r0.U()     // Catch:{ all -> 0x00c1 }
            r14 = -2147483648(0xffffffff80000000, double:NaN)
            int r8 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x01e1
            long r10 = r0.U()     // Catch:{ all -> 0x00c1 }
            r19 = r14
            long r14 = r2.f2640j     // Catch:{ all -> 0x00c1 }
            int r8 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x01e3
            r8 = 1
            goto L_0x01e4
        L_0x01e1:
            r19 = r14
        L_0x01e3:
            r8 = 0
        L_0x01e4:
            java.lang.String r10 = r0.o()     // Catch:{ all -> 0x00c1 }
            long r11 = r0.U()     // Catch:{ all -> 0x00c1 }
            int r0 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r0 != 0) goto L_0x01fc
            if (r10 == 0) goto L_0x01fc
            java.lang.String r0 = r2.f2633c     // Catch:{ all -> 0x00c1 }
            boolean r0 = r10.equals(r0)     // Catch:{ all -> 0x00c1 }
            if (r0 != 0) goto L_0x01fc
            r0 = 1
            goto L_0x01fd
        L_0x01fc:
            r0 = 0
        L_0x01fd:
            r0 = r0 | r8
            if (r0 == 0) goto L_0x0221
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x00c1 }
            r0.<init>()     // Catch:{ all -> 0x00c1 }
            java.lang.String r8 = "_pv"
            r0.putString(r8, r10)     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.E r15 = new com.google.android.gms.measurement.internal.E     // Catch:{ all -> 0x00c1 }
            java.lang.String r16 = "_au"
            com.google.android.gms.measurement.internal.D r8 = new com.google.android.gms.measurement.internal.D     // Catch:{ all -> 0x00c1 }
            r8.<init>(r0)     // Catch:{ all -> 0x00c1 }
            r19 = r17
            java.lang.String r18 = "auto"
            r17 = r8
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x00c1 }
            r17 = r19
            r1.s(r15, r2)     // Catch:{ all -> 0x00c1 }
        L_0x0221:
            r26.g(r27)     // Catch:{ all -> 0x00c1 }
            if (r9 != 0) goto L_0x0233
            com.google.android.gms.measurement.internal.k r0 = r1.l0()     // Catch:{ all -> 0x00c1 }
            java.lang.String r8 = r2.f2631a     // Catch:{ all -> 0x00c1 }
            java.lang.String r10 = "_f"
            com.google.android.gms.measurement.internal.A r0 = r0.L0(r8, r10)     // Catch:{ all -> 0x00c1 }
            goto L_0x0243
        L_0x0233:
            if (r9 != r13) goto L_0x0242
            com.google.android.gms.measurement.internal.k r0 = r1.l0()     // Catch:{ all -> 0x00c1 }
            java.lang.String r8 = r2.f2631a     // Catch:{ all -> 0x00c1 }
            java.lang.String r10 = "_v"
            com.google.android.gms.measurement.internal.A r0 = r0.L0(r8, r10)     // Catch:{ all -> 0x00c1 }
            goto L_0x0243
        L_0x0242:
            r0 = 0
        L_0x0243:
            if (r0 != 0) goto L_0x04fe
            r10 = 3600000(0x36ee80, double:1.7786363E-317)
            long r14 = r17 / r10
            r19 = r10
            r10 = 1
            long r14 = r14 + r10
            long r14 = r14 * r19
            java.lang.String r8 = "_dac"
            java.lang.String r12 = "_et"
            java.lang.String r10 = "_r"
            java.lang.String r11 = "_c"
            if (r9 != 0) goto L_0x04b2
            r19 = r14
            com.google.android.gms.measurement.internal.Y5 r15 = new com.google.android.gms.measurement.internal.Y5     // Catch:{ all -> 0x00c1 }
            java.lang.String r16 = "_fot"
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x00c1 }
            java.lang.String r20 = "auto"
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x00c1 }
            r1.w(r15, r2)     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.P2 r0 = r1.f()     // Catch:{ all -> 0x00c1 }
            r0.k()     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.E2 r0 = r1.f2547k     // Catch:{ all -> 0x00c1 }
            java.lang.Object r0 = M.C0335p.l(r0)     // Catch:{ all -> 0x00c1 }
            r9 = r0
            com.google.android.gms.measurement.internal.E2 r9 = (com.google.android.gms.measurement.internal.E2) r9     // Catch:{ all -> 0x00c1 }
            java.lang.String r0 = r2.f2631a     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x036f
            boolean r14 = r0.isEmpty()     // Catch:{ all -> 0x00c1 }
            if (r14 == 0) goto L_0x0289
            goto L_0x036f
        L_0x0289:
            com.google.android.gms.measurement.internal.S2 r14 = r9.f2370a     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.P2 r14 = r14.f()     // Catch:{ all -> 0x00c1 }
            r14.k()     // Catch:{ all -> 0x00c1 }
            boolean r14 = r9.b()     // Catch:{ all -> 0x00c1 }
            if (r14 != 0) goto L_0x02a9
            com.google.android.gms.measurement.internal.S2 r0 = r9.f2370a     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.n2 r0 = r0.a()     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.J()     // Catch:{ all -> 0x00c1 }
            java.lang.String r6 = "Install Referrer Reporter is not available"
            r0.a(r6)     // Catch:{ all -> 0x00c1 }
            goto L_0x037e
        L_0x02a9:
            com.google.android.gms.measurement.internal.G2 r14 = new com.google.android.gms.measurement.internal.G2     // Catch:{ all -> 0x00c1 }
            r14.<init>(r9, r0)     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.S2 r0 = r9.f2370a     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.P2 r0 = r0.f()     // Catch:{ all -> 0x00c1 }
            r0.k()     // Catch:{ all -> 0x00c1 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ all -> 0x00c1 }
            java.lang.String r15 = "com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE"
            r0.<init>(r15)     // Catch:{ all -> 0x00c1 }
            android.content.ComponentName r15 = new android.content.ComponentName     // Catch:{ all -> 0x00c1 }
            java.lang.String r13 = "com.google.android.finsky.externalreferrer.GetInstallReferrerService"
            r15.<init>(r6, r13)     // Catch:{ all -> 0x00c1 }
            r0.setComponent(r15)     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.S2 r13 = r9.f2370a     // Catch:{ all -> 0x00c1 }
            android.content.Context r13 = r13.A()     // Catch:{ all -> 0x00c1 }
            android.content.pm.PackageManager r13 = r13.getPackageManager()     // Catch:{ all -> 0x00c1 }
            if (r13 != 0) goto L_0x02e5
            com.google.android.gms.measurement.internal.S2 r0 = r9.f2370a     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.n2 r0 = r0.a()     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.N()     // Catch:{ all -> 0x00c1 }
            java.lang.String r6 = "Failed to obtain Package Manager to verify binding conditions for Install Referrer"
            r0.a(r6)     // Catch:{ all -> 0x00c1 }
            goto L_0x037e
        L_0x02e5:
            r15 = 0
            java.util.List r13 = r13.queryIntentServices(r0, r15)     // Catch:{ all -> 0x00c1 }
            if (r13 == 0) goto L_0x035f
            boolean r16 = r13.isEmpty()     // Catch:{ all -> 0x00c1 }
            if (r16 != 0) goto L_0x035f
            java.lang.Object r13 = r13.get(r15)     // Catch:{ all -> 0x00c1 }
            android.content.pm.ResolveInfo r13 = (android.content.pm.ResolveInfo) r13     // Catch:{ all -> 0x00c1 }
            android.content.pm.ServiceInfo r13 = r13.serviceInfo     // Catch:{ all -> 0x00c1 }
            if (r13 == 0) goto L_0x037e
            java.lang.String r15 = r13.packageName     // Catch:{ all -> 0x00c1 }
            java.lang.String r13 = r13.name     // Catch:{ all -> 0x00c1 }
            if (r13 == 0) goto L_0x034f
            boolean r6 = r6.equals(r15)     // Catch:{ all -> 0x00c1 }
            if (r6 == 0) goto L_0x034f
            boolean r6 = r9.b()     // Catch:{ all -> 0x00c1 }
            if (r6 == 0) goto L_0x034f
            android.content.Intent r6 = new android.content.Intent     // Catch:{ all -> 0x00c1 }
            r6.<init>(r0)     // Catch:{ all -> 0x00c1 }
            Q.b r0 = Q.b.b()     // Catch:{ RuntimeException -> 0x0333 }
            com.google.android.gms.measurement.internal.S2 r13 = r9.f2370a     // Catch:{ RuntimeException -> 0x0333 }
            android.content.Context r13 = r13.A()     // Catch:{ RuntimeException -> 0x0333 }
            r15 = 1
            boolean r0 = r0.a(r13, r6, r14, r15)     // Catch:{ RuntimeException -> 0x0333 }
            com.google.android.gms.measurement.internal.S2 r6 = r9.f2370a     // Catch:{ RuntimeException -> 0x0333 }
            com.google.android.gms.measurement.internal.n2 r6 = r6.a()     // Catch:{ RuntimeException -> 0x0333 }
            com.google.android.gms.measurement.internal.p2 r6 = r6.K()     // Catch:{ RuntimeException -> 0x0333 }
            java.lang.String r13 = "Install Referrer Service is"
            if (r0 == 0) goto L_0x0335
            java.lang.String r0 = "available"
            goto L_0x0337
        L_0x0333:
            r0 = move-exception
            goto L_0x033b
        L_0x0335:
            java.lang.String r0 = "not available"
        L_0x0337:
            r6.b(r13, r0)     // Catch:{ RuntimeException -> 0x0333 }
            goto L_0x037e
        L_0x033b:
            com.google.android.gms.measurement.internal.S2 r6 = r9.f2370a     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.n2 r6 = r6.a()     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.p2 r6 = r6.G()     // Catch:{ all -> 0x00c1 }
            java.lang.String r9 = "Exception occurred while binding to Install Referrer Service"
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00c1 }
            r6.b(r9, r0)     // Catch:{ all -> 0x00c1 }
            goto L_0x037e
        L_0x034f:
            com.google.android.gms.measurement.internal.S2 r0 = r9.f2370a     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.n2 r0 = r0.a()     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.L()     // Catch:{ all -> 0x00c1 }
            java.lang.String r6 = "Play Store version 8.3.73 or higher required for Install Referrer"
            r0.a(r6)     // Catch:{ all -> 0x00c1 }
            goto L_0x037e
        L_0x035f:
            com.google.android.gms.measurement.internal.S2 r0 = r9.f2370a     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.n2 r0 = r0.a()     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.J()     // Catch:{ all -> 0x00c1 }
            java.lang.String r6 = "Play Service for fetching Install Referrer is unavailable on device"
            r0.a(r6)     // Catch:{ all -> 0x00c1 }
            goto L_0x037e
        L_0x036f:
            com.google.android.gms.measurement.internal.S2 r0 = r9.f2370a     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.n2 r0 = r0.a()     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.N()     // Catch:{ all -> 0x00c1 }
            java.lang.String r6 = "Install Referrer Reporter was called with invalid app package name"
            r0.a(r6)     // Catch:{ all -> 0x00c1 }
        L_0x037e:
            com.google.android.gms.measurement.internal.P2 r0 = r1.f()     // Catch:{ all -> 0x00c1 }
            r0.k()     // Catch:{ all -> 0x00c1 }
            r1.A0()     // Catch:{ all -> 0x00c1 }
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ all -> 0x00c1 }
            r6.<init>()     // Catch:{ all -> 0x00c1 }
            r13 = 1
            r6.putLong(r11, r13)     // Catch:{ all -> 0x00c1 }
            r6.putLong(r10, r13)     // Catch:{ all -> 0x00c1 }
            r9 = 0
            r6.putLong(r7, r9)     // Catch:{ all -> 0x00c1 }
            r6.putLong(r5, r9)     // Catch:{ all -> 0x00c1 }
            r6.putLong(r4, r9)     // Catch:{ all -> 0x00c1 }
            r6.putLong(r3, r9)     // Catch:{ all -> 0x00c1 }
            r6.putLong(r12, r13)     // Catch:{ all -> 0x00c1 }
            boolean r0 = r2.f2646p     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x03ad
            r6.putLong(r8, r13)     // Catch:{ all -> 0x00c1 }
        L_0x03ad:
            java.lang.String r0 = r2.f2631a     // Catch:{ all -> 0x00c1 }
            java.lang.Object r0 = M.C0335p.l(r0)     // Catch:{ all -> 0x00c1 }
            r8 = r0
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.k r0 = r1.l0()     // Catch:{ all -> 0x00c1 }
            M.C0335p.f(r8)     // Catch:{ all -> 0x00c1 }
            r0.k()     // Catch:{ all -> 0x00c1 }
            r0.r()     // Catch:{ all -> 0x00c1 }
            java.lang.String r9 = "first_open_count"
            long r9 = r0.B0(r8, r9)     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.S2 r0 = r1.f2548l     // Catch:{ all -> 0x00c1 }
            android.content.Context r0 = r0.A()     // Catch:{ all -> 0x00c1 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x00c1 }
            if (r0 != 0) goto L_0x03ea
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()     // Catch:{ all -> 0x00c1 }
            java.lang.String r3 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.C0821n2.s(r8)     // Catch:{ all -> 0x00c1 }
            r0.b(r3, r4)     // Catch:{ all -> 0x00c1 }
        L_0x03e6:
            r21 = 0
            goto L_0x0495
        L_0x03ea:
            com.google.android.gms.measurement.internal.S2 r0 = r1.f2548l     // Catch:{ NameNotFoundException -> 0x03fa }
            android.content.Context r0 = r0.A()     // Catch:{ NameNotFoundException -> 0x03fa }
            T.d r0 = T.e.a(r0)     // Catch:{ NameNotFoundException -> 0x03fa }
            r15 = 0
            android.content.pm.PackageInfo r0 = r0.e(r8, r15)     // Catch:{ NameNotFoundException -> 0x03fa }
            goto L_0x040d
        L_0x03fa:
            r0 = move-exception
            com.google.android.gms.measurement.internal.n2 r11 = r1.a()     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.p2 r11 = r11.G()     // Catch:{ all -> 0x00c1 }
            java.lang.String r12 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.C0821n2.s(r8)     // Catch:{ all -> 0x00c1 }
            r11.c(r12, r13, r0)     // Catch:{ all -> 0x00c1 }
            r0 = 0
        L_0x040d:
            if (r0 == 0) goto L_0x0455
            long r11 = r0.firstInstallTime     // Catch:{ all -> 0x00c1 }
            r21 = 0
            int r13 = (r11 > r21 ? 1 : (r11 == r21 ? 0 : -1))
            if (r13 == 0) goto L_0x0455
            long r13 = r0.lastUpdateTime     // Catch:{ all -> 0x00c1 }
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x043c
            com.google.android.gms.measurement.internal.g r0 = r1.i0()     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.b2 r11 = com.google.android.gms.measurement.internal.G.f2508t0     // Catch:{ all -> 0x00c1 }
            boolean r0 = r0.q(r11)     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x0435
            r21 = 0
            int r0 = (r9 > r21 ? 1 : (r9 == r21 ? 0 : -1))
            if (r0 != 0) goto L_0x043a
            r13 = 1
            r6.putLong(r7, r13)     // Catch:{ all -> 0x00c1 }
            goto L_0x043a
        L_0x0435:
            r13 = 1
            r6.putLong(r7, r13)     // Catch:{ all -> 0x00c1 }
        L_0x043a:
            r15 = 0
            goto L_0x043d
        L_0x043c:
            r15 = 1
        L_0x043d:
            com.google.android.gms.measurement.internal.Y5 r0 = new com.google.android.gms.measurement.internal.Y5     // Catch:{ all -> 0x00c1 }
            java.lang.String r16 = "_fi"
            if (r15 == 0) goto L_0x0446
            r14 = 1
            goto L_0x0448
        L_0x0446:
            r14 = 0
        L_0x0448:
            java.lang.Long r19 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x00c1 }
            java.lang.String r20 = "auto"
            r15 = r0
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x00c1 }
            r1.w(r15, r2)     // Catch:{ all -> 0x00c1 }
        L_0x0455:
            com.google.android.gms.measurement.internal.S2 r0 = r1.f2548l     // Catch:{ NameNotFoundException -> 0x0465 }
            android.content.Context r0 = r0.A()     // Catch:{ NameNotFoundException -> 0x0465 }
            T.d r0 = T.e.a(r0)     // Catch:{ NameNotFoundException -> 0x0465 }
            r15 = 0
            android.content.pm.ApplicationInfo r11 = r0.c(r8, r15)     // Catch:{ NameNotFoundException -> 0x0465 }
            goto L_0x0478
        L_0x0465:
            r0 = move-exception
            com.google.android.gms.measurement.internal.n2 r7 = r1.a()     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.p2 r7 = r7.G()     // Catch:{ all -> 0x00c1 }
            java.lang.String r11 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.C0821n2.s(r8)     // Catch:{ all -> 0x00c1 }
            r7.c(r11, r8, r0)     // Catch:{ all -> 0x00c1 }
            r11 = 0
        L_0x0478:
            if (r11 == 0) goto L_0x03e6
            int r0 = r11.flags     // Catch:{ all -> 0x00c1 }
            r25 = 1
            r0 = r0 & 1
            if (r0 == 0) goto L_0x0488
            r13 = 1
            r6.putLong(r4, r13)     // Catch:{ all -> 0x00c1 }
            goto L_0x048a
        L_0x0488:
            r13 = 1
        L_0x048a:
            int r0 = r11.flags     // Catch:{ all -> 0x00c1 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x03e6
            r6.putLong(r3, r13)     // Catch:{ all -> 0x00c1 }
            goto L_0x03e6
        L_0x0495:
            int r0 = (r9 > r21 ? 1 : (r9 == r21 ? 0 : -1))
            if (r0 < 0) goto L_0x049c
            r6.putLong(r5, r9)     // Catch:{ all -> 0x00c1 }
        L_0x049c:
            com.google.android.gms.measurement.internal.E r15 = new com.google.android.gms.measurement.internal.E     // Catch:{ all -> 0x00c1 }
            java.lang.String r16 = "_f"
            com.google.android.gms.measurement.internal.D r0 = new com.google.android.gms.measurement.internal.D     // Catch:{ all -> 0x00c1 }
            r0.<init>(r6)     // Catch:{ all -> 0x00c1 }
            r19 = r17
            java.lang.String r18 = "auto"
            r17 = r0
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x00c1 }
            r1.Y(r15, r2)     // Catch:{ all -> 0x00c1 }
            goto L_0x051c
        L_0x04b2:
            r19 = r14
            r15 = 1
            if (r9 != r15) goto L_0x051c
            com.google.android.gms.measurement.internal.Y5 r15 = new com.google.android.gms.measurement.internal.Y5     // Catch:{ all -> 0x00c1 }
            java.lang.String r16 = "_fvt"
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x00c1 }
            java.lang.String r20 = "auto"
            r15.<init>(r16, r17, r19, r20)     // Catch:{ all -> 0x00c1 }
            r1.w(r15, r2)     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.P2 r0 = r1.f()     // Catch:{ all -> 0x00c1 }
            r0.k()     // Catch:{ all -> 0x00c1 }
            r1.A0()     // Catch:{ all -> 0x00c1 }
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x00c1 }
            r0.<init>()     // Catch:{ all -> 0x00c1 }
            r13 = 1
            r0.putLong(r11, r13)     // Catch:{ all -> 0x00c1 }
            r0.putLong(r10, r13)     // Catch:{ all -> 0x00c1 }
            r0.putLong(r12, r13)     // Catch:{ all -> 0x00c1 }
            boolean r3 = r2.f2646p     // Catch:{ all -> 0x00c1 }
            if (r3 == 0) goto L_0x04e8
            r0.putLong(r8, r13)     // Catch:{ all -> 0x00c1 }
        L_0x04e8:
            com.google.android.gms.measurement.internal.E r15 = new com.google.android.gms.measurement.internal.E     // Catch:{ all -> 0x00c1 }
            java.lang.String r16 = "_v"
            com.google.android.gms.measurement.internal.D r3 = new com.google.android.gms.measurement.internal.D     // Catch:{ all -> 0x00c1 }
            r3.<init>(r0)     // Catch:{ all -> 0x00c1 }
            r19 = r17
            java.lang.String r18 = "auto"
            r17 = r3
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x00c1 }
            r1.Y(r15, r2)     // Catch:{ all -> 0x00c1 }
            goto L_0x051c
        L_0x04fe:
            boolean r0 = r2.f2639i     // Catch:{ all -> 0x00c1 }
            if (r0 == 0) goto L_0x051c
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x00c1 }
            r0.<init>()     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.E r15 = new com.google.android.gms.measurement.internal.E     // Catch:{ all -> 0x00c1 }
            java.lang.String r16 = "_cd"
            com.google.android.gms.measurement.internal.D r3 = new com.google.android.gms.measurement.internal.D     // Catch:{ all -> 0x00c1 }
            r3.<init>(r0)     // Catch:{ all -> 0x00c1 }
            r19 = r17
            java.lang.String r18 = "auto"
            r17 = r3
            r15.<init>(r16, r17, r18, r19)     // Catch:{ all -> 0x00c1 }
            r1.Y(r15, r2)     // Catch:{ all -> 0x00c1 }
        L_0x051c:
            com.google.android.gms.measurement.internal.k r0 = r1.l0()     // Catch:{ all -> 0x00c1 }
            r0.k1()     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.measurement.internal.k r0 = r1.l0()
            r0.i1()
            return
        L_0x052b:
            com.google.android.gms.measurement.internal.k r2 = r1.l0()
            r2.i1()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.H5.h0(com.google.android.gms.measurement.internal.M5):void");
    }

    public final C0769g i0() {
        return ((S2) C0335p.l(this.f2548l)).w();
    }

    /* access modifiers changed from: package-private */
    public final void j0(M5 m5) {
        if (this.f2561y != null) {
            ArrayList arrayList = new ArrayList();
            this.f2562z = arrayList;
            arrayList.addAll(this.f2561y);
        }
        C0797k l02 = l0();
        String str = (String) C0335p.l(m5.f2631a);
        C0335p.f(str);
        l02.k();
        l02.r();
        try {
            SQLiteDatabase y4 = l02.y();
            String[] strArr = {str};
            int delete = y4.delete("apps", "app_id=?", strArr) + y4.delete("events", "app_id=?", strArr) + y4.delete("events_snapshot", "app_id=?", strArr) + y4.delete("user_attributes", "app_id=?", strArr) + y4.delete("conditional_properties", "app_id=?", strArr) + y4.delete("raw_events", "app_id=?", strArr) + y4.delete("raw_events_metadata", "app_id=?", strArr) + y4.delete("queue", "app_id=?", strArr) + y4.delete("audience_filter_values", "app_id=?", strArr) + y4.delete("main_event_params", "app_id=?", strArr) + y4.delete("default_event_params", "app_id=?", strArr) + y4.delete("trigger_uris", "app_id=?", strArr) + y4.delete("upload_queue", "app_id=?", strArr);
            if (delete > 0) {
                l02.a().K().c("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e5) {
            l02.a().G().c("Error resetting analytics data. appId, error", C0821n2.s(str), e5);
        }
        if (m5.f2638h) {
            h0(m5);
        }
    }

    public final C0797k l0() {
        return (C0797k) i(this.f2539c);
    }

    /* access modifiers changed from: package-private */
    public final void m0(M5 m5) {
        boolean z4;
        boolean z5;
        M5 m52 = m5;
        f().k();
        A0();
        C0335p.f(m52.f2631a);
        C0873v d5 = C0873v.d(m52.f2626B);
        a().K().c("Setting DMA consent for package", m52.f2631a, d5);
        String str = m52.f2631a;
        f().k();
        A0();
        p g4 = C0873v.b(d(str), 100).g();
        this.f2532C.put(str, d5);
        l0().Y(str, d5);
        p g5 = C0873v.b(d(str), 100).g();
        f().k();
        A0();
        p pVar = p.DENIED;
        boolean z6 = false;
        if (g4 == pVar && g5 == p.GRANTED) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (g4 == p.GRANTED && g5 == pVar) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (i0().q(G.f2439R0)) {
            if (z4 || z5) {
                z6 = true;
            }
            z4 = z6;
        }
        if (z4) {
            a().K().b("Generated _dcu event for", str);
            Bundle bundle = new Bundle();
            if (l0().J(F0(), str, false, false, false, false, false, false, false).f3158f < ((long) i0().t(str, G.f2454Z))) {
                bundle.putLong("_r", 1);
                a().K().c("_dcu realtime event count", str, Long.valueOf(l0().J(F0(), str, false, false, false, false, false, true, false).f3158f));
            }
            this.f2536G.b(str, "_dcu", bundle);
        }
    }

    public final C0779h2 n0() {
        return this.f2548l.D();
    }

    /* access modifiers changed from: package-private */
    public final void o0(M5 m5) {
        f().k();
        A0();
        C0335p.f(m5.f2631a);
        A3 f4 = A3.f(m5.f2652v, m5.f2625A);
        A3 U4 = U(m5.f2631a);
        a().K().c("Setting storage consent for package", m5.f2631a, f4);
        F(m5.f2631a, f4);
        if ((!C0576h6.a() || !i0().q(G.f2455Z0)) && f4.u(U4)) {
            j0(m5);
        }
    }

    public final C0842q2 p0() {
        return (C0842q2) i(this.f2538b);
    }

    /* access modifiers changed from: package-private */
    public final void q(C0755e eVar) {
        M5 c02 = c0((String) C0335p.l(eVar.f2953a));
        if (c02 != null) {
            r(eVar, c02);
        }
    }

    /* access modifiers changed from: package-private */
    public final void r(C0755e eVar, M5 m5) {
        Bundle bundle;
        C0335p.l(eVar);
        C0335p.f(eVar.f2953a);
        C0335p.l(eVar.f2955c);
        C0335p.f(eVar.f2955c.f2824b);
        f().k();
        A0();
        if (s0(m5)) {
            if (!m5.f2638h) {
                g(m5);
                return;
            }
            l0().c1();
            try {
                g(m5);
                String str = (String) C0335p.l(eVar.f2953a);
                C0755e I02 = l0().I0(str, eVar.f2955c.f2824b);
                if (I02 != null) {
                    a().F().c("Removing conditional user property", eVar.f2953a, this.f2548l.D().g(eVar.f2955c.f2824b));
                    l0().D(str, eVar.f2955c.f2824b);
                    if (I02.f2957e) {
                        l0().T0(str, eVar.f2955c.f2824b);
                    }
                    E e5 = eVar.f2963k;
                    if (e5 != null) {
                        D d5 = e5.f2367b;
                        if (d5 != null) {
                            bundle = d5.j();
                        } else {
                            bundle = null;
                        }
                        e0((E) C0335p.l(y0().H(str, ((E) C0335p.l(eVar.f2963k)).f2366a, bundle, I02.f2954b, eVar.f2963k.f2369d, true, true)), m5);
                    }
                } else {
                    a().L().c("Conditional user property doesn't exist", C0821n2.s(eVar.f2953a), this.f2548l.D().g(eVar.f2955c.f2824b));
                }
                l0().k1();
                l0().i1();
            } catch (Throwable th) {
                Throwable th2 = th;
                l0().i1();
                throw th2;
            }
        }
    }

    public final I2 r0() {
        return (I2) i(this.f2537a);
    }

    /* access modifiers changed from: package-private */
    public final void s(E e5, M5 m5) {
        C0892x4 x4Var;
        E e6;
        List<C0755e> list;
        List<C0755e> list2;
        List<C0755e> list3;
        String str;
        M5 m52 = m5;
        C0335p.l(m52);
        C0335p.f(m52.f2631a);
        f().k();
        A0();
        String str2 = m52.f2631a;
        E e7 = e5;
        long j4 = e7.f2369d;
        C0848r2 b5 = C0848r2.b(e7);
        f().k();
        if (this.f2534E == null || (str = this.f2535F) == null || !str.equals(str2)) {
            x4Var = null;
        } else {
            x4Var = this.f2534E;
        }
        int i4 = 0;
        d6.X(x4Var, b5.f3204d, false);
        E a5 = b5.a();
        x0();
        if (Z5.d0(a5, m52)) {
            if (!m52.f2638h) {
                g(m52);
                return;
            }
            List list4 = m52.f2650t;
            if (list4 == null) {
                e6 = a5;
            } else if (list4.contains(a5.f2366a)) {
                Bundle j5 = a5.f2367b.j();
                j5.putLong("ga_safelisted", 1);
                e6 = new E(a5.f2366a, new D(j5), a5.f2368c, a5.f2369d);
            } else {
                a().F().d("Dropping non-safelisted event. appId, event name, origin", str2, a5.f2366a, a5.f2368c);
                return;
            }
            l0().c1();
            try {
                C0797k l02 = l0();
                C0335p.f(str2);
                l02.k();
                l02.r();
                int i5 = (j4 > 0 ? 1 : (j4 == 0 ? 0 : -1));
                if (i5 < 0) {
                    l02.a().L().c("Invalid time querying timed out conditional properties", C0821n2.s(str2), Long.valueOf(j4));
                    list = Collections.EMPTY_LIST;
                } else {
                    list = l02.S("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str2, String.valueOf(j4)});
                }
                for (C0755e eVar : list) {
                    if (eVar != null) {
                        a().K().d("User property timed out", eVar.f2953a, this.f2548l.D().g(eVar.f2955c.f2824b), eVar.f2955c.c());
                        if (eVar.f2959g != null) {
                            e0(new E(eVar.f2959g, j4), m52);
                        }
                        l0().D(str2, eVar.f2955c.f2824b);
                    }
                }
                C0797k l03 = l0();
                C0335p.f(str2);
                l03.k();
                l03.r();
                if (i5 < 0) {
                    l03.a().L().c("Invalid time querying expired conditional properties", C0821n2.s(str2), Long.valueOf(j4));
                    list2 = Collections.EMPTY_LIST;
                } else {
                    list2 = l03.S("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str2, String.valueOf(j4)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (C0755e eVar2 : list2) {
                    if (eVar2 != null) {
                        a().K().d("User property expired", eVar2.f2953a, this.f2548l.D().g(eVar2.f2955c.f2824b), eVar2.f2955c.c());
                        l0().T0(str2, eVar2.f2955c.f2824b);
                        E e8 = eVar2.f2963k;
                        if (e8 != null) {
                            arrayList.add(e8);
                        }
                        l0().D(str2, eVar2.f2955c.f2824b);
                    }
                }
                int size = arrayList.size();
                int i6 = 0;
                while (i6 < size) {
                    Object obj = arrayList.get(i6);
                    i6++;
                    e0(new E((E) obj, j4), m52);
                }
                C0797k l04 = l0();
                String str3 = e6.f2366a;
                C0335p.f(str2);
                C0335p.f(str3);
                l04.k();
                l04.r();
                if (i5 < 0) {
                    l04.a().L().d("Invalid time querying triggered conditional properties", C0821n2.s(str2), l04.d().c(str3), Long.valueOf(j4));
                    list3 = Collections.EMPTY_LIST;
                } else {
                    list3 = l04.S("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str2, str3, String.valueOf(j4)});
                }
                ArrayList arrayList2 = new ArrayList(list3.size());
                for (C0755e eVar3 : list3) {
                    if (eVar3 != null) {
                        Y5 y5 = eVar3.f2955c;
                        a6 a6Var = new a6((String) C0335p.l(eVar3.f2953a), eVar3.f2954b, y5.f2824b, j4, C0335p.l(y5.c()));
                        if (l0().i0(a6Var)) {
                            a().K().d("User property triggered", eVar3.f2953a, this.f2548l.D().g(a6Var.f2856c), a6Var.f2858e);
                        } else {
                            a().G().d("Too many active user properties, ignoring", C0821n2.s(eVar3.f2953a), this.f2548l.D().g(a6Var.f2856c), a6Var.f2858e);
                        }
                        E e9 = eVar3.f2961i;
                        if (e9 != null) {
                            arrayList2.add(e9);
                        }
                        eVar3.f2955c = new Y5(a6Var);
                        eVar3.f2957e = true;
                        l0().g0(eVar3);
                    }
                }
                e0(e6, m52);
                int size2 = arrayList2.size();
                while (i4 < size2) {
                    Object obj2 = arrayList2.get(i4);
                    i4++;
                    e0(new E((E) obj2, j4), m52);
                }
                l0().k1();
                l0().i1();
            } catch (Throwable th) {
                l0().i1();
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void t(E e5, String str) {
        E e6 = e5;
        String str2 = str;
        C0744c2 M02 = l0().M0(str2);
        if (M02 == null || TextUtils.isEmpty(M02.o())) {
            a().F().b("No app data available; dropping event", str2);
            return;
        }
        Boolean k4 = k(M02);
        if (k4 == null) {
            if (!"_ui".equals(e6.f2366a)) {
                a().L().b("Could not find package. appId", C0821n2.s(str2));
            }
        } else if (!k4.booleanValue()) {
            a().G().b("App version does not match; dropping event. appId", C0821n2.s(str2));
            return;
        }
        C0744c2 c2Var = M02;
        C0744c2 c2Var2 = c2Var;
        C0744c2 c2Var3 = c2Var2;
        C0744c2 c2Var4 = c2Var3;
        C0744c2 c2Var5 = c2Var4;
        C0744c2 c2Var6 = c2Var5;
        Y(e6, new M5(str2, c2Var.q(), c2Var2.o(), c2Var3.U(), c2Var4.n(), c2Var5.z0(), c2Var6.t0(), (String) null, c2Var6.A(), false, c2Var6.p(), c2Var6.Q(), 0, 0, c2Var6.z(), false, c2Var6.j(), c2Var6.K0(), c2Var6.v0(), c2Var6.w(), (String) null, U(str2).x(), "", (String) null, c2Var6.C(), c2Var6.J0(), U(str2).b(), g0(str2).j(), c2Var6.a(), c2Var6.X(), c2Var6.v(), c2Var6.t()));
    }

    /* access modifiers changed from: package-private */
    public final S2 t0() {
        return this.f2548l;
    }

    /* access modifiers changed from: package-private */
    public final void u(C0744c2 c2Var, C0643p2.a aVar) {
        C0674t2 t2Var;
        f().k();
        A0();
        C0776h a5 = C0776h.a(aVar.b1());
        String l4 = c2Var.l();
        f().k();
        A0();
        A3 U4 = U(l4);
        int[] iArr = N5.f2661a;
        int i4 = iArr[U4.t().ordinal()];
        if (i4 == 1) {
            a5.d(A3.a.AD_STORAGE, C0790j.REMOTE_ENFORCED_DEFAULT);
        } else if (i4 == 2 || i4 == 3) {
            a5.c(A3.a.AD_STORAGE, U4.b());
        } else {
            a5.d(A3.a.AD_STORAGE, C0790j.FAILSAFE);
        }
        int i5 = iArr[U4.v().ordinal()];
        if (i5 == 1) {
            a5.d(A3.a.ANALYTICS_STORAGE, C0790j.REMOTE_ENFORCED_DEFAULT);
        } else if (i5 == 2 || i5 == 3) {
            a5.c(A3.a.ANALYTICS_STORAGE, U4.b());
        } else {
            a5.d(A3.a.ANALYTICS_STORAGE, C0790j.FAILSAFE);
        }
        String l5 = c2Var.l();
        f().k();
        A0();
        C0873v e5 = e(l5, g0(l5), U(l5), a5);
        aVar.S(((Boolean) C0335p.l(e5.h())).booleanValue());
        if (!TextUtils.isEmpty(e5.i())) {
            aVar.v0(e5.i());
        }
        f().k();
        A0();
        Iterator it = aVar.J().iterator();
        while (true) {
            if (!it.hasNext()) {
                t2Var = null;
                break;
            }
            t2Var = (C0674t2) it.next();
            if ("_npa".equals(t2Var.U())) {
                break;
            }
        }
        if (t2Var != null) {
            A3.a aVar2 = A3.a.AD_PERSONALIZATION;
            if (a5.b(aVar2) == C0790j.UNSET) {
                a6 N02 = l0().N0(c2Var.l(), "_npa");
                if (N02 == null) {
                    Boolean K02 = c2Var.K0();
                    if (K02 == null || ((K02 == Boolean.TRUE && t2Var.P() != 1) || (K02 == Boolean.FALSE && t2Var.P() != 0))) {
                        a5.d(aVar2, C0790j.API);
                    } else {
                        a5.d(aVar2, C0790j.MANIFEST);
                    }
                } else if ("tcf".equals(N02.f2855b)) {
                    a5.d(aVar2, C0790j.TCF);
                } else if (MBridgeConstans.DYNAMIC_VIEW_WX_APP.equals(N02.f2855b)) {
                    a5.d(aVar2, C0790j.API);
                } else {
                    a5.d(aVar2, C0790j.MANIFEST);
                }
            }
        } else {
            int b5 = b(c2Var.l(), a5);
            aVar.E((C0674t2) ((C0668s4) C0674t2.S().t("_npa").y(B().currentTimeMillis()).s((long) b5).m()));
            a().K().c("Setting user property", "non_personalized_ads(_npa)", Integer.valueOf(b5));
        }
        aVar.n0(a5.toString());
        boolean Y4 = this.f2537a.Y(c2Var.l());
        List I4 = aVar.I();
        int i6 = 0;
        for (int i7 = 0; i7 < I4.size(); i7++) {
            if ("_tcf".equals(((C0599k2) I4.get(i7)).U())) {
                C0599k2.a aVar3 = (C0599k2.a) ((C0599k2) I4.get(i7)).y();
                List I5 = aVar3.I();
                while (true) {
                    if (i6 >= I5.size()) {
                        break;
                    } else if ("_tcfd".equals(((C0617m2) I5.get(i6)).W())) {
                        aVar3.s(i6, C0617m2.U().y("_tcfd").A(C0907z5.d(((C0617m2) I5.get(i6)).X(), Y4)));
                        break;
                    } else {
                        i6++;
                    }
                }
                aVar.s(i7, aVar3);
                return;
            }
        }
    }

    public final C0878v4 u0() {
        return (C0878v4) i(this.f2544h);
    }

    public final C0796j5 v0() {
        return this.f2545i;
    }

    /* access modifiers changed from: package-private */
    public final void w(Y5 y5, M5 m5) {
        a6 N02;
        long j4;
        int i4;
        int i5;
        Y5 y52 = y5;
        M5 m52 = m5;
        f().k();
        A0();
        if (s0(m52)) {
            if (!m52.f2638h) {
                g(m52);
                return;
            }
            int r02 = y0().r0(y52.f2824b);
            if (r02 != 0) {
                y0();
                String str = y52.f2824b;
                i0();
                String J4 = d6.J(str, 24, true);
                String str2 = y52.f2824b;
                if (str2 != null) {
                    i5 = str2.length();
                } else {
                    i5 = 0;
                }
                y0();
                d6.Z(this.f2536G, m52.f2631a, r02, "_ev", J4, i5);
                return;
            }
            int t4 = y0().t(y52.f2824b, y52.c());
            if (t4 != 0) {
                y0();
                String str3 = y52.f2824b;
                i0();
                String J5 = d6.J(str3, 24, true);
                Object c5 = y52.c();
                if (c5 == null || (!(c5 instanceof String) && !(c5 instanceof CharSequence))) {
                    i4 = 0;
                } else {
                    i4 = String.valueOf(c5).length();
                }
                y0();
                d6.Z(this.f2536G, m52.f2631a, t4, "_ev", J5, i4);
                return;
            }
            Object A02 = y0().A0(y52.f2824b, y52.c());
            if (A02 != null) {
                if ("_sid".equals(y52.f2824b)) {
                    long j5 = y52.f2825c;
                    String str4 = y52.f2828f;
                    String str5 = (String) C0335p.l(m52.f2631a);
                    a6 N03 = l0().N0(str5, "_sno");
                    if (N03 != null) {
                        Object obj = N03.f2858e;
                        if (obj instanceof Long) {
                            j4 = ((Long) obj).longValue();
                            w(new Y5("_sno", j5, Long.valueOf(j4 + 1), str4), m52);
                        }
                    }
                    if (N03 != null) {
                        a().L().b("Retrieved last session number from database does not contain a valid (long) value", N03.f2858e);
                    }
                    A L02 = l0().L0(str5, "_s");
                    if (L02 != null) {
                        j4 = L02.f2285c;
                        a().K().b("Backfill the session number. Last used session number", Long.valueOf(j4));
                    } else {
                        j4 = 0;
                    }
                    w(new Y5("_sno", j5, Long.valueOf(j4 + 1), str4), m52);
                }
                a6 a6Var = new a6((String) C0335p.l(m52.f2631a), (String) C0335p.l(y52.f2828f), y52.f2824b, y52.f2825c, A02);
                a().K().c("Setting user property", this.f2548l.D().g(a6Var.f2856c), A02);
                l0().c1();
                try {
                    if ("_id".equals(a6Var.f2856c) && (N02 = l0().N0(m52.f2631a, "_id")) != null && !a6Var.f2858e.equals(N02.f2858e)) {
                        l0().T0(m52.f2631a, "_lair");
                    }
                    g(m52);
                    boolean i02 = l0().i0(a6Var);
                    if ("_sid".equals(y52.f2824b)) {
                        long w4 = x0().w(m52.f2654x);
                        C0744c2 M02 = l0().M0(m52.f2631a);
                        if (M02 != null) {
                            M02.E0(w4);
                            if (M02.B()) {
                                l0().V(M02, false, false);
                            }
                        }
                    }
                    l0().k1();
                    if (!i02) {
                        a().G().c("Too many unique user properties are set. Ignoring user property", this.f2548l.D().g(a6Var.f2856c), a6Var.f2858e);
                        y0();
                        d6.Z(this.f2536G, m52.f2631a, 9, (String) null, (String) null, 0);
                    }
                    l0().i1();
                } catch (Throwable th) {
                    l0().i1();
                    throw th;
                }
            }
        }
    }

    public final G5 w0() {
        return this.f2546j;
    }

    /* access modifiers changed from: package-private */
    public final void x(Runnable runnable) {
        f().k();
        if (this.f2552p == null) {
            this.f2552p = new ArrayList();
        }
        this.f2552p.add(runnable);
    }

    public final Z5 x0() {
        return (Z5) i(this.f2543g);
    }

    /* JADX WARNING: type inference failed for: r7v4, types: [java.lang.String] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void y(java.lang.String r4, int r5, java.lang.Throwable r6, byte[] r7, com.google.android.gms.measurement.internal.V5 r8) {
        /*
            r3 = this;
            com.google.android.gms.measurement.internal.P2 r0 = r3.f()
            r0.k()
            r3.A0()
            r0 = 0
            if (r7 != 0) goto L_0x0013
            byte[] r7 = new byte[r0]     // Catch:{ all -> 0x0010 }
            goto L_0x0013
        L_0x0010:
            r4 = move-exception
            goto L_0x00f6
        L_0x0013:
            r1 = 200(0xc8, float:2.8E-43)
            if (r5 == r1) goto L_0x001b
            r1 = 204(0xcc, float:2.86E-43)
            if (r5 != r1) goto L_0x00b3
        L_0x001b:
            if (r6 != 0) goto L_0x00b3
            if (r8 == 0) goto L_0x007a
            com.google.android.gms.measurement.internal.k r6 = r3.l0()     // Catch:{ all -> 0x0010 }
            long r7 = r8.a()     // Catch:{ all -> 0x0010 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0010 }
            r6.k()     // Catch:{ all -> 0x0010 }
            r6.r()     // Catch:{ all -> 0x0010 }
            M.C0335p.l(r7)     // Catch:{ all -> 0x0010 }
            boolean r8 = com.google.android.gms.internal.measurement.r7.a()     // Catch:{ all -> 0x0010 }
            if (r8 == 0) goto L_0x0046
            com.google.android.gms.measurement.internal.g r8 = r6.b()     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.b2 r1 = com.google.android.gms.measurement.internal.G.f2409C0     // Catch:{ all -> 0x0010 }
            boolean r8 = r8.q(r1)     // Catch:{ all -> 0x0010 }
            if (r8 == 0) goto L_0x007a
        L_0x0046:
            android.database.sqlite.SQLiteDatabase r8 = r6.y()     // Catch:{ all -> 0x0010 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0010 }
            java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch:{ all -> 0x0010 }
            java.lang.String r1 = "upload_queue"
            java.lang.String r2 = "rowid=?"
            int r7 = r8.delete(r1, r2, r7)     // Catch:{ SQLiteException -> 0x006b }
            r8 = 1
            if (r7 == r8) goto L_0x007a
            com.google.android.gms.measurement.internal.n2 r7 = r6.a()     // Catch:{ SQLiteException -> 0x006b }
            com.google.android.gms.measurement.internal.p2 r7 = r7.L()     // Catch:{ SQLiteException -> 0x006b }
            java.lang.String r8 = "Deleted fewer rows from upload_queue than expected"
            r7.a(r8)     // Catch:{ SQLiteException -> 0x006b }
            goto L_0x007a
        L_0x006b:
            r4 = move-exception
            com.google.android.gms.measurement.internal.n2 r5 = r6.a()     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.p2 r5 = r5.G()     // Catch:{ all -> 0x0010 }
            java.lang.String r6 = "Failed to delete a MeasurementBatch in a upload_queue table"
            r5.b(r6, r4)     // Catch:{ all -> 0x0010 }
            throw r4     // Catch:{ all -> 0x0010 }
        L_0x007a:
            com.google.android.gms.measurement.internal.n2 r6 = r3.a()     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.p2 r6 = r6.K()     // Catch:{ all -> 0x0010 }
            java.lang.String r7 = "Successfully uploaded batch from upload queue. appId, status"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0010 }
            r6.c(r7, r4, r5)     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.g r5 = r3.i0()     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.b2 r6 = com.google.android.gms.measurement.internal.G.f2409C0     // Catch:{ all -> 0x0010 }
            boolean r5 = r5.q(r6)     // Catch:{ all -> 0x0010 }
            if (r5 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.q2 r5 = r3.p0()     // Catch:{ all -> 0x0010 }
            boolean r5 = r5.z()     // Catch:{ all -> 0x0010 }
            if (r5 == 0) goto L_0x00af
            com.google.android.gms.measurement.internal.k r5 = r3.l0()     // Catch:{ all -> 0x0010 }
            boolean r5 = r5.g1(r4)     // Catch:{ all -> 0x0010 }
            if (r5 == 0) goto L_0x00af
            r3.k0(r4)     // Catch:{ all -> 0x0010 }
            goto L_0x00f0
        L_0x00af:
            r3.R()     // Catch:{ all -> 0x0010 }
            goto L_0x00f0
        L_0x00b3:
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x0010 }
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0010 }
            r1.<init>(r7, r2)     // Catch:{ all -> 0x0010 }
            int r7 = r1.length()     // Catch:{ all -> 0x0010 }
            r2 = 32
            int r7 = java.lang.Math.min(r2, r7)     // Catch:{ all -> 0x0010 }
            java.lang.String r7 = r1.substring(r0, r7)     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.n2 r1 = r3.a()     // Catch:{ all -> 0x0010 }
            com.google.android.gms.measurement.internal.p2 r1 = r1.M()     // Catch:{ all -> 0x0010 }
            java.lang.String r2 = "Network upload failed. Will retry later. appId, status, error"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0010 }
            if (r6 != 0) goto L_0x00d9
            r6 = r7
        L_0x00d9:
            r1.d(r2, r4, r5, r6)     // Catch:{ all -> 0x0010 }
            if (r8 == 0) goto L_0x00ed
            com.google.android.gms.measurement.internal.k r4 = r3.l0()     // Catch:{ all -> 0x0010 }
            long r5 = r8.a()     // Catch:{ all -> 0x0010 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0010 }
            r4.W(r5)     // Catch:{ all -> 0x0010 }
        L_0x00ed:
            r3.R()     // Catch:{ all -> 0x0010 }
        L_0x00f0:
            r3.f2557u = r0
            r3.P()
            return
        L_0x00f6:
            r3.f2557u = r0
            r3.P()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.H5.y(java.lang.String, int, java.lang.Throwable, byte[], com.google.android.gms.measurement.internal.V5):void");
    }

    public final d6 y0() {
        return ((S2) C0335p.l(this.f2548l)).L();
    }

    /* access modifiers changed from: package-private */
    public final void z0() {
        f().k();
        A0();
        if (!this.f2550n) {
            this.f2550n = true;
            if (T()) {
                int c5 = c(this.f2560x);
                int D4 = this.f2548l.y().D();
                f().k();
                if (c5 > D4) {
                    a().G().c("Panic: can't downgrade version. Previous, current version", Integer.valueOf(c5), Integer.valueOf(D4));
                } else if (c5 >= D4) {
                } else {
                    if (M(D4, this.f2560x)) {
                        a().K().c("Storage version upgraded. Previous, current version", Integer.valueOf(c5), Integer.valueOf(D4));
                    } else {
                        a().G().c("Storage version upgrade failed. Previous, current version", Integer.valueOf(c5), Integer.valueOf(D4));
                    }
                }
            }
        }
    }

    private class b {

        /* renamed from: a  reason: collision with root package name */
        final String f2568a;

        /* renamed from: b  reason: collision with root package name */
        long f2569b;

        private b(H5 h5) {
            this(h5, h5.y0().U0());
        }

        private b(H5 h5, String str) {
            this.f2568a = str;
            this.f2569b = h5.B().elapsedRealtime();
        }
    }

    private H5(W5 w5, S2 s22) {
        this.f2549m = false;
        this.f2553q = new HashSet();
        this.f2536G = new S5(this);
        C0335p.l(w5);
        this.f2548l = S2.b(w5.f2791a, (C0526c1) null, (Long) null);
        this.f2530A = -1;
        this.f2546j = new G5(this);
        Z5 z5 = new Z5(this);
        z5.s();
        this.f2543g = z5;
        C0842q2 q2Var = new C0842q2(this);
        q2Var.s();
        this.f2538b = q2Var;
        I2 i22 = new I2(this);
        i22.s();
        this.f2537a = i22;
        this.f2531B = new HashMap();
        this.f2532C = new HashMap();
        this.f2533D = new HashMap();
        f().D(new J5(this, w5));
    }
}
