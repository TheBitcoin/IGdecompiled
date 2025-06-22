package y;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import o.C0962c;
import q.h;
import q.i;
import q.p;
import t.C1046a;
import t.C1047b;
import t.C1048c;
import t.C1049d;
import t.C1050e;
import t.f;
import u.C1068a;
import z.C1114a;
import z.C1115b;

public class M implements C1094d, C1115b, C1093c, AutoCloseable {

    /* renamed from: f  reason: collision with root package name */
    private static final C0962c f4726f = C0962c.b("proto");

    /* renamed from: a  reason: collision with root package name */
    private final W f4727a;

    /* renamed from: b  reason: collision with root package name */
    private final A.a f4728b;

    /* renamed from: c  reason: collision with root package name */
    private final A.a f4729c;

    /* renamed from: d  reason: collision with root package name */
    private final C1095e f4730d;

    /* renamed from: e  reason: collision with root package name */
    private final O2.a f4731e;

    interface b {
        Object apply(Object obj);
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        final String f4732a;

        /* renamed from: b  reason: collision with root package name */
        final String f4733b;

        private c(String str, String str2) {
            this.f4732a = str;
            this.f4733b = str2;
        }
    }

    interface d {
        Object a();
    }

    M(A.a aVar, A.a aVar2, C1095e eVar, W w4, O2.a aVar3) {
        this.f4727a = w4;
        this.f4728b = aVar;
        this.f4729c = aVar2;
        this.f4730d = eVar;
        this.f4731e = aVar3;
    }

