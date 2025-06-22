package androidx.room;

import S2.C1601o;
import S2.H;
import S2.N;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.mbridge.msdk.MBridgeConstans;
import j$.util.DesugarCollections;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public abstract class RoomDatabase {
    public static final Companion Companion = new Companion((C2103g) null);
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean allowMainThreadQueries;
    private AutoCloser autoCloser;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs = new LinkedHashMap();
    private final Map<String, Object> backingFieldMap;
    private SupportSQLiteOpenHelper internalOpenHelper;
    private Executor internalQueryExecutor;
    private Executor internalTransactionExecutor;
    private final InvalidationTracker invalidationTracker = createInvalidationTracker();
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected List<? extends Callback> mCallbacks;
    protected volatile SupportSQLiteDatabase mDatabase;
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final ThreadLocal<Integer> suspendingTransactionId = new ThreadLocal<>();
    private final Map<Class<?>, Object> typeConverters;
    private boolean writeAheadLoggingEnabled;

    public static class Builder<T extends RoomDatabase> {
        private boolean allowDestructiveMigrationOnDowngrade;
        private boolean allowMainThreadQueries;
        private TimeUnit autoCloseTimeUnit;
        private long autoCloseTimeout = -1;
        private List<AutoMigrationSpec> autoMigrationSpecs = new ArrayList();
        private final List<Callback> callbacks = new ArrayList();
        private final Context context;
        private String copyFromAssetPath;
        private File copyFromFile;
        private Callable<InputStream> copyFromInputStream;
        private SupportSQLiteOpenHelper.Factory factory;
        private JournalMode journalMode = JournalMode.AUTOMATIC;
        private final Class<T> klass;
        private final MigrationContainer migrationContainer = new MigrationContainer();
        private Set<Integer> migrationStartAndEndVersions;
        private Set<Integer> migrationsNotRequiredFrom = new LinkedHashSet();
        private Intent multiInstanceInvalidationIntent;
        private final String name;
        private PrepackagedDatabaseCallback prepackagedDatabaseCallback;
        private QueryCallback queryCallback;
        private Executor queryCallbackExecutor;
        private Executor queryExecutor;
        private boolean requireMigration = true;
        private Executor transactionExecutor;
        private final List<Object> typeConverters = new ArrayList();

        public Builder(Context context2, Class<T> cls, String str) {
            m.e(context2, "context");
            m.e(cls, "klass");
            this.context = context2;
            this.klass = cls;
            this.name = str;
        }

        public Builder<T> addAutoMigrationSpec(AutoMigrationSpec autoMigrationSpec) {
            m.e(autoMigrationSpec, "autoMigrationSpec");
            this.autoMigrationSpecs.add(autoMigrationSpec);
            return this;
        }

        public Builder<T> addCallback(Callback callback) {
            m.e(callback, "callback");
            this.callbacks.add(callback);
            return this;
        }

        public Builder<T> addMigrations(Migration... migrationArr) {
            m.e(migrationArr, "migrations");
            if (this.migrationStartAndEndVersions == null) {
                this.migrationStartAndEndVersions = new HashSet();
            }
            for (Migration migration : migrationArr) {
                Set<Integer> set = this.migrationStartAndEndVersions;
                m.b(set);
                set.add(Integer.valueOf(migration.startVersion));
                Set<Integer> set2 = this.migrationStartAndEndVersions;
                m.b(set2);
                set2.add(Integer.valueOf(migration.endVersion));
            }
            this.migrationContainer.addMigrations((Migration[]) Arrays.copyOf(migrationArr, migrationArr.length));
            return this;
        }

        public Builder<T> addTypeConverter(Object obj) {
            m.e(obj, "typeConverter");
            this.typeConverters.add(obj);
            return this;
        }

        public Builder<T> allowMainThreadQueries() {
            this.allowMainThreadQueries = true;
            return this;
        }

        public T build() {
            SQLiteCopyOpenHelperFactory sQLiteCopyOpenHelperFactory;
            int i4;
            int i5;
            Executor executor = this.queryExecutor;
            if (executor == null && this.transactionExecutor == null) {
                Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
                this.transactionExecutor = iOThreadExecutor;
                this.queryExecutor = iOThreadExecutor;
            } else if (executor != null && this.transactionExecutor == null) {
                this.transactionExecutor = executor;
            } else if (executor == null) {
                this.queryExecutor = this.transactionExecutor;
            }
            Set<Integer> set = this.migrationStartAndEndVersions;
            if (set != null) {
                m.b(set);
                for (Integer intValue : set) {
                    int intValue2 = intValue.intValue();
                    if (this.migrationsNotRequiredFrom.contains(Integer.valueOf(intValue2))) {
                        throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + intValue2).toString());
                    }
                }
            }
            AutoClosingRoomOpenHelperFactory autoClosingRoomOpenHelperFactory = this.factory;
            if (autoClosingRoomOpenHelperFactory == null) {
                autoClosingRoomOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
            }
            if (autoClosingRoomOpenHelperFactory != null) {
                if (this.autoCloseTimeout > 0) {
                    if (this.name != null) {
                        long j4 = this.autoCloseTimeout;
                        TimeUnit timeUnit = this.autoCloseTimeUnit;
                        if (timeUnit != null) {
                            Executor executor2 = this.queryExecutor;
                            if (executor2 != null) {
                                autoClosingRoomOpenHelperFactory = new AutoClosingRoomOpenHelperFactory(autoClosingRoomOpenHelperFactory, new AutoCloser(j4, timeUnit, executor2));
                            } else {
                                throw new IllegalArgumentException("Required value was null.");
                            }
                        } else {
                            throw new IllegalArgumentException("Required value was null.");
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                    }
                }
                String str = this.copyFromAssetPath;
                if (!(str == null && this.copyFromFile == null && this.copyFromInputStream == null)) {
                    if (this.name != null) {
                        int i6 = 0;
                        if (str == null) {
                            i4 = 0;
                        } else {
                            i4 = 1;
                        }
                        File file = this.copyFromFile;
                        if (file == null) {
                            i5 = 0;
                        } else {
                            i5 = 1;
                        }
                        Callable<InputStream> callable = this.copyFromInputStream;
                        if (callable != null) {
                            i6 = 1;
                        }
                        if (i4 + i5 + i6 == 1) {
                            autoClosingRoomOpenHelperFactory = new SQLiteCopyOpenHelperFactory(str, file, callable, autoClosingRoomOpenHelperFactory);
                        } else {
                            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                        }
                    } else {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    }
                }
            } else {
                autoClosingRoomOpenHelperFactory = null;
            }
            if (autoClosingRoomOpenHelperFactory != null) {
                QueryCallback queryCallback2 = this.queryCallback;
                if (queryCallback2 != null) {
                    Executor executor3 = this.queryCallbackExecutor;
                    if (executor3 == null) {
                        throw new IllegalArgumentException("Required value was null.");
                    } else if (queryCallback2 != null) {
                        sQLiteCopyOpenHelperFactory = new QueryInterceptorOpenHelperFactory(autoClosingRoomOpenHelperFactory, executor3, queryCallback2);
                    } else {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                } else {
                    sQLiteCopyOpenHelperFactory = autoClosingRoomOpenHelperFactory;
                }
                Context context2 = this.context;
                String str2 = this.name;
                MigrationContainer migrationContainer2 = this.migrationContainer;
                List<Callback> list = this.callbacks;
                boolean z4 = this.allowMainThreadQueries;
                JournalMode resolve$room_runtime_release = this.journalMode.resolve$room_runtime_release(context2);
                Executor executor4 = this.queryExecutor;
                if (executor4 != null) {
                    Executor executor5 = this.transactionExecutor;
                    if (executor5 != null) {
                        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context2, str2, (SupportSQLiteOpenHelper.Factory) sQLiteCopyOpenHelperFactory, migrationContainer2, (List<? extends Callback>) list, z4, resolve$room_runtime_release, executor4, executor5, this.multiInstanceInvalidationIntent, this.requireMigration, this.allowDestructiveMigrationOnDowngrade, this.migrationsNotRequiredFrom, this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, this.prepackagedDatabaseCallback, (List<? extends Object>) this.typeConverters, (List<? extends AutoMigrationSpec>) this.autoMigrationSpecs);
                        T t4 = (RoomDatabase) Room.getGeneratedImplementation(this.klass, "_Impl");
                        t4.init(databaseConfiguration);
                        return t4;
                    }
                    throw new IllegalArgumentException("Required value was null.");
                }
                throw new IllegalArgumentException("Required value was null.");
            }
            throw new IllegalArgumentException("Required value was null.");
        }

        public Builder<T> createFromAsset(String str) {
            m.e(str, "databaseFilePath");
            this.copyFromAssetPath = str;
            return this;
        }

        public Builder<T> createFromFile(File file) {
            m.e(file, "databaseFile");
            this.copyFromFile = file;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder<T> createFromInputStream(Callable<InputStream> callable) {
            m.e(callable, "inputStreamCallable");
            this.copyFromInputStream = callable;
            return this;
        }

        public Builder<T> enableMultiInstanceInvalidation() {
            Intent intent;
            if (this.name != null) {
                intent = new Intent(this.context, MultiInstanceInvalidationService.class);
            } else {
                intent = null;
            }
            this.multiInstanceInvalidationIntent = intent;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigration() {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationFrom(int... iArr) {
            m.e(iArr, "startVersions");
            for (int valueOf : iArr) {
                this.migrationsNotRequiredFrom.add(Integer.valueOf(valueOf));
            }
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.requireMigration = true;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> openHelperFactory(SupportSQLiteOpenHelper.Factory factory2) {
            this.factory = factory2;
            return this;
        }

        @ExperimentalRoomApi
        public Builder<T> setAutoCloseTimeout(@IntRange(from = 0) long j4, TimeUnit timeUnit) {
            m.e(timeUnit, "autoCloseTimeUnit");
            if (j4 >= 0) {
                this.autoCloseTimeout = j4;
                this.autoCloseTimeUnit = timeUnit;
                return this;
            }
            throw new IllegalArgumentException("autoCloseTimeout must be >= 0");
        }

        public Builder<T> setJournalMode(JournalMode journalMode2) {
            m.e(journalMode2, "journalMode");
            this.journalMode = journalMode2;
            return this;
        }

        @ExperimentalRoomApi
        public Builder<T> setMultiInstanceInvalidationServiceIntent(Intent intent) {
            m.e(intent, "invalidationServiceIntent");
            if (this.name == null) {
                intent = null;
            }
            this.multiInstanceInvalidationIntent = intent;
            return this;
        }

        public Builder<T> setQueryCallback(QueryCallback queryCallback2, Executor executor) {
            m.e(queryCallback2, "queryCallback");
            m.e(executor, "executor");
            this.queryCallback = queryCallback2;
            this.queryCallbackExecutor = executor;
            return this;
        }

        public Builder<T> setQueryExecutor(Executor executor) {
            m.e(executor, "executor");
            this.queryExecutor = executor;
            return this;
        }

        public Builder<T> setTransactionExecutor(Executor executor) {
            m.e(executor, "executor");
            this.transactionExecutor = executor;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder<T> createFromAsset(String str, PrepackagedDatabaseCallback prepackagedDatabaseCallback2) {
            m.e(str, "databaseFilePath");
            m.e(prepackagedDatabaseCallback2, "callback");
            this.prepackagedDatabaseCallback = prepackagedDatabaseCallback2;
            this.copyFromAssetPath = str;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "StreamFiles"})
        public Builder<T> createFromFile(File file, PrepackagedDatabaseCallback prepackagedDatabaseCallback2) {
            m.e(file, "databaseFile");
            m.e(prepackagedDatabaseCallback2, "callback");
            this.prepackagedDatabaseCallback = prepackagedDatabaseCallback2;
            this.copyFromFile = file;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "LambdaLast"})
        public Builder<T> createFromInputStream(Callable<InputStream> callable, PrepackagedDatabaseCallback prepackagedDatabaseCallback2) {
            m.e(callable, "inputStreamCallable");
            m.e(prepackagedDatabaseCallback2, "callback");
            this.prepackagedDatabaseCallback = prepackagedDatabaseCallback2;
            this.copyFromInputStream = callable;
            return this;
        }
    }

    public static abstract class Callback {
        public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
            m.e(supportSQLiteDatabase, "db");
        }

        public void onDestructiveMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
            m.e(supportSQLiteDatabase, "db");
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            m.e(supportSQLiteDatabase, "db");
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private final boolean isLowRamDevice(ActivityManager activityManager) {
            return SupportSQLiteCompat.Api19Impl.isLowRamDevice(activityManager);
        }

        public final JournalMode resolve$room_runtime_release(Context context) {
            m.e(context, "context");
            if (this != AUTOMATIC) {
                return this;
            }
            Object systemService = context.getSystemService("activity");
            m.c(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            if (!isLowRamDevice((ActivityManager) systemService)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }
    }

    public static abstract class PrepackagedDatabaseCallback {
        public void onOpenPrepackagedDatabase(SupportSQLiteDatabase supportSQLiteDatabase) {
            m.e(supportSQLiteDatabase, "db");
        }
    }

    public interface QueryCallback {
        void onQuery(String str, List<? extends Object> list);
    }

    public RoomDatabase() {
        Map<String, Object> synchronizedMap = DesugarCollections.synchronizedMap(new LinkedHashMap());
        m.d(synchronizedMap, "synchronizedMap(mutableMapOf())");
        this.backingFieldMap = synchronizedMap;
        this.typeConverters = new LinkedHashMap();
    }

    protected static /* synthetic */ void getMCallbacks$annotations() {
    }

    protected static /* synthetic */ void getMDatabase$annotations() {
    }

    /* access modifiers changed from: private */
    public final void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = getOpenHelper().getWritableDatabase();
        getInvalidationTracker().syncTriggers$room_runtime_release(writableDatabase);
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    /* access modifiers changed from: private */
    public final void internalEndTransaction() {
        getOpenHelper().getWritableDatabase().endTransaction();
        if (!inTransaction()) {
            getInvalidationTracker().refreshVersionsAsync();
        }
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ Cursor query$default(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                cancellationSignal = null;
            }
            return roomDatabase.query(supportSQLiteQuery, cancellationSignal);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
    }

    private final <T> T unwrapOpenHelper(Class<T> cls, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (cls.isInstance(supportSQLiteOpenHelper)) {
            return supportSQLiteOpenHelper;
        }
        if (supportSQLiteOpenHelper instanceof DelegatingOpenHelper) {
            return unwrapOpenHelper(cls, ((DelegatingOpenHelper) supportSQLiteOpenHelper).getDelegate());
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotMainThread() {
        if (!this.allowMainThreadQueries && isMainThread$room_runtime_release()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.suspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    public void beginTransaction() {
        assertNotMainThread();
        AutoCloser autoCloser2 = this.autoCloser;
        if (autoCloser2 == null) {
            internalBeginTransaction();
        } else {
            autoCloser2.executeRefCountingFunction(new RoomDatabase$beginTransaction$1(this));
        }
    }

    @WorkerThread
    public abstract void clearAllTables();

    public void close() {
        if (isOpen()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            m.d(writeLock, "readWriteLock.writeLock()");
            writeLock.lock();
            try {
                getInvalidationTracker().stopMultiInstanceInvalidation$room_runtime_release();
                getOpenHelper().close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public SupportSQLiteStatement compileStatement(String str) {
        m.e(str, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().compileStatement(str);
    }

    /* access modifiers changed from: protected */
    public abstract InvalidationTracker createInvalidationTracker();

    /* access modifiers changed from: protected */
    public abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration);

    public void endTransaction() {
        AutoCloser autoCloser2 = this.autoCloser;
        if (autoCloser2 == null) {
            internalEndTransaction();
        } else {
            autoCloser2.executeRefCountingFunction(new RoomDatabase$endTransaction$1(this));
        }
    }

    /* access modifiers changed from: protected */
    public final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> getAutoMigrationSpecs() {
        return this.autoMigrationSpecs;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        m.e(map, "autoMigrationSpecs");
        return C1601o.h();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Map<String, Object> getBackingFieldMap() {
        return this.backingFieldMap;
    }

    public final Lock getCloseLock$room_runtime_release() {
        ReentrantReadWriteLock.ReadLock readLock = this.readWriteLock.readLock();
        m.d(readLock, "readWriteLock.readLock()");
        return readLock;
    }

    public InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.internalOpenHelper;
        if (supportSQLiteOpenHelper != null) {
            return supportSQLiteOpenHelper;
        }
        m.u("internalOpenHelper");
        return null;
    }

    public Executor getQueryExecutor() {
        Executor executor = this.internalQueryExecutor;
        if (executor != null) {
            return executor;
        }
        m.u("internalQueryExecutor");
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return N.d();
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return H.g();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.suspendingTransactionId;
    }

    public Executor getTransactionExecutor() {
        Executor executor = this.internalTransactionExecutor;
        if (executor != null) {
            return executor;
        }
        m.u("internalTransactionExecutor");
        return null;
    }

    public <T> T getTypeConverter(Class<T> cls) {
        m.e(cls, "klass");
        return this.typeConverters.get(cls);
    }

    public boolean inTransaction() {
        return getOpenHelper().getWritableDatabase().inTransaction();
    }

    @CallSuper
    public void init(DatabaseConfiguration databaseConfiguration) {
        boolean z4 = false;
        m.e(databaseConfiguration, "configuration");
        this.internalOpenHelper = createOpenHelper(databaseConfiguration);
        Set<Class<? extends AutoMigrationSpec>> requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        BitSet bitSet = new BitSet();
        for (Class next : requiredAutoMigrationSpecs) {
            int size = databaseConfiguration.autoMigrationSpecs.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i4 = size - 1;
                    if (next.isAssignableFrom(databaseConfiguration.autoMigrationSpecs.get(size).getClass())) {
                        bitSet.set(size);
                        break;
                    } else if (i4 < 0) {
                        break;
                    } else {
                        size = i4;
                    }
                }
            }
            size = -1;
            if (size >= 0) {
                this.autoMigrationSpecs.put(next, databaseConfiguration.autoMigrationSpecs.get(size));
            } else {
                throw new IllegalArgumentException(("A required auto migration spec (" + next.getCanonicalName() + ") is missing in the database configuration.").toString());
            }
        }
        int size2 = databaseConfiguration.autoMigrationSpecs.size() - 1;
        if (size2 >= 0) {
            while (true) {
                int i5 = size2 - 1;
                if (!bitSet.get(size2)) {
                    throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                } else if (i5 < 0) {
                    break;
                } else {
                    size2 = i5;
                }
            }
        }
        for (Migration next2 : getAutoMigrations(this.autoMigrationSpecs)) {
            if (!databaseConfiguration.migrationContainer.contains(next2.startVersion, next2.endVersion)) {
                databaseConfiguration.migrationContainer.addMigrations(next2);
            }
        }
        SQLiteCopyOpenHelper sQLiteCopyOpenHelper = (SQLiteCopyOpenHelper) unwrapOpenHelper(SQLiteCopyOpenHelper.class, getOpenHelper());
        if (sQLiteCopyOpenHelper != null) {
            sQLiteCopyOpenHelper.setDatabaseConfiguration(databaseConfiguration);
        }
        AutoClosingRoomOpenHelper autoClosingRoomOpenHelper = (AutoClosingRoomOpenHelper) unwrapOpenHelper(AutoClosingRoomOpenHelper.class, getOpenHelper());
        if (autoClosingRoomOpenHelper != null) {
            this.autoCloser = autoClosingRoomOpenHelper.autoCloser;
            getInvalidationTracker().setAutoCloser$room_runtime_release(autoClosingRoomOpenHelper.autoCloser);
        }
        if (databaseConfiguration.journalMode == JournalMode.WRITE_AHEAD_LOGGING) {
            z4 = true;
        }
        getOpenHelper().setWriteAheadLoggingEnabled(z4);
        this.mCallbacks = databaseConfiguration.callbacks;
        this.internalQueryExecutor = databaseConfiguration.queryExecutor;
        this.internalTransactionExecutor = new TransactionExecutor(databaseConfiguration.transactionExecutor);
        this.allowMainThreadQueries = databaseConfiguration.allowMainThreadQueries;
        this.writeAheadLoggingEnabled = z4;
        if (databaseConfiguration.multiInstanceInvalidationServiceIntent != null) {
            if (databaseConfiguration.name != null) {
                getInvalidationTracker().startMultiInstanceInvalidation$room_runtime_release(databaseConfiguration.context, databaseConfiguration.name, databaseConfiguration.multiInstanceInvalidationServiceIntent);
            } else {
                throw new IllegalArgumentException("Required value was null.");
            }
        }
        Map<Class<?>, List<Class<?>>> requiredTypeConverters = getRequiredTypeConverters();
        BitSet bitSet2 = new BitSet();
        for (Map.Entry next3 : requiredTypeConverters.entrySet()) {
            Class cls = (Class) next3.getKey();
            Iterator it = ((List) next3.getValue()).iterator();
            while (true) {
                if (it.hasNext()) {
                    Class cls2 = (Class) it.next();
                    int size3 = databaseConfiguration.typeConverters.size() - 1;
                    if (size3 >= 0) {
                        while (true) {
                            int i6 = size3 - 1;
                            if (cls2.isAssignableFrom(databaseConfiguration.typeConverters.get(size3).getClass())) {
                                bitSet2.set(size3);
                                break;
                            } else if (i6 < 0) {
                                break;
                            } else {
                                size3 = i6;
                            }
                        }
                    }
                    size3 = -1;
                    if (size3 >= 0) {
                        this.typeConverters.put(cls2, databaseConfiguration.typeConverters.get(size3));
                    } else {
                        throw new IllegalArgumentException(("A required type converter (" + cls2 + ") for " + cls.getCanonicalName() + " is missing in the database configuration.").toString());
                    }
                }
            }
        }
        int size4 = databaseConfiguration.typeConverters.size() - 1;
        if (size4 >= 0) {
            while (true) {
                int i7 = size4 - 1;
                if (!bitSet2.get(size4)) {
                    throw new IllegalArgumentException("Unexpected type converter " + databaseConfiguration.typeConverters.get(size4) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                } else if (i7 >= 0) {
                    size4 = i7;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void internalInitInvalidationTracker(SupportSQLiteDatabase supportSQLiteDatabase) {
        m.e(supportSQLiteDatabase, "db");
        getInvalidationTracker().internalInit$room_runtime_release(supportSQLiteDatabase);
    }

    public final boolean isMainThread$room_runtime_release() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public boolean isOpen() {
        Boolean bool;
        boolean isOpen;
        AutoCloser autoCloser2 = this.autoCloser;
        if (autoCloser2 != null) {
            isOpen = autoCloser2.isActive();
        } else {
            SupportSQLiteDatabase supportSQLiteDatabase = this.mDatabase;
            if (supportSQLiteDatabase != null) {
                isOpen = supportSQLiteDatabase.isOpen();
            } else {
                bool = null;
                return m.a(bool, Boolean.TRUE);
            }
        }
        bool = Boolean.valueOf(isOpen);
        return m.a(bool, Boolean.TRUE);
    }

    public final Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        m.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        return query$default(this, supportSQLiteQuery, (CancellationSignal) null, 2, (Object) null);
    }

    public void runInTransaction(Runnable runnable) {
        m.e(runnable, TtmlNode.TAG_BODY);
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    /* access modifiers changed from: protected */
    public final void setAutoMigrationSpecs(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        m.e(map, "<set-?>");
        this.autoMigrationSpecs = map;
    }

    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }

    public Cursor query(String str, Object[] objArr) {
        m.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        return getOpenHelper().getWritableDatabase().query((SupportSQLiteQuery) new SimpleSQLiteQuery(str, objArr));
    }

    public static class MigrationContainer {
        private final Map<Integer, TreeMap<Integer, Migration>> migrations = new LinkedHashMap();

        private final void addMigration(Migration migration) {
            int i4 = migration.startVersion;
            int i5 = migration.endVersion;
            Map<Integer, TreeMap<Integer, Migration>> map = this.migrations;
            Integer valueOf = Integer.valueOf(i4);
            TreeMap<Integer, Migration> treeMap = map.get(valueOf);
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                map.put(valueOf, treeMap);
            }
            TreeMap treeMap2 = treeMap;
            if (treeMap2.containsKey(Integer.valueOf(i5))) {
                Log.w(Room.LOG_TAG, "Overriding migration " + treeMap2.get(Integer.valueOf(i5)) + " with " + migration);
            }
            treeMap2.put(Integer.valueOf(i5), migration);
        }

        private final List<Migration> findUpMigrationPath(List<Migration> list, boolean z4, int i4, int i5) {
            Set set;
            boolean z5;
            Integer num;
            do {
                if (z4) {
                    if (i4 >= i5) {
                        return list;
                    }
                } else if (i4 <= i5) {
                    return list;
                }
                TreeMap treeMap = this.migrations.get(Integer.valueOf(i4));
                if (treeMap == null) {
                    return null;
                }
                if (z4) {
                    set = treeMap.descendingKeySet();
                } else {
                    set = treeMap.keySet();
                }
                Iterator it = set.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z5 = false;
                        continue;
                        break;
                    }
                    num = (Integer) it.next();
                    if (!z4) {
                        m.d(num, "targetVersion");
                        int intValue = num.intValue();
                        if (i5 <= intValue && intValue < i4) {
                            break;
                        }
                    } else {
                        int i6 = i4 + 1;
                        m.d(num, "targetVersion");
                        int intValue2 = num.intValue();
                        if (i6 <= intValue2 && intValue2 <= i5) {
                            break;
                        }
                    }
                }
                Object obj = treeMap.get(num);
                m.b(obj);
                list.add(obj);
                i4 = num.intValue();
                z5 = true;
                continue;
            } while (z5);
            return null;
        }

        public void addMigrations(List<? extends Migration> list) {
            m.e(list, "migrations");
            for (Migration addMigration : list) {
                addMigration(addMigration);
            }
        }

        public final boolean contains(int i4, int i5) {
            Map<Integer, Map<Integer, Migration>> migrations2 = getMigrations();
            if (!migrations2.containsKey(Integer.valueOf(i4))) {
                return false;
            }
            Map map = migrations2.get(Integer.valueOf(i4));
            if (map == null) {
                map = H.g();
            }
            return map.containsKey(Integer.valueOf(i5));
        }

        public List<Migration> findMigrationPath(int i4, int i5) {
            boolean z4;
            if (i4 == i5) {
                return C1601o.h();
            }
            if (i5 > i4) {
                z4 = true;
            } else {
                z4 = false;
            }
            return findUpMigrationPath(new ArrayList(), z4, i4, i5);
        }

        public Map<Integer, Map<Integer, Migration>> getMigrations() {
            return this.migrations;
        }

        public void addMigrations(Migration... migrationArr) {
            m.e(migrationArr, "migrations");
            for (Migration addMigration : migrationArr) {
                addMigration(addMigration);
            }
        }
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        m.e(supportSQLiteQuery, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null) {
            return getOpenHelper().getWritableDatabase().query(supportSQLiteQuery, cancellationSignal);
        }
        return getOpenHelper().getWritableDatabase().query(supportSQLiteQuery);
    }

    public <V> V runInTransaction(Callable<V> callable) {
        m.e(callable, TtmlNode.TAG_BODY);
        beginTransaction();
        try {
            V call = callable.call();
            setTransactionSuccessful();
            return call;
        } finally {
            endTransaction();
        }
    }
}
