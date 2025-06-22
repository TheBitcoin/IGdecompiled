package androidx.room;

import R2.s;
import S2.C1601o;
import S2.H;
import S2.N;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    public static final Companion Companion = new Companion((C2103g) null);
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    public static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1";
    public static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    /* access modifiers changed from: private */
    public AutoCloser autoCloser;
    private volatile SupportSQLiteStatement cleanupStatement;
    private final RoomDatabase database;
    private volatile boolean initialized;
    private final InvalidationLiveDataContainer invalidationLiveDataContainer;
    private MultiInstanceInvalidationClient multiInstanceInvalidationClient;
    private final ObservedTableTracker observedTableTracker;
    @GuardedBy("observerMap")
    private final SafeIterableMap<Observer, ObserverWrapper> observerMap;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    private final AtomicBoolean pendingRefresh;
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final Runnable refreshRunnable;
    private final Map<String, String> shadowTablesMap;
    private final Object syncTriggersLock;
    private final Map<String, Integer> tableIdLookup;
    private final String[] tablesNames;
    private final Object trackerLock;
    private final Map<String, Set<String>> viewTables;

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getRESET_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getSELECT_UPDATED_TABLES_SQL$room_runtime_release$annotations() {
        }

        public final void beginTransactionInternal$room_runtime_release(SupportSQLiteDatabase supportSQLiteDatabase) {
            m.e(supportSQLiteDatabase, "database");
            if (supportSQLiteDatabase.isWriteAheadLoggingEnabled()) {
                supportSQLiteDatabase.beginTransactionNonExclusive();
            } else {
                supportSQLiteDatabase.beginTransaction();
            }
        }

        public final String getTriggerName$room_runtime_release(String str, String str2) {
            m.e(str, "tableName");
            m.e(str2, "triggerType");
            return "`room_table_modification_trigger_" + str + '_' + str2 + '`';
        }

        private Companion() {
        }
    }

    public static final class ObservedTableTracker {
        public static final int ADD = 1;
        public static final Companion Companion = new Companion((C2103g) null);
        public static final int NO_OP = 0;
        public static final int REMOVE = 2;
        private boolean needsSync;
        private final long[] tableObservers;
        private final int[] triggerStateChanges;
        private final boolean[] triggerStates;

        public static final class Companion {
            public /* synthetic */ Companion(C2103g gVar) {
                this();
            }

            private Companion() {
            }
        }

        public ObservedTableTracker(int i4) {
            this.tableObservers = new long[i4];
            this.triggerStates = new boolean[i4];
            this.triggerStateChanges = new int[i4];
        }

        public final boolean getNeedsSync() {
            return this.needsSync;
        }

        public final long[] getTableObservers() {
            return this.tableObservers;
        }

        @VisibleForTesting
        public final int[] getTablesToSync() {
            boolean z4;
            synchronized (this) {
                try {
                    if (!this.needsSync) {
                        return null;
                    }
                    long[] jArr = this.tableObservers;
                    int length = jArr.length;
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < length) {
                        int i6 = i5 + 1;
                        int i7 = 1;
                        if (jArr[i4] > 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        boolean[] zArr = this.triggerStates;
                        if (z4 != zArr[i5]) {
                            int[] iArr = this.triggerStateChanges;
                            if (!z4) {
                                i7 = 2;
                            }
                            iArr[i5] = i7;
                        } else {
                            this.triggerStateChanges[i5] = 0;
                        }
                        zArr[i5] = z4;
                        i4++;
                        i5 = i6;
                    }
                    this.needsSync = false;
                    int[] iArr2 = (int[]) this.triggerStateChanges.clone();
                    return iArr2;
                } finally {
                }
            }
        }

        public final boolean onAdded(int... iArr) {
            boolean z4;
            m.e(iArr, "tableIds");
            synchronized (this) {
                try {
                    z4 = false;
                    for (int i4 : iArr) {
                        long[] jArr = this.tableObservers;
                        long j4 = jArr[i4];
                        jArr[i4] = 1 + j4;
                        if (j4 == 0) {
                            this.needsSync = true;
                            z4 = true;
                        }
                    }
                    s sVar = s.f8222a;
                } finally {
                }
            }
            return z4;
        }

        public final boolean onRemoved(int... iArr) {
            boolean z4;
            m.e(iArr, "tableIds");
            synchronized (this) {
                try {
                    z4 = false;
                    for (int i4 : iArr) {
                        long[] jArr = this.tableObservers;
                        long j4 = jArr[i4];
                        jArr[i4] = j4 - 1;
                        if (j4 == 1) {
                            this.needsSync = true;
                            z4 = true;
                        }
                    }
                    s sVar = s.f8222a;
                } finally {
                }
            }
            return z4;
        }

        public final void resetTriggerState() {
            synchronized (this) {
                Arrays.fill(this.triggerStates, false);
                this.needsSync = true;
                s sVar = s.f8222a;
            }
        }

        public final void setNeedsSync(boolean z4) {
            this.needsSync = z4;
        }
    }

    public static abstract class Observer {
        private final String[] tables;

        public Observer(String[] strArr) {
            m.e(strArr, "tables");
            this.tables = strArr;
        }

        public final String[] getTables$room_runtime_release() {
            return this.tables;
        }

        public boolean isRemote$room_runtime_release() {
            return false;
        }

        public abstract void onInvalidated(Set<String> set);

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected Observer(java.lang.String r3, java.lang.String... r4) {
            /*
                r2 = this;
                java.lang.String r0 = "firstTable"
                kotlin.jvm.internal.m.e(r3, r0)
                java.lang.String r0 = "rest"
                kotlin.jvm.internal.m.e(r4, r0)
                java.util.List r0 = S2.C1601o.c()
                r1 = r0
                java.util.Collection r1 = (java.util.Collection) r1
                S2.C1601o.v(r1, r4)
                r0.add(r3)
                java.util.List r3 = S2.C1601o.a(r0)
                java.util.Collection r3 = (java.util.Collection) r3
                r4 = 0
                java.lang.String[] r4 = new java.lang.String[r4]
                java.lang.Object[] r3 = r3.toArray(r4)
                java.lang.String r4 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
                kotlin.jvm.internal.m.c(r3, r4)
                java.lang.String[] r3 = (java.lang.String[]) r3
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker.Observer.<init>(java.lang.String, java.lang.String[]):void");
        }
    }

    public static final class ObserverWrapper {
        private final Observer observer;
        private final Set<String> singleTableSet;
        private final int[] tableIds;
        private final String[] tableNames;

        public ObserverWrapper(Observer observer2, int[] iArr, String[] strArr) {
            boolean z4;
            Set<String> set;
            m.e(observer2, "observer");
            m.e(iArr, "tableIds");
            m.e(strArr, "tableNames");
            this.observer = observer2;
            this.tableIds = iArr;
            this.tableNames = strArr;
            if (strArr.length == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                set = N.c(strArr[0]);
            } else {
                set = N.d();
            }
            this.singleTableSet = set;
            if (iArr.length != strArr.length) {
                throw new IllegalStateException("Check failed.");
            }
        }

        public final Observer getObserver$room_runtime_release() {
            return this.observer;
        }

        public final int[] getTableIds$room_runtime_release() {
            return this.tableIds;
        }

        public final void notifyByTableInvalidStatus$room_runtime_release(Set<Integer> set) {
            Set<String> set2;
            m.e(set, "invalidatedTablesIds");
            int[] iArr = this.tableIds;
            int length = iArr.length;
            if (length != 0) {
                int i4 = 0;
                if (length != 1) {
                    Set b5 = N.b();
                    int[] iArr2 = this.tableIds;
                    int length2 = iArr2.length;
                    int i5 = 0;
                    while (i4 < length2) {
                        int i6 = i5 + 1;
                        if (set.contains(Integer.valueOf(iArr2[i4]))) {
                            b5.add(this.tableNames[i5]);
                        }
                        i4++;
                        i5 = i6;
                    }
                    set2 = N.a(b5);
                } else if (set.contains(Integer.valueOf(iArr[0]))) {
                    set2 = this.singleTableSet;
                } else {
                    set2 = N.d();
                }
            } else {
                set2 = N.d();
            }
            if (!set2.isEmpty()) {
                this.observer.onInvalidated(set2);
            }
        }

        public final void notifyByTableNames$room_runtime_release(String[] strArr) {
            Set<String> set;
            m.e(strArr, "tables");
            int length = this.tableNames.length;
            if (length != 0) {
                if (length == 1) {
                    int length2 = strArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length2) {
                            set = N.d();
                            break;
                        } else if (m3.m.p(strArr[i4], this.tableNames[0], true)) {
                            set = this.singleTableSet;
                            break;
                        } else {
                            i4++;
                        }
                    }
                } else {
                    Set b5 = N.b();
                    for (String str : strArr) {
                        for (String str2 : this.tableNames) {
                            if (m3.m.p(str2, str, true)) {
                                b5.add(str2);
                            }
                        }
                    }
                    set = N.a(b5);
                }
            } else {
                set = N.d();
            }
            if (!set.isEmpty()) {
                this.observer.onInvalidated(set);
            }
        }
    }

    public static final class WeakObserver extends Observer {
        private final WeakReference<Observer> delegateRef;
        private final InvalidationTracker tracker;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WeakObserver(InvalidationTracker invalidationTracker, Observer observer) {
            super(observer.getTables$room_runtime_release());
            m.e(invalidationTracker, "tracker");
            m.e(observer, "delegate");
            this.tracker = invalidationTracker;
            this.delegateRef = new WeakReference<>(observer);
        }

        public final WeakReference<Observer> getDelegateRef() {
            return this.delegateRef;
        }

        public final InvalidationTracker getTracker() {
            return this.tracker;
        }

        public void onInvalidated(Set<String> set) {
            m.e(set, "tables");
            Observer observer = this.delegateRef.get();
            if (observer == null) {
                this.tracker.removeObserver(this);
            } else {
                observer.onInvalidated(set);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        String str;
        m.e(roomDatabase, "database");
        m.e(map, "shadowTablesMap");
        m.e(map2, "viewTables");
        m.e(strArr, "tableNames");
        this.database = roomDatabase;
        this.shadowTablesMap = map;
        this.viewTables = map2;
        this.pendingRefresh = new AtomicBoolean(false);
        this.observedTableTracker = new ObservedTableTracker(strArr.length);
        this.invalidationLiveDataContainer = new InvalidationLiveDataContainer(roomDatabase);
        this.observerMap = new SafeIterableMap<>();
        this.syncTriggersLock = new Object();
        this.trackerLock = new Object();
        this.tableIdLookup = new LinkedHashMap();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i4 = 0; i4 < length; i4++) {
            String str2 = strArr[i4];
            Locale locale = Locale.US;
            m.d(locale, "US");
            String lowerCase = str2.toLowerCase(locale);
            m.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            this.tableIdLookup.put(lowerCase, Integer.valueOf(i4));
            String str3 = this.shadowTablesMap.get(strArr[i4]);
            if (str3 != null) {
                m.d(locale, "US");
                str = str3.toLowerCase(locale);
                m.d(str, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str = null;
            }
            if (str != null) {
                lowerCase = str;
            }
            strArr2[i4] = lowerCase;
        }
        this.tablesNames = strArr2;
        for (Map.Entry next : this.shadowTablesMap.entrySet()) {
            Locale locale2 = Locale.US;
            m.d(locale2, "US");
            String lowerCase2 = ((String) next.getValue()).toLowerCase(locale2);
            m.d(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
            if (this.tableIdLookup.containsKey(lowerCase2)) {
                m.d(locale2, "US");
                String lowerCase3 = ((String) next.getKey()).toLowerCase(locale2);
                m.d(lowerCase3, "this as java.lang.String).toLowerCase(locale)");
                Map<String, Integer> map3 = this.tableIdLookup;
                map3.put(lowerCase3, H.h(map3, lowerCase2));
            }
        }
        this.refreshRunnable = new InvalidationTracker$refreshRunnable$1(this);
    }

    @VisibleForTesting
    public static /* synthetic */ void getRefreshRunnable$annotations() {
    }

    private final String[] resolveViews(String[] strArr) {
        Set b5 = N.b();
        for (String str : strArr) {
            Map<String, Set<String>> map = this.viewTables;
            Locale locale = Locale.US;
            m.d(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            m.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                Map<String, Set<String>> map2 = this.viewTables;
                m.d(locale, "US");
                String lowerCase2 = str.toLowerCase(locale);
                m.d(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                Set<String> set = map2.get(lowerCase2);
                m.b(set);
                b5.addAll(set);
            } else {
                b5.add(str);
            }
        }
        Object[] array = N.a(b5).toArray(new String[0]);
        m.c(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    private final void startTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i4) {
        supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i4 + ", 0)");
        String str = this.tablesNames[i4];
        for (String str2 : TRIGGERS) {
            String str3 = "CREATE TEMP TRIGGER IF NOT EXISTS " + Companion.getTriggerName$room_runtime_release(str, str2) + " AFTER " + str2 + " ON `" + str + "` BEGIN UPDATE " + UPDATE_TABLE_NAME + " SET " + INVALIDATED_COLUMN_NAME + " = 1" + " WHERE " + TABLE_ID_COLUMN_NAME + " = " + i4 + " AND " + INVALIDATED_COLUMN_NAME + " = 0" + "; END";
            m.d(str3, "StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.execSQL(str3);
        }
    }

    private final void stopTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i4) {
        String str = this.tablesNames[i4];
        for (String str2 : TRIGGERS) {
            String str3 = "DROP TRIGGER IF EXISTS " + Companion.getTriggerName$room_runtime_release(str, str2);
            m.d(str3, "StringBuilder().apply(builderAction).toString()");
            supportSQLiteDatabase.execSQL(str3);
        }
    }

    private final String[] validateAndResolveTableNames(String[] strArr) {
        String[] resolveViews = resolveViews(strArr);
        int length = resolveViews.length;
        int i4 = 0;
        while (i4 < length) {
            String str = resolveViews[i4];
            Map<String, Integer> map = this.tableIdLookup;
            Locale locale = Locale.US;
            m.d(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            m.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (map.containsKey(lowerCase)) {
                i4++;
            } else {
                throw new IllegalArgumentException(("There is no table with name " + str).toString());
            }
        }
        return resolveViews;
    }

    @WorkerThread
    @SuppressLint({"RestrictedApi"})
    public void addObserver(Observer observer) {
        ObserverWrapper putIfAbsent;
        m.e(observer, "observer");
        String[] resolveViews = resolveViews(observer.getTables$room_runtime_release());
        ArrayList arrayList = new ArrayList(resolveViews.length);
        int length = resolveViews.length;
        int i4 = 0;
        while (i4 < length) {
            String str = resolveViews[i4];
            Map<String, Integer> map = this.tableIdLookup;
            Locale locale = Locale.US;
            m.d(locale, "US");
            String lowerCase = str.toLowerCase(locale);
            m.d(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            Integer num = map.get(lowerCase);
            if (num != null) {
                arrayList.add(num);
                i4++;
            } else {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
        }
        int[] Y4 = C1601o.Y(arrayList);
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, Y4, resolveViews);
        synchronized (this.observerMap) {
            putIfAbsent = this.observerMap.putIfAbsent(observer, observerWrapper);
        }
        if (putIfAbsent == null && this.observedTableTracker.onAdded(Arrays.copyOf(Y4, Y4.length))) {
            syncTriggers$room_runtime_release();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addWeakObserver(Observer observer) {
        m.e(observer, "observer");
        addObserver(new WeakObserver(this, observer));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] strArr, Callable<T> callable) {
        m.e(strArr, "tableNames");
        m.e(callable, "computeFunction");
        return createLiveData(strArr, false, callable);
    }

    public final boolean ensureInitialization$room_runtime_release() {
        if (!this.database.isOpen()) {
            return false;
        }
        if (!this.initialized) {
            this.database.getOpenHelper().getWritableDatabase();
        }
        if (this.initialized) {
            return true;
        }
        Log.e(Room.LOG_TAG, "database is not initialized even though it is open");
        return false;
    }

    public final SupportSQLiteStatement getCleanupStatement$room_runtime_release() {
        return this.cleanupStatement;
    }

    public final RoomDatabase getDatabase$room_runtime_release() {
        return this.database;
    }

    public final SafeIterableMap<Observer, ObserverWrapper> getObserverMap$room_runtime_release() {
        return this.observerMap;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final AtomicBoolean getPendingRefresh() {
        return this.pendingRefresh;
    }

    public final Map<String, Integer> getTableIdLookup$room_runtime_release() {
        return this.tableIdLookup;
    }

    public final String[] getTablesNames$room_runtime_release() {
        return this.tablesNames;
    }

    public final void internalInit$room_runtime_release(SupportSQLiteDatabase supportSQLiteDatabase) {
        m.e(supportSQLiteDatabase, "database");
        synchronized (this.trackerLock) {
            if (this.initialized) {
                Log.e(Room.LOG_TAG, "Invalidation tracker is initialized twice :/.");
                return;
            }
            supportSQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY;");
            supportSQLiteDatabase.execSQL("PRAGMA recursive_triggers='ON';");
            supportSQLiteDatabase.execSQL(CREATE_TRACKING_TABLE_SQL);
            syncTriggers$room_runtime_release(supportSQLiteDatabase);
            this.cleanupStatement = supportSQLiteDatabase.compileStatement(RESET_UPDATED_TABLES_SQL);
            this.initialized = true;
            s sVar = s.f8222a;
        }
    }

    @VisibleForTesting(otherwise = 3)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void notifyObserversByTableNames(String... strArr) {
        m.e(strArr, "tables");
        synchronized (this.observerMap) {
            try {
                Iterator<T> it = this.observerMap.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    m.d(entry, "(observer, wrapper)");
                    ObserverWrapper observerWrapper = (ObserverWrapper) entry.getValue();
                    if (!((Observer) entry.getKey()).isRemote$room_runtime_release()) {
                        observerWrapper.notifyByTableNames$room_runtime_release(strArr);
                    }
                }
                s sVar = s.f8222a;
            } finally {
            }
        }
    }

    public final void onAutoCloseCallback$room_runtime_release() {
        synchronized (this.trackerLock) {
            this.initialized = false;
            this.observedTableTracker.resetTriggerState();
            s sVar = s.f8222a;
        }
    }

    public void refreshVersionsAsync() {
        if (this.pendingRefresh.compareAndSet(false, true)) {
            AutoCloser autoCloser2 = this.autoCloser;
            if (autoCloser2 != null) {
                autoCloser2.incrementCountAndEnsureDbIsOpen();
            }
            this.database.getQueryExecutor().execute(this.refreshRunnable);
        }
    }

    @WorkerThread
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void refreshVersionsSync() {
        AutoCloser autoCloser2 = this.autoCloser;
        if (autoCloser2 != null) {
            autoCloser2.incrementCountAndEnsureDbIsOpen();
        }
        syncTriggers$room_runtime_release();
        this.refreshRunnable.run();
    }

    @WorkerThread
    @SuppressLint({"RestrictedApi"})
    public void removeObserver(Observer observer) {
        ObserverWrapper remove;
        m.e(observer, "observer");
        synchronized (this.observerMap) {
            remove = this.observerMap.remove(observer);
        }
        if (remove != null) {
            ObservedTableTracker observedTableTracker2 = this.observedTableTracker;
            int[] tableIds$room_runtime_release = remove.getTableIds$room_runtime_release();
            if (observedTableTracker2.onRemoved(Arrays.copyOf(tableIds$room_runtime_release, tableIds$room_runtime_release.length))) {
                syncTriggers$room_runtime_release();
            }
        }
    }

    public final void setAutoCloser$room_runtime_release(AutoCloser autoCloser2) {
        m.e(autoCloser2, "autoCloser");
        this.autoCloser = autoCloser2;
        autoCloser2.setAutoCloseCallback(new c(this));
    }

    public final void setCleanupStatement$room_runtime_release(SupportSQLiteStatement supportSQLiteStatement) {
        this.cleanupStatement = supportSQLiteStatement;
    }

    public final void startMultiInstanceInvalidation$room_runtime_release(Context context, String str, Intent intent) {
        m.e(context, "context");
        m.e(str, RewardPlus.NAME);
        m.e(intent, "serviceIntent");
        this.multiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, str, intent, this, this.database.getQueryExecutor());
    }

    public final void stopMultiInstanceInvalidation$room_runtime_release() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = this.multiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient2 != null) {
            multiInstanceInvalidationClient2.stop();
        }
        this.multiInstanceInvalidationClient = null;
    }

    public final void syncTriggers$room_runtime_release(SupportSQLiteDatabase supportSQLiteDatabase) {
        Lock closeLock$room_runtime_release;
        m.e(supportSQLiteDatabase, "database");
        if (!supportSQLiteDatabase.inTransaction()) {
            try {
                closeLock$room_runtime_release = this.database.getCloseLock$room_runtime_release();
                closeLock$room_runtime_release.lock();
                synchronized (this.syncTriggersLock) {
                    int[] tablesToSync = this.observedTableTracker.getTablesToSync();
                    if (tablesToSync != null) {
                        Companion.beginTransactionInternal$room_runtime_release(supportSQLiteDatabase);
                        try {
                            int length = tablesToSync.length;
                            int i4 = 0;
                            int i5 = 0;
                            while (i4 < length) {
                                int i6 = tablesToSync[i4];
                                int i7 = i5 + 1;
                                if (i6 == 1) {
                                    startTrackingTable(supportSQLiteDatabase, i5);
                                } else if (i6 == 2) {
                                    stopTrackingTable(supportSQLiteDatabase, i5);
                                }
                                i4++;
                                i5 = i7;
                            }
                            supportSQLiteDatabase.setTransactionSuccessful();
                            supportSQLiteDatabase.endTransaction();
                            s sVar = s.f8222a;
                        } finally {
                            supportSQLiteDatabase.endTransaction();
                        }
                    }
                }
                closeLock$room_runtime_release.unlock();
            } catch (IllegalStateException e5) {
                Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e5);
            } catch (SQLiteException e6) {
                Log.e(Room.LOG_TAG, "Cannot run invalidation tracker. Is the db closed?", e6);
            } catch (Throwable th) {
                closeLock$room_runtime_release.unlock();
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] strArr, boolean z4, Callable<T> callable) {
        m.e(strArr, "tableNames");
        m.e(callable, "computeFunction");
        return this.invalidationLiveDataContainer.create(validateAndResolveTableNames(strArr), z4, callable);
    }

    public final void syncTriggers$room_runtime_release() {
        if (this.database.isOpen()) {
            syncTriggers$room_runtime_release(this.database.getOpenHelper().getWritableDatabase());
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, String... strArr) {
        this(roomDatabase, H.g(), H.g(), (String[]) Arrays.copyOf(strArr, strArr.length));
        m.e(roomDatabase, "database");
        m.e(strArr, "tableNames");
    }
}