    public static /* synthetic */ C1046a A(M m4, Map map, C1046a.C0050a aVar, Cursor cursor) {
        m4.getClass();
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            C1048c.b Q4 = m4.Q(cursor.getInt(1));
            long j4 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(C1048c.c().c(Q4).b(j4).a());
        }
        m4.f0(aVar, map);
        return aVar.e(m4.X()).d(m4.V()).c((String) m4.f4731e.get()).b();
    }

    public static /* synthetic */ Boolean D(Cursor cursor) {
        boolean z4;
        if (cursor.getCount() > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        return Boolean.valueOf(z4);
    }

    public static /* synthetic */ Long E(M m4, i iVar, p pVar, SQLiteDatabase sQLiteDatabase) {
        boolean z4;
        byte[] bArr;
        if (m4.a0()) {
            m4.a(1, C1048c.b.CACHE_FULL, iVar.n());
            return -1L;
        }
        long S4 = m4.S(sQLiteDatabase, pVar);
        int e5 = m4.f4730d.e();
        byte[] a5 = iVar.e().a();
        if (a5.length <= e5) {
            z4 = true;
        } else {
            z4 = false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(S4));
        contentValues.put("transport_name", iVar.n());
        contentValues.put("timestamp_ms", Long.valueOf(iVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(iVar.o()));
        contentValues.put("payload_encoding", iVar.e().b().a());
        contentValues.put("code", iVar.d());
        contentValues.put("num_attempts", 0);
        contentValues.put(MRAIDCommunicatorUtil.PLACEMENT_INLINE, Boolean.valueOf(z4));
        if (z4) {
            bArr = a5;
        } else {
            bArr = new byte[0];
        }
        contentValues.put("payload", bArr);
        contentValues.put("product_id", iVar.l());
        contentValues.put("pseudonymous_id", iVar.m());
        contentValues.put("experiment_ids_clear_blob", iVar.g());
        contentValues.put("experiment_ids_encrypted_blob", iVar.h());
        long insert = sQLiteDatabase.insert("events", (String) null, contentValues);
        if (!z4) {
            int ceil = (int) Math.ceil(((double) a5.length) / ((double) e5));
            for (int i4 = 1; i4 <= ceil; i4++) {
                byte[] copyOfRange = Arrays.copyOfRange(a5, (i4 - 1) * e5, Math.min(i4 * e5, a5.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i4));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", (String) null, contentValues2);
            }
        }
        for (Map.Entry entry : iVar.k().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put(RewardPlus.NAME, (String) entry.getKey());
            contentValues3.put("value", (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", (String) null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    public static /* synthetic */ Long G(Cursor cursor) {
        if (!cursor.moveToNext()) {
            return null;
        }
        return Long.valueOf(cursor.getLong(0));
    }

    public static /* synthetic */ Object H(Throwable th) {
        throw new C1114a("Timed out while trying to acquire the lock.", th);
    }

    public static /* synthetic */ Object I(String str, C1048c.b bVar, long j4, SQLiteDatabase sQLiteDatabase) {
        if (!((Boolean) k0(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.getNumber())}), new y())).booleanValue()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(bVar.getNumber()));
            contentValues.put("events_dropped_count", Long.valueOf(j4));
            sQLiteDatabase.insert("log_event_dropped", (String) null, contentValues);
            return null;
        }
        sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j4 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.getNumber())});
        return null;
    }

    public static /* synthetic */ Object J(Map map, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j4 = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j4));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j4), set);
            }
            set.add(new c(cursor.getString(1), cursor.getString(2)));
        }
        return null;
    }

    public static /* synthetic */ Integer K(M m4, long j4, SQLiteDatabase sQLiteDatabase) {
        m4.getClass();
        String[] strArr = {String.valueOf(j4)};
        k0(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new r(m4));
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    public static /* synthetic */ Object L(M m4, List list, p pVar, Cursor cursor) {
        m4.getClass();
        while (cursor.moveToNext()) {
            boolean z4 = false;
            long j4 = cursor.getLong(0);
            if (cursor.getInt(7) != 0) {
                z4 = true;
            }
            i.a o4 = i.a().n(cursor.getString(1)).i(cursor.getLong(2)).o(cursor.getLong(3));
            if (z4) {
                o4.h(new h(i0(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                o4.h(new h(i0(cursor.getString(4)), m4.g0(j4)));
            }
            if (!cursor.isNull(6)) {
                o4.g(Integer.valueOf(cursor.getInt(6)));
            }
            if (!cursor.isNull(8)) {
                o4.l(Integer.valueOf(cursor.getInt(8)));
            }
            if (!cursor.isNull(9)) {
                o4.m(cursor.getString(9));
            }
            if (!cursor.isNull(10)) {
                o4.j(cursor.getBlob(10));
            }
            if (!cursor.isNull(11)) {
                o4.k(cursor.getBlob(11));
            }
            list.add(C1101k.a(j4, pVar, o4.d()));
        }
        return null;
    }

    public static /* synthetic */ Object M(M m4, SQLiteDatabase sQLiteDatabase) {
        m4.getClass();
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + m4.f4728b.a()).execute();
        return null;
    }

    public static /* synthetic */ Long O(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    public static /* synthetic */ f P(long j4, SQLiteDatabase sQLiteDatabase) {
        return (f) k0(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new C1088D(j4));
    }

    private C1048c.b Q(int i4) {
        C1048c.b bVar = C1048c.b.REASON_UNKNOWN;
        if (i4 == bVar.getNumber()) {
            return bVar;
        }
        C1048c.b bVar2 = C1048c.b.MESSAGE_TOO_OLD;
        if (i4 == bVar2.getNumber()) {
            return bVar2;
        }
        C1048c.b bVar3 = C1048c.b.CACHE_FULL;
        if (i4 == bVar3.getNumber()) {
            return bVar3;
        }
        C1048c.b bVar4 = C1048c.b.PAYLOAD_TOO_BIG;
        if (i4 == bVar4.getNumber()) {
            return bVar4;
        }
        C1048c.b bVar5 = C1048c.b.MAX_RETRIES_REACHED;
        if (i4 == bVar5.getNumber()) {
            return bVar5;
        }
        C1048c.b bVar6 = C1048c.b.INVALID_PAYLOD;
        if (i4 == bVar6.getNumber()) {
            return bVar6;
        }
        C1048c.b bVar7 = C1048c.b.SERVER_ERROR;
        if (i4 == bVar7.getNumber()) {
            return bVar7;
        }
        C1068a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i4));
        return bVar;
    }

    private void R(SQLiteDatabase sQLiteDatabase) {
        h0(new C1102l(sQLiteDatabase), new C1112w());
    }

    private long S(SQLiteDatabase sQLiteDatabase, p pVar) {
        Long Y4 = Y(sQLiteDatabase, pVar);
        if (Y4 != null) {
            return Y4.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", pVar.b());
        contentValues.put("priority", Integer.valueOf(B.a.a(pVar.d())));
        contentValues.put("next_request_ms", 0);
        if (pVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(pVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
    }

    private C1047b V() {
        return C1047b.b().b(C1050e.c().b(T()).c(C1095e.f4767a.f()).a()).a();
    }

    private long W() {
        return U().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private f X() {
        return (f) Z(new C1087C(this.f4728b.a()));
    }

    private Long Y(SQLiteDatabase sQLiteDatabase, p pVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{pVar.b(), String.valueOf(B.a.a(pVar.d()))}));
        if (pVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(pVar.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) k0(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), (String) null, (String) null, (String) null), new C1113x());
    }

    private boolean a0() {
        if (W() * getPageSize() >= this.f4730d.f()) {
            return true;
        }
        return false;
    }

    private List b0(List list, Map map) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            C1101k kVar = (C1101k) listIterator.next();
            if (map.containsKey(Long.valueOf(kVar.c()))) {
                i.a p4 = kVar.b().p();
                for (c cVar : (Set) map.get(Long.valueOf(kVar.c()))) {
                    p4.c(cVar.f4732a, cVar.f4733b);
                }
                listIterator.set(C1101k.a(kVar.c(), kVar.d(), p4.d()));
            }
        }
        return list;
    }

    private List c0(SQLiteDatabase sQLiteDatabase, p pVar, int i4) {
        ArrayList arrayList = new ArrayList();
        Long Y4 = Y(sQLiteDatabase, pVar);
        if (Y4 == null) {
            return arrayList;
        }
        k0(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", MRAIDCommunicatorUtil.PLACEMENT_INLINE, "product_id", "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{Y4.toString()}, (String) null, (String) null, (String) null, String.valueOf(i4)), new C1111v(this, arrayList, pVar));
        return arrayList;
    }

    private Map d0(SQLiteDatabase sQLiteDatabase, List list) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i4 = 0; i4 < list.size(); i4++) {
            sb.append(((C1101k) list.get(i4)).c());
            if (i4 < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        k0(sQLiteDatabase.query("event_metadata", new String[]{"event_id", RewardPlus.NAME, "value"}, sb.toString(), (String[]) null, (String) null, (String) null, (String) null), new z(hashMap));
        return hashMap;
    }

    private static byte[] e0(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private void f0(C1046a.C0050a aVar, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            aVar.a(C1049d.c().c((String) entry.getKey()).b((List) entry.getValue()).a());
        }
    }

    private byte[] g0(long j4) {
        return (byte[]) k0(U().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j4)}, (String) null, (String) null, "sequence_num"), new C1086B());
    }

    private long getPageSize() {
        return U().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private Object h0(d dVar, b bVar) {
        long a5 = this.f4729c.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e5) {
                if (this.f4729c.a() >= ((long) this.f4730d.b()) + a5) {
                    return bVar.apply(e5);
                }
                SystemClock.sleep(50);
            }
        }
    }

    private static C0962c i0(String str) {
        if (str == null) {
            return f4726f;
        }
        return C0962c.b(str);
    }

    private static String j0(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((C1101k) it.next()).c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    static Object k0(Cursor cursor, b bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public static /* synthetic */ List l(M m4, p pVar, SQLiteDatabase sQLiteDatabase) {
        List c02 = m4.c0(sQLiteDatabase, pVar, m4.f4730d.d());
        for (o.f fVar : o.f.values()) {
            if (fVar != pVar.d()) {
                int d5 = m4.f4730d.d() - c02.size();
                if (d5 <= 0) {
                    break;
                }
                c02.addAll(m4.c0(sQLiteDatabase, pVar.f(fVar), d5));
            }
        }
        return m4.b0(c02, m4.d0(sQLiteDatabase, c02));
    }

    public static /* synthetic */ List n(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(p.a().b(cursor.getString(1)).d(B.a.b(cursor.getInt(2))).c(e0(cursor.getString(3))).a());
        }
        return arrayList;
    }

    public static /* synthetic */ Object o(M m4, Cursor cursor) {
        m4.getClass();
        while (cursor.moveToNext()) {
            int i4 = cursor.getInt(0);
            m4.a((long) i4, C1048c.b.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    public static /* synthetic */ SQLiteDatabase p(Throwable th) {
        throw new C1114a("Timed out while trying to open db.", th);
    }

    public static /* synthetic */ Object r(M m4, Cursor cursor) {
        m4.getClass();
        while (cursor.moveToNext()) {
            int i4 = cursor.getInt(0);
            m4.a((long) i4, C1048c.b.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    public static /* synthetic */ Object u(M m4, String str, String str2, SQLiteDatabase sQLiteDatabase) {
        m4.getClass();
        sQLiteDatabase.compileStatement(str).execute();
        k0(sQLiteDatabase.rawQuery(str2, (String[]) null), new C1110u(m4));
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    public static /* synthetic */ Boolean v(M m4, p pVar, SQLiteDatabase sQLiteDatabase) {
        Long Y4 = m4.Y(sQLiteDatabase, pVar);
        if (Y4 == null) {
            return Boolean.FALSE;
        }
        return (Boolean) k0(m4.U().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{Y4.toString()}), new C1109t());
    }

    public static /* synthetic */ Object w(long j4, p pVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j4));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(B.a.a(pVar.d()))}) < 1) {
            contentValues.put("backend_name", pVar.b());
            contentValues.put("priority", Integer.valueOf(B.a.a(pVar.d())));
            sQLiteDatabase.insert("transport_contexts", (String) null, contentValues);
        }
        return null;
    }

    public static /* synthetic */ byte[] x(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i4 += blob.length;
        }
        byte[] bArr = new byte[i4];
        int i5 = 0;
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            byte[] bArr2 = (byte[]) arrayList.get(i6);
            System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
            i5 += bArr2.length;
        }
        return bArr;
    }

    public static /* synthetic */ List z(SQLiteDatabase sQLiteDatabase) {
        return (List) k0(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new J());
    }

    public C1101k B(p pVar, i iVar) {
        C1068a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", pVar.d(), iVar.n(), pVar.b());
        long longValue = ((Long) Z(new C1103m(this, iVar, pVar))).longValue();
        if (longValue < 1) {
            return null;
        }
        return C1101k.a(longValue, pVar, iVar);
    }

    public Iterable C(p pVar) {
        return (Iterable) Z(new L(this, pVar));
    }

    /* access modifiers changed from: package-private */
    public long T() {
        return W() * getPageSize();
    }

    /* access modifiers changed from: package-private */
    public SQLiteDatabase U() {
        W w4 = this.f4727a;
        Objects.requireNonNull(w4);
        return (SQLiteDatabase) h0(new C1089E(w4), new C1090F());
    }

    /* access modifiers changed from: package-private */
    public Object Z(b bVar) {
        SQLiteDatabase U4 = U();
        U4.beginTransaction();
        try {
            Object apply = bVar.apply(U4);
            U4.setTransactionSuccessful();
            return apply;
        } finally {
            U4.endTransaction();
        }
    }

    public void a(long j4, C1048c.b bVar, String str) {
        Z(new C1107q(str, bVar, j4));
    }

    public int b() {
        return ((Integer) Z(new I(this, this.f4728b.a() - this.f4730d.c()))).intValue();
    }

    public void c(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            U().compileStatement("DELETE FROM events WHERE _id in " + j0(iterable)).execute();
        }
    }

    public void close() {
        this.f4727a.close();
    }

    public void d() {
        Z(new C1106p(this));
    }

    public long f(p pVar) {
        return ((Long) k0(U().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{pVar.b(), String.valueOf(B.a.a(pVar.d()))}), new H())).longValue();
    }

    public C1046a g() {
        return (C1046a) Z(new C1108s(this, "SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new HashMap(), C1046a.e()));
    }

    public Object i(C1115b.a aVar) {
        SQLiteDatabase U4 = U();
        R(U4);
        try {
            Object execute = aVar.execute();
            U4.setTransactionSuccessful();
            return execute;
        } finally {
            U4.endTransaction();
        }
    }

    public Iterable j() {
        return (Iterable) Z(new G());
    }

    public boolean q(p pVar) {
        return ((Boolean) Z(new C1104n(this, pVar))).booleanValue();
    }

    public void t(p pVar, long j4) {
        Z(new C1105o(j4, pVar));
    }

    public void y(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            Z(new K(this, "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + j0(iterable), "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name"));
        }
    }
}
