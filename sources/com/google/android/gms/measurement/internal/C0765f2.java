package com.google.android.gms.measurement.internal;

import R.d;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import androidx.exifinterface.media.ExifInterface;

/* renamed from: com.google.android.gms.measurement.internal.f2  reason: case insensitive filesystem */
public final class C0765f2 extends C0897y2 {

    /* renamed from: c  reason: collision with root package name */
    private final C0786i2 f2973c = new C0786i2(this, A(), "google_app_measurement_local.db");

    /* renamed from: d  reason: collision with root package name */
    private boolean f2974d;

    C0765f2(S2 s22) {
        super(s22);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r7v0 */
    /* JADX WARNING: type inference failed for: r7v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r7v5 */
    /* JADX WARNING: type inference failed for: r7v7 */
    /* JADX WARNING: type inference failed for: r7v8 */
    /* JADX WARNING: type inference failed for: r7v9 */
    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r7v11 */
    /* JADX WARNING: type inference failed for: r7v12 */
    /* JADX WARNING: type inference failed for: r7v17 */
    /* JADX WARNING: type inference failed for: r7v18 */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0159, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x015e, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0169, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x016e, code lost:
        r9.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
        r7 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0060, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0061, code lost:
        r7 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0064, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006b, code lost:
        r7 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00c2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ca, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00ec, code lost:
        r7 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ee, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00ef, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x00f5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x010a, code lost:
        if (r7.inTransaction() != false) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x010c, code lost:
        r7.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0110, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0111, code lost:
        r9 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0126, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x012b, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x013a, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x013f, code lost:
        r9.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x00d6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0161 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0161 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0161 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:9:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0060 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:25:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:25:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0078 A[SYNTHETIC, Splitter:B:39:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:68:? A[ExcHandler: SQLiteDatabaseLockedException (unused android.database.sqlite.SQLiteDatabaseLockedException), SYNTHETIC, Splitter:B:44:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0106 A[SYNTHETIC, Splitter:B:78:0x0106] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x013f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean D(int r18, byte[] r19) {
        /*
            r17 = this;
            r1 = r17
            r1.k()
            boolean r0 = r1.f2974d
            r2 = 0
            if (r0 == 0) goto L_0x000b
            return r2
        L_0x000b:
            android.content.ContentValues r3 = new android.content.ContentValues
            r3.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r18)
            java.lang.String r4 = "type"
            r3.put(r4, r0)
            java.lang.String r0 = "entry"
            r4 = r19
            r3.put(r0, r4)
            r4 = 5
            r5 = 0
            r6 = 5
        L_0x0023:
            if (r5 >= r4) goto L_0x0172
            r7 = 0
            r8 = 1
            android.database.sqlite.SQLiteDatabase r9 = r1.K()     // Catch:{ SQLiteFullException -> 0x0143, SQLiteDatabaseLockedException -> 0x012f, SQLiteException -> 0x00fe, all -> 0x00fa }
            if (r9 != 0) goto L_0x004a
            r1.f2974d = r8     // Catch:{ SQLiteFullException -> 0x0045, SQLiteDatabaseLockedException -> 0x0041, SQLiteException -> 0x0038 }
            if (r9 == 0) goto L_0x0034
            r9.close()
        L_0x0034:
            return r2
        L_0x0035:
            r0 = move-exception
            goto L_0x0167
        L_0x0038:
            r0 = move-exception
            r10 = r7
        L_0x003a:
            r7 = r9
            r19 = 1
            r16 = 0
            goto L_0x0104
        L_0x0041:
            r16 = 0
            goto L_0x0132
        L_0x0045:
            r0 = move-exception
        L_0x0046:
            r16 = 0
            goto L_0x0147
        L_0x004a:
            r9.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x0041, SQLiteException -> 0x00ee }
            java.lang.String r0 = "select count(1) from messages"
            android.database.Cursor r10 = r9.rawQuery(r0, r7)     // Catch:{ SQLiteFullException -> 0x00f5, SQLiteDatabaseLockedException -> 0x0041, SQLiteException -> 0x00ee }
            if (r10 == 0) goto L_0x006d
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteFullException -> 0x006a, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x0064, all -> 0x0060 }
            if (r0 == 0) goto L_0x006d
            long r11 = r10.getLong(r2)     // Catch:{ SQLiteFullException -> 0x006a, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x0064, all -> 0x0060 }
            goto L_0x006f
        L_0x0060:
            r0 = move-exception
        L_0x0061:
            r7 = r10
            goto L_0x0167
        L_0x0064:
            r0 = move-exception
            goto L_0x003a
        L_0x0066:
            r16 = 0
            goto L_0x00ec
        L_0x006a:
            r0 = move-exception
            r7 = r10
            goto L_0x0046
        L_0x006d:
            r11 = 0
        L_0x006f:
            r13 = 100000(0x186a0, double:4.94066E-319)
            java.lang.String r0 = "messages"
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 < 0) goto L_0x00d6
            com.google.android.gms.measurement.internal.n2 r13 = r1.a()     // Catch:{ SQLiteFullException -> 0x00d0, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x00ca, all -> 0x0060 }
            com.google.android.gms.measurement.internal.p2 r13 = r13.G()     // Catch:{ SQLiteFullException -> 0x00d0, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x00ca, all -> 0x0060 }
            java.lang.String r14 = "Data loss, local db full"
            r13.a(r14)     // Catch:{ SQLiteFullException -> 0x00d0, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x00ca, all -> 0x0060 }
            r13 = 100001(0x186a1, double:4.9407E-319)
            long r13 = r13 - r11
            java.lang.String r11 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            java.lang.String r12 = java.lang.Long.toString(r13)     // Catch:{ SQLiteFullException -> 0x00d0, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x00ca, all -> 0x0060 }
            java.lang.String[] r12 = new java.lang.String[]{r12}     // Catch:{ SQLiteFullException -> 0x00d0, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x00ca, all -> 0x0060 }
            int r11 = r9.delete(r0, r11, r12)     // Catch:{ SQLiteFullException -> 0x00d0, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x00ca, all -> 0x0060 }
            long r11 = (long) r11     // Catch:{ SQLiteFullException -> 0x00d0, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x00ca, all -> 0x0060 }
            int r15 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r15 == 0) goto L_0x00d6
            com.google.android.gms.measurement.internal.n2 r15 = r1.a()     // Catch:{ SQLiteFullException -> 0x00d0, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x00ca, all -> 0x0060 }
            com.google.android.gms.measurement.internal.p2 r15 = r15.G()     // Catch:{ SQLiteFullException -> 0x00d0, SQLiteDatabaseLockedException -> 0x0066, SQLiteException -> 0x00ca, all -> 0x0060 }
            r16 = 0
            java.lang.String r2 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r4 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x00c6, SQLiteDatabaseLockedException -> 0x00ec, SQLiteException -> 0x00c2, all -> 0x0060 }
            r19 = 1
            java.lang.Long r8 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteFullException -> 0x00be, SQLiteDatabaseLockedException -> 0x00ec, SQLiteException -> 0x00bb, all -> 0x0060 }
            long r13 = r13 - r11
            java.lang.Long r11 = java.lang.Long.valueOf(r13)     // Catch:{ SQLiteFullException -> 0x00be, SQLiteDatabaseLockedException -> 0x00ec, SQLiteException -> 0x00bb, all -> 0x0060 }
            r15.d(r2, r4, r8, r11)     // Catch:{ SQLiteFullException -> 0x00be, SQLiteDatabaseLockedException -> 0x00ec, SQLiteException -> 0x00bb, all -> 0x0060 }
            goto L_0x00da
        L_0x00bb:
            r0 = move-exception
        L_0x00bc:
            r7 = r9
            goto L_0x0104
        L_0x00be:
            r0 = move-exception
        L_0x00bf:
            r7 = r10
            goto L_0x0147
        L_0x00c2:
            r0 = move-exception
            r19 = 1
            goto L_0x00bc
        L_0x00c6:
            r0 = move-exception
            r19 = 1
            goto L_0x00bf
        L_0x00ca:
            r0 = move-exception
            r19 = 1
            r16 = 0
            goto L_0x00bc
        L_0x00d0:
            r0 = move-exception
            r19 = 1
            r16 = 0
            goto L_0x00bf
        L_0x00d6:
            r19 = 1
            r16 = 0
        L_0x00da:
            r9.insertOrThrow(r0, r7, r3)     // Catch:{ SQLiteFullException -> 0x00be, SQLiteDatabaseLockedException -> 0x00ec, SQLiteException -> 0x00bb, all -> 0x0060 }
            r9.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x00be, SQLiteDatabaseLockedException -> 0x00ec, SQLiteException -> 0x00bb, all -> 0x0060 }
            r9.endTransaction()     // Catch:{ SQLiteFullException -> 0x00be, SQLiteDatabaseLockedException -> 0x00ec, SQLiteException -> 0x00bb, all -> 0x0060 }
            if (r10 == 0) goto L_0x00e8
            r10.close()
        L_0x00e8:
            r9.close()
            return r19
        L_0x00ec:
            r7 = r10
            goto L_0x0132
        L_0x00ee:
            r0 = move-exception
            r19 = 1
            r16 = 0
            r10 = r7
            goto L_0x00bc
        L_0x00f5:
            r0 = move-exception
            r19 = 1
            goto L_0x0046
        L_0x00fa:
            r0 = move-exception
            r9 = r7
            goto L_0x0167
        L_0x00fe:
            r0 = move-exception
            r19 = 1
            r16 = 0
            r10 = r7
        L_0x0104:
            if (r7 == 0) goto L_0x0114
            boolean r2 = r7.inTransaction()     // Catch:{ all -> 0x0110 }
            if (r2 == 0) goto L_0x0114
            r7.endTransaction()     // Catch:{ all -> 0x0110 }
            goto L_0x0114
        L_0x0110:
            r0 = move-exception
            r9 = r7
            goto L_0x0061
        L_0x0114:
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()     // Catch:{ all -> 0x0110 }
            com.google.android.gms.measurement.internal.p2 r2 = r2.G()     // Catch:{ all -> 0x0110 }
            java.lang.String r4 = "Error writing entry to local database"
            r2.b(r4, r0)     // Catch:{ all -> 0x0110 }
            r2 = 1
            r1.f2974d = r2     // Catch:{ all -> 0x0110 }
            if (r10 == 0) goto L_0x0129
            r10.close()
        L_0x0129:
            if (r7 == 0) goto L_0x0161
            r7.close()
            goto L_0x0161
        L_0x012f:
            r16 = 0
            r9 = r7
        L_0x0132:
            long r10 = (long) r6
            android.os.SystemClock.sleep(r10)     // Catch:{ all -> 0x0035 }
            int r6 = r6 + 20
            if (r7 == 0) goto L_0x013d
            r7.close()
        L_0x013d:
            if (r9 == 0) goto L_0x0161
            r9.close()
            goto L_0x0161
        L_0x0143:
            r0 = move-exception
            r16 = 0
            r9 = r7
        L_0x0147:
            com.google.android.gms.measurement.internal.n2 r2 = r1.a()     // Catch:{ all -> 0x0035 }
            com.google.android.gms.measurement.internal.p2 r2 = r2.G()     // Catch:{ all -> 0x0035 }
            java.lang.String r4 = "Error writing entry; local database full"
            r2.b(r4, r0)     // Catch:{ all -> 0x0035 }
            r2 = 1
            r1.f2974d = r2     // Catch:{ all -> 0x0035 }
            if (r7 == 0) goto L_0x015c
            r7.close()
        L_0x015c:
            if (r9 == 0) goto L_0x0161
            r9.close()
        L_0x0161:
            int r5 = r5 + 1
            r2 = 0
            r4 = 5
            goto L_0x0023
        L_0x0167:
            if (r7 == 0) goto L_0x016c
            r7.close()
        L_0x016c:
            if (r9 == 0) goto L_0x0171
            r9.close()
        L_0x0171:
            throw r0
        L_0x0172:
            r16 = 0
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.K()
            java.lang.String r2 = "Failed to write entry to local database"
            r0.a(r2)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0765f2.D(int, byte[]):boolean");
    }

    private final SQLiteDatabase K() {
        if (this.f2974d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f2973c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f2974d = true;
        return null;
    }

    private final boolean L() {
        return A().getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX INFO: finally extract failed */
    private static long y(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            Cursor query = sQLiteDatabase.query("messages", new String[]{"rowid"}, "type=?", new String[]{ExifInterface.GPS_MEASUREMENT_3D}, (String) null, (String) null, "rowid desc", "1");
            if (query.moveToFirst()) {
                long j4 = query.getLong(0);
                query.close();
                return j4;
            }
            query.close();
            return -1;
        } catch (Throwable th) {
            Throwable th2 = th;
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final /* bridge */ /* synthetic */ Context A() {
        return super.A();
    }

    public final /* bridge */ /* synthetic */ d B() {
        return super.B();
    }

    public final /* bridge */ /* synthetic */ C0741c C() {
        return super.C();
    }

    public final boolean E(C0755e eVar) {
        g();
        byte[] q02 = d6.q0(eVar);
        if (q02.length <= 131072) {
            return D(2, q02);
        }
        a().I().a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean F(E e5) {
        Parcel obtain = Parcel.obtain();
        e5.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return D(0, marshall);
        }
        a().I().a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean G(Y5 y5) {
        Parcel obtain = Parcel.obtain();
        y5.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return D(1, marshall);
        }
        a().I().a("User property too long for local database. Sending directly to service");
        return false;
    }

    public final void H() {
        int delete;
        k();
        try {
            SQLiteDatabase K4 = K();
            if (K4 != null && (delete = K4.delete("messages", (String) null, (String[]) null)) > 0) {
                a().K().b("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e5) {
            a().G().b("Error resetting local analytics data. error", e5);
        }
    }

    public final boolean I() {
        return D(3, new byte[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0086, code lost:
        r3 = r3 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean J() {
        /*
            r10 = this;
            java.lang.String r0 = "Error deleting app launch break from local database"
            r10.k()
            boolean r1 = r10.f2974d
            r2 = 0
            if (r1 == 0) goto L_0x000b
            return r2
        L_0x000b:
            boolean r1 = r10.L()
            if (r1 != 0) goto L_0x0012
            return r2
        L_0x0012:
            r1 = 5
            r3 = 0
            r4 = 5
        L_0x0015:
            if (r3 >= r1) goto L_0x008f
            r5 = 1
            r6 = 0
            android.database.sqlite.SQLiteDatabase r6 = r10.K()     // Catch:{ SQLiteFullException -> 0x002b, SQLiteDatabaseLockedException -> 0x0068, SQLiteException -> 0x0029 }
            if (r6 != 0) goto L_0x002d
            r10.f2974d = r5     // Catch:{ SQLiteFullException -> 0x002b, SQLiteDatabaseLockedException -> 0x0068, SQLiteException -> 0x0029 }
            if (r6 == 0) goto L_0x0026
            r6.close()
        L_0x0026:
            return r2
        L_0x0027:
            r0 = move-exception
            goto L_0x0089
        L_0x0029:
            r7 = move-exception
            goto L_0x004a
        L_0x002b:
            r7 = move-exception
            goto L_0x0074
        L_0x002d:
            r6.beginTransaction()     // Catch:{ SQLiteFullException -> 0x002b, SQLiteDatabaseLockedException -> 0x0068, SQLiteException -> 0x0029 }
            java.lang.String r7 = "messages"
            java.lang.String r8 = "type == ?"
            r9 = 3
            java.lang.String r9 = java.lang.Integer.toString(r9)     // Catch:{ SQLiteFullException -> 0x002b, SQLiteDatabaseLockedException -> 0x0068, SQLiteException -> 0x0029 }
            java.lang.String[] r9 = new java.lang.String[]{r9}     // Catch:{ SQLiteFullException -> 0x002b, SQLiteDatabaseLockedException -> 0x0068, SQLiteException -> 0x0029 }
            r6.delete(r7, r8, r9)     // Catch:{ SQLiteFullException -> 0x002b, SQLiteDatabaseLockedException -> 0x0068, SQLiteException -> 0x0029 }
            r6.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x002b, SQLiteDatabaseLockedException -> 0x0068, SQLiteException -> 0x0029 }
            r6.endTransaction()     // Catch:{ SQLiteFullException -> 0x002b, SQLiteDatabaseLockedException -> 0x0068, SQLiteException -> 0x0029 }
            r6.close()
            return r5
        L_0x004a:
            if (r6 == 0) goto L_0x0055
            boolean r8 = r6.inTransaction()     // Catch:{ all -> 0x0027 }
            if (r8 == 0) goto L_0x0055
            r6.endTransaction()     // Catch:{ all -> 0x0027 }
        L_0x0055:
            com.google.android.gms.measurement.internal.n2 r8 = r10.a()     // Catch:{ all -> 0x0027 }
            com.google.android.gms.measurement.internal.p2 r8 = r8.G()     // Catch:{ all -> 0x0027 }
            r8.b(r0, r7)     // Catch:{ all -> 0x0027 }
            r10.f2974d = r5     // Catch:{ all -> 0x0027 }
            if (r6 == 0) goto L_0x0086
            r6.close()
            goto L_0x0086
        L_0x0068:
            long r7 = (long) r4
            android.os.SystemClock.sleep(r7)     // Catch:{ all -> 0x0027 }
            int r4 = r4 + 20
            if (r6 == 0) goto L_0x0086
            r6.close()
            goto L_0x0086
        L_0x0074:
            com.google.android.gms.measurement.internal.n2 r8 = r10.a()     // Catch:{ all -> 0x0027 }
            com.google.android.gms.measurement.internal.p2 r8 = r8.G()     // Catch:{ all -> 0x0027 }
            r8.b(r0, r7)     // Catch:{ all -> 0x0027 }
            r10.f2974d = r5     // Catch:{ all -> 0x0027 }
            if (r6 == 0) goto L_0x0086
            r6.close()
        L_0x0086:
            int r3 = r3 + 1
            goto L_0x0015
        L_0x0089:
            if (r6 == 0) goto L_0x008e
            r6.close()
        L_0x008e:
            throw r0
        L_0x008f:
            com.google.android.gms.measurement.internal.n2 r0 = r10.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.L()
            java.lang.String r1 = "Error deleting app launch break from local database in reasonable time"
            r0.a(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0765f2.J():boolean");
    }

    public final /* bridge */ /* synthetic */ C0821n2 a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ C0769g b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ C0887x c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ C0779h2 d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ C0904z2 e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ P2 f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ d6 g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    public final /* bridge */ /* synthetic */ C0894y l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ C0772g2 m() {
        return super.m();
    }

    public final /* bridge */ /* synthetic */ C0765f2 n() {
        return super.n();
    }

    public final /* bridge */ /* synthetic */ F3 o() {
        return super.o();
    }

    public final /* bridge */ /* synthetic */ C0885w4 p() {
        return super.p();
    }

    public final /* bridge */ /* synthetic */ F4 q() {
        return super.q();
    }

    public final /* bridge */ /* synthetic */ C0838p5 r() {
        return super.r();
    }

    /* access modifiers changed from: protected */
    public final boolean x() {
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:57|58|59|60) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:72|73|74|75) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:44|45|46|47|145) */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        a().G().a("Failed to load event from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r12.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        a().G().a("Failed to load user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r12.recycle();
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        a().G().a("Failed to load conditional user property from local database");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r12.recycle();
        r0 = null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x00ae */
    /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00de */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x0115 */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01da A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01da A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x018c A[SYNTHETIC, Splitter:B:97:0x018c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List z(int r22) {
        /*
            r21 = this;
            r1 = r21
            java.lang.String r2 = "Error reading entries from local database"
            r1.k()
            boolean r0 = r1.f2974d
            r3 = 0
            if (r0 == 0) goto L_0x000d
            return r3
        L_0x000d:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r0 = r1.L()
            if (r0 != 0) goto L_0x001a
            goto L_0x0181
        L_0x001a:
            r5 = 5
            r6 = 0
            r7 = 0
            r8 = 5
        L_0x001e:
            if (r7 >= r5) goto L_0x01e9
            r9 = 1
            android.database.sqlite.SQLiteDatabase r10 = r1.K()     // Catch:{ SQLiteFullException -> 0x01c0, SQLiteDatabaseLockedException -> 0x01ad, SQLiteException -> 0x0187, all -> 0x0184 }
            if (r10 != 0) goto L_0x003a
            r1.f2974d = r9     // Catch:{ SQLiteFullException -> 0x0036, SQLiteDatabaseLockedException -> 0x0182, SQLiteException -> 0x0032, all -> 0x002f }
            if (r10 == 0) goto L_0x002e
            r10.close()
        L_0x002e:
            return r3
        L_0x002f:
            r0 = move-exception
            goto L_0x01de
        L_0x0032:
            r0 = move-exception
            r11 = r3
            goto L_0x018a
        L_0x0036:
            r0 = move-exception
            r11 = r3
            goto L_0x01c3
        L_0x003a:
            r10.beginTransaction()     // Catch:{ SQLiteFullException -> 0x0036, SQLiteDatabaseLockedException -> 0x0182, SQLiteException -> 0x0032, all -> 0x002f }
            long r11 = y(r10)     // Catch:{ SQLiteFullException -> 0x0036, SQLiteDatabaseLockedException -> 0x0182, SQLiteException -> 0x0032, all -> 0x002f }
            r19 = -1
            int r0 = (r11 > r19 ? 1 : (r11 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x0054
            java.lang.String r0 = "rowid<?"
            java.lang.String[] r13 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x0036, SQLiteDatabaseLockedException -> 0x0182, SQLiteException -> 0x0032, all -> 0x002f }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteFullException -> 0x0036, SQLiteDatabaseLockedException -> 0x0182, SQLiteException -> 0x0032, all -> 0x002f }
            r13[r6] = r11     // Catch:{ SQLiteFullException -> 0x0036, SQLiteDatabaseLockedException -> 0x0182, SQLiteException -> 0x0032, all -> 0x002f }
            r14 = r13
            r13 = r0
            goto L_0x0056
        L_0x0054:
            r13 = r3
            r14 = r13
        L_0x0056:
            java.lang.String r11 = "messages"
            java.lang.String r0 = "rowid"
            java.lang.String r12 = "type"
            java.lang.String r15 = "entry"
            java.lang.String[] r12 = new java.lang.String[]{r0, r12, r15}     // Catch:{ SQLiteFullException -> 0x0036, SQLiteDatabaseLockedException -> 0x0182, SQLiteException -> 0x0032, all -> 0x002f }
            java.lang.String r17 = "rowid asc"
            r0 = 100
            java.lang.String r18 = java.lang.Integer.toString(r0)     // Catch:{ SQLiteFullException -> 0x0036, SQLiteDatabaseLockedException -> 0x0182, SQLiteException -> 0x0032, all -> 0x002f }
            r15 = 0
            r16 = 0
            android.database.Cursor r11 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteFullException -> 0x0036, SQLiteDatabaseLockedException -> 0x0182, SQLiteException -> 0x0032, all -> 0x002f }
        L_0x0071:
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            if (r0 == 0) goto L_0x0152
            long r19 = r11.getLong(r6)     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            int r0 = r11.getInt(r9)     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            r12 = 2
            byte[] r13 = r11.getBlob(r12)     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            if (r0 != 0) goto L_0x00c3
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            int r0 = r13.length     // Catch:{ a -> 0x00ae }
            r12.unmarshall(r13, r6, r0)     // Catch:{ a -> 0x00ae }
            r12.setDataPosition(r6)     // Catch:{ a -> 0x00ae }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.E> r0 = com.google.android.gms.measurement.internal.E.CREATOR     // Catch:{ a -> 0x00ae }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ a -> 0x00ae }
            com.google.android.gms.measurement.internal.E r0 = (com.google.android.gms.measurement.internal.E) r0     // Catch:{ a -> 0x00ae }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            if (r0 == 0) goto L_0x0071
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            goto L_0x0071
        L_0x00a2:
            r0 = move-exception
            r3 = r11
            goto L_0x01de
        L_0x00a6:
            r0 = move-exception
            goto L_0x018a
        L_0x00a9:
            r0 = move-exception
            goto L_0x01c3
        L_0x00ac:
            r0 = move-exception
            goto L_0x00bf
        L_0x00ae:
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()     // Catch:{ all -> 0x00ac }
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()     // Catch:{ all -> 0x00ac }
            java.lang.String r13 = "Failed to load event from local database"
            r0.a(r13)     // Catch:{ all -> 0x00ac }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            goto L_0x0071
        L_0x00bf:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            throw r0     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
        L_0x00c3:
            if (r0 != r9) goto L_0x00fa
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            int r0 = r13.length     // Catch:{ a -> 0x00de }
            r12.unmarshall(r13, r6, r0)     // Catch:{ a -> 0x00de }
            r12.setDataPosition(r6)     // Catch:{ a -> 0x00de }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.Y5> r0 = com.google.android.gms.measurement.internal.Y5.CREATOR     // Catch:{ a -> 0x00de }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ a -> 0x00de }
            com.google.android.gms.measurement.internal.Y5 r0 = (com.google.android.gms.measurement.internal.Y5) r0     // Catch:{ a -> 0x00de }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            goto L_0x00ef
        L_0x00dc:
            r0 = move-exception
            goto L_0x00f6
        L_0x00de:
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()     // Catch:{ all -> 0x00dc }
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()     // Catch:{ all -> 0x00dc }
            java.lang.String r13 = "Failed to load user property from local database"
            r0.a(r13)     // Catch:{ all -> 0x00dc }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            r0 = r3
        L_0x00ef:
            if (r0 == 0) goto L_0x0071
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            goto L_0x0071
        L_0x00f6:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            throw r0     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
        L_0x00fa:
            if (r0 != r12) goto L_0x0131
            android.os.Parcel r12 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            int r0 = r13.length     // Catch:{ a -> 0x0115 }
            r12.unmarshall(r13, r6, r0)     // Catch:{ a -> 0x0115 }
            r12.setDataPosition(r6)     // Catch:{ a -> 0x0115 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.e> r0 = com.google.android.gms.measurement.internal.C0755e.CREATOR     // Catch:{ a -> 0x0115 }
            java.lang.Object r0 = r0.createFromParcel(r12)     // Catch:{ a -> 0x0115 }
            com.google.android.gms.measurement.internal.e r0 = (com.google.android.gms.measurement.internal.C0755e) r0     // Catch:{ a -> 0x0115 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            goto L_0x0126
        L_0x0113:
            r0 = move-exception
            goto L_0x012d
        L_0x0115:
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()     // Catch:{ all -> 0x0113 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()     // Catch:{ all -> 0x0113 }
            java.lang.String r13 = "Failed to load conditional user property from local database"
            r0.a(r13)     // Catch:{ all -> 0x0113 }
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            r0 = r3
        L_0x0126:
            if (r0 == 0) goto L_0x0071
            r4.add(r0)     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            goto L_0x0071
        L_0x012d:
            r12.recycle()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            throw r0     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
        L_0x0131:
            r12 = 3
            if (r0 != r12) goto L_0x0143
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.L()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            java.lang.String r12 = "Skipping app launch break"
            r0.a(r12)     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            goto L_0x0071
        L_0x0143:
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            java.lang.String r12 = "Unknown record type in local database"
            r0.a(r12)     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            goto L_0x0071
        L_0x0152:
            java.lang.String r0 = "messages"
            java.lang.String r12 = "rowid <= ?"
            java.lang.String r13 = java.lang.Long.toString(r19)     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            java.lang.String[] r13 = new java.lang.String[]{r13}     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            int r0 = r10.delete(r0, r12, r13)     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            int r12 = r4.size()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            if (r0 >= r12) goto L_0x0175
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            com.google.android.gms.measurement.internal.p2 r0 = r0.G()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            java.lang.String r12 = "Fewer entries removed from local database than expected"
            r0.a(r12)     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
        L_0x0175:
            r10.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            r10.endTransaction()     // Catch:{ SQLiteFullException -> 0x00a9, SQLiteDatabaseLockedException -> 0x01af, SQLiteException -> 0x00a6 }
            r11.close()
            r10.close()
        L_0x0181:
            return r4
        L_0x0182:
            r11 = r3
            goto L_0x01af
        L_0x0184:
            r0 = move-exception
            r10 = r3
            goto L_0x01de
        L_0x0187:
            r0 = move-exception
            r10 = r3
            r11 = r10
        L_0x018a:
            if (r10 == 0) goto L_0x0195
            boolean r12 = r10.inTransaction()     // Catch:{ all -> 0x00a2 }
            if (r12 == 0) goto L_0x0195
            r10.endTransaction()     // Catch:{ all -> 0x00a2 }
        L_0x0195:
            com.google.android.gms.measurement.internal.n2 r12 = r1.a()     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.measurement.internal.p2 r12 = r12.G()     // Catch:{ all -> 0x00a2 }
            r12.b(r2, r0)     // Catch:{ all -> 0x00a2 }
            r1.f2974d = r9     // Catch:{ all -> 0x00a2 }
            if (r11 == 0) goto L_0x01a7
            r11.close()
        L_0x01a7:
            if (r10 == 0) goto L_0x01da
            r10.close()
            goto L_0x01da
        L_0x01ad:
            r10 = r3
            r11 = r10
        L_0x01af:
            long r12 = (long) r8
            android.os.SystemClock.sleep(r12)     // Catch:{ all -> 0x00a2 }
            int r8 = r8 + 20
            if (r11 == 0) goto L_0x01ba
            r11.close()
        L_0x01ba:
            if (r10 == 0) goto L_0x01da
            r10.close()
            goto L_0x01da
        L_0x01c0:
            r0 = move-exception
            r10 = r3
            r11 = r10
        L_0x01c3:
            com.google.android.gms.measurement.internal.n2 r12 = r1.a()     // Catch:{ all -> 0x00a2 }
            com.google.android.gms.measurement.internal.p2 r12 = r12.G()     // Catch:{ all -> 0x00a2 }
            r12.b(r2, r0)     // Catch:{ all -> 0x00a2 }
            r1.f2974d = r9     // Catch:{ all -> 0x00a2 }
            if (r11 == 0) goto L_0x01d5
            r11.close()
        L_0x01d5:
            if (r10 == 0) goto L_0x01da
            r10.close()
        L_0x01da:
            int r7 = r7 + 1
            goto L_0x001e
        L_0x01de:
            if (r3 == 0) goto L_0x01e3
            r3.close()
        L_0x01e3:
            if (r10 == 0) goto L_0x01e8
            r10.close()
        L_0x01e8:
            throw r0
        L_0x01e9:
            com.google.android.gms.measurement.internal.n2 r0 = r1.a()
            com.google.android.gms.measurement.internal.p2 r0 = r0.L()
            java.lang.String r2 = "Failed to read events from database in reasonable time"
            r0.a(r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.C0765f2.z(int):java.util.List");
    }
}
