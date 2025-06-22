package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.C0599k2;

final class m6 {

    /* renamed from: a  reason: collision with root package name */
    private C0599k2 f3126a;

    /* renamed from: b  reason: collision with root package name */
    private Long f3127b;

    /* renamed from: c  reason: collision with root package name */
    private long f3128c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ h6 f3129d;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.C0599k2 a(java.lang.String r15, com.google.android.gms.internal.measurement.C0599k2 r16) {
        /*
            r14 = this;
            r5 = r16
            java.lang.String r6 = r5.U()
            java.util.List r7 = r5.V()
            com.google.android.gms.measurement.internal.h6 r0 = r14.f3129d
            r0.l()
            java.lang.String r0 = "_eid"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.Z5.f0(r5, r0)
            r10 = r1
            java.lang.Long r10 = (java.lang.Long) r10
            if (r10 == 0) goto L_0x001c
            r1 = 1
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            r2 = 0
            if (r1 == 0) goto L_0x013c
            java.lang.String r4 = "_ep"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x013c
            M.C0335p.l(r10)
            com.google.android.gms.measurement.internal.h6 r1 = r14.f3129d
            r1.l()
            java.lang.String r1 = "_en"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.Z5.f0(r5, r1)
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            r4 = 0
            if (r1 == 0) goto L_0x0051
            com.google.android.gms.measurement.internal.h6 r15 = r14.f3129d
            com.google.android.gms.measurement.internal.n2 r15 = r15.a()
            com.google.android.gms.measurement.internal.p2 r15 = r15.I()
            java.lang.String r0 = "Extra parameter without an event name. eventId"
            r15.b(r0, r10)
            return r4
        L_0x0051:
            com.google.android.gms.internal.measurement.k2 r1 = r14.f3126a
            if (r1 == 0) goto L_0x0067
            java.lang.Long r1 = r14.f3127b
            if (r1 == 0) goto L_0x0067
            long r8 = r10.longValue()
            java.lang.Long r1 = r14.f3127b
            long r11 = r1.longValue()
            int r1 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r1 == 0) goto L_0x0096
        L_0x0067:
            com.google.android.gms.measurement.internal.h6 r1 = r14.f3129d
            com.google.android.gms.measurement.internal.k r1 = r1.n()
            android.util.Pair r1 = r1.H(r15, r10)
            if (r1 == 0) goto L_0x012c
            java.lang.Object r8 = r1.first
            if (r8 != 0) goto L_0x0079
            goto L_0x012c
        L_0x0079:
            com.google.android.gms.internal.measurement.k2 r8 = (com.google.android.gms.internal.measurement.C0599k2) r8
            r14.f3126a = r8
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r8 = r1.longValue()
            r14.f3128c = r8
            com.google.android.gms.measurement.internal.h6 r1 = r14.f3129d
            r1.l()
            com.google.android.gms.internal.measurement.k2 r1 = r14.f3126a
            java.lang.Object r0 = com.google.android.gms.measurement.internal.Z5.f0(r1, r0)
            java.lang.Long r0 = (java.lang.Long) r0
            r14.f3127b = r0
        L_0x0096:
            long r0 = r14.f3128c
            r8 = 1
            long r0 = r0 - r8
            r14.f3128c = r0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x00d5
            com.google.android.gms.measurement.internal.h6 r0 = r14.f3129d
            com.google.android.gms.measurement.internal.k r1 = r0.n()
            r1.k()
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.K()
            java.lang.String r2 = "Clearing complex main event info. appId"
            r0.b(r2, r15)
            android.database.sqlite.SQLiteDatabase r0 = r1.y()     // Catch:{ SQLiteException -> 0x00c5 }
            java.lang.String r2 = "delete from main_event_params where app_id=?"
            java.lang.String[] r15 = new java.lang.String[]{r15}     // Catch:{ SQLiteException -> 0x00c5 }
            r0.execSQL(r2, r15)     // Catch:{ SQLiteException -> 0x00c5 }
            goto L_0x00e3
        L_0x00c5:
            r0 = move-exception
            r15 = r0
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()
            java.lang.String r1 = "Error clearing complex main event"
            r0.b(r1, r15)
            goto L_0x00e3
        L_0x00d5:
            com.google.android.gms.measurement.internal.h6 r0 = r14.f3129d
            com.google.android.gms.measurement.internal.k r8 = r0.n()
            long r11 = r14.f3128c
            com.google.android.gms.internal.measurement.k2 r13 = r14.f3126a
            r9 = r15
            r8.n0(r9, r10, r11, r13)
        L_0x00e3:
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            com.google.android.gms.internal.measurement.k2 r0 = r14.f3126a
            java.util.List r0 = r0.V()
            java.util.Iterator r0 = r0.iterator()
        L_0x00f2:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0111
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.m2 r1 = (com.google.android.gms.internal.measurement.C0617m2) r1
            com.google.android.gms.measurement.internal.h6 r2 = r14.f3129d
            r2.l()
            java.lang.String r2 = r1.W()
            com.google.android.gms.internal.measurement.m2 r2 = com.google.android.gms.measurement.internal.Z5.F(r5, r2)
            if (r2 != 0) goto L_0x00f2
            r15.add(r1)
            goto L_0x00f2
        L_0x0111:
            boolean r0 = r15.isEmpty()
            if (r0 != 0) goto L_0x011c
            r15.addAll(r7)
            r7 = r15
            goto L_0x0180
        L_0x011c:
            com.google.android.gms.measurement.internal.h6 r15 = r14.f3129d
            com.google.android.gms.measurement.internal.n2 r15 = r15.a()
            com.google.android.gms.measurement.internal.p2 r15 = r15.I()
            java.lang.String r0 = "No unique parameters in main event. eventName"
            r15.b(r0, r6)
            goto L_0x0180
        L_0x012c:
            com.google.android.gms.measurement.internal.h6 r15 = r14.f3129d
            com.google.android.gms.measurement.internal.n2 r15 = r15.a()
            com.google.android.gms.measurement.internal.p2 r15 = r15.I()
            java.lang.String r0 = "Extra parameter without existing main event. eventName, eventId"
            r15.c(r0, r6, r10)
            return r4
        L_0x013c:
            if (r1 == 0) goto L_0x0180
            r14.f3127b = r10
            r14.f3126a = r5
            com.google.android.gms.measurement.internal.h6 r0 = r14.f3129d
            r0.l()
            java.lang.Long r0 = java.lang.Long.valueOf(r2)
            java.lang.String r1 = "_epc"
            java.lang.Object r0 = com.google.android.gms.measurement.internal.Z5.J(r5, r1, r0)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            r14.f3128c = r0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 > 0) goto L_0x016d
            com.google.android.gms.measurement.internal.h6 r15 = r14.f3129d
            com.google.android.gms.measurement.internal.n2 r15 = r15.a()
            com.google.android.gms.measurement.internal.p2 r15 = r15.I()
            java.lang.String r0 = "Complex event with zero extra param count. eventName"
            r15.b(r0, r6)
            goto L_0x0180
        L_0x016d:
            com.google.android.gms.measurement.internal.h6 r0 = r14.f3129d
            com.google.android.gms.measurement.internal.k r0 = r0.n()
            java.lang.Object r1 = M.C0335p.l(r10)
            r2 = r1
            java.lang.Long r2 = (java.lang.Long) r2
            long r3 = r14.f3128c
            r1 = r15
            r0.n0(r1, r2, r3, r5)
        L_0x0180:
            com.google.android.gms.internal.measurement.s4$b r15 = r16.y()
            com.google.android.gms.internal.measurement.k2$a r15 = (com.google.android.gms.internal.measurement.C0599k2.a) r15
            com.google.android.gms.internal.measurement.k2$a r15 = r15.B(r6)
            com.google.android.gms.internal.measurement.k2$a r15 = r15.G()
            com.google.android.gms.internal.measurement.k2$a r15 = r15.A(r7)
            com.google.android.gms.internal.measurement.Z4 r15 = r15.m()
            com.google.android.gms.internal.measurement.s4 r15 = (com.google.android.gms.internal.measurement.C0668s4) r15
            com.google.android.gms.internal.measurement.k2 r15 = (com.google.android.gms.internal.measurement.C0599k2) r15
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.m6.a(java.lang.String, com.google.android.gms.internal.measurement.k2):com.google.android.gms.internal.measurement.k2");
    }

    private m6(h6 h6Var) {
        this.f3129d = h6Var;
    }
}
