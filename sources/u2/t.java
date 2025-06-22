package u2;

import R2.s;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import g2.C2034B;
import g2.C2039G;
import g2.C2040H;
import g2.C2041I;
import g2.C2043a;
import g2.C2044b;
import g2.C2048f;
import g2.C2054l;
import g2.C2060s;
import g2.C2061t;
import g2.C2063v;
import g2.M;
import g2.S;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class t extends SQLiteOpenHelper {

    /* renamed from: u  reason: collision with root package name */
    public static final a f21927u = new a((C2103g) null);
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public static t f21928v;

    /* renamed from: a  reason: collision with root package name */
    private SQLiteDatabase f21929a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f21930b = {"id", RewardPlus.NAME, "packagename", "versionCode", "issystemapp", "isSystemService", "urlFicha", "md5signature", "exclude", "size", "excludeFromTracking", "defaultName", "sha256", "positiveNotified", "appID", "hasOldVersions", "trackInfoRegistered"};

    /* renamed from: c  reason: collision with root package name */
    private final String[] f21931c = {"id", MBridgeConstans.APP_ID, "sha256", "size", MBridgeConstans.DYNAMIC_VIEW_WX_PATH};

    /* renamed from: d  reason: collision with root package name */
    private final String[] f21932d = {"id", "packagename", "versionCode", "versionName", "notified", "ignoreVersion", "newFeatures", "installationAttempts"};

    /* renamed from: e  reason: collision with root package name */
    private final String[] f21933e = {"id", "packagename", "checked", "incomplete", "versioncode", "attempts", "idPrograma", "downloadAnyway", "md5signature", "supportedAbis", "minsdk", "urlIcon", "appName", "nextAttemptTimeStamp", "updateId"};

    /* renamed from: f  reason: collision with root package name */
    private final String[] f21934f = {"id", "downloadId", "fileId", "type", "size", "size_downloaded", "filehash", "absolutePath", "attempts", "nextAttemptTimeStamp"};

    /* renamed from: g  reason: collision with root package name */
    private final String[] f21935g = {"search", CampaignEx.JSON_KEY_TIMESTAMP};

    /* renamed from: h  reason: collision with root package name */
    private final String[] f21936h = {"id", MBridgeConstans.DYNAMIC_VIEW_WX_PATH};

    /* renamed from: i  reason: collision with root package name */
    private final String[] f21937i = {"id", CampaignEx.JSON_KEY_TIMESTAMP, CampaignEx.JSON_KEY_TITLE, NotificationCompat.CATEGORY_MESSAGE, "actions", "extra_info"};

    /* renamed from: j  reason: collision with root package name */
    private final String[] f21938j = {"appId", "automaticDownload"};

    /* renamed from: k  reason: collision with root package name */
    private final String[] f21939k = {"appId"};

    /* renamed from: l  reason: collision with root package name */
    private final String[] f21940l = {MBridgeConstans.DYNAMIC_VIEW_WX_PATH, "date"};

    /* renamed from: m  reason: collision with root package name */
    private final String[] f21941m = {"id", "notificationId", "packagename", "versioncode", "type"};

    /* renamed from: n  reason: collision with root package name */
    private final String[] f21942n = {"id", "type", "packagename", "versionname_old", "versionname_new", "versioncode_old", "versioncode_new", "size", CampaignEx.JSON_KEY_TIMESTAMP};

    /* renamed from: o  reason: collision with root package name */
    private final String[] f21943o = {"id", "type", "json", CampaignEx.JSON_KEY_TIMESTAMP};

    /* renamed from: p  reason: collision with root package name */
    private final String[] f21944p = {"id", "json", CampaignEx.JSON_KEY_TIMESTAMP};

    /* renamed from: q  reason: collision with root package name */
    private final String[] f21945q = {"id", "json", CampaignEx.JSON_KEY_TIMESTAMP};

    /* renamed from: r  reason: collision with root package name */
    private final String[] f21946r = {RewardPlus.NAME};

    /* renamed from: s  reason: collision with root package name */
    private final String[] f21947s = {"id", "appId", "sourceDeviceName", "downloadId"};

    /* renamed from: t  reason: collision with root package name */
    private final AtomicInteger f21948t = new AtomicInteger();

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final synchronized t a(Context context) {
            t d5;
            try {
                m.e(context, "context");
                if (t.f21928v == null) {
                    t.f21928v = new t(context.getApplicationContext());
                }
                d5 = t.f21928v;
                m.b(d5);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
            return d5;
        }

        private a() {
        }
    }

    public t(Context context) {
        super(context, "Uptodown.db", (SQLiteDatabase.CursorFactory) null, 670);
    }

    private final int D(int i4) {
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("download_files", "downloadId=?", new String[]{String.valueOf(i4)});
    }

    private final s G0() {
        this.f21929a = getWritableDatabase();
        return s.f8222a;
    }

    private final void N0(C2060s.c cVar, long j4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("downloadId", Long.valueOf(j4));
        contentValues.put("fileId", Long.valueOf(cVar.d()));
        contentValues.put("size", Long.valueOf(cVar.i()));
        contentValues.put("size_downloaded", Long.valueOf(cVar.h()));
        contentValues.put("filehash", cVar.e());
        contentValues.put("absolutePath", cVar.a());
        contentValues.put("attempts", Integer.valueOf(cVar.b()));
        contentValues.put("nextAttemptTimeStamp", Long.valueOf(cVar.g()));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.insert("download_files", (String) null, contentValues);
    }

    private final void O(int i4) {
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.delete("download_required_features", "downloadId=?", new String[]{String.valueOf(i4)});
    }

    private final void P(S s4) {
        if (s4.a() != null) {
            C2060s a5 = s4.a();
            m.b(a5);
            if (a5.q() >= 0) {
                C2060s a6 = s4.a();
                m.b(a6);
                O(a6.q());
            }
        }
    }

    private final void T(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS updates");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS apps");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS app_files");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_files");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS recent_searches");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS installable_files");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS notifications");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS deep_link_files");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS active_notifications");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS activity_log");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS responses");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preregistrations");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS preregistrations_to_notify");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS errors");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_required_features");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS remote_installs");
    }

    private final C2043a Z0(Cursor cursor) {
        int i4 = cursor.getInt(0);
        int i5 = cursor.getInt(1);
        String string = cursor.getString(2);
        String string2 = cursor.getString(3);
        m.b(string);
        m.b(string2);
        C2043a aVar = new C2043a(string, Long.parseLong(string2));
        aVar.i(i4);
        aVar.h(i5);
        aVar.j(C2043a.f20521f.a(cursor.getInt(4)));
        return aVar;
    }

    private final C2048f a1(Cursor cursor) {
        C2048f fVar = new C2048f();
        fVar.S(cursor.getLong(0));
        fVar.V(cursor.getString(1));
        fVar.W(cursor.getString(2));
        String string = cursor.getString(3);
        m.d(string, "getString(...)");
        fVar.h0(Long.parseLong(string));
        fVar.d0(cursor.getInt(4));
        fVar.e0(cursor.getInt(5));
        fVar.g0(cursor.getString(6));
        fVar.U(cursor.getString(7));
        fVar.N(cursor.getInt(8));
        String string2 = cursor.getString(9);
        m.d(string2, "getString(...)");
        fVar.b0(Long.parseLong(string2));
        fVar.O(cursor.getInt(10));
        fVar.L(cursor.getString(11));
        fVar.Z(cursor.getString(12));
        fVar.Y(cursor.getInt(13));
        fVar.K(cursor.getLong(14));
        fVar.R(cursor.getInt(15));
        fVar.f0(cursor.getInt(16));
        return fVar;
    }

    private final C2063v b1(Cursor cursor) {
        cursor.getInt(0);
        cursor.getInt(1);
        C2063v vVar = new C2063v();
        vVar.f(cursor.getString(2));
        String string = cursor.getString(3);
        m.d(string, "getString(...)");
        vVar.g(Long.parseLong(string));
        vVar.e(cursor.getString(4));
        return vVar;
    }

    private final C2060s c1(Cursor cursor) {
        C2060s sVar = new C2060s();
        sVar.P(cursor);
        return sVar;
    }

    private final C2060s.c d1(Cursor cursor) {
        C2060s.c cVar = new C2060s.c();
        cVar.j(cursor);
        return cVar;
    }

    private final C2061t e1(Cursor cursor) {
        C2061t tVar = new C2061t();
        tVar.d(cursor.getLong(0));
        tVar.e(cursor.getString(1));
        tVar.f(cursor.getLong(2));
        return tVar;
    }

    private final C2040H f1(Cursor cursor) {
        C2040H h4 = new C2040H();
        h4.c(cursor.getString(0));
        h4.d(cursor.getString(1));
        return h4;
    }

    private final M g1(Cursor cursor) {
        int i4 = cursor.getInt(0);
        String string = cursor.getString(1);
        String string2 = cursor.getString(2);
        String string3 = cursor.getString(3);
        m.b(string);
        m.b(string2);
        M m4 = new M(string, string2);
        m4.g(i4);
        m.b(string3);
        m4.h(Long.parseLong(string3));
        return m4;
    }

    private final S h1(Cursor cursor) {
        long j4 = cursor.getLong(0);
        String string = cursor.getString(1);
        m.b(string);
        S s4 = new S(string);
        s4.o(j4);
        String string2 = cursor.getString(2);
        m.d(string2, "getString(...)");
        s4.t(Long.parseLong(string2));
        s4.u(cursor.getString(3));
        s4.r(cursor.getInt(4));
        s4.p(cursor.getInt(5));
        s4.q(cursor.getString(6));
        return s4;
    }

    private final C2060s j0(long j4) {
        Exception exc;
        Cursor cursor;
        C2060s sVar;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("downloads", this.f21933e, "updateId=?", new String[]{String.valueOf(j4)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    m.b(cursor);
                    sVar = c1(cursor);
                } else {
                    sVar = null;
                }
                cursor.close();
                if (sVar != null && sVar.q() >= 0) {
                    sVar.X(l0(sVar.q()));
                }
                return sVar;
            } catch (Exception e5) {
                exc = e5;
                exc.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return null;
            }
        } catch (Exception e6) {
            exc = e6;
            cursor = null;
            exc.printStackTrace();
            cursor.close();
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: g2.s$c} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final g2.C2060s.c k0(java.lang.String r12) {
        /*
            r11 = this;
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r11.f21929a     // Catch:{ Exception -> 0x002e }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x002e }
            java.lang.String r3 = "download_files"
            java.lang.String[] r4 = r11.f21934f     // Catch:{ Exception -> 0x002e }
            java.lang.String r5 = "fileId=?"
            java.lang.String[] r6 = new java.lang.String[]{r12}     // Catch:{ Exception -> 0x002e }
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x002e }
            boolean r0 = r12.moveToFirst()     // Catch:{ Exception -> 0x0025 }
            if (r0 == 0) goto L_0x002a
            kotlin.jvm.internal.m.b(r12)     // Catch:{ Exception -> 0x0025 }
            g2.s$c r1 = r11.d1(r12)     // Catch:{ Exception -> 0x0025 }
            goto L_0x002a
        L_0x0025:
            r0 = move-exception
            r10 = r1
            r1 = r12
            r12 = r10
            goto L_0x0030
        L_0x002a:
            r12.close()     // Catch:{ Exception -> 0x0025 }
            return r1
        L_0x002e:
            r0 = move-exception
            r12 = r1
        L_0x0030:
            r0.printStackTrace()
            if (r1 == 0) goto L_0x003e
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L_0x003e
            r1.close()
        L_0x003e:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.t.k0(java.lang.String):g2.s$c");
    }

    private final void l(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS updates(id integer primary key autoincrement, packagename text, versionCode text, versionName text, notified integer default 0, ignoreVersion integer default 0, newFeatures text, installationAttempts integer default 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS apps( id integer primary key autoincrement, name text, packagename text, versionCode text, issystemapp integer default 0, isSystemService integer default 0, urlFicha text, md5signature text, exclude integer default 0, size text, excludeFromTracking integer default 0, defaultName text, sha256 text, positiveNotified integer default 0, appID integer default 0, hasOldVersions integer default 0, trackInfoRegistered integer default 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS app_files( id integer primary key autoincrement, app_id integer, sha256 text, size text, path text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS downloads(id integer primary key autoincrement, packagename text, checked integer default 0, incomplete integer default 0, versioncode integer default 0, attempts integer default 0, idPrograma integer default 0, downloadAnyway integer default 0, md5signature text, supportedAbis text, minsdk integer default 0, urlIcon text, appName text, nextAttemptTimeStamp integer default 0, updateId integer default 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_files(id integer primary key autoincrement, downloadId integer default 0, fileId integer default 0, type text, size integer default 0, size_downloaded integer default 0, filehash text, absolutePath text, attempts integer default 0, nextAttemptTimeStamp integer default 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS recent_searches(id integer primary key autoincrement, search text unique, timestamp text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS installable_files(id integer primary key autoincrement, path text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS notifications(id integer primary key autoincrement, timestamp text, title text, msg text, actions text, extra_info text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS deep_link_files(id integer primary key autoincrement, path text, date text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS active_notifications(id integer primary key autoincrement, notificationId integer, packagename text, versioncode integer, type integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS activity_log(id integer primary key autoincrement, type integer, packagename text, versionname_old text, versionname_new text, versioncode_old text, versioncode_new text, size text, timestamp text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS responses(id integer primary key autoincrement, type integer, json text, timestamp text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events(id integer primary key autoincrement, json text, timestamp integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preregistrations(id integer primary key autoincrement, appId integer, automaticDownload integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS preregistrations_to_notify(id integer primary key autoincrement, appId integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS errors(id integer primary key autoincrement, json text, timestamp integer);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_required_features(id integer primary key autoincrement, name text, downloadId text);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS remote_installs(id integer primary key autoincrement, appId integer, sourceDeviceName text, downloadId integer);");
    }

    private final ArrayList l0(int i4) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("download_files", this.f21934f, "downloadId=?", new String[]{String.valueOf(i4)}, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                m.b(query);
                arrayList.add(d1(query));
            }
            while (query.moveToNext()) {
                m.b(query);
                arrayList.add(d1(query));
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    private final void p() {
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.delete("download_required_features", (String) null, (String[]) null);
    }

    public final int A(String str) {
        m.e(str, RewardPlus.NAME);
        Iterator it = m0().iterator();
        m.d(it, "iterator(...)");
        C2060s sVar = null;
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            C2060s sVar2 = (C2060s) next;
            Iterator it2 = sVar2.o().iterator();
            m.d(it2, "iterator(...)");
            while (it2.hasNext()) {
                Object next2 = it2.next();
                m.d(next2, "next(...)");
                C2060s.c cVar = (C2060s.c) next2;
                if (cVar.a() != null) {
                    String a5 = cVar.a();
                    m.b(a5);
                    if (m3.m.p(new File(a5).getName(), str, true)) {
                        sVar = sVar2;
                    }
                }
            }
        }
        return z(sVar);
    }

    public final ArrayList A0() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        Cursor query = sQLiteDatabase.query("remote_installs", this.f21947s, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        m.d(query, "query(...)");
        if (query.moveToFirst()) {
            C2041I i4 = new C2041I();
            i4.e(query);
            arrayList.add(i4);
            while (query.moveToNext()) {
                C2041I i5 = new C2041I();
                i5.e(query);
                arrayList.add(i5);
            }
        }
        query.close();
        return arrayList;
    }

    public final int A1(C2041I i4) {
        m.e(i4, "remoteInstall");
        ContentValues contentValues = new ContentValues();
        contentValues.put("downloadId", Integer.valueOf(i4.b()));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.update("remote_installs", contentValues, "appId=?", new String[]{String.valueOf(i4.a())});
    }

    public final ArrayList B0(long j4) {
        String[] strArr = {String.valueOf(j4)};
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        Cursor query = sQLiteDatabase.query("remote_installs", this.f21947s, "appId=?", strArr, (String) null, (String) null, (String) null);
        m.d(query, "query(...)");
        if (query.moveToFirst()) {
            C2041I i4 = new C2041I();
            i4.e(query);
            arrayList.add(i4);
            while (query.moveToNext()) {
                C2041I i5 = new C2041I();
                i5.e(query);
                arrayList.add(i5);
            }
        }
        query.close();
        return arrayList;
    }

    public final void B1(String str, long j4, int i4) {
        m.e(str, "packagename");
        ContentValues contentValues = new ContentValues();
        contentValues.put("appID", Long.valueOf(j4));
        contentValues.put("hasOldVersions", Integer.valueOf(i4));
        contentValues.put("trackInfoRegistered", 1);
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.update("apps", contentValues, "packagename=?", new String[]{str});
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: g2.M} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final g2.M C0(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r0 = "type"
            kotlin.jvm.internal.m.e(r12, r0)
            r1 = 0
            java.lang.String[] r6 = new java.lang.String[]{r12}     // Catch:{ Exception -> 0x0033 }
            android.database.sqlite.SQLiteDatabase r2 = r11.f21929a     // Catch:{ Exception -> 0x0033 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0033 }
            java.lang.String r3 = "responses"
            java.lang.String[] r4 = r11.f21943o     // Catch:{ Exception -> 0x0033 }
            java.lang.String r5 = "type=?"
            r8 = 0
            r9 = 0
            r7 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0033 }
            boolean r0 = r12.moveToFirst()     // Catch:{ Exception -> 0x002a }
            if (r0 == 0) goto L_0x002f
            kotlin.jvm.internal.m.b(r12)     // Catch:{ Exception -> 0x002a }
            g2.M r1 = r11.g1(r12)     // Catch:{ Exception -> 0x002a }
            goto L_0x002f
        L_0x002a:
            r0 = move-exception
            r10 = r1
            r1 = r12
            r12 = r10
            goto L_0x0035
        L_0x002f:
            r12.close()     // Catch:{ Exception -> 0x002a }
            return r1
        L_0x0033:
            r0 = move-exception
            r12 = r1
        L_0x0035:
            r0.printStackTrace()
            if (r1 == 0) goto L_0x0043
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L_0x0043
            r1.close()
        L_0x0043:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.t.C0(java.lang.String):g2.M");
    }

    public final S D0(String str) {
        Cursor cursor;
        S s4;
        m.e(str, "packagename");
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("updates", this.f21932d, "packagename=?", new String[]{str}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    m.b(cursor);
                    s4 = h1(cursor);
                    s4.n(j0(s4.d()));
                    s4.s(E0(s4.a()));
                } else {
                    s4 = null;
                }
                cursor.close();
                return s4;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
            e.printStackTrace();
            cursor.close();
            return null;
        }
    }

    public final int E(long j4) {
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("events", "id=?", new String[]{String.valueOf(j4)});
    }

    public final ArrayList E0(C2060s sVar) {
        ArrayList arrayList = new ArrayList();
        if (sVar != null) {
            Cursor cursor = null;
            try {
                if (sVar.q() >= 0) {
                    SQLiteDatabase sQLiteDatabase = this.f21929a;
                    m.b(sQLiteDatabase);
                    Cursor query = sQLiteDatabase.query("download_required_features", this.f21946r, "downloadId=?", new String[]{String.valueOf(sVar.q())}, (String) null, (String) null, (String) null);
                    if (query.moveToFirst()) {
                        arrayList.add(query.getString(0));
                        while (query.moveToNext()) {
                            arrayList.add(query.getString(0));
                        }
                    }
                    query.close();
                    return arrayList;
                }
            } catch (Exception e5) {
                e5.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
        return arrayList;
    }

    public final int F(long j4) {
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("errors", "id=?", new String[]{String.valueOf(j4)});
    }

    public final ArrayList F0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("updates", this.f21932d, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                m.b(query);
                S h12 = h1(query);
                arrayList.add(h12);
                h12.n(j0(h12.d()));
                h12.s(E0(h12.a()));
            }
            while (query.moveToNext()) {
                m.b(query);
                S h13 = h1(query);
                arrayList.add(h13);
                h13.n(j0(h13.d()));
                h13.s(E0(h13.a()));
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final int G(String str) {
        m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("installable_files", "path=?", new String[]{str});
    }

    public final int H(int i4) {
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("notifications", "id=?", new String[]{String.valueOf(i4)});
    }

    public final void H0(C2043a aVar) {
        m.e(aVar, "activeNotification");
        ContentValues contentValues = new ContentValues();
        contentValues.put("notificationId", Integer.valueOf(aVar.a()));
        contentValues.put("packagename", aVar.c());
        contentValues.put("versioncode", Long.valueOf(aVar.e()));
        contentValues.put("type", Integer.valueOf(aVar.d().ordinal()));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.insert("active_notifications", (String) null, contentValues);
    }

    public final int I() {
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("events", "timestamp < ?", new String[]{String.valueOf(System.currentTimeMillis() - 2592000000L)});
    }

    public final void I0(C2044b bVar) {
        m.e(bVar, "activityLog");
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(bVar.d()));
        contentValues.put("packagename", bVar.a());
        contentValues.put("versioncode_old", bVar.g());
        contentValues.put("versioncode_new", bVar.f());
        contentValues.put("versionname_old", bVar.i());
        contentValues.put("versionname_new", bVar.h());
        contentValues.put("size", bVar.b());
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, bVar.c());
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.insert("activity_log", (String) null, contentValues);
    }

    public final int J() {
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("errors", "timestamp < ?", new String[]{String.valueOf(System.currentTimeMillis() - 2592000000L)});
    }

    public final C2048f J0(C2048f fVar) {
        m.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        ContentValues contentValues = new ContentValues();
        contentValues.put(RewardPlus.NAME, fVar.m());
        contentValues.put("packagename", fVar.o());
        contentValues.put("versionCode", Long.valueOf(fVar.A()));
        contentValues.put("issystemapp", Integer.valueOf(fVar.E()));
        contentValues.put("isSystemService", Integer.valueOf(fVar.G()));
        contentValues.put("urlFicha", fVar.z());
        contentValues.put("md5signature", fVar.k());
        contentValues.put("exclude", Integer.valueOf(fVar.e()));
        contentValues.put("size", String.valueOf(fVar.t()));
        contentValues.put("excludeFromTracking", Integer.valueOf(fVar.f()));
        contentValues.put("defaultName", fVar.c());
        contentValues.put("sha256", fVar.r());
        contentValues.put("positiveNotified", Integer.valueOf(fVar.q()));
        contentValues.put("appID", Long.valueOf(fVar.b()));
        contentValues.put("hasOldVersions", Integer.valueOf(fVar.h()));
        if (fVar.y() >= 0) {
            contentValues.put("trackInfoRegistered", Integer.valueOf(fVar.y()));
        }
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        fVar.S(sQLiteDatabase.insert("apps", (String) null, contentValues));
        return fVar;
    }

    public final int K(int i4) {
        int t02 = t0(i4);
        if (t02 <= 0) {
            return 0;
        }
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("notifications", "id<=?", new String[]{String.valueOf(t02)});
    }

    public final long K0(long j4, C2063v vVar) {
        m.e(vVar, "appFile");
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, String.valueOf(j4));
        contentValues.put("sha256", vVar.c());
        contentValues.put("size", String.valueOf(vVar.d()));
        contentValues.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, vVar.a());
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.insert("app_files", (String) null, contentValues);
    }

    public final int L(String str) {
        m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("recent_searches", "search=?", new String[]{str});
    }

    public final void L0(C2054l lVar) {
        m.e(lVar, "deepLink");
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, lVar.e());
        contentValues.put("date", lVar.a());
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.insert("deep_link_files", (String) null, contentValues);
    }

    public final void M(long j4) {
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.delete("remote_installs", "appId=?", new String[]{String.valueOf(j4)});
    }

    public final C2060s M0(C2060s sVar) {
        m.e(sVar, "download");
        ContentValues contentValues = new ContentValues();
        contentValues.put("packagename", sVar.w());
        contentValues.put("checked", Integer.valueOf(sVar.k()));
        contentValues.put("incomplete", Integer.valueOf(sVar.r()));
        contentValues.put("versioncode", Long.valueOf(sVar.E()));
        contentValues.put("attempts", Integer.valueOf(sVar.j()));
        contentValues.put("idPrograma", Long.valueOf(sVar.h()));
        contentValues.put("downloadAnyway", Integer.valueOf(sVar.l()));
        contentValues.put("md5signature", sVar.t());
        contentValues.put("supportedAbis", sVar.A());
        contentValues.put("minsdk", Integer.valueOf(sVar.u()));
        contentValues.put("urlIcon", sVar.D());
        contentValues.put("appName", sVar.i());
        contentValues.put("nextAttemptTimeStamp", Long.valueOf(sVar.v()));
        contentValues.put("updateId", Long.valueOf(sVar.C()));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        long insert = sQLiteDatabase.insert("downloads", (String) null, contentValues);
        sVar.Y((int) insert);
        Iterator it = sVar.o().iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            N0((C2060s.c) next, insert);
        }
        return sVar;
    }

    public final void N(int i4) {
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.delete("remote_installs", "downloadId=?", new String[]{String.valueOf(i4)});
    }

    public final void O0(C2061t tVar) {
        m.e(tVar, NotificationCompat.CATEGORY_EVENT);
        ContentValues contentValues = new ContentValues();
        contentValues.put("json", tVar.b());
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(tVar.c()));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.insert("events", (String) null, contentValues);
    }

    public final void P0(C2061t tVar) {
        m.e(tVar, NotificationCompat.CATEGORY_EVENT);
        ContentValues contentValues = new ContentValues();
        contentValues.put("json", tVar.b());
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(tVar.c()));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.insert("errors", (String) null, contentValues);
    }

    public final int Q(String str) {
        m.e(str, "type");
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("responses", "type=?", new String[]{str});
    }

    public final void Q0(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, str);
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.insert("installable_files", (String) null, contentValues);
    }

    public final int R(String str) {
        m.e(str, "packagename");
        String[] strArr = {str};
        S D02 = D0(str);
        if (D02 != null) {
            P(D02);
        }
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("updates", "packagename=?", strArr);
    }

    public final void R0(C2034B b5) {
        m.e(b5, "notificationRegistry");
        ContentValues contentValues = new ContentValues();
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, b5.e());
        contentValues.put(CampaignEx.JSON_KEY_TITLE, b5.f());
        contentValues.put(NotificationCompat.CATEGORY_MESSAGE, b5.d());
        contentValues.put("actions", b5.a());
        contentValues.put("extra_info", b5.b());
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.insert("notifications", (String) null, contentValues);
    }

    public final void S() {
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.delete("updates", (String) null, (String[]) null);
        p();
    }

    public final void S0(C2039G g4) {
        m.e(g4, "preRegister");
        ContentValues contentValues = new ContentValues();
        contentValues.put("appId", Long.valueOf(g4.c()));
        contentValues.put("automaticDownload", Integer.valueOf(g4.d()));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.insert("preregistrations", (String) null, contentValues);
    }

    public final void T0(C2039G g4) {
        m.e(g4, "preRegister");
        ContentValues contentValues = new ContentValues();
        contentValues.put("appId", Long.valueOf(g4.c()));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.insert("preregistrations_to_notify", (String) null, contentValues);
    }

    public final C2043a U(int i4) {
        Cursor cursor;
        C2043a aVar;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("active_notifications", this.f21941m, "notificationId=?", new String[]{String.valueOf(i4)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    m.b(cursor);
                    aVar = Z0(cursor);
                } else {
                    aVar = null;
                }
                cursor.close();
                return aVar;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                cursor.close();
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final void U0(C2040H h4) {
        m.e(h4, "recentSearch");
        ContentValues contentValues = new ContentValues();
        contentValues.put("search", h4.a());
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, h4.b());
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.insert("recent_searches", (String) null, contentValues);
    }

    public final C2043a V(String str, long j4) {
        Exception exc;
        Cursor cursor;
        C2043a aVar;
        m.e(str, "packageName");
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("active_notifications", this.f21941m, "packagename=? AND versioncode=?", new String[]{str, String.valueOf(j4)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    m.b(cursor);
                    aVar = Z0(cursor);
                } else {
                    aVar = null;
                }
                cursor.close();
                return aVar;
            } catch (Exception e5) {
                exc = e5;
                exc.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return null;
            }
        } catch (Exception e6) {
            exc = e6;
            cursor = null;
            exc.printStackTrace();
            cursor.close();
            return null;
        }
    }

    public final void V0(C2041I i4) {
        m.e(i4, "remoteInstall");
        ContentValues contentValues = new ContentValues();
        contentValues.put("appId", Long.valueOf(i4.a()));
        contentValues.put("sourceDeviceName", i4.c());
        contentValues.put("downloadId", Integer.valueOf(i4.b()));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.insert("remote_installs", (String) null, contentValues);
    }

    public final C2043a W(int i4) {
        Cursor cursor;
        C2043a aVar;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("active_notifications", this.f21941m, "id=?", new String[]{String.valueOf(i4)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    m.b(cursor);
                    aVar = Z0(cursor);
                } else {
                    aVar = null;
                }
                cursor.close();
                return aVar;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                cursor.close();
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final void W0(M m4) {
        m.e(m4, "response");
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", m4.e());
        contentValues.put("json", m4.b());
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, String.valueOf(m4.d()));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.insert("responses", (String) null, contentValues);
    }

    public final ArrayList X() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("active_notifications", this.f21941m, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                m.b(query);
                arrayList.add(Z0(query));
                while (query.moveToNext()) {
                    m.b(query);
                    arrayList.add(Z0(query));
                }
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final void X0(S s4) {
        m.e(s4, "update");
        if (s4.a() != null) {
            C2060s a5 = s4.a();
            m.b(a5);
            s4.n(M0(a5));
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("packagename", s4.h());
        contentValues.put("versionCode", Long.valueOf(s4.j()));
        contentValues.put("versionName", s4.k());
        contentValues.put("notified", Integer.valueOf(s4.g()));
        contentValues.put("ignoreVersion", Integer.valueOf(s4.e()));
        contentValues.put("newFeatures", s4.f());
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        long insert = sQLiteDatabase.insert("updates", (String) null, contentValues);
        if (s4.a() == null) {
            return;
        }
        if (insert >= 0) {
            C2060s a6 = s4.a();
            m.b(a6);
            a6.a0(insert);
            Y0(s4);
            C2060s a7 = s4.a();
            m.b(a7);
            w1(a7);
            return;
        }
        C2060s a8 = s4.a();
        m.b(a8);
        z(a8);
    }

    public final C2048f Y(String str) {
        Cursor cursor;
        C2048f fVar;
        m.e(str, "packagename");
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("apps", this.f21930b, "packagename=?", new String[]{str}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    m.b(cursor);
                    fVar = a1(cursor);
                } else {
                    fVar = null;
                }
                cursor.close();
                return fVar;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                cursor.close();
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
            e.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return null;
        }
    }

    public final void Y0(S s4) {
        m.e(s4, "update");
        ArrayList i4 = s4.i();
        if (i4 != null && !i4.isEmpty() && s4.a() != null) {
            C2060s a5 = s4.a();
            m.b(a5);
            if (a5.q() >= 0) {
                ArrayList i5 = s4.i();
                m.b(i5);
                Iterator it = i5.iterator();
                m.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(RewardPlus.NAME, (String) next);
                    C2060s a6 = s4.a();
                    m.b(a6);
                    contentValues.put("downloadId", Integer.valueOf(a6.q()));
                    SQLiteDatabase sQLiteDatabase = this.f21929a;
                    m.b(sQLiteDatabase);
                    sQLiteDatabase.insert("download_required_features", (String) null, contentValues);
                }
            }
        }
    }

    public final ArrayList Z(long j4) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("app_files", this.f21931c, "app_id=?", new String[]{String.valueOf(j4)}, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                m.b(query);
                arrayList.add(b1(query));
                while (query.moveToNext()) {
                    m.b(query);
                    arrayList.add(b1(query));
                }
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final synchronized void a() {
        if (this.f21948t.incrementAndGet() == 1) {
            t tVar = f21928v;
            m.b(tVar);
            tVar.G0();
        }
    }

    public final ArrayList a0(C2048f fVar) {
        m.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        if (fVar.i() >= 0) {
            return Z(fVar.i());
        }
        if (fVar.o() == null) {
            return null;
        }
        String o4 = fVar.o();
        m.b(o4);
        C2048f Y4 = Y(o4);
        if (Y4 != null) {
            return Z(Y4.i());
        }
        return null;
    }

    public final ArrayList b0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("apps", this.f21930b, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                m.b(query);
                arrayList.add(a1(query));
                while (query.moveToNext()) {
                    m.b(query);
                    arrayList.add(a1(query));
                }
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final ArrayList c0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("deep_link_files", this.f21940l, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                C2054l lVar = new C2054l();
                lVar.h(query.getString(0));
                lVar.f(query.getString(1));
                arrayList.add(lVar);
            }
            while (query.moveToNext()) {
                C2054l lVar2 = new C2054l();
                lVar2.h(query.getString(0));
                lVar2.f(query.getString(1));
                arrayList.add(lVar2);
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final C2060s d0(String str) {
        m.e(str, "filename");
        Iterator it = m0().iterator();
        m.d(it, "iterator(...)");
        C2060s sVar = null;
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            C2060s sVar2 = (C2060s) next;
            Iterator it2 = sVar2.o().iterator();
            m.d(it2, "iterator(...)");
            while (it2.hasNext()) {
                Object next2 = it2.next();
                m.d(next2, "next(...)");
                C2060s.c cVar = (C2060s.c) next2;
                if (cVar.a() != null) {
                    String a5 = cVar.a();
                    m.b(a5);
                    if (m3.m.p(new File(a5).getName(), str, true)) {
                        sVar = sVar2;
                    }
                }
            }
        }
        return sVar;
    }

    public final C2060s e0(String str) {
        String a5;
        m.e(str, "absolutePath");
        ArrayList m02 = m0();
        Iterator it = m02.iterator();
        m.d(it, "iterator(...)");
        C2060s sVar = null;
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            C2060s sVar2 = (C2060s) next;
            Iterator it2 = sVar2.o().iterator();
            m.d(it2, "iterator(...)");
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                m.d(next2, "next(...)");
                C2060s.c cVar = (C2060s.c) next2;
                if (cVar.a() != null && m3.m.p(cVar.a(), str, true)) {
                    sVar = sVar2;
                    break;
                }
            }
        }
        if (sVar == null) {
            Iterator it3 = m02.iterator();
            m.d(it3, "iterator(...)");
            while (it3.hasNext()) {
                Object next3 = it3.next();
                m.d(next3, "next(...)");
                C2060s sVar3 = (C2060s) next3;
                if (!sVar3.o().isEmpty() && (a5 = ((C2060s.c) sVar3.o().get(0)).a()) != null && a5.length() != 0 && m3.m.p(((C2060s.c) sVar3.o().get(0)).a(), str, true)) {
                    return sVar3;
                }
            }
        }
        return sVar;
    }

    public final C2060s f0(String str) {
        Long l4;
        Cursor cursor;
        C2060s sVar;
        m.e(str, "fileId");
        C2060s.c k02 = k0(str);
        if (k02 != null) {
            l4 = Long.valueOf(k02.c());
        } else {
            l4 = null;
        }
        if (l4 != null) {
            try {
                SQLiteDatabase sQLiteDatabase = this.f21929a;
                m.b(sQLiteDatabase);
                cursor = sQLiteDatabase.query("downloads", this.f21933e, "id=?", new String[]{String.valueOf(k02.c())}, (String) null, (String) null, (String) null);
                try {
                    if (cursor.moveToFirst()) {
                        m.b(cursor);
                        sVar = c1(cursor);
                    } else {
                        sVar = null;
                    }
                    cursor.close();
                    if (sVar != null && sVar.q() >= 0) {
                        sVar.X(l0(sVar.q()));
                    }
                    return sVar;
                } catch (Exception e5) {
                    e = e5;
                    e.printStackTrace();
                    cursor.close();
                    return null;
                }
            } catch (Exception e6) {
                e = e6;
                cursor = null;
                e.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return null;
            }
        }
        return null;
    }

    public final C2060s g0(int i4) {
        Cursor cursor;
        C2060s sVar;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("downloads", this.f21933e, "id=?", new String[]{String.valueOf(i4)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    m.b(cursor);
                    sVar = c1(cursor);
                } else {
                    sVar = null;
                }
                cursor.close();
                if (sVar != null && sVar.q() >= 0) {
                    sVar.X(l0(sVar.q()));
                }
                return sVar;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
            e.printStackTrace();
            cursor.close();
            return null;
        }
    }

    public final C2060s h0(String str) {
        Cursor cursor;
        C2060s sVar;
        m.e(str, "packagename");
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("downloads", this.f21933e, "packagename=?", new String[]{str}, (String) null, (String) null, "versioncode DESC");
            try {
                if (cursor.moveToFirst()) {
                    m.b(cursor);
                    sVar = c1(cursor);
                } else {
                    sVar = null;
                }
                cursor.close();
                if (sVar != null && sVar.q() >= 0) {
                    sVar.X(l0(sVar.q()));
                }
                return sVar;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
            e.printStackTrace();
            cursor.close();
            return null;
        }
    }

    public final synchronized void i() {
        try {
            if (this.f21948t.decrementAndGet() == 0) {
                t tVar = f21928v;
                m.b(tVar);
                tVar.close();
            } else if (this.f21948t.get() < 0) {
                this.f21948t.set(0);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final C2060s i0(String str, long j4) {
        Exception exc;
        Cursor cursor;
        C2060s sVar;
        m.e(str, "packagename");
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("downloads", this.f21933e, "packagename=? AND versioncode=?", new String[]{str, String.valueOf(j4)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    m.b(cursor);
                    sVar = c1(cursor);
                } else {
                    sVar = null;
                }
                cursor.close();
                if (sVar != null && sVar.q() >= 0) {
                    sVar.X(l0(sVar.q()));
                }
                return sVar;
            } catch (Exception e5) {
                exc = e5;
                exc.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return null;
            }
        } catch (Exception e6) {
            exc = e6;
            cursor = null;
            exc.printStackTrace();
            cursor.close();
            return null;
        }
    }

    public final int i1() {
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("preregistrations", (String) null, (String[]) null);
    }

    public final int j1(long j4) {
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("preregistrations", "appId=?", new String[]{String.valueOf(j4)});
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    public final int k() {
        int i4 = 0;
        ? r12 = 0;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT COUNT(id) AS count FROM notifications", r12);
            if (rawQuery.moveToFirst()) {
                i4 = rawQuery.getInt(0);
            }
            rawQuery.close();
            return i4;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (r12 != 0 && !r12.isClosed()) {
                r12.close();
            }
            return 0;
        }
    }

    public final int k1(long j4) {
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("preregistrations_to_notify", "appId=?", new String[]{String.valueOf(j4)});
    }

    public final C2060s l1(int i4) {
        Cursor cursor;
        C2060s sVar;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("downloads", this.f21933e, "id=?", new String[]{String.valueOf(i4)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    m.b(cursor);
                    sVar = c1(cursor);
                } else {
                    sVar = null;
                }
                cursor.close();
                if (sVar != null && sVar.q() >= 0) {
                    sVar.X(l0(sVar.q()));
                }
                return sVar;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            cursor = null;
            e.printStackTrace();
            cursor.close();
            return null;
        }
    }

    public final ArrayList m0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("downloads", this.f21933e, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                m.b(query);
                C2060s c12 = c1(query);
                if (c12.q() >= 0) {
                    c12.X(l0(c12.q()));
                }
                arrayList.add(c12);
            }
            while (query.moveToNext()) {
                m.b(query);
                C2060s c13 = c1(query);
                if (c13.q() >= 0) {
                    c13.X(l0(c13.q()));
                }
                arrayList.add(c13);
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final void m1() {
        ContentValues contentValues = new ContentValues();
        contentValues.putNull("urlFicha");
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.update("apps", contentValues, (String) null, (String[]) null);
    }

    public final int n(C2043a aVar) {
        m.e(aVar, "activeNotification");
        if (aVar.b() > -1) {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            return sQLiteDatabase.delete("active_notifications", "id=?", new String[]{String.valueOf(aVar.b())});
        } else if (aVar.a() > -1) {
            SQLiteDatabase sQLiteDatabase2 = this.f21929a;
            m.b(sQLiteDatabase2);
            return sQLiteDatabase2.delete("active_notifications", "notificationId=?", new String[]{String.valueOf(aVar.a())});
        } else if (aVar.c().length() <= 0) {
            return 0;
        } else {
            SQLiteDatabase sQLiteDatabase3 = this.f21929a;
            m.b(sQLiteDatabase3);
            return sQLiteDatabase3.delete("active_notifications", "packagename=?", new String[]{aVar.c()});
        }
    }

    public final ArrayList n0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("events", this.f21944p, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                m.b(query);
                arrayList.add(e1(query));
                while (query.moveToNext()) {
                    m.b(query);
                    arrayList.add(e1(query));
                }
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final void n1() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("checked", 1);
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.update("downloads", contentValues, (String) null, (String[]) null);
    }

    public final int o() {
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("notifications", (String) null, (String[]) null);
    }

    public final ArrayList o0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("errors", this.f21945q, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                m.b(query);
                arrayList.add(e1(query));
                while (query.moveToNext()) {
                    m.b(query);
                    arrayList.add(e1(query));
                }
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final void o1(C2048f fVar) {
        m.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        ContentValues contentValues = new ContentValues();
        contentValues.put("exclude", Integer.valueOf(fVar.e()));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.update("apps", contentValues, "packagename=?", new String[]{fVar.o()});
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m.e(sQLiteDatabase, "mSQLiteDatabase");
        this.f21929a = sQLiteDatabase;
        m.b(sQLiteDatabase);
        l(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        m.e(sQLiteDatabase, "sqLiteDatabase");
        if (i4 < 656) {
            T(sQLiteDatabase);
            l(sQLiteDatabase);
            return;
        }
        l(sQLiteDatabase);
        if (i4 < 667) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS updates");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS updates(id integer primary key autoincrement, packagename text, versionCode text, versionName text, notified integer default 0, ignoreVersion integer default 0, newFeatures text, installationAttempts integer default 0);");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS downloads(id integer primary key autoincrement, packagename text, checked integer default 0, incomplete integer default 0, versioncode integer default 0, attempts integer default 0, idPrograma integer default 0, downloadAnyway integer default 0, md5signature text, supportedAbis text, minsdk integer default 0, urlIcon text, appName text, nextAttemptTimeStamp integer default 0, updateId integer default 0);");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS download_files(id integer primary key autoincrement, downloadId integer default 0, fileId integer default 0, type text, size integer default 0, size_downloaded integer default 0, filehash text, absolutePath text, attempts integer default 0, nextAttemptTimeStamp integer default 0);");
        }
        if (i4 < 669) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS remote_installs(id integer primary key autoincrement, appId integer, sourceDeviceName text, downloadId integer);");
        }
    }

    public final ArrayList p0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("installable_files", this.f21936h, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                arrayList.add(query.getString(1));
            }
            while (query.moveToNext()) {
                arrayList.add(query.getString(1));
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final int p1(int i4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("trackInfoRegistered", Integer.valueOf(i4));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.update("apps", contentValues, (String) null, (String[]) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: g2.B} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final g2.C2034B q0() {
        /*
            r11 = this;
            r1 = 0
            java.lang.String r0 = "update_uptodown"
            java.lang.String[] r6 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x0036 }
            android.database.sqlite.SQLiteDatabase r2 = r11.f21929a     // Catch:{ Exception -> 0x0036 }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r3 = "notifications"
            java.lang.String[] r4 = r11.f21937i     // Catch:{ Exception -> 0x0036 }
            java.lang.String r5 = "actions=?"
            java.lang.String r9 = "id DESC"
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0036 }
            boolean r0 = r2.moveToFirst()     // Catch:{ Exception -> 0x002d }
            if (r0 == 0) goto L_0x0032
            g2.B r0 = new g2.B     // Catch:{ Exception -> 0x002d }
            r0.<init>()     // Catch:{ Exception -> 0x002d }
            kotlin.jvm.internal.m.b(r2)     // Catch:{ Exception -> 0x002d }
            r0.g(r2)     // Catch:{ Exception -> 0x002d }
            r1 = r0
            goto L_0x0032
        L_0x002d:
            r0 = move-exception
            r10 = r2
            r2 = r1
            r1 = r10
            goto L_0x0038
        L_0x0032:
            r2.close()     // Catch:{ Exception -> 0x002d }
            return r1
        L_0x0036:
            r0 = move-exception
            r2 = r1
        L_0x0038:
            r0.printStackTrace()
            if (r1 == 0) goto L_0x0046
            boolean r0 = r1.isClosed()
            if (r0 != 0) goto L_0x0046
            r1.close()
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.t.q0():g2.B");
    }

    public final void q1(C2043a aVar) {
        m.e(aVar, "activeNotification");
        ContentValues contentValues = new ContentValues();
        contentValues.put("notificationId", Integer.valueOf(aVar.a()));
        contentValues.put("packagename", aVar.c());
        contentValues.put("versioncode", Long.valueOf(aVar.e()));
        contentValues.put("type", Integer.valueOf(aVar.d().ordinal()));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.update("active_notifications", contentValues, "id=?", new String[]{String.valueOf(aVar.b())});
    }

    public final int r() {
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("responses", (String) null, (String[]) null);
    }

    public final int r0() {
        int i4;
        int i5 = 0;
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("active_notifications", new String[]{"notificationId"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (cursor.moveToFirst()) {
                int i6 = cursor.getInt(0);
                loop0:
                while (true) {
                    i4 = i6;
                    while (true) {
                        try {
                            if (!cursor.moveToNext()) {
                                break loop0;
                            }
                            i6 = cursor.getInt(0);
                            if (i6 > i4) {
                            }
                        } catch (Exception e5) {
                            e = e5;
                            i5 = i4;
                            e.printStackTrace();
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            return i5;
                        }
                    }
                }
                i5 = i4;
            }
            cursor.close();
            return i5;
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
            cursor.close();
            return i5;
        }
    }

    public final void r1(C2048f fVar) {
        m.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        ContentValues contentValues = new ContentValues();
        if (fVar.m() != null) {
            contentValues.put(RewardPlus.NAME, fVar.m());
        }
        if (fVar.A() > 0) {
            contentValues.put("versionCode", Long.valueOf(fVar.A()));
        }
        contentValues.put("issystemapp", Integer.valueOf(fVar.E()));
        contentValues.put("isSystemService", Integer.valueOf(fVar.G()));
        if (fVar.z() != null) {
            contentValues.put("urlFicha", fVar.z());
        }
        if (fVar.k() != null) {
            contentValues.put("md5signature", fVar.k());
        }
        contentValues.put("exclude", Integer.valueOf(fVar.e()));
        contentValues.put("size", String.valueOf(fVar.t()));
        contentValues.put("excludeFromTracking", Integer.valueOf(fVar.f()));
        if (fVar.c() != null) {
            contentValues.put("defaultName", fVar.c());
        }
        if (fVar.r() != null) {
            contentValues.put("sha256", fVar.r());
        }
        contentValues.put("positiveNotified", Integer.valueOf(fVar.q()));
        contentValues.put("appID", Long.valueOf(fVar.b()));
        contentValues.put("hasOldVersions", Integer.valueOf(fVar.h()));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.update("apps", contentValues, "packagename=?", new String[]{fVar.o()});
    }

    public final ArrayList s0() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        Cursor query = sQLiteDatabase.query("remote_installs", this.f21947s, "downloadId < 0", (String[]) null, (String) null, (String) null, (String) null);
        m.d(query, "query(...)");
        if (query.moveToFirst()) {
            C2041I i4 = new C2041I();
            i4.e(query);
            arrayList.add(i4);
            while (query.moveToNext()) {
                C2041I i5 = new C2041I();
                i5.e(query);
                arrayList.add(i5);
            }
        }
        query.close();
        return arrayList;
    }

    public final void s1(C2048f fVar) {
        m.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        ContentValues contentValues = new ContentValues();
        contentValues.put("excludeFromTracking", Integer.valueOf(fVar.f()));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.update("apps", contentValues, "packagename=?", new String[]{fVar.o()});
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], android.database.Cursor] */
    public final int t0(int i4) {
        int i5 = 0;
        ? r12 = 0;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT id FROM notifications ORDER BY id DESC LIMIT " + i4 + ",1", r12);
            if (rawQuery.moveToFirst()) {
                i5 = rawQuery.getInt(0);
            }
            rawQuery.close();
            return i5;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (r12 != 0 && !r12.isClosed()) {
                r12.close();
            }
            return 0;
        }
    }

    public final int t1(C2063v vVar) {
        m.e(vVar, "appFile");
        ContentValues contentValues = new ContentValues();
        contentValues.put("sha256", vVar.c());
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.update("app_files", contentValues, "path=?", new String[]{vVar.a()});
    }

    public final void u(C2048f fVar) {
        m.e(fVar, "appToDelete");
        if (fVar.i() < 0) {
            String o4 = fVar.o();
            m.b(o4);
            C2048f Y4 = Y(o4);
            if (Y4 != null) {
                fVar.S(Y4.i());
            }
        }
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.delete("apps", "packagename=?", new String[]{fVar.o()});
        SQLiteDatabase sQLiteDatabase2 = this.f21929a;
        m.b(sQLiteDatabase2);
        sQLiteDatabase2.delete("app_files", "app_id=?", new String[]{String.valueOf(fVar.i())});
    }

    public final ArrayList u0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("notifications", this.f21937i, (String) null, (String[]) null, (String) null, (String) null, "id DESC");
            if (query.moveToFirst()) {
                C2034B b5 = new C2034B();
                m.b(query);
                b5.g(query);
                arrayList.add(b5);
            }
            while (query.moveToNext()) {
                C2034B b6 = new C2034B();
                m.b(query);
                b6.g(query);
                arrayList.add(b6);
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final void u1(C2048f fVar) {
        m.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        ContentValues contentValues = new ContentValues();
        if (fVar.r() != null) {
            contentValues.put("sha256", fVar.r());
        }
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.update("apps", contentValues, "packagename=?", new String[]{fVar.o()});
    }

    public final void v(String str) {
        m.e(str, "packagename");
        C2048f Y4 = Y(str);
        if (Y4 != null) {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            sQLiteDatabase.delete("apps", "packagename=?", new String[]{str});
            SQLiteDatabase sQLiteDatabase2 = this.f21929a;
            m.b(sQLiteDatabase2);
            sQLiteDatabase2.delete("app_files", "app_id=?", new String[]{String.valueOf(Y4.i())});
        }
    }

    public final C2039G v0(long j4) {
        Exception exc;
        Cursor cursor;
        C2039G g4;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("preregistrations", this.f21938j, "appId=?", new String[]{String.valueOf(j4)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    C2039G.a aVar = C2039G.f20367f;
                    m.b(cursor);
                    g4 = aVar.c(cursor);
                } else {
                    g4 = null;
                }
                cursor.close();
                return g4;
            } catch (Exception e5) {
                exc = e5;
                exc.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return null;
            }
        } catch (Exception e6) {
            exc = e6;
            cursor = null;
            exc.printStackTrace();
            cursor.close();
            return null;
        }
    }

    public final void v1(S s4) {
        m.e(s4, "update");
        ContentValues contentValues = new ContentValues();
        contentValues.put("versionCode", Long.valueOf(s4.j()));
        contentValues.put("versionName", s4.k());
        contentValues.put("notified", Integer.valueOf(s4.g()));
        contentValues.put("ignoreVersion", Integer.valueOf(s4.e()));
        contentValues.put("newFeatures", s4.f());
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.update("updates", contentValues, "packagename=?", new String[]{s4.h()});
    }

    public final void w(C2063v vVar) {
        m.e(vVar, "appFile");
        if (vVar.c() != null) {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            sQLiteDatabase.delete("app_files", "sha256=?", new String[]{vVar.c()});
        } else if (vVar.a() != null) {
            SQLiteDatabase sQLiteDatabase2 = this.f21929a;
            m.b(sQLiteDatabase2);
            sQLiteDatabase2.delete("app_files", "path=?", new String[]{vVar.a()});
        }
    }

    public final C2039G w0(long j4) {
        Exception exc;
        Cursor cursor;
        C2039G g4;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            cursor = sQLiteDatabase.query("preregistrations_to_notify", this.f21939k, "appId=?", new String[]{String.valueOf(j4)}, (String) null, (String) null, (String) null);
            try {
                if (cursor.moveToFirst()) {
                    C2039G.a aVar = C2039G.f20367f;
                    m.b(cursor);
                    g4 = aVar.c(cursor);
                } else {
                    g4 = null;
                }
                cursor.close();
                return g4;
            } catch (Exception e5) {
                exc = e5;
                exc.printStackTrace();
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                return null;
            }
        } catch (Exception e6) {
            exc = e6;
            cursor = null;
            exc.printStackTrace();
            cursor.close();
            return null;
        }
    }

    public final int w1(C2060s sVar) {
        m.e(sVar, "download");
        ContentValues contentValues = new ContentValues();
        contentValues.put("packagename", sVar.w());
        contentValues.put("checked", Integer.valueOf(sVar.k()));
        contentValues.put("incomplete", Integer.valueOf(sVar.r()));
        contentValues.put("versioncode", Long.valueOf(sVar.E()));
        contentValues.put("attempts", Integer.valueOf(sVar.j()));
        contentValues.put("idPrograma", Long.valueOf(sVar.h()));
        contentValues.put("downloadAnyway", Integer.valueOf(sVar.l()));
        contentValues.put("md5signature", sVar.t());
        contentValues.put("supportedAbis", sVar.A());
        contentValues.put("minsdk", Integer.valueOf(sVar.u()));
        contentValues.put("urlIcon", sVar.D());
        contentValues.put("appName", sVar.i());
        contentValues.put("nextAttemptTimeStamp", Long.valueOf(sVar.v()));
        contentValues.put("updateId", Long.valueOf(sVar.C()));
        if (sVar.q() >= 0) {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            return sQLiteDatabase.update("downloads", contentValues, "id=?", new String[]{String.valueOf(sVar.q())});
        } else if (sVar.w() == null || sVar.E() <= 0) {
            return 0;
        } else {
            String[] strArr = {sVar.w(), String.valueOf(sVar.E())};
            SQLiteDatabase sQLiteDatabase2 = this.f21929a;
            m.b(sQLiteDatabase2);
            return sQLiteDatabase2.update("downloads", contentValues, "packagename=? AND versioncode=?", strArr);
        }
    }

    public final int x(String str) {
        m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        return sQLiteDatabase.delete("deep_link_files", "path=?", new String[]{str});
    }

    public final ArrayList x0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("preregistrations", this.f21938j, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                C2039G g4 = new C2039G();
                m.b(query);
                g4.g(query);
                arrayList.add(g4);
            }
            while (query.moveToNext()) {
                C2039G g5 = new C2039G();
                m.b(query);
                g5.g(query);
                arrayList.add(g5);
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final void x1(C2060s.c cVar) {
        m.e(cVar, "downloadFile");
        ContentValues contentValues = new ContentValues();
        contentValues.put("size_downloaded", Long.valueOf(cVar.h()));
        contentValues.put("absolutePath", cVar.a());
        contentValues.put("attempts", Integer.valueOf(cVar.b()));
        contentValues.put("nextAttemptTimeStamp", Long.valueOf(cVar.g()));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.update("download_files", contentValues, "id=?", new String[]{String.valueOf(cVar.f())});
    }

    public final ArrayList y0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("preregistrations_to_notify", this.f21939k, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                C2039G g4 = new C2039G();
                m.b(query);
                g4.g(query);
                arrayList.add(g4);
            }
            while (query.moveToNext()) {
                C2039G g5 = new C2039G();
                m.b(query);
                g5.g(query);
                arrayList.add(g5);
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final void y1(C2034B b5, String str, String str2) {
        m.e(b5, "notification");
        m.e(str, "notificationActions");
        m.e(str2, "notificationMsg");
        ContentValues contentValues = new ContentValues();
        contentValues.put("actions", str);
        contentValues.put(NotificationCompat.CATEGORY_MESSAGE, str2);
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.update("notifications", contentValues, "id=?", new String[]{String.valueOf(b5.c())});
    }

    public final int z(C2060s sVar) {
        if (sVar == null) {
            return 0;
        }
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        int delete = sQLiteDatabase.delete("downloads", "id=?", new String[]{String.valueOf(sVar.q())});
        D(sVar.q());
        return delete;
    }

    public final ArrayList z0() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.f21929a;
            m.b(sQLiteDatabase);
            Cursor query = sQLiteDatabase.query("recent_searches", this.f21935g, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query.moveToFirst()) {
                m.b(query);
                arrayList.add(f1(query));
            }
            while (query.moveToNext()) {
                m.b(query);
                arrayList.add(f1(query));
            }
            query.close();
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            return arrayList;
        }
    }

    public final void z1(long j4, int i4) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("automaticDownload", Integer.valueOf(i4));
        SQLiteDatabase sQLiteDatabase = this.f21929a;
        m.b(sQLiteDatabase);
        sQLiteDatabase.update("preregistrations", contentValues, "appId=?", new String[]{String.valueOf(j4)});
    }
}
