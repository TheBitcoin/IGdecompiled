package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.m;

public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List<AutoMigrationSpec> autoMigrationSpecs;
    public final List<RoomDatabase.Callback> callbacks;
    public final Context context;
    public final String copyFromAssetPath;
    public final File copyFromFile;
    public final Callable<InputStream> copyFromInputStream;
    public final RoomDatabase.JournalMode journalMode;
    public final RoomDatabase.MigrationContainer migrationContainer;
    private final Set<Integer> migrationNotRequiredFrom;
    public final boolean multiInstanceInvalidation;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final Intent multiInstanceInvalidationServiceIntent;
    public final String name;
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;
    public final List<Object> typeConverters;

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context context2, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer2, List<? extends RoomDatabase.Callback> list, boolean z4, RoomDatabase.JournalMode journalMode2, Executor executor, Executor executor2, Intent intent, boolean z5, boolean z6, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback2, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3) {
        Intent intent2 = intent;
        List<? extends Object> list4 = list2;
        List<? extends AutoMigrationSpec> list5 = list3;
        m.e(context2, "context");
        m.e(factory, "sqliteOpenHelperFactory");
        m.e(migrationContainer2, "migrationContainer");
        m.e(journalMode2, "journalMode");
        m.e(executor, "queryExecutor");
        m.e(executor2, "transactionExecutor");
        m.e(list4, "typeConverters");
        m.e(list5, "autoMigrationSpecs");
        this.context = context2;
        this.name = str;
        this.sqliteOpenHelperFactory = factory;
        this.migrationContainer = migrationContainer2;
        this.callbacks = list;
        this.allowMainThreadQueries = z4;
        this.journalMode = journalMode2;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.multiInstanceInvalidationServiceIntent = intent2;
        this.requireMigration = z5;
        this.allowDestructiveMigrationOnDowngrade = z6;
        this.migrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback2;
        this.typeConverters = list4;
        this.autoMigrationSpecs = list5;
        this.multiInstanceInvalidation = intent2 != null;
    }

    public boolean isMigrationRequired(int i4, int i5) {
        Set<Integer> set;
        if ((i4 <= i5 || !this.allowDestructiveMigrationOnDowngrade) && this.requireMigration && ((set = this.migrationNotRequiredFrom) == null || !set.contains(Integer.valueOf(i4)))) {
            return true;
        }
        return false;
    }

    public boolean isMigrationRequiredFrom(int i4) {
        return isMigrationRequired(i4, i4 + 1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r22, java.lang.String r23, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r24, androidx.room.RoomDatabase.MigrationContainer r25, java.util.List<? extends androidx.room.RoomDatabase.Callback> r26, boolean r27, androidx.room.RoomDatabase.JournalMode r28, java.util.concurrent.Executor r29, boolean r30, java.util.Set<java.lang.Integer> r31) {
        /*
            r21 = this;
            java.lang.String r0 = "context"
            r2 = r22
            kotlin.jvm.internal.m.e(r2, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r4 = r24
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "migrationContainer"
            r5 = r25
            kotlin.jvm.internal.m.e(r5, r0)
            java.lang.String r0 = "journalMode"
            r8 = r28
            kotlin.jvm.internal.m.e(r8, r0)
            java.lang.String r0 = "queryExecutor"
            r9 = r29
            kotlin.jvm.internal.m.e(r9, r0)
            java.util.List r19 = S2.C1601o.h()
            java.util.List r20 = S2.C1601o.h()
            r17 = 0
            r18 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r10 = r29
            r1 = r21
            r3 = r23
            r6 = r26
            r7 = r27
            r12 = r30
            r14 = r31
            r1.<init>((android.content.Context) r2, (java.lang.String) r3, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r4, (androidx.room.RoomDatabase.MigrationContainer) r5, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r6, (boolean) r7, (androidx.room.RoomDatabase.JournalMode) r8, (java.util.concurrent.Executor) r9, (java.util.concurrent.Executor) r10, (android.content.Intent) r11, (boolean) r12, (boolean) r13, (java.util.Set<java.lang.Integer>) r14, (java.lang.String) r15, (java.io.File) r16, (java.util.concurrent.Callable<java.io.InputStream>) r17, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r18, (java.util.List<? extends java.lang.Object>) r19, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, boolean, java.util.Set):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r21, java.lang.String r22, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, androidx.room.RoomDatabase.MigrationContainer r24, java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, androidx.room.RoomDatabase.JournalMode r27, java.util.concurrent.Executor r28, java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, java.util.Set<java.lang.Integer> r33) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.m.e(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.m.e(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.m.e(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.m.e(r9, r0)
            if (r30 == 0) goto L_0x0035
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
        L_0x0033:
            r10 = r0
            goto L_0x0037
        L_0x0035:
            r0 = 0
            goto L_0x0033
        L_0x0037:
            java.util.List r18 = S2.C1601o.h()
            java.util.List r19 = S2.C1601o.h()
            r16 = 0
            r17 = 0
            r14 = 0
            r15 = 0
            r0 = r20
            r2 = r22
            r5 = r25
            r6 = r26
            r11 = r31
            r12 = r32
            r13 = r33
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r21, java.lang.String r22, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, androidx.room.RoomDatabase.MigrationContainer r24, java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, androidx.room.RoomDatabase.JournalMode r27, java.util.concurrent.Executor r28, java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, java.util.Set<java.lang.Integer> r33, java.lang.String r34, java.io.File r35) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.m.e(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.m.e(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.m.e(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.m.e(r9, r0)
            if (r30 == 0) goto L_0x0035
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
        L_0x0033:
            r10 = r0
            goto L_0x0037
        L_0x0035:
            r0 = 0
            goto L_0x0033
        L_0x0037:
            java.util.List r18 = S2.C1601o.h()
            java.util.List r19 = S2.C1601o.h()
            r16 = 0
            r17 = 0
            r0 = r20
            r2 = r22
            r5 = r25
            r6 = r26
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r21, java.lang.String r22, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, androidx.room.RoomDatabase.MigrationContainer r24, java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, androidx.room.RoomDatabase.JournalMode r27, java.util.concurrent.Executor r28, java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, java.util.Set<java.lang.Integer> r33, java.lang.String r34, java.io.File r35, java.util.concurrent.Callable<java.io.InputStream> r36) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.m.e(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.m.e(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.m.e(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.m.e(r9, r0)
            if (r30 == 0) goto L_0x0035
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
        L_0x0033:
            r10 = r0
            goto L_0x0037
        L_0x0035:
            r0 = 0
            goto L_0x0033
        L_0x0037:
            java.util.List r18 = S2.C1601o.h()
            java.util.List r19 = S2.C1601o.h()
            r17 = 0
            r0 = r20
            r2 = r22
            r5 = r25
            r6 = r26
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r16 = r36
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r21, java.lang.String r22, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, androidx.room.RoomDatabase.MigrationContainer r24, java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, androidx.room.RoomDatabase.JournalMode r27, java.util.concurrent.Executor r28, java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, java.util.Set<java.lang.Integer> r33, java.lang.String r34, java.io.File r35, java.util.concurrent.Callable<java.io.InputStream> r36, androidx.room.RoomDatabase.PrepackagedDatabaseCallback r37) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.m.e(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.m.e(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.m.e(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.m.e(r9, r0)
            if (r30 == 0) goto L_0x0035
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
        L_0x0033:
            r10 = r0
            goto L_0x0037
        L_0x0035:
            r0 = 0
            goto L_0x0033
        L_0x0037:
            java.util.List r18 = S2.C1601o.h()
            java.util.List r19 = S2.C1601o.h()
            r0 = r20
            r2 = r22
            r5 = r25
            r6 = r26
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r16 = r36
            r17 = r37
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r21, java.lang.String r22, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, androidx.room.RoomDatabase.MigrationContainer r24, java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, androidx.room.RoomDatabase.JournalMode r27, java.util.concurrent.Executor r28, java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, java.util.Set<java.lang.Integer> r33, java.lang.String r34, java.io.File r35, java.util.concurrent.Callable<java.io.InputStream> r36, androidx.room.RoomDatabase.PrepackagedDatabaseCallback r37, java.util.List<? extends java.lang.Object> r38) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.m.e(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.m.e(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.m.e(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.m.e(r9, r0)
            java.lang.String r0 = "typeConverters"
            r2 = r38
            kotlin.jvm.internal.m.e(r2, r0)
            if (r30 == 0) goto L_0x003c
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r5 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r5)
        L_0x003a:
            r10 = r0
            goto L_0x003e
        L_0x003c:
            r0 = 0
            goto L_0x003a
        L_0x003e:
            java.util.List r19 = S2.C1601o.h()
            r0 = r20
            r5 = r25
            r6 = r26
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r2
            r2 = r22
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback, java.util.List):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @android.annotation.SuppressLint({"LambdaLast"})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r21, java.lang.String r22, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, androidx.room.RoomDatabase.MigrationContainer r24, java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, androidx.room.RoomDatabase.JournalMode r27, java.util.concurrent.Executor r28, java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, java.util.Set<java.lang.Integer> r33, java.lang.String r34, java.io.File r35, java.util.concurrent.Callable<java.io.InputStream> r36, androidx.room.RoomDatabase.PrepackagedDatabaseCallback r37, java.util.List<? extends java.lang.Object> r38, java.util.List<? extends androidx.room.migration.AutoMigrationSpec> r39) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.m.e(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.m.e(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.m.e(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.m.e(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.m.e(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.m.e(r9, r0)
            java.lang.String r0 = "typeConverters"
            r2 = r38
            kotlin.jvm.internal.m.e(r2, r0)
            java.lang.String r0 = "autoMigrationSpecs"
            r5 = r39
            kotlin.jvm.internal.m.e(r5, r0)
            if (r30 == 0) goto L_0x0043
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r6 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r6)
        L_0x0041:
            r10 = r0
            goto L_0x0045
        L_0x0043:
            r0 = 0
            goto L_0x0041
        L_0x0045:
            r17 = 0
            r0 = r20
            r6 = r26
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r16 = r36
            r18 = r2
            r19 = r5
            r2 = r22
            r5 = r25
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback, java.util.List, java.util.List):void");
    }
}
