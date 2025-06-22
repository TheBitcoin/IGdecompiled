package y;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

final class W extends SQLiteOpenHelper {

    /* renamed from: c  reason: collision with root package name */
    private static final String f4739c = ("INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")");

    /* renamed from: d  reason: collision with root package name */
    static int f4740d = 7;

    /* renamed from: e  reason: collision with root package name */
    private static final a f4741e;

    /* renamed from: f  reason: collision with root package name */
    private static final a f4742f;

    /* renamed from: g  reason: collision with root package name */
    private static final a f4743g;

    /* renamed from: h  reason: collision with root package name */
    private static final a f4744h;

    /* renamed from: i  reason: collision with root package name */
    private static final a f4745i;

    /* renamed from: j  reason: collision with root package name */
    private static final a f4746j;

    /* renamed from: k  reason: collision with root package name */
    private static final a f4747k;

    /* renamed from: l  reason: collision with root package name */
    private static final List f4748l;

    /* renamed from: a  reason: collision with root package name */
    private final int f4749a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4750b = false;

    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        O o4 = new O();
        f4741e = o4;
        P p4 = new P();
        f4742f = p4;
        Q q4 = new Q();
        f4743g = q4;
        S s4 = new S();
        f4744h = s4;
        T t4 = new T();
        f4745i = t4;
        U u4 = new U();
        f4746j = u4;
        V v4 = new V();
        f4747k = v4;
        f4748l = Arrays.asList(new a[]{o4, p4, q4, s4, t4, u4, v4});
    }

    W(Context context, String str, int i4) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i4);
        this.f4749a = i4;
    }

    public static /* synthetic */ void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    public static /* synthetic */ void d(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN pseudonymous_id TEXT");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_clear_blob BLOB");
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN experiment_ids_encrypted_blob BLOB");
    }

    public static /* synthetic */ void i(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f4739c);
    }

    public static /* synthetic */ void l(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public static /* synthetic */ void n(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    private void o(SQLiteDatabase sQLiteDatabase) {
        if (!this.f4750b) {
            onConfigure(sQLiteDatabase);
        }
    }

    private void p(SQLiteDatabase sQLiteDatabase, int i4) {
        o(sQLiteDatabase);
        r(sQLiteDatabase, 0, i4);
    }

    private void r(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        List list = f4748l;
        if (i5 <= list.size()) {
            while (i4 < i5) {
                ((a) f4748l.get(i4)).a(sQLiteDatabase);
                i4++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i4 + " to " + i5 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f4750b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        p(sQLiteDatabase, this.f4749a);
    }

    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        p(sQLiteDatabase, i5);
    }

    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        o(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        o(sQLiteDatabase);
        r(sQLiteDatabase, i4, i5);
    }
}
